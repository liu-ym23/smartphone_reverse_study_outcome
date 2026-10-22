package com.ss.android.lark.officesdk.minutes.service.recording.common.repo.cta;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes37.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\b\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\n¨\u0006\u000b"}, d2 = {"Lcom/ss/android/lark/officesdk/minutes/service/recording/common/repo/cta/MmQuotaType;", "", "value", "", "<init>", "(Ljava/lang/String;II)V", "getValue", "()I", "ASR", "AI_SUMMARY", "MempopeDeviceBonus", "officesdk-minutes-service_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum MmQuotaType extends Enum<MmQuotaType> {
    public static final MmQuotaType AI_SUMMARY = null;
    public static final MmQuotaType ASR = null;
    public static final MmQuotaType MempopeDeviceBonus = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ MmQuotaType[] f434899a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f434900b = null;
    private final int value;

    public static EnumEntries<MmQuotaType> getEntries() {
        return f434900b;
    }

    static {
        MmQuotaType r100 = new MmQuotaType("ASR", 0, 1);
        ASR = r100;
        MmQuotaType r101 = new MmQuotaType("AI_SUMMARY", 1, 2);
        AI_SUMMARY = r101;
        MmQuotaType r102 = new MmQuotaType("MempopeDeviceBonus", 2, 5);
        MempopeDeviceBonus = r102;
        MmQuotaType[] r103 = {r100, r101, r102};
        f434899a = r103;
        f434900b = EnumEntriesKt.enumEntries(r103);
    }

    public static MmQuotaType[] values() {
        return (MmQuotaType[]) f434899a.clone();
    }

    public final int getValue() {
        return this.value;
    }

    public static MmQuotaType valueOf(String r100) {
        return (MmQuotaType) r27.a.a(MmQuotaType.class, r100);
    }

    public MmQuotaType(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}
