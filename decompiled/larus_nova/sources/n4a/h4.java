package n4a;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.SparseArray;
import com.amap.api.location.AMapLocation;
import com.amap.api.location.AMapLocationClientOption;
import com.amap.api.services.geocoder.GeocodeSearch;
import com.bytedance.bdlocation.monitor.LocationMonitorConst;
import com.bytedance.map.api.monitor.MapMonitorConst;
import com.bytedance.ttnet.utils.MultiProcessFileUtils;
import com.loc.em;
import com.ss.ttvideoengine.net.DNSParser;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes32.dex */
public final class h4 {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final List<r0> f517352g = null;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static JSONArray f517353h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static AMapLocation f517354i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static boolean f517355j;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final SparseArray<Long> f517356a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f517357b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public long f517358c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String[] f517359d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f517360e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public long f517361f;

    public static /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f517362a = null;

        static {
            int[] r100 = new int[AMapLocationClientOption.AMapLocationMode.values().length];
            f517362a = r100;
            r100[AMapLocationClientOption.AMapLocationMode.Battery_Saving.ordinal()] = 1;     // Catch: NoSuchFieldError -> L7
        L10:
            f517362a[AMapLocationClientOption.AMapLocationMode.Device_Sensors.ordinal()] = 2;     // Catch: NoSuchFieldError -> L8
        L12:
            f517362a[AMapLocationClientOption.AMapLocationMode.Hight_Accuracy.ordinal()] = 3;     // Catch: NoSuchFieldError -> L9
            return;
        }
    }

    static {
        f517352g = new ArrayList();
        f517353h = null;
        f517354i = null;
        f517355j = false;
    }

    public h4() {
        this.f517356a = new SparseArray();
        this.f517357b = -1;
        this.f517358c = 0;
        this.f517359d = new String[]{"ol", "cl", "gl", "ha", "bs", "ds"};
        this.f517360e = -1;
        this.f517361f = -1;
    }

    public static void j(AMapLocation r100, AMapLocation r101) {
        if (f517354i != null) goto L11;
        if (j4.l(r100) == true) goto L9;
        f517354i = r101;     // Catch: Throwable -> L51
        return;
    L9:
        f517354i = r100.clone();     // Catch: Throwable -> L51
    L11:
        if (j4.l(f517354i) == true) goto L13;
        return;
    L13:
        if (j4.l(r101) == false) goto L54;
        AMapLocation r102 = r101.clone();     // Catch: Throwable -> L51
        if (f517354i.getLocationType() != 1) goto L17;
    L49:
        f517354i = r102;     // Catch: Throwable -> L51
        return;
    L17:
        if (f517354i.getLocationType() == 9) goto L49;
        if (GeocodeSearch.GPS.equalsIgnoreCase(f517354i.getProvider()) == true) goto L49;
        if (f517354i.getLocationType() == 7) goto L49;
        if (r102.getLocationType() == 1) goto L49;
        if (r102.getLocationType() == 9) goto L49;
        if (GeocodeSearch.GPS.equalsIgnoreCase(r102.getProvider()) == true) goto L49;
        if (r102.getLocationType() == 7) goto L49;
        long r103 = Math.abs(r102.getTime() - f517354i.getTime()) / 1000;     // Catch: Throwable -> L51
        if (r103 > 0) goto L34;
        r103 = 1;
    L34:
        if (r103 > 1800) goto L49;
        float r104 = j4.a(f517354i, r102);     // Catch: Throwable -> L51
        float r105 = r104 / r103;     // Catch: Throwable -> L51
        if (r104 <= 30000.0f) goto L49;
        if (r105 <= 1000.0f) goto L49;
        StringBuilder r106 = new StringBuilder();     // Catch: Throwable -> L51
        r106.append(f517354i.getLatitude());     // Catch: Throwable -> L51
        r106.append(",");     // Catch: Throwable -> L51
        r106.append(f517354i.getLongitude());     // Catch: Throwable -> L51
        r106.append(",");     // Catch: Throwable -> L51
        r106.append(f517354i.getAccuracy());     // Catch: Throwable -> L51
        r106.append(",");     // Catch: Throwable -> L51
        r106.append(f517354i.getLocationType());     // Catch: Throwable -> L51
        r106.append(",");     // Catch: Throwable -> L51
        if (r100.getTime() == 0) goto L43;
        r106.append(j4.f(f517354i.getTime(), "yyyyMMdd_HH:mm:ss:SS"));     // Catch: Throwable -> L51
    L44:
        r106.append("#");     // Catch: Throwable -> L51
        r106.append(r102.getLatitude());     // Catch: Throwable -> L51
        r106.append(",");     // Catch: Throwable -> L51
        r106.append(r102.getLongitude());     // Catch: Throwable -> L51
        r106.append(",");     // Catch: Throwable -> L51
        r106.append(r102.getAccuracy());     // Catch: Throwable -> L51
        r106.append(",");     // Catch: Throwable -> L51
        r106.append(r102.getLocationType());     // Catch: Throwable -> L51
        r106.append(",");     // Catch: Throwable -> L51
        if (r102.getTime() == 0) goto L47;
        r106.append(j4.f(r102.getTime(), "yyyyMMdd_HH:mm:ss:SS"));     // Catch: Throwable -> L51
    L48:
        l("bigshiftstatistics", r106.toString());     // Catch: Throwable -> L51
        r106.delete(0, r106.length());     // Catch: Throwable -> L51
        goto L49
    L47:
        r106.append(r102.getTime());     // Catch: Throwable -> L51
        goto L48
    L43:
        r106.append(f517354i.getTime());     // Catch: Throwable -> L51
        goto L44
    L54:
        return;
    }

    public static synchronized void b(Context r100) {
        monitor-enter(h4.class);
        if (r100 != null) goto L27;
    L23:
        monitor-exit(h4.class);
        return;
    L27:
    L16:
        th = move-exception;
        c4.g(th, "ReportUtil", MapMonitorConst.EVENT_DESTROY);     // Catch: Throwable -> L20
        return;
    L20:
        th = move-exception;
        throw th;
    L6:
        if (com.loc.h.f380068b == false) goto L23;
        List<r0> r101 = f517352g;     // Catch: Throwable -> L16
        if (r101 != null) goto L11;
    L13:
        n(r100);     // Catch: Throwable -> L16
        monitor-exit(h4.class);
        return;
    L11:
        if (((ArrayList) r101).size() <= 0) goto L13;
        ArrayList r102 = new ArrayList();     // Catch: Throwable -> L16
        r102.addAll(r101);     // Catch: Throwable -> L16
        s0.d(r102, r100);     // Catch: Throwable -> L16
        ((ArrayList) r101).clear();     // Catch: Throwable -> L16
        goto L13
    }

    public static void n(Context r100) {
        JSONArray r101 = f517353h;     // Catch: Throwable -> L15
        if (r101 != null) goto L5;
        return;
    L5:
        if (r101.length() <= 0) goto L21;
        p0 r102 = new p0(r100, c4.k(), f517353h.toString());     // Catch: Throwable -> L15
        monitor-enter(q0.class);     // Catch: Throwable -> L15
        k1.f517430d.b(new q0.a(r100, r102));     // Catch: Throwable -> L11
        monitor-exit(q0.class);     // Catch: Throwable -> L15
        f517353h = null;     // Catch: Throwable -> L15
        return;
    L11:
        th = move-exception;
        throw th;     // Catch: Throwable -> L15
    L21:
        return;
    L15:
        th = move-exception;
        c4.g(th, "ReportUtil", "writeOfflineLocLog");
    }

    public final void m(Context r110) {
        long r100 = SystemClock.elapsedRealtime() - this.f517358c;     // Catch: Throwable -> L20
        int r101 = this.f517357b;     // Catch: Throwable -> L20
        if (r101 == (-1)) goto L6;
        long r102 = this.f517356a.get(r101, 0L).longValue();     // Catch: Throwable -> L20
        this.f517356a.append(this.f517357b, Long.valueOf(r100 + r102));     // Catch: Throwable -> L20
    L6:
        long r103 = SystemClock.elapsedRealtime() - this.f517361f;     // Catch: Throwable -> L20
        int r104 = this.f517360e;     // Catch: Throwable -> L20
        if (r104 == (-1)) goto L9;
        long r105 = this.f517356a.get(r104, 0L).longValue();     // Catch: Throwable -> L20
        this.f517356a.append(this.f517360e, Long.valueOf(r103 + r105));     // Catch: Throwable -> L20
    L9:
        int r106 = 0;
        SharedPreferences.Editor r107 = r110.getSharedPreferences("pref1", 0).edit();     // Catch: Throwable -> L20
    L11:
        if (r106 >= this.f517359d.length) goto L18;
        long r108 = this.f517356a.get(r106, 0L).longValue();     // Catch: Throwable -> L20
        if (r108 <= 0) goto L17;
        if (r108 <= i4.b(r110, "pref1", this.f517359d[r106], 0)) goto L17;
        i4.g(r107, this.f517359d[r106], r108);     // Catch: Throwable -> L20
    L17:
        r106 = r106 + 1;     // Catch: Throwable -> L20
        goto L11
    L18:
        i4.e(r107);     // Catch: Throwable -> L20
        return;
    L20:
        th = move-exception;
        c4.g(th, "ReportUtil", "saveLocationTypeAndMode");
    }

    public static void a(long r100, long r101) {
        if (f517355j == false) goto L6;
        return;
    L6:
        StringBuffer r102 = new StringBuffer();     // Catch: Throwable -> L16
        r102.append("gpsTime:");     // Catch: Throwable -> L16
        r102.append(j4.f(r100, "yyyy-MM-dd HH:mm:ss.SSS"));     // Catch: Throwable -> L16
        r102.append(",sysTime:");     // Catch: Throwable -> L16
        r102.append(j4.f(r101, "yyyy-MM-dd HH:mm:ss.SSS"));     // Catch: Throwable -> L16
        r102.append(",serverTime:");     // Catch: Throwable -> L16
        long r103 = com.loc.h.C;     // Catch: Throwable -> L16
        String r104 = "0";
        if (0 == r103) goto L9;
        r104 = j4.f(r103, "yyyy-MM-dd HH:mm:ss.SSS");     // Catch: Throwable -> L16
    L9:
        r102.append(r104);     // Catch: Throwable -> L16
        l("checkgpstime", r102.toString());     // Catch: Throwable -> L16
        if (0 != r103) goto L12;
    L14:
        r102.delete(0, r102.length());     // Catch: Throwable -> L16
        f517355j = true;     // Catch: Throwable -> L16
        return;
    L12:
        if (Math.abs(r100 - r103) >= 31536000000L) goto L14;
        r102.append(", correctError");     // Catch: Throwable -> L16
        l("checkgpstimeerror", r102.toString());     // Catch: Throwable -> L16
    }

    public static synchronized void f(Context r100, AMapLocation r101) {
        monitor-enter(h4.class);
    L54:
        th = move-exception;
        c4.g(th, "ReportUtil", "recordOfflineLocLog");     // Catch: Throwable -> L58
        return;
    L58:
        th = move-exception;
        throw th;
    L5:
        if (j4.l(r101) == true) goto L8;
        monitor-exit(h4.class);
        return;
    L8:
        int r102 = r101.getLocationType();     // Catch: Throwable -> L54
        if (r102 == 1) goto L23;
        if (r102 == 2) goto L22;
        if (r102 == 4) goto L22;
        if (r102 != 11) goto L15;
        int r103 = 4;
    L24:
        boolean r104 = true;
    L25:
        if (r104 == true) goto L27;
    L52:
        monitor-exit(h4.class);
        return;
    L27:
        if (com.loc.h.f380074h >= 0) goto L29;
        com.loc.h.f380074h = 0;     // Catch: Throwable -> L54
    L29:
        int r105 = com.loc.h.f380074h;     // Catch: Throwable -> L54
        if (r105 == 0) goto L41;
        if (r103 == 0) goto L37;
        if (r103 == 4) goto L37;
        if (r105 != 1) goto L41;
        monitor-exit(h4.class);
        return;
    L37:
        if (r105 != 2) goto L41;
        monitor-exit(h4.class);
        return;
    L41:
        if (f517353h != null) goto L43;
        f517353h = new JSONArray();     // Catch: Throwable -> L54
    L43:
        JSONObject r106 = new JSONObject();     // Catch: Throwable -> L54
        r106.put("lon", j4.s(r101.getLongitude()));     // Catch: Throwable -> L54
        r106.put("lat", j4.s(r101.getLatitude()));     // Catch: Throwable -> L54
        r106.put("type", r103);     // Catch: Throwable -> L54
        r106.put("timestamp", System.currentTimeMillis());     // Catch: Throwable -> L54
        if (r101.getCoordType().equalsIgnoreCase(AMapLocation.COORD_TYPE_WGS84) == false) goto L46;
        r106.put("coordType", 1);     // Catch: Throwable -> L54
    L47:
        if (r103 != 0) goto L49;
        JSONObject r107 = new JSONObject();     // Catch: Throwable -> L54
        r107.put(LocationMonitorConst.ACCURACY, ((long) (((double) r101.getAccuracy()) * 100.0d)) / 100.0d);     // Catch: Throwable -> L54
        r107.put("altitude", ((long) (r101.getAltitude() * 100.0d)) / 100.0d);     // Catch: Throwable -> L54
        r107.put("bearing", ((long) (((double) r101.getBearing()) * 100.0d)) / 100.0d);     // Catch: Throwable -> L54
        r107.put("speed", ((long) (((double) r101.getSpeed()) * 100.0d)) / 100.0d);     // Catch: Throwable -> L54
        r106.put("extension", r107);     // Catch: Throwable -> L54
    L49:
        JSONArray r108 = f517353h.put(r106);     // Catch: Throwable -> L54
        f517353h = r108;     // Catch: Throwable -> L54
        if (r108.length() < com.loc.h.f380070d) goto L52;
        n(r100);     // Catch: Throwable -> L54
        goto L52
    L46:
        r106.put("coordType", 2);     // Catch: Throwable -> L54
        goto L47
    L15:
        if (r102 != 8) goto L17;
        r103 = 3;
        goto L24
    L17:
        if (r102 == 9) goto L19;
        r103 = 0;
        r104 = false;
        goto L25
    L19:
        r103 = 2;
    L22:
        r103 = 1;
        goto L24
    L23:
        r103 = 0;
        goto L24
    }

    public static void k(String r100, int r101) {
        String r102 = String.valueOf(r101);
        if (r101 != 2011) goto L5;
        String r103 = "ContextIsNull";
    L57:
        String r104 = r103;
        r.d(c4.k(), "/mobile/binary", r104, r100, "", r102);     // Catch: Throwable -> L60
        return;
    L63:
        return;
    L5:
        if (r101 != 2031) goto L7;
        r103 = "CreateApsReqException";
        goto L57
    L7:
        if (r101 != 2041) goto L9;
        r103 = "ResponseResultIsNull";
        goto L57
    L9:
        if (r101 != 2081) goto L11;
        r103 = "LocalLocException";
        goto L57
    L11:
        if (r101 != 2091) goto L13;
        r103 = "InitException";
        goto L57
    L13:
        if (r101 != 2111) goto L15;
        r103 = "ErrorCgiInfo";
        goto L57
    L15:
        if (r101 != 2121) goto L17;
        r103 = "NotLocPermission";
        goto L57
    L17:
        if (r101 != 2141) goto L19;
        r103 = "NoEnoughStatellites";
        goto L57
    L19:
        if (r101 != 2021) goto L21;
        r103 = "OnlyMainWifi";
        goto L57
    L21:
        if (r101 != 2022) goto L23;
        r103 = "OnlyOneWifiButNotMain";
        goto L57
    L23:
        if (r101 != 2061) goto L25;
        r103 = "ServerRetypeError";
        goto L57
    L25:
        if (r101 == 2062) goto L45;
        switch(r101) {
            case 2051: goto L34;
            case 2052: goto L33;
            case 2053: goto L32;
            case 2054: goto L31;
            default: goto L27;
        };
    L27:
        switch(r101) {
            case 2101: goto L37;
            case 2102: goto L36;
            case 2103: goto L35;
            default: goto L28;
        };
    L28:
        switch(r101) {
            case 2131: goto L40;
            case 2132: goto L39;
            case 2133: goto L38;
            default: goto L29;
        };
    L29:
        switch(r101) {
            case 2151: goto L44;
            case 2152: goto L43;
            case 2153: goto L42;
            case 2154: goto L41;
            default: goto L30;
        };
    L30:
        r103 = "";
        goto L57
    L41:
        r103 = "UNSUPPORT_CONTINUE_LOC";
        goto L57
    L42:
        r103 = "UNSUPPORT_COARSE_LBSLOC";
        goto L57
    L43:
        r103 = "MaybeMockGPSLoc";
        goto L57
    L44:
        r103 = "MaybeMockNetLoc";
        goto L57
    L38:
        r103 = "NoCgiAndWifiOff";
        goto L57
    L39:
        r103 = "AirPlaneModeAndWifiOff";
        goto L57
    L40:
        r103 = "NoCgiOAndWifiInfo";
        goto L57
    L35:
        r103 = "NotConfigAPSService";
        goto L57
    L36:
        r103 = "AuthClientScodeFail";
        goto L57
    L37:
        r103 = "BindAPSServiceException";
        goto L57
    L31:
        r103 = "ParserDataException";
        goto L57
    L32:
        r103 = "DecryptResponseException";
        goto L57
    L33:
        r103 = "MaybeIntercepted";
        goto L57
    L34:
        r103 = "NeedLoginNetWork\t";
        goto L57
    L45:
        r103 = "ServerLocFail";
        goto L57
    }

    public static void l(String r100, String r101) {
        e5 r102 = c4.k();     // Catch: Throwable -> L20
        Set<Integer> r103 = r.f517629e;     // Catch: Throwable -> L20
        r r104 = n.f517542c;     // Catch: Throwable -> L23
        if (r104 == null) goto L28;
        Context r105 = r104.f517630d;     // Catch: Throwable -> L23
        boolean r106 = false;
        if (r102 != null) goto L8;
    L13:
        if (r106 == true) goto L16;
        return;
    L16:
        if ("".equals(r100) == true) goto L30;
        t.b(r105, r102, 1, r100, r101);     // Catch: Throwable -> L23
        return;
    L30:
        return;
    L8:
        if (r102.f517261c != 1) goto L10;
        boolean r107 = true;
    L11:
        if (r107 == false) goto L13;
        r106 = true;
        goto L13
    L10:
        r107 = false;
        goto L11
    L28:
        return;
    L31:
        return;
    L20:
        th = move-exception;
        c4.g(th, "ReportUtil", "reportLog");
    }

    public final void c(Context r100, int r110) {
        int r101 = this.f517357b;     // Catch: Throwable -> L11
        if (r101 != r110) goto L6;
        return;
    L6:
        if (r101 == (-1)) goto L9;
        if (r101 == r110) goto L9;
        long r102 = SystemClock.elapsedRealtime() - this.f517358c;     // Catch: Throwable -> L11
        long r103 = this.f517356a.get(this.f517357b, 0L).longValue();     // Catch: Throwable -> L11
        this.f517356a.append(this.f517357b, Long.valueOf(r102 + r103));     // Catch: Throwable -> L11
    L9:
        long r104 = i4.b(r100, "pref1", this.f517359d[r110], 0);     // Catch: Throwable -> L11
        this.f517358c = SystemClock.elapsedRealtime() - r104;     // Catch: Throwable -> L11
        this.f517357b = r110;     // Catch: Throwable -> L11
        return;
    L11:
        th = move-exception;
        c4.g(th, "ReportUtil", "setLocationType");
    }

    public static void g(Context r100, AMapLocation r101, em r110) {
    L38:
        th = move-exception;
        c4.g(th, "ReportUtil", "reportBatting");
        return;
    L3:
        if (GeocodeSearch.GPS.equalsIgnoreCase(r101.getProvider()) == false) goto L5;
        return;
    L5:
        if (r101.getLocationType() == 1) goto L44;
        String r102 = "domestic";
        int r103 = 0;
        if (j4.l(r101) == false) goto L13;
        if (c4.h(r101.getLatitude(), r101.getLongitude()) == true) goto L15;
    L14:
        boolean r104 = true;
    L16:
        if (r104 == false) goto L18;
        r102 = "abroad";
    L18:
        String r105 = r102;
        String r106 = "cache";
        if (r101.getErrorCode() == 0) goto L30;
        int r107 = r101.getErrorCode();     // Catch: Throwable -> L38
        if (r107 == 4) goto L28;
        if (r107 == 5) goto L28;
        if (r107 == 6) goto L28;
        if (r107 == 11) goto L28;
    L29:
        String r108 = r106;
    L36:
        h(r100, r108, r105, r103, r101.getErrorCode(), r110);     // Catch: Throwable -> L38
        return;
    L28:
        r106 = com.alipay.sdk.m.k.b.f25406k;
        goto L29
    L30:
        int r109 = r101.getLocationType();     // Catch: Throwable -> L38
        if (r109 == 5) goto L34;
        if (r109 == 6) goto L34;
    L35:
        r108 = r106;
        r103 = 1;
    L34:
        r106 = com.alipay.sdk.m.k.b.f25406k;
    L15:
        r104 = false;
        goto L16
    L13:
        if ("http://abroad.apilocate.amap.com/mobile/binary".equals(c4.f517208c) == false) goto L15;
    }

    public static synchronized void i(Context r100, String r101, JSONObject r102) {
        monitor-enter(h4.class);
        if (r100 != null) goto L25;
    L23:
        monitor-exit(h4.class);
        return;
    L25:
    L16:
        th = move-exception;
        c4.g(th, "ReportUtil", "applyStatistics");     // Catch: Throwable -> L20
        return;
    L20:
        th = move-exception;
        throw th;
    L6:
        if (com.loc.h.f380068b == false) goto L23;
        r0 r103 = new r0(r100, "loc", "6.4.8", r101);     // Catch: Throwable -> L16
        if (r102 == null) goto L11;
        r103.a(r102.toString());     // Catch: Throwable -> L16
    L11:
        List<r0> r104 = f517352g;     // Catch: Throwable -> L16
        ((ArrayList) r104).add(r103);     // Catch: Throwable -> L16
        if (((ArrayList) r104).size() < 30) goto L14;
        ArrayList r105 = new ArrayList();     // Catch: Throwable -> L16
        r105.addAll(r104);     // Catch: Throwable -> L16
        s0.d(r105, r100);     // Catch: Throwable -> L16
        ((ArrayList) r104).clear();     // Catch: Throwable -> L16
    L14:
        monitor-exit(h4.class);
    }

    public static void e(Context r100, long r101, boolean r102, String r103) {
        int r104 = Long.valueOf(r101).intValue();
        if (r102 == true) goto L5;
        String r105 = "abroad";
    L6:
        if (r100 == null) goto L26;
    L21:
        th = move-exception;
        c4.g(th, "ReportUtil", "applyStatisticsEx");
        return;
    L8:
        if (com.loc.h.f380068b == false) goto L27;
        JSONObject r106 = new JSONObject();     // Catch: Throwable -> L21
        if (TextUtils.isEmpty(r105) == true) goto L14;
        r106.put("param_string_first", r105);     // Catch: Throwable -> L21
    L14:
        if (TextUtils.isEmpty(null) == true) goto L17;
        r106.put("param_string_second", null);     // Catch: Throwable -> L21
    L17:
        if (r104 == Integer.MAX_VALUE) goto L19;
        r106.put("param_int_first", r104);     // Catch: Throwable -> L21
    L19:
        i(r100, r103, r106);     // Catch: Throwable -> L21
        return;
    L27:
        return;
    L26:
        return;
    L5:
        r105 = "domestic";
        goto L6
    }

    public static void d(Context r100, int r101, int r102, long r103, long r104) {
        if (r100 == null) goto L14;
    L9:
        th = move-exception;
        c4.g(th, "ReportUtil", "applyStatisticsEx");
        return;
    L5:
        if (com.loc.h.f380068b == false) goto L15;
        JSONObject r105 = new JSONObject();     // Catch: Throwable -> L9
        r105.put("param_int_first", r101);     // Catch: Throwable -> L9
        r105.put("param_int_second", r102);     // Catch: Throwable -> L9
        r105.put("param_long_first", r103);     // Catch: Throwable -> L9
        r105.put("param_long_second", r104);     // Catch: Throwable -> L9
        i(r100, "O012", r105);     // Catch: Throwable -> L9
        return;
    L15:
        return;
    }

    public static void h(Context r100, String r101, String r102, int r110, int r111, em r112) {
        if (r100 == null) goto L65;
    L60:
        th = move-exception;
        c4.g(th, "ReportUtil", "applyStatisticsEx");
        return;
    L5:
        if (com.loc.h.f380068b == false) goto L66;
        JSONObject r103 = new JSONObject();     // Catch: Throwable -> L60
        if (TextUtils.isEmpty(r101) == true) goto L11;
        r103.put("param_string_first", r101);     // Catch: Throwable -> L60
    L11:
        if (TextUtils.isEmpty(r102) == true) goto L14;
        r103.put("param_string_second", r102);     // Catch: Throwable -> L60
    L14:
        if (r110 == Integer.MAX_VALUE) goto L16;
        r103.put("param_int_first", r110);     // Catch: Throwable -> L60
    L16:
        if (r111 == Integer.MAX_VALUE) goto L18;
        r103.put("param_int_second", r111);     // Catch: Throwable -> L60
    L18:
        if (r112 != null) goto L20;
    L58:
        i(r100, "O016", r103);     // Catch: Throwable -> L60
        return;
    L20:
        if (TextUtils.isEmpty(r112.f380044e) == true) goto L23;
        r103.put(MultiProcessFileUtils.KEY_DNS, r112.f380044e);     // Catch: Throwable -> L60
    L23:
        if (TextUtils.isEmpty(r112.f380045f) == true) goto L26;
        r103.put("domain", r112.f380045f);     // Catch: Throwable -> L60
    L26:
        if (TextUtils.isEmpty(r112.f380046g) == true) goto L29;
        r103.put("type", r112.f380046g);     // Catch: Throwable -> L60
    L29:
        if (TextUtils.isEmpty(r112.f380047h) == true) goto L32;
        r103.put("reason", r112.f380047h);     // Catch: Throwable -> L60
    L32:
        if (TextUtils.isEmpty(r112.f380049j) == true) goto L35;
        r103.put(DNSParser.DNS_RESULT_IP, r112.f380049j);     // Catch: Throwable -> L60
    L35:
        if (TextUtils.isEmpty(r112.f380048i) == true) goto L37;
        r103.put("stack", r112.f380048i);     // Catch: Throwable -> L60
    L37:
        long r104 = r112.f380041b;     // Catch: Throwable -> L60
        long r113 = r112.f380040a;     // Catch: Throwable -> L60
        long r105 = 0;
        if (r104 > r113) goto L40;
        long r106 = 0;
    L42:
        if (r106 > 0) goto L44;
    L48:
        long r107 = r112.f380043d;     // Catch: Throwable -> L60
        long r114 = r112.f380042c;     // Catch: Throwable -> L60
        long r108 = r107 - r114;     // Catch: Throwable -> L60
        if (r108 > 0) goto L52;
        r108 = 0;
    L52:
        if (r108 <= 0) goto L58;
        long r109 = r107 - r114;     // Catch: Throwable -> L60
        if (r109 <= 0) goto L57;
        r105 = r109;
    L57:
        r103.put("ntime", String.valueOf(r105));     // Catch: Throwable -> L60
        goto L58
    L44:
        if (r104 > r113) goto L46;
        long r115 = 0;
    L47:
        r103.put("ctime", String.valueOf(r115));     // Catch: Throwable -> L60
        goto L48
    L46:
        r115 = r104 - r113;     // Catch: Throwable -> L60
        goto L47
    L40:
        r106 = r104 - r113;     // Catch: Throwable -> L60
        goto L42
    L66:
        return;
    }
}
