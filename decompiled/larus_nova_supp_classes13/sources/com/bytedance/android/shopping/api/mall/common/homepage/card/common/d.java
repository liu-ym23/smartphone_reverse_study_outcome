package com.bytedance.android.shopping.api.mall.common.homepage.card.common;

import android.graphics.Outline;
import android.graphics.Rect;
import android.view.View;
import android.view.ViewOutlineProvider;
import com.bytedance.android.shopping.orderlist.common.freq.FreqActions;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class d extends ViewOutlineProvider {
    public float a;
    public final int b;
    public final int c;

    @Override // android.view.ViewOutlineProvider
    public final void getOutline(View r4, Outline r5) {
        Intrinsics.checkNotNullParameter(r4, FreqActions.ACTION_VIEW);
        Intrinsics.checkNotNullParameter(r5, "outline");
        r5.setRoundRect(new Rect(0, 0, this.b, this.c), this.a);
    }

    public d(float r1, int r2, int r3) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
    }
}
