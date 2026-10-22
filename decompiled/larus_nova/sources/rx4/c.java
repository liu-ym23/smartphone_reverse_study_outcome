package rx4;

import android.app.Activity;
import android.preference.CheckBoxPreference;
import android.preference.EditTextPreference;
import android.preference.Preference;
import android.preference.PreferenceScreen;
import jx4.t;

/* JADX INFO: loaded from: classes16.dex */
public final class c extends t {
    @Override // jx4.t
    public final void f() {
        CheckBoxPreference r100 = (CheckBoxPreference) this.f500814a.findPreference("lark_docs_newer_guide_switch");
        if (r100 == null) goto L5;
        r100.setOnPreferenceChangeListener(this);
        r100.setChecked(((Boolean) this.f500834c.a("lark_docs_newer_guide_switch", Boolean.FALSE)).booleanValue());
        r100.setEnabled(this.E);
    L5:
        final EditTextPreference r101 = (EditTextPreference) this.f500814a.findPreference("global_onboarding_key");
        r101.setSummary((CharSequence) this.f500834c.a("global_onboarding_key", ""));
        r101.setEnabled(this.E);
        r101.setOnPreferenceChangeListener(new a(this, r101));
        CheckBoxPreference r102 = (CheckBoxPreference) this.f500814a.findPreference("global_onboarding_enable");
        if (r102 == null) goto L8;
        r102.setEnabled(this.E);
        r102.setChecked(((Boolean) this.f500834c.a("global_onboarding_enable", Boolean.FALSE)).booleanValue());
        r102.setOnPreferenceChangeListener(this);
    L8:
        CheckBoxPreference r103 = (CheckBoxPreference) this.f500814a.findPreference("global_onboarding_native_only_enable");
        if (r103 == null) goto L11;
        r103.setEnabled(this.E);
        r103.setChecked(((Boolean) this.f500834c.a("global_onboarding_native_only_enable", Boolean.FALSE)).booleanValue());
        r103.setOnPreferenceChangeListener(this);
    L11:
        Preference r104 = this.f500814a.findPreference("clear_onboarding_cache");
        if (r104 == null) goto L15;
        r104.setEnabled(this.E);
        r104.setOnPreferenceClickListener(new b(this));
        return;
    }

    public c(PreferenceScreen r100, Activity r101) {
        super(r100, r101);
    }
}
