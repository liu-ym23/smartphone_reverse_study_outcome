package com.bytedance.ug.sdk.luckydog.task.newTimer;

import com.bytedance.ug.sdk.luckydog.task.n;
import com.bytedance.ug.sdk.luckyhost.api.api.timer.LuckyTimerStatus;
import java.util.concurrent.CopyOnWriteArraySet;
import kotlin.reflect.KProperty;

/* JADX INFO: loaded from: classes22.dex */
public final class b implements zm7.c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ LuckyNewTimerManager.b f271964a;

    public b(LuckyNewTimerManager.b r100) {
        this.f271964a = r100;
    }

    @Override // zm7.c
    public final void a(LuckyTimerStatus r100) {
        if (r100 != LuckyTimerStatus.TASK_TIME_END) goto L5;
    L6:
        com.bytedance.ug.sdk.luckydog.api.log.d.d("LuckyNewTimerManager", "onTaskStateChange() 任务结束, 移除掉token");
        KProperty[] r101 = LuckyNewTimerManager.f271935a;
        CopyOnWriteArraySet<String> r102 = LuckyNewTimerManager.f271941g;
        r102.remove(this.f271964a.f271953a);
        n.c(r102);
        return;
    L5:
        if (r100 == LuckyTimerStatus.TASK_TIMER_EXPIRE) goto L6;
    }
}
