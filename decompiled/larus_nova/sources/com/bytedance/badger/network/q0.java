package com.bytedance.badger.network;

import com.bytedance.badger.collect.impl.constants.Constants;
import com.bytedance.badger.e;
import com.larus.apm.impl.protector.RunnableProtector;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Lazy;
import kotlin.jvm.functions.Function6;
import kotlin.reflect.KProperty;

/* JADX INFO: loaded from: classes47.dex */
public final class q0 implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ String f199140a;

    public q0(String r100) {
        this.f199140a = r100;
    }

    public final void a() {
        u0 r100 = u0.f199154h;
        String r101 = this.f199140a;
        r100.getClass();
        ConcurrentHashMap r102 = u0.f199149c;
        p0 r103 = (p0) r102.get(r101);
        if (r103 != null) goto L5;
        e.g("BadgerNetworkRetryHandler", "RetryTask not found: " + r101 + ", might be cancelled");
        return;
    L5:
        e.b("BadgerNetworkRetryHandler", "Executing retry: " + r101 + ", remaining: " + r103.f199134a.get());
        b0 r104 = u0.a(r103.f199135b);
        if (r104.f199082a == true) goto L8;
    L10:
        boolean r105 = false;
    L11:
        e0 r110 = new e0(r103.f199136c, r103.f199137d - r103.f199134a.get(), r103.f199134a.get());
        String r106 = "";
        if (r105 == false) goto L18;
        r102.remove(r101);
        u0.f199150d.remove(r101);
        String r107 = w.a(r104.f199084c, Constants.Keys.KEY_X_TT_LOGID, false);
        if (r107 == null) goto L16;
        r106 = r107;
    L16:
        e.f("BadgerNetworkRetryHandler", "Retry succeeded: " + r101);
        Function6 r108 = r103.f199138e;
        Boolean r109 = Boolean.TRUE;
    L21:
        r108.invoke(r109, r106, r103.f199135b, r104, r110, com.bytedance.badger.C.a.f199018b);
        return;
    L18:
        if (r103.f199134a.decrementAndGet() < 0) goto L20;
        long r111 = Math.max(1, r103.f199137d - r103.f199134a.get());
        Lazy r112 = u0.f199153g;
        KProperty r113 = u0.f199147a[2];
        long r114 = r111 * ((Number) r112.getValue()).longValue();
        e.g("BadgerNetworkRetryHandler", "Retry failed: " + r101 + ", will retry after " + r114 + "ms, remaining: " + r103.f199134a);
        u0.c(r101, r114);
        return;
    L20:
        r102.remove(r101);
        u0.f199150d.remove(r101);
        e.e("BadgerNetworkRetryHandler", "Retry exhausted: " + r101);
        r108 = r103.f199138e;
        r109 = Boolean.FALSE;
        goto L21
    L8:
        if (r104.f199083b != 200) goto L10;
        r105 = true;
        goto L11
    }

    @Override // java.lang.Runnable
    public final void run() {
        a();     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }
}
