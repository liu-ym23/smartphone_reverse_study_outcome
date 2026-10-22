package com.ss.android.lark.audio.voiceinput;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes34.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\r\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0006\u0010\u0010\u001a\u00020\u0011J\u0006\u0010\u0012\u001a\u00020\u0013R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000f¨\u0006\u0014"}, d2 = {"Lcom/ss/android/lark/audio/voiceinput/AsrSessionState;", "", "state", "", "<init>", "(Ljava/lang/String;II)V", "getState", "()I", "AsrSessionIdle", "AsrSessionRecording", "AsrSessionSwitchLanguage", "AsrSessionWaitRecognizing", "AsrSessionEndWithText", "AsrSessionEndNoText", "AsrSessionEndWithTextTimeout", "AsrSessionEndNoTextTimeout", "isAsrSessionRunning", "", "info", "", "audio_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum AsrSessionState extends Enum<AsrSessionState> {
    public static final AsrSessionState AsrSessionEndNoText = null;
    public static final AsrSessionState AsrSessionEndNoTextTimeout = null;
    public static final AsrSessionState AsrSessionEndWithText = null;
    public static final AsrSessionState AsrSessionEndWithTextTimeout = null;
    public static final AsrSessionState AsrSessionIdle = null;
    public static final AsrSessionState AsrSessionRecording = null;
    public static final AsrSessionState AsrSessionSwitchLanguage = null;
    public static final AsrSessionState AsrSessionWaitRecognizing = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ AsrSessionState[] f409166a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f409167b = null;
    private final int state;

    public static EnumEntries<AsrSessionState> getEntries() {
        return f409167b;
    }

    static {
        AsrSessionState r100 = new AsrSessionState("AsrSessionIdle", 0, 1000);
        AsrSessionIdle = r100;
        AsrSessionState r101 = new AsrSessionState("AsrSessionRecording", 1, 1001);
        AsrSessionRecording = r101;
        AsrSessionState r102 = new AsrSessionState("AsrSessionSwitchLanguage", 2, 1003);
        AsrSessionSwitchLanguage = r102;
        AsrSessionState r103 = new AsrSessionState("AsrSessionWaitRecognizing", 3, 1002);
        AsrSessionWaitRecognizing = r103;
        AsrSessionState r104 = new AsrSessionState("AsrSessionEndWithText", 4, 1100);
        AsrSessionEndWithText = r104;
        AsrSessionState r105 = new AsrSessionState("AsrSessionEndNoText", 5, 1101);
        AsrSessionEndNoText = r105;
        AsrSessionState r110 = new AsrSessionState("AsrSessionEndWithTextTimeout", 6, 1102);
        AsrSessionEndWithTextTimeout = r110;
        AsrSessionState r111 = new AsrSessionState("AsrSessionEndNoTextTimeout", 7, 1103);
        AsrSessionEndNoTextTimeout = r111;
        AsrSessionState[] r112 = {r100, r101, r102, r103, r104, r105, r110, r111};
        f409166a = r112;
        f409167b = EnumEntriesKt.enumEntries(r112);
    }

    public static AsrSessionState[] values() {
        return (AsrSessionState[]) f409166a.clone();
    }

    public final String info() {
        int r100 = this.state;
        if (r100 == 1100) goto L9;
        switch(r100) {
            case 1000: goto L8;
            case 1001: goto L7;
            case 1002: goto L6;
            default: goto L5;
        };
    L5:
        return "Unknown";
    L6:
        return "WaitRecognizing";
    L7:
        return "Recording";
    L8:
        return "Idle";
    L9:
        return "End";
    }

    public final boolean isAsrSessionRunning() {
        int r100 = this.state;
        if (r100 > 1000) goto L5;
    L7:
        return false;
    L5:
        if (r100 >= 1100) goto L7;
        return true;
    }

    public final int getState() {
        return this.state;
    }

    public static AsrSessionState valueOf(String r100) {
        return (AsrSessionState) r27.a.a(AsrSessionState.class, r100);
    }

    public AsrSessionState(String r100, int r101, int r102) {
        super(r100, r101);
        this.state = r102;
    }
}
