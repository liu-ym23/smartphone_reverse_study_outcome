package com.ss.android.lark.officesdk.minutes.service.recording.common.repo.location;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes37.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/ss/android/lark/officesdk/minutes/service/recording/common/repo/location/MmLocationIdentityType;", "", "<init>", "(Ljava/lang/String;I)V", "RECORDING_ID", "MINUTES_TOKEN", "officesdk-minutes-service_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum MmLocationIdentityType extends Enum<MmLocationIdentityType> {
    public static final MmLocationIdentityType MINUTES_TOKEN = null;
    public static final MmLocationIdentityType RECORDING_ID = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ MmLocationIdentityType[] f434978a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f434979b = null;

    public static EnumEntries<MmLocationIdentityType> getEntries() {
        return f434979b;
    }

    static {
        MmLocationIdentityType r100 = new MmLocationIdentityType("RECORDING_ID", 0);
        RECORDING_ID = r100;
        MmLocationIdentityType r101 = new MmLocationIdentityType("MINUTES_TOKEN", 1);
        MINUTES_TOKEN = r101;
        MmLocationIdentityType[] r102 = {r100, r101};
        f434978a = r102;
        f434979b = EnumEntriesKt.enumEntries(r102);
    }

    public static MmLocationIdentityType[] values() {
        return (MmLocationIdentityType[]) f434978a.clone();
    }

    public static MmLocationIdentityType valueOf(String r100) {
        return (MmLocationIdentityType) r27.a.a(MmLocationIdentityType.class, r100);
    }

    public MmLocationIdentityType(String r100, int r101) {
        super(r100, r101);
    }
}
