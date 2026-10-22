package ss3;

import android.os.Looper;
import android.text.TextUtils;
import com.bytedance.bdlocation.monitor.LocationMonitorConst;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public final class j extends ss3.a {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final int f543399h = 0;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static boolean f543400i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static int f543401j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static boolean f543402k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static boolean f543403l;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public long f543404g;

    /* JADX INFO: loaded from: classes14.dex */
    public static class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ boolean f543405a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ int[] f543406b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ String f543407c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ int f543408d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final /* synthetic */ ThreadGroup f543409e;

        public final void a() {
            if (this.f543405a == true) goto L24;
            int[] r100 = this.f543406b;
            int r101 = r100[0];
            if (r101 < j.f543401j) goto L24;
            if (j.f543400i == false) goto L24;
            Thread[] r102 = new Thread[r101 + (r101 / 2)];
            r100[0] = this.f543409e.enumerate(r102);
            StringBuilder r103 = new StringBuilder();
            int r104 = 0;
        L10:
            int r105 = this.f543406b[0];
            if (r104 >= r105) goto L22;
            String r106 = r102[r104].getName();
            if (TextUtils.isEmpty(r106) == true) goto L15;
            r103.append(r106);
            r103.append(",");
        L15:
            r104 = r104 + 1;
            goto L10
        L22:
            JSONObject r107 = j.i(this.f543407c, this.f543408d, r105, r103.toString());     // Catch: Throwable -> L20
            is3.a.h().b(new js3.e(r107));     // Catch: Throwable -> L20
            return;
        L28:
            return;
        L24:
            JSONObject r108 = j.i(this.f543407c, this.f543408d, this.f543406b[0], null);     // Catch: Exception -> L21
            is3.a.h().b(new js3.e(r108));     // Catch: Exception -> L21
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

        public a(boolean r100, int[] r101, String r102, int r103, ThreadGroup r104) {
            this.f543405a = r100;
            this.f543406b = r101;
            this.f543407c = r102;
            this.f543408d = r103;
            this.f543409e = r104;
        }
    }

    @Override // ss3.a
    public final boolean c() {
        return true;
    }

    @Override // ss3.a
    public final void e() {
        if (f543402k == true) goto L5;
        return;
    L5:
        if (f543403l == true) goto L7;
        return;
    L7:
        if ((System.currentTimeMillis() - com.bytedance.apm.d.e()) <= 1200000) goto L12;
        j(null, false);
        return;
    }

    static {
        f543399h = Runtime.getRuntime().availableProcessors();
        f543400i = false;
        f543401j = 300;
        f543402k = false;
        f543403l = false;
    }

    public j() {
        this.f543404g = 600000;
        this.f543336e = "thread";
    }

    @Override // ss3.a, com.bytedance.services.slardar.config.IConfigListener
    public final void onReady() {
        super.onReady();
        f543400i = true;
    }

    @Override // ss3.a
    public final long h() {
        return this.f543404g;
    }

    @Override // ss3.a
    public final void a(JSONObject r100) {
        boolean r101 = false;
        if (r100.optInt("enable_thread_collect", 0) != 1) goto L5;
        boolean r102 = true;
    L6:
        f543402k = r102;
        if (r100.optInt("enable_upload", 0) != 1) goto L9;
        r101 = true;
    L9:
        f543403l = r101;
        f543401j = r100.optInt("thread_count_threshold", 300);
        this.f543404g = r100.optLong("collect_interval", 10) * 60000;
        return;
    L5:
        r102 = false;
        goto L6
    }

    public static int j(String r110, boolean r111) {
        int r100 = new PolarisFileWrapper("/proc/self/task/").list().length;     // Catch: Throwable -> L5
    L6:
        if (r100 != 0) goto L8;
        return 0;
    L8:
        ThreadGroup r101 = ThreadMethodProxy.getLooperThread(Looper.getMainLooper()).getThreadGroup();
    L10:
        if (r101.getParent() == null) goto L12;
        r101 = r101.getParent();
        goto L10
    L12:
        int[] r102 = {r101.activeCount()};
        bt3.b.d.f20539a.e(new a(r111, r102, r110, r100, r101));
        return (r100 << 16) + r102[0];
    L5:
        r100 = 0;
        goto L6
    }

    public static JSONObject i(String r100, int r101, int r102, String r103) {
        JSONObject r104 = new JSONObject();
        if (r101 > 0) goto L16;
    L5:
        r104.put("java_thread_count", r102);     // Catch: JSONException -> L13
        if (TextUtils.isEmpty(r100) == true) goto L9;
        r104.put("scene", r100);     // Catch: JSONException -> L13
    L9:
        if (TextUtils.isEmpty(r103) == true) goto L11;
        r104.put("thread_detail", r103);     // Catch: JSONException -> L13
    L11:
        r104.put(LocationMonitorConst.IS_MAIN_PROCESS, com.bytedance.apm.d.k());     // Catch: JSONException -> L13
        r104.put("cpu_count", f543399h);     // Catch: JSONException -> L13
        r104.put("process_name", com.bytedance.apm.d.c());     // Catch: JSONException -> L13
    L15:
        return r104;
    L13:
        e = move-exception;
        e.printStackTrace();
        goto L15
    L16:
        r104.put("total_thread_count", r101);     // Catch: JSONException -> L13
        goto L5
    }
}
