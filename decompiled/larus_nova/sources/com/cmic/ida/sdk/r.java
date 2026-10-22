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
public class r extends z {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Context f273183a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final LinkedBlockingQueue<IBinder> f273184b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final ServiceConnection f273185c;

    public class a implements ServiceConnection {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ r f273186a;

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName r100) {
        }

        public a(r r100) {
            this.f273186a = r100;
        }

        @Override // android.content.ServiceConnection
        public void onServiceConnected(ComponentName r100, IBinder r101) {
            r.a(this.f273186a).offer(r101, 3000, TimeUnit.MILLISECONDS);     // Catch: InterruptedException -> L4
            return;
        }
    }

    @Override // com.cmic.ida.sdk.z
    public String a() {
        Intent r100 = new Intent();
        r100.setClassName("com.zui.deviceidservice", "com.zui.deviceidservice.DeviceidService");
        String r101 = "";
        if (this.f273183a.bindService(r100, this.f273185c, 1) == false) goto L15;
        Parcel r102 = Parcel.obtain();
        Parcel r103 = Parcel.obtain();
        IBinder r104 = this.f273184b.poll(3000, TimeUnit.MILLISECONDS);     // Catch: Throwable -> L11 Exception -> L14
        if (r104 != null) goto L9;
        r103.recycle();
        r102.recycle();
        this.f273183a.unbindService(this.f273185c);
        return "";
    L9:
        r102.writeInterfaceToken(com.alipay.sdk.m.q0.a.AbstractBinderC0490a.f25723a);     // Catch: Throwable -> L11 Exception -> L14
        INVOKEINTERFACE_com_cmic_ida_sdk_r_com_obric_assistant_interaction_impl_BinderLancet_transact(r104, 1, r102, r103, 0);     // Catch: Throwable -> L11 Exception -> L14
        r103.readException();     // Catch: Throwable -> L11 Exception -> L14
        r101 = r103.readString();     // Catch: Throwable -> L11 Exception -> L14
        r103.recycle();
        r102.recycle();
        this.f273183a.unbindService(this.f273185c);
        goto L15
    L14:
        r103.recycle();
        r102.recycle();
        this.f273183a.unbindService(this.f273185c);
    L11:
        th = move-exception;
        r103.recycle();
        r102.recycle();
        this.f273183a.unbindService(this.f273185c);
        throw th;
    L15:
        return r101;
    }

    public r(Context r100) {
        this.f273184b = new LinkedBlockingQueue(1);
        this.f273185c = new a(this);
        this.f273183a = r100;
    }

    public static /* synthetic */ LinkedBlockingQueue a(r r100) {
        return r100.f273184b;
    }

    @Skip({"com.obric.assistant.interaction.impl.performance"})
    public static boolean INVOKEINTERFACE_com_cmic_ida_sdk_r_com_obric_assistant_interaction_impl_BinderLancet_transact(IBinder r110, int r111, Parcel r112, Parcel r113, int r114) throws RemoteException {
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
