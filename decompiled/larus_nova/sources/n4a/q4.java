package n4a;

import android.content.Context;
import android.content.SharedPreferences;
import android.location.GpsStatus;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import android.text.TextUtils;
import androidx.camera.video.AudioStats;
import com.amap.api.location.AMapLocation;
import com.amap.api.location.AMapLocationClientOption;
import com.amap.api.location.DPoint;
import com.amap.api.services.geocoder.GeocodeSearch;
import com.bytedance.android.livesdk.ktvimpl.ktvroom.challenge.vm.KtvSingChallengeViewModel;
import com.bytedance.bdlocation.monitor.LocationMonitorConst;
import com.bytedance.helios.statichook.config.ApiHookConfig;
import com.bytedance.map.api.data.MapInfoConst;
import com.bytedance.mira.conig.Constants;
import com.bytedance.mt.protector.impl.string2number.CastFloatProtector;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes32.dex */
public final class q4 {
    public static AMapLocation D;
    public static long E;
    public static final Object F = null;
    public static long G;
    public static boolean H;
    public static boolean I;

    /* JADX INFO: renamed from: J, reason: collision with root package name */
    public static volatile AMapLocation f517601J;
    public boolean A;
    public int B;
    public boolean C;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Handler f517602a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Context f517603b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final LocationManager f517604c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public AMapLocationClientOption f517605d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public long f517606e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public long f517607f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public boolean f517608g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f517609h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final f3 f517610i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public int f517611j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public int f517612k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public AMapLocation f517613l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public long f517614m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public float f517615n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final Object f517616o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final Object f517617p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public int f517618q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public GpsStatus f517619r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public p4 f517620s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public o4 f517621t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public AMapLocationClientOption.GeoLanguage f517622u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public boolean f517623v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public long f517624w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public int f517625x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public a f517626y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public String f517627z;

    public static class a implements LocationListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public q4 f517628a;

        public a(q4 r100) {
            this.f517628a = r100;
        }

        @Override // android.location.LocationListener
        public final void onProviderEnabled(String r100) {
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
            f06.d r107 = r106.preInvoke(100038, "com/loc/h$a", "onLocationChanged", this, r101, "void", r110);     // Catch: Exception -> L28
            if (r107.f474982a == true) goto L17;
            r100.add(r106);     // Catch: Exception -> L28
        L17:
            if (r107.f474982a == false) goto L29;
            return;
        L29:
            ThreadMethodProxy.currentThread().getId();     // Catch: Throwable -> L25
            q4 r108 = this.f517628a;     // Catch: Throwable -> L27
            if (r108 == null) goto L38;
            q4.f(r108, r210);     // Catch: Throwable -> L27
            return;
        L38:
            return;
        L39:
            return;
        L26:
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

        @Override // android.location.LocationListener
        public final void onProviderDisabled(String r100) {
            q4 r101 = this.f517628a;     // Catch: Throwable -> L8
            if (r101 == null) goto L11;
            AMapLocation r102 = q4.D;     // Catch: Throwable -> L8
            r101.getClass();     // Catch: Throwable -> L8
            if (GeocodeSearch.GPS.equalsIgnoreCase(r100) == false) goto L12;
            r101.f517607f = 0;     // Catch: Throwable -> L8
            r101.f517618q = 0;     // Catch: Throwable -> L8
            return;
        L12:
            return;
        L11:
            return;
        }

        @Override // android.location.LocationListener
        public final void onStatusChanged(String r100, int r101, Bundle r102) {
            q4 r103 = this.f517628a;     // Catch: Throwable -> L9
            if (r103 == null) goto L12;
            AMapLocation r104 = q4.D;     // Catch: Throwable -> L9
            r103.getClass();     // Catch: Throwable -> L9
            if (r101 == 0) goto L7;
            return;
        L7:
            r103.f517607f = 0;     // Catch: Throwable -> L9
            r103.f517618q = 0;     // Catch: Throwable -> L9
            return;
        L12:
            return;
        }
    }

    static {
        F = new Object();
        G = 0;
        H = false;
        I = false;
        f517601J = null;
    }

