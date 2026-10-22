package com.ss.android.lark.officesdk.minutes.ui.record.recording.base.slot.model;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: classes37.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/ss/android/lark/officesdk/minutes/ui/record/recording/base/slot/model/MmRecordingTopSlotMode;", "", "<init>", "(Ljava/lang/String;I)V", "OCCUPY", "OVERLAY", "officesdk-minutes-base-ui_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum MmRecordingTopSlotMode extends Enum<MmRecordingTopSlotMode> {
    public static final MmRecordingTopSlotMode OCCUPY = null;
    public static final MmRecordingTopSlotMode OVERLAY = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ MmRecordingTopSlotMode[] f436285a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f436286b = null;

    public static EnumEntries<MmRecordingTopSlotMode> getEntries() {
        return f436286b;
    }

    static {
        MmRecordingTopSlotMode r100 = new MmRecordingTopSlotMode("OCCUPY", 0);
        OCCUPY = r100;
        MmRecordingTopSlotMode r101 = new MmRecordingTopSlotMode("OVERLAY", 1);
        OVERLAY = r101;
        MmRecordingTopSlotMode[] r102 = {r100, r101};
        f436285a = r102;
        f436286b = EnumEntriesKt.enumEntries(r102);
    }

    public static MmRecordingTopSlotMode[] values() {
        return (MmRecordingTopSlotMode[]) f436285a.clone();
    }

    public static MmRecordingTopSlotMode valueOf(String r100) {
        return (MmRecordingTopSlotMode) a.a(MmRecordingTopSlotMode.class, r100);
    }

    public MmRecordingTopSlotMode(String r100, int r101) {
        super(r100, r101);
    }
}
