package com.bytedance.ee.bear.templates.center.list.custom;

import android.content.Context;
import androidx.fragment.app.FragmentActivity;
import com.bytedance.ee.bear.contract.i0;
import com.bytedance.ee.bear.contract.j;
import com.bytedance.ee.bear.templates.data.CategoryTab;
import com.bytedance.ee.bear.templates.data.TemplateGroupTab;
import com.bytedance.ee.bear.templates.data.TemplateV4;
import com.bytedance.ee.bear.templates.n;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Locale;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class c extends zn5.a {
    public final Context d;
    public final boolean e;
    public final boolean f;

    @Override // zn5.a
    public final TemplateGroupTab c(JSONObject r40) {
        JSONArray r3 = null;
        Locale r2 = ((i0) org.koin.java.a.c(i0.class, null, null, 6)).c();
        boolean r4 = j.a.a.getNetworkState().a();
        if (r40 == null) goto L5;
        boolean r11 = r40.optBoolean("has_data", true);
    L7:
        if (r40 == null) goto L9;
        boolean r10 = r40.optBoolean("has_more");
    L10:
        if (r40 == null) goto L13;
        String r7 = r40.optString("share_index");
        if (r7 == null) goto L13;
    L14:
        String r19 = r7;
        if (r40 == null) goto L17;
        JSONObject r8 = r40.optJSONObject("users");
    L18:
        if (r40 == null) goto L20;
        JSONArray r9 = r40.optJSONArray("own");
    L21:
        int r12 = n.a;
        Intrinsics.checkNotNull(r2);
        ArrayList r13 = n.b(r9, r8, r2, r4);
        Iterator r14 = r13.iterator();
    L23:
        if (r14.hasNext() == false) goto L25;
        ((TemplateV4) r14.next()).setCategoryId(String.valueOf(5));
        goto L23
    L25:
        String r21 = this.d.getString(2131887936);
        ao5.a r15 = new ao5.a(r21, false, r13, 5, 112);
        CategoryTab r29 = new CategoryTab(r21, CollectionsKt.arrayListOf(new ao5.a[]{r15}), 5, 0, this.a, 8, null);
        if (r40 == null) goto L28;
        r3 = r40.optJSONArray("share");
    L28:
        ArrayList r1 = n.b(r3, r8, r2, r4);
        Iterator r5 = r1.iterator();
    L30:
        if (r5.hasNext() == false) goto L32;
        ((TemplateV4) r5.next()).setCategoryId(String.valueOf(6));
        goto L30
    L32:
        String r22 = this.d.getString(2131887980);
        ao5.a r6 = new ao5.a(r22, r10, r1, 6, 112);
        CategoryTab r16 = new CategoryTab(r22, CollectionsKt.arrayListOf(new ao5.a[]{r6}), 6, 0, this.a, 8, null);
        CategoryTab r17 = new CategoryTab(this.d.getString(2131887879), CollectionsKt.arrayListOf(new ao5.a[]{r15, r6}), 0, 0, this.a, 12, null);
        if (r13.isEmpty() == false) goto L40;
        if (r1.isEmpty() == false) goto L40;
        if (this.f == true) goto L40;
        ArrayList r18 = new ArrayList();
    L44:
        return new TemplateGroupTab(this.a, r18, r10, r11, r19, null, null, 0, false, 448, null);
    L40:
        if (this.e == false) goto L42;
        r18 = CollectionsKt.arrayListOf(new CategoryTab[]{r16});
        goto L44
    L42:
        r18 = CollectionsKt.arrayListOf(new CategoryTab[]{r17, r29, r16});
        goto L44
    L20:
        r9 = null;
        goto L21
    L17:
        r8 = null;
    L13:
        r7 = "0";
        goto L14
    L9:
        r10 = false;
        goto L10
    L5:
        r11 = true;
        goto L7
    }

    public c(FragmentActivity r2, int r3, String r4, boolean r5, boolean r6, boolean r7) {
        Intrinsics.checkNotNullParameter(r2, "context");
        Intrinsics.checkNotNullParameter(r4, "cacheKey");
        super(r3, r5, r4);
        this.d = r2;
        this.e = r6;
        this.f = r7;
    }
}
