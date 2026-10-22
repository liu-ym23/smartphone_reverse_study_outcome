package com.ss.android.lark.audit_provider;

import android.content.Context;
import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.ss.android.lark.audit.db.AuditDBData;
import java.util.List;

/* JADX INFO: loaded from: classes34.dex */
public final class IDataIPCServiceStub extends Binder implements IInterface, IDataIPCService {
    public final DataIPCServiceImpl base;

    @Override // android.os.IInterface
    public IBinder asBinder() {
        return this;
    }

    public IDataIPCServiceStub(Context r100) {
        this.base = new DataIPCServiceImpl(r100);
        attachInterface(this, IDataIPCServiceProxy.DESCRIPTOR);
    }

    public static IDataIPCServiceProxy asInterface(Context r100, IBinder r101) {
        if (r101 != null) goto L5;
        return null;
    L5:
        IInterface r102 = r101.queryLocalInterface(IDataIPCServiceProxy.DESCRIPTOR);
        if (r102 == null) goto L12;
        if ((r102 instanceof IDataIPCServiceProxy) == false) goto L12;
        return (IDataIPCServiceProxy) r102;
    L12:
        return new IDataIPCServiceProxy(r100, r101);
    }

    @Override // com.ss.android.lark.audit_provider.IDataIPCService, gwa.g.a
    public void deleteAuditData(String r100, List<AuditDBData> r101) {
        this.base.deleteAuditData(r100, r101);
    }

    @Override // com.ss.android.lark.audit_provider.IDataIPCService, gwa.g.a
    public List<AuditDBData> queryAuditData(String r100, int r101) {
        return this.base.queryAuditData(r100, r101);
    }

    @Override // com.ss.android.lark.audit_provider.IDataIPCService, gwa.g.a
    public void recordAuditData(String r100, String r101) {
        this.base.recordAuditData(r100, r101);
    }

    @Override // android.os.Binder
    public boolean onTransact(int r100, Parcel r101, Parcel r102, int r103) throws RemoteException {
        if (r100 != 1) goto L5;
        r101.enforceInterface(IDataIPCServiceProxy.DESCRIPTOR);
        recordAuditData(r101.readString(), r101.readString());
        r102.writeNoException();
        return true;
    L5:
        if (r100 != 2) goto L7;
        r101.enforceInterface(IDataIPCServiceProxy.DESCRIPTOR);
        List<AuditDBData> r104 = queryAuditData(r101.readString(), r101.readInt());
        r102.writeNoException();
        r102.writeList(r104);
        return true;
    L7:
        if (r100 != 3) goto L9;
        r101.enforceInterface(IDataIPCServiceProxy.DESCRIPTOR);
        deleteAuditData(r101.readString(), r101.readArrayList(IDataIPCServiceStub.class.getClassLoader()));
        r102.writeNoException();
        return true;
    L9:
        if (r100 != 1598968902) goto L11;
        r102.writeString(IDataIPCServiceProxy.DESCRIPTOR);
        return true;
    L11:
        return super.onTransact(r100, r101, r102, r103);
    }
}
