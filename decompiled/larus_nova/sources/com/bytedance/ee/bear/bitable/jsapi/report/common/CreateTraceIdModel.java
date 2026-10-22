package com.bytedance.ee.bear.bitable.jsapi.report.common;

import com.bytedance.ee.util.io.NonProguard;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes15.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0011\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Lcom/bytedance/ee/bear/bitable/jsapi/report/common/CreateTraceIdModel;", "Lcom/bytedance/ee/util/io/NonProguard;", "parentTrace", "", "<init>", "(Ljava/lang/String;)V", "getParentTrace", "()Ljava/lang/String;", "docs-bitable-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class CreateTraceIdModel implements NonProguard {
    private final String parentTrace;

    public final String getParentTrace() {
        return this.parentTrace;
    }

    public CreateTraceIdModel(String r100) {
        this.parentTrace = r100;
    }
}
