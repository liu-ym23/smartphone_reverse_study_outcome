package com.bytedance.android.livesdk.livecommerce.promotion.cardV2.widget;

import android.content.Context;
import android.graphics.Bitmap;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.bytedance.android.ec.core.abtest.ECSettingKeys;
import com.bytedance.android.ec.core.imagex.ImageExtensionsKt;
import com.bytedance.android.ec.core.imagex.r;
import com.bytedance.android.ec.core.utils.ECLiveImageUtils;
import com.bytedance.android.ec.core.utils.w;
import com.bytedance.android.ec.core.widget.ECExplainingView;
import com.bytedance.android.ec.core.widget.ECLottieAnimationView;
import com.bytedance.android.ec.core.widget.ECNetImageView;
import com.bytedance.android.ec.model.response.a1;
import com.bytedance.android.ec.sdk.helper.ECAppInfoService;
import com.bytedance.android.shopping.extensions.ViewExtensionsKt;
import com.bytedance.android.ui.ec.widget.ecdraweeview.ECDraweeView;
import com.facebook.drawee.drawable.ScalingUtils;
import kotlin.Lazy;
import th.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public class ECPromotionImageView extends FrameLayout {
    public int a;
    public ECDraweeView b;
    public ECNetImageView c;
    public TextView d;
    public LinearLayout e;
    public ECExplainingView f;
    public ECLottieAnimationView g;
    public LinearLayout h;
    public View i;
    public TextView j;
    public ECNetImageView k;
    public ECDraweeView l;
    public w m;
    public String n;

    public final void a() {
        this.d.setVisibility(8);
        this.e.setVisibility(8);
        this.h.setVisibility(8);
    }

    public int getImageRadius() {
        int r0 = this.a;
        if (r0 < 0) goto L5;
        return r0;
    L5:
        Lazy r1 = ECAppInfoService.a;
        if (ECAppInfoService.l() == false) goto L9;
        return 8;
    L9:
        return 2;
    }

    public View getExplaingingLayout() {
        return this.h;
    }

    public ECDraweeView getFloatIconView() {
        return this.l;
    }

    public ECPromotionImageView(Context r2) {
        super(r2);
        this.a = -1;
        this.n = "ec_live_explain_lottie.json";
        b(r2);
    }

    public final void b(Context r7) {
        a.c(r7, 2131564749, this, true);
        this.b = findViewById(2131374627);
        this.c = findViewById(2131374626);
        this.d = (TextView) findViewById(2131391507);
        this.e = (LinearLayout) findViewById(2131378686);
        this.f = findViewById(2131370733);
        this.h = (LinearLayout) findViewById(2131371938);
        this.g = findViewById(2131371937);
        this.i = findViewById(2131392538);
        this.k = findViewById(2131371510);
        this.j = (TextView) findViewById(2131390596);
        this.l = findViewById(2131370422);
        this.h.setVisibility(8);
        Lazy r8 = ECAppInfoService.a;
        if (ECAppInfoService.l() == false) goto L6;
        this.e.setBackgroundResource(2131234623);
        this.i.setBackgroundResource(2131234568);
    L10:
        if (ECSettingKeys.P() == false) goto L14;
        this.i.setVisibility(8);
        ECDraweeView r9 = this.b;
        if (r9 == null) goto L14;
        r9.setBackgroundDrawable(null);
        this.b.setPlaceholderImage(2131106155, ScalingUtils.ScaleType.CENTER_INSIDE);
    L14:
        float r4 = this.a;
        ViewExtensionsKt.f(this, r4, r4, r4, r4, true);
        return;
    L6:
        if (ECAppInfoService.j() == false) goto L8;
        this.e.setVisibility(8);
        this.d.setTextSize(1, 13.0f);
        goto L10
    L8:
        this.e.setBackgroundResource(2131234622);
        this.i.setBackgroundResource(2131234567);
        goto L10
    }

    public void setAnimation(String r1) {
        this.n = r1;
    }

    public void setBottomBannerInfo(a1 r4) {
        this.k.setVisibility(0);
        this.j.setText(r4.f());
        ECLiveImageUtils.c(this.k, r4.e(), true, null);
    }

    public void setCallerContext(r r2) {
        ImageExtensionsKt.D(this.b, r2);
    }

    public void setForceRadius(int r7) {
        this.a = r7;
        ViewExtensionsKt.f(this, r7, r7, r7, r7, true);
    }

    public void setImageBitmap(Bitmap r2) {
        this.b.setImageBitmap(r2);
    }

    public void setPromotionImageBindConfig(w r1) {
        this.m = r1;
    }

    public ECPromotionImageView(Context r1, AttributeSet r2) {
        super(r1, r2);
        this.a = -1;
        this.n = "ec_live_explain_lottie.json";
        b(r1);
    }

    public ECPromotionImageView(Context r1, AttributeSet r2, int r3) {
        super(r1, r2, r3);
        this.a = -1;
        this.n = "ec_live_explain_lottie.json";
        b(r1);
    }
}
