package com.ss.android.lark.officesdk.minutes.service.recording.hardware;

import com.byted.cast.common.bean.State;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes37.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\b\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\b¨\u0006\t"}, d2 = {"Lcom/ss/android/lark/officesdk/minutes/service/recording/hardware/HardwareRecordingSessionState;", "", "<init>", "(Ljava/lang/String;I)V", "STARTING", State.RECORDING, "PAUSED", "WAITING_CALL_RECOVERY", "WAITING_INPUT_RECOVERY", "officesdk-minutes-service_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum HardwareRecordingSessionState extends Enum<HardwareRecordingSessionState> {
    public static final HardwareRecordingSessionState PAUSED = null;
    public static final HardwareRecordingSessionState RECORDING = null;
    public static final HardwareRecordingSessionState STARTING = null;
    public static final HardwareRecordingSessionState WAITING_CALL_RECOVERY = null;
    public static final HardwareRecordingSessionState WAITING_INPUT_RECOVERY = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ HardwareRecordingSessionState[] f435530a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f435531b = null;

    public static EnumEntries<HardwareRecordingSessionState> getEntries() {
        return f435531b;
    }

    static {
        HardwareRecordingSessionState r100 = new HardwareRecordingSessionState("STARTING", 0);
        STARTING = r100;
        HardwareRecordingSessionState r101 = new HardwareRecordingSessionState(State.RECORDING, 1);
        RECORDING = r101;
        HardwareRecordingSessionState r102 = new HardwareRecordingSessionState("PAUSED", 2);
        PAUSED = r102;
        HardwareRecordingSessionState r103 = new HardwareRecordingSessionState("WAITING_CALL_RECOVERY", 3);
        WAITING_CALL_RECOVERY = r103;
        HardwareRecordingSessionState r104 = new HardwareRecordingSessionState("WAITING_INPUT_RECOVERY", 4);
        WAITING_INPUT_RECOVERY = r104;
        HardwareRecordingSessionState[] r105 = {r100, r101, r102, r103, r104};
        f435530a = r105;
        f435531b = EnumEntriesKt.enumEntries(r105);
    }

    public static HardwareRecordingSessionState[] values() {
        return (HardwareRecordingSessionState[]) f435530a.clone();
    }

    public static HardwareRecordingSessionState valueOf(String r100) {
        return (HardwareRecordingSessionState) r27.a.a(HardwareRecordingSessionState.class, r100);
    }

    public HardwareRecordingSessionState(String r100, int r101) {
        super(r100, r101);
    }
}
