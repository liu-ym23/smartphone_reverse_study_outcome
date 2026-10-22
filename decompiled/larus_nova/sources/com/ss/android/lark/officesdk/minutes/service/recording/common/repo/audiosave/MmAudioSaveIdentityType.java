package com.ss.android.lark.officesdk.minutes.service.recording.common.repo.audiosave;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes37.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/ss/android/lark/officesdk/minutes/service/recording/common/repo/audiosave/MmAudioSaveIdentityType;", "", "<init>", "(Ljava/lang/String;I)V", "RECORDING_ID", "MINUTES_TOKEN", "officesdk-minutes-service_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum MmAudioSaveIdentityType extends Enum<MmAudioSaveIdentityType> {
    public static final MmAudioSaveIdentityType MINUTES_TOKEN = null;
    public static final MmAudioSaveIdentityType RECORDING_ID = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ MmAudioSaveIdentityType[] f434868a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f434869b = null;

    public static EnumEntries<MmAudioSaveIdentityType> getEntries() {
        return f434869b;
    }

    static {
        MmAudioSaveIdentityType r100 = new MmAudioSaveIdentityType("RECORDING_ID", 0);
        RECORDING_ID = r100;
        MmAudioSaveIdentityType r101 = new MmAudioSaveIdentityType("MINUTES_TOKEN", 1);
        MINUTES_TOKEN = r101;
        MmAudioSaveIdentityType[] r102 = {r100, r101};
        f434868a = r102;
        f434869b = EnumEntriesKt.enumEntries(r102);
    }

    public static MmAudioSaveIdentityType[] values() {
        return (MmAudioSaveIdentityType[]) f434868a.clone();
    }

    public static MmAudioSaveIdentityType valueOf(String r100) {
        return (MmAudioSaveIdentityType) r27.a.a(MmAudioSaveIdentityType.class, r100);
    }

    public MmAudioSaveIdentityType(String r100, int r101) {
        super(r100, r101);
    }
}
