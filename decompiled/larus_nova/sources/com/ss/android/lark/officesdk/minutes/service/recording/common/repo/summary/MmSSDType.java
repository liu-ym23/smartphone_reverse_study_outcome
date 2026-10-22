package com.ss.android.lark.officesdk.minutes.service.recording.common.repo.summary;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes37.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\u000b\b\u0086\u0081\u0002\u0018\u0000 \r2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\rB\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\f¨\u0006\u000e"}, d2 = {"Lcom/ss/android/lark/officesdk/minutes/service/recording/common/repo/summary/MmSSDType;", "", "value", "", "<init>", "(Ljava/lang/String;II)V", "getValue", "()I", "UNKNOWN", "SSD_UNKNOWN", "SSD_USER", "SSD_ROOM", "SSD_SIP_USER", "Companion", "officesdk-minutes-service_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum MmSSDType extends Enum<MmSSDType> {
    public static final a Companion = null;
    public static final MmSSDType SSD_ROOM = null;
    public static final MmSSDType SSD_SIP_USER = null;
    public static final MmSSDType SSD_UNKNOWN = null;
    public static final MmSSDType SSD_USER = null;
    public static final MmSSDType UNKNOWN = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ MmSSDType[] f435330a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f435331b = null;
    private final int value;

    public static EnumEntries<MmSSDType> getEntries() {
        return f435331b;
    }

    /* JADX WARN: Type inference failed for: r0v2, types: [com.ss.android.lark.officesdk.minutes.service.recording.common.repo.summary.MmSSDType$a] */
    static {
        MmSSDType r100 = new MmSSDType("UNKNOWN", 0, 0);
        UNKNOWN = r100;
        MmSSDType r101 = new MmSSDType("SSD_UNKNOWN", 1, 0);
        SSD_UNKNOWN = r101;
        MmSSDType r102 = new MmSSDType("SSD_USER", 2, 1);
        SSD_USER = r102;
        MmSSDType r103 = new MmSSDType("SSD_ROOM", 3, 2);
        SSD_ROOM = r103;
        MmSSDType r104 = new MmSSDType("SSD_SIP_USER", 4, 3);
        SSD_SIP_USER = r104;
        MmSSDType[] r105 = {r100, r101, r102, r103, r104};
        f435330a = r105;
        f435331b = EnumEntriesKt.enumEntries(r105);
        Companion = new a();
    }

    public static MmSSDType[] values() {
        return (MmSSDType[]) f435330a.clone();
    }

    public final int getValue() {
        return this.value;
    }

    public static MmSSDType valueOf(String r100) {
        return (MmSSDType) r27.a.a(MmSSDType.class, r100);
    }

    public MmSSDType(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}
