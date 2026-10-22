package com.bytedance.ee.bear.document.at;

import android.text.TextUtils;
import com.bytedance.ee.bear.at.AtObject;
import com.bytedance.ee.bear.document.analytic.AnalyticPlugin;
import com.bytedance.ee.bear.utils.AtUtils;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class a implements kn4.k {
    public final Map<String, Object> a;
    public final com.bytedance.ee.bear.contract.d b;
    public bo4.d c;
    public String d;

    public final void clearParams() {
        ((HashMap) this.a).clear();
    }

    public final void g() {
        int r0 = this.c.b;
        ArrayList r1 = AtUtils.a;
        String r2 = ((sbb.e) com.bytedance.ee.bear.utils.a.j.get(r0, sbb.e.e)).getType();
        ((HashMap) this.a).put("module", r2);
        int r3 = this.c.e;
        if (r3 == 0) goto L5;
        r2 = sbb.e.c(r3);
    L5:
        ((HashMap) this.a).put("file_type", r2);
        String r4 = du5.b.g(this.c.a);
        ((HashMap) this.a).put("file_id", r4);
        if (((HashMap) this.a).containsKey("zone") == true) goto L8;
        Map<String, Object> r5 = this.a;
        HashMap r6 = (HashMap) r5;
        r6.put("zone", this.c.c);
    L8:
        Map<String, Object> r7 = this.a;
        HashMap r8 = (HashMap) r7;
        r8.put("source", this.d);
    }

    public final Map<String, Object> h() {
        HashMap r0 = new HashMap();
        Iterator<Map.Entry<String, String>> r1 = this.b.t(AnalyticPlugin.BIZ_COMMON_PARAMS).entrySet().iterator();
    L4:
        if (r1.hasNext() == false) goto L6;
        Map.Entry<String, String> r2 = r1.next();
        r0.put(r2.getKey(), r2.getValue());
        goto L4
    L6:
        HashMap<String, Object> r3 = this.b.m("docCommonParams");
        if (r3.isEmpty() == true) goto L12;
        Iterator<Map.Entry<String, Object>> r4 = r3.entrySet().iterator();
    L10:
        if (r4.hasNext() == false) goto L16;
        Map.Entry<String, Object> r5 = r4.next();
        r0.put(r5.getKey(), r5.getValue());
    L16:
        r0.put("target", "none");
        return r0;
    L12:
        Iterator<Map.Entry<String, String>> r6 = this.b.t("driveCommonParams").entrySet().iterator();
    L14:
        if (r6.hasNext() == false) goto L16;
        Map.Entry<String, String> r7 = r6.next();
        r0.put(r7.getKey(), r7.getValue());
        goto L14
    }

    public final void b() {
        Map<String, Object> r0 = h();
        tt5.a.b("AtAnalytic", "ccm_mention_panel_view, params = " + r0);
        this.b.n("ccm_mention_panel_view", r0);
    }

    public a(com.bytedance.ee.bear.contract.d r2) {
        this.a = new HashMap();
        this.d = "toolbar";
        this.b = r2;
    }

    public final void a(Map<String, Object> r4) {
        clearParams();
        HashMap r5 = (HashMap) r4;
        if (r5.size() <= 0) goto L8;
        Iterator r6 = r5.entrySet().iterator();
    L6:
        if (r6.hasNext() == false) goto L10;
        Map.Entry r0 = (Map.Entry) r6.next();
        Map<String, Object> r1 = this.a;
        HashMap r2 = (HashMap) r1;
        r2.put((String) r0.getKey(), r0.getValue());
        goto L6
    L10:
        return;
    }

    public final void d(boolean r3) {
        if (r3 == false) goto L4;
        String r4 = "toolbar";
    L5:
        this.d = r4;
        g();
        this.b.v("open_mention", this.a);
        return;
    L4:
        r4 = "keyboard";
        goto L5
    }

    public final void f(bo4.d r1) {
        this.c = r1;
    }

    public final void e(AtObject r6, boolean r7) {
        if (r7 == false) goto L4;
        String r8 = "toolbar";
    L5:
        this.d = r8;
        g();
        int r9 = r6.getType();
        String r3 = "";
        if (r9 == 0) goto L27;
        if (r9 == 1) goto L25;
        if (r9 == 3) goto L25;
        if (r9 != 5) goto L12;
        String r10 = "chat";
    L36:
        ((HashMap) this.a).put("mention_type", r10);
        Map<String, Object> r1 = this.a;
        HashMap r2 = (HashMap) r1;
        r2.put("mention_sequence_num", Integer.valueOf(r6.getSequenceNum()));
        if ("link_file".equals(r10) == false) goto L43;
        Map<String, Object> r11 = this.a;
        int r12 = r6.getType();
        ArrayList r0 = AtUtils.a;
        String r13 = (String) com.bytedance.ee.bear.utils.a.f.get(r12);
        if (TextUtils.isEmpty(r13) == true) goto L42;
        r3 = r13;
    L42:
        ((HashMap) r11).put("mention_sub_type", r3);
    L43:
        this.b.v("confirm_mention", this.a);
        return;
    L12:
        if (r9 == 8) goto L25;
        if (r9 == 16) goto L25;
        if (r9 == 22) goto L25;
        if (r9 == 30) goto L25;
        if (r9 == 11) goto L25;
        if (r9 == 12) goto L25;
        r10 = "";
    L25:
        r10 = "link_file";
        goto L36
    L27:
        if (r6.getSource() != 1) goto L30;
        ((HashMap) this.a).put("recommend_source", "recent_view_user");
    L35:
        r10 = "user";
        goto L36
    L30:
        if (r6.getSource() != 2) goto L33;
        ((HashMap) this.a).put("recommend_source", "recent_mention_user");
        goto L35
    L33:
        if (r6.getSource() != 3) goto L35;
        ((HashMap) this.a).put("recommend_source", "lark_search_user");
        goto L35
    L4:
        r8 = "keyboard";
        goto L5
    }

    public final void c(AtObject r7, boolean r8, int r9, boolean r10) {
        Map<String, Object> r0 = h();
        HashMap r1 = (HashMap) r0;
        r1.put("click", "mention_confirm");
        int r2 = r7.getType();
        ArrayList r3 = AtUtils.a;
        boolean r4 = true;
        if (r2 == 0) goto L36;
        if (r2 != 1) goto L6;
        String r5 = sbb.e.g.getType();
    L37:
        r1.put("mention_type", r5);
        r1.put("mention_obj_id", du5.b.g(r7.getToken()));
        r1.put("is_send_notice_flag", Boolean.valueOf(r8));
        r1.put("domain", this.c.d);
        r1.put("mention_result_num", Integer.valueOf(r9 + 1));
        r1.put("is_have_query", Boolean.valueOf(r10));
        if (16 == r7.getType()) goto L41;
        r4 = false;
    L41:
        r1.put("is_wiki", String.valueOf(r4));
        if (r4 == false) goto L44;
        r1.put("wiki_token", du5.b.g(r7.getToken()));
    L45:
        tt5.a.b("AtAnalytic", "ccm_mention_panel_click, params = " + r0);
        this.b.n("ccm_mention_panel_click", r0);
        return;
    L44:
        r1.put("wiki_token", "none");
        goto L45
    L6:
        if (r2 != 3) goto L8;
        r5 = sbb.e.h.getType();
        goto L37
    L8:
        if (r2 != 5) goto L10;
        r5 = "chat";
        goto L37
    L10:
        if (r2 == 8) goto L32;
        if (r2 != 16) goto L13;
        r5 = sbb.e.n.getType();
        goto L37
    L13:
        if (r2 != 22) goto L15;
        r5 = sbb.e.o.getType();
        goto L37
    L15:
        if (r2 != 30) goto L17;
        r5 = sbb.e.m.getType();
        goto L37
    L17:
        if (r2 != 11) goto L19;
        r5 = sbb.e.k.getType();
        goto L37
    L19:
        if (r2 != 12) goto L21;
        r5 = sbb.e.l.getType();
        goto L37
    L21:
        if (r2 != 113) goto L23;
        r5 = sbb.e.t.getType();
        goto L37
    L23:
        if (r2 == 114) goto L25;
        r5 = "unknown";
        goto L37
    L25:
        r5 = sbb.e.u.getType();
        goto L37
    L32:
        r5 = sbb.e.i.getType();
        goto L37
    L36:
        r5 = "user";
        goto L37
    }
}
