package com.larus.ui.arch.vm.internal;

import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes31.dex */
public final class j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Lazy f375253a = null;

    public static final class a implements ThreadFactory {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final ThreadFactory f375254a;

        public a() {
            this.f375254a = Executors.defaultThreadFactory();
        }

        @Override // java.util.concurrent.ThreadFactory
        public final Thread newThread(Runnable r100) {
            Thread r101 = this.f375254a.newThread(r100);
            ThreadMethodProxy.setName(r101, "ui-arch#" + r101.getName());
            Intrinsics.checkNotNull(r101);
            return r101;
        }
    }

    static {
        f375253a = LazyKt.lazy(new i());
    }
}