    public q4(Context r100, x1.e r101) {
        this.f517606e = 0;
        this.f517607f = 0;
        this.f517608g = false;
        this.f517609h = 0;
        this.f517610i = null;
        this.f517611j = 240;
        this.f517612k = 80;
        this.f517613l = null;
        this.f517614m = 0;
        this.f517615n = 0.0f;
        this.f517616o = new Object();
        this.f517617p = new Object();
        this.f517618q = 0;
        this.f517619r = null;
        this.f517620s = null;
        this.f517622u = AMapLocationClientOption.GeoLanguage.DEFAULT;
        this.f517623v = true;
        this.f517624w = 0;
        this.f517625x = 0;
        this.f517626y = null;
        this.f517627z = null;
        this.A = false;
        this.B = 0;
        this.C = false;
        this.f517603b = r100;
        this.f517602a = r101;
        this.f517604c = (LocationManager) r100.getSystemService("location");     // Catch: Throwable -> L5
    L7:
        this.f517610i = new f3();
        return;
    L5:
        th = move-exception;
        c4.g(th, "GpsLocation", "<init>");
        goto L7
    }

    public static boolean g(LocationManager r100) {
    L14:
        th = move-exception;
        new StringBuilder("GpsLocation | hasProvider error: ").append(th.getMessage());
        return I;
    L3:
        if (H == true) goto L5;
        List<String> r101 = r100.getAllProviders();     // Catch: Throwable -> L14
        if (r101 != null) goto L9;
    L11:
        I = false;     // Catch: Throwable -> L14
    L12:
        H = true;     // Catch: Throwable -> L14
        return I;
    L9:
        if (r101.size() <= 0) goto L11;
        I = r101.contains(GeocodeSearch.GPS);     // Catch: Throwable -> L14
        goto L12
    L5:
        return I;
    }

    public final void b(int r100, int r101, String r102, long r103) {
        if (this.f517602a != null) goto L5;
        return;
    L5:
        if (this.f517605d.getLocationMode() != AMapLocationClientOption.AMapLocationMode.Device_Sensors) goto L12;
        Message r104 = Message.obtain();     // Catch: Throwable -> L8
        AMapLocation r105 = new AMapLocation("");     // Catch: Throwable -> L8
        r105.setProvider(GeocodeSearch.GPS);     // Catch: Throwable -> L8
        r105.setErrorCode(r101);     // Catch: Throwable -> L8
        r105.setLocationDetail(r102);     // Catch: Throwable -> L8
        r105.setLocationType(1);     // Catch: Throwable -> L8
        r104.obj = r105;     // Catch: Throwable -> L8
        r104.what = r100;     // Catch: Throwable -> L8
        this.f517602a.sendMessageDelayed(r104, r103);     // Catch: Throwable -> L8
        return;
    L12:
        return;
    }

    public final void c(Bundle r100) {
        if (r100 == null) goto L20;
        r100.setClassLoader(AMapLocation.class.getClassLoader());     // Catch: Throwable -> L13
        this.f517611j = r100.getInt("I_MAX_GEO_DIS");     // Catch: Throwable -> L13
        this.f517612k = r100.getInt("I_MIN_GEO_DIS");     // Catch: Throwable -> L13
        AMapLocation r101 = (AMapLocation) r100.getParcelable("loc");     // Catch: Throwable -> L13
        if (TextUtils.isEmpty(r101.getAdCode()) == true) goto L21;
        Object r102 = this.f517616o;     // Catch: Throwable -> L13
        monitor-enter(r102);     // Catch: Throwable -> L13
        f517601J = r101;     // Catch: Throwable -> L10
        monitor-exit(r102);     // Catch: Throwable -> L10
        return;
    L10:
        th = move-exception;
        throw th;     // Catch: Throwable -> L13
    L21:
        return;
    L13:
        th = move-exception;
        c4.g(th, "GpsLocation", "setLastGeoLocation");
        return;
    }

    public final void o(AMapLocation r100) {
    L11:
        r100.setOffset(false);
        r100.setCoordType(AMapLocation.COORD_TYPE_WGS84);
        return;
    L4:
        if (c4.h(r100.getLatitude(), r100.getLongitude()) == true) goto L6;
    L9:
        r100.setOffset(false);     // Catch: Throwable -> L11
        r100.setCoordType(AMapLocation.COORD_TYPE_WGS84);     // Catch: Throwable -> L11
        return;
    L6:
        if (this.f517605d.isOffset() == false) goto L9;
        DPoint r101 = e4.b(this.f517603b, new DPoint(r100.getLatitude(), r100.getLongitude()));     // Catch: Throwable -> L11
        r100.setLatitude(r101.getLatitude());     // Catch: Throwable -> L11
        r100.setLongitude(r101.getLongitude());     // Catch: Throwable -> L11
        r100.setOffset(this.f517605d.isOffset());     // Catch: Throwable -> L11
        r100.setCoordType(AMapLocation.COORD_TYPE_GCJ02);     // Catch: Throwable -> L11
    }

