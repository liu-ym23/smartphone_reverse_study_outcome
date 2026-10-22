package com.bytedance.flow_audio.api.business.asr.session;

import com.byted.cast.common.bean.State;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: classes19.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u000f\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000f¨\u0006\u0010"}, d2 = {"Lcom/bytedance/flow_audio/api/business/asr/session/FlowAsrSessionState;", "", "<init>", "(Ljava/lang/String;I)V", "IDLE", "PREPARING", State.RECORDING, "PENDING_FAIL", "STOPPING", "RETRYING", "WAITING_ASR_COMPLETION", "CANCELING", "FINISHED", "FAILED", "CANCELED", "RELEASED", "flow_audio_api_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum FlowAsrSessionState extends Enum<FlowAsrSessionState> {
    public static final FlowAsrSessionState CANCELED = null;
    public static final FlowAsrSessionState CANCELING = null;
    public static final FlowAsrSessionState FAILED = null;
    public static final FlowAsrSessionState FINISHED = null;
    public static final FlowAsrSessionState IDLE = null;
    public static final FlowAsrSessionState PENDING_FAIL = null;
    public static final FlowAsrSessionState PREPARING = null;
    public static final FlowAsrSessionState RECORDING = null;
    public static final FlowAsrSessionState RELEASED = null;
    public static final FlowAsrSessionState RETRYING = null;
    public static final FlowAsrSessionState STOPPING = null;
    public static final FlowAsrSessionState WAITING_ASR_COMPLETION = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ FlowAsrSessionState[] f243679a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f243680b = null;

    public static EnumEntries<FlowAsrSessionState> getEntries() {
        return f243680b;
    }

    static {
        FlowAsrSessionState r100 = new FlowAsrSessionState("IDLE", 0);
        IDLE = r100;
        FlowAsrSessionState r101 = new FlowAsrSessionState("PREPARING", 1);
        PREPARING = r101;
        FlowAsrSessionState r102 = new FlowAsrSessionState(State.RECORDING, 2);
        RECORDING = r102;
        FlowAsrSessionState r103 = new FlowAsrSessionState("PENDING_FAIL", 3);
        PENDING_FAIL = r103;
        FlowAsrSessionState r104 = new FlowAsrSessionState("STOPPING", 4);
        STOPPING = r104;
        FlowAsrSessionState r105 = new FlowAsrSessionState("RETRYING", 5);
        RETRYING = r105;
        FlowAsrSessionState r110 = new FlowAsrSessionState("WAITING_ASR_COMPLETION", 6);
        WAITING_ASR_COMPLETION = r110;
        FlowAsrSessionState r111 = new FlowAsrSessionState("CANCELING", 7);
        CANCELING = r111;
        FlowAsrSessionState r112 = new FlowAsrSessionState("FINISHED", 8);
        FINISHED = r112;
        FlowAsrSessionState r113 = new FlowAsrSessionState("FAILED", 9);
        FAILED = r113;
        FlowAsrSessionState r114 = new FlowAsrSessionState("CANCELED", 10);
        CANCELED = r114;
        FlowAsrSessionState r115 = new FlowAsrSessionState("RELEASED", 11);
        RELEASED = r115;
        FlowAsrSessionState[] r106 = {r100, r101, r102, r103, r104, r105, r110, r111, r112, r113, r114, r115};
        f243679a = r106;
        f243680b = EnumEntriesKt.enumEntries(r106);
    }

    public static FlowAsrSessionState[] values() {
        return (FlowAsrSessionState[]) f243679a.clone();
    }

    public static FlowAsrSessionState valueOf(String r100) {
        return (FlowAsrSessionState) a.a(FlowAsrSessionState.class, r100);
    }

    public FlowAsrSessionState(String r100, int r101) {
        super(r100, r101);
    }
}
