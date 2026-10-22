package com.ss.android.lark.officesdk.minutes.api.hardware;

import com.byted.cast.common.bean.State;
import com.larus.dora.api.model.FlowDoraWifiScene;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes37.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u000b\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000b¨\u0006\f"}, d2 = {"Lcom/ss/android/lark/officesdk/minutes/api/hardware/MmOfficeHardwareStateType;", "", "<init>", "(Ljava/lang/String;I)V", "IDLE", "CONNECTING", "BT_CONNECTING", "PARTIAL_CONNECTED", "CONNECTED", State.DISCONNECTED, "FAILED", FlowDoraWifiScene.OTHER, "officesdk-minutes-api_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum MmOfficeHardwareStateType extends Enum<MmOfficeHardwareStateType> {
    public static final MmOfficeHardwareStateType BT_CONNECTING = null;
    public static final MmOfficeHardwareStateType CONNECTED = null;
    public static final MmOfficeHardwareStateType CONNECTING = null;
    public static final MmOfficeHardwareStateType DISCONNECTED = null;
    public static final MmOfficeHardwareStateType FAILED = null;
    public static final MmOfficeHardwareStateType IDLE = null;
    public static final MmOfficeHardwareStateType OTHER = null;
    public static final MmOfficeHardwareStateType PARTIAL_CONNECTED = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ MmOfficeHardwareStateType[] f433498a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f433499b = null;

    public static EnumEntries<MmOfficeHardwareStateType> getEntries() {
        return f433499b;
    }

    static {
        MmOfficeHardwareStateType r100 = new MmOfficeHardwareStateType("IDLE", 0);
        IDLE = r100;
        MmOfficeHardwareStateType r101 = new MmOfficeHardwareStateType("CONNECTING", 1);
        CONNECTING = r101;
        MmOfficeHardwareStateType r102 = new MmOfficeHardwareStateType("BT_CONNECTING", 2);
        BT_CONNECTING = r102;
        MmOfficeHardwareStateType r103 = new MmOfficeHardwareStateType("PARTIAL_CONNECTED", 3);
        PARTIAL_CONNECTED = r103;
        MmOfficeHardwareStateType r104 = new MmOfficeHardwareStateType("CONNECTED", 4);
        CONNECTED = r104;
        MmOfficeHardwareStateType r105 = new MmOfficeHardwareStateType(State.DISCONNECTED, 5);
        DISCONNECTED = r105;
        MmOfficeHardwareStateType r110 = new MmOfficeHardwareStateType("FAILED", 6);
        FAILED = r110;
        MmOfficeHardwareStateType r111 = new MmOfficeHardwareStateType(FlowDoraWifiScene.OTHER, 7);
        OTHER = r111;
        MmOfficeHardwareStateType[] r112 = {r100, r101, r102, r103, r104, r105, r110, r111};
        f433498a = r112;
        f433499b = EnumEntriesKt.enumEntries(r112);
    }

    public static MmOfficeHardwareStateType[] values() {
        return (MmOfficeHardwareStateType[]) f433498a.clone();
    }

    public static MmOfficeHardwareStateType valueOf(String r100) {
        return (MmOfficeHardwareStateType) r27.a.a(MmOfficeHardwareStateType.class, r100);
    }

    public MmOfficeHardwareStateType(String r100, int r101) {
        super(r100, r101);
    }
}
