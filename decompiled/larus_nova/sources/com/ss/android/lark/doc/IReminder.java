package com.ss.android.lark.doc;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import android.os.Parcel;
import android.os.RemoteException;
import android.os.SystemClock;
import com.obric.assistant.interaction.impl.performance.BinderPerformanceReporter;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: classes35.dex */
public interface IReminder extends IInterface {

    public static class Default implements IReminder {
        public Default() {
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }

        @Override // com.ss.android.lark.doc.IReminder
        public void getRemindState(String r100, IFetchRemindCallback r101) throws RemoteException {
        }

        @Override // com.ss.android.lark.doc.IReminder
        public void registerRemindListener(IRemindStateChangeListener r100) throws RemoteException {
        }

        @Override // com.ss.android.lark.doc.IReminder
        public void setRemind(String r100, boolean r101, IPutRemindCallback r102) throws RemoteException {
        }

        @Override // com.ss.android.lark.doc.IReminder
        public void unRegisterRemindListener(IRemindStateChangeListener r100) throws RemoteException {
        }
    }

    public static abstract class Stub extends Binder implements IReminder {
        private static final String DESCRIPTOR = "com.ss.android.lark.doc.IReminder";
        static final int TRANSACTION_getRemindState = 2;
        static final int TRANSACTION_registerRemindListener = 3;
        static final int TRANSACTION_setRemind = 1;
        static final int TRANSACTION_unRegisterRemindListener = 4;

        public static class Proxy implements IReminder {
            public static IReminder sDefaultImpl;
            private IBinder mRemote;

            public String getInterfaceDescriptor() {
                return Stub.DESCRIPTOR;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.mRemote;
            }

            public Proxy(IBinder r100) {
                this.mRemote = r100;
            }

            @Override // com.ss.android.lark.doc.IReminder
            public void registerRemindListener(IRemindStateChangeListener r100) throws RemoteException {
                Parcel r101 = Parcel.obtain();
                r101.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L16
                if (r100 == null) goto L6;
                IBinder r102 = r100.asBinder();     // Catch: Throwable -> L16
            L7:
                r101.writeStrongBinder(r102);     // Catch: Throwable -> L16
                if (INVOKEINTERFACE_com_ss_android_lark_doc_IReminder$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 3, r101, null, 1) == false) goto L10;
            L14:
                r101.recycle();
                return;
            L10:
                if (Stub.getDefaultImpl() == null) goto L14;
                Stub.getDefaultImpl().registerRemindListener(r100);     // Catch: Throwable -> L16
                r101.recycle();
                return;
            L6:
                r102 = null;
            L16:
                th = move-exception;
                r101.recycle();
                throw th;
            }

            @Override // com.ss.android.lark.doc.IReminder
            public void unRegisterRemindListener(IRemindStateChangeListener r100) throws RemoteException {
                Parcel r101 = Parcel.obtain();
                r101.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L16
                if (r100 == null) goto L6;
                IBinder r102 = r100.asBinder();     // Catch: Throwable -> L16
            L7:
                r101.writeStrongBinder(r102);     // Catch: Throwable -> L16
                if (INVOKEINTERFACE_com_ss_android_lark_doc_IReminder$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 4, r101, null, 1) == false) goto L10;
            L14:
                r101.recycle();
                return;
            L10:
                if (Stub.getDefaultImpl() == null) goto L14;
                Stub.getDefaultImpl().unRegisterRemindListener(r100);     // Catch: Throwable -> L16
                r101.recycle();
                return;
            L6:
                r102 = null;
            L16:
                th = move-exception;
                r101.recycle();
                throw th;
            }

