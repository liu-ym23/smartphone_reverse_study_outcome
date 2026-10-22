package com.bytedance.ee.bear.document.sharewords.view;

import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.ViewParent;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.bumptech.glide.request.target.CustomTarget;
import com.bumptech.glide.request.transition.Transition;
import com.ss.android.lark.forwardv2.dto.template.ForwardClickableEnhancedView;
import com.ss.android.lark.log.Log;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class d extends CustomTarget<Bitmap> {
    public final /* synthetic */ CCMShareWordsEnhancedView a;
    public final /* synthetic */ long b;
    public final /* synthetic */ long c;

    public final void onLoadCleared(Drawable r2) {
        Log.i("CCMShareWordsEnhancedView", "getTargetView onLoadCleared");
    }

    public final void onLoadFailed(Drawable r7) {
        super.onLoadFailed(r7);
        Log.i("CCMShareWordsEnhancedView", "getTargetView onLoadFailed");
        CCMShareWordsEnhancedView r8 = this.a;
        CCMShareWordsEnhancedView.a r0 = CCMShareWordsEnhancedView.CREATOR;
        r8.b();
        this.a.p.b("IMAGE_FAIL", this.b, -1);
    }

    public final void onResourceReady(Object r8, Transition r9) {
        Bitmap r10 = (Bitmap) r8;
        Intrinsics.checkNotNullParameter(r10, "resource");
        Log.i("CCMShareWordsEnhancedView", "getTargetView onResourceReady");
        if (CCMShareWordsEnhancedView.a(this.a) != CCMShareWordsEnhancedView.LoadStatus.SUCCESS) goto L53;
        n r0 = this.a.j;
        if (r0 == null) goto L36;
        Intrinsics.checkNotNullParameter(r10, "resource");
        Object r11 = r0.a.getParent();
        View r5 = null;
        if ((r11 instanceof View) == false) goto L9;
        View r12 = (View) r11;
    L10:
        if (r12 == null) goto L12;
        ViewParent r4 = r12.getParent();
    L14:
        if ((r4 instanceof View) == false) goto L16;
        r5 = (View) r4;
    L16:
        if (r12 != null) goto L18;
    L20:
        boolean r13 = false;
    L21:
        if (r13 == true) goto L32;
        if (r5 != null) goto L24;
    L26:
        boolean r14 = false;
    L27:
        if (r14 == true) goto L32;
        if (r0.a.isLaidOut() == false) goto L32;
        boolean r16 = false;
    L33:
        if (r16 == false) goto L35;
        r0.a.post(new o(r0, r10));
        goto L36
    L35:
        r0.a(r10);
        goto L36
    L24:
        if (r5.isLaidOut() == true) goto L26;
        r14 = true;
    L32:
        r16 = true;
        goto L33
    L18:
        if (r12.isLaidOut() == true) goto L20;
        r13 = true;
        goto L21
    L12:
        r4 = null;
        goto L14
    L9:
        r12 = null;
    L36:
        ConstraintLayout r17 = this.a.e;
        if (r17 == null) goto L39;
        r17.setVisibility(0);
    L39:
        ConstraintLayout r18 = this.a.f;
        if (r18 == null) goto L42;
        r18.setVisibility(8);
    L42:
        ConstraintLayout r19 = this.a.c;
        if (r19 == null) goto L45;
        r19.setVisibility(8);
    L45:
        ConstraintLayout r20 = this.a.d;
        if (r20 == null) goto L48;
        r20.setVisibility(8);
    L48:
        ForwardClickableEnhancedView.a r21 = this.a.k;
        if (r21 == null) goto L51;
        r21.a(true);
    L51:
        this.a.p.b("IMAGE_SUCCESS", this.b, this.c);
        return;
    L53:
        if (CCMShareWordsEnhancedView.a(this.a) != CCMShareWordsEnhancedView.LoadStatus.FAILED_CODE) goto L70;
        ConstraintLayout r22 = this.a.d;
        if (r22 == null) goto L57;
        r22.setVisibility(0);
    L57:
        ConstraintLayout r23 = this.a.f;
        if (r23 == null) goto L60;
        r23.setVisibility(8);
    L60:
        ConstraintLayout r24 = this.a.e;
        if (r24 == null) goto L63;
        r24.setVisibility(8);
    L63:
        ConstraintLayout r26 = this.a.c;
        if (r26 == null) goto L66;
        r26.setVisibility(8);
    L66:
        ForwardClickableEnhancedView.a r27 = this.a.k;
        if (r27 == null) goto L69;
        r27.a(false);
    L69:
        this.a.p.b("IMAGE_FAIL", this.b, this.c);
        return;
    L70:
        this.a.b();
        this.a.p.b("IMAGE_FAIL", this.b, this.c);
    }

    public d(CCMShareWordsEnhancedView r1, long r2, long r4) {
        this.a = r1;
        this.b = r2;
        this.c = r4;
    }
}
