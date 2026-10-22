package com.bytedance.android.livesdk.ktvimpl.realtimechorus;

import com.ss.android.ugc.aweme.compat.nullable.Observer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class z0<T> implements Observer {
    public final /* synthetic */ RealTimeChorusOperateView a;

    public z0(RealTimeChorusOperateView r1) {
        this.a = r1;
    }

    public final void onChanged(Object r2) {
        Boolean r3 = (Boolean) r2;
        RealTimeChorusOperateView r4 = this.a;
        int r0 = RealTimeChorusOperateView.r;
        r4.b6();
    }
}
