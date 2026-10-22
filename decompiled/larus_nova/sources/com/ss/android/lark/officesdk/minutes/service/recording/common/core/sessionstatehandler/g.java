package com.ss.android.lark.officesdk.minutes.service.recording.common.core.sessionstatehandler;

import com.ss.android.lark.officesdk.minutes.service.recording.common.core.data.RecordingSessionType;

/* JADX INFO: loaded from: classes37.dex */
public final class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f434595a = 0;

    public /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f434596a = null;

        static {
            int[] r100 = new int[RecordingSessionType.values().length];
            r100[RecordingSessionType.SOFTWARE_RECORDING.ordinal()] = 1;     // Catch: NoSuchFieldError -> L11
        L19:
            r100[RecordingSessionType.HISTORY_RECORDING.ordinal()] = 2;     // Catch: NoSuchFieldError -> L12
        L27:
            r100[RecordingSessionType.PRE_MEETING_NATIVE_RECORDING.ordinal()] = 3;     // Catch: NoSuchFieldError -> L13
        L21:
            r100[RecordingSessionType.STANDALONE_AI_INTERPRETATION.ordinal()] = 4;     // Catch: NoSuchFieldError -> L14
        L23:
            r100[RecordingSessionType.HARDWARE_RECORDING.ordinal()] = 5;     // Catch: NoSuchFieldError -> L15
        L17:
            r100[RecordingSessionType.HARDWARE_LIVE_RECORDING.ordinal()] = 6;     // Catch: NoSuchFieldError -> L16
        L9:
            f434596a = r100;
        }
    }

    static {
    }
}
