package com.ss.bytertc.engine.data;

import com.ss.ttm.player.MediaPlayer;
import r27.a;

/* JADX INFO: loaded from: classes40.dex */
public final enum WTNSubscribeStateChangeReason extends Enum<WTNSubscribeStateChangeReason> {
    private static final /* synthetic */ WTNSubscribeStateChangeReason[] $VALUES = null;
    public static final WTNSubscribeStateChangeReason OVER_CLIENT_SUBSCRIBE_STREAM_LIMIT = null;
    public static final WTNSubscribeStateChangeReason OVER_STREAM_SUBSCRIBE_REQUEST_LIMIT = null;
    public static final WTNSubscribeStateChangeReason OVER_STREAM_SUBSCRIBE_USER_LIMIT = null;
    public static final WTNSubscribeStateChangeReason REMOTE_UNPUBLISH = null;
    public static final WTNSubscribeStateChangeReason SUBSCRIBE = null;
    public static final WTNSubscribeStateChangeReason UNSUBSCRIBE = null;
    private int value;

    /* JADX INFO: renamed from: com.ss.bytertc.engine.data.WTNSubscribeStateChangeReason$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$ss$bytertc$engine$data$WTNSubscribeStateChangeReason = null;

        static {
            int[] r100 = new int[WTNSubscribeStateChangeReason.values().length];
            $SwitchMap$com$ss$bytertc$engine$data$WTNSubscribeStateChangeReason = r100;
            r100[WTNSubscribeStateChangeReason.SUBSCRIBE.ordinal()] = 1;     // Catch: NoSuchFieldError -> L10
        L16:
            $SwitchMap$com$ss$bytertc$engine$data$WTNSubscribeStateChangeReason[WTNSubscribeStateChangeReason.UNSUBSCRIBE.ordinal()] = 2;     // Catch: NoSuchFieldError -> L11
        L20:
            $SwitchMap$com$ss$bytertc$engine$data$WTNSubscribeStateChangeReason[WTNSubscribeStateChangeReason.REMOTE_UNPUBLISH.ordinal()] = 3;     // Catch: NoSuchFieldError -> L12
        L26:
            $SwitchMap$com$ss$bytertc$engine$data$WTNSubscribeStateChangeReason[WTNSubscribeStateChangeReason.OVER_CLIENT_SUBSCRIBE_STREAM_LIMIT.ordinal()] = 4;     // Catch: NoSuchFieldError -> L13
        L18:
            $SwitchMap$com$ss$bytertc$engine$data$WTNSubscribeStateChangeReason[WTNSubscribeStateChangeReason.OVER_STREAM_SUBSCRIBE_USER_LIMIT.ordinal()] = 5;     // Catch: NoSuchFieldError -> L14
        L22:
            $SwitchMap$com$ss$bytertc$engine$data$WTNSubscribeStateChangeReason[WTNSubscribeStateChangeReason.OVER_STREAM_SUBSCRIBE_REQUEST_LIMIT.ordinal()] = 6;     // Catch: NoSuchFieldError -> L15
            return;
        }
    }

    static {
        WTNSubscribeStateChangeReason r100 = new WTNSubscribeStateChangeReason("SUBSCRIBE", 0, 0);
        SUBSCRIBE = r100;
        WTNSubscribeStateChangeReason r101 = new WTNSubscribeStateChangeReason("UNSUBSCRIBE", 1, 1300);
        UNSUBSCRIBE = r101;
        WTNSubscribeStateChangeReason r102 = new WTNSubscribeStateChangeReason("REMOTE_UNPUBLISH", 2, 1301);
        REMOTE_UNPUBLISH = r102;
        WTNSubscribeStateChangeReason r103 = new WTNSubscribeStateChangeReason("OVER_CLIENT_SUBSCRIBE_STREAM_LIMIT", 3, MediaPlayer.MEDIA_PLAYER_OPTION_AUTO_DISCONNECTED_CPU);
        OVER_CLIENT_SUBSCRIBE_STREAM_LIMIT = r103;
        WTNSubscribeStateChangeReason r104 = new WTNSubscribeStateChangeReason("OVER_STREAM_SUBSCRIBE_USER_LIMIT", 4, MediaPlayer.MEDIA_PLAYER_OPTION_CALIBRATION_AUDIO_TYPE);
        OVER_STREAM_SUBSCRIBE_USER_LIMIT = r104;
        WTNSubscribeStateChangeReason r105 = new WTNSubscribeStateChangeReason("OVER_STREAM_SUBSCRIBE_REQUEST_LIMIT", 5, MediaPlayer.MEDIA_PLAYER_OPTION_FORMATER_REC_BUFFER_THRESH);
        OVER_STREAM_SUBSCRIBE_REQUEST_LIMIT = r105;
        $VALUES = new WTNSubscribeStateChangeReason[]{r100, r101, r102, r103, r104, r105};
    }

    public static WTNSubscribeStateChangeReason[] values() {
        return (WTNSubscribeStateChangeReason[]) $VALUES.clone();
    }

    @Override // java.lang.Enum
    public String toString() {
        switch(AnonymousClass1.$SwitchMap$com$ss$bytertc$engine$data$WTNSubscribeStateChangeReason[ordinal()]) {
            case 1: goto L10;
            case 2: goto L9;
            case 3: goto L8;
            case 4: goto L7;
            case 5: goto L6;
            case 6: goto L5;
            default: goto L4;
        };
    L4:
        return "";
    L5:
        return "kWTNSubscribeStateChangeReasonOverStreamSubscribeRequestLimit";
    L6:
        return "kWTNSubscribeStateChangeReasonOverStreamSubscribeUserLimit";
    L7:
        return "kWTNSubscribeStateChangeReasonOverClientSubscribeStreamLimit";
    L8:
        return "kWTNSubscribeStateChangeReasonRemoteUnpublish";
    L9:
        return "kWTNSubscribeStateChangeReasonUnsubscribe";
    L10:
        return "kWTNSubscribeStateChangeReasonSubscribe";
    }

    public int value() {
        return this.value;
    }

    public static WTNSubscribeStateChangeReason fromId(int r100) {
        WTNSubscribeStateChangeReason[] r101 = values();
        int r102 = r101.length;
        int r103 = 0;
    L3:
        if (r103 >= r102) goto L8;
        WTNSubscribeStateChangeReason r104 = r101[r103];
        if (r104.value() == r100) goto L6;
        r103 = r103 + 1;
        goto L3
    L6:
        return r104;
    L8:
        return null;
    }

    public static WTNSubscribeStateChangeReason valueOf(String r100) {
        return (WTNSubscribeStateChangeReason) a.a(WTNSubscribeStateChangeReason.class, r100);
    }

    private WTNSubscribeStateChangeReason(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}
