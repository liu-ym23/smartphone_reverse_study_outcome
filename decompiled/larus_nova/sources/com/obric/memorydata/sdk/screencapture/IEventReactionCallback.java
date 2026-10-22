package com.obric.memorydata.sdk.screencapture;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import android.os.Parcel;
import android.os.RemoteException;
import android.os.SystemClock;
import com.obric.assistant.interaction.impl.performance.BinderPerformanceReporter;
import com.obric.memorydata.sdk.screencapture.event.ScreenEvent;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: classes33.dex */
public interface IEventReactionCallback extends IInterface {

    public static class Default implements IEventReactionCallback {
        public Default() {
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }

        @Override // com.obric.memorydata.sdk.screencapture.IEventReactionCallback
        public void onError(int r100, String r101) throws RemoteException {
        }

        @Override // com.obric.memorydata.sdk.screencapture.IEventReactionCallback
        public void onEvent(ScreenEvent r100, ScreenData r101) throws RemoteException {
        }
    }

    public static abstract class Stub extends Binder implements IEventReactionCallback {
        private static final String DESCRIPTOR = "com.obric.memorydata.sdk.screencapture.IEventReactionCallback";
        static final int TRANSACTION_onError = 2;
        static final int TRANSACTION_onEvent = 1;

        public static class Proxy implements IEventReactionCallback {
            public static IEventReactionCallback sDefaultImpl;
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

            @Override // com.obric.memorydata.sdk.screencapture.IEventReactionCallback
            public void onError(int r100, String r101) throws RemoteException {
                Parcel r102 = Parcel.obtain();
                Parcel r103 = Parcel.obtain();
                r102.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L13
                r102.writeInt(r100);     // Catch: Throwable -> L13
                r102.writeString(r101);     // Catch: Throwable -> L13
                if (INVOKEINTERFACE_com_obric_memorydata_sdk_screencapture_IEventReactionCallback$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 2, r102, r103, 0) == false) goto L6;
            L10:
                r103.readException();     // Catch: Throwable -> L13
                r103.recycle();
                r102.recycle();
                return;
            L6:
                if (Stub.getDefaultImpl() == null) goto L10;
                Stub.getDefaultImpl().onError(r100, r101);     // Catch: Throwable -> L13
                r103.recycle();
                r102.recycle();
                return;
            L13:
                th = move-exception;
                r103.recycle();
                r102.recycle();
                throw th;
            }

            @Override // com.obric.memorydata.sdk.screencapture.IEventReactionCallback
            public void onEvent(ScreenEvent r100, ScreenData r101) throws RemoteException {
                Parcel r102 = Parcel.obtain();
                Parcel r103 = Parcel.obtain();
                r102.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L20
                if (r100 == null) goto L6;
                r102.writeInt(1);     // Catch: Throwable -> L20
                r100.writeToParcel(r102, 0);     // Catch: Throwable -> L20
            L7:
                if (r101 == null) goto L9;
                r102.writeInt(1);     // Catch: Throwable -> L20
                r101.writeToParcel(r102, 0);     // Catch: Throwable -> L20
            L11:
                if (INVOKEINTERFACE_com_obric_memorydata_sdk_screencapture_IEventReactionCallback$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 1, r102, r103, 0) == false) goto L13;
            L17:
                r103.readException();     // Catch: Throwable -> L20
                r103.recycle();
                r102.recycle();
                return;
            L13:
                if (Stub.getDefaultImpl() == null) goto L17;
                Stub.getDefaultImpl().onEvent(r100, r101);     // Catch: Throwable -> L20
                r103.recycle();
                r102.recycle();
                return;
            L9:
                r102.writeInt(0);     // Catch: Throwable -> L20
                goto L11
            L6:
                r102.writeInt(0);     // Catch: Throwable -> L20
            L20:
                th = move-exception;
                r103.recycle();
                r102.recycle();
                throw th;
            }

            @Skip({"com.obric.assistant.interaction.impl.performance"})
            public static boolean INVOKEINTERFACE_com_obric_memorydata_sdk_screencapture_IEventReactionCallback$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(IBinder r110, int r111, Parcel r112, Parcel r113, int r114) throws RemoteException {
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

        public static IEventReactionCallback getDefaultImpl() {
            return Proxy.sDefaultImpl;
        }

        public static IEventReactionCallback asInterface(IBinder r100) {
            if (r100 != null) goto L5;
            return null;
        L5:
            IInterface r101 = r100.queryLocalInterface(DESCRIPTOR);
            if (r101 == null) goto L12;
            if ((r101 instanceof IEventReactionCallback) == false) goto L12;
            return (IEventReactionCallback) r101;
        L12:
            return new Proxy(r100);
        }

        public static boolean setDefaultImpl(IEventReactionCallback r100) {
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
            if (r100 != 1) goto L5;
            r101.enforceInterface(DESCRIPTOR);
            ScreenData r104 = null;
            if (r101.readInt() == 0) goto L17;
            ScreenEvent.CREATOR.getClass();
            ScreenEvent r105 = ScreenEvent.a.a(r101);
        L19:
            if (r101.readInt() == 0) goto L21;
            r104 = ScreenData.CREATOR.createFromParcel(r101);
        L21:
            onEvent(r105, r104);
            r102.writeNoException();
            return true;
        L17:
            r105 = null;
            goto L19
        L5:
            if (r100 != 2) goto L7;
            r101.enforceInterface(DESCRIPTOR);
            onError(r101.readInt(), r101.readString());
            r102.writeNoException();
            return true;
        L7:
            if (r100 != 1598968902) goto L9;
            r102.writeString(DESCRIPTOR);
            return true;
        L9:
            return super.onTransact(r100, r101, r102, r103);
        }
    }

    void onError(int r100, String r101) throws RemoteException;

    void onEvent(ScreenEvent r100, ScreenData r101) throws RemoteException;
}
