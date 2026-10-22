package com.larus.kmp.voice_setting.voice.track;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: classes30.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0012\b\u0080\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012¨\u0006\u0013"}, d2 = {"Lcom/larus/kmp/voice_setting/voice/track/VoiceSettingLegacyTraceKey;", "", "<init>", "(Ljava/lang/String;I)V", "ENTER_FROM", "TIME", "RECOMMEND_TYPE", "IS_MAIN_BOT", "IS_HIT", "REQUEST_TYPE", "SUCCESS", "PRELOAD", "CURRENT_PAGE", "VOICE_ID", "ENTER_METHOD", "BOT_ID", "VOICE_TYPE", "TO_TTS_SPEAKER", "IF_AUTO", "flow-voice-setting-impl_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum VoiceSettingLegacyTraceKey extends Enum<VoiceSettingLegacyTraceKey> {
    public static final VoiceSettingLegacyTraceKey BOT_ID = null;
    public static final VoiceSettingLegacyTraceKey CURRENT_PAGE = null;
    public static final VoiceSettingLegacyTraceKey ENTER_FROM = null;
    public static final VoiceSettingLegacyTraceKey ENTER_METHOD = null;
    public static final VoiceSettingLegacyTraceKey IF_AUTO = null;
    public static final VoiceSettingLegacyTraceKey IS_HIT = null;
    public static final VoiceSettingLegacyTraceKey IS_MAIN_BOT = null;
    public static final VoiceSettingLegacyTraceKey PRELOAD = null;
    public static final VoiceSettingLegacyTraceKey RECOMMEND_TYPE = null;
    public static final VoiceSettingLegacyTraceKey REQUEST_TYPE = null;
    public static final VoiceSettingLegacyTraceKey SUCCESS = null;
    public static final VoiceSettingLegacyTraceKey TIME = null;
    public static final VoiceSettingLegacyTraceKey TO_TTS_SPEAKER = null;
    public static final VoiceSettingLegacyTraceKey VOICE_ID = null;
    public static final VoiceSettingLegacyTraceKey VOICE_TYPE = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ VoiceSettingLegacyTraceKey[] f354961a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f354962b = null;

    public static EnumEntries<VoiceSettingLegacyTraceKey> getEntries() {
        return f354962b;
    }

    static {
        VoiceSettingLegacyTraceKey r100 = new VoiceSettingLegacyTraceKey("ENTER_FROM", 0);
        ENTER_FROM = r100;
        VoiceSettingLegacyTraceKey r101 = new VoiceSettingLegacyTraceKey("TIME", 1);
        TIME = r101;
        VoiceSettingLegacyTraceKey r102 = new VoiceSettingLegacyTraceKey("RECOMMEND_TYPE", 2);
        RECOMMEND_TYPE = r102;
        VoiceSettingLegacyTraceKey r103 = new VoiceSettingLegacyTraceKey("IS_MAIN_BOT", 3);
        IS_MAIN_BOT = r103;
        VoiceSettingLegacyTraceKey r104 = new VoiceSettingLegacyTraceKey("IS_HIT", 4);
        IS_HIT = r104;
        VoiceSettingLegacyTraceKey r105 = new VoiceSettingLegacyTraceKey("REQUEST_TYPE", 5);
        REQUEST_TYPE = r105;
        VoiceSettingLegacyTraceKey r110 = new VoiceSettingLegacyTraceKey("SUCCESS", 6);
        SUCCESS = r110;
        VoiceSettingLegacyTraceKey r111 = new VoiceSettingLegacyTraceKey("PRELOAD", 7);
        PRELOAD = r111;
        VoiceSettingLegacyTraceKey r112 = new VoiceSettingLegacyTraceKey("CURRENT_PAGE", 8);
        CURRENT_PAGE = r112;
        VoiceSettingLegacyTraceKey r113 = new VoiceSettingLegacyTraceKey("VOICE_ID", 9);
        VOICE_ID = r113;
        VoiceSettingLegacyTraceKey r114 = new VoiceSettingLegacyTraceKey("ENTER_METHOD", 10);
        ENTER_METHOD = r114;
        VoiceSettingLegacyTraceKey r115 = new VoiceSettingLegacyTraceKey("BOT_ID", 11);
        BOT_ID = r115;
        VoiceSettingLegacyTraceKey r106 = new VoiceSettingLegacyTraceKey("VOICE_TYPE", 12);
        VOICE_TYPE = r106;
        VoiceSettingLegacyTraceKey r107 = new VoiceSettingLegacyTraceKey("TO_TTS_SPEAKER", 13);
        TO_TTS_SPEAKER = r107;
        VoiceSettingLegacyTraceKey r108 = new VoiceSettingLegacyTraceKey("IF_AUTO", 14);
        IF_AUTO = r108;
        VoiceSettingLegacyTraceKey[] r109 = {r100, r101, r102, r103, r104, r105, r110, r111, r112, r113, r114, r115, r106, r107, r108};
        f354961a = r109;
        f354962b = EnumEntriesKt.enumEntries(r109);
    }

    public static VoiceSettingLegacyTraceKey[] values() {
        return (VoiceSettingLegacyTraceKey[]) f354961a.clone();
    }

    public static VoiceSettingLegacyTraceKey valueOf(String r100) {
        return (VoiceSettingLegacyTraceKey) a.a(VoiceSettingLegacyTraceKey.class, r100);
    }

    public VoiceSettingLegacyTraceKey(String r100, int r101) {
        super(r100, r101);
    }
}
