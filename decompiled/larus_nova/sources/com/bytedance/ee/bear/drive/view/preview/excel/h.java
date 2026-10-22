package com.bytedance.ee.bear.drive.view.preview.excel;

import com.alibaba.fastjson.JSON;
import com.bytedance.ee.bear.drive.cache.t;
import com.bytedance.ee.bear.drive.view.preview.wrapper.z;
import io.reactivex.functions.Function;

/* JADX INFO: loaded from: classes16.dex */
public final class h implements Function<String, Boolean> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ j f224850a;

    public h(j r100) {
        this.f224850a = r100;
    }

    @Override // io.reactivex.functions.Function
    public final Boolean apply(String r100) throws Exception {
        j r101 = this.f224850a;
        t r102 = r101.f224853a;
        z r103 = r101.f224854b;
        String r104 = r103.f225848p;
        String r105 = r103.f225847o;
        String r106 = r103.f225846n;
        r102.getClass();
        y75.b r107 = t.b(r104, r105, r106, "PREVIEW_META_DATA_SUB_ID");
        if (r107 == null) goto L5;
        tt5.a.h("ExcelRenderModel", "find excelSubCacheModel");
        j r108 = this.f224850a;
        r108.f224855c = r107;
        r108.f224856d = (ExcelMeta) JSON.parseObject(r107.f566624f, ExcelMeta.class);
    L9:
        return Boolean.TRUE;
    L5:
        tt5.a.h("ExcelRenderModel", "add a new excelSubCacheModel");
        j r109 = this.f224850a;
        r109.f224856d = new ExcelMeta();
        this.f224850a.f224856d.setIndex(0);
        j r110 = this.f224850a;
        r110.f224856d.setApiPrefix(r110.f224854b.f225838f.values().iterator().next());
        j r111 = this.f224850a;
        r111.f224856d.setPreviewExtra(r111.f224854b.f225839g);
        y75.b r112 = new y75.b();
        j r113 = this.f224850a;
        z r114 = r113.f224854b;
        r112.f566619a = r114.f225848p;
        r112.f566620b = r114.f225847o;
        r112.f566621c = r114.f225846n;
        r112.f566622d = "PREVIEW_META_DATA_SUB_ID";
        r112.f566624f = JSON.toJSONString(r113.f224856d);
        this.f224850a.f224853a.getClass();
        t.n(r112);
        j r115 = this.f224850a;
        r115.f224855c = r112;
        j.a r116 = r115.f224857e;
        if (r116 == null) goto L9;
        r116.a(r112);
        goto L9
    }
}
