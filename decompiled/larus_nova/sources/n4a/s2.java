package n4a;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.os.Messenger;
import android.os.Process;
import android.os.SystemClock;
import android.text.TextUtils;
import com.amap.api.location.AMapLocation;
import com.amap.api.location.AMapLocationClientOption;
import com.amap.api.services.geocoder.GeocodeSearch;
import com.bytedance.ies.sdk.widgets.perf.WidgetCostModule;
import com.bytedance.map.api.monitor.MapMonitorConst;
import com.larus.apm.impl.protector.RunnableProtector;
import com.loc.em;
import com.loc.es;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import com.ss.android.ugc.bytex.pthread.base.proxy.PthreadHandlerThreadV2;
import com.ss.ttvideoengine.DataLoaderHelper;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes32.dex */
public final class s2 {

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public static boolean f517679w;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f517680a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f517681b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public b f517682c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public long f517683d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public es f517684e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public es f517685f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public a f517686g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final Context f517687h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public t4 f517688i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public b3 f517689j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public HashMap<Messenger, Long> f517690k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public h4 f517691l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public long f517692m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public long f517693n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public List<Messenger> f517694o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public long f517695p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public HashMap<String, Boolean> f517696q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public String f517697r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public boolean f517698s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public String f517699t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public AMapLocationClientOption f517700u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public AMapLocationClientOption f517701v;

    public class a extends Handler {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ s2 f517702a;

        public a(s2 r100, Looper r101) {
            this.f517702a = r100;
            super(r101);
        }

