package com.bytedance.android.livesdk.livecommerce.room.coupon;

import com.bytedance.android.livesdk.livecommerce.utils.p0;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class e extends p0<ge.a> {
    public final /* synthetic */ Function0 a;

    public e(Function0 r1) {
        this.a = r1;
    }

    public final void onNext(Object r2) {
        Intrinsics.checkNotNullParameter((ge.a) r2, "iUser");
        this.a.invoke();
    }
}
