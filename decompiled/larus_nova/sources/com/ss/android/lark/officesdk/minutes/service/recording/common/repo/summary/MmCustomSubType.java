package com.ss.android.lark.officesdk.minutes.service.recording.common.repo.summary;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes37.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\u000b\b\u0086\u0081\u0002\u0018\u0000 \r2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\rB\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\f¨\u0006\u000e"}, d2 = {"Lcom/ss/android/lark/officesdk/minutes/service/recording/common/repo/summary/MmCustomSubType;", "", "value", "", "<init>", "(Ljava/lang/String;II)V", "getValue", "()I", "UNKNOWN", "MY_TODO", "KEYPOINT", "SPEAKER_SUMMARY", "GOLDEN_SENTENCES", "Companion", "officesdk-minutes-service_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum MmCustomSubType extends Enum<MmCustomSubType> {
    public static final a Companion = null;
    public static final MmCustomSubType GOLDEN_SENTENCES = null;
    public static final MmCustomSubType KEYPOINT = null;
    public static final MmCustomSubType MY_TODO = null;
    public static final MmCustomSubType SPEAKER_SUMMARY = null;
    public static final MmCustomSubType UNKNOWN = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ MmCustomSubType[] f435308a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f435309b = null;
    private final int value;

    public static EnumEntries<MmCustomSubType> getEntries() {
        return f435309b;
    }

    /* JADX WARN: Type inference failed for: r0v2, types: [com.ss.android.lark.officesdk.minutes.service.recording.common.repo.summary.MmCustomSubType$a] */
    static {
        MmCustomSubType r100 = new MmCustomSubType("UNKNOWN", 0, 0);
        UNKNOWN = r100;
        MmCustomSubType r101 = new MmCustomSubType("MY_TODO", 1, 1);
        MY_TODO = r101;
        MmCustomSubType r102 = new MmCustomSubType("KEYPOINT", 2, 2);
        KEYPOINT = r102;
        MmCustomSubType r103 = new MmCustomSubType("SPEAKER_SUMMARY", 3, 3);
        SPEAKER_SUMMARY = r103;
        MmCustomSubType r104 = new MmCustomSubType("GOLDEN_SENTENCES", 4, 4);
        GOLDEN_SENTENCES = r104;
        MmCustomSubType[] r105 = {r100, r101, r102, r103, r104};
        f435308a = r105;
        f435309b = EnumEntriesKt.enumEntries(r105);
        Companion = new a();
    }

    public static MmCustomSubType[] values() {
        return (MmCustomSubType[]) f435308a.clone();
    }

    public final int getValue() {
        return this.value;
    }

    public static MmCustomSubType valueOf(String r100) {
        return (MmCustomSubType) r27.a.a(MmCustomSubType.class, r100);
    }

    public MmCustomSubType(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}
