package com.ss.bytertc.engine.data;

import r27.a;

/* JADX INFO: loaded from: classes40.dex */
public final enum LocalAudioStreamError extends Enum<LocalAudioStreamError> {
    private static final /* synthetic */ LocalAudioStreamError[] $VALUES = null;
    public static final LocalAudioStreamError LOCAL_AUDIO_STREAM_ERROR_DEVICE_BUSY = null;
    public static final LocalAudioStreamError LOCAL_AUDIO_STREAM_ERROR_DEVICE_NO_PERMISSION = null;
    public static final LocalAudioStreamError LOCAL_AUDIO_STREAM_ERROR_ENCODE_FAILURE = null;
    public static final LocalAudioStreamError LOCAL_AUDIO_STREAM_ERROR_FAILURE = null;
    public static final LocalAudioStreamError LOCAL_AUDIO_STREAM_ERROR_NO_RECORDING_DEVICE = null;
    public static final LocalAudioStreamError LOCAL_AUDIO_STREAM_ERROR_OK = null;
    public static final LocalAudioStreamError LOCAL_AUDIO_STREAM_ERROR_RECORD_FAILURE = null;
    private int value;

    /* JADX INFO: renamed from: com.ss.bytertc.engine.data.LocalAudioStreamError$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$ss$bytertc$engine$data$LocalAudioStreamError = null;

        static {
            int[] r100 = new int[LocalAudioStreamError.values().length];
            $SwitchMap$com$ss$bytertc$engine$data$LocalAudioStreamError = r100;
            r100[LocalAudioStreamError.LOCAL_AUDIO_STREAM_ERROR_OK.ordinal()] = 1;     // Catch: NoSuchFieldError -> L11
        L18:
            $SwitchMap$com$ss$bytertc$engine$data$LocalAudioStreamError[LocalAudioStreamError.LOCAL_AUDIO_STREAM_ERROR_FAILURE.ordinal()] = 2;     // Catch: NoSuchFieldError -> L12
        L22:
            $SwitchMap$com$ss$bytertc$engine$data$LocalAudioStreamError[LocalAudioStreamError.LOCAL_AUDIO_STREAM_ERROR_DEVICE_NO_PERMISSION.ordinal()] = 3;     // Catch: NoSuchFieldError -> L13
        L30:
            $SwitchMap$com$ss$bytertc$engine$data$LocalAudioStreamError[LocalAudioStreamError.LOCAL_AUDIO_STREAM_ERROR_DEVICE_BUSY.ordinal()] = 4;     // Catch: NoSuchFieldError -> L14
        L20:
            $SwitchMap$com$ss$bytertc$engine$data$LocalAudioStreamError[LocalAudioStreamError.LOCAL_AUDIO_STREAM_ERROR_RECORD_FAILURE.ordinal()] = 5;     // Catch: NoSuchFieldError -> L15
        L24:
            $SwitchMap$com$ss$bytertc$engine$data$LocalAudioStreamError[LocalAudioStreamError.LOCAL_AUDIO_STREAM_ERROR_ENCODE_FAILURE.ordinal()] = 6;     // Catch: NoSuchFieldError -> L16
        L26:
            $SwitchMap$com$ss$bytertc$engine$data$LocalAudioStreamError[LocalAudioStreamError.LOCAL_AUDIO_STREAM_ERROR_NO_RECORDING_DEVICE.ordinal()] = 7;     // Catch: NoSuchFieldError -> L17
            return;
        }
    }

    static {
        LocalAudioStreamError r100 = new LocalAudioStreamError("LOCAL_AUDIO_STREAM_ERROR_OK", 0, 0);
        LOCAL_AUDIO_STREAM_ERROR_OK = r100;
        LocalAudioStreamError r101 = new LocalAudioStreamError("LOCAL_AUDIO_STREAM_ERROR_FAILURE", 1, 1);
        LOCAL_AUDIO_STREAM_ERROR_FAILURE = r101;
        LocalAudioStreamError r102 = new LocalAudioStreamError("LOCAL_AUDIO_STREAM_ERROR_DEVICE_NO_PERMISSION", 2, 2);
        LOCAL_AUDIO_STREAM_ERROR_DEVICE_NO_PERMISSION = r102;
        LocalAudioStreamError r103 = new LocalAudioStreamError("LOCAL_AUDIO_STREAM_ERROR_DEVICE_BUSY", 3, 3);
        LOCAL_AUDIO_STREAM_ERROR_DEVICE_BUSY = r103;
        LocalAudioStreamError r104 = new LocalAudioStreamError("LOCAL_AUDIO_STREAM_ERROR_RECORD_FAILURE", 4, 4);
        LOCAL_AUDIO_STREAM_ERROR_RECORD_FAILURE = r104;
        LocalAudioStreamError r105 = new LocalAudioStreamError("LOCAL_AUDIO_STREAM_ERROR_ENCODE_FAILURE", 5, 5);
        LOCAL_AUDIO_STREAM_ERROR_ENCODE_FAILURE = r105;
        LocalAudioStreamError r110 = new LocalAudioStreamError("LOCAL_AUDIO_STREAM_ERROR_NO_RECORDING_DEVICE", 6, 6);
        LOCAL_AUDIO_STREAM_ERROR_NO_RECORDING_DEVICE = r110;
        $VALUES = new LocalAudioStreamError[]{r100, r101, r102, r103, r104, r105, r110};
    }

    public static LocalAudioStreamError[] values() {
        return (LocalAudioStreamError[]) $VALUES.clone();
    }

    @Override // java.lang.Enum
    public String toString() {
        switch(AnonymousClass1.$SwitchMap$com$ss$bytertc$engine$data$LocalAudioStreamError[ordinal()]) {
            case 1: goto L11;
            case 2: goto L10;
            case 3: goto L9;
            case 4: goto L8;
            case 5: goto L7;
            case 6: goto L6;
            case 7: goto L5;
            default: goto L4;
        };
    L4:
        return "";
    L5:
        return "kLocalAudioStreamErrorNoRecordingDevice";
    L6:
        return "kLocalAudioStreamErrorEncodeFailure";
    L7:
        return "kLocalAudioStreamErrorRecordFailure";
    L8:
        return "kLocalAudioStreamErrorDeviceBusy";
    L9:
        return "kLocalAudioStreamErrorDeviceNoPermission";
    L10:
        return "kLocalAudioStreamErrorFailure";
    L11:
        return "kLocalAudioStreamErrorOk";
    }

    public int value() {
        return this.value;
    }

    public static LocalAudioStreamError fromId(int r100) {
        LocalAudioStreamError[] r101 = values();
        int r102 = r101.length;
        int r103 = 0;
    L3:
        if (r103 >= r102) goto L8;
        LocalAudioStreamError r104 = r101[r103];
        if (r104.value() == r100) goto L6;
        r103 = r103 + 1;
        goto L3
    L6:
        return r104;
    L8:
        return null;
    }

    public static LocalAudioStreamError valueOf(String r100) {
        return (LocalAudioStreamError) a.a(LocalAudioStreamError.class, r100);
    }

    private LocalAudioStreamError(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}
