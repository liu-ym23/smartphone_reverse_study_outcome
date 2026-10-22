package com.bytedance.android.shopping.anchorv4.voavhs.base.elements;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.bytedance.android.ec.core.opt.asyncInflate.ShoppingAsyncInflater;
import com.bytedance.android.ec.core.utils.a2;
import com.bytedance.android.shopping.anchorv4.dto.base.Action;
import com.bytedance.android.shopping.anchorv4.dto.base.ImageModel;
import com.bytedance.android.shopping.anchorv4.dto.elements.CouponButtonElement;
import com.bytedance.android.shopping.anchorv4.dto.elements.TextElement;
import com.bytedance.android.shopping.anchorv4.dto.elements.TextWithOneIconElement;
import com.bytedance.android.shopping.anchorv4.voavhs.base.design.ActionHubAccessor;
import com.bytedance.android.shopping.anchorv4.voavhs.base.extensions.ImageExtensionsKt;
import com.facebook.drawee.view.SimpleDraweeView;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u00012\u00020\u0002J\u0010\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0016¨\u0006\u0007"}, d2 = {"Lcom/bytedance/android/shopping/anchorv4/voavhs/base/elements/CouponButtonElementView;", "Landroidx/constraintlayout/widget/ConstraintLayout;", "Lcom/bytedance/android/shopping/anchorv4/voavhs/base/design/ActionHubAccessor;", "Lcom/bytedance/android/shopping/anchorv4/voavhs/base/design/a;", "hub", "", "setActionHub", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class CouponButtonElementView extends ConstraintLayout implements ActionHubAccessor {
    public final TextWithOneIconElementView a;
    public final TextWithOneIconElementView b;
    public final AppCompatImageView c;
    public final SimpleDraweeView d;
    public CouponButtonElement e;
    public com.bytedance.android.shopping.anchorv4.voavhs.base.design.a f;

    public CouponButtonElementView(Context r4) {
        this(r4, null, 0, 14);
    }

    public CouponButtonElementView(Context r3, AttributeSet r4) {
        this(r3, r4, 0, 12);
    }

    public CouponButtonElementView(Context r2, AttributeSet r3, int r4) {
        this(r2, r3, r4, 8);
    }

    @Override // com.bytedance.android.shopping.anchorv4.voavhs.base.design.ActionHubAccessor
    public final Action associatedAction() {
        return null;
    }

    @Override // com.bytedance.android.shopping.anchorv4.voavhs.base.design.ActionHubAccessor
    public final com.bytedance.android.shopping.anchorv4.voavhs.base.design.a actionHub() {
        return this.f;
    }

    @Override // com.bytedance.android.shopping.anchorv4.voavhs.base.design.ActionHubAccessor
    public final Object descriptionVO() {
        return this.e;
    }

    @Override // com.bytedance.android.shopping.anchorv4.voavhs.base.design.ActionHubAccessor
    public final void dispatchPossibleShow() {
        ActionHubAccessor.DefaultImpls.b(this);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void R5(final CouponButtonElement r13) {
        this.e = r13;
        if (r13 != null) goto L5;
        return;
    L5:
        TextWithOneIconElement r0 = r13.getPrefix();
        boolean r2 = true;
        if (r0 == null) goto L23;
        TextElement r5 = r0.getContent();
        if (r5 == null) goto L10;
        String r6 = r5.getText();
    L12:
        if (a2.b(r6) == false) goto L14;
    L17:
        boolean r7 = true;
    L18:
        if (r7 == false) goto L20;
        TextWithOneIconElement r8 = r0;
    L21:
        if (r8 == null) goto L23;
        TextWithOneIconElementView.b(this.a, r8, null, false, null, 14);
        this.a.setVisibility(0);
        this.c.setVisibility(0);
    L24:
        TextWithOneIconElement r1 = r13.getSuffix();
        if (r1 == null) goto L41;
        TextElement r9 = r1.getContent();
        if (r9 == null) goto L29;
        String r10 = r9.getText();
    L31:
        if (a2.b(r10) == false) goto L33;
    L36:
        if (r2 == false) goto L38;
        TextWithOneIconElement r11 = r1;
    L39:
        if (r11 == null) goto L41;
        TextWithOneIconElementView.b(this.b, r11, null, false, null, 14);
        this.b.setVisibility(0);
    L42:
        ImageModel r3 = r13.getTagHeaderIcon();
        if (r3 == null) goto L45;
        ImageExtensionsKt.d(this.d, r3, null);
        this.d.setVisibility(0);
    L46:
        setBackground(com.bytedance.commerce.base.drawable.a.a(new CouponButtonElementView$bind$9(r13)));
        Action r14 = r13.getAction();
        Intrinsics.checkNotNullParameter(this, "theView");
        ActionHubAccessor.DefaultImpls.a(this, this, r14);
        return;
    L45:
        this.d.setVisibility(8);
        goto L46
    L38:
        r11 = null;
        goto L39
    L33:
        if (r1.getIcon() != null) goto L36;
        r2 = false;
        goto L36
    L29:
        r10 = null;
    L41:
        this.b.setVisibility(8);
        goto L42
    L20:
        r8 = null;
        goto L21
    L14:
        if (r0.getIcon() != null) goto L17;
        r7 = false;
        goto L18
    L10:
        r6 = null;
    L23:
        this.a.setVisibility(8);
        this.c.setVisibility(8);
        goto L24
    }

    @Override // com.bytedance.android.shopping.anchorv4.voavhs.base.design.ActionHubAccessor
    public final String getOnLimitClickBindKey(Action r2) {
        Intrinsics.checkNotNullParameter(r2, "action");
        return ActionHubAccessor.DefaultImpls.c(r2);
    }

    @Override // com.bytedance.android.shopping.anchorv4.voavhs.base.design.ActionHubAccessor
    public void setActionHub(com.bytedance.android.shopping.anchorv4.voavhs.base.design.a r2) {
        Intrinsics.checkNotNullParameter(r2, "hub");
        this.f = r2;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void onMeasure(int r4, int r5) {
        int r0 = 0;
        setVisibility(0);
        if (View.MeasureSpec.getMode(r4) == Integer.MIN_VALUE) goto L5;
        super.onMeasure(r4, r5);
        return;
    L5:
        int r6 = View.MeasureSpec.getSize(r4);
        super.onMeasure(0, r5);
        int r7 = getMeasuredWidth();
        ViewGroup.LayoutParams r1 = getLayoutParams();
        if ((r1 instanceof ViewGroup.MarginLayoutParams) == true) goto L8;
        r1 = null;
    L8:
        ViewGroup.MarginLayoutParams r2 = (ViewGroup.MarginLayoutParams) r1;
        if (r2 == null) goto L12;
        r0 = r2.leftMargin + r2.rightMargin;
    L12:
        if ((r7 + r0) <= r6) goto L16;
        setVisibility(4);
        return;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public CouponButtonElementView(Context r3, AttributeSet r4, int r5, int r6) {
        if ((r6 & 2) == 0) goto L6;
        r4 = null;
    L6:
        if ((r6 & 4) == 0) goto L8;
        r5 = 0;
    L8:
        Intrinsics.checkNotNullParameter(r3, "context");
        super(r3, r4, r5);
        this.f = null;
        ShoppingAsyncInflater.e.getClass();
        ShoppingAsyncInflater.a.a(r3).aU(2131560514, this, true);
        LinearLayout r7 = (LinearLayout) findViewById(2131362839);
        this.a = (TextWithOneIconElementView) findViewById(2131362908);
        this.b = (TextWithOneIconElementView) findViewById(2131362906);
        this.c = findViewById(2131362784);
        this.d = findViewById(2131362786);
    }
}
