package n4a;

import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.Parcelable;
import android.os.SystemClock;
import android.text.TextUtils;
import androidx.camera.video.AudioStats;
import com.amap.api.fence.GeoFence;
import com.amap.api.fence.GeoFenceListener;
import com.amap.api.location.AMapLocation;
import com.amap.api.location.AMapLocationClient;
import com.amap.api.location.AMapLocationClientOption;
import com.amap.api.location.AMapLocationListener;
import com.amap.api.location.DPoint;
import com.bytedance.helios.statichook.config.ApiHookConfig;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import com.ss.android.ugc.bytex.pthread.base.proxy.PthreadHandlerThreadV2;
import com.ss.ttvideoengine.model.VideoThumbInfo;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes32.dex */
public final class a {

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public static boolean f517103z;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public h4 f517104a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Context f517105b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public PendingIntent f517106c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public String f517107d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public GeoFenceListener f517108e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Object f517109f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public volatile int f517110g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public ArrayList<GeoFence> f517111h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public d f517112i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final Object f517113j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final Object f517114k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public b f517115l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public c f517116m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public volatile boolean f517117n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public volatile boolean f517118o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public volatile boolean f517119p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public a0 f517120q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public w0 f517121r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public AMapLocationClient f517122s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public volatile AMapLocation f517123t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public long f517124u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public AMapLocationClientOption f517125v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public int f517126w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public final C6889a f517127x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public volatile boolean f517128y;

    /* JADX INFO: renamed from: n4a.a$a, reason: collision with other inner class name */
    public class C6889a implements AMapLocationListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ a f517129a;

        public C6889a(a r100) {
            this.f517129a = r100;
        }

