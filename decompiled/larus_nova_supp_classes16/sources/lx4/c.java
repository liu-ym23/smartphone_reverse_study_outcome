package lx4;

import android.app.Activity;
import android.preference.CheckBoxPreference;
import android.preference.EditTextPreference;
import android.preference.MultiSelectListPreference;
import android.preference.Preference;
import android.preference.PreferenceScreen;
import jx4.t;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class c extends t {
    @Override // jx4.t
    public final void f() {
        CheckBoxPreference r0 = (CheckBoxPreference) this.a.findPreference("test_switch");
        r0.setChecked(false);
        r0.setOnPreferenceChangeListener(this);
        r0.setEnabled(this.E);
        if (this.m != null) goto L5;
        this.m = new mx4.a(this.b.get(), this.i, this.A, this.B, this);
    L5:
        MultiSelectListPreference r1 = (MultiSelectListPreference) this.a.findPreference("doc_types");
        if (r1 == null) goto L8;
        r1.setOnPreferenceChangeListener(this);
        r1.setSummary(this.m.p().toString());
        r1.setEnabled(this.E);
    L8:
        EditTextPreference r2 = (EditTextPreference) this.a.findPreference("folder_token");
        this.s = r2;
        if (r2 == null) goto L11;
        r2.setOnPreferenceChangeListener(this);
        this.s.setSummary((CharSequence) this.c.a("folder_token", ""));
        this.s.setEnabled(this.E);
    L11:
        CheckBoxPreference r3 = (CheckBoxPreference) this.a.findPreference("wiki_test_switch");
        if (r3 == null) goto L16;
        r3.setChecked(false);
        r3.setOnPreferenceChangeListener(this);
        r3.setEnabled(this.E);
        if (this.n != null) goto L16;
        this.n = new j(this.b.get(), this.h, this.i, this.z, this.A, this.f, this.y);
    L16:
        Preference r4 = this.a.findPreference("memory_gc");
        if (r4 == null) goto L20;
        r4.setEnabled(this.E);
        r4.setOnPreferenceClickListener(new b(this));
        return;
    }

    public c(PreferenceScreen r1, Activity r2) {
        super(r1, r2);
    }
}
