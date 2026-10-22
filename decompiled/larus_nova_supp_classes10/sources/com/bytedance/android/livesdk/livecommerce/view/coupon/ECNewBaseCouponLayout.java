package com.bytedance.android.livesdk.livecommerce.view.coupon;

import android.content.Context;
import android.text.SpannableString;
import android.text.style.AbsoluteSizeSpan;
import android.text.style.StyleSpan;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.bytedance.android.ec.core.utils.ECLiveImageUtils;
import com.bytedance.android.livesdk.livecommerce.utils.k;
import com.bytedance.android.livesdk.livecommerce.utils.w0;
import com.bytedance.android.livesdk.livecommerce.view.ECPriceView;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;
import si2.p;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\b&\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\t¨\u0006\n"}, d2 = {"Lcom/bytedance/android/livesdk/livecommerce/view/coupon/ECNewBaseCouponLayout;", "Landroid/widget/FrameLayout;", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "livecommerce_saasRelease"}, k = 1, mv = {1, 4, 3})
public abstract class ECNewBaseCouponLayout extends FrameLayout {
    public Map<Integer, View> a;

    public ECNewBaseCouponLayout(Context r4) {
        AttributeSet r2 = null;
        this(r4, r2, 6, 0);
    }

    public ECNewBaseCouponLayout(Context r3, AttributeSet r4) {
        this(r3, r4, 4, 0);
    }

    public View a(int r3) {
        if (this.a != null) goto L5;
        this.a = new LinkedHashMap();
    L5:
        View r0 = this.a.get(Integer.valueOf(r3));
        if (r0 != null) goto L12;
        View r1 = findViewById(r3);
        if (r1 == null) goto L10;
        this.a.put(Integer.valueOf(r3), r1);
        return r1;
    L10:
        return null;
    L12:
        return r0;
    }

    public void b(p r15) {
        Intrinsics.checkNotNullParameter(r15, "ecuiCoupon");
        boolean r2 = true;
        ((TextView) a(2131370801)).setText(getContext().getResources().getString(2131896428, new Object[]{Integer.valueOf(r15.i)}));
        ((TextView) a(2131370799)).setText(r15.h);
        TextView r0 = (TextView) a(2131370803);
        if (r15.f != 1) goto L5;
        String r1 = r15.e;
    L6:
        r0.setText(r1);
        float r3 = 30.0f;
        if (r15.a != 1) goto L9;
        ((TextView) a(2131370797)).setVisibility(8);
        ((LinearLayout) a(2131370800)).setVisibility(8);
        ((RelativeLayout) a(2131370796)).setVisibility(0);
        String r4 = k.g(MathKt.roundToLong(r15.b * ((double) 100)));
        TextView r5 = (TextView) a(2131370795);
        SpannableString r6 = new SpannableString(r4 + getContext().getString(2131896938));
        r6.setSpan(new AbsoluteSizeSpan(w0.a(30.0f)), 0, r4.length(), 17);
        r6.setSpan(new StyleSpan(1), 0, r4.length(), 17);
        r6.setSpan(new AbsoluteSizeSpan(w0.a(11.0f)), r4.length(), r4.length() + 1, 17);
        Unit r7 = Unit.INSTANCE;
        r5.setText(r6);
    L32:
        String r8 = r15.o;
        if (r8 == null) goto L39;
        if (r8.length() == 0) goto L39;
        r2 = false;
    L39:
        if (r2 == false) goto L44;
        ViewGroup.LayoutParams r16 = a(2131370709).getLayoutParams();
        if (r16 == null) goto L43;
        r16.width = w0.a(26.0f);
        r16.height = w0.a(28.0f);
    L43:
        a(2131370709).setVisibility(0);
        a(2131370709).setImageResource(2131234633);
        return;
    L44:
        a(2131370709).setVisibility(0);
        ViewGroup.LayoutParams r9 = a(2131370709).getLayoutParams();
        if (r9 == null) goto L47;
        r9.width = w0.a(r15.p);
        r9.height = w0.a(r15.q);
    L47:
        ECLiveImageUtils.i(a(2131370709), r15.o, 0, 0);
        return;
    L9:
        ((LinearLayout) a(2131370800)).setVisibility(0);
        ((TextView) a(2131370797)).setVisibility(0);
        ((RelativeLayout) a(2131370796)).setVisibility(8);
        String r10 = String.valueOf(r15.c);
        ECPriceView r11 = (ECPriceView) a(2131370802);
        int r12 = r10.length();
        float r13 = 18.0f;
        if (r12 == 1) goto L19;
        if (r12 == 2) goto L19;
        if (r12 == 3) goto L18;
        if (r12 == 4) goto L17;
        if (r12 == 5) goto L16;
        r3 = 11.0f;
        goto L19
    L16:
        r3 = 16.0f;
        goto L19
    L17:
        r3 = 18.0f;
        goto L19
    L18:
        r3 = 24.0f;
    L19:
        r11.setPriceTextSize(w0.a(r3));
        ECPriceView r14 = (ECPriceView) a(2131370802);
        int r17 = r10.length();
        if (r17 == 1) goto L28;
        if (r17 == 2) goto L28;
        if (r17 == 3) goto L27;
        if (r17 == 4) goto L26;
        if (r17 == 5) goto L26;
        r13 = 10.0f;
    L26:
        r13 = 12.0f;
        goto L28
    L27:
        r13 = 14.0f;
    L28:
        r14.setYangTextSize(w0.a(r13));
        ((ECPriceView) a(2131370802)).setPriceText(r10);
        if (r15.a != 2) goto L31;
        ((TextView) a(2131370797)).setText(getContext().getResources().getString(2131896434));
        goto L32
    L31:
        ((TextView) a(2131370797)).setText(getContext().getResources().getString(2131896433, new Object[]{Integer.valueOf(r15.d)}));
        goto L32
    L5:
        r1 = getContext().getResources().getString(2131896921, new Object[]{Integer.valueOf(r15.g)});
        goto L6
    }

    public ECNewBaseCouponLayout(Context r3, AttributeSet r4, int r5) {
        Intrinsics.checkNotNullParameter(r3, "context");
        super(r3, r4, r5);
        this.a = new LinkedHashMap();
        View.inflate(r3, 2131560792, this);
        ((ImageView) a(2131370710)).setVisibility(0);
        ViewGroup.LayoutParams r6 = ((RelativeLayout) a(2131391314)).getLayoutParams();
        if (r6 == null) goto L11;
        ViewGroup.MarginLayoutParams r7 = (ViewGroup.MarginLayoutParams) r6;
        r7.topMargin = w0.a(5.0f);
        ((RelativeLayout) a(2131391314)).setLayoutParams(r7);
        ViewGroup.LayoutParams r8 = ((RelativeLayout) a(2131390861)).getLayoutParams();
        if (r8 == null) goto L9;
        ViewGroup.MarginLayoutParams r9 = (ViewGroup.MarginLayoutParams) r8;
        r9.topMargin = w0.a(5.0f);
        ((RelativeLayout) a(2131390861)).setLayoutParams(r9);
        return;
    L9:
        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
    L11:
        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
    }

    public /* synthetic */ ECNewBaseCouponLayout(Context r1, AttributeSet r2, int r3, int r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = null;
    L5:
        this(r1, r2, 0);
    }
}
