package com.bytedance.badger.service;

import a74.a;
import a74.l;
import a74.q;
import a74.r;
import android.app.Service;
import android.content.Intent;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Handler;
import android.os.IBinder;
import com.bytedance.badger.e;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import com.ss.android.ugc.bytex.pthread.base.proxy.PthreadHandlerThreadV2;
import faceverify.w;
import fna.g;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.jvm.internal.Intrinsics;
import ona.b;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes47.dex */
public class SensorDataService extends Service implements SensorEventListener {

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public static final /* synthetic */ int f199176q = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public volatile int f199177a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public volatile int f199178b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public volatile long f199179c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f199180d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f199181e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public SensorManager f199182f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public Sensor f199183g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public Sensor f199184h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final List f199185i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final List f199186j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public volatile q f199187k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final Object f199188l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final AtomicBoolean f199189m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final AtomicBoolean f199190n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public volatile PthreadHandlerThreadV2 f199191o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public volatile Handler f199192p;

    public SensorDataService() {
        this.f199177a = 10;
        this.f199178b = 3;
        this.f199179c = 0;
        this.f199180d = false;
        this.f199181e = false;
        this.f199185i = new ArrayList();
        this.f199186j = new ArrayList();
        this.f199188l = new Object();
        this.f199189m = new AtomicBoolean(false);
        this.f199190n = new AtomicBoolean(false);
    }

    public static String c(List r110) {
        StringBuilder r100 = new StringBuilder();
        int r101 = 0;
    L4:
        if (r101 >= ((ArrayList) r110).size()) goto L10;
        float[] r102 = (float[]) ListProtector.get(r110, r101);
        if (r101 <= 0) goto L8;
        r100.append(":");
    L8:
        r100.append(String.format(Locale.US, "%.0f,%.0f,%.0f", new Object[]{Double.valueOf(((double) r102[0]) * 1.0E8d), Double.valueOf(((double) r102[1]) * 1.0E8d), Double.valueOf(((double) r102[2]) * 1.0E8d)}));
        r101 = r101 + 1;
        goto L4
    L10:
        return r100.toString();
    }

    public final void d() {
        Object r100 = this.f199188l;
        monitor-enter(r100);
        q r101 = this.f199187k;     // Catch: Throwable -> L23
        long r102 = this.f199179c;     // Catch: Throwable -> L23
        ArrayList r103 = new ArrayList(this.f199185i);     // Catch: Throwable -> L23
        ArrayList r104 = new ArrayList(this.f199186j);     // Catch: Throwable -> L23
        ((ArrayList) this.f199185i).clear();     // Catch: Throwable -> L23
        ((ArrayList) this.f199186j).clear();     // Catch: Throwable -> L23
        this.f199187k = null;     // Catch: Throwable -> L23
        this.f199180d = false;     // Catch: Throwable -> L23
        this.f199181e = false;     // Catch: Throwable -> L23
        this.f199179c = 0;     // Catch: Throwable -> L23
        this.f199190n.set(false);     // Catch: Throwable -> L23
        this.f199189m.set(false);     // Catch: Throwable -> L23
        monitor-exit(r100);     // Catch: Throwable -> L23
        if (r101 != null) goto L28;
        return;
    L28:
        JSONObject r105 = new JSONObject();     // Catch: JSONException -> L20
        if (r103.isEmpty() == true) goto L14;
        r105.put("1", r102 + "#" + c(r103));     // Catch: JSONException -> L20
    L14:
        if (r104.isEmpty() == false) goto L17;
    L18:
        r101.a(r105);     // Catch: JSONException -> L20
        return;
    L17:
        r105.put("2", r102 + "#" + c(r104));     // Catch: JSONException -> L20
    L20:
        e = move-exception;
        r101.a("JSON generation failed: " + e.getMessage());
        return;
    L23:
        th = move-exception;
        throw th;
    }

