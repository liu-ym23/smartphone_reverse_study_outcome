package com.bytedance.android.shopping.anchorv4.voavhs.base.elements;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import com.bytedance.android.ec.core.opt.asyncInflate.ShoppingAsyncInflater;
import com.bytedance.android.shopping.anchorv4.dto.base.Action;
import com.bytedance.android.shopping.anchorv4.dto.elements.KolReviewElement;
import com.bytedance.android.shopping.anchorv4.voavhs.base.design.ActionHubAccessor;
import com.bytedance.android.shopping.anchorv4.voavhs.base.extensions.ImageExtensionsKt;
import com.facebook.drawee.view.SimpleDraweeView;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u00012\u00020\u0002J\u0010\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0016¨\u0006\u0007"}, d2 = {"Lcom/bytedance/android/shopping/anchorv4/voavhs/base/elements/KolReviewElementView;", "Landroid/widget/FrameLayout;", "Lcom/bytedance/android/shopping/anchorv4/voavhs/base/design/ActionHubAccessor;", "Lcom/bytedance/android/shopping/anchorv4/voavhs/base/design/a;", "hub", "", "setActionHub", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class KolReviewElementView extends FrameLayout implements ActionHubAccessor {
    public final com.bytedance.android.shopping.anchorv4.voavhs.base.extensions.b a;
    public KolReviewElement b;
    public com.bytedance.android.shopping.anchorv4.voavhs.base.design.a c;

    public KolReviewElementView(Context r4) {
        this(r4, null, 0, 14);
    }

    public KolReviewElementView(Context r3, AttributeSet r4) {
        this(r3, r4, 0, 12);
    }

    public KolReviewElementView(Context r2, AttributeSet r3, int r4) {
        this(r2, r3, r4, 8);
    }

    @Override // com.bytedance.android.shopping.anchorv4.voavhs.base.design.ActionHubAccessor
    public final Object descriptionVO() {
        return null;
    }

    @Override // com.bytedance.android.shopping.anchorv4.voavhs.base.design.ActionHubAccessor
    public final Action associatedAction() {
        KolReviewElement r0 = this.b;
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.getAction();
    }

    @Override // com.bytedance.android.shopping.anchorv4.voavhs.base.design.ActionHubAccessor
    public final com.bytedance.android.shopping.anchorv4.voavhs.base.design.a actionHub() {
        return this.c;
    }

    @Override // com.bytedance.android.shopping.anchorv4.voavhs.base.design.ActionHubAccessor
    public final void dispatchPossibleShow() {
        ActionHubAccessor.DefaultImpls.b(this);
    }

    @Override // android.view.View
    public final void draw(Canvas r2) {
        Intrinsics.checkNotNullParameter(r2, "canvas");
        this.a.e(r2);
        super.draw(r2);
        this.a.d(r2);
    }

    @Override // com.bytedance.android.shopping.anchorv4.voavhs.base.design.ActionHubAccessor
    public final String getOnLimitClickBindKey(Action r2) {
        Intrinsics.checkNotNullParameter(r2, "action");
        return ActionHubAccessor.DefaultImpls.c(r2);
    }

    @Override // com.bytedance.android.shopping.anchorv4.voavhs.base.design.ActionHubAccessor
    public void setActionHub(com.bytedance.android.shopping.anchorv4.voavhs.base.design.a r2) {
        Intrinsics.checkNotNullParameter(r2, "hub");
        this.c = r2;
    }

    public static void b(int r2, SimpleDraweeView r3) {
        if (r2 != 0) goto L5;
        FrameLayout.LayoutParams r4 = new FrameLayout.LayoutParams(-2, -2);
        r4.gravity = 17;
        Unit r0 = Unit.INSTANCE;
        r3.setLayoutParams(r4);
        return;
    L5:
        if (r2 != 1) goto L11;
        FrameLayout.LayoutParams r5 = new FrameLayout.LayoutParams(-2, -2);
        r5.leftMargin = com.bytedance.android.shopping.extensions.b.b(10);
        r5.topMargin = com.bytedance.android.shopping.extensions.b.b(10);
        Unit r1 = Unit.INSTANCE;
        r3.setLayoutParams(r5);
        return;
    }

    public final void a(KolReviewElement r22, ViewGroup.LayoutParams r23) {
        int r3 = 8;
        if (r22 != null) goto L6;
        setVisibility(8);
        return;
    L6:
        this.b = r22;
        removeAllViews();
        long r4 = r22.getLayoutStyle();
        if (r4 != KolReviewStyle.STYLE_SPLIT.getType()) goto L16;
        ShoppingAsyncInflater.a r5 = ShoppingAsyncInflater.e;
        Context r6 = getContext();
        r5.getClass();
        View r7 = ShoppingAsyncInflater.a.a(r6).aU(2131560501, this, true);
        MediaBoxElementView r8 = (MediaBoxElementView) r7.findViewById(2131362833);
        SimpleDraweeView r9 = r7.findViewById(2131362834);
        TextWithOneIconElementView r12 = (TextWithOneIconElementView) r7.findViewById(2131362829);
        TextWithOneIconElementView r10 = (TextWithOneIconElementView) r7.findViewById(2131362831);
        TextWithOneIconElementView r11 = (TextWithOneIconElementView) r7.findViewById(2131362830);
        View r13 = r7.findViewById(2131362832);
        FrameLayout.LayoutParams r14 = new FrameLayout.LayoutParams(-2, -2);
        if (r23 == null) goto L11;
        int r2 = r23.width;
        r14 = new FrameLayout.LayoutParams(r2, r2);
    L11:
        MediaBoxElementView.c(r8, r22.getImage(), r14, false, 4);
        ImageExtensionsKt.d(r9, r22.getTypeIcon(), null);
        TextWithOneIconElementView.b(r12, r22.getFollowText(), null, false, null, 14);
        TextWithOneIconElementView.b(r10, r22.getLikeCount(), null, false, null, 14);
        TextWithOneIconElementView.b(r11, r22.getKolInfo(), null, false, null, 14);
        b(r22.getTypeIconStyle(), r9);
        if (r22.getHasMask() == false) goto L14;
        r3 = 0;
    L14:
        r13.setVisibility(r3);
    L22:
        Action r1 = r22.getAction();
        Intrinsics.checkNotNullParameter(this, "theView");
        ActionHubAccessor.DefaultImpls.a(this, this, r1);
        return;
    L16:
        if (r4 != KolReviewStyle.STYLE_WHOLE.getType()) goto L21;
        ShoppingAsyncInflater.a r15 = ShoppingAsyncInflater.e;
        Context r16 = getContext();
        r15.getClass();
        View r17 = ShoppingAsyncInflater.a.a(r16).aU(2131560502, this, true);
        MediaBoxElementView r18 = (MediaBoxElementView) r17.findViewById(2131362833);
        SimpleDraweeView r19 = r17.findViewById(2131362834);
        TextElementView r20 = (TextElementView) r17.findViewById(2131362825);
        LinearLayout r21 = (LinearLayout) r17.findViewById(2131370673);
        TextWithOneIconElementView r110 = (TextWithOneIconElementView) r17.findViewById(2131362831);
        TextWithOneIconElementView r111 = (TextWithOneIconElementView) r17.findViewById(2131362835);
        TextWithOneIconElementView r112 = (TextWithOneIconElementView) r17.findViewById(2131362829);
        View r24 = r17.findViewById(2131362832);
        MediaBoxElementView.c(r18, r22.getImage(), null, false, 6);
        ImageExtensionsKt.d(r19, r22.getTypeIcon(), null);
        r20.x(r22.getReviewContent());
        TextWithOneIconElementView.b(r110, r22.getLikeCount(), null, false, null, 14);
        TextWithOneIconElementView.b(r111, r22.getKolInfo(), null, false, null, 14);
        TextWithOneIconElementView.b(r112, r22.getFollowText(), null, false, null, 14);
        b(r22.getTypeIconStyle(), r19);
        if (r22.getHasMask() == false) goto L20;
        r3 = 0;
    L20:
        r24.setVisibility(r3);
        r21.setBackground(com.bytedance.commerce.base.drawable.a.a(KolReviewElementView$renderAsWholeMode$2.INSTANCE));
        goto L22
    L21:
        setVisibility(8);
        goto L22
    }

    public KolReviewElementView(Context r3, AttributeSet r4, int r5, int r6) {
        if ((r6 & 2) == 0) goto L6;
        r4 = null;
    L6:
        if ((r6 & 4) == 0) goto L8;
        r5 = 0;
    L8:
        Intrinsics.checkNotNullParameter(r3, "context");
        super(r3, r4, r5);
        this.c = null;
        this.a = new com.bytedance.android.shopping.anchorv4.voavhs.base.extensions.b(this);
    }

    @Override // android.view.View
    public final void onSizeChanged(int r1, int r2, int r3, int r4) {
        super.onSizeChanged(r1, r2, r3, r4);
        this.a.c(r1, r2);
    }
}
