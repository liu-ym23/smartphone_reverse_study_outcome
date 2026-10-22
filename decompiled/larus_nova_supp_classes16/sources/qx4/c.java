package qx4;

import android.app.Activity;
import android.preference.CheckBoxPreference;
import android.preference.PreferenceScreen;
import jx4.t;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class c extends t {
    @Override // jx4.t
    public final void f() {
        CheckBoxPreference r0 = (CheckBoxPreference) this.a.findPreference("rust_net_enable");
        if (r0 == null) goto L5;
        r0.setOnPreferenceChangeListener(this);
        r0.setChecked(((Boolean) this.c.a("rust_net_enable", Boolean.TRUE)).booleanValue());
        r0.setEnabled(this.E);
    L5:
        CheckBoxPreference r1 = (CheckBoxPreference) this.a.findPreference("header_append_params_enable");
        boolean r2 = true;
        if (r1 != null) goto L8;
    L14:
        CheckBoxPreference r3 = (CheckBoxPreference) this.a.findPreference("header_append_params_enable_rn");
        if (r3 == null) goto L22;
        boolean r4 = ((Boolean) this.c.a("header_append_params_enable", Boolean.FALSE)).booleanValue();
        if (this.E == false) goto L20;
        if (r4 == false) goto L20;
    L21:
        r3.setEnabled(r2);
        r3.setChecked(((Boolean) this.c.a("header_append_params_enable_rn", Boolean.TRUE)).booleanValue());
        r3.setOnPreferenceChangeListener(this);
    L20:
        r2 = false;
    L22:
        this.a.findPreference("header_append_params").setOnPreferenceClickListener(new a(this));
        CheckBoxPreference r5 = (CheckBoxPreference) this.a.findPreference("net_interceptable");
        if (r5 == null) goto L25;
        r5.setEnabled(this.E);
        r5.setChecked(((Boolean) this.c.a("net_interceptable", Boolean.FALSE)).booleanValue());
        r5.setOnPreferenceChangeListener(this);
    L25:
        this.a.findPreference("net_main_process").setOnPreferenceClickListener(new b(this));
        return;
    L8:
        if (this.E == true) goto L10;
    L12:
        boolean r6 = false;
    L13:
        r1.setEnabled(r6);
        r1.setChecked(((Boolean) this.c.a("header_append_params_enable", Boolean.FALSE)).booleanValue());
        r1.setOnPreferenceChangeListener(this);
        goto L14
    L10:
        if (eu5.c.c() == false) goto L12;
        r6 = true;
        goto L13
    }

    public c(PreferenceScreen r1, Activity r2) {
        super(r1, r2);
    }
}
