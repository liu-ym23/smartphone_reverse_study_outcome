package net.sqlcipher;

import android.os.Bundle;
import android.os.IBinder;
import android.os.Looper;
import android.os.Parcel;
import android.os.RemoteException;
import android.os.SystemClock;
import com.obric.assistant.interaction.impl.performance.BinderPerformanceReporter;
import java.util.Map;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: classes42.dex */
final class BulkCursorProxy implements IBulkCursor {
    private Bundle mExtras;
    private IBinder mRemote;

    @Override // net.sqlcipher.IBulkCursor
    public Bundle getExtras() throws RemoteException {
        if (this.mExtras != null) goto L6;
        Parcel r100 = Parcel.obtain();
        Parcel r101 = Parcel.obtain();
        r100.writeInterfaceToken(IBulkCursor.descriptor);
        INVOKEINTERFACE_net_sqlcipher_BulkCursorProxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 10, r100, r101, 0);
        DatabaseUtils.readExceptionFromParcel(r101);
        this.mExtras = r101.readBundle(BulkCursorProxy.class.getClassLoader());
        r100.recycle();
        r101.recycle();
    L6:
        return this.mExtras;
    }

    @Override // net.sqlcipher.IBulkCursor
    public void close() throws RemoteException {
        Parcel r100 = Parcel.obtain();
        Parcel r101 = Parcel.obtain();
        r100.writeInterfaceToken(IBulkCursor.descriptor);
        INVOKEINTERFACE_net_sqlcipher_BulkCursorProxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 12, r100, r101, 0);
        DatabaseUtils.readExceptionFromParcel(r101);
        r100.recycle();
        r101.recycle();
    }

    @Override // net.sqlcipher.IBulkCursor
    public int count() throws RemoteException {
        Parcel r100 = Parcel.obtain();
        Parcel r101 = Parcel.obtain();
        r100.writeInterfaceToken(IBulkCursor.descriptor);
        boolean r102 = INVOKEINTERFACE_net_sqlcipher_BulkCursorProxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 2, r100, r101, 0);
        DatabaseUtils.readExceptionFromParcel(r101);
        if (r102 == true) goto L5;
        int r103 = -1;
    L6:
        r100.recycle();
        r101.recycle();
        return r103;
    L5:
        r103 = r101.readInt();
        goto L6
    }

    @Override // net.sqlcipher.IBulkCursor
    public void deactivate() throws RemoteException {
        Parcel r100 = Parcel.obtain();
        Parcel r101 = Parcel.obtain();
        r100.writeInterfaceToken(IBulkCursor.descriptor);
        INVOKEINTERFACE_net_sqlcipher_BulkCursorProxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 6, r100, r101, 0);
        DatabaseUtils.readExceptionFromParcel(r101);
        r100.recycle();
        r101.recycle();
    }

    @Override // net.sqlcipher.IBulkCursor
    public String[] getColumnNames() throws RemoteException {
        Parcel r100 = Parcel.obtain();
        Parcel r101 = Parcel.obtain();
        r100.writeInterfaceToken(IBulkCursor.descriptor);
        int r102 = 0;
        INVOKEINTERFACE_net_sqlcipher_BulkCursorProxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 3, r100, r101, 0);
        DatabaseUtils.readExceptionFromParcel(r101);
        int r103 = r101.readInt();
        String[] r104 = new String[r103];
    L3:
        if (r102 >= r103) goto L5;
        r104[r102] = r101.readString();
        r102 = r102 + 1;
        goto L3
    L5:
        r100.recycle();
        r101.recycle();
        return r104;
    }

    @Override // net.sqlcipher.IBulkCursor
    public boolean getWantsAllOnMoveCalls() throws RemoteException {
        Parcel r100 = Parcel.obtain();
        Parcel r101 = Parcel.obtain();
        r100.writeInterfaceToken(IBulkCursor.descriptor);
        INVOKEINTERFACE_net_sqlcipher_BulkCursorProxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 9, r100, r101, 0);
        DatabaseUtils.readExceptionFromParcel(r101);
        int r102 = r101.readInt();
        r100.recycle();
        r101.recycle();
        if (r102 == 0) goto L6;
        return true;
    L6:
        return false;
    }

    @Override // android.os.IInterface
    public IBinder asBinder() {
        return this.mRemote;
    }

    public BulkCursorProxy(IBinder r100) {
        this.mRemote = r100;
        this.mExtras = null;
    }

    @Override // net.sqlcipher.IBulkCursor
    public boolean deleteRow(int r100) throws RemoteException {
        Parcel r101 = Parcel.obtain();
        Parcel r102 = Parcel.obtain();
        r101.writeInterfaceToken(IBulkCursor.descriptor);
        r101.writeInt(r100);
        boolean r103 = false;
        INVOKEINTERFACE_net_sqlcipher_BulkCursorProxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 5, r101, r102, 0);
        DatabaseUtils.readExceptionFromParcel(r102);
        if (r102.readInt() != 1) goto L5;
        r103 = true;
    L5:
        r101.recycle();
        r102.recycle();
        return r103;
    }

    @Override // net.sqlcipher.IBulkCursor
    public CursorWindow getWindow(int r100) throws RemoteException {
        Parcel r101 = Parcel.obtain();
        Parcel r102 = Parcel.obtain();
        r101.writeInterfaceToken(IBulkCursor.descriptor);
        r101.writeInt(r100);
        INVOKEINTERFACE_net_sqlcipher_BulkCursorProxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 1, r101, r102, 0);
        DatabaseUtils.readExceptionFromParcel(r102);
        if (r102.readInt() != 1) goto L5;
        CursorWindow r103 = CursorWindow.newFromParcel(r102);
    L6:
        r101.recycle();
        r102.recycle();
        return r103;
    L5:
        r103 = null;
        goto L6
    }

    @Override // net.sqlcipher.IBulkCursor
    public void onMove(int r100) throws RemoteException {
        Parcel r101 = Parcel.obtain();
        Parcel r102 = Parcel.obtain();
        r101.writeInterfaceToken(IBulkCursor.descriptor);
        r101.writeInt(r100);
        INVOKEINTERFACE_net_sqlcipher_BulkCursorProxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 8, r101, r102, 0);
        DatabaseUtils.readExceptionFromParcel(r102);
        r101.recycle();
        r102.recycle();
    }

    @Override // net.sqlcipher.IBulkCursor
    public Bundle respond(Bundle r100) throws RemoteException {
        Parcel r101 = Parcel.obtain();
        Parcel r102 = Parcel.obtain();
        r101.writeInterfaceToken(IBulkCursor.descriptor);
        r101.writeBundle(r100);
        INVOKEINTERFACE_net_sqlcipher_BulkCursorProxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 11, r101, r102, 0);
        DatabaseUtils.readExceptionFromParcel(r102);
        Bundle r103 = r102.readBundle(BulkCursorProxy.class.getClassLoader());
        r101.recycle();
        r102.recycle();
        return r103;
    }

    @Override // net.sqlcipher.IBulkCursor
    public boolean updateRows(Map r100) throws RemoteException {
        Parcel r101 = Parcel.obtain();
        Parcel r102 = Parcel.obtain();
        r101.writeInterfaceToken(IBulkCursor.descriptor);
        r101.writeMap(r100);
        boolean r103 = false;
        INVOKEINTERFACE_net_sqlcipher_BulkCursorProxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 4, r101, r102, 0);
        DatabaseUtils.readExceptionFromParcel(r102);
        if (r102.readInt() != 1) goto L5;
        r103 = true;
    L5:
        r101.recycle();
        r102.recycle();
        return r103;
    }

    @Override // net.sqlcipher.IBulkCursor
    public int requery(IContentObserver r100, CursorWindow r101) throws RemoteException {
        Parcel r102 = Parcel.obtain();
        Parcel r103 = Parcel.obtain();
        r102.writeInterfaceToken(IBulkCursor.descriptor);
        r102.writeStrongInterface(r100);
        r101.writeToParcel(r102, 0);
        boolean r104 = INVOKEINTERFACE_net_sqlcipher_BulkCursorProxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 7, r102, r103, 0);
        DatabaseUtils.readExceptionFromParcel(r103);
        if (r104 == true) goto L5;
        int r105 = -1;
    L6:
        r102.recycle();
        r103.recycle();
        return r105;
    L5:
        r105 = r103.readInt();
        this.mExtras = r103.readBundle(BulkCursorProxy.class.getClassLoader());
        goto L6
    }

    @Skip({"com.obric.assistant.interaction.impl.performance"})
    public static boolean INVOKEINTERFACE_net_sqlcipher_BulkCursorProxy_com_obric_assistant_interaction_impl_BinderLancet_transact(IBinder r110, int r111, Parcel r112, Parcel r113, int r114) throws RemoteException {
        if (Looper.myLooper() != Looper.getMainLooper()) goto L5;
        long r100 = SystemClock.uptimeMillis();
        boolean r101 = r110.transact(r111, r112, r113, r114);     // Catch: Throwable -> L12
        long r102 = SystemClock.uptimeMillis() - r100;
        if (r102 < 100) goto L11;
        BinderPerformanceReporter.report(r102, r110.getClass().getName(), r111, r114, new Throwable("Slow main-thread Binder transaction"));
    L11:
        return r101;
    L12:
        th = move-exception;
        long r103 = SystemClock.uptimeMillis() - r100;
        if (r103 < 100) goto L22;
        if (r110 != null) goto L17;
        String r104 = "";
    L18:
        BinderPerformanceReporter.report(r103, r104, r111, r114, new Throwable("Slow main-thread Binder transaction"));
        throw th;
    L17:
        r104 = r110.getClass().getName();
        goto L18
    L22:
        throw th;
    L5:
        return r110.transact(r111, r112, r113, r114);
    }
}