            @Override // com.ss.android.lark.doc.IReminder
            public void getRemindState(String r100, IFetchRemindCallback r101) throws RemoteException {
                Parcel r102 = Parcel.obtain();
                r102.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L16
                r102.writeString(r100);     // Catch: Throwable -> L16
                if (r101 == null) goto L6;
                IBinder r103 = r101.asBinder();     // Catch: Throwable -> L16
            L7:
                r102.writeStrongBinder(r103);     // Catch: Throwable -> L16
                if (INVOKEINTERFACE_com_ss_android_lark_doc_IReminder$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 2, r102, null, 1) == false) goto L10;
            L14:
                r102.recycle();
                return;
            L10:
                if (Stub.getDefaultImpl() == null) goto L14;
                Stub.getDefaultImpl().getRemindState(r100, r101);     // Catch: Throwable -> L16
                r102.recycle();
                return;
            L6:
                r103 = null;
            L16:
                th = move-exception;
                r102.recycle();
                throw th;
            }

            @Override // com.ss.android.lark.doc.IReminder
            public void setRemind(String r100, boolean r101, IPutRemindCallback r102) throws RemoteException {
                Parcel r103 = Parcel.obtain();
                r103.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L20
                r103.writeString(r100);     // Catch: Throwable -> L20
                if (r101 == false) goto L6;
                int r104 = 1;
            L7:
                r103.writeInt(r104);     // Catch: Throwable -> L20
                if (r102 == null) goto L10;
                IBinder r105 = r102.asBinder();     // Catch: Throwable -> L20
            L11:
                r103.writeStrongBinder(r105);     // Catch: Throwable -> L20
                if (INVOKEINTERFACE_com_ss_android_lark_doc_IReminder$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 1, r103, null, 1) == false) goto L14;
            L18:
                r103.recycle();
                return;
            L14:
                if (Stub.getDefaultImpl() == null) goto L18;
                Stub.getDefaultImpl().setRemind(r100, r101, r102);     // Catch: Throwable -> L20
                r103.recycle();
                return;
            L10:
                r105 = null;
                goto L11
            L6:
                r104 = 0;
            L20:
                th = move-exception;
                r103.recycle();
                throw th;
            }

            @Skip({"com.obric.assistant.interaction.impl.performance"})
            public static boolean INVOKEINTERFACE_com_ss_android_lark_doc_IReminder$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(IBinder r110, int r111, Parcel r112, Parcel r113, int r114) throws RemoteException {
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

        public static IReminder getDefaultImpl() {
            return Proxy.sDefaultImpl;
        }

        public static IReminder asInterface(IBinder r100) {
            if (r100 != null) goto L5;
            return null;
        L5:
            IInterface r101 = r100.queryLocalInterface(DESCRIPTOR);
            if (r101 == null) goto L12;
            if ((r101 instanceof IReminder) == false) goto L12;
            return (IReminder) r101;
        L12:
            return new Proxy(r100);
        }

        public static boolean setDefaultImpl(IReminder r100) {
            if (Proxy.sDefaultImpl != null) goto L10;
            if (r100 == null) goto L7;
            Proxy.sDefaultImpl = r100;
            return true;
        L7:
            return false;
        L10:
            throw new IllegalStateException("setDefaultImpl() called twice");
        }

        @Override // android.os.Binder
        public boolean onTransact(int r100, Parcel r101, Parcel r102, int r103) throws RemoteException {
            if (r100 != 1) goto L5;
            r101.enforceInterface(DESCRIPTOR);
            String r104 = r101.readString();
            if (r101.readInt() == 0) goto L25;
            boolean r105 = true;
        L26:
            setRemind(r104, r105, IPutRemindCallback.Stub.asInterface(r101.readStrongBinder()));
            return true;
        L25:
            r105 = false;
            goto L26
        L5:
            if (r100 != 2) goto L7;
            r101.enforceInterface(DESCRIPTOR);
            getRemindState(r101.readString(), IFetchRemindCallback.Stub.asInterface(r101.readStrongBinder()));
            return true;
        L7:
            if (r100 != 3) goto L9;
            r101.enforceInterface(DESCRIPTOR);
            registerRemindListener(IRemindStateChangeListener.Stub.asInterface(r101.readStrongBinder()));
            return true;
        L9:
            if (r100 != 4) goto L11;
            r101.enforceInterface(DESCRIPTOR);
            unRegisterRemindListener(IRemindStateChangeListener.Stub.asInterface(r101.readStrongBinder()));
            return true;
        L11:
            if (r100 != 1598968902) goto L13;
            r102.writeString(DESCRIPTOR);
            return true;
        L13:
            return super.onTransact(r100, r101, r102, r103);
        }
    }

    void getRemindState(String r100, IFetchRemindCallback r101) throws RemoteException;

    void registerRemindListener(IRemindStateChangeListener r100) throws RemoteException;

    void setRemind(String r100, boolean r101, IPutRemindCallback r102) throws RemoteException;

    void unRegisterRemindListener(IRemindStateChangeListener r100) throws RemoteException;
}
