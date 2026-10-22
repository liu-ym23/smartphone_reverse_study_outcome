package com.oplus.ocs.base.common.api;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import com.oplus.ocs.base.IAuthenticationListener;

/* JADX INFO: loaded from: classes34.dex */
class f implements e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f404207a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private Context f404208b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private ServiceConnection f404209c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private IAuthenticationListener f404210d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private InternalClient f404211e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private com.coloros.ocs.base.IAuthenticationListener f404212f;

    public class a implements ServiceConnection {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ f f404214a;

        private a(f r100) {
            this.f404214a = r100;
        }

        @Override // android.content.ServiceConnection
        public final void onServiceDisconnected(ComponentName r100) {
            com.oplus.ocs.base.utils.a.b(f.c(this.f404214a), "onServiceDisconnected()");
            f.d(this.f404214a);
        }

        public /* synthetic */ a(f r100, byte r101) {
            this(r100);
        }

        @Override // android.content.ServiceConnection
        public final void onServiceConnected(ComponentName r100, IBinder r101) {
        L6:
            e = move-exception;
            e.printStackTrace();
            return;
        L3:
            if (f.b(this.f404214a) == null) goto L11;
            f.b(this.f404214a).serviceUnbind();     // Catch: Exception -> L6
            return;
        }
    }

    @Override // com.oplus.ocs.base.common.api.e
    public final boolean a() {
        boolean r100 = false;
        r100 = false;
    L22:
        e = e;
        boolean r101 = false;
    L24:
        com.oplus.ocs.base.utils.a.d(this.f404207a, String.format("in bind get an exception %s", new Object[]{e.getMessage()}));
        return r101;
    L4:
        if (this.f404208b.getApplicationContext() == null) goto L18;
        this.f404209c = new a(this, r100 ? 1 : 0);     // Catch: Exception -> L22
        Context r102 = this.f404208b.getApplicationContext();     // Catch: Exception -> L22
        com.coloros.ocs.base.IAuthenticationListener r103 = this.f404212f;     // Catch: Exception -> L22
        Intent r104 = this.f404211e.getServiceIntent("com.coloros.opencapabilityservice", "com.coloros.ocs.opencapabilityservice", "com.coloros.ocs.opencapabilityservice.service.ColorOcsService");     // Catch: Exception -> L22
        if (r103 == null) goto L8;
        Bundle r105 = new Bundle();     // Catch: Exception -> L22
        r105.putBinder("internal_binder", r103.asBinder());     // Catch: Exception -> L22
        r104.putExtra("internal_bundle", r105);     // Catch: Exception -> L22
    L8:
        boolean r106 = r102.bindService(r104, this.f404209c, 1);     // Catch: Exception -> L22
        com.oplus.ocs.base.utils.a.d(this.f404207a, "connect state - ".concat(String.valueOf(r106)));     // Catch: Exception -> L16
        if (r106 == true) goto L15;
        IAuthenticationListener r107 = this.f404210d;     // Catch: Exception -> L16
        if (r107 == null) goto L15;
        r107.onFail(3);     // Catch: Exception -> L16
        return r106;
    L15:
        r100 = r106;
    L29:
        return r100;
    L16:
        e = move-exception;
        r101 = r106;
        e = e;
        goto L24
    L18:
        IAuthenticationListener r108 = this.f404210d;     // Catch: Exception -> L22
        if (r108 == null) goto L29;
        r108.onFail(1009);     // Catch: Exception -> L22
        goto L29
    }

    @Override // com.oplus.ocs.base.common.api.e
    public final boolean b() {
        boolean r100 = false;
        r100 = false;
    L19:
        e = e;
        boolean r101 = false;
    L21:
        com.oplus.ocs.base.utils.a.d(this.f404207a, String.format("in bind get an exception %s", new Object[]{e.getMessage()}));
        return r101;
    L4:
        if (this.f404208b.getApplicationContext() == null) goto L15;
        this.f404209c = new a(this, r100 ? 1 : 0);     // Catch: Exception -> L19
        r101 = this.f404208b.getApplicationContext().bindService(this.f404211e.getServiceIntent4Stat("com.coloros.opencapabilityservice", "com.coloros.ocs.opencapabilityservice", "com.coloros.ocs.opencapabilityservice.service.ColorOcsService"), this.f404209c, 1);     // Catch: Exception -> L19
        com.oplus.ocs.base.utils.a.d(this.f404207a, "connect stat state - ".concat(String.valueOf(r101)));     // Catch: Exception -> L13
        if (r101 == true) goto L12;
        IAuthenticationListener r102 = this.f404210d;     // Catch: Exception -> L13
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
        IAuthenticationListener r103 = this.f404210d;     // Catch: Exception -> L19
        if (r103 == null) goto L26;
        r103.onFail(1009);     // Catch: Exception -> L19
        goto L26
    }

    @Override // com.oplus.ocs.base.common.api.e
    public final void d() {
    }

    @Override // com.oplus.ocs.base.common.api.e
    public final void c() {
        if (this.f404209c != null) goto L7;
        com.oplus.ocs.base.utils.a.d(this.f404207a, "mServiceConnectionImpl is null");
        return;
    L7:
        if (this.f404208b.getApplicationContext() == null) goto L15;
        this.f404208b.getApplicationContext().unbindService(this.f404209c);     // Catch: Exception -> L10
        return;
    L10:
        e = move-exception;
        com.oplus.ocs.base.utils.a.d(this.f404207a, String.format("in unbind get an exception %s", new Object[]{e.getMessage()}));
        return;
    }

    public static /* synthetic */ IAuthenticationListener a(f r100) {
        return r100.f404210d;
    }

    public static /* synthetic */ InternalClient b(f r100) {
        return r100.f404211e;
    }

    public static /* synthetic */ String c(f r100) {
        return r100.f404207a;
    }

    public static /* synthetic */ ServiceConnection d(f r100) {
        r100.f404209c = null;
        return null;
    }

    public f(Context r100, InternalClient r101, IAuthenticationListener r102) {
        this.f404207a = "f";
        this.f404208b = r100;
        this.f404211e = r101;
        this.f404210d = r102;
        this.f404212f = new AnonymousClass1(this);
    }
}
