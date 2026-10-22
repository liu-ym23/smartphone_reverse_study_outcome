package com.bytedance.gkfs.io;

import com.bytedance.gkfs.storage.GkFSChunkStorageInfo;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: classes19.dex */
public final class e {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final e f245196d = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Map<c, Long> f245197a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Map<c, Long> f245198b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Map<c, GkFSChunkStorageInfo> f245199c;

    public static final class a {
    }

    public e() {
        this(0);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof e) == false) goto L10;
        e r101 = (e) r100;
        if (Intrinsics.areEqual(this.f245198b, r101.f245198b) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.f245199c, r101.f245199c) == true) goto L16;
        return false;
    L16:
        return true;
    L10:
        return false;
    }

    public final int hashCode() {
        Map<c, Long> r100 = this.f245198b;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        Map<c, GkFSChunkStorageInfo> r104 = this.f245199c;
        if (r104 == null) goto L10;
        r101 = r104.hashCode();
    L10:
        return r103 + r101;
    L5:
        r102 = 0;
        goto L6
    }

    static {
        f245196d = new e(0);
    }

    public final String toString() {
        return "GkFSChunkIOStatistics(timeCost=" + this.f245198b + ", storageCost=" + this.f245199c + ", indexTimeCost=" + this.f245197a + ')';
    }

    public /* synthetic */ e(int r100) {
        this(MapsKt.emptyMap(), MapsKt.emptyMap());
    }

    public e(Map<c, Long> r100, Map<c, GkFSChunkStorageInfo> r101) {
        this.f245198b = r100;
        this.f245199c = r101;
        Set<Map.Entry<c, GkFSChunkStorageInfo>> r102 = r101.entrySet();
        LinkedHashMap r103 = new LinkedHashMap(RangesKt.coerceAtLeast(MapsKt.mapCapacity(CollectionsKt.collectionSizeOrDefault(r102, 10)), 16));
        Iterator<T> r104 = r102.iterator();
    L4:
        if (r104.hasNext() == false) goto L6;
        Map.Entry r105 = (Map.Entry) r104.next();
        Pair r106 = TuplesKt.to(r105.getKey(), Long.valueOf(((GkFSChunkStorageInfo) r105.getValue()).f245289d.f245261g));
        r103.put(r106.getFirst(), r106.getSecond());
        goto L4
    L6:
        this.f245197a = r103;
    }
}
