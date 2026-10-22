package com.bytedance.android.livesdk.livecommerce.promotion.cardV2.info.widget;

import android.content.Context;
import android.view.View;
import android.widget.FrameLayout;
import com.bytedance.android.ec.core.opt.asyncInflate.ShoppingAsyncInflater;
import com.bytedance.android.ec.model.response.o0;
import com.bytedance.android.livesdk.livecommerce.promotion.cardV2.LivePromotionCardArgsV2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class h extends FrameLayout implements com.bytedance.android.livesdk.livecommerce.promotion.cardV2.info.a {
    public o0 a;
    public final i b;
    public final com.bytedance.android.livesdk.livecommerce.promotion.cardV2.a c;
    public final LivePromotionCardArgsV2 d;

    public static final class a {
    }

    static {
    }

    @Override // com.bytedance.android.livesdk.livecommerce.promotion.cardV2.info.a
    public String getCurrentContentDescription() {
        return "";
    }

    @Override // com.bytedance.android.livesdk.livecommerce.promotion.cardV2.info.a
    public String getType() {
        return "seckill_bar_widget";
    }

    @Override // com.bytedance.android.livesdk.livecommerce.promotion.cardV2.info.a
    public final void release() {
        this.d.b.a();
        com.bytedance.android.livesdk.livecommerce.promotion.card.utils.d.a.b(this.b);
        this.a = null;
    }

    @Override // android.view.ViewGroup
    public final void onViewRemoved(View r1) {
        super.onViewRemoved(r1);
        release();
    }

    public h(Context r3, com.bytedance.android.livesdk.livecommerce.promotion.cardV2.a r4, LivePromotionCardArgsV2 r5) {
        Intrinsics.checkNotNullParameter(r3, "context");
        Intrinsics.checkNotNullParameter(r5, "argument");
        super(r3, null, 0);
        this.c = r4;
        this.d = r5;
        ShoppingAsyncInflater.e.getClass();
        addView(ShoppingAsyncInflater.a.a(r3).aU(2131564757, this, false));
        ((ECStockProgressLayout) findViewById(2131365111)).setPromotionCardArg(r5);
        this.b = new i(this);
    }
}
