package com.bytedance.android.shopping.deepfeed.ui.view;

import android.view.View;
import com.bytedance.android.shopping.deepfeed.ui.vh.AbsDeepFeedProductVH;
import com.bytedance.android.shopping.deepfeed.viewmodel.DeepFeedProductViewModel;
import com.bytedance.android.shopping.infeed.data.idl.InFeedProductV2;
import java.util.List;
import kotlin.jvm.functions.Function0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class l implements View.OnClickListener {
    public final /* synthetic */ DeepFeedProductViewModel a;
    public final /* synthetic */ View b;
    public final /* synthetic */ Function0 c;

    public l(DeepFeedProductViewModel r1, View r2, Function0 r3) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r5) {
        DeepFeedProductViewModel r6 = this.a;
        AbsDeepFeedProductVH r0 = (AbsDeepFeedProductVH) this.c.invoke();
        List<String> r1 = null;
        if (r0 == null) goto L5;
        InFeedProductV2 r2 = r0.m;
    L6:
        View r3 = this.b;
        AbsDeepFeedProductVH r4 = (AbsDeepFeedProductVH) this.c.invoke();
        if (r4 == null) goto L9;
        r1 = r4.n;
    L9:
        r6.clickCart(r2, "c958668.d226180", r3, r1);
        return;
    L5:
        r2 = null;
        goto L6
    }
}
