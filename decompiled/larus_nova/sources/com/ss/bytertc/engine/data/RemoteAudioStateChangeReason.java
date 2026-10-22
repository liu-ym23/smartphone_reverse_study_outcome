package com.ss.bytertc.engine.data;

import r27.a;

/* JADX INFO: loaded from: classes40.dex */
public final enum RemoteAudioStateChangeReason extends Enum<RemoteAudioStateChangeReason> {
    private static final /* synthetic */ RemoteAudioStateChangeReason[] $VALUES = null;
    public static final RemoteAudioStateChangeReason REMOTE_AUDIO_STATE_CHANGE_REASON_INTERNAL = null;
    public static final RemoteAudioStateChangeReason REMOTE_AUDIO_STATE_CHANGE_REASON_LOCAL_MUTED = null;
    public static final RemoteAudioStateChangeReason REMOTE_AUDIO_STATE_CHANGE_REASON_LOCAL_UNMUTED = null;
    public static final RemoteAudioStateChangeReason REMOTE_AUDIO_STATE_CHANGE_REASON_NETWORK_CONGESTION = null;
    public static final RemoteAudioStateChangeReason REMOTE_AUDIO_STATE_CHANGE_REASON_NETWORK_RECOVERY = null;
    public static final RemoteAudioStateChangeReason REMOTE_AUDIO_STATE_CHANGE_REASON_REMOTE_MUTED = null;
    public static final RemoteAudioStateChangeReason REMOTE_AUDIO_STATE_CHANGE_REASON_REMOTE_OFFLINE = null;
    public static final RemoteAudioStateChangeReason REMOTE_AUDIO_STATE_CHANGE_REASON_REMOTE_UNMUTED = null;
    private int value;

