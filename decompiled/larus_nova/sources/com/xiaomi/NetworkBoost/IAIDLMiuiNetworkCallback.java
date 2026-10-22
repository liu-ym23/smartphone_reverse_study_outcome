package com.xiaomi.NetworkBoost;

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

/* JADX INFO: loaded from: classes41.dex */
public interface IAIDLMiuiNetworkCallback extends IInterface {

    public static abstract class Stub extends Binder implements IAIDLMiuiNetworkCallback {

        public static class a implements IAIDLMiuiNetworkCallback {

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public static IAIDLMiuiNetworkCallback f462971b;

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public IBinder f462972a;

            public a(IBinder r100) {
                this.f462972a = r100;
            }

            @Override // android.os.IInterface
            public final IBinder asBinder() {
                return this.f462972a;
            }

            @Override // com.xiaomi.NetworkBoost.IAIDLMiuiNetworkCallback
            public final void dsdaStateChanged(boolean r100) {
                Parcel r101 = Parcel.obtain();
                r101.writeInterfaceToken("com.xiaomi.NetworkBoost.IAIDLMiuiNetworkCallback");     // Catch: Throwable -> L12
                r101.writeInt(r100 ? 1 : 0);     // Catch: Throwable -> L12
                if (INVOKEINTERFACE_com_xiaomi_NetworkBoost_IAIDLMiuiNetworkCallback$Stub$a_com_obric_assistant_interaction_impl_BinderLancet_transact(this.f462972a, 8, r101, null, 1) == false) goto L6;
            L10:
                r101.recycle();
                return;
            L6:
                if (Stub.getDefaultImpl() == null) goto L10;
                Stub.getDefaultImpl().dsdaStateChanged(r100);     // Catch: Throwable -> L12
                r101.recycle();
                return;
            L12:
                th = move-exception;
                r101.recycle();
                throw th;
            }

            @Override // com.xiaomi.NetworkBoost.IAIDLMiuiNetworkCallback
            public final void ifaceAdded(List<String> r100) {
                Parcel r101 = Parcel.obtain();
                r101.writeInterfaceToken("com.xiaomi.NetworkBoost.IAIDLMiuiNetworkCallback");     // Catch: Throwable -> L12
                r101.writeStringList(r100);     // Catch: Throwable -> L12
                if (INVOKEINTERFACE_com_xiaomi_NetworkBoost_IAIDLMiuiNetworkCallback$Stub$a_com_obric_assistant_interaction_impl_BinderLancet_transact(this.f462972a, 5, r101, null, 1) == false) goto L6;
            L10:
                r101.recycle();
                return;
            L6:
                if (Stub.getDefaultImpl() == null) goto L10;
                Stub.getDefaultImpl().ifaceAdded(r100);     // Catch: Throwable -> L12
                r101.recycle();
                return;
            L12:
                th = move-exception;
                r101.recycle();
                throw th;
            }

            @Override // com.xiaomi.NetworkBoost.IAIDLMiuiNetworkCallback
            public final void ifaceRemoved(List<String> r100) {
                Parcel r101 = Parcel.obtain();
                r101.writeInterfaceToken("com.xiaomi.NetworkBoost.IAIDLMiuiNetworkCallback");     // Catch: Throwable -> L12
                r101.writeStringList(r100);     // Catch: Throwable -> L12
                if (INVOKEINTERFACE_com_xiaomi_NetworkBoost_IAIDLMiuiNetworkCallback$Stub$a_com_obric_assistant_interaction_impl_BinderLancet_transact(this.f462972a, 6, r101, null, 1) == false) goto L6;
            L10:
                r101.recycle();
                return;
            L6:
                if (Stub.getDefaultImpl() == null) goto L10;
                Stub.getDefaultImpl().ifaceRemoved(r100);     // Catch: Throwable -> L12
                r101.recycle();
                return;
            L12:
                th = move-exception;
                r101.recycle();
                throw th;
            }

