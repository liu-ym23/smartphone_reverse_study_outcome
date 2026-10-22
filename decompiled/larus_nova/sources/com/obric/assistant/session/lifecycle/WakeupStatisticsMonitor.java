package com.obric.assistant.session.lifecycle;

import android.content.Context;
import com.obric.assistant.wakeup.statistics.api.IWakeupStatisticsAPI;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes33.dex */
public final class WakeupStatisticsMonitor extends a {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final WakeupStatisticsMonitor f391619b = null;

    static {
        f391619b = new WakeupStatisticsMonitor();
    }

    @Override // bga.i
    public final void onDestroy() {
        IWakeupStatisticsAPI r100 = wha.a.a();
        if (r100 == null) goto L6;
        r100.destroy();
        return;
    }

    public WakeupStatisticsMonitor() {
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [com.obric.assistant.session.lifecycle.f] */
    @Override // bga.i
    public final void a(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        IWakeupStatisticsAPI r101 = wha.a.a();
        if (r101 == 0) goto L6;
        r101.a(new f());
        return;
    }
}
