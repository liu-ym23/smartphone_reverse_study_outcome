package com.obric.assistant.block.complex.call_for_me;

import com.larus.nova.R;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes32.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0014\b\u0086\u0081\u0002\u0018\u0000 \u001a2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u001aB)\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\u0007¢\u0006\u0004\b\t\u0010\nR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\b\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0010j\u0002\b\u0012j\u0002\b\u0013j\u0002\b\u0014j\u0002\b\u0015j\u0002\b\u0016j\u0002\b\u0017j\u0002\b\u0018j\u0002\b\u0019¨\u0006\u001b"}, d2 = {"Lcom/obric/assistant/block/complex/call_for_me/CallState;", "", "stateStr", "", "btnTextResId", "", "btnEnabled", "", "btnActivated", "<init>", "(Ljava/lang/String;ILjava/lang/String;IZZ)V", "getStateStr", "()Ljava/lang/String;", "getBtnTextResId", "()I", "getBtnEnabled", "()Z", "getBtnActivated", "UNKNOWN", "CALL_FOR_ME", "CALL_DIALING", "CALL_ONGOING", "CALL_ENDED", "CALL_SUMMARIZING", "CALL_CANCELLED", "CALL_EXPIRED", "Companion", "card_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum CallState extends Enum<CallState> {
    public static final CallState CALL_CANCELLED = null;
    public static final CallState CALL_DIALING = null;
    public static final CallState CALL_ENDED = null;
    public static final CallState CALL_EXPIRED = null;
    public static final CallState CALL_FOR_ME = null;
    public static final CallState CALL_ONGOING = null;
    public static final CallState CALL_SUMMARIZING = null;
    public static final a Companion = null;
    public static final CallState UNKNOWN = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ CallState[] f385933a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f385934b = null;
    private final boolean btnActivated;
    private final boolean btnEnabled;
    private final int btnTextResId;
    private final String stateStr;

    public static final class a {
        public a() {
        }
    }

    public static EnumEntries<CallState> getEntries() {
        return f385934b;
    }

    static {
        CallState r100 = new CallState("UNKNOWN", 0, "unknown", R.string.obric_call_for_me_block_call, false, false);
        UNKNOWN = r100;
        CallState r101 = new CallState("CALL_FOR_ME", 1, "call_for_me", R.string.obric_call_for_me_block_call, true, false);
        CALL_FOR_ME = r101;
        CallState r102 = new CallState("CALL_DIALING", 2, "call_dialing", R.string.obric_call_for_me_block_dialing, false, false);
        CALL_DIALING = r102;
        CallState r103 = new CallState("CALL_ONGOING", 3, "call_ongoing", R.string.obric_call_for_me_block_ongoing, true, true);
        CALL_ONGOING = r103;
        CallState r104 = new CallState("CALL_ENDED", 4, "call_ended", R.string.obric_call_for_me_block_ended, false, false);
        CALL_ENDED = r104;
        CallState r105 = new CallState("CALL_SUMMARIZING", 5, "call_summarizing", R.string.obric_call_for_me_block_summarizing, false, false);
        CALL_SUMMARIZING = r105;
        CallState r210 = new CallState("CALL_CANCELLED", 6, "call_cancelled", R.string.obric_call_for_me_block_cancelled, false, false);
        CALL_CANCELLED = r210;
        CallState r106 = new CallState("CALL_EXPIRED", 7, "call_expired", R.string.obric_call_for_me_block_expired, false, false);
        CALL_EXPIRED = r106;
        CallState[] r107 = {r100, r101, r102, r103, r104, r105, r210, r106};
        f385933a = r107;
        f385934b = EnumEntriesKt.enumEntries(r107);
        Companion = new a();
    }

    public static CallState[] values() {
        return (CallState[]) f385933a.clone();
    }

    public final boolean getBtnActivated() {
        return this.btnActivated;
    }

    public final boolean getBtnEnabled() {
        return this.btnEnabled;
    }

    public final int getBtnTextResId() {
        return this.btnTextResId;
    }

    public final String getStateStr() {
        return this.stateStr;
    }

    public static CallState valueOf(String r100) {
        return (CallState) r27.a.a(CallState.class, r100);
    }

    public CallState(String r100, int r101, String r102, int r103, boolean r104, boolean r105) {
        super(r100, r101);
        this.stateStr = r102;
        this.btnTextResId = r103;
        this.btnEnabled = r104;
        this.btnActivated = r105;
    }
}
