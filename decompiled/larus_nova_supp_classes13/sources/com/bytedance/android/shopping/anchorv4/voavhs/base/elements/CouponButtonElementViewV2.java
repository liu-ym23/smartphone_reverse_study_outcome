package com.bytedance.android.shopping.anchorv4.voavhs.base.elements;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import com.bytedance.android.ec.core.opt.asyncInflate.ShoppingAsyncInflater;
import com.bytedance.android.ec.core.utils.a2;
import com.bytedance.android.shopping.anchorv4.dto.base.Action;
import com.bytedance.android.shopping.anchorv4.dto.base.Background;
import com.bytedance.android.shopping.anchorv4.dto.elements.CouponButtonElement;
import com.bytedance.android.shopping.anchorv4.dto.elements.TextElement;
import com.bytedance.android.shopping.anchorv4.dto.elements.TextWithOneIconElement;
import com.bytedance.android.shopping.anchorv4.voavhs.base.design.ActionHubAccessor;
import com.bytedance.android.shopping.anchorv4.voavhs.base.extensions.ExtensionsKt;
import com.bytedance.android.shopping.anchorv4.voavhs.base.extensions.ImageExtensionsKt;
import com.bytedance.mt.protector.impl.color.ColorProtector;
import com.facebook.drawee.view.SimpleDraweeView;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u00012\u00020\u0002J\u0010\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0016¨\u0006\u0007"}, d2 = {"Lcom/bytedance/android/shopping/anchorv4/voavhs/base/elements/CouponButtonElementViewV2;", "Landroid/widget/RelativeLayout;", "Lcom/bytedance/android/shopping/anchorv4/voavhs/base/design/ActionHubAccessor;", "Lcom/bytedance/android/shopping/anchorv4/voavhs/base/design/a;", "hub", "", "setActionHub", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class CouponButtonElementViewV2 extends RelativeLayout implements ActionHubAccessor {
    public CouponButtonElement a;
    public final TextWithOneIconElementView b;
    public final RelativeLayout c;
    public final FrameLayout d;
    public final TextElementView e;
    public final SimpleDraweeView f;
    public final View g;
    public com.bytedance.android.shopping.anchorv4.voavhs.base.design.a h;

    public CouponButtonElementViewV2(Context r4) {
        this(r4, null, 0, 14);
    }

    public CouponButtonElementViewV2(Context r3, AttributeSet r4) {
        this(r3, r4, 0, 12);
    }

    public CouponButtonElementViewV2(Context r2, AttributeSet r3, int r4) {
        this(r2, r3, r4, 8);
    }

    @Override // com.bytedance.android.shopping.anchorv4.voavhs.base.design.ActionHubAccessor
    public final Action associatedAction() {
        return null;
    }

    @Override // com.bytedance.android.shopping.anchorv4.voavhs.base.design.ActionHubAccessor
    public final com.bytedance.android.shopping.anchorv4.voavhs.base.design.a actionHub() {
        return this.h;
    }

    @Override // com.bytedance.android.shopping.anchorv4.voavhs.base.design.ActionHubAccessor
    public final Object descriptionVO() {
        return this.a;
    }

    @Override // com.bytedance.android.shopping.anchorv4.voavhs.base.design.ActionHubAccessor
    public final void dispatchPossibleShow() {
        ActionHubAccessor.DefaultImpls.b(this);
    }

    public final void a(final CouponButtonElement r13) {
        this.a = r13;
        if (r13 != null) goto L5;
        return;
    L5:
        TextWithOneIconElement r0 = r13.getPrefix();
        boolean r1 = true;
        String r2 = null;
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
        TextWithOneIconElementView.b(this.b, r8, null, false, null, 14);
        this.b.setVisibility(0);
        this.g.setVisibility(0);
        this.g.setBackgroundColor(com.bytedance.android.shopping.extensions.a.a(r13.getDividerColor(), ColorProtector.parseColor("#33FE2C55")));
    L24:
        TextWithOneIconElement r3 = r13.getSuffix();
        if (r3 == null) goto L54;
        TextElement r9 = r3.getContent();
        if (r9 == null) goto L29;
        String r10 = r9.getText();
    L31:
        if (a2.b(r10) == false) goto L33;
    L36:
        if (r1 == true) goto L39;
        r3 = null;
    L39:
        if (r3 == null) goto L54;
        TextElement r4 = r3.getContent();
        if (r4 == null) goto L43;
        String r11 = r4.getText();
    L45:
        if (a2.b(r11) == false) goto L48;
        this.e.x(r3.getContent());
        this.e.setVisibility(0);
    L48:
        if (r3.getIcon() == null) goto L50;
        ImageExtensionsKt.d(this.f, r3.getIcon(), null);
        this.f.setVisibility(0);
    L50:
        ExtensionsKt.j(this.c, r3.getBackground());
        FrameLayout r12 = this.d;
        Background r14 = r3.getBackground();
        if (r14 == null) goto L53;
        r2 = r14.getBackgroundColor();
    L53:
        r12.setBackgroundColor(com.bytedance.android.shopping.extensions.a.a(r2, 0));
    L55:
        this.c.addOnLayoutChangeListener(new a(this));
        invalidate();
        setBackground(com.bytedance.commerce.base.drawable.a.a(new CouponButtonElementViewV2$bind$7(r13)));
        Action r15 = r13.getAction();
        Intrinsics.checkNotNullParameter(this, "theView");
        ActionHubAccessor.DefaultImpls.a(this, this, r15);
        return;
    L43:
        r11 = null;
        goto L45
    L33:
        if (r3.getIcon() != null) goto L36;
        r1 = false;
        goto L36
    L29:
        r10 = null;
    L54:
        this.e.setVisibility(8);
        this.f.setVisibility(8);
        goto L55
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
        this.b.setVisibility(8);
        this.g.setVisibility(8);
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
        this.h = r2;
    }

    public CouponButtonElementViewV2(Context r3, AttributeSet r4, int r5, int r6) {
        if ((r6 & 2) == 0) goto L6;
        r4 = null;
    L6:
        if ((r6 & 4) == 0) goto L8;
        r5 = 0;
    L8:
        Intrinsics.checkNotNullParameter(r3, "context");
        super(r3, r4, r5);
        this.h = null;
        ShoppingAsyncInflater.e.getClass();
        ShoppingAsyncInflater.a.a(r3).aU(2131560515, this, true);
        this.b = (TextWithOneIconElementView) findViewById(2131362909);
        this.e = (TextElementView) findViewById(2131362907);
        this.c = (RelativeLayout) findViewById(2131362788);
        this.d = (FrameLayout) findViewById(2131362800);
        this.f = findViewById(2131362787);
        this.g = findViewById(2131362785);
    }
}
