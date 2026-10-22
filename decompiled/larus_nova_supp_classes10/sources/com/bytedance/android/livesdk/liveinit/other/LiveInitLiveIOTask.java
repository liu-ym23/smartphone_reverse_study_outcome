package com.bytedance.android.livesdk.liveinit.other;

import com.bytedance.android.live.room.e;
import com.bytedance.android.livesdk.init.AbsLiveInitUnit;
import com.bytedance.android.livesdk.init.InitThread;
import com.bytedance.android.livesdk.init.LiveInitPoint;
import com.bytedance.android.livesdk.init.LiveInitUnitKey;
import com.bytedance.android.livesdkapi.init.LiveInitAssistant;
import is0.c;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0016J\b\u0010\u0005\u001a\u00020\u0006H\u0016J\b\u0010\u0007\u001a\u00020\bH\u0016J\b\u0010\t\u001a\u00020\nH\u0016J\b\u0010\u000b\u001a\u00020\fH\u0016¨\u0006\r"}, d2 = {"Lcom/bytedance/android/livesdk/liveinit/other/LiveInitLiveIOTask;", "Lcom/bytedance/android/livesdk/init/AbsLiveInitUnit;", "()V", "getUnitKey", "Lcom/bytedance/android/livesdk/init/LiveInitUnitKey;", "initPoint", "Lcom/bytedance/android/livesdk/init/LiveInitPoint;", "initialize", "", "lazyInitThread", "Lcom/bytedance/android/livesdk/init/InitThread;", "postDelayTime", "", "livesdk-init_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class LiveInitLiveIOTask extends AbsLiveInitUnit {
    public static final LiveInitLiveIOTask INSTANCE = null;

    static {
        INSTANCE = new LiveInitLiveIOTask();
    }

    public InitThread lazyInitThread() {
        return getInitThreadWithConfig(LiveInitAssistant.INSTANCE.getInitConfigInner().getUnitThreadConfig().getInitLiveio());
    }

    public long postDelayTime() {
        return LiveInitAssistant.INSTANCE.getInitConfigInner().getUnitPostDelayConfig().getCommonDelayTime();
    }

    public void initialize() {
        e r0 = c.c().dnsOptimizer();
        if (r0 == null) goto L6;
        r0.sync();
        r0.b();
        return;
    }

    private LiveInitLiveIOTask() {
    }

    public LiveInitUnitKey getUnitKey() {
        return LiveInitUnitKey.LiveInitLiveIOTask;
    }

    public LiveInitPoint initPoint() {
        return LiveInitPoint.ENTER_ROOM;
    }
}
