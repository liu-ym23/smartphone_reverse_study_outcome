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
import org.xmlpull.v1.XmlPullParser;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes.dex */
public final class b {
    public static volatile boolean a = false;
    public static long b = -1;
    public static String c = "";

    public static class a implements Runnable {
        public final /* synthetic */ JSONObject a;
        public final /* synthetic */ IZeusReporter b;
        public final /* synthetic */ String c;

        public final void a() {
            JSONObject r0 = this.a;
            r0.put("zeus_core_version_code", "0.0.1-alpha.174");     // Catch: JSONException -> L9
            Zeus.getAppApplication();     // Catch: JSONException -> L9
            r0.put("cur_process", d.c());     // Catch: JSONException -> L9
            if (r.a == false) goto L6;
            int r2 = 1;
        L7:
            r0.put("is_first_boot", r2);     // Catch: JSONException -> L9
            b.b();     // Catch: JSONException -> L9
            r0.put("host_version_code", b.b);     // Catch: JSONException -> L9
            r0.put("host_version_name", b.c);     // Catch: JSONException -> L9
        L11:
            this.b.report(this.c, this.a);
            return;
        L6:
            r2 = 0;
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

        public a(JSONObject r1, IZeusReporter r2, String r3) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
        }
    }

    public b() {
    }

    public static void b() {
        if (a == false) goto L6;
        return;
    L6:
        monitor-enter(b.class);
    L30:
        th = move-exception;
        throw th;
    L8:
        if (a == false) goto L36;
        monitor-exit(b.class);     // Catch: Throwable -> L30
        return;
    L36:
        PackageInfo r2 = Zeus.getAppApplication().getPackageManager().getPackageInfo(Zeus.getAppApplication().getPackageName(), 0);     // Catch: Throwable -> L22
        if (Build.VERSION.SDK_INT < 28) goto L15;
        long r3 = r2.getLongVersionCode();     // Catch: Throwable -> L22
    L16:
        b = r3;     // Catch: Throwable -> L22
        String r4 = r2.versionName;     // Catch: Throwable -> L22
        if (r4 != null) goto L19;
        r4 = XmlPullParser.NO_NAMESPACE;
    L19:
        c = r4;     // Catch: Throwable -> L22
    L20:
        a = true;     // Catch: Throwable -> L30
        monitor-exit(b.class);     // Catch: Throwable -> L30
        return;
    L15:
        r3 = r2.versionCode;     // Catch: Throwable -> L22
    L22:
        th = move-exception;
        ZeusLogger.w(ZeusLogger.TAG_REPORTER, "load host version failed", th);     // Catch: Throwable -> L27
    L27:
        th = move-exception;
        a = true;     // Catch: Throwable -> L30
        throw th;     // Catch: Throwable -> L30
    }

    public static String a(Object r0) {
        if (r0 != null) goto L6;
        return XmlPullParser.NO_NAMESPACE;
    L6:
        return r0.toString();
    }

    public static void c(String r2, JSONObject r3) {
        IZeusReporter r0 = GlobalParam.getInstance().getReporter();
        if (r0 == null) goto L6;
        e.b(new a(r3, r0, r2));
        return;
    }
}
