package com.bytedance.android.livesdk.livecommerce.intro.utils;

import android.os.SystemClock;
import com.bytedance.android.livesdk.livecommerce.intro.model.resp.LiveIntroResponse;
import io.reactivex.functions.Consumer;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class i<T> implements Consumer {
    public final /* synthetic */ f a;

    public i(f r1) {
        this.a = r1;
    }

    public final void accept(Object r3) {
        Throwable r4 = (Throwable) r3;
        dm.a.a("IntroCardLoadOpt").a("v2, preloadIntroCard error");
        f r5 = this.a;
        r5.c = Long.valueOf(SystemClock.elapsedRealtime());
        f r6 = this.a;
        r6.a = false;
        r6.e = false;
        Function1<? super LiveIntroResponse, Unit> r7 = this.a.g;
        if (r7 == null) goto L5;
        Unit r8 = (Unit) r7.invoke(null);
    L5:
        this.a.g = null;
    }
}
