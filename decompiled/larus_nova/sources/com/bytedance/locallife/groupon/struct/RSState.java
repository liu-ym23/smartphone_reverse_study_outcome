package com.bytedance.locallife.groupon.struct;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes21.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u000e\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000e¨\u0006\u000f"}, d2 = {"Lcom/bytedance/locallife/groupon/struct/RSState;", "", "IDLE", "ROUTE_START", "ROUTE_INTERCEPT", "PARSE_STRUCT", "PRE_OPEN", "PRE_OPEN_SUBPAGE", "SUBPAGE_FMP_END", "SUBPAGE_JUMP_TASK_START", "SUBPAGE_JUMP_TASK", "SUBPAGE_CALLBACK", "SUBPAGE_CALLBACK_OPEN", "SUBPAGE_OPEN_ERROR", "JUMP_FINISH", "locallife-groupon-api_release"}, k = 1, mv = {1, 4, 3})
public final enum RSState extends Enum<RSState> {
    public static final RSState IDLE = null;
    public static final RSState JUMP_FINISH = null;
    public static final RSState PARSE_STRUCT = null;
    public static final RSState PRE_OPEN = null;
    public static final RSState PRE_OPEN_SUBPAGE = null;
    public static final RSState ROUTE_INTERCEPT = null;
    public static final RSState ROUTE_START = null;
    public static final RSState SUBPAGE_CALLBACK = null;
    public static final RSState SUBPAGE_CALLBACK_OPEN = null;
    public static final RSState SUBPAGE_FMP_END = null;
    public static final RSState SUBPAGE_JUMP_TASK = null;
    public static final RSState SUBPAGE_JUMP_TASK_START = null;
    public static final RSState SUBPAGE_OPEN_ERROR = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ RSState[] f258838a = null;

    public static RSState valueOf(String r100) {
        return (RSState) r27.a.a(RSState.class, r100);
    }

    public static RSState[] values() {
        return (RSState[]) f258838a.clone();
    }

    static {
        RSState r100 = new RSState("IDLE", 0);
        IDLE = r100;
        RSState r101 = new RSState("ROUTE_START", 1);
        ROUTE_START = r101;
        RSState r102 = new RSState("ROUTE_INTERCEPT", 2);
        ROUTE_INTERCEPT = r102;
        RSState r103 = new RSState("PARSE_STRUCT", 3);
        PARSE_STRUCT = r103;
        RSState r104 = new RSState("PRE_OPEN", 4);
        PRE_OPEN = r104;
        RSState r105 = new RSState("PRE_OPEN_SUBPAGE", 5);
        PRE_OPEN_SUBPAGE = r105;
        RSState r110 = new RSState("SUBPAGE_FMP_END", 6);
        SUBPAGE_FMP_END = r110;
        RSState r111 = new RSState("SUBPAGE_JUMP_TASK_START", 7);
        SUBPAGE_JUMP_TASK_START = r111;
        RSState r112 = new RSState("SUBPAGE_JUMP_TASK", 8);
        SUBPAGE_JUMP_TASK = r112;
        RSState r113 = new RSState("SUBPAGE_CALLBACK", 9);
        SUBPAGE_CALLBACK = r113;
        RSState r114 = new RSState("SUBPAGE_CALLBACK_OPEN", 10);
        SUBPAGE_CALLBACK_OPEN = r114;
        RSState r115 = new RSState("SUBPAGE_OPEN_ERROR", 11);
        SUBPAGE_OPEN_ERROR = r115;
        RSState r106 = new RSState("JUMP_FINISH", 12);
        JUMP_FINISH = r106;
        f258838a = new RSState[]{r100, r101, r102, r103, r104, r105, r110, r111, r112, r113, r114, r115, r106};
    }

    public RSState(String r100, int r101) {
        super(r100, r101);
    }
}
