package wx4;

import android.app.Activity;
import android.preference.CheckBoxPreference;
import android.preference.PreferenceScreen;
import jx4.t;

/* JADX INFO: loaded from: classes16.dex */
public final class a extends t {
    @Override // jx4.t
    public final void f() {
        CheckBoxPreference r100 = (CheckBoxPreference) this.f500814a.findPreference("wikitree_collab_enable");
        if (r100 == null) goto L5;
        r100.setOnPreferenceChangeListener(this);
        r100.setChecked(((Boolean) this.f500834c.a("wikitree_collab_enable", Boolean.TRUE)).booleanValue());
        r100.setEnabled(this.E);
    L5:
        CheckBoxPreference r101 = (CheckBoxPreference) this.f500814a.findPreference("wikitree_show_areaId");
        if (r101 == null) goto L8;
        r101.setOnPreferenceChangeListener(this);
        r101.setChecked(((Boolean) this.f500834c.a("wikitree_show_areaId", Boolean.FALSE)).booleanValue());
        r101.setEnabled(this.E);
    L8:
        CheckBoxPreference r102 = (CheckBoxPreference) this.f500814a.findPreference("wikitree_show_status");
        if (r102 == null) goto L12;
        r102.setOnPreferenceChangeListener(this);
        r102.setChecked(((Boolean) this.f500834c.a("wikitree_show_status", Boolean.FALSE)).booleanValue());
        r102.setEnabled(this.E);
        return;
    }

    public a(PreferenceScreen r100, Activity r101) {
        super(r100, r101);
    }
}
