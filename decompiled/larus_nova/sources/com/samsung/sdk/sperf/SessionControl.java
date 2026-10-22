package com.samsung.sdk.sperf;

import android.net.LocalServerSocket;
import android.net.LocalSocket;
import android.os.IBinder;
import android.os.RemoteException;
import android.os.ServiceManager;
import com.samsung.android.perfsdkservice.IPerfSDKService;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import com.ss.android.ugc.bytex.pthread.base.proxy.PthreadThreadV2;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.util.Iterator;
import java.util.Vector;

/* JADX INFO: loaded from: classes34.dex */
class SessionControl {
    private static SessionControl instance;
    private LocalSocket client;

    /* JADX INFO: renamed from: in, reason: collision with root package name */
    private DataInputStream f405791in;
    private Object localSocketObject;
    private IPerfSDKService mService;
    private DataOutputStream out;
    private Vector<SPerfListener> perfSDKListerners;
    private LocalServerSocket server;
    private String socketName;

    private SessionControl() {
        this.localSocketObject = null;
        this.perfSDKListerners = null;
        this.mService = null;
        this.server = null;
        this.client = null;
        this.f405791in = null;
        this.out = null;
        this.socketName = "PERFSDK_SOC_" + Long.toString(Double.doubleToLongBits(Math.random()), 36).substring(0, 5);
        createServer();
        SPerfUtil.log("Make Server for connection with PerfSDK Server");
        this.localSocketObject = getService();
        this.perfSDKListerners = new Vector();
    }

    public static /* synthetic */ LocalServerSocket access$000(SessionControl r100) {
        return r100.server;
    }

    public static /* synthetic */ LocalServerSocket access$002(SessionControl r100, LocalServerSocket r101) {
        r100.server = r101;
        return r101;
    }

    public static /* synthetic */ String access$100(SessionControl r100) {
        return r100.socketName;
    }

    public static /* synthetic */ LocalSocket access$200(SessionControl r100) {
        return r100.client;
    }

    public static /* synthetic */ LocalSocket access$202(SessionControl r100, LocalSocket r101) {
        r100.client = r101;
        return r101;
    }

    public static /* synthetic */ DataInputStream access$302(SessionControl r100, DataInputStream r101) {
        r100.f405791in = r101;
        return r101;
    }

    public static /* synthetic */ DataOutputStream access$402(SessionControl r100, DataOutputStream r101) {
        r100.out = r101;
        return r101;
    }

    public static SessionControl createInstance() {
        if (instance != null) goto L5;
        instance = new SessionControl();
    L5:
        SessionControl r100 = instance;
        if (r100 == null) goto L14;
        if (r100.getDataInputStream() != null) goto L10;
    L11:
        instance = null;
        return null;
    L10:
        if (r100.getDataOutputStream() == null) goto L11;
    L14:
        return instance;
    }

    private void createServer() {
        ThreadMethodProxy.start(new PthreadThreadV2(new AnonymousClass1(this), "essionControl"));
    }

    public void addListerner(SPerfListener r100) {
        Vector<SPerfListener> r101 = this.perfSDKListerners;
        if (r101 != null) goto L5;
        return;
    L5:
        r101.add(r100);
    }

    public Object callback(Object r100) {
        return r100;
    }

    public DataInputStream getDataInputStream() {
        return this.f405791in;
    }

    public DataOutputStream getDataOutputStream() {
        return this.out;
    }

    public Object getService() {
        if (this.localSocketObject != null) goto L22;
        IBinder r100 = ServiceManager.getService("perfsdkservice");     // Catch: NoSuchMethodError -> L19
        if (r100 == null) goto L7;
        this.mService = IPerfSDKService.Stub.asInterface(r100);     // Catch: NoSuchMethodError -> L19
        SPerfUtil.log("Get mService Interface");     // Catch: NoSuchMethodError -> L19
    L7:
        IPerfSDKService r101 = this.mService;     // Catch: NoSuchMethodError -> L19
        if (r101 == null) goto L22;
        this.localSocketObject = Integer.valueOf(r101.initPerfSDK(this.socketName));     // Catch: RemoteException -> L16 NoSuchMethodError -> L19
        String r102 = this.mService.getAllowedPkgName();     // Catch: RemoteException -> L16 NoSuchMethodError -> L19
        if (r102 != null) goto L12;
    L14:
        SPerfUtil.log("Do initPerfSDK");     // Catch: RemoteException -> L16 NoSuchMethodError -> L19
    L12:
        if (r102.length() <= 0) goto L14;
        Boost.setNativePkgName(r102);     // Catch: RemoteException -> L16 NoSuchMethodError -> L19
    L16:
        e = move-exception;
        e.printStackTrace();     // Catch: NoSuchMethodError -> L19
    L19:
        e = move-exception;
        e.printStackTrace();
    L22:
        return this.localSocketObject;
    }

    public void notifyReleaseToListener() {
        Iterator<SPerfListener> r100 = this.perfSDKListerners.iterator();
    L4:
        if (r100.hasNext() == false) goto L6;
        r100.next().onReleasedByTimeout();
        goto L4
    }

    public void notifyyWarningLevelToListener(int r100) {
        Iterator<SPerfListener> r101 = this.perfSDKListerners.iterator();
    L4:
        if (r101.hasNext() == false) goto L6;
        r101.next().onHighTempWarning(r100);
        goto L4
    }

    public boolean removeListener(SPerfListener r100) {
        Vector<SPerfListener> r101 = this.perfSDKListerners;
        if (r101 != null) goto L7;
        return false;
    L7:
        return r101.remove(r100);
    }
}
