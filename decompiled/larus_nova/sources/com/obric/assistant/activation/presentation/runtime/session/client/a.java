package com.obric.assistant.activation.presentation.runtime.session.client;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.SystemClock;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.activation.presentation.contract.ipc.IObricInteractorBridgeService;
import com.obric.assistant.activation.presentation.runtime.manager.ObricListeningChildCoordinator;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes32.dex */
public final class a implements ServiceConnection {

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final C4589a f385499i = null;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static volatile a f385500j;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ComponentName f385501a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public IBinder f385502b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Function1<? super IObricInteractorBridgeService, Unit> f385503c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public Function1<? super String, Unit> f385504d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f385505e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public Context f385506f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public long f385507g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public volatile boolean f385508h;

    /* JADX INFO: renamed from: com.obric.assistant.activation.presentation.runtime.session.client.a$a, reason: collision with other inner class name */
    public static final class C4589a {
        public C4589a() {
        }
    }

    static {
        f385499i = new C4589a();
    }

    public final IObricInteractorBridgeService c() {
        IBinder r100 = this.f385502b;
        if (r100 != null) goto L5;
        return null;
    L5:
        if (r100.isBinderAlive() == true) goto L8;
        r100 = null;
    L8:
        if (r100 != null) goto L10;
        return null;
    L10:
        return IObricInteractorBridgeService.Stub.asInterface(r100);
    }

    public final String g() {
        StringBuilder r100 = new StringBuilder("bound=");
        r100.append(this.f385505e);
        r100.append(", binding=");
        r100.append(this.f385508h);
        r100.append(", binderAlive=");
        IBinder r101 = this.f385502b;
        boolean r102 = false;
        if (r101 != null) goto L5;
    L7:
        r100.append(r102);
        return r100.toString();
    L5:
        if (r101.isBinderAlive() != true) goto L7;
        r102 = true;
        goto L7
    }

    public a(ComponentName r100) {
        this.f385501a = r100;
    }

    public final synchronized void a(Context r110) {
        monitor-enter(this);
        boolean r100 = false;
        if (this.f385508h == false) goto L13;
        long r101 = SystemClock.elapsedRealtime() - this.f385507g;     // Catch: Throwable -> L42
        if (r101 >= 10000) goto L11;
        FLogger.f375446a.i("ClientServiceConn", "skip bind: request already in progress, " + g());     // Catch: Throwable -> L42
        monitor-exit(this);
        return;
    L11:
        FLogger.f375446a.w("ClientServiceConn", "retry expired bind on real event, ageMs=" + r101 + ", " + g());     // Catch: Throwable -> L42
        this.f385505e = false;     // Catch: Throwable -> L42
        this.f385508h = false;     // Catch: Throwable -> L42
    L13:
        if (this.f385505e == false) goto L17;
        FLogger.f375446a.i("ClientServiceConn", "skip bind: binding already active, " + g());     // Catch: Throwable -> L42
        monitor-exit(this);
        return;
    L17:
        IBinder r102 = this.f385502b;     // Catch: Throwable -> L42
        if (r102 != null) goto L20;
    L22:
        boolean r103 = false;
    L23:
        if (r103 == false) goto L27;
        FLogger.f375446a.i("ClientServiceConn", "skip bind: Binder is alive, " + g());     // Catch: Throwable -> L42
        monitor-exit(this);
        return;
    L27:
        if (r110 != null) goto L31;
        FLogger.f375446a.e("ClientServiceConn", "skip bind: application context is null, " + g());     // Catch: Throwable -> L42
        monitor-exit(this);
        return;
    L31:
        Context r111 = r110.getApplicationContext();     // Catch: Throwable -> L42
        this.f385506f = r111;     // Catch: Throwable -> L42
        Intent r104 = new Intent();     // Catch: Throwable -> L42
        r104.setComponent(this.f385501a);     // Catch: Throwable -> L42
        r104.addFlags(1);     // Catch: Throwable -> L42
        r111.startService(r104);     // Catch: RuntimeException -> L34 Throwable -> L42
        r100 = r111.bindService(r104, this, 32);     // Catch: RuntimeException -> L34 Throwable -> L42
    L36:
        this.f385508h = r100;     // Catch: Throwable -> L42
        if (this.f385508h == false) goto L39;
        this.f385507g = SystemClock.elapsedRealtime();     // Catch: Throwable -> L42
    L39:
        this.f385505e = this.f385508h;     // Catch: Throwable -> L42
        FLogger.f375446a.i("ClientServiceConn", "bindService requested, component=" + this.f385501a.getClassName() + ", accepted=" + this.f385508h);     // Catch: Throwable -> L42
        monitor-exit(this);
        return;
    L34:
        e = move-exception;
        FLogger.f375446a.w("ClientServiceConn", "start/bind service threw, component=" + this.f385501a.getClassName(), e);     // Catch: Throwable -> L42
        goto L36
    L20:
        if (r102.isBinderAlive() != true) goto L22;
        r103 = true;
    L42:
        th = move-exception;
        throw th;
    }

