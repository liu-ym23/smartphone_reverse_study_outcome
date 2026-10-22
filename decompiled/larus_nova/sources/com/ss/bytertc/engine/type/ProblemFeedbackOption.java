package com.ss.bytertc.engine.type;

import android.support.v4.media.session.PlaybackStateCompat;
import com.byted.cast.common.bean.State;
import com.bytedance.android.livesdk.chatroom.event.UserProfileEvent;
import com.ss.android.socialbase.downloader.constants.DownloadConstants;
import r27.a;

/* JADX INFO: loaded from: classes40.dex */
public final enum ProblemFeedbackOption extends Enum<ProblemFeedbackOption> {
    private static final /* synthetic */ ProblemFeedbackOption[] $VALUES = null;
    public static final ProblemFeedbackOption DISCONNECTED = null;
    public static final ProblemFeedbackOption EAR_BACK_DELAY = null;
    public static final ProblemFeedbackOption LOCAL_AUDIO_LAGGING = null;
    public static final ProblemFeedbackOption LOCAL_AUDIO_STRENGTH = null;
    public static final ProblemFeedbackOption LOCAL_ECHO = null;
    public static final ProblemFeedbackOption LOCAL_NOISE = null;
    public static final ProblemFeedbackOption LOCAL_NOT_SYNC = null;
    public static final ProblemFeedbackOption LOCAL_NO_AUDIO = null;
    public static final ProblemFeedbackOption LOCAL_NO_VIDEO = null;
    public static final ProblemFeedbackOption LOCAL_VIDEO_FUZZY = null;
    public static final ProblemFeedbackOption LOCAL_VIDEO_LAGGING = null;
    public static final ProblemFeedbackOption NONE = null;
    public static final ProblemFeedbackOption OTHER_MESSAGE = null;
    public static final ProblemFeedbackOption REMOTE_AUDIO_LAGGING = null;
    public static final ProblemFeedbackOption REMOTE_AUDIO_STRENGTH = null;
    public static final ProblemFeedbackOption REMOTE_ECHO = null;
    public static final ProblemFeedbackOption REMOTE_NOISE = null;
    public static final ProblemFeedbackOption REMOTE_NOT_SYNC = null;
    public static final ProblemFeedbackOption REMOTE_NO_AUDIO = null;
    public static final ProblemFeedbackOption REMOTE_NO_VIDEO = null;
    public static final ProblemFeedbackOption REMOTE_VIDEO_FUZZY = null;
    public static final ProblemFeedbackOption REMOTE_VIDEO_LAGGING = null;
    public final long value;

