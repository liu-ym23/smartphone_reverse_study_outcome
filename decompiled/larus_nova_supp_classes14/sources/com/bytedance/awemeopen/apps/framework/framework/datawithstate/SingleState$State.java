package com.bytedance.awemeopen.apps.framework.framework.datawithstate;

import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0010\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\b¨\u0006\t"}, d2 = {"com/bytedance/awemeopen/apps/framework/framework/datawithstate/SingleState$State", "", "Lcom/bytedance/awemeopen/apps/framework/framework/datawithstate/SingleState$State;", "INIT", "LOADING", "INIT_SUCCESS", "INIT_FAIL", "LOAD_MORE_SUCCESS", "LOAD_MORE_FAIL", "ao_apps_framework_release"}, k = 1, mv = {1, 7, 1})
public final enum SingleState$State extends Enum<SingleState$State> {
    public static final SingleState$State INIT = null;
    public static final SingleState$State INIT_FAIL = null;
    public static final SingleState$State INIT_SUCCESS = null;
    public static final SingleState$State LOADING = null;
    public static final SingleState$State LOAD_MORE_FAIL = null;
    public static final SingleState$State LOAD_MORE_SUCCESS = null;
    public static final /* synthetic */ SingleState$State[] a = null;

    public static SingleState$State valueOf(String r1) {
        return (SingleState$State) a.a(SingleState$State.class, r1);
    }

    public static SingleState$State[] values() {
        return (SingleState$State[]) a.clone();
    }

    static {
        SingleState$State r0 = new SingleState$State("INIT", 0);
        INIT = r0;
        SingleState$State r1 = new SingleState$State("LOADING", 1);
        LOADING = r1;
        SingleState$State r3 = new SingleState$State("INIT_SUCCESS", 2);
        INIT_SUCCESS = r3;
        SingleState$State r5 = new SingleState$State("INIT_FAIL", 3);
        INIT_FAIL = r5;
        SingleState$State r7 = new SingleState$State("LOAD_MORE_SUCCESS", 4);
        LOAD_MORE_SUCCESS = r7;
        SingleState$State r9 = new SingleState$State("LOAD_MORE_FAIL", 5);
        LOAD_MORE_FAIL = r9;
        a = new SingleState$State[]{r0, r1, r3, r5, r7, r9};
    }

    public SingleState$State(String r1, int r2) {
        super(r1, r2);
    }
}
