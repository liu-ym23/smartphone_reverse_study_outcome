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
public class c extends z {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Context f273086a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final LinkedBlockingQueue<IBinder> f273087b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final ServiceConnection f273088c;

    public class a implements ServiceConnection {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ c f273089a;

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName r100) {
        }

        public a(c r100) {
            this.f273089a = r100;
        }

        @Override // android.content.ServiceConnection
        public void onServiceConnected(ComponentName r100, IBinder r101) {
            c.a(this.f273089a).offer(r101, 3000, TimeUnit.MILLISECONDS);     // Catch: Exception -> L4
            return;
        }
    }

    @Override // com.cmic.ida.sdk.z
    public String a() {
        Intent r100 = new Intent();
        r100.setAction("com.asus.msa.action.ACCESS_DID");
        r100.setComponent(new ComponentName("com.asus.msa.SupplementaryDID", "com.asus.msa.SupplementaryDID.SupplementaryDIDService"));
        String r101 = "";
        if (this.f273086a.bindService(r100, this.f273088c, 1) == true) goto L14;
    L12:
        return r101;
    L14:
        IBinder r102 = this.f273087b.poll(3000, TimeUnit.MILLISECONDS);     // Catch: Exception -> L13
        if (r102 != null) goto L7;
        return "";
    L7:
        Parcel r103 = Parcel.obtain();     // Catch: Exception -> L13
        Parcel r104 = Parcel.obtain();     // Catch: Exception -> L13
        r103.writeInterfaceToken("com.asus.msa.SupplementaryDID.IDidAidlInterface");     // Catch: Throwable -> L10
        INVOKEINTERFACE_com_cmic_ida_sdk_c_com_obric_assistant_interaction_impl_BinderLancet_transact(r102, 3, r103, r104, 0);     // Catch: Throwable -> L10
        r104.readException();     // Catch: Throwable -> L10
        r101 = r104.readString();     // Catch: Throwable -> L10
        this.f273086a.unbindService(this.f273088c);     // Catch: Throwable -> L10
        r103.recycle();     // Catch: Exception -> L13
    L11:
        r104.recycle();     // Catch: Exception -> L13
        goto L12
    L10:
        r103.recycle();     // Catch: Exception -> L13
        goto L11
    }

    public c(Context r100) {
        this.f273087b = new LinkedBlockingQueue(1);
        this.f273088c = new a(this);
        this.f273086a = r100;
    }

    public static /* synthetic */ LinkedBlockingQueue a(c r100) {
        return r100.f273087b;
    }

    @Skip({"com.obric.assistant.interaction.impl.performance"})
    public static boolean INVOKEINTERFACE_com_cmic_ida_sdk_c_com_obric_assistant_interaction_impl_BinderLancet_transact(IBinder r110, int r111, Parcel r112, Parcel r113, int r114) throws RemoteException {
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
