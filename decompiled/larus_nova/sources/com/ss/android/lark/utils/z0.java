package com.ss.android.lark.utils;

import android.text.TextUtils;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes38.dex */
public final class z0<K, V> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final a<K> f444794a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ConcurrentHashMap<V, K> f444795b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final ConcurrentHashMap<K, V> f444796c;

    public interface a<K> {
    }

    public z0(b1c.c.a r100) {
        Intrinsics.checkNotNullParameter(r100, "fixStrategy");
        this.f444794a = r100;
        this.f444795b = new ConcurrentHashMap(25);
        this.f444796c = new ConcurrentHashMap(25);
    }

    public final void a(b1c.c.b r100, Object r101) {
        Intrinsics.checkNotNullParameter(r100, "key");
        Intrinsics.checkNotNullParameter(r101, "value");
        b1c.c.a r102 = (b1c.c.a) this.f444794a;
        r102.getClass();
        if (TextUtils.equals(r102.f16971a, r100.f16973a) == false) goto L5;
    L8:
        boolean r103 = true;
    L9:
        if (r103 == false) goto L12;
        this.f444796c.put(r100, r101);
        this.f444795b.put(r101, r100);
        return;
    L12:
        return;
    L5:
        if (TextUtils.equals(r102.f16972b, r100.f16973a) == true) goto L8;
        r103 = false;
        goto L9
    }
}
