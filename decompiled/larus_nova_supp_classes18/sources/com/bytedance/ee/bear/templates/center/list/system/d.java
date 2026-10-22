package com.bytedance.ee.bear.templates.center.list.system;

import android.content.Context;
import androidx.fragment.app.FragmentActivity;
import com.bytedance.ee.bear.contract.i0;
import com.bytedance.ee.bear.contract.j;
import com.bytedance.ee.bear.templates.data.CategoryTab;
import com.bytedance.ee.bear.templates.data.TemplateGroupTab;
import com.bytedance.ee.bear.templates.data.TemplateV4;
import com.bytedance.ee.bear.templates.n;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Locale;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class d extends zn5.a {
    public final Context d;
    public final int e;
    public final String f;
    public final SystemTemplateListModel g;

    public static final class a {
    }

    static {
    }

    @Override // zn5.a
    public final TemplateGroupTab a() {
        return this.g.S7(this.e, this.a, new Throwable("json is null"));
    }

    @Override // zn5.a
    public final TemplateGroupTab b(Throwable r4) {
        Intrinsics.checkNotNullParameter(r4, "err");
        return this.g.S7(this.e, this.a, r4);
    }

    @Override // zn5.a
    public final TemplateGroupTab c(JSONObject r61) {
        Locale r2 = ((i0) org.koin.java.a.c(i0.class, null, null, 6)).c();
        boolean r4 = j.a.a.getNetworkState().a();
        if (r61 == null) goto L5;
        JSONArray r5 = r61.optJSONArray("category_metas");
    L6:
        if (r61 == null) goto L8;
        JSONObject r6 = r61.optJSONObject("template_list");
    L9:
        if (r61 == null) goto L11;
        JSONArray r7 = r61.optJSONArray("recommend_list");
    L12:
        if (r61 == null) goto L14;
        JSONObject r1 = r61.optJSONObject("template_metas");
    L16:
        if (this.g.h().isOnlyNewLarkForm() == false) goto L18;
        String r8 = this.g.h().getTemplateSource();
    L19:
        Intrinsics.checkNotNull(r2);
        HashMap r10 = new HashMap();
        if (r1 == null) goto L28;
        Iterator<String> r11 = r1.keys();
    L24:
        if (r11.hasNext() == false) goto L28;
        String r12 = r11.next();
        JSONObject r13 = r1.optJSONObject(r12);
        if (r13 == null) goto L24;
        TemplateV4 r14 = n.a(r13, null, r2, r4);
        r14.setTemplateSource(r8);
        r10.put(r12, r14);
    L28:
        ArrayList r3 = new ArrayList();
        if (r6 == null) goto L58;
        if (r5 == null) goto L58;
        ArrayList r9 = new ArrayList();
        int r15 = r5.length();
        int r16 = 0;
    L33:
        if (r16 >= r15) goto L38;
        JSONObject r17 = r5.optJSONObject(r16);
        if (r17 == null) goto L37;
        String r18 = r17.optString("name");
        long r19 = r17.optLong("category_id", -1);
        String r110 = r17.optString("description");
        Intrinsics.checkNotNull(r110);
        Intrinsics.checkNotNull(r18);
        r9.add(new ao5.b(r19, r110, r18));
    L37:
        r16 = r16 + 1;
        goto L33
    L38:
        HashMap r20 = new HashMap();
        Iterator<String> r21 = r6.keys();
    L40:
        if (r21.hasNext() == false) goto L42;
        String r22 = r21.next();
        r20.put(r22, r6.optJSONArray(r22));
        goto L40
    L42:
        Iterator r23 = r9.iterator();
    L44:
        if (r23.hasNext() == false) goto L58;
        ao5.b r24 = (ao5.b) r23.next();
        JSONArray r25 = (JSONArray) r20.get(String.valueOf(r24.a));
        if (r25 == null) goto L44;
        ArrayList r26 = new ArrayList();
        int r27 = r25.length();
        int r111 = 0;
    L48:
        if (r111 >= r27) goto L53;
        TemplateV4 r112 = (TemplateV4) r10.get(r25.optString(r111));
        if (r112 == null) goto L52;
        r26.add(r112);
    L52:
        r111 = r111 + 1;
        goto L48
    L53:
        String r28 = r24.c;
        if (r28 != null) goto L56;
        String r113 = "";
    L57:
        r3.add(new ao5.a(r113, true, r26, r24.a, 112));
        goto L44
    L56:
        r113 = r28;
    L58:
        ArrayList r29 = new ArrayList();
        if (r7 == null) goto L67;
        int r30 = r7.length();
        int r31 = 0;
    L61:
        if (r31 >= r30) goto L67;
        TemplateV4 r114 = (TemplateV4) r10.get(r7.optString(r31));
        if (r114 == null) goto L65;
        r29.add(TemplateV4.copy$default(r114, null, null, 0, null, null, null, 0, null, null, null, 0, null, null, null, null, 0, 0, 0, 0, 0, null, null, 0, null, null, null, false, 0, null, null, false, null, 0, 0, null, -1, 7, null));
    L65:
        r31 = r31 + 1;
    L67:
        if (com.bytedance.ee.bear.appsetting.c.a.a.h("bitable.new.survey.from.block.disable") == true) goto L82;
        if (Intrinsics.areEqual("create_new", this.f) == true) goto L77;
        if (Intrinsics.areEqual("create_new_recent", this.f) == true) goto L77;
        if (Intrinsics.areEqual("create_new_folder_block", this.f) == true) goto L77;
        if (this.g.h().getCreateBlank() == true) goto L77;
    L92:
        ao5.a r32 = new ao5.a(this.d.getString(2131887921), false, r29, 0, 120);
        if (this.g.h().isOnlyNewLarkForm() == false) goto L100;
        String r115 = com.bytedance.ee.bear.templates.a.a();
        if ((!StringsKt.isBlank(r115)) == false) goto L97;
        String r33 = r115;
    L98:
        if (r33 == null) goto L100;
        TemplateV4 r116 = new TemplateV4(r115, null, this.e, null, null, null, 0, null, null, null, 0, null, null, null, null, 0, 0, 0, 0, 0, null, null, 0, null, null, null, false, 0, null, null, true, this.g.h().getTemplateSource(), 0, 0, null, 1073741818, 7, null);
    L101:
        ArrayList r34 = new ArrayList();
        String r117 = this.d.getString(2131887879);
        ArrayList r35 = new ArrayList();
        if (r116 == null) goto L104;
        ListProtector.add(r32.c, 0, r116);
    L104:
        r35.add(r32);
        r35.addAll(r3);
        r34.add(new CategoryTab(r117, r35, 0, 0, this.a, 12, null));
        Iterator r36 = r3.iterator();
    L106:
        if (r36.hasNext() == false) goto L109;
        ao5.a r37 = (ao5.a) r36.next();
        r34.add(new CategoryTab(r37.a, CollectionsKt.arrayListOf(new ao5.a[]{new ao5.a(r37.a, r37.b, new ArrayList(r37.c), r37.d, 96)}), r37.d, 1, this.a));
        goto L106
    L109:
        return new TemplateGroupTab(this.a, r34, false, false, null, null, null, 0, false, 508, null);
    L97:
        r33 = null;
    L100:
        r116 = null;
    L77:
        if (this.e == (-1)) goto L92;
        if (this.g.h().isOnlyNewLarkForm() == true) goto L92;
        ListProtector.add(r29, 0, new TemplateV4(null, null, this.e, null, null, null, 0, null, null, null, 0, null, null, null, null, 0, 0, 0, 0, 0, null, null, 0, null, null, null, false, 0, null, null, true, null, 0, 0, null, -1073741829, 7, null));
        goto L92
    L82:
        if (Intrinsics.areEqual("create_new", this.f) == false) goto L84;
    L89:
        int r38 = this.e;
        if (r38 == (-1)) goto L92;
        ListProtector.add(r29, 0, new TemplateV4(null, null, r38, null, null, null, 0, null, null, null, 0, null, null, null, null, 0, 0, 0, 0, 0, null, null, 0, null, null, null, false, 0, null, null, true, null, 0, 0, null, -1073741829, 7, null));
        goto L92
    L84:
        if (Intrinsics.areEqual("create_new_recent", this.f) == true) goto L89;
        if (Intrinsics.areEqual("create_new_folder_block", this.f) == true) goto L89;
        if (this.g.h().getCreateBlank() == false) goto L92;
    L18:
        r8 = "";
        goto L19
    L14:
        r1 = null;
        goto L16
    L11:
        r7 = null;
        goto L12
    L8:
        r6 = null;
        goto L9
    L5:
        r5 = null;
        goto L6
    }

    public d(FragmentActivity r2, int r3, int r4, String r5, boolean r6, String r7, SystemTemplateListModel r8) {
        Intrinsics.checkNotNullParameter(r2, "context");
        Intrinsics.checkNotNullParameter(r5, "cacheKey");
        Intrinsics.checkNotNullParameter(r7, "from");
        Intrinsics.checkNotNullParameter(r8, "model");
        super(r3, r6, r5);
        this.d = r2;
        this.e = r4;
        this.f = r7;
        this.g = r8;
    }
}
