package com.bytedance.android.livesdk.livecommerce.promotion.cardV2.info.widget;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.bytedance.android.ec.model.response.ECCarouselData;
import com.bytedance.android.livesdk.livecommerce.promotion.card.IPromotionUIConfig;
import com.bytedance.android.livesdk.livecommerce.promotion.card.PromotionCardModuleName;
import com.bytedance.android.livesdk.livecommerce.promotion.card.utils.UIConfigHelper;
import com.bytedance.android.livesdk.livecommerce.utils.UtilityKotlinExtentionsKt;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
@Deprecated(message = "整体迁移 ECSalePointViewV2")
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u0001B\u0013\b\u0016\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b\u0006\u0010\u0007B\u001d\b\u0016\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\t\u001a\u0004\u0018\u00010\b¢\u0006\u0004\b\u0006\u0010\nB%\b\u0016\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\t\u001a\u0004\u0018\u00010\b\u0012\u0006\u0010\f\u001a\u00020\u000b¢\u0006\u0004\b\u0006\u0010\rJ\b\u0010\u0003\u001a\u00020\u0002H\u0002¨\u0006\u000e"}, d2 = {"Lcom/bytedance/android/livesdk/livecommerce/promotion/cardV2/info/widget/ECSalePointView;", "Landroid/widget/LinearLayout;", "Landroid/view/View;", "getLine", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "Landroid/util/AttributeSet;", "attrs", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "", "defStyleAttr", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "livecommerce_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ECSalePointView extends LinearLayout {
    public final TextView a;
    public final View b;
    public final TextView c;

    private final View getLine() {
        View r0 = new View(getContext());
        LinearLayout.LayoutParams r1 = new LinearLayout.LayoutParams(UtilityKotlinExtentionsKt.d(Double.valueOf(0.5d)), UtilityKotlinExtentionsKt.d(8));
        r1.leftMargin = UtilityKotlinExtentionsKt.d(3);
        r1.rightMargin = UtilityKotlinExtentionsKt.d(Double.valueOf(3.5d));
        r1.gravity = 16;
        r0.setLayoutParams(r1);
        r0.setBackgroundColor(th.a.a(getContext(), 2131106090));
        r0.setVisibility(8);
        return r0;
    }

    public ECSalePointView(Context r3) {
        super(r3);
        setOrientation(0);
        TextView r4 = b(getContext());
        this.a = r4;
        View r0 = getLine();
        this.b = r0;
        TextView r1 = b(getContext());
        this.c = r1;
        addView(r4);
        addView(r0);
        addView(r1);
    }

    public static TextView b(Context r3) {
        TextView r0 = new TextView(r3);
        r0.setTextSize(1, 12.0f);
        r0.setTextColor(th.a.a(r3, 2131106066));
        r0.setEllipsize(TextUtils.TruncateAt.END);
        r0.setMaxLines(1);
        return r0;
    }

    public ECSalePointView(Context r2, AttributeSet r3) {
        super(r2, r3);
        setOrientation(0);
        TextView r4 = b(getContext());
        this.a = r4;
        View r5 = getLine();
        this.b = r5;
        TextView r0 = b(getContext());
        this.c = r0;
        addView(r4);
        addView(r5);
        addView(r0);
    }

    public final void a(ECCarouselData r6, com.bytedance.android.livesdk.livecommerce.promotion.card.k r7) {
        Intrinsics.checkNotNullParameter(r6, "data");
        String r0 = r6.getBefore();
        String r2 = null;
        if (cg4.a.a(r0) == true) goto L7;
        r0 = null;
    L7:
        if (r0 == null) goto L9;
        this.a.setVisibility(0);
        this.a.setText(r0);
    L11:
        if (cg4.a.a(r6.getBefore()) == true) goto L13;
    L15:
        this.b.setVisibility(8);
    L16:
        String r1 = r6.getContent();
        if (cg4.a.a(r1) == false) goto L19;
        r2 = r1;
    L19:
        if (r2 == null) goto L21;
        this.c.setVisibility(0);
        this.c.setText(r2);
        int r3 = com.bytedance.android.ec.core.utils.s.a;
        this.c.setTextColor(com.bytedance.android.ec.core.utils.s.a(r6.getColor(), th.a.a(getContext(), 2131106066)));
    L22:
        if (r7 == null) goto L29;
        IPromotionUIConfig.d r8 = r7.a(PromotionCardModuleName.InfoAreaSalePointModule);
        if (r8 == null) goto L30;
        IPromotionUIConfig.b r9 = r8.a();
        if (r9 == null) goto L31;
        int r10 = UIConfigHelper.a;
        UIConfigHelper.c(this.a, r9);
        UIConfigHelper.c(this.c, r9);
        return;
    L31:
        return;
    L30:
        return;
    L29:
        return;
    L21:
        this.c.setVisibility(8);
        Unit r11 = Unit.INSTANCE;
        goto L22
    L13:
        if (cg4.a.a(r6.getContent()) == false) goto L15;
        this.b.setVisibility(0);
        goto L16
    L9:
        this.a.setVisibility(8);
        Unit r4 = Unit.INSTANCE;
        goto L11
    }

    public ECSalePointView(Context r1, AttributeSet r2, int r3) {
        super(r1, r2, r3);
        setOrientation(0);
        TextView r4 = b(getContext());
        this.a = r4;
        View r5 = getLine();
        this.b = r5;
        TextView r6 = b(getContext());
        this.c = r6;
        addView(r4);
        addView(r5);
        addView(r6);
    }
}
