package com.bytedance.forest.utils;

import com.bytedance.forest.model.Response;
import java.io.Closeable;
import java.util.HashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: classes3.dex */
public final class l implements Closeable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final com.bytedance.forest.model.k f244578a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f244579b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final f f244580c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Response f244581d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public g f244582e;

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
        f r100 = this.f244580c;
        if (r100 == null) goto L6;
        r100.close();
        return;
    }

    public final String toString() {
        return super.toString() + "(response=" + this.f244581d.p() + ", cacheSize=" + this.f244579b + ", buffer=" + this.f244578a + ", file=" + this.f244581d.f244318t + ')';
    }

    public l(Response r100, g r101) {
        this.f244581d = r100;
        this.f244582e = r101;
        com.bytedance.forest.model.k r102 = r100.f244306h;
        this.f244578a = r102;
        boolean r103 = true;
        if (r102 != null) goto L5;
    L7:
        String r104 = r100.f244318t;
        if (r104 == null) goto L10;
        int r105 = r104.length();
    L11:
        this.f244579b = r105;
        HashMap<String, CopyOnWriteArrayList<f>> r106 = MemoryManager.f244490d;
        if (r100.f244315q.getGeckoModel().f244348a.length() != 0) goto L14;
        boolean r107 = true;
    L15:
        if (r107 == false) goto L17;
    L33:
        f r108 = null;
    L34:
        this.f244580c = r108;
        return;
    L17:
        if (r100.f244315q.getGeckoModel().f244349b.length() == 0) goto L20;
        r103 = false;
    L20:
        if (r103 == true) goto L33;
        r108 = new f(this);
        HashMap<String, CopyOnWriteArrayList<f>> r109 = MemoryManager.f244490d;
        monitor-enter(r109);
        CopyOnWriteArrayList<f> r110 = r109.get(r108.f244546b);     // Catch: Throwable -> L30
        if (r110 != null) goto L28;
        r110 = new CopyOnWriteArrayList();     // Catch: Throwable -> L30
        r109.put(r108.f244546b, r110);     // Catch: Throwable -> L30
    L28:
        monitor-exit(r109);
        r110.add(r108);
    L30:
        th = move-exception;
        throw th;
    L14:
        r107 = false;
        goto L15
    L10:
        r105 = 1;
        goto L11
    L5:
        if (r102.isCacheProvided$forest_release() != true) goto L7;
        r105 = RangesKt.coerceAtLeast(r102.size(), 1);
        goto L11
    }
}
