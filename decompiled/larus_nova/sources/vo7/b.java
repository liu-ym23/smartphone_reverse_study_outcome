package vo7;

import android.text.TextUtils;
import bp7.d;
import bp7.e;
import com.huawei.hms.support.hianalytics.HiAnalyticsConstant;
import com.larus.apm.impl.protector.RunnableProtector;
import java.util.HashMap;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONObject;
import zo7.c;

/* JADX INFO: loaded from: classes3.dex */
public final class b implements Runnable {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static volatile boolean f556511d;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f556512a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f556513b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final long f556514c;

    public final void a() {
        AtomicBoolean r100 = d.f19987g;     // Catch: Throwable -> L43
        d r101 = d.a.f19994a;     // Catch: Throwable -> L43
        r101.a();     // Catch: Throwable -> L43
        e r102 = r101.f19989b;     // Catch: Throwable -> L43
        if (r102 != null) goto L6;
        boolean r103 = false;
    L10:
        if (r103 == false) goto L14;
        zo7.b.d("ReportPreInstallChannelTask", "has report pre install channel");     // Catch: Throwable -> L43
        return;
    L14:
        if (TextUtils.isEmpty(this.f556512a) == false) goto L18;
        zo7.b.d("ReportPreInstallChannelTask", "mPreInstallChannel is empty");     // Catch: Throwable -> L43
        return;
    L18:
        if (TextUtils.isEmpty(this.f556513b) == false) goto L22;
        zo7.b.b("ReportPreInstallChannelTask", "did is empty");     // Catch: Throwable -> L43
        b(false, "did is empty");     // Catch: Throwable -> L43
        return;
    L22:
        if (f556511d == false) goto L25;
        zo7.b.d("ReportPreInstallChannelTask", "isReporting");     // Catch: Throwable -> L43
        return;
    L25:
        f556511d = true;     // Catch: Throwable -> L43
        bp7.a r104 = bp7.a.C0335a.f19983a;     // Catch: Throwable -> L43
        xo7.b r105 = r104.f19978a;     // Catch: Throwable -> L43
        if (r105 != null) goto L28;
        int r106 = -1;
    L29:
        HashMap r107 = new HashMap(4);     // Catch: Throwable -> L43
        r107.put("device_id", this.f556513b);     // Catch: Throwable -> L43
        r107.put("system_record_channel", this.f556512a);     // Catch: Throwable -> L43
        r107.put("app_id", r106 + "");     // Catch: Throwable -> L43
        r107.put("time", (System.currentTimeMillis() / 1000) + "");     // Catch: Throwable -> L43
        zo7.b.d("ReportPreInstallChannelTask", "executePost start");     // Catch: Throwable -> L43
        xo7.e r108 = r104.f19979b;     // Catch: Exception -> L34 Throwable -> L43
        if (r108 == null) goto L36;
        String r109 = r108.a(r107);     // Catch: Exception -> L34 Throwable -> L43
    L37:
        JSONObject r110 = new JSONObject(r109);     // Catch: Throwable -> L43
        int r111 = r110.optInt("code", -1);     // Catch: Throwable -> L43
        String r112 = r110.optString("message");     // Catch: Throwable -> L43
        zo7.b.d("ReportPreInstallChannelTask", "executePost end, code : " + r111);     // Catch: Throwable -> L43
        if (r111 != 0) goto L40;
        d.a.f19994a.c(true);     // Catch: Throwable -> L43
        b(true, "");     // Catch: Throwable -> L43
    L41:
        f556511d = false;     // Catch: Throwable -> L43
        return;
    L40:
        d.a.f19994a.c(false);     // Catch: Throwable -> L43
        b(false, "code=" + r111 + ", msg = " + r112);     // Catch: Throwable -> L43
        goto L41
    L36:
        r109 = "";
    L34:
        e = move-exception;
        zo7.b.b("YZConfigManager", "executePost meet err, " + e);     // Catch: Throwable -> L43
        goto L36
    L28:
        r106 = r105.getAppId();     // Catch: Throwable -> L43
        goto L29
    L6:
        if (r102.f19995a != null) goto L8;
        r102.a();     // Catch: Throwable -> L43
    L8:
        r103 = r102.f19995a.getBoolean("report_pre_install_channel", false);     // Catch: Throwable -> L43
    L43:
        th = move-exception;
        zo7.b.c("ReportPreInstallChannelTask", "meet throwable", th);
        AtomicBoolean r113 = d.f19987g;
        d.a.f19994a.c(false);
        b(false, th.getMessage());
        f556511d = false;
    }

    @Override // java.lang.Runnable
    public final void run() {
        a();     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }

    public final void b(boolean r100, String r101) {
        JSONObject r102 = new JSONObject();     // Catch: Throwable -> L4
        r102.put("pre_install_channel", this.f556512a);     // Catch: Throwable -> L4
        r102.put(HiAnalyticsConstant.BI_KEY_COST_TIME, this.f556514c);     // Catch: Throwable -> L4
        r102.put("result", r100);     // Catch: Throwable -> L4
        r102.put("failed_reason", r101);     // Catch: Throwable -> L4
        c.a("yz_channel_report_by_api", r102, null);     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        zo7.b.c("ReportPreInstallChannelTask", "reportPreInstallChannelByApiEvent", th);
    }

    public b(String r100, String r101, long r102) {
        this.f556512a = r100;
        this.f556513b = r101;
        this.f556514c = r102;
    }
}
