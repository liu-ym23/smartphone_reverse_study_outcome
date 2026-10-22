package com.bytedance.ug.sdk.luckydog.api.task.pendant;

import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: classes22.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/bytedance/ug/sdk/luckydog/api/task/pendant/PendantState;", "", "COUNT_DOWN", "NEED_LOGIN", "FINISHED", "UNKNOWN", "luckydog-api_release"}, k = 1, mv = {1, 4, 0})
public final enum PendantState extends Enum<PendantState> {
    public static final PendantState COUNT_DOWN = null;
    public static final PendantState FINISHED = null;
    public static final PendantState NEED_LOGIN = null;
    public static final PendantState UNKNOWN = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ PendantState[] f271668a = null;

    static {
        PendantState r100 = new PendantState("COUNT_DOWN", 0);
        COUNT_DOWN = r100;
        PendantState r101 = new PendantState("NEED_LOGIN", 1);
        NEED_LOGIN = r101;
        PendantState r102 = new PendantState("FINISHED", 2);
        FINISHED = r102;
        PendantState r103 = new PendantState("UNKNOWN", 3);
        UNKNOWN = r103;
        f271668a = new PendantState[]{r100, r101, r102, r103};
    }

    public static PendantState valueOf(String r100) {
        return (PendantState) a.a(PendantState.class, r100);
    }

    public static PendantState[] values() {
        return (PendantState[]) f271668a.clone();
    }

    public PendantState(String r100, int r101) {
        super(r100, r101);
    }
}
