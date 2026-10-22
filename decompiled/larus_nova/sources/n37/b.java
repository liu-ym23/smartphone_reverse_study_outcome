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

/* JADX INFO: loaded from: classes.dex */
public final class b implements f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final SharedPreferences f516975a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final SharedPreferences.Editor f516976b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final IEnsure f516977c;

    @Override // h37.f
    public final void apply() {
        this.f516976b.apply();
    }

    public final boolean a(String r100) {
        return this.f516975a.getBoolean(r100, false);
    L5:
        e = move-exception;
        IEnsure r101 = this.f516977c;
        if (r101 == null) goto L9;
        r101.reportLogException(e);
    L9:
        return false;
    }

    public final long b(String r100) {
        return this.f516975a.getLong(r100, 0);
    L5:
        e = move-exception;
        IEnsure r101 = this.f516977c;
        if (r101 == null) goto L9;
        r101.reportLogException(e);
    L9:
        return 0;
    }

    public final String c(String r100) {
        return this.f516975a.getString(r100, "");
    L5:
        e = move-exception;
        IEnsure r101 = this.f516977c;
        if (r101 == null) goto L9;
        r101.reportLogException(e);
    L9:
        return "";
    }

    @Override // h37.f
    public final boolean contains(String r100) {
        return this.f516975a.contains(r100);
    }

    @Override // h37.f
    public final boolean getBoolean(String r100) {
        return a(r100);
    }

    @Override // h37.f
    public final int getInt(String r100) {
        return getInt(r100, 0);
    }

    @Override // h37.f
    public final long getLong(String r100) {
        return b(r100);
    }

    @Override // h37.f
    public final String getString(String r100) {
        return c(r100);
    }

    @Override // h37.f
    public final int getInt(String r100, int r101) {
        return this.f516975a.getInt(r100, r101);
    L4:
        e = move-exception;
        IEnsure r102 = this.f516977c;
        if (r102 == null) goto L8;
        r102.reportLogException(e);
    L8:
        return r101;
    }

    @Override // h37.f
    public final void putBoolean(String r100, boolean r101) {
        this.f516976b.putBoolean(r100, r101);
    }

    @Override // h37.f
    public final void putInt(String r100, int r101) {
        this.f516976b.putInt(r100, r101);
    }

    @Override // h37.f
    public final void putLong(String r100, long r101) {
        this.f516976b.putLong(r100, r101);
    }

    @Override // h37.f
    public final void putString(String r100, String r101) {
        this.f516976b.putString(r100, r101);
    }

    public b(Context r100, String r101, boolean r102, boolean r103) {
        SettingsConfigProvider r104 = (SettingsConfigProvider) ServiceManager.getService(SettingsConfigProvider.class);
        if (r104 != null) goto L5;
    L51:
    L19:
        e = move-exception;
        if (Build.VERSION.SDK_INT < 26) goto L33;
        DevicePolicyManager r105 = (DevicePolicyManager) r100.getSystemService("device_policy");
        if (r105 == null) goto L33;
        int r106 = r105.getStorageEncryptionStatus();     // Catch: IllegalStateException -> L31
        if (r106 != 5) goto L29;
    L30:
        boolean r107 = true;
    L34:
        if (r107 == true) goto L36;
        throw e;
    L36:
        if (Build.VERSION.SDK_INT < 24) goto L46;
        Context r108 = r100.createDeviceProtectedStorageContext();
        if (r108.moveSharedPreferencesFrom(r100, r101 + ".sp") == true) goto L44;
        if (r104 == null) goto L44;
        if (r104.getConfig() == null) goto L44;
        r104.getConfig().f479840c.getClass();
    L44:
        if (this.f516975a != null) goto L46;
        this.f516975a = r108.getSharedPreferences(r101 + ".sp", 0);
    L46:
        this.f516976b = this.f516975a.edit();
        this.f516977c = (IEnsure) ServiceManager.getService(IEnsure.class);
        return;
    L29:
        if (r106 != 3) goto L33;
    L31:
        e = move-exception;
        e.printStackTrace();
    L33:
        r107 = false;
        goto L34
    L16:
        if (this.f516975a != null) goto L46;
        this.f516975a = r100.getSharedPreferences(r101 + ".sp", 0);     // Catch: IllegalStateException -> L19
        goto L46
    L5:
        if (r104.getConfig() == null) goto L51;
        d r109 = r104.getConfig();
        String r110 = r101 + ".sp";
        if (r103 == false) goto L9;
        int r111 = 4;
    L10:
        e r112 = r109.f479840c.f479857f;
        if (r112 == null) goto L13;
        SharedPreferences r113 = r112.a(r110, r111);
    L14:
        this.f516975a = r113;
        goto L51
    L13:
        r113 = null;
        goto L14
    L9:
        r111 = 0;
        goto L10
    }
}
