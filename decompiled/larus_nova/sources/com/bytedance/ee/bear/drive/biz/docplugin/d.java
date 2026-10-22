package com.bytedance.ee.bear.drive.biz.docplugin;

import android.os.Binder;
import android.os.Looper;
import android.os.Parcel;
import android.os.RemoteException;
import android.os.SystemClock;
import com.alipay.sdk.m.u.i;
import com.bytedance.ee.bear.contract.drive.sdk.entity.open.BaseOpenEntity;
import com.obric.assistant.interaction.impl.performance.BinderPerformanceReporter;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: classes16.dex */
public abstract class d extends Binder {

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f222863a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public BaseOpenEntity f222864b;

        public final String toString() {
            return "Result {code=" + this.f222863a + i.f25855d;
        }

        public a() {
        }

        public a(BaseOpenEntity r100) {
            this.f222863a = 100;
            this.f222864b = r100;
        }

        public a(int r100) {
            this.f222863a = 100;
        }
    }

    public abstract void b(a r100);

    public d() {
    }

    public final void c(a r100) {
        tt5.a.k("drive_in_doc_attachment_ICallback", "ICallbackProxy.sendResult: result " + r100.toString());
        if (isBinderAlive() == false) goto L13;
        Parcel r101 = Parcel.obtain();
        Parcel r102 = Parcel.obtain();
        r101.writeInterfaceToken("android.os.IBinder");
        r101.writeInt(r100.f222863a);
        r101.writeParcelable(r100.f222864b, 0);
        tt5.a.k("drive_in_doc_attachment_ICallback", "ICallbackProxy.sendResult: send success ");     // Catch: RemoteException -> L7
        a(this, r101, r102);     // Catch: RemoteException -> L7
    L9:
        r102.readException();
        r101.recycle();
        r102.recycle();
        return;
    L7:
        e = move-exception;
        e.printStackTrace();
        tt5.a.e("drive_in_doc_attachment_ICallback", "sendResult: ", e, false);
        goto L9
    }

    @Skip({"com.obric.assistant.interaction.impl.performance"})
    public static void a(d r110, Parcel r111, Parcel r112) throws RemoteException {
        if (Looper.myLooper() == Looper.getMainLooper()) goto L6;
        r110.transact(2, r111, r112, 0);
        return;
    L6:
        long r100 = SystemClock.uptimeMillis();
        r110.transact(2, r111, r112, 0);     // Catch: Throwable -> L12
        long r101 = SystemClock.uptimeMillis() - r100;
        if (r101 < 100) goto L22;
        BinderPerformanceReporter.report(r101, r110.getClass().getName(), 2, 0, new Throwable("Slow main-thread Binder transaction"));
        return;
    L22:
        return;
    L12:
        th = move-exception;
        long r102 = SystemClock.uptimeMillis() - r100;
        if (r102 < 100) goto L19;
        if (r110 != null) goto L17;
        String r113 = "";
    L18:
        BinderPerformanceReporter.report(r102, r113, 2, 0, new Throwable("Slow main-thread Binder transaction"));
        goto L19
    L17:
        r113 = r110.getClass().getName();
    L19:
        throw th;
    }

    @Override // android.os.Binder
    public final boolean onTransact(int r100, Parcel r101, Parcel r102, int r103) throws RemoteException {
        if (r100 != 2) goto L10;
        r101.enforceInterface("android.os.IBinder");     // Catch: Exception -> L7
        a r104 = new a();     // Catch: Exception -> L7
        r104.f222863a = r101.readInt();     // Catch: Exception -> L7
        r104.f222864b = (BaseOpenEntity) r101.readParcelable(BaseOpenEntity.class.getClassLoader());     // Catch: Exception -> L7
        b(r104);     // Catch: Exception -> L7
        r102.writeNoException();     // Catch: Exception -> L7
        return true;
    L7:
        e = move-exception;
        tt5.a.l("drive_in_doc_attachment_ICallback", "Callback ERROR!", e);
    L10:
        return super.onTransact(r100, r101, r102, r103);
    }
}
