package com.bytedance.ee.bear.bitable.jsapi.report.common;

import com.bytedance.ee.util.io.NonProguard;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes15.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u00002\u00020\u0001B7\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0016\u0010\u0006\u001a\u0012\u0012\u0004\u0012\u00020\b0\u0007j\b\u0012\u0004\u0012\u00020\b`\t¢\u0006\u0004\b\n\u0010\u000bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\rR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\rR!\u0010\u0006\u001a\u0012\u0012\u0004\u0012\u00020\b0\u0007j\b\u0012\u0004\u0012\u00020\b`\t¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011¨\u0006\u0012"}, d2 = {"Lcom/bytedance/ee/bear/bitable/jsapi/report/common/ReportListModel;", "Lcom/bytedance/ee/util/io/NonProguard;", "traceId", "", "eventName", "biz", "list", "Ljava/util/ArrayList;", "Lcom/bytedance/ee/bear/bitable/jsapi/report/common/ReportModel;", "Lkotlin/collections/ArrayList;", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/ArrayList;)V", "getTraceId", "()Ljava/lang/String;", "getEventName", "getBiz", "getList", "()Ljava/util/ArrayList;", "docs-bitable-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ReportListModel implements NonProguard {
    private final String biz;
    private final String eventName;
    private final ArrayList<ReportModel> list;
    private final String traceId;

    public final String getBiz() {
        return this.biz;
    }

    public final String getEventName() {
        return this.eventName;
    }

    public final ArrayList<ReportModel> getList() {
        return this.list;
    }

    public final String getTraceId() {
        return this.traceId;
    }

    public ReportListModel(String r100, String r101, String r102, ArrayList<ReportModel> r103) {
        Intrinsics.checkNotNullParameter(r100, "traceId");
        Intrinsics.checkNotNullParameter(r101, "eventName");
        Intrinsics.checkNotNullParameter(r102, "biz");
        Intrinsics.checkNotNullParameter(r103, "list");
        this.traceId = r100;
        this.eventName = r101;
        this.biz = r102;
        this.list = r103;
    }
}