    public final void f(String r100) {
        Object r101 = this.f199188l;
        monitor-enter(r101);
        q r102 = this.f199187k;     // Catch: Throwable -> L9
        this.f199187k = null;     // Catch: Throwable -> L9
        this.f199180d = false;     // Catch: Throwable -> L9
        this.f199181e = false;     // Catch: Throwable -> L9
        this.f199179c = 0;     // Catch: Throwable -> L9
        this.f199190n.set(false);     // Catch: Throwable -> L9
        this.f199189m.set(false);     // Catch: Throwable -> L9
        ((ArrayList) this.f199185i).clear();     // Catch: Throwable -> L9
        ((ArrayList) this.f199186j).clear();     // Catch: Throwable -> L9
        monitor-exit(r101);     // Catch: Throwable -> L9
        if (r102 == null) goto L14;
        r102.a(r100);
        return;
    L14:
        return;
    L9:
        th = move-exception;
        throw th;
    }

    public final synchronized void g() {
        monitor-enter(this);
    L10:
        th = move-exception;
        throw th;
    L4:
        if (this.f199191o == null) goto L7;
        monitor-exit(this);
        return;
    L7:
        PthreadHandlerThreadV2 r100 = new PthreadHandlerThreadV2("Badger-Sensor", 10);     // Catch: Throwable -> L10
        ThreadMethodProxy.start(r100);     // Catch: Throwable -> L10
        this.f199191o = r100;     // Catch: Throwable -> L10
        this.f199192p = new Handler(r100.getLooper());     // Catch: Throwable -> L10
        monitor-exit(this);
    }

    @Override // android.hardware.SensorEventListener
    public final void onAccuracyChanged(Sensor r100, int r101) {
    }

    @Override // android.app.Service
    public final IBinder onBind(Intent r100) {
        return new r(this);
    }

    @Override // android.app.Service
    public final void onDestroy() {
        e.f("event_behavior# ", "onDestroy####");
        final PthreadHandlerThreadV2 r100 = this.f199191o;
        Handler r101 = this.f199192p;
        this.f199191o = null;
        this.f199192p = null;
        if (r100 == null) goto L6;
        if (r101 == null) goto L6;
        r101.post(new a(this, r100));
    L6:
        super.onDestroy();
    }

    @Override // android.app.Service
    public final int onStartCommand(Intent r100, int r101, int r102) {
        return 2;
    }

    @Override // android.app.Service
    public final void onCreate() {
        super.onCreate();
        SensorManager r100 = (SensorManager) getSystemService(w.BLOB_ELEM_TYPE_SENSOR);
        this.f199182f = r100;
        this.f199183g = r100.getDefaultSensor(1);
        this.f199184h = this.f199182f.getDefaultSensor(4);
        g();
    }

    @Override // android.hardware.SensorEventListener
    public final void onSensorChanged(SensorEvent r110) {
        if (this.f199189m.get() == true) goto L5;
        return;
    L5:
        if (this.f199190n.get() == true) goto L68;
        float[] r100 = r110.values;
        float[] r101 = {r100[0], r100[1], r100[2]};
        Object r102 = this.f199188l;
        monitor-enter(r102);
    L56:
        th = move-exception;
        throw th;
    L10:
        if (this.f199179c != 0) goto L12;
        this.f199179c = System.currentTimeMillis();     // Catch: Throwable -> L56
    L12:
        int r111 = r110.sensor.getType();     // Catch: Throwable -> L56
        if (r111 == 1) goto L22;
        if (r111 == 4) goto L18;
    L25:
        if (this.f199180d == true) goto L27;
    L30:
        boolean r112 = true;
    L32:
        if (this.f199181e == true) goto L34;
    L37:
        boolean r103 = true;
    L39:
        if (this.f199180d == false) goto L41;
    L42:
        if (r112 == false) goto L45;
        if (r103 == false) goto L45;
        boolean r113 = true;
    L46:
        monitor-exit(r102);     // Catch: Throwable -> L56
        if (r113 == true) goto L49;
        return;
    L49:
        if (this.f199190n.compareAndSet(false, true) == false) goto L66;
        e.f("event_behavior# ", "stopSamplingInternal=" + ThreadMethodProxy.currentThread().getName());
        SensorManager r114 = this.f199182f;     // Catch: Throwable -> L60
        if (r114 == null) goto L54;
        b(r114, this);     // Catch: Throwable -> L60
    L54:
        d();     // Catch: Throwable -> L60
        return;
    L67:
        return;
    L66:
        return;
    L45:
        r113 = false;
        goto L46
    L41:
        if (this.f199181e == false) goto L45;
    L34:
        if (((ArrayList) this.f199186j).size() >= this.f199177a) goto L37;
        r103 = false;
        goto L39
    L27:
        if (((ArrayList) this.f199185i).size() >= this.f199177a) goto L30;
        r112 = false;
        goto L32
    L18:
        if (((ArrayList) this.f199186j).size() >= this.f199177a) goto L25;
        ArrayList r115 = (ArrayList) this.f199186j;     // Catch: Throwable -> L56
    L20:
        r115.add(r101);     // Catch: Throwable -> L56
        goto L25
    L22:
        if (((ArrayList) this.f199185i).size() >= this.f199177a) goto L25;
        r115 = (ArrayList) this.f199185i;     // Catch: Throwable -> L56
        goto L20
    }

