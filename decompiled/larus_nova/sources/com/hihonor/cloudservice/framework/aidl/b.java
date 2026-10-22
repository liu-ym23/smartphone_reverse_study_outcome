package com.hihonor.cloudservice.framework.aidl;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import android.os.Parcel;
import android.os.RemoteException;
import android.os.SystemClock;
import com.obric.assistant.interaction.impl.performance.BinderPerformanceReporter;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: classes23.dex */
public interface b extends IInterface {

    public static abstract class a extends Binder implements b {

        /* JADX INFO: renamed from: com.hihonor.cloudservice.framework.aidl.b$a$a, reason: collision with other inner class name */
        public static class C3869a implements b {

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public static b f276493b;

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            private IBinder f276494a;

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.f276494a;
            }

            public C3869a(IBinder r100) {
                this.f276494a = r100;
            }

            @Override // com.hihonor.cloudservice.framework.aidl.b
            public void a(DataBuffer r100, com.hihonor.cloudservice.framework.aidl.a r101) {
                Parcel r102 = Parcel.obtain();
                Parcel r103 = Parcel.obtain();
                r102.writeInterfaceToken("com.hihonor.cloudservice.framework.aidl.IServiceInvoke");     // Catch: Throwable -> L20
                if (r100 == null) goto L6;
                r102.writeInt(1);     // Catch: Throwable -> L20
                r100.writeToParcel(r102, 0);     // Catch: Throwable -> L20
            L7:
                if (r101 == null) goto L9;
                IBinder r104 = r101.asBinder();     // Catch: Throwable -> L20
            L10:
                r102.writeStrongBinder(r104);     // Catch: Throwable -> L20
                if (INVOKEINTERFACE_com_hihonor_cloudservice_framework_aidl_b$a$a_com_obric_assistant_interaction_impl_BinderLancet_transact(this.f276494a, 1, r102, r103, 0) == false) goto L13;
            L17:
                r103.readException();     // Catch: Throwable -> L20
                r103.recycle();
                r102.recycle();
                return;
            L13:
                if (a.a() == null) goto L17;
                a.a().a(r100, r101);     // Catch: Throwable -> L20
                r103.recycle();
                r102.recycle();
                return;
            L9:
                r104 = null;
                goto L10
            L6:
                r102.writeInt(0);     // Catch: Throwable -> L20
            L20:
                th = move-exception;
                r103.recycle();
                r102.recycle();
                throw th;
            }

            @Skip({"com.obric.assistant.interaction.impl.performance"})
            public static boolean INVOKEINTERFACE_com_hihonor_cloudservice_framework_aidl_b$a$a_com_obric_assistant_interaction_impl_BinderLancet_transact(IBinder r110, int r111, Parcel r112, Parcel r113, int r114) throws RemoteException {
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

        public static b a() {
            return C3869a.f276493b;
        }

        public static b a(IBinder r100) {
            if (r100 != null) goto L5;
            return null;
        L5:
            IInterface r101 = r100.queryLocalInterface("com.hihonor.cloudservice.framework.aidl.IServiceInvoke");
            if (r101 == null) goto L12;
            if ((r101 instanceof b) == false) goto L12;
            return (b) r101;
        L12:
            return new C3869a(r100);
        }
    }

    void a(DataBuffer r100, com.hihonor.cloudservice.framework.aidl.a r101);
}
