package com.xiaomi.NetworkBoost;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import android.os.Parcel;
import android.os.RemoteException;
import android.os.SystemClock;
import com.obric.assistant.interaction.impl.performance.BinderPerformanceReporter;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: classes41.dex */
public interface IAIDLMiuiNetQoECallback extends IInterface {

    public static abstract class Stub extends Binder implements IAIDLMiuiNetQoECallback {

        public static class a implements IAIDLMiuiNetQoECallback {

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public static IAIDLMiuiNetQoECallback f462965b;

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public IBinder f462966a;

            public a(IBinder r100) {
                this.f462966a = r100;
            }

            @Override // android.os.IInterface
            public final IBinder asBinder() {
                return this.f462966a;
            }

            @Override // com.xiaomi.NetworkBoost.IAIDLMiuiNetQoECallback
            public final void masterQoECallBack(NetLinkLayerQoE r100) {
                Parcel r101 = Parcel.obtain();
                r101.writeInterfaceToken("com.xiaomi.NetworkBoost.IAIDLMiuiNetQoECallback");     // Catch: Throwable -> L16
                if (r100 == null) goto L6;
                r101.writeInt(1);     // Catch: Throwable -> L16
                r100.writeToParcel(r101, 0);     // Catch: Throwable -> L16
            L8:
                if (INVOKEINTERFACE_com_xiaomi_NetworkBoost_IAIDLMiuiNetQoECallback$Stub$a_com_obric_assistant_interaction_impl_BinderLancet_transact(this.f462966a, 1, r101, null, 1) == false) goto L10;
            L14:
                r101.recycle();
                return;
            L10:
                if (Stub.getDefaultImpl() == null) goto L14;
                Stub.getDefaultImpl().masterQoECallBack(r100);     // Catch: Throwable -> L16
                r101.recycle();
                return;
            L6:
                r101.writeInt(0);     // Catch: Throwable -> L16
            L16:
                th = move-exception;
                r101.recycle();
                throw th;
            }

            @Override // com.xiaomi.NetworkBoost.IAIDLMiuiNetQoECallback
            public final void slaveQoECallBack(NetLinkLayerQoE r100) {
                Parcel r101 = Parcel.obtain();
                r101.writeInterfaceToken("com.xiaomi.NetworkBoost.IAIDLMiuiNetQoECallback");     // Catch: Throwable -> L16
                if (r100 == null) goto L6;
                r101.writeInt(1);     // Catch: Throwable -> L16
                r100.writeToParcel(r101, 0);     // Catch: Throwable -> L16
            L8:
                if (INVOKEINTERFACE_com_xiaomi_NetworkBoost_IAIDLMiuiNetQoECallback$Stub$a_com_obric_assistant_interaction_impl_BinderLancet_transact(this.f462966a, 2, r101, null, 1) == false) goto L10;
            L14:
                r101.recycle();
                return;
            L10:
                if (Stub.getDefaultImpl() == null) goto L14;
                Stub.getDefaultImpl().slaveQoECallBack(r100);     // Catch: Throwable -> L16
                r101.recycle();
                return;
            L6:
                r101.writeInt(0);     // Catch: Throwable -> L16
            L16:
                th = move-exception;
                r101.recycle();
                throw th;
            }

            @Skip({"com.obric.assistant.interaction.impl.performance"})
            public static boolean INVOKEINTERFACE_com_xiaomi_NetworkBoost_IAIDLMiuiNetQoECallback$Stub$a_com_obric_assistant_interaction_impl_BinderLancet_transact(IBinder r110, int r111, Parcel r112, Parcel r113, int r114) throws RemoteException {
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

        public Stub() {
            attachInterface(this, "com.xiaomi.NetworkBoost.IAIDLMiuiNetQoECallback");
        }

        public static IAIDLMiuiNetQoECallback asInterface(IBinder r100) {
            if (r100 != null) goto L5;
            return null;
        L5:
            IInterface r101 = r100.queryLocalInterface("com.xiaomi.NetworkBoost.IAIDLMiuiNetQoECallback");
            if (r101 == null) goto L12;
            if ((r101 instanceof IAIDLMiuiNetQoECallback) == false) goto L12;
            return (IAIDLMiuiNetQoECallback) r101;
        L12:
            return new a(r100);
        }

        public static IAIDLMiuiNetQoECallback getDefaultImpl() {
            return a.f462965b;
        }

        public static boolean setDefaultImpl(IAIDLMiuiNetQoECallback r100) {
            if (a.f462965b != null) goto L10;
            if (r100 == null) goto L7;
            a.f462965b = r100;
            return true;
        L7:
            return false;
        L10:
            throw new IllegalStateException("setDefaultImpl() called twice");
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        @Override // android.os.Binder
        public boolean onTransact(int r100, Parcel r101, Parcel r102, int r103) {
            NetLinkLayerQoE r104 = null;
            if (r100 != 1) goto L5;
            r101.enforceInterface("com.xiaomi.NetworkBoost.IAIDLMiuiNetQoECallback");
            if (r101.readInt() == 0) goto L20;
            r104 = NetLinkLayerQoE.CREATOR.createFromParcel(r101);
        L20:
            masterQoECallBack(r104);
            return true;
        L5:
            if (r100 != 2) goto L7;
            r101.enforceInterface("com.xiaomi.NetworkBoost.IAIDLMiuiNetQoECallback");
            if (r101.readInt() == 0) goto L15;
            r104 = NetLinkLayerQoE.CREATOR.createFromParcel(r101);
        L15:
            slaveQoECallBack(r104);
            return true;
        L7:
            if (r100 != 1598968902) goto L9;
            r102.writeString("com.xiaomi.NetworkBoost.IAIDLMiuiNetQoECallback");
            return true;
        L9:
            return super.onTransact(r100, r101, r102, r103);
        }
    }

    void masterQoECallBack(NetLinkLayerQoE r100);

    void slaveQoECallBack(NetLinkLayerQoE r100);
}
