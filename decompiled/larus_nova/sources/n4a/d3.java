package n4a;

import android.content.Context;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.net.wifi.WifiInfo;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.telephony.TelephonyManager;
import com.amap.api.col.s.ce;
import com.bytedance.android.livesdkapi.depend.live.vs.VSConstants;
import com.bytedance.crypto.utils.CryptoConst;
import com.bytedance.helios.statichook.config.ApiHookConfig;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.loc.dv;
import com.miui.easygo.constant.EasyGoConstant;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Vector;
import javax.crypto.KeyGenerator;
import kotlin.UByte;

/* JADX INFO: loaded from: classes32.dex */
public final class d3 implements z2 {

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static long f517223k;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f517224a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ArrayList<v1> f517225b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Handler f517226c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public s3 f517227d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public l3 f517228e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public q2 f517229f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public LocationManager f517230g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public a f517231h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final n0 f517232i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public volatile boolean f517233j;

    public static class a implements LocationListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public d3 f517234a;

        public a(d3 r100) {
            this.f517234a = r100;
        }

        @Override // android.location.LocationListener
        public final void onProviderDisabled(String r100) {
        }

        @Override // android.location.LocationListener
        public final void onProviderEnabled(String r100) {
        }

        @Override // android.location.LocationListener
        public final void onStatusChanged(String r100, int r101, Bundle r102) {
        }

