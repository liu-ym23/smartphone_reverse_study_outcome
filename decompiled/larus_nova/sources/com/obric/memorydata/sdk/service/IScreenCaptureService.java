package com.obric.memorydata.sdk.service;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import android.os.Parcel;
import android.os.RemoteException;
import android.os.SystemClock;
import com.obric.assistant.interaction.impl.performance.BinderPerformanceReporter;
import com.obric.memorydata.sdk.screencapture.ICaptureCurrentCallback;
import com.obric.memorydata.sdk.screencapture.IEventReactionCallback;
import com.obric.memorydata.sdk.screencapture.ScreenEventReaction;
import com.obric.memorydata.sdk.screencapture.TaskOptions;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: classes33.dex */
public interface IScreenCaptureService extends IInterface {

    public static class Default implements IScreenCaptureService {
        public Default() {
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }

        @Override // com.obric.memorydata.sdk.service.IScreenCaptureService
        public void captureCurrent(TaskOptions r100, String r101, ICaptureCurrentCallback r102) throws RemoteException {
        }

        @Override // com.obric.memorydata.sdk.service.IScreenCaptureService
        public int getScreenEventReactionCount() throws RemoteException {
            return 0;
        }

        @Override // com.obric.memorydata.sdk.service.IScreenCaptureService
        public void register(ScreenEventReaction r100, long r101, IEventReactionCallback r102) throws RemoteException {
        }

        @Override // com.obric.memorydata.sdk.service.IScreenCaptureService
        public void unregister(String r100) throws RemoteException {
        }
    }

    public static abstract class Stub extends Binder implements IScreenCaptureService {
        private static final String DESCRIPTOR = "com.obric.memorydata.sdk.service.IScreenCaptureService";
        static final int TRANSACTION_captureCurrent = 4;
        static final int TRANSACTION_getScreenEventReactionCount = 3;
        static final int TRANSACTION_register = 1;
        static final int TRANSACTION_unregister = 2;

        public static class Proxy implements IScreenCaptureService {
            public static IScreenCaptureService sDefaultImpl;
            private IBinder mRemote;

            public String getInterfaceDescriptor() {
                return Stub.DESCRIPTOR;
            }

            @Override // com.obric.memorydata.sdk.service.IScreenCaptureService
            public int getScreenEventReactionCount() throws RemoteException {
                Parcel r100 = Parcel.obtain();
                Parcel r101 = Parcel.obtain();
                r100.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L13
                if (INVOKEINTERFACE_com_obric_memorydata_sdk_service_IScreenCaptureService$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 3, r100, r101, 0) == false) goto L6;
            L10:
                r101.readException();     // Catch: Throwable -> L13
                int r102 = r101.readInt();     // Catch: Throwable -> L13
                r101.recycle();
                r100.recycle();
                return r102;
            L6:
                if (Stub.getDefaultImpl() == null) goto L10;
                int r103 = Stub.getDefaultImpl().getScreenEventReactionCount();     // Catch: Throwable -> L13
                r101.recycle();
                r100.recycle();
                return r103;
            L13:
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

            @Override // com.obric.memorydata.sdk.service.IScreenCaptureService
            public void unregister(String r100) throws RemoteException {
                Parcel r101 = Parcel.obtain();
                Parcel r102 = Parcel.obtain();
                r101.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L13
                r101.writeString(r100);     // Catch: Throwable -> L13
                if (INVOKEINTERFACE_com_obric_memorydata_sdk_service_IScreenCaptureService$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 2, r101, r102, 0) == false) goto L6;
            L10:
                r102.readException();     // Catch: Throwable -> L13
                r102.recycle();
                r101.recycle();
                return;
            L6:
                if (Stub.getDefaultImpl() == null) goto L10;
                Stub.getDefaultImpl().unregister(r100);     // Catch: Throwable -> L13
                r102.recycle();
                r101.recycle();
                return;
            L13:
                th = move-exception;
                r102.recycle();
                r101.recycle();
                throw th;
            }

            @Override // com.obric.memorydata.sdk.service.IScreenCaptureService
            public void captureCurrent(TaskOptions r100, String r101, ICaptureCurrentCallback r102) throws RemoteException {
                Parcel r103 = Parcel.obtain();
                Parcel r104 = Parcel.obtain();
                r103.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L21
                if (r100 == null) goto L6;
                r103.writeInt(1);     // Catch: Throwable -> L21
                r100.writeToParcel(r103, 0);     // Catch: Throwable -> L21
            L7:
                r103.writeString(r101);     // Catch: Throwable -> L21
                if (r102 == null) goto L10;
                IBinder r105 = r102.asBinder();     // Catch: Throwable -> L21
            L11:
                r103.writeStrongBinder(r105);     // Catch: Throwable -> L21
                if (INVOKEINTERFACE_com_obric_memorydata_sdk_service_IScreenCaptureService$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 4, r103, r104, 0) == false) goto L14;
            L18:
                r104.readException();     // Catch: Throwable -> L21
                r104.recycle();
                r103.recycle();
                return;
            L14:
                if (Stub.getDefaultImpl() == null) goto L18;
                Stub.getDefaultImpl().captureCurrent(r100, r101, r102);     // Catch: Throwable -> L21
                r104.recycle();
                r103.recycle();
                return;
            L10:
                r105 = null;
                goto L11
            L6:
                r103.writeInt(0);     // Catch: Throwable -> L21
            L21:
                th = move-exception;
                r104.recycle();
                r103.recycle();
                throw th;
            }

