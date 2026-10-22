package com.ss.bytertc.engine.type;

import android.support.v4.media.session.PlaybackStateCompat;
import com.byted.cast.common.bean.State;
import com.bytedance.android.livesdk.chatroom.event.UserProfileEvent;
import com.ss.android.socialbase.downloader.constants.DownloadConstants;
import r27.a;

/* JADX INFO: loaded from: classes40.dex */
public final enum AudioProblemFeedback extends Enum<AudioProblemFeedback> {
    private static final /* synthetic */ AudioProblemFeedback[] $VALUES = null;
    public static final AudioProblemFeedback DISCONNECTED = null;
    public static final AudioProblemFeedback EAR_BACK_DELAY = null;
    public static final AudioProblemFeedback LOCAL_AUDIO_LAGGING = null;
    public static final AudioProblemFeedback LOCAL_AUDIO_STRENGTH = null;
    public static final AudioProblemFeedback LOCAL_ECHO = null;
    public static final AudioProblemFeedback LOCAL_NOISE = null;
    public static final AudioProblemFeedback LOCAL_NOT_SYNC = null;
    public static final AudioProblemFeedback LOCAL_NO_AUDIO = null;
    public static final AudioProblemFeedback LOCAL_NO_VIDEO = null;
    public static final AudioProblemFeedback LOCAL_VIDEO_FUZZY = null;
    public static final AudioProblemFeedback LOCAL_VIDEO_LAGGING = null;
    public static final AudioProblemFeedback NONE = null;
    public static final AudioProblemFeedback OTHER_MESSAGE = null;
    public static final AudioProblemFeedback REMOTE_AUDIO_LAGGING = null;
    public static final AudioProblemFeedback REMOTE_AUDIO_STRENGTH = null;
    public static final AudioProblemFeedback REMOTE_ECHO = null;
    public static final AudioProblemFeedback REMOTE_NOISE = null;
    public static final AudioProblemFeedback REMOTE_NOT_SYNC = null;
    public static final AudioProblemFeedback REMOTE_NO_AUDIO = null;
    public static final AudioProblemFeedback REMOTE_NO_VIDEO = null;
    public static final AudioProblemFeedback REMOTE_VIDEO_FUZZY = null;
    public static final AudioProblemFeedback REMOTE_VIDEO_LAGGING = null;
    public final long value;

    static {
        AudioProblemFeedback r100 = new AudioProblemFeedback(UserProfileEvent.POSITION_NONE, 0, 0);
        NONE = r100;
        AudioProblemFeedback r101 = new AudioProblemFeedback("OTHER_MESSAGE", 1, 1);
        OTHER_MESSAGE = r101;
        AudioProblemFeedback r102 = new AudioProblemFeedback(State.DISCONNECTED, 2, 2);
        DISCONNECTED = r102;
        AudioProblemFeedback r103 = new AudioProblemFeedback("EAR_BACK_DELAY", 3, 4);
        EAR_BACK_DELAY = r103;
        AudioProblemFeedback r104 = new AudioProblemFeedback("LOCAL_NOISE", 4, 1024);
        LOCAL_NOISE = r104;
        AudioProblemFeedback r105 = new AudioProblemFeedback("LOCAL_AUDIO_LAGGING", 5, 2048);
        LOCAL_AUDIO_LAGGING = r105;
        AudioProblemFeedback r106 = new AudioProblemFeedback("LOCAL_NO_AUDIO", 6, 4096);
        LOCAL_NO_AUDIO = r106;
        AudioProblemFeedback r110 = new AudioProblemFeedback("LOCAL_AUDIO_STRENGTH", 7, PlaybackStateCompat.ACTION_PLAY_FROM_URI);
        LOCAL_AUDIO_STRENGTH = r110;
        AudioProblemFeedback r111 = new AudioProblemFeedback("LOCAL_ECHO", 8, 16384);
        LOCAL_ECHO = r111;
        AudioProblemFeedback r112 = new AudioProblemFeedback("LOCAL_VIDEO_FUZZY", 9, 16777216);
        LOCAL_VIDEO_FUZZY = r112;
        AudioProblemFeedback r113 = new AudioProblemFeedback("LOCAL_NOT_SYNC", 10, 33554432);
        LOCAL_NOT_SYNC = r113;
        AudioProblemFeedback r107 = new AudioProblemFeedback("LOCAL_VIDEO_LAGGING", 11, 67108864);
        LOCAL_VIDEO_LAGGING = r107;
        AudioProblemFeedback r108 = new AudioProblemFeedback("LOCAL_NO_VIDEO", 12, 134217728);
        LOCAL_NO_VIDEO = r108;
        AudioProblemFeedback r109 = new AudioProblemFeedback("REMOTE_NOISE", 13, 137438953472L);
        REMOTE_NOISE = r109;
        AudioProblemFeedback r114 = new AudioProblemFeedback("REMOTE_AUDIO_LAGGING", 14, 274877906944L);
        REMOTE_AUDIO_LAGGING = r114;
        AudioProblemFeedback r115 = new AudioProblemFeedback("REMOTE_NO_AUDIO", 15, 549755813888L);
        REMOTE_NO_AUDIO = r115;
        AudioProblemFeedback r116 = new AudioProblemFeedback("REMOTE_AUDIO_STRENGTH", 16, DownloadConstants.TB);
        REMOTE_AUDIO_STRENGTH = r116;
        AudioProblemFeedback r117 = new AudioProblemFeedback("REMOTE_ECHO", 17, 2199023255552L);
        REMOTE_ECHO = r117;
        AudioProblemFeedback r118 = new AudioProblemFeedback("REMOTE_VIDEO_FUZZY", 18, 2251799813685248L);
        REMOTE_VIDEO_FUZZY = r118;
        AudioProblemFeedback r119 = new AudioProblemFeedback("REMOTE_NOT_SYNC", 19, 4503599627370496L);
        REMOTE_NOT_SYNC = r119;
        AudioProblemFeedback r120 = new AudioProblemFeedback("REMOTE_VIDEO_LAGGING", 20, 9007199254740992L);
        REMOTE_VIDEO_LAGGING = r120;
        AudioProblemFeedback r121 = new AudioProblemFeedback("REMOTE_NO_VIDEO", 21, 18014398509481984L);
        REMOTE_NO_VIDEO = r121;
        $VALUES = new AudioProblemFeedback[]{r100, r101, r102, r103, r104, r105, r106, r110, r111, r112, r113, r107, r108, r109, r114, r115, r116, r117, r118, r119, r120, r121};
    }

    public static AudioProblemFeedback[] values() {
        return (AudioProblemFeedback[]) $VALUES.clone();
    }

    public static AudioProblemFeedback fromId(int r100) {
        AudioProblemFeedback[] r101 = values();
        int r102 = r101.length;
        int r103 = 0;
    L3:
        if (r103 >= r102) goto L9;
        AudioProblemFeedback r104 = r101[r103];
        if (r104.value == r100) goto L6;
        r103 = r103 + 1;
        goto L3
    L6:
        return r104;
    L9:
        return NONE;
    }

    public static AudioProblemFeedback valueOf(String r100) {
        return (AudioProblemFeedback) a.a(AudioProblemFeedback.class, r100);
    }

    private AudioProblemFeedback(String r100, int r101, long r102) {
        super(r100, r101);
        this.value = r102;
    }
}
