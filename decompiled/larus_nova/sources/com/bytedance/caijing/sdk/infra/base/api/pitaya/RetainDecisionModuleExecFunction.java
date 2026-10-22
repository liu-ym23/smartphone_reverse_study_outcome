package com.bytedance.caijing.sdk.infra.base.api.pitaya;

import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: classes15.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0004\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003j\u0002\b\u0004¨\u0006\u0005"}, d2 = {"Lcom/bytedance/caijing/sdk/infra/base/api/pitaya/RetainDecisionModuleExecFunction;", "", "DECIDE_AVAILABLE_WND_TYPE", "DECIDE_WND_TYPE", "DECIDE_STD_WITH_UNIFY_FILTER_WND_TYPE", "cj-host-service-api_release"}, k = 1, mv = {1, 6, 0})
public final enum RetainDecisionModuleExecFunction extends Enum<RetainDecisionModuleExecFunction> {
    public static final RetainDecisionModuleExecFunction DECIDE_AVAILABLE_WND_TYPE = null;
    public static final RetainDecisionModuleExecFunction DECIDE_STD_WITH_UNIFY_FILTER_WND_TYPE = null;
    public static final RetainDecisionModuleExecFunction DECIDE_WND_TYPE = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ RetainDecisionModuleExecFunction[] f202231a = null;

    public static RetainDecisionModuleExecFunction valueOf(String r100) {
        return (RetainDecisionModuleExecFunction) a.a(RetainDecisionModuleExecFunction.class, r100);
    }

    public static RetainDecisionModuleExecFunction[] values() {
        return (RetainDecisionModuleExecFunction[]) f202231a.clone();
    }

    static {
        RetainDecisionModuleExecFunction r100 = new RetainDecisionModuleExecFunction("DECIDE_AVAILABLE_WND_TYPE", 0);
        DECIDE_AVAILABLE_WND_TYPE = r100;
        RetainDecisionModuleExecFunction r101 = new RetainDecisionModuleExecFunction("DECIDE_WND_TYPE", 1);
        DECIDE_WND_TYPE = r101;
        RetainDecisionModuleExecFunction r102 = new RetainDecisionModuleExecFunction("DECIDE_STD_WITH_UNIFY_FILTER_WND_TYPE", 2);
        DECIDE_STD_WITH_UNIFY_FILTER_WND_TYPE = r102;
        f202231a = new RetainDecisionModuleExecFunction[]{r100, r101, r102};
    }

    public RetainDecisionModuleExecFunction(String r100, int r101) {
        super(r100, r101);
    }
}
