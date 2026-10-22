package com.google.android.gms.common.internal;

import android.app.PendingIntent;
import android.os.Looper;
import android.os.Message;
import com.google.android.gms.common.ConnectionResult;

/* JADX INFO: loaded from: classes23.dex */
public final class h extends com.google.android.gms.internal.common.l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ BaseGmsClient f274540a;

    @Override // android.os.Handler
    public final void handleMessage(Message r110) {
        boolean r100 = false;
        if (this.f274540a.zzd.get() == r110.arg1) goto L12;
        int r101 = r110.what;
        if (r101 == 2) goto L8;
        if (r101 == 1) goto L8;
        if (r101 == 7) goto L8;
    L9:
        if (r100 == false) goto L101;
        i r111 = (i) r110.obj;
        r111.b();
        r111.d();
        return;
    L101:
        return;
    L8:
        r100 = true;
        goto L9
    L12:
        int r102 = r110.what;
        if (r102 == 1) goto L21;
        if (r102 == 7) goto L21;
        if (r102 != 4) goto L19;
        if (this.f274540a.enableLocalFallback() == false) goto L21;
    L19:
        if (r110.what == 5) goto L21;
    L22:
        int r103 = r110.what;
        PendingIntent r104 = null;
        if (r103 != 4) goto L37;
        BaseGmsClient.zzg(this.f274540a, new ConnectionResult(r110.arg2));
        if (BaseGmsClient.zzo(this.f274540a) == false) goto L31;
        BaseGmsClient r112 = this.f274540a;
        if (BaseGmsClient.zzm(r112) == true) goto L31;
        BaseGmsClient.zzi(r112, 3, null);
        return;
    L31:
        BaseGmsClient r113 = this.f274540a;
        if (BaseGmsClient.zza(r113) == null) goto L34;
        ConnectionResult r114 = BaseGmsClient.zza(r113);
    L35:
        ((BaseGmsClient.b) this.f274540a.zzc).a(r114);
        this.f274540a.onConnectionFailed(r114);
        return;
    L34:
        r114 = new ConnectionResult(8);
        goto L35
    L37:
        if (r103 != 5) goto L44;
        BaseGmsClient r115 = this.f274540a;
        if (BaseGmsClient.zza(r115) == null) goto L41;
        ConnectionResult r116 = BaseGmsClient.zza(r115);
    L42:
        ((BaseGmsClient.b) this.f274540a.zzc).a(r116);
        this.f274540a.onConnectionFailed(r116);
        return;
    L41:
        r116 = new ConnectionResult(8);
        goto L42
    L44:
        if (r103 != 3) goto L51;
        Object r105 = r110.obj;
        if ((r105 instanceof PendingIntent) == false) goto L48;
        r104 = (PendingIntent) r105;
    L48:
        ConnectionResult r106 = new ConnectionResult(r110.arg2, r104);
        ((BaseGmsClient.b) this.f274540a.zzc).a(r106);
        this.f274540a.onConnectionFailed(r106);
        return;
    L51:
        if (r103 != 6) goto L57;
        BaseGmsClient.zzi(this.f274540a, 5, null);
        BaseGmsClient r107 = this.f274540a;
        if (BaseGmsClient.zzb(r107) == null) goto L55;
        BaseGmsClient.zzb(r107).onConnectionSuspended(r110.arg2);
    L55:
        this.f274540a.onConnectionSuspended(r110.arg2);
        BaseGmsClient.zzn(this.f274540a, 5, 1, null);
        return;
    L57:
        if (r103 == 2) goto L59;
    L63:
        int r108 = r110.what;
        if (r108 == 2) goto L67;
        if (r108 == 1) goto L67;
        if (r108 == 7) goto L67;
    L68:
        if (r100 == false) goto L91;
        i r117 = (i) r110.obj;
        monitor-enter(r117);
        Object r109 = r117.f274541a;     // Catch: Throwable -> L88
        if (r117.f274542b == false) goto L74;
        r117.toString();     // Catch: Throwable -> L88
    L74:
        monitor-exit(r117);     // Catch: Throwable -> L88
        if (r109 != null) goto L97;
    L80:
        monitor-enter(r117);
        r117.f274542b = true;     // Catch: Throwable -> L85
        monitor-exit(r117);     // Catch: Throwable -> L85
        r117.d();
        return;
    L85:
        th = move-exception;
        throw th;
    L97:
        r117.a();     // Catch: RuntimeException -> L78
    L78:
        e = move-exception;
        throw e;
    L88:
        th = move-exception;
        throw th;
    L91:
        new Exception();
        return;
    L67:
        r100 = true;
        goto L68
    L59:
        if (this.f274540a.isConnected() == true) goto L63;
        i r118 = (i) r110.obj;
        r118.b();
        r118.d();
        return;
    L21:
        if (this.f274540a.isConnecting() == true) goto L22;
        i r119 = (i) r110.obj;
        r119.b();
        r119.d();
    }

    public h(BaseGmsClient r100, Looper r101) {
        this.f274540a = r100;
        super(r101);
    }
}
