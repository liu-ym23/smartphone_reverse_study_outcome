package rx4;

import android.app.Activity;
import android.preference.CheckBoxPreference;
import android.preference.EditTextPreference;
import android.preference.Preference;
import android.preference.PreferenceScreen;
import jx4.t;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class c extends t {
    @Override // jx4.t
    public final void f() {
        CheckBoxPreference r0 = (CheckBoxPreference) this.a.findPreference("lark_docs_newer_guide_switch");
        if (r0 == null) goto L5;
        r0.setOnPreferenceChangeListener(this);
        r0.setChecked(((Boolean) this.c.a("lark_docs_newer_guide_switch", Boolean.FALSE)).booleanValue());
        r0.setEnabled(this.E);
    L5:
        final EditTextPreference r1 = (EditTextPreference) this.a.findPreference("global_onboarding_key");
        r1.setSummary((CharSequence) this.c.a("global_onboarding_key", ""));
        r1.setEnabled(this.E);
        r1.setOnPreferenceChangeListener(new a(this, r1));
        CheckBoxPreference r2 = (CheckBoxPreference) this.a.findPreference("global_onboarding_enable");
        if (r2 == null) goto L8;
        r2.setEnabled(this.E);
        r2.setChecked(((Boolean) this.c.a("global_onboarding_enable", Boolean.FALSE)).booleanValue());
        r2.setOnPreferenceChangeListener(this);
    L8:
        CheckBoxPreference r3 = (CheckBoxPreference) this.a.findPreference("global_onboarding_native_only_enable");
        if (r3 == null) goto L11;
        r3.setEnabled(this.E);
        r3.setChecked(((Boolean) this.c.a("global_onboarding_native_only_enable", Boolean.FALSE)).booleanValue());
        r3.setOnPreferenceChangeListener(this);
    L11:
        Preference r4 = this.a.findPreference("clear_onboarding_cache");
        if (r4 == null) goto L15;
        r4.setEnabled(this.E);
        r4.setOnPreferenceClickListener(new b(this));
        return;
    }

    public c(PreferenceScreen r1, Activity r2) {
        super(r1, r2);
    }
}
