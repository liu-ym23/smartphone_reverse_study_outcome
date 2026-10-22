package com.ss.android.lark.officesdk.minutes.service.foundation.hardware;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: classes37.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/ss/android/lark/officesdk/minutes/service/foundation/hardware/MmHardwareExternalAudioDeviceType;", "", "<init>", "(Ljava/lang/String;I)V", "D3200", "D1204", "officesdk-minutes-service_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum MmHardwareExternalAudioDeviceType extends Enum<MmHardwareExternalAudioDeviceType> {
    public static final MmHardwareExternalAudioDeviceType D1204 = null;
    public static final MmHardwareExternalAudioDeviceType D3200 = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ MmHardwareExternalAudioDeviceType[] f433802a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f433803b = null;

    public static EnumEntries<MmHardwareExternalAudioDeviceType> getEntries() {
        return f433803b;
    }

    static {
        MmHardwareExternalAudioDeviceType r100 = new MmHardwareExternalAudioDeviceType("D3200", 0);
        D3200 = r100;
        MmHardwareExternalAudioDeviceType r101 = new MmHardwareExternalAudioDeviceType("D1204", 1);
        D1204 = r101;
        MmHardwareExternalAudioDeviceType[] r102 = {r100, r101};
        f433802a = r102;
        f433803b = EnumEntriesKt.enumEntries(r102);
    }

    public static MmHardwareExternalAudioDeviceType[] values() {
        return (MmHardwareExternalAudioDeviceType[]) f433802a.clone();
    }

    public static MmHardwareExternalAudioDeviceType valueOf(String r100) {
        return (MmHardwareExternalAudioDeviceType) a.a(MmHardwareExternalAudioDeviceType.class, r100);
    }

    public MmHardwareExternalAudioDeviceType(String r100, int r101) {
        super(r100, r101);
    }
}
