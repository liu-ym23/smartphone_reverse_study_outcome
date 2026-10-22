package com.ss.android.lark.officesdk.minutes.api.hardware;

import com.byted.cast.common.bean.State;
import com.bytedance.android.livesdk.chatroom.event.UserProfileEvent;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes37.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\b\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\b¨\u0006\t"}, d2 = {"Lcom/ss/android/lark/officesdk/minutes/api/hardware/MmOfficeHardwareRecordingState;", "", "<init>", "(Ljava/lang/String;I)V", "STARTING", State.RECORDING, "PAUSED", "WAITING_RECOVERY", UserProfileEvent.POSITION_NONE, "officesdk-minutes-api_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum MmOfficeHardwareRecordingState extends Enum<MmOfficeHardwareRecordingState> {
    public static final MmOfficeHardwareRecordingState NONE = null;
    public static final MmOfficeHardwareRecordingState PAUSED = null;
    public static final MmOfficeHardwareRecordingState RECORDING = null;
    public static final MmOfficeHardwareRecordingState STARTING = null;
    public static final MmOfficeHardwareRecordingState WAITING_RECOVERY = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ MmOfficeHardwareRecordingState[] f433496a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f433497b = null;

    public static EnumEntries<MmOfficeHardwareRecordingState> getEntries() {
        return f433497b;
    }

    static {
        MmOfficeHardwareRecordingState r100 = new MmOfficeHardwareRecordingState("STARTING", 0);
        STARTING = r100;
        MmOfficeHardwareRecordingState r101 = new MmOfficeHardwareRecordingState(State.RECORDING, 1);
        RECORDING = r101;
        MmOfficeHardwareRecordingState r102 = new MmOfficeHardwareRecordingState("PAUSED", 2);
        PAUSED = r102;
        MmOfficeHardwareRecordingState r103 = new MmOfficeHardwareRecordingState("WAITING_RECOVERY", 3);
        WAITING_RECOVERY = r103;
        MmOfficeHardwareRecordingState r104 = new MmOfficeHardwareRecordingState(UserProfileEvent.POSITION_NONE, 4);
        NONE = r104;
        MmOfficeHardwareRecordingState[] r105 = {r100, r101, r102, r103, r104};
        f433496a = r105;
        f433497b = EnumEntriesKt.enumEntries(r105);
    }

    public static MmOfficeHardwareRecordingState[] values() {
        return (MmOfficeHardwareRecordingState[]) f433496a.clone();
    }

    public static MmOfficeHardwareRecordingState valueOf(String r100) {
        return (MmOfficeHardwareRecordingState) r27.a.a(MmOfficeHardwareRecordingState.class, r100);
    }

    public MmOfficeHardwareRecordingState(String r100, int r101) {
        super(r100, r101);
    }
}
