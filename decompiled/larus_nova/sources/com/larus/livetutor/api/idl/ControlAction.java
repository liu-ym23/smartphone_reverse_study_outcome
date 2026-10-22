package com.larus.livetutor.api.idl;

import com.google.gson.annotations.SerializedName;
import com.tencent.connect.common.Constants;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.JvmStatic;

/* JADX INFO: loaded from: classes30.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\u0011\b\u0087\u0081\u0002\u0018\u0000 \u00132\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u0013B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012¨\u0006\u0014"}, d2 = {"Lcom/larus/livetutor/api/idl/ControlAction;", "", "value", "", "<init>", "(Ljava/lang/String;II)V", "getValue", "()I", "Unknown", "Continue", "Restart", "Start", "WaitTimeout", "Pause", "PauseContinue", "JumpAndReplay", "JumpAndRestart", "ConvenientContinueResponse", "BoardReactControl", "Companion", "api_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum ControlAction extends Enum<ControlAction> {
    private static final /* synthetic */ EnumEntries $ENTRIES = null;
    private static final /* synthetic */ ControlAction[] $VALUES = null;

    @SerializedName("11")
    public static final ControlAction BoardReactControl = null;
    public static final a Companion = null;

    @SerializedName("1")
    public static final ControlAction Continue = null;

    @SerializedName(Constants.VIA_REPORT_TYPE_SHARE_TO_QQ)
    public static final ControlAction ConvenientContinueResponse = null;

    @SerializedName("8")
    public static final ControlAction JumpAndReplay = null;

    @SerializedName(Constants.VIA_SHARE_TYPE_MINI_PROGRAM)
    public static final ControlAction JumpAndRestart = null;

    @SerializedName("5")
    public static final ControlAction Pause = null;

    @SerializedName("7")
    public static final ControlAction PauseContinue = null;

    @SerializedName("2")
    public static final ControlAction Restart = null;

    @SerializedName("3")
    public static final ControlAction Start = null;

    @SerializedName("0")
    public static final ControlAction Unknown = null;

    @SerializedName("4")
    public static final ControlAction WaitTimeout = null;
    private final int value;

    public static final class a {
        public a() {
        }
    }

    private static final /* synthetic */ ControlAction[] $values() {
        return new ControlAction[]{Unknown, Continue, Restart, Start, WaitTimeout, Pause, PauseContinue, JumpAndReplay, JumpAndRestart, ConvenientContinueResponse, BoardReactControl};
    }

    public static EnumEntries<ControlAction> getEntries() {
        return $ENTRIES;
    }

    static {
        Unknown = new ControlAction("Unknown", 0, 0);
        Continue = new ControlAction("Continue", 1, 1);
        Restart = new ControlAction("Restart", 2, 2);
        Start = new ControlAction("Start", 3, 3);
        WaitTimeout = new ControlAction("WaitTimeout", 4, 4);
        Pause = new ControlAction("Pause", 5, 5);
        PauseContinue = new ControlAction("PauseContinue", 6, 7);
        JumpAndReplay = new ControlAction("JumpAndReplay", 7, 8);
        JumpAndRestart = new ControlAction("JumpAndRestart", 8, 9);
        ConvenientContinueResponse = new ControlAction("ConvenientContinueResponse", 9, 10);
        BoardReactControl = new ControlAction("BoardReactControl", 10, 11);
        ControlAction[] r100 = $values();
        $VALUES = r100;
        $ENTRIES = EnumEntriesKt.enumEntries(r100);
        Companion = new a();
    }

    public static ControlAction[] values() {
        return (ControlAction[]) $VALUES.clone();
    }

    public final int getValue() {
        return this.value;
    }

    @JvmStatic
    public static final ControlAction findByValue(int r100) {
        Companion.getClass();
        switch(r100) {
            case 0: goto L16;
            case 1: goto L27;
            case 2: goto L26;
            case 3: goto L25;
            case 4: goto L24;
            case 5: goto L23;
            case 6: goto L4;
            case 7: goto L22;
            case 8: goto L21;
            case 9: goto L20;
            case 10: goto L19;
            case 11: goto L18;
            default: goto L4;
        };
    L4:
        return null;
    L18:
        return BoardReactControl;
    L19:
        return ConvenientContinueResponse;
    L20:
        return JumpAndRestart;
    L21:
        return JumpAndReplay;
    L22:
        return PauseContinue;
    L23:
        return Pause;
    L24:
        return WaitTimeout;
    L25:
        return Start;
    L26:
        return Restart;
    L27:
        return Continue;
    L16:
        return Unknown;
    }

    public static ControlAction valueOf(String r100) {
        return (ControlAction) r27.a.a(ControlAction.class, r100);
    }

    private ControlAction(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}
