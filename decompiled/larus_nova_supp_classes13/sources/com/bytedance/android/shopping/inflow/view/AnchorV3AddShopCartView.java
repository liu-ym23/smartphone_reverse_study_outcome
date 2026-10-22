package com.bytedance.android.shopping.inflow.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.bytedance.android.ec.core.utils.s0;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.greenrobot.eventbus.Subscribe;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0016\u0018\u00002\u00020\u0001:\u0001\u0016B'\b\u0007\u0012\u0006\u0010\u0010\u001a\u00020\u000f\u0012\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u0011\u0012\b\b\u0002\u0010\u0013\u001a\u00020\f¢\u0006\u0004\b\u0014\u0010\u0015J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0007J\u0010\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0006H\u0007J&\u0010\u000e\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\b2\u0006\u0010\r\u001a\u00020\f¨\u0006\u0017"}, d2 = {"Lcom/bytedance/android/shopping/inflow/view/AnchorV3AddShopCartView;", "Landroid/widget/FrameLayout;", "Lhl/d;", "event", "", "onCartCountChangeEvent", "Lhl/b;", "addShopCartSuccessEvent", "", "white", "asBottom", "show", "", "cartProductCount", "update", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "a", "ec-biz-inner-flow-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public class AnchorV3AddShopCartView extends FrameLayout {
    public ImageView a;
    public View b;

    public static final class a {
    }

    static {
    }

    public AnchorV3AddShopCartView(Context r4) {
        AttributeSet r2 = null;
        this(r4, r2, 6, 0);
    }

    public AnchorV3AddShopCartView(Context r3, AttributeSet r4) {
        this(r3, r4, 4, 0);
    }

    public FrameLayout.LayoutParams a() {
        return new FrameLayout.LayoutParams(-1, -1, 17);
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        s0.c(this);
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        s0.e(this);
    }

    @Subscribe
    public final void addShopCartSuccessEvent(hl.b r3) {
        Intrinsics.checkNotNullParameter(r3, "event");
        if (r3.a <= 0) goto L17;
        View r0 = this.b;
        if (r0 == null) goto L7;
        r0.setVisibility(0);
    L7:
        View r1 = this.b;
        if ((r1 instanceof TextView) == true) goto L10;
        r1 = null;
    L10:
        TextView r2 = (TextView) r1;
        if (r2 == null) goto L21;
        int r4 = r3.a;
        if (r4 <= 99) goto L15;
        String r5 = "99+";
    L16:
        r2.setText(r5);
        return;
    L15:
        r5 = String.valueOf(r4);
        goto L16
    L21:
        return;
    L17:
        View r6 = this.b;
        if (r6 == null) goto L23;
        r6.setVisibility(8);
        return;
    }

    @Subscribe
    public final void onCartCountChangeEvent(hl.d r3) {
        Intrinsics.checkNotNullParameter(r3, "event");
        int r4 = r3.a;
        if (r4 <= 0) goto L17;
        View r0 = this.b;
        if (r0 == null) goto L7;
        r0.setVisibility(0);
    L7:
        View r1 = this.b;
        if ((r1 instanceof TextView) == true) goto L10;
        r1 = null;
    L10:
        TextView r2 = (TextView) r1;
        if (r2 != null) goto L13;
        return;
    L13:
        if (r4 <= 99) goto L15;
        String r5 = "99+";
    L16:
        r2.setText(r5);
        return;
    L15:
        r5 = String.valueOf(r4);
        goto L16
    L17:
        View r6 = this.b;
        if (r6 == null) goto L23;
        r6.setVisibility(8);
        return;
    }

    public AnchorV3AddShopCartView(Context r2, AttributeSet r3, int r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2, r3, r4);
    }

    public /* synthetic */ AnchorV3AddShopCartView(Context r1, AttributeSet r2, int r3, int r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = null;
    L5:
        this(r1, r2, 0);
    }

    public final void update(boolean r7, boolean r8, boolean r9, int r10) {
        if (r9 == false) goto L47;
        setVisibility(0);
        int r3 = 2131231295;
        if (getChildCount() != 2) goto L25;
        View r11 = getChildAt(0);
        View r12 = getChildAt(1);
        if (r11 != null) goto L9;
        return;
    L9:
        if (Intrinsics.areEqual(r11, this.a) == false) goto L50;
        if (r12 != null) goto L12;
        return;
    L12:
        if (Intrinsics.areEqual(r12, this.b) == false) goto L52;
        View r13 = this.b;
        if (r13 == null) goto L16;
        r13.setVisibility(8);
    L16:
        ImageView r14 = this.a;
        if (r14 == null) goto L53;
        if (r8 == false) goto L20;
        r3 = 2131233528;
    L23:
        r14.setBackgroundResource(r3);
        return;
    L20:
        if (r7 == true) goto L23;
        r3 = 2131231294;
        goto L23
    L53:
        return;
    L52:
        return;
    L50:
        return;
    L25:
        removeAllViews();
        ImageView r1 = new ImageView(getContext());
        if (r8 == false) goto L28;
        r3 = 2131233528;
    L31:
        r1.setBackgroundResource(r3);
        addView(r1, a());
        Unit r15 = Unit.INSTANCE;
        this.a = r1;
        View r16 = LayoutInflater.from(getContext()).inflate(2131564850, this, false);
        if (r10 <= 0) goto L44;
        r16.setVisibility(0);
        if ((r16 instanceof TextView) == true) goto L36;
        View r17 = null;
    L37:
        TextView r18 = (TextView) r17;
        if (r18 != null) goto L40;
    L45:
        addView(r16);
        this.b = r16;
        return;
    L40:
        if (r10 <= 99) goto L42;
        String r19 = "99+";
    L43:
        r18.setText(r19);
        goto L45
    L42:
        r19 = String.valueOf(r10);
        goto L43
    L36:
        r17 = r16;
        goto L37
    L44:
        r16.setVisibility(8);
        goto L45
    L28:
        if (r7 == true) goto L31;
        r3 = 2131231294;
        goto L31
    L47:
        setVisibility(8);
    }
}