    public final AMapLocation q() {
        if (j4.l(this.f517613l) == true) goto L7;
        return null;
    L7:
        if (com.loc.h.f380084r == true) goto L50;
        return null;
    L50:
        boolean r100 = ((Boolean) f4.e(f5.o("KY29tLmFtYXAuYXBpLm5hdmkuQU1hcE5hdmk="), f5.o("UaXNOYXZpU3RhcnRlZA=="), null, null)).booleanValue();     // Catch: Throwable -> L11
    L12:
        if (r100 == false) goto L39;
        JSONObject r101 = new JSONObject((String) f4.e(f5.o("KY29tLmFtYXAuYXBpLm5hdmkuQU1hcE5hdmk="), f5.o("UZ2V0TmF2aUxvY2F0aW9u"), null, null));     // Catch: Throwable -> L41
        long r102 = r101.optLong("time");     // Catch: Throwable -> L41
        if (this.C == true) goto L17;
        this.C = true;     // Catch: Throwable -> L41
        h4.l("useNaviLoc", "use NaviLoc");     // Catch: Throwable -> L41
    L17:
        if ((System.currentTimeMillis() - r102) > 5500) goto L39;
        double r103 = r101.optDouble("lat", AudioStats.AUDIO_AMPLITUDE_NONE);     // Catch: Throwable -> L41
        double r104 = r101.optDouble("lng", AudioStats.AUDIO_AMPLITUDE_NONE);     // Catch: Throwable -> L41
        float r105 = 0.0f;
        float r110 = CastFloatProtector.parseFloat(r101.optString(LocationMonitorConst.ACCURACY, "0"));     // Catch: NumberFormatException -> L22 Throwable -> L41
    L23:
        double r106 = r101.optDouble("altitude", AudioStats.AUDIO_AMPLITUDE_NONE);     // Catch: Throwable -> L41
        float r111 = CastFloatProtector.parseFloat(r101.optString("bearing", "0"));     // Catch: NumberFormatException -> L26 Throwable -> L41
    L42:
        r105 = (CastFloatProtector.parseFloat(r101.optString("speed", "0")) * 10.0f) / 36.0f;
    L29:
        AMapLocation r107 = new AMapLocation(MapInfoConst.MAP_SHOT_DIR);     // Catch: Throwable -> L41
        r107.setLocationType(9);     // Catch: Throwable -> L41
        r107.setLatitude(r103);     // Catch: Throwable -> L41
        r107.setLongitude(r104);     // Catch: Throwable -> L41
        r107.setAccuracy(r110);     // Catch: Throwable -> L41
        r107.setAltitude(r106);     // Catch: Throwable -> L41
        r107.setBearing(r111);     // Catch: Throwable -> L41
        r107.setSpeed(r105);     // Catch: Throwable -> L41
        r107.setTime(r102);     // Catch: Throwable -> L41
        r107.setCoordType(AMapLocation.COORD_TYPE_GCJ02);     // Catch: Throwable -> L41
        if (j4.a(r107, this.f517613l) > 300.0f) goto L39;
        Object r108 = this.f517617p;     // Catch: Throwable -> L41
        monitor-enter(r108);     // Catch: Throwable -> L41
        this.f517613l.setLongitude(r104);     // Catch: Throwable -> L36
        this.f517613l.setLatitude(r103);     // Catch: Throwable -> L36
        this.f517613l.setAccuracy(r110);     // Catch: Throwable -> L36
        this.f517613l.setBearing(r111);     // Catch: Throwable -> L36
        this.f517613l.setSpeed(r105);     // Catch: Throwable -> L36
        this.f517613l.setTime(r102);     // Catch: Throwable -> L36
        this.f517613l.setCoordType(AMapLocation.COORD_TYPE_GCJ02);     // Catch: Throwable -> L36
        monitor-exit(r108);     // Catch: Throwable -> L36
        return r107;
    L36:
        th = move-exception;
        throw th;     // Catch: Throwable -> L41
    L26:
        r111 = 0.0f;
    L22:
        r110 = 0.0f;
    L11:
        r100 = false;
    L39:
        return null;
    }

