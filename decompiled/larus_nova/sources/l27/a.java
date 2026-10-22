package l27;

import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.text.TextUtils;
import com.bytedance.mira.log.MiraLogger;
import com.bytedance.mt.protector.impl.JSONObjectProtectorUtils;
import com.larus.apm.impl.protector.RunnableProtector;
import com.monitor.cloudmessage.consts.CloudControlInf;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public final class a implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f507126a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final e f507127b;

    public final synchronized void a() {
        monitor-enter(this);
    L49:
        th = move-exception;
        throw th;
    L4:
        if (this.f507126a == false) goto L11;
        if (e.d().f507156i == false) goto L11;
        monitor-exit(this);
        return;
    L11:
        if ((System.currentTimeMillis() - this.f507127b.f507149b) >= 300000) goto L52;
        monitor-exit(this);
        return;
    L52:
        NetworkInfo r100 = ((ConnectivityManager) h27.a.f483619b.b().getSystemService("connectivity")).getActiveNetworkInfo();     // Catch: Exception -> L21 Throwable -> L49
        if (r100 == null) goto L22;
        if (r100.isConnected() == false) goto L22;
        boolean r101 = true;
    L23:
        if (r101 == true) goto L26;
        monitor-exit(this);
        return;
    L26:
        int r102 = 0;
    L28:
        if (r102 >= 2) goto L46;
        String r103 = c.a(c.c());     // Catch: Exception -> L43 Throwable -> L49
        byte[] r104 = r103.getBytes();     // Catch: Exception -> L43 Throwable -> L49
        if (r104 == null) goto L45;
        String r105 = h27.a.f483619b.a(r104);     // Catch: Exception -> L43 Throwable -> L49
        if (TextUtils.isEmpty(r105) == false) goto L35;
        MiraLogger.e(MiraLogger.TAG_DOWNLOAD, "Request plugin failed! response is empty!");     // Catch: Exception -> L43 Throwable -> L49
        goto L45
    L35:
        JSONObject r106 = new JSONObject(r105);     // Catch: Exception -> L43 Throwable -> L49
        n27.b.a("pluginSettingRequest", new String[]{"request: " + new String(r103), "response: " + r106});     // Catch: Exception -> L43 Throwable -> L49
        JSONObject r107 = JSONObjectProtectorUtils.getJSONObject(r106, "data").optJSONObject("config");     // Catch: Exception -> L43 Throwable -> L49
        if (r107 == null) goto L38;
        e r108 = this.f507127b;     // Catch: Exception -> L43 Throwable -> L49
        r108.getClass();     // Catch: Exception -> L43 Throwable -> L49
        r108.h(r107.optLong("auto_request_interval", 1800));     // Catch: Exception -> L43 Throwable -> L49
    L38:
        JSONArray r109 = JSONObjectProtectorUtils.getJSONObject(r106, "data").optJSONArray(CloudControlInf.PLUGIN);     // Catch: Exception -> L43 Throwable -> L49
        JSONArray r110 = JSONObjectProtectorUtils.getJSONObject(r106, "data").optJSONArray("pre_download_plugin");     // Catch: Exception -> L43 Throwable -> L49
        if (r109 == null) goto L41;
        this.f507127b.f507149b = System.currentTimeMillis();     // Catch: Exception -> L43 Throwable -> L49
        this.f507127b.e(r109, r110);     // Catch: Exception -> L43 Throwable -> L49
        this.f507127b.getClass();     // Catch: Exception -> L43 Throwable -> L49
    L41:
        monitor-exit(this);
        return;
    L45:
        r102 = r102 + 1;     // Catch: Throwable -> L49
    L43:
        e = move-exception;
        MiraLogger.e(MiraLogger.TAG_DOWNLOAD, "Request plugin config failed!!!", e);     // Catch: Throwable -> L49
        goto L45
    L46:
        this.f507126a = false;     // Catch: Throwable -> L49
        monitor-exit(this);
        return;
    L22:
        r101 = false;
        goto L23
    }

    @Override // java.lang.Runnable
    public final synchronized void run() {
        monitor-enter(this);
        a();     // Catch: Throwable -> L5
    L8:
        monitor-exit(this);
        return;
    L5:
        th = move-exception;
    L11:
        th = move-exception;
        throw th;
    L7:
        if (RunnableProtector.intercept(th) == true) goto L8;
        throw th;     // Catch: Throwable -> L11
    }

    public a(e r100) {
        this.f507126a = false;
        this.f507127b = r100;
    }

    public a(e r100, int r101) {
        this.f507126a = true;
        this.f507127b = r100;
    }
}
