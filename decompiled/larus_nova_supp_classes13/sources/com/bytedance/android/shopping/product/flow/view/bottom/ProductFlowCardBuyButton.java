package com.bytedance.android.shopping.product.flow.view.bottom;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.text.SpannableString;
import android.text.style.AbsoluteSizeSpan;
import android.text.style.ForegroundColorSpan;
import android.text.style.TextAppearanceSpan;
import android.util.AttributeSet;
import android.widget.Button;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatButton;
import ch3.b;
import com.bytedance.android.ec.core.utils.g1;
import com.bytedance.android.ec.model.PromotionDepositPresaleActivity;
import com.bytedance.android.ec.model.response.anchorv3.PromotionProductStruct;
import com.bytedance.android.shopping.anchorv3.activities.vo.ActivityVO;
import d63.q;
import d63.r;
import f53.a;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0016\u0018\u00002\u00020\u00012\u00020\u0002B'\b\u0007\u0012\u0006\u0010\u001e\u001a\u00020\u001d\u0012\n\b\u0002\u0010 \u001a\u0004\u0018\u00010\u001f\u0012\b\b\u0002\u0010!\u001a\u00020\f¢\u0006\u0004\b\"\u0010#J\u0010\u0010\u0006\u001a\u00020\u00052\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003J\u0010\u0010\t\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0007H\u0016J\b\u0010\u000b\u001a\u00020\nH\u0016J\b\u0010\r\u001a\u00020\fH\u0016R\"\u0010\u0014\u001a\u00020\f8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R$\u0010\u001c\u001a\u0004\u0018\u00010\u00158\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001b¨\u0006$"}, d2 = {"Lcom/bytedance/android/shopping/product/flow/view/bottom/ProductFlowCardBuyButton;", "Landroidx/appcompat/widget/AppCompatButton;", "", "Lcom/bytedance/android/shopping/anchorv3/activities/vo/ActivityVO;", "activityVO", "", "setDepositPresaleAppointmentButtonText", "", "radius", "setRadius", "Landroid/widget/Button;", "getView", "", "getBuyButtonActivityType", "a", "I", "getButtonType", "()I", "setButtonType", "(I)V", "buttonType", "", "b", "Ljava/lang/String;", "getDefaultButtonText", "()Ljava/lang/String;", "setDefaultButtonText", "(Ljava/lang/String;)V", "defaultButtonText", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "ec-core_saasRelease"}, k = 1, mv = {1, 4, 3})
public class ProductFlowCardBuyButton extends AppCompatButton {
    public int a;
    public String b;

    public ProductFlowCardBuyButton(Context r4) {
        AttributeSet r2 = null;
        this(r4, r2, 6, 0);
    }

