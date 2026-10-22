package com.larus.dora.impl.device.settings.lab.headdown;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes27.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0080\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/larus/dora/impl/device/settings/lab/headdown/HeadDownCalibrationFailureReason;", "", "<init>", "(Ljava/lang/String;I)V", "MOTION", "NOT_WEARING", "TIMEOUT", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum HeadDownCalibrationFailureReason extends Enum<HeadDownCalibrationFailureReason> {
    public static final HeadDownCalibrationFailureReason MOTION = null;
    public static final HeadDownCalibrationFailureReason NOT_WEARING = null;
    public static final HeadDownCalibrationFailureReason TIMEOUT = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ HeadDownCalibrationFailureReason[] f334757a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f334758b = null;

    public static EnumEntries<HeadDownCalibrationFailureReason> getEntries() {
        return f334758b;
    }

    static {
        HeadDownCalibrationFailureReason r100 = new HeadDownCalibrationFailureReason("MOTION", 0);
        MOTION = r100;
        HeadDownCalibrationFailureReason r101 = new HeadDownCalibrationFailureReason("NOT_WEARING", 1);
        NOT_WEARING = r101;
        HeadDownCalibrationFailureReason r102 = new HeadDownCalibrationFailureReason("TIMEOUT", 2);
        TIMEOUT = r102;
        HeadDownCalibrationFailureReason[] r103 = {r100, r101, r102};
        f334757a = r103;
        f334758b = EnumEntriesKt.enumEntries(r103);
    }

    public static HeadDownCalibrationFailureReason[] values() {
        return (HeadDownCalibrationFailureReason[]) f334757a.clone();
    }

    public static HeadDownCalibrationFailureReason valueOf(String r100) {
        return (HeadDownCalibrationFailureReason) r27.a.a(HeadDownCalibrationFailureReason.class, r100);
    }

    public HeadDownCalibrationFailureReason(String r100, int r101) {
        super(r100, r101);
    }
}
