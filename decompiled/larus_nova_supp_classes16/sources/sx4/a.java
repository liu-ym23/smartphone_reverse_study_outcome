package sx4;

import android.app.Activity;
import android.preference.CheckBoxPreference;
import android.preference.PreferenceScreen;
import com.larksuite.framework.utils.DevEnvUtil;
import jx4.t;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class a extends t {
    @Override // jx4.t
    public final void f() {
        CheckBoxPreference r0 = (CheckBoxPreference) this.a.findPreference("rn_doze");
        if (r0 == null) goto L5;
        r0.setOnPreferenceChangeListener(this);
        r0.setChecked(((Boolean) this.c.a("rn_doze", Boolean.FALSE)).booleanValue());
        r0.setEnabled(this.E);
    L5:
        CheckBoxPreference r1 = (CheckBoxPreference) this.a.findPreference("rn_debug_for_bitable");
        if (r1 == null) goto L8;
        r1.setOnPreferenceChangeListener(this);
        r1.setChecked(((Boolean) this.c.a("rn_debug_for_bitable", Boolean.FALSE)).booleanValue());
        r1.setEnabled(this.E);
    L8:
        CheckBoxPreference r2 = (CheckBoxPreference) this.a.findPreference("rn_debug");
        if (r2 == null) goto L23;
        r2.setOnPreferenceChangeListener(this);
        boolean r3 = true;
        if (DevEnvUtil.isDebugMode(this.J) == true) goto L13;
    L15:
        boolean r4 = false;
    L16:
        r2.setChecked(r4);
        if (DevEnvUtil.isDebugMode(this.J) == true) goto L19;
    L21:
        r3 = false;
    L22:
        r2.setEnabled(r3);
        goto L23
    L19:
        if (this.E == false) goto L21;
    L13:
        if (((Boolean) this.c.a("rn_debug", Boolean.FALSE)).booleanValue() == false) goto L15;
        r4 = true;
    L23:
        CheckBoxPreference r5 = (CheckBoxPreference) this.a.findPreference("rn_preload");
        if (r5 == null) goto L26;
        r5.setOnPreferenceChangeListener(this);
        r5.setChecked(((Boolean) this.c.a("rn_preload", Boolean.TRUE)).booleanValue());
        r5.setEnabled(this.E);
    L26:
        CheckBoxPreference r6 = (CheckBoxPreference) this.a.findPreference("doc_rn_enabled");
        if (r6 == null) goto L30;
        r6.setOnPreferenceChangeListener(this);
        r6.setChecked(((Boolean) this.c.a("doc_rn_enabled", Boolean.TRUE)).booleanValue());
        r6.setEnabled(this.E);
        return;
    }

    public a(PreferenceScreen r1, Activity r2) {
        super(r1, r2);
    }
}
