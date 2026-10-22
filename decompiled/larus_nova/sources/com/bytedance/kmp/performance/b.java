package com.bytedance.kmp.performance;

import android.content.Context;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;

/* JADX INFO: loaded from: classes19.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final b f252707a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final s f252708b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static s f252709c;

    public b() {
    }

    public final Context getContext() {
        return null;
    }

    static {
        f252707a = new b();
        f252708b = new s(null);
    }

    public static s a() {
        s r100 = f252709c;
        if (r100 != null) goto L10;
        pd6.b r101 = pd6.c.f528682a;
        a r102 = (a) pd6.c.a(Reflection.getOrCreateKotlinClass(a.class));
        if (r102 == null) goto L7;
        r100 = r102.getConfig();
    L8:
        if (r100 != null) goto L10;
        r100 = f252708b;
        goto L10
    L7:
        r100 = null;
    L10:
        Intrinsics.checkNotNullParameter(r100, "config");
        f252709c = r100;
        return r100;
    }
}
