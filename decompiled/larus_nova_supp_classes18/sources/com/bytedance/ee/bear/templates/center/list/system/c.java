package com.bytedance.ee.bear.templates.center.list.system;

import com.bytedance.ee.bear.contract.i0;
import com.bytedance.ee.bear.contract.j;
import com.bytedance.ee.bear.templates.data.CategoryTab;
import com.bytedance.ee.bear.templates.data.TemplateGroupTab;
import com.bytedance.ee.bear.templates.n;
import java.util.Locale;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class c extends zn5.a {
    public final long d;

    @Override // zn5.a
    public final TemplateGroupTab c(JSONObject r24) {
        Locale r2 = ((i0) org.koin.java.a.c(i0.class, null, null, 6)).c();
        boolean r4 = j.a.a.getNetworkState().a();
        if (r24 == null) goto L5;
        JSONArray r5 = r24.optJSONArray("template_list");
    L7:
        if (r24 == null) goto L9;
        boolean r1 = r24.optBoolean("has_more");
    L10:
        int r7 = n.a;
        Intrinsics.checkNotNull(r2);
        return new TemplateGroupTab(this.a, CollectionsKt.arrayListOf(new CategoryTab[]{new CategoryTab(null, CollectionsKt.arrayListOf(new ao5.a[]{new ao5.a(null, r1, n.b(r5, null, r2, r4), this.d, 113)}), this.d, 0, this.a, 9, null)}), r1, false, null, null, null, 0, false, 504, null);
    L9:
        r1 = false;
        goto L10
    L5:
        r5 = null;
        goto L7
    }

    public c(int r2, String r3, boolean r4, long r5) {
        Intrinsics.checkNotNullParameter(r3, "cacheKey");
        super(r2, r4, r3);
        this.d = r5;
    }
}
