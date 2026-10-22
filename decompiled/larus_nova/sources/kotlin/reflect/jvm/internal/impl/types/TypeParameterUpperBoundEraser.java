package kotlin.reflect.jvm.internal.impl.types;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Set;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.storage.LockBasedStorageManager;
import kotlin.reflect.jvm.internal.impl.storage.MemoizedFunctionToNotNull;
import kotlin.reflect.jvm.internal.impl.types.checker.IntersectionTypeKt;
import kotlin.reflect.jvm.internal.impl.types.error.ErrorType;
import kotlin.reflect.jvm.internal.impl.types.error.ErrorTypeKind;
import kotlin.reflect.jvm.internal.impl.types.error.ErrorUtils;
import kotlin.reflect.jvm.internal.impl.types.typeUtil.TypeUtilsKt;

/* JADX INFO: loaded from: classes5.dex */
public final class TypeParameterUpperBoundEraser {
    public static final Companion Companion = null;
    private final Lazy erroneousErasedBound$delegate;
    private final MemoizedFunctionToNotNull<DataToEraseUpperBound, KotlinType> getErasedUpperBound;
    private final TypeParameterErasureOptions options;
    private final ErasureProjectionComputer projectionComputer;
    private final LockBasedStorageManager storage;

    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r100) {
            this();
        }

        public final KotlinType replaceArgumentsOfUpperBound(KotlinType r110, TypeSubstitutor r111, Set<? extends TypeParameterDescriptor> r112, boolean r210) {
            Intrinsics.checkNotNullParameter(r110, "<this>");
            Intrinsics.checkNotNullParameter(r111, "substitutor");
            UnwrappedType r100 = r110.unwrap();
            if ((r100 instanceof FlexibleType) == false) goto L68;
            FlexibleType r101 = (FlexibleType) r100;
            SimpleType r113 = r101.getLowerBound();
            if (r113.getConstructor().getParameters().isEmpty() == false) goto L7;
        L35:
            SimpleType r102 = r101.getUpperBound();
            if (r102.getConstructor().getParameters().isEmpty() == false) goto L38;
        L66:
            UnwrappedType r103 = KotlinTypeFactory.flexibleType(r113, r102);
        L102:
            return r111.safeSubstitute(TypeWithEnhancementKt.inheritEnhancement(r103, r100), Variance.OUT_VARIANCE);
        L38:
            if (r102.getConstructor().mo10732getDeclarationDescriptor() == null) goto L66;
            List<TypeParameterDescriptor> r104 = r102.getConstructor().getParameters();
            ArrayList r114 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r104, 10));
            Iterator<T> r105 = r104.iterator();
        L42:
            if (r105.hasNext() == false) goto L65;
            TypeParameterDescriptor r106 = (TypeParameterDescriptor) r105.next();
            TypeProjection r115 = (TypeProjection) CollectionsKt.getOrNull(r110.getArguments(), r106.getIndex());
            if (r210 == false) goto L54;
            if (r115 == null) goto L51;
            KotlinType r116 = r115.getType();
            if (r116 == null) goto L51;
            if (TypeUtilsKt.containsTypeParameter(r116) == true) goto L51;
            boolean r117 = true;
        L52:
            if (r117 == false) goto L54;
        L64:
            r114.add(r115);
        L51:
            r117 = false;
        L54:
            if (r112 != null) goto L56;
        L58:
            boolean r118 = false;
        L59:
            if (r115 == null) goto L63;
            if (r118 == true) goto L63;
            if (r111.getSubstitution().mo10737get(r115.getType()) != null) goto L64;
        L63:
            r115 = new StarProjectionImpl(r106);
            goto L64
        L56:
            if (r112.contains(r106) == false) goto L58;
            r118 = true;
            goto L59
        L65:
            r102 = TypeSubstitutionKt.replace$default(r102, r114, null, 2, null);
            goto L66
        L7:
            if (r113.getConstructor().mo10732getDeclarationDescriptor() == null) goto L35;
            List<TypeParameterDescriptor> r119 = r113.getConstructor().getParameters();
            ArrayList r120 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r119, 10));
            Iterator<T> r121 = r119.iterator();
        L11:
            if (r121.hasNext() == false) goto L34;
            TypeParameterDescriptor r122 = (TypeParameterDescriptor) r121.next();
            TypeProjection r123 = (TypeProjection) CollectionsKt.getOrNull(r110.getArguments(), r122.getIndex());
            if (r210 == false) goto L23;
            if (r123 == null) goto L20;
            KotlinType r124 = r123.getType();
            if (r124 == null) goto L20;
            if (TypeUtilsKt.containsTypeParameter(r124) == true) goto L20;
            boolean r125 = true;
        L21:
            if (r125 == false) goto L23;
        L33:
            r120.add(r123);
        L20:
            r125 = false;
        L23:
            if (r112 != null) goto L25;
        L27:
            boolean r126 = false;
        L28:
            if (r123 == null) goto L32;
            if (r126 == true) goto L32;
            if (r111.getSubstitution().mo10737get(r123.getType()) != null) goto L33;
        L32:
            r123 = new StarProjectionImpl(r122);
            goto L33
        L25:
            if (r112.contains(r122) == false) goto L27;
            r126 = true;
            goto L28
        L34:
            r113 = TypeSubstitutionKt.replace$default(r113, r120, null, 2, null);
            goto L35
        L68:
            if ((r100 instanceof SimpleType) == false) goto L104;
            SimpleType r107 = (SimpleType) r100;
            if (r107.getConstructor().getParameters().isEmpty() == false) goto L72;
        L100:
            r103 = r107;
            goto L102
        L72:
            if (r107.getConstructor().mo10732getDeclarationDescriptor() == null) goto L100;
            List<TypeParameterDescriptor> r108 = r107.getConstructor().getParameters();
            ArrayList r127 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r108, 10));
            Iterator<T> r109 = r108.iterator();
        L76:
            if (r109.hasNext() == false) goto L99;
            TypeParameterDescriptor r128 = (TypeParameterDescriptor) r109.next();
            TypeProjection r129 = (TypeProjection) CollectionsKt.getOrNull(r110.getArguments(), r128.getIndex());
            if (r210 == false) goto L88;
            if (r129 == null) goto L85;
            KotlinType r130 = r129.getType();
            if (r130 == null) goto L85;
            if (TypeUtilsKt.containsTypeParameter(r130) == true) goto L85;
            boolean r131 = true;
        L86:
            if (r131 == false) goto L88;
        L98:
            r127.add(r129);
        L85:
            r131 = false;
        L88:
            if (r112 != null) goto L90;
        L92:
            boolean r132 = false;
        L93:
            if (r129 == null) goto L97;
            if (r132 == true) goto L97;
            if (r111.getSubstitution().mo10737get(r129.getType()) != null) goto L98;
        L97:
            r129 = new StarProjectionImpl(r128);
            goto L98
        L90:
            if (r112.contains(r128) == false) goto L92;
            r132 = true;
            goto L93
        L99:
            r103 = TypeSubstitutionKt.replace$default(r107, r127, null, 2, null);
            goto L102
        L104:
            throw new NoWhenBranchMatchedException();
        }
    }

    /* JADX INFO: loaded from: classes42.dex */
    public static final class DataToEraseUpperBound {
        private final ErasureTypeAttributes typeAttr;
        private final TypeParameterDescriptor typeParameter;

        public String toString() {
            return "DataToEraseUpperBound(typeParameter=" + this.typeParameter + ", typeAttr=" + this.typeAttr + ')';
        }

        public int hashCode() {
            int r100 = this.typeParameter.hashCode();
            return r100 + ((r100 * 31) + this.typeAttr.hashCode());
        }

        public final ErasureTypeAttributes getTypeAttr() {
            return this.typeAttr;
        }

        public final TypeParameterDescriptor getTypeParameter() {
            return this.typeParameter;
        }

        public boolean equals(Object r100) {
            if ((r100 instanceof DataToEraseUpperBound) == true) goto L5;
            return false;
        L5:
            DataToEraseUpperBound r101 = (DataToEraseUpperBound) r100;
            if (Intrinsics.areEqual(r101.typeParameter, this.typeParameter) == true) goto L8;
            return false;
        L8:
            if (Intrinsics.areEqual(r101.typeAttr, this.typeAttr) == false) goto L12;
            return true;
        L12:
            return false;
        }

        public DataToEraseUpperBound(TypeParameterDescriptor r100, ErasureTypeAttributes r101) {
            Intrinsics.checkNotNullParameter(r100, "typeParameter");
            Intrinsics.checkNotNullParameter(r101, "typeAttr");
            this.typeParameter = r100;
            this.typeAttr = r101;
        }
    }

    static {
        Companion = new Companion(null);
    }

    public static /* synthetic */ ErrorType accessor$TypeParameterUpperBoundEraser$lambda0(TypeParameterUpperBoundEraser r100) {
        return erroneousErasedBound_delegate$lambda$0(r100);
    }

    public static /* synthetic */ KotlinType accessor$TypeParameterUpperBoundEraser$lambda1(TypeParameterUpperBoundEraser r100, DataToEraseUpperBound r101) {
        return getErasedUpperBound$lambda$2(r100, r101);
    }

    private final ErrorType getErroneousErasedBound() {
        return (ErrorType) this.erroneousErasedBound$delegate.getValue();
    }

    private static final ErrorType erroneousErasedBound_delegate$lambda$0(TypeParameterUpperBoundEraser r100) {
        Intrinsics.checkNotNullParameter(r100, "this$0");
        return ErrorUtils.createErrorType(ErrorTypeKind.CANNOT_COMPUTE_ERASED_BOUND, new String[]{r100.toString()});
    }

    private final KotlinType getDefaultType(ErasureTypeAttributes r100) {
        SimpleType r101 = r100.getDefaultType();
        if (r101 == null) goto L7;
        KotlinType r102 = TypeUtilsKt.replaceArgumentsWithStarProjections(r101);
        if (r102 == null) goto L7;
        return r102;
    L7:
        return getErroneousErasedBound();
    }

    public TypeParameterUpperBoundEraser(ErasureProjectionComputer r100, TypeParameterErasureOptions r101) {
        Intrinsics.checkNotNullParameter(r100, "projectionComputer");
        Intrinsics.checkNotNullParameter(r101, "options");
        this.projectionComputer = r100;
        this.options = r101;
        LockBasedStorageManager r102 = new LockBasedStorageManager("Type parameter upper bound erasure results");
        this.storage = r102;
        this.erroneousErasedBound$delegate = LazyKt.lazy(new TypeParameterUpperBoundEraser$$Lambda$0(this));
        this.getErasedUpperBound = r102.createMemoizedFunction(new TypeParameterUpperBoundEraser$$Lambda$1(this));
    }

    private static final KotlinType getErasedUpperBound$lambda$2(TypeParameterUpperBoundEraser r100, DataToEraseUpperBound r101) {
        Intrinsics.checkNotNullParameter(r100, "this$0");
        return r100.getErasedUpperBoundInternal(r101.getTypeParameter(), r101.getTypeAttr());
    }

    private final KotlinType getErasedUpperBoundInternal(TypeParameterDescriptor r100, ErasureTypeAttributes r101) {
        Set<TypeParameterDescriptor> r102 = r101.getVisitedTypeParameters();
        if (r102 != null) goto L5;
    L8:
        Set<TypeParameterDescriptor> r103 = TypeUtilsKt.extractTypeParametersFromUpperBounds(r100.getDefaultType(), r102);
        LinkedHashMap r104 = new LinkedHashMap(RangesKt.coerceAtLeast(MapsKt.mapCapacity(CollectionsKt.collectionSizeOrDefault(r103, 10)), 16));
        Iterator<T> r105 = r103.iterator();
    L10:
        if (r105.hasNext() == false) goto L19;
        TypeParameterDescriptor r106 = (TypeParameterDescriptor) r105.next();
        if (r102 != null) goto L14;
    L17:
        TypeProjection r107 = this.projectionComputer.computeProjection(r106, r101, this, getErasedUpperBound(r106, r101.withNewVisitedTypeParameter(r100)));
    L18:
        Pair r108 = TuplesKt.to(r106.getTypeConstructor(), r107);
        r104.put(r108.getFirst(), r108.getSecond());
        goto L10
    L14:
        if (r102.contains(r106) == false) goto L17;
        r107 = TypeUtils.makeStarProjection(r106, r101);
        goto L18
    L19:
        boolean r109 = false;
        Set<KotlinType> r110 = substituteErasedUpperBounds(TypeSubstitutor.create(TypeConstructorSubstitution.Companion.createByConstructorsMap$default(TypeConstructorSubstitution.Companion, r104, false, 2, null)), r100.getUpperBounds(), r101);
        if ((!r110.isEmpty()) == false) goto L38;
        if (this.options.getIntersectUpperBounds() == false) goto L24;
        List r111 = CollectionsKt.toList(r110);
        ArrayList r112 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r111, 10));
        Iterator r113 = r111.iterator();
    L33:
        if (r113.hasNext() == false) goto L36;
        r112.add(((KotlinType) r113.next()).unwrap());
        goto L33
    L36:
        return IntersectionTypeKt.intersectTypes(r112);
    L24:
        if (r110.size() != 1) goto L26;
        r109 = true;
    L26:
        if (r109 == false) goto L30;
        return (KotlinType) CollectionsKt.single(r110);
    L30:
        throw new IllegalArgumentException("Should only be one computed upper bound if no need to intersect all bounds".toString());
    L38:
        return getDefaultType(r101);
    L5:
        if (r102.contains(r100.getOriginal()) == false) goto L8;
        return getDefaultType(r101);
    }

    public final KotlinType getErasedUpperBound(TypeParameterDescriptor r100, ErasureTypeAttributes r101) {
        Intrinsics.checkNotNullParameter(r100, "typeParameter");
        Intrinsics.checkNotNullParameter(r101, "typeAttr");
        return this.getErasedUpperBound.invoke(new DataToEraseUpperBound(r100, r101));
    }

    private final Set<KotlinType> substituteErasedUpperBounds(TypeSubstitutor r100, List<? extends KotlinType> r101, ErasureTypeAttributes r102) {
        Set r103 = SetsKt.createSetBuilder();
        Iterator<? extends KotlinType> r104 = r101.iterator();
    L4:
        if (r104.hasNext() == false) goto L21;
        KotlinType r105 = r104.next();
        ClassifierDescriptor r106 = r105.getConstructor().mo10732getDeclarationDescriptor();
        if ((r106 instanceof ClassDescriptor) == false) goto L9;
        r103.add(Companion.replaceArgumentsOfUpperBound(r105, r100, r102.getVisitedTypeParameters(), this.options.getLeaveNonTypeParameterTypes()));
    L19:
        if (this.options.getIntersectUpperBounds() == true) goto L4;
    L9:
        if ((r106 instanceof TypeParameterDescriptor) == false) goto L19;
        Set<TypeParameterDescriptor> r107 = r102.getVisitedTypeParameters();
        boolean r108 = false;
        if (r107 != null) goto L13;
    L15:
        if (r108 == false) goto L17;
        r103.add(getDefaultType(r102));
        goto L19
    L17:
        r103.addAll(substituteErasedUpperBounds(r100, ((TypeParameterDescriptor) r106).getUpperBounds(), r102));
        goto L19
    L13:
        if (r107.contains(r106) != true) goto L15;
        r108 = true;
    L21:
        return SetsKt.build(r103);
    }

    public /* synthetic */ TypeParameterUpperBoundEraser(ErasureProjectionComputer r100, TypeParameterErasureOptions r101, int r102, DefaultConstructorMarker r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = new TypeParameterErasureOptions(false, false);
    L5:
        this(r100, r101);
    }
}
