package com.bytedance.dtrace;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes15.dex */
public class TraceMethodItem implements Serializable {
    public int action;
    public String className;
    public Map<String, Object> extraData;
    public boolean isConstructor;
    public String methodName;
    public String methodSign;
    public int traceThreadMode;

    public TraceMethodItem() {
        this.extraData = new HashMap();
        this.traceThreadMode = TraceThreadMode.All.getValue();
    }
}
