package com.bytedance.ug.sdk.luckydog.api.task.pendant;

import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: classes22.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u000f\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u0017\u0010\b\u001a\u00020\u00078\u0006¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012j\u0002\b\u0013j\u0002\b\u0014j\u0002\b\u0015¨\u0006\u0016"}, d2 = {"Lcom/bytedance/ug/sdk/luckydog/api/task/pendant/CounterPendantState;", "", "", "state", "I", "getState", "()I", "", "str", "Ljava/lang/String;", "getStr", "()Ljava/lang/String;", "PENDANT_STATE_GUIDE", "PENDANT_STATE_TIMING_UNFOLD", "PENDANT_STATE_TIMING_FOLD", "PENDANT_STATE_COUNTING_UNFOLD", "PENDANT_STATE_COUNTING_FOLD", "PENDANT_STATE_FINISH_UNFOLD", "PENDANT_STATE_FINISH_FOLD", "PENDANT_STATE_NEED_LOGIN", "PENDANT_STATE_DESTROYED", "UNKNOW", "luckydog-api_release"}, k = 1, mv = {1, 4, 0})
public final enum CounterPendantState extends Enum<CounterPendantState> {
    public static final CounterPendantState PENDANT_STATE_COUNTING_FOLD = null;
    public static final CounterPendantState PENDANT_STATE_COUNTING_UNFOLD = null;
    public static final CounterPendantState PENDANT_STATE_DESTROYED = null;
    public static final CounterPendantState PENDANT_STATE_FINISH_FOLD = null;
    public static final CounterPendantState PENDANT_STATE_FINISH_UNFOLD = null;
    public static final CounterPendantState PENDANT_STATE_GUIDE = null;
    public static final CounterPendantState PENDANT_STATE_NEED_LOGIN = null;
    public static final CounterPendantState PENDANT_STATE_TIMING_FOLD = null;
    public static final CounterPendantState PENDANT_STATE_TIMING_UNFOLD = null;
    public static final CounterPendantState UNKNOW = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ CounterPendantState[] f271667a = null;
    private final int state;
    private final String str;

    public static CounterPendantState valueOf(String r100) {
        return (CounterPendantState) a.a(CounterPendantState.class, r100);
    }

    public static CounterPendantState[] values() {
        return (CounterPendantState[]) f271667a.clone();
    }

    static {
        CounterPendantState r100 = new CounterPendantState("PENDANT_STATE_GUIDE", 0, 0, "GUIDE");
        PENDANT_STATE_GUIDE = r100;
        CounterPendantState r101 = new CounterPendantState("PENDANT_STATE_TIMING_UNFOLD", 1, 1, "TIMING_UNFOLD");
        PENDANT_STATE_TIMING_UNFOLD = r101;
        CounterPendantState r102 = new CounterPendantState("PENDANT_STATE_TIMING_FOLD", 2, 2, "TIMING_FOLD");
        PENDANT_STATE_TIMING_FOLD = r102;
        CounterPendantState r103 = new CounterPendantState("PENDANT_STATE_COUNTING_UNFOLD", 3, 3, "COUNTING_UNFOLD");
        PENDANT_STATE_COUNTING_UNFOLD = r103;
        CounterPendantState r104 = new CounterPendantState("PENDANT_STATE_COUNTING_FOLD", 4, 4, "COUNTING_FOLD");
        PENDANT_STATE_COUNTING_FOLD = r104;
        CounterPendantState r105 = new CounterPendantState("PENDANT_STATE_FINISH_UNFOLD", 5, 5, "FINISH_UNFOLD");
        PENDANT_STATE_FINISH_UNFOLD = r105;
        CounterPendantState r106 = new CounterPendantState("PENDANT_STATE_FINISH_FOLD", 6, 6, "FINISH_FOLD");
        PENDANT_STATE_FINISH_FOLD = r106;
        CounterPendantState r107 = new CounterPendantState("PENDANT_STATE_NEED_LOGIN", 7, 7, "NEED_LOGIN");
        PENDANT_STATE_NEED_LOGIN = r107;
        CounterPendantState r108 = new CounterPendantState("PENDANT_STATE_DESTROYED", 8, 8, "DESTROYED");
        PENDANT_STATE_DESTROYED = r108;
        CounterPendantState r109 = new CounterPendantState("UNKNOW", 9, -1, "UNKNOW");
        UNKNOW = r109;
        f271667a = new CounterPendantState[]{r100, r101, r102, r103, r104, r105, r106, r107, r108, r109};
    }

    public final int getState() {
        return this.state;
    }

    public final String getStr() {
        return this.str;
    }

    public CounterPendantState(String r100, int r101, int r102, String r103) {
        super(r100, r101);
        this.state = r102;
        this.str = r103;
    }
}
