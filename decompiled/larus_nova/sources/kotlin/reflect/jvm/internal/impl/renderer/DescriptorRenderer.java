package kotlin.reflect.jvm.internal.impl.renderer;

import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.collections.SetsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.builtins.KotlinBuiltIns;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassKind;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptorWithTypeParameters;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeAliasDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ValueParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.AnnotationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.AnnotationUseSiteTarget;
import kotlin.reflect.jvm.internal.impl.name.FqNameUnsafe;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import kotlin.reflect.jvm.internal.impl.types.TypeProjection;

/* JADX INFO: loaded from: classes5.dex */
public abstract class DescriptorRenderer {
    public static final DescriptorRenderer COMPACT = null;
    public static final DescriptorRenderer COMPACT_WITHOUT_SUPERTYPES = null;
    public static final DescriptorRenderer COMPACT_WITH_MODIFIERS = null;
    public static final DescriptorRenderer COMPACT_WITH_SHORT_TYPES = null;
    public static final Companion Companion = null;
    public static final DescriptorRenderer DEBUG_TEXT = null;
    public static final DescriptorRenderer FQ_NAMES_IN_TYPES = null;
    public static final DescriptorRenderer FQ_NAMES_IN_TYPES_WITH_ANNOTATIONS = null;
    public static final DescriptorRenderer HTML = null;
    public static final DescriptorRenderer ONLY_NAMES_WITH_SHORT_TYPES = null;
    public static final DescriptorRenderer SHORT_NAMES_IN_TYPES = null;
    public static final DescriptorRenderer WITHOUT_MODIFIERS = null;

    public static final class Companion {

        /* JADX INFO: loaded from: classes42.dex */
        public /* synthetic */ class WhenMappings {
            public static final /* synthetic */ int[] $EnumSwitchMapping$0 = null;

            static {
                int[] r100 = new int[ClassKind.values().length];
                r100[ClassKind.CLASS.ordinal()] = 1;     // Catch: NoSuchFieldError -> L11
            L19:
                r100[ClassKind.INTERFACE.ordinal()] = 2;     // Catch: NoSuchFieldError -> L12
            L27:
                r100[ClassKind.ENUM_CLASS.ordinal()] = 3;     // Catch: NoSuchFieldError -> L13
            L21:
                r100[ClassKind.OBJECT.ordinal()] = 4;     // Catch: NoSuchFieldError -> L14
            L23:
                r100[ClassKind.ANNOTATION_CLASS.ordinal()] = 5;     // Catch: NoSuchFieldError -> L15
            L17:
                r100[ClassKind.ENUM_ENTRY.ordinal()] = 6;     // Catch: NoSuchFieldError -> L16
            L9:
                $EnumSwitchMapping$0 = r100;
            }
        }

        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r100) {
            this();
        }

        public final String getClassifierKindPrefix(ClassifierDescriptorWithTypeParameters r100) {
            Intrinsics.checkNotNullParameter(r100, "classifier");
            if ((r100 instanceof TypeAliasDescriptor) == false) goto L6;
            return "typealias";
        L6:
            if ((r100 instanceof ClassDescriptor) == false) goto L22;
            ClassDescriptor r101 = (ClassDescriptor) r100;
            if (r101.isCompanionObject() == false) goto L11;
            return "companion object";
        L11:
            switch(WhenMappings.$EnumSwitchMapping$0[r101.getKind().ordinal()]) {
                case 1: goto L19;
                case 2: goto L18;
                case 3: goto L17;
                case 4: goto L16;
                case 5: goto L15;
                case 6: goto L14;
                default: goto L13;
            };
        L14:
            return "enum entry";
        L15:
            return "annotation class";
        L16:
            return "object";
        L17:
            return "enum class";
        L18:
            return "interface";
        L19:
            return "class";
        L13:
            throw new NoWhenBranchMatchedException();
        L22:
            throw new AssertionError("Unexpected classifier: " + r100);
        }

