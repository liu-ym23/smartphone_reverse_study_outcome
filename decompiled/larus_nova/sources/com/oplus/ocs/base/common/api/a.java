package com.oplus.ocs.base.common.api;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.Message;
import android.os.Process;
import com.coloros.ocs.base.IServiceBroker;
import com.oplus.ocs.base.common.CapabilityInfo;
import com.oplus.ocs.base.utils.ServiceCheck;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.ugc.bytex.pthread.base.PThreadExecutorsUtils;
import com.ss.android.ugc.bytex.thread_rename.base.DefaultThreadFactory;

/* JADX INFO: loaded from: classes34.dex */
class a implements e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f404186a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private ServiceConnectionC4689a f404187b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private IServiceBroker f404188c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private Context f404189d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private String f404190e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private c f404191f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private k f404192g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private IBinder.DeathRecipient f404193h;

    /* JADX INFO: renamed from: com.oplus.ocs.base.common.api.a$a, reason: collision with other inner class name */
    public class ServiceConnectionC4689a implements ServiceConnection {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ a f404198a;

        private ServiceConnectionC4689a(a r100) {
            this.f404198a = r100;
        }

        @Override // android.content.ServiceConnection
        public final void onServiceDisconnected(ComponentName r100) {
            if (a.f(this.f404198a) == null) goto L5;
            a.f(this.f404198a).onStateChange(13);
        L5:
            a.g(this.f404198a);
            a.a(this.f404198a, null);
        }

        public /* synthetic */ ServiceConnectionC4689a(a r100, byte r101) {
            this(r100);
        }

        @Override // android.content.ServiceConnection
        public final void onServiceConnected(ComponentName r100, IBinder r101) {
            com.oplus.ocs.base.utils.a.a(a.b(this.f404198a), "onServiceConnected");
            a.a(this.f404198a, IServiceBroker.Stub.asInterface(r101));     // Catch: Exception -> L5
            a.d(this.f404198a).asBinder().linkToDeath(a.c(this.f404198a), 0);     // Catch: Exception -> L5
            a.e(this.f404198a).sendEmptyMessage(3);     // Catch: Exception -> L5
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
        k r100 = this.f404192g;
        if (r100 == null) goto L6;
        r100.onStateChange(2);
    L6:
        if (ServiceCheck.b(this.f404189d) == false) goto L8;
        PThreadExecutorsUtils.newSingleThreadExecutor(new DefaultThreadFactory("/common/api/a")).execute(new AnonymousClass1(this));
    L21:
        return true;
    L8:
        byte r101 = 0;
    L19:
        e = move-exception;
        com.oplus.ocs.base.utils.a.d(this.f404186a, String.format("out bind get an exception %s", new Object[]{e.getMessage()}));
        goto L21
    L10:
        if (this.f404189d.getApplicationContext() == null) goto L14;
        this.f404187b = new ServiceConnectionC4689a(this, r101);     // Catch: Exception -> L19
        Context r102 = this.f404189d.getApplicationContext();     // Catch: Exception -> L19
        Intent r103 = new Intent("com.coloros.opencapabilityservice");     // Catch: Exception -> L19
        r103.setComponent(new ComponentName("com.coloros.ocs.opencapabilityservice", "com.coloros.ocs.opencapabilityservice.service.ColorOcsService"));     // Catch: Exception -> L19
        boolean r104 = r102.bindService(r103, this.f404187b, 1);     // Catch: Exception -> L19
        com.oplus.ocs.base.utils.a.b(this.f404186a, "connect state ".concat(String.valueOf(r104)));     // Catch: Exception -> L19
        if (r104 == true) goto L21;
        a(3);     // Catch: Exception -> L19
        goto L21
    L14:
        k r105 = this.f404192g;     // Catch: Exception -> L19
        if (r105 == null) goto L17;
        r105.onStateChange(2);     // Catch: Exception -> L19
    L17:
        a(1009);     // Catch: Exception -> L19
        goto L21
    }

    @Override // com.oplus.ocs.base.common.api.e
    public final void c() {
        if (this.f404187b != null) goto L5;
        return;
    L5:
        if (this.f404189d.getApplicationContext() == null) goto L14;
        this.f404189d.getApplicationContext().unbindService(this.f404187b);     // Catch: Exception -> L8
        this.f404188c = null;     // Catch: Exception -> L8
        return;
    L8:
        e = move-exception;
        com.oplus.ocs.base.utils.a.d(this.f404186a, String.format("out unbind get an exception %s", new Object[]{e.getMessage()}));
        return;
    }

    @Override // com.oplus.ocs.base.common.api.e
    public final void d() {
        IServiceBroker r100 = this.f404188c;     // Catch: Exception -> L10
        if (r100 == null) goto L15;
        IBinder r101 = r100.asBinder();     // Catch: Exception -> L10
        if (r101 != null) goto L7;
        return;
    L7:
        if (r101.isBinderAlive() == false) goto L17;
        this.f404188c.handleAuthentication(this.f404190e, "1.0.11", new AnonymousClass3(this));     // Catch: Exception -> L10
        return;
    L17:
        return;
    L15:
        return;
    L10:
        e = move-exception;
        e.printStackTrace();
        com.oplus.ocs.base.utils.a.d(this.f404186a, "the exception that service broker authenticates is" + e.getMessage());
        a(7);
    }

    private void a(int r100) {
        com.oplus.ocs.base.utils.a.b(this.f404186a, "errorCode ".concat(String.valueOf(r100)));
        Message r101 = Message.obtain();
        r101.what = 2;
        r101.arg1 = r100;
        this.f404191f.sendMessage(r101);
    }

    public static /* synthetic */ String b(a r100) {
        return r100.f404186a;
    }

    public static /* synthetic */ IBinder.DeathRecipient c(a r100) {
        return r100.f404193h;
    }

    public static /* synthetic */ IServiceBroker d(a r100) {
        return r100.f404188c;
    }

    public static /* synthetic */ c e(a r100) {
        return r100.f404191f;
    }

    public static /* synthetic */ k f(a r100) {
        return r100.f404192g;
    }

    public static /* synthetic */ ServiceConnectionC4689a g(a r100) {
        r100.f404187b = null;
        return null;
    }

    public static /* synthetic */ void a(final a r100) {
        Context r101 = r100.f404189d;
        new InternalClient(r101, r101.getPackageName(), r100.f404190e, Process.myPid(), true, true, new AnonymousClass2(r100)).connect();
    }

    public static /* synthetic */ void a(a r100, CapabilityInfo r101) {
        Message r102 = Message.obtain();
        r102.what = 1;
        r102.obj = r101;
        r100.f404191f.sendMessage(r102);
    }

    public static /* synthetic */ void a(a r100, int r101) {
        r100.a(r101);
    }

    public static /* synthetic */ IServiceBroker a(a r100, IServiceBroker r101) {
        r100.f404188c = r101;
        return r101;
    }

    public a(Context r100, String r101, c r102, k r103) {
        this.f404186a = BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY;
        this.f404187b = null;
        this.f404193h = new AnonymousClass4(this);
        this.f404189d = r100;
        this.f404190e = r101;
        this.f404191f = r102;
        this.f404192g = r103;
    }
}
