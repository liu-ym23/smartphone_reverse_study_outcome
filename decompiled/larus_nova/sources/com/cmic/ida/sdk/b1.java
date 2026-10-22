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
public class b1 extends z {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Context f273082a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final LinkedBlockingQueue<IBinder> f273083b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final ServiceConnection f273084c;

    public class a implements ServiceConnection {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ b1 f273085a;

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName r100) {
        }

        public a(b1 r100) {
            this.f273085a = r100;
        }

        @Override // android.content.ServiceConnection
        public void onServiceConnected(ComponentName r100, IBinder r101) {
            b1.a(this.f273085a).offer(r101, 3000, TimeUnit.MILLISECONDS);     // Catch: InterruptedException -> L4
            return;
        }
    }

    @Override // com.cmic.ida.sdk.z
    public String a() {
        Intent r100 = new Intent();
        r100.setClassName("com.mdid.msa", "com.mdid.msa.service.MsaIdService");
        r100.setAction("com.bun.msa.action.bindto.service");
        r100.putExtra("com.bun.msa.param.pkgname", this.f273082a.getPackageName());
        if (this.f273082a.bindService(r100, this.f273084c, 1) == true) goto L16;
    L12:
        return "";
    L16:
        IBinder r101 = this.f273083b.poll(3000, TimeUnit.MILLISECONDS);     // Catch: Exception -> L13
        if (r101 != null) goto L7;
        return "";
    L7:
        Parcel r102 = Parcel.obtain();     // Catch: Exception -> L13
        Parcel r103 = Parcel.obtain();     // Catch: Exception -> L13
        r102.writeInterfaceToken("com.bun.lib.MsaIdInterface");     // Catch: Throwable -> L11
        INVOKEINTERFACE_com_cmic_ida_sdk_b1_com_obric_assistant_interaction_impl_BinderLancet_transact(r101, 3, r102, r103, 0);     // Catch: Throwable -> L11
        r103.readException();     // Catch: Throwable -> L11
        String r104 = r103.readString();     // Catch: Throwable -> L11
        r102.recycle();     // Catch: Exception -> L13
        r103.recycle();     // Catch: Exception -> L13
        return r104;
    L11:
        r102.recycle();     // Catch: Exception -> L13
        r103.recycle();     // Catch: Exception -> L13
        this.f273082a.unbindService(this.f273084c);     // Catch: Exception -> L13
        goto L12
    }

    public b1(Context r100) {
        this.f273083b = new LinkedBlockingQueue(1);
        this.f273084c = new a(this);
        this.f273082a = r100;
    }

    public static /* synthetic */ LinkedBlockingQueue a(b1 r100) {
        return r100.f273083b;
    }

    @Skip({"com.obric.assistant.interaction.impl.performance"})
    public static boolean INVOKEINTERFACE_com_cmic_ida_sdk_b1_com_obric_assistant_interaction_impl_BinderLancet_transact(IBinder r110, int r111, Parcel r112, Parcel r113, int r114) throws RemoteException {
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
