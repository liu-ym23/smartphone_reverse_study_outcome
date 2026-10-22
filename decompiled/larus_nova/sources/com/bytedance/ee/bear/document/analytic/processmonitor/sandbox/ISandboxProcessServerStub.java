package com.bytedance.ee.bear.document.analytic.processmonitor.sandbox;

import android.content.Context;
import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.bytedance.ee.bear.document.analytic.processmonitor.entity.CpuInfo;

/* JADX INFO: loaded from: classes16.dex */
public final class ISandboxProcessServerStub extends Binder implements IInterface, ISandboxProcessServer {
    public final SandboxProcessServer base;

    @Override // android.os.IInterface
    public IBinder asBinder() {
        return this;
    }

    @Override // com.bytedance.ee.bear.document.analytic.processmonitor.sandbox.ISandboxProcessServer
    public long getSandboxCPUTime() {
        return this.base.getSandboxCPUTime();
    }

    @Override // com.bytedance.ee.bear.document.analytic.processmonitor.sandbox.ISandboxProcessServer
    public long getSandboxMemory() {
        return this.base.getSandboxMemory();
    }

    public ISandboxProcessServerStub(Context r100) {
        this.base = new SandboxProcessServer(r100);
        attachInterface(this, ISandboxProcessServerProxy.DESCRIPTOR);
    }

    public static ISandboxProcessServerProxy asInterface(Context r100, IBinder r101) {
        if (r101 != null) goto L5;
        return null;
    L5:
        IInterface r102 = r101.queryLocalInterface(ISandboxProcessServerProxy.DESCRIPTOR);
        if (r102 == null) goto L12;
        if ((r102 instanceof ISandboxProcessServerProxy) == false) goto L12;
        return (ISandboxProcessServerProxy) r102;
    L12:
        return new ISandboxProcessServerProxy(r100, r101);
    }

    @Override // com.bytedance.ee.bear.document.analytic.processmonitor.sandbox.ISandboxProcessServer
    public CpuInfo getCurrentCpuRate(String r100, boolean r101) {
        return this.base.getCurrentCpuRate(r100, r101);
    }

    @Override // android.os.Binder
    public boolean onTransact(int r100, Parcel r101, Parcel r102, int r103) throws RemoteException {
        if (r100 != 1) goto L5;
        r101.enforceInterface(ISandboxProcessServerProxy.DESCRIPTOR);
        long r104 = getSandboxCPUTime();
        r102.writeNoException();
        r102.writeLong(r104);
        return true;
    L5:
        if (r100 != 2) goto L7;
        r101.enforceInterface(ISandboxProcessServerProxy.DESCRIPTOR);
        String r105 = r101.readString();
        if (r101.readInt() != 0) goto L19;
        boolean r106 = false;
    L20:
        CpuInfo r107 = getCurrentCpuRate(r105, r106);
        r102.writeNoException();
        if (r107 == null) goto L23;
        r102.writeInt(1);
        r107.writeToParcel(r102, 1);
    L24:
        return true;
    L23:
        r102.writeInt(0);
        goto L24
    L19:
        r106 = true;
        goto L20
    L7:
        if (r100 != 3) goto L9;
        r101.enforceInterface(ISandboxProcessServerProxy.DESCRIPTOR);
        long r108 = getSandboxMemory();
        r102.writeNoException();
        r102.writeLong(r108);
        return true;
    L9:
        if (r100 != 1598968902) goto L11;
        r102.writeString(ISandboxProcessServerProxy.DESCRIPTOR);
        return true;
    L11:
        return super.onTransact(r100, r101, r102, r103);
    }
}
