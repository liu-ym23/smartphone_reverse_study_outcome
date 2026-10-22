package px4;

import android.app.Activity;
import android.preference.EditTextPreference;
import android.preference.PreferenceScreen;
import android.preference.SwitchPreference;
import android.text.TextUtils;
import io.reactivex.Flowable;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

/* JADX INFO: loaded from: classes16.dex */
public final class v extends jx4.t {
    public final CompositeDisposable K;

    @Override // jx4.t
    public final void f() {
        final EditTextPreference r100 = (EditTextPreference) this.f500814a.findPreference("lynx_source_url");
        r100.setSummary((CharSequence) this.f500834c.a("lynx_template_url", ""));
        r100.setEnabled(this.E);
        r100.setOnPreferenceChangeListener(new d(this, r100));
        final EditTextPreference r101 = (EditTextPreference) this.f500814a.findPreference("lynx_specific_version");
        r101.setSummary((CharSequence) this.f500834c.a("lynx_specific_version", ""));
        r101.setEnabled(this.E);
        r101.setOnPreferenceChangeListener(new m(this, r101));
        PreferenceScreen r102 = (PreferenceScreen) this.f500814a.findPreference("lynx_dev_tool_scan");
        r102.setEnabled(this.E);
        r102.setOnPreferenceClickListener(new n(this));
        PreferenceScreen r103 = (PreferenceScreen) this.f500814a.findPreference("lynx_current_version");
        r103.setEnabled(this.E);
        String r104 = ((com.bytedance.ee.bear.lynx.api.c) org.koin.java.a.a(com.bytedance.ee.bear.lynx.api.c.class)).e(this.f500833J);
        if (TextUtils.isEmpty(r104) == true) goto L5;
        r103.setSummary(r104);
    L5:
        final EditTextPreference r105 = (EditTextPreference) this.f500814a.findPreference("lynx_bitable_proxy_ip");
        final EditTextPreference r106 = (EditTextPreference) this.f500814a.findPreference("lynx_bitable_scm_version");
        SwitchPreference r107 = (SwitchPreference) this.f500814a.findPreference("lynx_bitable_enable_proxy");
        final PreferenceScreen r108 = (PreferenceScreen) this.f500814a.findPreference("lynx_bitable_enable_buildin");
        PreferenceScreen r109 = (PreferenceScreen) this.f500814a.findPreference("lynx_bitable_dev_tool_scan");
        r109.setEnabled(this.E);
        r109.setOnPreferenceClickListener(new o(this, r105));
        r105.setSummary((CharSequence) this.f500834c.a("lynx_bitable_proxy_ip", ""));
        r105.setOnPreferenceChangeListener(new p(this, r105));
        String r110 = (String) this.f500834c.a("lynx_bitable_scm_version", "");
        if (TextUtils.isEmpty(r110) == false) goto L8;
        r110 = "已关闭";
    L8:
        r106.setSummary(r110);
        r106.setOnPreferenceChangeListener(new q(this, r106, r108));
        r107.setChecked(this.f500834c.f514368a.getBoolean("lynx_bitable_enable_proxy", false));
        r107.setOnPreferenceChangeListener(new r(this));
        h(r108);
        SwitchPreference r111 = (SwitchPreference) this.f500814a.findPreference("lynx_bitable_enable_show_lynx");
        r111.setChecked(this.f500834c.f514368a.getBoolean("lynx_bitable_enable_show_lynx", false));
        r111.setOnPreferenceChangeListener(new s(this));
    }

    @Override // jx4.t
    public final void e() {
        super.e();
        this.K.dispose();
    }

    public final void g(boolean r100) {
        ((SwitchPreference) this.f500814a.findPreference("lynx_bitable_enable_proxy")).setChecked(r100);
        this.f500834c.b("lynx_bitable_enable_proxy", Boolean.valueOf(r100));
    }

    public final void h(final PreferenceScreen r100) {
        String r101 = c.f530886a;
        if (r101 != null) goto L5;
        r101 = "";
    L5:
        r100.setSummary("Apk 内置资源, version:".concat(r101));
        if (TextUtils.isEmpty(r101) == true) goto L8;
        return;
    L8:
        Disposable r102 = Flowable.just("").observeOn(Schedulers.io()).map(new h(this)).subscribe(new i(r100), new j());
        this.K.add(r102);
    }

    public v(PreferenceScreen r100, Activity r101) {
        super(r100, r101);
        this.K = new CompositeDisposable();
    }
}