    static {
        ProblemFeedbackOption r100 = new ProblemFeedbackOption(UserProfileEvent.POSITION_NONE, 0, 0);
        NONE = r100;
        ProblemFeedbackOption r101 = new ProblemFeedbackOption("OTHER_MESSAGE", 1, 1);
        OTHER_MESSAGE = r101;
        ProblemFeedbackOption r102 = new ProblemFeedbackOption(State.DISCONNECTED, 2, 2);
        DISCONNECTED = r102;
        ProblemFeedbackOption r103 = new ProblemFeedbackOption("EAR_BACK_DELAY", 3, 4);
        EAR_BACK_DELAY = r103;
        ProblemFeedbackOption r104 = new ProblemFeedbackOption("LOCAL_NOISE", 4, 1024);
        LOCAL_NOISE = r104;
        ProblemFeedbackOption r105 = new ProblemFeedbackOption("LOCAL_AUDIO_LAGGING", 5, 2048);
        LOCAL_AUDIO_LAGGING = r105;
        ProblemFeedbackOption r106 = new ProblemFeedbackOption("LOCAL_NO_AUDIO", 6, 4096);
        LOCAL_NO_AUDIO = r106;
        ProblemFeedbackOption r110 = new ProblemFeedbackOption("LOCAL_AUDIO_STRENGTH", 7, PlaybackStateCompat.ACTION_PLAY_FROM_URI);
        LOCAL_AUDIO_STRENGTH = r110;
        ProblemFeedbackOption r111 = new ProblemFeedbackOption("LOCAL_ECHO", 8, 16384);
        LOCAL_ECHO = r111;
        ProblemFeedbackOption r112 = new ProblemFeedbackOption("LOCAL_VIDEO_FUZZY", 9, 16777216);
        LOCAL_VIDEO_FUZZY = r112;
        ProblemFeedbackOption r113 = new ProblemFeedbackOption("LOCAL_NOT_SYNC", 10, 33554432);
        LOCAL_NOT_SYNC = r113;
        ProblemFeedbackOption r107 = new ProblemFeedbackOption("LOCAL_VIDEO_LAGGING", 11, 67108864);
        LOCAL_VIDEO_LAGGING = r107;
        ProblemFeedbackOption r108 = new ProblemFeedbackOption("LOCAL_NO_VIDEO", 12, 134217728);
        LOCAL_NO_VIDEO = r108;
        ProblemFeedbackOption r109 = new ProblemFeedbackOption("REMOTE_NOISE", 13, 137438953472L);
        REMOTE_NOISE = r109;
        ProblemFeedbackOption r114 = new ProblemFeedbackOption("REMOTE_AUDIO_LAGGING", 14, 274877906944L);
        REMOTE_AUDIO_LAGGING = r114;
        ProblemFeedbackOption r115 = new ProblemFeedbackOption("REMOTE_NO_AUDIO", 15, 549755813888L);
        REMOTE_NO_AUDIO = r115;
        ProblemFeedbackOption r116 = new ProblemFeedbackOption("REMOTE_AUDIO_STRENGTH", 16, DownloadConstants.TB);
        REMOTE_AUDIO_STRENGTH = r116;
        ProblemFeedbackOption r117 = new ProblemFeedbackOption("REMOTE_ECHO", 17, 2199023255552L);
        REMOTE_ECHO = r117;
        ProblemFeedbackOption r118 = new ProblemFeedbackOption("REMOTE_VIDEO_FUZZY", 18, 2251799813685248L);
        REMOTE_VIDEO_FUZZY = r118;
        ProblemFeedbackOption r119 = new ProblemFeedbackOption("REMOTE_NOT_SYNC", 19, 4503599627370496L);
        REMOTE_NOT_SYNC = r119;
        ProblemFeedbackOption r120 = new ProblemFeedbackOption("REMOTE_VIDEO_LAGGING", 20, 9007199254740992L);
        REMOTE_VIDEO_LAGGING = r120;
        ProblemFeedbackOption r121 = new ProblemFeedbackOption("REMOTE_NO_VIDEO", 21, 18014398509481984L);
        REMOTE_NO_VIDEO = r121;
        $VALUES = new ProblemFeedbackOption[]{r100, r101, r102, r103, r104, r105, r106, r110, r111, r112, r113, r107, r108, r109, r114, r115, r116, r117, r118, r119, r120, r121};
    }

    public static ProblemFeedbackOption[] values() {
        return (ProblemFeedbackOption[]) $VALUES.clone();
    }

    public static ProblemFeedbackOption fromId(long r100) {
        ProblemFeedbackOption[] r101 = values();
        int r102 = r101.length;
        int r103 = 0;
    L3:
        if (r103 >= r102) goto L8;
        ProblemFeedbackOption r104 = r101[r103];
        if (r104.value == r100) goto L6;
        r103 = r103 + 1;
        goto L3
    L6:
        return r104;
    L8:
        return null;
    }

    public static ProblemFeedbackOption valueOf(String r100) {
        return (ProblemFeedbackOption) a.a(ProblemFeedbackOption.class, r100);
    }

    private ProblemFeedbackOption(String r100, int r101, long r102) {
        super(r100, r101);
        this.value = r102;
    }
}
