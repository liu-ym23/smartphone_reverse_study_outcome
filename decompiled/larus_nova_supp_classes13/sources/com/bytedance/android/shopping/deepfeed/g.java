package com.bytedance.android.shopping.deepfeed;

import androidx.lifecycle.Observer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class g<T> implements Observer {
    public final /* synthetic */ DeepFeedProductFragment a;

    public g(DeepFeedProductFragment r1) {
        this.a = r1;
    }

    public final void onChanged(Object r5) {
        com.bytedance.android.shopping.deepfeed.viewmodel.d r6 = (com.bytedance.android.shopping.deepfeed.viewmodel.d) r5;
        if (r6 == null) goto L10;
        DeepFeedProductFragment r0 = this.a;
        Runnable r1 = r0.Y;
        if (r1 == null) goto L8;
        r0.ea0().removeCallbacks(r1);
    L8:
        l r2 = new l(r0, r6);
        r0.Y = r2;
        r0.ea0().postDelayed(r2, 500);
        this.a.ga0().consumePitayaAutoSlideEvent();
        return;
    }
}