    public final void h() {
        LocationManager r100 = this.f517604c;
        if (r100 != null) goto L28;
        return;
    L28:
        a r101 = this.f517626y;     // Catch: Throwable -> L24
        if (r101 == null) goto L32;
        if (fna.g.d() == true) goto L11;
        r100.removeUpdates(r101);     // Catch: Throwable -> L24
    L12:
        this.f517626y.f517628a = null;     // Catch: Throwable -> L24
        this.f517626y = null;     // Catch: Throwable -> L24
        goto L32
    L11:
        r100.removeUpdates(r101);     // Catch: Throwable -> L24
        nna.a.a(r101.hashCode());     // Catch: Throwable -> L24
    L32:
        p4 r102 = this.f517620s;     // Catch: Throwable -> L25
        if (r102 == null) goto L30;
        this.f517604c.removeGpsStatusListener(r102);     // Catch: Throwable -> L25
    L30:
        o4 r103 = this.f517621t;     // Catch: Throwable -> L26
        if (r103 == null) goto L34;
        this.f517604c.unregisterGnssStatusCallback(r103);     // Catch: Throwable -> L26
    L34:
        Handler r104 = this.f517602a;     // Catch: Throwable -> L27
        if (r104 == null) goto L22;
        r104.removeMessages(8);     // Catch: Throwable -> L27
    L22:
        this.f517618q = 0;
        this.f517606e = 0;
        this.f517624w = 0;
        this.f517607f = 0;
        this.f517609h = 0;
        this.f517625x = 0;
        this.f517610i.b();
        this.f517613l = null;
        this.f517614m = 0;
        this.f517615n = 0.0f;
        this.f517627z = null;
        this.C = false;
    }

    public final boolean j() {
        if ((SystemClock.elapsedRealtime() - this.f517607f) <= 2800) goto L6;
        return false;
    L6:
        return true;
    }

    public final void p() {
        if ((SystemClock.elapsedRealtime() - E) <= 5000) goto L5;
        return;
    L5:
        if (j4.l(D) == true) goto L7;
        return;
    L7:
        if (this.f517605d.isMockEnable() == false) goto L9;
    L11:
        this.f517607f = SystemClock.elapsedRealtime();
        k(D);
        return;
    L9:
        if (D.isMock() == false) goto L11;
    }

    public final void d(AMapLocation r100) {
        if (j4.l(r100) == true) goto L5;
        return;
    L5:
        this.f517607f = SystemClock.elapsedRealtime();
        Object r101 = F;
        monitor-enter(r101);
        E = SystemClock.elapsedRealtime();     // Catch: Throwable -> L11
        D = r100.clone();     // Catch: Throwable -> L11
        monitor-exit(r101);     // Catch: Throwable -> L11
        this.f517609h++;
        return;
    L11:
        th = move-exception;
        throw th;
    }

    public final void e(AMapLocationClientOption r110) {
        this.f517605d = r110;
        if (r110 != null) goto L54;
        this.f517605d = new AMapLocationClientOption();
    L54:
        G = i4.b(this.f517603b, "pref", "lagt", G);     // Catch: Throwable -> L7
    L9:
        if (this.f517604c != null) goto L56;
        return;
    L56:
        p();     // Catch: Throwable -> L46 SecurityException -> L48
        this.f517623v = true;     // Catch: Throwable -> L46 SecurityException -> L48
        Looper r100 = Looper.myLooper();     // Catch: Throwable -> L46 SecurityException -> L48
        if (r100 != null) goto L15;
        r100 = this.f517603b.getMainLooper();     // Catch: Throwable -> L46 SecurityException -> L48
    L15:
        Looper r101 = r100;
        this.f517606e = SystemClock.elapsedRealtime();     // Catch: Throwable -> L46 SecurityException -> L48
        if (g(this.f517604c) == true) goto L52;
        b(8, 14, "no gps provider#1402", 0);     // Catch: Throwable -> L46 SecurityException -> L48
        return;
    L52:
    L24:
        th = move-exception;
        th.getMessage();     // Catch: Throwable -> L46 SecurityException -> L48
    L27:
        if (this.f517626y != null) goto L30;
        this.f517626y = new a(this);     // Catch: Throwable -> L46 SecurityException -> L48
    L30:
        if (this.f517605d.getLocationMode().equals(AMapLocationClientOption.AMapLocationMode.Device_Sensors) == true) goto L32;
    L34:
        LocationManager r102 = this.f517604c;     // Catch: Throwable -> L46 SecurityException -> L48
        a r103 = this.f517626y;     // Catch: Throwable -> L46 SecurityException -> L48
        long r104 = 900;
        float r105 = 0.0f;
    L36:
        if (fna.g.d() == true) goto L38;
        n(r102, r104, r105, r103, r101);     // Catch: Throwable -> L46 SecurityException -> L48
    L40:
        if (Build.VERSION.SDK_INT < 24) goto L42;
        o4 r106 = new o4(this);     // Catch: Throwable -> L46 SecurityException -> L48
        this.f517621t = r106;     // Catch: Throwable -> L46 SecurityException -> L48
        m(this.f517604c, r106);     // Catch: Throwable -> L46 SecurityException -> L48
    L43:
        b(8, 14, "no enough satellites#1401", this.f517605d.getHttpTimeOut());     // Catch: Throwable -> L46 SecurityException -> L48
        return;
    L42:
        p4 r107 = new p4(this);     // Catch: Throwable -> L46 SecurityException -> L48
        this.f517620s = r107;     // Catch: Throwable -> L46 SecurityException -> L48
        l(this.f517604c, r107);     // Catch: Throwable -> L46 SecurityException -> L48
        goto L43
    L38:
        n(r102, r104, r105, r103, r101);     // Catch: Throwable -> L46 SecurityException -> L48
        nna.a.c(r103.hashCode());     // Catch: Throwable -> L46 SecurityException -> L48
        goto L40
    L32:
        if (this.f517605d.getDeviceModeDistanceFilter() <= 0.0f) goto L34;
        LocationManager r108 = this.f517604c;     // Catch: Throwable -> L46 SecurityException -> L48
        long r109 = this.f517605d.getInterval();     // Catch: Throwable -> L46 SecurityException -> L48
        float r111 = this.f517605d.getDeviceModeDistanceFilter();     // Catch: Throwable -> L46 SecurityException -> L48
        r102 = r108;
        r103 = this.f517626y;     // Catch: Throwable -> L46 SecurityException -> L48
        r105 = r111;
        r104 = r109;
        goto L36
    L18:
        if ((System.currentTimeMillis() - G) >= Constants.DOWNLOAD_TEMP_FILE_PAST_TIME) goto L20;
    L51:
        goto L27
    L20:
        if (j4.A(this.f517603b, "WYW5kcm9pZC5wZXJtaXNzaW9uLkFDQ0VTU19MT0NBVElPTl9FWFRSQV9DT01NQU5EUw==") == false) goto L22;
        this.f517604c.sendExtraCommand(GeocodeSearch.GPS, "force_xtra_injection", null);     // Catch: Throwable -> L24
        G = System.currentTimeMillis();     // Catch: Throwable -> L24
        SharedPreferences.Editor r112 = i4.c(this.f517603b, "pref");     // Catch: Throwable -> L24
        i4.g(r112, "lagt", G);     // Catch: Throwable -> L24
        i4.e(r112);     // Catch: Throwable -> L24
        goto L51
    L22:
        c4.g(new Exception("n_alec"), "OPENSDK_GL", "rlu_n_alec");     // Catch: Throwable -> L24
    L48:
        e = move-exception;
        this.f517623v = false;
        h4.k(null, 2121);
        b(2, 12, e.getMessage() + "#1201", 0);
        return;
    L46:
        th = move-exception;
        th.getMessage();
        c4.g(th, "GpsLocation", "requestLocationUpdates part2");
    }

