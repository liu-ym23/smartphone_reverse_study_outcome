package com.ss.android.lark.officesdk.minutes.ui.record.recording.subtitle.ui;

import com.bytedance.android.livesdk.chatroom.event.UserProfileEvent;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes37.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/ss/android/lark/officesdk/minutes/ui/record/recording/subtitle/ui/MmSubtitleHighlightStyle;", "", "<init>", "(Ljava/lang/String;I)V", UserProfileEvent.POSITION_NONE, "JUMP", "SELECTED", "officesdk-minutes-base-ui_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum MmSubtitleHighlightStyle extends Enum<MmSubtitleHighlightStyle> {
    public static final MmSubtitleHighlightStyle JUMP = null;
    public static final MmSubtitleHighlightStyle NONE = null;
    public static final MmSubtitleHighlightStyle SELECTED = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ MmSubtitleHighlightStyle[] f436431a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f436432b = null;

    public static EnumEntries<MmSubtitleHighlightStyle> getEntries() {
        return f436432b;
    }

    static {
        MmSubtitleHighlightStyle r100 = new MmSubtitleHighlightStyle(UserProfileEvent.POSITION_NONE, 0);
        NONE = r100;
        MmSubtitleHighlightStyle r101 = new MmSubtitleHighlightStyle("JUMP", 1);
        JUMP = r101;
        MmSubtitleHighlightStyle r102 = new MmSubtitleHighlightStyle("SELECTED", 2);
        SELECTED = r102;
        MmSubtitleHighlightStyle[] r103 = {r100, r101, r102};
        f436431a = r103;
        f436432b = EnumEntriesKt.enumEntries(r103);
    }

    public static MmSubtitleHighlightStyle[] values() {
        return (MmSubtitleHighlightStyle[]) f436431a.clone();
    }

    public static MmSubtitleHighlightStyle valueOf(String r100) {
        return (MmSubtitleHighlightStyle) r27.a.a(MmSubtitleHighlightStyle.class, r100);
    }

    public MmSubtitleHighlightStyle(String r100, int r101) {
        super(r100, r101);
    }
}
