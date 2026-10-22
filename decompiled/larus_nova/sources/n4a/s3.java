package n4a;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.wifi.ScanResult;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.os.Handler;
import android.os.SystemClock;
import android.text.TextUtils;
import com.bytedance.helios.statichook.config.ApiHookConfig;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.bytedance.sdk.account.platform.onekey.bpea.BpeaManager;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.TreeMap;

/* JADX INFO: loaded from: classes32.dex */
public final class s3 {
    public static long A;
    public static HashMap<String, Long> B;
    public static long C;
    public static int D;
    public static long E;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public static long f517704w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public static long f517705x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public static long f517706y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public static long f517707z;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final WifiManager f517708a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public ArrayList<v2> f517709b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final ArrayList<v2> f517710c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Context f517711d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f517712e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public StringBuilder f517713f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public boolean f517714g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public boolean f517715h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public boolean f517716i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public volatile r3 f517717j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public String f517718k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public TreeMap<Integer, v2> f517719l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public boolean f517720m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public boolean f517721n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public boolean f517722o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final q3 f517723p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public String f517724q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public long f517725r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public ConnectivityManager f517726s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public long f517727t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public d3 f517728u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public volatile boolean f517729v;

    static {
        B = new HashMap(36);
        C = 0;
        D = 0;
        E = 0;
    }

    public final boolean b(ConnectivityManager r100) {
    L8:
        th = move-exception;
        c4.g(th, "WifiManagerWrapper", "wifiAccess");
        return false;
    L4:
        if (j4.d(r100.getActiveNetworkInfo()) != 1) goto L13;
        if (c(j()) == false) goto L14;
        return true;
    L14:
        return false;
    L13:
        return false;
    }

    public final WifiInfo e() {
    L11:
        th = move-exception;
        c4.g(th, "WifiManagerWrapper", BpeaManager.getConnectionInfo);
        return null;
    L4:
        if (this.f517708a != null) goto L6;
        return null;
    L6:
        if (j4.A(this.f517711d, "EYW5kcm9pZC5wZXJtaXNzaW9uLkFDQ0VTU19XSUZJX1NUQVRF") == true) goto L8;
        c4.g(new Exception("gci_n_aws"), "OPENSDK_WMW", "gci_n_aws");     // Catch: Throwable -> L11
        return null;
    L8:
        return f(this.f517708a);
    }

    public final ArrayList<v2> i() {
        if (this.f517709b != null) goto L6;
        return null;
    L6:
        ArrayList<v2> r100 = new ArrayList();
        if (this.f517709b.isEmpty() == true) goto L9;
        r100.addAll(this.f517709b);
    L9:
        return r100;
    }

    public final boolean a() {
        if (this.f517708a != null) goto L5;
        boolean r100 = false;
    L6:
        this.f517720m = r100;
        if (j4.A(this.f517711d, "EYW5kcm9pZC5wZXJtaXNzaW9uLkFDQ0VTU19XSUZJX1NUQVRF") == false) goto L11;
        this.f517721n = this.f517708a.isWifiEnabled();     // Catch: Throwable -> L28
    L11:
        if (this.f517720m == true) goto L14;
        return false;
    L14:
        if (this.f517714g == true) goto L17;
        return false;
    L17:
        if (f517706y != 0) goto L20;
    L26:
        return true;
    L20:
        if ((SystemClock.elapsedRealtime() - f517706y) >= 4900) goto L23;
        return false;
    L23:
        if ((SystemClock.elapsedRealtime() - f517707z) < 1500) goto L34;
        SystemClock.elapsedRealtime();
        goto L26
    L34:
        return false;
    L5:
        r100 = j4.G(this.f517711d);
        goto L6
    }

    public final r3 j() {
        if (j4.A(this.f517711d, "EYW5kcm9pZC5wZXJtaXNzaW9uLkFDQ0VTU19XSUZJX1NUQVRF") == false) goto L6;
        this.f517721n = this.f517708a.isWifiEnabled();     // Catch: Throwable -> L14
    L6:
        if (this.f517721n == true) goto L10;
        return null;
    L10:
        if (this.f517717j != null) goto L13;
        this.f517717j = new r3(e());
    L13:
        return this.f517717j;
    }

