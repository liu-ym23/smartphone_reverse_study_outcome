package com.ss.android.lark.officesdk.minutes.service.recording.common.perf.appreciable;

import com.ss.android.lark.officesdk.minutes.service.recording.common.statistics.core.MmRecordingCommonParam;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes37.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final b f434673a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final c f434674b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final d f434675c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final MmRecordingSubtitleAppreciable f434676d = null;

    static {
        f434673a = new b();
        f434674b = new c();
        f434675c = new d();
        f434676d = new MmRecordingSubtitleAppreciable();
    }

    public static void a(String r100, MmRecordingCommonParam r101, JSONObject r102) {
        Intrinsics.checkNotNullParameter(r100, "actionName");
        Intrinsics.checkNotNullParameter(r101, "commonParam");
        Intrinsics.checkNotNullParameter(r102, "extras");
        lvb.a.e("MmRecordingCoreMetrics", "[sendEvent] actionName=" + r100 + ", extras=" + r102);     // Catch: Exception -> L5
        com.ss.android.lark.officesdk.minutes.service.recording.common.statistics.core.d r103 = new com.ss.android.lark.officesdk.minutes.service.recording.common.statistics.core.d();     // Catch: Exception -> L5
        r103.f(r102);     // Catch: Exception -> L5
        r103.f(r101.asRecordingDevTrackerParams().a());     // Catch: Exception -> L5
        r103.e("action_name", r100);     // Catch: Exception -> L5
        JSONObject r104 = r103.a();     // Catch: Exception -> L5
        int r105 = com.ss.android.lark.officesdk.minutes.service.recording.common.statistics.core.c.f435421n;     // Catch: Exception -> L5
        com.ss.android.lark.officesdk.minutes.service.recording.common.statistics.core.c.a.b(r104);     // Catch: Exception -> L5
        return;
    L5:
        e = move-exception;
        lvb.a.b("MmRecordingCoreMetrics", "[sendEvent] failed, actionName=" + r100 + ", error=" + e);
    }
}
