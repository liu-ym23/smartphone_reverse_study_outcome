package com.ss.android.ugc.tools.utils;

import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import com.ss.android.ugc.tools.CukaieManifest;
import io.reactivex.functions.Consumer;
import io.reactivex.plugins.RxJavaPlugins;

/* JADX INFO: loaded from: classes40.dex */
public final class h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f454860a = 0;

    public static final class a<T> implements Consumer<Throwable> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final a f454861a = null;

        static {
            f454861a = new a();
        }

        public a() {
        }

        @Override // io.reactivex.functions.Consumer
        public final void accept(Throwable r100) {
            Throwable r101 = r100;
            CukaieManifest r102 = CukaieManifest.f454800f;
            r102.getClass();
            if (((Boolean) CukaieManifest.f454797c.getValue(r102, CukaieManifest.f454795a[1])).booleanValue() == false) goto L5;
            r101.printStackTrace();
            Thread r103 = ThreadMethodProxy.currentThread();
            r103.getUncaughtExceptionHandler().uncaughtException(r103, r101);
            return;
        L5:
            RxJavaPlugins.onError(r101);
        }
    }
}
