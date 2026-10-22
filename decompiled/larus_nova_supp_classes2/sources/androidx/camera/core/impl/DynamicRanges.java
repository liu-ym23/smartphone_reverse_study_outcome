package androidx.camera.core.impl;

import androidx.camera.core.DynamicRange;
import androidx.core.util.Preconditions;
import java.util.Iterator;
import java.util.Set;
import kotlin.Metadata;
import kotlin.collections.SetsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\"\n\u0002\b\u0005\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0018\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J\u0018\u0010\b\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J\u001e\u0010\t\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00060\u000bH\u0007J\u0018\u0010\f\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J*\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00060\u000b2\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00060\u000b2\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00060\u000bH\u0007¨\u0006\u0010"}, d2 = {"Landroidx/camera/core/impl/DynamicRanges;", "", "()V", "canMatchBitDepth", "", "dynamicRangeToTest", "Landroidx/camera/core/DynamicRange;", "fullySpecifiedDynamicRange", "canMatchEncoding", "canResolve", "fullySpecifiedDynamicRanges", "", "canResolveUnderSpecifiedTo", "underSpecifiedDynamicRange", "findAllPossibleMatches", "dynamicRangesToTest", "camera-core_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class DynamicRanges {
    public static final DynamicRanges INSTANCE = null;

    static {
        INSTANCE = new DynamicRanges();
    }

    private DynamicRanges() {
    }

    private final boolean canMatchBitDepth(DynamicRange r3, DynamicRange r4) {
        Preconditions.checkState(r4.isFullySpecified(), "Fully specified range is not actually fully specified.");
        if (r3.getBitDepth() != 0) goto L6;
        return true;
    L6:
        if (r3.getBitDepth() == r4.getBitDepth()) goto L11;
        return false;
    L11:
        return true;
    }

    private final boolean canMatchEncoding(DynamicRange r3, DynamicRange r4) {
        Preconditions.checkState(r4.isFullySpecified(), "Fully specified range is not actually fully specified.");
        int r5 = r3.getEncoding();
        if (r5 != 0) goto L5;
        return true;
    L5:
        int r6 = r4.getEncoding();
        if (r5 != 2) goto L9;
        if (r6 == 1) goto L9;
        return true;
    L9:
        if (r5 == r6) goto L14;
        return false;
    L14:
        return true;
    }

    @JvmStatic
    public static final boolean canResolve(DynamicRange r3, Set<DynamicRange> r4) {
        Intrinsics.checkNotNullParameter(r3, "dynamicRangeToTest");
        Intrinsics.checkNotNullParameter(r4, "fullySpecifiedDynamicRanges");
        if (r3.isFullySpecified() == true) goto L19;
        Iterator<T> r5 = r4.iterator();
    L7:
        if (r5.hasNext() == false) goto L11;
        Object r0 = r5.next();
        DynamicRanges r2 = INSTANCE;
        if (r2.canResolveUnderSpecifiedTo(r3, (DynamicRange) r0) == false) goto L7;
    L12:
        if (r0 == null) goto L14;
        return true;
    L14:
        return false;
    L11:
        r0 = null;
        goto L12
    L19:
        return r4.contains(r3);
    }

    private final boolean canResolveUnderSpecifiedTo(DynamicRange r2, DynamicRange r3) {
        if (canMatchBitDepth(r2, r3) == true) goto L5;
    L7:
        return false;
    L5:
        if (canMatchEncoding(r2, r3) == false) goto L7;
        return true;
    }

    @JvmStatic
    public static final Set<DynamicRange> findAllPossibleMatches(Set<DynamicRange> r5, Set<DynamicRange> r6) {
        Intrinsics.checkNotNullParameter(r5, "dynamicRangesToTest");
        Intrinsics.checkNotNullParameter(r6, "fullySpecifiedDynamicRanges");
        if (r5.isEmpty() == true) goto L21;
        Set r0 = SetsKt.createSetBuilder();
        Iterator<T> r7 = r5.iterator();
    L6:
        if (r7.hasNext() == false) goto L19;
        DynamicRange r1 = (DynamicRange) r7.next();
        if (r1.isFullySpecified() == true) goto L10;
        Iterator<T> r2 = r6.iterator();
    L14:
        if (r2.hasNext() == false) goto L6;
        DynamicRange r3 = (DynamicRange) r2.next();
        if (INSTANCE.canResolveUnderSpecifiedTo(r1, r3) == false) goto L14;
        r0.add(r3);
        goto L14
    L10:
        if (r6.contains(r1) == false) goto L6;
        r0.add(r1);
        goto L6
    L19:
        return SetsKt.build(r0);
    L21:
        throw new IllegalArgumentException("Candidate dynamic range set must contain at least 1 candidate dynamic range.");
    }
}
