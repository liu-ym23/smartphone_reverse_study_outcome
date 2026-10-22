package com.bytedance.ee.bear.list.office.longpress;

import com.bytedance.ee.docsdk.impl.document.plugins.offline.storage.ResourceData;
import java.util.Map;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class n implements com.bytedance.ee.bear.d.b {
    public final /* synthetic */ com.bytedance.ee.bear.more.office.c a;

    public final void b(String r2) {
        Intrinsics.checkNotNullParameter(r2, ResourceData.KEY_TYPE);
    }

    public final void c(String r2) {
        Intrinsics.checkNotNullParameter(r2, ResourceData.KEY_TYPE);
    }

    public final void d(String r2) {
        Intrinsics.checkNotNullParameter(r2, ResourceData.KEY_TYPE);
    }

    public n(com.bytedance.ee.bear.more.office.c r1) {
        this.a = r1;
    }

    public final void a(String r3) {
        Intrinsics.checkNotNullParameter(r3, "exportType");
        m r0 = m.a;
        m.h(this.a, "ccm_docs_export_as_set_view", MapsKt.mapOf(TuplesKt.to("export_type", r3)));
    }

    public final void f(String r4) {
        Intrinsics.checkNotNullParameter(r4, "click");
        m r0 = m.a;
        m.a(this.a, "ccm_space_export_as_click", r4, null);
    }

    public final void e(String r4, String r5, String r6) {
        Intrinsics.checkNotNullParameter(r4, "click");
        Intrinsics.checkNotNullParameter(r5, "exportType");
        boolean r0 = true;
        Map r7 = MapsKt.mutableMapOf(new Pair[]{TuplesKt.to("export_type", r5)});
        if (r6 != null) goto L5;
    L8:
        if (r0 == true) goto L10;
        r7.put("export_content", r6);
    L10:
        m r8 = m.a;
        m.a(this.a, "ccm_docs_export_as_set_click", r4, r7);
        return;
    L5:
        if (r6.length() == 0) goto L8;
        r0 = false;
        goto L8
    }
}