    /* JADX INFO: renamed from: com.ss.bytertc.engine.data.RemoteAudioStateChangeReason$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$ss$bytertc$engine$data$RemoteAudioStateChangeReason = null;

        static {
            int[] r100 = new int[RemoteAudioStateChangeReason.values().length];
            $SwitchMap$com$ss$bytertc$engine$data$RemoteAudioStateChangeReason = r100;
            r100[RemoteAudioStateChangeReason.REMOTE_AUDIO_STATE_CHANGE_REASON_INTERNAL.ordinal()] = 1;     // Catch: NoSuchFieldError -> L12
        L20:
            $SwitchMap$com$ss$bytertc$engine$data$RemoteAudioStateChangeReason[RemoteAudioStateChangeReason.REMOTE_AUDIO_STATE_CHANGE_REASON_NETWORK_CONGESTION.ordinal()] = 2;     // Catch: NoSuchFieldError -> L13
        L24:
            $SwitchMap$com$ss$bytertc$engine$data$RemoteAudioStateChangeReason[RemoteAudioStateChangeReason.REMOTE_AUDIO_STATE_CHANGE_REASON_NETWORK_RECOVERY.ordinal()] = 3;     // Catch: NoSuchFieldError -> L14
        L34:
            $SwitchMap$com$ss$bytertc$engine$data$RemoteAudioStateChangeReason[RemoteAudioStateChangeReason.REMOTE_AUDIO_STATE_CHANGE_REASON_LOCAL_MUTED.ordinal()] = 4;     // Catch: NoSuchFieldError -> L15
        L22:
            $SwitchMap$com$ss$bytertc$engine$data$RemoteAudioStateChangeReason[RemoteAudioStateChangeReason.REMOTE_AUDIO_STATE_CHANGE_REASON_LOCAL_UNMUTED.ordinal()] = 5;     // Catch: NoSuchFieldError -> L16
        L26:
            $SwitchMap$com$ss$bytertc$engine$data$RemoteAudioStateChangeReason[RemoteAudioStateChangeReason.REMOTE_AUDIO_STATE_CHANGE_REASON_REMOTE_MUTED.ordinal()] = 6;     // Catch: NoSuchFieldError -> L17
        L28:
            $SwitchMap$com$ss$bytertc$engine$data$RemoteAudioStateChangeReason[RemoteAudioStateChangeReason.REMOTE_AUDIO_STATE_CHANGE_REASON_REMOTE_UNMUTED.ordinal()] = 7;     // Catch: NoSuchFieldError -> L18
        L30:
            $SwitchMap$com$ss$bytertc$engine$data$RemoteAudioStateChangeReason[RemoteAudioStateChangeReason.REMOTE_AUDIO_STATE_CHANGE_REASON_REMOTE_OFFLINE.ordinal()] = 8;     // Catch: NoSuchFieldError -> L19
            return;
        }
    }

    static {
        RemoteAudioStateChangeReason r100 = new RemoteAudioStateChangeReason("REMOTE_AUDIO_STATE_CHANGE_REASON_INTERNAL", 0, 0);
        REMOTE_AUDIO_STATE_CHANGE_REASON_INTERNAL = r100;
        RemoteAudioStateChangeReason r101 = new RemoteAudioStateChangeReason("REMOTE_AUDIO_STATE_CHANGE_REASON_NETWORK_CONGESTION", 1, 1);
        REMOTE_AUDIO_STATE_CHANGE_REASON_NETWORK_CONGESTION = r101;
        RemoteAudioStateChangeReason r102 = new RemoteAudioStateChangeReason("REMOTE_AUDIO_STATE_CHANGE_REASON_NETWORK_RECOVERY", 2, 2);
        REMOTE_AUDIO_STATE_CHANGE_REASON_NETWORK_RECOVERY = r102;
        RemoteAudioStateChangeReason r103 = new RemoteAudioStateChangeReason("REMOTE_AUDIO_STATE_CHANGE_REASON_LOCAL_MUTED", 3, 3);
        REMOTE_AUDIO_STATE_CHANGE_REASON_LOCAL_MUTED = r103;
        RemoteAudioStateChangeReason r104 = new RemoteAudioStateChangeReason("REMOTE_AUDIO_STATE_CHANGE_REASON_LOCAL_UNMUTED", 4, 4);
        REMOTE_AUDIO_STATE_CHANGE_REASON_LOCAL_UNMUTED = r104;
        RemoteAudioStateChangeReason r105 = new RemoteAudioStateChangeReason("REMOTE_AUDIO_STATE_CHANGE_REASON_REMOTE_MUTED", 5, 5);
        REMOTE_AUDIO_STATE_CHANGE_REASON_REMOTE_MUTED = r105;
        RemoteAudioStateChangeReason r110 = new RemoteAudioStateChangeReason("REMOTE_AUDIO_STATE_CHANGE_REASON_REMOTE_UNMUTED", 6, 6);
        REMOTE_AUDIO_STATE_CHANGE_REASON_REMOTE_UNMUTED = r110;
        RemoteAudioStateChangeReason r111 = new RemoteAudioStateChangeReason("REMOTE_AUDIO_STATE_CHANGE_REASON_REMOTE_OFFLINE", 7, 7);
        REMOTE_AUDIO_STATE_CHANGE_REASON_REMOTE_OFFLINE = r111;
        $VALUES = new RemoteAudioStateChangeReason[]{r100, r101, r102, r103, r104, r105, r110, r111};
    }

    public static RemoteAudioStateChangeReason[] values() {
        return (RemoteAudioStateChangeReason[]) $VALUES.clone();
    }

    @Override // java.lang.Enum
    public String toString() {
        switch(AnonymousClass1.$SwitchMap$com$ss$bytertc$engine$data$RemoteAudioStateChangeReason[ordinal()]) {
            case 1: goto L12;
            case 2: goto L11;
            case 3: goto L10;
            case 4: goto L9;
            case 5: goto L8;
            case 6: goto L7;
            case 7: goto L6;
            case 8: goto L5;
            default: goto L4;
        };
    L4:
        return "";
    L5:
        return "kRemoteAudioReasonRemoteOffline";
    L6:
        return "kRemoteAudioReasonRemoteUnmuted";
    L7:
        return "kRemoteAudioReasonRemoteMuted";
    L8:
        return "kRemoteAudioReasonLocalUnmuted";
    L9:
        return "kRemoteAudioReasonLocalMuted";
    L10:
        return "kRemoteAudioReasonNetworkRecovery";
    L11:
        return "kRemoteAudioReasonNetworkCongestion";
    L12:
        return "kRemoteAudioReasonInternal";
    }

    public int value() {
        return this.value;
    }

    public static RemoteAudioStateChangeReason fromId(int r100) {
        RemoteAudioStateChangeReason[] r101 = values();
        int r102 = r101.length;
        int r103 = 0;
    L3:
        if (r103 >= r102) goto L8;
        RemoteAudioStateChangeReason r104 = r101[r103];
        if (r104.value() == r100) goto L6;
        r103 = r103 + 1;
        goto L3
    L6:
        return r104;
    L8:
        return null;
    }

    public static RemoteAudioStateChangeReason valueOf(String r100) {
        return (RemoteAudioStateChangeReason) a.a(RemoteAudioStateChangeReason.class, r100);
    }

    private RemoteAudioStateChangeReason(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}
