package com.ss.android.lark.optrace.extension.clientRequest;

import com.ss.android.lark.optrace.extension.TracingExtension;

/* JADX INFO: loaded from: classes37.dex */
public abstract class TrancingClientRequestExtension implements TracingExtension {
    public TrancingClientRequestExtension() {
    }

    public abstract String getRequestId();

    @Override // com.ss.android.lark.optrace.extension.TracingExtension
    public abstract /* synthetic */ TracingExtension mergeExtension(TracingExtension r100);

    public abstract void setRequestId(String r100);
}
