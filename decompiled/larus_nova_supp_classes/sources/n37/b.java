package n37;

import android.app.admin.DevicePolicyManager;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Build;
import com.bytedance.news.common.service.manager.ServiceManager;
import com.bytedance.news.common.settings.SettingsConfigProvider;
import com.bytedance.services.apm.api.IEnsure;
import g37.d;
import h37.e;
import h37.f;
import org.xmlpull.v1.XmlPullParser;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes.dex */
public final class b implements f {
    public final SharedPreferences a;
    public final SharedPreferences.Editor b;
    public final IEnsure c;

    @Override // h37.f
    public final void apply() {
        this.b.apply();
    }

    public final boolean a(String r3) {
        return this.a.getBoolean(r3, false);
    L5:
        e = move-exception;
        IEnsure r1 = this.c;
        if (r1 == null) goto L9;
        r1.reportLogException(e);
    L9:
        return false;
    }

    public final long b(String r4) {
        return this.a.getLong(r4, 0);
    L5:
        e = move-exception;
        IEnsure r2 = this.c;
        if (r2 == null) goto L9;
        r2.reportLogException(e);
    L9:
        return 0;
    }

    public final String c(String r3) {
        return this.a.getString(r3, XmlPullParser.NO_NAMESPACE);
    L5:
        e = move-exception;
        IEnsure r1 = this.c;
        if (r1 == null) goto L9;
        r1.reportLogException(e);
    L9:
        return XmlPullParser.NO_NAMESPACE;
    }

    @Override // h37.f
    public final boolean contains(String r2) {
        return this.a.contains(r2);
    }

    @Override // h37.f
    public final boolean getBoolean(String r1) {
        return a(r1);
    }

    @Override // h37.f
    public final int getInt(String r2) {
        return getInt(r2, 0);
    }

    @Override // h37.f
    public final long getLong(String r3) {
        return b(r3);
    }

    @Override // h37.f
    public final String getString(String r1) {
        return c(r1);
    }

    @Override // h37.f
    public final int getInt(String r2, int r3) {
        return this.a.getInt(r2, r3);
    L4:
        e = move-exception;
        IEnsure r0 = this.c;
        if (r0 == null) goto L8;
        r0.reportLogException(e);
    L8:
        return r3;
    }

    @Override // h37.f
    public final void putBoolean(String r2, boolean r3) {
        this.b.putBoolean(r2, r3);
    }

    @Override // h37.f
    public final void putInt(String r2, int r3) {
        this.b.putInt(r2, r3);
    }

    @Override // h37.f
    public final void putLong(String r2, long r3) {
        this.b.putLong(r2, r3);
    }

    @Override // h37.f
    public final void putString(String r2, String r3) {
        this.b.putString(r2, r3);
    }

    public b(Context r5, String r6, boolean r7, boolean r8) {
        SettingsConfigProvider r9 = (SettingsConfigProvider) ServiceManager.getService(SettingsConfigProvider.class);
        if (r9 != null) goto L5;
    L51:
    L19:
        e = move-exception;
        if (Build.VERSION.SDK_INT < 26) goto L33;
        DevicePolicyManager r2 = (DevicePolicyManager) r5.getSystemService("device_policy");
        if (r2 == null) goto L33;
        int r3 = r2.getStorageEncryptionStatus();     // Catch: IllegalStateException -> L31
        if (r3 != 5) goto L29;
    L30:
        boolean r4 = true;
    L34:
        if (r4 == true) goto L36;
        throw e;
    L36:
        if (Build.VERSION.SDK_INT < 24) goto L46;
        Context r10 = r5.createDeviceProtectedStorageContext();
        if (r10.moveSharedPreferencesFrom(r5, r6 + ".sp") == true) goto L44;
        if (r9 == null) goto L44;
        if (r9.getConfig() == null) goto L44;
        r9.getConfig().c.getClass();
    L44:
        if (this.a != null) goto L46;
        this.a = r10.getSharedPreferences(r6 + ".sp", 0);
    L46:
        this.b = this.a.edit();
        this.c = (IEnsure) ServiceManager.getService(IEnsure.class);
        return;
    L29:
        if (r3 != 3) goto L33;
    L31:
        e = move-exception;
        e.printStackTrace();
    L33:
        r4 = false;
        goto L34
    L16:
        if (this.a != null) goto L46;
        this.a = r5.getSharedPreferences(r6 + ".sp", 0);     // Catch: IllegalStateException -> L19
        goto L46
    L5:
        if (r9.getConfig() == null) goto L51;
        d r11 = r9.getConfig();
        String r12 = r6 + ".sp";
        if (r8 == false) goto L9;
        int r13 = 4;
    L10:
        e r14 = r11.c.f;
        if (r14 == null) goto L13;
        SharedPreferences r15 = r14.a(r12, r13);
    L14:
        this.a = r15;
        goto L51
    L13:
        r15 = null;
        goto L14
    L9:
        r13 = 0;
        goto L10
    }
}
