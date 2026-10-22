package com.bytedance.android.livesdk.livecommerce.intro.utils;

import com.bytedance.android.livesdk.livecommerce.intro.model.resp.LiveIntroResponse;
import com.bytedance.android.livesdk.livecommerce.opt.ECLivePerformanceMonitor;
import com.bytedance.android.livesdk.livecommerce.room.store.ECContext;
import io.reactivex.functions.Consumer;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class e<T> implements Consumer {
    public final /* synthetic */ IntroCardLoadOpt a;
    public final /* synthetic */ ECContext b;

    public e(IntroCardLoadOpt r1, ECContext r2) {
        this.a = r1;
        this.b = r2;
    }

    public final void accept(Object r2) {
        Throwable r3 = (Throwable) r2;
        dm.a.a("IntroCardLoadOpt").a("v1, preloadIntroCard error");
        ((ECLivePerformanceMonitor) this.b.getEcLivePerformanceMonitor().getValue()).l();
        this.a.c = false;
        Function1<? super LiveIntroResponse, Unit> r4 = this.a.d;
        if (r4 == null) goto L5;
        Unit r5 = (Unit) r4.invoke(null);
    L5:
        this.a.d = null;
    }
}