    public final List<v2> k() {
        if (this.f517708a != null) goto L47;
    L46:
        return null;
    L47:
    L44:
        e = move-exception;
        this.f517718k = e.getMessage();
    L42:
        th = move-exception;
        this.f517718k = null;
        c4.g(th, "WifiManagerWrapper", "getScanResults");
        goto L46
    L5:
        if (j4.A(this.f517711d, "EYW5kcm9pZC5wZXJtaXNzaW9uLkFDQ0VTU19XSUZJX1NUQVRF") == false) goto L7;
        List r100 = g(this.f517708a);     // Catch: Throwable -> L42 SecurityException -> L44
    L8:
        HashMap<String, Long> r101 = new HashMap(36);     // Catch: Throwable -> L42 SecurityException -> L44
        if (r100 == null) goto L15;
        Iterator r102 = r100.iterator();     // Catch: Throwable -> L42 SecurityException -> L44
    L12:
        if (r102.hasNext() == false) goto L15;
        ScanResult r103 = (ScanResult) r102.next();     // Catch: Throwable -> L42 SecurityException -> L44
        r101.put(r103.BSSID, Long.valueOf(r103.timestamp));     // Catch: Throwable -> L42 SecurityException -> L44
    L15:
        if (B.isEmpty() == false) goto L17;
    L18:
        B = r101;     // Catch: Throwable -> L42 SecurityException -> L44
        C = SystemClock.elapsedRealtime();     // Catch: Throwable -> L42 SecurityException -> L44
    L19:
        this.f517718k = null;     // Catch: Throwable -> L42 SecurityException -> L44
        ArrayList r104 = new ArrayList();     // Catch: Throwable -> L42 SecurityException -> L44
        this.f517724q = "";     // Catch: Throwable -> L42 SecurityException -> L44
        this.f517717j = j();     // Catch: Throwable -> L42 SecurityException -> L44
        if (c(this.f517717j) == false) goto L25;
        r3 r105 = this.f517717j;     // Catch: Throwable -> L42 SecurityException -> L44
        if (r105.f517651c != null) goto L24;
        r105.f517651c = p3.a(r105.f517649a);     // Catch: Throwable -> L42 SecurityException -> L44
    L24:
        this.f517724q = r105.f517651c;     // Catch: Throwable -> L42 SecurityException -> L44
    L25:
        if (r100 != null) goto L27;
    L40:
        this.f517723p.b(r104);     // Catch: Throwable -> L42 SecurityException -> L44
        return r104;
    L27:
        if (r100.size() <= 0) goto L40;
        int r106 = r100.size();     // Catch: Throwable -> L42 SecurityException -> L44
        int r107 = 0;
    L29:
        if (r107 >= r106) goto L40;
        ScanResult r108 = (ScanResult) ListProtector.get(r100, r107);     // Catch: Throwable -> L42 SecurityException -> L44
        String r109 = r108.BSSID;     // Catch: Throwable -> L42 SecurityException -> L44
        if (TextUtils.isEmpty(this.f517724q) == false) goto L33;
    L35:
        boolean r110 = false;
    L36:
        v2 r111 = new v2(r110);     // Catch: Throwable -> L42 SecurityException -> L44
        r111.f517820b = r108.SSID;     // Catch: Throwable -> L42 SecurityException -> L44
        r111.f517822d = r108.frequency;     // Catch: Throwable -> L42 SecurityException -> L44
        r111.f517823e = r108.timestamp;     // Catch: Throwable -> L42 SecurityException -> L44
        r111.f517819a = v2.a(r108.BSSID);     // Catch: Throwable -> L42 SecurityException -> L44
        r111.f517821c = (short) r108.level;     // Catch: Throwable -> L42 SecurityException -> L44
        short r112 = (short) ((SystemClock.elapsedRealtime() - (r108.timestamp / 1000)) / 1000);     // Catch: Throwable -> L42 SecurityException -> L44
        r111.f517825g = r112;     // Catch: Throwable -> L42 SecurityException -> L44
        if (r112 >= 0) goto L39;
        r111.f517825g = 0;     // Catch: Throwable -> L42 SecurityException -> L44
    L39:
        r111.f517824f = SystemClock.elapsedRealtime();     // Catch: Throwable -> L42 SecurityException -> L44
        r104.add(r111);     // Catch: Throwable -> L42 SecurityException -> L44
        r107 = r107 + 1;     // Catch: Throwable -> L42 SecurityException -> L44
        goto L29
    L33:
        if (this.f517724q.equals(r109) == false) goto L35;
        r110 = true;
        goto L36
    L17:
        if (B.equals(r101) == true) goto L19;
    L7:
        c4.g(new Exception("gst_n_aws"), "OPENSDK_WMW", "gsr_n_aws");     // Catch: Throwable -> L42 SecurityException -> L44
        r100 = null;
        goto L8
    }