        @Override // android.os.Handler
        public final void handleMessage(Message r110) {
            Bundle r100 = r110.getData();     // Catch: Throwable -> L27
            Messenger r101 = r110.replyTo;     // Catch: Throwable -> L25
            if (r100 != null) goto L86;
        L30:
            int r102 = r110.what;     // Catch: Throwable -> L82
            if (r102 == 0) goto L79;
            if (r102 != 1) goto L34;
            this.f517702a.b(r100);     // Catch: Throwable -> L82
            s2.k(this.f517702a, r101, r100);     // Catch: Throwable -> L82
        L80:
            super.handleMessage(r110);     // Catch: Throwable -> L82
            return;
        L82:
            th = move-exception;
            c4.g(th, "actionHandler", "handleMessage");
            return;
        L34:
            switch(r102) {
                case 9: goto L72;
                case 10: goto L71;
                case 11: goto L70;
                case 12: goto L69;
                case 13: goto L60;
                case 14: goto L48;
                case 15: goto L47;
                case 16: goto L42;
                case 17: goto L37;
                case 18: goto L36;
                default: goto L80;
            };
        L36:
            this.f517702a.b(r100);     // Catch: Throwable -> L82
            this.f517702a.d(r101, r100, "FINE_LOC", 12);     // Catch: Throwable -> L82
            goto L80
        L37:
            if (r100 == null) goto L80;
            if (r100.isEmpty() == true) goto L80;
            this.f517702a.f517696q.put(r100.getString("objHash"), Boolean.FALSE);     // Catch: Throwable -> L82
        L46:
            this.f517702a.l();     // Catch: Throwable -> L82
            goto L80
        L42:
            if (r100 == null) goto L80;
            if (r100.isEmpty() == true) goto L80;
            this.f517702a.f517696q.put(r100.getString("objHash"), Boolean.TRUE);     // Catch: Throwable -> L82
            goto L46
        L47:
            this.f517702a.b(r100);     // Catch: Throwable -> L82
            this.f517702a.d(r101, r100, "COARSE_LOC", 1);     // Catch: Throwable -> L82
            goto L80
        L48:
            Messenger r103 = r110.replyTo;     // Catch: Throwable -> L82
            if (r103 == null) goto L55;
            List<Messenger> r104 = this.f517702a.f517694o;     // Catch: Throwable -> L82
            if (r104 == null) goto L55;
            if (((ArrayList) r104).contains(r103) == false) goto L55;
            ((ArrayList) this.f517702a.f517694o).remove(r103);     // Catch: Throwable -> L82
        L55:
            List<Messenger> r105 = this.f517702a.f517694o;     // Catch: Throwable -> L82
            if (r105 == null) goto L80;
            if (((ArrayList) r105).size() != 0) goto L80;
            this.f517702a.f517689j.u();     // Catch: Throwable -> L82
            goto L80
        L60:
            Messenger r106 = r110.replyTo;     // Catch: Throwable -> L82
            if (r106 == null) goto L80;
            List<Messenger> r107 = this.f517702a.f517694o;     // Catch: Throwable -> L82
            if (r107 == null) goto L80;
            if (((ArrayList) r107).contains(r106) == true) goto L80;
            ((ArrayList) this.f517702a.f517694o).add(r106);     // Catch: Throwable -> L82
            if (((ArrayList) this.f517702a.f517694o).size() != 1) goto L80;
            this.f517702a.n();     // Catch: Throwable -> L82
            goto L80
        L69:
            this.f517702a.f517690k.remove(r101);     // Catch: Throwable -> L82
            goto L80
        L70:
            this.f517702a.m();     // Catch: Throwable -> L82
            goto L80
        L71:
            this.f517702a.b(r100);     // Catch: Throwable -> L82
            this.f517702a.d(r101, r100, "FINE_LOC", 1);     // Catch: Throwable -> L82
            goto L80
        L72:
            this.f517702a.b(r100);     // Catch: Throwable -> L82
            s2 r108 = this.f517702a;     // Catch: Throwable -> L82
            r108.getClass();     // Catch: Throwable -> L82
            Context r109 = r108.f517687h;     // Catch: Throwable -> L76
            boolean r111 = com.loc.h.f380067a;     // Catch: Throwable -> L76
            e5 r112 = c4.k();     // Catch: Throwable -> L85
            r112.f517261c = com.loc.h.f380068b ? 1 : 0;     // Catch: Throwable -> L85
            r.b(r109, r112);     // Catch: Throwable -> L85
            goto L80
        L76:
            th = move-exception;
            c4.g(th, "ApsServiceCore", "doCallOtherSer");     // Catch: Throwable -> L82
            goto L80
        L79:
            this.f517702a.b(r100);     // Catch: Throwable -> L82
            s2.h(this.f517702a, r101, r100);     // Catch: Throwable -> L82
            goto L80
        L86:
        L11:
            Throwable th10 = th;
        L94:
            c4.g(th10, "ApsServiceCore", "ActionHandler handlerMessage");     // Catch: Throwable -> L82
            goto L30
        L7:
            if (r100.isEmpty() == true) goto L30;
            String r113 = r100.getString("c");     // Catch: Throwable -> L11
            s2 r114 = this.f517702a;     // Catch: Throwable -> L11
            if (TextUtils.isEmpty(r114.f517697r) == false) goto L14;
            Context r115 = r114.f517687h;     // Catch: Throwable -> L11
            String r116 = c4.f517206a;     // Catch: Throwable -> L11
            r114.f517697r = b5.a(v4.f(r115));     // Catch: Throwable -> L11
        L14:
            if (TextUtils.isEmpty(r113) == false) goto L16;
        L19:
            boolean r117 = false;
        L20:
            if (r117 == true) goto L30;
            if (r110.what != 1) goto L98;
            h4.k(null, DataLoaderHelper.DATALOADER_KEY_INT_DEV_DISK_SIZE_MB);     // Catch: Throwable -> L11
            es r118 = s2.a(10, "invalid handlder scode!!!#1002");     // Catch: Throwable -> L11
            em r119 = new em();     // Catch: Throwable -> L11
            r119.f380047h = "#1002";     // Catch: Throwable -> L11
            r119.f380046g = "conitue";     // Catch: Throwable -> L11
            this.f517702a.e(r101, r118, r118.V, r119);     // Catch: Throwable -> L11
            return;
        L98:
            return;
        L16:
            if (r113.equals(r114.f517697r) == false) goto L19;
            r117 = true;
        L25:
            th = move-exception;
            r101 = null;
            th10 = th;
        L27:
            th = move-exception;
            r101 = null;
            th10 = th;
            r100 = null;
            goto L94
        }
    }

    public class b extends PthreadHandlerThreadV2 {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ s2 f517703c;

        public b(s2 r100) {
            this.f517703c = r100;
            super("amapLocCoreThread");
        }