    public final void i(AMapLocation r100) {
        if (j4.l(r100) == true) goto L6;
        return;
    L6:
        if (this.f517602a == null) goto L25;
        long r101 = SystemClock.elapsedRealtime();
        if (this.f517605d.getInterval() > KtvSingChallengeViewModel.CHALLENGE_ON_GOING_INTERVAL) goto L10;
    L11:
        Bundle r102 = new Bundle();
        r102.putDouble("lat", r100.getLatitude());
        r102.putDouble("lon", r100.getLongitude());
        r102.putFloat("radius", r100.getAccuracy());
        r102.putLong("time", r100.getTime());
        Message r103 = Message.obtain();
        r103.setData(r102);
        r103.what = 5;
        Object r104 = this.f517616o;
        monitor-enter(r104);
    L22:
        th = move-exception;
        throw th;
    L14:
        if (f517601J != null) goto L18;
        Handler r105 = this.f517602a;     // Catch: Throwable -> L22
    L16:
        r105.sendMessage(r103);     // Catch: Throwable -> L22
    L20:
        monitor-exit(r104);     // Catch: Throwable -> L22
        return;
    L18:
        if (j4.a(r100, f517601J) <= this.f517612k) goto L20;
        r105 = this.f517602a;     // Catch: Throwable -> L22
        goto L16
    L10:
        if ((r101 - this.f517624w) > (this.f517605d.getInterval() - KtvSingChallengeViewModel.CHALLENGE_ON_GOING_INTERVAL)) goto L11;
        return;
    }

    public final void k(AMapLocation r100) {
        if (r100.getErrorCode() != 15) goto L8;
        if (AMapLocationClientOption.AMapLocationMode.Device_Sensors.equals(this.f517605d.getLocationMode()) == true) goto L8;
        return;
    L8:
        if (this.f517605d.getLocationMode().equals(AMapLocationClientOption.AMapLocationMode.Device_Sensors) == false) goto L16;
        if (this.f517605d.getDeviceModeDistanceFilter() <= 0.0f) goto L16;
        if (this.f517602a == null) goto L21;
        Message r101 = Message.obtain();
        r101.obj = r100;
        r101.what = 2;
        this.f517602a.sendMessage(r101);
        return;
    L21:
        return;
    L16:
        if ((SystemClock.elapsedRealtime() - this.f517624w) < (this.f517605d.getInterval() - 200)) goto L22;
        this.f517624w = SystemClock.elapsedRealtime();
        if (this.f517602a == null) goto L23;
        Message r102 = Message.obtain();
        r102.obj = r100;
        r102.what = 2;
        this.f517602a.sendMessage(r102);
        return;
    L23:
        return;
    }

