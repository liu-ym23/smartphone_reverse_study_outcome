package com.bytedance.android.shopping.anchorv4.voavhs.headv2.gallery.widget;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.fragment.app.FragmentActivity;
import com.bytedance.android.ec.core.utils.q;
import com.bytedance.android.shopping.anchorv4.voavhs.headv2.gallery.m0;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class c extends LinearLayout {
    public static final int e = 0;
    public final Paint a;
    public final RectF b;
    public boolean c;
    public final f d;

    public static final class a {
    }

    public static final class b extends com.bytedance.android.shopping.anchorv4.voavhs.headv2.gallery.b {
        public final /* synthetic */ c c;

        @Override // com.bytedance.android.shopping.anchorv4.voavhs.headv2.gallery.b
        public final boolean a(int r3) {
            return this.c.d.wW("bottom_left_find_same", Integer.valueOf(r3));
        }

        @Override // com.bytedance.android.shopping.anchorv4.voavhs.headv2.gallery.b
        public final void b(RectF r8) {
            boolean r0 = false;
            if (r8 == null) goto L8;
            c r2 = this.c;
            r2.c = true;
            int r3 = r2.getChildCount();
            int r4 = 0;
        L5:
            if (r4 >= r3) goto L7;
            r2.getChildAt(r4).setAlpha(1.0f);
            r4 = r4 + 1;
            goto L5
        L7:
            this.c.invalidate();
        L8:
            if (r8 != null) goto L10;
            return;
        L10:
            if (r8.height() <= 0) goto L12;
            r0 = true;
        L12:
            if (r0 == true) goto L15;
            r8 = null;
        L15:
            if (r8 == null) goto L20;
            this.c.setTranslationY(Float.valueOf((r8.bottom - c.e) - com.bytedance.android.shopping.extensions.b.a(12)).floatValue());
            return;
        }

        public b(c r1, View r2, m0 r3) {
            this.c = r1;
            super(r2, r3);
        }
    }

    static {
        e = com.bytedance.android.shopping.extensions.b.a(20);
    }

    public final com.bytedance.android.shopping.anchorv4.voavhs.headv2.gallery.b getLayerItem() {
        return new b(this, this, new m0(true, true, true, 1, false, 48));
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void dispatchDraw(Canvas r7) {
        Intrinsics.checkNotNullParameter(r7, "canvas");
        if (this.c == false) goto L5;
        this.a.setColor(1461065763);
        float r0 = getHeight() / 2.0f;
        float r1 = q.a(Double.valueOf(0.5d));
        this.a.setStyle(Paint.Style.FILL);
        this.b.set(0.0f, 0.0f, getWidth(), getHeight());
        this.b.inset(r1, r1);
        r7.drawRoundRect(this.b, r0, r0, this.a);
        this.b.set(0.0f, 0.0f, getWidth(), getHeight());
        this.a.setStrokeWidth(r1);
        this.a.setStyle(Paint.Style.STROKE);
        this.a.setColor(536870911);
        r7.drawRoundRect(this.b, r0, r0, this.a);
    L5:
        super.dispatchDraw(r7);
    }

    public c(FragmentActivity r6, f r7) {
        Intrinsics.checkNotNullParameter(r6, "context");
        Intrinsics.checkNotNullParameter(r7, "callback");
        super(r6);
        this.d = r7;
        Paint r8 = new Paint(1);
        r8.setColor(1461065763);
        r8.setStyle(Paint.Style.FILL);
        Unit r1 = Unit.INSTANCE;
        this.a = r8;
        this.b = new RectF();
        int r9 = 0;
        setOrientation(0);
        setGravity(17);
        int r2 = com.bytedance.android.shopping.extensions.b.a(10);
        setPadding(r2, 0, r2, 0);
        ImageView r3 = new ImageView(r6);
        r3.setImageResource(2131231266);
        addView(r3, new LinearLayout.LayoutParams(com.bytedance.android.shopping.extensions.b.a(12), com.bytedance.android.shopping.extensions.b.a(12)));
        TextView r4 = new TextView(r6);
        r4.setText("找同款");
        r4.setTextColor(-1);
        r4.setTextSize(1, 10.0f);
        LinearLayout.LayoutParams r10 = new LinearLayout.LayoutParams(-2, -2);
        r10.leftMargin = com.bytedance.android.shopping.extensions.b.a(2);
        addView(r4, r10);
        if (this.c == false) goto L5;
        float r11 = 1.0f;
    L6:
        int r0 = getChildCount();
    L7:
        if (r9 >= r0) goto L9;
        getChildAt(r9).setAlpha(r11);
        r9 = r9 + 1;
        goto L7
    L9:
        return;
    L5:
        r11 = 0.0f;
        goto L6
    }
}