        @Override // android.location.LocationListener
        public final void onLocationChanged(Location r210) {
            ArrayList r100 = new ArrayList();
            Object[] r101 = {r210};
            f06.b r110 = new f06.b();
            g06.a r102 = ApiHookConfig.f245611b.get(100038);
            if (r102 == null) goto L5;
            f06.a[] r103 = r102.f479473i;
        L6:
            f06.a[] r111 = r103;
            int r104 = r111.length;
            int r105 = 0;
        L8:
            if (r105 >= r104) goto L15;
            f06.a r106 = r111[r105];
            int r112 = r105;
            int r113 = r104;
            f06.a[] r114 = r111;
            f06.d r107 = r106.preInvoke(100038, "com/loc/eo$a", "onLocationChanged", this, r101, "void", r110);     // Catch: Exception -> L30
            if (r107.f474982a == true) goto L17;
            r100.add(r106);     // Catch: Exception -> L30
        L17:
            if (r107.f474982a == false) goto L32;
            return;
        L32:
            d3 r108 = this.f517234a;     // Catch: Throwable -> L29
            if (r108 != null) goto L34;
        L31:
            return;
        L34:
            Handler r109 = r108.f517226c;     // Catch: Throwable -> L26
            if (r109 == null) goto L31;
            r109.post(new b(r108, r210));     // Catch: Throwable -> L26
        L26:
            th = move-exception;
            r.f(th, "cl", "olcc");     // Catch: Throwable -> L29
        L41:
            return;
        L14:
            r105 = r112 + 1;
            r104 = r113;
            r111 = r114;
            goto L8
        L15:
            r107 = new f06.d(false, null);
            goto L17
        L5:
            r103 = ApiHookConfig.f245613d;
            goto L6
        }
    }

    public class b extends l1 {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f517235b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final Location f517236c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ d3 f517237d;

        public b(d3 r100, int r101) {
            this.f517237d = r100;
            this.f517235b = 0;
            this.f517235b = r101;
        }

        public b(d3 r100, Location r101) {
            this(r100, 1);
            this.f517236c = r101;
        }

        @Override // n4a.l1
        public final void a() {
            int r100 = this.f517235b;
            if (r100 != 1) goto L67;
        L63:
            th = move-exception;
            c4.g(th, "cl", "coll");
            return;
        L5:
            if (this.f517236c != null) goto L8;
            return;
        L8:
            if (this.f517237d.f517233j == true) goto L11;
            return;
        L11:
            if (j4.J(this.f517237d.f517224a) == true) goto L146;
            Bundle r101 = this.f517236c.getExtras();     // Catch: Throwable -> L63
            if (r101 == null) goto L16;
            int r102 = r101.getInt("satellites");     // Catch: Throwable -> L63
        L18:
            if (j4.k(this.f517236c, r102) == true) goto L147;
            s3 r103 = this.f517237d.f517227d;     // Catch: Throwable -> L63
            if (r103 != null) goto L23;
        L28:
            s3 r104 = this.f517237d.f517227d;     // Catch: Throwable -> L63
            if (r104.f517722o == true) goto L31;
        L30:
            ArrayList<v2> r105 = r104.f517710c;     // Catch: Throwable -> L63
            List<dv> r106 = this.f517237d.f517228e.a();     // Catch: Throwable -> L63
            s1.a r107 = new s1.a();     // Catch: Throwable -> L63
            u2 r108 = new u2();     // Catch: Throwable -> L63
            r108.f517753g = this.f517236c.getAccuracy();     // Catch: Throwable -> L63
            r108.f517750d = this.f517236c.getAltitude();     // Catch: Throwable -> L63
            r108.f517748b = this.f517236c.getLatitude();     // Catch: Throwable -> L63
            r108.f517752f = this.f517236c.getBearing();     // Catch: Throwable -> L63
            r108.f517749c = this.f517236c.getLongitude();     // Catch: Throwable -> L63
            this.f517236c.isFromMockProvider();     // Catch: Throwable -> L63
            this.f517236c.getProvider();     // Catch: Throwable -> L63
            r108.f517751e = this.f517236c.getSpeed();     // Catch: Throwable -> L63
            r108.f517772i = (byte) r102;     // Catch: Throwable -> L63
            System.currentTimeMillis();     // Catch: Throwable -> L63
            r108.f517747a = this.f517236c.getTime();     // Catch: Throwable -> L63
            r108.f517771h = this.f517236c.getTime();     // Catch: Throwable -> L63
            r107.f517669a = r108;     // Catch: Throwable -> L63
            r107.f517670b = r105;     // Catch: Throwable -> L63
            WifiInfo r109 = this.f517237d.f517227d.e();     // Catch: Throwable -> L63
            if (r109 == null) goto L35;
            r107.f517671c = v2.a(p3.a(r109));     // Catch: Throwable -> L63
        L35:
            r107.f517672d = s3.E;     // Catch: Throwable -> L63
            r107.f517674f = this.f517236c.getTime();     // Catch: Throwable -> L63
            int r110 = x4.d(this.f517237d.f517224a);     // Catch: Throwable -> L38
        L40:
            r107.f517675g = (byte) r110;     // Catch: Throwable -> L63
            Context r111 = this.f517237d.f517224a;     // Catch: Throwable -> L63
            String r112 = "";
            if (x4.m(r111, f5.o("WYW5kcm9pZC5wZXJtaXNzaW9uLlJFQURfUEhPTkVfU1RBVEU=")) == false) goto L48;
            TelephonyManager r113 = (TelephonyManager) r111.getSystemService("phone");     // Catch: Throwable -> L114
            if (r113 == null) goto L48;
            r112 = r113.getNetworkOperatorName();     // Catch: Throwable -> L114
        L48:
            r107.f517676h = r112;     // Catch: Throwable -> L63
            d3 r114 = this.f517237d;     // Catch: Throwable -> L63
            r107.f517673e = r114.f517227d.f517720m;     // Catch: Throwable -> L63
            r107.f517678j = j4.i(r114.f517224a);     // Catch: Throwable -> L63
            r107.f517677i = r106;     // Catch: Throwable -> L63
            v1 r115 = q2.a(r107);     // Catch: Throwable -> L63
            if (r115 == null) goto L148;
            ArrayList<v1> r116 = this.f517237d.f517225b;     // Catch: Throwable -> L63
            monitor-enter(r116);     // Catch: Throwable -> L63
            this.f517237d.f517225b.add(r115);     // Catch: Throwable -> L60
            if (this.f517237d.f517225b.size() < 5) goto L57;
            d3 r117 = this.f517237d;     // Catch: Throwable -> L60
            r117.getClass();     // Catch: Throwable -> L60
            k1.f517430d.b(new b(r117, 3));     // Catch: Throwable -> L115
        L57:
            monitor-exit(r116);     // Catch: Throwable -> L60
            this.f517237d.d();     // Catch: Throwable -> L63
            return;
        L60:
            th = move-exception;
            throw th;     // Catch: Throwable -> L63
        L148:
            return;
        L38:
            r110 = -1;
            goto L40
        L31:
            r104.d(true);     // Catch: Throwable -> L63
            goto L30
        L23:
            if (r103.f517722o == true) goto L28;
            r103.f517722o = true;     // Catch: Throwable -> L113
            List<v2> r118 = r103.k();     // Catch: Throwable -> L113
            if (r118 == null) goto L27;
            r103.f517709b.clear();     // Catch: Throwable -> L113
            r103.f517709b.addAll(r118);     // Catch: Throwable -> L113
        L27:
            r103.h(true);     // Catch: Throwable -> L113
            goto L28
        L147:
            return;
        L16:
            r102 = 0;
            goto L18
        L146:
            return;
        L67:
            if (r100 == 2) goto L69;
            if (r100 != 3) goto L154;
            this.f517237d.e();
            return;
        L154:
            return;
        L69:
            if (j4.J(this.f517237d.f517224a) == true) goto L152;
            h0 r119 = null;
            byte[] r120 = null;
            r120 = null;
            d3.f517223k = System.currentTimeMillis();     // Catch: Throwable -> L100
            if (this.f517237d.f517232i.f517550f.e() == false) goto L98;
            h0 r121 = h0.b(new PolarisFileWrapper(this.f517237d.f517232i.f517545a), this.f517237d.f517232i.f517546b);     // Catch: Throwable -> L100
            ArrayList r122 = new ArrayList();     // Catch: Throwable -> L96
            KeyGenerator r123 = KeyGenerator.getInstance(CryptoConst.ALGORITHM_AES);     // Catch: Throwable -> L116
            if (r123 == null) goto L80;
            r123.init(128);     // Catch: Throwable -> L116
            r120 = r123.generateKey().getEncoded();     // Catch: Throwable -> L116
        L80:
            if (r120 == null) goto L133;
            List r124 = d3.a(r121, this.f517237d.f517232i, r122, r120);     // Catch: Throwable -> L96
            if (((ArrayList) r124).size() == 0) goto L133;
            this.f517237d.f517232i.f517550f.a();     // Catch: Throwable -> L96
            if (q2.b(f5.n(q2.d(t3.b(r120), y4.f(r120, q2.c(), f5.p()), r124))) == true) goto L128;
        L95:
            r119 = r121;
            goto L98
        L128:
            Iterator r125 = r122.iterator();     // Catch: Throwable -> L93
        L89:
            if (r125.hasNext() == false) goto L91;
            r121.h((String) r125.next());     // Catch: Throwable -> L93
            goto L89
        L91:
            r121.close();     // Catch: Throwable -> L93
        L93:
            th = move-exception;
            r.f(th, "aps", "dlo");     // Catch: Throwable -> L96
        L133:
            r121.close();     // Catch: Throwable -> L118
            return;
        L153:
            return;
        L96:
            Throwable th10 = th;
        L137:
            r.f(th10, "leg", "uts");     // Catch: Throwable -> L106
            if (r121 != null) goto L133;
            return;
        L106:
            th = move-exception;
            if (r121 != null) goto L119;
        L109:
            throw th;
        L119:
            r121.close();     // Catch: Throwable -> L117
        L98:
            if (r119 == null) goto L150;
            r121 = r119;
            goto L133
        L150:
            return;
        L100:
            th = move-exception;
            r121 = null;
            th10 = th;
            goto L137
        }
    }

    public d3(Context r100) {
        this.f517224a = null;
        this.f517225b = new ArrayList();
        this.f517227d = null;
        this.f517228e = null;
        this.f517233j = false;
        this.f517224a = r100;
        n0 r101 = new n0();
        this.f517232i = r101;
        Vector<e5> r102 = p.f517579b;
        t0.b(r100, r101, ce.f26396k, 100, 1024000, "0");
        int r103 = com.loc.h.F;
        boolean r104 = com.loc.h.D;
        int r105 = com.loc.h.E;
        r101.f517550f = new g1(r100, r103, "kKey", new e1(r100, r104, r105, r105 * 10));
        r101.f517549e = new z();
    }

    public final void d() {
        if (j4.J(this.f517224a) == false) goto L6;
        return;
    L6:
        if ((System.currentTimeMillis() - f517223k) >= 60000) goto L8;
        return;
    L8:
        k1.f517430d.b(new b(this, 2));     // Catch: Throwable -> L10
        return;
    }

    public final void e() {
    L36:
        th = move-exception;
        c4.g(th, "clm", "wtD");
        return;
    L3:
        if (j4.J(this.f517224a) == false) goto L5;
        return;
    L5:
        ArrayList<v1> r100 = this.f517225b;     // Catch: Throwable -> L36
        if (r100 != null) goto L8;
        return;
    L8:
        if (r100.size() == 0) goto L52;
        ArrayList r101 = new ArrayList();     // Catch: Throwable -> L36
        ArrayList<v1> r102 = this.f517225b;     // Catch: Throwable -> L36
        monitor-enter(r102);     // Catch: Throwable -> L36
        r101.addAll(this.f517225b);     // Catch: Throwable -> L32
        this.f517225b.clear();     // Catch: Throwable -> L32
        monitor-exit(r102);     // Catch: Throwable -> L32
        ByteArrayOutputStream r103 = new ByteArrayOutputStream();     // Catch: Throwable -> L36
        byte[] r104 = null;
        KeyGenerator r105 = KeyGenerator.getInstance(CryptoConst.ALGORITHM_AES);     // Catch: Throwable -> L39
        if (r105 == null) goto L20;
        r105.init(256);     // Catch: Throwable -> L39
        r104 = r105.generateKey().getEncoded();     // Catch: Throwable -> L39
    L20:
        if (r104 != null) goto L22;
        return;
    L22:
        int r106 = r104.length;     // Catch: Throwable -> L36
        r103.write(new byte[]{(byte) ((r106 & 65280) >> 8), (byte) (r106 & 255)});     // Catch: Throwable -> L36
        r103.write(r104);     // Catch: Throwable -> L36
        Iterator r107 = r101.iterator();     // Catch: Throwable -> L36
    L24:
        if (r107.hasNext() == false) goto L30;
        v1 r108 = (v1) r107.next();     // Catch: Throwable -> L36
        byte[] r109 = r108.f517818b;     // Catch: Throwable -> L36
        if (r109.length < 10) goto L24;
        if (r109.length > 65535) goto L24;
        byte[] r110 = y4.f(r104, r109, f5.p());     // Catch: Throwable -> L36
        int r111 = r110.length;     // Catch: Throwable -> L36
        r103.write(new byte[]{(byte) ((r111 & 65280) >> 8), (byte) (r111 & 255)});     // Catch: Throwable -> L36
        r103.write(r110);     // Catch: Throwable -> L36
        int r112 = r108.f517817a;     // Catch: Throwable -> L36
        r103.write(new byte[]{(byte) ((r112 >> 24) & 255), (byte) ((r112 >> 16) & 255), (byte) ((r112 >> 8) & 255), (byte) (r112 & 255)});     // Catch: Throwable -> L36
        goto L24
    L30:
        o0.a(Long.toString(System.currentTimeMillis()), r103.toByteArray(), this.f517232i);     // Catch: Throwable -> L36
        return;
    L32:
        th = move-exception;
        throw th;     // Catch: Throwable -> L36
    }

    public static void c(LocationManager r110, a r210) {
        ArrayList r100 = new ArrayList();
        Object[] r101 = {VSConstants.EXTRA_SHOW_MSG_BOARD_FROM_PASSIVE_ACTION, 1000L, Float.valueOf(-1.0f), r210};
        f06.b r111 = new f06.b();
        g06.a r102 = ApiHookConfig.f245611b.get(100001);
        if (r102 == null) goto L5;
        f06.a[] r103 = r102.f479473i;
    L6:
        f06.a[] r112 = r103;
        int r104 = r112.length;
        int r105 = 0;
    L8:
        if (r105 >= r104) goto L15;
        f06.a r106 = r112[r105];
        int r113 = r105;
        int r114 = r104;
        f06.a[] r115 = r112;
        f06.d r107 = r106.preInvoke(100001, "android/location/LocationManager", "requestLocationUpdates", r110, r101, "void", r111);     // Catch: Exception -> L21
        if (r107.f474982a == true) goto L17;
        r100.add(r106);     // Catch: Exception -> L21
    L17:
        if (r107.f474982a == false) goto L19;
        return;
    L19:
        r110.requestLocationUpdates(VSConstants.EXTRA_SHOW_MSG_BOARD_FROM_PASSIVE_ACTION, 1000, -1.0f, r210);
        return;
    L14:
        r105 = r113 + 1;
        r104 = r114;
        r112 = r115;
        goto L8
    L15:
        r107 = new f06.d(false, null);
        goto L17
    L5:
        r103 = ApiHookConfig.f245613d;
        goto L6
    }

    public final void b(l3 r100, s3 r101, Handler r102) {
        if (this.f517233j == false) goto L5;
        return;
    L5:
        if (r100 == null) goto L49;
        if (r101 == null) goto L50;
        if (r102 != null) goto L10;
        return;
    L10:
        if (j4.J(this.f517224a) == false) goto L12;
        return;
    L12:
        this.f517233j = true;
        this.f517228e = r100;
        this.f517227d = r101;
        r101.f517728u = this;
        r100.f517482w = this;
        this.f517226c = r102;
    L43:
        th = move-exception;
        c4.g(th, "col", "init");
        return;
    L14:
        if (this.f517230g != null) goto L17;
        this.f517230g = (LocationManager) this.f517224a.getSystemService("location");     // Catch: Throwable -> L43
    L17:
        if (this.f517231h != null) goto L19;
        this.f517231h = new a(this);     // Catch: Throwable -> L43
    L19:
        a r103 = this.f517231h;     // Catch: Throwable -> L43
        r103.f517234a = this;     // Catch: Throwable -> L43
        LocationManager r104 = this.f517230g;     // Catch: Throwable -> L43
        if (r104 == null) goto L26;
        if (fna.g.d() == true) goto L24;
        c(r104, r103);     // Catch: Throwable -> L43
        goto L26
    L24:
        c(r104, r103);     // Catch: Throwable -> L43
        nna.a.c(r103.hashCode());     // Catch: Throwable -> L43
    L26:
        if (this.f517229f != null) goto L48;
        this.f517229f = new q2(v4.g(this.f517224a), v4.d(this.f517224a), this);     // Catch: Throwable -> L43
        w2.f517850f = "";     // Catch: Throwable -> L43
        String r105 = x4.q(this.f517224a);     // Catch: Throwable -> L43
        if (r105 == null) goto L30;
        w2.f517851g = r105;     // Catch: Throwable -> L43
    L31:
        String r106 = x4.j(this.f517224a);     // Catch: Throwable -> L43
        if (r106 == null) goto L34;
        w2.f517852h = r106;     // Catch: Throwable -> L43
    L35:
        x4.p(this.f517224a);     // Catch: Throwable -> L43
        byte r107 = w2.f517845a;     // Catch: Throwable -> L43
        w2.f517853i = "";     // Catch: Throwable -> L43
        String r108 = Build.MODEL;     // Catch: Throwable -> L43
        if (r108 == null) goto L38;
        w2.f517854j = r108;     // Catch: Throwable -> L43
    L38:
        String r109 = Build.MANUFACTURER;     // Catch: Throwable -> L43
        if (r109 == null) goto L41;
        w2.f517855k = r109;     // Catch: Throwable -> L43
    L41:
        String r110 = Build.BRAND;     // Catch: Throwable -> L43
        w2.f517856l = Build.VERSION.SDK_INT;     // Catch: Throwable -> L43
        String r111 = Build.VERSION.RELEASE;     // Catch: Throwable -> L43
        v2.a("");     // Catch: Throwable -> L43
        w2.f517857m = "";     // Catch: Throwable -> L43
        return;
    L34:
        byte r112 = w2.f517845a;     // Catch: Throwable -> L43
        goto L35
    L30:
        byte r113 = w2.f517845a;     // Catch: Throwable -> L43
        goto L31
    L48:
        return;
    L50:
        return;
    }

    public static List a(h0 r110, n0 r111, List r112, byte[] r210) {
        h0 r100 = r110;
        ArrayList r101 = new ArrayList();
        File r102 = r100.f517312a;     // Catch: Throwable -> L75
        if (r102 != null) goto L6;
    L77:
        return r101;
    L6:
        if (r102.exists() == false) goto L77;
        String[] r103 = r102.list();     // Catch: Throwable -> L75
        if (r103 == null) goto L77;
        int r104 = r103.length;     // Catch: Throwable -> L75
        char r105 = 0;
        int r106 = 0;
        int r107 = 0;
    L11:
        if (r106 >= r104) goto L77;
        String r108 = r103[r106];     // Catch: Throwable -> L75
        if (r108.contains(".0") == false) goto L74;
        InputStream r109 = null;
        String r113 = r108.split(EasyGoConstant.VERSION_SEPARATIVE_SIGN)[r105];     // Catch: Throwable -> L65
        h0.e r114 = r100.a(r113);     // Catch: Throwable -> L65
        if (r114 != null) goto L106;
        if (r114 == null) goto L74;
    L98:
        r114.close();     // Catch: Throwable -> L84
        goto L74
    L106:
        r109 = r114.f517333a[r105];     // Catch: Throwable -> L64
        if (r109 != null) goto L25;
        if (r109 == null) goto L98;
        r109.close();     // Catch: Throwable -> L78
        goto L98
    L25:
        int r115 = 2;
        byte[] r116 = new byte[2];     // Catch: Throwable -> L64
        r109.read(r116);     // Catch: Throwable -> L64
        int r117 = 0;
        int r118 = 0;
    L28:
        if (r117 >= 2) goto L32;
        r118 = r118 | ((r116[r117] & 255) << ((1 - r117) * 8));
        r117 = r117 + 1;
        goto L28
    L32:
        if (r118 != 0) goto L34;
    L102:
        r109.close();     // Catch: Throwable -> L83
    L114:
        r114.close();     // Catch: Throwable -> L85
        goto L77
    L34:
        if (r118 > 65535) goto L102;
        byte[] r119 = new byte[r118];     // Catch: Throwable -> L64
        r109.read(r119);     // Catch: Throwable -> L64
        byte[] r120 = new byte[2];     // Catch: Throwable -> L64
        int r121 = 0;
    L37:
        if (r109.read(r120) < 0) goto L51;
        int r122 = 0;
        int r123 = 0;
    L40:
        if (r122 < r115) goto L112;
        byte[] r124 = new byte[r123];     // Catch: Throwable -> L48
        r109.read(r124);     // Catch: Throwable -> L48
        byte[] r125 = y4.c(r119, r124, f5.p());     // Catch: Throwable -> L48
        r121 = r121 + r125.length;     // Catch: Throwable -> L48
        byte[] r126 = new byte[4];     // Catch: Throwable -> L48
        r109.read(r126);     // Catch: Throwable -> L48
        r101.add(new v1(((((r126[r115] & UByte.MAX_VALUE) << 8) | (r126[3] & UByte.MAX_VALUE)) | ((r126[1] & UByte.MAX_VALUE) << 16)) | ((r126[0] & UByte.MAX_VALUE) << 24), y4.f(r210, f5.n(r125), f5.p())));     // Catch: Throwable -> L79
        r115 = 2;
        goto L37
    L112:
        r123 = r123 | ((r120[r122] & 255) << ((1 - r122) * 8));
        r122 = r122 + 1;
        goto L40
    L51:
        r107 = r107 + r121;
        ((ArrayList) r112).add(r113);     // Catch: Throwable -> L59
        if (r107 > r111.f517550f.d()) goto L102;
        r109.close();     // Catch: Throwable -> L80
    L104:
        r114.close();     // Catch: Throwable -> L81
    L66:
        if (r109 != null) goto L116;
    L70:
        if (r114 == null) goto L74;
    L116:
        r109.close();     // Catch: Throwable -> L69
    L65:
        r114 = null;
    L74:
        r106 = r106 + 1;
        r100 = r110;
        r105 = 0;
    L75:
        th = move-exception;
        r.f(th, "aps", com.baidu.bbalbscesium.j.b.f30211c);
        goto L77
    }
}
