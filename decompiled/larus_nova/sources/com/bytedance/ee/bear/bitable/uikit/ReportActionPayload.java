package com.bytedance.ee.bear.bitable.uikit;

import java.util.HashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes16.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0016\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\u0003¨\u0006\n"}, d2 = {"Lcom/bytedance/ee/bear/bitable/uikit/ReportActionPayload;", "Lcom/bytedance/ee/bear/bitable/uikit/ActionPayload;", "scene", "", "<init>", "(Ljava/lang/String;)V", "put", "", "key", "value", "docs-bitable-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ReportActionPayload extends ActionPayload {
    public ReportActionPayload(String r100) {
        Intrinsics.checkNotNullParameter(r100, "scene");
        setAction("ItemViewReportTea");
        setTeaParams(new HashMap());
        setTeaScene(r100);
    }

    public final void put(String r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "key");
        Intrinsics.checkNotNullParameter(r101, "value");
        HashMap<String, String> r102 = getTeaParams();
        if (r102 == null) goto L6;
        String r103 = r102.put(r100, r101);
        return;
    }
}
