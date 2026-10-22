package k27;

import android.content.SharedPreferences;
import android.text.TextUtils;
import com.bytedance.mira.log.MiraLogger;
import com.bytedance.mt.protector.impl.string2number.CastIntegerProtector;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: classes3.dex */
public final class g {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static volatile g f501614b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final String f501615c = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final SharedPreferences f501616a;

    public static class a implements Runnable {
        public static void a() {
            String r100 = p27.b.b();
            if (TextUtils.isEmpty(r100) == true) goto L6;
            PolarisFileWrapper r101 = new PolarisFileWrapper(r100);
            MiraLogger.i(MiraLogger.TAG_INIT, "PreDownloadScanRunnable listPluginDownloadDir, dir = " + r101);
            r101.listFiles(new f());
            return;
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

        public a() {
        }
    }

    /* JADX INFO: loaded from: classes21.dex */
    public static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f501617a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f501618b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final String f501619c;

        public b(String r100) {
            String r101 = r100.replaceAll("pre_download_", "").replaceAll("\\.jar", "");
            String[] r102 = r101.split("_");
            if (r102.length >= 3) goto L6;
            MiraLogger.d(g.f501615c, "PrePlugin : info length < 3 >>> ".concat(r100));
            return;
        L6:
            this.f501619c = r102[r102.length - 1];
            this.f501618b = CastIntegerProtector.parseInt(r102[r102.length - 2]);     // Catch: Exception -> L9
        L10:
            this.f501617a = r101.replaceAll("_" + this.f501618b + "_" + this.f501619c, "");
            return;
        L9:
            this.f501618b = -1;
            goto L10
        }
    }

    static {
        f501615c = "morpheus-".concat(g.class.getSimpleName());
    }

    public static g a() {
        if (f501614b != null) goto L15;
        monitor-enter(g.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (f501614b != null) goto L9;
        f501614b = new g();     // Catch: Throwable -> L11
    L9:
        monitor-exit(g.class);     // Catch: Throwable -> L11
    L15:
        return f501614b;
    }

    public g() {
        this.f501616a = h27.a.getContext().getSharedPreferences("morpheus_pre_download", 0);
    }

    public static boolean b(l27.b r100) {
        if (r100.f507140m != 3) goto L5;
        return true;
    L5:
        return false;
    }

    public final void d(String r100, int r101, boolean r102) {
        SharedPreferences.Editor r103 = this.f501616a.edit();
        String r104 = "PRE_DOWNLOAD_DOWNLOAD_" + r100 + "_" + r101;
        if (r102 == false) goto L5;
        r103.putBoolean(r104, true);
    L6:
        r103.apply();
        return;
    L5:
        r103.remove(r104);
        goto L6
    }

    public final void c(String r100, int r101, String r102, boolean r103) {
        SharedPreferences.Editor r104 = this.f501616a.edit();
        String r105 = "PRE_DOWNLOAD_MD5_" + r100 + "_" + r101;
        if (r103 == false) goto L5;
        r104.putString(r105, r102);
    L6:
        r104.apply();
        return;
    L5:
        r104.remove(r105);
        goto L6
    }
}
