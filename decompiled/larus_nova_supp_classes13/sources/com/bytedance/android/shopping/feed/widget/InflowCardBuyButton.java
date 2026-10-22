package com.bytedance.android.shopping.feed.widget;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.text.SpannableString;
import android.text.style.AbsoluteSizeSpan;
import android.text.style.ForegroundColorSpan;
import android.text.style.TextAppearanceSpan;
import android.util.AttributeSet;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatButton;
import com.bytedance.android.ec.core.utils.g1;
import com.bytedance.android.ec.model.PromotionDepositPresaleActivity;
import com.bytedance.android.ec.model.response.anchorv3.PromotionProductButtonStruct;
import com.bytedance.android.ec.model.response.anchorv3.PromotionProductStruct;
import com.bytedance.android.shopping.anchorv3.activities.vo.ActivityVO;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0017\b\u0016\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0002J\u0010\u0010\u0006\u001a\u00020\u00052\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003J\u0010\u0010\t\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0007H\u0016J\b\u0010\u000b\u001a\u00020\nH\u0016J\b\u0010\r\u001a\u00020\fH\u0016J\n\u0010\u000f\u001a\u0004\u0018\u00010\u000eH\u0016J\n\u0010\u0011\u001a\u0004\u0018\u00010\u0010H\u0016R$\u0010\u0018\u001a\u0004\u0018\u00010\u000e8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\"\u0010\u001f\u001a\u00020\f8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001eR$\u0010&\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b \u0010!\u001a\u0004\b\"\u0010#\"\u0004\b$\u0010%¨\u0006'"}, d2 = {"Lcom/bytedance/android/shopping/feed/widget/InflowCardBuyButton;", "Landroidx/appcompat/widget/AppCompatButton;", "", "Lcom/bytedance/android/shopping/anchorv3/activities/vo/ActivityVO;", "activityVO", "", "setDepositPresaleAppointmentButtonText", "", "radius", "setRadius", "Landroid/widget/Button;", "getView", "", "getBuyButtonActivityType", "", "getJumpUrl", "Lcom/bytedance/android/ec/model/response/anchorv3/PromotionProductStruct;", "getPromotion", "a", "Ljava/lang/String;", "getDefaultButtonText", "()Ljava/lang/String;", "setDefaultButtonText", "(Ljava/lang/String;)V", "defaultButtonText", "b", "I", "getButtonType", "()I", "setButtonType", "(I)V", "buttonType", "c", "Lcom/bytedance/android/shopping/anchorv3/activities/vo/ActivityVO;", "getActivity", "()Lcom/bytedance/android/shopping/anchorv3/activities/vo/ActivityVO;", "setActivity", "(Lcom/bytedance/android/shopping/anchorv3/activities/vo/ActivityVO;)V", "activity", "ec-biz-inner-flow-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public class InflowCardBuyButton extends AppCompatButton {
    public String a;
    public int b;
    public ActivityVO c;
    public PromotionProductStruct d;
    public PromotionProductButtonStruct e;

    public InflowCardBuyButton(Context r7) {
        this(r7, null, 0, null, 14);
    }

    public InflowCardBuyButton(Context r7, AttributeSet r8) {
        this(r7, r8, 0, null, 12);
    }

    public InflowCardBuyButton(Context r7, AttributeSet r8, int r9) {
        this(r7, r8, r9, null, 8);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public Button getView() {
        return this;
    }

    public String getJumpUrl() {
        PromotionProductButtonStruct r0 = this.e;
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.getOrderUrl();
    }

    public final ActivityVO getActivity() {
        return this.c;
    }

    public final int getButtonType() {
        return this.b;
    }

    public int getBuyButtonActivityType() {
        return this.b;
    }

    public final String getDefaultButtonText() {
        return this.a;
    }

    public PromotionProductStruct getPromotion() {
        return this.d;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void b(PromotionProductStruct r14) {
        Intrinsics.checkNotNullParameter(r14, "promotion");
        Intrinsics.checkNotNullParameter(new m(r14), "cardVO");
        d63.q r0 = d63.r.a(r14);
        ActivityVO r1 = this.c;
        if (r1 != null) goto L5;
        r1 = f53.a.c(r14);
    L5:
        this.b = 0;
        String r2 = this.a;
        if (r2 != null) goto L11;
        PromotionProductButtonStruct r3 = this.e;
        if (r3 == null) goto L10;
        r2 = r3.getText();
        goto L11
    L10:
        r2 = null;
    L11:
        if (r2 != null) goto L14;
        r2 = ag4.a.d(2131895762);
    L14:
        setText(r2);
        if (r1.isOnActivity() == false) goto L17;
    L20:
        this.b = r1.getActivityType();
    L21:
        int r4 = this.b;
        if (r4 == 3) goto L43;
        if (r4 == 8) goto L29;
        if (r4 != 13) goto L48;
        setBackgroundResource(2131231241);
        setDepositPresaleAppointmentButtonText(r1);
    L48:
        if (r0.c == false) goto L50;
    L69:
        setAlpha(0.5f);
        setOnClickListener(null);
        return;
    L50:
        if (r1.getActivityType() == 4) goto L69;
        PromotionProductButtonStruct r15 = this.e;
        if (r15 == null) goto L57;
        if (r15.getGrayButton() == true) goto L69;
    L57:
        if (r0.a == true) goto L61;
        if (r1.getActivityType() == 5) goto L61;
    L64:
        if (r1.getActivityType() == 13) goto L66;
    L68:
        setAlpha(1.0f);
        return;
    L66:
        if (r1.isAppoint() == false) goto L68;
        setAlpha(0.5f);
        setOnClickListener(null);
        return;
    L61:
        if (r1.getActivityType() == 13) goto L64;
        setAlpha(0.5f);
        setOnClickListener(null);
        return;
    L29:
        if (getBuyButtonActivityType() != 8) goto L48;
        if (a53.a.a() != 1) goto L41;
        PromotionDepositPresaleActivity r5 = r1.getDepositPresaleActivity();
        if (r5 == null) goto L36;
        Long r6 = Long.valueOf(r5.getDepositPrice() / ((long) 100));
    L37:
        if (r6 == null) goto L39;
        StringBuilder r7 = new StringBuilder();
        int r9 = g1.a;
        r7.append(g1.a.c(getContext(), 2131913963, new Object[0]));
        r7.append("\n ¥");
        r7.append(r6);
        SpannableString r8 = new SpannableString(r7.toString());
        AbsoluteSizeSpan r16 = new AbsoluteSizeSpan(12, true);
        ForegroundColorSpan r10 = new ForegroundColorSpan(g1.a.a(getContext(), 2131109402));
        r8.setSpan(r16, 5, r8.length(), 33);
        r8.setSpan(r10, 5, r8.length(), 33);
        setText(r8);
    L40:
        setBackgroundResource(2131231242);
        goto L48
    L39:
        int r11 = g1.a;
        setText(g1.a.c(getContext(), 2131913963, new Object[0]));
        goto L40
    L36:
        r6 = null;
        goto L37
    L41:
        int r12 = g1.a;
        setText(g1.a.c(getContext(), 2131913963, new Object[0]));
        setBackgroundResource(2131231241);
        goto L48
    L43:
        if (r1.isAppoint() == false) goto L45;
        int r13 = g1.a;
        String r17 = g1.a.c(getContext(), 2131895759, new Object[0]);
    L46:
        setText(r17);
        goto L48
    L45:
        int r18 = g1.a;
        r17 = g1.a.c(getContext(), 2131895912, new Object[0]);
        goto L46
    L17:
        if (r1.getActivityType() != 1) goto L21;
        if (r1.getCurTime() >= r1.getStartTime()) goto L21;
        goto L20
    }

    public final void setActivity(ActivityVO r1) {
        this.c = r1;
    }

    public final void setButtonType(int r1) {
        this.b = r1;
    }

    public final void setDefaultButtonText(String r1) {
        this.a = r1;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void setDepositPresaleAppointmentButtonText(ActivityVO r3) {
        if (r3 != null) goto L4;
        return;
    L4:
        if (r3.isAppoint() == false) goto L6;
        int r4 = g1.a;
        c(g1.a.c(getContext(), 2131897006, new Object[0]), 3);
        setOnClickListener(null);
        setAlpha(0.5f);
        return;
    L6:
        int r5 = g1.a;
        c(g1.a.c(getContext(), 2131897008, new Object[0]), 4);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void setRadius(float r2) {
        Drawable r0 = getBackground().mutate();
        if (r0 == null) goto L7;
        ((GradientDrawable) r0).setCornerRadius(r2);
        return;
    L7:
        throw new NullPointerException("null cannot be cast to non-null type android.graphics.drawable.GradientDrawable");
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void c(String r6, int r7) {
        SpannableString r0 = new SpannableString(r6);
        r0.setSpan(new TextAppearanceSpan(getContext(), 2131954544), 0, r7, 33);
        r0.setSpan(new TextAppearanceSpan(getContext(), 2131954545), r7, r6.length(), 33);
        setText(r0, TextView.BufferType.SPANNABLE);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void a(PromotionProductStruct r1, PromotionProductButtonStruct r2, final View.OnClickListener r3, rd3.a r4) {
        Intrinsics.checkNotNullParameter(r1, "promotion");
        this.d = r1;
        this.e = r2;
        b(r1);
        com.bytedance.android.ec.core.widget.f.c(this, null, "bind_product_flow_card", new InflowCardBuyButton$bind$2(r3), 1);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public InflowCardBuyButton(Context r3, AttributeSet r4, int r5, ActivityVO r6, int r7) {
        if ((r7 & 2) == 0) goto L6;
        r4 = null;
    L6:
        if ((r7 & 4) == 0) goto L9;
        r5 = 0;
    L9:
        if ((r7 & 8) == 0) goto L11;
        r6 = null;
    L11:
        Intrinsics.checkNotNullParameter(r3, "context");
        super(r3, r4, r5);
        setText(ag4.a.d(2131895762));
        setGravity(17);
        this.c = r6;
        setTextColor(getResources().getColor(2131109391));
        setBackgroundResource(2131234577);
        if (ld3.c.h() == false) goto L14;
        setMaxLines(1);
    L14:
        se3.a.c(this, 2, 14.0f);
    }
}