    public static void b(SensorManager r100, SensorEventListener r101) {
        if (g.d() == true) goto L6;
        r100.unregisterListener(r101);
        return;
    L6:
        r100.unregisterListener(r101);
        if (r101 == null) goto L9;
        int r102 = r101.hashCode();
    L10:
        b.c(new ona.a(r102, null));
        return;
    L9:
        r102 = 0;
        goto L10
    }

    public final void e(int r100, int r101, l r102) {
        int r103 = 1;
        if (this.f199189m.compareAndSet(false, true) == true) goto L7;
        r102.a("Service is already collecting data.");
        return;
    L7:
        if (this.f199183g == null) goto L9;
    L12:
        e.b("sensor#", " start. size" + r100 + ",type" + r101);
        g();
        this.f199190n.set(false);
        this.f199187k = r102;
        Object r104 = this.f199188l;
        monitor-enter(r104);
        ((ArrayList) this.f199185i).clear();     // Catch: Throwable -> L33
        ((ArrayList) this.f199186j).clear();     // Catch: Throwable -> L33
        this.f199179c = 0;     // Catch: Throwable -> L33
        monitor-exit(r104);     // Catch: Throwable -> L33
        if (r100 > 0) goto L18;
        r100 = 10;
    L18:
        this.f199177a = r100;
        if (r101 != 0) goto L21;
        r103 = 0;
    L27:
        this.f199178b = r103;
        this.f199180d = false;
        this.f199181e = false;
        Handler r105 = this.f199192p;
        if (r105 != null) goto L31;
        f("sensor_thread_null");
        return;
    L31:
        r105.post(new a74.b(this));
        return;
    L21:
        if (r101 == 20) goto L27;
        if (r101 == 60) goto L25;
        r103 = 3;
        goto L27
    L25:
        r103 = 2;
    L33:
        th = move-exception;
        throw th;
    L9:
        if (this.f199184h != null) goto L12;
        r102.a("not support sensor");
        this.f199189m.set(false);
    }

    public static boolean a(SensorManager r100, SensorDataService r101, Sensor r102, int r103, Handler r104) {
        if (g.d() == true) goto L6;
        Boolean r105 = Boolean.valueOf(r100.registerListener(r101, r102, r103, r104));
        Intrinsics.checkNotNull(r105, "null cannot be cast to non-null type kotlin.Boolean");
        return r105.booleanValue();
    L6:
        Boolean r106 = Boolean.valueOf(r100.registerListener(r101, r102, r103, r104));
        Intrinsics.checkNotNull(r106, "null cannot be cast to non-null type kotlin.Boolean");
        boolean r107 = r106.booleanValue();
        b.a(new ona.a(r101.hashCode(), Integer.valueOf(r102.hashCode())));
        return r107;
    }
}
