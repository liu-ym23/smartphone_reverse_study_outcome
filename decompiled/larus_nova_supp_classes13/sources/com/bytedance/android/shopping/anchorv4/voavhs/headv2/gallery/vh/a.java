package com.bytedance.android.shopping.anchorv4.voavhs.headv2.gallery.vh;

import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class a implements View.OnTouchListener {
    public final /* synthetic */ GestureDetector a;

    public a(GestureDetector r1) {
        this.a = r1;
    }

    @Override // android.view.View.OnTouchListener
    public final boolean onTouch(View r1, MotionEvent r2) {
        this.a.onTouchEvent(r2);
        return true;
    }
}
