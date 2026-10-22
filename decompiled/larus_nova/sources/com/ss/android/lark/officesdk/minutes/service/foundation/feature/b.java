package com.ss.android.lark.officesdk.minutes.service.foundation.feature;

import com.ss.android.lark.officesdk.minutes.api.recording.common.data.MmRecordingSource;
import com.ss.android.lark.officesdk.minutes.api.recording.common.depend.feature.MmOfficeSdkFeature;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes37.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f433800a = 0;

    public /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f433801a = null;

        static {
            int[] r100 = new int[MmRecordingSource.values().length];
            r100[MmRecordingSource.DOUBAO_PERSONAL.ordinal()] = 1;     // Catch: NoSuchFieldError -> L8
        L11:
            r100[MmRecordingSource.DOUBAO_ENTERPRISE.ordinal()] = 2;     // Catch: NoSuchFieldError -> L9
        L15:
            r100[MmRecordingSource.FEISHU_DOUBAO.ordinal()] = 3;     // Catch: NoSuchFieldError -> L10
        L6:
            f433801a = r100;
        }
    }

    static {
    }

    public static boolean a(com.ss.android.lark.officesdk.minutes.service.foundation.feature.a r100) {
        Intrinsics.checkNotNullParameter(r100, "featureService");
        Intrinsics.checkNotNullParameter(r100, "featureService");
        if (r100.h(MmOfficeSdkFeature.RecordingNoAiNotes) == false) goto L5;
    L7:
        return false;
    L5:
        if (r100.h(MmOfficeSdkFeature.RecordingPersonalNotesEnable) == false) goto L7;
        return true;
    }

    public static boolean b(com.ss.android.lark.officesdk.minutes.service.foundation.feature.a r100) {
        Intrinsics.checkNotNullParameter(r100, "featureService");
        if (a(r100) == true) goto L5;
    L7:
        return false;
    L5:
        if (r100.h(MmOfficeSdkFeature.RecordingPersonalNotesMarkTranscript) == false) goto L7;
        return true;
    }
}
