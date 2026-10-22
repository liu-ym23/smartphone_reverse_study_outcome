package com.bytedance.ee.bear.middleground.comment.card;

import android.view.MotionEvent;
import android.view.View;
import com.bytedance.ee.bear.middleground.comment.uitls.CommentUtils;
import kotlin.Lazy;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class b0 implements View.OnTouchListener {
    public final /* synthetic */ FloatCardComment a;

    public b0(FloatCardComment r1) {
        this.a = r1;
    }

    @Override // android.view.View.OnTouchListener
    public final boolean onTouch(View r4, MotionEvent r5) {
        Lazy r0 = CommentUtils.a;
        if (CommentUtils.b(r4.getContext()) == false) goto L5;
        return false;
    L5:
        FloatCardComment r1 = this.a;
        Intrinsics.checkNotNull(r4);
        Intrinsics.checkNotNull(r5);
        return r1.g(r4, r5, false, "input_left_button");
    }
}
