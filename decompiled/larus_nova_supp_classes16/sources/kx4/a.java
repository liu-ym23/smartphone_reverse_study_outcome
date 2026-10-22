package kx4;

import android.app.Activity;
import android.preference.CheckBoxPreference;
import android.preference.PreferenceScreen;
import jx4.t;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class a extends t {
    @Override // jx4.t
    public final void f() {
        CheckBoxPreference r0 = (CheckBoxPreference) this.a.findPreference("sensitive_report_enable");
        if (r0 == null) goto L5;
        r0.setOnPreferenceChangeListener(this);
        r0.setChecked(((Boolean) this.c.a("sensitive_report_enable", Boolean.TRUE)).booleanValue());
        r0.setEnabled(this.E);
    L5:
        CheckBoxPreference r1 = (CheckBoxPreference) this.a.findPreference("enableFrontendEtTest");
        if (r1 == null) goto L8;
        r1.setOnPreferenceChangeListener(this);
        r1.setChecked(((Boolean) this.c.a("enable_frontend_et_test", Boolean.FALSE)).booleanValue());
        r1.setEnabled(this.E);
    L8:
        CheckBoxPreference r2 = (CheckBoxPreference) this.a.findPreference("enable_statistics");
        if (r2 == null) goto L12;
        r2.setOnPreferenceChangeListener(this);
        r2.setChecked(((Boolean) this.c.a("enable_statistics", Boolean.FALSE)).booleanValue());
        r2.setEnabled(this.E);
        return;
    }

    public a(PreferenceScreen r1, Activity r2) {
        super(r1, r2);
    }
}
