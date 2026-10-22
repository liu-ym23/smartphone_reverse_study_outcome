package kotlin.reflect.jvm.internal.impl.types;

import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes42.dex */
public final class FlexibleTypesKt {
    public static final FlexibleType asFlexibleType(KotlinType r100) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        UnwrappedType r101 = r100.unwrap();
        Intrinsics.checkNotNull(r101, "null cannot be cast to non-null type org.jetbrains.kotlin.types.FlexibleType");
        return (FlexibleType) r101;
    }

    public static final boolean isFlexible(KotlinType r100) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        return r100.unwrap() instanceof FlexibleType;
    }

    public static final SimpleType lowerIfFlexible(KotlinType r100) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        UnwrappedType r101 = r100.unwrap();
        if ((r101 instanceof FlexibleType) == false) goto L6;
        return ((FlexibleType) r101).getLowerBound();
    L6:
        if ((r101 instanceof SimpleType) == false) goto L10;
        return (SimpleType) r101;
    L10:
        throw new NoWhenBranchMatchedException();
    }

    public static final SimpleType upperIfFlexible(KotlinType r100) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        UnwrappedType r101 = r100.unwrap();
        if ((r101 instanceof FlexibleType) == false) goto L6;
        return ((FlexibleType) r101).getUpperBound();
    L6:
        if ((r101 instanceof SimpleType) == false) goto L10;
        return (SimpleType) r101;
    L10:
        throw new NoWhenBranchMatchedException();
    }
}
