package com.ss.android.lark.officesdk.minutes.service.recording.common.statistics;

import com.bytedance.android.livesdkapi.performance.ILoadStallMonitor;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes37.dex */
public final class h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final com.ss.android.lark.officesdk.minutes.service.recording.common.statistics.core.c f435440a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Map<String, b> f435441b;

    public static final class a {
    }

    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public long f435442a;

        public b() {
        }
    }

    static {
    }

    public h(com.ss.android.lark.officesdk.minutes.service.recording.common.statistics.core.c r100) {
        Intrinsics.checkNotNullParameter(r100, "businessTracker");
        this.f435440a = r100;
        this.f435441b = new LinkedHashMap();
    }

    public final void a(String r100, b r101) {
        if (r101.f435442a <= 0) goto L5;
        return;
    L5:
        r101.f435442a = System.currentTimeMillis();
        com.ss.android.lark.officesdk.minutes.service.recording.common.statistics.core.d r102 = new com.ss.android.lark.officesdk.minutes.service.recording.common.statistics.core.d();
        r102.e("scene", "record");
        r102.e("action_name", "start_main_window_dismiss");
        JSONObject r103 = r102.a();
        lvb.a.e("MmRecordingBackgroundRunTracker", "[sendStartStatusEvent] sessionId=".concat(r100));
        this.f435440a.g(r100, "vc_background_run_status", r103);
    }

    public final void b(String r110, b r111) {
        long r100 = r111.f435442a;
        if (r100 > 0) goto L5;
        return;
    L5:
        long r101 = RangesKt.coerceAtLeast(System.currentTimeMillis() - r100, 0);
        r111.f435442a = 0;
        if (r101 >= 1000) goto L9;
        lvb.a.e("MmRecordingBackgroundRunTracker", "[stopIfNeeded] skip short duration, sessionId=" + r110 + ", startTime=" + r100 + ", duration=" + r101);
        return;
    L9:
        com.ss.android.lark.officesdk.minutes.service.recording.common.statistics.core.d r102 = new com.ss.android.lark.officesdk.minutes.service.recording.common.statistics.core.d();
        r102.e("scene", "record");
        r102.e("action_name", "stop_main_window_dismiss");
        r102.c(ILoadStallMonitor.START_TIME, r100);
        r102.c("duration", r101);
        JSONObject r103 = r102.a();
        lvb.a.e("MmRecordingBackgroundRunTracker", "[sendStopStatusEvent] sessionId=" + r110 + ", startTime=" + r100 + ", duration=" + r101);
        this.f435440a.g(r110, "vc_background_run_status", r103);
    }
}
