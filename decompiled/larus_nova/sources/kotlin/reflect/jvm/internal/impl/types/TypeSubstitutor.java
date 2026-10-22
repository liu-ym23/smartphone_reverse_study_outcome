package kotlin.reflect.jvm.internal.impl.types;

import com.bytedance.android.live.soloktv.SoloKtvContext;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.ArrayList;
import java.util.List;
import kotlin.reflect.jvm.internal.impl.builtins.KotlinBuiltIns;
import kotlin.reflect.jvm.internal.impl.builtins.StandardNames;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.CompositeAnnotations;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.FilteredAnnotations;
import kotlin.reflect.jvm.internal.impl.resolve.calls.inference.CapturedTypeConstructorKt;
import kotlin.reflect.jvm.internal.impl.types.checker.NewCapturedTypeConstructor;
import kotlin.reflect.jvm.internal.impl.types.error.ErrorType;
import kotlin.reflect.jvm.internal.impl.types.error.ErrorTypeKind;
import kotlin.reflect.jvm.internal.impl.types.error.ErrorUtils;
import kotlin.reflect.jvm.internal.impl.types.typeUtil.TypeUtilsKt;
import kotlin.reflect.jvm.internal.impl.types.typesApproximation.CapturedTypeApproximationKt;
import kotlin.reflect.jvm.internal.impl.utils.ExceptionUtilsKt;
import r27.a;

/* JADX INFO: loaded from: classes5.dex */
public class TypeSubstitutor {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    public static final TypeSubstitutor EMPTY = null;
    private final TypeSubstitution substitution;

    /* JADX INFO: renamed from: kotlin.reflect.jvm.internal.impl.types.TypeSubstitutor$2, reason: invalid class name */
    /* JADX INFO: loaded from: classes42.dex */
    public static /* synthetic */ class AnonymousClass2 {
        static final /* synthetic */ int[] $SwitchMap$org$jetbrains$kotlin$types$TypeSubstitutor$VarianceConflictType = null;

        static {
            int[] r100 = new int[VarianceConflictType.values().length];
            $SwitchMap$org$jetbrains$kotlin$types$TypeSubstitutor$VarianceConflictType = r100;
            r100[VarianceConflictType.OUT_IN_IN_POSITION.ordinal()] = 1;     // Catch: NoSuchFieldError -> L7
        L10:
            $SwitchMap$org$jetbrains$kotlin$types$TypeSubstitutor$VarianceConflictType[VarianceConflictType.IN_IN_OUT_POSITION.ordinal()] = 2;     // Catch: NoSuchFieldError -> L8
        L12:
            $SwitchMap$org$jetbrains$kotlin$types$TypeSubstitutor$VarianceConflictType[VarianceConflictType.NO_CONFLICT.ordinal()] = 3;     // Catch: NoSuchFieldError -> L9
            return;
        }
    }

    /* JADX INFO: loaded from: classes42.dex */
    public static final class SubstitutionException extends Exception {
        public SubstitutionException(String r100) {
            super(r100);
        }
    }

    /* JADX INFO: loaded from: classes42.dex */
    public static final enum VarianceConflictType extends Enum<VarianceConflictType> {
        private static final /* synthetic */ VarianceConflictType[] $VALUES = null;
        public static final VarianceConflictType IN_IN_OUT_POSITION = null;
        public static final VarianceConflictType NO_CONFLICT = null;
        public static final VarianceConflictType OUT_IN_IN_POSITION = null;

        static {
            VarianceConflictType r100 = new VarianceConflictType("NO_CONFLICT", 0);
            NO_CONFLICT = r100;
            VarianceConflictType r101 = new VarianceConflictType("IN_IN_OUT_POSITION", 1);
            IN_IN_OUT_POSITION = r101;
            VarianceConflictType r102 = new VarianceConflictType("OUT_IN_IN_POSITION", 2);
            OUT_IN_IN_POSITION = r102;
            $VALUES = new VarianceConflictType[]{r100, r101, r102};
        }

        public static VarianceConflictType[] values() {
            return (VarianceConflictType[]) $VALUES.clone();
        }

        public static VarianceConflictType valueOf(String r100) {
            return (VarianceConflictType) a.a(VarianceConflictType.class, r100);
        }

