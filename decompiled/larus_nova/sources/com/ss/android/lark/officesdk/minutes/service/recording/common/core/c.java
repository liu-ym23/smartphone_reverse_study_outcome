package com.ss.android.lark.officesdk.minutes.service.recording.common.core;

import com.ss.android.lark.officesdk.minutes.api.recording.common.data.MmRecordingSource;
import com.ss.android.lark.officesdk.minutes.service.recording.common.core.data.RecordingSessionType;
import com.ss.android.lark.pb.minutes.v1.MinutesRecordingStartRequest;

/* JADX INFO: loaded from: classes37.dex */
public final class c {

    public /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f434182a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ int[] f434183b = null;

        static {
            int[] r100 = new int[RecordingSessionType.values().length];
            r100[RecordingSessionType.HISTORY_RECORDING.ordinal()] = 1;     // Catch: NoSuchFieldError -> L13
        L19:
            r100[RecordingSessionType.STANDALONE_AI_INTERPRETATION.ordinal()] = 2;     // Catch: NoSuchFieldError -> L14
        L6:
            f434182a = r100;
            int[] r101 = new int[MmRecordingSource.values().length];
            r101[MmRecordingSource.FEISHU_DOUBAO.ordinal()] = 1;     // Catch: NoSuchFieldError -> L15
        L29:
            r101[MmRecordingSource.DOUBAO_GLASSES.ordinal()] = 2;     // Catch: NoSuchFieldError -> L16
        L23:
            r101[MmRecordingSource.DOUBAO_EARBUDS.ordinal()] = 3;     // Catch: NoSuchFieldError -> L17
        L25:
            r101[MmRecordingSource.DOUBAO_STANDALONE_AI_INTERPRETATION.ordinal()] = 4;     // Catch: NoSuchFieldError -> L18
        L11:
            f434183b = r101;
        }
    }

    public static final MinutesRecordingStartRequest.ExtraType a(MmRecordingSource r100) {
        if (r100 != null) goto L4;
        int r101 = -1;
    L6:
        if (r101 == 1) goto L18;
        if (r101 == 2) goto L22;
        if (r101 == 3) goto L21;
        if (r101 == 4) goto L20;
        return MinutesRecordingStartRequest.ExtraType.UNKNOWN;
    L20:
        return MinutesRecordingStartRequest.ExtraType.UNKNOWN;
    L21:
        return MinutesRecordingStartRequest.ExtraType.DOUBAO_EARBUDS;
    L22:
        return MinutesRecordingStartRequest.ExtraType.DOUBAO_GLASSES;
    L18:
        return MinutesRecordingStartRequest.ExtraType.DOUBAO_IN_LARK;
    L4:
        r101 = a.f434183b[r100.ordinal()];
        goto L6
    }
}
