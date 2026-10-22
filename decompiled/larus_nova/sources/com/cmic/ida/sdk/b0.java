package com.cmic.ida.sdk;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.content.pm.Signature;
import android.os.IBinder;
import android.os.Looper;
import android.os.Parcel;
import android.os.RemoteException;
import android.os.SystemClock;
import com.obric.assistant.interaction.impl.performance.BinderPerformanceReporter;
import java.security.MessageDigest;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;
import kotlin.UByte;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: classes22.dex */
public class b0 extends z {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Context f273078a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final LinkedBlockingQueue<IBinder> f273079b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final ServiceConnection f273080c;

    public class a implements ServiceConnection {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ b0 f273081a;

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName r100) {
        }

        public a(b0 r100) {
            this.f273081a = r100;
        }

        @Override // android.content.ServiceConnection
        public void onServiceConnected(ComponentName r100, IBinder r101) {
            b0.a(this.f273081a).offer(r101, 3000, TimeUnit.MILLISECONDS);     // Catch: Throwable -> L4
            return;
        }
    }

    @Override // com.cmic.ida.sdk.z
    public String a() {
        Intent r100 = new Intent();
        r100.setComponent(new ComponentName("com.heytap.openid", "com.heytap.openid.IdentifyService"));
        r100.setAction("action.com.heytap.openid.OPEN_ID_SERVICE");
        String r101 = "";
        if (this.f273078a.bindService(r100, this.f273080c, 1) == false) goto L9;
        r101 = a(this.f273079b.poll(3000, TimeUnit.MILLISECONDS));     // Catch: Throwable -> L6
        this.f273078a.unbindService(this.f273080c);     // Catch: Throwable -> L6
        return r101;
    L10:
        return r101;
    L9:
        return "";
    }

    public b0(Context r100) {
        this.f273079b = new LinkedBlockingQueue(1);
        this.f273080c = new a(this);
        this.f273078a = r100;
    }

    private String a(IBinder r100) {
        String r101 = "";
        if (r100 != null) goto L5;
        return "";
    L5:
        String r102 = this.f273078a.getPackageName();
        String r103 = a(this.f273078a, r102);
        Parcel r104 = Parcel.obtain();     // Catch: Exception -> L13
        Parcel r105 = Parcel.obtain();     // Catch: Exception -> L13
        r104.writeInterfaceToken("com.heytap.openid.IOpenID");     // Catch: Throwable -> L9
        r104.writeString(r102);     // Catch: Throwable -> L9
        r104.writeString(r103);     // Catch: Throwable -> L9
        r104.writeString("OUID");     // Catch: Throwable -> L9
        INVOKEINTERFACE_com_cmic_ida_sdk_b0_com_obric_assistant_interaction_impl_BinderLancet_transact(r100, 1, r104, r105, 0);     // Catch: Throwable -> L9
        r105.readException();     // Catch: Throwable -> L9
        r101 = r105.readString();     // Catch: Throwable -> L9
        r104.recycle();     // Catch: Exception -> L13
        r105.recycle();     // Catch: Exception -> L13
        goto L12
    L9:
        th = move-exception;
        r104.recycle();     // Catch: Exception -> L13
        r105.recycle();     // Catch: Exception -> L13
        throw th;     // Catch: Exception -> L13
    L12:
        return r101;
    }

    public static /* synthetic */ LinkedBlockingQueue a(b0 r100) {
        return r100.f273079b;
    }

    private String a(Context r100, String r101) {
        Signature[] r102 = r100.getPackageManager().getPackageInfo(r101, 64).signatures;     // Catch: Exception -> L13
        if (r102 != null) goto L5;
        return "";
    L5:
        if (r102.length <= 0) goto L17;
        int r103 = 0;
        byte[] r104 = r102[0].toByteArray();     // Catch: Exception -> L13
        byte[] r105 = MessageDigest.getInstance("SHA1").digest(r104);     // Catch: Exception -> L13
        StringBuilder r106 = new StringBuilder();     // Catch: Exception -> L13
        int r107 = r105.length;     // Catch: Exception -> L13
    L7:
        if (r103 >= r107) goto L9;
        r106.append(Integer.toHexString((r105[r103] & UByte.MAX_VALUE) | 256).substring(1, 3));     // Catch: Exception -> L13
        r103 = r103 + 1;     // Catch: Exception -> L13
        goto L7
    L9:
        return r106.toString();
    L17:
        return "";
    L18:
        return "";
    }

    @Skip({"com.obric.assistant.interaction.impl.performance"})
    public static boolean INVOKEINTERFACE_com_cmic_ida_sdk_b0_com_obric_assistant_interaction_impl_BinderLancet_transact(IBinder r110, int r111, Parcel r112, Parcel r113, int r114) throws RemoteException {
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