        private VarianceConflictType(String r100, int r101) {
            super(r100, r101);
        }
    }

    private static /* synthetic */ void $$$reportNull$$$0(int r110) {
        if (r110 == 1) goto L13;
        if (r110 == 2) goto L13;
        if (r110 == 8) goto L13;
        if (r110 == 34) goto L13;
        if (r110 == 37) goto L13;
        switch(r110) {
            case 11: goto L13;
            case 12: goto L13;
            case 13: goto L13;
            default: goto L9;
        };
    L9:
        switch(r110) {
            case 19: goto L13;
            case 20: goto L13;
            case 21: goto L13;
            case 22: goto L13;
            case 23: goto L13;
            case 24: goto L13;
            case 25: goto L13;
            default: goto L10;
        };
    L10:
        switch(r110) {
            case 29: goto L13;
            case 30: goto L13;
            case 31: goto L13;
            case 32: goto L13;
            default: goto L11;
        };
    L11:
        switch(r110) {
            case 40: goto L13;
            case 41: goto L13;
            case 42: goto L13;
            default: goto L12;
        };
    L12:
        String r100 = "Argument for @NotNull parameter '%s' of %s.%s must not be null";
    L14:
        if (r110 == 1) goto L24;
        if (r110 == 2) goto L24;
        if (r110 == 8) goto L24;
        if (r110 == 34) goto L24;
        if (r110 == 37) goto L24;
        switch(r110) {
            case 11: goto L24;
            case 12: goto L24;
            case 13: goto L24;
            default: goto L20;
        };
    L20:
        switch(r110) {
            case 19: goto L24;
            case 20: goto L24;
            case 21: goto L24;
            case 22: goto L24;
            case 23: goto L24;
            case 24: goto L24;
            case 25: goto L24;
            default: goto L21;
        };
    L21:
        switch(r110) {
            case 29: goto L24;
            case 30: goto L24;
            case 31: goto L24;
            case 32: goto L24;
            default: goto L22;
        };
    L22:
        switch(r110) {
            case 40: goto L24;
            case 41: goto L24;
            case 42: goto L24;
            default: goto L23;
        };
    L23:
        int r101 = 3;
    L25:
        Object[] r102 = new Object[r101];
        switch(r110) {
            case 1: goto L41;
            case 2: goto L41;
            case 3: goto L40;
            case 4: goto L39;
            case 5: goto L38;
            case 6: goto L37;
            case 7: goto L27;
            case 8: goto L41;
            case 9: goto L36;
            case 10: goto L35;
            case 11: goto L41;
            case 12: goto L41;
            case 13: goto L41;
            case 14: goto L36;
            case 15: goto L35;
            case 16: goto L34;
            case 17: goto L34;
            case 18: goto L33;
            case 19: goto L41;
            case 20: goto L41;
            case 21: goto L41;
            case 22: goto L41;
            case 23: goto L41;
            case 24: goto L41;
            case 25: goto L41;
            case 26: goto L32;
            case 27: goto L31;
            case 28: goto L33;
            case 29: goto L41;
            case 30: goto L41;
            case 31: goto L41;
            case 32: goto L41;
            case 33: goto L30;
            case 34: goto L41;
            case 35: goto L29;
            case 36: goto L34;
            case 37: goto L41;
            case 38: goto L29;
            case 39: goto L28;
            case 40: goto L41;
            case 41: goto L41;
            case 42: goto L41;
            default: goto L27;
        };
    L27:
        r102[0] = "substitution";
    L43:
        if (r110 == 1) goto L60;
        if (r110 == 2) goto L59;
        if (r110 == 8) goto L58;
        if (r110 == 34) goto L57;
        if (r110 == 37) goto L56;
        switch(r110) {
            case 11: goto L55;
            case 12: goto L55;
            case 13: goto L55;
            default: goto L49;
        };
    L49:
        switch(r110) {
            case 19: goto L54;
            case 20: goto L54;
            case 21: goto L54;
            case 22: goto L54;
            case 23: goto L54;
            case 24: goto L54;
            case 25: goto L54;
            default: goto L50;
        };
    L50:
        switch(r110) {
            case 29: goto L53;
            case 30: goto L53;
            case 31: goto L53;
            case 32: goto L53;
            default: goto L51;
        };
    L51:
        switch(r110) {
            case 40: goto L56;
            case 41: goto L56;
            case 42: goto L56;
            default: goto L52;
        };
    L52:
        r102[1] = "kotlin/reflect/jvm/internal/impl/types/TypeSubstitutor";
    L61:
        switch(r110) {
            case 1: goto L72;
            case 2: goto L72;
            case 3: goto L71;
            case 4: goto L71;
            case 5: goto L62;
            case 6: goto L62;
            case 7: goto L70;
            case 8: goto L72;
            case 9: goto L69;
            case 10: goto L69;
            case 11: goto L72;
            case 12: goto L72;
            case 13: goto L72;
            case 14: goto L68;
            case 15: goto L68;
            case 16: goto L68;
            case 17: goto L67;
            case 18: goto L66;
            case 19: goto L72;
            case 20: goto L72;
            case 21: goto L72;
            case 22: goto L72;
            case 23: goto L72;
            case 24: goto L72;
            case 25: goto L72;
            case 26: goto L65;
            case 27: goto L65;
            case 28: goto L65;
            case 29: goto L72;
            case 30: goto L72;
            case 31: goto L72;
            case 32: goto L72;
            case 33: goto L64;
            case 34: goto L72;
            case 35: goto L63;
            case 36: goto L63;
            case 37: goto L72;
            case 38: goto L63;
            case 39: goto L63;
            case 40: goto L72;
            case 41: goto L72;
            case 42: goto L72;
            default: goto L62;
        };
    L62:
        r102[2] = "create";
        goto L72
    L63:
        r102[2] = "combine";
        goto L72
    L64:
        r102[2] = "filterOutUnsafeVariance";
        goto L72
    L65:
        r102[2] = "projectedTypeForConflictedTypeWithUnsafeVariance";
        goto L72
    L66:
        r102[2] = "unsafeSubstitute";
        goto L72
    L67:
        r102[2] = "substituteWithoutApproximation";
        goto L72
    L68:
        r102[2] = "substitute";
        goto L72
    L69:
        r102[2] = "safeSubstitute";
        goto L72
    L70:
        r102[2] = "<init>";
        goto L72
    L71:
        r102[2] = "createChainedSubstitutor";
    L72:
        String r103 = String.format(r100, r102);
        if (r110 == 1) goto L84;
        if (r110 == 2) goto L84;
        if (r110 == 8) goto L84;
        if (r110 == 34) goto L84;
        if (r110 == 37) goto L84;
        switch(r110) {
            case 11: goto L84;
            case 12: goto L84;
            case 13: goto L84;
            default: goto L79;
        };
    L79:
        switch(r110) {
            case 19: goto L84;
            case 20: goto L84;
            case 21: goto L84;
            case 22: goto L84;
            case 23: goto L84;
            case 24: goto L84;
            case 25: goto L84;
            default: goto L80;
        };
    L80:
        switch(r110) {
            case 29: goto L84;
            case 30: goto L84;
            case 31: goto L84;
            case 32: goto L84;
            default: goto L81;
        };
    L81:
        switch(r110) {
            case 40: goto L84;
            case 41: goto L84;
            case 42: goto L84;
            default: goto L85;
        };
    L85:
        throw new IllegalArgumentException(r103);
    L84:
        throw new IllegalStateException(r103);
    L53:
        r102[1] = "projectedTypeForConflictedTypeWithUnsafeVariance";
        goto L61
    L54:
        r102[1] = "unsafeSubstitute";
        goto L61
    L55:
        r102[1] = "safeSubstitute";
    L56:
        r102[1] = "combine";
        goto L61
    L57:
        r102[1] = "filterOutUnsafeVariance";
        goto L61
    L58:
        r102[1] = "getSubstitution";
        goto L61
    L59:
        r102[1] = "replaceWithContravariantApproximatingSubstitution";
        goto L61
    L60:
        r102[1] = "replaceWithNonApproximatingSubstitution";
        goto L61
    L28:
        r102[0] = "projectionKind";
        goto L43
    L29:
        r102[0] = "typeParameterVariance";
        goto L43
    L30:
        r102[0] = "annotations";
        goto L43
    L31:
        r102[0] = "substituted";
        goto L43
    L32:
        r102[0] = "originalType";
        goto L43
    L33:
        r102[0] = "originalProjection";
        goto L43
    L34:
        r102[0] = "typeProjection";
        goto L43
    L35:
        r102[0] = "howThisTypeIsUsed";
        goto L43
    L36:
        r102[0] = "type";
        goto L43
    L37:
        r102[0] = PerfLog.PARAM_KEY_CONTEXT_ID;
        goto L43
    L38:
        r102[0] = "substitutionContext";
        goto L43
    L39:
        r102[0] = "second";
        goto L43
    L40:
        r102[0] = SoloKtvContext.SOLO_PAGE_FIRST;
        goto L43
    L41:
        r102[0] = "kotlin/reflect/jvm/internal/impl/types/TypeSubstitutor";
    L24:
        r101 = 2;
    L13:
        r100 = "@NotNull method %s.%s must not return null";
        goto L14
    }

