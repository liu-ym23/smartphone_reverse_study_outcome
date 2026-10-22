package com.bytedance.android.livesdk.livecommerce.promotion.card.view;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.text.TextUtils;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.bytedance.android.ec.core.widget.ECNetImageView;
import com.bytedance.android.ec.model.promotion.ECUICampaign;
import com.bytedance.android.ec.model.promotion.ECUIPromotion;
import com.bytedance.android.ec.model.response.CampaignProgress;
import com.bytedance.android.livesdk.livecommerce.ab.ECLiveABUtils;
import com.bytedance.android.livesdk.livecommerce.promotion.card.g;
import com.bytedance.android.livesdk.livecommerce.promotion.card.model.LivePromotionCardArgs;
import com.bytedance.android.livesdk.livecommerce.utils.UtilityKotlinExtentionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class a extends LinearLayout {
    public ECUIPromotion a;
    public final ECNetImageView b;
    public final TextView c;
    public final ECNewCountDownView d;
    public StringBuilder e;
    public boolean f;
    public final b g;
    public final c h;
    public final g i;

    /* JADX INFO: renamed from: com.bytedance.android.livesdk.livecommerce.promotion.card.view.a$a, reason: collision with other inner class name */
    public static final class C0086a {
    }

    static {
    }

    public final void c() {
        this.a = null;
        this.i.b.a();
        com.bytedance.android.livesdk.livecommerce.promotion.card.utils.d r0 = com.bytedance.android.livesdk.livecommerce.promotion.card.utils.d.a;
        r0.b(this.g);
        this.i.b.a();
        r0.b(this.h);
    }

    public final Drawable a() {
        GradientDrawable r0 = new GradientDrawable();
        r0.setCornerRadius(UtilityKotlinExtentionsKt.c(Float.valueOf(2.0f)));
        r0.setStroke(2, th.a.a(getContext(), 2131105929));
        r0.setColor(th.a.a(getContext(), 2131105892));
        return r0;
    }

    public final void b() {
        setVisibility(8);
        this.c.setVisibility(8);
        this.d.setVisibility(8);
    }

    public a(Context r3, LivePromotionCardArgs r4) {
        Intrinsics.checkNotNullParameter(r3, "context");
        Intrinsics.checkNotNullParameter(r4, "argument");
        super(r3, null, 0);
        this.i = r4;
        this.g = new b(this);
        this.h = new c(this);
        th.a.c(r3, 2131564745, this, true);
        setLayoutParams(new ViewGroup.LayoutParams(-2, UtilityKotlinExtentionsKt.d(16)));
        this.b = findViewById(2131380910);
        this.c = (TextView) findViewById(2131362171);
        this.d = (ECNewCountDownView) findViewById(2131390410);
    }

    public final void d(ECUICampaign r11, long r12, StringBuilder r14) {
        if (r11 == null) goto L34;
        ECLiveABUtils r0 = ECLiveABUtils.INSTANCE;
        if (r0.getECOM_LIVE_ACTIVITY_LABEL_STOCK() == true) goto L8;
        if (r11.stock > 0) goto L8;
        return;
    L8:
        if (r0.getECOM_LIVE_ACTIVITY_LABEL_STOCK() == true) goto L10;
    L12:
        float r1 = ((r11.leftStock * 1.0f) / r11.stock) * 100;
    L13:
        long r2 = r11.endTime - r12;
        boolean r6 = true;
        if (r11.startTime >= r12) goto L16;
        boolean r4 = true;
    L18:
        if (r2 >= 86400000) goto L21;
        r6 = false;
    L21:
        if (r6 == false) goto L23;
    L30:
        this.d.setText(r11.progressText);
        if (r14 == null) goto L38;
        r14.append(r11.progressText);
        return;
    L38:
        return;
    L23:
        if (r0.getECOM_LIVE_ACTIVITY_LABEL_STOCK() == false) goto L25;
    L27:
        if (r4 == true) goto L29;
        ECNewCountDownView.x(this.d, r11.startTime - r12, r11.progressText, 10);
        return;
    L29:
        ECNewCountDownView.x(this.d, r11.endTime - r12, null, 14);
        return;
    L25:
        if (r1 > 10) goto L27;
    L16:
        r4 = false;
        goto L18
    L10:
        if (r11.stock > 0) goto L12;
        r1 = 0.0f;
        goto L13
    }

    public final void e(ECUICampaign r7, long r8, StringBuilder r10) {
        if (r7 == null) goto L5;
        CampaignProgress r1 = r7.progress;
    L6:
        if (r1 != null) goto L8;
    L30:
        b();
        return;
    L8:
        if (r7.stock <= 0) goto L30;
        CampaignProgress r9 = r7.progress;
        if (r9.getCountDown() != null) goto L23;
        if (TextUtils.isEmpty(r9.getRightText()) == true) goto L21;
        this.d.setText(r9.getRightText());
        if (r10 != null) goto L17;
    L18:
        if (r10 == null) goto L20;
        r10.append(r9.getRightText());
    L20:
        setVisibility(0);
        this.c.setVisibility(0);
        this.d.setVisibility(0);
        return;
    L17:
        if (StringsKt.contains$default(r10, String.valueOf(r9.getRightText()), false, 2, null) == true) goto L20;
    L21:
        b();
        return;
    L23:
        if (r8 <= 0) goto L28;
        ECNewCountDownView r11 = this.d;
        String r12 = r9.getRightText();
        if (r12 != null) goto L27;
        r12 = "";
    L27:
        ECNewCountDownView.x(r11, r8, r12, 10);
        setVisibility(0);
        this.c.setVisibility(0);
        this.d.setVisibility(0);
        return;
    L28:
        b();
        return;
    L5:
        r1 = null;
        goto L6
    }
}
