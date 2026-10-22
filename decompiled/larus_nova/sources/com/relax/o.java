package com.relax;

import android.os.Handler;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import com.ss.android.ugc.bytex.pthread.base.proxy.PthreadHandlerThreadV2;

/* JADX INFO: loaded from: classes34.dex */
public final class o {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Handler f404660a;

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final o f404661a = null;

        static {
            f404661a = new o();
        }
    }

    public interface b {
    }

    public o() {
        PthreadHandlerThreadV2 r100 = new PthreadHandlerThreadV2("relax-engine-worker");
        ThreadMethodProxy.start(r100);
        this.f404660a = new Handler(r100.getLooper());
    }
}