    public ProductFlowCardBuyButton(Context r3, AttributeSet r4) {
        this(r3, r4, 4, 0);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public Button getView() {
        return this;
    }

    public final int getButtonType() {
        return this.a;
    }

    public int getBuyButtonActivityType() {
        return this.a;
    }

    public final String getDefaultButtonText() {
        return this.b;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void a(PromotionProductStruct r14) {
        Intrinsics.checkNotNullParameter(r14, "promotion");
        Intrinsics.checkNotNullParameter(new b(r14), "cardVO");
        q r0 = r.a(r14);
        ActivityVO r15 = a.c(r14);
        this.a = 0;
        String r2 = this.b;
        if (r2 != null) goto L8;
        r2 = r0.p;
        if (r2 != null) goto L8;
        r2 = ag4.a.d(2131895762);
    L8:
        setText(r2);
        setBackgroundResource(2131247912);
        if (r15.isOnActivity() == false) goto L11;
    L14:
        this.a = r15.getActivityType();
    L15:
        int r3 = this.a;
        if (r3 != 2) goto L18;
        setBackgroundResource(2131234348);
    L45:
        if (r0.c == false) goto L47;
    L62:
        setBackgroundResource(2131247911);
        setAlpha(0.5f);
        setOnClickListener(null);
        return;
    L47:
        if (r15.getActivityType() == 4) goto L62;
        if (r0.a == true) goto L54;
        if (r15.getActivityType() == 5) goto L54;
    L57:
        if (r15.getActivityType() == 13) goto L59;
    L61:
        setAlpha(1.0f);
        return;
    L59:
        if (r15.isAppoint() == false) goto L61;
        setAlpha(0.5f);
        setOnClickListener(null);
        return;
    L54:
        if (r15.getActivityType() == 13) goto L57;
        setBackgroundResource(2131247911);
        setAlpha(0.5f);
        setOnClickListener(null);
        return;
    L18:
        if (r3 == 3) goto L39;
        if (r3 == 8) goto L28;
        if (r3 == 9) goto L26;
        if (r3 != 13) goto L45;
        setBackgroundResource(2131231241);
        setDepositPresaleAppointmentButtonText(r15);
        goto L45
    L26:
        setBackgroundResource(2131247911);
        setOnClickListener(null);
        goto L45
    L28:
        if (a53.a.a() != 1) goto L37;
        PromotionDepositPresaleActivity r4 = r15.getDepositPresaleActivity();
        if (r4 == null) goto L32;
        Long r5 = Long.valueOf(r4.getDepositPrice() / ((long) 100));
    L33:
        if (r5 == null) goto L35;
        StringBuilder r9 = new StringBuilder();
        int r10 = g1.a;
        r9.append(g1.a.c(getContext(), 2131913963, new Object[0]));
        r9.append("\n ¥");
        r9.append(r5);
        SpannableString r6 = new SpannableString(r9.toString());
        AbsoluteSizeSpan r1 = new AbsoluteSizeSpan(12, true);
        ForegroundColorSpan r7 = new ForegroundColorSpan(g1.a.a(getContext(), 2131109402));
        r6.setSpan(r1, 5, r6.length(), 33);
        r6.setSpan(r7, 5, r6.length(), 33);
        setText(r6);
    L36:
        setBackgroundResource(2131231242);
        goto L45
    L35:
        int r8 = g1.a;
        setText(g1.a.c(getContext(), 2131913963, new Object[0]));
        goto L36
    L32:
        r5 = null;
        goto L33
    L37:
        int r11 = g1.a;
        setText(g1.a.c(getContext(), 2131913963, new Object[0]));
        setBackgroundResource(2131231241);
        goto L45
    L39:
        if (r15.isAppoint() == false) goto L41;
        int r12 = g1.a;
        String r13 = g1.a.c(getContext(), 2131895759, new Object[0]);
    L42:
        setText(r13);
        setBackgroundResource(2131234346);
        goto L45
    L41:
        int r16 = g1.a;
        r13 = g1.a.c(getContext(), 2131895912, new Object[0]);
        goto L42
    L11:
        if (r15.getActivityType() != 1) goto L15;
        if (r15.getCurTime() >= r15.getStartTime()) goto L15;
        goto L14
    }

    public final void setButtonType(int r1) {
        this.a = r1;
    }

    public final void setDefaultButtonText(String r1) {
        this.b = r1;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void setDepositPresaleAppointmentButtonText(ActivityVO r3) {
        if (r3 != null) goto L4;
        return;
    L4:
        if (r3.isAppoint() == false) goto L6;
        int r4 = g1.a;
        b(g1.a.c(getContext(), 2131897006, new Object[0]), 3);
        setOnClickListener(null);
        setAlpha(0.5f);
        return;
    L6:
        int r5 = g1.a;
        b(g1.a.c(getContext(), 2131897008, new Object[0]), 4);
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
    public final void b(String r6, int r7) {
        SpannableString r0 = new SpannableString(r6);
        r0.setSpan(new TextAppearanceSpan(getContext(), 2131954544), 0, r7, 33);
        r0.setSpan(new TextAppearanceSpan(getContext(), 2131954545), r7, r6.length(), 33);
        setText(r0, TextView.BufferType.SPANNABLE);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public ProductFlowCardBuyButton(Context r2, AttributeSet r3, int r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2, r3, r4);
        setTextColor(-1);
        setText(ag4.a.d(2131895762));
        setGravity(17);
        setTextColor(getResources().getColor(2131109391));
        setBackgroundResource(2131247912);
    }

    public /* synthetic */ ProductFlowCardBuyButton(Context r1, AttributeSet r2, int r3, int r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = null;
    L5:
        this(r1, r2, 0);
    }
}
