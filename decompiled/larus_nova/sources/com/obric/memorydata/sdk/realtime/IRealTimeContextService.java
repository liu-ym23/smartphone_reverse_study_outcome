package com.obric.memorydata.sdk.realtime;

import android.app.assist.AssistStructure;
import android.graphics.Bitmap;
import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import android.os.Parcel;
import android.os.RemoteException;
import android.os.SystemClock;
import com.obric.assistant.interaction.impl.performance.BinderPerformanceReporter;
import com.obric.capabilitykit.entity.app.AppEntity;
import java.util.List;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: classes33.dex */
public interface IRealTimeContextService extends IInterface {

    public static class Default implements IRealTimeContextService {
        public Default() {
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }

        @Override // com.obric.memorydata.sdk.realtime.IRealTimeContextService
        public void onHandleAssist(AssistStructure r100, List<AppEntity> r101) throws RemoteException {
        }

        @Override // com.obric.memorydata.sdk.realtime.IRealTimeContextService
        public void onHandleAssistWithCallback(AssistStructure r100, List<AppEntity> r101, IRealTimeContextCallback r102) throws RemoteException {
        }

        @Override // com.obric.memorydata.sdk.realtime.IRealTimeContextService
        public void onHandleScreenshot(Bitmap r100) throws RemoteException {
        }

        @Override // com.obric.memorydata.sdk.realtime.IRealTimeContextService
        public RealTimeContextResult queryRealTimeContext(String r100, String r101, String r102) throws RemoteException {
            return null;
        }
    }

    public static abstract class Stub extends Binder implements IRealTimeContextService {
        private static final String DESCRIPTOR = "com.obric.memorydata.sdk.realtime.IRealTimeContextService";
        static final int TRANSACTION_onHandleAssist = 1;
        static final int TRANSACTION_onHandleAssistWithCallback = 4;
        static final int TRANSACTION_onHandleScreenshot = 2;
        static final int TRANSACTION_queryRealTimeContext = 3;

        public static class Proxy implements IRealTimeContextService {
            public static IRealTimeContextService sDefaultImpl;
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

            @Override // com.obric.memorydata.sdk.realtime.IRealTimeContextService
            public void onHandleScreenshot(Bitmap r100) throws RemoteException {
                Parcel r101 = Parcel.obtain();
                r101.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L16
                if (r100 == null) goto L6;
                r101.writeInt(1);     // Catch: Throwable -> L16
                r100.writeToParcel(r101, 0);     // Catch: Throwable -> L16
            L8:
                if (INVOKEINTERFACE_com_obric_memorydata_sdk_realtime_IRealTimeContextService$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 2, r101, null, 1) == false) goto L10;
            L14:
                r101.recycle();
                return;
            L10:
                if (Stub.getDefaultImpl() == null) goto L14;
                Stub.getDefaultImpl().onHandleScreenshot(r100);     // Catch: Throwable -> L16
                r101.recycle();
                return;
            L6:
                r101.writeInt(0);     // Catch: Throwable -> L16
            L16:
                th = move-exception;
                r101.recycle();
                throw th;
            }

            @Override // com.obric.memorydata.sdk.realtime.IRealTimeContextService
            public void onHandleAssist(AssistStructure r100, List<AppEntity> r101) throws RemoteException {
                Parcel r102 = Parcel.obtain();
                r102.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L16
                if (r100 == null) goto L6;
                r102.writeInt(1);     // Catch: Throwable -> L16
                r100.writeToParcel(r102, 0);     // Catch: Throwable -> L16
            L7:
                r102.writeTypedList(r101);     // Catch: Throwable -> L16
                if (INVOKEINTERFACE_com_obric_memorydata_sdk_realtime_IRealTimeContextService$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 1, r102, null, 1) == false) goto L10;
            L14:
                r102.recycle();
                return;
            L10:
                if (Stub.getDefaultImpl() == null) goto L14;
                Stub.getDefaultImpl().onHandleAssist(r100, r101);     // Catch: Throwable -> L16
                r102.recycle();
                return;
            L6:
                r102.writeInt(0);     // Catch: Throwable -> L16
            L16:
                th = move-exception;
                r102.recycle();
                throw th;
            }

