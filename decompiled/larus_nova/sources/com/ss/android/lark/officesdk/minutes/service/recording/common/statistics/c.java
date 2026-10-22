package com.ss.android.lark.officesdk.minutes.service.recording.common.statistics;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes37.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final com.ss.android.lark.officesdk.minutes.service.recording.common.statistics.core.c f435410a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f435411b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public String f435412c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public long f435413d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f435414e;

    public static final class a {
    }

    static {
    }

    public final void a() {
        Intrinsics.checkNotNullParameter("close", "click");
        if (this.f435410a.d(this.f435412c) == true) goto L6;
        lvb.a.b(this.f435411b, "[trackClick] commonParam invalid, sessionId=" + this.f435412c + ", click=close");
        return;
    L6:
        com.ss.android.lark.officesdk.minutes.service.recording.common.statistics.core.c r100 = this.f435410a;
        String r101 = this.f435412c;
        com.ss.android.lark.officesdk.minutes.service.recording.common.statistics.core.d r102 = new com.ss.android.lark.officesdk.minutes.service.recording.common.statistics.core.d();
        r102.e("click", "close");
        r102.e("source", "native");
        r100.g(r101, "vc_record_tail_window_click", r102.a());
    }

    public c(com.ss.android.lark.officesdk.minutes.service.recording.common.statistics.core.c r100) {
        Intrinsics.checkNotNullParameter(r100, "businessTracker");
        this.f435410a = r100;
        this.f435411b = "MmRecordingTracker_EndWindow";
        this.f435412c = "";
    }
}
