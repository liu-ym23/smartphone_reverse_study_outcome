package com.bytedance.android.window.shop.home.presenter;

import android.widget.FrameLayout;
import com.ss.android.ugc.aweme.compat.nullable.Observer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class o<T> implements Observer {
    public final /* synthetic */ ECWindowCroppedStyleBackGroundPresenter a;

    public o(ECWindowCroppedStyleBackGroundPresenter r1) {
        this.a = r1;
    }

    public final void onChanged(Object r5) {
        Float r6 = (Float) r5;
        if (r6.floatValue() > 0) goto L5;
        this.a.b0().setVisibility(8);
        this.a.b0().setAlpha(0.0f);
        ((FrameLayout) this.a.n.getValue()).setAlpha(1.0f);
        return;
    L5:
        float r2 = 1;
        if (r6.floatValue() < r2) goto L8;
        this.a.b0().setVisibility(0);
        this.a.b0().setAlpha(1.0f);
        return;
    L8:
        this.a.b0().setVisibility(0);
        this.a.b0().setAlpha(r6.floatValue());
        ((FrameLayout) this.a.n.getValue()).setAlpha(r2 - r6.floatValue());
    }
}
