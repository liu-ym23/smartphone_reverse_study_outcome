package com.bytedance.android.shopping.card_list.monitor.fps;

import com.bytedance.android.shopping.card_list.monitor.error.CardListRunCatchExtKt;
import et3.c;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class CardListYataFpsMonitor$fpsTracker$2$$special$$inlined$apply$lambda$1 implements c.d {
    public final /* synthetic */ CardListYataFpsMonitor$fpsTracker$2 a;
    public final /* synthetic */ String b;

    public CardListYataFpsMonitor$fpsTracker$2$$special$$inlined$apply$lambda$1(CardListYataFpsMonitor$fpsTracker$2 r1, String r2) {
        this.a = r1;
        this.b = r2;
    }

    public final void fpsCallBack(final double r3) {
        CardListRunCatchExtKt.a(this.a.this$0.c, "CardListYataFpsMonitor-asyncFpsEvent", new AnonymousClass1(this, r3));
    }
}
