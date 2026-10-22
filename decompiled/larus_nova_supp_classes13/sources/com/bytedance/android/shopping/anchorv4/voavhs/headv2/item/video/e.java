package com.bytedance.android.shopping.anchorv4.voavhs.headv2.item.video;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.bytedance.android.ec.core.utils.q;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class e extends LinearLayout {
    public static final int j = 0;
    public static final int k = 0;
    public static final int l = 0;
    public static final int m = 0;
    public static final int n = 0;
    public final Paint a;
    public final RectF b;
    public final ImageView c;
    public final ImageView d;
    public int e;
    public int f;
    public final boolean g;
    public final int h;
    public final com.bytedance.android.shopping.anchorv4.voavhs.headv2.item.video.a i;

    public static final class a {
    }

    static {
        j = com.bytedance.android.shopping.extensions.b.a(44);
        k = com.bytedance.android.shopping.extensions.b.a(12);
        l = com.bytedance.android.shopping.extensions.b.a(22);
        m = com.bytedance.android.shopping.extensions.b.a(24);
        n = com.bytedance.android.shopping.extensions.b.a(64);
    }

    public final ViewGroup a(boolean r6) {
        FrameLayout r0 = new FrameLayout(getContext());
        ImageView r1 = new ImageView(r0.getContext());
        int r3 = k;
        FrameLayout.LayoutParams r2 = new FrameLayout.LayoutParams(r3, r3);
        if (r6 == false) goto L5;
        int r4 = 8388693;
    L6:
        r2.gravity = r4;
        if (r6 == false) goto L9;
        r2.rightMargin = com.bytedance.android.shopping.extensions.b.a(8);
    L10:
        r2.bottomMargin = (this.h - r3) / 2;
        Unit r7 = Unit.INSTANCE;
        r0.addView(r1, r2);
        int r5 = j;
        r0.setLayoutParams(new LinearLayout.LayoutParams(r5, r5));
        return r0;
    L9:
        r2.leftMargin = com.bytedance.android.shopping.extensions.b.a(8);
        goto L10
    L5:
        r4 = 80;
        goto L6
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void dispatchDraw(Canvas r13) {
        Intrinsics.checkNotNullParameter(r13, "canvas");
        this.a.setColor(this.e);
        float r0 = this.h / 2.0f;
        float r2 = n / 2.0f;
        boolean r3 = this.g;
        Double r4 = Double.valueOf(0.5d);
        if (r3 == false) goto L5;
        float r5 = 0.0f;
    L7:
        if (this.g == false) goto L9;
        int r6 = 6;
    L10:
        float r7 = q.a(Integer.valueOf(r6));
        this.a.setStyle(Paint.Style.FILL);
        this.b.set((getWidth() / 2.0f) - r2, getHeight() - this.h, (getWidth() / 2.0f) + r2, getHeight());
        this.b.inset(r5, r5);
        r13.drawRoundRect(this.b, r0, r0, this.a);
        float r8 = (-r5) / 2;
        this.b.inset(r8, r8);
        this.a.setStrokeWidth(r5);
        this.a.setStyle(Paint.Style.STROKE);
        this.a.setColor(this.f);
        r13.drawRoundRect(this.b, r0, r0, this.a);
        this.a.setStyle(Paint.Style.FILL);
        this.a.setColor(872415231);
        this.a.setStrokeWidth(q.a(r4));
        float r1 = (this.h - r7) / 2.0f;
        r13.drawLine(getWidth() / 2.0f, getHeight() - r1, getWidth() / 2.0f, (getHeight() - r1) - r7, this.a);
        super.dispatchDraw(r13);
        return;
    L9:
        r6 = 9;
        goto L10
    L5:
        r5 = q.a(r4);
        goto L7
    }

    public final void setAudioState(boolean r2) {
        ImageView r0 = this.c;
        if (r2 == false) goto L9;
        if (this.g == false) goto L7;
        int r3 = 2131231276;
    L12:
        r0.setImageResource(r3);
        return;
    L7:
        r3 = 2131231275;
        goto L12
    L9:
        if (this.g == false) goto L11;
        r3 = 2131231278;
        goto L12
    L11:
        r3 = 2131231277;
        goto L12
    }

    public final void setPlayState(boolean r2) {
        ImageView r0 = this.d;
        if (r2 == false) goto L9;
        if (this.g == false) goto L7;
        int r3 = 2131231280;
    L12:
        r0.setImageResource(r3);
        return;
    L7:
        r3 = 2131231279;
        goto L12
    L9:
        if (this.g == false) goto L11;
        r3 = 2131231282;
        goto L12
    L11:
        r3 = 2131231281;
        goto L12
    }

    public e(Context r3, VideoCoverLayout.d r4) {
        Intrinsics.checkNotNullParameter(r3, "context");
        Intrinsics.checkNotNullParameter(r4, "callback");
        super(r3, null);
        this.i = r4;
        Paint r5 = new Paint(1);
        r5.setStyle(Paint.Style.FILL);
        r5.setStrokeWidth(q.a(1));
        r5.setStrokeCap(Paint.Cap.ROUND);
        Unit r1 = Unit.INSTANCE;
        this.a = r5;
        this.b = new RectF();
        this.e = 1461065763;
        this.f = 536870911;
        boolean r6 = r4.c();
        this.g = r6;
        if (r6 == false) goto L5;
        int r7 = m;
    L6:
        this.h = r7;
        ViewGroup r8 = a(true);
        r8.setOnClickListener(new c(this));
        View r0 = r8.getChildAt(0);
        if (r0 == null) goto L15;
        this.c = (ImageView) r0;
        addView(r8);
        ViewGroup r9 = a(false);
        r9.setOnClickListener(new d(this));
        View r2 = r9.getChildAt(0);
        if (r2 == null) goto L13;
        this.d = (ImageView) r2;
        addView(r9);
        setOrientation(0);
        return;
    L13:
        throw new NullPointerException("null cannot be cast to non-null type android.widget.ImageView");
    L15:
        throw new NullPointerException("null cannot be cast to non-null type android.widget.ImageView");
    L5:
        r7 = l;
        goto L6
    }
}
