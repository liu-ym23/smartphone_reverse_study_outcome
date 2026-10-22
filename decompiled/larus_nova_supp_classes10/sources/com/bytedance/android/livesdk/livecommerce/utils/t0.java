package com.bytedance.android.livesdk.livecommerce.utils;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.Scheduler;
import io.reactivex.annotations.CheckReturnValue;
import io.reactivex.annotations.SchedulerSupport;
import io.reactivex.internal.disposables.EmptyDisposable;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.plugins.RxJavaPlugins;
import io.reactivex.schedulers.Schedulers;
import java.util.concurrent.TimeUnit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class t0 {
    public static final /* synthetic */ int a = 0;

    public static final class a extends Observable<Object> {
        public a() {
        }

        public final void subscribeActual(Observer<? super Object> r2) {
            Intrinsics.checkNotNullParameter(r2, "observer");
            r2.onSubscribe(EmptyDisposable.NEVER);
        }
    }

    static {
        new a();
    }

    @SchedulerSupport("io.reactivex:computation")
    @CheckReturnValue
    public static Observable a(long r7, long r9, TimeUnit r11) {
        Intrinsics.checkNotNullParameter(r11, "unit");
        return b(r7, r9, r11, Schedulers.computation());
    }

    @SchedulerSupport("custom")
    @CheckReturnValue
    public static Observable b(long r8, long r10, TimeUnit r12, Scheduler r13) {
        Intrinsics.checkNotNullParameter(r12, "unit");
        Intrinsics.checkNotNullParameter(r13, "scheduler");
        ObjectHelper.requireNonNull(r12, "unit is null");
        ObjectHelper.requireNonNull(r13, "scheduler is null");
        return RxJavaPlugins.onAssembly(new ObservableInterval(Math.max(0, r8), Math.max(0, r10), r12, r13));
    }
}
