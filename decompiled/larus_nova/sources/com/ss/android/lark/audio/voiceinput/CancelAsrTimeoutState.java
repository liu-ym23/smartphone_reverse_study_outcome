package com.ss.android.lark.audio.voiceinput;

import com.bytedance.android.livesdk.schema.BasicTestActionHandler;
import com.ss.ttvideoengine.log.VideoEventOneOutSync;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes34.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\u000f\n\u0002\u0010\u000e\n\u0000\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0006\u0010\u0012\u001a\u00020\u0013R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011¨\u0006\u0014"}, d2 = {"Lcom/ss/android/lark/audio/voiceinput/CancelAsrTimeoutState;", "", "state", "", "<init>", "(Ljava/lang/String;II)V", "getState", "()I", "CancelByPause", "CancelByReset", "CancelByClick", "CancelByFinish", "CancelByCleared", "CancelByClickCancel", "CancelByInputChange", "CancelByAsrTimeOut", "CancelByClickSend", "CancelByAdvanceModeDefault", "info", "", "audio_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum CancelAsrTimeoutState extends Enum<CancelAsrTimeoutState> {
    public static final CancelAsrTimeoutState CancelByAdvanceModeDefault = null;
    public static final CancelAsrTimeoutState CancelByAsrTimeOut = null;
    public static final CancelAsrTimeoutState CancelByCleared = null;
    public static final CancelAsrTimeoutState CancelByClick = null;
    public static final CancelAsrTimeoutState CancelByClickCancel = null;
    public static final CancelAsrTimeoutState CancelByClickSend = null;
    public static final CancelAsrTimeoutState CancelByFinish = null;
    public static final CancelAsrTimeoutState CancelByInputChange = null;
    public static final CancelAsrTimeoutState CancelByPause = null;
    public static final CancelAsrTimeoutState CancelByReset = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ CancelAsrTimeoutState[] f409172a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f409173b = null;
    private final int state;

    public static EnumEntries<CancelAsrTimeoutState> getEntries() {
        return f409173b;
    }

    static {
        CancelAsrTimeoutState r100 = new CancelAsrTimeoutState("CancelByPause", 0, 0);
        CancelByPause = r100;
        CancelAsrTimeoutState r101 = new CancelAsrTimeoutState("CancelByReset", 1, 1);
        CancelByReset = r101;
        CancelAsrTimeoutState r102 = new CancelAsrTimeoutState("CancelByClick", 2, 2);
        CancelByClick = r102;
        CancelAsrTimeoutState r103 = new CancelAsrTimeoutState("CancelByFinish", 3, 3);
        CancelByFinish = r103;
        CancelAsrTimeoutState r104 = new CancelAsrTimeoutState("CancelByCleared", 4, 4);
        CancelByCleared = r104;
        CancelAsrTimeoutState r105 = new CancelAsrTimeoutState("CancelByClickCancel", 5, 5);
        CancelByClickCancel = r105;
        CancelAsrTimeoutState r110 = new CancelAsrTimeoutState("CancelByInputChange", 6, 6);
        CancelByInputChange = r110;
        CancelAsrTimeoutState r111 = new CancelAsrTimeoutState("CancelByAsrTimeOut", 7, 7);
        CancelByAsrTimeOut = r111;
        CancelAsrTimeoutState r112 = new CancelAsrTimeoutState("CancelByClickSend", 8, 8);
        CancelByClickSend = r112;
        CancelAsrTimeoutState r113 = new CancelAsrTimeoutState("CancelByAdvanceModeDefault", 9, 9);
        CancelByAdvanceModeDefault = r113;
        CancelAsrTimeoutState[] r114 = {r100, r101, r102, r103, r104, r105, r110, r111, r112, r113};
        f409172a = r114;
        f409173b = EnumEntriesKt.enumEntries(r114);
    }

    public static CancelAsrTimeoutState[] values() {
        return (CancelAsrTimeoutState[]) f409172a.clone();
    }

    public final String info() {
        switch(this.state) {
            case 0: goto L14;
            case 1: goto L13;
            case 2: goto L12;
            case 3: goto L11;
            case 4: goto L10;
            case 5: goto L9;
            case 6: goto L8;
            case 7: goto L7;
            case 8: goto L6;
            case 9: goto L5;
            default: goto L4;
        };
    L4:
        return "unknown";
    L5:
        return "advance_mode_default";
    L6:
        return "click_send";
    L7:
        return "timeout";
    L8:
        return "input";
    L9:
        return "cancel";
    L10:
        return "cleared";
    L11:
        return VideoEventOneOutSync.END_TYPE_FINISH;
    L12:
        return "click";
    L13:
        return BasicTestActionHandler.TEST_ACTION_RESET;
    L14:
        return "pause";
    }

    public final int getState() {
        return this.state;
    }

    public static CancelAsrTimeoutState valueOf(String r100) {
        return (CancelAsrTimeoutState) r27.a.a(CancelAsrTimeoutState.class, r100);
    }

    public CancelAsrTimeoutState(String r100, int r101, int r102) {
        super(r100, r101);
        this.state = r102;
    }
}
