package com.larus.larkfeed.impl.gallery;

import android.view.GestureDetector;
import android.view.MotionEvent;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes30.dex */
public final class f extends GestureDetector.SimpleOnGestureListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ LarkImageView f355213a;

    @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
    public final boolean onDown(MotionEvent r100) {
        Intrinsics.checkNotNullParameter(r100, "e");
        return true;
    }

    public f(LarkImageView r100) {
        this.f355213a = r100;
    }

    @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
    public final void onLongPress(MotionEvent r100) {
        Intrinsics.checkNotNullParameter(r100, "e");
        LarkImageView r101 = this.f355213a;
        com.larus.gallery.api.j r102 = r101.f355176g;
        if (r102 != null) goto L5;
        return;
    L5:
        r101.f355179j = true;
        r102.b();
    }
}
