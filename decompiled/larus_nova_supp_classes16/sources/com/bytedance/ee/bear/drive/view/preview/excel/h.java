package com.bytedance.ee.bear.drive.view.preview.excel;

import com.alibaba.fastjson.JSON;
import com.bytedance.ee.bear.drive.cache.t;
import com.bytedance.ee.bear.drive.view.preview.wrapper.z;
import io.reactivex.functions.Function;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class h implements Function<String, Boolean> {
    public final /* synthetic */ j a;

    public h(j r1) {
        this.a = r1;
    }

    public final Object apply(Object r5) throws Exception {
        String r6 = (String) r5;
        j r7 = this.a;
        t r0 = r7.a;
        z r8 = r7.b;
        String r1 = r8.p;
        String r2 = r8.o;
        String r9 = r8.n;
        r0.getClass();
        y75.b r10 = t.b(r1, r2, r9, "PREVIEW_META_DATA_SUB_ID");
        if (r10 == null) goto L5;
        tt5.a.h("ExcelRenderModel", "find excelSubCacheModel");
        j r3 = this.a;
        r3.c = r10;
        r3.d = (ExcelMeta) JSON.parseObject(r10.f, ExcelMeta.class);
    L9:
        return Boolean.TRUE;
    L5:
        tt5.a.h("ExcelRenderModel", "add a new excelSubCacheModel");
        j r11 = this.a;
        r11.d = new ExcelMeta();
        this.a.d.setIndex(0);
        j r12 = this.a;
        r12.d.setApiPrefix(r12.b.f.values().iterator().next());
        j r13 = this.a;
        r13.d.setPreviewExtra(r13.b.g);
        y75.b r14 = new y75.b();
        j r4 = this.a;
        z r16 = r4.b;
        r14.a = r16.p;
        r14.b = r16.o;
        r14.c = r16.n;
        r14.d = "PREVIEW_META_DATA_SUB_ID";
        r14.f = JSON.toJSONString(r4.d);
        this.a.a.getClass();
        t.n(r14);
        j r17 = this.a;
        r17.c = r14;
        j.a r18 = r17.e;
        if (r18 == null) goto L9;
        r18.a(r14);
        goto L9
    }
}
