package com.bytedance.ee.bear.document.at;

import android.text.TextUtils;
import com.bytedance.android.live.core.monitor.NewBroadcastMonitor;
import com.bytedance.ee.bear.at.AtObject;
import com.bytedance.ee.bear.document.analytic.AnalyticPlugin;
import com.bytedance.ee.bear.utils.AtUtils;
import com.obric.trace.ObricActionBarTrackType;
import com.ss.android.cert.manager.constants.EventConstant;
import com.ss.android.lark.picker.base.widget.reporter.PickerReporterConstants;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* JADX INFO: loaded from: classes16.dex */
public final class a implements kn4.k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Map<String, Object> f219089a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final com.bytedance.ee.bear.contract.d f219090b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public bo4.d f219091c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public String f219092d;

    @Override // kn4.k
    public final void clearParams() {
        ((HashMap) this.f219089a).clear();
    }

    public final void g() {
        int r100 = this.f219091c.f19840b;
        ArrayList<String> r101 = AtUtils.f239806a;
        String r102 = com.bytedance.ee.bear.utils.a.f239821j.get(r100, sbb.e.f541294e).getType();
        ((HashMap) this.f219089a).put(EventConstant.Key.MODULE, r102);
        int r103 = this.f219091c.f19843e;
        if (r103 == 0) goto L5;
        r102 = sbb.e.c(r103);
    L5:
        ((HashMap) this.f219089a).put("file_type", r102);
        String r104 = du5.b.g(this.f219091c.f19839a);
        ((HashMap) this.f219089a).put("file_id", r104);
        if (((HashMap) this.f219089a).containsKey("zone") == true) goto L8;
        Map<String, Object> r105 = this.f219089a;
        HashMap r106 = (HashMap) r105;
        r106.put("zone", this.f219091c.f19841c);
    L8:
        Map<String, Object> r107 = this.f219089a;
        HashMap r108 = (HashMap) r107;
        r108.put("source", this.f219092d);
    }

    public final Map<String, Object> h() {
        HashMap r100 = new HashMap();
        Iterator<Map.Entry<String, String>> r101 = this.f219090b.t(AnalyticPlugin.BIZ_COMMON_PARAMS).entrySet().iterator();
    L4:
        if (r101.hasNext() == false) goto L6;
        Map.Entry<String, String> r102 = r101.next();
        r100.put(r102.getKey(), r102.getValue());
        goto L4
    L6:
        HashMap<String, Object> r103 = this.f219090b.m("docCommonParams");
        if (r103.isEmpty() == true) goto L12;
        Iterator<Map.Entry<String, Object>> r104 = r103.entrySet().iterator();
    L10:
        if (r104.hasNext() == false) goto L16;
        Map.Entry<String, Object> r105 = r104.next();
        r100.put(r105.getKey(), r105.getValue());
    L16:
        r100.put(PickerReporterConstants.KEY.TARGET, "none");
        return r100;
    L12:
        Iterator<Map.Entry<String, String>> r106 = this.f219090b.t("driveCommonParams").entrySet().iterator();
    L14:
        if (r106.hasNext() == false) goto L16;
        Map.Entry<String, String> r107 = r106.next();
        r100.put(r107.getKey(), r107.getValue());
        goto L14
    }

    @Override // kn4.k
    public final void b() {
        Map<String, Object> r100 = h();
        tt5.a.b("AtAnalytic", "ccm_mention_panel_view, params = " + r100);
        this.f219090b.n("ccm_mention_panel_view", r100);
    }

    public a(com.bytedance.ee.bear.contract.d r100) {
        this.f219089a = new HashMap();
        this.f219092d = NewBroadcastMonitor.STAGE.TOOLBAR;
        this.f219090b = r100;
    }

    @Override // kn4.k
    public final void a(Map<String, Object> r100) {
        clearParams();
        HashMap r101 = (HashMap) r100;
        if (r101.size() <= 0) goto L8;
        Iterator r102 = r101.entrySet().iterator();
    L6:
        if (r102.hasNext() == false) goto L10;
        Map.Entry r103 = (Map.Entry) r102.next();
        Map<String, Object> r104 = this.f219089a;
        HashMap r105 = (HashMap) r104;
        r105.put((String) r103.getKey(), r103.getValue());
        goto L6
    L10:
        return;
    }

    @Override // kn4.k
    public final void d(boolean r100) {
        if (r100 == false) goto L4;
        String r101 = NewBroadcastMonitor.STAGE.TOOLBAR;
    L5:
        this.f219092d = r101;
        g();
        this.f219090b.v("open_mention", this.f219089a);
        return;
    L4:
        r101 = ObricActionBarTrackType.KEY_BOARD;
        goto L5
    }

    @Override // kn4.k
    public final void f(bo4.d r100) {
        this.f219091c = r100;
    }

    @Override // kn4.k
    public final void e(AtObject r100, boolean r101) {
        if (r101 == false) goto L4;
        String r102 = NewBroadcastMonitor.STAGE.TOOLBAR;
    L5:
        this.f219092d = r102;
        g();
        int r103 = r100.getType();
        String r104 = "";
        if (r103 == 0) goto L27;
        if (r103 == 1) goto L25;
        if (r103 == 3) goto L25;
        if (r103 != 5) goto L12;
        String r105 = "chat";
    L36:
        ((HashMap) this.f219089a).put("mention_type", r105);
        Map<String, Object> r106 = this.f219089a;
        HashMap r107 = (HashMap) r106;
        r107.put("mention_sequence_num", Integer.valueOf(r100.getSequenceNum()));
        if ("link_file".equals(r105) == false) goto L43;
        Map<String, Object> r108 = this.f219089a;
        int r109 = r100.getType();
        ArrayList<String> r110 = AtUtils.f239806a;
        String r111 = com.bytedance.ee.bear.utils.a.f239817f.get(r109);
        if (TextUtils.isEmpty(r111) == true) goto L42;
        r104 = r111;
    L42:
        ((HashMap) r108).put("mention_sub_type", r104);
    L43:
        this.f219090b.v("confirm_mention", this.f219089a);
        return;
    L12:
        if (r103 == 8) goto L25;
        if (r103 == 16) goto L25;
        if (r103 == 22) goto L25;
        if (r103 == 30) goto L25;
        if (r103 == 11) goto L25;
        if (r103 == 12) goto L25;
        r105 = "";
    L25:
        r105 = "link_file";
        goto L36
    L27:
        if (r100.getSource() != 1) goto L30;
        ((HashMap) this.f219089a).put("recommend_source", "recent_view_user");
    L35:
        r105 = "user";
        goto L36
    L30:
        if (r100.getSource() != 2) goto L33;
        ((HashMap) this.f219089a).put("recommend_source", "recent_mention_user");
        goto L35
    L33:
        if (r100.getSource() != 3) goto L35;
        ((HashMap) this.f219089a).put("recommend_source", "lark_search_user");
        goto L35
    L4:
        r102 = ObricActionBarTrackType.KEY_BOARD;
        goto L5
    }

    @Override // kn4.k
    public final void c(AtObject r100, boolean r101, int r102, boolean r110) {
        Map<String, Object> r103 = h();
        HashMap r104 = (HashMap) r103;
        r104.put("click", "mention_confirm");
        int r105 = r100.getType();
        ArrayList<String> r106 = AtUtils.f239806a;
        boolean r107 = true;
        if (r105 == 0) goto L36;
        if (r105 != 1) goto L6;
        String r108 = sbb.e.f541296g.getType();
    L37:
        r104.put("mention_type", r108);
        r104.put("mention_obj_id", du5.b.g(r100.getToken()));
        r104.put("is_send_notice_flag", Boolean.valueOf(r101));
        r104.put("domain", this.f219091c.f19842d);
        r104.put("mention_result_num", Integer.valueOf(r102 + 1));
        r104.put("is_have_query", Boolean.valueOf(r110));
        if (16 == r100.getType()) goto L41;
        r107 = false;
    L41:
        r104.put("is_wiki", String.valueOf(r107));
        if (r107 == false) goto L44;
        r104.put("wiki_token", du5.b.g(r100.getToken()));
    L45:
        tt5.a.b("AtAnalytic", "ccm_mention_panel_click, params = " + r103);
        this.f219090b.n("ccm_mention_panel_click", r103);
        return;
    L44:
        r104.put("wiki_token", "none");
        goto L45
    L6:
        if (r105 != 3) goto L8;
        r108 = sbb.e.f541297h.getType();
        goto L37
    L8:
        if (r105 != 5) goto L10;
        r108 = "chat";
        goto L37
    L10:
        if (r105 == 8) goto L32;
        if (r105 != 16) goto L13;
        r108 = sbb.e.f541303n.getType();
        goto L37
    L13:
        if (r105 != 22) goto L15;
        r108 = sbb.e.f541304o.getType();
        goto L37
    L15:
        if (r105 != 30) goto L17;
        r108 = sbb.e.f541302m.getType();
        goto L37
    L17:
        if (r105 != 11) goto L19;
        r108 = sbb.e.f541300k.getType();
        goto L37
    L19:
        if (r105 != 12) goto L21;
        r108 = sbb.e.f541301l.getType();
        goto L37
    L21:
        if (r105 != 113) goto L23;
        r108 = sbb.e.f541309t.getType();
        goto L37
    L23:
        if (r105 == 114) goto L25;
        r108 = "unknown";
        goto L37
    L25:
        r108 = sbb.e.f541310u.getType();
        goto L37
    L32:
        r108 = sbb.e.f541298i.getType();
        goto L37
    L36:
        r108 = "user";
        goto L37
    }
}
