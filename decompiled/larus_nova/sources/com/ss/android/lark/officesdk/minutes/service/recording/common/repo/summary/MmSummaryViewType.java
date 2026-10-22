package com.ss.android.lark.officesdk.minutes.service.recording.common.repo.summary;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes37.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0002\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0006\u0010\u0006\u001a\u00020\u0007J\u0006\u0010\b\u001a\u00020\u0007j\u0002\b\u0004j\u0002\b\u0005¨\u0006\t"}, d2 = {"Lcom/ss/android/lark/officesdk/minutes/service/recording/common/repo/summary/MmSummaryViewType;", "", "<init>", "(Ljava/lang/String;I)V", "Markdown", "FishBone", "isFishBone", "", "isMarkdown", "officesdk-minutes-service_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum MmSummaryViewType extends Enum<MmSummaryViewType> {
    public static final MmSummaryViewType FishBone = null;
    public static final MmSummaryViewType Markdown = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ MmSummaryViewType[] f435334a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f435335b = null;

    public static EnumEntries<MmSummaryViewType> getEntries() {
        return f435335b;
    }

    static {
        MmSummaryViewType r100 = new MmSummaryViewType("Markdown", 0);
        Markdown = r100;
        MmSummaryViewType r101 = new MmSummaryViewType("FishBone", 1);
        FishBone = r101;
        MmSummaryViewType[] r102 = {r100, r101};
        f435334a = r102;
        f435335b = EnumEntriesKt.enumEntries(r102);
    }

    public static MmSummaryViewType[] values() {
        return (MmSummaryViewType[]) f435334a.clone();
    }

    public final boolean isFishBone() {
        if (this != FishBone) goto L5;
        return true;
    L5:
        return false;
    }

    public final boolean isMarkdown() {
        if (this != Markdown) goto L5;
        return true;
    L5:
        return false;
    }

    public static MmSummaryViewType valueOf(String r100) {
        return (MmSummaryViewType) r27.a.a(MmSummaryViewType.class, r100);
    }

    public MmSummaryViewType(String r100, int r101) {
        super(r100, r101);
    }
}
