package com.bytedance.ug.sdk.luckydog.task.newTimer;

import com.bytedance.ug.sdk.luckydog.task.n;
import com.bytedance.ug.sdk.luckyhost.api.api.countTimer.LuckyCounterTaskStatus;
import il7.m;
import java.util.concurrent.CopyOnWriteArraySet;
import kotlin.reflect.KProperty;
import xm7.h;

/* JADX INFO: loaded from: classes22.dex */
public final class a implements h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ LuckyNewTimerManager.a f271963a;

    public a(LuckyNewTimerManager.a r100) {
        this.f271963a = r100;
    }

    @Override // xm7.h
    public final void c(LuckyCounterTaskStatus r100) {
        if (r100 != LuckyCounterTaskStatus.TASK_STATUS_COMPLETE) goto L5;
    L6:
        com.bytedance.ug.sdk.luckydog.api.log.d.d("LuckyNewTimerManager", "onTaskStateChange() 任务结束, 移除掉token");
        KProperty[] r101 = LuckyNewTimerManager.f271935a;
        CopyOnWriteArraySet<String> r102 = LuckyNewTimerManager.f271941g;
        r102.remove(this.f271963a.f271952a);
        m.a().h(this.f271963a.f271952a);
        n.c(r102);
        return;
    L5:
        if (r100 == LuckyCounterTaskStatus.TASK_STATUS_EXPIRED) goto L6;
    }
}
