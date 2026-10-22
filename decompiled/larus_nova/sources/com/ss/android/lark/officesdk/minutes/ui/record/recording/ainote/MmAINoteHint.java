package com.ss.android.lark.officesdk.minutes.ui.record.recording.ainote;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes37.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/ss/android/lark/officesdk/minutes/ui/record/recording/ainote/MmAINoteHint;", "", "<init>", "(Ljava/lang/String;I)V", "SUBTITLE_MISSING", "MARK_THROTTLE", "officesdk-minutes-base-ui_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum MmAINoteHint extends Enum<MmAINoteHint> {
    public static final MmAINoteHint MARK_THROTTLE = null;
    public static final MmAINoteHint SUBTITLE_MISSING = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ MmAINoteHint[] f435965a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f435966b = null;

    public static EnumEntries<MmAINoteHint> getEntries() {
        return f435966b;
    }

    static {
        MmAINoteHint r100 = new MmAINoteHint("SUBTITLE_MISSING", 0);
        SUBTITLE_MISSING = r100;
        MmAINoteHint r101 = new MmAINoteHint("MARK_THROTTLE", 1);
        MARK_THROTTLE = r101;
        MmAINoteHint[] r102 = {r100, r101};
        f435965a = r102;
        f435966b = EnumEntriesKt.enumEntries(r102);
    }

    public static MmAINoteHint[] values() {
        return (MmAINoteHint[]) f435965a.clone();
    }

    public static MmAINoteHint valueOf(String r100) {
        return (MmAINoteHint) r27.a.a(MmAINoteHint.class, r100);
    }

    public MmAINoteHint(String r100, int r101) {
        super(r100, r101);
    }
}
