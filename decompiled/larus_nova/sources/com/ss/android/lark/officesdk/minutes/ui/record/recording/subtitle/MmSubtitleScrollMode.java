package com.ss.android.lark.officesdk.minutes.ui.record.recording.subtitle;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes37.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/ss/android/lark/officesdk/minutes/ui/record/recording/subtitle/MmSubtitleScrollMode;", "", "<init>", "(Ljava/lang/String;I)V", "FOLLOW", "FREE", "officesdk-minutes-base-ui_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum MmSubtitleScrollMode extends Enum<MmSubtitleScrollMode> {
    public static final MmSubtitleScrollMode FOLLOW = null;
    public static final MmSubtitleScrollMode FREE = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ MmSubtitleScrollMode[] f436388a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f436389b = null;

    public static EnumEntries<MmSubtitleScrollMode> getEntries() {
        return f436389b;
    }

    static {
        MmSubtitleScrollMode r100 = new MmSubtitleScrollMode("FOLLOW", 0);
        FOLLOW = r100;
        MmSubtitleScrollMode r101 = new MmSubtitleScrollMode("FREE", 1);
        FREE = r101;
        MmSubtitleScrollMode[] r102 = {r100, r101};
        f436388a = r102;
        f436389b = EnumEntriesKt.enumEntries(r102);
    }

    public static MmSubtitleScrollMode[] values() {
        return (MmSubtitleScrollMode[]) f436388a.clone();
    }

    public static MmSubtitleScrollMode valueOf(String r100) {
        return (MmSubtitleScrollMode) r27.a.a(MmSubtitleScrollMode.class, r100);
    }

    public MmSubtitleScrollMode(String r100, int r101) {
        super(r100, r101);
    }
}
