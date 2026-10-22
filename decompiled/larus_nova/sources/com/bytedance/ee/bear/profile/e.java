package com.bytedance.ee.bear.profile;

import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes18.dex */
public final class e implements View.OnTouchListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ HalfProfileActivity f236285a;

    public e(HalfProfileActivity r100) {
        this.f236285a = r100;
    }

    @Override // android.view.View.OnTouchListener
    public final boolean onTouch(View r100, MotionEvent r101) {
        Intrinsics.checkNotNullParameter(r101, "event");
        GestureDetector r102 = this.f236285a.f236252n;
        if (r102 != null) goto L5;
        return false;
    L5:
        if (r102.onTouchEvent(r101) != true) goto L9;
        return true;
    L9:
        return false;
    }
}