    public static void f(q4 r110, Location r111) {
        Handler r100 = r110.f517602a;
        if (r100 == null) goto L5;
        r100.removeMessages(8);
    L5:
        if (r111 == null) goto L119;
        AMapLocation r101 = new AMapLocation(r111);     // Catch: Throwable -> L102
        if (j4.l(r101) == false) goto L117;
        r101.setProvider(GeocodeSearch.GPS);     // Catch: Throwable -> L102
        boolean r102 = true;
        r101.setLocationType(1);     // Catch: Throwable -> L102
        if (r110.f517608g == true) goto L25;
        if (j4.l(r101) == false) goto L25;
        Context r103 = r110.f517603b;     // Catch: Throwable -> L102
        long r104 = SystemClock.elapsedRealtime() - r110.f517606e;     // Catch: Throwable -> L102
        boolean r105 = c4.h(r101.getLatitude(), r101.getLongitude());     // Catch: Throwable -> L102
        List<r0> r106 = h4.f517352g;     // Catch: Throwable -> L102
        if (r103 != null) goto L109;
    L23:
        r110.f517608g = true;     // Catch: Throwable -> L102
        goto L25
    L109:
    L21:
        th = move-exception;
        c4.g(th, "ReportUtil", "reportGPSLocUseTime");     // Catch: Throwable -> L102
        goto L23
    L17:
        if (com.loc.h.f380068b == false) goto L23;
        h4.e(r103, r104, r105, "O015");     // Catch: Throwable -> L21
    L25:
        if (j4.k(r101, r110.f517618q) == false) goto L32;
        r101.setMock(true);     // Catch: Throwable -> L102
        r101.setTrustedLevel(4);     // Catch: Throwable -> L102
        if (r110.f517605d.isMockEnable() == true) goto L33;
        int r112 = r110.f517625x;     // Catch: Throwable -> L102
        if (r112 <= 3) goto L31;
        h4.k(null, 2152);     // Catch: Throwable -> L102
        r101.setErrorCode(15);     // Catch: Throwable -> L102
        r101.setLocationDetail("GpsLocation has been mocked!#1501");     // Catch: Throwable -> L102
        r101.setLatitude(AudioStats.AUDIO_AMPLITUDE_NONE);     // Catch: Throwable -> L102
        r101.setLongitude(AudioStats.AUDIO_AMPLITUDE_NONE);     // Catch: Throwable -> L102
        r101.setAltitude(AudioStats.AUDIO_AMPLITUDE_NONE);     // Catch: Throwable -> L102
        r101.setSpeed(0.0f);     // Catch: Throwable -> L102
        r101.setAccuracy(0.0f);     // Catch: Throwable -> L102
        r101.setBearing(0.0f);     // Catch: Throwable -> L102
        r101.setExtras(null);     // Catch: Throwable -> L102
    L97:
        r110.k(r101);     // Catch: Throwable -> L102
        return;
    L31:
        r110.f517625x = r112 + 1;     // Catch: Throwable -> L102
        return;
    L33:
        r101.setSatellites(r110.f517618q);     // Catch: Throwable -> L102
        r110.o(r101);     // Catch: Throwable -> L102
        int r107 = r110.f517618q;     // Catch: Throwable -> L105
        if (r107 < 4) goto L37;
        int r108 = 1;
    L39:
        r101.setGpsAccuracyStatus(r108);     // Catch: Throwable -> L105
    L106:
        goto L42
    L37:
        if (r107 != 0) goto L40;
        r108 = -1;
        goto L39
    L40:
        r101.setGpsAccuracyStatus(0);     // Catch: Throwable -> L105
    L42:
        if (j4.l(r101) == true) goto L45;
    L55:
        if (j4.l(r101) == true) goto L58;
    L71:
        r110.d(r101);     // Catch: Throwable -> L102
        r110.i(r101);     // Catch: Throwable -> L102
        Object r109 = r110.f517616o;     // Catch: Throwable -> L102
        monitor-enter(r109);     // Catch: Throwable -> L102
        AMapLocation r113 = f517601J;     // Catch: Throwable -> L99
        if (r113 != null) goto L76;
    L80:
        monitor-exit(r109);     // Catch: Throwable -> L99
    L116:
    L95:
        th = move-exception;
        c4.g(th, "GpsLocation", "onLocationChangedLast");     // Catch: Throwable -> L102
        goto L97
    L82:
        if (j4.l(r101) == false) goto L97;
        if (r110.f517613l == null) goto L86;
        r110.f517614m = r111.getTime() - r110.f517613l.getTime();     // Catch: Throwable -> L95
        r110.f517615n = j4.a(r110.f517613l, r101);     // Catch: Throwable -> L95
    L86:
        Object r114 = r110.f517617p;     // Catch: Throwable -> L95
        monitor-enter(r114);     // Catch: Throwable -> L95
        r110.f517613l = r101.clone();     // Catch: Throwable -> L92
        monitor-exit(r114);     // Catch: Throwable -> L92
        r110.f517627z = null;     // Catch: Throwable -> L95
        r110.A = false;     // Catch: Throwable -> L95
        r110.B = 0;     // Catch: Throwable -> L95
        goto L97
    L92:
        th = move-exception;
        throw th;     // Catch: Throwable -> L95
    L76:
        if (r110.f517605d.isNeedAddress() == false) goto L80;
        if (j4.a(r101, r113) >= r110.f517611j) goto L80;
        c4.d(r101, r113);     // Catch: Throwable -> L99
    L99:
        th = move-exception;
        throw th;     // Catch: Throwable -> L102
    L58:
        if (r110.f517609h < 3) goto L71;
        if (r101.getAccuracy() >= 0.0f) goto L63;
    L64:
        r101.setAccuracy(0.0f);     // Catch: Throwable -> L102
    L66:
        if (r101.getSpeed() >= 0.0f) goto L68;
    L69:
        r101.setSpeed(0.0f);     // Catch: Throwable -> L102
    L70:
        r101 = r110.f517610i.a(r101);     // Catch: Throwable -> L102
        goto L71
    L68:
        if (r101.getSpeed() != Float.MAX_VALUE) goto L70;
    L63:
        if (r101.getAccuracy() != Float.MAX_VALUE) goto L66;
    L45:
        if (com.loc.h.f380089w == true) goto L47;
    L49:
        r102 = false;
    L50:
        if (r102 == false) goto L55;
        long r115 = r101.getTime();     // Catch: Throwable -> L102
        long r116 = System.currentTimeMillis();     // Catch: Throwable -> L102
        long r117 = d4.a(r115, r116, com.loc.h.f380090x);     // Catch: Throwable -> L102
        if (r117 == r115) goto L55;
        r101.setTime(r117);     // Catch: Throwable -> L102
        h4.a(r115, r116);     // Catch: Throwable -> L102
        goto L55
    L47:
        if (com.loc.h.f380090x <= 0) goto L49;
    L32:
        r110.f517625x = 0;     // Catch: Throwable -> L102
        goto L33
    L117:
        return;
    L102:
        th = move-exception;
        c4.g(th, "GpsLocation", "onLocationChanged");
        return;
    }

