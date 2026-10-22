package com.bytedance.ee.bear.document.sharewords.view;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Matrix;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.larksuite.component.ui.imageview.LKUIRoundedImageView2;
import com.larus.nova.R;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import com.ss.android.lark.utils.LarkContext;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: classes16.dex */
public final class n {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ImageView f221854a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final View f221855b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f221856c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public lt7.d f221857d;

    public static final class a {
    }

    static {
    }

    public final void c() {
        lt7.d r100 = this.f221857d;     // Catch: Exception -> L6
        if (r100 == null) goto L11;
        r100.a();     // Catch: Exception -> L6
        return;
    L11:
        return;
    L6:
        e = move-exception;
        tt5.a.e("SkeletonAnimator", "hideSkeletonAnim(): ", e, false);
    }

    public static int b(int r100) {
        Resources r101 = LarkContext.getApplication().getResources();
        return (int) ((r100 * WindowDisplayMetricsOverride.apply(r101, r101.getDisplayMetrics()).density) + 0.5f);
    }

    public final void a(Bitmap r110) {
        c();
        int r100 = r110.getHeight();
        int r101 = r110.getWidth();
        tt5.a.h("SkeletonAnimator", "onLoadSuccess(): bitmapHeight=" + r100 + ", bitmapWidth=" + r101);
        int r102 = b(200);
        int r103 = b(261);
        Object r104 = this.f221854a.getParent();
        View r105 = null;
        if ((r104 instanceof View) == false) goto L5;
        View r106 = (View) r104;
    L6:
        if (r106 == null) goto L8;
        Object r107 = r106.getParent();
    L10:
        if ((r107 instanceof View) == false) goto L12;
        View r111 = (View) r107;
    L14:
        if (r111 == null) goto L16;
        int r108 = r111.getWidth();
    L17:
        if (r111 == null) goto L19;
        int r109 = r111.getPaddingLeft();
    L20:
        if (r111 == null) goto L22;
        int r112 = r111.getPaddingRight();
    L23:
        int r113 = RangesKt.coerceAtLeast((r108 - (r109 + r112)) - b(2), 0);
        if (r113 <= 0) goto L26;
        r103 = Math.min(r103, r113);
    L26:
        if (r100 >= r102) goto L28;
        int r114 = r103;
    L29:
        if (r100 <= r102) goto L31;
        int r115 = r102;
    L32:
        if (r100 <= r102) goto L34;
        float r116 = Math.min(r115 / r100, r103 / r101);
    L35:
        float r117 = r116;
        Matrix r118 = new Matrix();
        r118.postScale(r117, r117);
        Bitmap r119 = Bitmap.createBitmap(r110, 0, 0, r101, r100, r118, true);
        tt5.a.h("SkeletonAnimator", "onLoadSuccess(): newBitmap.width=" + r119.getWidth());
        int r120 = r119.getWidth();
        int r121 = r119.getHeight();
        ViewGroup.LayoutParams r122 = this.f221854a.getLayoutParams();
        r122.height = r121;
        r122.width = r120;
        this.f221854a.setLayoutParams(r122);
        tt5.a.h("SkeletonAnimator", "onLoadSuccess(): destImg height=" + r121 + ", bitmapScale=" + r117);
        StringBuilder r123 = new StringBuilder("onLoadSuccess(): destImg params.width=");
        r123.append(r122.width);
        tt5.a.h("SkeletonAnimator", r123.toString());
        if (r106 == null) goto L38;
        ViewGroup.LayoutParams r124 = r106.getLayoutParams();
    L39:
        if (r124 == null) goto L41;
        r124.width = b(2) + r120;
        r124.height = b(2) + r121;
        r106.setLayoutParams(r124);
    L41:
        if (r111 == null) goto L43;
        ViewGroup.LayoutParams r125 = r111.getLayoutParams();
    L44:
        if (r125 == null) goto L46;
        r125.width = r120 + b(2);
        r125.height = r121 + b(2);
        r111.setLayoutParams(r125);
    L46:
        tt5.a.h("SkeletonAnimator", "onLoadSuccess(): destImg parent params.width=" + r122.width);
        this.f221854a.setImageBitmap(r119);
        Object r126 = this.f221855b.getParent();
        if ((r126 instanceof View) == false) goto L49;
        r105 = (View) r126;
    L49:
        if (r105 == null) goto L52;
        r105.setVisibility(8);
        return;
    L52:
        return;
    L43:
        r125 = null;
        goto L44
    L38:
        r124 = null;
        goto L39
    L34:
        r116 = r114 / r101;
        goto L35
    L31:
        r115 = r100;
        goto L32
    L28:
        r114 = r101;
        goto L29
    L22:
        r112 = 0;
        goto L23
    L19:
        r109 = 0;
        goto L20
    L16:
        r108 = 0;
        goto L17
    L12:
        r111 = null;
        goto L14
    L8:
        r107 = null;
        goto L10
    L5:
        r106 = null;
        goto L6
    }

    public n(LKUIRoundedImageView2 r100, View r101) {
        Intrinsics.checkNotNullParameter(r100, "destImg");
        Intrinsics.checkNotNullParameter(r101, "loadingView");
        this.f221854a = r100;
        this.f221855b = r101;
        this.f221856c = R.layout.docx_share_words_skeleton;
    }
}