            @Override // com.obric.memorydata.sdk.service.IScreenCaptureService
            public void register(ScreenEventReaction r100, long r101, IEventReactionCallback r102) throws RemoteException {
                Parcel r103 = Parcel.obtain();
                Parcel r104 = Parcel.obtain();
                r103.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L21
                if (r100 == null) goto L6;
                r103.writeInt(1);     // Catch: Throwable -> L21
                r100.writeToParcel(r103, 0);     // Catch: Throwable -> L21
            L7:
                r103.writeLong(r101);     // Catch: Throwable -> L21
                if (r102 == null) goto L10;
                IBinder r105 = r102.asBinder();     // Catch: Throwable -> L21
            L11:
                r103.writeStrongBinder(r105);     // Catch: Throwable -> L21
                if (INVOKEINTERFACE_com_obric_memorydata_sdk_service_IScreenCaptureService$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 1, r103, r104, 0) == false) goto L14;
            L18:
                r104.readException();     // Catch: Throwable -> L21
                r104.recycle();
                r103.recycle();
                return;
            L14:
                if (Stub.getDefaultImpl() == null) goto L18;
                Stub.getDefaultImpl().register(r100, r101, r102);     // Catch: Throwable -> L21
                r104.recycle();
                r103.recycle();
                return;
            L10:
                r105 = null;
                goto L11
            L6:
                r103.writeInt(0);     // Catch: Throwable -> L21
            L21:
                th = move-exception;
                r104.recycle();
                r103.recycle();
                throw th;
            }

            @Skip({"com.obric.assistant.interaction.impl.performance"})
            public static boolean INVOKEINTERFACE_com_obric_memorydata_sdk_service_IScreenCaptureService$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(IBinder r110, int r111, Parcel r112, Parcel r113, int r114) throws RemoteException {
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

        public static IScreenCaptureService getDefaultImpl() {
            return Proxy.sDefaultImpl;
        }

        public static IScreenCaptureService asInterface(IBinder r100) {
            if (r100 != null) goto L5;
            return null;
        L5:
            IInterface r101 = r100.queryLocalInterface(DESCRIPTOR);
            if (r101 == null) goto L12;
            if ((r101 instanceof IScreenCaptureService) == false) goto L12;
            return (IScreenCaptureService) r101;
        L12:
            return new Proxy(r100);
        }

        public static boolean setDefaultImpl(IScreenCaptureService r100) {
            if (Proxy.sDefaultImpl != null) goto L7;
            if (r100 == null) goto L9;
            Proxy.sDefaultImpl = r100;
            return true;
        L9:
            return false;
        L7:
            return false;
        }

        @Override // android.os.Binder
        public boolean onTransact(int r100, Parcel r101, Parcel r102, int r103) throws RemoteException {
            ScreenEventReaction r104 = null;
            TaskOptions r105 = null;
            if (r100 != 1) goto L5;
            r101.enforceInterface(DESCRIPTOR);
            if (r101.readInt() == 0) goto L28;
            r104 = ScreenEventReaction.CREATOR.createFromParcel(r101);
        L28:
            register(r104, r101.readLong(), IEventReactionCallback.Stub.asInterface(r101.readStrongBinder()));
            r102.writeNoException();
            return true;
        L5:
            if (r100 != 2) goto L7;
            r101.enforceInterface(DESCRIPTOR);
            unregister(r101.readString());
            r102.writeNoException();
            return true;
        L7:
            if (r100 != 3) goto L9;
            r101.enforceInterface(DESCRIPTOR);
            int r106 = getScreenEventReactionCount();
            r102.writeNoException();
            r102.writeInt(r106);
            return true;
        L9:
            if (r100 != 4) goto L11;
            r101.enforceInterface(DESCRIPTOR);
            if (r101.readInt() == 0) goto L19;
            r105 = TaskOptions.CREATOR.createFromParcel(r101);
        L19:
            captureCurrent(r105, r101.readString(), ICaptureCurrentCallback.Stub.asInterface(r101.readStrongBinder()));
            r102.writeNoException();
            return true;
        L11:
            if (r100 != 1598968902) goto L13;
            r102.writeString(DESCRIPTOR);
            return true;
        L13:
            return super.onTransact(r100, r101, r102, r103);
        }
    }

    void captureCurrent(TaskOptions r100, String r101, ICaptureCurrentCallback r102) throws RemoteException;

    int getScreenEventReactionCount() throws RemoteException;

    void register(ScreenEventReaction r100, long r101, IEventReactionCallback r102) throws RemoteException;

    void unregister(String r100) throws RemoteException;
}