            @Override // com.xiaomi.NetworkBoost.IAIDLMiuiNetworkCallback
            public final void mediaPlayerPolicyNotify(int r100, int r101, int r102) {
                Parcel r103 = Parcel.obtain();
                r103.writeInterfaceToken("com.xiaomi.NetworkBoost.IAIDLMiuiNetworkCallback");     // Catch: Throwable -> L12
                r103.writeInt(r100);     // Catch: Throwable -> L12
                r103.writeInt(r101);     // Catch: Throwable -> L12
                r103.writeInt(r102);     // Catch: Throwable -> L12
                if (INVOKEINTERFACE_com_xiaomi_NetworkBoost_IAIDLMiuiNetworkCallback$Stub$a_com_obric_assistant_interaction_impl_BinderLancet_transact(this.f462972a, 9, r103, null, 1) == false) goto L6;
            L10:
                r103.recycle();
                return;
            L6:
                if (Stub.getDefaultImpl() == null) goto L10;
                Stub.getDefaultImpl().mediaPlayerPolicyNotify(r100, r101, r102);     // Catch: Throwable -> L12
                r103.recycle();
                return;
            L12:
                th = move-exception;
                r103.recycle();
                throw th;
            }

            @Override // com.xiaomi.NetworkBoost.IAIDLMiuiNetworkCallback
            public final void onNetworkPriorityChanged(int r100, int r101, int r102) {
                Parcel r103 = Parcel.obtain();
                r103.writeInterfaceToken("com.xiaomi.NetworkBoost.IAIDLMiuiNetworkCallback");     // Catch: Throwable -> L12
                r103.writeInt(r100);     // Catch: Throwable -> L12
                r103.writeInt(r101);     // Catch: Throwable -> L12
                r103.writeInt(r102);     // Catch: Throwable -> L12
                if (INVOKEINTERFACE_com_xiaomi_NetworkBoost_IAIDLMiuiNetworkCallback$Stub$a_com_obric_assistant_interaction_impl_BinderLancet_transact(this.f462972a, 10, r103, null, 1) == false) goto L6;
            L10:
                r103.recycle();
                return;
            L6:
                if (Stub.getDefaultImpl() == null) goto L10;
                Stub.getDefaultImpl().onNetworkPriorityChanged(r100, r101, r102);     // Catch: Throwable -> L12
                r103.recycle();
                return;
            L12:
                th = move-exception;
                r103.recycle();
                throw th;
            }

            @Override // com.xiaomi.NetworkBoost.IAIDLMiuiNetworkCallback
            public final void onScanSuccussed(int r100) {
                Parcel r101 = Parcel.obtain();
                r101.writeInterfaceToken("com.xiaomi.NetworkBoost.IAIDLMiuiNetworkCallback");     // Catch: Throwable -> L12
                r101.writeInt(r100);     // Catch: Throwable -> L12
                if (INVOKEINTERFACE_com_xiaomi_NetworkBoost_IAIDLMiuiNetworkCallback$Stub$a_com_obric_assistant_interaction_impl_BinderLancet_transact(this.f462972a, 1, r101, null, 1) == false) goto L6;
            L10:
                r101.recycle();
                return;
            L6:
                if (Stub.getDefaultImpl() == null) goto L10;
                Stub.getDefaultImpl().onScanSuccussed(r100);     // Catch: Throwable -> L12
                r101.recycle();
                return;
            L12:
                th = move-exception;
                r101.recycle();
                throw th;
            }

            @Override // com.xiaomi.NetworkBoost.IAIDLMiuiNetworkCallback
            public final void onSetSlaveWifiResult(boolean r100) {
                Parcel r101 = Parcel.obtain();
                r101.writeInterfaceToken("com.xiaomi.NetworkBoost.IAIDLMiuiNetworkCallback");     // Catch: Throwable -> L12
                r101.writeInt(r100 ? 1 : 0);     // Catch: Throwable -> L12
                if (INVOKEINTERFACE_com_xiaomi_NetworkBoost_IAIDLMiuiNetworkCallback$Stub$a_com_obric_assistant_interaction_impl_BinderLancet_transact(this.f462972a, 2, r101, null, 1) == false) goto L6;
            L10:
                r101.recycle();
                return;
            L6:
                if (Stub.getDefaultImpl() == null) goto L10;
                Stub.getDefaultImpl().onSetSlaveWifiResult(r100);     // Catch: Throwable -> L12
                r101.recycle();
                return;
            L12:
                th = move-exception;
                r101.recycle();
                throw th;
            }

