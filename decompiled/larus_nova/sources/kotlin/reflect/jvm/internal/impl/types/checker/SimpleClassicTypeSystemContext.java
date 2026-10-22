package kotlin.reflect.jvm.internal.impl.types.checker;

import java.util.Collection;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.jvm.internal.impl.builtins.PrimitiveType;
import kotlin.reflect.jvm.internal.impl.name.FqName;
import kotlin.reflect.jvm.internal.impl.name.FqNameUnsafe;
import kotlin.reflect.jvm.internal.impl.types.TypeCheckerState;
import kotlin.reflect.jvm.internal.impl.types.model.ArgumentList;
import kotlin.reflect.jvm.internal.impl.types.model.CaptureStatus;
import kotlin.reflect.jvm.internal.impl.types.model.CapturedTypeConstructorMarker;
import kotlin.reflect.jvm.internal.impl.types.model.CapturedTypeMarker;
import kotlin.reflect.jvm.internal.impl.types.model.DefinitelyNotNullTypeMarker;
import kotlin.reflect.jvm.internal.impl.types.model.DynamicTypeMarker;
import kotlin.reflect.jvm.internal.impl.types.model.FlexibleTypeMarker;
import kotlin.reflect.jvm.internal.impl.types.model.KotlinTypeMarker;
import kotlin.reflect.jvm.internal.impl.types.model.SimpleTypeMarker;
import kotlin.reflect.jvm.internal.impl.types.model.TypeArgumentListMarker;
import kotlin.reflect.jvm.internal.impl.types.model.TypeArgumentMarker;
import kotlin.reflect.jvm.internal.impl.types.model.TypeConstructorMarker;
import kotlin.reflect.jvm.internal.impl.types.model.TypeParameterMarker;
import kotlin.reflect.jvm.internal.impl.types.model.TypeVariableTypeConstructorMarker;
import kotlin.reflect.jvm.internal.impl.types.model.TypeVariance;

/* JADX INFO: loaded from: classes42.dex */
public final class SimpleClassicTypeSystemContext implements ClassicTypeSystemContext {
    public static final SimpleClassicTypeSystemContext INSTANCE = null;

    static {
        INSTANCE = new SimpleClassicTypeSystemContext();
    }

