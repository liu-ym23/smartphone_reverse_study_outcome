package com.bytedance.android.livesdk.ktvimpl.realtimechorus;

import kotlin.Metadata;
import kotlin.jvm.internal.CallableReference;
import kotlin.jvm.internal.MutablePropertyReference0Impl;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
@Metadata(k = 3, mv = {1, 5, 1})
final /* synthetic */ class RealTimeChorusBusinessWidget$updateRealtimeChorusGuestStatus$1 extends MutablePropertyReference0Impl {
    public RealTimeChorusBusinessWidget$updateRealtimeChorusGuestStatus$1(RealTimeChorusBusinessWidget r7) {
        super(r7, RealTimeChorusBusinessWidget.class, "mViewModel", "getMViewModel()Lcom/bytedance/android/livesdk/ktvimpl/realtimechorus/RealTimeChorusViewModel;", 0);
    }

    public Object get() {
        return RealTimeChorusBusinessWidget.wq((RealTimeChorusBusinessWidget) ((CallableReference) this).receiver);
    }

    public void set(Object r2) {
        RealTimeChorusViewModel r3 = (RealTimeChorusViewModel) r2;
        ((RealTimeChorusBusinessWidget) ((CallableReference) this).receiver).e = r3;
    }
}