    static {
        EMPTY = create(TypeSubstitution.EMPTY);
    }

    public TypeSubstitution getSubstitution() {
        TypeSubstitution r100 = this.substitution;
        if (r100 != null) goto L5;
        $$$reportNull$$$0(8);
    L5:
        return r100;
    }

    public boolean isEmpty() {
        return this.substitution.isEmpty();
    }

    public TypeSubstitutor replaceWithNonApproximatingSubstitution() {
        TypeSubstitution r100 = this.substitution;
        if ((r100 instanceof IndexedParametersSubstitution) == true) goto L5;
    L9:
        return this;
    L5:
        if (r100.approximateContravariantCapturedTypes() == false) goto L9;
        return new TypeSubstitutor(new IndexedParametersSubstitution(((IndexedParametersSubstitution) this.substitution).getParameters(), ((IndexedParametersSubstitution) this.substitution).getArguments(), false));
    }

    public TypeSubstitutor(TypeSubstitution r100) {
        if (r100 != null) goto L4;
        $$$reportNull$$$0(7);
    L4:
        this.substitution = r100;
    }

    public static TypeSubstitutor create(KotlinType r100) {
        if (r100 != null) goto L5;
        $$$reportNull$$$0(6);
    L5:
        return create(TypeConstructorSubstitution.create(r100.getConstructor(), r100.getArguments()));
    }

