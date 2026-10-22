package com.bytedance.ee.bear.document.sharewords.view;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Matrix;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.larksuite.component.ui.imageview.LKUIRoundedImageView2;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import com.ss.android.lark.utils.LarkContext;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class n {
    public final ImageView a;
    public final View b;
    public final int c;
    public lt7.d d;

    public static final class a {
    }

    static {
    }

    public final void c() {
        lt7.d r0 = this.d;     // Catch: Exception -> L6
        if (r0 == null) goto L11;
        r0.a();     // Catch: Exception -> L6
        return;
    L11:
        return;
    L6:
        e = move-exception;
        tt5.a.e("SkeletonAnimator", "hideSkeletonAnim(): ", e, false);
    }

    public static int b(int r2) {
        Resources r0 = LarkContext.getApplication().getResources();
        return (int) ((r2 * WindowDisplayMetricsOverride.apply(r0, r0.getDisplayMetrics()).density) + 0.5f);
    }

    public final void a(Bitmap r14) {
        c();
        int r4 = r14.getHeight();
        int r3 = r14.getWidth();
        tt5.a.h("SkeletonAnimator", "onLoadSuccess(): bitmapHeight=" + r4 + ", bitmapWidth=" + r3);
        int r0 = b(200);
        int r1 = b(261);
        Object r2 = this.a.getParent();
        View r8 = null;
        if ((r2 instanceof View) == false) goto L5;
        View r9 = (View) r2;
    L6:
        if (r9 == null) goto L8;
        Object r5 = r9.getParent();
    L10:
        if ((r5 instanceof View) == false) goto L12;
        View r10 = (View) r5;
    L14:
        if (r10 == null) goto L16;
        int r6 = r10.getWidth();
    L17:
        if (r10 == null) goto L19;
        int r7 = r10.getPaddingLeft();
    L20:
        if (r10 == null) goto L22;
        int r11 = r10.getPaddingRight();
    L23:
        int r12 = RangesKt.coerceAtLeast((r6 - (r7 + r11)) - b(2), 0);
        if (r12 <= 0) goto L26;
        r1 = Math.min(r1, r12);
    L26:
        if (r4 >= r0) goto L28;
        int r13 = r1;
    L29:
        if (r4 <= r0) goto L31;
        int r16 = r0;
    L32:
        if (r4 <= r0) goto L34;
        float r17 = Math.min(r16 / r4, r1 / r3);
    L35:
        float r18 = r17;
        Matrix r19 = new Matrix();
        r19.postScale(r18, r18);
        Bitmap r110 = Bitmap.createBitmap(r14, 0, 0, r3, r4, r19, true);
        tt5.a.h("SkeletonAnimator", "onLoadSuccess(): newBitmap.width=" + r110.getWidth());
        int r20 = r110.getWidth();
        int r21 = r110.getHeight();
        ViewGroup.LayoutParams r22 = this.a.getLayoutParams();
        r22.height = r21;
        r22.width = r20;
        this.a.setLayoutParams(r22);
        tt5.a.h("SkeletonAnimator", "onLoadSuccess(): destImg height=" + r21 + ", bitmapScale=" + r18);
        StringBuilder r23 = new StringBuilder("onLoadSuccess(): destImg params.width=");
        r23.append(r22.width);
        tt5.a.h("SkeletonAnimator", r23.toString());
        if (r9 == null) goto L38;
        ViewGroup.LayoutParams r24 = r9.getLayoutParams();
    L39:
        if (r24 == null) goto L41;
        r24.width = b(2) + r20;
        r24.height = b(2) + r21;
        r9.setLayoutParams(r24);
    L41:
        if (r10 == null) goto L43;
        ViewGroup.LayoutParams r26 = r10.getLayoutParams();
    L44:
        if (r26 == null) goto L46;
        r26.width = r20 + b(2);
        r26.height = r21 + b(2);
        r10.setLayoutParams(r26);
    L46:
        tt5.a.h("SkeletonAnimator", "onLoadSuccess(): destImg parent params.width=" + r22.width);
        this.a.setImageBitmap(r110);
        Object r111 = this.b.getParent();
        if ((r111 instanceof View) == false) goto L49;
        r8 = (View) r111;
    L49:
        if (r8 == null) goto L52;
        r8.setVisibility(8);
        return;
    L52:
        return;
    L43:
        r26 = null;
        goto L44
    L38:
        r24 = null;
        goto L39
    L34:
        r17 = r13 / r3;
        goto L35
    L31:
        r16 = r4;
        goto L32
    L28:
        r13 = r3;
        goto L29
    L22:
        r11 = 0;
        goto L23
    L19:
        r7 = 0;
        goto L20
    L16:
        r6 = 0;
        goto L17
    L12:
        r10 = null;
        goto L14
    L8:
        r5 = null;
        goto L10
    L5:
        r9 = null;
        goto L6
    }

    public n(LKUIRoundedImageView2 r2, View r3) {
        Intrinsics.checkNotNullParameter(r2, "destImg");
        Intrinsics.checkNotNullParameter(r3, "loadingView");
        this.a = r2;
        this.b = r3;
        this.c = 2131560134;
    }
}
