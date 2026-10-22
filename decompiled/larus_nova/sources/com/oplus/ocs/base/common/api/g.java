package com.oplus.ocs.base.common.api;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.Message;
import android.os.RemoteException;
import com.oplus.ocs.base.IServiceBroker;
import com.oplus.ocs.base.common.CapabilityInfo;
import com.oplus.ocs.base.utils.ServiceCheck;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.ugc.bytex.pthread.base.PThreadExecutorsUtils;
import com.ss.android.ugc.bytex.thread_rename.base.DefaultThreadFactory;

/* JADX INFO: loaded from: classes34.dex */
final class g implements e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final String f404215a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    a f404216b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    IServiceBroker f404217c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    Context f404218d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    String f404219e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    c f404220f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    k f404221g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    IBinder.DeathRecipient f404222h;

    public class a implements ServiceConnection {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ g f404227a;

        private a(g r100) {
            this.f404227a = r100;
        }

        @Override // android.content.ServiceConnection
        public final void onServiceDisconnected(ComponentName r100) {
            k r101 = this.f404227a.f404221g;
            if (r101 == null) goto L5;
            r101.onStateChange(13);
        L5:
            g r102 = this.f404227a;
            r102.f404216b = null;
            r102.f404217c = null;
        }

        public /* synthetic */ a(g r100, byte r101) {
            this(r100);
        }

        @Override // android.content.ServiceConnection
        public final void onServiceConnected(ComponentName r100, IBinder r101) {
            com.oplus.ocs.base.utils.a.a(this.f404227a.f404215a, "new ocs onServiceConnected");
            g r102 = this.f404227a;     // Catch: RemoteException -> L5
            r102.f404217c = IServiceBroker.Stub.asInterface(r101);     // Catch: RemoteException -> L5
            this.f404227a.f404217c.asBinder().linkToDeath(this.f404227a.f404222h, 0);     // Catch: RemoteException -> L5
            this.f404227a.f404220f.sendEmptyMessage(3);     // Catch: RemoteException -> L5
            return;
        L5:
            e = move-exception;
            e.printStackTrace();
        }
    }

    @Override // com.oplus.ocs.base.common.api.e
    public final boolean b() {
        return false;
    }

    @Override // com.oplus.ocs.base.common.api.e
    public final boolean a() {
        k r100 = this.f404221g;
        if (r100 == null) goto L6;
        r100.onStateChange(2);
    L6:
        if (ServiceCheck.b(this.f404218d) == false) goto L8;
        PThreadExecutorsUtils.newSingleThreadExecutor(new DefaultThreadFactory("/common/api/g")).execute(new AnonymousClass1(this));
    L21:
        return true;
    L8:
        byte r101 = 0;
    L19:
        e = move-exception;
        com.oplus.ocs.base.utils.a.d(this.f404215a, String.format("out bind get an exception %s", new Object[]{e.getMessage()}));
        goto L21
    L10:
        if (this.f404218d.getApplicationContext() == null) goto L14;
        this.f404216b = new a(this, r101);     // Catch: Exception -> L19
        Context r102 = this.f404218d.getApplicationContext();     // Catch: Exception -> L19
        Intent r103 = new Intent("com.oplus.ocs.openauthenticate");     // Catch: Exception -> L19
        r103.setComponent(new ComponentName("com.oplus.ocs", "com.oplus.ocs.service.OpenAuthenticateService"));     // Catch: Exception -> L19
        boolean r104 = r102.bindService(r103, this.f404216b, 1);     // Catch: Exception -> L19
        com.oplus.ocs.base.utils.a.b(this.f404215a, "connect state ".concat(String.valueOf(r104)));     // Catch: Exception -> L19
        if (r104 == true) goto L21;
        a(3);     // Catch: Exception -> L19
        goto L21
    L14:
        k r105 = this.f404221g;     // Catch: Exception -> L19
        if (r105 == null) goto L17;
        r105.onStateChange(2);     // Catch: Exception -> L19
    L17:
        a(1009);     // Catch: Exception -> L19
        goto L21
    }

    @Override // com.oplus.ocs.base.common.api.e
    public final void c() {
        if (this.f404216b != null) goto L5;
        return;
    L5:
        if (this.f404218d.getApplicationContext() == null) goto L14;
        this.f404218d.getApplicationContext().unbindService(this.f404216b);     // Catch: Exception -> L8
        this.f404217c = null;     // Catch: Exception -> L8
        return;
    L8:
        e = move-exception;
        com.oplus.ocs.base.utils.a.d(this.f404215a, String.format("out unbind get an exception %s", new Object[]{e.getMessage()}));
        return;
    }

    @Override // com.oplus.ocs.base.common.api.e
    public final void d() {
        IServiceBroker r100 = this.f404217c;     // Catch: Exception -> L10
        if (r100 == null) goto L15;
        IBinder r101 = r100.asBinder();     // Catch: Exception -> L10
        if (r101 != null) goto L7;
        return;
    L7:
        if (r101.isBinderAlive() == false) goto L17;
        this.f404217c.handleAuthentication(this.f404219e, "1.0.11", new AnonymousClass3(this));     // Catch: Exception -> L10
        return;
    L17:
        return;
    L15:
        return;
    L10:
        e = move-exception;
        com.oplus.ocs.base.utils.a.d(this.f404215a, "the exception that service broker authenticates is" + e.getMessage());
        a(7);
    }

    public final void a(int r100) {
        com.oplus.ocs.base.utils.a.b(this.f404215a, "errorCode ".concat(String.valueOf(r100)));
        Message r101 = Message.obtain();
        r101.what = 2;
        r101.arg1 = r100;
        this.f404220f.sendMessage(r101);
    }

    public static /* synthetic */ void a(g r100, CapabilityInfo r101) {
        Message r102 = Message.obtain();
        r102.what = 1;
        r102.obj = r101;
        r100.f404220f.sendMessage(r102);
    }

    public g(Context r100, String r101, c r102, k r103) {
        this.f404215a = BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY;
        this.f404216b = null;
        this.f404222h = new AnonymousClass4(this);
        this.f404218d = r100;
        this.f404219e = r101;
        this.f404220f = r102;
        this.f404221g = r103;
    }
}
