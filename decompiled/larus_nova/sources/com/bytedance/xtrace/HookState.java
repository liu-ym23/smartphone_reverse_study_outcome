package com.bytedance.xtrace;

import r27.a;

/* JADX INFO: loaded from: classes22.dex */
public final enum HookState extends Enum {
    private static final /* synthetic */ HookState[] $VALUES = null;
    public static final HookState FAILED_FIND_ADD_LISTENER = null;
    public static final HookState FAILED_FIND_DO_CALL = null;
    public static final HookState FAILED_FIND_ENABLE_METHOD_TRACING = null;
    public static final HookState FAILED_FIND_INTERPRETER_BRIDGE = null;
    public static final HookState FAILED_FIND_METHOD_ENTERED = null;
    public static final HookState FAILED_OPEN_TRACE = null;
    public static final HookState SUCCESS = null;
    public static final HookState UNKNOWN = null;
    private final int value;

    static {
        HookState r100 = new HookState("SUCCESS", 0, 0);
        SUCCESS = r100;
        HookState r101 = new HookState("FAILED_FIND_DO_CALL", 1, 1);
        FAILED_FIND_DO_CALL = r101;
        HookState r102 = new HookState("FAILED_FIND_INTERPRETER_BRIDGE", 2, 2);
        FAILED_FIND_INTERPRETER_BRIDGE = r102;
        HookState r103 = new HookState("FAILED_OPEN_TRACE", 3, 3);
        FAILED_OPEN_TRACE = r103;
        HookState r104 = new HookState("FAILED_FIND_METHOD_ENTERED", 4, 4);
        FAILED_FIND_METHOD_ENTERED = r104;
        HookState r105 = new HookState("FAILED_FIND_ADD_LISTENER", 5, 5);
        FAILED_FIND_ADD_LISTENER = r105;
        HookState r110 = new HookState("FAILED_FIND_ENABLE_METHOD_TRACING", 6, 6);
        FAILED_FIND_ENABLE_METHOD_TRACING = r110;
        HookState r111 = new HookState("UNKNOWN", 7, 20);
        UNKNOWN = r111;
        $VALUES = new HookState[]{r100, r101, r102, r103, r104, r105, r110, r111};
    }

    private HookState(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }

    public static HookState fromInt(int r100) {
        HookState[] r101 = values();
        int r102 = r101.length;
        int r103 = 0;
    L3:
        if (r103 >= r102) goto L9;
        HookState r104 = r101[r103];
        if (r104.value == r100) goto L6;
        r103 = r103 + 1;
        goto L3
    L6:
        return r104;
    L9:
        return UNKNOWN;
    }

    public static HookState valueOf(String r100) {
        return (HookState) a.a(HookState.class, r100);
    }

    public static HookState[] values() {
        return (HookState[]) $VALUES.clone();
    }

    public int getValue() {
        return this.value;
    }
}
