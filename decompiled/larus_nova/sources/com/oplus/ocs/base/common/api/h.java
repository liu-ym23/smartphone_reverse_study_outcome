package com.oplus.ocs.base.common.api;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import com.oplus.ocs.base.IAuthenticationListener;

/* JADX INFO: loaded from: classes34.dex */
class h implements e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f404228a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private Context f404229b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private ServiceConnection f404230c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private IAuthenticationListener f404231d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private InternalClient f404232e;

    public class a implements ServiceConnection {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ h f404233a;

        private a(h r100) {
            this.f404233a = r100;
        }

        @Override // android.content.ServiceConnection
        public final void onServiceDisconnected(ComponentName r100) {
            com.oplus.ocs.base.utils.a.b(h.b(this.f404233a), "onServiceDisconnected()");
            h.c(this.f404233a);
        }

        public /* synthetic */ a(h r100, byte r101) {
            this(r100);
        }

        @Override // android.content.ServiceConnection
        public final void onServiceConnected(ComponentName r100, IBinder r101) {
            if (h.a(this.f404233a) == null) goto L9;
            h.a(this.f404233a).serviceUnbind();     // Catch: Exception -> L6
            return;
        L9:
            return;
        }
    }

    @Override // com.oplus.ocs.base.common.api.e
    public final boolean a() {
        boolean r100 = false;
        r100 = false;
    L23:
        e = e;
        boolean r101 = false;
    L25:
        com.oplus.ocs.base.utils.a.d(this.f404228a, String.format("in bind get an exception %s", new Object[]{e.getMessage()}));
        return r101;
    L4:
        if (this.f404229b.getApplicationContext() == null) goto L19;
        this.f404230c = new a(this, r100 ? 1 : 0);     // Catch: Exception -> L23
        Context r102 = this.f404229b.getApplicationContext();     // Catch: Exception -> L23
        IAuthenticationListener r103 = this.f404231d;     // Catch: Exception -> L23
        Intent r104 = this.f404232e.getServiceIntent("com.oplus.ocs.openauthenticate", "com.oplus.ocs", "com.oplus.ocs.service.OpenAuthenticateService");     // Catch: Exception -> L23
        if (r103 == null) goto L8;
        Bundle r105 = new Bundle();     // Catch: Exception -> L23
        r105.putBinder("internal_binder", r103.asBinder());     // Catch: Exception -> L23
        r104.putExtra("internal_bundle", r105);     // Catch: Exception -> L23
    L8:
        boolean r106 = r102.bindService(r104, this.f404230c, 1);     // Catch: Exception -> L23
        com.oplus.ocs.base.utils.a.d(this.f404228a, "connect state - ".concat(String.valueOf(r106)));     // Catch: Exception -> L17
        if (r106 == true) goto L16;
        IAuthenticationListener r107 = this.f404231d;     // Catch: Exception -> L17
        if (r107 == null) goto L16;
        r107.onFail(3);     // Catch: Exception -> L27
        return r106;
    L35:
        return r106;
    L16:
        r100 = r106;
    L33:
        return r100;
    L17:
        e = move-exception;
        r101 = r106;
        e = e;
        goto L25
    L19:
        IAuthenticationListener r108 = this.f404231d;     // Catch: Exception -> L23
        if (r108 == null) goto L33;
        r108.onFail(1009);     // Catch: Exception -> L23
        goto L33
    }

    @Override // com.oplus.ocs.base.common.api.e
    public final boolean b() {
        boolean r100 = false;
        r100 = false;
    L19:
        e = e;
        boolean r101 = false;
    L21:
        com.oplus.ocs.base.utils.a.d(this.f404228a, String.format("in bind get an exception %s", new Object[]{e.getMessage()}));
        return r101;
    L4:
        if (this.f404229b.getApplicationContext() == null) goto L15;
        this.f404230c = new a(this, r100 ? 1 : 0);     // Catch: Exception -> L19
        r101 = this.f404229b.getApplicationContext().bindService(this.f404232e.getServiceIntent4Stat("com.oplus.ocs.openauthenticate", "com.oplus.ocs", "com.oplus.ocs.service.OpenAuthenticateService"), this.f404230c, 1);     // Catch: Exception -> L19
        com.oplus.ocs.base.utils.a.d(this.f404228a, "connect stat state - ".concat(String.valueOf(r101)));     // Catch: Exception -> L13
        if (r101 == true) goto L12;
        IAuthenticationListener r102 = this.f404231d;     // Catch: Exception -> L13
        if (r102 == null) goto L12;
        r102.onFail(3);     // Catch: Exception -> L13
        return r101;
    L12:
        r100 = r101;
    L26:
        return r100;
    L13:
        e = e;
        goto L21
    L15:
        IAuthenticationListener r103 = this.f404231d;     // Catch: Exception -> L19
        if (r103 == null) goto L26;
        r103.onFail(1009);     // Catch: Exception -> L19
        goto L26
    }

    @Override // com.oplus.ocs.base.common.api.e
    public final void d() {
    }

    @Override // com.oplus.ocs.base.common.api.e
    public final void c() {
        if (this.f404230c != null) goto L7;
        com.oplus.ocs.base.utils.a.d(this.f404228a, "mServiceConnectionImpl is null");
        return;
    L7:
        if (this.f404229b.getApplicationContext() == null) goto L15;
        this.f404229b.getApplicationContext().unbindService(this.f404230c);     // Catch: Exception -> L10
        return;
    L10:
        e = move-exception;
        com.oplus.ocs.base.utils.a.d(this.f404228a, String.format("in unbind get an exception %s", new Object[]{e.getMessage()}));
        return;
    }

    public static /* synthetic */ InternalClient a(h r100) {
        return r100.f404232e;
    }

    public static /* synthetic */ String b(h r100) {
        return r100.f404228a;
    }

    public static /* synthetic */ ServiceConnection c(h r100) {
        r100.f404230c = null;
        return null;
    }

    public h(Context r100, InternalClient r101, IAuthenticationListener r102) {
        this.f404228a = "h";
        this.f404229b = r100;
        this.f404232e = r101;
        this.f404231d = r102;
    }
}
