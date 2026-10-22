package com.bytedance.android.shopping.hybrid.bridges;

import android.content.Context;
import android.os.Handler;
import cg3.k;
import com.bytedance.android.shopping.order.PublishUtil;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class c<T> implements Consumer {
    public final /* synthetic */ ECOpenVideoPreviewPanelMethod a;

    public c(ECOpenVideoPreviewPanelMethod r1) {
        this.a = r1;
    }

    public final void accept(Object r3) {
        Handler r0 = PublishUtil.a;
        Context r1 = this.a.getContext();
        PublishUtil.e(r1, (k) r3, true);
    }
}
