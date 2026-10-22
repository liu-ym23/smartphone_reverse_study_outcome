package com.bytedance.locallife.dito.common.lynx;

import android.view.MotionEvent;
import android.view.View;
import aq6.l;

/* JADX INFO: loaded from: classes21.dex */
public final class a implements View.OnTouchListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ View f257384a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ boolean f257385b;

    public a(View r100, boolean r101) {
        this.f257384a = r100;
        this.f257385b = r101;
    }

    @Override // android.view.View.OnTouchListener
    public final boolean onTouch(View r100, MotionEvent r101) {
        int r102 = l.f15909a;
        if (l.a(this.f257384a) == true) goto L5;
    L8:
        return true;
    L5:
        if (this.f257385b == false) goto L8;
        return false;
    }
}
