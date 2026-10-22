package com.ss.android.lark.custom.repeat.widget.wheelview;

import android.os.Handler;
import android.os.Message;
import tab.c;

/* JADX INFO: loaded from: classes35.dex */
public final class a extends Handler {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final WheelView f420388a;

    public a(WheelView r100) {
        this.f420388a = r100;
    }

    @Override // android.os.Handler
    public final void handleMessage(Message r100) {
        int r101 = r100.what;
        if (r101 != 1000) goto L5;
        this.f420388a.invalidate();
        return;
    L5:
        if (r101 != 2000) goto L7;
        this.f420388a.d(WheelView.ACTION.FLING);
        return;
    L7:
        if (r101 != 3000) goto L18;
        WheelView r102 = this.f420388a;
        if (r102.f420362c == null) goto L15;
        r102.postDelayed(new c(r102), 0);
        return;
    L15:
        return;
    }
}
