package com.bytedance.ee.bear.profile;

import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class e implements View.OnTouchListener {
    public final /* synthetic */ HalfProfileActivity a;

    public e(HalfProfileActivity r1) {
        this.a = r1;
    }

    @Override // android.view.View.OnTouchListener
    public final boolean onTouch(View r2, MotionEvent r3) {
        Intrinsics.checkNotNullParameter(r3, "event");
        GestureDetector r4 = this.a.n;
        if (r4 != null) goto L5;
        return false;
    L5:
        if (r4.onTouchEvent(r3) != true) goto L9;
        return true;
    L9:
        return false;
    }
}