        public final DescriptorRenderer withOptions(Function1<? super DescriptorRendererOptions, Unit> r100) {
            Intrinsics.checkNotNullParameter(r100, "changeOptions");
            DescriptorRendererOptionsImpl r101 = new DescriptorRendererOptionsImpl();
            r100.invoke(r101);
            r101.lock();
            return new DescriptorRendererImpl(r101);
        }
    }

    public interface ValueParametersHandler {

        public static final class DEFAULT implements ValueParametersHandler {
            public static final DEFAULT INSTANCE = null;

            static {
                INSTANCE = new DEFAULT();
            }

            private DEFAULT() {
            }

            @Override // kotlin.reflect.jvm.internal.impl.renderer.DescriptorRenderer.ValueParametersHandler
            public void appendBeforeValueParameter(ValueParameterDescriptor r100, int r101, int r102, StringBuilder r103) {
                Intrinsics.checkNotNullParameter(r100, "parameter");
                Intrinsics.checkNotNullParameter(r103, "builder");
            }

            @Override // kotlin.reflect.jvm.internal.impl.renderer.DescriptorRenderer.ValueParametersHandler
            public void appendAfterValueParameters(int r100, StringBuilder r101) {
                Intrinsics.checkNotNullParameter(r101, "builder");
                r101.append(")");
            }

            @Override // kotlin.reflect.jvm.internal.impl.renderer.DescriptorRenderer.ValueParametersHandler
            public void appendBeforeValueParameters(int r100, StringBuilder r101) {
                Intrinsics.checkNotNullParameter(r101, "builder");
                r101.append("(");
            }

            @Override // kotlin.reflect.jvm.internal.impl.renderer.DescriptorRenderer.ValueParametersHandler
            public void appendAfterValueParameter(ValueParameterDescriptor r100, int r101, int r102, StringBuilder r103) {
                Intrinsics.checkNotNullParameter(r100, "parameter");
                Intrinsics.checkNotNullParameter(r103, "builder");
                if (r101 == (r102 - 1)) goto L6;
                r103.append(", ");
                return;
            }
        }

        void appendAfterValueParameter(ValueParameterDescriptor r100, int r101, int r102, StringBuilder r103);

        void appendAfterValueParameters(int r100, StringBuilder r101);

        void appendBeforeValueParameter(ValueParameterDescriptor r100, int r101, int r102, StringBuilder r103);

        void appendBeforeValueParameters(int r100, StringBuilder r101);
    }

    public DescriptorRenderer() {
    }

    public static /* synthetic */ Unit accessor$DescriptorRenderer$lambda0(DescriptorRendererOptions r100) {
        return WITHOUT_MODIFIERS$lambda$0(r100);
    }

    public static /* synthetic */ Unit accessor$DescriptorRenderer$lambda1(DescriptorRendererOptions r100) {
        return COMPACT_WITH_MODIFIERS$lambda$1(r100);
    }

    public static /* synthetic */ Unit accessor$DescriptorRenderer$lambda10(DescriptorRendererOptions r100) {
        return HTML$lambda$10(r100);
    }

    public static /* synthetic */ Unit accessor$DescriptorRenderer$lambda2(DescriptorRendererOptions r100) {
        return COMPACT$lambda$2(r100);
    }

    public static /* synthetic */ Unit accessor$DescriptorRenderer$lambda3(DescriptorRendererOptions r100) {
        return COMPACT_WITHOUT_SUPERTYPES$lambda$3(r100);
    }

    public static /* synthetic */ Unit accessor$DescriptorRenderer$lambda4(DescriptorRendererOptions r100) {
        return COMPACT_WITH_SHORT_TYPES$lambda$4(r100);
    }

    public static /* synthetic */ Unit accessor$DescriptorRenderer$lambda5(DescriptorRendererOptions r100) {
        return ONLY_NAMES_WITH_SHORT_TYPES$lambda$5(r100);
    }

    public static /* synthetic */ Unit accessor$DescriptorRenderer$lambda6(DescriptorRendererOptions r100) {
        return FQ_NAMES_IN_TYPES$lambda$6(r100);
    }

    public static /* synthetic */ Unit accessor$DescriptorRenderer$lambda7(DescriptorRendererOptions r100) {
        return FQ_NAMES_IN_TYPES_WITH_ANNOTATIONS$lambda$7(r100);
    }

    public static /* synthetic */ Unit accessor$DescriptorRenderer$lambda8(DescriptorRendererOptions r100) {
        return SHORT_NAMES_IN_TYPES$lambda$8(r100);
    }

    public static /* synthetic */ Unit accessor$DescriptorRenderer$lambda9(DescriptorRendererOptions r100) {
        return DEBUG_TEXT$lambda$9(r100);
    }

    public abstract String render(DeclarationDescriptor r100);

    public abstract String renderAnnotation(AnnotationDescriptor r100, AnnotationUseSiteTarget r101);

    public abstract String renderFlexibleType(String r100, String r101, KotlinBuiltIns r102);

    public abstract String renderFqName(FqNameUnsafe r100);

    public abstract String renderName(Name r100, boolean r101);

    public abstract String renderType(KotlinType r100);

    public abstract String renderTypeProjection(TypeProjection r100);

    static {
        Companion r100 = new Companion(null);
        Companion = r100;
        WITHOUT_MODIFIERS = r100.withOptions(DescriptorRenderer$$Lambda$0.INSTANCE);
        COMPACT_WITH_MODIFIERS = r100.withOptions(DescriptorRenderer$$Lambda$1.INSTANCE);
        COMPACT = r100.withOptions(DescriptorRenderer$$Lambda$2.INSTANCE);
        COMPACT_WITHOUT_SUPERTYPES = r100.withOptions(DescriptorRenderer$$Lambda$3.INSTANCE);
        COMPACT_WITH_SHORT_TYPES = r100.withOptions(DescriptorRenderer$$Lambda$4.INSTANCE);
        ONLY_NAMES_WITH_SHORT_TYPES = r100.withOptions(DescriptorRenderer$$Lambda$5.INSTANCE);
        FQ_NAMES_IN_TYPES = r100.withOptions(DescriptorRenderer$$Lambda$6.INSTANCE);
        FQ_NAMES_IN_TYPES_WITH_ANNOTATIONS = r100.withOptions(DescriptorRenderer$$Lambda$7.INSTANCE);
        SHORT_NAMES_IN_TYPES = r100.withOptions(DescriptorRenderer$$Lambda$8.INSTANCE);
        DEBUG_TEXT = r100.withOptions(DescriptorRenderer$$Lambda$9.INSTANCE);
        HTML = r100.withOptions(DescriptorRenderer$$Lambda$10.INSTANCE);
    }

    private static final Unit COMPACT$lambda$2(DescriptorRendererOptions r100) {
        Intrinsics.checkNotNullParameter(r100, "$this$withOptions");
        r100.setWithDefinedIn(false);
        r100.setModifiers(SetsKt.emptySet());
        return Unit.INSTANCE;
    }

    private static final Unit COMPACT_WITHOUT_SUPERTYPES$lambda$3(DescriptorRendererOptions r100) {
        Intrinsics.checkNotNullParameter(r100, "$this$withOptions");
        r100.setWithDefinedIn(false);
        r100.setModifiers(SetsKt.emptySet());
        r100.setWithoutSuperTypes(true);
        return Unit.INSTANCE;
    }

    private static final Unit COMPACT_WITH_MODIFIERS$lambda$1(DescriptorRendererOptions r100) {
        Intrinsics.checkNotNullParameter(r100, "$this$withOptions");
        r100.setWithDefinedIn(false);
        return Unit.INSTANCE;
    }

    private static final Unit COMPACT_WITH_SHORT_TYPES$lambda$4(DescriptorRendererOptions r100) {
        Intrinsics.checkNotNullParameter(r100, "$this$withOptions");
        r100.setModifiers(SetsKt.emptySet());
        r100.setClassifierNamePolicy(ClassifierNamePolicy.SHORT.INSTANCE);
        r100.setParameterNameRenderingPolicy(ParameterNameRenderingPolicy.ONLY_NON_SYNTHESIZED);
        return Unit.INSTANCE;
    }

    private static final Unit DEBUG_TEXT$lambda$9(DescriptorRendererOptions r100) {
        Intrinsics.checkNotNullParameter(r100, "$this$withOptions");
        r100.setDebugMode(true);
        r100.setClassifierNamePolicy(ClassifierNamePolicy.FULLY_QUALIFIED.INSTANCE);
        r100.setModifiers(DescriptorRendererModifier.ALL);
        return Unit.INSTANCE;
    }

    private static final Unit FQ_NAMES_IN_TYPES$lambda$6(DescriptorRendererOptions r100) {
        Intrinsics.checkNotNullParameter(r100, "$this$withOptions");
        r100.setModifiers(DescriptorRendererModifier.ALL_EXCEPT_ANNOTATIONS);
        return Unit.INSTANCE;
    }

    private static final Unit FQ_NAMES_IN_TYPES_WITH_ANNOTATIONS$lambda$7(DescriptorRendererOptions r100) {
        Intrinsics.checkNotNullParameter(r100, "$this$withOptions");
        r100.setModifiers(DescriptorRendererModifier.ALL);
        return Unit.INSTANCE;
    }

    private static final Unit HTML$lambda$10(DescriptorRendererOptions r100) {
        Intrinsics.checkNotNullParameter(r100, "$this$withOptions");
        r100.setTextFormat(RenderingFormat.HTML);
        r100.setModifiers(DescriptorRendererModifier.ALL);
        return Unit.INSTANCE;
    }

    private static final Unit ONLY_NAMES_WITH_SHORT_TYPES$lambda$5(DescriptorRendererOptions r100) {
        Intrinsics.checkNotNullParameter(r100, "$this$withOptions");
        r100.setWithDefinedIn(false);
        r100.setModifiers(SetsKt.emptySet());
        r100.setClassifierNamePolicy(ClassifierNamePolicy.SHORT.INSTANCE);
        r100.setWithoutTypeParameters(true);
        r100.setParameterNameRenderingPolicy(ParameterNameRenderingPolicy.NONE);
        r100.setReceiverAfterName(true);
        r100.setRenderCompanionObjectName(true);
        r100.setWithoutSuperTypes(true);
        r100.setStartFromName(true);
        return Unit.INSTANCE;
    }

    private static final Unit SHORT_NAMES_IN_TYPES$lambda$8(DescriptorRendererOptions r100) {
        Intrinsics.checkNotNullParameter(r100, "$this$withOptions");
        r100.setClassifierNamePolicy(ClassifierNamePolicy.SHORT.INSTANCE);
        r100.setParameterNameRenderingPolicy(ParameterNameRenderingPolicy.ONLY_NON_SYNTHESIZED);
        return Unit.INSTANCE;
    }

    private static final Unit WITHOUT_MODIFIERS$lambda$0(DescriptorRendererOptions r100) {
        Intrinsics.checkNotNullParameter(r100, "$this$withOptions");
        r100.setModifiers(SetsKt.emptySet());
        return Unit.INSTANCE;
    }

    public final DescriptorRenderer withOptions(Function1<? super DescriptorRendererOptions, Unit> r100) {
        Intrinsics.checkNotNullParameter(r100, "changeOptions");
        Intrinsics.checkNotNull(this, "null cannot be cast to non-null type org.jetbrains.kotlin.renderer.DescriptorRendererImpl");
        DescriptorRendererOptionsImpl r101 = ((DescriptorRendererImpl) this).getOptions().copy();
        r100.invoke(r101);
        r101.lock();
        return new DescriptorRendererImpl(r101);
    }

    public static /* synthetic */ String renderAnnotation$default(DescriptorRenderer r100, AnnotationDescriptor r101, AnnotationUseSiteTarget r102, int r103, Object r104) {
        if (r104 != null) goto L9;
        if ((r103 & 2) == 0) goto L7;
        r102 = null;
    L7:
        return r100.renderAnnotation(r101, r102);
    L9:
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: renderAnnotation");
    }
}
