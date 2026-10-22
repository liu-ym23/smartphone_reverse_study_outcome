package com.bytedance.monitor.collector;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.util.Pair;
import androidx.fragment.app.Fragment;
import b27.g;
import b27.h;
import com.bytedance.android.bytehook.ByteHook;
import com.bytedance.apm.core.ActivityLifeObserver;
import com.bytedance.apm.d;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.CopyOnWriteArrayList;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public final class c {

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static volatile boolean f265641j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static volatile c f265642k;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List<AbsMonitor> f265643a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public volatile boolean f265644b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public volatile boolean f265645c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public volatile boolean f265646d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f265647e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public BinderMonitor f265648f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public h f265649g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public b27.c f265650h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public b f265651i;

    public class a implements ff7.c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ c f265652a;

        @Override // ff7.c
        public final void onActivityCreated(Activity r100, Bundle r101) {
        }

        @Override // ff7.c
        public final void onActivityPause(Activity r100) {
        }

        @Override // ff7.c
        public final void onActivityResume(Activity r100) {
        }

        @Override // ff7.c
        public final void onActivityStarted(Activity r100) {
        }

        @Override // ff7.c
        public final void onChange(Activity r100, Fragment r101) {
        }

        public a(c r100) {
            this.f265652a = r100;
        }

        @Override // ff7.c
        public final void onBackground(Activity r100) {
            this.f265652a.getClass();
        }

        @Override // ff7.c
        public final void onFront(Activity r100) {
            this.f265652a.getClass();
        }
    }

    public static c e() {
        if (f265642k != null) goto L15;
        monitor-enter(c.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (f265642k != null) goto L9;
        f265642k = new c();     // Catch: Throwable -> L11
    L9:
        monitor-exit(c.class);     // Catch: Throwable -> L11
    L15:
        return f265642k;
    }

    public final long a() {
        if (this.f265647e == true) goto L7;
        return com.bytedance.apm.util.b.a();
    L7:
        if (f265641j == true) goto L12;
        return 0;
    L12:
        return MonitorJni.doGetAppCpuTime();
    L11:
        return 0;
    }

    public final JSONObject b() {
        JSONObject r100 = new JSONObject();
        int r101 = 0;
    L10:
    L7:
        e = move-exception;
        e.printStackTrace();
    L9:
        return r100;
    L4:
        if (r101 >= ((CopyOnWriteArrayList) this.f265643a).size()) goto L9;
        Pair<String, ?> r102 = ((AbsMonitor) ListProtector.get(this.f265643a, r101)).a();     // Catch: Exception -> L7
        r100.put((String) r102.first, r102.second);     // Catch: Exception -> L7
        r101 = r101 + 1;
        goto L10
    }

    public final b.e f() {
        b r100 = this.f265651i;
        if (r100 == null) goto L16;
        b.f r101 = r100.f265592j;
        if (r101 != null) goto L9;
        return null;
    L9:
        if (r100.f265600r == true) goto L12;
        return null;
    L12:
        if (r101.b().f265626d == 8) goto L15;
        return null;
    L15:
        return r100.f265592j.b();
    L16:
        return null;
    }

    public c() {
        this.f265644b = false;
        this.f265645c = false;
        this.f265646d = false;
        this.f265643a = new CopyOnWriteArrayList();
        ActivityLifeObserver.getInstance().register(new a(this));
    }

    public static synchronized boolean h(Context r100) {
        monitor-enter(c.class);
    L10:
        th = move-exception;
        throw th;
    L5:
        if (f265641j == true) goto L7;
        f265641j = e27.b.b(r100);     // Catch: Throwable -> L10
        ByteHook.init();     // Catch: Throwable -> L10
    L7:
        boolean r101 = f265641j;     // Catch: Throwable -> L10
        monitor-exit(c.class);
        return r101;
    }

    public final long d(int r100) {
        if (this.f265647e == true) goto L7;
        return com.bytedance.apm.util.b.j();
    L7:
        if (f265641j == true) goto L12;
        return 0;
    L12:
        return MonitorJni.getTotalCPUTimeByTimeInStat(r100);
    L11:
        return 0;
    }

    public final synchronized void i(g r100) {
        monitor-enter(this);
    L40:
        th = move-exception;
        throw th;
    L4:
        if (d.j() == false) goto L11;
        Objects.toString(r100);     // Catch: Throwable -> L40
        if (f265641j == false) goto L11;
        MonitorJni.doSetDebugMode(true);     // Catch: Throwable -> L43
    L11:
        if (f265641j == true) goto L15;
        monitor-exit(this);
        return;
    L15:
        if (this.f265649g != null) goto L18;
        this.f265649g = new h(r100.f17054f);     // Catch: Throwable -> L40
    L18:
        if (r100.f17050b == false) goto L24;
        if (this.f265648f != null) goto L22;
        this.f265648f = new BinderMonitor(r100.f17054f);     // Catch: Throwable -> L40
    L22:
        this.f265648f.getClass();     // Catch: Throwable -> L40
        MonitorJni.enableBinderHook();     // Catch: Throwable -> L40
    L24:
        if (r100.f17049a == false) goto L34;
        if (this.f265650h != null) goto L28;
        this.f265650h = new b27.c(r100.f17054f);     // Catch: Throwable -> L40
    L28:
        b27.c r101 = this.f265650h;     // Catch: Throwable -> L40
        long r102 = r100.f17053e;     // Catch: Throwable -> L40
        r101.getClass();     // Catch: Throwable -> L40
        if (f265641j == false) goto L34;
        MonitorJni.doEnableAtrace(r101.f265561c, r102);     // Catch: Throwable -> L44
    L34:
        if (r100.f17051c == true) goto L36;
    L38:
        monitor-exit(this);
        return;
    L36:
        if (this.f265651i != null) goto L38;
        this.f265651i = new b(r100.f17054f);     // Catch: Throwable -> L40
        goto L38
    }

    public final JSONObject c(long r100, long r101) {
        JSONObject r102 = new JSONObject();
        int r103 = 0;
    L4:
        if (r103 >= ((CopyOnWriteArrayList) this.f265643a).size()) goto L7;
        Pair<String, ?> r104 = ((AbsMonitor) ListProtector.get(this.f265643a, r103)).b(r100, r101);     // Catch: Exception -> L8
        r102.put((String) r104.first, r104.second);     // Catch: Exception -> L8
    L6:
        r103 = r103 + 1;
        goto L4
    L7:
        return r102;
    }

    public final synchronized void g(Context r100, g r101) {
        monitor-enter(this);
    L20:
        th = move-exception;
        throw th;
    L4:
        if (this.f265644b == false) goto L12;
        if (d.j() == false) goto L8;
        Objects.toString(r101);     // Catch: Throwable -> L20
        new Throwable();     // Catch: Throwable -> L20
    L8:
        i(r101);     // Catch: Throwable -> L20
        monitor-exit(this);
        return;
    L12:
        if (h(r100) == true) goto L25;
    L18:
        monitor-exit(this);
        return;
    L25:
        if (f265641j == false) goto L17;
        MonitorJni.doInit();     // Catch: Throwable -> L23
    L17:
        i(r101);     // Catch: Throwable -> L20
        this.f265644b = true;     // Catch: Throwable -> L20
        goto L18
    }
}
