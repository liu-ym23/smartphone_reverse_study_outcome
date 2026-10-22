package com.vivo.push;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import android.text.TextUtils;
import com.vivo.push.util.ah;
import com.vivo.vms.IPCInvoke;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: loaded from: classes41.dex */
public final class i implements ServiceConnection {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final Object f462380a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static Map<String, i> f462381b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private boolean f462382c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private String f462383d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private Context f462384e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private AtomicInteger f462385f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private volatile IPCInvoke f462386g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private Object f462387h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private String f462388i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private Handler f462389j;

    static {
        f462380a = new Object();
        f462381b = new HashMap();
    }

    private void b() {
        int r100 = this.f462385f.get();
        com.vivo.push.util.t.d("AidlManager", "Enter connect, Connection Status: ".concat(String.valueOf(r100)));
        if (r100 != 4) goto L5;
        return;
    L5:
        if (r100 != 2) goto L7;
        return;
    L7:
        if (r100 != 3) goto L9;
        return;
    L9:
        if (r100 != 5) goto L12;
        return;
    L12:
        if (this.f462382c == false) goto L22;
        a(2);
        if (c() == true) goto L17;
        a(1);
        com.vivo.push.util.t.a("AidlManager", "bind core service fail");
        return;
    L17:
        d();
        return;
    }

    private boolean c() {
        Intent r100 = new Intent(this.f462388i);
        r100.setPackage(this.f462383d);
        return this.f462384e.bindService(r100, this, 1);
    L5:
        e = move-exception;
        com.vivo.push.util.t.a("AidlManager", "bind core error", e);
        return false;
    }

    private void d() {
        this.f462389j.removeMessages(1);
        this.f462389j.sendEmptyMessageDelayed(1, 3000);
    }

    private void e() {
        this.f462389j.removeMessages(1);
    }

    private void f() {
        this.f462384e.unbindService(this);     // Catch: Exception -> L4
        return;
    L4:
        e = move-exception;
        com.vivo.push.util.t.a("AidlManager", "On unBindServiceException:" + e.getMessage());
    }

    public final boolean a() {
        String r100 = com.vivo.push.util.aa.a(this.f462384e);
        this.f462383d = r100;
        boolean r101 = false;
        if (TextUtils.isEmpty(r100) == false) goto L7;
        com.vivo.push.util.t.c(this.f462384e, "push pkgname is null");
        return false;
    L7:
        if (ah.a(this.f462384e, this.f462383d) < 1260) goto L9;
        r101 = true;
    L9:
        this.f462382c = r101;
        return r101;
    }

    public static /* synthetic */ void b(i r100) {
        r100.a(1);
    }

    public static /* synthetic */ void c(i r100) {
        r100.f();
    }

    public final boolean a(Bundle r100) {
        b();
        if (this.f462385f.get() != 2) goto L35;
        Object r101 = this.f462387h;
        monitor-enter(r101);
        this.f462387h.wait(2000);     // Catch: Throwable -> L8 InterruptedException -> L10
    L12:
        monitor-exit(r101);     // Catch: Throwable -> L8
        goto L35
    L8:
        th = move-exception;
        throw th;
    L10:
        e = move-exception;
        e.printStackTrace();     // Catch: Throwable -> L8
    L35:
        int r102 = this.f462385f.get();     // Catch: Exception -> L23
        if (r102 != 4) goto L21;
        this.f462389j.removeMessages(2);     // Catch: Exception -> L23
        this.f462389j.sendEmptyMessageDelayed(2, 30000);     // Catch: Exception -> L23
        this.f462386g.asyncCall(r100, null);     // Catch: Exception -> L23
        return true;
    L21:
        com.vivo.push.util.t.d("AidlManager", "invoke error : connect status = ".concat(String.valueOf(r102)));     // Catch: Exception -> L23
        return false;
    L23:
        e = move-exception;
        com.vivo.push.util.t.a("AidlManager", "invoke error ", e);
        int r103 = this.f462385f.get();
        com.vivo.push.util.t.d("AidlManager", "Enter disconnect, Connection Status: ".concat(String.valueOf(r103)));
        if (r103 != 2) goto L27;
        e();
        a(1);
        return false;
    L27:
        if (r103 == 3) goto L31;
        if (r103 != 4) goto L42;
        a(1);
        f();
        return false;
    L42:
        return false;
    L31:
        a(1);
        return false;
    }

    @Override // android.content.ServiceConnection
    public final void onBindingDied(ComponentName r100) {
        com.vivo.push.util.t.b("AidlManager", "onBindingDied : ".concat(String.valueOf(r100)));
    }

    @Override // android.content.ServiceConnection
    public final void onServiceDisconnected(ComponentName r100) {
        this.f462386g = null;
        a(1);
    }

    private void a(int r100) {
        this.f462385f.set(r100);
    }

    public static /* synthetic */ AtomicInteger a(i r100) {
        return r100.f462385f;
    }

    private i(Context r100, String r101) {
        this.f462383d = null;
        this.f462387h = new Object();
        this.f462389j = null;
        this.f462384e = r100;
        this.f462388i = r101;
        boolean r102 = true;
        this.f462385f = new AtomicInteger(1);
        this.f462389j = new Handler(Looper.getMainLooper(), new j(this));
        String r103 = com.vivo.push.util.aa.a(r100);
        this.f462383d = r103;
        if (TextUtils.isEmpty(r103) == false) goto L5;
    L13:
        com.vivo.push.util.t.c(this.f462384e, "init error : push pkgname is " + this.f462383d + " ; action is " + this.f462388i);
        this.f462382c = false;
        return;
    L5:
        if (TextUtils.isEmpty(this.f462388i) == true) goto L13;
        if (ah.a(r100, this.f462383d) >= 1260) goto L11;
        r102 = false;
    L11:
        this.f462382c = r102;
        b();
    }

    public static i a(Context r100, String r101) {
        i r102 = f462381b.get(r101);
        if (r102 != null) goto L14;
        Object r103 = f462380a;
        monitor-enter(r103);
        i r104 = f462381b.get(r101);     // Catch: Throwable -> L11
        if (r104 != null) goto L9;
        r104 = new i(r100, r101);     // Catch: Throwable -> L11
        f462381b.put(r101, r104);     // Catch: Throwable -> L11
    L9:
        monitor-exit(r103);     // Catch: Throwable -> L11
        return r104;
    L11:
        th = move-exception;
        throw th;
    L14:
        return r102;
    }

    @Override // android.content.ServiceConnection
    public final void onServiceConnected(ComponentName r100, IBinder r101) {
        e();
        this.f462386g = IPCInvoke.Stub.asInterface(r101);
        if (this.f462386g != null) goto L7;
        com.vivo.push.util.t.d("AidlManager", "onServiceConnected error : aidl must not be null.");
        f();
        this.f462385f.set(1);
        return;
    L7:
        if (this.f462385f.get() != 2) goto L10;
        a(4);
    L12:
        Object r102 = this.f462387h;
        monitor-enter(r102);
        this.f462387h.notifyAll();     // Catch: Throwable -> L17
        monitor-exit(r102);     // Catch: Throwable -> L17
        return;
    L17:
        th = move-exception;
        throw th;
    L10:
        if (this.f462385f.get() == 4) goto L12;
        f();
        goto L12
    }
}
