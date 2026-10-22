package com.bytedance.ee.bear.bitable.celleditor.bean;

import com.bytedance.ee.util.io.NonProguard;
import java.util.Map;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes15.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010$\n\u0002\u0010\u0000\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003R\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001e\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u0010\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR(\u0010\u0011\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0013\u0018\u00010\u0012X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017¨\u0006\u0018"}, d2 = {"Lcom/bytedance/ee/bear/bitable/celleditor/bean/ReportEventModel;", "Lcom/bytedance/ee/util/io/NonProguard;", "<init>", "()V", "eventName", "", "getEventName", "()Ljava/lang/String;", "setEventName", "(Ljava/lang/String;)V", "reportType", "", "getReportType", "()Ljava/lang/Integer;", "setReportType", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "params", "", "", "getParams", "()Ljava/util/Map;", "setParams", "(Ljava/util/Map;)V", "docs-bitable-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ReportEventModel implements NonProguard {
    private String eventName;
    private Map<String, ? extends Object> params;
    private Integer reportType;

    public ReportEventModel() {
    }

    public final String getEventName() {
        return this.eventName;
    }

    public final Map<String, Object> getParams() {
        return this.params;
    }

    public final Integer getReportType() {
        return this.reportType;
    }

    public final void setEventName(String r100) {
        this.eventName = r100;
    }

    public final void setParams(Map<String, ? extends Object> r100) {
        this.params = r100;
    }

    public final void setReportType(Integer r100) {
        this.reportType = r100;
    }
}
