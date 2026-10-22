package com.bytedance.android.livesdk.livecommerce.intro.utils;

import android.os.SystemClock;
import com.bytedance.android.livesdk.livecommerce.intro.model.resp.LiveIntroResponse;
import com.bytedance.android.livesdk.livecommerce.utils.UtilityKotlinExtentionsKt;
import io.reactivex.functions.Consumer;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class h<T> implements Consumer {
    public final /* synthetic */ f a;

    public h(f r1) {
        this.a = r1;
    }

    public final void accept(Object r4) {
        LiveIntroResponse r5 = (LiveIntroResponse) r4;
        dm.a.a("IntroCardLoadOpt").a("v2, preloadIntroCard success");
        this.a.c = Long.valueOf(SystemClock.elapsedRealtime());
        f r0 = this.a;
        r0.a = false;
        if (r5 == null) goto L5;
        f.o.getClass();
        f.a.a(r5);
        Unit r2 = Unit.INSTANCE;
    L6:
        r0.d = r5;
        this.a.e = true;
        Function1<? super LiveIntroResponse, Unit> r6 = this.a.g;
        if (r6 == null) goto L9;
        UtilityKotlinExtentionsKt.b.postAtFrontOfQueue(new g(r6, this));
    L9:
        this.a.g = null;
        return;
    L5:
        r5 = null;
        goto L6
    }
}
