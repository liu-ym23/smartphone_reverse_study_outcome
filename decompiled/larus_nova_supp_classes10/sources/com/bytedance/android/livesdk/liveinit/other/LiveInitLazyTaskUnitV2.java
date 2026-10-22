package com.bytedance.android.livesdk.liveinit.other;

import com.bytedance.android.live.core.launch.AbsTask;
import com.bytedance.android.livesdk.init.AbsLiveInitUnit;
import com.bytedance.android.livesdk.init.InitThread;
import com.bytedance.android.livesdk.init.LiveInitPoint;
import com.bytedance.android.livesdk.init.LiveInitUnitKey;
import com.bytedance.android.livesdkapi.init.LiveInitAssistant;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010\u000b\u001a\u00020\fH\u0016J\b\u0010\r\u001a\u00020\u000eH\u0016J\b\u0010\u000f\u001a\u00020\u0010H\u0016J\b\u0010\u0011\u001a\u00020\u0012H\u0016J\b\u0010\u0013\u001a\u00020\u0014H\u0016R+\u0010\u0003\u001a\u0012\u0012\u0004\u0012\u00020\u00050\u0004j\b\u0012\u0004\u0012\u00020\u0005`\u00068FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u0007\u0010\b¨\u0006\u0015"}, d2 = {"Lcom/bytedance/android/livesdk/liveinit/other/LiveInitLazyTaskUnitV2;", "Lcom/bytedance/android/livesdk/init/AbsLiveInitUnit;", "()V", "taskList", "Ljava/util/ArrayList;", "Lcom/bytedance/android/live/core/launch/AbsTask;", "Lkotlin/collections/ArrayList;", "getTaskList", "()Ljava/util/ArrayList;", "taskList$delegate", "Lkotlin/Lazy;", "getUnitKey", "Lcom/bytedance/android/livesdk/init/LiveInitUnitKey;", "initPoint", "Lcom/bytedance/android/livesdk/init/LiveInitPoint;", "initialize", "", "lazyInitThread", "Lcom/bytedance/android/livesdk/init/InitThread;", "postDelayTime", "", "livesdk-init_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class LiveInitLazyTaskUnitV2 extends AbsLiveInitUnit {
    public static final LiveInitLazyTaskUnitV2 INSTANCE = null;
    private static final Lazy taskList$delegate = null;

    public final ArrayList<AbsTask> getTaskList() {
        return (ArrayList) taskList$delegate.getValue();
    }

    static {
        INSTANCE = new LiveInitLazyTaskUnitV2();
        taskList$delegate = LazyKt.lazy(LiveInitLazyTaskUnitV2$taskList$2.INSTANCE);
    }

    public InitThread lazyInitThread() {
        return getInitThreadWithConfig(LiveInitAssistant.INSTANCE.getInitConfigInner().getUnitThreadConfig().getInitLazyTaskV2());
    }

    public long postDelayTime() {
        return LiveInitAssistant.INSTANCE.getInitConfigInner().getUnitPostDelayConfig().getCommonDelayTime();
    }

    public void initialize() {
        Iterator<T> r0 = getTaskList().iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        ((AbsTask) r0.next()).start();
        goto L4
    }

    private LiveInitLazyTaskUnitV2() {
    }

    public LiveInitUnitKey getUnitKey() {
        return LiveInitUnitKey.LiveInitLazyTaskUnit_V2;
    }

    public LiveInitPoint initPoint() {
        return LiveInitPoint.ENTER_ROOM;
    }
}
