package com.obric.assistant.dora;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import com.larus.utils.logger.FLogger;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes6.dex */
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final e f389108a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final CopyOnWriteArrayList<a> f389109b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static volatile Context f389110c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static volatile IDoraMainProcessBridgeService f389111d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static volatile boolean f389112e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static volatile boolean f389113f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final b f389114g = null;

    public interface a {
        void a();

        void b();
    }

    public static final class b implements ServiceConnection {
        public b() {
        }

        @Override // android.content.ServiceConnection
        public final void onBindingDied(ComponentName r100) {
            FLogger r101 = FLogger.f375446a;
            r101.w("DoraInteractorBridgeHub", "bridge onBindingDied: name=" + r100);
            e r102 = e.f389108a;
            r102.getClass();
            e.c();
            e.a(r102);
            if (e.f389113f == true) goto L5;
            r101.i("DoraInteractorBridgeHub", "rebindMainProcessBridgeServiceIfNeeded skipped: no active demand");
            return;
        L5:
            e.b();
        }

        @Override // android.content.ServiceConnection
        public final void onNullBinding(ComponentName r100) {
            FLogger.f375446a.w("DoraInteractorBridgeHub", "bridge onNullBinding: name=" + r100);
            e r101 = e.f389108a;
            r101.getClass();
            e.c();
            e.a(r101);
        }

        @Override // android.content.ServiceConnection
        public final void onServiceDisconnected(ComponentName r100) {
            FLogger r101 = FLogger.f375446a;
            r101.w("DoraInteractorBridgeHub", "bridge onServiceDisconnected: name=" + r100);
            e r102 = e.f389108a;
            r102.getClass();
            e.c();
            e.a(r102);
            if (e.f389113f == true) goto L5;
            r101.i("DoraInteractorBridgeHub", "rebindMainProcessBridgeServiceIfNeeded skipped: no active demand");
            return;
        L5:
            e.b();
        }

        @Override // android.content.ServiceConnection
        public final void onServiceConnected(ComponentName r100, IBinder r101) {
            FLogger r102 = FLogger.f375446a;
            r102.i("DoraInteractorBridgeHub", "bridge onServiceConnected: name=" + r100);
            IDoraMainProcessBridgeService r103 = IDoraMainProcessBridgeService.Stub.asInterface(r101);
            e r104 = e.f389108a;
            e.f389111d = r103;
            e.f389112e = true;
            if (r103 != null) goto L18;
            r102.e("DoraInteractorBridgeHub", "bridge onServiceConnected failed: binder is null");
            return;
        L18:
            Result.Companion r105 = Result.Companion;     // Catch: Throwable -> L12
            int r106 = r103.getStateSnapshot().f389090a;     // Catch: Throwable -> L12
            e.f389108a.getClass();     // Catch: Throwable -> L12
            Iterator<a> r107 = e.f389109b.iterator();     // Catch: Throwable -> L12
        L8:
            if (r107.hasNext() == false) goto L10;
            a r108 = r107.next();     // Catch: Throwable -> L12
            e r109 = e.f389108a;     // Catch: Throwable -> L12
            Intrinsics.checkNotNull(r108);     // Catch: Throwable -> L12
            r109.getClass();     // Catch: Throwable -> L12
            e.d(r108);     // Catch: Throwable -> L12
            goto L8
        L10:
            Object r110 = Result.m9449constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L12
        L14:
            Throwable r111 = Result.m9452exceptionOrNullimpl(r110);
            if (r111 == null) goto L21;
            FLogger.f375446a.e("DoraInteractorBridgeHub", "bridge onServiceConnected init failed: " + r111.getMessage());
            return;
        L21:
            return;
        L12:
            th = move-exception;
            Result.Companion r112 = Result.Companion;
            r110 = Result.m9449constructorimpl(ResultKt.createFailure(th));
            goto L14
        }
    }

    public e() {
    }

    public static void c() {
        f389111d = null;
        f389112e = false;
    }

    static {
        f389108a = new e();
        f389109b = new CopyOnWriteArrayList();
        f389114g = new b();
    }

    public static void b() {
        if (f389112e == false) goto L5;
        return;
    L5:
        Context r100 = f389110c;
        if (r100 != null) goto L9;
        FLogger.f375446a.e("DoraInteractorBridgeHub", "bindMainProcessBridgeService failed: applicationContext is null");
        return;
    L9:
        Intent r101 = new Intent(r100, DoraMainProcessBridgeService.class);
        Result.Companion r102 = Result.Companion;     // Catch: Throwable -> L12
        FLogger.f375446a.i("DoraInteractorBridgeHub", "bindMainProcessBridgeService startService before bindService");     // Catch: Throwable -> L12
        r100.startService(r101);     // Catch: Throwable -> L12
        Object r103 = Result.m9449constructorimpl(Boolean.valueOf(r100.bindService(r101, f389114g, 1)));     // Catch: Throwable -> L12
    L14:
        Throwable r104 = Result.m9452exceptionOrNullimpl(r103);
        if (r104 == null) goto L18;
        FLogger.f375446a.e("DoraInteractorBridgeHub", "bindMainProcessBridgeService failed: " + r104.getMessage());
        r103 = Boolean.FALSE;
    L18:
        f389112e = ((Boolean) r103).booleanValue();
        FLogger.f375446a.i("DoraInteractorBridgeHub", "bindMainProcessBridgeService: isBridgeBound=" + f389112e);
        return;
    L12:
        th = move-exception;
        Result.Companion r105 = Result.Companion;
        r103 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L14
    }

    public static final void a(e r100) {
        r100.getClass();
        Iterator<a> r101 = f389109b.iterator();
    L4:
        if (r101.hasNext() == false) goto L13;
        a r102 = r101.next();
        Result.Companion r103 = Result.Companion;     // Catch: Throwable -> L8
        r102.b();     // Catch: Throwable -> L8
        Object r104 = Result.m9449constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L8
    L10:
        Throwable r105 = Result.m9452exceptionOrNullimpl(r104);
        if (r105 == null) goto L4;
        FLogger.f375446a.e("DoraInteractorBridgeHub", "notifyBridgeUnavailable failed: " + r105.getMessage());
    L8:
        th = move-exception;
        Result.Companion r106 = Result.Companion;
        r104 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L10
    }

    public static void d(a r100) {
        Result.Companion r101 = Result.Companion;     // Catch: Throwable -> L4
        r100.a();     // Catch: Throwable -> L4
        Object r102 = Result.m9449constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L4
    L6:
        Throwable r103 = Result.m9452exceptionOrNullimpl(r102);
        if (r103 == null) goto L12;
        FLogger.f375446a.e("DoraInteractorBridgeHub", "notifySingleBridgeAvailable failed: " + r103.getMessage());
        return;
    L12:
        return;
    L4:
        th = move-exception;
        Result.Companion r104 = Result.Companion;
        r102 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L6
    }
}