    private static Annotations filterOutUnsafeVariance(Annotations r100) {
        if (r100 != null) goto L5;
        $$$reportNull$$$0(33);
    L5:
        if (r100.hasAnnotation(StandardNames.FqNames.unsafeVariance) == true) goto L8;
        return r100;
    L8:
        return new FilteredAnnotations(r100, new AnonymousClass1());
    }

    private static String safeToString(Object r100) {
        return r100.toString();
    L4:
        th = move-exception;
        if (ExceptionUtilsKt.isProcessCanceledException(th) == true) goto L10;
        return "[Exception while computing toString(): " + th + "]";
    L10:
        throw th;
    }

    public TypeProjection substitute(TypeProjection r100) {
        if (r100 != null) goto L4;
        $$$reportNull$$$0(16);
    L4:
        TypeProjection r101 = substituteWithoutApproximation(r100);
        if (this.substitution.approximateCapturedTypes() == true) goto L10;
        if (this.substitution.approximateContravariantCapturedTypes() == true) goto L10;
        return r101;
    L10:
        return CapturedTypeApproximationKt.approximateCapturedTypesIfNecessary(r101, this.substitution.approximateContravariantCapturedTypes());
    }

    public TypeProjection substituteWithoutApproximation(TypeProjection r100) {
        if (r100 != null) goto L5;
        $$$reportNull$$$0(17);
    L5:
        if (isEmpty() == false) goto L11;
        return r100;
    L11:
        return unsafeSubstitute(r100, null, 0);
    L10:
        return null;
    }

    public static TypeSubstitutor create(TypeSubstitution r100) {
        if (r100 != null) goto L5;
        $$$reportNull$$$0(0);
    L5:
        return new TypeSubstitutor(r100);
    }

