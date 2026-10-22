package com.ss.android.lark.widget.photo.preview.video.online;

import android.view.MotionEvent;

/* JADX INFO: loaded from: classes38.dex */
public final class k0 implements y0c.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ f0 f447373a;

    @Override // y0c.b
    public final /* synthetic */ void f() {
    }

    @Override // y0c.b
    public final /* synthetic */ void onDoubleTap(MotionEvent r100) {
    }

    @Override // y0c.b
    public final /* synthetic */ void onDown(MotionEvent r100) {
    }

    @Override // y0c.b
    public final /* synthetic */ void onScroll(MotionEvent r100, MotionEvent r101, float r102, float r103) {
    }

    @Override // y0c.b
    public final /* synthetic */ void onSingleTapUp(MotionEvent r100) {
    }

    public k0(f0 r100) {
        this.f447373a = r100;
    }

    @Override // y0c.b
    public final void onLongPress(MotionEvent r100) {
        f0 r101 = this.f447373a;
        if (r101.f447339t == false) goto L9;
        r101.f447325f.performHapticFeedback(0);
        if (com.ss.android.lark.widget.photopicker.f.a().t() == false) goto L7;
        f r102 = this.f447373a.B;
        r102.f447318b.generateFuncListItems(r102.f447317a, false);
        return;
    L7:
        this.f447373a.f447326g.A4();
        return;
    }
}
