package com.ss.android.lark.officesdk.minutes.service.recording.common.repo.cta;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes37.dex */
public final class b {
    public static final MmRecordingQuotaCtaRenderType a(MmUnavailableReason r100) {
        boolean r101 = false;
        if (r100 == null) goto L10;
        Integer r102 = r100.getReasonCode();
        if (r102 == null) goto L10;
        if (r102.intValue() != 2) goto L10;
        r101 = true;
    L10:
        if (r101 == false) goto L12;
        String r103 = r100.getWindowLimitType();
        if (Intrinsics.areEqual(r103, "5h") == false) goto L17;
        return MmRecordingQuotaCtaRenderType.WindowLimited5H;
    L17:
        if (Intrinsics.areEqual(r103, "7d") == false) goto L20;
        return MmRecordingQuotaCtaRenderType.WindowLimited7D;
    L20:
        return MmRecordingQuotaCtaRenderType.Default;
    L12:
        return MmRecordingQuotaCtaRenderType.Default;
    }
}