            @Override // com.obric.memorydata.sdk.realtime.IRealTimeContextService
            public void onHandleAssistWithCallback(AssistStructure r100, List<AppEntity> r101, IRealTimeContextCallback r102) throws RemoteException {
                Parcel r103 = Parcel.obtain();
                r103.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L20
                if (r100 == null) goto L6;
                r103.writeInt(1);     // Catch: Throwable -> L20
                r100.writeToParcel(r103, 0);     // Catch: Throwable -> L20
            L7:
                r103.writeTypedList(r101);     // Catch: Throwable -> L20
                if (r102 == null) goto L10;
                IBinder r104 = r102.asBinder();     // Catch: Throwable -> L20
            L11:
                r103.writeStrongBinder(r104);     // Catch: Throwable -> L20
                if (INVOKEINTERFACE_com_obric_memorydata_sdk_realtime_IRealTimeContextService$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 4, r103, null, 1) == false) goto L14;
            L18:
                r103.recycle();
                return;
            L14:
                if (Stub.getDefaultImpl() == null) goto L18;
                Stub.getDefaultImpl().onHandleAssistWithCallback(r100, r101, r102);     // Catch: Throwable -> L20
                r103.recycle();
                return;
            L10:
                r104 = null;
                goto L11
            L6:
                r103.writeInt(0);     // Catch: Throwable -> L20
            L20:
                th = move-exception;
                r103.recycle();
                throw th;
            }

            @Override // com.obric.memorydata.sdk.realtime.IRealTimeContextService
            public RealTimeContextResult queryRealTimeContext(String r100, String r101, String r102) throws RemoteException {
                Parcel r103 = Parcel.obtain();
                Parcel r104 = Parcel.obtain();
                r103.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L17
                r103.writeString(r100);     // Catch: Throwable -> L17
                r103.writeString(r101);     // Catch: Throwable -> L17
                r103.writeString(r102);     // Catch: Throwable -> L17
                if (INVOKEINTERFACE_com_obric_memorydata_sdk_realtime_IRealTimeContextService$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 3, r103, r104, 0) == false) goto L6;
            L10:
                r104.readException();     // Catch: Throwable -> L17
                if (r104.readInt() == 0) goto L14;
                RealTimeContextResult r105 = RealTimeContextResult.CREATOR.createFromParcel(r104);     // Catch: Throwable -> L17
            L15:
                r104.recycle();
                r103.recycle();
                return r105;
            L14:
                r105 = null;
                goto L15
            L6:
                if (Stub.getDefaultImpl() == null) goto L10;
                RealTimeContextResult r106 = Stub.getDefaultImpl().queryRealTimeContext(r100, r101, r102);     // Catch: Throwable -> L17
                r104.recycle();
                r103.recycle();
                return r106;
            L17:
                th = move-exception;
                r104.recycle();
                r103.recycle();
                throw th;
            }

            @Skip({"com.obric.assistant.interaction.impl.performance"})
            public static boolean INVOKEINTERFACE_com_obric_memorydata_sdk_realtime_IRealTimeContextService$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(IBinder r110, int r111, Parcel r112, Parcel r113, int r114) throws RemoteException {
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

        public static IRealTimeContextService getDefaultImpl() {
            return Proxy.sDefaultImpl;
        }

        public static IRealTimeContextService asInterface(IBinder r100) {
            if (r100 != null) goto L5;
            return null;
        L5:
            IInterface r101 = r100.queryLocalInterface(DESCRIPTOR);
            if (r101 == null) goto L12;
            if ((r101 instanceof IRealTimeContextService) == false) goto L12;
            return (IRealTimeContextService) r101;
        L12:
            return new Proxy(r100);
        }

        public static boolean setDefaultImpl(IRealTimeContextService r100) {
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
            AssistStructure r104 = null;
            AssistStructure r105 = null;
            Bitmap r106 = null;
            if (r100 != 1) goto L5;
            r101.enforceInterface(DESCRIPTOR);
            if (r101.readInt() == 0) goto L34;
            r104 = (AssistStructure) AssistStructure.CREATOR.createFromParcel(r101);
        L34:
            onHandleAssist(r104, r101.createTypedArrayList(AppEntity.CREATOR));
            return true;
        L5:
            if (r100 != 2) goto L7;
            r101.enforceInterface(DESCRIPTOR);
            if (r101.readInt() == 0) goto L29;
            r106 = (Bitmap) Bitmap.CREATOR.createFromParcel(r101);
        L29:
            onHandleScreenshot(r106);
            return true;
        L7:
            if (r100 != 3) goto L9;
            r101.enforceInterface(DESCRIPTOR);
            RealTimeContextResult r107 = queryRealTimeContext(r101.readString(), r101.readString(), r101.readString());
            r102.writeNoException();
            if (r107 == null) goto L24;
            r102.writeInt(1);
            r107.writeToParcel(r102, 1);
        L25:
            return true;
        L24:
            r102.writeInt(0);
            goto L25
        L9:
            if (r100 != 4) goto L11;
            r101.enforceInterface(DESCRIPTOR);
            if (r101.readInt() == 0) goto L19;
            r105 = (AssistStructure) AssistStructure.CREATOR.createFromParcel(r101);
        L19:
            onHandleAssistWithCallback(r105, r101.createTypedArrayList(AppEntity.CREATOR), IRealTimeContextCallback.Stub.asInterface(r101.readStrongBinder()));
            return true;
        L11:
            if (r100 != 1598968902) goto L13;
            r102.writeString(DESCRIPTOR);
            return true;
        L13:
            return super.onTransact(r100, r101, r102, r103);
        }
    }

    void onHandleAssist(AssistStructure r100, List<AppEntity> r101) throws RemoteException;

    void onHandleAssistWithCallback(AssistStructure r100, List<AppEntity> r101, IRealTimeContextCallback r102) throws RemoteException;

    void onHandleScreenshot(Bitmap r100) throws RemoteException;

    RealTimeContextResult queryRealTimeContext(String r100, String r101, String r102) throws RemoteException;
}