    public final boolean l() {
        long r100 = SystemClock.elapsedRealtime() - f517704w;
        if (r100 >= 4900) goto L6;
        return false;
    L6:
        if (this.f517726s != null) goto L9;
        this.f517726s = (ConnectivityManager) j4.e(this.f517711d, "connectivity");
    L9:
        if (b(this.f517726s) == false) goto L14;
        if (r100 >= 9900) goto L14;
        return false;
    L14:
        if (D <= 1) goto L28;
        long r101 = this.f517727t;
        if (r101 != 30000) goto L23;
        r101 = com.loc.h.f380088v;
        if (r101 != (-1)) goto L23;
        r101 = 30000;
    L23:
        if (Build.VERSION.SDK_INT < 28) goto L28;
        if (r100 >= r101) goto L28;
        return false;
    L28:
        if (this.f517708a == null) goto L63;
        f517704w = SystemClock.elapsedRealtime();
        int r102 = D;
        if (r102 >= 2) goto L33;
        D = r102 + 1;
    L33:
        if (j4.A(this.f517711d, "WYW5kcm9pZC5wZXJtaXNzaW9uLkNIQU5HRV9XSUZJX1NUQVRF") == false) goto L53;
        WifiManager r103 = this.f517708a;
        ArrayList r104 = new ArrayList();
        Object[] r105 = new Object[0];
        f06.b r106 = new f06.b();
        g06.a r107 = ApiHookConfig.f245611b.get(102302);
        if (r107 == null) goto L37;
        f06.a[] r108 = r107.f479473i;
    L38:
        f06.a[] r110 = r108;
        int r111 = r110.length;
        int r112 = 0;
    L40:
        if (r112 >= r111) goto L47;
        f06.a r113 = r110[r112];
        int r114 = r112;
        int r115 = r111;
        f06.a[] r116 = r110;
        f06.d r109 = r113.preInvoke(102302, "android/net/wifi/WifiManager", "startScan", r103, r105, "boolean", r106);     // Catch: Exception -> L56
        if (r109.f474982a == true) goto L49;
        r104.add(r113);     // Catch: Exception -> L56
    L49:
        if (r109.f474982a == false) goto L52;
        return ((Boolean) r109.f474983b).booleanValue();
    L52:
        return r103.startScan();
    L46:
        r112 = r114 + 1;
        r111 = r115;
        r110 = r116;
        goto L40
    L47:
        r109 = new f06.d(false, null);
        goto L49
    L37:
        r108 = ApiHookConfig.f245613d;
        goto L38
    L53:
        c4.g(new Exception("n_cws"), "OPENSDK_WMW", "wfs_n_cws");
        return false;
    L63:
        return false;
    }

    public static boolean c(r3 r100) {
        if (r100 != null) goto L6;
        return false;
    L6:
        if (r100.f517649a != null) goto L9;
        return false;
    L9:
        if (TextUtils.isEmpty(r100.a()) == false) goto L12;
        return false;
    L12:
        if (r100.f517651c != null) goto L15;
        r100.f517651c = p3.a(r100.f517649a);
    L15:
        if (j4.n(r100.f517651c) == false) goto L21;
        return true;
    L21:
        return false;
    }

