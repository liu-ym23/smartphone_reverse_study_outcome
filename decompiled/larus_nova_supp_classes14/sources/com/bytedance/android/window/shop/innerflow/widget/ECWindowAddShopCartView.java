package com.bytedance.android.window.shop.innerflow.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.bytedance.android.ec.core.utils.s0;
import com.bytedance.android.shopping.extensions.b;
import hl.d;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.greenrobot.eventbus.Subscribe;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\b&\u0018\u00002\u00020\u0001:\u0001\u0014B'\b\u0007\u0012\u0006\u0010\u000e\u001a\u00020\r\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u000f\u0012\b\b\u0002\u0010\u0011\u001a\u00020\u0002¢\u0006\u0004\b\u0012\u0010\u0013J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0007J\u0010\u0010\t\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\bH\u0007J\b\u0010\u000b\u001a\u00020\nH\u0016J\b\u0010\f\u001a\u00020\u0002H\u0016¨\u0006\u0015"}, d2 = {"Lcom/bytedance/android/window/shop/innerflow/widget/ECWindowAddShopCartView;", "Landroid/widget/FrameLayout;", "", "getProperImage", "Lhl/d;", "event", "", "onCartCountChanged", "Lhl/b;", "onAddToShopCartSuccess", "Landroid/widget/TextView;", "getAndAddDotTextView", "getProductCountLimit", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "a", "ec-biz-store-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public abstract class ECWindowAddShopCartView extends FrameLayout {
    public ImageView a;
    public TextView b;

    public static final class a {
    }

    static {
    }

    public ECWindowAddShopCartView(Context r4) {
        AttributeSet r2 = null;
        this(r4, r2, 6, 0);
    }

    public ECWindowAddShopCartView(Context r3, AttributeSet r4) {
        this(r3, r4, 4, 0);
    }

    private final int getProperImage() {
        return 2131234712;
    }

    public int getProductCountLimit() {
        return 99;
    }

    public FrameLayout.LayoutParams b() {
        return new FrameLayout.LayoutParams(b.b(32), b.b(32), 3);
    }

    public TextView getAndAddDotTextView() {
        View r0 = LayoutInflater.from(getContext()).inflate(2131564849, this, false);
        addView(r0);
        if (r0 == null) goto L7;
        return (TextView) r0;
    L7:
        throw new NullPointerException("null cannot be cast to non-null type android.widget.TextView");
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

    public final String a(int r2) {
        if (r2 <= getProductCountLimit()) goto L6;
        StringBuilder r3 = new StringBuilder();
        r3.append(getProductCountLimit());
        r3.append('+');
        return r3.toString();
    L6:
        return String.valueOf(r2);
    }

    public final void c(int r5) {
        setVisibility(0);
        if (getChildCount() != 2) goto L18;
        View r6 = getChildAt(0);
        View r0 = getChildAt(1);
        if (r6 != null) goto L7;
        return;
    L7:
        if (Intrinsics.areEqual(r6, this.a) == false) goto L25;
        if (r0 != null) goto L10;
        return;
    L10:
        if (Intrinsics.areEqual(r0, this.b) == false) goto L27;
        TextView r7 = this.b;
        if (r7 == null) goto L14;
        r7.setVisibility(8);
    L14:
        ImageView r8 = this.a;
        if (r8 == null) goto L28;
        r8.setBackgroundResource(getProperImage());
        return;
    L28:
        return;
    L27:
        return;
    L25:
        return;
    L18:
        removeAllViews();
        ImageView r1 = new ImageView(getContext());
        r1.setScaleType(ImageView.ScaleType.FIT_XY);
        r1.setBackgroundResource(getProperImage());
        addView(r1, b());
        Unit r2 = Unit.INSTANCE;
        this.a = r1;
        TextView r3 = getAndAddDotTextView();
        if (r5 <= 0) goto L21;
        r3.setVisibility(0);
        r3.setText(a(r5));
    L22:
        this.b = r3;
        return;
    L21:
        r3.setVisibility(8);
        goto L22
    }

    @Subscribe
    public final void onAddToShopCartSuccess(hl.b r3) {
        Intrinsics.checkNotNullParameter(r3, "event");
        if (r3.a <= 0) goto L10;
        TextView r0 = this.b;
        if (r0 == null) goto L7;
        r0.setVisibility(0);
    L7:
        TextView r1 = this.b;
        if (r1 == null) goto L14;
        r1.setText(a(r3.a));
        return;
    L14:
        return;
    L10:
        TextView r4 = this.b;
        if (r4 == null) goto L16;
        r4.setVisibility(8);
        return;
    }

    @Subscribe
    public final void onCartCountChanged(d r3) {
        Intrinsics.checkNotNullParameter(r3, "event");
        int r4 = r3.a;
        if (r4 <= 0) goto L10;
        TextView r0 = this.b;
        if (r0 == null) goto L7;
        r0.setVisibility(0);
    L7:
        TextView r1 = this.b;
        if (r1 == null) goto L14;
        r1.setText(a(r4));
        return;
    L14:
        return;
    L10:
        TextView r5 = this.b;
        if (r5 == null) goto L16;
        r5.setVisibility(8);
        return;
    }

    public ECWindowAddShopCartView(Context r2, AttributeSet r3, int r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2, r3, r4);
    }

    public /* synthetic */ ECWindowAddShopCartView(Context r1, AttributeSet r2, int r3, int r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = null;
    L5:
        this(r1, r2, 0);
    }
}
