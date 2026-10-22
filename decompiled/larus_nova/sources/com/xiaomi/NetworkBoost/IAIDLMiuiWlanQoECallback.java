package com.xiaomi.NetworkBoost;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import android.os.Parcel;
import android.os.RemoteException;
import android.os.SystemClock;
import com.obric.assistant.interaction.impl.performance.BinderPerformanceReporter;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.IntStream;
import me.ele.lancet.base.annotations.Skip;
import pqc.k;
import pqc.l;
import pqc.m;
import pqc.n;

/* JADX INFO: loaded from: classes41.dex */
public interface IAIDLMiuiWlanQoECallback extends IInterface {

    public static abstract class Stub extends Binder implements IAIDLMiuiWlanQoECallback {

        public static class a implements IAIDLMiuiWlanQoECallback {

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public static IAIDLMiuiWlanQoECallback f462973b;

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public IBinder f462974a;

            public a(IBinder r100) {
                this.f462974a = r100;
            }

            public static /* synthetic */ void a(Parcel r100, String r101, String r102) {
                r100.writeString(r101);
                r100.writeString(r102);
            }

            public static /* synthetic */ void b(Parcel r100, String r101, String r102) {
                r100.writeString(r101);
                r100.writeString(r102);
            }

            @Override // android.os.IInterface
            public final IBinder asBinder() {
                return this.f462974a;
            }

            @Override // com.xiaomi.NetworkBoost.IAIDLMiuiWlanQoECallback
            public final void wlanQoEReportUpdateMaster(Map<String, String> r100) {
                final Parcel r101 = Parcel.obtain();
                Parcel r102 = Parcel.obtain();
                r101.writeInterfaceToken("com.xiaomi.NetworkBoost.IAIDLMiuiWlanQoECallback");     // Catch: Throwable -> L16
                if (r100 != null) goto L6;
                r101.writeInt(-1);     // Catch: Throwable -> L16
            L8:
                if (INVOKEINTERFACE_com_xiaomi_NetworkBoost_IAIDLMiuiWlanQoECallback$Stub$a_com_obric_assistant_interaction_impl_BinderLancet_transact(this.f462974a, 1, r101, r102, 0) == false) goto L10;
            L14:
                r102.readException();     // Catch: Throwable -> L16
            L12:
                r102.recycle();
                r101.recycle();
                return;
            L10:
                if (Stub.getDefaultImpl() == null) goto L14;
                Stub.getDefaultImpl().wlanQoEReportUpdateMaster(r100);     // Catch: Throwable -> L16
                goto L12
            L6:
                r101.writeInt(r100.size());     // Catch: Throwable -> L16
                r100.forEach(new m(r101));     // Catch: Throwable -> L16
            L16:
                th = move-exception;
                r102.recycle();
                r101.recycle();
                throw th;
            }

            @Override // com.xiaomi.NetworkBoost.IAIDLMiuiWlanQoECallback
            public final void wlanQoEReportUpdateSlave(Map<String, String> r100) {
                final Parcel r101 = Parcel.obtain();
                Parcel r102 = Parcel.obtain();
                r101.writeInterfaceToken("com.xiaomi.NetworkBoost.IAIDLMiuiWlanQoECallback");     // Catch: Throwable -> L16
                if (r100 != null) goto L6;
                r101.writeInt(-1);     // Catch: Throwable -> L16
            L8:
                if (INVOKEINTERFACE_com_xiaomi_NetworkBoost_IAIDLMiuiWlanQoECallback$Stub$a_com_obric_assistant_interaction_impl_BinderLancet_transact(this.f462974a, 2, r101, r102, 0) == false) goto L10;
            L14:
                r102.readException();     // Catch: Throwable -> L16
            L12:
                r102.recycle();
                r101.recycle();
                return;
            L10:
                if (Stub.getDefaultImpl() == null) goto L14;
                Stub.getDefaultImpl().wlanQoEReportUpdateSlave(r100);     // Catch: Throwable -> L16
                goto L12
            L6:
                r101.writeInt(r100.size());     // Catch: Throwable -> L16
                r100.forEach(new n(r101));     // Catch: Throwable -> L16
            L16:
                th = move-exception;
                r102.recycle();
                r101.recycle();
                throw th;
            }

            @Skip({"com.obric.assistant.interaction.impl.performance"})
            public static boolean INVOKEINTERFACE_com_xiaomi_NetworkBoost_IAIDLMiuiWlanQoECallback$Stub$a_com_obric_assistant_interaction_impl_BinderLancet_transact(IBinder r110, int r111, Parcel r112, Parcel r113, int r114) throws RemoteException {
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
            attachInterface(this, "com.xiaomi.NetworkBoost.IAIDLMiuiWlanQoECallback");
        }

        public static /* synthetic */ void a(Parcel r100, Map r101, int r102) {
            r101.put(r100.readString(), r100.readString());
        }

        public static IAIDLMiuiWlanQoECallback asInterface(IBinder r100) {
            if (r100 != null) goto L5;
            return null;
        L5:
            IInterface r101 = r100.queryLocalInterface("com.xiaomi.NetworkBoost.IAIDLMiuiWlanQoECallback");
            if (r101 == null) goto L12;
            if ((r101 instanceof IAIDLMiuiWlanQoECallback) == false) goto L12;
            return (IAIDLMiuiWlanQoECallback) r101;
        L12:
            return new a(r100);
        }

        public static /* synthetic */ void b(Parcel r100, Map r101, int r102) {
            r101.put(r100.readString(), r100.readString());
        }

        public static IAIDLMiuiWlanQoECallback getDefaultImpl() {
            return a.f462973b;
        }

        public static boolean setDefaultImpl(IAIDLMiuiWlanQoECallback r100) {
            if (a.f462973b != null) goto L10;
            if (r100 == null) goto L7;
            a.f462973b = r100;
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
        public boolean onTransact(int r100, final Parcel r101, Parcel r102, int r103) {
            final HashMap r104 = null;
            if (r100 != 1) goto L5;
            r101.enforceInterface("com.xiaomi.NetworkBoost.IAIDLMiuiWlanQoECallback");
            int r105 = r101.readInt();
            if (r105 < 0) goto L23;
            r104 = new HashMap();
        L23:
            IntStream.range(0, r105).forEach(new l(r101, r104));
            wlanQoEReportUpdateMaster(r104);
        L17:
            r102.writeNoException();
            return true;
        L5:
            if (r100 != 2) goto L7;
            r101.enforceInterface("com.xiaomi.NetworkBoost.IAIDLMiuiWlanQoECallback");
            int r106 = r101.readInt();
            if (r106 < 0) goto L16;
            r104 = new HashMap();
        L16:
            IntStream.range(0, r106).forEach(new k(r101, r104));
            wlanQoEReportUpdateSlave(r104);
            goto L17
        L7:
            if (r100 != 1598968902) goto L9;
            r102.writeString("com.xiaomi.NetworkBoost.IAIDLMiuiWlanQoECallback");
            return true;
        L9:
            return super.onTransact(r100, r101, r102, r103);
        }
    }

    void wlanQoEReportUpdateMaster(Map<String, String> r100);

    void wlanQoEReportUpdateSlave(Map<String, String> r100);
}
