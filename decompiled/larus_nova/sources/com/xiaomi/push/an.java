package com.xiaomi.push;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.content.pm.PackageInfo;
import android.content.pm.Signature;
import android.os.Build;
import android.os.IBinder;
import android.os.Looper;
import android.os.Parcel;
import android.os.RemoteException;
import android.os.SystemClock;
import com.obric.assistant.interaction.impl.performance.BinderPerformanceReporter;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import com.ss.android.ugc.bytex.pthread.base.proxy.PthreadThreadV2;
import java.security.MessageDigest;
import kotlin.UByte;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: classes41.dex */
class an implements ah {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static boolean f463135a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private volatile int f240a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private Context f241a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private ServiceConnection f242a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private volatile a f243a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private final Object f244a;

    /* JADX INFO: renamed from: com.xiaomi.push.an$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
    }

    public class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ an f463136a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        String f245a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        String f463137b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        String f463138c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        String f463139d;

        private a(an r100) {
            this.f463136a = r100;
            this.f245a = null;
            this.f463137b = null;
            this.f463138c = null;
            this.f463139d = null;
        }

        public /* synthetic */ a(an r100, AnonymousClass1 r101) {
            this(r100);
        }
    }

    public class b implements ServiceConnection {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ an f463140a;

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName r100) {
        }

        private b(an r100) {
            this.f463140a = r100;
        }

        public /* synthetic */ b(an r100, AnonymousClass1 r101) {
            this(r100);
        }

        @Override // android.content.ServiceConnection
        public void onServiceConnected(ComponentName r100, final IBinder r101) {
            if (an.m8807a(this.f463140a) == null) goto L5;
            return;
        L5:
            ThreadMethodProxy.start(new PthreadThreadV2(new AnonymousClass1(this, r101), "omi/push/an$b"));
        }
    }

    public static class c {
        public static String a(IBinder r100, String r101, String r102, String r103) {
            Parcel r104 = Parcel.obtain();
            Parcel r105 = Parcel.obtain();
            r104.writeInterfaceToken("com.heytap.openid.IOpenID");     // Catch: Throwable -> L6
            r104.writeString(r101);     // Catch: Throwable -> L6
            r104.writeString(r102);     // Catch: Throwable -> L6
            r104.writeString(r103);     // Catch: Throwable -> L6
            INVOKEINTERFACE_com_xiaomi_push_an$c_com_obric_assistant_interaction_impl_BinderLancet_transact(r100, 1, r104, r105, 0);     // Catch: Throwable -> L6
            r105.readException();     // Catch: Throwable -> L6
            String r106 = r105.readString();     // Catch: Throwable -> L6
            r105.recycle();
            r104.recycle();
            return r106;
        L6:
            th = move-exception;
            r105.recycle();
            r104.recycle();
            throw th;
        }

        @Skip({"com.obric.assistant.interaction.impl.performance"})
        public static boolean INVOKEINTERFACE_com_xiaomi_push_an$c_com_obric_assistant_interaction_impl_BinderLancet_transact(IBinder r110, int r111, Parcel r112, Parcel r113, int r114) throws RemoteException {
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
        this.f242a = new b(this, null);
        Intent r100 = new Intent();
        r100.setClassName("com.heytap.openid", "com.heytap.openid.IdentifyService");
        r100.setAction("action.com.heytap.openid.OPEN_ID_SERVICE");
        int r101 = 1;
        boolean r102 = this.f241a.bindService(r100, this.f242a, 1);     // Catch: Exception -> L5
    L6:
        if (r102 == true) goto L9;
        r101 = 2;
    L9:
        this.f240a = r101;
        return;
    L5:
        r102 = false;
        goto L6
    }

    private String b() {
        Signature[] r100 = this.f241a.getPackageManager().getPackageInfo(this.f241a.getPackageName(), 64).signatures;     // Catch: Exception -> L8
        MessageDigest r101 = MessageDigest.getInstance("SHA1");     // Catch: Exception -> L8
        StringBuilder r102 = new StringBuilder();     // Catch: Exception -> L8
        int r103 = 0;
        byte[] r104 = r101.digest(r100[0].toByteArray());     // Catch: Exception -> L8
    L4:
        if (r103 >= r104.length) goto L6;
        r102.append(Integer.toHexString((r104[r103] & UByte.MAX_VALUE) | 256).substring(1, 3));     // Catch: Exception -> L8
        r103 = r103 + 1;     // Catch: Exception -> L8
        goto L4
    L6:
        return r102.toString();
    L8:
        return "";
    }

    /* JADX INFO: renamed from: b, reason: collision with other method in class */
    private void m8811b() {
        ServiceConnection r100 = this.f242a;
        if (r100 == null) goto L9;
        this.f241a.unbindService(r100);     // Catch: Exception -> L6
        return;
    L10:
        return;
    }

    @Override // com.xiaomi.push.ah
    /* JADX INFO: renamed from: a */
    public String mo8804a() {
        a("getOAID");
        if (this.f243a != null) goto L6;
        return null;
    L6:
        return this.f243a.f463137b;
    }

    @Override // com.xiaomi.push.ah
    /* JADX INFO: renamed from: a */
    public boolean mo8805a() {
        return f463135a;
    }

    public an(Context r100) {
        this.f240a = 0;
        this.f243a = null;
        this.f244a = new Object();
        this.f241a = r100;
        a();
    }

    private void a(String r100) {
        if (this.f240a == 1) goto L5;
        return;
    L5:
        if (Looper.myLooper() == Looper.getMainLooper()) goto L21;
        Object r101 = this.f244a;
        monitor-enter(r101);
        com.xiaomi.channel.commonutils.logger.b.m8718a("oppo's " + r100 + " wait...");     // Catch: Throwable -> L10 Exception -> L17
        this.f244a.wait(3000);     // Catch: Throwable -> L10 Exception -> L17
    L10:
        th = move-exception;
        throw th;
    L12:
        monitor-exit(r101);     // Catch: Throwable -> L10
        return;
    }

    public static boolean a(Context r100) {
        PackageInfo r101 = r100.getPackageManager().getPackageInfo("com.heytap.openid", 128);     // Catch: Exception -> L21
        if (r101 == null) goto L20;
        if (Build.VERSION.SDK_INT < 28) goto L8;
        long r102 = r101.getLongVersionCode();     // Catch: Exception -> L21
    L10:
        if ((r101.applicationInfo.flags & 1) == 0) goto L12;
        boolean r103 = true;
    L14:
        if (r102 < 1) goto L16;
        boolean r104 = true;
    L17:
        f463135a = r104;     // Catch: Exception -> L21
        if (r103 == false) goto L20;
        return true;
    L16:
        r104 = false;
        goto L17
    L12:
        r103 = false;
        goto L14
    L8:
        r102 = r101.versionCode;     // Catch: Exception -> L21
    L20:
        return false;
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public static /* synthetic */ String m8809a(an r100) {
        return r100.b();
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public static /* synthetic */ void m8810a(an r100) {
        r100.m8811b();
    }

    public static /* synthetic */ Context a(an r100) {
        return r100.f241a;
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public static /* synthetic */ a m8807a(an r100) {
        return r100.f243a;
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public static /* synthetic */ Object m8808a(an r100) {
        return r100.f244a;
    }

    public static /* synthetic */ int a(an r100, int r101) {
        r100.f240a = r101;
        return r101;
    }

    public static /* synthetic */ a a(an r100, a r101) {
        r100.f243a = r101;
        return r101;
    }
}
