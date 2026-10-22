package com.ss.android.lark.widget.wheelpicker;

import android.os.Handler;
import android.os.Message;

/* JADX INFO: loaded from: classes38.dex */
public final class a extends Handler {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final WheelView f449114a;

    public a(WheelView r100) {
        this.f449114a = r100;
    }

    @Override // android.os.Handler
    public final void handleMessage(Message r100) {
        int r101 = r100.what;
        if (r101 != 1000) goto L5;
        this.f449114a.invalidate();
        return;
    L5:
        if (r101 != 2000) goto L7;
        this.f449114a.b(WheelView.ACTION.FLING);
        return;
    L7:
        if (r101 != 3000) goto L15;
        this.f449114a.getClass();
        return;
    }
}
