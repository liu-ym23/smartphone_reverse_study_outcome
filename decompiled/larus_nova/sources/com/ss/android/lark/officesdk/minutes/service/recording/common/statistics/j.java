package com.ss.android.lark.officesdk.minutes.service.recording.common.statistics;

import com.ss.android.lark.officesdk.minutes.service.recording.common.statistics.core.MmRecordingCommonParam;
import java.util.Iterator;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes37.dex */
public final class j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final com.ss.android.lark.officesdk.minutes.service.recording.common.statistics.core.c f435449a;

    public static final class a {
    }

    static {
    }

    public j(com.ss.android.lark.officesdk.minutes.service.recording.common.statistics.core.c r100) {
        Intrinsics.checkNotNullParameter(r100, "businessTracker");
        this.f435449a = r100;
    }

    public final void a(String r100, String r101, Map<String, ? extends Object> r102) {
        Intrinsics.checkNotNullParameter(r100, "sessionId");
        Intrinsics.checkNotNullParameter(r101, "click");
        MmRecordingCommonParam r103 = this.f435449a.b(r100);
        if (r103 == null) goto L7;
        boolean r104 = true;
        if (r103.isValid() != true) goto L7;
    L8:
        if (r104 == true) goto L11;
        lvb.a.b("MmRecordingPageTracker", "[trackClick] commonParam invalid, " + r101);
        return;
    L11:
        com.ss.android.lark.officesdk.minutes.service.recording.common.statistics.core.d r105 = new com.ss.android.lark.officesdk.minutes.service.recording.common.statistics.core.d();
        r105.e("click", r101);
        if (r102 == null) goto L17;
        Iterator<Map.Entry<String, ? extends Object>> r106 = r102.entrySet().iterator();
    L15:
        if (r106.hasNext() == false) goto L17;
        Map.Entry<String, ? extends Object> r107 = r106.next();
        r105.d(r107.getKey(), r107.getValue());
    L17:
        this.f435449a.g(r100, "vc_navigation_minutes_recording_click", r105.a());
        return;
    L7:
        r104 = false;
        goto L8
    }
}
