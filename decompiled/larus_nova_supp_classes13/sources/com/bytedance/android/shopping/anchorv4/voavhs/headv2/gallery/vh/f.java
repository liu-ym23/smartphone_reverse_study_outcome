package com.bytedance.android.shopping.anchorv4.voavhs.headv2.gallery.vh;

import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.lifecycle.Observer;
import com.bytedance.android.shopping.anchorv4.voavhs.headv2.gallery.i;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class f<T> implements Observer {
    public final /* synthetic */ GalleryVideoVH a;

    public f(GalleryVideoVH r1) {
        this.a = r1;
    }

    public final void onChanged(Object r6) {
        GalleryVideoVH r0 = this.a;
        int r7 = ((Integer) r6).intValue();
        View r1 = r0.c;
        ViewGroup.LayoutParams r2 = null;
        if (r1 == null) goto L11;
        ViewGroup.LayoutParams r3 = r1.getLayoutParams();
        if ((r3 instanceof ViewGroup.MarginLayoutParams) == true) goto L7;
        r3 = null;
    L7:
        ViewGroup.MarginLayoutParams r4 = (ViewGroup.MarginLayoutParams) r3;
        if (r4 == null) goto L11;
        r4.bottomMargin = r7;
        r1.setLayoutParams(r4);
    L11:
        if (i.a() == false) goto L22;
        FrameLayout r5 = r0.d;
        if (r5 == null) goto L23;
        ViewGroup.LayoutParams r8 = r5.getLayoutParams();
        if ((r8 instanceof ViewGroup.MarginLayoutParams) == false) goto L18;
        r2 = r8;
    L18:
        ViewGroup.MarginLayoutParams r9 = (ViewGroup.MarginLayoutParams) r2;
        if (r9 == null) goto L24;
        r9.bottomMargin = r7;
        r5.setLayoutParams(r9);
        return;
    L24:
        return;
    L23:
        return;
    }
}
