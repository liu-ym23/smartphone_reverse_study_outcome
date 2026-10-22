package rb4;

import android.text.TextUtils;
import com.bytedance.bdturing.BdTuringConfig;
import com.bytedance.retrofit2.SsResponse;
import com.bytedance.retrofit2.mime.TypedInput;
import com.bytedance.security.android.aopcheck.PolarisFileInputStreamWrapper;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.ss.android.ugc.bytex.pthread.base.proxy.PThreadPoolExecutor;
import java.io.File;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicBoolean;
import qb4.n;

/* JADX INFO: loaded from: classes3.dex */
public final class c implements com.bytedance.bdturing.setting.c.a {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static volatile c f536917h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final String f536918i = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Map<Integer, Boolean> f536919a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f536920b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public String f536921c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public String f536922d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final AtomicBoolean f536923e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Object f536924f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f536925g;

    static {
        f536918i = "BdTuring" + File.separator + "web_res";
    }

    public static c e() {
        if (f536917h != null) goto L15;
        monitor-enter(c.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (f536917h != null) goto L9;
        f536917h = new c();     // Catch: Throwable -> L11
    L9:
        monitor-exit(c.class);     // Catch: Throwable -> L11
    L15:
        return f536917h;
    }

    public final String g() {
        if (TextUtils.isEmpty(this.f536920b) == false) goto L10;
        BdTuringConfig r100 = qb4.b.c.f532315a.f532302a;
        if (r100 == null) goto L10;
        if (r100.getApplicationContext() == null) goto L10;
        this.f536920b = r100.getApplicationContext().getFilesDir().getAbsolutePath() + File.separator + f536918i;
    L10:
        return this.f536920b;
    }

    public c() {
        this.f536923e = new AtomicBoolean(false);
        this.f536924f = new Object();
        this.f536925g = -1;
        this.f536919a = new HashMap();
    }

    public static String f(String r100) {
    L8:
        e = move-exception;
        e.printStackTrace();
        return r100;
    L3:
        if (TextUtils.isEmpty(r100) == true) goto L13;
        int r101 = r100.lastIndexOf(".");     // Catch: Exception -> L8
        if (r101 <= 0) goto L14;
        return r100.substring(0, r101);
    L14:
        return r100;
    L13:
        return r100;
    }

    public final void c(h r100) {
        if (r100 != null) goto L4;
        return;
    L4:
        if (TextUtils.isEmpty(r100.f536933a) == false) goto L6;
        return;
    L6:
        if (TextUtils.isEmpty(g()) == true) goto L24;
        PolarisFileWrapper r101 = new PolarisFileWrapper(g(), r100.f536933a);
        if (r101.exists() == false) goto L22;
        hc4.c.f(r101);
        Object r102 = this.f536924f;
        monitor-enter(r102);
        hc4.c.e(g() + File.separator + f(r100.f536933a));     // Catch: Throwable -> L15
        monitor-exit(r102);     // Catch: Throwable -> L15
        return;
    L15:
        th = move-exception;
        throw th;
    L22:
        return;
    }

    public static void b(c r100, h r101) {
        r100.getClass();
        if (r101 == null) goto L37;
        boolean r102 = true;
        if (TextUtils.isEmpty(r101.f536933a) == false) goto L7;
    L11:
        boolean r103 = false;
    L12:
        if (r103 == true) goto L15;
        return;
    L15:
        if (TextUtils.isEmpty(r100.g()) == false) goto L17;
    L30:
        r102 = false;
    L31:
        if (r102 == true) goto L40;
        r100.c(r101);
        e r104 = e.a();
        a r105 = new a(r100, r101);
        PThreadPoolExecutor r106 = r104.f536929a;
        if (r106 == null) goto L38;
        r106.execute(r105);
        return;
    L38:
        return;
    L40:
        return;
    L17:
        if (TextUtils.isEmpty(r101.f536933a) == false) goto L19;
    L23:
        boolean r107 = false;
    L24:
        if (r107 == false) goto L30;
        String r108 = hc4.c.g(new PolarisFileWrapper(r100.g(), r101.f536933a));
        if (TextUtils.isEmpty(r108) == true) goto L30;
        if (r108.equals(r101.f536935c) == false) goto L30;
    L19:
        if (TextUtils.isEmpty(r101.f536934b) == true) goto L23;
        if (TextUtils.isEmpty(r101.f536935c) == true) goto L23;
        r107 = true;
        goto L24
    L7:
        if (TextUtils.isEmpty(r101.f536934b) == true) goto L11;
        if (TextUtils.isEmpty(r101.f536935c) == true) goto L11;
        r103 = true;
        goto L12
    }

    public static File h(String r100, String r101) {
    L15:
        e = move-exception;
        e.printStackTrace();
        return null;
    L4:
        if (TextUtils.isEmpty(r100) == false) goto L6;
        return null;
    L6:
        if (TextUtils.isEmpty(r101) == true) goto L21;
        SsResponse<TypedInput> r102 = ec4.h.b(r100).doGet(false, r100, null, null).execute();     // Catch: Exception -> L15
        if (r102 != null) goto L10;
        return null;
    L10:
        if (r102.code() == 200) goto L12;
        return null;
    L12:
        if (r102.code() != 200) goto L24;
        return hc4.c.c(r102.body().in(), r101);
    L24:
        return null;
    L21:
        return null;
    }

    public final File d(String r100, int r101) throws Exception {
        c r102 = e();
        if (r101 == 1) goto L14;
        if (r101 == 2) goto L8;
        r102.getClass();
        String r103 = "";
    L20:
        if (TextUtils.isEmpty(r103) == false) goto L23;
        this.f536925g = 4;
        return null;
    L23:
        PolarisFileWrapper r104 = new PolarisFileWrapper(r103);
        if (r104.exists() == true) goto L26;
    L36:
        this.f536925g = 4;
        return null;
    L26:
        if (r104.listFiles() == null) goto L36;
        if (r104.listFiles().length == 0) goto L36;
        File r105 = new PolarisFileWrapper(r103 + File.separator + r100).getCanonicalFile();
        if (r105.getPath().startsWith(r104.getCanonicalPath()) == false) goto L35;
        this.f536925g = 0;
        return r105;
    L35:
        throw new IllegalArgumentException();
    L8:
        if (TextUtils.isEmpty(r102.f536922d) == true) goto L10;
    L12:
        r103 = r102.f536922d;
        goto L20
    L10:
        if (TextUtils.isEmpty(r102.g()) == true) goto L12;
        r102.f536922d = r102.g() + File.separator + f("authentication.zip");
        goto L12
    L14:
        if (TextUtils.isEmpty(r102.f536921c) == true) goto L16;
    L18:
        r103 = r102.f536921c;
        goto L20
    L16:
        if (TextUtils.isEmpty(r102.g()) == true) goto L18;
        r102.f536921c = r102.g() + File.separator + f("captcha.zip");
        goto L18
    }

    public final PolarisFileInputStreamWrapper i(String r100, int r101) {
        PolarisFileInputStreamWrapper r102 = null;
        if (TextUtils.isEmpty(r100) == false) goto L5;
        return null;
    L5:
        Object r103 = this.f536924f;
        monitor-enter(r103);
        File r104 = d(r100, r101);     // Catch: Throwable -> L18 Exception -> L20
        if (r104 != null) goto L10;
    L16:
        Objects.toString(r102);     // Catch: Throwable -> L18 Exception -> L20
        int r105 = n.f532367a;     // Catch: Throwable -> L18 Exception -> L20
    L22:
        monitor-exit(r103);     // Catch: Throwable -> L18
        return r102;
    L10:
        if (r104.exists() == false) goto L16;
        if (r104.isFile() == false) goto L16;
        if (r104.length() <= 0) goto L16;
        r102 = new PolarisFileInputStreamWrapper(r104);     // Catch: Throwable -> L18 Exception -> L20
    L18:
        th = move-exception;
        throw th;
    L20:
        e = move-exception;
        e.printStackTrace();     // Catch: Throwable -> L18
        goto L22
    }

    @Override // com.bytedance.bdturing.setting.c.a
    public final void a(int r100, String r101, long r102) {
        int r103 = n.f532367a;
        if (r100 == 200) goto L5;
    L22:
        this.f536925g = 1;
        return;
    L5:
        if (TextUtils.isEmpty(r101) == true) goto L22;
        BdTuringConfig r104 = qb4.b.c.f532315a.f532302a;     // Catch: Exception -> L14
        if (r104 != null) goto L9;
    L16:
        this.f536925g = 0;
        if (TextUtils.isEmpty(r101) == true) goto L28;
        e r105 = e.a();
        b r106 = new b(this, r101);
        PThreadPoolExecutor r107 = r105.f536929a;
        if (r107 == null) goto L26;
        r107.execute(r106);
        return;
    L26:
        return;
    L28:
        return;
    L9:
        if (r104.getApplicationContext() == null) goto L16;
        PolarisFileWrapper r108 = new PolarisFileWrapper(r104.getApplicationContext().getFilesDir().getAbsolutePath() + File.separator + "turing_web_res");     // Catch: Exception -> L14
        if (r108.exists() == false) goto L16;
        hc4.c.f(r108);     // Catch: Exception -> L14
    L14:
        e = move-exception;
        e.printStackTrace();
        goto L16
    }
}
