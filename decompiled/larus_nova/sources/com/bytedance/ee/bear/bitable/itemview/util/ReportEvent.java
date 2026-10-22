package com.bytedance.ee.bear.bitable.itemview.util;

import com.bytedance.ee.util.io.NonProguard;
import java.util.Map;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes15.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010$\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003R\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR(\u0010\n\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000f¨\u0006\u0010"}, d2 = {"Lcom/bytedance/ee/bear/bitable/itemview/util/ReportEvent;", "Lcom/bytedance/ee/util/io/NonProguard;", "<init>", "()V", "event", "", "getEvent", "()Ljava/lang/String;", "setEvent", "(Ljava/lang/String;)V", "params", "", "getParams", "()Ljava/util/Map;", "setParams", "(Ljava/util/Map;)V", "docs-bitable-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ReportEvent implements NonProguard {
    private String event;
    private Map<String, String> params;

    public ReportEvent() {
    }

    public final String getEvent() {
        return this.event;
    }

    public final Map<String, String> getParams() {
        return this.params;
    }

    public final void setEvent(String r100) {
        this.event = r100;
    }

    public final void setParams(Map<String, String> r100) {
        this.params = r100;
    }
}
