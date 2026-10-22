package kotlin.reflect.jvm.internal.impl.types.typesApproximation;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.builtins.KotlinBuiltIns;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.renderer.ClassifierNamePolicy;
import kotlin.reflect.jvm.internal.impl.renderer.DescriptorRendererOptions;
import kotlin.reflect.jvm.internal.impl.resolve.calls.inference.CapturedTypeConstructor;
import kotlin.reflect.jvm.internal.impl.resolve.calls.inference.CapturedTypeConstructorKt;
import kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.DescriptorUtilsKt;
import kotlin.reflect.jvm.internal.impl.types.FlexibleTypesKt;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import kotlin.reflect.jvm.internal.impl.types.KotlinTypeFactory;
import kotlin.reflect.jvm.internal.impl.types.TypeConstructor;
import kotlin.reflect.jvm.internal.impl.types.TypeProjection;
import kotlin.reflect.jvm.internal.impl.types.TypeProjectionImpl;
import kotlin.reflect.jvm.internal.impl.types.TypeSubstitutionKt;
import kotlin.reflect.jvm.internal.impl.types.TypeSubstitutor;
import kotlin.reflect.jvm.internal.impl.types.TypeUtils;
import kotlin.reflect.jvm.internal.impl.types.TypeWithEnhancementKt;
import kotlin.reflect.jvm.internal.impl.types.UnwrappedType;
import kotlin.reflect.jvm.internal.impl.types.Variance;
import kotlin.reflect.jvm.internal.impl.types.typeUtil.TypeUtilsKt;

/* JADX INFO: loaded from: classes42.dex */
public final class CapturedTypeApproximationKt {

    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0 = null;

