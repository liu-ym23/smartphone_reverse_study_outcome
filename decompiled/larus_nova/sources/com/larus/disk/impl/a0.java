package com.larus.disk.impl;

import java.util.Iterator;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: classes27.dex */
public final class a0 {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final /* synthetic */ int f330613d = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f330614a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Map<DiskFileType, Long> f330615b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f330616c;

    public static final class a {
    }

    static {
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof a0) == true) goto L8;
        return false;
    L8:
        a0 r101 = (a0) r100;
        if (Intrinsics.areEqual(this.f330614a, r101.f330614a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f330615b, r101.f330615b) == true) goto L15;
        return false;
    L15:
        if (this.f330616c == r101.f330616c) goto L17;
        return false;
    L17:
        return true;
    }

    public final int hashCode() {
        return (((this.f330614a.hashCode() * 31) + this.f330615b.hashCode()) * 31) + this.f330616c;
    }

    public final String toString() {
        return "DiskFileTypeSummary(status=" + this.f330614a + ", sizeBytes=" + this.f330615b + ", unreadablePathCount=" + this.f330616c + ')';
    }

    public final long a() {
        Iterator<T> r100 = this.f330615b.values().iterator();
        long r101 = 0;
    L4:
        if (r100.hasNext() == false) goto L9;
        long r102 = RangesKt.coerceAtLeast(((Number) r100.next()).longValue(), 0);
        if ((Long.MAX_VALUE - r101) < r102) goto L7;
        r101 = r101 + r102;
        goto L4
    L7:
        r101 = Long.MAX_VALUE;
        goto L4
    L9:
        return r101;
    }

    public final long b(DiskFileType r100) {
        Intrinsics.checkNotNullParameter(r100, "type");
        Long r101 = this.f330615b.get(r100);
        if (r101 != null) goto L7;
        return 0;
    L7:
        return r101.longValue();
    }

    public a0(String r100, Map<DiskFileType, Long> r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, "status");
        Intrinsics.checkNotNullParameter(r101, "sizeBytes");
        this.f330614a = r100;
        this.f330615b = r101;
        this.f330616c = r102;
    }
}
