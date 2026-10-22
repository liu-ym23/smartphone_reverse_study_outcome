package sx4;

import android.app.Activity;
import android.preference.CheckBoxPreference;
import android.preference.PreferenceScreen;
import com.larksuite.framework.utils.DevEnvUtil;
import jx4.t;

/* JADX INFO: loaded from: classes16.dex */
public final class a extends t {
    @Override // jx4.t
    public final void f() {
        CheckBoxPreference r100 = (CheckBoxPreference) this.f500814a.findPreference("rn_doze");
        if (r100 == null) goto L5;
        r100.setOnPreferenceChangeListener(this);
        r100.setChecked(((Boolean) this.f500834c.a("rn_doze", Boolean.FALSE)).booleanValue());
        r100.setEnabled(this.E);
    L5:
        CheckBoxPreference r101 = (CheckBoxPreference) this.f500814a.findPreference("rn_debug_for_bitable");
        if (r101 == null) goto L8;
        r101.setOnPreferenceChangeListener(this);
        r101.setChecked(((Boolean) this.f500834c.a("rn_debug_for_bitable", Boolean.FALSE)).booleanValue());
        r101.setEnabled(this.E);
    L8:
        CheckBoxPreference r102 = (CheckBoxPreference) this.f500814a.findPreference("rn_debug");
        if (r102 == null) goto L23;
        r102.setOnPreferenceChangeListener(this);
        boolean r103 = true;
        if (DevEnvUtil.isDebugMode(this.f500833J) == true) goto L13;
    L15:
        boolean r104 = false;
    L16:
        r102.setChecked(r104);
        if (DevEnvUtil.isDebugMode(this.f500833J) == true) goto L19;
    L21:
        r103 = false;
    L22:
        r102.setEnabled(r103);
        goto L23
    L19:
        if (this.E == false) goto L21;
    L13:
        if (((Boolean) this.f500834c.a("rn_debug", Boolean.FALSE)).booleanValue() == false) goto L15;
        r104 = true;
    L23:
        CheckBoxPreference r105 = (CheckBoxPreference) this.f500814a.findPreference("rn_preload");
        if (r105 == null) goto L26;
        r105.setOnPreferenceChangeListener(this);
        r105.setChecked(((Boolean) this.f500834c.a("rn_preload", Boolean.TRUE)).booleanValue());
        r105.setEnabled(this.E);
    L26:
        CheckBoxPreference r106 = (CheckBoxPreference) this.f500814a.findPreference("doc_rn_enabled");
        if (r106 == null) goto L30;
        r106.setOnPreferenceChangeListener(this);
        r106.setChecked(((Boolean) this.f500834c.a("doc_rn_enabled", Boolean.TRUE)).booleanValue());
        r106.setEnabled(this.E);
        return;
    }

    public a(PreferenceScreen r100, Activity r101) {
        super(r100, r101);
    }
}
