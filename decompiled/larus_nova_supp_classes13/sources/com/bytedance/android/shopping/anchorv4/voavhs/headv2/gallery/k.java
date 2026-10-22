package com.bytedance.android.shopping.anchorv4.voavhs.headv2.gallery;

import android.graphics.Matrix;
import android.graphics.RectF;
import android.view.View;
import android.view.ViewParent;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.shopping.anchorv4.voavhs.head.gallery.AnchorV4PhotoWithTitleVH;
import com.bytedance.android.shopping.gallery2.PhotoVH;
import com.bytedance.android.ui.ec.widget.photodraweeview.IPhotoDraweeViewCallback;
import com.bytedance.android.ui.ec.widget.photodraweeview.transition.TransitionLayout;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class k implements IPhotoDraweeViewCallback {
    public final Matrix a;
    public float b;
    public final /* synthetic */ GalleryCompatAdapter c;
    public final /* synthetic */ PhotoVH d;

    public final Matrix getDefaultTransform() {
        return this.a;
    }

    public k(GalleryCompatAdapter r1, PhotoVH r2) {
        this.c = r1;
        this.d = r2;
        this.a = new Matrix();
        this.b = Float.MAX_VALUE;
    }

    public final void configTransform(View r12, RectF r13) {
        Intrinsics.checkNotNullParameter(r12, "imageView");
        Intrinsics.checkNotNullParameter(r13, "imageBounds");
        this.a.reset();
    L3:
        ViewParent r0 = null;
        if (r12 == null) goto L15;
        if ((r12 instanceof RecyclerView) == true) goto L15;
        if ((r12.getParent() instanceof TransitionLayout) == true) goto L16;
        ViewParent r14 = r12.getParent();
        if ((r14 instanceof View) == false) goto L14;
        r0 = r14;
    L14:
        r12 = (View) r0;
    L16:
        float r1 = this.d.getTransitionLayout().getHeight();
        float r2 = this.d.getTransitionLayout().getWidth();
        float r3 = 0;
        if (r13.height() > r3) goto L19;
        return;
    L19:
        if (r13.width() > r3) goto L21;
        return;
    L21:
        if (r1 > r3) goto L23;
        return;
    L23:
        if (r2 <= r3) goto L60;
        if (r12 != null) goto L26;
        return;
    L26:
        if (r12.getHeight() <= 0) goto L63;
        h0 r4 = this.c.g;
        if (r4 != null) goto L32;
        return;
    L32:
        if (this.b <= r12.getHeight()) goto L34;
        this.b = r12.getHeight();
    L34:
        float r5 = 1.0f;
        if (r1 > this.b) goto L37;
        float r6 = 1.0f;
    L38:
        int r7 = r4.d();
        int r8 = r4.f();
        int r9 = AnchorV4PhotoWithTitleVH.k;
        float r10 = r7;
        float r11 = (r1 - (r8 + AnchorV4PhotoWithTitleVH.l)) - r10;
        if (r6 >= 1.0f) goto L48;
        float r15 = r2 / r1;
        float r16 = r13.width() / r13.height();
        if (r15 >= r16) goto L44;
        r1 = r2 / r16;
    L44:
        if (r11 >= r1) goto L46;
        r5 = r11 / r1;
    L46:
        float r17 = 1;
        float r18 = r17 - ((r17 - r5) * r6);
        this.a.postScale(r18, r18, r13.centerX(), r13.top);
        float r19 = 2;
        this.a.postTranslate(0.0f, ((r10 + (r11 / r19)) - ((r12.getY() + r13.top) + ((r13.height() / r19) * r18))) * r6);
        return;
    L48:
        if (r13.height() <= r11) goto L50;
        r5 = r11 / r13.height();
    L50:
        this.a.postScale(r5, r5, r13.centerX(), r13.centerY());
        this.a.postTranslate(0.0f, (r10 + (r11 / 2)) - r13.centerY());
        return;
    L37:
        float r20 = r12.getHeight();
        float r21 = this.b;
        r6 = (r20 - r21) / (r1 - r21);
        goto L38
    L63:
        return;
    L60:
        return;
    L15:
        r12 = null;
        goto L16
    }
}
