package com.ss.android.lark.officesdk.minutes.ui.record.recording.base.slot.model;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: classes37.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/ss/android/lark/officesdk/minutes/ui/record/recording/base/slot/model/MmRecordingNestedScrollMode;", "", "<init>", "(Ljava/lang/String;I)V", "Disabled", "Enabled", "officesdk-minutes-base-ui_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum MmRecordingNestedScrollMode extends Enum<MmRecordingNestedScrollMode> {
    public static final MmRecordingNestedScrollMode Disabled = null;
    public static final MmRecordingNestedScrollMode Enabled = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ MmRecordingNestedScrollMode[] f436281a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f436282b = null;

    public static EnumEntries<MmRecordingNestedScrollMode> getEntries() {
        return f436282b;
    }

    static {
        MmRecordingNestedScrollMode r100 = new MmRecordingNestedScrollMode("Disabled", 0);
        Disabled = r100;
        MmRecordingNestedScrollMode r101 = new MmRecordingNestedScrollMode("Enabled", 1);
        Enabled = r101;
        MmRecordingNestedScrollMode[] r102 = {r100, r101};
        f436281a = r102;
        f436282b = EnumEntriesKt.enumEntries(r102);
    }

    public static MmRecordingNestedScrollMode[] values() {
        return (MmRecordingNestedScrollMode[]) f436281a.clone();
    }

    public static MmRecordingNestedScrollMode valueOf(String r100) {
        return (MmRecordingNestedScrollMode) a.a(MmRecordingNestedScrollMode.class, r100);
    }

    public MmRecordingNestedScrollMode(String r100, int r101) {
        super(r100, r101);
    }
}
