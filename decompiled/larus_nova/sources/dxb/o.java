package dxb;

import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkInfo;
import android.net.Uri;
import android.text.TextUtils;
import android.util.Pair;
import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.lark.officewebview.util.NetWorkUtils;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.Inet4Address;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.Iterator;
import org.json.JSONArray;

/* JADX INFO: loaded from: classes37.dex */
public final class o implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ cxb.a f470495a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ int f470496b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ String f470497c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ boolean f470498d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final /* synthetic */ Boolean f470499e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final /* synthetic */ Uri f470500f;

    public o(cxb.a r100, int r101, String r102, boolean r103, Boolean r104, Uri r105) {
        this.f470495a = r100;
        this.f470496b = r101;
        this.f470497c = r102;
        this.f470498d = r103;
        this.f470499e = r104;
        this.f470500f = r105;
    }

    public final void a() {
        g r100 = new g("wb_load_received_error", c.f470460e, this.f470495a);
        r100.a("error_code", Integer.valueOf(this.f470496b));
        r100.a("error_msg", this.f470497c);
        r100.a("error_type", "normal");
        r100.a("is_first_page", Boolean.valueOf(this.f470498d));
        r100.a("is_main_frame", this.f470499e);
        Uri r101 = this.f470500f;
        int r102 = this.f470496b;
        t.b(r100, r101);
        if (r102 == (-10)) goto L12;
        if (r102 == (-8)) goto L12;
        if (r102 == (-6)) goto L12;
        if (r102 == (-2)) goto L12;
    L125:
        r100.b();
        return;
    L12:
        if (NetWorkUtils.a() == true) goto L14;
        Object r103 = "";
    L35:
        r100.a("device_ip", r103);
        r100.a("network_type", NetWorkUtils.c());
        int r104 = 0;
        if (NetWorkUtils.a() == true) goto L141;
    L44:
        boolean r105 = false;
    L45:
        r100.a("vpn_is_open", Boolean.valueOf(r105));
        if (NetWorkUtils.a() == true) goto L48;
        ArrayList r106 = new ArrayList();
    L64:
        r100.a("local_dns_server", r106);
        if (r101 == null) goto L125;
        String r107 = r101.getHost();
        boolean r108 = TextUtils.isEmpty(r107);
        float r109 = 0.0f;
        Float r110 = Float.valueOf(0.0f);
        if (r108 == false) goto L70;
        Pair r111 = new Pair("", r110);
    L112:
        r100.a("host_ping_result", r111.first);
        r100.a("host_ping_duration", r111.second);
        goto L125
    L70:
        if (NetWorkUtils.a() == true) goto L72;
        r111 = new Pair("", r110);
        goto L112
    L72:
        OutputStream r112 = null;
        InputStream r113 = null;
        r113 = null;
        r112 = null;
        Process r114 = NetWorkUtils.b(Runtime.getRuntime(), "ping -c 3 " + r107);     // Catch: Throwable -> L96 Exception -> L98
        OutputStream r115 = r114.getOutputStream();     // Catch: Throwable -> L96 Exception -> L98
        r115.close();     // Catch: Throwable -> L92 Exception -> L94
        long r116 = System.nanoTime();     // Catch: Throwable -> L92 Exception -> L94
        r113 = r114.getInputStream();     // Catch: Throwable -> L92 Exception -> L94
        BufferedReader r117 = new BufferedReader(new InputStreamReader(r113, "UTF8"));     // Catch: Throwable -> L92 Exception -> L94
        JSONArray r118 = new JSONArray();     // Catch: Throwable -> L92 Exception -> L94
    L75:
        String r119 = r117.readLine();     // Catch: Throwable -> L92 Exception -> L94
        if (r119 == null) goto L82;
        r118.put(r119);     // Catch: Throwable -> L92 Exception -> L94
        if (r119.contains("From") == true) goto L81;
        if (r119.contains("from") == false) goto L75;
    L81:
        r109 = (System.nanoTime() - r116) / 1000000.0f;     // Catch: Throwable -> L92 Exception -> L94
        goto L75
    L82:
        r114.destroy();     // Catch: Throwable -> L92 Exception -> L94
        r111 = new Pair(r118.toString(), Float.valueOf(r109));     // Catch: Throwable -> L92 Exception -> L94
        r115.close();     // Catch: IOException -> L85
    L87:
        if (r113 == null) goto L112;
        r113.close();     // Catch: IOException -> L90
    L90:
        e = move-exception;
        com.ss.android.lark.officesdk.utils.di.j.d("NetWorkUtils", e);
    L85:
        e = move-exception;
        com.ss.android.lark.officesdk.utils.di.j.d("NetWorkUtils", e);
        goto L87
    L94:
        e = e;
        InputStream r120 = r113;
        r112 = r115;
        InputStream r121 = r120;
    L139:
        com.ss.android.lark.officesdk.utils.di.j.d("NetWorkUtils", e);     // Catch: Throwable -> L113
        if (r112 != null) goto L137;
    L106:
        if (r121 != null) goto L129;
    L111:
        r111 = new Pair("", r110);
        goto L112
    L129:
        r121.close();     // Catch: IOException -> L109
    L109:
        e = move-exception;
        com.ss.android.lark.officesdk.utils.di.j.d("NetWorkUtils", e);
        goto L111
    L137:
        r112.close();     // Catch: IOException -> L104
    L104:
        e = move-exception;
        com.ss.android.lark.officesdk.utils.di.j.d("NetWorkUtils", e);
    L113:
        th = th;
    L114:
        if (r112 != null) goto L131;
    L119:
        if (r121 == null) goto L177;
        r121.close();     // Catch: IOException -> L122
        throw th;
    L122:
        e = move-exception;
        com.ss.android.lark.officesdk.utils.di.j.d("NetWorkUtils", e);
        throw th;
    L177:
        throw th;
    L131:
        r112.close();     // Catch: IOException -> L117
    L117:
        e = move-exception;
        com.ss.android.lark.officesdk.utils.di.j.d("NetWorkUtils", e);
    L92:
        th = th;
        InputStream r122 = r113;
        r112 = r115;
        r121 = r122;
        goto L114
    L98:
        e = e;
        r121 = null;
    L96:
        th = th;
        r121 = null;
        goto L114
    L48:
        r106 = new ArrayList();
        int r123 = com.ss.android.lark.officesdk.utils.di.d.f437220a;     // Catch: Exception -> L62
        ConnectivityManager r124 = (ConnectivityManager) com.ss.android.lark.officesdk.utils.di.d.a.a().getSystemService("connectivity");     // Catch: Exception -> L62
        NetworkInfo r125 = r124.getActiveNetworkInfo();     // Catch: Exception -> L62
        Network[] r126 = r124.getAllNetworks();     // Catch: Exception -> L62
        int r127 = r126.length;     // Catch: Exception -> L62
    L50:
        if (r104 >= r127) goto L64;
        Network r128 = r126[r104];     // Catch: Exception -> L62
        NetworkInfo r129 = r124.getNetworkInfo(r128);     // Catch: Exception -> L62
        if (r129 == null) goto L61;
        if (r125 == null) goto L61;
        if (r129.getType() != r125.getType()) goto L61;
        Iterator<InetAddress> r130 = r124.getLinkProperties(r128).getDnsServers().iterator();     // Catch: Exception -> L62
    L58:
        if (r130.hasNext() == false) goto L61;
        r106.add(r130.next().getHostAddress());     // Catch: Exception -> L62
    L61:
        r104 = r104 + 1;
    L62:
        e = move-exception;
        com.ss.android.lark.officesdk.utils.di.j.d("NetWorkUtils", e);
        goto L64
    L141:
        int r131 = com.ss.android.lark.officesdk.utils.di.d.f437220a;     // Catch: Exception -> L42
        NetworkInfo r132 = ((ConnectivityManager) com.ss.android.lark.officesdk.utils.di.d.a.a().getSystemService("connectivity")).getNetworkInfo(17);     // Catch: Exception -> L42
        if (r132 == null) goto L44;
        r105 = r132.isConnected();     // Catch: Exception -> L42
    L42:
        e = move-exception;
        com.ss.android.lark.officesdk.utils.di.j.d("NetWorkUtils", e);
        goto L44
    L14:
        r103 = "none";
        Enumeration<NetworkInterface> r133 = NetworkInterface.getNetworkInterfaces();     // Catch: SocketException -> L33
    L16:
        if (r133.hasMoreElements() == false) goto L35;
        NetworkInterface r134 = r133.nextElement();     // Catch: SocketException -> L33
        String r135 = r134.getName();     // Catch: SocketException -> L33
        if (r135 == null) goto L16;
        if (TextUtils.equals(r135.toLowerCase(), "eth0") == true) goto L24;
        if (TextUtils.equals(r135.toLowerCase(), "wlan0") == false) goto L16;
    L24:
        Enumeration<InetAddress> r136 = r134.getInetAddresses();     // Catch: SocketException -> L33
    L26:
        if (r136.hasMoreElements() == false) goto L16;
        InetAddress r137 = r136.nextElement();     // Catch: SocketException -> L33
        if ((r137 instanceof Inet4Address) == false) goto L26;
        if (r137.isLoopbackAddress() == true) goto L26;
        r103 = r137.getHostAddress();     // Catch: SocketException -> L33
    L33:
        e = move-exception;
        com.ss.android.lark.officesdk.utils.di.j.d("NetWorkUtils", e);
        goto L35
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
}