        @Override // com.amap.api.location.AMapLocationListener
        public final void onLocationChanged(AMapLocation r210) {
            ArrayList r110 = new ArrayList();
            Object[] r111 = {r210};
            f06.b r112 = new f06.b();
            g06.a r100 = ApiHookConfig.f245611b.get(101329);
            if (r100 == null) goto L5;
            f06.a[] r101 = r100.f479473i;
        L6:
            f06.a[] r102 = r101;
            int r103 = r102.length;
            int r104 = 0;
        L8:
            if (r104 >= r103) goto L15;
            f06.a r105 = r102[r104];
            int r113 = r104;
            int r114 = r103;
            f06.a[] r211 = r102;
            f06.d r106 = r105.preInvoke(101329, "com/loc/a$1", "onLocationChanged", this, r111, "void", r112);     // Catch: Exception -> L44
            if (r106.f474982a == true) goto L12;
            r110.add(r105);     // Catch: Exception -> L44
            goto L14
        L12:
            Bundle r107 = null;
        L17:
            if (r106.f474982a == false) goto L47;
            return;
        L47:
            if (this.f517129a.f517128y == false) goto L23;
            return;
        L23:
            if (this.f517129a.f517119p == true) goto L25;
            return;
        L25:
            this.f517129a.f517123t = r210;     // Catch: Throwable -> L43
            if (r210 == null) goto L31;
            int r108 = r210.getErrorCode();     // Catch: Throwable -> L43
            if (r210.getErrorCode() != 0) goto L30;
            this.f517129a.f517124u = SystemClock.elapsedRealtime();     // Catch: Throwable -> L43
            this.f517129a.h(5, r107, 0);     // Catch: Throwable -> L43
            boolean r115 = true;
        L33:
            if (r115 == false) goto L36;
            a r109 = this.f517129a;     // Catch: Throwable -> L43
            r109.f517126w = 0;     // Catch: Throwable -> L43
            r109.h(6, r107, 0);     // Catch: Throwable -> L43
            return;
        L36:
            Bundle r116 = new Bundle();     // Catch: Throwable -> L43
            if (this.f517129a.f517117n == true) goto L39;
            this.f517129a.r(7);     // Catch: Throwable -> L43
            r116.putLong(VideoThumbInfo.KEY_INTERVAL, 2000);     // Catch: Throwable -> L43
            this.f517129a.h(8, r116, 2000);     // Catch: Throwable -> L43
        L39:
            a r117 = this.f517129a;     // Catch: Throwable -> L43
            int r118 = r117.f517126w + 1;     // Catch: Throwable -> L43
            r117.f517126w = r118;     // Catch: Throwable -> L43
            if (r118 < 3) goto L51;
            r116.putInt(GeoFence.BUNDLE_KEY_LOCERRORCODE, r108);     // Catch: Throwable -> L43
            this.f517129a.g(1002, r116);     // Catch: Throwable -> L43
            return;
        L51:
            return;
        L30:
            a.k("定位失败", r210.getErrorCode(), r210.getErrorInfo(), new String[]{"locationDetail:" + r210.getLocationDetail()});     // Catch: Throwable -> L43
        L32:
            r115 = false;
            goto L33
        L31:
            r108 = 8;
            goto L32
        L52:
            return;
        L14:
            r104 = r113 + 1;
            r103 = r114;
            r102 = r211;
            goto L8
        L15:
            r107 = null;
            r106 = new f06.d(false, null);
            goto L17
        L5:
            r101 = ApiHookConfig.f245613d;
            goto L6
        }
    }

    public class b extends Handler {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ a f517130a;

        public b(a r100, Looper r101) {
            this.f517130a = r100;
            super(r101);
        }

        @Override // android.os.Handler
        public final void handleMessage(Message r100) {
            switch(r100.what) {
                case 0: goto L39;
                case 1: goto L37;
                case 2: goto L35;
                case 3: goto L33;
                case 4: goto L31;
                case 5: goto L29;
                case 6: goto L27;
                case 7: goto L25;
                case 8: goto L23;
                case 9: goto L21;
                case 10: goto L19;
                case 11: goto L8;
                case 12: goto L6;
                case 13: goto L5;
                default: goto L48;
            };     // Catch: Throwable -> L42
        L5:
            this.f517130a.C();     // Catch: Throwable -> L42
            return;
        L6:
            this.f517130a.D(r100.getData());     // Catch: Throwable -> L42
            return;
        L8:
            a r101 = this.f517130a;     // Catch: Throwable -> L42
            Bundle r102 = r100.getData();     // Catch: Throwable -> L42
            r101.getClass();     // Catch: Throwable -> L42
            if (r101.f517111h == null) goto L45;
            GeoFence r103 = (GeoFence) r102.getParcelable("fc");     // Catch: Throwable -> L41
            if (r101.f517111h.contains(r103) == false) goto L15;
            r101.f517111h.remove(r103);     // Catch: Throwable -> L41
        L15:
            if (r101.f517111h.size() > 0) goto L17;
            r101.x();     // Catch: Throwable -> L41
            return;
        L17:
            r101.J();     // Catch: Throwable -> L41
            return;
        L45:
            return;
        L47:
            return;
        L19:
            this.f517130a.x();     // Catch: Throwable -> L42
            return;
        L21:
            this.f517130a.i(r100.getData());     // Catch: Throwable -> L42
            return;
        L23:
            this.f517130a.G(r100.getData());     // Catch: Throwable -> L42
            return;
        L25:
            this.f517130a.A();     // Catch: Throwable -> L42
            return;
        L27:
            a r104 = this.f517130a;     // Catch: Throwable -> L42
            r104.j(r104.f517123t);     // Catch: Throwable -> L42
            return;
        L29:
            this.f517130a.B();     // Catch: Throwable -> L42
            return;
        L31:
            this.f517130a.s(3, r100.getData());     // Catch: Throwable -> L42
            return;
        L33:
            this.f517130a.s(2, r100.getData());     // Catch: Throwable -> L42
            return;
        L35:
            this.f517130a.s(1, r100.getData());     // Catch: Throwable -> L42
            return;
        L37:
            this.f517130a.z(r100.getData());     // Catch: Throwable -> L42
            return;
        L39:
            this.f517130a.t(r100.getData());     // Catch: Throwable -> L42
            return;
        L48:
            return;
        }
    }

    public static class c extends PthreadHandlerThreadV2 {
        public c() {
            super("fenceActionThread");
        }

        @Override // com.ss.android.ugc.bytex.pthread.base.proxy.PthreadHandlerThreadV2, android.os.HandlerThread, java.lang.Thread, java.lang.Runnable
        public final void run() {
            super.run();     // Catch: Throwable -> L4
            return;
        }
    }

    public class d extends Handler {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ a f517131a;

        public d(a r100) {
            this.f517131a = r100;
        }

        public d(a r100, Looper r101) {
            this.f517131a = r100;
            super(r101);
        }

        @Override // android.os.Handler
        public final void handleMessage(Message r100) {
            Bundle r101 = r100.getData();     // Catch: Throwable -> L17
            switch(r100.what) {
                case 1000: goto L15;
                case 1001: goto L21;
                case 1002: goto L19;
                default: goto L23;
            };
        L15:
            this.f517131a.E(r101);     // Catch: Throwable -> L17
            return;
        L19:
            int r102 = r101.getInt(GeoFence.BUNDLE_KEY_LOCERRORCODE);     // Catch: Throwable -> L7
            this.f517131a.y(r102);     // Catch: Throwable -> L7
            return;
        L7:
            th = move-exception;
            th.printStackTrace();     // Catch: Throwable -> L17
            return;
        L21:
            GeoFence r103 = (GeoFence) r101.getParcelable("geoFence");     // Catch: Throwable -> L12
            this.f517131a.u(r103);     // Catch: Throwable -> L12
            return;
        L12:
            th = move-exception;
            th.printStackTrace();     // Catch: Throwable -> L17
            return;
        L23:
            return;
        }
    }

    public a(Context r100) {
        this.f517104a = null;
        this.f517105b = null;
        this.f517106c = null;
        this.f517107d = null;
        this.f517108e = null;
        this.f517109f = new Object();
        this.f517110g = 1;
        this.f517111h = new ArrayList();
        this.f517112i = null;
        this.f517113j = new Object();
        this.f517114k = new Object();
        this.f517115l = null;
        this.f517116m = null;
        this.f517117n = false;
        this.f517118o = false;
        this.f517119p = false;
        this.f517120q = null;
        this.f517121r = null;
        this.f517122s = null;
        this.f517123t = null;
        this.f517124u = 0;
        this.f517125v = null;
        this.f517126w = 0;
        this.f517127x = new C6889a(this);
        this.f517128y = false;
        this.f517105b = r100.getApplicationContext();     // Catch: Throwable -> L5
        F();     // Catch: Throwable -> L5
        return;
    L5:
        th = move-exception;
        c4.g(th, "GeoFenceManger", "<init>");
    }

    public static float a(AMapLocation r100, List<GeoFence> r101) {
        float r102 = Float.MAX_VALUE;
        if (r100 != null) goto L5;
    L26:
        return r102;
    L5:
        if (r100.getErrorCode() != 0) goto L26;
        if (r101 == null) goto L26;
        ArrayList r103 = (ArrayList) r101;
        if (r103.isEmpty() == true) goto L26;
        DPoint r104 = new DPoint(r100.getLatitude(), r100.getLongitude());
        Iterator r105 = r103.iterator();
    L11:
        if (r105.hasNext() == false) goto L26;
        GeoFence r106 = (GeoFence) r105.next();
        if (r106.isAble() == false) goto L11;
        float r107 = j4.b(r104, r106.getCenter());
        if (r107 <= r106.getMinDis2Center()) goto L21;
        if (r107 >= r106.getMaxDis2Center()) goto L21;
        return 0.0f;
    L21:
        if (r107 <= r106.getMaxDis2Center()) goto L24;
        r102 = Math.min(r102, r107 - r106.getMaxDis2Center());
    L24:
        if (r107 >= r106.getMinDis2Center()) goto L11;
        r102 = Math.min(r102, r106.getMinDis2Center() - r107);
        goto L11
    }

    public static float b(DPoint r100, List<DPoint> r101) {
        float r102 = Float.MAX_VALUE;
        if (r101 != null) goto L5;
    L10:
        return r102;
    L5:
        if (r101.isEmpty() == true) goto L10;
        Iterator<DPoint> r103 = r101.iterator();
    L8:
        if (r103.hasNext() == false) goto L10;
        r102 = Math.min(r102, j4.b(r100, r103.next()));
        goto L8
    }

    public static Bundle e(GeoFence r100, String r101, String r102, int r103, int r104) {
        Bundle r105 = new Bundle();
        if (r101 != null) goto L5;
        r101 = "";
    L5:
        r105.putString(GeoFence.BUNDLE_KEY_FENCEID, r101);
        r105.putString(GeoFence.BUNDLE_KEY_CUSTOMID, r102);
        r105.putInt("event", r103);
        r105.putInt(GeoFence.BUNDLE_KEY_LOCERRORCODE, r104);
        r105.putParcelable(GeoFence.BUNDLE_KEY_FENCE, r100);
        return r105;
    }

    public static void k(String r100, int r101, String r102, String... r103) {
        StringBuffer r104 = new StringBuffer("===========================================\n");
        r104.append("              " + r100 + "                ");
        r104.append("\n-------------------------------------------\n");
        r104.append("errorCode:".concat(String.valueOf(r101)));
        r104.append("\n");
        r104.append("错误信息:".concat(String.valueOf(r102)));
        r104.append("\n");
        if (r103.length <= 0) goto L7;
        int r105 = r103.length;
        int r106 = 0;
    L5:
        if (r106 >= r105) goto L7;
        r104.append(r103[r106]);
        r104.append("\n");
        r106 = r106 + 1;
    L7:
        r104.append("===========================================\n");
    }

    public static boolean n(int r100, String r101, String r102, DPoint r103) {
        if (TextUtils.isEmpty(r101) == false) goto L6;
        return false;
    L6:
        if (r100 == 1) goto L22;
        if (r100 != 2) goto L24;
        if (r103 != null) goto L13;
        return false;
    L13:
        if (r103.getLatitude() <= 90.0d) goto L15;
    L20:
        k("添加围栏失败", 0, "经纬度错误，传入的纬度：" + r103.getLatitude() + "传入的经度:" + r103.getLongitude(), new String[0]);
        return false;
    L15:
        if (r103.getLatitude() < (-90.0d)) goto L20;
        if (r103.getLongitude() > 180.0d) goto L20;
        if (r103.getLongitude() < (-180.0d)) goto L20;
    L24:
        return true;
    L22:
        if (TextUtils.isEmpty(r102) == false) goto L24;
        return false;
    }

    public static float q(DPoint r100, List<DPoint> r101) {
        float r102 = Float.MIN_VALUE;
        if (r101 != null) goto L5;
    L10:
        return r102;
    L5:
        if (r101.isEmpty() == true) goto L10;
        Iterator<DPoint> r103 = r101.iterator();
    L8:
        if (r103.hasNext() == false) goto L10;
        r102 = Math.max(r102, j4.b(r100, r103.next()));
        goto L8
    }

    public final void A() {
    L6:
        th = move-exception;
        c4.g(th, "GeoFenceManager", "doStartOnceLocation");
        return;
    L3:
        if (this.f517122s == null) goto L11;
        K();     // Catch: Throwable -> L6
        this.f517125v.setLocationCacheEnable(true);     // Catch: Throwable -> L6
        this.f517125v.setNeedAddress(false);     // Catch: Throwable -> L6
        this.f517125v.setOnceLocation(true);     // Catch: Throwable -> L6
        this.f517122s.setLocationOption(this.f517125v);     // Catch: Throwable -> L6
        this.f517122s.startLocation();     // Catch: Throwable -> L6
        return;
    }

    public final void B() {
    L21:
        th = move-exception;
        c4.g(th, "GeoFenceManager", "doCheckLocationPolicy");
        return;
    L3:
        if (this.f517128y == false) goto L6;
        return;
    L6:
        if (j4.l(this.f517123t) == true) goto L8;
        return;
    L8:
        float r100 = a(this.f517123t, this.f517111h);     // Catch: Throwable -> L21
        if (r100 != Float.MAX_VALUE) goto L12;
        return;
    L12:
        if (r100 >= 1000.0f) goto L16;
        r(7);     // Catch: Throwable -> L21
        Bundle r101 = new Bundle();     // Catch: Throwable -> L21
        r101.putLong(VideoThumbInfo.KEY_INTERVAL, 2000);     // Catch: Throwable -> L21
        h(8, r101, 500);     // Catch: Throwable -> L21
        return;
    L16:
        if (r100 >= 5000.0f) goto L19;
        K();     // Catch: Throwable -> L21
        r(7);     // Catch: Throwable -> L21
        h(7, null, 10000);     // Catch: Throwable -> L21
        return;
    L19:
        K();     // Catch: Throwable -> L21
        r(7);     // Catch: Throwable -> L21
        h(7, null, (long) (((r100 - 4000.0f) / 100.0f) * 1000.0f));     // Catch: Throwable -> L21
    }

    public final void C() {
        r(7);     // Catch: Throwable -> L8
        r(8);     // Catch: Throwable -> L8
        AMapLocationClient r100 = this.f517122s;     // Catch: Throwable -> L8
        if (r100 == null) goto L6;
        r100.stopLocation();     // Catch: Throwable -> L8
    L6:
        this.f517117n = false;     // Catch: Throwable -> L8
        return;
    L8:
        th = move-exception;
        c4.g(th, "GeoFenceManager", "doPauseGeoFence");
    }

    public final void E(Bundle r100) {
        if (r100 == null) goto L22;
    L17:
        th = move-exception;
        c4.g(th, "GeoFenceManager", "resultAddGeoFenceFinished");
        return;
    L4:
        if (r100.isEmpty() == true) goto L23;
        int r101 = r100.getInt("errorCode");     // Catch: Throwable -> L17
        ArrayList r102 = r100.getParcelableArrayList("resultList");     // Catch: Throwable -> L17
        if (r102 != null) goto L8;
        r102 = new ArrayList();     // Catch: Throwable -> L17
    L8:
        String r103 = r100.getString(GeoFence.BUNDLE_KEY_CUSTOMID);     // Catch: Throwable -> L17
        if (r103 != null) goto L11;
        r103 = "";
    L11:
        GeoFenceListener r104 = this.f517108e;     // Catch: Throwable -> L17
        if (r104 == null) goto L14;
        r104.onGeoFenceCreateFinished((ArrayList) r102.clone(), r101, r103);     // Catch: Throwable -> L17
    L14:
        if (r101 != 0) goto L24;
        J();     // Catch: Throwable -> L17
        return;
    L24:
        return;
    L23:
        return;
    }

    public final void F() {
        if (this.f517119p == true) goto L6;
        this.f517119p = true;
    L6:
        if (this.f517118o == false) goto L43;
        return;
    L43:
    L14:
        th = move-exception;
        c4.g(th, "GeoFenceManger", "init 1");
    L45:
        c r100 = new c();     // Catch: Throwable -> L18
        this.f517116m = r100;     // Catch: Throwable -> L18
        ThreadMethodProxy.setPriority(r100, 5);     // Catch: Throwable -> L18
        ThreadMethodProxy.start(this.f517116m);     // Catch: Throwable -> L18
        this.f517115l = new b(this, this.f517116m.getLooper());     // Catch: Throwable -> L18
    L39:
        this.f517120q = new a0(this.f517105b);     // Catch: Throwable -> L24
        this.f517121r = new w0();     // Catch: Throwable -> L24
        this.f517125v = new AMapLocationClientOption();     // Catch: Throwable -> L24
        AMapLocationClient r101 = new AMapLocationClient(this.f517105b);     // Catch: Throwable -> L24
        this.f517122s = r101;     // Catch: Throwable -> L24
        r101.setLocationListener(this.f517127x);     // Catch: Throwable -> L24
        if (this.f517104a != null) goto L26;
        this.f517104a = new h4();     // Catch: Throwable -> L24
    L26:
        this.f517118o = true;
        String r102 = this.f517107d;     // Catch: Throwable -> L33
        if (r102 == null) goto L36;
        if (this.f517106c != null) goto L36;
        d(r102);     // Catch: Throwable -> L33
    L36:
        if (f517103z == true) goto L47;
        f517103z = true;
        h4.i(this.f517105b, "O020", null);
        return;
    L47:
        return;
    L33:
        th = move-exception;
        c4.g(th, "GeoFenceManger", "init 4");
    L24:
        th = move-exception;
        c4.g(th, "GeoFenceManger", "initBase");
    L18:
        th = move-exception;
        c4.g(th, "GeoFenceManger", "init 2");
        goto L39
    L9:
        if (Looper.myLooper() != null) goto L11;
        d r103 = new d(this, this.f517105b.getMainLooper());     // Catch: Throwable -> L14
    L12:
        this.f517112i = r103;     // Catch: Throwable -> L14
        goto L45
    L11:
        r103 = new d(this);     // Catch: Throwable -> L14
        goto L12
    }

    public final void G(Bundle r100) {
    L13:
        th = move-exception;
        c4.g(th, "GeoFenceManager", "doStartContinueLocation");
        return;
    L3:
        if (this.f517122s == null) goto L18;
        long r101 = 2000;
        if (r100 != null) goto L7;
    L9:
        this.f517125v.setOnceLocation(false);     // Catch: Throwable -> L13
        this.f517125v.setInterval(r101);     // Catch: Throwable -> L13
        this.f517125v.setLocationCacheEnable(true);     // Catch: Throwable -> L13
        this.f517125v.setNeedAddress(false);     // Catch: Throwable -> L13
        this.f517122s.setLocationOption(this.f517125v);     // Catch: Throwable -> L13
        if (this.f517117n == true) goto L19;
        this.f517122s.stopLocation();     // Catch: Throwable -> L13
        this.f517122s.startLocation();     // Catch: Throwable -> L13
        this.f517117n = true;     // Catch: Throwable -> L13
        return;
    L19:
        return;
    L7:
        if (r100.isEmpty() == true) goto L9;
        r101 = r100.getLong(VideoThumbInfo.KEY_INTERVAL, 2000);     // Catch: Throwable -> L13
        goto L9
    }

    public final void H() {
        Object r100 = this.f517114k;     // Catch: Throwable -> L13
        monitor-enter(r100);     // Catch: Throwable -> L13
        d r101 = this.f517112i;     // Catch: Throwable -> L10
        if (r101 == null) goto L7;
        r101.removeCallbacksAndMessages(null);     // Catch: Throwable -> L10
    L7:
        this.f517112i = null;     // Catch: Throwable -> L10
        monitor-exit(r100);     // Catch: Throwable -> L10
        return;
    L10:
        th = move-exception;
        throw th;     // Catch: Throwable -> L13
    L13:
        th = move-exception;
        c4.g(th, "GeoFenceManager", "destroyResultHandler");
    }

    public final void I() {
        Object r100 = this.f517113j;     // Catch: Throwable -> L13
        monitor-enter(r100);     // Catch: Throwable -> L13
        b r101 = this.f517115l;     // Catch: Throwable -> L10
        if (r101 == null) goto L7;
        r101.removeCallbacksAndMessages(null);     // Catch: Throwable -> L10
    L7:
        this.f517115l = null;     // Catch: Throwable -> L10
        monitor-exit(r100);     // Catch: Throwable -> L10
        return;
    L10:
        th = move-exception;
        throw th;     // Catch: Throwable -> L13
    L13:
        th = move-exception;
        c4.g(th, "GeoFenceManager", "destroyActionHandler");
    }

    public final void K() {
        if (this.f517117n == false) goto L5;
        r(8);     // Catch: Throwable -> L10
    L5:
        AMapLocationClient r100 = this.f517122s;     // Catch: Throwable -> L10
        if (r100 == null) goto L8;
        r100.stopLocation();     // Catch: Throwable -> L10
    L8:
        this.f517117n = false;     // Catch: Throwable -> L10
        return;
    }

    public final int c(List<GeoFence> r100) {
    L11:
        th = move-exception;
        c4.g(th, "GeoFenceManager", "addGeoFenceList");
        k("添加围栏失败", 8, th.getMessage(), new String[0]);
        return 8;
    L4:
        if (this.f517111h != null) goto L6;
        this.f517111h = new ArrayList();     // Catch: Throwable -> L11
    L6:
        Iterator r101 = ((ArrayList) r100).iterator();     // Catch: Throwable -> L11
    L7:
        if (r101.hasNext() == false) goto L17;
        w((GeoFence) r101.next());     // Catch: Throwable -> L11
        goto L7
    L17:
        return 0;
    }

    public final PendingIntent d(String r100) {
        Object r101 = this.f517109f;
        monitor-enter(r101);
        Intent r102 = new Intent(r100);     // Catch: Throwable -> L20
        r102.setPackage(v4.d(this.f517105b));     // Catch: Throwable -> L20
        if (Build.VERSION.SDK_INT >= 31) goto L7;
    L10:
        PendingIntent r103 = PendingIntent.getBroadcast(this.f517105b, 0, r102, 0);     // Catch: Throwable -> L20
    L9:
        this.f517106c = r103;     // Catch: Throwable -> L20
        this.f517107d = r100;     // Catch: Throwable -> L20
        ArrayList<GeoFence> r104 = this.f517111h;     // Catch: Throwable -> L20
        if (r104 != null) goto L14;
    L22:
        monitor-exit(r101);     // Catch: Throwable -> L25
        return this.f517106c;
    L14:
        if (r104.isEmpty() == true) goto L22;
        Iterator<GeoFence> r105 = this.f517111h.iterator();     // Catch: Throwable -> L20
    L16:
        if (r105.hasNext() == false) goto L22;
        GeoFence r106 = r105.next();     // Catch: Throwable -> L20
        r106.setPendingIntent(this.f517106c);     // Catch: Throwable -> L20
        r106.setPendingIntentAction(this.f517107d);     // Catch: Throwable -> L20
        goto L16
    L7:
        if (this.f517105b.getApplicationInfo().targetSdkVersion < 31) goto L10;
        r103 = PendingIntent.getBroadcast(this.f517105b, 0, r102, 33554432);     // Catch: Throwable -> L20
    L25:
        th = move-exception;
        throw th;
    L20:
        th = move-exception;
        c4.g(th, "GeoFenceManager", "createPendingIntent");     // Catch: Throwable -> L25
        goto L22
    }

    public final void g(int r100, Bundle r101) {
        Object r102 = this.f517114k;     // Catch: Throwable -> L12
        monitor-enter(r102);     // Catch: Throwable -> L12
        d r103 = this.f517112i;     // Catch: Throwable -> L9
        if (r103 == null) goto L7;
        Message r104 = r103.obtainMessage();     // Catch: Throwable -> L9
        r104.what = r100;     // Catch: Throwable -> L9
        r104.setData(r101);     // Catch: Throwable -> L9
        this.f517112i.sendMessage(r104);     // Catch: Throwable -> L9
    L7:
        monitor-exit(r102);     // Catch: Throwable -> L9
        return;
    L9:
        th = move-exception;
        throw th;     // Catch: Throwable -> L12
    L12:
        th = move-exception;
        c4.g(th, "GeoFenceManager", "sendResultHandlerMessage");
    }

    public final void h(int r100, Bundle r101, long r102) {
        Object r103 = this.f517113j;     // Catch: Throwable -> L12
        monitor-enter(r103);     // Catch: Throwable -> L12
        b r104 = this.f517115l;     // Catch: Throwable -> L9
        if (r104 == null) goto L7;
        Message r105 = r104.obtainMessage();     // Catch: Throwable -> L9
        r105.what = r100;     // Catch: Throwable -> L9
        r105.setData(r101);     // Catch: Throwable -> L9
        this.f517115l.sendMessageDelayed(r105, r102);     // Catch: Throwable -> L9
    L7:
        monitor-exit(r103);     // Catch: Throwable -> L9
        return;
    L9:
        th = move-exception;
        throw th;     // Catch: Throwable -> L12
    L12:
        th = move-exception;
        c4.g(th, "GeoFenceManager", "sendActionHandlerMessage");
    }

    public final void i(Bundle r100) {
        int r101 = 1;
        if (r100 == null) goto L6;
        r101 = r100.getInt("activatesAction", 1);     // Catch: Throwable -> L18
    L18:
        th = move-exception;
        c4.g(th, "GeoFenceManager", "doSetActivatesAction");
        return;
    L6:
        if (this.f517110g == r101) goto L16;
        ArrayList<GeoFence> r102 = this.f517111h;     // Catch: Throwable -> L18
        if (r102 != null) goto L10;
    L15:
        J();     // Catch: Throwable -> L18
        goto L16
    L10:
        if (r102.isEmpty() == true) goto L15;
        Iterator<GeoFence> r103 = this.f517111h.iterator();     // Catch: Throwable -> L18
    L13:
        if (r103.hasNext() == false) goto L15;
        GeoFence r104 = r103.next();     // Catch: Throwable -> L18
        r104.setStatus(0);     // Catch: Throwable -> L18
        r104.setEnterTime(-1);     // Catch: Throwable -> L18
    L16:
        this.f517110g = r101;     // Catch: Throwable -> L18
    }

    public final void l(String r100, String r101, DPoint r102, float r103, int r104, String r105) {
        F();     // Catch: Throwable -> L14
        if (r103 > 0.0f) goto L5;
    L6:
        r103 = 3000.0f;
    L7:
        if (r104 > 0) goto L10;
        r104 = 10;
    L10:
        if (r104 <= 25) goto L12;
        r104 = 25;
    L12:
        Bundle r106 = new Bundle();     // Catch: Throwable -> L14
        r106.putString("keyWords", r100);     // Catch: Throwable -> L14
        r106.putString("poiType", r101);     // Catch: Throwable -> L14
        r106.putParcelable("centerPoint", r102);     // Catch: Throwable -> L14
        r106.putFloat("aroundRadius", r103);     // Catch: Throwable -> L14
        r106.putInt("searchSize", r104);     // Catch: Throwable -> L14
        r106.putString(GeoFence.BUNDLE_KEY_CUSTOMID, r105);     // Catch: Throwable -> L14
        h(3, r106, 0);     // Catch: Throwable -> L14
        return;
    L5:
        if (r103 <= 50000.0f) goto L7;
    L14:
        th = move-exception;
        c4.g(th, "GeoFenceManager", "addNearbyGeoFence");
    }

    public final void m(String r100, String r101, String r102, int r103, String r104) {
        F();     // Catch: Throwable -> L10
        if (r103 > 0) goto L6;
        r103 = 10;
    L6:
        if (r103 <= 25) goto L8;
        r103 = 25;
    L8:
        Bundle r105 = new Bundle();     // Catch: Throwable -> L10
        r105.putString("keyWords", r100);     // Catch: Throwable -> L10
        r105.putString("poiType", r101);     // Catch: Throwable -> L10
        r105.putString("city", r102);     // Catch: Throwable -> L10
        r105.putInt("searchSize", r103);     // Catch: Throwable -> L10
        r105.putString(GeoFence.BUNDLE_KEY_CUSTOMID, r104);     // Catch: Throwable -> L10
        h(2, r105, 0);     // Catch: Throwable -> L10
        return;
    L10:
        th = move-exception;
        c4.g(th, "GeoFenceManager", "addKeywordGeoFence");
    }

    public final boolean o(GeoFence r100) {
        ArrayList<GeoFence> r101 = this.f517111h;     // Catch: Throwable -> L18
        if (r101 != null) goto L6;
    L16:
        this.f517119p = false;     // Catch: Throwable -> L18
        h(10, null, 0);     // Catch: Throwable -> L18
        return true;
    L6:
        if (r101.isEmpty() == true) goto L16;
        if (this.f517111h.contains(r100) == true) goto L11;
        return false;
    L11:
        if (this.f517111h.size() != 1) goto L13;
        this.f517119p = false;     // Catch: Throwable -> L18
    L13:
        Bundle r102 = new Bundle();     // Catch: Throwable -> L18
        r102.putParcelable("fc", r100);     // Catch: Throwable -> L18
        h(11, r102, 0);     // Catch: Throwable -> L18
        return true;
    L18:
        th = move-exception;
        c4.g(th, "GeoFenceManager", "removeGeoFence(GeoFence)");
        return false;
    }

    public final void r(int r100) {
        Object r101 = this.f517113j;     // Catch: Throwable -> L12
        monitor-enter(r101);     // Catch: Throwable -> L12
        b r102 = this.f517115l;     // Catch: Throwable -> L9
        if (r102 == null) goto L7;
        r102.removeMessages(r100);     // Catch: Throwable -> L9
    L7:
        monitor-exit(r101);     // Catch: Throwable -> L9
        return;
    L9:
        th = move-exception;
        throw th;     // Catch: Throwable -> L12
    L12:
        th = move-exception;
        c4.g(th, "GeoFenceManager", "removeActionHandlerMessage");
    }

    public final void t(Bundle r110) {
        ArrayList<? extends Parcelable> r100 = new ArrayList();     // Catch: Throwable -> L26
        String r101 = "";
        int r102 = 1;
        if (r110 != null) goto L6;
    L23:
        String r103 = r101;
    L24:
        Bundle r111 = new Bundle();     // Catch: Throwable -> L26
        r111.putInt("errorCode", r102);     // Catch: Throwable -> L26
        r111.putParcelableArrayList("resultList", r100);     // Catch: Throwable -> L26
        r111.putString(GeoFence.BUNDLE_KEY_CUSTOMID, r103);     // Catch: Throwable -> L26
        g(1000, r111);     // Catch: Throwable -> L26
        return;
    L6:
        if (r110.isEmpty() == true) goto L23;
        DPoint r104 = (DPoint) r110.getParcelable("centerPoint");     // Catch: Throwable -> L26
        r103 = r110.getString(GeoFence.BUNDLE_KEY_CUSTOMID);     // Catch: Throwable -> L26
        if (r104 != null) goto L10;
        r101 = r103;
        goto L23
    L10:
        if (r104.getLatitude() <= 90.0d) goto L12;
    L21:
        k("添加围栏失败", 1, "经纬度错误，传入的纬度：" + r104.getLatitude() + "传入的经度:" + r104.getLongitude(), new String[0]);     // Catch: Throwable -> L26
        goto L24
    L12:
        if (r104.getLatitude() < (-90.0d)) goto L21;
        if (r104.getLongitude() > 180.0d) goto L21;
        if (r104.getLongitude() < (-180.0d)) goto L21;
        GeoFence r112 = f(r110, false);     // Catch: Throwable -> L26
        r102 = w(r112);     // Catch: Throwable -> L26
        if (r102 != 0) goto L24;
        r100.add(r112);     // Catch: Throwable -> L26
    L26:
        th = move-exception;
        c4.g(th, "GeoFenceManager", "doAddGeoFenceRound");
    }

    public final void u(GeoFence r100) {
        Object r101 = this.f517109f;     // Catch: Throwable -> L25
        monitor-enter(r101);     // Catch: Throwable -> L25
    L22:
        th = move-exception;
        throw th;     // Catch: Throwable -> L25
    L5:
        if (this.f517105b != null) goto L7;
    L20:
        monitor-exit(r101);     // Catch: Throwable -> L22
        return;
    L7:
        if (this.f517106c == null) goto L9;
    L12:
        Intent r102 = new Intent();     // Catch: Throwable -> L22
        r102.putExtras(e(r100, r100.getFenceId(), r100.getCustomId(), r100.getStatus(), 0));     // Catch: Throwable -> L22
        String r103 = this.f517107d;     // Catch: Throwable -> L22
        if (r103 == null) goto L15;
        r102.setAction(r103);     // Catch: Throwable -> L22
    L15:
        r102.setPackage(v4.d(this.f517105b));     // Catch: Throwable -> L22
        if (r100.getPendingIntent() == null) goto L19;
        PendingIntent r104 = r100.getPendingIntent();     // Catch: Throwable -> L22
        Context r105 = this.f517105b;     // Catch: Throwable -> L22
    L18:
        r104.send(r105, 0, r102);     // Catch: Throwable -> L22
        goto L20
    L19:
        r104 = this.f517106c;     // Catch: Throwable -> L22
        r105 = this.f517105b;     // Catch: Throwable -> L22
        goto L18
    L9:
        if (r100.getPendingIntent() != null) goto L12;
        monitor-exit(r101);     // Catch: Throwable -> L22
        return;
    L25:
        th = move-exception;
        c4.g(th, "GeoFenceManager", "resultTriggerGeoFence");
    }

    public final int w(GeoFence r100) {
    L11:
        th = move-exception;
        c4.g(th, "GeoFenceManager", "addGeoFence2List");
        k("添加围栏失败", 8, th.getMessage(), new String[0]);
        return 8;
    L4:
        if (this.f517111h != null) goto L7;
        this.f517111h = new ArrayList();     // Catch: Throwable -> L11
    L7:
        if (this.f517111h.contains(r100) == true) goto L10;
        this.f517111h.add(r100);     // Catch: Throwable -> L11
        return 0;
    L10:
        return 17;
    }

    public final void x() {
        if (this.f517118o == true) goto L5;
        return;
    L5:
        ArrayList<GeoFence> r100 = this.f517111h;     // Catch: Throwable -> L33
        if (r100 == null) goto L9;
        r100.clear();     // Catch: Throwable -> L33
        this.f517111h = null;     // Catch: Throwable -> L33
    L9:
        if (this.f517119p == false) goto L11;
        return;
    L11:
        I();     // Catch: Throwable -> L33
        AMapLocationClient r101 = this.f517122s;     // Catch: Throwable -> L33
        if (r101 == null) goto L14;
        r101.stopLocation();     // Catch: Throwable -> L33
        this.f517122s.onDestroy();     // Catch: Throwable -> L33
    L14:
        this.f517122s = null;     // Catch: Throwable -> L33
        c r102 = this.f517116m;     // Catch: Throwable -> L33
        if (r102 == null) goto L17;
        r102.quitSafely();     // Catch: Throwable -> L33
    L17:
        this.f517116m = null;     // Catch: Throwable -> L33
        this.f517120q = null;     // Catch: Throwable -> L33
        Object r103 = this.f517109f;     // Catch: Throwable -> L33
        monitor-enter(r103);     // Catch: Throwable -> L33
        PendingIntent r104 = this.f517106c;     // Catch: Throwable -> L28
        if (r104 == null) goto L22;
        r104.cancel();     // Catch: Throwable -> L28
    L22:
        this.f517106c = null;     // Catch: Throwable -> L28
        monitor-exit(r103);     // Catch: Throwable -> L28
        H();     // Catch: Throwable -> L33
        h4 r105 = this.f517104a;     // Catch: Throwable -> L33
        if (r105 == null) goto L31;
        r105.m(this.f517105b);     // Catch: Throwable -> L33
        goto L31
    L28:
        th = move-exception;
        throw th;     // Catch: Throwable -> L33
    L31:
        this.f517117n = false;
        this.f517118o = false;
    }

    public final void y(int r100) {
    L17:
        th = move-exception;
        c4.g(th, "GeoFenceManager", "resultRemindLocationError");
        return;
    L3:
        if (this.f517105b == null) goto L16;
        Object r101 = this.f517109f;     // Catch: Throwable -> L17
        monitor-enter(r101);     // Catch: Throwable -> L17
    L13:
        th = move-exception;
        throw th;     // Catch: Throwable -> L17
    L7:
        if (this.f517106c != null) goto L10;
        monitor-exit(r101);     // Catch: Throwable -> L13
        return;
    L10:
        Intent r102 = new Intent();     // Catch: Throwable -> L13
        r102.putExtras(e(null, null, null, 4, r100));     // Catch: Throwable -> L13
        this.f517106c.send(this.f517105b, 0, r102);     // Catch: Throwable -> L13
        monitor-exit(r101);     // Catch: Throwable -> L13
        return;
    }

    public final void z(Bundle r100) {
        ArrayList<? extends Parcelable> r101 = new ArrayList();     // Catch: Throwable -> L19
        String r102 = "";
        int r103 = 1;
        if (r100 != null) goto L6;
    L17:
        Bundle r104 = new Bundle();     // Catch: Throwable -> L19
        r104.putString(GeoFence.BUNDLE_KEY_CUSTOMID, r102);     // Catch: Throwable -> L19
        r104.putInt("errorCode", r103);     // Catch: Throwable -> L19
        r104.putParcelableArrayList("resultList", r101);     // Catch: Throwable -> L19
        g(1000, r104);     // Catch: Throwable -> L19
        return;
    L6:
        if (r100.isEmpty() == true) goto L17;
        ArrayList r105 = r100.getParcelableArrayList("pointList");     // Catch: Throwable -> L19
        String r106 = r100.getString(GeoFence.BUNDLE_KEY_CUSTOMID);     // Catch: Throwable -> L19
        if (r105 != null) goto L10;
    L16:
        r102 = r106;
        goto L17
    L10:
        if (r105.size() <= 2) goto L16;
        GeoFence r107 = f(r100, true);     // Catch: Throwable -> L19
        int r108 = w(r107);     // Catch: Throwable -> L19
        if (r108 != 0) goto L15;
        r101.add(r107);     // Catch: Throwable -> L19
    L15:
        r103 = r108;
    L19:
        th = move-exception;
        c4.g(th, "GeoFenceManager", "doAddGeoFencePolygon");
    }

    public final void J() {
        if (this.f517128y == false) goto L6;
        return;
    L6:
        if (this.f517115l != null) goto L8;
        return;
    L8:
        if (this.f517123t != null) goto L10;
    L14:
        boolean r100 = false;
    L16:
        if (r100 == false) goto L19;
        h(6, null, 0);
        h(5, null, 0);
        return;
    L19:
        r(7);
        h(7, null, 0);
        return;
    L10:
        if (j4.l(this.f517123t) == false) goto L14;
        if ((SystemClock.elapsedRealtime() - this.f517124u) >= 10000) goto L14;
        r100 = true;
        goto L16
    }

    public final void D(Bundle r100) {
        if (r100 == null) goto L47;
    L36:
        th = move-exception;
        c4.g(th, "GeoFenceManager", "doSetGeoFenceAble");
        return;
    L4:
        if (r100.isEmpty() == true) goto L48;
        String r101 = r100.getString("fid");     // Catch: Throwable -> L36
        if (TextUtils.isEmpty(r101) == false) goto L9;
        return;
    L9:
        boolean r102 = true;
        boolean r103 = r100.getBoolean("ab", true);     // Catch: Throwable -> L36
        ArrayList<GeoFence> r104 = this.f517111h;     // Catch: Throwable -> L36
        if (r104 != null) goto L12;
    L19:
        if (r103 == true) goto L34;
        ArrayList<GeoFence> r105 = this.f517111h;     // Catch: Throwable -> L36
        if (r105 != null) goto L23;
    L31:
        if (r102 == false) goto L46;
        C();     // Catch: Throwable -> L36
        return;
    L46:
        return;
    L23:
        if (r105.isEmpty() == true) goto L31;
        Iterator<GeoFence> r106 = this.f517111h.iterator();     // Catch: Throwable -> L36
    L27:
        if (r106.hasNext() == false) goto L31;
        if (r106.next().isAble() == false) goto L27;
        r102 = false;
        goto L31
    L34:
        J();     // Catch: Throwable -> L36
        return;
    L12:
        if (r104.isEmpty() == true) goto L19;
        Iterator<GeoFence> r107 = this.f517111h.iterator();     // Catch: Throwable -> L36
    L15:
        if (r107.hasNext() == false) goto L19;
        GeoFence r108 = r107.next();     // Catch: Throwable -> L36
        if (r108.getFenceId().equals(r101) == false) goto L15;
        r108.setAble(r103);     // Catch: Throwable -> L36
        goto L19
    L48:
        return;
    }

    public final void j(AMapLocation r100) {
    L46:
        th = move-exception;
        c4.g(th, "GeoFenceManager", "doCheckFence");
        return;
    L3:
        if (this.f517128y == false) goto L5;
        return;
    L5:
        ArrayList<GeoFence> r101 = this.f517111h;     // Catch: Throwable -> L46
        if (r101 != null) goto L8;
        return;
    L8:
        if (r101.isEmpty() == true) goto L62;
        if (r100 != null) goto L12;
        return;
    L12:
        if (r100.getErrorCode() != 0) goto L64;
        Iterator<GeoFence> r102 = this.f517111h.iterator();     // Catch: Throwable -> L46
    L14:
        if (r102.hasNext() == false) goto L65;
        GeoFence r103 = r102.next();     // Catch: Throwable -> L46
        if (r103.isAble() == false) goto L14;
        if (v(r100, r103) == false) goto L14;
        int r104 = this.f517110g;     // Catch: Throwable -> L46
        boolean r105 = true;
        boolean r106 = false;
        if ((r104 & 1) != 1) goto L29;
        if (r103.getStatus() != 1) goto L29;
        r106 = true;
        goto L29
    L26:
        th = move-exception;
        c4.g(th, "Utils", "remindStatus");     // Catch: Throwable -> L46
    L42:
        if (r106 == false) goto L14;
        r103.setCurrentLocation(r100);     // Catch: Throwable -> L46
        Bundle r107 = new Bundle();     // Catch: Throwable -> L46
        r107.putParcelable("geoFence", r103);     // Catch: Throwable -> L46
        g(1001, r107);     // Catch: Throwable -> L46
    L29:
        if ((r104 & 2) != 2) goto L34;
        if (r103.getStatus() != 2) goto L34;
        r106 = true;
    L34:
        if ((r104 & 4) == 4) goto L37;
    L40:
        r105 = r106;
    L41:
        r106 = r105;
        goto L42
    L37:
        if (r103.getStatus() != 3) goto L40;
    L65:
        return;
    L64:
        return;
    }

    public static boolean p(AMapLocation r110, GeoFence r111) {
        boolean r100 = false;
    L35:
        th = th;
    L36:
        c4.g(th, "Utils", "isInGeoFence");
    L38:
        return r100;
    L4:
        if (j4.l(r110) == true) goto L6;
    L39:
        goto L38
    L6:
        if (r111.getPointList() == null) goto L39;
        if (r111.getPointList().isEmpty() == true) goto L39;
        int r101 = r111.getType();     // Catch: Throwable -> L35
        if (r101 == 0) goto L28;
        if (r101 == 1) goto L15;
        if (r101 == 2) goto L28;
        if (r101 != 3) goto L39;
    L15:
        Iterator<List<DPoint>> r112 = r111.getPointList().iterator();     // Catch: Throwable -> L35
        boolean r102 = false;
    L42:
    L26:
        th = th;
        r100 = r102;
        goto L36
    L18:
        if (r112.hasNext() == false) goto L25;
        List<DPoint> r103 = r112.next();     // Catch: Throwable -> L26
        if (r103.size() >= 3) goto L22;
        boolean r104 = false;
    L23:
        if (r104 == false) goto L42;
        r102 = true;
        goto L42
    L22:
        r104 = c4.j(new DPoint(r110.getLatitude(), r110.getLongitude()), r103);     // Catch: Throwable -> L26
        goto L23
    L25:
        r100 = r102;
    L28:
        DPoint r105 = r111.getCenter();     // Catch: Throwable -> L35
        if (j4.c(new double[]{r105.getLatitude(), r105.getLongitude(), r110.getLatitude(), r110.getLongitude()}) > r111.getRadius()) goto L32;
        boolean r113 = true;
    L33:
        if (r113 == false) goto L39;
        return true;
    L32:
        r113 = false;
        goto L33
    }

    public static boolean v(AMapLocation r100, GeoFence r101) {
        boolean r102 = false;
    L22:
        th = th;
    L23:
        c4.g(th, "Utils", "isFenceStatusChanged");
    L25:
        return r102;
    L4:
        if (p(r100, r101) == false) goto L17;
        if (r101.getEnterTime() != (-1)) goto L11;
        if (r101.getStatus() == 1) goto L25;
        r101.setEnterTime(SystemClock.elapsedRealtime());     // Catch: Throwable -> L22
        r101.setStatus(1);     // Catch: Throwable -> L22
        return true;
    L11:
        if (r101.getStatus() == 3) goto L25;
        if ((SystemClock.elapsedRealtime() - r101.getEnterTime()) <= 600000) goto L25;
        r101.setStatus(3);     // Catch: Throwable -> L22
        return true;
    L17:
        if (r101.getStatus() == 2) goto L25;
        r101.setStatus(2);     // Catch: Throwable -> L20
        r101.setEnterTime(-1);     // Catch: Throwable -> L20
        r102 = true;
    L20:
        th = th;
        r102 = true;
        goto L23
    }

    public final GeoFence f(Bundle r110, boolean r111) {
        GeoFence r100 = new GeoFence();
        ArrayList r101 = new ArrayList();
        DPoint r102 = new DPoint();
        if (r111 == false) goto L16;
        r100.setType(1);
        r101 = r110.getParcelableArrayList("pointList");
        if (r101 == null) goto L15;
        DPoint r112 = new DPoint();
        Iterator r103 = r101.iterator();     // Catch: Throwable -> L13
        double r104 = AudioStats.AUDIO_AMPLITUDE_NONE;
        double r105 = 0.0d;
    L9:
        if (r103.hasNext() == false) goto L11;
        DPoint r106 = (DPoint) r103.next();     // Catch: Throwable -> L13
        r104 = r104 + r106.getLatitude();     // Catch: Throwable -> L13
        r105 = r105 + r106.getLongitude();     // Catch: Throwable -> L13
        goto L9
    L11:
        r102 = new DPoint(j4.s(r104 / ((double) r101.size())), j4.s(r105 / ((double) r101.size())));     // Catch: Throwable -> L13
    L13:
        th = move-exception;
        c4.g(th, "GeoFenceUtil", "getPolygonCenter");
        r102 = r112;
    L15:
        r100.setMaxDis2Center(q(r102, r101));
        r100.setMinDis2Center(b(r102, r101));
    L24:
        r100.setActivatesAction(this.f517110g);
        r100.setCustomId(r110.getString(GeoFence.BUNDLE_KEY_CUSTOMID));
        ArrayList r113 = new ArrayList();
        r113.add(r101);
        r100.setPointList(r113);
        r100.setCenter(r102);
        r100.setPendingIntentAction(this.f517107d);
        r100.setExpiration(-1);
        r100.setPendingIntent(this.f517106c);
        StringBuilder r114 = new StringBuilder();
        r114.append(w0.b());
        r100.setFenceId(r114.toString());
        h4 r115 = this.f517104a;
        if (r115 == null) goto L27;
        r115.c(this.f517105b, 2);
    L27:
        return r100;
    L16:
        r100.setType(0);
        r102 = (DPoint) r110.getParcelable("centerPoint");
        if (r102 == null) goto L19;
        r101.add(r102);
    L19:
        float r107 = 1000.0f;
        float r116 = r110.getFloat("fenceRadius", 1000.0f);
        if (r116 <= 0.0f) goto L23;
        r107 = r116;
    L23:
        r100.setRadius(r107);
        r100.setMinDis2Center(r107);
        r100.setMaxDis2Center(r107);
        goto L24
    }

    public final void s(int r210, Bundle r211) {
        Bundle r100 = new Bundle();
        ArrayList<? extends Parcelable> r101 = new ArrayList();     // Catch: Throwable -> L95
        if (r211 != null) goto L111;
    L92:
        Bundle r102 = r100;
        String r103 = "errorCode";
        int r110 = 1;
    L93:
        r102.putInt(r103, r110);
    L100:
        g(1000, r102);
        return;
    L111:
    L90:
        th = th;
        r102 = r100;
        String r104 = "errorCode";
    L97:
        int r105 = 0;
    L107:
        c4.g(th, "GeoFenceManager", "doAddGeoFenceNearby");     // Catch: Throwable -> L102
        r102.putInt(r104, 8);
    L102:
        th = move-exception;
        r102.putInt(r104, r105);
        g(1000, r102);
        throw th;
    L6:
        if (r211.isEmpty() == true) goto L92;
        ArrayList r111 = new ArrayList();     // Catch: Throwable -> L90
        String r112 = r211.getString(GeoFence.BUNDLE_KEY_CUSTOMID);     // Catch: Throwable -> L90
        String r113 = r211.getString("keyWords");     // Catch: Throwable -> L90
        String r114 = r211.getString("city");     // Catch: Throwable -> L90
        String r115 = r211.getString("poiType");     // Catch: Throwable -> L90
        DPoint r116 = (DPoint) r211.getParcelable("centerPoint");     // Catch: Throwable -> L90
        int r106 = r211.getInt("searchSize", 10);     // Catch: Throwable -> L90
        float r107 = r211.getFloat("aroundRadius", 3000.0f);     // Catch: Throwable -> L90
        if (n(r210, r113, r115, r116) == true) goto L115;
        String r212 = GeoFence.BUNDLE_KEY_CUSTOMID;
        String r213 = "errorCode";
        Bundle r214 = r100;
        ArrayList<? extends Parcelable> r108 = r101;
        String r215 = r112;
        r105 = 1;
    L85:
        r102 = r214;
        r102.putString(r212, r215);     // Catch: Throwable -> L88
        r102.putParcelableArrayList("resultList", r108);     // Catch: Throwable -> L88
        r110 = r105;
        r103 = r213;
    L88:
        th = th;
        r104 = r213;
        goto L107
    L115:
        Bundle r109 = new Bundle();     // Catch: Throwable -> L79
        r109.putString(GeoFence.BUNDLE_KEY_CUSTOMID, r112);     // Catch: Throwable -> L79
        r109.putString("pendingIntentAction", this.f517107d);     // Catch: Throwable -> L79
        r213 = "errorCode";
        r109.putLong("expiration", -1);     // Catch: Throwable -> L77
        r109.putInt("activatesAction", this.f517110g);     // Catch: Throwable -> L77
        r214 = r100;
        r212 = GeoFence.BUNDLE_KEY_CUSTOMID;
        r215 = r112;
        if (r210 != 1) goto L15;
        r109.putFloat("fenceRadius", 1000.0f);     // Catch: Throwable -> L21
        a0 r117 = this.f517120q;     // Catch: Throwable -> L21
        Context r118 = this.f517105b;     // Catch: Throwable -> L21
        String r119 = String.valueOf(r106);     // Catch: Throwable -> L21
        r117.getClass();     // Catch: Throwable -> L21
        Map<String, String> r120 = a0.b(r118, r113, r115, r114, r119, null, null, null);     // Catch: Throwable -> L21
        HashMap r121 = (HashMap) r120;     // Catch: Throwable -> L21
        r121.put("children", "1");     // Catch: Throwable -> L21
        r121.put("page", "1");     // Catch: Throwable -> L21
        r121.put("extensions", "base");     // Catch: Throwable -> L21
        String r122 = a0.a(r118, "http://restsdk.amap.com/v3/place/text?", r120);     // Catch: Throwable -> L21
    L24:
        int r123 = 4;
        if (r122 != null) goto L27;
        r108 = r101;
    L76:
        r105 = r123;
        goto L85
    L27:
        if (1 != r210) goto L29;
        int r124 = w0.a(r122, r111, r109);     // Catch: Throwable -> L21
    L31:
        if (2 != r210) goto L34;
        r124 = w0.a(r122, r111, r109);     // Catch: Throwable -> L21
    L34:
        if (3 != r210) goto L37;
        this.f517121r.getClass();     // Catch: Throwable -> L21
        r124 = w0.d(r122, r111, r109);     // Catch: Throwable -> L21
    L37:
        if (r124 == 10000) goto L39;
        r108 = r101;
        if (r124 != 1) goto L52;
    L66:
        int r125 = r124;
    L67:
        if (r125 != 0) goto L105;
    L74:
        r105 = r125;
        goto L85
    L105:
        k("添加围栏失败", r125, "searchErrCode is ".concat(String.valueOf(r125)), new String[0]);     // Catch: Throwable -> L72
    L72:
        th = th;
    L83:
        r104 = r213;
        r102 = r214;
        goto L97
    L52:
        if (r124 == 7) goto L66;
        if (r124 == 4) goto L66;
        if (r124 == 5) goto L66;
        if (r124 == 16) goto L66;
        if (r124 == 17) goto L66;
        switch(r124) {
            case 10000: goto L64;
            case 10001: goto L63;
            case 10002: goto L63;
            case 10003: goto L62;
            case 10004: goto L62;
            case 10005: goto L62;
            case 10006: goto L62;
            case 10007: goto L63;
            case 10008: goto L63;
            case 10009: goto L63;
            case 10010: goto L62;
            case 10011: goto L62;
            case 10012: goto L63;
            case 10013: goto L63;
            case 10014: goto L62;
            case 10015: goto L62;
            case 10016: goto L62;
            case 10017: goto L62;
            default: goto L60;
        };
    L60:
        switch(r124) {
            case 20000: goto L65;
            case 20001: goto L65;
            case 20002: goto L65;
            default: goto L61;
        };
    L61:
        r125 = 8;
        goto L67
    L65:
        r125 = 1;
        goto L67
    L62:
        r125 = 4;
        goto L67
    L63:
        r125 = 7;
        goto L67
    L64:
        r125 = 0;
        goto L67
    L39:
        if (r111.isEmpty() == false) goto L41;
        r108 = r101;
        r105 = 16;
        goto L85
    L41:
        r105 = c(r111);     // Catch: Throwable -> L21
        r108 = r101;
        if (r105 == 0) goto L119;
        r123 = r105;
        goto L76
    L119:
        r108.addAll(r111);     // Catch: Throwable -> L46
    L46:
        th = th;
        r104 = r213;
        r102 = r214;
        goto L107
    L29:
        r124 = 0;
        goto L31
    L15:
        if (r210 != 2) goto L17;
        double r126 = j4.s(r116.getLatitude());     // Catch: Throwable -> L21
        double r127 = j4.s(r116.getLongitude());     // Catch: Throwable -> L21
        int r128 = Float.valueOf(r107).intValue();     // Catch: Throwable -> L21
        r109.putFloat("fenceRadius", 200.0f);     // Catch: Throwable -> L21
        a0 r129 = this.f517120q;     // Catch: Throwable -> L21
        Context r130 = this.f517105b;     // Catch: Throwable -> L21
        String r131 = String.valueOf(r106);     // Catch: Throwable -> L21
        String r216 = String.valueOf(r126);     // Catch: Throwable -> L21
        String r217 = String.valueOf(r127);     // Catch: Throwable -> L21
        String r132 = String.valueOf(r128);     // Catch: Throwable -> L21
        r129.getClass();     // Catch: Throwable -> L21
        Map<String, String> r133 = a0.b(r130, r113, r115, null, r131, r216, r217, r132);     // Catch: Throwable -> L21
        HashMap r134 = (HashMap) r133;     // Catch: Throwable -> L21
        r134.put("children", "1");     // Catch: Throwable -> L21
        r134.put("page", "1");     // Catch: Throwable -> L21
        r134.put("extensions", "base");     // Catch: Throwable -> L21
        r122 = a0.a(r130, "http://restsdk.amap.com/v3/place/around?", r133);     // Catch: Throwable -> L21
        goto L24
    L17:
        if (r210 == 3) goto L19;
        r122 = null;
        goto L24
    L19:
        a0 r135 = this.f517120q;     // Catch: Throwable -> L21
        Context r136 = this.f517105b;     // Catch: Throwable -> L21
        r135.getClass();     // Catch: Throwable -> L21
        Map<String, String> r137 = a0.b(r136, r113, null, null, null, null, null, null);     // Catch: Throwable -> L21
        HashMap r138 = (HashMap) r137;     // Catch: Throwable -> L21
        r138.put("extensions", "all");     // Catch: Throwable -> L21
        r138.put("subdistrict", "0");     // Catch: Throwable -> L21
        r122 = a0.a(r136, "http://restsdk.amap.com/v3/config/district?", r137);     // Catch: Throwable -> L21
    L21:
        th = th;
    L77:
        th = th;
    L81:
        r214 = r100;
    L79:
        th = th;
        r213 = "errorCode";
    L95:
        th = th;
        r104 = "errorCode";
        r102 = r100;
        goto L97
    }
}