        @Override // android.os.HandlerThread
        public final void onLooperPrepared() {
            s2 r100 = this.f517703c;     // Catch: Throwable -> L5
            r100.f517688i = new t4(r100.f517687h);     // Catch: Throwable -> L5
        L16:
            com.loc.h.g(this.f517703c.f517687h);     // Catch: Throwable -> L9
            com.loc.h.a(this.f517703c.f517687h);     // Catch: Throwable -> L9
        L11:
            s2 r101 = this.f517703c;     // Catch: Throwable -> L13
            r101.f517689j = new b3(false);     // Catch: Throwable -> L13
            super.onLooperPrepared();     // Catch: Throwable -> L13
            return;
        L9:
            th = move-exception;
            c4.g(th, "APSManager$ActionThread", "init 3");     // Catch: Throwable -> L13
            goto L11
        L13:
            th = move-exception;
            c4.g(th, "APSManager$ActionThread", "onLooperPrepared");
            return;
        L5:
            th = move-exception;
            c4.g(th, "APSManager$ActionThread", "init 2");     // Catch: Throwable -> L13
            goto L16
        }

        @Override // com.ss.android.ugc.bytex.pthread.base.proxy.PthreadHandlerThreadV2, android.os.HandlerThread, java.lang.Thread, java.lang.Runnable
        public final void run() {
            super.run();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            c4.g(th, "APSManager$ActionThread", "run");     // Catch: Throwable -> L7
            return;
        L7:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L11;
            return;
        L11:
            throw th;
        }
    }

    public s2(Context r100) {
        this.f517680a = false;
        this.f517681b = false;
        this.f517682c = null;
        this.f517683d = 0;
        this.f517684e = null;
        this.f517685f = null;
        this.f517686g = null;
        this.f517687h = null;
        this.f517688i = null;
        this.f517689j = null;
        this.f517690k = new HashMap();
        this.f517691l = null;
        this.f517692m = 0;
        this.f517693n = 0;
        this.f517695p = 0;
        this.f517696q = new HashMap();
        this.f517697r = null;
        this.f517698s = true;
        this.f517699t = "";
        this.f517700u = null;
        this.f517701v = new AMapLocationClientOption();
        this.f517687h = r100;
    }

    public static es a(int r100, String r101) {
        es r102 = new es();     // Catch: Throwable -> L4
        r102.setErrorCode(r100);     // Catch: Throwable -> L4
        r102.setLocationDetail(r101);     // Catch: Throwable -> L4
        return r102;
    L4:
        th = move-exception;
        c4.g(th, "ApsServiceCore", "newInstanceAMapLoc");
        return null;
    }

    public static void c(Messenger r100, int r101, Bundle r102) {
        if (r100 == null) goto L10;
        Message r103 = Message.obtain();     // Catch: Throwable -> L5
        r103.setData(r102);     // Catch: Throwable -> L5
        r103.what = r101;     // Catch: Throwable -> L5
        r100.send(r103);     // Catch: Throwable -> L5
        return;
    L5:
        th = move-exception;
        c4.g(th, "ApsServiceCore", "sendMessage");
        return;
    }

    public final void b(Bundle r100) {
    L17:
        th = move-exception;
        this.f517698s = false;
        th.printStackTrace();
        this.f517699t = th.getMessage();
        c4.g(th, "ApsServiceCore", "init");
        return;
    L3:
        if (this.f517680a == false) goto L8;
        b3 r101 = this.f517689j;     // Catch: Throwable -> L17
        if (r101 == null) goto L21;
        r101.l();     // Catch: Throwable -> L17
        return;
    L21:
        return;
    L8:
        c4.c(this.f517687h);     // Catch: Throwable -> L17
        if (r100 == null) goto L11;
        this.f517701v = c4.b(r100.getBundle("optBundle"));     // Catch: Throwable -> L17
    L11:
        this.f517689j.g(this.f517687h);     // Catch: Throwable -> L17
        this.f517689j.p();     // Catch: Throwable -> L17
        g(this.f517701v);     // Catch: Throwable -> L17
        this.f517689j.r();     // Catch: Throwable -> L17
        this.f517680a = true;     // Catch: Throwable -> L17
        this.f517698s = true;     // Catch: Throwable -> L17
        this.f517699t = "";     // Catch: Throwable -> L17
        List<Messenger> r102 = this.f517694o;     // Catch: Throwable -> L17
        if (r102 != null) goto L14;
        return;
    L14:
        if (((ArrayList) r102).size() <= 0) goto L23;
        n();     // Catch: Throwable -> L17
        return;
    }

