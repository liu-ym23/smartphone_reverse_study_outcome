package com.ss.bytertc.engine.data;

import r27.a;

/* JADX INFO: loaded from: classes40.dex */
public final enum LocalAudioStreamState extends Enum<LocalAudioStreamState> {
    private static final /* synthetic */ LocalAudioStreamState[] $VALUES = null;
    public static final LocalAudioStreamState LOCAL_AUDIO_STREAM_STATE_ENCODING = null;
    public static final LocalAudioStreamState LOCAL_AUDIO_STREAM_STATE_FAILED = null;
    public static final LocalAudioStreamState LOCAL_AUDIO_STREAM_STATE_RECORDING = null;
    public static final LocalAudioStreamState LOCAL_AUDIO_STREAM_STATE_STOPPED = null;
    private int value;

    /* JADX INFO: renamed from: com.ss.bytertc.engine.data.LocalAudioStreamState$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$ss$bytertc$engine$data$LocalAudioStreamState = null;

        static {
            int[] r100 = new int[LocalAudioStreamState.values().length];
            $SwitchMap$com$ss$bytertc$engine$data$LocalAudioStreamState = r100;
            r100[LocalAudioStreamState.LOCAL_AUDIO_STREAM_STATE_STOPPED.ordinal()] = 1;     // Catch: NoSuchFieldError -> L8
        L12:
            $SwitchMap$com$ss$bytertc$engine$data$LocalAudioStreamState[LocalAudioStreamState.LOCAL_AUDIO_STREAM_STATE_RECORDING.ordinal()] = 2;     // Catch: NoSuchFieldError -> L9
        L14:
            $SwitchMap$com$ss$bytertc$engine$data$LocalAudioStreamState[LocalAudioStreamState.LOCAL_AUDIO_STREAM_STATE_ENCODING.ordinal()] = 3;     // Catch: NoSuchFieldError -> L10
        L18:
            $SwitchMap$com$ss$bytertc$engine$data$LocalAudioStreamState[LocalAudioStreamState.LOCAL_AUDIO_STREAM_STATE_FAILED.ordinal()] = 4;     // Catch: NoSuchFieldError -> L11
            return;
        }
    }

    static {
        LocalAudioStreamState r100 = new LocalAudioStreamState("LOCAL_AUDIO_STREAM_STATE_STOPPED", 0, 0);
        LOCAL_AUDIO_STREAM_STATE_STOPPED = r100;
        LocalAudioStreamState r101 = new LocalAudioStreamState("LOCAL_AUDIO_STREAM_STATE_RECORDING", 1, 1);
        LOCAL_AUDIO_STREAM_STATE_RECORDING = r101;
        LocalAudioStreamState r102 = new LocalAudioStreamState("LOCAL_AUDIO_STREAM_STATE_ENCODING", 2, 2);
        LOCAL_AUDIO_STREAM_STATE_ENCODING = r102;
        LocalAudioStreamState r103 = new LocalAudioStreamState("LOCAL_AUDIO_STREAM_STATE_FAILED", 3, 3);
        LOCAL_AUDIO_STREAM_STATE_FAILED = r103;
        $VALUES = new LocalAudioStreamState[]{r100, r101, r102, r103};
    }

    public static LocalAudioStreamState[] values() {
        return (LocalAudioStreamState[]) $VALUES.clone();
    }

    @Override // java.lang.Enum
    public String toString() {
        int r100 = AnonymousClass1.$SwitchMap$com$ss$bytertc$engine$data$LocalAudioStreamState[ordinal()];
        if (r100 != 1) goto L5;
        return "kLocalAudioStreamStateStopped";
    L5:
        if (r100 != 2) goto L7;
        return "kLocalAudioStreamStateRecording";
    L7:
        if (r100 != 3) goto L9;
        return "kLocalAudioStreamStateEncoding";
    L9:
        if (r100 == 4) goto L11;
        return "";
    L11:
        return "kLocalAudioStreamStateFailed";
    }

    public int value() {
        return this.value;
    }

    public static LocalAudioStreamState fromId(int r100) {
        LocalAudioStreamState[] r101 = values();
        int r102 = r101.length;
        int r103 = 0;
    L3:
        if (r103 >= r102) goto L8;
        LocalAudioStreamState r104 = r101[r103];
        if (r104.value() == r100) goto L6;
        r103 = r103 + 1;
        goto L3
    L6:
        return r104;
    L8:
        return null;
    }

    public static LocalAudioStreamState valueOf(String r100) {
        return (LocalAudioStreamState) a.a(LocalAudioStreamState.class, r100);
    }

    private LocalAudioStreamState(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}