            @Override // com.xiaomi.NetworkBoost.IAIDLMiuiNetworkCallback
            public final void onSlaveWifiConnected(boolean r100) {
                Parcel r101 = Parcel.obtain();
                r101.writeInterfaceToken("com.xiaomi.NetworkBoost.IAIDLMiuiNetworkCallback");     // Catch: Throwable -> L12
                r101.writeInt(r100 ? 1 : 0);     // Catch: Throwable -> L12
                if (INVOKEINTERFACE_com_xiaomi_NetworkBoost_IAIDLMiuiNetworkCallback$Stub$a_com_obric_assistant_interaction_impl_BinderLancet_transact(this.f462972a, 3, r101, null, 1) == false) goto L6;
            L10:
                r101.recycle();
                return;
            L6:
                if (Stub.getDefaultImpl() == null) goto L10;
                Stub.getDefaultImpl().onSlaveWifiConnected(r100);     // Catch: Throwable -> L12
                r101.recycle();
                return;
            L12:
                th = move-exception;
                r101.recycle();
                throw th;
            }

            @Override // com.xiaomi.NetworkBoost.IAIDLMiuiNetworkCallback
            public final void onSlaveWifiDisconnected(boolean r100) {
                Parcel r101 = Parcel.obtain();
                r101.writeInterfaceToken("com.xiaomi.NetworkBoost.IAIDLMiuiNetworkCallback");     // Catch: Throwable -> L12
                r101.writeInt(r100 ? 1 : 0);     // Catch: Throwable -> L12
                if (INVOKEINTERFACE_com_xiaomi_NetworkBoost_IAIDLMiuiNetworkCallback$Stub$a_com_obric_assistant_interaction_impl_BinderLancet_transact(this.f462972a, 4, r101, null, 1) == false) goto L6;
            L10:
                r101.recycle();
                return;
            L6:
                if (Stub.getDefaultImpl() == null) goto L10;
                Stub.getDefaultImpl().onSlaveWifiDisconnected(r100);     // Catch: Throwable -> L12
                r101.recycle();
                return;
            L12:
                th = move-exception;
                r101.recycle();
                throw th;
            }

            @Override // com.xiaomi.NetworkBoost.IAIDLMiuiNetworkCallback
            public final void onSlaveWifiEnable(boolean r100) {
                Parcel r101 = Parcel.obtain();
                r101.writeInterfaceToken("com.xiaomi.NetworkBoost.IAIDLMiuiNetworkCallback");     // Catch: Throwable -> L12
                r101.writeInt(r100 ? 1 : 0);     // Catch: Throwable -> L12
                if (INVOKEINTERFACE_com_xiaomi_NetworkBoost_IAIDLMiuiNetworkCallback$Stub$a_com_obric_assistant_interaction_impl_BinderLancet_transact(this.f462972a, 7, r101, null, 1) == false) goto L6;
            L10:
                r101.recycle();
                return;
            L6:
                if (Stub.getDefaultImpl() == null) goto L10;
                Stub.getDefaultImpl().onSlaveWifiEnable(r100);     // Catch: Throwable -> L12
                r101.recycle();
                return;
            L12:
                th = move-exception;
                r101.recycle();
                throw th;
            }

            @Override // com.xiaomi.NetworkBoost.IAIDLMiuiNetworkCallback
            public final void onSlaveWifiEnableV1(int r100) {
                Parcel r101 = Parcel.obtain();
                r101.writeInterfaceToken("com.xiaomi.NetworkBoost.IAIDLMiuiNetworkCallback");     // Catch: Throwable -> L12
                r101.writeInt(r100);     // Catch: Throwable -> L12
                if (INVOKEINTERFACE_com_xiaomi_NetworkBoost_IAIDLMiuiNetworkCallback$Stub$a_com_obric_assistant_interaction_impl_BinderLancet_transact(this.f462972a, 11, r101, null, 1) == false) goto L6;
            L10:
                r101.recycle();
                return;
            L6:
                if (Stub.getDefaultImpl() == null) goto L10;
                Stub.getDefaultImpl().onSlaveWifiEnableV1(r100);     // Catch: Throwable -> L12
                r101.recycle();
                return;
            L12:
                th = move-exception;
                r101.recycle();
                throw th;
            }

            @Skip({"com.obric.assistant.interaction.impl.performance"})
            public static boolean INVOKEINTERFACE_com_xiaomi_NetworkBoost_IAIDLMiuiNetworkCallback$Stub$a_com_obric_assistant_interaction_impl_BinderLancet_transact(IBinder r110, int r111, Parcel r112, Parcel r113, int r114) throws RemoteException {
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
            attachInterface(this, "com.xiaomi.NetworkBoost.IAIDLMiuiNetworkCallback");
        }

