package com.ss.android.lark.officesdk.minutes.service.recording.common.repo.endwindow;

import com.ss.android.lark.officesdk.minutes.service.recording.common.repo.cta.MmAISummaryQuotaData;
import com.ss.android.lark.officesdk.minutes.service.recording.common.repo.cta.MmASRQuotaData;
import com.ss.android.lark.officesdk.minutes.service.recording.common.repo.cta.MmQuotaData;
import com.ss.android.lark.officesdk.minutes.service.recording.common.repo.cta.MmQuotaType;
import com.ss.android.lark.officesdk.minutes.service.recording.common.repo.cta.MmUnavailableReason;

/* JADX INFO: loaded from: classes37.dex */
public final class h {

    public /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f434963a = null;

        static {
            int[] r100 = new int[MmQuotaType.values().length];
            r100[MmQuotaType.AI_SUMMARY.ordinal()] = 1;     // Catch: NoSuchFieldError -> L7
        L9:
            r100[MmQuotaType.ASR.ordinal()] = 2;     // Catch: NoSuchFieldError -> L8
        L5:
            f434963a = r100;
        }
    }

    public static final MmEndWindowUnavailableReason a(com.ss.android.lark.officesdk.minutes.service.recording.common.repo.cta.h r100, MmQuotaData r101) {
        MmUnavailableReason r102 = null;
        if ((r100 instanceof com.ss.android.lark.officesdk.minutes.service.recording.common.repo.cta.h.d) == false) goto L6;
        MmQuotaType r103 = ((com.ss.android.lark.officesdk.minutes.service.recording.common.repo.cta.h.d) r100).f434927a;
    L9:
        if (r103 != null) goto L11;
        int r104 = -1;
    L13:
        if (r104 != 1) goto L15;
        MmAISummaryQuotaData r105 = r101.getAiQuota();
        if (r105 == null) goto L25;
        r102 = r105.getUnavailableReason();
    L25:
        return d.a(r102);
    L15:
        if (r104 != 2) goto L26;
        MmASRQuotaData r106 = r101.getAsrQuota();
        if (r106 == null) goto L27;
        r102 = r106.getUnavailableReason();
    L27:
        return d.a(r102);
    L26:
        return new MmEndWindowUnavailableReason(0, null, 3, null);
    L11:
        r104 = a.f434963a[r103.ordinal()];
        goto L13
    L6:
        if ((r100 instanceof com.ss.android.lark.officesdk.minutes.service.recording.common.repo.cta.h.c) == false) goto L8;
        r103 = ((com.ss.android.lark.officesdk.minutes.service.recording.common.repo.cta.h.c) r100).f434923a;
        goto L9
    L8:
        r103 = null;
        goto L9
    }
}
