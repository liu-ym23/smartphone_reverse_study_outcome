package com.ss.android.lark.officesdk.minutes.service.recording.hardware;

import com.larus.dora.api.model.FlowDoraWifiScene;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes37.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\b\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\b¨\u0006\t"}, d2 = {"Lcom/ss/android/lark/officesdk/minutes/service/recording/hardware/HardwarePlaybackState;", "", "<init>", "(Ljava/lang/String;I)V", "IDLE", "SYS_CALL", "APP_CALL", "MEDIA", FlowDoraWifiScene.OTHER, "officesdk-minutes-service_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum HardwarePlaybackState extends Enum<HardwarePlaybackState> {
    public static final HardwarePlaybackState APP_CALL = null;
    public static final HardwarePlaybackState IDLE = null;
    public static final HardwarePlaybackState MEDIA = null;
    public static final HardwarePlaybackState OTHER = null;
    public static final HardwarePlaybackState SYS_CALL = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ HardwarePlaybackState[] f435522a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f435523b = null;

    public static EnumEntries<HardwarePlaybackState> getEntries() {
        return f435523b;
    }

    static {
        HardwarePlaybackState r100 = new HardwarePlaybackState("IDLE", 0);
        IDLE = r100;
        HardwarePlaybackState r101 = new HardwarePlaybackState("SYS_CALL", 1);
        SYS_CALL = r101;
        HardwarePlaybackState r102 = new HardwarePlaybackState("APP_CALL", 2);
        APP_CALL = r102;
        HardwarePlaybackState r103 = new HardwarePlaybackState("MEDIA", 3);
        MEDIA = r103;
        HardwarePlaybackState r104 = new HardwarePlaybackState(FlowDoraWifiScene.OTHER, 4);
        OTHER = r104;
        HardwarePlaybackState[] r105 = {r100, r101, r102, r103, r104};
        f435522a = r105;
        f435523b = EnumEntriesKt.enumEntries(r105);
    }

    public static HardwarePlaybackState[] values() {
        return (HardwarePlaybackState[]) f435522a.clone();
    }

    public static HardwarePlaybackState valueOf(String r100) {
        return (HardwarePlaybackState) r27.a.a(HardwarePlaybackState.class, r100);
    }

    public HardwarePlaybackState(String r100, int r101) {
        super(r100, r101);
    }
}
