package com.ss.android.lark.imageocr.select;

import android.view.MotionEvent;
import android.view.View;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes36.dex */
public final class h implements View.OnTouchListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ e f426547a;

    public h(e r100) {
        this.f426547a = r100;
    }

    @Override // android.view.View.OnTouchListener
    public final boolean onTouch(View r100, MotionEvent r101) {
        Intrinsics.checkNotNullParameter(r101, "event");
        e r102 = this.f426547a;
        r102.f426504h = (int) r101.getX();
        e r103 = this.f426547a;
        r103.f426505i = (int) r101.getY();
        return false;
    }
}
