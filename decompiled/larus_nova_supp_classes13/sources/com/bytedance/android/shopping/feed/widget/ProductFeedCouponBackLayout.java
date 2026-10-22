package com.bytedance.android.shopping.feed.widget;

import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.bytedance.android.ec.core.utils.y;
import com.bytedance.android.ec.model.ECUrlModel;
import com.bytedance.android.ec.model.response.anchorv3.MFPromotionEvent;
import com.bytedance.android.ec.model.response.anchorv3.PromotionProductActivitiesStruct;
import com.bytedance.android.ec.model.response.anchorv3.PromotionProductPrivilegesStruct;
import com.bytedance.android.ec.model.response.anchorv3.PromotionProductStruct;
import com.facebook.drawee.view.SimpleDraweeView;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\u0018\u00002\u00020\u00012\u00020\u0002B'\b\u0007\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\b\u001a\u00020\u0007¢\u0006\u0004\b\t\u0010\n¨\u0006\u000b"}, d2 = {"Lcom/bytedance/android/shopping/feed/widget/ProductFeedCouponBackLayout;", "Landroid/widget/LinearLayout;", "Lcom/bytedance/android/shopping/feed/view/c;", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "ec-biz-inner-flow-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ProductFeedCouponBackLayout extends LinearLayout implements com.bytedance.android.shopping.feed.view.c {
    public final SimpleDraweeView a;
    public final TextView b;

    public ProductFeedCouponBackLayout(Context r4) {
        AttributeSet r2 = null;
        this(r4, r2, 6, 0);
    }

    public ProductFeedCouponBackLayout(Context r3, AttributeSet r4) {
        this(r3, r4, 4, 0);
    }

    @Override // com.bytedance.android.shopping.feed.view.c
    public final void a() {
    }

    public final void b(PromotionProductStruct r8) {
        Intrinsics.checkNotNullParameter(r8, "promotion");
        PromotionProductPrivilegesStruct r0 = r8.getPrivilegeInfo();
        String r1 = null;
        if (r0 == null) goto L17;
        PromotionProductActivitiesStruct r2 = r0.getActivities();
        if (r2 == null) goto L17;
        MFPromotionEvent r3 = r2.getMfPromotionEvent();
        if (r3 == null) goto L17;
        ECUrlModel r4 = r3.getEventIcon();
        if (r4 == null) goto L17;
        ViewGroup.LayoutParams r5 = this.a.getLayoutParams();
        if ((r5 instanceof LinearLayout.LayoutParams) == true) goto L13;
        r5 = null;
    L13:
        LinearLayout.LayoutParams r6 = (LinearLayout.LayoutParams) r5;
        if (r6 == null) goto L16;
        float r7 = r4.getWidth();
        Resources r9 = Resources.getSystem();
        r6.width = MathKt.roundToInt(TypedValue.applyDimension(1, r7, WindowDisplayMetricsOverride.apply(r9, r9.getDisplayMetrics())));
        float r10 = r4.getHeight();
        Resources r11 = Resources.getSystem();
        r6.height = MathKt.roundToInt(TypedValue.applyDimension(1, r10, WindowDisplayMetricsOverride.apply(r11, r11.getDisplayMetrics())));
        this.a.setLayoutParams(r6);
    L16:
        y.a(this.a, r4);
    L17:
        TextView r12 = this.b;
        PromotionProductPrivilegesStruct r13 = r8.getPrivilegeInfo();
        if (r13 == null) goto L24;
        PromotionProductActivitiesStruct r14 = r13.getActivities();
        if (r14 == null) goto L24;
        MFPromotionEvent r15 = r14.getMfPromotionEvent();
        if (r15 == null) goto L24;
        r1 = r15.getTitle();
    L24:
        r12.setText(r1);
    }

    public ProductFeedCouponBackLayout(Context r2, AttributeSet r3, int r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2, r3, r4);
        LayoutInflater.from(r2).inflate(2131560641, this);
        this.a = findViewById(2131372251);
        this.b = (TextView) findViewById(2131372252);
    }

    public /* synthetic */ ProductFeedCouponBackLayout(Context r1, AttributeSet r2, int r3, int r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = null;
    L5:
        this(r1, r2, 0);
    }
}
