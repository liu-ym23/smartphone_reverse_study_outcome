package com.bytedance.android.shopping.mall.homepage;

import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.bytedance.android.ec.hybrid.card.impl.ECLynxCard;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class m extends rj.a {
    public final /* synthetic */ ECMallFragment d;
    public final /* synthetic */ ViewGroup e;

    public final void onLoadSuccess() {
        super.onLoadSuccess();
        View r0 = this.d.getView();
        if (r0 == null) goto L8;
        FrameLayout r1 = (FrameLayout) r0.findViewById(2131382099);
        if (r1 == null) goto L9;
        r1.setVisibility(0);
        return;
    L9:
        return;
    }

    public m(ECLynxCard r1, ECMallFragment r2, ViewGroup r3) {
        this.d = r2;
        this.e = r3;
        super(r1, "pendant_layer");
    }
}
