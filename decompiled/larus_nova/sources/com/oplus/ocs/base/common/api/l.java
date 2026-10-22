package com.oplus.ocs.base.common.api;

import android.content.Context;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import android.os.Message;
import com.oplus.ocs.base.common.AuthResult;
import com.oplus.ocs.base.common.CapabilityInfo;
import com.oplus.ocs.base.common.api.Api.ApiOptions;
import com.oplus.ocs.base.internal.ClientSettings;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import com.ss.android.ugc.bytex.pthread.base.proxy.PthreadHandlerThreadV2;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: classes34.dex */
class l<O extends Api.ApiOptions> implements Handler.Callback {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    static Map<Api.ClientKey, OplusApiClient> f404234c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final String f404235d = null;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static volatile l f404236f;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    Context f404237a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    com.oplus.ocs.base.common.a f404238b;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private Looper f404239e;

    static {
        f404235d = "l";
        f404234c = new ConcurrentHashMap();
    }

    public static l a(Context r100) {
        if (f404236f != null) goto L18;
        monitor-enter(l.class);
    L14:
        th = move-exception;
        throw th;
    L7:
        if (f404236f != null) goto L12;
        PthreadHandlerThreadV2 r101 = new PthreadHandlerThreadV2("OplusApiManager", 9);     // Catch: Throwable -> L14
        ThreadMethodProxy.start(r101);     // Catch: Throwable -> L14
        if (r101.getLooper() == null) goto L11;
        f404236f = new l(r100, r101.getLooper());     // Catch: Throwable -> L14
        goto L12
    L11:
        f404236f = new l(r100, Looper.getMainLooper());     // Catch: Throwable -> L14
    L12:
        monitor-exit(l.class);     // Catch: Throwable -> L14
    L18:
        return f404236f;
    }

    public static IBinder b(OplusApi r100) {
        com.oplus.ocs.base.utils.d.a(r100, "oplusApi not be null");
        if (f404234c.containsKey(r100.getApi().getClientKey()) == false) goto L8;
        OplusApiClient r101 = f404234c.get(r100.getApi().getClientKey());
        if (r101 != null) goto L7;
        return null;
    L7:
        return r101.getRemoteService();
    L8:
        return null;
    }

    public static int c(OplusApi r100) {
        com.oplus.ocs.base.utils.d.a(r100, "oplusApi not be null");
        if (f404234c.containsKey(r100.getApi().getClientKey()) == false) goto L8;
        OplusApiClient r101 = f404234c.get(r100.getApi().getClientKey());
        if (r101 != null) goto L7;
        return 0;
    L7:
        return r101.getRemoteVersion();
    L8:
        return 0;
    }

    public static AuthResult d(OplusApi r100) {
        com.oplus.ocs.base.utils.d.a(r100, "oplusApi not be null");
        if (f404234c.containsKey(r100.getApi().getClientKey()) == false) goto L8;
        OplusApiClient r101 = f404234c.get(r100.getApi().getClientKey());
        if (r101 != null) goto L7;
        return null;
    L7:
        return r101.getAuthResult();
    L8:
        return null;
    }

    public static boolean e(OplusApi r100) {
        com.oplus.ocs.base.utils.d.a(r100, "oplusApi not be null");
        if (f404234c.containsKey(r100.getApi().getClientKey()) == false) goto L8;
        OplusApiClient r101 = f404234c.get(r100.getApi().getClientKey());
        if (r101 != null) goto L7;
        return false;
    L7:
        return r101.isConnected();
    L8:
        return false;
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message r100) {
        com.oplus.ocs.base.utils.a.a(f404235d, "handle message " + r100.what);
        int r101 = r100.what;
        if (r101 != 0) goto L5;
        Api r102 = (Api) r100.obj;
        if (r102 != null) goto L17;
        return false;
    L17:
        if (r102.getClientKey() == null) goto L28;
        OplusApiClient r103 = f404234c.get(r102.getClientKey());
        if (r103 == null) goto L29;
        r103.connect();
        return false;
    L29:
        return false;
    L28:
        return false;
    L5:
        if (r101 != 1) goto L30;
        Api r104 = (Api) r100.obj;
        if (r104 != null) goto L10;
        return false;
    L10:
        if (r104.getClientKey() == null) goto L24;
        OplusApiClient r105 = f404234c.get(r104.getClientKey());
        if (r105 == null) goto L25;
        r105.disconnect();
        a(r104.getClientKey());
        return false;
    L25:
        return false;
    L24:
        return false;
    L30:
        return false;
    }

