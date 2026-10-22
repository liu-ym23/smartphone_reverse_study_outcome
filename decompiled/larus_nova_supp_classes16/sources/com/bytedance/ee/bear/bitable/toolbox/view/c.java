package com.bytedance.ee.bear.bitable.toolbox.view;

import android.view.GestureDetector;
import android.view.MotionEvent;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class c implements Function1<MotionEvent, Unit> {
    public final /* synthetic */ GestureDetector a;

    public c(GestureDetector r1) {
        this.a = r1;
    }

    public final Object invoke(Object r2) {
        MotionEvent r3 = (MotionEvent) r2;
        if (r3 == null) goto L6;
        this.a.onTouchEvent(r3);
    L6:
        return Unit.INSTANCE;
    }
}
