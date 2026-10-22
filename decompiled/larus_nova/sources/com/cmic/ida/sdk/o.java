package com.cmic.ida.sdk;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.IBinder;
import android.os.Looper;
import android.os.Parcel;
import android.os.RemoteException;
import android.os.SystemClock;
import android.provider.Settings;
import android.text.TextUtils;
import com.huawei.hms.common.PackageConstants;
import com.obric.assistant.interaction.impl.performance.BinderPerformanceReporter;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: classes22.dex */
public class o extends z {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Context f273170a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final LinkedBlockingQueue<IBinder> f273171b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final ServiceConnection f273172c;

    public class a implements ServiceConnection {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ o f273173a;

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName r100) {
        }

        public a(o r100) {
            this.f273173a = r100;
        }

        @Override // android.content.ServiceConnection
        public void onServiceConnected(ComponentName r100, IBinder r101) {
            o.a(this.f273173a).offer(r101, 3000, TimeUnit.MILLISECONDS);     // Catch: Exception -> L4
            return;
        }
    }

    @Override // com.cmic.ida.sdk.z
    public String a() {
        String r100 = Settings.Global.getString(this.f273170a.getContentResolver(), "pps_oaid");     // Catch: Exception -> L30
        if (a(r100) == true) goto L6;
        return r100;
    L6:
        Intent r101 = new Intent("com.uodis.opendevice.OPENIDS_SERVICE");     // Catch: Exception -> L30
        r101.setPackage(a(this.f273170a));     // Catch: Exception -> L30
        if (this.f273170a.bindService(r101, this.f273172c, 1) == true) goto L38;
    L32:
        return "";
    L38:
        IBinder r102 = this.f273171b.poll(3000, TimeUnit.MILLISECONDS);     // Catch: Throwable -> L25 Exception -> L28
        if (r102 != null) goto L12;
        this.f273170a.unbindService(this.f273172c);     // Catch: Exception -> L30
        return "";
    L12:
        Parcel r103 = Parcel.obtain();     // Catch: Throwable -> L25 Exception -> L28
        Parcel r104 = Parcel.obtain();     // Catch: Throwable -> L25 Exception -> L28
        r103.writeInterfaceToken(com.alipay.sdk.m.c.b.f25240a);     // Catch: Throwable -> L16
        INVOKEINTERFACE_com_cmic_ida_sdk_o_com_obric_assistant_interaction_impl_BinderLancet_transact(r102, 1, r103, r104, 0);     // Catch: Throwable -> L16
        r104.readException();     // Catch: Throwable -> L16
        String r105 = r104.readString();     // Catch: Throwable -> L16
        r103.recycle();     // Catch: Throwable -> L25 Exception -> L28
    L19:
        r104.recycle();     // Catch: Throwable -> L25 Exception -> L28
        this.f273170a.unbindService(this.f273172c);     // Catch: Exception -> L30
        return r105;
    L16:
        th = move-exception;
        th.printStackTrace();     // Catch: Throwable -> L22
        r103.recycle();     // Catch: Throwable -> L25 Exception -> L28
        r105 = "";
    L22:
        th = move-exception;
        r103.recycle();     // Catch: Throwable -> L25 Exception -> L28
        r104.recycle();     // Catch: Throwable -> L25 Exception -> L28
        throw th;     // Catch: Throwable -> L25 Exception -> L28
    L28:
        this.f273170a.unbindService(this.f273172c);     // Catch: Exception -> L30
    L25:
        th = move-exception;
        this.f273170a.unbindService(this.f273172c);     // Catch: Exception -> L30
        throw th;     // Catch: Exception -> L30
    L30:
        e = move-exception;
        e.printStackTrace();
        goto L32
    }

    public o(Context r100) {
        this.f273171b = new LinkedBlockingQueue(1);
        this.f273172c = new a(this);
        this.f273170a = r100;
    }

    private static String a(Context r100) {
        if (a(r100, "com.huawei.hwid") == true) goto L13;
        String r101 = PackageConstants.SERVICES_PACKAGE_ALL_SCENE;
        if (a(r100, PackageConstants.SERVICES_PACKAGE_ALL_SCENE) == true) goto L11;
        r101 = "com.huawei.hwid.tv";
        if (a(r100, "com.huawei.hwid.tv") == true) goto L11;
        return "com.huawei.hwid";
    L11:
        return r101;
    L13:
        return "com.huawei.hwid";
    }

    private static boolean a(String r100) {
        if (TextUtils.isEmpty(r100) == false) goto L7;
        return true;
    L7:
        return r100.replaceAll("0", "").replaceAll("-", "").isEmpty();
    }

    public static /* synthetic */ LinkedBlockingQueue a(o r100) {
        return r100.f273171b;
    }

    private static boolean a(Context r100, String r101) {
        if (b(r100, r101) == null) goto L5;
        return true;
    L5:
        return false;
    }

    private static PackageInfo b(Context r100, String r101) {
        if (TextUtils.isEmpty(r101) == true) goto L10;
        if (r100 == null) goto L10;
        PackageManager r102 = r100.getPackageManager();     // Catch: Throwable -> L11
        if (r102 == null) goto L10;
        return r102.getPackageInfo(r101, 128);
    L10:
        return null;
    }

    @Skip({"com.obric.assistant.interaction.impl.performance"})
    public static boolean INVOKEINTERFACE_com_cmic_ida_sdk_o_com_obric_assistant_interaction_impl_BinderLancet_transact(IBinder r110, int r111, Parcel r112, Parcel r113, int r114) throws RemoteException {
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
