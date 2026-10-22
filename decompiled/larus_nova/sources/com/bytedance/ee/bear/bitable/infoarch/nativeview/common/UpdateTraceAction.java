package com.bytedance.ee.bear.bitable.infoarch.nativeview.common;

import com.bytedance.ee.bear.bitable.uikit.Action;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes15.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\u0005¨\u0006\t"}, d2 = {"Lcom/bytedance/ee/bear/bitable/infoarch/nativeview/common/UpdateTraceAction;", "Lcom/bytedance/ee/bear/bitable/uikit/Action;", "traceId", "", "<init>", "(Ljava/lang/String;)V", "getTraceId", "()Ljava/lang/String;", "setTraceId", "docs-bitable-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class UpdateTraceAction extends Action {
    private String traceId;

    public final String getTraceId() {
        return this.traceId;
    }

    public UpdateTraceAction(String r100) {
        Intrinsics.checkNotNullParameter(r100, "traceId");
        super(r100, "BindViewLifecycleTraceId");
        this.traceId = r100;
    }

    public final void setTraceId(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.traceId = r100;
    }
}
