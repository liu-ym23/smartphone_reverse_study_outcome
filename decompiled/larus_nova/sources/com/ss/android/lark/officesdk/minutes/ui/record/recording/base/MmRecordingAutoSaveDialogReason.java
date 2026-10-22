package com.ss.android.lark.officesdk.minutes.ui.record.recording.base;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes37.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/ss/android/lark/officesdk/minutes/ui/record/recording/base/MmRecordingAutoSaveDialogReason;", "", "<init>", "(Ljava/lang/String;I)V", "NoQuota", "WindowLimited5H", "WindowLimited7D", "officesdk-minutes-base-ui_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum MmRecordingAutoSaveDialogReason extends Enum<MmRecordingAutoSaveDialogReason> {
    public static final MmRecordingAutoSaveDialogReason NoQuota = null;
    public static final MmRecordingAutoSaveDialogReason WindowLimited5H = null;
    public static final MmRecordingAutoSaveDialogReason WindowLimited7D = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ MmRecordingAutoSaveDialogReason[] f436145a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f436146b = null;

    public static EnumEntries<MmRecordingAutoSaveDialogReason> getEntries() {
        return f436146b;
    }

    static {
        MmRecordingAutoSaveDialogReason r100 = new MmRecordingAutoSaveDialogReason("NoQuota", 0);
        NoQuota = r100;
        MmRecordingAutoSaveDialogReason r101 = new MmRecordingAutoSaveDialogReason("WindowLimited5H", 1);
        WindowLimited5H = r101;
        MmRecordingAutoSaveDialogReason r102 = new MmRecordingAutoSaveDialogReason("WindowLimited7D", 2);
        WindowLimited7D = r102;
        MmRecordingAutoSaveDialogReason[] r103 = {r100, r101, r102};
        f436145a = r103;
        f436146b = EnumEntriesKt.enumEntries(r103);
    }

    public static MmRecordingAutoSaveDialogReason[] values() {
        return (MmRecordingAutoSaveDialogReason[]) f436145a.clone();
    }

    public static MmRecordingAutoSaveDialogReason valueOf(String r100) {
        return (MmRecordingAutoSaveDialogReason) r27.a.a(MmRecordingAutoSaveDialogReason.class, r100);
    }

    public MmRecordingAutoSaveDialogReason(String r100, int r101) {
        super(r100, r101);
    }
}
