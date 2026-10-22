package com.larus.kmp.voice_setting.voice.list.row;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes30.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0082\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/larus/kmp/voice_setting/voice/list/row/VoiceStatusRowStyle;", "", "<init>", "(Ljava/lang/String;I)V", "TRAILING", "REVIEW_AREA", "flow-voice-setting-impl_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
final enum VoiceStatusRowStyle extends Enum<VoiceStatusRowStyle> {
    public static final VoiceStatusRowStyle REVIEW_AREA = null;
    public static final VoiceStatusRowStyle TRAILING = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ VoiceStatusRowStyle[] f353607a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f353608b = null;

    public static EnumEntries<VoiceStatusRowStyle> getEntries() {
        return f353608b;
    }

    static {
        VoiceStatusRowStyle r100 = new VoiceStatusRowStyle("TRAILING", 0);
        TRAILING = r100;
        VoiceStatusRowStyle r101 = new VoiceStatusRowStyle("REVIEW_AREA", 1);
        REVIEW_AREA = r101;
        VoiceStatusRowStyle[] r102 = {r100, r101};
        f353607a = r102;
        f353608b = EnumEntriesKt.enumEntries(r102);
    }

    public static VoiceStatusRowStyle[] values() {
        return (VoiceStatusRowStyle[]) f353607a.clone();
    }

    public static VoiceStatusRowStyle valueOf(String r100) {
        return (VoiceStatusRowStyle) r27.a.a(VoiceStatusRowStyle.class, r100);
    }

    public VoiceStatusRowStyle(String r100, int r101) {
        super(r100, r101);
    }
}
