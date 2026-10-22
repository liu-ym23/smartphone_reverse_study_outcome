package com.larus.kmp.voice_setting.voice.track;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: classes30.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\r\b\u0080\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\r¨\u0006\u000e"}, d2 = {"Lcom/larus/kmp/voice_setting/voice/track/VoiceSettingLegacyTraceEvent;", "", "<init>", "(Ljava/lang/String;I)V", "RECOMMEND_VOICE_TTI", "HIT_PRELOAD_RECOMMEND_VOICE", "RECOMMEND_REQUEST_LOAD_TIME", "COMPLETE_DELETE_OWN_VOICE", "COMPLETE_CHANGE_OWN_VOICE_NAME", "CLICK_VOICE_SETTING", "CLICK_CHANGE_OWN_VOICE_NAME", "CLICK_DELETE_OWN_VOICE", "RECORD_OWN_VOICE_COMPLETE", "CHANGE_VOICE", "flow-voice-setting-impl_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum VoiceSettingLegacyTraceEvent extends Enum<VoiceSettingLegacyTraceEvent> {
    public static final VoiceSettingLegacyTraceEvent CHANGE_VOICE = null;
    public static final VoiceSettingLegacyTraceEvent CLICK_CHANGE_OWN_VOICE_NAME = null;
    public static final VoiceSettingLegacyTraceEvent CLICK_DELETE_OWN_VOICE = null;
    public static final VoiceSettingLegacyTraceEvent CLICK_VOICE_SETTING = null;
    public static final VoiceSettingLegacyTraceEvent COMPLETE_CHANGE_OWN_VOICE_NAME = null;
    public static final VoiceSettingLegacyTraceEvent COMPLETE_DELETE_OWN_VOICE = null;
    public static final VoiceSettingLegacyTraceEvent HIT_PRELOAD_RECOMMEND_VOICE = null;
    public static final VoiceSettingLegacyTraceEvent RECOMMEND_REQUEST_LOAD_TIME = null;
    public static final VoiceSettingLegacyTraceEvent RECOMMEND_VOICE_TTI = null;
    public static final VoiceSettingLegacyTraceEvent RECORD_OWN_VOICE_COMPLETE = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ VoiceSettingLegacyTraceEvent[] f354959a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f354960b = null;

    public static EnumEntries<VoiceSettingLegacyTraceEvent> getEntries() {
        return f354960b;
    }

    static {
        VoiceSettingLegacyTraceEvent r100 = new VoiceSettingLegacyTraceEvent("RECOMMEND_VOICE_TTI", 0);
        RECOMMEND_VOICE_TTI = r100;
        VoiceSettingLegacyTraceEvent r101 = new VoiceSettingLegacyTraceEvent("HIT_PRELOAD_RECOMMEND_VOICE", 1);
        HIT_PRELOAD_RECOMMEND_VOICE = r101;
        VoiceSettingLegacyTraceEvent r102 = new VoiceSettingLegacyTraceEvent("RECOMMEND_REQUEST_LOAD_TIME", 2);
        RECOMMEND_REQUEST_LOAD_TIME = r102;
        VoiceSettingLegacyTraceEvent r103 = new VoiceSettingLegacyTraceEvent("COMPLETE_DELETE_OWN_VOICE", 3);
        COMPLETE_DELETE_OWN_VOICE = r103;
        VoiceSettingLegacyTraceEvent r104 = new VoiceSettingLegacyTraceEvent("COMPLETE_CHANGE_OWN_VOICE_NAME", 4);
        COMPLETE_CHANGE_OWN_VOICE_NAME = r104;
        VoiceSettingLegacyTraceEvent r105 = new VoiceSettingLegacyTraceEvent("CLICK_VOICE_SETTING", 5);
        CLICK_VOICE_SETTING = r105;
        VoiceSettingLegacyTraceEvent r110 = new VoiceSettingLegacyTraceEvent("CLICK_CHANGE_OWN_VOICE_NAME", 6);
        CLICK_CHANGE_OWN_VOICE_NAME = r110;
        VoiceSettingLegacyTraceEvent r111 = new VoiceSettingLegacyTraceEvent("CLICK_DELETE_OWN_VOICE", 7);
        CLICK_DELETE_OWN_VOICE = r111;
        VoiceSettingLegacyTraceEvent r112 = new VoiceSettingLegacyTraceEvent("RECORD_OWN_VOICE_COMPLETE", 8);
        RECORD_OWN_VOICE_COMPLETE = r112;
        VoiceSettingLegacyTraceEvent r113 = new VoiceSettingLegacyTraceEvent("CHANGE_VOICE", 9);
        CHANGE_VOICE = r113;
        VoiceSettingLegacyTraceEvent[] r114 = {r100, r101, r102, r103, r104, r105, r110, r111, r112, r113};
        f354959a = r114;
        f354960b = EnumEntriesKt.enumEntries(r114);
    }

    public static VoiceSettingLegacyTraceEvent[] values() {
        return (VoiceSettingLegacyTraceEvent[]) f354959a.clone();
    }

    public static VoiceSettingLegacyTraceEvent valueOf(String r100) {
        return (VoiceSettingLegacyTraceEvent) a.a(VoiceSettingLegacyTraceEvent.class, r100);
    }

    public VoiceSettingLegacyTraceEvent(String r100, int r101) {
        super(r100, r101);
    }
}
