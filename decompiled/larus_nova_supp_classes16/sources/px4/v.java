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

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class v extends jx4.t {
    public final CompositeDisposable K;

    @Override // jx4.t
    public final void f() {
        final EditTextPreference r0 = (EditTextPreference) this.a.findPreference("lynx_source_url");
        r0.setSummary((CharSequence) this.c.a("lynx_template_url", ""));
        r0.setEnabled(this.E);
        r0.setOnPreferenceChangeListener(new d(this, r0));
        final EditTextPreference r1 = (EditTextPreference) this.a.findPreference("lynx_specific_version");
        r1.setSummary((CharSequence) this.c.a("lynx_specific_version", ""));
        r1.setEnabled(this.E);
        r1.setOnPreferenceChangeListener(new m(this, r1));
        PreferenceScreen r2 = (PreferenceScreen) this.a.findPreference("lynx_dev_tool_scan");
        r2.setEnabled(this.E);
        r2.setOnPreferenceClickListener(new n(this));
        PreferenceScreen r3 = (PreferenceScreen) this.a.findPreference("lynx_current_version");
        r3.setEnabled(this.E);
        String r4 = ((com.bytedance.ee.bear.lynx.api.c) org.koin.java.a.a(com.bytedance.ee.bear.lynx.api.c.class)).e(this.J);
        if (TextUtils.isEmpty(r4) == true) goto L5;
        r3.setSummary(r4);
    L5:
        final EditTextPreference r5 = (EditTextPreference) this.a.findPreference("lynx_bitable_proxy_ip");
        final EditTextPreference r6 = (EditTextPreference) this.a.findPreference("lynx_bitable_scm_version");
        SwitchPreference r7 = (SwitchPreference) this.a.findPreference("lynx_bitable_enable_proxy");
        final PreferenceScreen r8 = (PreferenceScreen) this.a.findPreference("lynx_bitable_enable_buildin");
        PreferenceScreen r9 = (PreferenceScreen) this.a.findPreference("lynx_bitable_dev_tool_scan");
        r9.setEnabled(this.E);
        r9.setOnPreferenceClickListener(new o(this, r5));
        r5.setSummary((CharSequence) this.c.a("lynx_bitable_proxy_ip", ""));
        r5.setOnPreferenceChangeListener(new p(this, r5));
        String r10 = (String) this.c.a("lynx_bitable_scm_version", "");
        if (TextUtils.isEmpty(r10) == false) goto L8;
        r10 = "已关闭";
    L8:
        r6.setSummary(r10);
        r6.setOnPreferenceChangeListener(new q(this, r6, r8));
        r7.setChecked(this.c.a.getBoolean("lynx_bitable_enable_proxy", false));
        r7.setOnPreferenceChangeListener(new r(this));
        h(r8);
        SwitchPreference r11 = (SwitchPreference) this.a.findPreference("lynx_bitable_enable_show_lynx");
        r11.setChecked(this.c.a.getBoolean("lynx_bitable_enable_show_lynx", false));
        r11.setOnPreferenceChangeListener(new s(this));
    }

    @Override // jx4.t
    public final void e() {
        super.e();
        this.K.dispose();
    }

    public final void g(boolean r3) {
        ((SwitchPreference) this.a.findPreference("lynx_bitable_enable_proxy")).setChecked(r3);
        this.c.b("lynx_bitable_enable_proxy", Boolean.valueOf(r3));
    }

    public final void h(final PreferenceScreen r4) {
        String r0 = c.a;
        if (r0 != null) goto L5;
        r0 = "";
    L5:
        r4.setSummary("Apk 内置资源, version:".concat(r0));
        if (TextUtils.isEmpty(r0) == true) goto L8;
        return;
    L8:
        Disposable r5 = Flowable.just("").observeOn(Schedulers.io()).map(new h(this)).subscribe(new i(r4), new j());
        this.K.add(r5);
    }

    public v(PreferenceScreen r1, Activity r2) {
        super(r1, r2);
        this.K = new CompositeDisposable();
    }
}
