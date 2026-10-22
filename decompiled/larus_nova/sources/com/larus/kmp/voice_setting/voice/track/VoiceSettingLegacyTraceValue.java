package com.larus.kmp.voice_setting.voice.track;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: classes30.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u000b\b\u0080\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000b¨\u0006\f"}, d2 = {"Lcom/larus/kmp/voice_setting/voice/track/VoiceSettingLegacyTraceValue;", "", "<init>", "(Ljava/lang/String;I)V", "TRACE_SELF_CREATE", "TRACE_DEFAULT", "TTS_DISABLED", "STRING_0", "STRING_1", "VOICE_TYPE_SELF_CREATE", "VOICE_TYPE_DEFAULT", "PREVIOUS_PAGE_CHAT", "flow-voice-setting-impl_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum VoiceSettingLegacyTraceValue extends Enum<VoiceSettingLegacyTraceValue> {
    public static final VoiceSettingLegacyTraceValue PREVIOUS_PAGE_CHAT = null;
    public static final VoiceSettingLegacyTraceValue STRING_0 = null;
    public static final VoiceSettingLegacyTraceValue STRING_1 = null;
    public static final VoiceSettingLegacyTraceValue TRACE_DEFAULT = null;
    public static final VoiceSettingLegacyTraceValue TRACE_SELF_CREATE = null;
    public static final VoiceSettingLegacyTraceValue TTS_DISABLED = null;
    public static final VoiceSettingLegacyTraceValue VOICE_TYPE_DEFAULT = null;
    public static final VoiceSettingLegacyTraceValue VOICE_TYPE_SELF_CREATE = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ VoiceSettingLegacyTraceValue[] f354963a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f354964b = null;

    public static EnumEntries<VoiceSettingLegacyTraceValue> getEntries() {
        return f354964b;
    }

    static {
        VoiceSettingLegacyTraceValue r100 = new VoiceSettingLegacyTraceValue("TRACE_SELF_CREATE", 0);
        TRACE_SELF_CREATE = r100;
        VoiceSettingLegacyTraceValue r101 = new VoiceSettingLegacyTraceValue("TRACE_DEFAULT", 1);
        TRACE_DEFAULT = r101;
        VoiceSettingLegacyTraceValue r102 = new VoiceSettingLegacyTraceValue("TTS_DISABLED", 2);
        TTS_DISABLED = r102;
        VoiceSettingLegacyTraceValue r103 = new VoiceSettingLegacyTraceValue("STRING_0", 3);
        STRING_0 = r103;
        VoiceSettingLegacyTraceValue r104 = new VoiceSettingLegacyTraceValue("STRING_1", 4);
        STRING_1 = r104;
        VoiceSettingLegacyTraceValue r105 = new VoiceSettingLegacyTraceValue("VOICE_TYPE_SELF_CREATE", 5);
        VOICE_TYPE_SELF_CREATE = r105;
        VoiceSettingLegacyTraceValue r110 = new VoiceSettingLegacyTraceValue("VOICE_TYPE_DEFAULT", 6);
        VOICE_TYPE_DEFAULT = r110;
        VoiceSettingLegacyTraceValue r111 = new VoiceSettingLegacyTraceValue("PREVIOUS_PAGE_CHAT", 7);
        PREVIOUS_PAGE_CHAT = r111;
        VoiceSettingLegacyTraceValue[] r112 = {r100, r101, r102, r103, r104, r105, r110, r111};
        f354963a = r112;
        f354964b = EnumEntriesKt.enumEntries(r112);
    }

    public static VoiceSettingLegacyTraceValue[] values() {
        return (VoiceSettingLegacyTraceValue[]) f354963a.clone();
    }

    public static VoiceSettingLegacyTraceValue valueOf(String r100) {
        return (VoiceSettingLegacyTraceValue) a.a(VoiceSettingLegacyTraceValue.class, r100);
    }

    public VoiceSettingLegacyTraceValue(String r100, int r101) {
        super(r100, r101);
    }
}
