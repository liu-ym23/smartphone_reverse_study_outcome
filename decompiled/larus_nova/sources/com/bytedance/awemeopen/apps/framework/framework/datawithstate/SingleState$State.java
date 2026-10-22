package com.bytedance.awemeopen.apps.framework.framework.datawithstate;

import com.android.ttcjpaysdk.base.h5.cjjsb.constant.ErrorCode;
import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: classes14.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0010\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\b¨\u0006\t"}, d2 = {"com/bytedance/awemeopen/apps/framework/framework/datawithstate/SingleState$State", "", "Lcom/bytedance/awemeopen/apps/framework/framework/datawithstate/SingleState$State;", ErrorCode.INIT, "LOADING", "INIT_SUCCESS", "INIT_FAIL", "LOAD_MORE_SUCCESS", "LOAD_MORE_FAIL", "ao_apps_framework_release"}, k = 1, mv = {1, 7, 1})
public final enum SingleState$State extends Enum<SingleState$State> {
    public static final SingleState$State INIT = null;
    public static final SingleState$State INIT_FAIL = null;
    public static final SingleState$State INIT_SUCCESS = null;
    public static final SingleState$State LOADING = null;
    public static final SingleState$State LOAD_MORE_FAIL = null;
    public static final SingleState$State LOAD_MORE_SUCCESS = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ SingleState$State[] f196938a = null;

    public static SingleState$State valueOf(String r100) {
        return (SingleState$State) a.a(SingleState$State.class, r100);
    }

    public static SingleState$State[] values() {
        return (SingleState$State[]) f196938a.clone();
    }

    static {
        SingleState$State r100 = new SingleState$State(ErrorCode.INIT, 0);
        INIT = r100;
        SingleState$State r101 = new SingleState$State("LOADING", 1);
        LOADING = r101;
        SingleState$State r102 = new SingleState$State("INIT_SUCCESS", 2);
        INIT_SUCCESS = r102;
        SingleState$State r103 = new SingleState$State("INIT_FAIL", 3);
        INIT_FAIL = r103;
        SingleState$State r104 = new SingleState$State("LOAD_MORE_SUCCESS", 4);
        LOAD_MORE_SUCCESS = r104;
        SingleState$State r105 = new SingleState$State("LOAD_MORE_FAIL", 5);
        LOAD_MORE_FAIL = r105;
        f196938a = new SingleState$State[]{r100, r101, r102, r103, r104, r105};
    }

    public SingleState$State(String r100, int r101) {
        super(r100, r101);
    }
}
