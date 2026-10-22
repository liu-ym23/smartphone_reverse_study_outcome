package com.bytedance.android.livesdk.ktvimpl.realtimechorus;

import androidx.lifecycle.Observer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class u<T> implements Observer {
    public final /* synthetic */ RealTimeChorusBusinessWidget a;

    public u(RealTimeChorusBusinessWidget r1) {
        this.a = r1;
    }

    public final void onChanged(Object r3) {
        RealTimeChorusBusinessWidget r0 = this.a;
        int r1 = RealTimeChorusBusinessWidget.V0;
        r0.Pq((String) r3);
    }
}
