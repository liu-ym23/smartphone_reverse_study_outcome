package com.huawei.hms.common.internal;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import com.huawei.hms.common.HuaweiApi;
import com.huawei.hms.core.aidl.IAIDLInvoke;
import com.huawei.hms.support.log.HMSLog;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

/* JADX INFO: loaded from: classes23.dex */
public class RequestManager implements Handler.Callback {
    public static final int NOTIFY_CONNECT_FAILED = 10012;
    public static final int NOTIFY_CONNECT_SUCCESS = 10011;
    public static final int NOTIFY_CONNECT_SUSPENDED = 10013;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final Object f277106a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static volatile RequestManager f277107b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static Handler f277108c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static Queue<HuaweiApi.RequestHandler> f277109d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static Map<String, HuaweiApi.RequestHandler> f277110e;

    static {
        f277106a = new Object();
        f277109d = new ConcurrentLinkedQueue();
        f277110e = new LinkedHashMap();
    }

    private void b() {
    L3:
        if (f277109d.isEmpty() == true) goto L11;
        HuaweiApi.RequestHandler r100 = f277109d.poll();
        if (r100 == null) goto L3;
        Object r101 = r100.getClient();
        if ((r101 instanceof BaseHmsClient) == false) goto L3;
        BaseHmsClient r102 = (BaseHmsClient) r101;
        r102.setService(IAIDLInvoke.Stub.asInterface(r102.getAdapter().getServiceBinder()));
        r100.onConnected();
        goto L3
    }

    private void c() {
        HMSLog.i("RequestManager", "NOTIFY_CONNECT_SUSPENDED.");
    L4:
        if (f277109d.isEmpty() == true) goto L6;
        f277109d.poll().onConnectionSuspended(1);
        goto L4
    L6:
        d();
    }

    private void d() {
        HMSLog.i("RequestManager", "notifyRunningRequestConnectSuspend, connectedReqMap.size(): " + f277110e.size());
        Iterator<Map.Entry<String, HuaweiApi.RequestHandler>> r100 = f277110e.entrySet().iterator();
    L4:
        if (r100.hasNext() == false) goto L11;
        r100.next().getValue().onConnectionSuspended(1);     // Catch: RuntimeException -> L8
    L10:
        r100.remove();
    L8:
        e = move-exception;
        HMSLog.e("RequestManager", "NOTIFY_CONNECT_SUSPENDED Exception: " + e.getMessage());
        goto L10
    }

    public static RequestManager getInstance() {
        Object r100 = f277106a;
        monitor-enter(r100);
    L10:
        th = move-exception;
        throw th;
    L5:
        if (f277107b != null) goto L7;
        HandlerThread r101 = new HandlerThread("RequestManager");     // Catch: Throwable -> L10
        r101.start();     // Catch: Throwable -> L10
        f277107b = new RequestManager(r101.getLooper());     // Catch: Throwable -> L10
    L7:
        monitor-exit(r100);     // Catch: Throwable -> L10
        return f277107b;
    }

    public static /* synthetic */ Map a() {
        return f277110e;
    }

    public static Handler getHandler() {
        return f277108c;
    }

    private RequestManager(Looper r100) {
        f277108c = new Handler(r100, this);
    }

    private void a(Message r100) {
        HMSLog.i("RequestManager", "NOTIFY_CONNECT_FAILED.");
        BaseHmsClient.ConnectionResultWrapper r101 = (BaseHmsClient.ConnectionResultWrapper) r100.obj;     // Catch: RuntimeException -> L5
        HuaweiApi.RequestHandler r102 = r101.getRequest();     // Catch: RuntimeException -> L5
        f277109d.remove(r102);     // Catch: RuntimeException -> L5
        r102.onConnectionFailed(r101.getConnectionResult());     // Catch: RuntimeException -> L5
        return;
    L5:
        e = move-exception;
        HMSLog.e("RequestManager", "<handleConnectFailed> handle Failed" + e.getMessage());
    }

    public static void addRequestToQueue(HuaweiApi.RequestHandler r100) {
        f277109d.add(r100);
    }

    public static void removeReqByTransId(final String r100) {
        if (f277108c != null) goto L5;
        return;
    L5:
        HMSLog.i("RequestManager", "removeReqByTransId");
        f277108c.post(new AnonymousClass2(r100));
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message r100) {
        if (r100 != null) goto L5;
        return false;
    L5:
        HMSLog.i("RequestManager", "RequestManager handleMessage.");
        switch(r100.what) {
            case 10011: goto L13;
            case 10012: goto L11;
            case 10013: goto L9;
            default: goto L7;
        };
    L7:
        HMSLog.i("RequestManager", "handleMessage unknown msg:" + r100.what);
        return false;
    L9:
        c();
        return true;
    L11:
        a(r100);
        return true;
    L13:
        b();
        return true;
    }

    public static void addToConnectedReqMap(final String r100, final HuaweiApi.RequestHandler r101) {
        if (f277108c != null) goto L5;
        return;
    L5:
        HMSLog.i("RequestManager", "addToConnectedReqMap");
        f277108c.post(new AnonymousClass1(r100, r101));
    }
}
