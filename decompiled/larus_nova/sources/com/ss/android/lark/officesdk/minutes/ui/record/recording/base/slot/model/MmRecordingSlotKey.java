package com.ss.android.lark.officesdk.minutes.ui.record.recording.base.slot.model;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: classes37.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0007\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007¨\u0006\b"}, d2 = {"Lcom/ss/android/lark/officesdk/minutes/ui/record/recording/base/slot/model/MmRecordingSlotKey;", "", "<init>", "(Ljava/lang/String;I)V", "TOP", "TITLE", "MIDDLE", "TOOLBAR", "officesdk-minutes-base-ui_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum MmRecordingSlotKey extends Enum<MmRecordingSlotKey> {
    public static final MmRecordingSlotKey MIDDLE = null;
    public static final MmRecordingSlotKey TITLE = null;
    public static final MmRecordingSlotKey TOOLBAR = null;
    public static final MmRecordingSlotKey TOP = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ MmRecordingSlotKey[] f436283a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f436284b = null;

    public static EnumEntries<MmRecordingSlotKey> getEntries() {
        return f436284b;
    }

    static {
        MmRecordingSlotKey r100 = new MmRecordingSlotKey("TOP", 0);
        TOP = r100;
        MmRecordingSlotKey r101 = new MmRecordingSlotKey("TITLE", 1);
        TITLE = r101;
        MmRecordingSlotKey r102 = new MmRecordingSlotKey("MIDDLE", 2);
        MIDDLE = r102;
        MmRecordingSlotKey r103 = new MmRecordingSlotKey("TOOLBAR", 3);
        TOOLBAR = r103;
        MmRecordingSlotKey[] r104 = {r100, r101, r102, r103};
        f436283a = r104;
        f436284b = EnumEntriesKt.enumEntries(r104);
    }

    public static MmRecordingSlotKey[] values() {
        return (MmRecordingSlotKey[]) f436283a.clone();
    }

    public static MmRecordingSlotKey valueOf(String r100) {
        return (MmRecordingSlotKey) a.a(MmRecordingSlotKey.class, r100);
    }

    public MmRecordingSlotKey(String r100, int r101) {
        super(r100, r101);
    }
}
