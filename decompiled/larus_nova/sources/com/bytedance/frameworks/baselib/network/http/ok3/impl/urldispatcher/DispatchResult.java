package com.bytedance.frameworks.baselib.network.http.ok3.impl.urldispatcher;

import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes19.dex */
public class DispatchResult {
    public List<Long> mActionRuleIdList;
    public List<DispatchActionInfo> mDispatchActionChain;
    public String mDispatchedURL;
    public int mDropCode;

    public DispatchResult() {
        this.mDispatchedURL = "";
        this.mActionRuleIdList = new ArrayList();
        this.mDispatchActionChain = new ArrayList();
        this.mDropCode = -555;
    }
}
