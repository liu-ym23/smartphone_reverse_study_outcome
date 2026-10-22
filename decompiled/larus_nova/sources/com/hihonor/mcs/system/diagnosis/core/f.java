package com.hihonor.mcs.system.diagnosis.core;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.Process;
import android.os.RemoteException;
import android.util.ArrayMap;
import com.hihonor.mcs.system.diagnosis.core.performance.Performance;
import com.hihonor.mcs.system.diagnosis.core.powerthermal.PowerThermal;
import com.hihonor.mcs.system.diagnosis.core.pressure.Resource;
import com.hihonor.mcs.system.diagnosis.core.stability.Stability;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes23.dex */
public final class f {

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static f f276645j;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Object f276646a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public IDiagKitInterface f276647b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Map<ICallbackPayload, Stability> f276648c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Map<ICallbackPayload, Performance> f276649d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Map<ICallbackPayload, PowerThermal> f276650e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Map<IPressureCallbackPayload, Resource> f276651f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public String f276652g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final Context f276653h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final AtomicBoolean f276654i;

    public class a implements ServiceConnection {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ f f276655a;

        public a(f r100) {
            this.f276655a = r100;
        }

        @Override // android.content.ServiceConnection
        public final void onServiceDisconnected(ComponentName r100) {
            Object r101 = this.f276655a.f276646a;
            monitor-enter(r101);
            this.f276655a.f276647b = null;     // Catch: Throwable -> L7
            monitor-exit(r101);     // Catch: Throwable -> L7
            return;
        L7:
            th = move-exception;
            throw th;
        }

        @Override // android.content.ServiceConnection
        public final void onServiceConnected(ComponentName r100, IBinder r101) {
            Object r102 = this.f276655a.f276646a;
            monitor-enter(r102);
            f r103 = this.f276655a;     // Catch: RuntimeException -> L10 Throwable -> L12 Throwable -> L14
            r103.f276647b = IDiagKitInterface.Stub.asInterface(r101);     // Catch: RuntimeException -> L10 Throwable -> L12 Throwable -> L14
            f r104 = this.f276655a;     // Catch: RuntimeException -> L10 Throwable -> L12 Throwable -> L14
            IDiagKitInterface r105 = r104.f276647b;     // Catch: RuntimeException -> L10 Throwable -> L12 Throwable -> L14
            if (r105 != null) goto L8;
            monitor-exit(r102);     // Catch: Throwable -> L14
            return;
        L8:
            r104.m(r105);     // Catch: RuntimeException -> L10 Throwable -> L12 Throwable -> L14
            f r106 = this.f276655a;     // Catch: RuntimeException -> L10 Throwable -> L12 Throwable -> L14
            String r107 = r106.f276652g;     // Catch: RuntimeException -> L10 Throwable -> L12 Throwable -> L14
            r106.f276647b.pushAarVersionToService("2.0.0.1");     // Catch: RuntimeException -> L10 Throwable -> L12 Throwable -> L14
            f.a(this.f276655a);     // Catch: RuntimeException -> L10 Throwable -> L12 Throwable -> L14
            f.b(this.f276655a);     // Catch: RuntimeException -> L10 Throwable -> L12 Throwable -> L14
            f.c(this.f276655a);     // Catch: RuntimeException -> L10 Throwable -> L12 Throwable -> L14
            f.d(this.f276655a);     // Catch: RuntimeException -> L10 Throwable -> L12 Throwable -> L14
        L17:
            monitor-exit(r102);     // Catch: Throwable -> L14
            return;
        L14:
            th = move-exception;
            throw th;
        L12:
            e = move-exception;
            e.getMessage();     // Catch: Throwable -> L14
            goto L17
        }
    }

    public f(Context r100) {
        this.f276646a = new Object();
        this.f276647b = null;
        this.f276648c = new ArrayMap();
        this.f276649d = new ArrayMap();
        this.f276650e = new ArrayMap();
        this.f276651f = new ArrayMap();
        this.f276652g = null;
        this.f276653h = null;
        this.f276654i = new AtomicBoolean();
        this.f276653h = r100;
    }

    public static f f(Context r100) {
        monitor-enter(f.class);
    L10:
        th = move-exception;
        throw th;
    L5:
        if (f276645j != null) goto L7;
        f276645j = new f(r100);     // Catch: Throwable -> L10
    L7:
        f r101 = f276645j;     // Catch: Throwable -> L10
        monitor-exit(f.class);     // Catch: Throwable -> L10
        return r101;
    }

