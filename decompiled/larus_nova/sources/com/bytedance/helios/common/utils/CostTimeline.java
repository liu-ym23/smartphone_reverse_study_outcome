package com.bytedance.helios.common.utils;

import android.os.SystemClock;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: classes19.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\b\b\u0007\u0018\u00002\u00020\u0001B\u000f\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J5\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0011\u001a\u00020\u00032\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u000f¢\u0006\u0002\u0010\u0013J\u001a\u0010\u0014\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u000fJ\u000e\u0010\u0015\u001a\u00020\r2\u0006\u0010\u0016\u001a\u00020\u000fR\u0017\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0017"}, d2 = {"Lcom/bytedance/helios/common/utils/CostTimeline;", "", "init", "", "(J)V", "costTimeLogs", "Ljava/util/concurrent/CopyOnWriteArrayList;", "Lcom/bytedance/helios/common/utils/CostTimeLog;", "getCostTimeLogs", "()Ljava/util/concurrent/CopyOnWriteArrayList;", "getInit", "()J", "logCostTime", "", "label", "", "start", "end", "message", "(Ljava/lang/String;Ljava/lang/Long;JLjava/lang/String;)V", "logTotal", "printLog", "tag", "common_release"}, k = 1, mv = {1, 1, 16})
public final class CostTimeline {
    private final CopyOnWriteArrayList<CostTimeLog> costTimeLogs;
    private final long init;

    public static final class a implements Runnable {
    }

    public CostTimeline() {
        long r100 = 0;
        this(r100, 1, null);
    }

    public final void printLog(String r100) {
    }

    public final CopyOnWriteArrayList<CostTimeLog> getCostTimeLogs() {
        return this.costTimeLogs;
    }

    public final long getInit() {
        return this.init;
    }

    public CostTimeline(long r100) {
        this.init = r100;
        this.costTimeLogs = new CopyOnWriteArrayList();
    }

    public final void logTotal(String r110, String r111) {
        this.costTimeLogs.add(new CostTimeLog(r110 + "(total)", Long.valueOf(this.init), 0, r111, 4, null));
    }

    public /* synthetic */ CostTimeline(long r100, int r101, DefaultConstructorMarker r102) {
        if ((r101 & 1) == 0) goto L5;
        r100 = SystemClock.elapsedRealtimeNanos();
    L5:
        this(r100);
    }

    public final void logCostTime(String r100, Long r110, long r111, String r112) {
        CostTimeLog r101 = (CostTimeLog) CollectionsKt.lastOrNull(this.costTimeLogs);
        if (r110 != null) goto L9;
        if (r101 == null) goto L7;
        long r102 = r101.getEnd();
    L8:
        r110 = Long.valueOf(r102);
        goto L9
    L7:
        r102 = this.init;
    L9:
        CostTimeLog r103 = new CostTimeLog(r100, r110, r111, r112);
        this.costTimeLogs.add(r103);
    }

    public static /* synthetic */ void logTotal$default(CostTimeline r100, String r101, String r102, int r103, Object r104) {
        if ((r103 & 2) == 0) goto L5;
        r102 = null;
    L5:
        r100.logTotal(r101, r102);
    }

    public static /* synthetic */ void logCostTime$default(CostTimeline r100, String r101, Long r102, long r110, String r111, int r112, Object r113) {
        if ((r112 & 2) == 0) goto L5;
        Long r103 = null;
    L7:
        if ((r112 & 4) == 0) goto L9;
        r110 = SystemClock.elapsedRealtimeNanos();
    L9:
        long r104 = r110;
        if ((r112 & 8) == 0) goto L12;
        String r105 = null;
    L13:
        r100.logCostTime(r101, r103, r104, r105);
        return;
    L12:
        r105 = r111;
        goto L13
    L5:
        r103 = r102;
        goto L7
    }
}
