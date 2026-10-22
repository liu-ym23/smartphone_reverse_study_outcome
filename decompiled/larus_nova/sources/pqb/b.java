package pqb;

import com.ss.android.agilelogger.ALog;
import java.util.ArrayList;
import java.util.List;
import kotlin.jvm.JvmStatic;

/* JADX INFO: loaded from: classes36.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f530315a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static volatile b f530316b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static volatile com.ss.android.lark.log.f f530317c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static volatile List<String> f530318d;

    public static final class a {
        public a() {
        }

        @JvmStatic
        public static String a(String r100, String r101, Integer r102) {
            if (r101 == null) goto L15;
            StringBuilder r103 = new StringBuilder();
            r103.append(r101);
            r103.append('#');
            r103.append(r100);
            if (r102 != null) goto L7;
        L8:
            String r104 = ":" + r102;
        L10:
            r103.append(r104);
            String r105 = r103.toString();
            if (r105 != null) goto L14;
            return r100;
        L14:
            return r105;
        L7:
            if (r102.intValue() != 0) goto L8;
            r104 = "";
            goto L10
        L15:
            return r100;
        }
    }

    public b() {
    }

    static {
        f530315a = new a();
        f530318d = new ArrayList();
    }

    public static String e(String r100) {
        com.ss.android.lark.log.f r101 = f530317c;
        if (r101 == null) goto L7;
        boolean r102 = true;
        if (r101.f431392h != true) goto L7;
    L8:
        if (r102 == true) goto L10;
        return r100;
    L10:
        ThreadLocal<knc.c.a> r103 = knc.c.f504332a;
        knc.c.a r104 = r103.get();
        if (r104 == null) goto L13;
        String r105 = r104.f504334b;
    L14:
        knc.c.a r106 = r103.get();
        if (r106 == null) goto L17;
        Integer r107 = Integer.valueOf(r106.f504335c);
    L18:
        knc.c.a r108 = r103.get();
        if (r108 != null) goto L21;
        r108 = new knc.c.a();
    L21:
        r108.f504333a = null;
        r108.f504334b = null;
        r108.f504335c = -1;
        r103.set(r108);
        return a.a(r100, r105, r107);
    L17:
        r107 = null;
        goto L18
    L13:
        r105 = null;
    L7:
        r102 = false;
        goto L8
    }

    public static void a(String r100, String r101) {
        if (c(r100, r101, 3) == false) goto L6;
        ALog.d(e(r100), r101);
        return;
    }

    public static void b(String r100, String r101) {
        if (c(r100, r101, 6) == false) goto L6;
        ALog.e(e(r100), r101);
        return;
    }

    public static void d(String r100, String r101) {
        if (c(r100, r101, 4) == false) goto L6;
        ALog.i(e(r100), r101);
        return;
    }

    public static void f(String r100, String r101) {
        if (c(r100, r101, 2) == false) goto L6;
        ALog.v(e(r100), r101);
        return;
    }

    public static boolean c(String r100, String r101, Integer r102) {
        if (r100 == null) goto L14;
        if (r101 == null) goto L14;
        if (r102 == null) goto L8;
        if (r102.intValue() < 2) goto L14;
    L8:
        if (((ArrayList) f530318d).size() != 0) goto L10;
    L13:
        return true;
    L10:
        if (((ArrayList) f530318d).contains(r100) == false) goto L13;
        if (((ArrayList) f530318d).contains(r100) == true) goto L13;
    L14:
        return false;
    }
}
