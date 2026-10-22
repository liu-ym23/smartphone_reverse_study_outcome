package com.ss.android.lark.officesdk.minutes.api.hardware.legacy;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: classes37.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/ss/android/lark/officesdk/minutes/api/hardware/legacy/MmLegacyHardwareRuntimePhase;", "", "<init>", "(Ljava/lang/String;I)V", "UNKNOWN", "SYNCING", "officesdk-minutes-api_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum MmLegacyHardwareRuntimePhase extends Enum<MmLegacyHardwareRuntimePhase> {
    public static final MmLegacyHardwareRuntimePhase SYNCING = null;
    public static final MmLegacyHardwareRuntimePhase UNKNOWN = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ MmLegacyHardwareRuntimePhase[] f433504a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f433505b = null;

    public static EnumEntries<MmLegacyHardwareRuntimePhase> getEntries() {
        return f433505b;
    }

    static {
        MmLegacyHardwareRuntimePhase r100 = new MmLegacyHardwareRuntimePhase("UNKNOWN", 0);
        UNKNOWN = r100;
        MmLegacyHardwareRuntimePhase r101 = new MmLegacyHardwareRuntimePhase("SYNCING", 1);
        SYNCING = r101;
        MmLegacyHardwareRuntimePhase[] r102 = {r100, r101};
        f433504a = r102;
        f433505b = EnumEntriesKt.enumEntries(r102);
    }

    public static MmLegacyHardwareRuntimePhase[] values() {
        return (MmLegacyHardwareRuntimePhase[]) f433504a.clone();
    }

    public static MmLegacyHardwareRuntimePhase valueOf(String r100) {
        return (MmLegacyHardwareRuntimePhase) a.a(MmLegacyHardwareRuntimePhase.class, r100);
    }

    public MmLegacyHardwareRuntimePhase(String r100, int r101) {
        super(r100, r101);
    }
}
