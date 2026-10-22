package com.ss.android.lark.officesdk.minutes.service.recording.common.repo.summary;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes37.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\t\b\u0086\u0081\u0002\u0018\u0000 \u000b2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u000bB\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\n¨\u0006\f"}, d2 = {"Lcom/ss/android/lark/officesdk/minutes/service/recording/common/repo/summary/MmFishBoneItemType;", "", "value", "", "<init>", "(Ljava/lang/String;II)V", "getValue", "()I", "TYPE_UNKNOWN", "TYPE_TEXT", "TYPE_IMAGE", "Companion", "officesdk-minutes-service_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum MmFishBoneItemType extends Enum<MmFishBoneItemType> {
    public static final a Companion = null;
    public static final MmFishBoneItemType TYPE_IMAGE = null;
    public static final MmFishBoneItemType TYPE_TEXT = null;
    public static final MmFishBoneItemType TYPE_UNKNOWN = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ MmFishBoneItemType[] f435310a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f435311b = null;
    private final int value;

    public static EnumEntries<MmFishBoneItemType> getEntries() {
        return f435311b;
    }

    /* JADX WARN: Type inference failed for: r0v2, types: [com.ss.android.lark.officesdk.minutes.service.recording.common.repo.summary.MmFishBoneItemType$a] */
    static {
        MmFishBoneItemType r100 = new MmFishBoneItemType("TYPE_UNKNOWN", 0, 0);
        TYPE_UNKNOWN = r100;
        MmFishBoneItemType r101 = new MmFishBoneItemType("TYPE_TEXT", 1, 1);
        TYPE_TEXT = r101;
        MmFishBoneItemType r102 = new MmFishBoneItemType("TYPE_IMAGE", 2, 2);
        TYPE_IMAGE = r102;
        MmFishBoneItemType[] r103 = {r100, r101, r102};
        f435310a = r103;
        f435311b = EnumEntriesKt.enumEntries(r103);
        Companion = new a();
    }

    public static MmFishBoneItemType[] values() {
        return (MmFishBoneItemType[]) f435310a.clone();
    }

    public final int getValue() {
        return this.value;
    }

    public static MmFishBoneItemType valueOf(String r100) {
        return (MmFishBoneItemType) r27.a.a(MmFishBoneItemType.class, r100);
    }

    public MmFishBoneItemType(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}
