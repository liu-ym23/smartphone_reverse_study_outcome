package com.bytedance.android.shopping.feed.widget;

import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.bytedance.android.ec.core.utils.y;
import com.bytedance.android.ec.model.ECUrlModel;
import com.bytedance.android.ec.model.response.anchorv3.Description;
import com.bytedance.android.ec.model.response.anchorv3.ExchangeCoupons;
import com.facebook.drawee.view.SimpleDraweeView;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0015\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\u0018\u00002\u00020\u0001:\u0002\u0006\fB'\b\u0007\u0012\u0006\u0010\u001c\u001a\u00020\u001b\u0012\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\u001d\u0012\b\b\u0002\u0010 \u001a\u00020\u001f¢\u0006\u0004\b!\u0010\"J\b\u0010\u0003\u001a\u00020\u0002H\u0002R#\u0010\n\u001a\n \u0005*\u0004\u0018\u00010\u00040\u00048BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0006\u0010\u0007\u001a\u0004\b\b\u0010\tR#\u0010\u000f\u001a\n \u0005*\u0004\u0018\u00010\u000b0\u000b8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\f\u0010\u0007\u001a\u0004\b\r\u0010\u000eR#\u0010\u0014\u001a\n \u0005*\u0004\u0018\u00010\u00100\u00108BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0011\u0010\u0007\u001a\u0004\b\u0012\u0010\u0013R#\u0010\u0017\u001a\n \u0005*\u0004\u0018\u00010\u00100\u00108BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0015\u0010\u0007\u001a\u0004\b\u0016\u0010\u0013R#\u0010\u001a\u001a\n \u0005*\u0004\u0018\u00010\u00100\u00108BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0018\u0010\u0007\u001a\u0004\b\u0019\u0010\u0013¨\u0006#"}, d2 = {"Lcom/bytedance/android/shopping/feed/widget/ExchangeCouponView;", "Landroid/widget/FrameLayout;", "", "getColors", "Landroid/widget/LinearLayout;", "kotlin.jvm.PlatformType", "a", "Lkotlin/Lazy;", "getExchangeCouponContainer", "()Landroid/widget/LinearLayout;", "exchangeCouponContainer", "Lcom/facebook/drawee/view/SimpleDraweeView;", "b", "getCouponIcon", "()Lcom/facebook/drawee/view/SimpleDraweeView;", "couponIcon", "Landroid/widget/TextView;", "c", "getCouponDesc", "()Landroid/widget/TextView;", "couponDesc", "d", "getCouponDescPrice", "couponDescPrice", "e", "getCouponButton", "couponButton", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "ec-biz-inner-flow-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ExchangeCouponView extends FrameLayout {
    public final Lazy a;
    public final Lazy b;
    public final Lazy c;
    public final Lazy d;
    public final Lazy e;
    public ExchangeCoupons f;
    public b g;

    public static final class a {
    }

    public interface b {
        void a();
    }

    static {
    }

    public ExchangeCouponView(Context r4) {
        AttributeSet r2 = null;
        this(r4, r2, 6, 0);
    }

    public ExchangeCouponView(Context r3, AttributeSet r4) {
        this(r3, r4, 4, 0);
    }

    private final TextView getCouponButton() {
        return (TextView) this.e.getValue();
    }

    private final TextView getCouponDesc() {
        return (TextView) this.c.getValue();
    }

    private final TextView getCouponDescPrice() {
        return (TextView) this.d.getValue();
    }

    private final SimpleDraweeView getCouponIcon() {
        return (SimpleDraweeView) this.b.getValue();
    }

    private final LinearLayout getExchangeCouponContainer() {
        return (LinearLayout) this.a.getValue();
    }

    private final int[] getColors() {
        ArrayList r0 = new ArrayList();
        ExchangeCoupons r1 = this.f;
        if (r1 == null) goto L13;
        List r2 = r1.getBackgroundColor();
        if (r2 == null) goto L13;
        Iterator r3 = r2.iterator();
    L8:
        if (r3.hasNext() == false) goto L13;
        Integer r4 = com.bytedance.android.ec.core.utils.s.b((String) r3.next());
        if (r4 == null) goto L8;
        r0.add(Integer.valueOf(r4.intValue()));
    L13:
        return CollectionsKt.toIntArray(r0);
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        b r0 = this.g;
        if (r0 == null) goto L6;
        r0.a();
        return;
    }

    public static final /* synthetic */ int[] a(ExchangeCouponView r0) {
        return r0.getColors();
    }

    public final void b(ExchangeCoupons r4, b r5) {
        Intrinsics.checkNotNullParameter(r4, "exchangeCoupons");
        this.f = r4;
        this.g = r5;
        getExchangeCouponContainer().setBackground(com.bytedance.commerce.base.drawable.a.a(new ExchangeCouponView$initView$1(this)));
        ExchangeCoupons r6 = this.f;
        if (r6 == null) goto L10;
        ECUrlModel r7 = r6.getIcon();
        if (r7 == null) goto L10;
        if (r7.getHeight() == 0) goto L9;
        ViewGroup.LayoutParams r8 = getCouponIcon().getLayoutParams();
        float r0 = (int) (((r7.getWidth() * 1.0f) / r7.getHeight()) * 12);
        Resources r1 = Resources.getSystem();
        r8.width = MathKt.roundToInt(TypedValue.applyDimension(1, r0, WindowDisplayMetricsOverride.apply(r1, r1.getDisplayMetrics())));
    L9:
        y.a(getCouponIcon(), r7);
    L10:
        TextView r9 = getCouponDesc();
        ExchangeCoupons r10 = this.f;
        String r2 = "";
        if (r10 == null) goto L17;
        Description r11 = r10.getMainMainDescription();
        if (r11 == null) goto L17;
        String r12 = r11.getText();
        if (r12 == null) goto L17;
    L18:
        r9.setText(r12);
        ExchangeCoupons r13 = this.f;
        if (r13 == null) goto L27;
        Description r14 = r13.getMainMainDescription();
        if (r14 == null) goto L27;
        String r15 = r14.getColor();
        if (r15 == null) goto L27;
        Integer r16 = com.bytedance.android.ec.core.utils.s.b(r15);
        if (r16 == null) goto L27;
        getCouponDesc().setTextColor(r16.intValue());
    L27:
        TextView r17 = getCouponDescPrice();
        ExchangeCoupons r18 = this.f;
        if (r18 == null) goto L34;
        Description r19 = r18.getSubDescription();
        if (r19 == null) goto L34;
        String r20 = r19.getText();
        if (r20 == null) goto L34;
    L35:
        r17.setText(r20);
        ExchangeCoupons r21 = this.f;
        if (r21 == null) goto L44;
        Description r22 = r21.getSubDescription();
        if (r22 == null) goto L44;
        String r23 = r22.getColor();
        if (r23 == null) goto L44;
        Integer r24 = com.bytedance.android.ec.core.utils.s.b(r23);
        if (r24 == null) goto L44;
        getCouponDescPrice().setTextColor(r24.intValue());
    L44:
        TextView r25 = getCouponButton();
        ExchangeCoupons r26 = this.f;
        if (r26 == null) goto L51;
        Description r27 = r26.getButton();
        if (r27 == null) goto L51;
        String r28 = r27.getText();
        if (r28 == null) goto L51;
        r2 = r28;
    L51:
        r25.setText(r2);
        ExchangeCoupons r29 = this.f;
        if (r29 == null) goto L61;
        Description r30 = r29.getButton();
        if (r30 == null) goto L62;
        String r31 = r30.getColor();
        if (r31 == null) goto L63;
        Integer r32 = com.bytedance.android.ec.core.utils.s.b(r31);
        if (r32 == null) goto L64;
        getCouponButton().setTextColor(r32.intValue());
        return;
    L64:
        return;
    L63:
        return;
    L62:
        return;
    L61:
        return;
    L34:
        r20 = "";
    L17:
        r12 = "";
        goto L18
    }

    public ExchangeCouponView(Context r2, AttributeSet r3, int r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2, r3, r4);
        LayoutInflater.from(r2).inflate(2131560565, this);
        this.a = LazyKt.lazy(new ExchangeCouponView$exchangeCouponContainer$2(this));
        this.b = LazyKt.lazy(new ExchangeCouponView$couponIcon$2(this));
        this.c = LazyKt.lazy(new ExchangeCouponView$couponDesc$2(this));
        this.d = LazyKt.lazy(new ExchangeCouponView$couponDescPrice$2(this));
        this.e = LazyKt.lazy(new ExchangeCouponView$couponButton$2(this));
    }

    public /* synthetic */ ExchangeCouponView(Context r1, AttributeSet r2, int r3, int r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = null;
    L5:
        this(r1, r2, 0);
    }
}
