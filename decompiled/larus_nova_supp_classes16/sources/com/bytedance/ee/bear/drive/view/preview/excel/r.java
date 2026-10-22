package com.bytedance.ee.bear.drive.view.preview.excel;

import android.util.Base64;
import android.webkit.JavascriptInterface;
import com.alibaba.fastjson.JSONObject;
import io.reactivex.Flowable;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class r {
    public final /* synthetic */ ExcelRenderView a;

    @JavascriptInterface
    public void copyWithoutPermission() {
        tt5.a.h("ExcelRenderView", "copyWithoutPermission called");
    }

    @JavascriptInterface
    public void firstScreenPainted() {
        tt5.a.h("ExcelRenderView", "firstScreenPainted called");
        ExcelRenderView r0 = this.a;
        int r2 = ExcelRenderView.k;
        c95.c r1 = r0.c;
        if (r1 == null) goto L5;
        r1.b("html_excel");
    L5:
        j65.a.c(this.a.d, "ExcelRenderView");
    }

    @JavascriptInterface
    public String getInitialData() {
        tt5.a.h("ExcelRenderView", "getInitialData called");
        j r0 = this.a.i;
        int r1 = r0.g.a().getExcel_tab_data_max_size() * 1024;
        JSONObject r2 = new JSONObject();     // Catch: Exception -> L5
        r2.put("apiPrefix", r0.d.getApiPrefix());     // Catch: Exception -> L5
        r2.put("index", Integer.valueOf(r0.d.getIndex()));     // Catch: Exception -> L5
        r2.put("previewExtra", r0.d.getPreviewExtra());     // Catch: Exception -> L5
        r2.put("platform", "mobile");     // Catch: Exception -> L5
        r2.put("resourcePrefix", "file:///android_asset/excel/");     // Catch: Exception -> L5
        r2.put("copyable", Boolean.TRUE);     // Catch: Exception -> L5
        r2.put("perTabMaxSize", Integer.valueOf(r1));     // Catch: Exception -> L5
        r2.put("sizeExceededTipsText", r0.h.getResources().getString(2131888386));     // Catch: Exception -> L5
        String r3 = r2.toJSONString();     // Catch: Exception -> L5
    L8:
        return Base64.encodeToString(r3.getBytes(), 2);
    L5:
        e = move-exception;
        tt5.a.e("ExcelRenderModel", "getInitialData failed", e, false);
        r3 = "";
        goto L8
    }

    public r(ExcelRenderView r1) {
        this.a = r1;
    }

    @JavascriptInterface
    public void currentTabChanged(final String r4) {
        tt5.a.h("ExcelRenderView", "currentTabChanged called, tabIndex = " + r4);
        final j r0 = this.a.i;
        r0.getClass();
        this.a.j.add(Flowable.just(r4).observeOn(fo5.d.b()).subscribe(new f(r0, r4), new g(r4)));
    }

    @JavascriptInterface
    public void requestCachedData(final String r4) {
        tt5.a.h("ExcelRenderView", "requestCachedData called, subId = " + r4);
        j r0 = this.a.i;
        r0.getClass();
        this.a.j.add(Flowable.just("").observeOn(fo5.d.b()).flatMap(new i(r0, r4)).subscribe(new p(this, r4), new q(this, r4)));
    }
}