        public static IAIDLMiuiNetworkCallback asInterface(IBinder r100) {
            if (r100 != null) goto L5;
            return null;
        L5:
            IInterface r101 = r100.queryLocalInterface("com.xiaomi.NetworkBoost.IAIDLMiuiNetworkCallback");
            if (r101 == null) goto L12;
            if ((r101 instanceof IAIDLMiuiNetworkCallback) == false) goto L12;
            return (IAIDLMiuiNetworkCallback) r101;
        L12:
            return new a(r100);
        }

        public static IAIDLMiuiNetworkCallback getDefaultImpl() {
            return a.f462971b;
        }

        public static boolean setDefaultImpl(IAIDLMiuiNetworkCallback r100) {
            if (a.f462971b != null) goto L10;
            if (r100 == null) goto L7;
            a.f462971b = r100;
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
            if (r100 == 1598968902) goto L45;
            boolean r104 = false;
            switch(r100) {
                case 1: goto L43;
                case 2: goto L38;
                case 3: goto L33;
                case 4: goto L28;
                case 5: goto L26;
                case 6: goto L24;
                case 7: goto L19;
                case 8: goto L14;
                case 9: goto L12;
                case 10: goto L10;
                case 11: goto L8;
                default: goto L7;
            };
        L8:
            r101.enforceInterface("com.xiaomi.NetworkBoost.IAIDLMiuiNetworkCallback");
            onSlaveWifiEnableV1(r101.readInt());
            return true;
        L10:
            r101.enforceInterface("com.xiaomi.NetworkBoost.IAIDLMiuiNetworkCallback");
            onNetworkPriorityChanged(r101.readInt(), r101.readInt(), r101.readInt());
            return true;
        L12:
            r101.enforceInterface("com.xiaomi.NetworkBoost.IAIDLMiuiNetworkCallback");
            mediaPlayerPolicyNotify(r101.readInt(), r101.readInt(), r101.readInt());
            return true;
        L14:
            r101.enforceInterface("com.xiaomi.NetworkBoost.IAIDLMiuiNetworkCallback");
            if (r101.readInt() == 0) goto L17;
            r104 = true;
        L17:
            dsdaStateChanged(r104);
            return true;
        L19:
            r101.enforceInterface("com.xiaomi.NetworkBoost.IAIDLMiuiNetworkCallback");
            if (r101.readInt() == 0) goto L22;
            r104 = true;
        L22:
            onSlaveWifiEnable(r104);
            return true;
        L24:
            r101.enforceInterface("com.xiaomi.NetworkBoost.IAIDLMiuiNetworkCallback");
            ifaceRemoved(r101.createStringArrayList());
            return true;
        L26:
            r101.enforceInterface("com.xiaomi.NetworkBoost.IAIDLMiuiNetworkCallback");
            ifaceAdded(r101.createStringArrayList());
            return true;
        L28:
            r101.enforceInterface("com.xiaomi.NetworkBoost.IAIDLMiuiNetworkCallback");
            if (r101.readInt() == 0) goto L31;
            r104 = true;
        L31:
            onSlaveWifiDisconnected(r104);
            return true;
        L33:
            r101.enforceInterface("com.xiaomi.NetworkBoost.IAIDLMiuiNetworkCallback");
            if (r101.readInt() == 0) goto L36;
            r104 = true;
        L36:
            onSlaveWifiConnected(r104);
            return true;
        L38:
            r101.enforceInterface("com.xiaomi.NetworkBoost.IAIDLMiuiNetworkCallback");
            if (r101.readInt() == 0) goto L41;
            r104 = true;
        L41:
            onSetSlaveWifiResult(r104);
            return true;
        L43:
            r101.enforceInterface("com.xiaomi.NetworkBoost.IAIDLMiuiNetworkCallback");
            onScanSuccussed(r101.readInt());
            return true;
        L7:
            return super.onTransact(r100, r101, r102, r103);
        L45:
            r102.writeString("com.xiaomi.NetworkBoost.IAIDLMiuiNetworkCallback");
            return true;
        }
    }

    void dsdaStateChanged(boolean r100);

    void ifaceAdded(List<String> r100);

    void ifaceRemoved(List<String> r100);

    void mediaPlayerPolicyNotify(int r100, int r101, int r102);

    void onNetworkPriorityChanged(int r100, int r101, int r102);

    void onScanSuccussed(int r100);

    void onSetSlaveWifiResult(boolean r100);

    void onSlaveWifiConnected(boolean r100);

    void onSlaveWifiDisconnected(boolean r100);

    void onSlaveWifiEnable(boolean r100);

    void onSlaveWifiEnableV1(int r100);
}