    public final void g(AMapLocationClientOption r100) {
        b3 r101 = this.f517689j;     // Catch: Throwable -> L24
        if (r101 == null) goto L5;
        r101.i(r100);     // Catch: Throwable -> L24
    L5:
        if (r100 == null) goto L29;
        f517679w = r100.isKillProcess();     // Catch: Throwable -> L24
        if (this.f517700u != null) goto L9;
    L22:
        this.f517700u = r100;     // Catch: Throwable -> L24
        return;
    L9:
        if (r100.isOffset() == this.f517700u.isOffset()) goto L11;
    L16:
        this.f517683d = 0;     // Catch: Throwable -> L24
    L18:
        if (r100.isOffset() == this.f517700u.isOffset()) goto L20;
    L21:
        this.f517685f = null;     // Catch: Throwable -> L24
        goto L22
    L20:
        if (this.f517700u.getGeoLanguage() == r100.getGeoLanguage()) goto L22;
    L11:
        if (r100.isNeedAddress() != this.f517700u.isNeedAddress()) goto L16;
        if (r100.isLocationCacheEnable() != this.f517700u.isLocationCacheEnable()) goto L16;
        if (this.f517700u.getGeoLanguage() == r100.getGeoLanguage()) goto L18;
    L29:
        return;
    L24:
        th = move-exception;
        c4.g(th, "ApsServiceCore", "setExtra");
    }

    public final void i() {
        this.f517691l = new h4();     // Catch: Throwable -> L4
        b r100 = new b(this);     // Catch: Throwable -> L4
        this.f517682c = r100;     // Catch: Throwable -> L4
        ThreadMethodProxy.setPriority(r100, 5);     // Catch: Throwable -> L4
        ThreadMethodProxy.start(this.f517682c);     // Catch: Throwable -> L4
        this.f517686g = new a(this, this.f517682c.getLooper());     // Catch: Throwable -> L4
        this.f517694o = new ArrayList();     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        c4.g(th, "ApsServiceCore", WidgetCostModule.TYPE_ON_CREATE);
    }

    public final void l() {
        if (this.f517689j == null) goto L20;
        HashMap<String, Boolean> r100 = this.f517696q;
        if (r100 != null) goto L7;
        return;
    L7:
        if (r100.isEmpty() == true) goto L22;
        Iterator<Boolean> r101 = this.f517696q.values().iterator();
    L10:
        if (r101.hasNext() == false) goto L15;
        if (r101.next().booleanValue() == false) goto L10;
        this.f517689j.k(true);
        return;
    L15:
        this.f517689j.k(false);
        return;
    L22:
        return;
    }

