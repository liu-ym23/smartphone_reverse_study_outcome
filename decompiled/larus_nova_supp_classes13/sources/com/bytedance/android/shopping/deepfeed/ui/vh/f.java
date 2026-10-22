package com.bytedance.android.shopping.deepfeed.ui.vh;

import android.view.View;
import com.bytedance.android.shopping.deepfeed.action.DeepFeedCommentClickArea;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class f implements View.OnClickListener {
    public final /* synthetic */ DeepFeedProductBannerCommentVH a;

    public f(DeepFeedProductBannerCommentVH r1) {
        this.a = r1;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r2) {
        Function1<? super DeepFeedCommentClickArea, Unit> r3 = this.a.o;
        if (r3 == null) goto L6;
        Unit r4 = (Unit) r3.invoke(DeepFeedCommentClickArea.Container);
        return;
    }
}
