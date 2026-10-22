package com.ss.android.lark.officesdk.minutes.api.recording.common.data;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: classes37.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\b\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\b¨\u0006\t"}, d2 = {"Lcom/ss/android/lark/officesdk/minutes/api/recording/common/data/MmHardwareRecordingAudioRoute;", "", "<init>", "(Ljava/lang/String;I)V", "BLUETOOTH", "SPEAKER", "WIRED_HEADSET", "EARPIECE", "UNKNOWN", "officesdk-minutes-api_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum MmHardwareRecordingAudioRoute extends Enum<MmHardwareRecordingAudioRoute> {
    public static final MmHardwareRecordingAudioRoute BLUETOOTH = null;
    public static final MmHardwareRecordingAudioRoute EARPIECE = null;
    public static final MmHardwareRecordingAudioRoute SPEAKER = null;
    public static final MmHardwareRecordingAudioRoute UNKNOWN = null;
    public static final MmHardwareRecordingAudioRoute WIRED_HEADSET = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ MmHardwareRecordingAudioRoute[] f433516a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f433517b = null;

    public static EnumEntries<MmHardwareRecordingAudioRoute> getEntries() {
        return f433517b;
    }

    static {
        MmHardwareRecordingAudioRoute r100 = new MmHardwareRecordingAudioRoute("BLUETOOTH", 0);
        BLUETOOTH = r100;
        MmHardwareRecordingAudioRoute r101 = new MmHardwareRecordingAudioRoute("SPEAKER", 1);
        SPEAKER = r101;
        MmHardwareRecordingAudioRoute r102 = new MmHardwareRecordingAudioRoute("WIRED_HEADSET", 2);
        WIRED_HEADSET = r102;
        MmHardwareRecordingAudioRoute r103 = new MmHardwareRecordingAudioRoute("EARPIECE", 3);
        EARPIECE = r103;
        MmHardwareRecordingAudioRoute r104 = new MmHardwareRecordingAudioRoute("UNKNOWN", 4);
        UNKNOWN = r104;
        MmHardwareRecordingAudioRoute[] r105 = {r100, r101, r102, r103, r104};
        f433516a = r105;
        f433517b = EnumEntriesKt.enumEntries(r105);
    }

    public static MmHardwareRecordingAudioRoute[] values() {
        return (MmHardwareRecordingAudioRoute[]) f433516a.clone();
    }

    public static MmHardwareRecordingAudioRoute valueOf(String r100) {
        return (MmHardwareRecordingAudioRoute) a.a(MmHardwareRecordingAudioRoute.class, r100);
    }

    public MmHardwareRecordingAudioRoute(String r100, int r101) {
        super(r100, r101);
    }
}