    public static Variance combine(Variance r100, Variance r101) {
        if (r100 != null) goto L4;
        $$$reportNull$$$0(38);
    L4:
        if (r101 != null) goto L6;
        $$$reportNull$$$0(39);
    L6:
        Variance r102 = Variance.INVARIANT;
        if (r100 != r102) goto L11;
        if (r101 != null) goto L10;
        $$$reportNull$$$0(40);
    L10:
        return r101;
    L11:
        if (r101 != r102) goto L15;
        if (r100 != null) goto L14;
        $$$reportNull$$$0(41);
    L14:
        return r100;
    L15:
        if (r100 != r101) goto L20;
        if (r101 != null) goto L18;
        $$$reportNull$$$0(42);
    L18:
        return r101;
    L20:
        throw new AssertionError("Variance conflict: type parameter variance '" + r100 + "' and projection kind '" + r101 + "' cannot be combined");
    }

    private static VarianceConflictType conflictType(Variance r100, Variance r101) {
        Variance r102 = Variance.IN_VARIANCE;
        if (r100 != r102) goto L9;
        if (r101 != Variance.OUT_VARIANCE) goto L9;
        return VarianceConflictType.OUT_IN_IN_POSITION;
    L9:
        if (r100 != Variance.OUT_VARIANCE) goto L14;
        if (r101 != r102) goto L14;
        return VarianceConflictType.IN_IN_OUT_POSITION;
    L14:
        return VarianceConflictType.NO_CONFLICT;
    }

    public static TypeSubstitutor createChainedSubstitutor(TypeSubstitution r100, TypeSubstitution r101) {
        if (r100 != null) goto L4;
        $$$reportNull$$$0(3);
    L4:
        if (r101 != null) goto L7;
        $$$reportNull$$$0(4);
    L7:
        return create(DisjointKeysUnionTypeSubstitution.create(r100, r101));
    }

    private TypeProjection substituteCompoundType(TypeProjection r100, int r101) throws SubstitutionException {
        KotlinType r102 = r100.getType();
        Variance r103 = r100.getProjectionKind();
        if ((r102.getConstructor().mo10732getDeclarationDescriptor() instanceof TypeParameterDescriptor) == false) goto L5;
        return r100;
    L5:
        SimpleType r104 = SpecialTypesKt.getAbbreviation(r102);
        if (r104 == null) goto L8;
        KotlinType r105 = replaceWithNonApproximatingSubstitution().substitute(r104, Variance.INVARIANT);
    L9:
        KotlinType r106 = TypeSubstitutionKt.replace(r102, substituteTypeArguments(r102.getConstructor().getParameters(), r102.getArguments(), r101), this.substitution.filterAnnotations(r102.getAnnotations()));
        if ((r106 instanceof SimpleType) == false) goto L15;
        if ((r105 instanceof SimpleType) == false) goto L15;
        r106 = SpecialTypesKt.withAbbreviation((SimpleType) r106, (SimpleType) r105);
    L15:
        return new TypeProjectionImpl(r103, r106);
    L8:
        r105 = null;
        goto L9
    }

    public KotlinType safeSubstitute(KotlinType r100, Variance r101) {
        if (r100 != null) goto L4;
        $$$reportNull$$$0(9);
    L4:
        if (r101 != null) goto L7;
        $$$reportNull$$$0(10);
    L7:
        if (isEmpty() == false) goto L21;
        if (r100 != null) goto L10;
        $$$reportNull$$$0(11);
    L10:
        return r100;
    L21:
        KotlinType r102 = unsafeSubstitute(new TypeProjectionImpl(r101, r100), null, 0).getType();     // Catch: SubstitutionException -> L16
        if (r102 != null) goto L15;
        $$$reportNull$$$0(12);
    L15:
        return r102;
    L16:
        e = move-exception;
        ErrorType r103 = ErrorUtils.createErrorType(ErrorTypeKind.UNABLE_TO_SUBSTITUTE_TYPE, new String[]{e.getMessage()});
        if (r103 != null) goto L20;
        $$$reportNull$$$0(13);
    L20:
        return r103;
    }

    public KotlinType substitute(KotlinType r100, Variance r101) {
        if (r100 != null) goto L4;
        $$$reportNull$$$0(14);
    L4:
        if (r101 != null) goto L6;
        $$$reportNull$$$0(15);
    L6:
        TypeProjection r102 = substitute(new TypeProjectionImpl(r101, getSubstitution().prepareTopLevelType(r100, r101)));
        if (r102 != null) goto L10;
        return null;
    L10:
        return r102.getType();
    }

