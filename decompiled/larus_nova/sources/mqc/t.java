package mqc;

import android.content.SharedPreferences;
import android.os.Build;
import android.text.TextUtils;
import com.bytedance.mt.protector.impl.string2number.CastIntegerProtector;
import com.volcengine.zeus.Zeus;
import com.volcengine.zeus.log.ZeusLogger;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;

/* JADX INFO: loaded from: classes.dex */
public final class t {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static volatile t f514969c;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final SharedPreferences f514970a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public volatile SharedPreferences f514971b;

    public static t c() {
        if (f514969c != null) goto L15;
        monitor-enter(t.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (f514969c != null) goto L9;
        f514969c = new t();     // Catch: Throwable -> L11
    L9:
        monitor-exit(t.class);     // Catch: Throwable -> L11
    L15:
        return f514969c;
    }

    public final SharedPreferences e() {
        if (this.f514971b != null) goto L14;
        monitor-enter(this);
    L10:
        th = move-exception;
        throw th;
    L6:
        if (this.f514971b != null) goto L8;
        Zeus.getAppApplication();     // Catch: Throwable -> L10
        this.f514971b = Zeus.getAppApplication().getSharedPreferences("zeus_meta_data_sp_boot_" + dqc.d.c(), 0);     // Catch: Throwable -> L10
    L8:
        monitor-exit(this);     // Catch: Throwable -> L10
    L14:
        return this.f514971b;
    }

    public t() {
        this.f514970a = Zeus.getAppApplication().getSharedPreferences("zeus_meta_data_sp", 0);
    }

    public final List<Integer> a(String r100) {
        ArrayList r101 = new ArrayList();
        String r102 = "DISABLE_DOWNLOAD_" + r100 + "_";
        Iterator<String> r103 = this.f514970a.getAll().keySet().iterator();
    L4:
        if (r103.hasNext() == false) goto L8;
        String r104 = r103.next();
        if (r104.startsWith(r102) == false) goto L4;
        r101.add(CastIntegerProtector.valueOf(r104.replace(r102, "")));
        goto L4
    L8:
        return r101;
    }

    public final String b(String r100) {
        String r101 = this.f514970a.getString("HOST_IDENTITY_" + r100, "");
        ZeusLogger.i(ZeusLogger.TAG_INIT, "ZeusSpUtils getHostIdentity pluginPKg = " + r100 + ", hostIdentity = " + r101);
        return r101;
    }

    public final int d(String r100) {
        int r101 = this.f514970a.getInt("PLUGIN_API_VERSION_" + r100, 0);
        ZeusLogger.i(ZeusLogger.TAG_INIT, "ZeusSpUtils getPluginApiVersion pluginPKg = " + r100 + ", pluginApiVersion = " + r101);
        return r101;
    }

    public final boolean f(String r100) {
        return !TextUtils.isEmpty(this.f514970a.getString("ROM_LAST_".concat(r100), ""));
    }

    public final boolean g(String r100) {
        boolean r101 = !TextUtils.equals(this.f514970a.getString("HOST_ABI_" + r100, ""), Zeus.getHostAbi());
        StringBuilder r102 = new StringBuilder("ZeusSpUtils isHostAbiUpdate HOST_ABI=");
        r102.append(this.f514970a.getString("HOST_ABI_" + r100, ""));
        r102.append(", ");
        r102.append(Zeus.getHostAbi());
        r102.append(", result=");
        r102.append(r101);
        ZeusLogger.i(ZeusLogger.TAG_INIT, r102.toString());
        return r101;
    }

    public final boolean i(String r100) {
        String r101 = this.f514970a.getString("ROM_LAST_".concat(r100), "");
        String r102 = Build.VERSION.INCREMENTAL;
        if (TextUtils.isEmpty(r101) == false) goto L5;
        return false;
    L5:
        if (TextUtils.isEmpty(r102) == false) goto L8;
        return false;
    L8:
        return !TextUtils.equals(r101, r102);
    }

    public final void k(String r100) {
        String r101 = this.f514970a.getString("HOST_ABI_" + r100, "");
        SharedPreferences.Editor r102 = this.f514970a.edit();
        r102.putString("HOST_ABI_" + r100, Zeus.getHostAbi());
        r102.apply();
        ZeusLogger.i(ZeusLogger.TAG_INIT, "ZeusSpUtils setHostAbiUpdated HOST_ABI=" + r101 + " --> " + Zeus.getHostAbi());
    }

    public final void n(String r100) {
        SharedPreferences.Editor r101 = this.f514970a.edit();
        r101.putString("ROM_LAST_" + r100, Build.VERSION.INCREMENTAL);
        r101.apply();
    }

    public final void o(String r100) {
        if (TextUtils.equals(this.f514970a.getString("SECONDARY_DEX2OAT_HOST_IDENTITY", ""), r100) == true) goto L6;
        SharedPreferences.Editor r101 = this.f514970a.edit();
        r101.putString("SECONDARY_DEX2OAT_HOST_IDENTITY", r100);
        r101.apply();
        return;
    }

    public final void p(long r100) {
        SharedPreferences.Editor r101 = this.f514970a.edit();
        r101.putLong("SECONDARY_DEX2OAT_LAST_TRIGGER_TIME", r100);
        r101.apply();
    }

    public final void q(String r100) {
        SharedPreferences.Editor r101 = e().edit();
        r101.putString("last_boot_id", r100);
        r101.apply();
    }

    public final boolean h(String r100, int r101) {
        return this.f514970a.getBoolean(String.format(Locale.getDefault(), "INSTALLED_%s-%d", new Object[]{r100, Integer.valueOf(r101)}), false);
    }

    public final void l(String r100, String r101) {
        String r102 = b(r100);
        if (TextUtils.equals(r102, r101) == true) goto L5;
        SharedPreferences.Editor r103 = this.f514970a.edit();
        r103.putString("HOST_IDENTITY_" + r100, r101);
        r103.apply();
    L5:
        ZeusLogger.i(ZeusLogger.TAG_INIT, "ZeusSpUtils setHostIdentity(" + r100 + ") " + r102 + " --> " + r101);
    }

    public final void m(String r100, int r101) {
        int r102 = d(r100);
        if (r102 == r101) goto L5;
        SharedPreferences.Editor r103 = this.f514970a.edit();
        r103.putInt("PLUGIN_API_VERSION_" + r100, r101);
        r103.apply();
    L5:
        ZeusLogger.i(ZeusLogger.TAG_INIT, "ZeusSpUtils setPluginApiVersion " + r102 + " --> " + r101);
    }

    public final void j(String r100, int r101, boolean r102) {
        SharedPreferences.Editor r103 = this.f514970a.edit();
        String r104 = "INSTALLED_" + r100 + "-" + r101;
        if (r102 == false) goto L5;
        r103.putBoolean(r104, true);
    L6:
        r103.commit();
        return;
    L5:
        r103.remove(r104);
        goto L6
    }
}
