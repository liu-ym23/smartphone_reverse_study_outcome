package com.ss.android.lark.officesdk.minutes.service.recording.common.statistics.core;

import com.ss.android.lark.officesdk.minutes.api.recording.doubao.DoubaoStatisticInfo;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes37.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ConcurrentHashMap<String, com.ss.android.lark.officesdk.minutes.service.recording.common.statistics.core.a> f435420a;

    public static final class a {
    }

    static {
    }

    public b() {
        this.f435420a = new ConcurrentHashMap();
    }

    public final void a(String r100) {
        com.ss.android.lark.officesdk.minutes.service.recording.common.statistics.core.a r101 = this.f435420a.get(r100);
        if (r101 != null) goto L6;
        return;
    L6:
        if (r101.f435418d == true) goto L8;
        return;
    L8:
        if (r101.f435419e == false) goto L12;
        this.f435420a.remove(r100);
        lvb.a.e("MmRecordingBusinessTrackContextStore", "[tryRemoveIfLifecycleFinished] remove context, sessionId=" + r100);
        return;
    }

    public final com.ss.android.lark.officesdk.minutes.service.recording.common.statistics.core.a getContext(String r100) {
        Intrinsics.checkNotNullParameter(r100, "sessionId");
        return this.f435420a.get(r100);
    }

    public final void b(String r110, Boolean r111, Boolean r112, String r113) {
        if (StringsKt.isBlank(r110) == false) goto L6;
        lvb.a.h("MmRecordingBusinessTrackContextStore", "[" + r113 + "] skip: sessionId is blank");
        return;
    L6:
        com.ss.android.lark.officesdk.minutes.service.recording.common.statistics.core.a r100 = this.f435420a.get(r110);
        if (r100 != null) goto L10;
        lvb.a.h("MmRecordingBusinessTrackContextStore", "[" + r113 + "] skip: context missing, sessionId=" + r110);
        return;
    L10:
        if (r111 == null) goto L12;
        boolean r114 = r111.booleanValue();
    L13:
        boolean r101 = r114;
        if (r112 == null) goto L16;
        boolean r115 = r112.booleanValue();
    L17:
        String r102 = r100.f435415a;
        MmRecordingCommonParam r103 = r100.f435416b;
        DoubaoStatisticInfo r104 = r100.f435417c;
        Intrinsics.checkNotNullParameter(r102, "sessionId");
        Intrinsics.checkNotNullParameter(r103, "commonParam");
        com.ss.android.lark.officesdk.minutes.service.recording.common.statistics.core.a r116 = new com.ss.android.lark.officesdk.minutes.service.recording.common.statistics.core.a(r102, r103, r104, r101, r115);
        this.f435420a.put(r110, r116);
        lvb.a.e("MmRecordingBusinessTrackContextStore", "[" + r113 + "] sessionId=" + r110 + ", sessionEnded=" + r116.f435418d + ", endWindowClosed=" + r116.f435419e);
        a(r110);
        return;
    L16:
        r115 = r100.f435419e;
        goto L17
    L12:
        r114 = r100.f435418d;
        goto L13
    }
}
