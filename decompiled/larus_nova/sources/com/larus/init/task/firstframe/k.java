package com.larus.init.task.firstframe;

import com.bytedance.lego.init.InitScheduler;
import com.larus.utils.logger.FLogger;

/* JADX INFO: loaded from: classes4.dex */
public final class k extends kg9.i {
    @Override // kg9.i
    public final void c() {
    }

    public k() {
        super(15000);
    }

    @Override // kg9.i
    public final void b() {
        if (l.f351315h == false) goto L6;
        FLogger.f375446a.d("FlowFirstFrameTaskDispatcher", "Countdown timer finished,but already dispatch feed show!");
        return;
    L6:
        FLogger.f375446a.d("FlowFirstFrameTaskDispatcher", "Countdown timer finished, need to redispatch feed show tasks!");
        InitScheduler.onFeedShow();
    }
}
