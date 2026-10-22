package com.xiaomi.push;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.content.pm.PackageInfo;
import android.os.IBinder;
import android.os.Looper;
import android.os.Parcel;
import android.os.RemoteException;
import android.os.SystemClock;
import com.obric.assistant.interaction.impl.performance.BinderPerformanceReporter;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import com.ss.android.ugc.bytex.pthread.base.proxy.PthreadThreadV2;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: classes41.dex */
class ag implements ah {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static boolean f463113a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private volatile int f218a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private Context f219a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private ServiceConnection f220a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private final Object f221a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private volatile String f222a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private volatile String f463114b;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    private volatile boolean f223b;

    /* JADX INFO: renamed from: com.xiaomi.push.ag$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
    }

    public class a implements ServiceConnection {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ ag f463115a;

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName r100) {
        }

        private a(ag r100) {
            this.f463115a = r100;
        }

        public /* synthetic */ a(ag r100, AnonymousClass1 r101) {
            this(r100);
        }

        @Override // android.content.ServiceConnection
        public void onServiceConnected(ComponentName r100, final IBinder r101) {
            ThreadMethodProxy.start(new PthreadThreadV2(new AnonymousClass1(this, r101), "omi/push/ag$a"));
        }
    }

    public static class b {
        /* JADX INFO: renamed from: a, reason: collision with other method in class */
        public static boolean m8806a(IBinder r100) {
            Parcel r101 = Parcel.obtain();
            Parcel r102 = Parcel.obtain();
            r101.writeInterfaceToken(com.alipay.sdk.m.c.b.f25240a);     // Catch: Throwable -> L8
            boolean r103 = false;
            INVOKEINTERFACE_com_xiaomi_push_ag$b_com_obric_assistant_interaction_impl_BinderLancet_transact(r100, 2, r101, r102, 0);     // Catch: Throwable -> L8
            r102.readException();     // Catch: Throwable -> L8
            if (r102.readInt() == 0) goto L6;
            r103 = true;
        L6:
            r102.recycle();
            r101.recycle();
            return r103;
        L8:
            th = move-exception;
            r102.recycle();
            r101.recycle();
            throw th;
        }

        public static String a(IBinder r100) {
            Parcel r101 = Parcel.obtain();
            Parcel r102 = Parcel.obtain();
            r101.writeInterfaceToken(com.alipay.sdk.m.c.b.f25240a);     // Catch: Throwable -> L6
            INVOKEINTERFACE_com_xiaomi_push_ag$b_com_obric_assistant_interaction_impl_BinderLancet_transact(r100, 1, r101, r102, 0);     // Catch: Throwable -> L6
            r102.readException();     // Catch: Throwable -> L6
            String r103 = r102.readString();     // Catch: Throwable -> L6
            r102.recycle();
            r101.recycle();
            return r103;
        L6:
            th = move-exception;
            r102.recycle();
            r101.recycle();
            throw th;
        }

        @Skip({"com.obric.assistant.interaction.impl.performance"})
        public static boolean INVOKEINTERFACE_com_xiaomi_push_ag$b_com_obric_assistant_interaction_impl_BinderLancet_transact(IBinder r110, int r111, Parcel r112, Parcel r113, int r114) throws RemoteException {
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

    private void a() {
        this.f220a = new a(this, null);
        Intent r100 = new Intent("com.uodis.opendevice.OPENIDS_SERVICE");
        r100.setPackage("com.huawei.hwid");
        int r101 = 1;
        boolean r102 = this.f219a.bindService(r100, this.f220a, 1);     // Catch: Exception -> L5
    L6:
        if (r102 == true) goto L9;
        r101 = 2;
    L9:
        this.f218a = r101;
        return;
    L5:
        r102 = false;
        goto L6
    }

    private void b() {
        ServiceConnection r100 = this.f220a;
        if (r100 == null) goto L9;
        this.f219a.unbindService(r100);     // Catch: Exception -> L6
        return;
    L10:
        return;
    }

    @Override // com.xiaomi.push.ah
    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public String mo8804a() {
        a("getOAID");
        return this.f222a;
    }

    @Override // com.xiaomi.push.ah
    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public boolean mo8805a() {
        return f463113a;
    }

    public ag(Context r100) {
        this.f218a = 0;
        this.f222a = null;
        this.f223b = false;
        this.f463114b = null;
        this.f221a = new Object();
        this.f219a = r100;
        a();
    }

    private void a(String r100) {
        if (this.f218a == 1) goto L5;
        return;
    L5:
        if (Looper.myLooper() == Looper.getMainLooper()) goto L21;
        Object r101 = this.f221a;
        monitor-enter(r101);
        com.xiaomi.channel.commonutils.logger.b.m8718a("huawei's " + r100 + " wait...");     // Catch: Throwable -> L10 Exception -> L17
        this.f221a.wait(3000);     // Catch: Throwable -> L10 Exception -> L17
    L10:
        th = move-exception;
        throw th;
    L12:
        monitor-exit(r101);     // Catch: Throwable -> L10
        return;
    }

    public static boolean a(Context r100) {
        PackageInfo r101 = r100.getPackageManager().getPackageInfo("com.huawei.hwid", 128);     // Catch: Exception -> L15
        if ((r101.applicationInfo.flags & 1) == 0) goto L6;
        boolean r102 = true;
    L8:
        if (r101.versionCode < 20602000) goto L10;
        boolean r103 = true;
    L11:
        f463113a = r103;     // Catch: Exception -> L15
        if (r102 == false) goto L14;
        return true;
    L10:
        r103 = false;
        goto L11
    L6:
        r102 = false;
    L14:
        return false;
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public static /* synthetic */ void m8803a(ag r100) {
        r100.b();
    }

    public static /* synthetic */ Object a(ag r100) {
        return r100.f221a;
    }

    public static /* synthetic */ int a(ag r100, int r101) {
        r100.f218a = r101;
        return r101;
    }

    public static /* synthetic */ String a(ag r100, String r101) {
        r100.f222a = r101;
        return r101;
    }

    public static /* synthetic */ boolean a(ag r100, boolean r101) {
        r100.f223b = r101;
        return r101;
    }
}
