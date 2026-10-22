package com.larus.audio.call;

import com.bytedance.android.shopping.buynow.data.model.BuyNowCloseMethod;
import com.bytedance.common.wschannel.WsConstants;
import com.bytedance.ee.bear.middleground.comment.aibot.model.AiBotPollingAuthResult;
import com.larus.voicecall.impl.subtitle.SubtitleListUpdateType;
import com.ss.ttvideoengine.ITTVideoEngineEventSource;
import com.ss.ttvideoengine.model.VideoSeekTs;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import kotlin.Metadata;
import kotlin.annotation.AnnotationRetention;

/* JADX INFO: loaded from: classes24.dex */
@Retention(RetentionPolicy.SOURCE)
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0002\b\u0002\b\u0087\u0002\u0018\u0000 \u00022\u00020\u0001:\u0001\u0002B\u0000¨\u0006\u0003"}, d2 = {"Lcom/larus/audio/call/InstanceCallState;", "", "Companion", "avkit_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
@kotlin.annotation.Retention(AnnotationRetention.SOURCE)
public @interface InstanceCallState {
    public static final int CONNECTING = 1;
    public static final a Companion = null;
    public static final int DORA_STOP = 13;
    public static final int ENDING = 18;
    public static final int INVALID = -1;
    public static final int LISTENING = 3;
    public static final int LISTEN_AND_SPEAK = 17;
    public static final int LOADING = 10;
    public static final int MUTE = 14;
    public static final int NETWORK_ERROR = 6;
    public static final int NETWORK_ERROR_RETRY_DIRECTLY = 16;
    public static final int PAUSED = 7;
    public static final int PENDING = 11;
    public static final int RESUME = 8;
    public static final int SCENE_MODE_CHANGE = 12;
    public static final int SPEAKING = 5;
    public static final int THINKING = 4;
    public static final int UNINITIALIZED = 0;
    public static final int UN_MUTE = 15;
    public static final int WAITING = 2;
    public static final int WAITING_HELLO = 9;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ a f288734a = null;

        static {
            f288734a = new a();
        }

        public a() {
        }

        public static String a(int r100) {
            switch(r100) {
                case -1: goto L21;
                case 0: goto L20;
                case 1: goto L19;
                case 2: goto L18;
                case 3: goto L17;
                case 4: goto L16;
                case 5: goto L15;
                case 6: goto L14;
                case 7: goto L13;
                case 8: goto L12;
                case 9: goto L11;
                case 10: goto L10;
                case 11: goto L9;
                case 12: goto L8;
                case 13: goto L3;
                case 14: goto L7;
                case 15: goto L6;
                case 16: goto L3;
                case 17: goto L5;
                case 18: goto L4;
                default: goto L3;
            };
        L3:
            return "unknown";
        L4:
            return VideoSeekTs.KEY_ENDING;
        L5:
            return "listen_and_speak";
        L6:
            return "un_mute";
        L7:
            return ITTVideoEngineEventSource.KEY_MUTE;
        L8:
            return SubtitleListUpdateType.SCENE_MODE_CHANGE;
        L9:
            return AiBotPollingAuthResult.STATUS_PENDING;
        L10:
            return "loading";
        L11:
            return "waiting_hello";
        L12:
            return "resume";
        L13:
            return "paused";
        L14:
            return BuyNowCloseMethod.NETWORK_ERROR;
        L15:
            return "speaking";
        L16:
            return SubtitleListUpdateType.THINKING;
        L17:
            return "listening";
        L18:
            return "waiting";
        L19:
            return WsConstants.KEY_CONNECTION;
        L20:
            return "uninitialized";
        L21:
            return "invalid";
        }
    }

    static {
        Companion = a.f288734a;
    }
}
