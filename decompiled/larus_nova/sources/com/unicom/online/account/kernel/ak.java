package com.unicom.online.account.kernel;

import android.content.Context;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

/* JADX INFO: loaded from: classes5.dex */
public final class ak {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static String f461989a = "123.125.99.31";

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final String f461990b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final String f461991c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final String f461992d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final String f461993e = null;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final String f461994f = null;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final String f461995g = null;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final String f461996h = null;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final String f461997i = null;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final String f461998j = null;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final String f461999k = null;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final String f462000l = null;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final String f462001m = null;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static final String f462002n = null;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public static List<d> f462003o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public static Set<String> f462004p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public static int f462005q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public static String f462006r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private static String f462007s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private static String f462008t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    private static String f462009u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    private static int f462010v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    private static int f462011w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    private static String f462012x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    private static String f462013y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    private static String f462014z;

    static {
        f461990b = new String(o.b("MTAwMTAuY29t"));
        f461991c = new String(o.b("aWQ2Lm1l"));
        f461992d = new String(o.b("Y21wYXNzcG9ydC5jb20="));
        f461993e = new String(o.b("bXN2Ni53b3Ntcy5jbg=="));
        f461994f = new String(o.b("YWxpLndvc21zLmNu"));
        f461995g = new String(o.b("bS56enguY25rbG9nLmNvbQ=="));
        f461996h = new String(o.b("dGVzdC53b3Ntcy5jbg=="));
        f461997i = new String(o.b("YXV0aC53b3Ntcy5jbg=="));
        f461998j = new String(o.b("c2RrbG9nLndvc21zLmNu"));
        f461999k = new String(o.b("L2Ryby92MS9yZXBvcnQ="));
        f462000l = new String(o.b("L3VuaWNvbUF1dGgvYW5kcm9pZC92My4wL3Fj"));
        f462001m = new String(o.b("L3VuaWNvbUF1dGgvYW5kcm9pZC92My4wL3Fj"));
        f462002n = new String(o.b("L3VuaWNvbVVhaWQvYW5kcm9pZC92MS4wL3Fj"));
        f462004p = new HashSet();
        f462006r = "0";
        f462007s = "";
        f462008t = "";
        f462009u = "";
        f462010v = 5;
        f462011w = -1;
        f462012x = "";
        f462013y = "";
        f462014z = "";
    }

    public static int a() {
        int r100 = f462005q;
        if (r100 != 0) goto L5;
        return 1;
    L5:
        if (r100 == 1) goto L11;
        if (r100 == 2) goto L9;
        return -1;
    L9:
        return 0;
    L11:
        return 2;
    }

    public static void a(int r100) {
        f462005q = r100;
    }

    public static void a(Context r100, String r101) {
        d r102 = new d();
        r102.f462035a = r101;
        if (f462003o.isEmpty() == false) goto L5;
        f462003o.add(r102);
    L8:
        am.a(r100, "DNSCache", new ArrayList(f462003o));
        return;
    L5:
        ListProtector.add(f462003o, 1, r102);
        if (f462003o.size() <= 4) goto L8;
        ListProtector.remove(f462003o, 4);
        goto L8
    }

