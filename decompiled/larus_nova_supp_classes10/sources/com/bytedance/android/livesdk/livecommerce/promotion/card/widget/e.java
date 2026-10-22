package com.bytedance.android.livesdk.livecommerce.promotion.card.widget;

import android.content.Context;
import android.os.SystemClock;
import android.view.View;
import android.widget.FrameLayout;
import com.bytedance.android.ec.core.opt.asyncInflate.ShoppingAsyncInflater;
import com.bytedance.android.ec.model.promotion.ECUICampaign;
import com.bytedance.android.ec.model.promotion.ECUIPromotion;
import com.bytedance.android.livesdk.livecommerce.promotion.card.model.LivePromotionCardArgs;
import com.bytedance.android.livesdk.livecommerce.promotion.card.view.CountDownView;
import com.bytedance.android.livesdk.livecommerce.promotion.card.view.ECStockProgressLayout;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class e extends FrameLayout implements ij2.a {
    public ECUIPromotion a;
    public final f b;
    public final LivePromotionCardArgs c;

    public static final class a {
    }

    static {
    }

    @Override // ij2.a
    public String getCurrentContentDescription() {
        return "";
    }

    @Override // ij2.a
    public String getType() {
        return "seckill_bar_widget";
    }

    @Override // ij2.a
    public final void release() {
        this.c.b.a();
        com.bytedance.android.livesdk.livecommerce.promotion.card.utils.d.a.b(this.b);
    }

    @Override // ij2.a
    public final boolean a() {
        return ij2.a.C0143a.b(this);
    }

    @Override // ij2.a
    public ij2.b getParentContainer() {
        return ij2.a.C0143a.a(this);
    }

    @Override // ij2.a
    public final void b(com.bytedance.android.ec.common.api.jump.model.e r9) {
        Intrinsics.checkNotNullParameter(r9, "data");
        ECUIPromotion r10 = r9.a;
        this.a = r10;
        if (r10 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("promotion");
    L5:
        ECUICampaign r11 = r10.getCampaign();
        if (r11 == null) goto L8;
        ((ECStockProgressLayout) findViewById(2131365111)).b(r11.progressText, r11.stock, r11.leftStock, r11.label);
        c(SystemClock.elapsedRealtime(), r11.endTime);
    L8:
        this.c.b.a();
        com.bytedance.android.livesdk.livecommerce.promotion.card.utils.d.a.a(this.b);
    }

    @Override // android.view.ViewGroup
    public final void onViewRemoved(View r1) {
        super.onViewRemoved(r1);
        release();
    }

    public e(Context r3, LivePromotionCardArgs r4) {
        Intrinsics.checkNotNullParameter(r3, "context");
        Intrinsics.checkNotNullParameter(r4, "argument");
        super(r3, null, 0);
        this.c = r4;
        ShoppingAsyncInflater.e.getClass();
        addView(ShoppingAsyncInflater.a.a(r3).aU(2131564756, this, false));
        this.b = new f(this);
    }

    public final void c(long r4, long r6) {
        long r7 = r6 - r4;
        CountDownView r5 = (CountDownView) findViewById(2131368046);
        ECUIPromotion r8 = this.a;
        if (r8 != null) goto L6;
        Intrinsics.throwUninitializedPropertyAccessException("promotion");
    L6:
        if (r8.isOnSale() == true) goto L8;
    L13:
        r5.setVisibility(4);
        return;
    L8:
        if (r7 < 86400000) goto L10;
        boolean r0 = true;
    L11:
        if (r0 == true) goto L13;
        r5.setVisibility(0);
        r5.a(r7);
        return;
    L10:
        r0 = false;
        goto L11
    }
}