    public final synchronized void b(Context r100) {
        monitor-enter(this);
        Context r101 = this.f385506f;     // Catch: Throwable -> L29
        if (r101 != null) goto L10;
        if (r100 == null) goto L8;
        r101 = r100.getApplicationContext();     // Catch: Throwable -> L29
        goto L10
    L8:
        r101 = null;
    L10:
        if (r101 != null) goto L14;
        FLogger.f375446a.e("ClientServiceConn", "disconnect without application context, force clear local state");     // Catch: Throwable -> L29
        this.f385502b = null;     // Catch: Throwable -> L29
        this.f385505e = false;     // Catch: Throwable -> L29
        this.f385508h = false;     // Catch: Throwable -> L29
        this.f385506f = null;     // Catch: Throwable -> L29
        monitor-exit(this);
        return;
    L14:
        FLogger.f375446a.i("ClientServiceConn", "disconnect start, " + g());     // Catch: Throwable -> L29
        if (this.f385505e == true) goto L33;
    L26:
        this.f385502b = null;     // Catch: Throwable -> L29
        this.f385505e = false;     // Catch: Throwable -> L29
        this.f385508h = false;     // Catch: Throwable -> L29
        this.f385506f = null;     // Catch: Throwable -> L29
        FLogger.f375446a.i("ClientServiceConn", "disconnect complete, " + g());     // Catch: Throwable -> L29
        monitor-exit(this);
        return;
    L33:
        Result.Companion r102 = Result.Companion;     // Catch: Throwable -> L18
        r101.unbindService(this);     // Catch: Throwable -> L18
        Object r103 = Result.m9449constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L18
    L21:
        if (Result.m9456isSuccessimpl(r103) == false) goto L23;
        Unit r104 = (Unit) r103;     // Catch: Throwable -> L29
        FLogger.f375446a.i("ClientServiceConn", "unbindService complete");     // Catch: Throwable -> L29
    L23:
        Throwable r105 = Result.m9452exceptionOrNullimpl(r103);     // Catch: Throwable -> L29
        if (r105 == null) goto L26;
        FLogger.f375446a.w("ClientServiceConn", "unbind service failed", r105);     // Catch: Throwable -> L29
    L18:
        th = move-exception;
        Result.Companion r106 = Result.Companion;     // Catch: Throwable -> L29
        r103 = Result.m9449constructorimpl(ResultKt.createFailure(th));     // Catch: Throwable -> L29
    L29:
        th = move-exception;
        throw th;
    }

    public final synchronized void d(Context r100) {
        monitor-enter(this);
        FLogger.f375446a.i("ClientServiceConn", "reconnect start, " + g());     // Catch: Throwable -> L22
        Context r101 = this.f385506f;     // Catch: Throwable -> L22
        if (r101 != null) goto L10;
        if (r100 == null) goto L8;
        r101 = r100.getApplicationContext();     // Catch: Throwable -> L22
        goto L10
    L8:
        r101 = null;
    L10:
        if (this.f385505e == false) goto L19;
        if (r101 == null) goto L19;
        Result.Companion r102 = Result.Companion;     // Catch: Throwable -> L14
        r101.unbindService(this);     // Catch: Throwable -> L14
        Object r103 = Result.m9449constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L14
    L16:
        Throwable r104 = Result.m9452exceptionOrNullimpl(r103);     // Catch: Throwable -> L22
        if (r104 == null) goto L19;
        FLogger.f375446a.w("ClientServiceConn", "unbind before reconnect failed", r104);     // Catch: Throwable -> L22
        goto L19
    L14:
        th = move-exception;
        Result.Companion r105 = Result.Companion;     // Catch: Throwable -> L22
        r103 = Result.m9449constructorimpl(ResultKt.createFailure(th));     // Catch: Throwable -> L22
    L19:
        this.f385502b = null;     // Catch: Throwable -> L22
        this.f385505e = false;     // Catch: Throwable -> L22
        this.f385508h = false;     // Catch: Throwable -> L22
        a(r101);     // Catch: Throwable -> L22
        FLogger.f375446a.i("ClientServiceConn", "reconnect requested, " + g());     // Catch: Throwable -> L22
        monitor-exit(this);
        return;
    L22:
        th = move-exception;
        throw th;
    }

    public final synchronized void e(d r100) {
        monitor-enter(this);
        Intrinsics.checkNotNullParameter(r100, "listener");     // Catch: Throwable -> L13
        this.f385503c = r100;     // Catch: Throwable -> L13
        IObricInteractorBridgeService r101 = c();     // Catch: Throwable -> L13
        FLogger r102 = FLogger.f375446a;     // Catch: Throwable -> L13
        StringBuilder r103 = new StringBuilder("setConnectedListener, dispatchImmediately=");     // Catch: Throwable -> L13
        if (r101 == null) goto L7;
        boolean r104 = true;
    L8:
        r103.append(r104);     // Catch: Throwable -> L13
        r102.i("ClientServiceConn", r103.toString());     // Catch: Throwable -> L13
        if (r101 == null) goto L11;
        r100.invoke(r101);     // Catch: Throwable -> L13
    L11:
        monitor-exit(this);
        return;
    L7:
        r104 = false;
    L13:
        th = move-exception;
        throw th;
    }

