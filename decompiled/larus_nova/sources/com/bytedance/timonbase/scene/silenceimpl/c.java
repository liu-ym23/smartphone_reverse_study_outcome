package com.bytedance.timonbase.scene.silenceimpl;

import android.view.MotionEvent;
import android.view.View;

/* JADX INFO: loaded from: classes22.dex */
public final class c implements View.OnTouchListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final View.OnTouchListener f270897a;

    public c(View.OnTouchListener r100) {
        this.f270897a = r100;
    }

    @Override // android.view.View.OnTouchListener
    public final boolean onTouch(View r100, MotionEvent r101) {
        if (r101 != null) goto L4;
    L6:
        View.OnTouchListener r102 = this.f270897a;
        if (r102 != null) goto L11;
        return false;
    L11:
        return r102.onTouch(r100, r101);
    L4:
        if (r101.getAction() != 0) goto L6;
        b.a();
        goto L6
    }
}
