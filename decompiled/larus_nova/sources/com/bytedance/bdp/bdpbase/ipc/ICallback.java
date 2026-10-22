package com.bytedance.bdp.bdpbase.ipc;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import android.os.Parcel;
import android.os.RemoteException;
import android.os.SystemClock;
import com.obric.assistant.interaction.impl.performance.BinderPerformanceReporter;
import java.util.List;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: classes11.dex */
interface ICallback extends IInterface {

    public static abstract class Stub extends Binder implements ICallback {
        private static final String DESCRIPTOR = "com.bytedance.bdp.bdpbase.ipc.ICallback";
        static final int TRANSACTION_CALLBACK = 1;
        static final int TRANSACTION_GC = 4;
        static final int TRANSACTION_GC_ALL = 5;

        public static class Proxy implements ICallback {
            private IBinder mRemote;

            public String getInterfaceDescriptor() {
                return Stub.DESCRIPTOR;
            }

            @Override // com.bytedance.bdp.bdpbase.ipc.ICallback
            public void gcAll() throws RemoteException {
                Parcel r100 = Parcel.obtain();
                Parcel r101 = Parcel.obtain();
                r100.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L6
                INVOKEINTERFACE_com_bytedance_bdp_bdpbase_ipc_ICallback$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 4, r100, r101, 0);     // Catch: Throwable -> L6
                r101.readException();     // Catch: Throwable -> L6
                r101.recycle();
                r100.recycle();
                return;
            L6:
                th = move-exception;
                r101.recycle();
                r100.recycle();
                throw th;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.mRemote;
            }

            public Proxy(IBinder r100) {
                this.mRemote = r100;
            }

            @Override // com.bytedance.bdp.bdpbase.ipc.ICallback
            public Response callback(CallbackRequest r110) throws RemoteException {
                Parcel r100 = Parcel.obtain();
                Parcel r101 = Parcel.obtain();
                r100.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L22
                if (r110 == null) goto L6;
                r100.writeInt(1);     // Catch: Throwable -> L22
                r100.writeLong(System.nanoTime());     // Catch: Throwable -> L22
                r110.writeToParcel(r100, 0);     // Catch: Throwable -> L22
            L8:
                if (r100.dataSize() <= 870400) goto L15;
                StringBuilder r102 = new StringBuilder("Request data too large! size is: ");     // Catch: Throwable -> L22
                r102.append(r100.dataSize());     // Catch: Throwable -> L22
                r102.append(", callback request id: ");     // Catch: Throwable -> L22
                if (r110 != null) goto L12;
                long r103 = 0;
            L13:
                r102.append(r103);     // Catch: Throwable -> L22
                throw new RemoteException(r102.toString());     // Catch: Throwable -> L22
            L12:
                r103 = r110.f201101d;     // Catch: Throwable -> L22
                goto L13
            L15:
                INVOKEINTERFACE_com_bytedance_bdp_bdpbase_ipc_ICallback$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 1, r100, r101, 0);     // Catch: Throwable -> L22
                long r104 = r101.readLong();     // Catch: Throwable -> L22
                r101.readException();     // Catch: Throwable -> L22
                if (r101.readInt() == 0) goto L19;
                long r105 = r101.readLong();     // Catch: Throwable -> L22
                Response<Object> r111 = Response.CREATOR.createFromParcel(r101);     // Catch: Throwable -> L22
                r111.f201131g = System.nanoTime() - r105;     // Catch: Throwable -> L22
                r111.f201130f = r104;     // Catch: Throwable -> L22
            L20:
                r101.recycle();
                r100.recycle();
                return r111;
            L19:
                r111 = null;
                goto L20
            L6:
                r100.writeInt(0);     // Catch: Throwable -> L22
            L22:
                th = move-exception;
                r101.recycle();
                r100.recycle();
                throw th;
            }

            @Override // com.bytedance.bdp.bdpbase.ipc.ICallback
            public void gc(List<Long> r100) throws RemoteException {
                Parcel r101 = Parcel.obtain();
                Parcel r102 = Parcel.obtain();
                r101.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L6
                r101.writeList(r100);     // Catch: Throwable -> L6
                INVOKEINTERFACE_com_bytedance_bdp_bdpbase_ipc_ICallback$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 4, r101, r102, 0);     // Catch: Throwable -> L6
                r102.readException();     // Catch: Throwable -> L6
                r102.recycle();
                r101.recycle();
                return;
            L6:
                th = move-exception;
                r102.recycle();
                r101.recycle();
                throw th;
            }

            @Skip({"com.obric.assistant.interaction.impl.performance"})
            public static boolean INVOKEINTERFACE_com_bytedance_bdp_bdpbase_ipc_ICallback$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(IBinder r110, int r111, Parcel r112, Parcel r113, int r114) throws RemoteException {
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

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        public Stub() {
            attachInterface(this, DESCRIPTOR);
        }

        public static ICallback asInterface(IBinder r100) {
            if (r100 != null) goto L5;
            return null;
        L5:
            IInterface r101 = r100.queryLocalInterface(DESCRIPTOR);
            if ((r101 instanceof ICallback) == false) goto L10;
            return (ICallback) r101;
        L10:
            return new Proxy(r100);
        }

        @Override // android.os.Binder
        public boolean onTransact(int r100, Parcel r101, Parcel r102, int r110) throws RemoteException {
            if (r100 != 1) goto L5;
            r101.enforceInterface(DESCRIPTOR);
            if (r101.readInt() == 0) goto L21;
            long r103 = r101.readLong();
            CallbackRequest r104 = CallbackRequest.CREATOR.createFromParcel(r101);
            r102.writeLong(System.nanoTime() - r103);
        L22:
            Response r105 = callback(r104);
            r102.writeNoException();
            if (r105 == null) goto L25;
            r102.writeInt(1);
            r102.writeLong(System.nanoTime());
            r105.writeToParcel(r102, 1);
        L26:
            return true;
        L25:
            r102.writeInt(0);
            goto L26
        L21:
            r104 = null;
            goto L22
        L5:
            if (r100 != 1598968902) goto L7;
            r102.writeString(DESCRIPTOR);
            return true;
        L7:
            if (r100 != 4) goto L9;
            r101.enforceInterface(DESCRIPTOR);
            gc(r101.readArrayList(com.bytedance.bdp.bdpbase.util.b.a()));
            r102.writeNoException();
            return true;
        L9:
            if (r100 != 5) goto L11;
            r101.enforceInterface(DESCRIPTOR);
            gcAll();
            r102.writeNoException();
            return true;
        L11:
            return super.onTransact(r100, r101, r102, r110);
        }
    }

    Response callback(CallbackRequest r100) throws RemoteException;

    void gc(List<Long> r100) throws RemoteException;

    void gcAll() throws RemoteException;
}
