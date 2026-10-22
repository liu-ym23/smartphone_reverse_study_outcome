package com.ss.android.lark.officesdk.minutes.ui.record.recording.base;

import com.ss.android.lark.officesdk.minutes.service.recording.common.repo.meta.MmRecordingUITab;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes37.dex */
public final class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f436202a = 0;

    public /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f436203a = null;

        static {
            int[] r100 = new int[MmRecordingUITab.values().length];
            r100[MmRecordingUITab.SUBTITLE.ordinal()] = 1;     // Catch: NoSuchFieldError -> L7
        L9:
            r100[MmRecordingUITab.SUMMARY.ordinal()] = 2;     // Catch: NoSuchFieldError -> L8
        L5:
            f436203a = r100;
        }
    }

    static {
    }

    public static boolean a(MmRecordingUITab r100, MmRecordingUITab r101, com.ss.android.lark.officesdk.minutes.service.recording.common.repo.cta.h r102) {
        Intrinsics.checkNotNullParameter(r100, "fragmentTab");
        Intrinsics.checkNotNullParameter(r101, "currentTab");
        Intrinsics.checkNotNullParameter(r102, "state");
        if (r100 == r101) goto L5;
    L9:
        return false;
    L5:
        if (Intrinsics.areEqual(r102, com.ss.android.lark.officesdk.minutes.service.recording.common.repo.cta.h.a.f434921a) == true) goto L9;
        if (Intrinsics.areEqual(r102, com.ss.android.lark.officesdk.minutes.service.recording.common.repo.cta.h.b.f434922a) == true) goto L9;
        return true;
    }
}
