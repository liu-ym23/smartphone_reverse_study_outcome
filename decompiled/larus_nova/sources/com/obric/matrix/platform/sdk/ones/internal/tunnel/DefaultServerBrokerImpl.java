package com.obric.matrix.platform.sdk.ones.internal.tunnel;

import android.os.IBinder;
import android.os.RemoteException;
import com.obric.matrix.platform.server.IServerBroker;
import com.obric.matrix.platform.server.IServerCallback;

/* JADX INFO: loaded from: classes33.dex */
class DefaultServerBrokerImpl implements IServerBroker {
    public DefaultServerBrokerImpl() {
    }

    @Override // android.os.IInterface
    public IBinder asBinder() {
        return null;
    }

    @Override // com.obric.matrix.platform.server.IServerBroker
    public byte[] invoke(int r100, byte[] r101) throws RemoteException {
        return new byte[0];
    }

    @Override // com.obric.matrix.platform.server.IServerBroker
    public void invokeAsyn(int r100, byte[] r101, IServerCallback r102) throws RemoteException {
    }

    @Override // com.obric.matrix.platform.server.IServerBroker
    public void registerServerCallback(String r100, IServerCallback r101) throws RemoteException {
    }
}
