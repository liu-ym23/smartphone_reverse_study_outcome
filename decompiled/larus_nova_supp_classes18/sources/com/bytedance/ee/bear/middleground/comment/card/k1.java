package com.bytedance.ee.bear.middleground.comment.card;

import android.view.MotionEvent;
import android.view.View;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class k1 implements View.OnTouchListener {
    public final /* synthetic */ HalfScreenCardComment a;

    public k1(HalfScreenCardComment r1) {
        this.a = r1;
    }

    @Override // android.view.View.OnTouchListener
    public final boolean onTouch(View r1, MotionEvent r2) {
        this.a.d.m(r2.getRawY());
        return false;
    }
}
