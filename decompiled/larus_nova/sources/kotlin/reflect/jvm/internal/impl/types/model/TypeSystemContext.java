package kotlin.reflect.jvm.internal.impl.types.model;

import java.util.Collection;
import java.util.List;
import kotlin.reflect.jvm.internal.impl.types.TypeCheckerState;

/* JADX INFO: loaded from: classes42.dex */
public interface TypeSystemContext extends TypeSystemOptimizationContext {
    boolean areEqualTypeConstructors(TypeConstructorMarker r100, TypeConstructorMarker r101);

    int argumentsCount(KotlinTypeMarker r100);

    TypeArgumentListMarker asArgumentList(SimpleTypeMarker r100);

    CapturedTypeMarker asCapturedType(SimpleTypeMarker r100);

    DefinitelyNotNullTypeMarker asDefinitelyNotNullType(SimpleTypeMarker r100);

    DynamicTypeMarker asDynamicType(FlexibleTypeMarker r100);

    FlexibleTypeMarker asFlexibleType(KotlinTypeMarker r100);

    SimpleTypeMarker asSimpleType(KotlinTypeMarker r100);

    TypeArgumentMarker asTypeArgument(KotlinTypeMarker r100);

    SimpleTypeMarker captureFromArguments(SimpleTypeMarker r100, CaptureStatus r101);

    CaptureStatus captureStatus(CapturedTypeMarker r100);

    List<SimpleTypeMarker> fastCorrespondingSupertypes(SimpleTypeMarker r100, TypeConstructorMarker r101);

    TypeArgumentMarker get(TypeArgumentListMarker r100, int r101);

    TypeArgumentMarker getArgument(KotlinTypeMarker r100, int r101);

    TypeArgumentMarker getArgumentOrNull(SimpleTypeMarker r100, int r101);

    List<TypeArgumentMarker> getArguments(KotlinTypeMarker r100);

    TypeParameterMarker getParameter(TypeConstructorMarker r100, int r101);

    List<TypeParameterMarker> getParameters(TypeConstructorMarker r100);

    KotlinTypeMarker getType(TypeArgumentMarker r100);

    TypeParameterMarker getTypeParameter(TypeVariableTypeConstructorMarker r100);

    TypeParameterMarker getTypeParameterClassifier(TypeConstructorMarker r100);

    List<KotlinTypeMarker> getUpperBounds(TypeParameterMarker r100);

    TypeVariance getVariance(TypeArgumentMarker r100);

    TypeVariance getVariance(TypeParameterMarker r100);

    boolean hasFlexibleNullability(KotlinTypeMarker r100);

    boolean hasRecursiveBounds(TypeParameterMarker r100, TypeConstructorMarker r101);

    KotlinTypeMarker intersectTypes(List<? extends KotlinTypeMarker> r100);

    boolean isAnyConstructor(TypeConstructorMarker r100);

    boolean isCapturedType(KotlinTypeMarker r100);

    boolean isClassType(SimpleTypeMarker r100);

    boolean isClassTypeConstructor(TypeConstructorMarker r100);

    boolean isCommonFinalClassConstructor(TypeConstructorMarker r100);

    boolean isDefinitelyNotNullType(KotlinTypeMarker r100);

    boolean isDenotable(TypeConstructorMarker r100);

    boolean isDynamic(KotlinTypeMarker r100);

    boolean isError(KotlinTypeMarker r100);

    boolean isFlexibleWithDifferentTypeConstructors(KotlinTypeMarker r100);

    boolean isIntegerLiteralType(SimpleTypeMarker r100);

    boolean isIntegerLiteralTypeConstructor(TypeConstructorMarker r100);

    boolean isIntersection(TypeConstructorMarker r100);

    boolean isMarkedNullable(KotlinTypeMarker r100);

    boolean isMarkedNullable(SimpleTypeMarker r100);

    boolean isNotNullTypeParameter(KotlinTypeMarker r100);

    boolean isNothing(KotlinTypeMarker r100);

    boolean isNothingConstructor(TypeConstructorMarker r100);

    boolean isNullableType(KotlinTypeMarker r100);

    boolean isOldCapturedType(CapturedTypeMarker r100);

    boolean isPrimitiveType(SimpleTypeMarker r100);

    boolean isProjectionNotNull(CapturedTypeMarker r100);

    boolean isRawType(KotlinTypeMarker r100);

    boolean isSingleClassifierType(SimpleTypeMarker r100);

    boolean isStarProjection(TypeArgumentMarker r100);

    boolean isStubType(SimpleTypeMarker r100);

    boolean isStubTypeForBuilderInference(SimpleTypeMarker r100);

    boolean isTypeVariableType(KotlinTypeMarker r100);

    SimpleTypeMarker lowerBound(FlexibleTypeMarker r100);

    SimpleTypeMarker lowerBoundIfFlexible(KotlinTypeMarker r100);

    KotlinTypeMarker lowerType(CapturedTypeMarker r100);

    KotlinTypeMarker makeDefinitelyNotNullOrNotNull(KotlinTypeMarker r100);

    SimpleTypeMarker original(DefinitelyNotNullTypeMarker r100);

    SimpleTypeMarker originalIfDefinitelyNotNullable(SimpleTypeMarker r100);

    int parametersCount(TypeConstructorMarker r100);

    Collection<KotlinTypeMarker> possibleIntegerTypes(SimpleTypeMarker r100);

    TypeArgumentMarker projection(CapturedTypeConstructorMarker r100);

    int size(TypeArgumentListMarker r100);

    TypeCheckerState.SupertypesPolicy substitutionSupertypePolicy(SimpleTypeMarker r100);

    Collection<KotlinTypeMarker> supertypes(TypeConstructorMarker r100);

    CapturedTypeConstructorMarker typeConstructor(CapturedTypeMarker r100);

    TypeConstructorMarker typeConstructor(KotlinTypeMarker r100);

    TypeConstructorMarker typeConstructor(SimpleTypeMarker r100);

    SimpleTypeMarker upperBound(FlexibleTypeMarker r100);

    SimpleTypeMarker upperBoundIfFlexible(KotlinTypeMarker r100);

    KotlinTypeMarker withNullability(KotlinTypeMarker r100, boolean r101);

    SimpleTypeMarker withNullability(SimpleTypeMarker r100, boolean r101);
}
