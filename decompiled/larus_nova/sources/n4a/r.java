package n4a;

import android.content.Context;
import android.os.Looper;
import android.text.TextUtils;
import com.ss.android.ugc.bytex.pthread.base.proxy.PThreadPoolExecutor;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.Vector;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: loaded from: classes32.dex */
public final class r extends n implements Thread.UncaughtExceptionHandler {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final Set<Integer> f517629e = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Context f517630d;

    public r(Context r100) {
        this.f517630d = r100;
        Thread.UncaughtExceptionHandler r101 = Thread.getDefaultUncaughtExceptionHandler();     // Catch: Throwable -> L17
        this.f517543a = r101;     // Catch: Throwable -> L17
        if (r101 != null) goto L7;
        Thread.setDefaultUncaughtExceptionHandler(this);     // Catch: Throwable -> L17
        this.f517544b = true;     // Catch: Throwable -> L17
        return;
    L7:
        String r102 = r101.toString();     // Catch: Throwable -> L17
        if (r102.startsWith("com.amap.apis.utils.core.dynamiccore") == false) goto L10;
    L15:
        Thread.setDefaultUncaughtExceptionHandler(this);     // Catch: Throwable -> L17
        this.f517544b = true;     // Catch: Throwable -> L17
        return;
    L10:
        if (r102.indexOf("com.amap.api") == (-1)) goto L12;
    L13:
        this.f517544b = false;     // Catch: Throwable -> L17
        return;
    L12:
        if (r102.indexOf("com.loc") == (-1)) goto L15;
    L17:
        th = move-exception;
        th.printStackTrace();
    }

    public static void f(Throwable r100, String r101, String r102) {
        r r103 = n.f517542c;     // Catch: Throwable -> L6
        if (r103 == null) goto L9;
        r103.c(r100, 1, r101, r102);     // Catch: Throwable -> L6
        return;
    L9:
        return;
    }

    @Override // java.lang.Thread.UncaughtExceptionHandler
    public final void uncaughtException(Thread r100, Throwable r101) {
        if (r101 != null) goto L4;
        return;
    L4:
        c(r101, 0, null, null);
        Thread.UncaughtExceptionHandler r102 = this.f517543a;
        if (r102 == null) goto L12;
        Thread.setDefaultUncaughtExceptionHandler(r102);     // Catch: Throwable -> L9
    L7:
        this.f517543a.uncaughtException(r100, r101);
        return;
    }

    static {
        f517629e = Collections.synchronizedSet(new HashSet());
        new AtomicInteger(1);
    }

    public static synchronized void e() {
        monitor-enter(r.class);
        PThreadPoolExecutor r100 = h0.f517310r;     // Catch: Throwable -> L10
        if (r100 != null) goto L7;
    L31:
    L22:
        th = move-exception;
        th.printStackTrace();     // Catch: Throwable -> L26
        return;
    L13:
        if (n.f517542c == null) goto L19;
        Thread.UncaughtExceptionHandler r101 = Thread.getDefaultUncaughtExceptionHandler();     // Catch: Throwable -> L22
        r r102 = n.f517542c;     // Catch: Throwable -> L22
        if (r101 != r102) goto L19;
        Thread.UncaughtExceptionHandler r103 = r102.f517543a;     // Catch: Throwable -> L22
        if (r103 == null) goto L19;
        Thread.setDefaultUncaughtExceptionHandler(r103);     // Catch: Throwable -> L22
    L19:
        n.f517542c = null;     // Catch: Throwable -> L22
        monitor-exit(r.class);
        return;
    L7:
        if (r100.isShutdown() == true) goto L31;
        h0.f517310r.shutdown();     // Catch: Throwable -> L10
    L10:
        th = move-exception;
        th.printStackTrace();     // Catch: Throwable -> L26
    L26:
        th = move-exception;
        throw th;
    }

    public static void g() {
        r r100 = n.f517542c;
        if (r100 == null) goto L15;
        Context r101 = r100.f517630d;
        Vector<e5> r102 = p.f517579b;
    L10:
        th = move-exception;
        f(th, "Lg", "proL");
        return;
    L6:
        if ((System.currentTimeMillis() - p.f517578a) < 60000) goto L16;
        p.f517578a = System.currentTimeMillis();     // Catch: Throwable -> L10
        k1.f517430d.b(new o(r101));     // Catch: Throwable -> L10
        return;
    L16:
        return;
    }

