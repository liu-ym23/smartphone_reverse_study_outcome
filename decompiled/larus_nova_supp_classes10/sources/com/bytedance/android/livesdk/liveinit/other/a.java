package com.bytedance.android.livesdk.liveinit.other;

import com.bytedance.android.livesdk.init.AbsLiveInitUnit;
import com.bytedance.android.livesdk.init.InitThread;
import com.bytedance.android.livesdk.init.LiveInitPoint;
import com.bytedance.android.livesdk.init.LiveInitUnitKey;
import com.bytedance.android.livesdk.log.ILoggerLifeManagerService;
import com.bytedance.android.livesdkapi.init.LiveInitAssistant;
import jc1.k;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class a extends AbsLiveInitUnit {
    public static final a a = null;

    static {
        a = new a();
    }

    public final void initialize() {
        ILoggerLifeManagerService r0 = (ILoggerLifeManagerService) k.f(ILoggerLifeManagerService.class);
        if (r0 == null) goto L6;
        r0.initConfig();
        return;
    }

    public final InitThread lazyInitThread() {
        return getInitThreadWithConfig(LiveInitAssistant.INSTANCE.getInitConfigInner().getUnitThreadConfig().getEnsureLazy());
    }

    public final long postDelayTime() {
        return LiveInitAssistant.INSTANCE.getInitConfigInner().getUnitPostDelayConfig().getEnsureLazyTime();
    }

    public a() {
    }

    public final LiveInitUnitKey getUnitKey() {
        return LiveInitUnitKey.LiveEnsureLazyUnit;
    }

    public final LiveInitPoint initPoint() {
        return LiveInitPoint.ENTER_ROOM;
    }
}
