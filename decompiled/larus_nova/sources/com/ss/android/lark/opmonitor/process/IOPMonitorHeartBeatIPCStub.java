package com.ss.android.lark.opmonitor.process;

import android.content.Context;
import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import android.text.TextUtils;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.opmonitor.api.IOPMonitorHeartBeatListenerStub;
import com.ss.android.lark.opmonitor.config.OPMonitorHeartBeatConfig;
import com.ss.android.lark.opmonitor.model.OPMonitorHeartBeatMonitorData;
import eyb.a;
import eyb.b;
import fyb.d;
import java.util.concurrent.ScheduledExecutorService;

/* JADX INFO: loaded from: classes37.dex */
public final class IOPMonitorHeartBeatIPCStub extends Binder implements IInterface, a {
    public final b base;

    @Override // android.os.IInterface
    public IBinder asBinder() {
        return this;
    }

    public IOPMonitorHeartBeatIPCStub(Context r100) {
        this.base = new b(r100);
        attachInterface(this, IOPMonitorHeartBeatIPCProxy.DESCRIPTOR);
    }

    public void endHeartBeat(String r100) {
        this.base.getClass();
        d r101 = d.a();
        r101.getClass();
        if (TextUtils.isEmpty(r100) == true) goto L17;
        OPMonitorHeartBeatConfig r102 = r101.f479335a;
        if (r102 != null) goto L8;
        return;
    L8:
        if (r102.f437595b == false) goto L15;
        OPMonitorHeartBeatMonitorData r103 = r101.f479340f.get(r100);
        if (r103 != null) goto L12;
        r101.f479341g.remove(r100);
        return;
    L12:
        r103.f437599c = 0;
        r101.f479341g.remove(r100);
        return;
    L15:
        return;
    }

    public void setLarkStatus(boolean r100) {
        this.base.getClass();
        d r101 = d.a();
        monitor-enter(r101);
        OPMonitorHeartBeatConfig r102 = r101.f479335a;     // Catch: Throwable -> L19
        if (r102 != null) goto L7;
    L17:
        monitor-exit(r101);
        return;
    L7:
        if (r102.f437595b == false) goto L17;
        Log.i("OPMonitorHeartBeatManager", "lark status is change isLarkForeground: " + r100);     // Catch: Throwable -> L19
        if (r100 == false) goto L11;
        r101.b();     // Catch: Throwable -> L19
        goto L17
    L11:
        Log.i("OPMonitorHeartBeatManager", "stopTimer");     // Catch: Throwable -> L19
        ScheduledExecutorService r103 = r101.f479339e;     // Catch: Throwable -> L19
        if (r103 == null) goto L17;
        if (r103.isShutdown() == true) goto L17;
        r101.f479339e.shutdownNow();     // Catch: Throwable -> L19
    L19:
        th = move-exception;
        throw th;
    }

    public static IOPMonitorHeartBeatIPCProxy asInterface(Context r100, IBinder r101) {
        if (r101 != null) goto L5;
        return null;
    L5:
        IInterface r102 = r101.queryLocalInterface(IOPMonitorHeartBeatIPCProxy.DESCRIPTOR);
        if (r102 == null) goto L12;
        if ((r102 instanceof IOPMonitorHeartBeatIPCProxy) == false) goto L12;
        return (IOPMonitorHeartBeatIPCProxy) r102;
    L12:
        return new IOPMonitorHeartBeatIPCProxy(r100, r101);
    }

    public void registerHeartBeat(OPMonitorHeartBeatMonitorData r100, byb.a r101) {
        this.base.getClass();
        Log.i("OPMonitorHeartBeatIPC", "registerHeartBeat source:" + r100.f437598b);
        d r102 = d.a();
        OPMonitorHeartBeatConfig r103 = r102.f479335a;
        if (r103 != null) goto L5;
        return;
    L5:
        if (r103.f437595b == false) goto L9;
        r102.f479340f.put(r100.f437598b, r100);
        r102.f479341g.put(r100.f437598b, r101);
        return;
    }

    @Override // android.os.Binder
    public boolean onTransact(int r100, Parcel r101, Parcel r102, int r103) throws RemoteException {
        if (r100 != 1) goto L5;
        r101.enforceInterface(IOPMonitorHeartBeatIPCProxy.DESCRIPTOR);
        if (r101.readInt() == 0) goto L25;
        OPMonitorHeartBeatMonitorData r104 = OPMonitorHeartBeatMonitorData.CREATOR.createFromParcel(r101);
    L26:
        registerHeartBeat(r104, IOPMonitorHeartBeatListenerStub.asInterface(r101.readStrongBinder()));
        r102.writeNoException();
        return true;
    L25:
        r104 = null;
        goto L26
    L5:
        if (r100 != 2) goto L7;
        r101.enforceInterface(IOPMonitorHeartBeatIPCProxy.DESCRIPTOR);
        endHeartBeat(r101.readString());
        r102.writeNoException();
        return true;
    L7:
        if (r100 != 3) goto L9;
        r101.enforceInterface(IOPMonitorHeartBeatIPCProxy.DESCRIPTOR);
        if (r101.readInt() != 0) goto L17;
        boolean r105 = false;
    L18:
        setLarkStatus(r105);
        r102.writeNoException();
        return true;
    L17:
        r105 = true;
        goto L18
    L9:
        if (r100 != 1598968902) goto L11;
        r102.writeString(IOPMonitorHeartBeatIPCProxy.DESCRIPTOR);
        return true;
    L11:
        return super.onTransact(r100, r101, r102, r103);
    }
}
