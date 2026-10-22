package com.ss.android.lark.officesdk.minutes.ui.record.recording.subtitle.ui;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes37.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\t\b\u0080\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\t¨\u0006\n"}, d2 = {"Lcom/ss/android/lark/officesdk/minutes/ui/record/recording/subtitle/ui/MmSubtitlePayload;", "", "<init>", "(Ljava/lang/String;I)V", "CONTENT", "AVATAR", "SPEAKER", "EDIT_STATE", "TIME", "HIGHLIGHT", "officesdk-minutes-base-ui_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum MmSubtitlePayload extends Enum<MmSubtitlePayload> {
    public static final MmSubtitlePayload AVATAR = null;
    public static final MmSubtitlePayload CONTENT = null;
    public static final MmSubtitlePayload EDIT_STATE = null;
    public static final MmSubtitlePayload HIGHLIGHT = null;
    public static final MmSubtitlePayload SPEAKER = null;
    public static final MmSubtitlePayload TIME = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ MmSubtitlePayload[] f436467a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f436468b = null;

    public static EnumEntries<MmSubtitlePayload> getEntries() {
        return f436468b;
    }

    static {
        MmSubtitlePayload r100 = new MmSubtitlePayload("CONTENT", 0);
        CONTENT = r100;
        MmSubtitlePayload r101 = new MmSubtitlePayload("AVATAR", 1);
        AVATAR = r101;
        MmSubtitlePayload r102 = new MmSubtitlePayload("SPEAKER", 2);
        SPEAKER = r102;
        MmSubtitlePayload r103 = new MmSubtitlePayload("EDIT_STATE", 3);
        EDIT_STATE = r103;
        MmSubtitlePayload r104 = new MmSubtitlePayload("TIME", 4);
        TIME = r104;
        MmSubtitlePayload r105 = new MmSubtitlePayload("HIGHLIGHT", 5);
        HIGHLIGHT = r105;
        MmSubtitlePayload[] r110 = {r100, r101, r102, r103, r104, r105};
        f436467a = r110;
        f436468b = EnumEntriesKt.enumEntries(r110);
    }

    public static MmSubtitlePayload[] values() {
        return (MmSubtitlePayload[]) f436467a.clone();
    }

    public static MmSubtitlePayload valueOf(String r100) {
        return (MmSubtitlePayload) r27.a.a(MmSubtitlePayload.class, r100);
    }

    public MmSubtitlePayload(String r100, int r101) {
        super(r100, r101);
    }
}
