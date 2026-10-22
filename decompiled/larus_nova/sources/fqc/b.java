package fqc;

import android.content.pm.PackageInfo;
import android.os.Build;
import com.larus.apm.impl.protector.RunnableProtector;
import com.volcengine.zeus.GlobalParam;
import com.volcengine.zeus.Zeus;
import com.volcengine.zeus.log.IZeusReporter;
import com.volcengine.zeus.log.ZeusLogger;
import dqc.d;
import dqc.e;
import mqc.r;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static volatile boolean f478481a = false;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static long f478482b = -1;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static String f478483c = "";

    public static class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ JSONObject f478484a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ IZeusReporter f478485b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ String f478486c;

        public final void a() {
            JSONObject r100 = this.f478484a;
            r100.put("zeus_core_version_code", "0.0.1-alpha.174");     // Catch: JSONException -> L9
            Zeus.getAppApplication();     // Catch: JSONException -> L9
            r100.put("cur_process", d.c());     // Catch: JSONException -> L9
            if (r.f514968a == false) goto L6;
            int r101 = 1;
        L7:
            r100.put("is_first_boot", r101);     // Catch: JSONException -> L9
            b.b();     // Catch: JSONException -> L9
            r100.put("host_version_code", b.f478482b);     // Catch: JSONException -> L9
            r100.put("host_version_name", b.f478483c);     // Catch: JSONException -> L9
        L11:
            this.f478485b.report(this.f478486c, this.f478484a);
            return;
        L6:
            r101 = 0;
        L9:
            e = move-exception;
            ZeusLogger.w(ZeusLogger.TAG_REPORTER, e.getMessage(), e);
            goto L11
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

        public a(JSONObject r100, IZeusReporter r101, String r102) {
            this.f478484a = r100;
            this.f478485b = r101;
            this.f478486c = r102;
        }
    }

    public b() {
    }

    public static void b() {
        if (f478481a == false) goto L6;
        return;
    L6:
        monitor-enter(b.class);
    L30:
        th = move-exception;
        throw th;
    L8:
        if (f478481a == false) goto L36;
        monitor-exit(b.class);     // Catch: Throwable -> L30
        return;
    L36:
        PackageInfo r100 = Zeus.getAppApplication().getPackageManager().getPackageInfo(Zeus.getAppApplication().getPackageName(), 0);     // Catch: Throwable -> L22
        if (Build.VERSION.SDK_INT < 28) goto L15;
        long r101 = r100.getLongVersionCode();     // Catch: Throwable -> L22
    L16:
        f478482b = r101;     // Catch: Throwable -> L22
        String r102 = r100.versionName;     // Catch: Throwable -> L22
        if (r102 != null) goto L19;
        r102 = "";
    L19:
        f478483c = r102;     // Catch: Throwable -> L22
    L20:
        f478481a = true;     // Catch: Throwable -> L30
        monitor-exit(b.class);     // Catch: Throwable -> L30
        return;
    L15:
        r101 = r100.versionCode;     // Catch: Throwable -> L22
    L22:
        th = move-exception;
        ZeusLogger.w(ZeusLogger.TAG_REPORTER, "load host version failed", th);     // Catch: Throwable -> L27
    L27:
        th = move-exception;
        f478481a = true;     // Catch: Throwable -> L30
        throw th;     // Catch: Throwable -> L30
    }

    public static String a(Object r100) {
        if (r100 != null) goto L6;
        return "";
    L6:
        return r100.toString();
    }

    public static void c(String r100, JSONObject r101) {
        IZeusReporter r102 = GlobalParam.getInstance().getReporter();
        if (r102 == null) goto L6;
        e.b(new a(r101, r102, r100));
        return;
    }
}
