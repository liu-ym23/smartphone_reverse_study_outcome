package com.bytedance.ee.bear.templates.search.base;

import android.text.SpannableStringBuilder;
import android.text.style.ForegroundColorSpan;
import com.bytedance.ee.bear.contract.i0;
import com.bytedance.ee.bear.contract.j;
import com.bytedance.ee.bear.templates.data.CategoryTab;
import com.bytedance.ee.bear.templates.data.TemplateGroupTab;
import com.bytedance.ee.bear.templates.n;
import com.bytedance.ee.bear.wikiv2.browser.plugin.WikiFolderPushPlugin;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Locale;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class BaseSearchParser extends zn5.a {
    public final String d;

    public BaseSearchParser(String r4) {
        Intrinsics.checkNotNullParameter(r4, "searchKey");
        super(2, false, "");
        this.d = r4;
    }

    @Override // zn5.a
    public final TemplateGroupTab c(JSONObject r31) {
        JSONArray r3 = null;
        Locale r2 = ((i0) org.koin.java.a.c(i0.class, null, null, 6)).c();
        boolean r4 = j.a.a.getNetworkState().a();
        if (r31 == null) goto L5;
        boolean r11 = r31.optBoolean("has_data", true);
    L7:
        if (r31 == null) goto L9;
        boolean r10 = r31.optBoolean("has_more");
    L10:
        if (r31 == null) goto L13;
        String r7 = r31.optString("share_index");
        if (r7 == null) goto L13;
    L14:
        String r19 = r7;
        if (r31 == null) goto L17;
        JSONObject r8 = r31.optJSONObject("authors");
    L18:
        if (r31 == null) goto L21;
        String r9 = r31.optString("buffer");
        if (r9 == null) goto L21;
    L22:
        String r20 = r9;
        if (r31 == null) goto L25;
        r3 = r31.optJSONArray(WikiFolderPushPlugin.DATA);
    L25:
        int r1 = n.a;
        Intrinsics.checkNotNull(r2);
        ao5.a r5 = new ao5.a("", false, n.b(r3, r8, r2, r4), 5, 112);
        final Ref.IntRef r6 = new Ref.IntRef();
        ArrayList r12 = CollectionsKt.arrayListOf(new ao5.a[]{r5});
        Function1<Integer, Unit> r13 = new BaseSearchParser$parseDataObj$categoryList$1(r6);
        ArrayList r14 = new ArrayList();
        ArrayList r15 = new ArrayList();
        Iterator r16 = r12.iterator();
    L27:
        if (r16.hasNext() == false) goto L29;
        r15.addAll(((ao5.a) r16.next()).c);
        goto L27
    L29:
        r13.invoke(Integer.valueOf(r15.size()));
        String r17 = xo5.a.c(eu5.b.a, 2131888000, "SearchKeyWord", this.d);
        SpannableStringBuilder r18 = new SpannableStringBuilder(r17);
        r18.setSpan(new ForegroundColorSpan(eu5.b.a.getResources().getColor(2131103404)), 0, this.d.length(), 33);
        ao5.a r21 = new ao5.a(r18, r10, r15, 0, 120);
        ArrayList r22 = new ArrayList();
        r22.add(r21);
        Intrinsics.checkNotNull(r17);
        r14.add(new CategoryTab(r17, r22, 0, 0, 2, 12, null));
        return new TemplateGroupTab(2, r14, r10, r11, r19, null, r20, r6.element, false, 256, null);
    L21:
        r9 = "";
        goto L22
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
}