    public final void a(Api r100) {
        Message r101 = this.f404238b.obtainMessage();
        r101.what = 0;
        r101.obj = r100;
        this.f404238b.sendMessage(r101);
    }

    public static void a(OplusApi r100) {
        CapabilityInfo r101 = CapabilityApiClient.getCapabilityInfo(r100.getApi());
        if (r101 == null) goto L6;
        r100.checkAuthResult(r101);
        return;
    }

    public static void a(Api.ClientKey r100) {
        f404234c.remove(r100);
    }

    private l(Context r100, Looper r101) {
        if (r100.getApplicationContext() == null) goto L5;
        this.f404237a = r100.getApplicationContext();
    L6:
        this.f404239e = r101;
        this.f404238b = new com.oplus.ocs.base.common.a(this.f404239e, this);
        return;
    L5:
        this.f404237a = r100;
        goto L6
    }

    public final void a(final OplusApi r100, ClientSettings r101) {
        com.oplus.ocs.base.utils.d.a(r100, "oplusApi not be null");
        com.oplus.ocs.base.utils.d.a(r101, "clientsettings not be null");
        if (f404234c.containsKey(r100.getApi().getClientKey()) == true) goto L6;
        m r102 = new m(this.f404237a, r100.getApi(), r100.f404173a, r101);
        r102.setOnClearListener(new AnonymousClass1(this, r100));
        r102.setOnCapabilityAuthListener(new AnonymousClass2(this, r100));
        f404234c.put(r100.getApi().getClientKey(), r102);
        a(r100.getApi());
        return;
    }

    public static <T> void a(OplusApi r100, TaskListenerHolder<T> r101) {
        com.oplus.ocs.base.utils.a.a(f404235d, "addQueue ".concat(r100.getClass().getSimpleName()));
        com.oplus.ocs.base.utils.d.a(r100, "oplusApi not be null");
        if (f404234c.containsKey(r100.getApi().getClientKey()) == false) goto L8;
        OplusApiClient r102 = f404234c.get(r100.getApi().getClientKey());
        if (r102 == null) goto L9;
        r102.addQueue(r101);
        return;
    L9:
        return;
    }

    public final void a(OplusApi r100, final OnConnectionSucceedListener r101, Handler r102) {
        com.oplus.ocs.base.utils.d.a(r100, "oplusApi not be null");
        if (f404234c.containsKey(r100.getApi().getClientKey()) == false) goto L15;
        OplusApiClient r103 = f404234c.get(r100.getApi().getClientKey());
        if (r103 != null) goto L7;
        return;
    L7:
        if (r100.isConnected() == false) goto L13;
        if (r102 != null) goto L10;
        final Looper r104 = Looper.getMainLooper();
    L11:
        new AnonymousClass4(this, r104, r101).sendEmptyMessage(0);
        return;
    L10:
        r104 = r102.getLooper();
        goto L11
    L13:
        r103.setOnConnectionSucceedListener(r101, r102);
        return;
    }

    public static void a(OplusApi r100, OnConnectionFailedListener r101, Handler r102) {
        com.oplus.ocs.base.utils.d.a(r100, "oplusApi not be null");
        if (f404234c.containsKey(r100.getApi().getClientKey()) == false) goto L8;
        OplusApiClient r103 = f404234c.get(r100.getApi().getClientKey());
        if (r103 == null) goto L9;
        r103.setOnConnectionFailedListener(r101, r102);
        return;
    L9:
        return;
    }
}
