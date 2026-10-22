package com.ss.android.lark.officesdk.minutes.service.recording.common.repo.cta;

import com.ss.android.lark.officesdk.minutes.api.recording.common.data.MmRecordingSource;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes37.dex */
public final class f {
    public static final boolean a(h r100) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        if ((r100 instanceof h.d) == false) goto L5;
    L8:
        return true;
    L5:
        if ((r100 instanceof h.c) == true) goto L8;
        return false;
    }

    public static final boolean b(c r100) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        h r101 = r100.f434914a;
        h.a r102 = h.a.f434921a;
        if (Intrinsics.areEqual(r101, r102) == false) goto L5;
    L7:
        return false;
    L5:
        if (Intrinsics.areEqual(r100.f434915b, r102) == true) goto L7;
        return true;
    }

    public static final boolean c(MmRecordingSource r100) {
        if (r100 != MmRecordingSource.FEISHU) goto L5;
    L10:
        return true;
    L5:
        if (r100 == MmRecordingSource.FEISHU_HARDWARE_D1204) goto L10;
        if (r100 == MmRecordingSource.FEISHU_HARDWARE_RECORDER) goto L10;
        return false;
    }
}
