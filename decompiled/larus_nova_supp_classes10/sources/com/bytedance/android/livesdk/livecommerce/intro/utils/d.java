package com.bytedance.android.livesdk.livecommerce.intro.utils;

import com.bytedance.android.livesdk.livecommerce.intro.model.resp.LiveIntroResponse;
import com.bytedance.android.livesdk.livecommerce.opt.ECLivePerformanceMonitor;
import com.bytedance.android.livesdk.livecommerce.room.store.ECContext;
import io.reactivex.functions.Consumer;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class d<T> implements Consumer {
    public final /* synthetic */ IntroCardLoadOpt a;
    public final /* synthetic */ ECContext b;

    public d(IntroCardLoadOpt r1, ECContext r2) {
        this.a = r1;
        this.b = r2;
    }

    public final void accept(Object r4) {
        LiveIntroResponse r5 = (LiveIntroResponse) r4;
        dm.a.b r0 = dm.a.a("IntroCardLoadOpt");
        StringBuilder r1 = new StringBuilder("v1, preloadIntroCard success, optCardLoadRequest=");
        boolean r2 = IntroCardLoadOpt.h;
        r1.append(r2);
        r0.a(r1.toString());
        if (r2 == true) goto L8;
        ((ECLivePerformanceMonitor) this.b.getEcLivePerformanceMonitor().getValue()).l();
        this.a.c = false;
        this.a.a = r5;
        this.a.b = true;
        Function1<? super LiveIntroResponse, Unit> r3 = this.a.d;
        if (r3 == null) goto L9;
        Unit r6 = (Unit) r3.invoke(r5);
        return;
    L9:
        return;
    }
}
