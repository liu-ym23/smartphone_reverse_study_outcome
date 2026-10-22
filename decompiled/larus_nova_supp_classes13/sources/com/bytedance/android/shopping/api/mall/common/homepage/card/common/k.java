package com.bytedance.android.shopping.api.mall.common.homepage.card.common;

import android.graphics.Outline;
import android.view.View;
import android.view.ViewOutlineProvider;
import com.bytedance.android.shopping.orderlist.common.freq.FreqActions;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class k extends ViewOutlineProvider {
    public final /* synthetic */ float a;

    public k(float r1) {
        this.a = r1;
    }

    @Override // android.view.ViewOutlineProvider
    public final void getOutline(View r8, Outline r9) {
        Intrinsics.checkNotNullParameter(r8, FreqActions.ACTION_VIEW);
        Intrinsics.checkNotNullParameter(r9, "outline");
        r9.setRoundRect(0, 0, r8.getWidth(), r8.getHeight(), this.a);
    }
}
