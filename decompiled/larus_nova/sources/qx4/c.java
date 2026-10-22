package qx4;

import android.app.Activity;
import android.preference.CheckBoxPreference;
import android.preference.PreferenceScreen;
import jx4.t;

/* JADX INFO: loaded from: classes16.dex */
public final class c extends t {
    @Override // jx4.t
    public final void f() {
        CheckBoxPreference r100 = (CheckBoxPreference) this.f500814a.findPreference("rust_net_enable");
        if (r100 == null) goto L5;
        r100.setOnPreferenceChangeListener(this);
        r100.setChecked(((Boolean) this.f500834c.a("rust_net_enable", Boolean.TRUE)).booleanValue());
        r100.setEnabled(this.E);
    L5:
        CheckBoxPreference r101 = (CheckBoxPreference) this.f500814a.findPreference("header_append_params_enable");
        boolean r102 = true;
        if (r101 != null) goto L8;
    L14:
        CheckBoxPreference r103 = (CheckBoxPreference) this.f500814a.findPreference("header_append_params_enable_rn");
        if (r103 == null) goto L22;
        boolean r104 = ((Boolean) this.f500834c.a("header_append_params_enable", Boolean.FALSE)).booleanValue();
        if (this.E == false) goto L20;
        if (r104 == false) goto L20;
    L21:
        r103.setEnabled(r102);
        r103.setChecked(((Boolean) this.f500834c.a("header_append_params_enable_rn", Boolean.TRUE)).booleanValue());
        r103.setOnPreferenceChangeListener(this);
    L20:
        r102 = false;
    L22:
        this.f500814a.findPreference("header_append_params").setOnPreferenceClickListener(new a(this));
        CheckBoxPreference r105 = (CheckBoxPreference) this.f500814a.findPreference("net_interceptable");
        if (r105 == null) goto L25;
        r105.setEnabled(this.E);
        r105.setChecked(((Boolean) this.f500834c.a("net_interceptable", Boolean.FALSE)).booleanValue());
        r105.setOnPreferenceChangeListener(this);
    L25:
        this.f500814a.findPreference("net_main_process").setOnPreferenceClickListener(new b(this));
        return;
    L8:
        if (this.E == true) goto L10;
    L12:
        boolean r106 = false;
    L13:
        r101.setEnabled(r106);
        r101.setChecked(((Boolean) this.f500834c.a("header_append_params_enable", Boolean.FALSE)).booleanValue());
        r101.setOnPreferenceChangeListener(this);
        goto L14
    L10:
        if (eu5.c.c() == false) goto L12;
        r106 = true;
        goto L13
    }

    public c(PreferenceScreen r100, Activity r101) {
        super(r100, r101);
    }
}