    public final void m() {
        HashMap<Messenger, Long> r100 = this.f517690k;     // Catch: Throwable -> L96
        if (r100 == null) goto L114;
        r100.clear();     // Catch: Throwable -> L96
        this.f517690k = null;     // Catch: Throwable -> L96
    L114:
        List<Messenger> r101 = this.f517694o;     // Catch: Throwable -> L10
        if (r101 == null) goto L12;
        ((ArrayList) r101).clear();     // Catch: Throwable -> L10
    L12:
        t4 r102 = this.f517688i;     // Catch: Throwable -> L96
        int r103 = 0;
        if (r102 != null) goto L108;
    L20:
        this.f517680a = false;     // Catch: Throwable -> L96
        this.f517681b = false;     // Catch: Throwable -> L96
        this.f517689j.t();     // Catch: Throwable -> L96
        a r104 = this.f517686g;     // Catch: Throwable -> L96
        if (r104 == null) goto L23;
        r104.removeCallbacksAndMessages(null);     // Catch: Throwable -> L96
    L23:
        this.f517686g = null;     // Catch: Throwable -> L96
        b r105 = this.f517682c;     // Catch: Throwable -> L96
        if (r105 != null) goto L116;
    L28:
        this.f517682c = null;     // Catch: Throwable -> L96
        if (this.f517691l != null) goto L31;
    L89:
        HashMap<String, Boolean> r106 = this.f517696q;     // Catch: Throwable -> L96
        if (r106 == null) goto L92;
        r106.clear();     // Catch: Throwable -> L96
        this.f517696q = null;     // Catch: Throwable -> L96
    L92:
        h4.b(this.f517687h);     // Catch: Throwable -> L96
        r.e();     // Catch: Throwable -> L96
        if (f517679w == false) goto L119;
        Process.killProcess(Process.myPid());     // Catch: Throwable -> L96
        return;
    L119:
        return;
    L31:
        if (this.f517692m == 0) goto L89;
        if (this.f517693n == 0) goto L89;
        long r110 = SystemClock.elapsedRealtime() - this.f517692m;     // Catch: Throwable -> L96
        h4 r107 = this.f517691l;     // Catch: Throwable -> L96
        Context r108 = this.f517687h;     // Catch: Throwable -> L96
        r107.getClass();     // Catch: Throwable -> L96
        long r111 = i4.b(r108, "pref1", r107.f517359d[2], 0);     // Catch: Throwable -> L100
        long r112 = i4.b(r108, "pref1", r107.f517359d[0], 0);     // Catch: Throwable -> L100
        long r113 = i4.b(r108, "pref1", r107.f517359d[1], 0);     // Catch: Throwable -> L100
        if (r111 == 0) goto L40;
    L44:
        long r114 = r112 - r111;
        long r115 = r113 - r111;
        if (r111 <= r114) goto L50;
        if (r111 <= r115) goto L52;
        int r116 = 2;
    L54:
        h4 r109 = this.f517691l;     // Catch: Throwable -> L96
        Context r117 = this.f517687h;     // Catch: Throwable -> L96
        r109.getClass();     // Catch: Throwable -> L96
        long r118 = i4.b(r117, "pref1", r109.f517359d[3], 0);     // Catch: Throwable -> L99
        long r119 = i4.b(r117, "pref1", r109.f517359d[4], 0);     // Catch: Throwable -> L99
        long r210 = i4.b(r117, "pref1", r109.f517359d[5], 0);     // Catch: Throwable -> L99
        if (r118 != 0) goto L64;
        if (r119 != 0) goto L64;
        if (r210 == 0) goto L72;
    L64:
        if (r118 <= r119) goto L69;
        if (r118 <= r210) goto L71;
        int r120 = 3;
    L73:
        Context r121 = this.f517687h;     // Catch: Throwable -> L96
        long r122 = this.f517693n;     // Catch: Throwable -> L96
        if (r116 == (-1)) goto L83;
        if (r120 == (-1)) goto L83;
        h4.d(r121, r116, r120, r122, r110);     // Catch: Throwable -> L80
    L80:
        th = move-exception;
        c4.g(th, "ReportUtil", "reportServiceAliveTime");     // Catch: Throwable -> L96
    L83:
        h4 r123 = this.f517691l;     // Catch: Throwable -> L96
        Context r124 = this.f517687h;     // Catch: Throwable -> L96
        r123.getClass();     // Catch: Throwable -> L96
        SharedPreferences.Editor r125 = r124.getSharedPreferences("pref1", 0).edit();     // Catch: Throwable -> L101
    L85:
        String[] r126 = r123.f517359d;     // Catch: Throwable -> L101
        if (r103 >= r126.length) goto L88;
        i4.g(r125, r126[r103], 0);     // Catch: Throwable -> L101
        r103 = r103 + 1;     // Catch: Throwable -> L101
        goto L85
    L88:
        i4.e(r125);     // Catch: Throwable -> L101
    L71:
        r120 = 5;
        goto L73
    L69:
        if (r119 <= r210) goto L71;
        r120 = 4;
    L72:
        r120 = -1;
    L52:
        r116 = 1;
        goto L54
    L50:
        if (r114 <= r115) goto L52;
        r116 = 0;
        goto L54
    L40:
        if (r112 != 0) goto L44;
        if (r113 != 0) goto L44;
    L53:
        r116 = -1;
        goto L54
    L116:
        f4.b(r105, HandlerThread.class, "quitSafely", new Object[0]);     // Catch: Throwable -> L27
    L27:
        this.f517682c.quit();     // Catch: Throwable -> L96
        goto L28
    L108:
        r102.d();     // Catch: Throwable -> L17
        r102.f517763e = 0;     // Catch: Throwable -> L17
        r102.f517764f = false;     // Catch: Throwable -> L17
        r102.f517761c = null;     // Catch: Throwable -> L17
        r102.f517762d = null;     // Catch: Throwable -> L17
    L19:
        this.f517688i = null;     // Catch: Throwable -> L96
        goto L20
    L17:
        th = move-exception;
        c4.g(th, "LastLocationManager", MapMonitorConst.EVENT_DESTROY);     // Catch: Throwable -> L96
    L10:
        th = move-exception;
        c4.g(th, "apm", "des1");     // Catch: Throwable -> L96
    L96:
        th = move-exception;
        c4.g(th, "apm", "tdest");
    }

