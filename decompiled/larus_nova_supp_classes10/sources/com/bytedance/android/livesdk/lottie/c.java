package com.bytedance.android.livesdk.lottie;

import android.content.Context;
import com.bytedance.android.livesdk.utils.i3;
import com.bytedance.ies.sdk.widgets.Widget;
import io.reactivex.Single;
import io.reactivex.functions.Function;
import io.reactivex.schedulers.Schedulers;
import kotlin.jvm.internal.Intrinsics;
import vl2.m;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class c<T, R> implements Function {
    public final /* synthetic */ CommonLottieAnimationWidget a;

    public c(CommonLottieAnimationWidget r1) {
        this.a = r1;
    }

    public final Object apply(Object r3) {
        m r4 = (m) r3;
        Intrinsics.checkNotNullParameter(r4, "it");
        Context r0 = ((Widget) this.a).context;
        Intrinsics.checkNotNullParameter(r4, "entity");
        return Single.create(new i3(r0, r4)).subscribeOn(Schedulers.io()).zipWith(Single.just(r4), new com.bytedance.android.live.core.utils.rxutils.m());
    }
}
