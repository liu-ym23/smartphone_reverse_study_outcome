package kotlin.reflect.jvm.internal.impl.types;

import java.util.ArrayDeque;
import java.util.Set;
import kotlin.Unit;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.types.model.CapturedTypeMarker;
import kotlin.reflect.jvm.internal.impl.types.model.KotlinTypeMarker;
import kotlin.reflect.jvm.internal.impl.types.model.SimpleTypeMarker;
import kotlin.reflect.jvm.internal.impl.types.model.TypeSystemContext;
import kotlin.reflect.jvm.internal.impl.utils.SmartSet;
import r27.a;

/* JADX INFO: loaded from: classes42.dex */
public class TypeCheckerState {
    private final boolean allowedTypeVariable;
    private int argumentsDepth;
    private final boolean isErrorTypeEqualsToAnything;
    private final boolean isStubTypeEqualsToAnything;
    private final AbstractTypePreparator kotlinTypePreparator;
    private final AbstractTypeRefiner kotlinTypeRefiner;
    private ArrayDeque<SimpleTypeMarker> supertypesDeque;
    private boolean supertypesLocked;
    private Set<SimpleTypeMarker> supertypesSet;
    private final TypeSystemContext typeSystemContext;

    public interface ForkPointContext {

        public static final class Default implements ForkPointContext {
            private boolean result;

            public Default() {
            }

            public final boolean getResult() {
                return this.result;
            }

            @Override // kotlin.reflect.jvm.internal.impl.types.TypeCheckerState.ForkPointContext
            public void fork(Function0<Boolean> r100) {
                Intrinsics.checkNotNullParameter(r100, "block");
                if (this.result == false) goto L5;
                return;
            L5:
                this.result = r100.invoke().booleanValue();
            }
        }

        void fork(Function0<Boolean> r100);
    }

    public static final enum LowerCapturedTypePolicy extends Enum<LowerCapturedTypePolicy> {
        private static final /* synthetic */ EnumEntries $ENTRIES = null;
        private static final /* synthetic */ LowerCapturedTypePolicy[] $VALUES = null;
        public static final LowerCapturedTypePolicy CHECK_ONLY_LOWER = null;
        public static final LowerCapturedTypePolicy CHECK_SUBTYPE_AND_LOWER = null;
        public static final LowerCapturedTypePolicy SKIP_LOWER = null;

        private static final /* synthetic */ LowerCapturedTypePolicy[] $values() {
            return new LowerCapturedTypePolicy[]{CHECK_ONLY_LOWER, CHECK_SUBTYPE_AND_LOWER, SKIP_LOWER};
        }

        static {
            CHECK_ONLY_LOWER = new LowerCapturedTypePolicy("CHECK_ONLY_LOWER", 0);
            CHECK_SUBTYPE_AND_LOWER = new LowerCapturedTypePolicy("CHECK_SUBTYPE_AND_LOWER", 1);
            SKIP_LOWER = new LowerCapturedTypePolicy("SKIP_LOWER", 2);
            LowerCapturedTypePolicy[] r100 = $values();
            $VALUES = r100;
            $ENTRIES = EnumEntriesKt.enumEntries(r100);
        }

        public static LowerCapturedTypePolicy[] values() {
            return (LowerCapturedTypePolicy[]) $VALUES.clone();
        }

        public static LowerCapturedTypePolicy valueOf(String r100) {
            return (LowerCapturedTypePolicy) a.a(LowerCapturedTypePolicy.class, r100);
        }

        private LowerCapturedTypePolicy(String r100, int r101) {
            super(r100, r101);
        }
    }

    public static abstract class SupertypesPolicy {

        public static abstract class DoCustomTransform extends SupertypesPolicy {
            public DoCustomTransform() {
                super(null);
            }
        }

        public static final class LowerIfFlexible extends SupertypesPolicy {
            public static final LowerIfFlexible INSTANCE = null;

            static {
                INSTANCE = new LowerIfFlexible();
            }

            private LowerIfFlexible() {
                super(null);
            }

            @Override // kotlin.reflect.jvm.internal.impl.types.TypeCheckerState.SupertypesPolicy
            /* JADX INFO: renamed from: transformType */
            public SimpleTypeMarker mo10736transformType(TypeCheckerState r100, KotlinTypeMarker r101) {
                Intrinsics.checkNotNullParameter(r100, "state");
                Intrinsics.checkNotNullParameter(r101, "type");
                return r100.getTypeSystemContext().lowerBoundIfFlexible(r101);
            }
        }

        public static final class None extends SupertypesPolicy {
            public static final None INSTANCE = null;

            static {
                INSTANCE = new None();
            }

            private None() {
                super(null);
            }

            public Void transformType(TypeCheckerState r100, KotlinTypeMarker r101) {
                Intrinsics.checkNotNullParameter(r100, "state");
                Intrinsics.checkNotNullParameter(r101, "type");
                throw new UnsupportedOperationException("Should not be called");
            }

            @Override // kotlin.reflect.jvm.internal.impl.types.TypeCheckerState.SupertypesPolicy
            /* JADX INFO: renamed from: transformType, reason: collision with other method in class */
            public /* bridge */ /* synthetic */ SimpleTypeMarker mo10736transformType(TypeCheckerState r100, KotlinTypeMarker r101) {
                return (SimpleTypeMarker) transformType(r100, r101);
            }
        }

        public static final class UpperIfFlexible extends SupertypesPolicy {
            public static final UpperIfFlexible INSTANCE = null;

            static {
                INSTANCE = new UpperIfFlexible();
            }