    public static void l(LocationManager r110, p4 r111) {
        ArrayList r100 = new ArrayList();
        Object[] r101 = {r111};
        f06.b r112 = new f06.b();
        g06.a r102 = ApiHookConfig.f245611b.get(100005);
        if (r102 == null) goto L5;
        f06.a[] r103 = r102.f479473i;
    L6:
        f06.a[] r113 = r103;
        int r104 = r113.length;
        int r105 = 0;
    L8:
        if (r105 >= r104) goto L15;
        f06.a r106 = r113[r105];
        int r114 = r105;
        int r115 = r104;
        f06.d r107 = r106.preInvoke(100005, "android/location/LocationManager", "addGpsStatusListener", r110, r101, "boolean", r112);     // Catch: Exception -> L22
        if (r107.f474982a == true) goto L17;
        r100.add(r106);     // Catch: Exception -> L22
    L17:
        if (r107.f474982a == false) goto L20;
        ((Boolean) r107.f474983b).booleanValue();
        return;
    L20:
        r110.addGpsStatusListener(r111);
        return;
    L14:
        r105 = r114 + 1;
        r104 = r115;
        goto L8
    L15:
        r107 = new f06.d(false, null);
        goto L17
    L5:
        r103 = ApiHookConfig.f245613d;
        goto L6
    }

