package com.ss.android.lark.http.netstate;

import android.os.Handler;
import com.ss.android.lark.log.Log;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import com.ss.android.ugc.bytex.pthread.base.proxy.PthreadHandlerThreadV2;
import java.util.Collections;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes36.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public volatile NetworkUtils.NetworkType f425869a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final AtomicReference<Handler> f425870b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Set<com.ss.android.lark.http.netstate.a> f425871c;

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final c f425872a = null;

        static {
            f425872a = new c();
        }
    }

    public c() {
        this.f425870b = new AtomicReference(null);
        this.f425871c = Collections.newSetFromMap(new ConcurrentHashMap());
        this.f425869a = NetworkUtils.NetworkType.UNKNOWN;
    }

    public final void a(com.ss.android.lark.http.netstate.a r100) {
        if (r100 == null) goto L7;
        this.f425871c.add(r100);
        if (this.f425869a == NetworkUtils.NetworkType.UNKNOWN) goto L8;
        r100.a(this.f425869a);
        return;
    L8:
        return;
    }

    public final void b(final NetworkUtils.NetworkType r100) {
        Log.i("NetworkStateManager", "updateNetworkType new type:" + r100 + ", current type:" + this.f425869a);
        if (this.f425869a.getValue() == r100.getValue()) goto L5;
    L6:
        this.f425869a = r100;
        Handler r101 = this.f425870b.get();
        if (r101 != null) goto L19;
        PthreadHandlerThreadV2 r102 = new PthreadHandlerThreadV2("NetworkStateManager");
        ThreadMethodProxy.start(r102);
        Handler r103 = new Handler(r102.getLooper());
        AtomicReference<Handler> r104 = this.f425870b;
    L11:
        if (r104.compareAndSet(null, r103) == true) goto L12;
        if (r104.get() == null) goto L11;
        boolean r105 = false;
    L16:
        if (r105 == false) goto L18;
        Log.i("NetworkStateManager", "initHandlerThread done!");
        r101 = r103;
        goto L19
    L18:
        r102.quitSafely();
        r101 = this.f425870b.get();
        goto L19
    L12:
        r105 = true;
    L19:
        r101.post(new b(this, r100));
        return;
    L5:
        if (this.f425869a == NetworkUtils.NetworkType.UNKNOWN) goto L6;
    }
}
