package nx4;

import android.app.Activity;
import android.preference.CheckBoxPreference;
import android.preference.Preference;
import android.preference.PreferenceScreen;
import jx4.t;

/* JADX INFO: loaded from: classes16.dex */
public final class p extends t {
    @Override // jx4.t
    public final void f() {
        Preference r100 = this.f500814a.findPreference("clean_drive_cache");
        this.F = r100;
        if (r100 == null) goto L5;
        r100.setEnabled(this.E);
        this.F.setOnPreferenceClickListener(new a(this));
    L5:
        Preference r101 = this.f500814a.findPreference("clean_cleanable_cache");
        this.G = r101;
        if (r101 == null) goto L8;
        r101.setEnabled(this.E);
        this.G.setOnPreferenceClickListener(new g(this));
    L8:
        Preference r102 = this.f500814a.findPreference("get_cleanable_cache_size");
        this.H = r102;
        if (r102 == null) goto L11;
        r102.setEnabled(this.E);
        this.H.setOnPreferenceClickListener(new h(this));
    L11:
        Preference r103 = this.f500814a.findPreference("open_drive_test_activity");
        this.I = r103;
        if (r103 == null) goto L14;
        r103.setEnabled(this.E);
        this.I.setOnPreferenceClickListener(new i());
    L14:
        CheckBoxPreference r104 = (CheckBoxPreference) this.f500814a.findPreference("tt_video_log_enable");
        if (r104 == null) goto L18;
        r104.setOnPreferenceChangeListener(this);
        r104.setChecked(((Boolean) this.f500834c.a("tt_video_log_enable", Boolean.FALSE)).booleanValue());
        r104.setEnabled(this.E);
        return;
    }

    public p(PreferenceScreen r100, Activity r101) {
        super(r100, r101);
    }
}
