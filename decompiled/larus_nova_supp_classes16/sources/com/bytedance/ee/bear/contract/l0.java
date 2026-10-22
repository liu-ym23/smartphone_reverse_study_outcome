package com.bytedance.ee.bear.contract;

import android.content.SharedPreferences;
import android.text.TextUtils;
import com.bytedance.apm.ApmAgent;
import com.bytedance.ttnet.TTNetInit;
import com.ss.android.lark.monitor.MonitorModule;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class l0 implements d {
    public final HashMap<String, HashMap<String, Object>> a;
    public final ml5.b b;
    public Boolean c;
    public final boolean d;
    public final boolean e;

    public class a implements SharedPreferences.OnSharedPreferenceChangeListener {
        public final /* synthetic */ l0 a;

        public a(l0 r1) {
            this.a = r1;
        }

        @Override // android.content.SharedPreferences.OnSharedPreferenceChangeListener
        public final void onSharedPreferenceChanged(SharedPreferences r4, String r5) {
            tt5.a.b("AnalyticServiceImp", "onSharedPreferenceChanged: key=" + r5);
            if (r5.equals("enable_statistics") == false) goto L6;
            l0 r6 = this.a;
            r6.c = (Boolean) r6.b.a("enable_statistics", Boolean.FALSE);
            tt5.a.b("AnalyticServiceImp", "onSharedPreferenceChanged: mEnableStatistics=" + this.a.c);
            return;
        }
    }

    @Override // com.bytedance.ee.bear.contract.d
    public final void q() {
        tt5.a.h("AnalyticServiceImp", "reportLaunchActive(): ");
        a("launch_active", new JSONObject());
    }

    public l0() {
        this.a = new HashMap();
        tt5.a.b("AnalyticServiceImp", "init: ");
        this.d = eu5.c.b(eu5.b.a);
        ml5.b r1 = new ml5.b("debug_config");
        this.b = r1;
        r1.registerOnSharedPreferenceChangeListener(new a(this));
        this.c = (Boolean) r1.a("enable_statistics", Boolean.FALSE);
        JSONObject r2 = new JSONObject();
        r2.put("enter_type", "click_icon");     // Catch: JSONException -> L5
        a("launch_app", r2);     // Catch: JSONException -> L5
    L7:
        this.e = !TextUtils.isEmpty((String) new ml5.b("debug_config").a("ip_proxy", ""));
        return;
    L5:
        e = move-exception;
        tt5.a.e("AnalyticServiceImp", "reportLaunchApp(): ", e, false);
        goto L7
    }

    public static JSONObject w(Map r5) {
        JSONObject r0 = new JSONObject();
        if (r5 == null) goto L12;
        Iterator r6 = r5.entrySet().iterator();
    L6:
        if (r6.hasNext() == false) goto L12;
        Map.Entry r1 = (Map.Entry) r6.next();
        r0.put((String) r1.getKey(), r1.getValue());     // Catch: JSONException -> L10
    L10:
        e = move-exception;
        tt5.a.e("AnalyticServiceImp", "convertMap2JSON(): ", e, false);
    L12:
        return r0;
    }

    @Override // com.bytedance.ee.bear.contract.d
    public final void c(String r2) {
        this.a.remove(r2);
    }

    @Override // com.bytedance.ee.bear.contract.d
    public final void h(String r2) {
        this.a.remove(r2);
    }

    @Override // com.bytedance.ee.bear.contract.d
    public final void k(String r2) {
        l(r2, null);
    }

    @Override // com.bytedance.ee.bear.contract.d
    public final HashMap<String, Object> m(String r2) {
        HashMap<String, Object> r3 = this.a.get(r2);
        if (r3 == null) goto L6;
        return r3;
    L6:
        return new HashMap();
    }

    @Override // com.bytedance.ee.bear.contract.d
    public final HashMap<String, String> t(String r4) {
        HashMap<String, Object> r5 = this.a.get(r4);
        HashMap<String, String> r0 = new HashMap();
        if (r5 == null) goto L12;
        Iterator<Map.Entry<String, Object>> r6 = r5.entrySet().iterator();
    L6:
        if (r6.hasNext() == false) goto L12;
        Map.Entry<String, Object> r1 = r6.next();
        if (r1.getValue() == null) goto L10;
        String r2 = r1.getValue().toString();
    L11:
        r0.put(r1.getKey(), r2);
        goto L6
    L10:
        r2 = "";
    L12:
        return r0;
    }

    @Override // com.bytedance.ee.bear.contract.d
    public final void a(String r4, JSONObject r5) {
        if (r4.startsWith("docs_") == false) goto L5;
        r(r4, r5, "", true);
        return;
    L5:
        r(r4, r5, "docs_", true);
    }

    @Override // com.bytedance.ee.bear.contract.d
    public final String e(String r2, String r3) {
        HashMap<String, Object> r4 = this.a.get(r2);
        if (r4 == null) goto L10;
        Object r5 = r4.get(r3);
        if (r5 != null) goto L7;
        return "";
    L7:
        return r5.toString();
    L10:
        return null;
    }

    @Override // com.bytedance.ee.bear.contract.d
    public final Object f(String r2, String r3) {
        HashMap<String, Object> r4 = this.a.get(r2);
        if (r4 != null) goto L5;
        return null;
    L5:
        return r4.get(r3);
    }

    @Override // com.bytedance.ee.bear.contract.d
    public final void i(String r3, JSONObject r4) {
        r(r3, r4, "", true);
    }

    @Override // com.bytedance.ee.bear.contract.d
    public final void l(String r5, JSONObject r6) {
        tt5.a.b("AnalyticServiceImp", "CcmBatteryMonitor start scene=" + r5);     // Catch: Throwable -> L10
        MonitorModule.e().f(MonitorModule.Business.ccm, r5);     // Catch: Throwable -> L10
        String r7 = "ccm_" + r5;     // Catch: Throwable -> L10
        if (r6 != null) goto L6;
    L8:
        ApmAgent.startScene(r7);     // Catch: Throwable -> L10
        ApmAgent.startBatteryCollect(r7);     // Catch: Throwable -> L10
        return;
    L6:
        if (r6.optBoolean("is_vc") == false) goto L8;
        r7 = r7 + "_vc";     // Catch: Throwable -> L10
        st3.a.b().c(r7);     // Catch: Throwable -> L10
    L10:
        th = move-exception;
        tt5.a.f("AnalyticServiceImp", th, false);
    }

    @Override // com.bytedance.ee.bear.contract.d
    public final void n(String r2, Map r3) {
        d(r2, w(r3), true);
    }

    @Override // com.bytedance.ee.bear.contract.d
    public final void p(String r6, JSONObject r7) {
        Object r1 = f("ccm_battery_extra", "ccm_battery_extra");     // Catch: Throwable -> L14
        if ((r1 instanceof JSONObject) == false) goto L7;
        if (r7 != null) goto L7;
        r7 = (JSONObject) r1;     // Catch: Throwable -> L14
    L7:
        if (r7 != null) goto L9;
        r7 = new JSONObject();     // Catch: Throwable -> L14
    L9:
        String r2 = "ccm_" + r6;     // Catch: Throwable -> L14
        if (r7.optBoolean("is_vc") == false) goto L12;
        r2 = r2 + "_vc";     // Catch: Throwable -> L14
        st3.a.b().d(r2);     // Catch: Throwable -> L14
    L12:
        r7.put("net_level", TTNetInit.getEffectiveConnectionType());     // Catch: Throwable -> L14
        r7.put("app_visible", ((f) org.koin.java.a.a(f.class)).a());     // Catch: Throwable -> L14
        tt5.a.b("AnalyticServiceImp", "CcmBatteryMonitor stop scene=" + r6 + ", extra=" + r7);     // Catch: Throwable -> L14
        MonitorModule.e().i(MonitorModule.Business.ccm, r6, r7);     // Catch: Throwable -> L14
        ApmAgent.stopScene(r2);     // Catch: Throwable -> L14
        ApmAgent.stopBatteryCollect(r2);     // Catch: Throwable -> L14
        return;
    L14:
        th = move-exception;
        tt5.a.f("AnalyticServiceImp", th, false);
    }

    @Override // com.bytedance.ee.bear.contract.d
    public final void s(String r3, String r4) {
        Object r5 = f("ccm_battery_extra", "ccm_battery_extra" + r4);
        if ((r5 instanceof JSONObject) == false) goto L5;
        JSONObject r6 = (JSONObject) r5;
    L6:
        p(r3, r6);
        return;
    L5:
        r6 = null;
        goto L6
    }

    @Override // com.bytedance.ee.bear.contract.d
    public final void u(String r3, JSONObject r4) {
        r(r3, r4, "", true);
    }

    @Override // com.bytedance.ee.bear.contract.d
    public final void v(String r2, Map r3) {
        g(r2, w(r3), true);
    }

    @Override // com.bytedance.ee.bear.contract.d
    public final void b(String r1, Map r2, boolean r3) {
        g(r1, w(r2), r3);
    }

    @Override // com.bytedance.ee.bear.contract.d
    public final void d(String r2, JSONObject r3, boolean r4) {
        r(r2, r3, "", r4);
    }

    @Override // com.bytedance.ee.bear.contract.d
    public final void g(String r3, JSONObject r4, boolean r5) {
        if (r3.startsWith("docs_") == false) goto L5;
        r(r3, r4, "", r5);
        return;
    L5:
        r(r3, r4, "docs_", r5);
    }

    @Override // com.bytedance.ee.bear.contract.d
    public final void j(String r2, String r3, Object r4) {
        HashMap<String, Object> r0 = this.a.get(r2);
        if (r0 != null) goto L5;
        r0 = new HashMap();
    L5:
        r0.put(r3, r4);
        this.a.put(r2, r0);
    }

    @Override // com.bytedance.ee.bear.contract.d
    public final void o(String r1, com.alibaba.fastjson.JSONObject r2, boolean r3) {
        d(r1, w(r2), r3);
    }

    @Override // com.bytedance.ee.bear.contract.d
    public final void r(String r4, JSONObject r5, String r6, boolean r7) {
        if (this.c.booleanValue() == false) goto L5;
    L21:
        com.ss.android.lark.statistics.b.b(r6 + r4, r5);
        return;
    L5:
        if (this.d == false) goto L18;
        if (this.b.a.getBoolean("sensitive_report_enable", true) == true) goto L9;
        return;
    L9:
        if (r7 == true) goto L11;
    L15:
        tt5.a.b("AnalyticServiceImp", "trackEvent:  event = " + r4 + "   param = " + r5.toString());
        return;
    L11:
        if (du5.b.a(r5.toString()) == false) goto L15;
        throw new RuntimeException("token is sensitive **** " + r4 + " " + r5.toString());
    L18:
        if (this.e == false) goto L21;
        tt5.a.b("AnalyticServiceImp", "trackEventExt: You have set proxy, exit report");
    }
}
