package com.larksuite.component.card.monitor;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes24.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010$\n\u0002\u0010\u0000\n\u0002\b\u0002\b\u0016\u0018\u00002\u00020\u0001B\u001b\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\u0014\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\f0\u000bH\u0016J\u0014\u0010\r\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\f0\u000bH\u0016R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\b¨\u0006\u000e"}, d2 = {"Lcom/larksuite/component/card/monitor/UniversalCardMonitorData;", "Ljava/io/Serializable;", "businessType", "", "scene", "<init>", "(Ljava/lang/String;Ljava/lang/String;)V", "getBusinessType", "()Ljava/lang/String;", "getScene", "getMonitorCategoryMap", "", "", "getBusinessMonitorMap", "universalcard_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public class UniversalCardMonitorData implements Serializable {
    private final String businessType;
    private final String scene;

    public Map<String, Object> getBusinessMonitorMap() {
        HashMap r100 = new HashMap();
        String r101 = this.businessType;
        if (r101 == null) goto L5;
        r100.put("scene", r101);
    L5:
        return r100;
    }

    public Map<String, Object> getMonitorCategoryMap() {
        HashMap r100 = new HashMap();
        String r101 = this.businessType;
        if (r101 == null) goto L5;
        r100.put("render_business_type", r101);
    L5:
        String r102 = this.scene;
        if (r102 == null) goto L8;
        r100.put("scene", r102);
    L8:
        return r100;
    }

    public final String getBusinessType() {
        return this.businessType;
    }

    public final String getScene() {
        return this.scene;
    }

    public UniversalCardMonitorData(String r100, String r101) {
        this.businessType = r100;
        this.scene = r101;
    }
}
