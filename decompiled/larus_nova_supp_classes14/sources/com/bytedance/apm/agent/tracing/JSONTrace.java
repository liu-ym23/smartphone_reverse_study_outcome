package com.bytedance.apm.agent.tracing;

import com.bytedance.apm.agent.filter.ISendFilter;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public class JSONTrace implements ISendFilter {
    public JSONTrace() {
    }

    @Override // com.bytedance.apm.agent.filter.ISendFilter
    public boolean isSend() {
        return false;
    }
}