    public static synchronized void b(Context r100, e5 r101) throws com.loc.l {
        monitor-enter(r.class);
    L29:
        th = move-exception;
        throw th;
    L5:
        if (r101.a() == null) goto L28;
        if ("".equals(r101.a()) == true) goto L28;
    L15:
        th = move-exception;
        th.printStackTrace();     // Catch: Throwable -> L29
    L25:
        monitor-exit(r.class);
        return;
    L9:
        if (f517629e.add(Integer.valueOf(r101.hashCode())) == true) goto L12;
        monitor-exit(r.class);
        return;
    L12:
        r r102 = n.f517542c;     // Catch: Throwable -> L15
        if (r102 != null) goto L17;
        n.f517542c = new r(r100);     // Catch: Throwable -> L15
    L18:
        r r103 = n.f517542c;     // Catch: Throwable -> L15
        boolean r104 = r103.f517544b;     // Catch: Throwable -> L15
        k1.f517430d.b(new q(r103, r101, r104));     // Catch: Throwable -> L21 RejectedExecutionException -> L32
    L21:
        th = move-exception;
        th.printStackTrace();     // Catch: Throwable -> L15
        goto L25
    L17:
        r102.f517544b = false;     // Catch: Throwable -> L15
    L28:
        throw new com.loc.l("sdk name is invalid");     // Catch: Throwable -> L29
    }

