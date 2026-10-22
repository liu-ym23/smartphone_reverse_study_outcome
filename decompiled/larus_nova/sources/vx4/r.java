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

/* JADX INFO: loaded from: classes16.dex */
public final class r extends t {
    public Preference K;

    @Override // jx4.t
    public final void f() {
        this.K = this.f500814a.findPreference("scm_info");
        if (Boolean.TRUE.equals(AppInfoUtils.f()) == false) goto L84;
        tt5.a.h("WebResourceDebugInfo", "getScmInfo: skip scm info in OfficeSDK");
        Preference r100 = this.K;
        if (r100 == null) goto L13;
        r100.setSummary("");
    L13:
        CheckBoxPreference r101 = (CheckBoxPreference) this.f500814a.findPreference("offline_auto_download_full_res");
        if (r101 == null) goto L16;
        r101.setOnPreferenceChangeListener(this);
    L16:
        CheckBoxPreference r102 = (CheckBoxPreference) this.f500814a.findPreference("enable_debug_res");
        if (r102 == null) goto L19;
        r102.setOnPreferenceChangeListener(this);
        r102.setChecked(((Boolean) this.f500834c.a("enable_debug_res", Boolean.FALSE)).booleanValue());
    L19:
        CheckBoxPreference r103 = (CheckBoxPreference) this.f500814a.findPreference("offline_disable_specific_res");
        if (r103 == null) goto L22;
        r103.setOnPreferenceChangeListener(this);
        r103.setChecked(((Boolean) this.f500834c.a("offline_disable_specific_res", Boolean.FALSE)).booleanValue());
    L22:
        EditTextPreference r104 = (EditTextPreference) this.f500814a.findPreference("offline_res_version");
        this.f500849r = r104;
        if (r104 == null) goto L25;
        r104.setOnPreferenceChangeListener(this);
        this.f500849r.setSummary((CharSequence) this.f500834c.a("offline_res_version", ""));
        this.f500849r.setEnabled(this.E);
    L25:
        CheckBoxPreference r105 = (CheckBoxPreference) this.f500814a.findPreference("offline_res_enable_source_map");
        if (r105 == null) goto L28;
        r105.setOnPreferenceChangeListener(this);
    L28:
        CheckBoxPreference r106 = (CheckBoxPreference) this.f500814a.findPreference("initGecko");
        if (r106 == null) goto L31;
        r106.setOnPreferenceChangeListener(this);
        r106.setChecked(((Boolean) this.f500834c.a("initGecko", Boolean.TRUE)).booleanValue());
        r106.setEnabled(this.E);
    L31:
        CheckBoxPreference r107 = (CheckBoxPreference) this.f500814a.findPreference("disable_ip_proxy");
        this.f500848q = r107;
        if (r107 == null) goto L34;
        r107.setOnPreferenceChangeListener(this);
        this.f500848q.setChecked(((Boolean) this.f500834c.a("disable_ip_proxy", Boolean.FALSE)).booleanValue());
        this.f500848q.setEnabled(this.E);
    L34:
        EditTextPreference r108 = (EditTextPreference) this.f500814a.findPreference("ip_proxy");
        this.f500851t = r108;
        if (r108 == null) goto L37;
        r108.setOnPreferenceChangeListener(this);
        this.f500851t.setSummary((CharSequence) this.f500834c.a("save_ip_proxy", ""));
        this.f500851t.setEnabled(this.E);
    L37:
        EditTextPreference r109 = (EditTextPreference) this.f500814a.findPreference("documentOpenTimeout");
        this.f500853v = r109;
        if (r109 == null) goto L44;
        r109.setOnPreferenceChangeListener(this);
        int r110 = this.f500834c.f514368a.getInt("documentOpenTimeout", -1);
        if (r110 >= 0) goto L42;
        String r111 = "";
    L43:
        this.f500853v.setSummary(r111);
        this.f500853v.setEnabled(eu5.c.c());
        goto L44
    L42:
        r111 = r110 + " ms";
    L44:
        CheckBoxPreference r112 = (CheckBoxPreference) this.f500814a.findPreference("firstRenderNotAccelerate");
        this.f500846o = r112;
        if (r112 == null) goto L47;
        r112.setOnPreferenceChangeListener(this);
        this.f500846o.setChecked(((Boolean) this.f500834c.a("firstRenderNotAccelerate", Boolean.FALSE)).booleanValue());
        this.f500846o.setEnabled(this.E);
    L47:
        CheckBoxPreference r113 = (CheckBoxPreference) this.f500814a.findPreference("singleWebView");
        this.f500847p = r113;
        if (r113 == null) goto L50;
        r113.setOnPreferenceChangeListener(this);
        this.f500847p.setChecked(((Boolean) this.f500834c.a("singleWebView", Boolean.FALSE)).booleanValue());
        this.f500847p.setEnabled(this.E);
    L50:
        EditTextPreference r114 = (EditTextPreference) this.f500814a.findPreference("http_request_id");
        this.f500852u = r114;
        if (r114 == null) goto L53;
        r114.setOnPreferenceChangeListener(this);
        this.f500852u.setSummary((CharSequence) this.f500834c.a("http_request_id", ""));
        this.f500852u.setEnabled(this.E);
    L53:
        CheckBoxPreference r115 = (CheckBoxPreference) this.f500814a.findPreference("offline_encrypt");
        if (r115 == null) goto L56;
        r115.setOnPreferenceChangeListener(this);
        r115.setChecked(((Boolean) this.f500834c.a("offline_encrypt", Boolean.TRUE)).booleanValue());
        r115.setEnabled(this.E);
    L56:
        CheckBoxPreference r116 = (CheckBoxPreference) this.f500814a.findPreference("show_cache_toast");
        if (r115 == null) goto L59;
        r116.setOnPreferenceChangeListener(this);
        r116.setChecked(((Boolean) this.f500834c.a("show_cache_toast", Boolean.FALSE)).booleanValue());
        r116.setEnabled(this.E);
    L59:
        CheckBoxPreference r117 = (CheckBoxPreference) this.f500814a.findPreference("disable_preload_document");
        if (r115 == null) goto L62;
        r117.setOnPreferenceChangeListener(this);
        r117.setChecked(((Boolean) this.f500834c.a("disable_preload_document", Boolean.FALSE)).booleanValue());
        r117.setEnabled(this.E);
    L62:
        CheckBoxPreference r118 = (CheckBoxPreference) this.f500814a.findPreference("show_doc_size_toast");
        if (r118 == null) goto L65;
        r118.setOnPreferenceChangeListener(this);
        r118.setChecked(((Boolean) this.f500834c.a("show_doc_size_toast", Boolean.FALSE)).booleanValue());
        r118.setEnabled(this.E);
    L65:
        CheckBoxPreference r119 = (CheckBoxPreference) this.f500814a.findPreference("ai_roadster_debug");
        if (r119 == null) goto L68;
        r119.setOnPreferenceChangeListener(this);
        r119.setChecked(((Boolean) this.f500834c.a("ai_roadster_debug", Boolean.FALSE)).booleanValue());
        r119.setEnabled(this.E);
    L68:
        CheckBoxPreference r120 = (CheckBoxPreference) this.f500814a.findPreference("ttwebview_enable");
        this.f500854w = r120;
        if (r120 == null) goto L71;
        r120.setOnPreferenceChangeListener(this);
        this.f500854w.setChecked(((Boolean) this.f500834c.a("ttwebview_enable", Boolean.TRUE)).booleanValue());
        this.f500854w.setEnabled(this.E);
    L71:
        CheckBoxPreference r121 = (CheckBoxPreference) this.f500814a.findPreference("ttwebview_m62_enable");
        this.f500855x = r121;
        if (r121 == null) goto L74;
        r121.setOnPreferenceChangeListener(this);
        this.f500855x.setChecked(((Boolean) this.f500834c.a("ttwebview_m62_enable", Boolean.FALSE)).booleanValue());
        this.f500855x.setEnabled(this.E);
    L74:
        Preference r122 = this.f500814a.findPreference("get_doc_cache_size");
        if (r122 == null) goto L77;
        r122.setEnabled(this.E);
        r122.setOnPreferenceClickListener(new a(this));
    L77:
        Preference r123 = this.f500814a.findPreference("clean_doc_cache");
        if (r123 == null) goto L80;
        r123.setEnabled(this.E);
        r123.setOnPreferenceClickListener(new h(this));
    L80:
        this.f500814a.findPreference("roaster_zip_link").setOnPreferenceChangeListener(this);
        this.f500814a.findPreference("clear_roaster").setOnPreferenceClickListener(new i(this));
        this.f500814a.findPreference("debug_on").setOnPreferenceClickListener(new j(this));
        this.f500814a.findPreference("set_data_error").setOnPreferenceClickListener(new k(this));
        CheckBoxPreference r124 = (CheckBoxPreference) this.f500814a.findPreference("drive_same_render_emed_on");
        if (r124 == null) goto L86;
        r124.setOnPreferenceChangeListener(this);
        return;
    L86:
        return;
    L84:
        l7 r125 = y7.f222541j;     // Catch: Exception -> L9
        y7.a.f222551a.t(null).evaluateJavascript("window.scm", new q(this));     // Catch: Exception -> L9
    L9:
        e = move-exception;
        tt5.a.l("WebResourceDebugInfo", "getScmInfo: skip scm info", e);
        Preference r126 = this.K;
        if (r126 == null) goto L13;
        r126.setSummary("");
        goto L13
    }

    public r(PreferenceScreen r100, Activity r101) {
        super(r100, r101);
    }
}
