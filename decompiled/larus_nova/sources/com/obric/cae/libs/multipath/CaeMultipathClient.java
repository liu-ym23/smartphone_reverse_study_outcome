package com.obric.cae.libs.multipath;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.IBinder;
import android.os.Looper;
import android.os.Message;
import android.os.RemoteException;
import android.os.ServiceManager;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import com.ss.android.ugc.bytex.pthread.base.proxy.PthreadHandlerThreadV2;

/* JADX INFO: loaded from: classes33.dex */
public class CaeMultipathClient {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static volatile CaeMultipathClient f395892e;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public ICaeMultipathManager f395893a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public HandlerThread f395894b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public a f395895c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f395896d;

    public class a extends Handler {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ CaeMultipathClient f395897a;

        @Override // android.os.Handler
        public final void handleMessage(Message r100) {
            int r101 = r100.what;
            boolean r102 = true;
            if (r101 != 1) goto L5;
            CaeMultipathClient.a(this.f395897a);
            return;
        L5:
            if (r101 != 2) goto L17;
            CaeMultipathClient r103 = this.f395897a;
            if (r103.f395893a != null) goto L11;
            r102 = false;
        L11:
            if (r102 == true) goto L15;
            CaeMultipathClient.a(r103);
            return;
        L15:
            return;
        }

        public a(CaeMultipathClient r100, Looper r101) {
            this.f395897a = r100;
            super(r101);
        }
    }

    public static CaeMultipathClient getInstance() {
        if (f395892e != null) goto L15;
        monitor-enter(CaeMultipathClient.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (f395892e != null) goto L9;
        f395892e = new CaeMultipathClient();     // Catch: Throwable -> L11
    L9:
        monitor-exit(CaeMultipathClient.class);     // Catch: Throwable -> L11
    L15:
        return f395892e;
    }

    public final void a() {
        PthreadHandlerThreadV2 r100 = new PthreadHandlerThreadV2("CaeMultipathConnectThread");
        this.f395894b = r100;
        ThreadMethodProxy.start(r100);
        this.f395895c = new a(this, this.f395894b.getLooper());
    }

    public String getLatestNetworkTruth() {
        ICaeMultipathManager r100 = this.f395893a;
        if (r100 == null) goto L5;
        boolean r101 = true;
    L7:
        if (r101 == true) goto L12;
        return null;
    L12:
        return r100.getLatestNetworkTruth();
    L11:
        return null;
    L5:
        r101 = false;
        goto L7
    }

    public boolean reportAssistantFailure() {
        ICaeMultipathManager r100 = this.f395893a;
        if (r100 == null) goto L5;
        boolean r101 = true;
    L6:
        if (r101 == true) goto L11;
        return false;
    L11:
        r100.reportAssistantFailure();     // Catch: Exception -> L10
        return true;
    L10:
        return false;
    L5:
        r101 = false;
        goto L6
    }

    public CaeMultipathClient() {
        this.f395896d = false;
        a();
        this.f395895c.sendEmptyMessage(1);
    }

    public static void a(CaeMultipathClient r110) {
        if (r110.f395896d == true) goto L33;
        r110.f395896d = true;
        IBinder r100 = ServiceManager.getService("cae_multipath");     // Catch: Throwable -> L18 Exception -> L20
        if (r100 != null) goto L28;
        r110.f395895c.removeMessages(2);     // Catch: Throwable -> L18 Exception -> L20
        r110.f395895c.sendEmptyMessageDelayed(2, 5000);     // Catch: Throwable -> L18 Exception -> L20
    L21:
        r110.f395896d = false;
        return;
    L28:
        int r101 = ICaeMultipathManager.Stub.TRANSACTION_startMultipath;     // Catch: Exception -> L16 Throwable -> L18
        ICaeMultipathManager r102 = (ICaeMultipathManager) ICaeMultipathManager.Stub.class.getMethod("asInterface", new Class[]{IBinder.class}).invoke(null, new Object[]{r100});     // Catch: Exception -> L16 Throwable -> L18
        r110.f395893a = r102;     // Catch: Exception -> L16 Throwable -> L18
        if (r102 != null) goto L26;
        r110.f395895c.removeMessages(2);     // Catch: Exception -> L16 Throwable -> L18
        r110.f395895c.sendEmptyMessageDelayed(2, 5000);     // Catch: Exception -> L16 Throwable -> L18
        goto L21
    L26:
        r100.linkToDeath(new com.obric.cae.libs.multipath.a(r110), 0);     // Catch: RemoteException -> L25 Throwable -> L18 Exception -> L20
    L15:
        r110.f395896d = false;
        return;
    L16:
        r110.f395895c.removeMessages(2);     // Catch: Throwable -> L18 Exception -> L20
        r110.f395895c.sendEmptyMessageDelayed(2, 5000);     // Catch: Throwable -> L18 Exception -> L20
    L20:
        r110.f395895c.removeMessages(2);     // Catch: Throwable -> L18
        r110.f395895c.sendEmptyMessageDelayed(2, 5000);     // Catch: Throwable -> L18
    L18:
        th = move-exception;
        r110.f395896d = false;
        throw th;
    }
}
