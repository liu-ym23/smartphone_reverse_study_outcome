package nx4;

import android.app.Activity;
import android.preference.CheckBoxPreference;
import android.preference.Preference;
import android.preference.PreferenceScreen;
import jx4.t;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class p extends t {
    @Override // jx4.t
    public final void f() {
        Preference r0 = this.a.findPreference("clean_drive_cache");
        this.F = r0;
        if (r0 == null) goto L5;
        r0.setEnabled(this.E);
        this.F.setOnPreferenceClickListener(new a(this));
    L5:
        Preference r1 = this.a.findPreference("clean_cleanable_cache");
        this.G = r1;
        if (r1 == null) goto L8;
        r1.setEnabled(this.E);
        this.G.setOnPreferenceClickListener(new g(this));
    L8:
        Preference r2 = this.a.findPreference("get_cleanable_cache_size");
        this.H = r2;
        if (r2 == null) goto L11;
        r2.setEnabled(this.E);
        this.H.setOnPreferenceClickListener(new h(this));
    L11:
        Preference r3 = this.a.findPreference("open_drive_test_activity");
        this.I = r3;
        if (r3 == null) goto L14;
        r3.setEnabled(this.E);
        this.I.setOnPreferenceClickListener(new i());
    L14:
        CheckBoxPreference r4 = (CheckBoxPreference) this.a.findPreference("tt_video_log_enable");
        if (r4 == null) goto L18;
        r4.setOnPreferenceChangeListener(this);
        r4.setChecked(((Boolean) this.c.a("tt_video_log_enable", Boolean.FALSE)).booleanValue());
        r4.setEnabled(this.E);
        return;
    }

    public p(PreferenceScreen r1, Activity r2) {
        super(r1, r2);
    }
}