    public final void c(Throwable r110, int r111, String r210, String r211) {
        Context r100 = this.f517630d;
        String[] r101 = f5.f517286a;
        StringWriter r102 = new StringWriter();     // Catch: Throwable -> L23
        PrintWriter r103 = new PrintWriter(r102);     // Catch: Throwable -> L21
        r110.printStackTrace(r103);     // Catch: Throwable -> L19
        Throwable r104 = r110;
    L7:
        r104 = r104.getCause();     // Catch: Throwable -> L19
        if (r104 == null) goto L10;
        r104.printStackTrace(r103);     // Catch: Throwable -> L19
        goto L7
    L10:
        String r105 = r102.toString();     // Catch: Throwable -> L19
        r102.close();     // Catch: Throwable -> L13
    L156:
        r103.close();     // Catch: Throwable -> L17
    L38:
        Vector<e5> r106 = p.f517579b;
        Looper r107 = Looper.getMainLooper();     // Catch: Throwable -> L47
        monitor-enter(r107);     // Catch: Throwable -> L47
        List r108 = p.f517579b;     // Catch: Throwable -> L44
        monitor-exit(r107);     // Catch: Throwable -> L44
    L49:
        if (r108 != null) goto L52;
        r108 = new ArrayList();
    L52:
        if (r105 != null) goto L54;
    L100:
        e5 r109 = null;
    L101:
        if (r109 == null) goto L108;
        boolean r112 = true;
        if (r109.f517261c != 1) goto L105;
        boolean r113 = true;
    L106:
        if (r113 == false) goto L108;
    L109:
        if (r112 == false) goto L177;
        String r114 = r105.replaceAll("\n", "<br/>");
        String r115 = r110.toString();
        if (r115 != null) goto L114;
        return;
    L114:
        if ("".equals(r115) == true) goto L178;
        StringBuilder r116 = new StringBuilder();
        if (r210 == null) goto L119;
        r116.append("class:");
        r116.append(r210);
    L119:
        if (r211 == null) goto L121;
        r116.append(" method:");
        r116.append(r211);
        r116.append("$<br/>");
    L121:
        r116.append(r114);
        t.b(r100, r109, r111, r115, r116.toString());
        return;
    L178:
        return;
    L177:
        return;
    L105:
        r113 = false;
    L108:
        r112 = false;
        goto L109
    L54:
        if ("".equals(r105) == true) goto L100;
        Iterator r117 = r108.iterator();
    L58:
        if (r117.hasNext() == false) goto L85;
        e5 r118 = (e5) r117.next();
        String[] r119 = r118.d();
        String[] r120 = r105.split("\n");     // Catch: Throwable -> L79
        int r121 = r120.length;     // Catch: Throwable -> L79
        int r122 = 0;
    L61:
        if (r122 >= r121) goto L73;
        String r123 = r120[r122].trim();     // Catch: Throwable -> L79
        if (TextUtils.isEmpty(r123) == false) goto L65;
    L69:
        boolean r124 = false;
    L70:
        if (r124 == true) goto L81;
        r122 = r122 + 1;     // Catch: Throwable -> L79
    L81:
        boolean r125 = false;
    L82:
        if (r125 == false) goto L58;
        r109 = r118;
        goto L101
    L65:
        if (r123.startsWith("at ") == false) goto L69;
        if (r123.contains("uncaughtException") == false) goto L69;
        r124 = true;
        goto L70
    L73:
        int r126 = r120.length;     // Catch: Throwable -> L79
        int r127 = 0;
    L74:
        if (r127 >= r126) goto L81;
        if (p.b(r119, r120[r127].trim()) == true) goto L77;
        r127 = r127 + 1;
        goto L74
    L77:
        r125 = true;
    L79:
        th = move-exception;
        th.printStackTrace();
        goto L81
    L85:
        if (r105.contains("com.amap.api.col") == false) goto L91;
        e5.a r128 = new e5.a("collection", "1.0", "AMap_collection_1.0");     // Catch: com.loc.l -> L88
        r128.f517273e = (String[]) new String[]{"com.amap.api.collection"}.clone();     // Catch: com.loc.l -> L88
        r109 = r128.a();     // Catch: com.loc.l -> L88
    L88:
        e = move-exception;
        e.printStackTrace();
    L91:
        if (r105.contains("com.amap.co") == false) goto L93;
    L158:
        String[] r129 = f5.f517286a;     // Catch: com.loc.l -> L98
        e5.a r130 = new e5.a("co", "1.0.0", "AMap_co_1.0.0");     // Catch: com.loc.l -> L98
        r130.f517273e = (String[]) new String[]{"com.amap.co", "com.amap.opensdk.co", "com.amap.location"}.clone();     // Catch: com.loc.l -> L98
        e5 r131 = r130.a();     // Catch: com.loc.l -> L98
        r131.f517261c = 1;     // Catch: com.loc.l -> L98
        r109 = r131;
    L98:
        e = move-exception;
        e.printStackTrace();
        goto L100
    L93:
        if (r105.contains("com.amap.opensdk.co") == true) goto L158;
        if (r105.contains("com.amap.location") == false) goto L100;
    L44:
        th = move-exception;
        throw th;     // Catch: Throwable -> L47
    L47:
        th = move-exception;
        th.printStackTrace();
        r108 = p.f517579b;
    L17:
        th = move-exception;
        th.printStackTrace();
    L13:
        th = move-exception;
        th.printStackTrace();
    L19:
        th = th;
    L140:
        th.printStackTrace();     // Catch: Throwable -> L123
        if (r102 != null) goto L152;
    L32:
        if (r103 != null) goto L160;
    L37:
        r105 = null;
        goto L38
    L160:
        r103.close();     // Catch: Throwable -> L35
    L35:
        th = move-exception;
        th.printStackTrace();
        goto L37
    L152:
        r102.close();     // Catch: Throwable -> L30
    L30:
        th = move-exception;
        th.printStackTrace();
    L123:
        th = move-exception;
        if (r102 != null) goto L144;
    L130:
        if (r103 == null) goto L179;
        r103.close();     // Catch: Throwable -> L133
        throw th;
    L133:
        th = move-exception;
        th.printStackTrace();
        throw th;
    L179:
        throw th;
    L144:
        r102.close();     // Catch: Throwable -> L128
    L128:
        th = move-exception;
        th.printStackTrace();
    L21:
        th = th;
    L25:
        r103 = null;
    L23:
        th = th;
        r102 = null;
        goto L25
    }

    public static void d(e5 r100, String r101, String r102, String r103, String r104, String r105) {
        if (n.f517542c == null) goto L19;
        String r106 = "path:" + r101 + ",type:" + r102 + ",gsid:" + r103 + ",csid:" + r104 + ",code:" + r105;     // Catch: Throwable -> L16
        Context r107 = n.f517542c.f517630d;     // Catch: Throwable -> L16
        boolean r108 = false;
        if (r100 != null) goto L7;
    L12:
        if (r108 == false) goto L20;
        t.b(r107, r100, 1, "networkError", r106);     // Catch: Throwable -> L16
        return;
    L20:
        return;
    L7:
        if (r100.f517261c != 1) goto L9;
        boolean r109 = true;
    L10:
        if (r109 == false) goto L12;
        r108 = true;
        goto L12
    L9:
        r109 = false;
        goto L10
    L19:
        return;
    }
}