    public final void n() {
        if (j4.J(this.f517687h) == false) goto L27;
        return;
    L27:
        b3 r100 = this.f517689j;     // Catch: Throwable -> L24
        if (r100 == null) goto L30;
        if (r100 == null) goto L31;
        r100.F = this.f517686g;     // Catch: Throwable -> L24
        r100.getClass();     // Catch: Throwable -> L24
        Context r101 = r100.f517167a;     // Catch: Throwable -> L21
        if (r101 != null) goto L13;
        return;
    L13:
        if (r100.L != null) goto L15;
        r100.L = new d3(r101);     // Catch: Throwable -> L21
    L15:
        l3 r102 = r100.f517170d;     // Catch: Throwable -> L21
        if (r102 == null) goto L33;
        s3 r103 = r100.f517169c;     // Catch: Throwable -> L21
        if (r103 == null) goto L34;
        r100.L.b(r102, r103, r100.F);     // Catch: Throwable -> L21
    L35:
        return;
    L34:
        return;
    L33:
        return;
    L21:
        th = move-exception;
        r.f(th, "as", "stc");     // Catch: Throwable -> L24
        return;
    L31:
        return;
    L30:
        return;
    L24:
        th = move-exception;
        c4.g(th, "ApsServiceCore", "startColl");
    }

    public static AMapLocationClientOption j(Bundle r100) {
        AMapLocationClientOption r101 = null;
        r101 = c4.b(r100.getBundle("optBundle"));     // Catch: Throwable -> L11
        String r102 = r100.getString("d");     // Catch: Throwable -> L8
        if (TextUtils.isEmpty(r102) == true) goto L14;
        x4.f517927d = r102;     // Catch: Throwable -> L8
    L14:
    L13:
        return r101;
    L8:
        th = move-exception;
        c4.g(th, "APSManager", "doLocation setUmidToken");     // Catch: Throwable -> L11
    L11:
        th = move-exception;
        c4.g(th, "APSManager", "parseBundle");
        goto L13
    }

    public static void h(s2 r100, Messenger r101, Bundle r102) {
        r100.getClass();
        if (r102 == null) goto L28;
    L21:
        th = move-exception;
        c4.g(th, "ApsServiceCore", "doInitAuth");
        return;
    L5:
        if (r102.isEmpty() == false) goto L8;
        return;
    L8:
        if (r100.f517681b == true) goto L30;
        r100.f517681b = true;     // Catch: Throwable -> L21
        d3 r103 = r100.f517689j.L;     // Catch: Throwable -> L18
        if (r103 == null) goto L15;
        r103.d();     // Catch: Throwable -> L18
    L15:
        if (com.loc.h.f380085s == false) goto L31;
        Bundle r104 = new Bundle();     // Catch: Throwable -> L18
        r104.putBoolean("installMockApp", true);     // Catch: Throwable -> L18
        c(r101, 9, r104);     // Catch: Throwable -> L18
    L32:
        return;
    L31:
        return;
    L18:
        th = move-exception;
        c4.g(th, "ApsServiceCore", "initAuth");     // Catch: Throwable -> L21
        return;
    L30:
        return;
    }

