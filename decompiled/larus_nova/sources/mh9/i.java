package mh9;

import com.larus.kmp.voice_setting.voice.track.VoiceSettingLegacyTraceEvent;
import com.larus.kmp.voice_setting.voice.track.VoiceSettingLegacyTraceKey;
import com.larus.kmp.voice_setting.voice.track.VoiceSettingLegacyTraceValue;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes30.dex */
public final class i {

    public /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f514003a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ int[] f514004b = null;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final /* synthetic */ int[] f514005c = null;

        static {
            int[] r100 = new int[VoiceSettingLegacyTraceEvent.values().length];
            r100[VoiceSettingLegacyTraceEvent.RECOMMEND_VOICE_TTI.ordinal()] = 1;     // Catch: NoSuchFieldError -> L49
        L100:
            r100[VoiceSettingLegacyTraceEvent.HIT_PRELOAD_RECOMMEND_VOICE.ordinal()] = 2;     // Catch: NoSuchFieldError -> L50
        L114:
            r100[VoiceSettingLegacyTraceEvent.RECOMMEND_REQUEST_LOAD_TIME.ordinal()] = 3;     // Catch: NoSuchFieldError -> L51
        L122:
            r100[VoiceSettingLegacyTraceEvent.COMPLETE_DELETE_OWN_VOICE.ordinal()] = 4;     // Catch: NoSuchFieldError -> L52
        L124:
            r100[VoiceSettingLegacyTraceEvent.COMPLETE_CHANGE_OWN_VOICE_NAME.ordinal()] = 5;     // Catch: NoSuchFieldError -> L53
        L136:
            r100[VoiceSettingLegacyTraceEvent.CLICK_VOICE_SETTING.ordinal()] = 6;     // Catch: NoSuchFieldError -> L54
        L142:
            r100[VoiceSettingLegacyTraceEvent.CLICK_CHANGE_OWN_VOICE_NAME.ordinal()] = 7;     // Catch: NoSuchFieldError -> L55
        L90:
            r100[VoiceSettingLegacyTraceEvent.CLICK_DELETE_OWN_VOICE.ordinal()] = 8;     // Catch: NoSuchFieldError -> L56
        L102:
            r100[VoiceSettingLegacyTraceEvent.RECORD_OWN_VOICE_COMPLETE.ordinal()] = 9;     // Catch: NoSuchFieldError -> L57
        L106:
            r100[VoiceSettingLegacyTraceEvent.CHANGE_VOICE.ordinal()] = 10;     // Catch: NoSuchFieldError -> L58
        L22:
            f514003a = r100;
            int[] r101 = new int[VoiceSettingLegacyTraceKey.values().length];
            r101[VoiceSettingLegacyTraceKey.ENTER_FROM.ordinal()] = 1;     // Catch: NoSuchFieldError -> L59
        L134:
            r101[VoiceSettingLegacyTraceKey.TIME.ordinal()] = 2;     // Catch: NoSuchFieldError -> L60
        L140:
            r101[VoiceSettingLegacyTraceKey.RECOMMEND_TYPE.ordinal()] = 3;     // Catch: NoSuchFieldError -> L61
        L82:
            r101[VoiceSettingLegacyTraceKey.IS_MAIN_BOT.ordinal()] = 4;     // Catch: NoSuchFieldError -> L62
        L86:
            r101[VoiceSettingLegacyTraceKey.IS_HIT.ordinal()] = 5;     // Catch: NoSuchFieldError -> L63
        L96:
            r101[VoiceSettingLegacyTraceKey.REQUEST_TYPE.ordinal()] = 6;     // Catch: NoSuchFieldError -> L64
        L110:
            r101[VoiceSettingLegacyTraceKey.SUCCESS.ordinal()] = 7;     // Catch: NoSuchFieldError -> L65
        L116:
            r101[VoiceSettingLegacyTraceKey.PRELOAD.ordinal()] = 8;     // Catch: NoSuchFieldError -> L66
        L126:
            r101[VoiceSettingLegacyTraceKey.CURRENT_PAGE.ordinal()] = 9;     // Catch: NoSuchFieldError -> L67
        L132:
            r101[VoiceSettingLegacyTraceKey.VOICE_ID.ordinal()] = 10;     // Catch: NoSuchFieldError -> L68
        L144:
            r101[VoiceSettingLegacyTraceKey.ENTER_METHOD.ordinal()] = 11;     // Catch: NoSuchFieldError -> L69
        L94:
            r101[VoiceSettingLegacyTraceKey.BOT_ID.ordinal()] = 12;     // Catch: NoSuchFieldError -> L70
        L104:
            r101[VoiceSettingLegacyTraceKey.VOICE_TYPE.ordinal()] = 13;     // Catch: NoSuchFieldError -> L71
        L108:
            r101[VoiceSettingLegacyTraceKey.TO_TTS_SPEAKER.ordinal()] = 14;     // Catch: NoSuchFieldError -> L72
        L118:
            r101[VoiceSettingLegacyTraceKey.IF_AUTO.ordinal()] = 15;     // Catch: NoSuchFieldError -> L73
        L38:
            f514004b = r101;
            int[] r102 = new int[VoiceSettingLegacyTraceValue.values().length];
            r102[VoiceSettingLegacyTraceValue.TRACE_SELF_CREATE.ordinal()] = 1;     // Catch: NoSuchFieldError -> L74
        L84:
            r102[VoiceSettingLegacyTraceValue.TRACE_DEFAULT.ordinal()] = 2;     // Catch: NoSuchFieldError -> L75
        L88:
            r102[VoiceSettingLegacyTraceValue.TTS_DISABLED.ordinal()] = 3;     // Catch: NoSuchFieldError -> L76
        L98:
            r102[VoiceSettingLegacyTraceValue.STRING_0.ordinal()] = 4;     // Catch: NoSuchFieldError -> L77
        L112:
            r102[VoiceSettingLegacyTraceValue.STRING_1.ordinal()] = 5;     // Catch: NoSuchFieldError -> L78
        L120:
            r102[VoiceSettingLegacyTraceValue.VOICE_TYPE_SELF_CREATE.ordinal()] = 6;     // Catch: NoSuchFieldError -> L79
        L130:
            r102[VoiceSettingLegacyTraceValue.VOICE_TYPE_DEFAULT.ordinal()] = 7;     // Catch: NoSuchFieldError -> L80
        L138:
            r102[VoiceSettingLegacyTraceValue.PREVIOUS_PAGE_CHAT.ordinal()] = 8;     // Catch: NoSuchFieldError -> L81
        L47:
            f514005c = r102;
        }
    }

    public static final String a(VoiceSettingLegacyTraceValue r100) {
        Intrinsics.checkNotNullParameter(r100, "value");
        switch(a.f514005c[r100.ordinal()]) {
            case 1: goto L11;
            case 2: goto L12;
            case 3: goto L9;
            case 4: goto L8;
            case 5: goto L7;
            case 6: goto L11;
            case 7: goto L12;
            case 8: goto L6;
            default: goto L5;
        };
    L6:
        return "chat";
    L7:
        return "1";
    L8:
        return "0";
    L9:
        return "tts_disabled";
    L12:
        return "default";
    L5:
        throw new NoWhenBranchMatchedException();
    L11:
        return "self_create";
    }
}
