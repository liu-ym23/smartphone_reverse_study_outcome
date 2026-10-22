package com.bytedance.pia.core.setting;

import android.content.Context;
import com.larus.apm.impl.protector.RunnableProtector;
import java.util.Map;
import kotlin.Lazy;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;

/* JADX INFO: loaded from: classes21.dex */
public final class c implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final c f266298a = null;

    static {
        f266298a = new c();
    }

    public c() {
    }

    @Override // java.lang.Runnable
    public final void run() {
        g.f266303a.getClass();     // Catch: Throwable -> L18
        Lazy<Settings> r100 = Settings.f266286f;     // Catch: Throwable -> L18
        b r101 = Settings.a.d();     // Catch: Throwable -> L18
        if (r101 == null) goto L7;
        Long r102 = r101.d();     // Catch: Throwable -> L18
        if (r102 == null) goto L7;
        long r103 = r102.longValue();     // Catch: Throwable -> L18
    L8:
        b r104 = Settings.a.d();     // Catch: Throwable -> L18
        if (r104 == null) goto L12;
        Map<String, String> r105 = r104.c();     // Catch: Throwable -> L18
        if (r105 == null) goto L12;
    L13:
        Context r106 = c47.c.a.f22405a;     // Catch: Throwable -> L18
        if (r103 <= 0) goto L21;
        if (r105 == null) goto L25;
        r105.isEmpty();     // Catch: Throwable -> L18
        return;
    L25:
        return;
    L21:
        return;
    L12:
        r105 = MapsKt.mapOf(TuplesKt.to("https://pia-demo-est.gf.bytedance.net/index", "pia_test"));     // Catch: Throwable -> L18
    L7:
        r103 = 1000;
    L18:
        th = move-exception;
        if (RunnableProtector.intercept(th) == true) goto L26;
        throw th;
    }
}