    public static void k(s2 r110, Messenger r111, Bundle r112) {
        r110.getClass();
        if (r112 == null) goto L70;
    L62:
        th = move-exception;
        c4.g(th, "ApsServiceCore", "doLocation");
        return;
    L5:
        if (r112.isEmpty() == true) goto L71;
        em r100 = new em();     // Catch: Throwable -> L62
        r100.f380046g = "conitue";     // Catch: Throwable -> L62
        AMapLocationClientOption r113 = j(r112);     // Catch: Throwable -> L62
        r110.g(r113);     // Catch: Throwable -> L62
        if (r110.f517690k.containsKey(r111) == true) goto L10;
    L14:
        AMapLocation r101 = null;
        if (r110.f517698s == true) goto L17;
        es r114 = a(9, "init error : " + r110.f517699t + "#0901");     // Catch: Throwable -> L62
        r110.f517684e = r114;     // Catch: Throwable -> L62
        r100.f380047h = "#0901";     // Catch: Throwable -> L62
        r110.e(r111, r114, r114.V, r100);     // Catch: Throwable -> L62
        h4.k(null, 2091);     // Catch: Throwable -> L62
        return;
    L17:
        long r102 = SystemClock.elapsedRealtime();     // Catch: Throwable -> L62
        if (j4.m(r110.f517684e) == true) goto L20;
    L22:
        r100.f380040a = SystemClock.elapsedRealtime();     // Catch: Throwable -> L62
        es r103 = r110.f517689j.c(r100);     // Catch: Throwable -> L38
        r110.f517684e = r103;     // Catch: Throwable -> L38
        if (r103.getLocationType() != 6) goto L27;
    L35:
        r110.f517689j.j(r110.f517684e, 2);     // Catch: Throwable -> L38
    L36:
        r110.f517684e = r110.f517689j.d(r110.f517684e);     // Catch: Throwable -> L38
    L42:
        if (j4.m(r110.f517684e) == false) goto L45;
        r110.f517683d = SystemClock.elapsedRealtime();     // Catch: Throwable -> L62
    L45:
        if (r110.f517684e != null) goto L47;
        r110.f517684e = a(8, "loc is null#0801");     // Catch: Throwable -> L62
        r100.f380047h = "#0801";     // Catch: Throwable -> L62
    L47:
        es r104 = r110.f517684e;     // Catch: Throwable -> L62
        if (r104 == null) goto L51;
        String r105 = r104.V;     // Catch: Throwable -> L62
        r101 = r104.clone();     // Catch: Throwable -> L62
        String r106 = r105;
    L68:
    L58:
        th = move-exception;
        c4.g(th, "ApsServiceCore", "fixLastLocation");     // Catch: Throwable -> L62
    L60:
        r110.e(r111, r101, r106, r100);     // Catch: Throwable -> L62
        return;
    L53:
        if (r113.isLocationCacheEnable() == false) goto L60;
        t4 r107 = r110.f517688i;     // Catch: Throwable -> L58
        if (r107 == null) goto L60;
        r101 = r107.a(r101, r106, r113.getLastLocationLifeCycle());     // Catch: Throwable -> L58
    L51:
        r106 = null;
        goto L68
    L27:
        if (r110.f517684e.getLocationType() == 5) goto L35;
        if (r110.f517684e.getLocationType() != 2) goto L33;
        r110.f517689j.j(r110.f517684e, 3);     // Catch: Throwable -> L38
        goto L36
    L33:
        if (r110.f517684e.getLocationType() != 4) goto L36;
        r110.f517689j.j(r110.f517684e, 4);     // Catch: Throwable -> L38
    L38:
        th = move-exception;
        h4.k(null, 2081);     // Catch: Throwable -> L62
        r100.f380047h = "#0801";     // Catch: Throwable -> L62
        r110.f517684e = a(8, "loc error : " + th.getMessage() + "#0801");     // Catch: Throwable -> L62
        c4.g(th, "ApsServiceCore", "run part2");     // Catch: Throwable -> L62
        goto L42
    L20:
        if ((r102 - r110.f517683d) >= 600) goto L22;
        es r115 = r110.f517684e;     // Catch: Throwable -> L62
        r110.e(r111, r115, r115.V, r100);     // Catch: Throwable -> L62
        r110.f517689j.j(r110.f517684e, 3);     // Catch: Throwable -> L62
        return;
    L10:
        if (r113.isOnceLocation() == true) goto L14;
        if ((SystemClock.elapsedRealtime() - r110.f517690k.get(r111).longValue()) >= 800) goto L14;
        return;
    L71:
        return;
    }

    public final void f(Messenger r100, String r101, int r102) {
        Bundle r103 = new Bundle();
        r103.setClassLoader(AMapLocation.class.getClassLoader());
        r103.putInt("I_MAX_GEO_DIS", com.loc.h.f380081o * 3);
        r103.putInt("I_MIN_GEO_DIS", com.loc.h.f380081o);
        r103.putParcelable("loc", this.f517685f);
        if ("COARSE_LOC".equals(r101) == false) goto L6;
        int r104 = 103;
    L8:
        c(r100, r104, r103);
        return;
    L6:
        if (r102 != 1) goto L11;
        r104 = 6;
        goto L8
    L11:
        if (r102 != 12) goto L14;
        c(r100, 18, r103);
        return;
    }