            private UpperIfFlexible() {
                super(null);
            }

            @Override // kotlin.reflect.jvm.internal.impl.types.TypeCheckerState.SupertypesPolicy
            /* JADX INFO: renamed from: transformType */
            public SimpleTypeMarker mo10736transformType(TypeCheckerState r100, KotlinTypeMarker r101) {
                Intrinsics.checkNotNullParameter(r100, "state");
                Intrinsics.checkNotNullParameter(r101, "type");
                return r100.getTypeSystemContext().upperBoundIfFlexible(r101);
            }
        }

        private SupertypesPolicy() {
        }

        public /* synthetic */ SupertypesPolicy(DefaultConstructorMarker r100) {
            this();
        }

        /* JADX INFO: renamed from: transformType */
        public abstract SimpleTypeMarker mo10736transformType(TypeCheckerState r100, KotlinTypeMarker r101);
    }

    public Boolean addSubtypeConstraint(KotlinTypeMarker r100, KotlinTypeMarker r101, boolean r102) {
        Intrinsics.checkNotNullParameter(r100, "subType");
        Intrinsics.checkNotNullParameter(r101, "superType");
        return null;
    }

    public boolean customIsSubtypeOf(KotlinTypeMarker r100, KotlinTypeMarker r101) {
        Intrinsics.checkNotNullParameter(r100, "subType");
        Intrinsics.checkNotNullParameter(r101, "superType");
        return true;
    }

    public final void initialize() {
        this.supertypesLocked = true;
        if (this.supertypesDeque != null) goto L6;
        this.supertypesDeque = new ArrayDeque(4);
    L6:
        if (this.supertypesSet != null) goto L9;
        this.supertypesSet = SmartSet.Companion.create();
        return;
    }

    public final void clear() {
        ArrayDeque<SimpleTypeMarker> r100 = this.supertypesDeque;
        Intrinsics.checkNotNull(r100);
        r100.clear();
        Set<SimpleTypeMarker> r101 = this.supertypesSet;
        Intrinsics.checkNotNull(r101);
        r101.clear();
        this.supertypesLocked = false;
    }

    public final ArrayDeque<SimpleTypeMarker> getSupertypesDeque() {
        return this.supertypesDeque;
    }

    public final Set<SimpleTypeMarker> getSupertypesSet() {
        return this.supertypesSet;
    }

    public final TypeSystemContext getTypeSystemContext() {
        return this.typeSystemContext;
    }

    public final boolean isErrorTypeEqualsToAnything() {
        return this.isErrorTypeEqualsToAnything;
    }

    public final boolean isStubTypeEqualsToAnything() {
        return this.isStubTypeEqualsToAnything;
    }

    public static final /* synthetic */ int access$getArgumentsDepth(TypeCheckerState r100) {
        return r100.argumentsDepth;
    }

    public final boolean isAllowedTypeVariable(KotlinTypeMarker r100) {
        Intrinsics.checkNotNullParameter(r100, "type");
        if (this.allowedTypeVariable == true) goto L5;
    L7:
        return false;
    L5:
        if (this.typeSystemContext.isTypeVariableType(r100) == false) goto L7;
        return true;
    }

    public final KotlinTypeMarker prepareType(KotlinTypeMarker r100) {
        Intrinsics.checkNotNullParameter(r100, "type");
        return this.kotlinTypePreparator.prepareType(r100);
    }

    public final KotlinTypeMarker refineType(KotlinTypeMarker r100) {
        Intrinsics.checkNotNullParameter(r100, "type");
        return this.kotlinTypeRefiner.refineType(r100);
    }

    public boolean runForkingPoint(Function1<? super ForkPointContext, Unit> r100) {
        Intrinsics.checkNotNullParameter(r100, "block");
        ForkPointContext.Default r101 = new ForkPointContext.Default();
        r100.invoke(r101);
        return r101.getResult();
    }

    public static final /* synthetic */ void access$setArgumentsDepth(TypeCheckerState r100, int r101) {
        r100.argumentsDepth = r101;
    }

    public LowerCapturedTypePolicy getLowerCapturedTypePolicy(SimpleTypeMarker r100, CapturedTypeMarker r101) {
        Intrinsics.checkNotNullParameter(r100, "subType");
        Intrinsics.checkNotNullParameter(r101, "superType");
        return LowerCapturedTypePolicy.CHECK_SUBTYPE_AND_LOWER;
    }

    public TypeCheckerState(boolean r100, boolean r101, boolean r102, TypeSystemContext r103, AbstractTypePreparator r104, AbstractTypeRefiner r105) {
        Intrinsics.checkNotNullParameter(r103, "typeSystemContext");
        Intrinsics.checkNotNullParameter(r104, "kotlinTypePreparator");
        Intrinsics.checkNotNullParameter(r105, "kotlinTypeRefiner");
        this.isErrorTypeEqualsToAnything = r100;
        this.isStubTypeEqualsToAnything = r101;
        this.allowedTypeVariable = r102;
        this.typeSystemContext = r103;
        this.kotlinTypePreparator = r104;
        this.kotlinTypeRefiner = r105;
    }

    public static /* synthetic */ Boolean addSubtypeConstraint$default(TypeCheckerState r100, KotlinTypeMarker r101, KotlinTypeMarker r102, boolean r103, int r104, Object r105) {
        if (r105 != null) goto L9;
        if ((r104 & 4) == 0) goto L7;
        r103 = false;
    L7:
        return r100.addSubtypeConstraint(r101, r102, r103);
    L9:
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: addSubtypeConstraint");
    }
}