    public static Variance combine(Variance r100, TypeProjection r101) {
        if (r100 != null) goto L4;
        $$$reportNull$$$0(35);
    L4:
        if (r101 != null) goto L7;
        $$$reportNull$$$0(36);
    L7:
        if (r101.isStarProjection() == false) goto L13;
        Variance r102 = Variance.OUT_VARIANCE;
        if (r102 != null) goto L11;
        $$$reportNull$$$0(37);
    L11:
        return r102;
    L13:
        return combine(r100, r101.getProjectionKind());
    }

    private static void assertRecursionDepth(int r100, TypeProjection r101, TypeSubstitution r102) {
        if (r100 > 100) goto L6;
        return;
    L6:
        throw new IllegalStateException("Recursion too deep. Most likely infinite loop while substituting " + safeToString(r101) + "; substitution: " + safeToString(r102));
    }

    private List<TypeProjection> substituteTypeArguments(List<TypeParameterDescriptor> r110, List<TypeProjection> r111, int r112) throws SubstitutionException {
        ArrayList r100 = new ArrayList(r110.size());
        int r101 = 0;
        boolean r102 = false;
    L4:
        if (r101 >= r110.size()) goto L21;
        TypeParameterDescriptor r103 = (TypeParameterDescriptor) ListProtector.get(r110, r101);
        TypeProjection r104 = (TypeProjection) ListProtector.get(r111, r101);
        TypeProjection r105 = unsafeSubstitute(r104, r103, r112 + 1);
        int r106 = AnonymousClass2.$SwitchMap$org$jetbrains$kotlin$types$TypeSubstitutor$VarianceConflictType[conflictType(r103.getVariance(), r105.getProjectionKind()).ordinal()];
        if (r106 != 1) goto L8;
    L17:
        r105 = TypeUtils.makeStarProjection(r103);
    L18:
        if (r105 == r104) goto L20;
        r102 = true;
    L20:
        r100.add(r105);
        r101 = r101 + 1;
        goto L4
    L8:
        if (r106 == 2) goto L17;
        if (r106 != 3) goto L18;
        Variance r107 = r103.getVariance();
        Variance r108 = Variance.INVARIANT;
        if (r107 == r108) goto L18;
        if (r105.isStarProjection() == true) goto L18;
        r105 = new TypeProjectionImpl(r108, r105.getType());
        goto L18
    L21:
        if (r102 == true) goto L23;
        return r111;
    L23:
        return r100;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    private TypeProjection unsafeSubstitute(TypeProjection r100, TypeParameterDescriptor r101, int r110) throws SubstitutionException {
        if (r100 != null) goto L4;
        $$$reportNull$$$0(18);
    L4:
        assertRecursionDepth(r110, r100, this.substitution);
        if (r100.isStarProjection() == false) goto L7;
        return r100;
    L7:
        KotlinType r102 = r100.getType();
        if ((r102 instanceof TypeWithEnhancement) == false) goto L15;
        TypeWithEnhancement r103 = (TypeWithEnhancement) r102;
        UnwrappedType r104 = r103.getOrigin();
        KotlinType r105 = r103.getEnhancement();
        TypeProjection r106 = unsafeSubstitute(new TypeProjectionImpl(r100.getProjectionKind(), r104), r101, r110 + 1);
        if (r106.isStarProjection() == false) goto L13;
        return r106;
    L13:
        return new TypeProjectionImpl(r106.getProjectionKind(), TypeWithEnhancementKt.wrapEnhancement(r106.getType().unwrap(), substitute(r105, r100.getProjectionKind())));
    L15:
        if (DynamicTypesKt.isDynamic(r102) == false) goto L17;
    L69:
        return r100;
    L17:
        if ((r102.unwrap() instanceof RawType) == true) goto L69;
        TypeProjection r107 = this.substitution.mo10737get(r102);
        if (r107 == null) goto L22;
        TypeProjection r108 = projectedTypeForConflictedTypeWithUnsafeVariance(r102, r107, r101, r100);
    L23:
        Variance r109 = r100.getProjectionKind();
        if (r108 != null) goto L37;
        if (FlexibleTypesKt.isFlexible(r102) == false) goto L37;
        if (TypeCapabilitiesKt.isCustomTypeParameter(r102) == true) goto L37;
        FlexibleType r111 = FlexibleTypesKt.asFlexibleType(r102);
        int r112 = r110 + 1;
        TypeProjection r113 = unsafeSubstitute(new TypeProjectionImpl(r109, r111.getLowerBound()), r101, r112);
        TypeProjection r114 = unsafeSubstitute(new TypeProjectionImpl(r109, r111.getUpperBound()), r101, r112);
        Variance r115 = r113.getProjectionKind();
        if (r113.getType() != r111.getLowerBound()) goto L35;
        if (r114.getType() != r111.getUpperBound()) goto L35;
        return r100;
    L35:
        return new TypeProjectionImpl(r115, KotlinTypeFactory.flexibleType(TypeSubstitutionKt.asSimpleType(r113.getType()), TypeSubstitutionKt.asSimpleType(r114.getType())));
    L37:
        if (KotlinBuiltIns.isNothing(r102) == true) goto L69;
        if (KotlinTypeKt.isError(r102) == true) goto L69;
        if (r108 == null) goto L66;
        VarianceConflictType r116 = conflictType(r109, r108.getProjectionKind());
        if (CapturedTypeConstructorKt.isCaptured(r102) == true) goto L52;
        int r117 = AnonymousClass2.$SwitchMap$org$jetbrains$kotlin$types$TypeSubstitutor$VarianceConflictType[r116.ordinal()];
        if (r117 == 1) goto L51;
        if (r117 != 2) goto L52;
        return new TypeProjectionImpl(Variance.OUT_VARIANCE, r102.getConstructor().getBuiltIns().getNullableAnyType());
    L51:
        throw new SubstitutionException("Out-projection in in-position");
    L52:
        CustomTypeParameter r118 = TypeCapabilitiesKt.getCustomTypeParameter(r102);
        if (r108.isStarProjection() == false) goto L55;
        return r108;
    L55:
        if (r118 == null) goto L57;
        KotlinType r119 = r118.substitutionResult(r108.getType());
    L59:
        if (r102.getAnnotations().isEmpty() == true) goto L62;
        r119 = TypeUtilsKt.replaceAnnotations(r119, new CompositeAnnotations(new Annotations[]{r119.getAnnotations(), filterOutUnsafeVariance(this.substitution.filterAnnotations(r102.getAnnotations()))}));
    L62:
        if (r116 != VarianceConflictType.NO_CONFLICT) goto L65;
        r109 = combine(r109, r108.getProjectionKind());
    L65:
        return new TypeProjectionImpl(r109, r119);
    L57:
        r119 = TypeUtils.makeNullableIfNeeded(r108.getType(), r102.isMarkedNullable());
        goto L59
    L66:
        r100 = substituteCompoundType(r100, r110);
        if (r100 != null) goto L69;
        $$$reportNull$$$0(25);
        goto L69
    L22:
        r108 = null;
        goto L23
    }

    private static TypeProjection projectedTypeForConflictedTypeWithUnsafeVariance(KotlinType r100, TypeProjection r101, TypeParameterDescriptor r102, TypeProjection r103) {
        if (r100 != null) goto L4;
        $$$reportNull$$$0(26);
    L4:
        if (r101 != null) goto L6;
        $$$reportNull$$$0(27);
    L6:
        if (r103 != null) goto L9;
        $$$reportNull$$$0(28);
    L9:
        if (r100.getAnnotations().hasAnnotation(StandardNames.FqNames.unsafeVariance) == true) goto L13;
        if (r101 != null) goto L12;
        $$$reportNull$$$0(29);
    L12:
        return r101;
    L13:
        TypeConstructor r104 = r101.getType().getConstructor();
        if ((r104 instanceof NewCapturedTypeConstructor) == true) goto L16;
        return r101;
    L16:
        TypeProjection r105 = ((NewCapturedTypeConstructor) r104).getProjection();
        Variance r106 = r105.getProjectionKind();
        VarianceConflictType r107 = conflictType(r103.getProjectionKind(), r106);
        VarianceConflictType r108 = VarianceConflictType.OUT_IN_IN_POSITION;
        if (r107 == r108) goto L19;
        if (r102 != null) goto L23;
        return r101;
    L23:
        if (conflictType(r102.getVariance(), r106) == r108) goto L25;
        return r101;
    L25:
        return new TypeProjectionImpl(r105.getType());
    L19:
        return new TypeProjectionImpl(r105.getType());
    }
}
