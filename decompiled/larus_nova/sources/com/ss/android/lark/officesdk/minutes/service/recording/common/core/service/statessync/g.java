package com.ss.android.lark.officesdk.minutes.service.recording.common.core.service.statessync;

import com.larksuite.framework.utils.s;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes37.dex */
public final class g {
    static {
    }

    public static String a(String r100, String r101, e r102) {
        Intrinsics.checkNotNullParameter(r100, "userId");
        Intrinsics.checkNotNullParameter(r101, "meetingId");
        Intrinsics.checkNotNullParameter(r102, "localStorage");
        String r103 = r102.s(r101);
        if ((!StringsKt.isBlank(r103)) == false) goto L5;
        return r103;
    L5:
        String r104 = r102.t(r101);
        String r105 = r102.s(r104);
        if (StringsKt.isBlank(r105) == false) goto L8;
        Intrinsics.checkNotNullParameter(r100, "userId");
        Intrinsics.checkNotNullParameter(r101, "meetingId");
        Intrinsics.checkNotNullParameter(r104, "sourceSessionKey");
        r105 = StringsKt.take(s.c("minutes_recording_history_trace:" + r100 + ':' + r101 + ':' + r104), 16);
    L8:
        r102.D(r101, r105);
        return r105;
    }
}