    public static WifiInfo f(WifiManager r110) {
        ArrayList r100 = new ArrayList();
        Object[] r111 = new Object[0];
        f06.b r112 = new f06.b();
        g06.a r101 = ApiHookConfig.f245611b.get(102301);
        if (r101 == null) goto L5;
        f06.a[] r102 = r101.f479473i;
    L6:
        f06.a[] r113 = r102;
        int r103 = r113.length;
        int r104 = 0;
    L8:
        if (r104 >= r103) goto L15;
        f06.a r105 = r113[r104];
        int r114 = r104;
        int r115 = r103;
        f06.d r106 = r105.preInvoke(102301, "android/net/wifi/WifiManager", BpeaManager.getConnectionInfo, r110, r111, "android.net.wifi.WifiInfo", r112);     // Catch: Exception -> L22
        if (r106.f474982a == true) goto L17;
        r100.add(r105);     // Catch: Exception -> L22
    L17:
        if (r106.f474982a == false) goto L21;
        return (WifiInfo) r106.f474983b;
    L21:
        return r110.getConnectionInfo();
    L14:
        r104 = r114 + 1;
        r103 = r115;
        goto L8
    L15:
        r106 = new f06.d(false, null);
        goto L17
    L5:
        r102 = ApiHookConfig.f245613d;
        goto L6
    }

    public static List g(WifiManager r110) {
        f06.c r100 = new f06.c();
        Object[] r101 = new Object[0];
        f06.b r111 = new f06.b();
        f06.d r112 = r100.b(102300, "android/net/wifi/WifiManager", "getScanResults", r110, r101, "java.util.List", r111);
        if (r112.f474982a == false) goto L6;
        r100.a(102300, "android/net/wifi/WifiManager", "getScanResults", r110, r101, null, r111, false);
        return (List) r112.f474983b;
    L6:
        List<ScanResult> r113 = r110.getScanResults();
        r100.a(102300, "android/net/wifi/WifiManager", "getScanResults", r110, r101, r113, r111, true);
        return r113;
    }

    public final void d(boolean r100) {
        if (r100 == false) goto L27;
        if (a() == false) goto L34;
        long r101 = SystemClock.elapsedRealtime();
        if ((r101 - f517705x) < 10000) goto L10;
        this.f517709b.clear();
        A = f517707z;
    L10:
        if (a() == false) goto L18;
    L15:
        th = move-exception;
        c4.g(th, "WifiManager", "wifiScan");
        goto L18
    L12:
        if (l() == false) goto L18;
        f517706y = SystemClock.elapsedRealtime();     // Catch: Throwable -> L15
    L18:
        if ((r101 - f517705x) < 10000) goto L34;
        int r102 = 20;
    L20:
        if (r102 <= 0) goto L34;
        if (f517707z != A) goto L34;
        Thread.sleep(150);     // Catch: Throwable -> L74
    L25:
        r102 = r102 - 1;
    L34:
        List<v2> r103 = null;
        boolean r104 = false;
        if (this.f517729v == false) goto L56;
        this.f517729v = false;
        WifiManager r105 = this.f517708a;     // Catch: Throwable -> L54
        if (r105 == null) goto L56;
        int r106 = r105.getWifiState();     // Catch: Throwable -> L43
    L46:
        if (this.f517709b != null) goto L48;
        this.f517709b = new ArrayList();     // Catch: Throwable -> L54
    L48:
        if (r106 == 0) goto L52;
        if (r106 == 1) goto L52;
        if (r106 != 4) goto L56;
    L52:
        this.f517717j = null;     // Catch: Throwable -> L54
        this.f517709b.clear();     // Catch: Throwable -> L54
    L43:
        th = move-exception;
        c4.g(th, "OPENSDK_WMW", "cwsc");     // Catch: Throwable -> L54
        r106 = 4;
    L56:
        if (A == f517707z) goto L65;
        r103 = k();     // Catch: Throwable -> L59
    L61:
        A = f517707z;
        this.f517709b.clear();
        if (r103 == null) goto L65;
        this.f517709b.addAll(r103);
    L59:
        th = move-exception;
        c4.g(th, "WifiManager", "updateScanResult");
    L65:
        if ((SystemClock.elapsedRealtime() - f517707z) <= 20000) goto L67;
        this.f517709b.clear();
    L67:
        f517705x = SystemClock.elapsedRealtime();
        if (this.f517709b.isEmpty() == false) goto L72;
        f517707z = SystemClock.elapsedRealtime();
        List<v2> r107 = k();
        if (r107 == null) goto L72;
        this.f517709b.addAll(r107);
        r104 = true;
    L72:
        h(r104);
        return;
    L27:
        if (a() == false) goto L34;
    L32:
        th = move-exception;
        c4.g(th, "WifiManager", "wifiScan");
        goto L34
    L29:
        if (l() == false) goto L34;
        f517706y = SystemClock.elapsedRealtime();     // Catch: Throwable -> L32
        goto L34
    }