    public static List h(Resource r100) {
        ArrayList r101 = new ArrayList();
        Iterator r102 = r100.getKinds().iterator();
    L4:
        if (r102.hasNext() == false) goto L6;
        r101.add(((Resource.Kind) r102.next()).toString());
        goto L4
    L6:
        return r101;
    }

    public final void i(com.hihonor.mcs.system.diagnosis.core.a r100) {
        if (this.f276654i.get() == false) goto L6;
        return;
    L6:
        if (this.f276654i.compareAndSet(false, true) == false) goto L9;
        Process.myPid();
        Intent r101 = new Intent();
        r101.setComponent(new ComponentName("com.hihonor.hiview", "com.hihonor.mcs.system.diagnosis.service.DiagKitService"));
        a r102 = new a(this);
        this.f276653h.bindService(r101, 1, r100, r102);
        return;
    }

    public final void j(PowerThermal r100, ShareMemoryCallbackWrapper r101, com.hihonor.mcs.system.diagnosis.core.a r102) {
        Object r103 = this.f276646a;
        monitor-enter(r103);
        ((ArrayMap) this.f276650e).put(r101, r100);     // Catch: Throwable -> L17
        if (this.f276647b != null) goto L21;
        i(r102);     // Catch: Throwable -> L17
        monitor-exit(r103);     // Catch: Throwable -> L17
        return;
    L21:
        List<String> r104 = g(r100);     // Catch: RemoteException -> L14 Throwable -> L17
        if (((ArrayList) r104).size() <= 0) goto L12;
        this.f276647b.registerPowerThermalPayload(r104, r101);     // Catch: RemoteException -> L14 Throwable -> L17
    L12:
        monitor-exit(r103);     // Catch: Throwable -> L17
        return;
    L14:
        e = move-exception;
        ((ArrayMap) this.f276650e).remove(r101);     // Catch: Throwable -> L17
        throw new RuntimeException(e);     // Catch: Throwable -> L17
    L17:
        th = move-exception;
        throw th;
    }

    public final void k(Resource r100, BinderCallbackWrapper r101, com.hihonor.mcs.system.diagnosis.core.a r102) {
        Object r103 = this.f276646a;
        monitor-enter(r103);
        ((ArrayMap) this.f276651f).put(r101, r100);     // Catch: Throwable -> L17
        if (this.f276647b != null) goto L21;
        i(r102);     // Catch: Throwable -> L17
        monitor-exit(r103);     // Catch: Throwable -> L17
        return;
    L21:
        List<String> r104 = h(r100);     // Catch: RemoteException -> L14 Throwable -> L17
        if (((ArrayList) r104).size() <= 0) goto L12;
        this.f276647b.registerPressurePayload(r104, r101);     // Catch: RemoteException -> L14 Throwable -> L17
    L12:
        monitor-exit(r103);     // Catch: Throwable -> L17
        return;
    L14:
        e = move-exception;
        ((ArrayMap) this.f276651f).remove(r101);     // Catch: Throwable -> L17
        throw new RuntimeException(e);     // Catch: Throwable -> L17
    L17:
        th = move-exception;
        throw th;
    }

    public final void l(Stability r100, ShareMemoryCallbackWrapper r101, com.hihonor.mcs.system.diagnosis.core.a r102) {
        Object r103 = this.f276646a;
        monitor-enter(r103);
        ((ArrayMap) this.f276648c).put(r101, r100);     // Catch: Throwable -> L17
        if (this.f276647b != null) goto L21;
        i(r102);     // Catch: Throwable -> L17
        monitor-exit(r103);     // Catch: Throwable -> L17
        return;
    L21:
        List<String> r104 = e(r100);     // Catch: RemoteException -> L14 Throwable -> L17
        if (((ArrayList) r104).size() <= 0) goto L12;
        this.f276647b.registerStabilityPayload(r104, r101);     // Catch: RemoteException -> L14 Throwable -> L17
    L12:
        monitor-exit(r103);     // Catch: Throwable -> L17
        return;
    L14:
        e = move-exception;
        ((ArrayMap) this.f276648c).remove(r101);     // Catch: Throwable -> L17
        throw new RuntimeException(e);     // Catch: Throwable -> L17
    L17:
        th = move-exception;
        throw th;
    }

