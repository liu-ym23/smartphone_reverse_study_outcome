package com.bytedance.ee.bear.templates.center.list.business;

import com.bytedance.ee.bear.contract.i0;
import com.bytedance.ee.bear.contract.j;
import com.bytedance.ee.bear.templates.data.CategoryTab;
import com.bytedance.ee.bear.templates.data.TemplateGroupTab;
import com.bytedance.ee.bear.templates.n;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Locale;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class b extends zn5.a {
    @Override // zn5.a
    public final TemplateGroupTab c(JSONObject r30) {
        JSONArray r3 = null;
        Locale r2 = ((i0) org.koin.java.a.c(i0.class, null, null, 6)).c();
        boolean r4 = j.a.a.getNetworkState().a();
        if (r30 == null) goto L5;
        boolean r11 = r30.optBoolean("has_data", true);
    L6:
        if (r30 == null) goto L8;
        boolean r10 = r30.optBoolean("has_more");
    L9:
        if (r30 == null) goto L12;
        String r7 = r30.optString("share_index");
        if (r7 == null) goto L12;
    L13:
        String r19 = r7;
        if (r30 == null) goto L16;
        JSONObject r8 = r30.optJSONObject("users");
    L17:
        if (r30 == null) goto L19;
        r3 = r30.optJSONArray("categories");
    L19:
        Intrinsics.checkNotNull(r2);
        ArrayList r1 = new ArrayList();
        if (r3 == null) goto L25;
        int r9 = r3.length();
        int r12 = 0;
    L23:
        if (r12 >= r9) goto L25;
        JSONObject r13 = r3.optJSONObject(r12);
        Intrinsics.checkNotNull(r13);
        String r14 = r13.optString("name");
        long r16 = r13.optLong("category_id", -1);
        ArrayList r15 = n.b(r13.optJSONArray("templates"), r8, r2, r4);
        Intrinsics.checkNotNull(r14);
        r1.add(new ao5.a(r14, r10, r15, r16, 112));
        r12 = r12 + 1;
    L25:
        int r5 = this.a;
        ArrayList r17 = new ArrayList();
        Iterator r6 = r1.iterator();
    L27:
        if (r6.hasNext() == false) goto L30;
        ao5.a r18 = (ao5.a) r6.next();
        r17.add(new CategoryTab(r18.a, CollectionsKt.arrayListOf(new ao5.a[]{r18}), 0, 0, r5, 12, null));
        goto L27
    L30:
        return new TemplateGroupTab(this.a, r17, r10, r11, r19, null, null, 0, false, 448, null);
    L16:
        r8 = null;
    L12:
        r7 = "0";
        goto L13
    L8:
        r10 = false;
        goto L9
    L5:
        r11 = true;
        goto L6
    }

    public b(int r2, String r3, boolean r4) {
        Intrinsics.checkNotNullParameter(r3, "cacheKey");
        super(r2, r4, r3);
    }
}
