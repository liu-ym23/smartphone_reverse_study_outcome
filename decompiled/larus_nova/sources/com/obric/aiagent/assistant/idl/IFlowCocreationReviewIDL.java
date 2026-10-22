package com.obric.aiagent.assistant.idl;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import android.os.Parcel;
import android.os.RemoteException;
import android.os.SystemClock;
import com.obric.assistant.interaction.impl.performance.BinderPerformanceReporter;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: classes4.dex */
public interface IFlowCocreationReviewIDL extends IInterface {

    /* JADX INFO: loaded from: classes32.dex */
    public static class Default implements IFlowCocreationReviewIDL {
        public Default() {
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }

        @Override // com.obric.aiagent.assistant.idl.IFlowCocreationReviewIDL
        public void logOmniStep(String r100, long r101, String r102, int r103, String r104, String r105, boolean r106, boolean r107, long r110, String r111) throws RemoteException {
        }

        @Override // com.obric.aiagent.assistant.idl.IFlowCocreationReviewIDL
        public void logOmniUserStop(String r100, long r101, String r102, long r103, String r104, String r105) throws RemoteException {
        }
    }

    public static abstract class Stub extends Binder implements IFlowCocreationReviewIDL {
        private static final String DESCRIPTOR = "com.obric.aiagent.assistant.idl.IFlowCocreationReviewIDL";
        static final int TRANSACTION_logOmniStep = 1;
        static final int TRANSACTION_logOmniUserStop = 2;

        /* JADX INFO: loaded from: classes6.dex */
        public static class Proxy implements IFlowCocreationReviewIDL {
            public static IFlowCocreationReviewIDL sDefaultImpl;
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

            @Skip({"com.obric.assistant.interaction.impl.performance"})
            public static boolean INVOKEINTERFACE_com_obric_aiagent_assistant_idl_IFlowCocreationReviewIDL$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(IBinder r110, int r111, Parcel r112, Parcel r113, int r114) throws RemoteException {
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

            @Override // com.obric.aiagent.assistant.idl.IFlowCocreationReviewIDL
            public void logOmniUserStop(String r110, long r111, String r112, long r113, String r210, String r211) throws RemoteException {
                Parcel r100 = Parcel.obtain();
                r100.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L16
                r100.writeString(r110);     // Catch: Throwable -> L16
                r100.writeLong(r111);     // Catch: Throwable -> L16
                r100.writeString(r112);     // Catch: Throwable -> L16
                r100.writeLong(r113);     // Catch: Throwable -> L16
                r100.writeString(r210);     // Catch: Throwable -> L16
                r100.writeString(r211);     // Catch: Throwable -> L16
            L14:
                th = th;
            L18:
                r100.recycle();
                throw th;
            L6:
                if (INVOKEINTERFACE_com_obric_aiagent_assistant_idl_IFlowCocreationReviewIDL$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 2, r100, null, 1) == false) goto L8;
            L12:
                r100.recycle();
                return;
            L8:
                if (Stub.getDefaultImpl() == null) goto L12;
                Stub.getDefaultImpl().logOmniUserStop(r110, r111, r112, r113, r210, r211);     // Catch: Throwable -> L14
                r100.recycle();
                return;
            L16:
                th = th;
                goto L18
            }

            @Override // com.obric.aiagent.assistant.idl.IFlowCocreationReviewIDL
            public void logOmniStep(String r110, long r111, String r210, int r211, String r212, String r213, boolean r214, boolean r215, long r216, String r217) throws RemoteException {
                Parcel r100 = Parcel.obtain();
                r100.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L23
                r100.writeString(r110);     // Catch: Throwable -> L23
                r100.writeLong(r111);     // Catch: Throwable -> L23
                r100.writeString(r210);     // Catch: Throwable -> L23
                r100.writeInt(r211);     // Catch: Throwable -> L23
                r100.writeString(r212);     // Catch: Throwable -> L23
                r100.writeString(r213);     // Catch: Throwable -> L23
                int r101 = 0;
                if (r214 == false) goto L6;
                int r112 = 1;
            L7:
                r100.writeInt(r112);     // Catch: Throwable -> L23
                if (r215 == false) goto L10;
                r101 = 1;
            L10:
                r100.writeInt(r101);     // Catch: Throwable -> L23
                r100.writeLong(r216);     // Catch: Throwable -> L23
                r100.writeString(r217);     // Catch: Throwable -> L23
            L21:
                th = th;
            L25:
                r100.recycle();
                throw th;
            L13:
                if (INVOKEINTERFACE_com_obric_aiagent_assistant_idl_IFlowCocreationReviewIDL$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 1, r100, null, 1) == false) goto L15;
            L19:
                r100.recycle();
                return;
            L15:
                if (Stub.getDefaultImpl() == null) goto L19;
                Stub.getDefaultImpl().logOmniStep(r110, r111, r210, r211, r212, r213, r214, r215, r216, r217);     // Catch: Throwable -> L21
                r100.recycle();
                return;
            L6:
                r112 = 0;
            L23:
                th = th;
                goto L25
            }
        }

        public IBinder asBinder() {
            return this;
        }

        public Stub() {
            attachInterface(this, DESCRIPTOR);
        }

        public static IFlowCocreationReviewIDL getDefaultImpl() {
            return Proxy.sDefaultImpl;
        }

        public static IFlowCocreationReviewIDL asInterface(IBinder r100) {
            if (r100 != null) goto L5;
            return null;
        L5:
            IInterface r101 = r100.queryLocalInterface(DESCRIPTOR);
            if (r101 == null) goto L12;
            if ((r101 instanceof IFlowCocreationReviewIDL) == false) goto L12;
            return (IFlowCocreationReviewIDL) r101;
        L12:
            return new Proxy(r100);
        }

        public static boolean setDefaultImpl(IFlowCocreationReviewIDL r100) {
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
        public boolean onTransact(int r210, Parcel r211, Parcel r212, int r310) throws RemoteException {
            if (r210 != 1) goto L5;
            r211.enforceInterface(DESCRIPTOR);
            String r110 = r211.readString();
            long r111 = r211.readLong();
            String r112 = r211.readString();
            int r113 = r211.readInt();
            String r114 = r211.readString();
            String r213 = r211.readString();
            if (r211.readInt() == 0) goto L17;
            boolean r214 = true;
        L19:
            if (r211.readInt() == 0) goto L21;
            boolean r215 = true;
        L22:
            logOmniStep(r110, r111, r112, r113, r114, r213, r214, r215, r211.readLong(), r211.readString());
            return true;
        L21:
            r215 = false;
            goto L22
        L17:
            r214 = false;
            goto L19
        L5:
            if (r210 != 2) goto L7;
            r211.enforceInterface(DESCRIPTOR);
            logOmniUserStop(r211.readString(), r211.readLong(), r211.readString(), r211.readLong(), r211.readString(), r211.readString());
            return true;
        L7:
            if (r210 != 1598968902) goto L9;
            r212.writeString(DESCRIPTOR);
            return true;
        L9:
            return super.onTransact(r210, r211, r212, r310);
        }
    }

    void logOmniStep(String r100, long r101, String r102, int r103, String r104, String r105, boolean r106, boolean r107, long r110, String r111) throws RemoteException;

    void logOmniUserStop(String r100, long r101, String r102, long r103, String r104, String r105) throws RemoteException;
}
