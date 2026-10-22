package com.bytedance.android.shopping.anchorv4.voavhs.headv2.gallery.vh;

import android.view.GestureDetector;
import android.view.MotionEvent;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class b extends GestureDetector.SimpleOnGestureListener {
    public final /* synthetic */ GalleryVideoVH a;

    public b(GalleryVideoVH r1) {
        this.a = r1;
    }

    @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
    public final boolean onSingleTapUp(MotionEvent r3) {
        Intrinsics.checkNotNullParameter(r3, "e");
        GalleryVideoVH r4 = this.a;
        int r0 = GalleryVideoVH.s;
        if (r4.X3() == false) goto L5;
        this.a.q.f.setMoreVideoExpanded(false);
    L6:
        return true;
    L5:
        GalleryVideoVH r5 = this.a;
        GalleryVideoVH.U3(r5, !GalleryVideoVH.T3(r5).isPlaying());
        goto L6
    }
}
