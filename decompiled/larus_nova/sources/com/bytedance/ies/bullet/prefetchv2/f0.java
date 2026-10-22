package com.bytedance.ies.bullet.prefetchv2;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes19.dex */
public final class f0<K, V> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f247533a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Function2<K, V, Boolean> f247534b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Function2<K, V, Unit> f247535c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final LinkedHashMap<K, V> f247536d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f247537e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f247538f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f247539g;

    public final synchronized void d() {
        monitor-enter(this);
        Iterator<Map.Entry<K, V>> r100 = this.f247536d.entrySet().iterator();     // Catch: Throwable -> L12
    L5:
        if (r100.hasNext() == false) goto L10;
        Map.Entry<K, V> r101 = r100.next();     // Catch: Throwable -> L12
        if (this.f247534b.invoke(r101.getKey(), r101.getValue()).booleanValue() == false) goto L5;
        r100.remove();     // Catch: Throwable -> L12
        this.f247535c.invoke(r101.getKey(), r101.getValue());     // Catch: Throwable -> L12
        int r102 = this.f247537e;     // Catch: Throwable -> L12
        r101.getKey();     // Catch: Throwable -> L12
        r101.getValue();     // Catch: Throwable -> L12
        this.f247537e = r102 - 1;     // Catch: Throwable -> L12
        goto L5
    L10:
        monitor-exit(this);
        return;
    L12:
        th = move-exception;
        throw th;
    }

    public final synchronized String toString() {
        monitor-enter(this);
        int r100 = this.f247538f;     // Catch: Throwable -> L11
        int r101 = this.f247539g + r100;     // Catch: Throwable -> L11
        if (r101 == 0) goto L7;
        int r102 = (r100 * 100) / r101;     // Catch: Throwable -> L11
    L8:
        String r103 = "LruCache[maxSize=" + this.f247533a + ",hits=" + this.f247538f + ",misses=" + this.f247539g + ",hitRate=" + r102 + "%%]";     // Catch: Throwable -> L11
        monitor-exit(this);
        return r103;
    L7:
        r102 = 0;
    L11:
        th = move-exception;
        throw th;
    }

    public final V a(K r100) {
        monitor-enter(this);
        V r101 = this.f247536d.get(r100);     // Catch: Throwable -> L12
        if (r101 == null) goto L8;
        this.f247538f++;     // Catch: Throwable -> L12
        monitor-exit(this);
        return r101;
    L8:
        this.f247539g++;     // Catch: Throwable -> L12
        monitor-exit(this);
        return null;
    L12:
        th = move-exception;
        throw th;
    }

    public final V c(K r100) {
        monitor-enter(this);
        V r101 = this.f247536d.remove(r100);     // Catch: Throwable -> L9
        if (r101 == null) goto L6;
        this.f247537e--;     // Catch: Throwable -> L9
    L6:
        Unit r102 = Unit.INSTANCE;     // Catch: Throwable -> L9
        monitor-exit(this);
        return r101;
    L9:
        th = move-exception;
        throw th;
    }

    public final void e(int r100) {
    L2:
        monitor-enter(this);
    L22:
        th = move-exception;
        throw th;
    L4:
        if (this.f247537e < 0) goto L21;
        if (this.f247536d.isEmpty() == false) goto L10;
        if (this.f247537e != 0) goto L21;
    L10:
        if (this.f247537e <= r100) goto L11;
        Map.Entry r101 = (Map.Entry) CollectionsKt.firstOrNull(this.f247536d.entrySet());     // Catch: Throwable -> L22
        if (r101 == null) goto L15;
        Object r102 = r101.getKey();     // Catch: Throwable -> L22
        Object r103 = r101.getValue();     // Catch: Throwable -> L22
        LinkedHashMap<K, V> r104 = this.f247536d;     // Catch: Throwable -> L22
        Intrinsics.checkNotNull(r102);     // Catch: Throwable -> L22
        r104.remove(r102);     // Catch: Throwable -> L22
        int r105 = this.f247537e;     // Catch: Throwable -> L22
        Intrinsics.checkNotNull(r103);     // Catch: Throwable -> L22
        this.f247537e = r105 - 1;     // Catch: Throwable -> L22
        monitor-exit(this);
        goto L2
    L15:
        monitor-exit(this);
        return;
    L11:
        monitor-exit(this);
        return;
    L21:
        throw new IllegalStateException(f0.class.getName() + ".sizeOf() is reporting inconsistent results!");     // Catch: Throwable -> L22
    }

    public f0(Function2 r100, Function2 r101) {
        Intrinsics.checkNotNullParameter(r100, "expireRule");
        Intrinsics.checkNotNullParameter(r101, "onValueTrimmed");
        this.f247533a = 4;
        this.f247534b = r100;
        this.f247535c = r101;
        this.f247536d = new LinkedHashMap(0, 0.75f, true);
    }

    public final void b(Object r100, Object r101) {
        monitor-enter(this);
        this.f247537e++;     // Catch: Throwable -> L10
        if (this.f247536d.put(r100, r101) == null) goto L6;
        this.f247537e--;     // Catch: Throwable -> L10
    L6:
        Unit r102 = Unit.INSTANCE;     // Catch: Throwable -> L10
        monitor-exit(this);
        e(this.f247533a);
        return;
    L10:
        th = move-exception;
        throw th;
    }
}
