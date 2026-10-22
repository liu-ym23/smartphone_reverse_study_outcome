package com.bytedance.android.shopping.anchorv4.voavhs.headv2.gallery;

import com.bytedance.android.ecom.arch.slice.slices.template.SlcTemplateView;
import com.bytedance.android.shopping.orderlist.common.freq.FreqActions;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class s0 implements com.bytedance.android.shopping.anchorv4.helper.g {
    public final /* synthetic */ t0 a;

    public s0(t0 r1) {
        this.a = r1;
    }

    public final void a(com.bytedance.android.ecom.arch.slice.g r2) {
        Intrinsics.checkNotNullParameter(r2, "slice");
        Intrinsics.checkNotNullParameter(r2, "slice");
    }

    public final void b(com.bytedance.android.ecom.arch.slice.g r2, SlcTemplateView r3) {
        Intrinsics.checkNotNullParameter(r2, "slice");
        Intrinsics.checkNotNullParameter(r3, FreqActions.ACTION_VIEW);
        this.a.c.invoke(r2, r3);
    }
}
