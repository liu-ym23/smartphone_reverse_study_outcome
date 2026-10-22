package com.bytedance.frameworks.baselib.network.http.ok3.impl.metadispatch;

import java.util.Set;

/* JADX INFO: loaded from: classes19.dex */
public class TTMetaDispatchLog {
    public long dispatchCostMs;
    public Set<String> headerAdd;
    public Set<String> headerRm;
    public Set<String> queryAdd;
    public Set<String> queryRm;

    public TTMetaDispatchLog() {
        this.dispatchCostMs = 0;
    }
}
