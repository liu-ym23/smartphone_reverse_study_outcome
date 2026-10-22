package com.larus.im.service.audio.cmd;

import com.mammon.audiosdk.session.type.RequestEvent;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: classes30.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b8\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0013\b\u0002\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012j\u0002\b\u0013j\u0002\b\u0014j\u0002\b\u0015j\u0002\b\u0016j\u0002\b\u0017j\u0002\b\u0018j\u0002\b\u0019j\u0002\b\u001aj\u0002\b\u001bj\u0002\b\u001cj\u0002\b\u001dj\u0002\b\u001ej\u0002\b\u001fj\u0002\b j\u0002\b!j\u0002\b\"j\u0002\b#j\u0002\b$j\u0002\b%j\u0002\b&j\u0002\b'j\u0002\b(j\u0002\b)j\u0002\b*j\u0002\b+j\u0002\b,j\u0002\b-j\u0002\b.j\u0002\b/j\u0002\b0j\u0002\b1j\u0002\b2j\u0002\b3j\u0002\b4j\u0002\b5j\u0002\b6j\u0002\b7j\u0002\b8j\u0002\b9j\u0002\b:¨\u0006;"}, d2 = {"Lcom/larus/im/service/audio/cmd/TriggerMode;", "", "event", "", "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "getEvent", "()Ljava/lang/String;", "UNUSED", "INTERRUPT", "PAUSE", "CONTINUE", "HELLO", "HELLO_NEW", "WAIT", "HANGUP", "UPLINK_HANGUP", "AUTH_DENY", "AUTH_SUCCESS", "AUTH_FAILED", "ONBOARDING_START", "CONTINUE_TYPE", "ANCS_SUMMARY", "IMAGE", "CLIENT_SUMMON_NOTICE", "FULL_TEXT_QUERY", "INTERVIEW_IMAGE", "SUGGEST", "DORA_E_BOT_ACTIVE", "QUERY_WHEN_SILENCE", "MUTE", "UNMUTE", "UPDATE_UI_CONTEXT", "UPDATE_PERSONAL_CONTEXT", "END_ASR", "CHAT_REQUEST", "SPEECH_STARTED", "SPEECH_ENDED", "CLIM_IN_STARTED", "CLIM_IN_END", "INTERPRET_ASR_STARTED", "AUDIO_ROUND_TRACE", "TTS_PLAYBACK_START", "TTS_PLAYBACK_END", "TTS_PLAYBACK_PAUSE", "TTS_PLAYBACK_RESUME", "TTS_PLAYBACK_INTERRUPT", "SWITCH_SCENE", "PING", "DOWNLINK_QUOTA_EXCEEDED", "UPLINK_UPDATE_EXTENSION_TIME", "DORA_START_CONVERSATION", "DORA_STOP_CONVERSATION", "CLIENT_INTENT", "VOICE_ASSISTANT_SEND_IMAGE", "UPDATE_ROUND_CONTEXT", "WAKE_UP_REJECT", "WAKE_UP_SUCCESS", "CLIENT_SYNC", "flow-avsdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum TriggerMode extends Enum<TriggerMode> {
    public static final TriggerMode ANCS_SUMMARY = null;
    public static final TriggerMode AUDIO_ROUND_TRACE = null;
    public static final TriggerMode AUTH_DENY = null;
    public static final TriggerMode AUTH_FAILED = null;
    public static final TriggerMode AUTH_SUCCESS = null;
    public static final TriggerMode CHAT_REQUEST = null;
    public static final TriggerMode CLIENT_INTENT = null;
    public static final TriggerMode CLIENT_SUMMON_NOTICE = null;
    public static final TriggerMode CLIENT_SYNC = null;
    public static final TriggerMode CLIM_IN_END = null;
    public static final TriggerMode CLIM_IN_STARTED = null;
    public static final TriggerMode CONTINUE = null;
    public static final TriggerMode CONTINUE_TYPE = null;
    public static final TriggerMode DORA_E_BOT_ACTIVE = null;
    public static final TriggerMode DORA_START_CONVERSATION = null;
    public static final TriggerMode DORA_STOP_CONVERSATION = null;
    public static final TriggerMode DOWNLINK_QUOTA_EXCEEDED = null;
    public static final TriggerMode END_ASR = null;
    public static final TriggerMode FULL_TEXT_QUERY = null;
    public static final TriggerMode HANGUP = null;
    public static final TriggerMode HELLO = null;
    public static final TriggerMode HELLO_NEW = null;
    public static final TriggerMode IMAGE = null;
    public static final TriggerMode INTERPRET_ASR_STARTED = null;
    public static final TriggerMode INTERRUPT = null;
    public static final TriggerMode INTERVIEW_IMAGE = null;
    public static final TriggerMode MUTE = null;
    public static final TriggerMode ONBOARDING_START = null;
    public static final TriggerMode PAUSE = null;
    public static final TriggerMode PING = null;
    public static final TriggerMode QUERY_WHEN_SILENCE = null;
    public static final TriggerMode SPEECH_ENDED = null;
    public static final TriggerMode SPEECH_STARTED = null;
    public static final TriggerMode SUGGEST = null;
    public static final TriggerMode SWITCH_SCENE = null;
    public static final TriggerMode TTS_PLAYBACK_END = null;
    public static final TriggerMode TTS_PLAYBACK_INTERRUPT = null;
    public static final TriggerMode TTS_PLAYBACK_PAUSE = null;
    public static final TriggerMode TTS_PLAYBACK_RESUME = null;
    public static final TriggerMode TTS_PLAYBACK_START = null;
    public static final TriggerMode UNMUTE = null;
    public static final TriggerMode UNUSED = null;
    public static final TriggerMode UPDATE_PERSONAL_CONTEXT = null;
    public static final TriggerMode UPDATE_ROUND_CONTEXT = null;
    public static final TriggerMode UPDATE_UI_CONTEXT = null;
    public static final TriggerMode UPLINK_HANGUP = null;
    public static final TriggerMode UPLINK_UPDATE_EXTENSION_TIME = null;
    public static final TriggerMode VOICE_ASSISTANT_SEND_IMAGE = null;
    public static final TriggerMode WAIT = null;
    public static final TriggerMode WAKE_UP_REJECT = null;
    public static final TriggerMode WAKE_UP_SUCCESS = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ TriggerMode[] f350727a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f350728b = null;
    private final String event;

    public static EnumEntries<TriggerMode> getEntries() {
        return f350728b;
    }

    static {
        TriggerMode r100 = new TriggerMode("UNUSED", 0, null);
        UNUSED = r100;
        TriggerMode r101 = new TriggerMode("INTERRUPT", 1, RequestEvent.ClientInterrupt);
        INTERRUPT = r101;
        TriggerMode r102 = new TriggerMode("PAUSE", 2, RequestEvent.PauseCall);
        PAUSE = r102;
        TriggerMode r103 = new TriggerMode("CONTINUE", 3, RequestEvent.ContinueCall);
        CONTINUE = r103;
        TriggerMode r104 = new TriggerMode("HELLO", 4, RequestEvent.TriggerBot);
        HELLO = r104;
        TriggerMode r105 = new TriggerMode("HELLO_NEW", 5, RequestEvent.TriggerBot);
        HELLO_NEW = r105;
        TriggerMode r110 = new TriggerMode("WAIT", 6, RequestEvent.TriggerBot);
        WAIT = r110;
        TriggerMode r111 = new TriggerMode("HANGUP", 7, RequestEvent.TriggerBot);
        HANGUP = r111;
        TriggerMode r112 = new TriggerMode("UPLINK_HANGUP", 8, RequestEvent.TriggerBot);
        UPLINK_HANGUP = r112;
        TriggerMode r113 = new TriggerMode("AUTH_DENY", 9, RequestEvent.TriggerBot);
        AUTH_DENY = r113;
        TriggerMode r114 = new TriggerMode("AUTH_SUCCESS", 10, RequestEvent.TriggerBot);
        AUTH_SUCCESS = r114;
        TriggerMode r106 = new TriggerMode("AUTH_FAILED", 11, RequestEvent.TriggerBot);
        AUTH_FAILED = r106;
        TriggerMode r107 = new TriggerMode("ONBOARDING_START", 12, RequestEvent.TriggerBot);
        ONBOARDING_START = r107;
        TriggerMode r108 = new TriggerMode("CONTINUE_TYPE", 13, RequestEvent.TriggerBot);
        CONTINUE_TYPE = r108;
        TriggerMode r109 = new TriggerMode("ANCS_SUMMARY", 14, RequestEvent.TriggerBot);
        ANCS_SUMMARY = r109;
        TriggerMode r115 = new TriggerMode("IMAGE", 15, RequestEvent.TriggerBot);
        IMAGE = r115;
        TriggerMode r116 = new TriggerMode("CLIENT_SUMMON_NOTICE", 16, RequestEvent.TriggerBot);
        CLIENT_SUMMON_NOTICE = r116;
        TriggerMode r117 = new TriggerMode("FULL_TEXT_QUERY", 17, RequestEvent.TriggerBot);
        FULL_TEXT_QUERY = r117;
        TriggerMode r118 = new TriggerMode("INTERVIEW_IMAGE", 18, RequestEvent.TriggerBot);
        INTERVIEW_IMAGE = r118;
        TriggerMode r119 = new TriggerMode("SUGGEST", 19, RequestEvent.TriggerBot);
        SUGGEST = r119;
        TriggerMode r120 = new TriggerMode("DORA_E_BOT_ACTIVE", 20, RequestEvent.TriggerBot);
        DORA_E_BOT_ACTIVE = r120;
        TriggerMode r121 = new TriggerMode("QUERY_WHEN_SILENCE", 21, RequestEvent.TriggerBot);
        QUERY_WHEN_SILENCE = r121;
        TriggerMode r122 = new TriggerMode("MUTE", 22, RequestEvent.MuteCall);
        MUTE = r122;
        TriggerMode r123 = new TriggerMode("UNMUTE", 23, RequestEvent.UnmuteCall);
        UNMUTE = r123;
        TriggerMode r124 = new TriggerMode("UPDATE_UI_CONTEXT", 24, RequestEvent.UpdateUIContext);
        UPDATE_UI_CONTEXT = r124;
        TriggerMode r125 = new TriggerMode("UPDATE_PERSONAL_CONTEXT", 25, "UpdatePersonalContext");
        UPDATE_PERSONAL_CONTEXT = r125;
        TriggerMode r126 = new TriggerMode("END_ASR", 26, RequestEvent.EndASR);
        END_ASR = r126;
        TriggerMode r127 = new TriggerMode("CHAT_REQUEST", 27, null);
        CHAT_REQUEST = r127;
        TriggerMode r128 = new TriggerMode("SPEECH_STARTED", 28, null);
        SPEECH_STARTED = r128;
        TriggerMode r129 = new TriggerMode("SPEECH_ENDED", 29, null);
        SPEECH_ENDED = r129;
        TriggerMode r130 = new TriggerMode("CLIM_IN_STARTED", 30, "ClimInStarted");
        CLIM_IN_STARTED = r130;
        TriggerMode r131 = new TriggerMode("CLIM_IN_END", 31, "ClimInEnd");
        CLIM_IN_END = r131;
        TriggerMode r132 = new TriggerMode("INTERPRET_ASR_STARTED", 32, "InterpretASRStarted");
        INTERPRET_ASR_STARTED = r132;
        TriggerMode r133 = new TriggerMode("AUDIO_ROUND_TRACE", 33, "PlayStatusTrace");
        AUDIO_ROUND_TRACE = r133;
        TriggerMode r134 = new TriggerMode("TTS_PLAYBACK_START", 34, "TTSPlaybackStart");
        TTS_PLAYBACK_START = r134;
        TriggerMode r135 = new TriggerMode("TTS_PLAYBACK_END", 35, "TTSPlaybackEnd");
        TTS_PLAYBACK_END = r135;
        TriggerMode r136 = new TriggerMode("TTS_PLAYBACK_PAUSE", 36, null);
        TTS_PLAYBACK_PAUSE = r136;
        TriggerMode r137 = new TriggerMode("TTS_PLAYBACK_RESUME", 37, null);
        TTS_PLAYBACK_RESUME = r137;
        TriggerMode r138 = new TriggerMode("TTS_PLAYBACK_INTERRUPT", 38, null);
        TTS_PLAYBACK_INTERRUPT = r138;
        TriggerMode r139 = new TriggerMode("SWITCH_SCENE", 39, null);
        SWITCH_SCENE = r139;
        TriggerMode r140 = new TriggerMode("PING", 40, null);
        PING = r140;
        TriggerMode r141 = new TriggerMode("DOWNLINK_QUOTA_EXCEEDED", 41, null);
        DOWNLINK_QUOTA_EXCEEDED = r141;
        TriggerMode r142 = new TriggerMode("UPLINK_UPDATE_EXTENSION_TIME", 42, "UpdateExtensionTime");
        UPLINK_UPDATE_EXTENSION_TIME = r142;
        TriggerMode r143 = new TriggerMode("DORA_START_CONVERSATION", 43, "EnterDialogue");
        DORA_START_CONVERSATION = r143;
        TriggerMode r144 = new TriggerMode("DORA_STOP_CONVERSATION", 44, "ExitDialogue");
        DORA_STOP_CONVERSATION = r144;
        TriggerMode r145 = new TriggerMode("CLIENT_INTENT", 45, "ClientIntent");
        CLIENT_INTENT = r145;
        TriggerMode r146 = new TriggerMode("VOICE_ASSISTANT_SEND_IMAGE", 46, "SendImage");
        VOICE_ASSISTANT_SEND_IMAGE = r146;
        TriggerMode r147 = new TriggerMode("UPDATE_ROUND_CONTEXT", 47, "UpdateRoundContext");
        UPDATE_ROUND_CONTEXT = r147;
        TriggerMode r148 = new TriggerMode("WAKE_UP_REJECT", 48, null);
        WAKE_UP_REJECT = r148;
        TriggerMode r149 = new TriggerMode("WAKE_UP_SUCCESS", 49, null);
        WAKE_UP_SUCCESS = r149;
        TriggerMode r150 = new TriggerMode("CLIENT_SYNC", 50, null);
        CLIENT_SYNC = r150;
        TriggerMode[] r151 = {r100, r101, r102, r103, r104, r105, r110, r111, r112, r113, r114, r106, r107, r108, r109, r115, r116, r117, r118, r119, r120, r121, r122, r123, r124, r125, r126, r127, r128, r129, r130, r131, r132, r133, r134, r135, r136, r137, r138, r139, r140, r141, r142, r143, r144, r145, r146, r147, r148, r149, r150};
        f350727a = r151;
        f350728b = EnumEntriesKt.enumEntries(r151);
    }

    public static TriggerMode[] values() {
        return (TriggerMode[]) f350727a.clone();
    }

    public final String getEvent() {
        return this.event;
    }

    public static TriggerMode valueOf(String r100) {
        return (TriggerMode) a.a(TriggerMode.class, r100);
    }

    public TriggerMode(String r100, int r101, String r102) {
        super(r100, r101);
        this.event = r102;
    }
}
