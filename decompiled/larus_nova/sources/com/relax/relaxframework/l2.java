package com.relax.relaxframework;

import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes34.dex */
public final class l2<K, V> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Map<K, m2<K, V>> f405174a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public m2<K, V> f405175b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public m2<K, V> f405176c;

    public l2() {
        this.f405174a = new LinkedHashMap();
        this.f405175b = null;
        this.f405176c = null;
    }

    public final void a(m2<K, V> r100) {
        m2<K, V> r101 = r100.f405188c;
        if (r101 == null) goto L5;
        Intrinsics.checkNotNull(r101);
        r101.f405189d = r100.f405189d;
    L6:
        m2<K, V> r102 = r100.f405189d;
        if (r102 == null) goto L9;
        Intrinsics.checkNotNull(r102);
        r102.f405188c = r100.f405188c;
        return;
    L9:
        this.f405176c = r100.f405188c;
        return;
    L5:
        this.f405175b = r100.f405189d;
        goto L6
    }

    public boolean delete(K r100) {
        Map<K, m2<K, V>> r101 = this.f405174a;
        Map<K, m2<K, V>> r102 = null;
        if (r101 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("map");
        r101 = null;
    L5:
        m2<K, V> r103 = r101.get(r100);
        if (r103 == null) goto L13;
        a(r103);
        Map<K, m2<K, V>> r104 = this.f405174a;
        if (r104 != null) goto L10;
        Intrinsics.throwUninitializedPropertyAccessException("map");
    L11:
        com.bytedance.rts.foundation.m.delete(r102, r100);
        return true;
    L10:
        r102 = r104;
        goto L11
    L13:
        return false;
    }
}