    public static boolean a(String r100) {
        if (r100.startsWith(f461997i) == false) goto L5;
        return true;
    L5:
        if (r100.startsWith(f461993e) == false) goto L7;
        return true;
    L7:
        if (r100.startsWith(f461995g) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public static boolean a(String r100, String r101) {
        aj.a("\nhostname : " + r100 + "\nsubjectName : " + r101);
        if (ac.b() == false) goto L16;
        if (r100 == null) goto L16;
    L13:
        e = move-exception;
        aj.a(e);
        goto L16
    L6:
        if (r100.length() <= 0) goto L16;
        InetAddress r102 = InetAddress.getByName(r100.replaceFirst("^\\[", "").replaceAll("\\]$", ""));     // Catch: UnknownHostException -> L13
        Iterator<String> r103 = f462004p.iterator();     // Catch: UnknownHostException -> L13
    L9:
        if (r103.hasNext() == false) goto L16;
        if (r102.equals(InetAddress.getByName(r103.next())) == false) goto L9;
        return true;
    L16:
        if (r100.endsWith(".10010.com") == true) goto L18;
    L19:
        String r104 = f461997i;
        if (r100.equals(r104) == true) goto L22;
    L23:
        String r105 = f461993e;
        if (r100.equals(r105) == true) goto L26;
    L27:
        String r106 = f461994f;
        if (r100.equals(r106) == true) goto L30;
    L31:
        String r107 = f461996h;
        if (r100.equals(r107) == true) goto L34;
    L35:
        String r108 = f461995g;
        if (r100.equals(r108) == false) goto L40;
        if (b(r101, "CN=" + r108) == false) goto L40;
    L47:
        return true;
    L40:
        if (r100.equals("id6.me") == false) goto L44;
        if (b(r101, "CN=*.id6.me") == true) goto L47;
    L44:
        if (r100.equals("cert.cmpassport.com") == true) goto L46;
        return false;
    L46:
        if (b(r101, "CN=*.cmpassport.com") == true) goto L47;
        return false;
    L34:
        if (b(r101, "CN=" + r107) == true) goto L47;
    L30:
        if (b(r101, "CN=" + r106) == true) goto L47;
    L26:
        if (b(r101, "CN=" + r105) == true) goto L47;
    L22:
        if (b(r101, "CN=" + r104) == true) goto L47;
    L18:
        if (b(r101, "CN=10010.com") == true) goto L47;
        goto L19
    }

    public static String b() {
        return f462006r;
    }

    public static String b(int r100) {
        if (ac.a(r100) == false) goto L8;
        StringBuilder r101 = new StringBuilder("https://");
        r101.append(i.d());
        String r102 = f462000l;
    L5:
        r101.append(r102);
        r101.append("?");
        return r101.toString();
    L8:
        if (ac.b(r100) == false) goto L10;
        r101 = new StringBuilder("https://");
        r101.append(i.d());
        r102 = f462002n;
        goto L5
    L10:
        r101 = new StringBuilder("https://");
        r101.append(i.d());
        r102 = f462001m;
        goto L5
    }

    public static void b(Context r100, String r101) {
        d r102 = i(r101);
        if (r102 == null) goto L6;
        r102.f462036b = "";
        r102.f462037c = 0;
        am.a(r100, "DNSCache", new ArrayList(f462003o));
        return;
    }

    public static void b(String r100) {
        f462006r = r100;
    }

    private static boolean b(String r100, String r101) {
        if (r100.startsWith(r101) == false) goto L5;
        return true;
    L5:
        if (r100.endsWith(r101) == true) goto L11;
        return false;
    L11:
        return true;
    }

    public static String c() {
        return f462007s;
    }

    public static void c(int r100) {
        f462010v = r100;
    }

    public static void c(String r100) {
        f462007s = r100;
    }

    public static String d() {
        if (f462008t.length() == 32) goto L6;
        e();
    L6:
        return f462008t;
    }

    public static void d(int r100) {
        f462011w = r100;
    }

    public static void d(String r100) {
        aj.a("APN:".concat(String.valueOf(r100)));
        f462009u = r100;
    }

    public static String e() {
        f462008t = n.a();
        return d();
    }

    public static String e(String r100) {
        if ("cmnet".equals(r100) == false) goto L5;
    L24:
        return "1";
    L5:
        if ("cmwap".equals(r100) == true) goto L24;
        if ("3gwap".equals(r100) == false) goto L10;
    L23:
        return "3";
    L10:
        if ("uniwap".equals(r100) == true) goto L23;
        if ("3gnet".equals(r100) == true) goto L23;
        if ("uninet".equals(r100) == true) goto L23;
        if ("ctnet".equals(r100) == false) goto L19;
    L22:
        return "2";
    L19:
        if ("ctwap".equals(r100) == true) goto L22;
        return "0";
    }

    public static String f() {
        return f462009u;
    }

    public static void f(String r100) {
        f462012x = r100;
    }

    public static int g() {
        return f462010v;
    }

    public static void g(String r100) {
        f462013y = r100;
    }

    public static int h() {
        return f462011w;
    }

    public static void h(String r100) {
        f462014z = r100;
    }

    public static d i(String r100) {
        int r101 = 0;
    L4:
        if (r101 >= f462003o.size()) goto L9;
        d r102 = (d) ListProtector.get(f462003o, r101);
        if (r102.f462035a.equalsIgnoreCase(r100) == true) goto L7;
        r101 = r101 + 1;
        goto L4
    L7:
        return r102;
    L9:
        return null;
    }
}
