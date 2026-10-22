package com.bytedance.ee.bear.middleground.comment.card;

import android.view.MotionEvent;
import android.view.View;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class s implements View.OnTouchListener {
    public final /* synthetic */ FloatCardComment a;

    public s(FloatCardComment r1) {
        this.a = r1;
    }

    @Override // android.view.View.OnTouchListener
    public final boolean onTouch(View r4, MotionEvent r5) {
        FloatCardComment r0 = this.a;
        Intrinsics.checkNotNull(r4);
        Intrinsics.checkNotNull(r5);
        return r0.g(r4, r5, true, "input_bottom_button");
    }
}