    public final void h(boolean r100) {
        ArrayList<v2> r101 = this.f517709b;
        if (r101 != null) goto L5;
        return;
    L5:
        if (r101.isEmpty() == false) goto L8;
        return;
    L8:
        if ((SystemClock.elapsedRealtime() - f517707z) <= 3600000) goto L11;
        this.f517717j = null;
        this.f517709b.clear();
    L11:
        if (this.f517719l != null) goto L13;
        this.f517719l = new TreeMap(Collections.reverseOrder());
    L13:
        this.f517719l.clear();
        if (this.f517722o == false) goto L17;
        if (r100 == false) goto L17;
        this.f517710c.clear();     // Catch: Throwable -> L54
    L17:
        int r102 = this.f517709b.size();
        this.f517725r = 0;
        int r103 = 0;
    L18:
        if (r103 >= r102) goto L48;
        v2 r104 = (v2) ListProtector.get(this.f517709b, r103);
        if (r104.f517826h == false) goto L23;
        this.f517725r = r104.f517824f;
    L23:
        if (j4.n(v2.b(r104.f517819a)) == false) goto L47;
        int r105 = 20;
        if (r102 <= 20) goto L36;
        r105 = WifiManager.calculateSignalLevel(r104.f517821c, 20);     // Catch: ArithmeticException -> L29
    L31:
        if (r105 <= 0) goto L33;
        boolean r106 = true;
    L34:
        if (r106 == false) goto L47;
    L33:
        r106 = false;
    L29:
        e = move-exception;
        c4.g(e, "Aps", "wifiSigFine");
    L36:
        if (this.f517722o == false) goto L40;
        if (r100 == false) goto L40;
        this.f517710c.add(r104);
    L40:
        if (TextUtils.isEmpty(r104.f517820b) == false) goto L42;
        String r107 = "unkwn";
    L45:
        r104.f517820b = r107;
    L46:
        this.f517719l.put(Integer.valueOf((r104.f517821c * 25) + r103), r104);
        goto L47
    L42:
        if ("<unknown ssid>".equals(r104.f517820b) == true) goto L46;
        r107 = String.valueOf(r103);
    L47:
        r103 = r103 + 1;
        goto L18
    L48:
        this.f517709b.clear();
        Iterator<v2> r108 = this.f517719l.values().iterator();
    L50:
        if (r108.hasNext() == false) goto L52;
        v2 r109 = r108.next();
        this.f517709b.add(r109);
        goto L50
    L52:
        this.f517719l.clear();
    }

    public s3(Context r100, WifiManager r101, Handler r102) {
        this.f517709b = new ArrayList();
        this.f517710c = new ArrayList();
        this.f517712e = false;
        this.f517713f = null;
        this.f517714g = true;
        this.f517715h = true;
        this.f517716i = true;
        this.f517717j = null;
        this.f517718k = null;
        this.f517719l = null;
        this.f517720m = true;
        this.f517721n = true;
        this.f517722o = false;
        this.f517724q = "";
        this.f517725r = 0;
        this.f517726s = null;
        this.f517727t = 30000;
        this.f517729v = false;
        this.f517708a = r101;
        this.f517711d = r100;
        q3 r103 = new q3(r100, r102);
        this.f517723p = r103;
        if (r103.f517342b == true) goto L7;
        Handler r104 = r103.f517344d;
        if (r104 == null) goto L7;
        r104.removeCallbacks(r103.f517347g);
        r103.f517344d.postDelayed(r103.f517347g, 60000);
    L7:
        r103.f517342b = true;
    }
}
