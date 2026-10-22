package com.cmic.ida.sdk;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.Looper;
import android.os.Parcel;
import android.os.RemoteException;
import android.os.SystemClock;
import com.obric.assistant.interaction.impl.performance.BinderPerformanceReporter;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: classes22.dex */
public class i extends z {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Context f273129a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final LinkedBlockingQueue<IBinder> f273130b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final ServiceConnection f273131c;

    public class a implements ServiceConnection {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ i f273132a;

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName r100) {
        }

        public a(i r100) {
            this.f273132a = r100;
        }

        @Override // android.content.ServiceConnection
        public void onServiceConnected(ComponentName r100, IBinder r101) {
            this.f273132a.f273130b.offer(r101, 3000, TimeUnit.MILLISECONDS);     // Catch: InterruptedException -> L4
            return;
        }
    }

    @Override // com.cmic.ida.sdk.z
    public String a() {
        Intent r100 = new Intent();
        r100.setClassName("com.coolpad.deviceidsupport", "com.coolpad.deviceidsupport.DeviceIdService");
        String r101 = "";
        if (this.f273129a.bindService(r100, this.f273131c, 1) == true) goto L17;
        return "";
    L17:
        IBinder r102 = this.f273130b.poll(3000, TimeUnit.MILLISECONDS);     // Catch: InterruptedException -> L14
        if (r102 != null) goto L8;
        return "";
    L8:
        Parcel r103 = Parcel.obtain();     // Catch: InterruptedException -> L14
        Parcel r104 = Parcel.obtain();     // Catch: InterruptedException -> L14
        r103.writeInterfaceToken("com.coolpad.deviceidsupport.IDeviceIdManager");     // Catch: Throwable -> L11
        INVOKEINTERFACE_com_cmic_ida_sdk_i_com_obric_assistant_interaction_impl_BinderLancet_transact(r102, 1, r103, r104, 0);     // Catch: Throwable -> L11
        r104.readException();     // Catch: Throwable -> L11
        r101 = r104.readString();     // Catch: Throwable -> L11
        r104.recycle();     // Catch: InterruptedException -> L14
        r103.recycle();     // Catch: InterruptedException -> L14
        Context r105 = this.f273129a;     // Catch: InterruptedException -> L14
        ServiceConnection r106 = this.f273131c;     // Catch: InterruptedException -> L14
    L12:
        r105.unbindService(r106);     // Catch: InterruptedException -> L14
        goto L13
    L11:
        r104.recycle();     // Catch: InterruptedException -> L14
        r103.recycle();     // Catch: InterruptedException -> L14
        r105 = this.f273129a;     // Catch: InterruptedException -> L14
        r106 = this.f273131c;     // Catch: InterruptedException -> L14
    L13:
        return r101;
    }

    public i(Context r100) {
        this.f273130b = new LinkedBlockingQueue(1);
        this.f273131c = new a(this);
        this.f273129a = r100;
    }

    @Skip({"com.obric.assistant.interaction.impl.performance"})
    public static boolean INVOKEINTERFACE_com_cmic_ida_sdk_i_com_obric_assistant_interaction_impl_BinderLancet_transact(IBinder r110, int r111, Parcel r112, Parcel r113, int r114) throws RemoteException {
        if (Looper.myLooper() != Looper.getMainLooper()) goto L5;
        long r100 = SystemClock.uptimeMillis();
        boolean r101 = r110.transact(r111, r112, r113, r114);     // Catch: Throwable -> L12
        long r102 = SystemClock.uptimeMillis() - r100;
        if (r102 < 100) goto L11;
        BinderPerformanceReporter.report(r102, r110.getClass().getName(), r111, r114, new Throwable("Slow main-thread Binder transaction"));
    L11:
        return r101;
    L12:
        th = move-exception;
        long r103 = SystemClock.uptimeMillis() - r100;
        if (r103 < 100) goto L22;
        if (r110 != null) goto L17;
        String r104 = "";
    L18:
        BinderPerformanceReporter.report(r103, r104, r111, r114, new Throwable("Slow main-thread Binder transaction"));
        throw th;
    L17:
        r104 = r110.getClass().getName();
        goto L18
    L22:
        throw th;
    L5:
        return r110.transact(r111, r112, r113, r114);
    }
}