    public final void d(Messenger r110, Bundle r111, String r210, int r211) {
        if (r111 == null) goto L62;
    L48:
        th = move-exception;
        c4.g(th, "ApsServiceCore", "doLocationGeo");
        return;
    L5:
        if (r111.isEmpty() == true) goto L63;
        double r112 = r111.getDouble("lat");     // Catch: Throwable -> L48
        double r113 = r111.getDouble("lon");     // Catch: Throwable -> L48
        float r100 = r111.getFloat("radius");     // Catch: Throwable -> L48
        long r101 = r111.getLong("time");     // Catch: Throwable -> L48
        if ("FINE_LOC".equals(r210) == false) goto L17;
        if (r211 != 1) goto L12;
        AMapLocation r102 = new AMapLocation(GeocodeSearch.GPS);     // Catch: Throwable -> L48
        r102.setLocationType(1);     // Catch: Throwable -> L48
    L15:
        r102.setLatitude(r112);     // Catch: Throwable -> L48
        r102.setLongitude(r113);     // Catch: Throwable -> L48
        r102.setAccuracy(r100);     // Catch: Throwable -> L48
        r102.setTime(r101);     // Catch: Throwable -> L48
        this.f517689j.h(r102);     // Catch: Throwable -> L48
        goto L17
    L12:
        if (r211 != 12) goto L14;
        AMapLocation r114 = new AMapLocation("network");     // Catch: Throwable -> L48
        r114.setLocationType(12);     // Catch: Throwable -> L48
        r102 = r114;
        goto L15
    L14:
        r102 = null;
    L17:
        if (com.loc.h.f380080n == true) goto L19;
        return;
    L19:
        AMapLocationClientOption r103 = j(r111);     // Catch: Throwable -> L48
        if (r103 != null) goto L22;
        return;
    L22:
        if (r103.isNeedAddress() == false) goto L57;
        g(r103);     // Catch: Throwable -> L48
        es r104 = this.f517685f;     // Catch: Throwable -> L48
        if (r104 == null) goto L29;
        float r105 = j4.c(new double[]{r112, r113, r104.getLatitude(), this.f517685f.getLongitude()});     // Catch: Throwable -> L48
        if (r105 >= (com.loc.h.f380081o * 3)) goto L31;
        f(r110, r210, r211);     // Catch: Throwable -> L48
    L31:
        if (r105 != (-1.0f)) goto L33;
    L36:
        b(r111);     // Catch: Throwable -> L48
        b3 r106 = this.f517689j;     // Catch: Throwable -> L48
        r106.getClass();     // Catch: Throwable -> L48
        String r107 = r106.f517182p.a(r106.f517167a, r112, r113);     // Catch: Throwable -> L51
        if (r107.contains("\"status\":\"1\"") == false) goto L41;
        es r108 = r106.f517172f.a(r107);     // Catch: Throwable -> L51
        r108.setLatitude(r112);     // Catch: Throwable -> L51
        r108.setLongitude(r113);     // Catch: Throwable -> L51
    L42:
        this.f517685f = r108;     // Catch: Throwable -> L48
        this.f517695p = SystemClock.elapsedRealtime();     // Catch: Throwable -> L48
        es r109 = this.f517685f;     // Catch: Throwable -> L48
        if (r109 != null) goto L45;
        return;
    L45:
        if (TextUtils.isEmpty(r109.getAdCode()) == true) goto L61;
        f(r110, r210, r211);     // Catch: Throwable -> L48
        return;
    L61:
        return;
    L41:
        r108 = null;
        goto L42
    L33:
        if (r105 > com.loc.h.f380081o) goto L35;
        return;
    L35:
        if ((SystemClock.elapsedRealtime() - this.f517695p) > (com.loc.h.f380082p * 1000)) goto L36;
        return;
    L29:
        r105 = -1.0f;
        goto L31
    L57:
        return;
    L63:
        return;
    }

    public final void e(Messenger r100, AMapLocation r101, String r102, em r103) {
        Bundle r104 = new Bundle();
        r104.setClassLoader(AMapLocation.class.getClassLoader());
        r104.putParcelable("loc", r101);
        r104.putString("nb", r102);
        r104.putParcelable("statics", r103);
        this.f517690k.put(r100, Long.valueOf(SystemClock.elapsedRealtime()));
        c(r100, 1, r104);
    }
}
