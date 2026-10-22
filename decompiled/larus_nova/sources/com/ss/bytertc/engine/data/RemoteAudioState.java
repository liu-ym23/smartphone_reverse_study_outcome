package com.ss.bytertc.engine.data;

import r27.a;

/* JADX INFO: loaded from: classes40.dex */
public final enum RemoteAudioState extends Enum<RemoteAudioState> {
    private static final /* synthetic */ RemoteAudioState[] $VALUES = null;
    public static final RemoteAudioState REMOTE_AUDIO_STATE_DECODING = null;
    public static final RemoteAudioState REMOTE_AUDIO_STATE_FAILED = null;
    public static final RemoteAudioState REMOTE_AUDIO_STATE_FROZEN = null;
    public static final RemoteAudioState REMOTE_AUDIO_STATE_STARTING = null;
    public static final RemoteAudioState REMOTE_AUDIO_STATE_STOPPED = null;
    private int value;

    /* JADX INFO: renamed from: com.ss.bytertc.engine.data.RemoteAudioState$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$ss$bytertc$engine$data$RemoteAudioState = null;

        static {
            int[] r100 = new int[RemoteAudioState.values().length];
            $SwitchMap$com$ss$bytertc$engine$data$RemoteAudioState = r100;
            r100[RemoteAudioState.REMOTE_AUDIO_STATE_STOPPED.ordinal()] = 1;     // Catch: NoSuchFieldError -> L9
        L14:
            $SwitchMap$com$ss$bytertc$engine$data$RemoteAudioState[RemoteAudioState.REMOTE_AUDIO_STATE_STARTING.ordinal()] = 2;     // Catch: NoSuchFieldError -> L10
        L18:
            $SwitchMap$com$ss$bytertc$engine$data$RemoteAudioState[RemoteAudioState.REMOTE_AUDIO_STATE_DECODING.ordinal()] = 3;     // Catch: NoSuchFieldError -> L11
        L22:
            $SwitchMap$com$ss$bytertc$engine$data$RemoteAudioState[RemoteAudioState.REMOTE_AUDIO_STATE_FROZEN.ordinal()] = 4;     // Catch: NoSuchFieldError -> L12
        L16:
            $SwitchMap$com$ss$bytertc$engine$data$RemoteAudioState[RemoteAudioState.REMOTE_AUDIO_STATE_FAILED.ordinal()] = 5;     // Catch: NoSuchFieldError -> L13
            return;
        }
    }

    static {
        RemoteAudioState r100 = new RemoteAudioState("REMOTE_AUDIO_STATE_STOPPED", 0, 0);
        REMOTE_AUDIO_STATE_STOPPED = r100;
        RemoteAudioState r101 = new RemoteAudioState("REMOTE_AUDIO_STATE_STARTING", 1, 1);
        REMOTE_AUDIO_STATE_STARTING = r101;
        RemoteAudioState r102 = new RemoteAudioState("REMOTE_AUDIO_STATE_DECODING", 2, 2);
        REMOTE_AUDIO_STATE_DECODING = r102;
        RemoteAudioState r103 = new RemoteAudioState("REMOTE_AUDIO_STATE_FROZEN", 3, 3);
        REMOTE_AUDIO_STATE_FROZEN = r103;
        RemoteAudioState r104 = new RemoteAudioState("REMOTE_AUDIO_STATE_FAILED", 4, 4);
        REMOTE_AUDIO_STATE_FAILED = r104;
        $VALUES = new RemoteAudioState[]{r100, r101, r102, r103, r104};
    }

    public static RemoteAudioState[] values() {
        return (RemoteAudioState[]) $VALUES.clone();
    }

    @Override // java.lang.Enum
    public String toString() {
        int r100 = AnonymousClass1.$SwitchMap$com$ss$bytertc$engine$data$RemoteAudioState[ordinal()];
        if (r100 != 1) goto L5;
        return "kRemoteAudioStateStopped";
    L5:
        if (r100 != 2) goto L7;
        return "kRemoteAudioStateStarting";
    L7:
        if (r100 != 3) goto L9;
        return "kRemoteAudioStateDecoding";
    L9:
        if (r100 != 4) goto L11;
        return "kRemoteAudioStateFrozen";
    L11:
        if (r100 == 5) goto L13;
        return "";
    L13:
        return "kRemoteAudioStateFailed";
    }

    public int value() {
        return this.value;
    }

    public static RemoteAudioState fromId(int r100) {
        RemoteAudioState[] r101 = values();
        int r102 = r101.length;
        int r103 = 0;
    L3:
        if (r103 >= r102) goto L8;
        RemoteAudioState r104 = r101[r103];
        if (r104.value() == r100) goto L6;
        r103 = r103 + 1;
        goto L3
    L6:
        return r104;
    L8:
        return null;
    }

    public static RemoteAudioState valueOf(String r100) {
        return (RemoteAudioState) a.a(RemoteAudioState.class, r100);
    }

    private RemoteAudioState(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}
