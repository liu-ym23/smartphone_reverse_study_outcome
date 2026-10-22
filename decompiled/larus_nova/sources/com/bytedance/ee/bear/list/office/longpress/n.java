package com.bytedance.ee.bear.list.office.longpress;

import java.util.Map;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes18.dex */
public final class n implements com.bytedance.ee.bear.d.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ com.bytedance.ee.bear.more.office.c f229060a;

    @Override // com.bytedance.ee.bear.d.b
    public final void b(String r100) {
        Intrinsics.checkNotNullParameter(r100, "type");
    }

    @Override // com.bytedance.ee.bear.d.b
    public final void c(String r100) {
        Intrinsics.checkNotNullParameter(r100, "type");
    }

    @Override // com.bytedance.ee.bear.d.b
    public final void d(String r100) {
        Intrinsics.checkNotNullParameter(r100, "type");
    }

    public n(com.bytedance.ee.bear.more.office.c r100) {
        this.f229060a = r100;
    }

    @Override // com.bytedance.ee.bear.d.b
    public final void a(String r100) {
        Intrinsics.checkNotNullParameter(r100, "exportType");
        m r101 = m.f229044a;
        m.h(this.f229060a, "ccm_docs_export_as_set_view", MapsKt.mapOf(TuplesKt.to("export_type", r100)));
    }

    @Override // com.bytedance.ee.bear.d.b
    public final void f(String r100) {
        Intrinsics.checkNotNullParameter(r100, "click");
        m r101 = m.f229044a;
        m.a(this.f229060a, "ccm_space_export_as_click", r100, null);
    }

    @Override // com.bytedance.ee.bear.d.b
    public final void e(String r100, String r101, String r102) {
        Intrinsics.checkNotNullParameter(r100, "click");
        Intrinsics.checkNotNullParameter(r101, "exportType");
        boolean r103 = true;
        Map r104 = MapsKt.mutableMapOf(new Pair[]{TuplesKt.to("export_type", r101)});
        if (r102 != null) goto L5;
    L8:
        if (r103 == true) goto L10;
        r104.put("export_content", r102);
    L10:
        m r105 = m.f229044a;
        m.a(this.f229060a, "ccm_docs_export_as_set_click", r100, r104);
        return;
    L5:
        if (r102.length() == 0) goto L8;
        r103 = false;
        goto L8
    }
}
