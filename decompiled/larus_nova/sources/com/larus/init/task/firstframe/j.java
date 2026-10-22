package com.larus.init.task.firstframe;

import com.larus.utils.logger.FLogger;

/* JADX INFO: loaded from: classes4.dex */
public final class j extends kg9.i {
    @Override // kg9.i
    public final void c() {
    }

    public j() {
        super(10000);
    }

    @Override // kg9.i
    public final void b() {
        if (l.f351308a == true) goto L6;
        FLogger.f375446a.d("FlowFirstFrameTaskDispatcher", "Countdown timer finished, need to redispatch first frame tasks!");
        l.a();
        return;
    }
}
