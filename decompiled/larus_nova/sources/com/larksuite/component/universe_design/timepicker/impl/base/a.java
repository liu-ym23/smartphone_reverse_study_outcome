package com.larksuite.component.universe_design.timepicker.impl.base;

import android.os.Handler;
import android.os.Message;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes24.dex */
public final class a extends Handler {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final WheelView f285393a;

    /* JADX INFO: renamed from: com.larksuite.component.universe_design.timepicker.impl.base.a$a, reason: collision with other inner class name */
    public static final class C3921a {
    }

    static {
    }

    public a(WheelView r100) {
        Intrinsics.checkNotNullParameter(r100, "loopview");
        this.f285393a = r100;
    }

    @Override // android.os.Handler
    public final void handleMessage(Message r100) {
        Intrinsics.checkNotNullParameter(r100, "msg");
        int r101 = r100.what;
        if (r101 != 1000) goto L5;
        this.f285393a.invalidate();
        return;
    L5:
        if (r101 != 2000) goto L7;
        this.f285393a.smoothScroll(WheelView.ACTION.FLING);
        return;
    L7:
        if (r101 != 3000) goto L15;
        this.f285393a.onItemSelected();
        return;
    }
}
