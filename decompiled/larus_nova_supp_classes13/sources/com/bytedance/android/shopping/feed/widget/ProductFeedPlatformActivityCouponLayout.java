package com.bytedance.android.shopping.feed.widget;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.bytedance.android.ec.core.utils.y;
import com.bytedance.android.ec.model.ECUrlModel;
import com.bytedance.android.ec.model.response.anchorv3.PromotionDiscountLabel;
import com.bytedance.android.ec.model.response.anchorv3.PromotionMarketFloor;
import com.bytedance.android.ec.model.response.anchorv3.PromotionProductActivitiesStruct;
import com.bytedance.android.ec.model.response.anchorv3.PromotionProductCouponsStruct;
import com.bytedance.android.ec.model.response.anchorv3.PromotionProductPrivilegesStruct;
import com.bytedance.android.ec.model.response.anchorv3.PromotionProductStruct;
import com.facebook.drawee.view.SimpleDraweeView;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\u0018\u00002\u00020\u00012\u00020\u0002B'\b\u0007\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\b\u001a\u00020\u0007¢\u0006\u0004\b\t\u0010\n¨\u0006\u000b"}, d2 = {"Lcom/bytedance/android/shopping/feed/widget/ProductFeedPlatformActivityCouponLayout;", "Landroid/widget/LinearLayout;", "Lcom/bytedance/android/shopping/feed/view/c;", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "ec-biz-inner-flow-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ProductFeedPlatformActivityCouponLayout extends LinearLayout implements com.bytedance.android.shopping.feed.view.c {
    public final SimpleDraweeView a;
    public final TextView b;
    public final View c;
    public final TextView d;

    public ProductFeedPlatformActivityCouponLayout(Context r4) {
        AttributeSet r2 = null;
        this(r4, r2, 6, 0);
    }

    public ProductFeedPlatformActivityCouponLayout(Context r3, AttributeSet r4) {
        this(r3, r4, 4, 0);
    }

    @Override // com.bytedance.android.shopping.feed.view.c
    public final void a() {
    }

    public final void b(PromotionProductStruct r10) {
        if (r10.hasPlatformActivity() == true) goto L5;
    L43:
        setVisibility(8);
        return;
    L5:
        if (r10.hasPlatformDiscountCoupon() == false) goto L43;
        setVisibility(0);
        PromotionProductPrivilegesStruct r3 = r10.getPrivilegeInfo();
        Object r4 = null;
        if (r3 == null) goto L15;
        PromotionProductActivitiesStruct r5 = r3.getActivities();
        if (r5 == null) goto L15;
        PromotionMarketFloor r6 = r5.getPlatformTextActivity();
        if (r6 == null) goto L15;
        ECUrlModel r7 = r6.getIcon();
        if (r7 == null) goto L15;
        this.a.setVisibility(0);
        y.c(this.a, r7, getResources().getDimensionPixelOffset(2131165665), getResources().getDimensionPixelOffset(2131165664), null);
    L16:
        PromotionProductPrivilegesStruct r11 = r10.getPrivilegeInfo();
        if (r11 == null) goto L42;
        PromotionProductCouponsStruct r12 = r11.getCoupons();
        if (r12 == null) goto L42;
        List r13 = r12.getDiscountLabels();
        if (r13 == null) goto L42;
        Iterator r14 = r13.iterator();
    L24:
        if (r14.hasNext() == false) goto L31;
        Object r8 = r14.next();
        if (((PromotionDiscountLabel) r8).getType() != 3) goto L28;
        boolean r9 = true;
    L29:
        if (r9 == false) goto L24;
        r4 = r8;
        goto L31
    L28:
        r9 = false;
    L31:
        PromotionDiscountLabel r15 = (PromotionDiscountLabel) r4;
        if (r15 == null) goto L42;
        String r16 = r15.getTag();
        String r1 = r15.getTagHeader();
        if (r16 != null) goto L36;
    L41:
        this.d.setVisibility(8);
        this.b.setVisibility(8);
        this.c.setVisibility(8);
        return;
    L36:
        if (TextUtils.isEmpty(r16) == true) goto L41;
        if (r1 == null) goto L41;
        if (TextUtils.isEmpty(r1) == true) goto L41;
        this.d.setText(r16);
        this.b.setText(r1);
        this.d.setVisibility(0);
        this.b.setVisibility(0);
        this.c.setVisibility(0);
        return;
    L42:
        this.d.setVisibility(8);
        return;
    L15:
        this.a.setVisibility(8);
        goto L16
    }

    public ProductFeedPlatformActivityCouponLayout(Context r2, AttributeSet r3, int r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2, r3, r4);
        LayoutInflater.from(r2).inflate(2131564255, this);
        this.a = findViewById(2131383149);
        this.b = (TextView) findViewById(2131383157);
        this.c = findViewById(2131383156);
        this.d = (TextView) findViewById(2131383155);
    }

    public /* synthetic */ ProductFeedPlatformActivityCouponLayout(Context r1, AttributeSet r2, int r3, int r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = null;
    L5:
        this(r1, r2, 0);
    }
}