        static {
            int[] r100 = new int[Variance.values().length];
            r100[Variance.INVARIANT.ordinal()] = 1;     // Catch: NoSuchFieldError -> L8
        L11:
            r100[Variance.IN_VARIANCE.ordinal()] = 2;     // Catch: NoSuchFieldError -> L9
        L15:
            r100[Variance.OUT_VARIANCE.ordinal()] = 3;     // Catch: NoSuchFieldError -> L10
        L6:
            $EnumSwitchMapping$0 = r100;
        }
    }

    public static /* synthetic */ Unit accessor$CapturedTypeApproximationKt$lambda0(DescriptorRendererOptions r100) {
        return toTypeProjection$lambda$1$lambda$0(r100);
    }

    public static /* synthetic */ Boolean accessor$CapturedTypeApproximationKt$lambda1(UnwrappedType r100) {
        return approximateCapturedTypesIfNecessary$lambda$2(r100);
    }

    public static final ApproximationBounds<KotlinType> approximateCapturedTypes(KotlinType r100) {
        Intrinsics.checkNotNullParameter(r100, "type");
        if (FlexibleTypesKt.isFlexible(r100) == false) goto L6;
        ApproximationBounds<KotlinType> r101 = approximateCapturedTypes(FlexibleTypesKt.lowerIfFlexible(r100));
        ApproximationBounds<KotlinType> r102 = approximateCapturedTypes(FlexibleTypesKt.upperIfFlexible(r100));
        return new ApproximationBounds(TypeWithEnhancementKt.inheritEnhancement(KotlinTypeFactory.flexibleType(FlexibleTypesKt.lowerIfFlexible(r101.getLower()), FlexibleTypesKt.upperIfFlexible(r102.getLower())), r100), TypeWithEnhancementKt.inheritEnhancement(KotlinTypeFactory.flexibleType(FlexibleTypesKt.lowerIfFlexible(r101.getUpper()), FlexibleTypesKt.upperIfFlexible(r102.getUpper())), r100));
    L6:
        TypeConstructor r103 = r100.getConstructor();
        if (CapturedTypeConstructorKt.isCaptured(r100) == false) goto L18;
        Intrinsics.checkNotNull(r103, "null cannot be cast to non-null type org.jetbrains.kotlin.resolve.calls.inference.CapturedTypeConstructor");
        TypeProjection r104 = ((CapturedTypeConstructor) r103).getProjection();
        KotlinType r105 = approximateCapturedTypes$makeNullableIfNeeded(r104.getType(), r100);
        int r106 = WhenMappings.$EnumSwitchMapping$0[r104.getProjectionKind().ordinal()];
        if (r106 == 2) goto L16;
        if (r106 != 3) goto L14;
        return new ApproximationBounds(approximateCapturedTypes$makeNullableIfNeeded(TypeUtilsKt.getBuiltIns(r100).getNothingType(), r100), r105);
    L14:
        throw new AssertionError("Only nontrivial projections should have been captured, not: " + r104);
    L16:
        return new ApproximationBounds(r105, TypeUtilsKt.getBuiltIns(r100).getNullableAnyType());
    L18:
        if (r100.getArguments().isEmpty() == true) goto L45;
        if (r100.getArguments().size() != r103.getParameters().size()) goto L45;
        ArrayList r107 = new ArrayList();
        ArrayList r108 = new ArrayList();
        Iterator r109 = CollectionsKt.zip(r100.getArguments(), r103.getParameters()).iterator();
    L24:
        if (r109.hasNext() == false) goto L29;
        Pair r110 = (Pair) r109.next();
        TypeProjection r111 = (TypeProjection) r110.component1();
        TypeParameterDescriptor r112 = (TypeParameterDescriptor) r110.component2();
        Intrinsics.checkNotNull(r112);
        TypeArgument r113 = toTypeArgument(r111, r112);
        if (r111.isStarProjection() == true) goto L27;
        ApproximationBounds<TypeArgument> r114 = approximateProjection(r113);
        TypeArgument r115 = r114.component1();
        TypeArgument r116 = r114.component2();
        r107.add(r115);
        r108.add(r116);
        goto L24
    L27:
        r107.add(r113);
        r108.add(r113);
        goto L24
    L29:
        boolean r117 = false;
        if (r107.isEmpty() == true) goto L39;
        Iterator r118 = r107.iterator();
    L34:
        if (r118.hasNext() == false) goto L39;
        if ((!((TypeArgument) r118.next()).isConsistent()) == false) goto L34;
        r117 = true;
    L39:
        if (r117 == false) goto L41;
        Object r119 = TypeUtilsKt.getBuiltIns(r100).getNothingType();
    L43:
        return new ApproximationBounds(r119, replaceTypeArguments(r100, r108));
    L41:
        r119 = replaceTypeArguments(r100, r107);
    L45:
        return new ApproximationBounds(r100, r100);
    }

    private static final Boolean approximateCapturedTypesIfNecessary$lambda$2(UnwrappedType r100) {
        Intrinsics.checkNotNull(r100);
        return Boolean.valueOf(CapturedTypeConstructorKt.isCaptured(r100));
    }

    private static final ApproximationBounds<TypeArgument> approximateProjection(TypeArgument r100) {
        ApproximationBounds<KotlinType> r101 = approximateCapturedTypes(r100.getInProjection());
        KotlinType r102 = r101.component1();
        KotlinType r103 = r101.component2();
        ApproximationBounds<KotlinType> r104 = approximateCapturedTypes(r100.getOutProjection());
        KotlinType r105 = r104.component1();
        KotlinType r106 = r104.component2();
        return new ApproximationBounds(new TypeArgument(r100.getTypeParameter(), r103, r105), new TypeArgument(r100.getTypeParameter(), r102, r106));
    }

    private static final TypeProjection substituteCapturedTypesWithProjections(TypeProjection r100) {
        return TypeSubstitutor.create(new CapturedTypeApproximationKt$substituteCapturedTypesWithProjections$typeSubstitutor$1()).substituteWithoutApproximation(r100);
    }

    private static final TypeProjection toTypeProjection(TypeArgument r100) {
        r100.isConsistent();
        if (Intrinsics.areEqual(r100.getInProjection(), r100.getOutProjection()) == true) goto L17;
        Variance r101 = r100.getTypeParameter().getVariance();
        Variance r102 = Variance.IN_VARIANCE;
        if (r101 == r102) goto L17;
        if (KotlinBuiltIns.isNothing(r100.getInProjection()) == false) goto L13;
        if (r100.getTypeParameter().getVariance() == r102) goto L13;
        return new TypeProjectionImpl(toTypeProjection$removeProjectionIfRedundant(r100, Variance.OUT_VARIANCE), r100.getOutProjection());
    L13:
        if (KotlinBuiltIns.isNullableAny(r100.getOutProjection()) == false) goto L20;
        return new TypeProjectionImpl(toTypeProjection$removeProjectionIfRedundant(r100, r102), r100.getInProjection());
    L20:
        return new TypeProjectionImpl(toTypeProjection$removeProjectionIfRedundant(r100, Variance.OUT_VARIANCE), r100.getOutProjection());
    L17:
        return new TypeProjectionImpl(r100.getInProjection());
    }

    private static final Unit toTypeProjection$lambda$1$lambda$0(DescriptorRendererOptions r100) {
        Intrinsics.checkNotNullParameter(r100, "$this$withOptions");
        r100.setClassifierNamePolicy(ClassifierNamePolicy.FULLY_QUALIFIED.INSTANCE);
        return Unit.INSTANCE;
    }

    private static final KotlinType approximateCapturedTypes$makeNullableIfNeeded(KotlinType r100, KotlinType r101) {
        return TypeUtils.makeNullableIfNeeded(r100, r101.isMarkedNullable());
    }

    public static final TypeProjection approximateCapturedTypesIfNecessary(TypeProjection r100, boolean r101) {
        if (r100 != null) goto L6;
        return null;
    L6:
        if (r100.isStarProjection() == false) goto L8;
        return r100;
    L8:
        KotlinType r102 = r100.getType();
        if (TypeUtils.contains(r102, CapturedTypeApproximationKt$$Lambda$1.INSTANCE) == true) goto L11;
        return r100;
    L11:
        Variance r103 = r100.getProjectionKind();
        if (r103 == Variance.OUT_VARIANCE) goto L14;
        if (r101 == false) goto L19;
        return new TypeProjectionImpl(r103, approximateCapturedTypes(r102).getLower());
    L19:
        return substituteCapturedTypesWithProjections(r100);
    L14:
        return new TypeProjectionImpl(r103, approximateCapturedTypes(r102).getUpper());
    }

    private static final KotlinType replaceTypeArguments(KotlinType r100, List<TypeArgument> r101) {
        r100.getArguments().size();
        r101.size();
        List<TypeArgument> r102 = r101;
        ArrayList r103 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r102, 10));
        Iterator<T> r104 = r102.iterator();
    L4:
        if (r104.hasNext() == false) goto L7;
        r103.add(toTypeProjection((TypeArgument) r104.next()));
        goto L4
    L7:
        return TypeSubstitutionKt.replace$default(r100, r103, null, null, 6, null);
    }

    private static final TypeArgument toTypeArgument(TypeProjection r100, TypeParameterDescriptor r101) {
        Variance r102 = TypeSubstitutor.combine(r101.getVariance(), r100);
        int r103 = WhenMappings.$EnumSwitchMapping$0[r102.ordinal()];
        if (r103 == 1) goto L13;
        if (r103 == 2) goto L15;
        if (r103 != 3) goto L10;
        return new TypeArgument(r101, DescriptorUtilsKt.getBuiltIns(r101).getNothingType(), r100.getType());
    L10:
        throw new NoWhenBranchMatchedException();
    L15:
        return new TypeArgument(r101, r100.getType(), DescriptorUtilsKt.getBuiltIns(r101).getNullableAnyType());
    L13:
        return new TypeArgument(r101, r100.getType(), r100.getType());
    }

    private static final Variance toTypeProjection$removeProjectionIfRedundant(TypeArgument r100, Variance r101) {
        if (r101 == r100.getTypeParameter().getVariance()) goto L5;
        return r101;
    L5:
        return Variance.INVARIANT;
    }
}
