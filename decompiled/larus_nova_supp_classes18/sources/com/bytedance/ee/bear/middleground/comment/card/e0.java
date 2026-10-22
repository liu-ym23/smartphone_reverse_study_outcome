package com.bytedance.ee.bear.middleground.comment.card;

import android.view.MotionEvent;
import android.view.View;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class e0 implements View.OnTouchListener {
    public final /* synthetic */ FloatCardComment a;

    public e0(FloatCardComment r1) {
        this.a = r1;
    }

    @Override // android.view.View.OnTouchListener
    public final boolean onTouch(View r7, MotionEvent r8) {
        FloatCardComment r0 = this.a;
        Intrinsics.checkNotNull(r7);
        Intrinsics.checkNotNull(r8);
        return r0.f(r7, r8, false, "input_left_button", com.bytedance.ee.bear.middleground.comment.export.e.c());
    }
}
