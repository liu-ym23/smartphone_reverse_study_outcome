package com.bytedance.android.shopping.slice.elements.lottieview;

import android.content.Context;
import com.bytedance.android.ec.core.widget.ECLottieAnimationView;
import com.bytedance.android.ecom.arch.slice.render.widget.roundcorner.SlcRoundFrameLayout;
import com.bytedance.android.shopping.anchorv4.voavhs.e;
import com.bytedance.android.ui.ec.widget.ecdraweeview.ECDraweeView;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class d extends SlcRoundFrameLayout {
    public ECLottieAnimationView c;
    public ECDraweeView d;
    public e e;

    public final e getPdpService() {
        return this.e;
    }

    public d(Context r4) {
        Intrinsics.checkNotNullParameter(r4, "context");
        super(r4, null, 6, 0);
    }

    public final void setPdpService(e r1) {
        this.e = r1;
    }
}
