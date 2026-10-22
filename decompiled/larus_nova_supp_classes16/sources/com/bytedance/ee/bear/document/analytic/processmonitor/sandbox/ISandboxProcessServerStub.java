package com.bytedance.ee.bear.document.analytic.processmonitor.sandbox;

import android.content.Context;
import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.bytedance.ee.bear.document.analytic.processmonitor.entity.CpuInfo;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
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

    public ISandboxProcessServerStub(Context r2) {
        this.base = new SandboxProcessServer(r2);
        attachInterface(this, ISandboxProcessServerProxy.DESCRIPTOR);
    }

    public static ISandboxProcessServerProxy asInterface(Context r2, IBinder r3) {
        if (r3 != null) goto L5;
        return null;
    L5:
        IInterface r0 = r3.queryLocalInterface(ISandboxProcessServerProxy.DESCRIPTOR);
        if (r0 == null) goto L12;
        if ((r0 instanceof ISandboxProcessServerProxy) == false) goto L12;
        return (ISandboxProcessServerProxy) r0;
    L12:
        return new ISandboxProcessServerProxy(r2, r3);
    }

    @Override // com.bytedance.ee.bear.document.analytic.processmonitor.sandbox.ISandboxProcessServer
    public CpuInfo getCurrentCpuRate(String r2, boolean r3) {
        return this.base.getCurrentCpuRate(r2, r3);
    }

    @Override // android.os.Binder
    public boolean onTransact(int r4, Parcel r5, Parcel r6, int r7) throws RemoteException {
        if (r4 != 1) goto L5;
        r5.enforceInterface(ISandboxProcessServerProxy.DESCRIPTOR);
        long r8 = getSandboxCPUTime();
        r6.writeNoException();
        r6.writeLong(r8);
        return true;
    L5:
        if (r4 != 2) goto L7;
        r5.enforceInterface(ISandboxProcessServerProxy.DESCRIPTOR);
        String r9 = r5.readString();
        if (r5.readInt() != 0) goto L19;
        boolean r10 = false;
    L20:
        CpuInfo r11 = getCurrentCpuRate(r9, r10);
        r6.writeNoException();
        if (r11 == null) goto L23;
        r6.writeInt(1);
        r11.writeToParcel(r6, 1);
    L24:
        return true;
    L23:
        r6.writeInt(0);
        goto L24
    L19:
        r10 = true;
        goto L20
    L7:
        if (r4 != 3) goto L9;
        r5.enforceInterface(ISandboxProcessServerProxy.DESCRIPTOR);
        long r12 = getSandboxMemory();
        r6.writeNoException();
        r6.writeLong(r12);
        return true;
    L9:
        if (r4 != 1598968902) goto L11;
        r6.writeString(ISandboxProcessServerProxy.DESCRIPTOR);
        return true;
    L11:
        return super.onTransact(r4, r5, r6, r7);
    }
}
