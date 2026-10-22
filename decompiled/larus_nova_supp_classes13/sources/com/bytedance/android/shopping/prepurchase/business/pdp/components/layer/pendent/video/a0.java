package com.bytedance.android.shopping.prepurchase.business.pdp.components.layer.pendent.video;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.Typeface;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.bytedance.android.ec.core.widget.RoundedFrameLayout;
import com.bytedance.android.shopping.extensions.ViewExtensionsKt;
import com.bytedance.android.ui.ec.widget.ecdraweeview.ECDraweeView;
import com.facebook.drawee.drawable.ScalingUtils;
import com.facebook.drawee.generic.GenericDraweeHierarchy;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class a0 extends RoundedFrameLayout {
    public final Paint b;
    public final RectF c;
    public TextView d;
    public View e;
    public FrameLayout f;
    public ECDraweeView g;
    public boolean h;
    public View i;
    public final t j;

    public final TextView getTvBottomLeft() {
        TextView r0 = this.d;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("tvBottomLeft");
    L5:
        return r0;
    }

    public final FrameLayout getVideoContainer() {
        FrameLayout r0 = this.f;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("videoContainer");
    L5:
        return r0;
    }

    public final ECDraweeView getIvCover() {
        return this.g;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void dispatchDraw(Canvas r5) {
        Intrinsics.checkNotNullParameter(r5, "canvas");
        super.dispatchDraw(r5);
        this.c.set(0.0f, 0.0f, getWidth(), getHeight());
        r5.drawRoundRect(this.c, getBorderRadius(), getBorderRadius(), this.b);
    }

    public final void setIvCover(ECDraweeView r1) {
        this.g = r1;
    }

    public final void setTvBottomLeft(TextView r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.d = r2;
    }

    public final void setVideoContainer(FrameLayout r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.f = r2;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public a0(Context r9, t r10) {
        Intrinsics.checkNotNullParameter(r9, "context");
        Intrinsics.checkNotNullParameter(r10, "ability");
        super(r9);
        this.j = r10;
        Paint r11 = new Paint(1);
        r11.setColor(-1);
        r11.setStrokeWidth(com.bytedance.android.shopping.extensions.b.a(Double.valueOf(1.5d)));
        r11.setStyle(Paint.Style.STROKE);
        Unit r2 = Unit.INSTANCE;
        this.b = r11;
        this.c = new RectF();
        FrameLayout r12 = new FrameLayout(getContext());
        this.f = r12;
        addView(r12, -1, -1);
        String r13 = r10.getParams().d.e;
        if (r13 == null) goto L8;
        ECDraweeView r14 = new ECDraweeView(getContext(), null, 0, 6, null);
        this.g = r14;
        GenericDraweeHierarchy r3 = r14.getHierarchy();
        if (r3 == null) goto L7;
        r3.setActualImageScaleType(ScalingUtils.ScaleType.CENTER_CROP);
    L7:
        com.bytedance.android.ec.core.utils.y.d(r14, r13);
        addView(r14, new FrameLayout.LayoutParams(-1, -1));
    L8:
        addView(new z(this, getContext()), -1, -1);
        TextView r15 = new TextView(getContext());
        this.d = r15;
        r15.setTypeface(Typeface.DEFAULT_BOLD);
        r15.setTextColor(-1);
        ViewExtensionsKt.h(r15, 12);
        r15.setShadowLayer(com.bytedance.android.ec.core.utils.q.a(2), com.bytedance.android.ec.core.utils.q.a(1), com.bytedance.android.ec.core.utils.q.a(1), 872415232);
        FrameLayout.LayoutParams r16 = new FrameLayout.LayoutParams(-2, -2);
        r16.bottomMargin = com.bytedance.android.shopping.extensions.b.a(6);
        r16.gravity = 81;
        r16.leftMargin = 0;
        addView(r15, r16);
        ImageView r17 = new ImageView(getContext());
        r17.setImageResource(2131231265);
        r17.setScaleType(ImageView.ScaleType.CENTER);
        this.e = r17;
        r17.setVisibility(8);
        FrameLayout.LayoutParams r18 = new FrameLayout.LayoutParams(-2, -2);
        r18.gravity = 17;
        addView(r17, r18);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void onMeasure(int r4, int r5) {
        if (this.j.getParams().d.c == true) goto L5;
        super/*android.widget.FrameLayout*/.onMeasure(r4, r5);
        return;
    L5:
        com.bytedance.android.shopping.anchorv3.detail.widget.playerblock.b r0 = this.j.getParams().c.e;
        Integer r1 = r0.l();
        int r2 = 0;
        if (r1 == null) goto L8;
        int r3 = r1.intValue();
    L9:
        Integer r6 = r0.c();
        if (r6 == null) goto L12;
        r2 = r6.intValue();
    L12:
        if (r3 <= 0) goto L18;
        if (r2 <= 0) goto L18;
        if (r3 <= r2) goto L16;
        int r7 = com.bytedance.android.shopping.anchorv4.video.float.m.f;
        int r8 = com.bytedance.android.shopping.anchorv4.video.float.m.f;
        int r9 = RangesKt.coerceAtLeast((int) ((r2 / r3) * r8), com.bytedance.android.shopping.anchorv4.video.float.m.g);
    L17:
        super/*android.widget.FrameLayout*/.onMeasure(View.MeasureSpec.makeMeasureSpec(r8, 1073741824), View.MeasureSpec.makeMeasureSpec(r9, 1073741824));
        return;
    L16:
        int r10 = com.bytedance.android.shopping.anchorv4.video.float.m.f;
        r9 = com.bytedance.android.shopping.anchorv4.video.float.m.f;
        r8 = RangesKt.coerceAtLeast((int) ((r3 / r2) * r9), com.bytedance.android.shopping.anchorv4.video.float.m.g);
    L18:
        super/*android.widget.FrameLayout*/.onMeasure(r4, r5);
        return;
    L8:
        r3 = 0;
        goto L9
    }
}
