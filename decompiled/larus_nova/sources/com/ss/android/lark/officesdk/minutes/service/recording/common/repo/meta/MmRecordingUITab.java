package com.ss.android.lark.officesdk.minutes.service.recording.common.repo.meta;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes37.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0002\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0006\u0010\u0006\u001a\u00020\u0007J\u0006\u0010\b\u001a\u00020\u0007j\u0002\b\u0004j\u0002\b\u0005¨\u0006\t"}, d2 = {"Lcom/ss/android/lark/officesdk/minutes/service/recording/common/repo/meta/MmRecordingUITab;", "", "<init>", "(Ljava/lang/String;I)V", "SUBTITLE", "SUMMARY", "isInSubtitle", "", "isInSummary", "officesdk-minutes-service_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum MmRecordingUITab extends Enum<MmRecordingUITab> {
    public static final MmRecordingUITab SUBTITLE = null;
    public static final MmRecordingUITab SUMMARY = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ MmRecordingUITab[] f435032a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f435033b = null;

    public static EnumEntries<MmRecordingUITab> getEntries() {
        return f435033b;
    }

    static {
        MmRecordingUITab r100 = new MmRecordingUITab("SUBTITLE", 0);
        SUBTITLE = r100;
        MmRecordingUITab r101 = new MmRecordingUITab("SUMMARY", 1);
        SUMMARY = r101;
        MmRecordingUITab[] r102 = {r100, r101};
        f435032a = r102;
        f435033b = EnumEntriesKt.enumEntries(r102);
    }

    public static MmRecordingUITab[] values() {
        return (MmRecordingUITab[]) f435032a.clone();
    }

    public final boolean isInSubtitle() {
        if (this != SUBTITLE) goto L5;
        return true;
    L5:
        return false;
    }

    public final boolean isInSummary() {
        if (this != SUMMARY) goto L5;
        return true;
    L5:
        return false;
    }

    public static MmRecordingUITab valueOf(String r100) {
        return (MmRecordingUITab) r27.a.a(MmRecordingUITab.class, r100);
    }

    public MmRecordingUITab(String r100, int r101) {
        super(r100, r101);
    }
}
