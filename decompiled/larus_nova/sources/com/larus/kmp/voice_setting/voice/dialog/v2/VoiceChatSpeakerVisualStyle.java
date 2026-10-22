package com.larus.kmp.voice_setting.voice.dialog.v2;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0080\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/larus/kmp/voice_setting/voice/dialog/v2/VoiceChatSpeakerVisualStyle;", "", "<init>", "(Ljava/lang/String;I)V", "CLASSIC", "BLUR", "flow-voice-setting-impl_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum VoiceChatSpeakerVisualStyle extends Enum<VoiceChatSpeakerVisualStyle> {
    public static final VoiceChatSpeakerVisualStyle BLUR = null;
    public static final VoiceChatSpeakerVisualStyle CLASSIC = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ VoiceChatSpeakerVisualStyle[] f353039a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f353040b = null;

    public static EnumEntries<VoiceChatSpeakerVisualStyle> getEntries() {
        return f353040b;
    }

    static {
        VoiceChatSpeakerVisualStyle r100 = new VoiceChatSpeakerVisualStyle("CLASSIC", 0);
        CLASSIC = r100;
        VoiceChatSpeakerVisualStyle r101 = new VoiceChatSpeakerVisualStyle("BLUR", 1);
        BLUR = r101;
        VoiceChatSpeakerVisualStyle[] r102 = {r100, r101};
        f353039a = r102;
        f353040b = EnumEntriesKt.enumEntries(r102);
    }

    public static VoiceChatSpeakerVisualStyle[] values() {
        return (VoiceChatSpeakerVisualStyle[]) f353039a.clone();
    }

    public static VoiceChatSpeakerVisualStyle valueOf(String r100) {
        return (VoiceChatSpeakerVisualStyle) r27.a.a(VoiceChatSpeakerVisualStyle.class, r100);
    }

    public VoiceChatSpeakerVisualStyle(String r100, int r101) {
        super(r100, r101);
    }
}