    public final synchronized void f(c r100) {
        monitor-enter(this);
        Intrinsics.checkNotNullParameter(r100, "listener");     // Catch: Throwable -> L6
        this.f385504d = r100;     // Catch: Throwable -> L6
        monitor-exit(this);
        return;
    L6:
        th = move-exception;
        throw th;
    }

    @Override // android.content.ServiceConnection
    public final void onBindingDied(ComponentName r100) {
        FLogger r101 = FLogger.f375446a;
        StringBuilder r102 = new StringBuilder("onBindingDied, component=");
        if (r100 == null) goto L5;
        String r103 = r100.getClassName();
    L6:
        r102.append(r103);
        r102.append("; release binding and wait for real event");
        r101.w("ClientServiceConn", r102.toString());
        Function1<? super String, Unit> r104 = this.f385504d;
        if (r104 == null) goto L9;
        r104.invoke("binding_died");
    L9:
        this.f385508h = false;
        this.f385502b = null;
        Context r105 = this.f385506f;
        if (this.f385505e == false) goto L20;
        if (r105 == null) goto L20;
        Result.Companion r106 = Result.Companion;     // Catch: Throwable -> L14
        r105.unbindService(this);     // Catch: Throwable -> L14
        Object r107 = Result.m9449constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L14
    L16:
        Throwable r108 = Result.m9452exceptionOrNullimpl(r107);
        if (r108 == null) goto L19;
        FLogger.f375446a.w("ClientServiceConn", "unbind dead binding failed", r108);
    L19:
        this.f385505e = false;
    L14:
        th = move-exception;
        Result.Companion r109 = Result.Companion;
        r107 = Result.m9449constructorimpl(ResultKt.createFailure(th));
    L20:
        this.f385502b = null;
        this.f385505e = false;
        this.f385508h = false;
        this.f385506f = null;
        super.onBindingDied(r100);
        return;
    L5:
        r103 = null;
        goto L6
    }

    @Override // android.content.ServiceConnection
    public final void onNullBinding(ComponentName r100) {
        this.f385508h = false;
        String r101 = null;
        this.f385502b = null;
        FLogger r102 = FLogger.f375446a;
        StringBuilder r103 = new StringBuilder("onNullBinding, component=");
        if (r100 == null) goto L5;
        r101 = r100.getClassName();
    L5:
        r103.append(r101);
        r103.append("; release unusable binding");
        r102.w("ClientServiceConn", r103.toString());
        Function1<? super String, Unit> r104 = this.f385504d;
        if (r104 == null) goto L8;
        r104.invoke("null_binding");
    L8:
        b(this.f385506f);
    }

    @Override // android.content.ServiceConnection
    public final void onServiceDisconnected(ComponentName r100) {
        FLogger r101 = FLogger.f375446a;
        StringBuilder r102 = new StringBuilder("onServiceDisconnected, component=");
        if (r100 == null) goto L5;
        String r103 = r100.getClassName();
    L6:
        r102.append(r103);
        r102.append(", release binding; ");
        r102.append(g());
        r101.w("ClientServiceConn", r102.toString());
        Function1<? super String, Unit> r104 = this.f385504d;
        if (r104 == null) goto L9;
        r104.invoke("service_disconnected");
    L9:
        ObricListeningChildCoordinator.f385289a.getClass();
        ObricListeningChildCoordinator.i(new com.obric.assistant.activation.presentation.runtime.manager.p());
        b(this.f385506f);
        return;
    L5:
        r103 = null;
        goto L6
    }

    @Override // android.content.ServiceConnection
    public final void onServiceConnected(ComponentName r100, IBinder r101) {
        boolean r102 = false;
        this.f385508h = false;
        this.f385505e = true;
        this.f385502b = r101;
        FLogger r103 = FLogger.f375446a;
        StringBuilder r104 = new StringBuilder("onServiceConnected, component=");
        if (r100 == null) goto L5;
        String r105 = r100.getClassName();
    L6:
        r104.append(r105);
        r104.append(", hasBinder=");
        if (r101 == null) goto L9;
        boolean r106 = true;
    L10:
        r104.append(r106);
        r104.append(", binderAlive=");
        if (r101 != null) goto L13;
    L15:
        boolean r107 = false;
    L16:
        r104.append(r107);
        r104.append(", hasListener=");
        if (this.f385503c == null) goto L19;
        r102 = true;
    L19:
        r104.append(r102);
        r103.i("ClientServiceConn", r104.toString());
        IObricInteractorBridgeService r108 = IObricInteractorBridgeService.Stub.asInterface(r101);
        if (r108 != null) goto L23;
        r103.w("ClientServiceConn", "connected Binder cannot resolve bridge interface");
        return;
    L23:
        Function1<? super IObricInteractorBridgeService, Unit> r109 = this.f385503c;
        if (r109 == null) goto L27;
        r109.invoke(r108);
        return;
    L27:
        return;
    L13:
        if (r101.isBinderAlive() != true) goto L15;
        r107 = true;
        goto L16
    L9:
        r106 = false;
        goto L10
    L5:
        r105 = null;
        goto L6
    }
}
