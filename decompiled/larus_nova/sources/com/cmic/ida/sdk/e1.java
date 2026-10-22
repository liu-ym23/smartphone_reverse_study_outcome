package com.cmic.ida.sdk;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import android.os.Parcel;
import android.os.RemoteException;
import android.os.SystemClock;
import com.obric.assistant.interaction.impl.performance.BinderPerformanceReporter;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: classes22.dex */
public interface e1 extends IInterface {

    public static abstract class a extends Binder implements e1 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int f273107a = 0;

        /* JADX INFO: renamed from: com.cmic.ida.sdk.e1$a$a, reason: collision with other inner class name */
        public static class C3817a implements e1 {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public IBinder f273108a;

            public C3817a(IBinder r100) {
                this.f273108a = r100;
            }

            @Override // com.cmic.ida.sdk.e1
            public void a(d1 r100) {
                Parcel r101 = Parcel.obtain();
                Parcel r102 = Parcel.obtain();
                r101.writeInterfaceToken("com.hihonor.cloudservice.oaid.IOAIDService");     // Catch: Throwable -> L13
                if (r100 == null) goto L6;
                d1.a r103 = (d1.a) r100;     // Catch: Throwable -> L13
            L7:
                r101.writeStrongBinder(r103);     // Catch: Throwable -> L13
                if (INVOKEINTERFACE_com_cmic_ida_sdk_e1$a$a_com_obric_assistant_interaction_impl_BinderLancet_transact(this.f273108a, 3, r101, r102, 0) == true) goto L10;
                int r104 = a.f273107a;     // Catch: Throwable -> L13
            L10:
                r102.readException();     // Catch: Throwable -> L13
                r102.recycle();
                r101.recycle();
                return;
            L6:
                r103 = null;
            L13:
                th = move-exception;
                r102.recycle();
                r101.recycle();
                throw th;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.f273108a;
            }

            @Override // com.cmic.ida.sdk.e1
            public void b(d1 r100) {
                Parcel r101 = Parcel.obtain();
                Parcel r102 = Parcel.obtain();
                r101.writeInterfaceToken("com.hihonor.cloudservice.oaid.IOAIDService");     // Catch: Throwable -> L13
                if (r100 == null) goto L6;
                d1.a r103 = (d1.a) r100;     // Catch: Throwable -> L13
            L7:
                r101.writeStrongBinder(r103);     // Catch: Throwable -> L13
                if (INVOKEINTERFACE_com_cmic_ida_sdk_e1$a$a_com_obric_assistant_interaction_impl_BinderLancet_transact(this.f273108a, 2, r101, r102, 0) == true) goto L10;
                int r104 = a.f273107a;     // Catch: Throwable -> L13
            L10:
                r102.readException();     // Catch: Throwable -> L13
                r102.recycle();
                r101.recycle();
                return;
            L6:
                r103 = null;
            L13:
                th = move-exception;
                r102.recycle();
                r101.recycle();
                throw th;
            }

            @Skip({"com.obric.assistant.interaction.impl.performance"})
            public static boolean INVOKEINTERFACE_com_cmic_ida_sdk_e1$a$a_com_obric_assistant_interaction_impl_BinderLancet_transact(IBinder r110, int r111, Parcel r112, Parcel r113, int r114) throws RemoteException {
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
    }

    void a(d1 r100);

    void b(d1 r100);
}
