package com.bytedance.locallife.dito.common.plugin;

import com.google.gson.annotations.Expose;
import java.util.LinkedHashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes21.dex */
public final class y extends com.bytedance.locallife.dito.provider.c<Map<String, Object>> {

    @Expose
    private transient x metrics;

    @Expose
    private transient String pageUrl;

    @Expose
    private transient int resultFrom;

    public static final class a {
    }

    static {
    }

    public final x e() {
        return this.metrics;
    }

    public final String f() {
        return this.pageUrl;
    }

    public final int g() {
        return this.resultFrom;
    }

    public final void h(x r100) {
        this.metrics = r100;
        Map<String, Object> r101 = c();
        if (r101 == null) goto L6;
        r101.put("metrics", r100);
        return;
    }

    public final void i(String r100) {
        this.pageUrl = r100;
        Map<String, Object> r101 = c();
        if (r101 == null) goto L6;
        r101.put("page_url", r100);
        return;
    }

    public final void j(int r100) {
        this.resultFrom = r100;
        Map<String, Object> r101 = c();
        if (r101 == null) goto L6;
        r101.put("result_from", Integer.valueOf(r100));
        return;
    }

    public y(int r100, String r101) {
        super(r100, r101, new LinkedHashMap());
        this.resultFrom = -1;
    }
}
