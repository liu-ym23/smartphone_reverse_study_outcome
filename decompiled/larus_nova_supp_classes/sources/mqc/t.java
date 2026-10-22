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
import org.xmlpull.v1.XmlPullParser;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes.dex */
public final class t {
    public static volatile t c;
    public final SharedPreferences a;
    public volatile SharedPreferences b;

    public static t c() {
        if (c != null) goto L15;
        monitor-enter(t.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (c != null) goto L9;
        c = new t();     // Catch: Throwable -> L11
    L9:
        monitor-exit(t.class);     // Catch: Throwable -> L11
    L15:
        return c;
    }

    public final SharedPreferences e() {
        if (this.b != null) goto L14;
        monitor-enter(this);
    L10:
        th = move-exception;
        throw th;
    L6:
        if (this.b != null) goto L8;
        Zeus.getAppApplication();     // Catch: Throwable -> L10
        this.b = Zeus.getAppApplication().getSharedPreferences("zeus_meta_data_sp_boot_" + dqc.d.c(), 0);     // Catch: Throwable -> L10
    L8:
        monitor-exit(this);     // Catch: Throwable -> L10
    L14:
        return this.b;
    }

    public t() {
        this.a = Zeus.getAppApplication().getSharedPreferences("zeus_meta_data_sp", 0);
    }

    public final List<Integer> a(String r5) {
        ArrayList r0 = new ArrayList();
        String r6 = "DISABLE_DOWNLOAD_" + r5 + "_";
        Iterator<String> r1 = this.a.getAll().keySet().iterator();
    L4:
        if (r1.hasNext() == false) goto L8;
        String r2 = r1.next();
        if (r2.startsWith(r6) == false) goto L4;
        r0.add(CastIntegerProtector.valueOf(r2.replace(r6, XmlPullParser.NO_NAMESPACE)));
        goto L4
    L8:
        return r0;
    }

    public final String b(String r4) {
        String r0 = this.a.getString("HOST_IDENTITY_" + r4, XmlPullParser.NO_NAMESPACE);
        ZeusLogger.i(ZeusLogger.TAG_INIT, "ZeusSpUtils getHostIdentity pluginPKg = " + r4 + ", hostIdentity = " + r0);
        return r0;
    }

    public final int d(String r4) {
        int r0 = this.a.getInt("PLUGIN_API_VERSION_" + r4, 0);
        ZeusLogger.i(ZeusLogger.TAG_INIT, "ZeusSpUtils getPluginApiVersion pluginPKg = " + r4 + ", pluginApiVersion = " + r0);
        return r0;
    }

    public final boolean f(String r3) {
        return !TextUtils.isEmpty(this.a.getString("ROM_LAST_".concat(r3), XmlPullParser.NO_NAMESPACE));
    }

    public final boolean g(String r7) {
        boolean r0 = !TextUtils.equals(this.a.getString("HOST_ABI_" + r7, XmlPullParser.NO_NAMESPACE), Zeus.getHostAbi());
        StringBuilder r1 = new StringBuilder("ZeusSpUtils isHostAbiUpdate HOST_ABI=");
        r1.append(this.a.getString("HOST_ABI_" + r7, XmlPullParser.NO_NAMESPACE));
        r1.append(", ");
        r1.append(Zeus.getHostAbi());
        r1.append(", result=");
        r1.append(r0);
        ZeusLogger.i(ZeusLogger.TAG_INIT, r1.toString());
        return r0;
    }

    public final boolean i(String r3) {
        String r4 = this.a.getString("ROM_LAST_".concat(r3), XmlPullParser.NO_NAMESPACE);
        String r0 = Build.VERSION.INCREMENTAL;
        if (TextUtils.isEmpty(r4) == false) goto L5;
        return false;
    L5:
        if (TextUtils.isEmpty(r0) == false) goto L8;
        return false;
    L8:
        return !TextUtils.equals(r4, r0);
    }

    public final void k(String r5) {
        String r0 = this.a.getString("HOST_ABI_" + r5, XmlPullParser.NO_NAMESPACE);
        SharedPreferences.Editor r1 = this.a.edit();
        r1.putString("HOST_ABI_" + r5, Zeus.getHostAbi());
        r1.apply();
        ZeusLogger.i(ZeusLogger.TAG_INIT, "ZeusSpUtils setHostAbiUpdated HOST_ABI=" + r0 + " --> " + Zeus.getHostAbi());
    }

    public final void n(String r4) {
        SharedPreferences.Editor r0 = this.a.edit();
        r0.putString("ROM_LAST_" + r4, Build.VERSION.INCREMENTAL);
        r0.apply();
    }

    public final void o(String r4) {
        if (TextUtils.equals(this.a.getString("SECONDARY_DEX2OAT_HOST_IDENTITY", XmlPullParser.NO_NAMESPACE), r4) == true) goto L6;
        SharedPreferences.Editor r0 = this.a.edit();
        r0.putString("SECONDARY_DEX2OAT_HOST_IDENTITY", r4);
        r0.apply();
        return;
    }

    public final void p(long r3) {
        SharedPreferences.Editor r0 = this.a.edit();
        r0.putLong("SECONDARY_DEX2OAT_LAST_TRIGGER_TIME", r3);
        r0.apply();
    }

    public final void q(String r3) {
        SharedPreferences.Editor r0 = e().edit();
        r0.putString("last_boot_id", r3);
        r0.apply();
    }

    public final boolean h(String r5, int r6) {
        return this.a.getBoolean(String.format(Locale.getDefault(), "INSTALLED_%s-%d", new Object[]{r5, Integer.valueOf(r6)}), false);
    }

    public final void l(String r5, String r6) {
        String r0 = b(r5);
        if (TextUtils.equals(r0, r6) == true) goto L5;
        SharedPreferences.Editor r1 = this.a.edit();
        r1.putString("HOST_IDENTITY_" + r5, r6);
        r1.apply();
    L5:
        ZeusLogger.i(ZeusLogger.TAG_INIT, "ZeusSpUtils setHostIdentity(" + r5 + ") " + r0 + " --> " + r6);
    }

    public final void m(String r5, int r6) {
        int r0 = d(r5);
        if (r0 == r6) goto L5;
        SharedPreferences.Editor r1 = this.a.edit();
        r1.putInt("PLUGIN_API_VERSION_" + r5, r6);
        r1.apply();
    L5:
        ZeusLogger.i(ZeusLogger.TAG_INIT, "ZeusSpUtils setPluginApiVersion " + r0 + " --> " + r6);
    }

    public final void j(String r4, int r5, boolean r6) {
        SharedPreferences.Editor r0 = this.a.edit();
        String r7 = "INSTALLED_" + r4 + "-" + r5;
        if (r6 == false) goto L5;
        r0.putBoolean(r7, true);
    L6:
        r0.commit();
        return;
    L5:
        r0.remove(r7);
        goto L6
    }
}