    public final void m(IDiagKitInterface r100) {
    L6:
        e = move-exception;
        e.getMessage();
        return;
    L3:
        if (this.f276652g != null) goto L11;
        this.f276652g = r100.getServiceVersion();     // Catch: Exception -> L6
        return;
    }

    public final void n(ShareMemoryCallbackWrapper r100) {
        Object r101 = this.f276646a;
        monitor-enter(r101);
        ((ArrayMap) this.f276650e).remove(r100);     // Catch: Throwable -> L14
        IDiagKitInterface r102 = this.f276647b;     // Catch: Throwable -> L14
        if (r102 != null) goto L18;
        monitor-exit(r101);     // Catch: Throwable -> L14
        return;
    L18:
        r102.unregisterPowerThermalPayload(r100);     // Catch: RemoteException -> L10 Throwable -> L14
    L12:
        monitor-exit(r101);     // Catch: Throwable -> L14
        return;
    L10:
        e = move-exception;
        e.toString();     // Catch: Throwable -> L14
    L14:
        th = move-exception;
        throw th;
    }

    public final void o(BinderCallbackWrapper r100) {
        Object r101 = this.f276646a;
        monitor-enter(r101);
        ((ArrayMap) this.f276651f).remove(r100);     // Catch: Throwable -> L14
        IDiagKitInterface r102 = this.f276647b;     // Catch: Throwable -> L14
        if (r102 != null) goto L18;
        monitor-exit(r101);     // Catch: Throwable -> L14
        return;
    L18:
        r102.unregisterPressurePayload(r100);     // Catch: RemoteException -> L10 Throwable -> L14
    L12:
        monitor-exit(r101);     // Catch: Throwable -> L14
        return;
    L10:
        e = move-exception;
        e.toString();     // Catch: Throwable -> L14
    L14:
        th = move-exception;
        throw th;
    }

    public final void p(ShareMemoryCallbackWrapper r100) {
        Object r101 = this.f276646a;
        monitor-enter(r101);
        ((ArrayMap) this.f276648c).remove(r100);     // Catch: Throwable -> L14
        IDiagKitInterface r102 = this.f276647b;     // Catch: Throwable -> L14
        if (r102 != null) goto L18;
        monitor-exit(r101);     // Catch: Throwable -> L14
        return;
    L18:
        r102.unregisterStabilityPayload(r100);     // Catch: RemoteException -> L10 Throwable -> L14
    L12:
        monitor-exit(r101);     // Catch: Throwable -> L14
        return;
    L10:
        e = move-exception;
        e.toString();     // Catch: Throwable -> L14
    L14:
        th = move-exception;
        throw th;
    }

    public static void a(final f r100) {
        Map<ICallbackPayload, Stability> r101 = r100.f276648c;
        ArrayMap r102 = (ArrayMap) r101;
        r102.forEach(new b(r100));
    }

    public static void b(final f r100) {
        Map<ICallbackPayload, Performance> r101 = r100.f276649d;
        ArrayMap r102 = (ArrayMap) r101;
        r102.forEach(new c(r100));
    }

    public static void c(final f r100) {
        Map<ICallbackPayload, PowerThermal> r101 = r100.f276650e;
        ArrayMap r102 = (ArrayMap) r101;
        r102.forEach(new e(r100));
    }

    public static void d(final f r100) {
        Map<IPressureCallbackPayload, Resource> r101 = r100.f276651f;
        ArrayMap r102 = (ArrayMap) r101;
        r102.forEach(new d(r100));
    }

    public static List e(Stability r100) {
        ArrayList r101 = new ArrayList();
        Iterator r102 = r100.f276669a.iterator();
    L4:
        if (r102.hasNext() == false) goto L6;
        r101.add(((Stability.Kind) r102.next()).toString());
        goto L4
    L6:
        return r101;
    }

    public static List g(PowerThermal r100) {
        ArrayList r101 = new ArrayList();
        Iterator r102 = r100.f276660a.iterator();
    L4:
        if (r102.hasNext() == false) goto L6;
        r101.add(((PowerThermal.Kind) r102.next()).toString());
        goto L4
    L6:
        return r101;
    }
}
