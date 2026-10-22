package com.bytedance.livesdk.ktvcommon.download;

import com.bytedance.livesdk.ktvcommon.download.api.g;
import com.bytedance.livesdk.ktvcommon.download.model.DownloadState;
import com.ss.android.socialbase.downloader.constants.DBDefinition;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: classes20.dex */
public final class e implements g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ TaskScheduler f255937a;

    public e(TaskScheduler r100) {
        this.f255937a = r100;
    }

    @Override // com.bytedance.livesdk.ktvcommon.download.api.g
    public final void b(String r100, int r110) {
        Intrinsics.checkNotNullParameter(r100, DBDefinition.TASK_ID);
        com.bytedance.livesdk.ktvcommon.download.model.e r101 = this.f255937a.f255920c.get(r100);
        if (r101 != null) goto L5;
        return;
    L5:
        r101.f255972j = RangesKt.coerceIn(r110, 0, 100);
        com.bytedance.live.kmp.util.c r111 = com.bytedance.live.kmp.util.c.f255167a;
        r101.f255970h = System.currentTimeMillis();
        b r112 = this.f255937a.f255923f;
        int r102 = r101.f255972j;
        r112.getClass();
        Intrinsics.checkNotNullParameter(r101, "task");
        Map<String, CopyOnWriteArrayList<com.bytedance.livesdk.ktvcommon.download.api.a>> r113 = r112.f255933a;
        LinkedHashMap r114 = (LinkedHashMap) r113;
        CopyOnWriteArrayList r115 = (CopyOnWriteArrayList) r114.get(r101.f255964b);
        if (r115 == null) goto L11;
        Iterator r116 = r115.iterator();
    L9:
        if (r116.hasNext() == false) goto L13;
        ((com.bytedance.livesdk.ktvcommon.download.api.a) r116.next()).b(r101.f255964b, r101.f255965c, r101.f255963a, r101.f255966d.f255976c, r102, r101.f255968f);
        goto L9
    L13:
        return;
    }

    @Override // com.bytedance.livesdk.ktvcommon.download.api.g
    public final void a(String r100, DownloadState r101, com.bytedance.livesdk.ktvcommon.download.model.d r102) {
        Intrinsics.checkNotNullParameter(r100, DBDefinition.TASK_ID);
        Intrinsics.checkNotNullParameter(r101, "state");
        Intrinsics.checkNotNullParameter(r102, "result");
        int r103 = yk6.g.f568232a;
        yk6.g.a("KTV-Download-Scheduler", "onCompleted: taskId=" + r100 + ", state=" + r101 + ", result=" + r102);
        TaskScheduler r104 = this.f255937a;
        com.bytedance.livesdk.ktvcommon.download.model.e r105 = r104.f255920c.remove(r100);
        if (r105 == null) goto L38;
        Intrinsics.checkNotNullParameter(r101, "<set-?>");
        r105.f255967e = r101;
        b r106 = r104.f255923f;
        r106.getClass();
        Intrinsics.checkNotNullParameter(r105, "task");
        Intrinsics.checkNotNullParameter(r101, "state");
        Intrinsics.checkNotNullParameter(r102, "result");
        yk6.g.a("KTV-Download-Task", "notifyTaskCompleted: batchId=" + r105.f255964b + ", taskId=" + r105.f255963a + ", state=" + r101);
        CopyOnWriteArrayList r107 = (CopyOnWriteArrayList) ((LinkedHashMap) r106.f255933a).get(r105.f255964b);
        if (r107 == null) goto L11;
        Iterator r108 = r107.iterator();
    L9:
        if (r108.hasNext() == false) goto L11;
        ((com.bytedance.livesdk.ktvcommon.download.api.a) r108.next()).a(r105.f255964b, r105.f255965c, r101, r102);
    L11:
        String r109 = r105.f255964b;
        int r110 = yk6.g.f568232a;
        yk6.g.a("KTV-Download-Scheduler", "handleTaskCompletion: batchId=" + r109 + ", taskId=" + r100 + ", state=" + r101);
        if (r104.f255921d.c(r109) == false) goto L30;
        monitor-enter(r104);
        Iterator r111 = ((ArrayList) r104.f255919b).iterator();     // Catch: Throwable -> L27
    L16:
        if (r111.hasNext() == false) goto L20;
        Object r112 = r111.next();     // Catch: Throwable -> L27
        if (Intrinsics.areEqual(((TaskScheduler.d) r112).f255925a, r109) == false) goto L16;
    L21:
        TaskScheduler.d r113 = (TaskScheduler.d) r112;     // Catch: Throwable -> L27
        if (r113 == null) goto L24;
        ((ArrayList) r104.f255919b).remove(r113);     // Catch: Throwable -> L27
        int r114 = yk6.g.f568232a;     // Catch: Throwable -> L27
        yk6.g.a("KTV-Download-Scheduler", "Batch " + r109 + " completed, remaining active: " + ((ArrayList) r104.f255919b).size());     // Catch: Throwable -> L27
    L24:
        Unit r115 = Unit.INSTANCE;     // Catch: Throwable -> L27
        monitor-exit(r104);
        r104.c();
        return;
    L20:
        r112 = null;
    L27:
        th = move-exception;
        throw th;
    L30:
        return;
    }
}