    private SimpleClassicTypeSystemContext() {
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.model.TypeSystemContext
    public List<SimpleTypeMarker> fastCorrespondingSupertypes(SimpleTypeMarker r100, TypeConstructorMarker r101) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        Intrinsics.checkNotNullParameter(r101, "constructor");
        return null;
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.model.TypeSystemInferenceExtensionContext
    public boolean isK2() {
        return ClassicTypeSystemContext.DefaultImpls.isK2(this);
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.model.TypeSystemContext
    public int argumentsCount(KotlinTypeMarker r100) {
        return ClassicTypeSystemContext.DefaultImpls.argumentsCount(this, r100);
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.model.TypeSystemContext
    public TypeArgumentListMarker asArgumentList(SimpleTypeMarker r100) {
        return ClassicTypeSystemContext.DefaultImpls.asArgumentList(this, r100);
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.checker.ClassicTypeSystemContext, kotlin.reflect.jvm.internal.impl.types.model.TypeSystemContext
    public CapturedTypeMarker asCapturedType(SimpleTypeMarker r100) {
        return ClassicTypeSystemContext.DefaultImpls.asCapturedType(this, r100);
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.model.TypeSystemContext
    public DefinitelyNotNullTypeMarker asDefinitelyNotNullType(SimpleTypeMarker r100) {
        return ClassicTypeSystemContext.DefaultImpls.asDefinitelyNotNullType(this, r100);
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.model.TypeSystemContext
    public DynamicTypeMarker asDynamicType(FlexibleTypeMarker r100) {
        return ClassicTypeSystemContext.DefaultImpls.asDynamicType(this, r100);
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.model.TypeSystemContext
    public FlexibleTypeMarker asFlexibleType(KotlinTypeMarker r100) {
        return ClassicTypeSystemContext.DefaultImpls.asFlexibleType(this, r100);
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.checker.ClassicTypeSystemContext, kotlin.reflect.jvm.internal.impl.types.model.TypeSystemContext
    public SimpleTypeMarker asSimpleType(KotlinTypeMarker r100) {
        return ClassicTypeSystemContext.DefaultImpls.asSimpleType(this, r100);
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.model.TypeSystemContext
    public TypeArgumentMarker asTypeArgument(KotlinTypeMarker r100) {
        return ClassicTypeSystemContext.DefaultImpls.asTypeArgument(this, r100);
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.model.TypeSystemContext
    public CaptureStatus captureStatus(CapturedTypeMarker r100) {
        return ClassicTypeSystemContext.DefaultImpls.captureStatus(this, r100);
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.model.TypeSystemContext
    public List<TypeArgumentMarker> getArguments(KotlinTypeMarker r100) {
        return ClassicTypeSystemContext.DefaultImpls.getArguments(this, r100);
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.TypeSystemCommonBackendContext
    public FqNameUnsafe getClassFqNameUnsafe(TypeConstructorMarker r100) {
        return ClassicTypeSystemContext.DefaultImpls.getClassFqNameUnsafe(this, r100);
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.model.TypeSystemContext
    public List<TypeParameterMarker> getParameters(TypeConstructorMarker r100) {
        return ClassicTypeSystemContext.DefaultImpls.getParameters(this, r100);
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.TypeSystemCommonBackendContext
    public PrimitiveType getPrimitiveArrayType(TypeConstructorMarker r100) {
        return ClassicTypeSystemContext.DefaultImpls.getPrimitiveArrayType(this, r100);
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.TypeSystemCommonBackendContext
    public PrimitiveType getPrimitiveType(TypeConstructorMarker r100) {
        return ClassicTypeSystemContext.DefaultImpls.getPrimitiveType(this, r100);
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.TypeSystemCommonBackendContext
    public KotlinTypeMarker getRepresentativeUpperBound(TypeParameterMarker r100) {
        return ClassicTypeSystemContext.DefaultImpls.getRepresentativeUpperBound(this, r100);
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.model.TypeSystemContext
    public KotlinTypeMarker getType(TypeArgumentMarker r100) {
        return ClassicTypeSystemContext.DefaultImpls.getType(this, r100);
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.model.TypeSystemContext
    public TypeParameterMarker getTypeParameter(TypeVariableTypeConstructorMarker r100) {
        return ClassicTypeSystemContext.DefaultImpls.getTypeParameter(this, r100);
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.model.TypeSystemContext
    public TypeParameterMarker getTypeParameterClassifier(TypeConstructorMarker r100) {
        return ClassicTypeSystemContext.DefaultImpls.getTypeParameterClassifier(this, r100);
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.TypeSystemCommonBackendContext
    public KotlinTypeMarker getUnsubstitutedUnderlyingType(KotlinTypeMarker r100) {
        return ClassicTypeSystemContext.DefaultImpls.getUnsubstitutedUnderlyingType(this, r100);
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.model.TypeSystemContext
    public List<KotlinTypeMarker> getUpperBounds(TypeParameterMarker r100) {
        return ClassicTypeSystemContext.DefaultImpls.getUpperBounds(this, r100);
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.model.TypeSystemContext
    public TypeVariance getVariance(TypeArgumentMarker r100) {
        return ClassicTypeSystemContext.DefaultImpls.getVariance(this, r100);
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.model.TypeSystemContext
    public boolean hasFlexibleNullability(KotlinTypeMarker r100) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        if (isMarkedNullable(lowerBoundIfFlexible(r100)) == isMarkedNullable(upperBoundIfFlexible(r100))) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.model.TypeSystemContext
    public KotlinTypeMarker intersectTypes(List<? extends KotlinTypeMarker> r100) {
        return ClassicTypeSystemContext.DefaultImpls.intersectTypes(this, r100);
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.model.TypeSystemContext
    public boolean isAnyConstructor(TypeConstructorMarker r100) {
        return ClassicTypeSystemContext.DefaultImpls.isAnyConstructor(this, r100);
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.model.TypeSystemContext
    public boolean isCapturedType(KotlinTypeMarker r100) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        SimpleTypeMarker r101 = asSimpleType(r100);
        if (r101 == null) goto L5;
        CapturedTypeMarker r102 = asCapturedType(r101);
    L6:
        if (r102 == null) goto L8;
        return true;
    L8:
        return false;
    L5:
        r102 = null;
        goto L6
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.model.TypeSystemContext
    public boolean isClassType(SimpleTypeMarker r100) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        return isClassTypeConstructor(typeConstructor(r100));
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.model.TypeSystemContext
    public boolean isClassTypeConstructor(TypeConstructorMarker r100) {
        return ClassicTypeSystemContext.DefaultImpls.isClassTypeConstructor(this, r100);
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.model.TypeSystemContext
    public boolean isCommonFinalClassConstructor(TypeConstructorMarker r100) {
        return ClassicTypeSystemContext.DefaultImpls.isCommonFinalClassConstructor(this, r100);
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.model.TypeSystemContext
    public boolean isDefinitelyNotNullType(KotlinTypeMarker r100) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        SimpleTypeMarker r101 = asSimpleType(r100);
        if (r101 == null) goto L5;
        DefinitelyNotNullTypeMarker r102 = asDefinitelyNotNullType(r101);
    L6:
        if (r102 == null) goto L8;
        return true;
    L8:
        return false;
    L5:
        r102 = null;
        goto L6
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.model.TypeSystemContext
    public boolean isDenotable(TypeConstructorMarker r100) {
        return ClassicTypeSystemContext.DefaultImpls.isDenotable(this, r100);
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.model.TypeSystemContext
    public boolean isDynamic(KotlinTypeMarker r100) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        FlexibleTypeMarker r101 = asFlexibleType(r100);
        if (r101 == null) goto L5;
        DynamicTypeMarker r102 = asDynamicType(r101);
    L6:
        if (r102 == null) goto L8;
        return true;
    L8:
        return false;
    L5:
        r102 = null;
        goto L6
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.model.TypeSystemContext
    public boolean isError(KotlinTypeMarker r100) {
        return ClassicTypeSystemContext.DefaultImpls.isError(this, r100);
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.model.TypeSystemContext
    public boolean isFlexibleWithDifferentTypeConstructors(KotlinTypeMarker r100) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        return !Intrinsics.areEqual(typeConstructor(lowerBoundIfFlexible(r100)), typeConstructor(upperBoundIfFlexible(r100)));
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.TypeSystemCommonBackendContext
    public boolean isInlineClass(TypeConstructorMarker r100) {
        return ClassicTypeSystemContext.DefaultImpls.isInlineClass(this, r100);
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.model.TypeSystemContext
    public boolean isIntegerLiteralType(SimpleTypeMarker r100) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        return isIntegerLiteralTypeConstructor(typeConstructor(r100));
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.model.TypeSystemContext
    public boolean isIntegerLiteralTypeConstructor(TypeConstructorMarker r100) {
        return ClassicTypeSystemContext.DefaultImpls.isIntegerLiteralTypeConstructor(this, r100);
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.model.TypeSystemContext
    public boolean isIntersection(TypeConstructorMarker r100) {
        return ClassicTypeSystemContext.DefaultImpls.isIntersection(this, r100);
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.model.TypeSystemContext
    public boolean isMarkedNullable(KotlinTypeMarker r100) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        if ((r100 instanceof SimpleTypeMarker) == true) goto L5;
    L7:
        return false;
    L5:
        if (isMarkedNullable((SimpleTypeMarker) r100) == false) goto L7;
        return true;
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.model.TypeSystemContext
    public boolean isNotNullTypeParameter(KotlinTypeMarker r100) {
        return ClassicTypeSystemContext.DefaultImpls.isNotNullTypeParameter(this, r100);
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.model.TypeSystemContext
    public boolean isNothing(KotlinTypeMarker r100) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        if (isNothingConstructor(typeConstructor(r100)) == true) goto L5;
    L7:
        return false;
    L5:
        if (isNullableType(r100) == true) goto L7;
        return true;
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.model.TypeSystemContext
    public boolean isNothingConstructor(TypeConstructorMarker r100) {
        return ClassicTypeSystemContext.DefaultImpls.isNothingConstructor(this, r100);
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.model.TypeSystemContext
    public boolean isNullableType(KotlinTypeMarker r100) {
        return ClassicTypeSystemContext.DefaultImpls.isNullableType(this, r100);
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.model.TypeSystemContext
    public boolean isOldCapturedType(CapturedTypeMarker r100) {
        return ClassicTypeSystemContext.DefaultImpls.isOldCapturedType(this, r100);
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.model.TypeSystemContext
    public boolean isPrimitiveType(SimpleTypeMarker r100) {
        return ClassicTypeSystemContext.DefaultImpls.isPrimitiveType(this, r100);
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.model.TypeSystemContext
    public boolean isProjectionNotNull(CapturedTypeMarker r100) {
        return ClassicTypeSystemContext.DefaultImpls.isProjectionNotNull(this, r100);
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.model.TypeSystemContext
    public boolean isRawType(KotlinTypeMarker r100) {
        return ClassicTypeSystemContext.DefaultImpls.isRawType(this, r100);
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.checker.ClassicTypeSystemContext, kotlin.reflect.jvm.internal.impl.types.model.TypeSystemContext
    public boolean isSingleClassifierType(SimpleTypeMarker r100) {
        return ClassicTypeSystemContext.DefaultImpls.isSingleClassifierType(this, r100);
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.model.TypeSystemContext
    public boolean isStarProjection(TypeArgumentMarker r100) {
        return ClassicTypeSystemContext.DefaultImpls.isStarProjection(this, r100);
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.model.TypeSystemContext
    public boolean isStubType(SimpleTypeMarker r100) {
        return ClassicTypeSystemContext.DefaultImpls.isStubType(this, r100);
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.model.TypeSystemContext
    public boolean isStubTypeForBuilderInference(SimpleTypeMarker r100) {
        return ClassicTypeSystemContext.DefaultImpls.isStubTypeForBuilderInference(this, r100);
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.model.TypeSystemContext
    public boolean isTypeVariableType(KotlinTypeMarker r100) {
        return ClassicTypeSystemContext.DefaultImpls.isTypeVariableType(this, r100);
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.TypeSystemCommonBackendContext
    public boolean isUnderKotlinPackage(TypeConstructorMarker r100) {
        return ClassicTypeSystemContext.DefaultImpls.isUnderKotlinPackage(this, r100);
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.checker.ClassicTypeSystemContext, kotlin.reflect.jvm.internal.impl.types.model.TypeSystemContext
    public SimpleTypeMarker lowerBound(FlexibleTypeMarker r100) {
        return ClassicTypeSystemContext.DefaultImpls.lowerBound(this, r100);
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.model.TypeSystemContext
    public SimpleTypeMarker lowerBoundIfFlexible(KotlinTypeMarker r100) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        FlexibleTypeMarker r101 = asFlexibleType(r100);
        if (r101 == null) goto L6;
        SimpleTypeMarker r102 = lowerBound(r101);
        if (r102 == null) goto L6;
        return r102;
    L6:
        SimpleTypeMarker r103 = asSimpleType(r100);
        Intrinsics.checkNotNull(r103);
        return r103;
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.model.TypeSystemContext
    public KotlinTypeMarker lowerType(CapturedTypeMarker r100) {
        return ClassicTypeSystemContext.DefaultImpls.lowerType(this, r100);
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.model.TypeSystemContext
    public KotlinTypeMarker makeDefinitelyNotNullOrNotNull(KotlinTypeMarker r100) {
        return ClassicTypeSystemContext.DefaultImpls.makeDefinitelyNotNullOrNotNull(this, r100);
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.TypeSystemCommonBackendContext
    public KotlinTypeMarker makeNullable(KotlinTypeMarker r100) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        SimpleTypeMarker r101 = asSimpleType(r100);
        if (r101 == null) goto L8;
        SimpleTypeMarker r102 = withNullability(r101, true);
        if (r102 != null) goto L7;
        return r100;
    L7:
        return r102;
    L8:
        return r100;
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.model.TypeSystemContext
    public SimpleTypeMarker original(DefinitelyNotNullTypeMarker r100) {
        return ClassicTypeSystemContext.DefaultImpls.original(this, r100);
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.model.TypeSystemContext
    public SimpleTypeMarker originalIfDefinitelyNotNullable(SimpleTypeMarker r100) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        DefinitelyNotNullTypeMarker r101 = asDefinitelyNotNullType(r100);
        if (r101 == null) goto L9;
        SimpleTypeMarker r102 = original(r101);
        if (r102 != null) goto L8;
        return r100;
    L8:
        return r102;
    L9:
        return r100;
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.model.TypeSystemContext
    public int parametersCount(TypeConstructorMarker r100) {
        return ClassicTypeSystemContext.DefaultImpls.parametersCount(this, r100);
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.model.TypeSystemContext
    public Collection<KotlinTypeMarker> possibleIntegerTypes(SimpleTypeMarker r100) {
        return ClassicTypeSystemContext.DefaultImpls.possibleIntegerTypes(this, r100);
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.model.TypeSystemContext
    public TypeArgumentMarker projection(CapturedTypeConstructorMarker r100) {
        return ClassicTypeSystemContext.DefaultImpls.projection(this, r100);
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.model.TypeSystemContext
    public int size(TypeArgumentListMarker r100) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        if ((r100 instanceof SimpleTypeMarker) == false) goto L6;
        return argumentsCount((KotlinTypeMarker) r100);
    L6:
        if ((r100 instanceof ArgumentList) == false) goto L10;
        return ((ArgumentList) r100).size();
    L10:
        throw new IllegalStateException(("unknown type argument list type: " + r100 + ", " + Reflection.getOrCreateKotlinClass(r100.getClass())).toString());
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.model.TypeSystemContext
    public TypeCheckerState.SupertypesPolicy substitutionSupertypePolicy(SimpleTypeMarker r100) {
        return ClassicTypeSystemContext.DefaultImpls.substitutionSupertypePolicy(this, r100);
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.model.TypeSystemContext
    public Collection<KotlinTypeMarker> supertypes(TypeConstructorMarker r100) {
        return ClassicTypeSystemContext.DefaultImpls.supertypes(this, r100);
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.model.TypeSystemContext
    public TypeConstructorMarker typeConstructor(KotlinTypeMarker r100) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        SimpleTypeMarker r101 = asSimpleType(r100);
        if (r101 != null) goto L6;
        r101 = lowerBoundIfFlexible(r100);
    L6:
        return typeConstructor(r101);
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.checker.ClassicTypeSystemContext, kotlin.reflect.jvm.internal.impl.types.model.TypeSystemContext
    public SimpleTypeMarker upperBound(FlexibleTypeMarker r100) {
        return ClassicTypeSystemContext.DefaultImpls.upperBound(this, r100);
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.model.TypeSystemContext
    public SimpleTypeMarker upperBoundIfFlexible(KotlinTypeMarker r100) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        FlexibleTypeMarker r101 = asFlexibleType(r100);
        if (r101 == null) goto L6;
        SimpleTypeMarker r102 = upperBound(r101);
        if (r102 == null) goto L6;
        return r102;
    L6:
        SimpleTypeMarker r103 = asSimpleType(r100);
        Intrinsics.checkNotNull(r103);
        return r103;
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.model.TypeSystemContext
    public TypeVariance getVariance(TypeParameterMarker r100) {
        return ClassicTypeSystemContext.DefaultImpls.getVariance(this, r100);
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.model.TypeSystemContext
    public boolean isMarkedNullable(SimpleTypeMarker r100) {
        return ClassicTypeSystemContext.DefaultImpls.isMarkedNullable(this, r100);
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.model.TypeSystemContext
    public CapturedTypeConstructorMarker typeConstructor(CapturedTypeMarker r100) {
        return ClassicTypeSystemContext.DefaultImpls.typeConstructor(this, r100);
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.checker.ClassicTypeSystemContext, kotlin.reflect.jvm.internal.impl.types.model.TypeSystemContext
    public TypeConstructorMarker typeConstructor(SimpleTypeMarker r100) {
        return ClassicTypeSystemContext.DefaultImpls.typeConstructor(this, r100);
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.model.TypeSystemContext
    public boolean areEqualTypeConstructors(TypeConstructorMarker r100, TypeConstructorMarker r101) {
        return ClassicTypeSystemContext.DefaultImpls.areEqualTypeConstructors(this, r100, r101);
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.model.TypeSystemContext
    public SimpleTypeMarker captureFromArguments(SimpleTypeMarker r100, CaptureStatus r101) {
        return ClassicTypeSystemContext.DefaultImpls.captureFromArguments(this, r100, r101);
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.checker.ClassicTypeSystemContext
    public KotlinTypeMarker createFlexibleType(SimpleTypeMarker r100, SimpleTypeMarker r101) {
        return ClassicTypeSystemContext.DefaultImpls.createFlexibleType(this, r100, r101);
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.model.TypeSystemContext
    public TypeArgumentMarker get(TypeArgumentListMarker r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        if ((r100 instanceof SimpleTypeMarker) == false) goto L6;
        return getArgument((KotlinTypeMarker) r100, r101);
    L6:
        if ((r100 instanceof ArgumentList) == false) goto L10;
        return ((ArgumentList) r100).get(r101);
    L10:
        throw new IllegalStateException(("unknown type argument list type: " + r100 + ", " + Reflection.getOrCreateKotlinClass(r100.getClass())).toString());
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.model.TypeSystemContext
    public TypeArgumentMarker getArgument(KotlinTypeMarker r100, int r101) {
        return ClassicTypeSystemContext.DefaultImpls.getArgument(this, r100, r101);
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.model.TypeSystemContext
    public TypeArgumentMarker getArgumentOrNull(SimpleTypeMarker r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        boolean r102 = false;
        if (r101 >= 0) goto L5;
    L7:
        if (r102 == true) goto L9;
        return null;
    L9:
        return getArgument(r100, r101);
    L5:
        if (r101 >= argumentsCount(r100)) goto L7;
        r102 = true;
        goto L7
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.model.TypeSystemContext
    public TypeParameterMarker getParameter(TypeConstructorMarker r100, int r101) {
        return ClassicTypeSystemContext.DefaultImpls.getParameter(this, r100, r101);
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.TypeSystemCommonBackendContext
    public boolean hasAnnotation(KotlinTypeMarker r100, FqName r101) {
        return ClassicTypeSystemContext.DefaultImpls.hasAnnotation(this, r100, r101);
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.model.TypeSystemContext
    public boolean hasRecursiveBounds(TypeParameterMarker r100, TypeConstructorMarker r101) {
        return ClassicTypeSystemContext.DefaultImpls.hasRecursiveBounds(this, r100, r101);
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.model.TypeSystemOptimizationContext
    public boolean identicalArguments(SimpleTypeMarker r100, SimpleTypeMarker r101) {
        return ClassicTypeSystemContext.DefaultImpls.identicalArguments(this, r100, r101);
    }

    public TypeCheckerState newTypeCheckerState(boolean r100, boolean r101) {
        return ClassicTypeSystemContext.DefaultImpls.newTypeCheckerState(this, r100, r101);
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.model.TypeSystemContext
    public KotlinTypeMarker withNullability(KotlinTypeMarker r100, boolean r101) {
        return ClassicTypeSystemContext.DefaultImpls.withNullability(this, r100, r101);
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.checker.ClassicTypeSystemContext, kotlin.reflect.jvm.internal.impl.types.model.TypeSystemContext
    public SimpleTypeMarker withNullability(SimpleTypeMarker r100, boolean r101) {
        return ClassicTypeSystemContext.DefaultImpls.withNullability(this, r100, r101);
    }
}
