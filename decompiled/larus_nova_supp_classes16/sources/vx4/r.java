package vx4;

import android.app.Activity;
import android.preference.CheckBoxPreference;
import android.preference.EditTextPreference;
import android.preference.Preference;
import android.preference.PreferenceScreen;
import com.bytedance.ee.bear.document.l7;
import com.bytedance.ee.bear.document.y7;
import com.bytedance.ee.util.info.AppInfoUtils;
import jx4.t;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class r extends t {
    public Preference K;

    @Override // jx4.t
    public final void f() {
        this.K = this.a.findPreference("scm_info");
        if (Boolean.TRUE.equals(AppInfoUtils.f()) == false) goto L84;
        tt5.a.h("WebResourceDebugInfo", "getScmInfo: skip scm info in OfficeSDK");
        Preference r0 = this.K;
        if (r0 == null) goto L13;
        r0.setSummary("");
    L13:
        CheckBoxPreference r1 = (CheckBoxPreference) this.a.findPreference("offline_auto_download_full_res");
        if (r1 == null) goto L16;
        r1.setOnPreferenceChangeListener(this);
    L16:
        CheckBoxPreference r2 = (CheckBoxPreference) this.a.findPreference("enable_debug_res");
        if (r2 == null) goto L19;
        r2.setOnPreferenceChangeListener(this);
        r2.setChecked(((Boolean) this.c.a("enable_debug_res", Boolean.FALSE)).booleanValue());
    L19:
        CheckBoxPreference r3 = (CheckBoxPreference) this.a.findPreference("offline_disable_specific_res");
        if (r3 == null) goto L22;
        r3.setOnPreferenceChangeListener(this);
        r3.setChecked(((Boolean) this.c.a("offline_disable_specific_res", Boolean.FALSE)).booleanValue());
    L22:
        EditTextPreference r4 = (EditTextPreference) this.a.findPreference("offline_res_version");
        this.r = r4;
        if (r4 == null) goto L25;
        r4.setOnPreferenceChangeListener(this);
        this.r.setSummary((CharSequence) this.c.a("offline_res_version", ""));
        this.r.setEnabled(this.E);
    L25:
        CheckBoxPreference r5 = (CheckBoxPreference) this.a.findPreference("offline_res_enable_source_map");
        if (r5 == null) goto L28;
        r5.setOnPreferenceChangeListener(this);
    L28:
        CheckBoxPreference r6 = (CheckBoxPreference) this.a.findPreference("initGecko");
        if (r6 == null) goto L31;
        r6.setOnPreferenceChangeListener(this);
        r6.setChecked(((Boolean) this.c.a("initGecko", Boolean.TRUE)).booleanValue());
        r6.setEnabled(this.E);
    L31:
        CheckBoxPreference r7 = (CheckBoxPreference) this.a.findPreference("disable_ip_proxy");
        this.q = r7;
        if (r7 == null) goto L34;
        r7.setOnPreferenceChangeListener(this);
        this.q.setChecked(((Boolean) this.c.a("disable_ip_proxy", Boolean.FALSE)).booleanValue());
        this.q.setEnabled(this.E);
    L34:
        EditTextPreference r8 = (EditTextPreference) this.a.findPreference("ip_proxy");
        this.t = r8;
        if (r8 == null) goto L37;
        r8.setOnPreferenceChangeListener(this);
        this.t.setSummary((CharSequence) this.c.a("save_ip_proxy", ""));
        this.t.setEnabled(this.E);
    L37:
        EditTextPreference r9 = (EditTextPreference) this.a.findPreference("documentOpenTimeout");
        this.v = r9;
        if (r9 == null) goto L44;
        r9.setOnPreferenceChangeListener(this);
        int r10 = this.c.a.getInt("documentOpenTimeout", -1);
        if (r10 >= 0) goto L42;
        String r11 = "";
    L43:
        this.v.setSummary(r11);
        this.v.setEnabled(eu5.c.c());
        goto L44
    L42:
        r11 = r10 + " ms";
    L44:
        CheckBoxPreference r12 = (CheckBoxPreference) this.a.findPreference("firstRenderNotAccelerate");
        this.o = r12;
        if (r12 == null) goto L47;
        r12.setOnPreferenceChangeListener(this);
        this.o.setChecked(((Boolean) this.c.a("firstRenderNotAccelerate", Boolean.FALSE)).booleanValue());
        this.o.setEnabled(this.E);
    L47:
        CheckBoxPreference r13 = (CheckBoxPreference) this.a.findPreference("singleWebView");
        this.p = r13;
        if (r13 == null) goto L50;
        r13.setOnPreferenceChangeListener(this);
        this.p.setChecked(((Boolean) this.c.a("singleWebView", Boolean.FALSE)).booleanValue());
        this.p.setEnabled(this.E);
    L50:
        EditTextPreference r14 = (EditTextPreference) this.a.findPreference("http_request_id");
        this.u = r14;
        if (r14 == null) goto L53;
        r14.setOnPreferenceChangeListener(this);
        this.u.setSummary((CharSequence) this.c.a("http_request_id", ""));
        this.u.setEnabled(this.E);
    L53:
        CheckBoxPreference r16 = (CheckBoxPreference) this.a.findPreference("offline_encrypt");
        if (r16 == null) goto L56;
        r16.setOnPreferenceChangeListener(this);
        r16.setChecked(((Boolean) this.c.a("offline_encrypt", Boolean.TRUE)).booleanValue());
        r16.setEnabled(this.E);
    L56:
        CheckBoxPreference r17 = (CheckBoxPreference) this.a.findPreference("show_cache_toast");
        if (r16 == null) goto L59;
        r17.setOnPreferenceChangeListener(this);
        r17.setChecked(((Boolean) this.c.a("show_cache_toast", Boolean.FALSE)).booleanValue());
        r17.setEnabled(this.E);
    L59:
        CheckBoxPreference r18 = (CheckBoxPreference) this.a.findPreference("disable_preload_document");
        if (r16 == null) goto L62;
        r18.setOnPreferenceChangeListener(this);
        r18.setChecked(((Boolean) this.c.a("disable_preload_document", Boolean.FALSE)).booleanValue());
        r18.setEnabled(this.E);
    L62:
        CheckBoxPreference r19 = (CheckBoxPreference) this.a.findPreference("show_doc_size_toast");
        if (r19 == null) goto L65;
        r19.setOnPreferenceChangeListener(this);
        r19.setChecked(((Boolean) this.c.a("show_doc_size_toast", Boolean.FALSE)).booleanValue());
        r19.setEnabled(this.E);
    L65:
        CheckBoxPreference r20 = (CheckBoxPreference) this.a.findPreference("ai_roadster_debug");
        if (r20 == null) goto L68;
        r20.setOnPreferenceChangeListener(this);
        r20.setChecked(((Boolean) this.c.a("ai_roadster_debug", Boolean.FALSE)).booleanValue());
        r20.setEnabled(this.E);
    L68:
        CheckBoxPreference r21 = (CheckBoxPreference) this.a.findPreference("ttwebview_enable");
        this.w = r21;
        if (r21 == null) goto L71;
        r21.setOnPreferenceChangeListener(this);
        this.w.setChecked(((Boolean) this.c.a("ttwebview_enable", Boolean.TRUE)).booleanValue());
        this.w.setEnabled(this.E);
    L71:
        CheckBoxPreference r22 = (CheckBoxPreference) this.a.findPreference("ttwebview_m62_enable");
        this.x = r22;
        if (r22 == null) goto L74;
        r22.setOnPreferenceChangeListener(this);
        this.x.setChecked(((Boolean) this.c.a("ttwebview_m62_enable", Boolean.FALSE)).booleanValue());
        this.x.setEnabled(this.E);
    L74:
        Preference r23 = this.a.findPreference("get_doc_cache_size");
        if (r23 == null) goto L77;
        r23.setEnabled(this.E);
        r23.setOnPreferenceClickListener(new a(this));
    L77:
        Preference r24 = this.a.findPreference("clean_doc_cache");
        if (r24 == null) goto L80;
        r24.setEnabled(this.E);
        r24.setOnPreferenceClickListener(new h(this));
    L80:
        this.a.findPreference("roaster_zip_link").setOnPreferenceChangeListener(this);
        this.a.findPreference("clear_roaster").setOnPreferenceClickListener(new i(this));
        this.a.findPreference("debug_on").setOnPreferenceClickListener(new j(this));
        this.a.findPreference("set_data_error").setOnPreferenceClickListener(new k(this));
        CheckBoxPreference r26 = (CheckBoxPreference) this.a.findPreference("drive_same_render_emed_on");
        if (r26 == null) goto L86;
        r26.setOnPreferenceChangeListener(this);
        return;
    L86:
        return;
    L84:
        l7 r27 = y7.j;     // Catch: Exception -> L9
        y7.a.a.t(null).evaluateJavascript("window.scm", new q(this));     // Catch: Exception -> L9
    L9:
        e = move-exception;
        tt5.a.l("WebResourceDebugInfo", "getScmInfo: skip scm info", e);
        Preference r28 = this.K;
        if (r28 == null) goto L13;
        r28.setSummary("");
        goto L13
    }

    public r(PreferenceScreen r1, Activity r2) {
        super(r1, r2);
    }
}
