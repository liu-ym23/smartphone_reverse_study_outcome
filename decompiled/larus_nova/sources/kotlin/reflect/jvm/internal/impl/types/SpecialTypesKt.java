package kotlin.reflect.jvm.internal.impl.types;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.types.checker.NewCapturedType;

/* JADX INFO: loaded from: classes42.dex */
public final class SpecialTypesKt {
    public static final AbbreviatedType getAbbreviatedType(KotlinType r100) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        UnwrappedType r101 = r100.unwrap();
        if ((r101 instanceof AbbreviatedType) == true) goto L7;
        return null;
    L7:
        return (AbbreviatedType) r101;
    }

    public static final SimpleType getAbbreviation(KotlinType r100) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        AbbreviatedType r101 = getAbbreviatedType(r100);
        if (r101 != null) goto L7;
        return null;
    L7:
        return r101.getAbbreviation();
    }

    public static final boolean isDefinitelyNotNullType(KotlinType r100) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        return r100.unwrap() instanceof DefinitelyNotNullType;
    }

    private static final IntersectionTypeConstructor makeDefinitelyNotNullOrNotNull(IntersectionTypeConstructor r100) {
        Collection<KotlinType> r101 = r100.mo10733getSupertypes();
        ArrayList r102 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r101, 10));
        Iterator<T> r103 = r101.iterator();
        boolean r104 = false;
    L3:
        KotlinType r105 = null;
        if (r103.hasNext() == false) goto L9;
        KotlinType r106 = (KotlinType) r103.next();
        if (TypeUtils.isNullableType(r106) == false) goto L8;
        r106 = makeDefinitelyNotNullOrNotNull$default(r106.unwrap(), false, 1, null);
        r104 = true;
    L8:
        r102.add(r106);
        goto L3
    L9:
        if (r104 == false) goto L22;
        KotlinType r107 = r100.getAlternativeType();
        if (r107 == null) goto L18;
        if (TypeUtils.isNullableType(r107) == false) goto L16;
        r107 = makeDefinitelyNotNullOrNotNull$default(r107.unwrap(), false, 1, null);
    L16:
        r105 = r107;
    L18:
        return new IntersectionTypeConstructor(r102).setAlternative(r105);
    L22:
        return null;
    }

    private static final SimpleType makeIntersectionTypeDefinitelyNotNullOrNotNull(KotlinType r100) {
        TypeConstructor r101 = r100.getConstructor();
        if ((r101 instanceof IntersectionTypeConstructor) == false) goto L5;
        IntersectionTypeConstructor r102 = (IntersectionTypeConstructor) r101;
    L6:
        if (r102 != null) goto L8;
        return null;
    L8:
        IntersectionTypeConstructor r103 = makeDefinitelyNotNullOrNotNull(r102);
        if (r103 != null) goto L12;
        return null;
    L12:
        return r103.createType();
    L5:
        r102 = null;
        goto L6
    }

    public static final NewCapturedType withNotNullProjection(NewCapturedType r100) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        return new NewCapturedType(r100.getCaptureStatus(), r100.getConstructor(), r100.getLowerType(), r100.getAttributes(), r100.isMarkedNullable(), true);
    }

    public static final UnwrappedType makeDefinitelyNotNullOrNotNull(UnwrappedType r100, boolean r101) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        DefinitelyNotNullType r102 = DefinitelyNotNullType.Companion.makeDefinitelyNotNull$default(DefinitelyNotNullType.Companion, r100, r101, false, 4, null);
        if (r102 != null) goto L10;
        SimpleType r103 = makeIntersectionTypeDefinitelyNotNullOrNotNull(r100);
        if (r103 == null) goto L9;
        return r103;
    L9:
        return r100.makeNullableAsSpecified(false);
    L10:
        return r102;
    }

    public static final SimpleType makeSimpleTypeDefinitelyNotNullOrNotNull(SimpleType r100, boolean r101) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        DefinitelyNotNullType r102 = DefinitelyNotNullType.Companion.makeDefinitelyNotNull$default(DefinitelyNotNullType.Companion, r100, r101, false, 4, null);
        if (r102 != null) goto L10;
        SimpleType r103 = makeIntersectionTypeDefinitelyNotNullOrNotNull(r100);
        if (r103 == null) goto L8;
        return r103;
    L8:
        return r100.makeNullableAsSpecified(false);
    L10:
        return r102;
    }

    public static final SimpleType withAbbreviation(SimpleType r100, SimpleType r101) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        Intrinsics.checkNotNullParameter(r101, "abbreviatedType");
        if (KotlinTypeKt.isError(r100) == false) goto L6;
        return r100;
    L6:
        return new AbbreviatedType(r100, r101);
    }

    public static /* synthetic */ UnwrappedType makeDefinitelyNotNullOrNotNull$default(UnwrappedType r100, boolean r101, int r102, Object r103) {
        if ((r102 & 1) == 0) goto L6;
        r101 = false;
    L6:
        return makeDefinitelyNotNullOrNotNull(r100, r101);
    }

    public static /* synthetic */ SimpleType makeSimpleTypeDefinitelyNotNullOrNotNull$default(SimpleType r100, boolean r101, int r102, Object r103) {
        if ((r102 & 1) == 0) goto L6;
        r101 = false;
    L6:
        return makeSimpleTypeDefinitelyNotNullOrNotNull(r100, r101);
    }
}
