package com.ss.android.lark.forwardv2.impl.utils;

import lib.p;
import r27.a;

/* JADX INFO: loaded from: classes36.dex */
public final enum ForwardUtil$ReceiveAuthorizationState extends Enum<ForwardUtil$ReceiveAuthorizationState> {
    public static final ForwardUtil$ReceiveAuthorizationState FINAL_AUTHORIZATION_STATE_DENY = null;
    public static final ForwardUtil$ReceiveAuthorizationState FINAL_AUTHORIZATION_STATE_PASS = null;
    public static final ForwardUtil$ReceiveAuthorizationState MIDDLE_AUTHORIZATION_STATE = null;
    public static final ForwardUtil$ReceiveAuthorizationState NORMAL_STATE = null;
    public static final ForwardUtil$ReceiveAuthorizationState UNKNOWN = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ ForwardUtil$ReceiveAuthorizationState[] f424950a = null;

    static {
        ForwardUtil$ReceiveAuthorizationState r100 = new ForwardUtil$ReceiveAuthorizationState("UNKNOWN", 0);
        UNKNOWN = r100;
        ForwardUtil$ReceiveAuthorizationState r101 = new ForwardUtil$ReceiveAuthorizationState("MIDDLE_AUTHORIZATION_STATE", 1);
        MIDDLE_AUTHORIZATION_STATE = r101;
        ForwardUtil$ReceiveAuthorizationState r102 = new ForwardUtil$ReceiveAuthorizationState("FINAL_AUTHORIZATION_STATE_PASS", 2);
        FINAL_AUTHORIZATION_STATE_PASS = r102;
        ForwardUtil$ReceiveAuthorizationState r103 = new ForwardUtil$ReceiveAuthorizationState("FINAL_AUTHORIZATION_STATE_DENY", 3);
        FINAL_AUTHORIZATION_STATE_DENY = r103;
        ForwardUtil$ReceiveAuthorizationState r104 = new ForwardUtil$ReceiveAuthorizationState("NORMAL_STATE", 4);
        NORMAL_STATE = r104;
        f424950a = new ForwardUtil$ReceiveAuthorizationState[]{r100, r101, r102, r103, r104};
    }

    public static ForwardUtil$ReceiveAuthorizationState[] values() {
        return (ForwardUtil$ReceiveAuthorizationState[]) f424950a.clone();
    }

    public static int valueFrom(ForwardUtil$ReceiveAuthorizationState r100) {
        int r101 = p.f509485a[r100.ordinal()];
        if (r101 != 1) goto L5;
        return 1;
    L5:
        if (r101 != 2) goto L7;
        return 3;
    L7:
        if (r101 != 4) goto L9;
        return 2;
    L9:
        if (r101 == 5) goto L12;
        return 0;
    L12:
        return 4;
    }

    public static ForwardUtil$ReceiveAuthorizationState valueOf(int r100) {
        if (r100 == 0) goto L22;
        if (r100 == 1) goto L20;
        if (r100 == 2) goto L18;
        if (r100 == 3) goto L16;
        if (r100 == 4) goto L14;
        return UNKNOWN;
    L14:
        return NORMAL_STATE;
    L16:
        return FINAL_AUTHORIZATION_STATE_DENY;
    L18:
        return FINAL_AUTHORIZATION_STATE_PASS;
    L20:
        return MIDDLE_AUTHORIZATION_STATE;
    L22:
        return UNKNOWN;
    }

    public static ForwardUtil$ReceiveAuthorizationState valueOf(String r100) {
        return (ForwardUtil$ReceiveAuthorizationState) a.a(ForwardUtil$ReceiveAuthorizationState.class, r100);
    }

    public ForwardUtil$ReceiveAuthorizationState(String r100, int r101) {
        super(r100, r101);
    }
}
