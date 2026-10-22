package com.bytedance.live.richcontent.resource.cache;

import com.huawei.hms.framework.common.ContainerUtils;
import java.util.LinkedHashMap;
import java.util.Locale;
import java.util.Map;

/* JADX INFO: loaded from: classes19.dex */
public class a<K, V> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final LinkedHashMap<K, V> f255778a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f255779b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f255780c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f255781d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f255782e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f255783f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f255784g;

    public final synchronized int a() {
        monitor-enter(this);
        int r100 = this.f255782e;     // Catch: Throwable -> L6
        monitor-exit(this);
        return r100;
    L6:
        th = move-exception;
        throw th;
    }

    public final synchronized int b() {
        monitor-enter(this);
        int r100 = this.f255783f;     // Catch: Throwable -> L6
        monitor-exit(this);
        return r100;
    L6:
        th = move-exception;
        throw th;
    }

    public final synchronized int c() {
        monitor-enter(this);
        int r100 = this.f255784g;     // Catch: Throwable -> L6
        monitor-exit(this);
        return r100;
    L6:
        th = move-exception;
        throw th;
    }

    public final synchronized int d() {
        monitor-enter(this);
        int r100 = this.f255781d;     // Catch: Throwable -> L6
        monitor-exit(this);
        return r100;
    L6:
        th = move-exception;
        throw th;
    }

    public final synchronized int f() {
        monitor-enter(this);
        int r100 = this.f255779b;     // Catch: Throwable -> L6
        monitor-exit(this);
        return r100;
    L6:
        th = move-exception;
        throw th;
    }

    public int g(Object r100) {
        throw null;
    }

    public final synchronized String toString() {
        monitor-enter(this);
        int r100 = this.f255783f;     // Catch: Throwable -> L10
        int r101 = this.f255784g + r100;     // Catch: Throwable -> L10
        if (r101 == 0) goto L6;
        int r102 = (r100 * 100) / r101;     // Catch: Throwable -> L10
    L7:
        String r103 = String.format(Locale.US, "LruCache[maxSize=%d,hits=%d,misses=%d,hitRate=%d%%]", new Object[]{Integer.valueOf(this.f255780c), Integer.valueOf(this.f255783f), Integer.valueOf(this.f255784g), Integer.valueOf(r102)});     // Catch: Throwable -> L10
        monitor-exit(this);
        return r103;
    L6:
        r102 = 0;
    L10:
        th = move-exception;
        throw th;
    }

    public a(int r100) {
        if (r100 <= 0) goto L7;
        this.f255780c = r100;
        this.f255778a = new LinkedHashMap(0, 0.75f, true);
        return;
    L7:
        throw new IllegalArgumentException("maxSize <= 0");
    }

    public final void h(int r100) {
    L2:
        monitor-enter(this);
    L21:
        th = move-exception;
        throw th;
    L4:
        if (this.f255779b < 0) goto L20;
        if (this.f255778a.isEmpty() == false) goto L10;
        if (this.f255779b != 0) goto L20;
    L10:
        if (this.f255779b <= r100) goto L17;
        if (this.f255778a.isEmpty() == true) goto L17;
        Map.Entry<K, V> r101 = this.f255778a.entrySet().iterator().next();     // Catch: Throwable -> L21
        K r102 = r101.getKey();     // Catch: Throwable -> L21
        V r103 = r101.getValue();     // Catch: Throwable -> L21
        this.f255778a.remove(r102);     // Catch: Throwable -> L21
        this.f255779b -= e(r102, r103);     // Catch: Throwable -> L21
        this.f255782e++;     // Catch: Throwable -> L21
        monitor-exit(this);     // Catch: Throwable -> L21
    L17:
        monitor-exit(this);     // Catch: Throwable -> L21
        return;
    L20:
        throw new IllegalStateException(getClass().getName() + ".sizeOf() is reporting inconsistent results!");     // Catch: Throwable -> L21
    }

    public final int e(K r100, V r101) {
        int r102 = g(r101);
        if (r102 < 0) goto L6;
        return r102;
    L6:
        throw new IllegalStateException("Negative size: " + r100 + ContainerUtils.KEY_VALUE_DELIMITER + r101);
    }
}
