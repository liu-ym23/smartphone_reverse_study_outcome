package com.ss.android.lark.officesdk.minutes.service.recording.common.repo.location;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes37.dex */
public final class c {
    public static final b a(boolean r100, String r101, String r102, String r103, String r104) {
        Intrinsics.checkNotNullParameter(r101, "recordingId");
        Intrinsics.checkNotNullParameter(r102, "minutesToken");
        Intrinsics.checkNotNullParameter(r103, "readyRecordingId");
        Intrinsics.checkNotNullParameter(r104, "readyMinutesToken");
        if (r100 == false) goto L6;
        return new b(r103, MmLocationIdentityType.RECORDING_ID);
    L6:
        if (r102.length() != 0) goto L8;
        boolean r105 = true;
    L9:
        if (r105 == false) goto L12;
        r102 = r104;
    L12:
        return new b(r102, MmLocationIdentityType.MINUTES_TOKEN);
    L8:
        r105 = false;
        goto L9
    }
}
