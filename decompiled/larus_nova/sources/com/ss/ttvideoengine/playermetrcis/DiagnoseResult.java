package com.ss.ttvideoengine.playermetrcis;

import com.bytedance.ee.bear.middleground.feed.export.bean.DocFeed$Value$DataSource;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes34.dex */
public class DiagnoseResult implements IMetricsInfo {
    public int avgValue;
    public int maxValue;
    public int overCount;

    public void reset() {
        this.maxValue = 0;
        this.avgValue = 0;
        this.overCount = 0;
    }

    public DiagnoseResult() {
        this.maxValue = 0;
        this.avgValue = 0;
        this.overCount = 0;
    }

    @Override // com.ss.ttvideoengine.playermetrcis.IMetricsInfo
    public Map<String, Object> getMetricsInfo(String r100) {
        HashMap r101 = new HashMap();
        if (r100.equals("pow") == false) goto L8;
        r101.put("avg_pow", Integer.valueOf(this.avgValue));
        r101.put("max_pow", Integer.valueOf(this.maxValue));
        int r102 = this.overCount;
        if (r102 <= 0) goto L17;
        r101.put("over_pow", Integer.valueOf(r102));
    L17:
        return r101;
    L8:
        if (r100.equals(DocFeed$Value$DataSource.MEM) == false) goto L13;
        r101.put("avg_mem", Integer.valueOf(this.avgValue));
        r101.put("max_mem", Integer.valueOf(this.maxValue));
        int r103 = this.overCount;
        if (r103 <= 0) goto L17;
        r101.put("over_mem", Integer.valueOf(r103));
        goto L17
    L13:
        if (r100.equals("cpu") == false) goto L17;
        r101.put("avg_cpu", Integer.valueOf(this.avgValue));
        r101.put("max_cpu", Integer.valueOf(this.maxValue));
        int r104 = this.overCount;
        if (r104 <= 0) goto L17;
        r101.put("over_cpu", Integer.valueOf(r104));
        goto L17
    }
}