    public static void m(LocationManager r110, o4 r111) {
        ArrayList r100 = new ArrayList();
        Object[] r101 = {r111};
        f06.b r112 = new f06.b();
        g06.a r102 = ApiHookConfig.f245611b.get(100011);
        if (r102 == null) goto L5;
        f06.a[] r103 = r102.f479473i;
    L6:
        f06.a[] r113 = r103;
        int r104 = r113.length;
        int r105 = 0;
    L8:
        if (r105 >= r104) goto L15;
        f06.a r106 = r113[r105];
        int r114 = r105;
        int r115 = r104;
        f06.d r107 = r106.preInvoke(100011, "android/location/LocationManager", "registerGnssStatusCallback", r110, r101, "boolean", r112);     // Catch: Exception -> L22
        if (r107.f474982a == true) goto L17;
        r100.add(r106);     // Catch: Exception -> L22
    L17:
        if (r107.f474982a == false) goto L20;
        ((Boolean) r107.f474983b).booleanValue();
        return;
    L20:
        r110.registerGnssStatusCallback(r111);
        return;
    L14:
        r105 = r114 + 1;
        r104 = r115;
        goto L8
    L15:
        r107 = new f06.d(false, null);
        goto L17
    L5:
        r103 = ApiHookConfig.f245613d;
        goto L6
    }

    public final AMapLocation a(AMapLocation r110, String r111) {
        if (this.f517613l != null) goto L6;
        return r110;
    L6:
        if (this.f517605d.isMockEnable() == true) goto L11;
        if (this.f517613l.isMock() == false) goto L11;
        return r110;
    L11:
        if (j4.l(this.f517613l) == true) goto L13;
        return r110;
    L13:
        AMapLocation r100 = q();
        if (r100 != null) goto L16;
    L19:
        float r101 = this.f517613l.getSpeed();
        if (r101 != 0.0f) goto L29;
        long r102 = this.f517614m;
        if (r102 <= 0) goto L29;
        if (r102 >= 8) goto L29;
        float r103 = this.f517615n;
        if (r103 <= 0.0f) goto L29;
        r101 = r103 / r102;
    L29:
        if (r110 != null) goto L31;
    L48:
        long r112 = 30000;
    L49:
        long r113 = SystemClock.elapsedRealtime() - this.f517607f;
        if (r113 <= 30000) goto L53;
        return r110;
    L53:
        if (r113 < r112) goto L77;
        if (this.A == true) goto L85;
    L67:
        this.f517627z = null;
        this.B = 0;
        Object r104 = this.f517617p;
        monitor-enter(r104);
        this.f517613l = null;     // Catch: Throwable -> L73
        monitor-exit(r104);     // Catch: Throwable -> L73
        this.f517614m = 0;
        this.f517615n = 0.0f;
        return r110;
    L73:
        th = move-exception;
        throw th;
    L85:
        ArrayList<String> r105 = j4.v(r111);     // Catch: Throwable -> L62
        ArrayList<String> r106 = j4.v(this.f517627z);     // Catch: Throwable -> L62
        if (r105.size() < 8) goto L63;
        if (r106.size() < 8) goto L63;
        boolean r107 = j4.o(this.f517627z, r111);     // Catch: Throwable -> L62
    L64:
        if (r107 == false) goto L67;
        AMapLocation r108 = this.f517613l.clone();
        r108.setTrustedLevel(3);
        return r108;
    L63:
        r107 = false;
        goto L64
    L77:
        if (this.f517627z == null) goto L79;
    L81:
        AMapLocation r109 = this.f517613l.clone();
        r109.setTrustedLevel(2);
        return r109;
    L79:
        if (this.B < 2) goto L81;
        this.f517627z = r111;
        goto L81
    L31:
        if (j4.l(r110) == false) goto L48;
        if (r110.getAccuracy() >= 200.0f) goto L43;
        int r114 = this.B + 1;
        this.B = r114;
        if (this.f517627z != null) goto L39;
        if (r114 < 2) goto L39;
        this.A = true;
    L39:
        if (r101 <= 5.0f) goto L41;
        r112 = 10000;
        goto L49
    L41:
        r112 = 15000;
        goto L49
    L43:
        if (TextUtils.isEmpty(this.f517627z) == true) goto L46;
        this.A = false;
        this.B = 0;
    L46:
        if (r101 <= 5.0f) goto L48;
        r112 = 20000;
        goto L49
    L16:
        if (j4.l(r100) == false) goto L19;
        r100.setTrustedLevel(2);
        return r100;
    }

    public static void n(LocationManager r110, long r210, float r211, LocationListener r212, Looper r213) {
        ArrayList r100 = new ArrayList();
        Object[] r101 = {GeocodeSearch.GPS, Long.valueOf(r210), Float.valueOf(r211), r212, r213};
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
        r110.requestLocationUpdates(GeocodeSearch.GPS, r210, r211, r212, r213);
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
}
