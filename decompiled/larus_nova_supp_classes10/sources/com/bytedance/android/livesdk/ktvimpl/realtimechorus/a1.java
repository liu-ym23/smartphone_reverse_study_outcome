package com.bytedance.android.livesdk.ktvimpl.realtimechorus;

import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class a1<T> implements Consumer {
    public final /* synthetic */ RealTimeChorusOperateView a;

    public a1(RealTimeChorusOperateView r1) {
        this.a = r1;
    }

    public final void accept(Object r2) {
        ye2.a r3 = (ye2.a) r2;
        RealTimeChorusOperateView r4 = this.a;
        int r0 = RealTimeChorusOperateView.r;
        r4.V5("paid auto join");
    }
}
