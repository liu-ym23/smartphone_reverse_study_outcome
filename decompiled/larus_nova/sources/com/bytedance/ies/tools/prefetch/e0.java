package com.bytedance.ies.tools.prefetch;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: classes19.dex */
public final class e0<K, V> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final LinkedHashMap<K, V> f248812a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f248813b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f248814c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f248815d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final int f248816e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Function2<K, V, Boolean> f248817f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final Function2<K, V, Unit> f248818g;

    public final synchronized void d() {
        monitor-enter(this);
        k r100 = p.f248826a;     // Catch: Throwable -> L13
        p.b("Start trimming, entry count: " + this.f248812a.size() + '.');     // Catch: Throwable -> L13
        Iterator<Map.Entry<K, V>> r101 = this.f248812a.entrySet().iterator();     // Catch: Throwable -> L13
    L6:
        if (r101.hasNext() == false) goto L11;
        Map.Entry<K, V> r102 = r101.next();     // Catch: Throwable -> L13
        if (this.f248817f.invoke(r102.getKey(), r102.getValue()).booleanValue() == false) goto L6;
        r101.remove();     // Catch: Throwable -> L13
        this.f248818g.invoke(r102.getKey(), r102.getValue());     // Catch: Throwable -> L13
        int r103 = this.f248813b;     // Catch: Throwable -> L13
        r102.getKey();     // Catch: Throwable -> L13
        r102.getValue();     // Catch: Throwable -> L13
        this.f248813b = r103 - 1;     // Catch: Throwable -> L13
        k r104 = p.f248826a;     // Catch: Throwable -> L13
        p.b("Entry removed: " + r102.getKey() + '.');     // Catch: Throwable -> L13
        goto L6
    L11:
        monitor-exit(this);
        return;
    L13:
        th = move-exception;
        throw th;
    }

    public final synchronized String toString() {
        monitor-enter(this);
        int r100 = this.f248814c;     // Catch: Throwable -> L11
        int r101 = this.f248815d + r100;     // Catch: Throwable -> L11
        if (r101 == 0) goto L7;
        int r102 = (r100 * 100) / r101;     // Catch: Throwable -> L11
    L8:
        String r103 = "LruCache[maxSize=" + this.f248816e + ",hits=" + this.f248814c + ",misses=" + this.f248815d + ",hitRate=" + r102 + "%%]";     // Catch: Throwable -> L11
        monitor-exit(this);
        return r103;
    L7:
        r102 = 0;
    L11:
        th = move-exception;
        throw th;
    }

    /* JADX WARN: Type inference failed for: r3v2, types: [T, V, java.lang.Object] */
    public final V a(K r100) {
        Ref.ObjectRef r101 = new Ref.ObjectRef();
        monitor-enter(this);
        V r102 = this.f248812a.get(r100);     // Catch: Throwable -> L13
        r101.element = r102;     // Catch: Throwable -> L13
        if (r102 == 0) goto L9;
        this.f248814c++;     // Catch: Throwable -> L13
        monitor-exit(this);
        return r102;
    L9:
        this.f248815d++;     // Catch: Throwable -> L13
        monitor-exit(this);
        return null;
    L13:
        th = move-exception;
        throw th;
    }

    public final void b(Object r100) {
        Ref.ObjectRef r101 = new Ref.ObjectRef();
        monitor-enter(this);
        V r102 = this.f248812a.remove(r100);     // Catch: Throwable -> L10
        r101.element = r102;     // Catch: Throwable -> L10
        if (r102 == 0) goto L7;
        this.f248813b--;     // Catch: Throwable -> L10
    L7:
        Unit r103 = Unit.INSTANCE;     // Catch: Throwable -> L10
        monitor-exit(this);
        return;
    L10:
        th = move-exception;
        throw th;
    }

    public final void e(int r100) {
    L2:
        monitor-enter(this);
    L28:
        th = move-exception;
        throw th;
    L4:
        if (this.f248813b < 0) goto L27;
        if (this.f248812a.isEmpty() == false) goto L10;
        if (this.f248813b != 0) goto L27;
    L10:
        if (this.f248813b <= r100) goto L11;
        Map.Entry r101 = (Map.Entry) CollectionsKt.firstOrNull(this.f248812a.entrySet());     // Catch: Throwable -> L28
        if (r101 == null) goto L24;
        Object r102 = r101.getKey();     // Catch: Throwable -> L28
        Object r103 = r101.getValue();     // Catch: Throwable -> L28
        LinkedHashMap<K, V> r104 = this.f248812a;     // Catch: Throwable -> L28
        if (r102 != null) goto L18;
        Intrinsics.throwNpe();     // Catch: Throwable -> L28
    L18:
        r104.remove(r102);     // Catch: Throwable -> L28
        int r105 = this.f248813b;     // Catch: Throwable -> L28
        if (r103 != null) goto L21;
        Intrinsics.throwNpe();     // Catch: Throwable -> L28
    L21:
        this.f248813b = r105 - 1;     // Catch: Throwable -> L28
        monitor-exit(this);
        goto L2
    L24:
        monitor-exit(this);
        return;
    L11:
        monitor-exit(this);
        return;
    L27:
        throw new IllegalStateException(e0.class.getName() + ".sizeOf() is reporting inconsistent results!");     // Catch: Throwable -> L28
    }

    public e0(Function2 r100, Function2 r101) {
        this.f248816e = 32;
        this.f248817f = r100;
        this.f248818g = r101;
        this.f248812a = new LinkedHashMap(0, 0.75f, true);
    }

    public final void c(K r100, V r101) {
        Ref.ObjectRef r102 = new Ref.ObjectRef();
        monitor-enter(this);
        this.f248813b++;     // Catch: Throwable -> L11
        V r103 = this.f248812a.put(r100, r101);     // Catch: Throwable -> L11
        r102.element = r103;     // Catch: Throwable -> L11
        if (r103 == 0) goto L7;
        this.f248813b--;     // Catch: Throwable -> L11
    L7:
        Unit r104 = Unit.INSTANCE;     // Catch: Throwable -> L11
        monitor-exit(this);
        e(this.f248816e);
        return;
    L11:
        th = move-exception;
        throw th;
    }
}
