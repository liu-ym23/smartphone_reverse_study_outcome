package ke9;

import com.larus.im.service.audio.ModalType;
import com.larus.im.service.audio.cmd.TargetVideoSourceType;
import com.larus.im.service.audio.cmd.TriggerMode;

/* JADX INFO: loaded from: classes30.dex */
public final /* synthetic */ class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int[] f503121a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ int[] f503122b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final /* synthetic */ int[] f503123c = null;

    static {
        int[] r100 = new int[ModalType.values().length];
        r100[ModalType.NONE.ordinal()] = 1;     // Catch: NoSuchFieldError -> L66
    L145:
        r100[ModalType.AUDIO.ordinal()] = 2;     // Catch: NoSuchFieldError -> L67
    L153:
        r100[ModalType.VIDEO.ordinal()] = 3;     // Catch: NoSuchFieldError -> L68
    L8:
        f503121a = r100;
        int[] r101 = new int[TargetVideoSourceType.values().length];
        r101[TargetVideoSourceType.VIDEO_SOURCE_DEFAULT.ordinal()] = 1;     // Catch: NoSuchFieldError -> L69
    L177:
        r101[TargetVideoSourceType.VIDEO_SOURCE_CAMERA.ordinal()] = 2;     // Catch: NoSuchFieldError -> L70
    L185:
        r101[TargetVideoSourceType.VIDEO_SOURCE_SCREEN.ordinal()] = 3;     // Catch: NoSuchFieldError -> L71
    L12:
        f503122b = r101;
        int[] r102 = new int[TriggerMode.values().length];
        r102[TriggerMode.UNUSED.ordinal()] = 1;     // Catch: NoSuchFieldError -> L72
    L199:
        r102[TriggerMode.END_ASR.ordinal()] = 2;     // Catch: NoSuchFieldError -> L73
    L207:
        r102[TriggerMode.MUTE.ordinal()] = 3;     // Catch: NoSuchFieldError -> L74
    L215:
        r102[TriggerMode.UNMUTE.ordinal()] = 4;     // Catch: NoSuchFieldError -> L75
    L221:
        r102[TriggerMode.INTERRUPT.ordinal()] = 5;     // Catch: NoSuchFieldError -> L76
    L225:
        r102[TriggerMode.PAUSE.ordinal()] = 6;     // Catch: NoSuchFieldError -> L77
    L127:
        r102[TriggerMode.CONTINUE.ordinal()] = 7;     // Catch: NoSuchFieldError -> L78
    L137:
        r102[TriggerMode.HELLO.ordinal()] = 8;     // Catch: NoSuchFieldError -> L79
    L139:
        r102[TriggerMode.HELLO_NEW.ordinal()] = 9;     // Catch: NoSuchFieldError -> L80
    L147:
        r102[TriggerMode.WAIT.ordinal()] = 10;     // Catch: NoSuchFieldError -> L81
    L165:
        r102[TriggerMode.HANGUP.ordinal()] = 11;     // Catch: NoSuchFieldError -> L82
    L175:
        r102[TriggerMode.AUTH_DENY.ordinal()] = 12;     // Catch: NoSuchFieldError -> L83
    L179:
        r102[TriggerMode.AUTH_SUCCESS.ordinal()] = 13;     // Catch: NoSuchFieldError -> L84
    L187:
        r102[TriggerMode.AUTH_FAILED.ordinal()] = 14;     // Catch: NoSuchFieldError -> L85
    L201:
        r102[TriggerMode.ONBOARDING_START.ordinal()] = 15;     // Catch: NoSuchFieldError -> L86
    L211:
        r102[TriggerMode.CONTINUE_TYPE.ordinal()] = 16;     // Catch: NoSuchFieldError -> L87
    L213:
        r102[TriggerMode.ANCS_SUMMARY.ordinal()] = 17;     // Catch: NoSuchFieldError -> L88
    L219:
        r102[TriggerMode.IMAGE.ordinal()] = 18;     // Catch: NoSuchFieldError -> L89
    L233:
        r102[TriggerMode.INTERVIEW_IMAGE.ordinal()] = 19;     // Catch: NoSuchFieldError -> L90
    L129:
        r102[TriggerMode.SUGGEST.ordinal()] = 20;     // Catch: NoSuchFieldError -> L91
    L131:
        r102[TriggerMode.UPDATE_UI_CONTEXT.ordinal()] = 21;     // Catch: NoSuchFieldError -> L92
    L141:
        r102[TriggerMode.CLIM_IN_STARTED.ordinal()] = 22;     // Catch: NoSuchFieldError -> L93
    L157:
        r102[TriggerMode.CLIM_IN_END.ordinal()] = 23;     // Catch: NoSuchFieldError -> L94
    L167:
        r102[TriggerMode.INTERPRET_ASR_STARTED.ordinal()] = 24;     // Catch: NoSuchFieldError -> L95
    L171:
        r102[TriggerMode.AUDIO_ROUND_TRACE.ordinal()] = 25;     // Catch: NoSuchFieldError -> L96
    L181:
        r102[TriggerMode.TTS_PLAYBACK_START.ordinal()] = 26;     // Catch: NoSuchFieldError -> L97
    L193:
        r102[TriggerMode.TTS_PLAYBACK_END.ordinal()] = 27;     // Catch: NoSuchFieldError -> L98
    L203:
        r102[TriggerMode.CHAT_REQUEST.ordinal()] = 28;     // Catch: NoSuchFieldError -> L99
    L205:
        r102[TriggerMode.SWITCH_SCENE.ordinal()] = 29;     // Catch: NoSuchFieldError -> L100
    L217:
        r102[TriggerMode.PING.ordinal()] = 30;     // Catch: NoSuchFieldError -> L101
    L227:
        r102[TriggerMode.UPLINK_HANGUP.ordinal()] = 31;     // Catch: NoSuchFieldError -> L102
    L235:
        r102[TriggerMode.UPLINK_UPDATE_EXTENSION_TIME.ordinal()] = 32;     // Catch: NoSuchFieldError -> L103
    L123:
        r102[TriggerMode.SPEECH_STARTED.ordinal()] = 33;     // Catch: NoSuchFieldError -> L104
    L133:
        r102[TriggerMode.SPEECH_ENDED.ordinal()] = 34;     // Catch: NoSuchFieldError -> L105
    L149:
        r102[TriggerMode.TTS_PLAYBACK_PAUSE.ordinal()] = 35;     // Catch: NoSuchFieldError -> L106
    L159:
        r102[TriggerMode.TTS_PLAYBACK_RESUME.ordinal()] = 36;     // Catch: NoSuchFieldError -> L107
    L161:
        r102[TriggerMode.TTS_PLAYBACK_INTERRUPT.ordinal()] = 37;     // Catch: NoSuchFieldError -> L108
    L173:
        r102[TriggerMode.CLIENT_SUMMON_NOTICE.ordinal()] = 38;     // Catch: NoSuchFieldError -> L109
    L189:
        r102[TriggerMode.FULL_TEXT_QUERY.ordinal()] = 39;     // Catch: NoSuchFieldError -> L110
    L195:
        r102[TriggerMode.DOWNLINK_QUOTA_EXCEEDED.ordinal()] = 40;     // Catch: NoSuchFieldError -> L111
    L197:
        r102[TriggerMode.DORA_E_BOT_ACTIVE.ordinal()] = 41;     // Catch: NoSuchFieldError -> L112
    L209:
        r102[TriggerMode.CLIENT_INTENT.ordinal()] = 42;     // Catch: NoSuchFieldError -> L113
    L223:
        r102[TriggerMode.QUERY_WHEN_SILENCE.ordinal()] = 43;     // Catch: NoSuchFieldError -> L114
    L229:
        r102[TriggerMode.DORA_START_CONVERSATION.ordinal()] = 44;     // Catch: NoSuchFieldError -> L115
    L231:
        r102[TriggerMode.DORA_STOP_CONVERSATION.ordinal()] = 45;     // Catch: NoSuchFieldError -> L116
    L125:
        r102[TriggerMode.VOICE_ASSISTANT_SEND_IMAGE.ordinal()] = 46;     // Catch: NoSuchFieldError -> L117
    L143:
        r102[TriggerMode.WAKE_UP_REJECT.ordinal()] = 47;     // Catch: NoSuchFieldError -> L118
    L151:
        r102[TriggerMode.WAKE_UP_SUCCESS.ordinal()] = 48;     // Catch: NoSuchFieldError -> L119
    L155:
        r102[TriggerMode.CLIENT_SYNC.ordinal()] = 49;     // Catch: NoSuchFieldError -> L120
    L163:
        r102[TriggerMode.UPDATE_PERSONAL_CONTEXT.ordinal()] = 50;     // Catch: NoSuchFieldError -> L121
    L183:
        r102[TriggerMode.UPDATE_ROUND_CONTEXT.ordinal()] = 51;     // Catch: NoSuchFieldError -> L122
    L64:
        f503123c = r102;
    }
}
