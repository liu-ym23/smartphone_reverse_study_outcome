package com.ss.android.lark.officesdk.minutes.service.recording.common.repo.summary;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes37.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0006\u0010\b\u001a\u00020\tj\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007¨\u0006\n"}, d2 = {"Lcom/ss/android/lark/officesdk/minutes/service/recording/common/repo/summary/MmSummaryStatus;", "", "<init>", "(Ljava/lang/String;I)V", "None", "EmptyContent", "HasContent", "MeetingAISummaryOpenError", "hasContent", "", "officesdk-minutes-service_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum MmSummaryStatus extends Enum<MmSummaryStatus> {
    public static final MmSummaryStatus EmptyContent = null;
    public static final MmSummaryStatus HasContent = null;
    public static final MmSummaryStatus MeetingAISummaryOpenError = null;
    public static final MmSummaryStatus None = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ MmSummaryStatus[] f435332a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f435333b = null;

    public static EnumEntries<MmSummaryStatus> getEntries() {
        return f435333b;
    }

    static {
        MmSummaryStatus r100 = new MmSummaryStatus("None", 0);
        None = r100;
        MmSummaryStatus r101 = new MmSummaryStatus("EmptyContent", 1);
        EmptyContent = r101;
        MmSummaryStatus r102 = new MmSummaryStatus("HasContent", 2);
        HasContent = r102;
        MmSummaryStatus r103 = new MmSummaryStatus("MeetingAISummaryOpenError", 3);
        MeetingAISummaryOpenError = r103;
        MmSummaryStatus[] r104 = {r100, r101, r102, r103};
        f435332a = r104;
        f435333b = EnumEntriesKt.enumEntries(r104);
    }

    public static MmSummaryStatus[] values() {
        return (MmSummaryStatus[]) f435332a.clone();
    }

    public final boolean hasContent() {
        if (this != HasContent) goto L5;
        return true;
    L5:
        return false;
    }

    public static MmSummaryStatus valueOf(String r100) {
        return (MmSummaryStatus) r27.a.a(MmSummaryStatus.class, r100);
    }

    public MmSummaryStatus(String r100, int r101) {
        super(r100, r101);
    }
}
