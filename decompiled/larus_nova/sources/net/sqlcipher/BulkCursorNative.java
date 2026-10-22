package net.sqlcipher;

import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;

/* JADX INFO: loaded from: classes42.dex */
public abstract class BulkCursorNative extends Binder implements IBulkCursor {
    @Override // android.os.IInterface
    public IBinder asBinder() {
        return this;
    }

    public BulkCursorNative() {
        attachInterface(this, IBulkCursor.descriptor);
    }

    public static IBulkCursor asInterface(IBinder r100) {
        if (r100 != null) goto L5;
        return null;
    L5:
        IBulkCursor r101 = (IBulkCursor) r100.queryLocalInterface(IBulkCursor.descriptor);
        if (r101 == null) goto L9;
        return r101;
    L9:
        return new BulkCursorProxy(r100);
    }

    @Override // android.os.Binder
    public boolean onTransact(int r100, Parcel r101, Parcel r102, int r103) throws RemoteException {
        int r104 = 0;
        switch(r100) {
            case 1: goto L38;
            case 2: goto L36;
            case 3: goto L32;
            case 4: goto L27;
            case 5: goto L22;
            case 6: goto L20;
            case 7: goto L18;
            case 8: goto L16;
            case 9: goto L11;
            case 10: goto L9;
            case 11: goto L7;
            case 12: goto L5;
            default: goto L48;
        };
    L5:
        r101.enforceInterface(IBulkCursor.descriptor);     // Catch: Exception -> L44
        close();     // Catch: Exception -> L44
        r102.writeNoException();     // Catch: Exception -> L44
        return true;
    L7:
        r101.enforceInterface(IBulkCursor.descriptor);     // Catch: Exception -> L44
        Bundle r105 = respond(r101.readBundle(getClass().getClassLoader()));     // Catch: Exception -> L44
        r102.writeNoException();     // Catch: Exception -> L44
        r102.writeBundle(r105);     // Catch: Exception -> L44
        return true;
    L9:
        r101.enforceInterface(IBulkCursor.descriptor);     // Catch: Exception -> L44
        Bundle r106 = getExtras();     // Catch: Exception -> L44
        r102.writeNoException();     // Catch: Exception -> L44
        r102.writeBundle(r106);     // Catch: Exception -> L44
        return true;
    L11:
        r101.enforceInterface(IBulkCursor.descriptor);     // Catch: Exception -> L44
        boolean r107 = getWantsAllOnMoveCalls();     // Catch: Exception -> L44
        r102.writeNoException();     // Catch: Exception -> L44
        if (r107 == false) goto L14;
        r104 = 1;
    L14:
        r102.writeInt(r104);     // Catch: Exception -> L44
        return true;
    L16:
        r101.enforceInterface(IBulkCursor.descriptor);     // Catch: Exception -> L44
        onMove(r101.readInt());     // Catch: Exception -> L44
        r102.writeNoException();     // Catch: Exception -> L44
        return true;
    L18:
        r101.enforceInterface(IBulkCursor.descriptor);     // Catch: Exception -> L44
        int r108 = requery(IContentObserver.Stub.asInterface(r101.readStrongBinder()), CursorWindow.CREATOR.createFromParcel(r101));     // Catch: Exception -> L44
        r102.writeNoException();     // Catch: Exception -> L44
        r102.writeInt(r108);     // Catch: Exception -> L44
        r102.writeBundle(getExtras());     // Catch: Exception -> L44
        return true;
    L20:
        r101.enforceInterface(IBulkCursor.descriptor);     // Catch: Exception -> L44
        deactivate();     // Catch: Exception -> L44
        r102.writeNoException();     // Catch: Exception -> L44
        return true;
    L22:
        r101.enforceInterface(IBulkCursor.descriptor);     // Catch: Exception -> L44
        boolean r109 = deleteRow(r101.readInt());     // Catch: Exception -> L44
        r102.writeNoException();     // Catch: Exception -> L44
        if (r109 != true) goto L25;
        r104 = 1;
    L25:
        r102.writeInt(r104);     // Catch: Exception -> L44
        return true;
    L27:
        r101.enforceInterface(IBulkCursor.descriptor);     // Catch: Exception -> L44
        boolean r110 = updateRows(r101.readHashMap(null));     // Catch: Exception -> L44
        r102.writeNoException();     // Catch: Exception -> L44
        if (r110 != true) goto L30;
        r104 = 1;
    L30:
        r102.writeInt(r104);     // Catch: Exception -> L44
        return true;
    L32:
        r101.enforceInterface(IBulkCursor.descriptor);     // Catch: Exception -> L44
        String[] r111 = getColumnNames();     // Catch: Exception -> L44
        r102.writeNoException();     // Catch: Exception -> L44
        r102.writeInt(r111.length);     // Catch: Exception -> L44
        int r112 = r111.length;     // Catch: Exception -> L44
    L33:
        if (r104 >= r112) goto L35;
        r102.writeString(r111[r104]);     // Catch: Exception -> L44
        r104 = r104 + 1;     // Catch: Exception -> L44
        goto L33
    L35:
        return true;
    L36:
        r101.enforceInterface(IBulkCursor.descriptor);     // Catch: Exception -> L44
        int r113 = count();     // Catch: Exception -> L44
        r102.writeNoException();     // Catch: Exception -> L44
        r102.writeInt(r113);     // Catch: Exception -> L44
        return true;
    L38:
        r101.enforceInterface(IBulkCursor.descriptor);     // Catch: Exception -> L44
        CursorWindow r114 = getWindow(r101.readInt());     // Catch: Exception -> L44
        if (r114 != null) goto L42;
        r102.writeInt(0);     // Catch: Exception -> L44
        return true;
    L42:
        r102.writeNoException();     // Catch: Exception -> L44
        r102.writeInt(1);     // Catch: Exception -> L44
        r114.writeToParcel(r102, 0);     // Catch: Exception -> L44
        return true;
    L48:
        return super.onTransact(r100, r101, r102, r103);
    L44:
        e = move-exception;
        DatabaseUtils.writeExceptionToParcel(r102, e);
        return true;
    }
}
