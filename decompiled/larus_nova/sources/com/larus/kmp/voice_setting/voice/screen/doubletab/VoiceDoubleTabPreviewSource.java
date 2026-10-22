package com.larus.kmp.voice_setting.voice.screen.doubletab;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes30.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\t\b\u0080\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\t¨\u0006\n"}, d2 = {"Lcom/larus/kmp/voice_setting/voice/screen/doubletab/VoiceDoubleTabPreviewSource;", "", "<init>", "(Ljava/lang/String;I)V", "UNKNOWN", "SINGLE_LIST_ITEM", "TOP_SINGLE", "MIX_LIST_ITEM", "EDIT_MIX_ROW", "MIXED_PREVIEW", "flow-voice-setting-impl_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum VoiceDoubleTabPreviewSource extends Enum<VoiceDoubleTabPreviewSource> {
    public static final VoiceDoubleTabPreviewSource EDIT_MIX_ROW = null;
    public static final VoiceDoubleTabPreviewSource MIXED_PREVIEW = null;
    public static final VoiceDoubleTabPreviewSource MIX_LIST_ITEM = null;
    public static final VoiceDoubleTabPreviewSource SINGLE_LIST_ITEM = null;
    public static final VoiceDoubleTabPreviewSource TOP_SINGLE = null;
    public static final VoiceDoubleTabPreviewSource UNKNOWN = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ VoiceDoubleTabPreviewSource[] f354123a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f354124b = null;

    public static EnumEntries<VoiceDoubleTabPreviewSource> getEntries() {
        return f354124b;
    }

    static {
        VoiceDoubleTabPreviewSource r100 = new VoiceDoubleTabPreviewSource("UNKNOWN", 0);
        UNKNOWN = r100;
        VoiceDoubleTabPreviewSource r101 = new VoiceDoubleTabPreviewSource("SINGLE_LIST_ITEM", 1);
        SINGLE_LIST_ITEM = r101;
        VoiceDoubleTabPreviewSource r102 = new VoiceDoubleTabPreviewSource("TOP_SINGLE", 2);
        TOP_SINGLE = r102;
        VoiceDoubleTabPreviewSource r103 = new VoiceDoubleTabPreviewSource("MIX_LIST_ITEM", 3);
        MIX_LIST_ITEM = r103;
        VoiceDoubleTabPreviewSource r104 = new VoiceDoubleTabPreviewSource("EDIT_MIX_ROW", 4);
        EDIT_MIX_ROW = r104;
        VoiceDoubleTabPreviewSource r105 = new VoiceDoubleTabPreviewSource("MIXED_PREVIEW", 5);
        MIXED_PREVIEW = r105;
        VoiceDoubleTabPreviewSource[] r110 = {r100, r101, r102, r103, r104, r105};
        f354123a = r110;
        f354124b = EnumEntriesKt.enumEntries(r110);
    }

    public static VoiceDoubleTabPreviewSource[] values() {
        return (VoiceDoubleTabPreviewSource[]) f354123a.clone();
    }

    public static VoiceDoubleTabPreviewSource valueOf(String r100) {
        return (VoiceDoubleTabPreviewSource) r27.a.a(VoiceDoubleTabPreviewSource.class, r100);
    }

    public VoiceDoubleTabPreviewSource(String r100, int r101) {
        super(r100, r101);
    }
}
