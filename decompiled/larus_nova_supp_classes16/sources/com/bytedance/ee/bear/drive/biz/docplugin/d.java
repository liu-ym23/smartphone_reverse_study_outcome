package com.bytedance.ee.bear.drive.biz.docplugin;

import android.os.Binder;
import android.os.Looper;
import android.os.Parcel;
import android.os.RemoteException;
import android.os.SystemClock;
import com.bytedance.ee.bear.contract.drive.sdk.entity.open.BaseOpenEntity;
import com.obric.assistant.interaction.impl.performance.BinderPerformanceReporter;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public abstract class d extends Binder {

    public static final class a {
        public int a;
        public BaseOpenEntity b;

        public final String toString() {
            return "Result {code=" + this.a + "}";
        }

        public a() {
        }

        public a(BaseOpenEntity r2) {
            this.a = 100;
            this.b = r2;
        }

        public a(int r1) {
            this.a = 100;
        }
    }

    public abstract void b(a r1);

    public d() {
    }

    public final void c(a r6) {
        tt5.a.k("drive_in_doc_attachment_ICallback", "ICallbackProxy.sendResult: result " + r6.toString());
        if (isBinderAlive() == false) goto L13;
        Parcel r0 = Parcel.obtain();
        Parcel r2 = Parcel.obtain();
        r0.writeInterfaceToken("android.os.IBinder");
        r0.writeInt(r6.a);
        r0.writeParcelable(r6.b, 0);
        tt5.a.k("drive_in_doc_attachment_ICallback", "ICallbackProxy.sendResult: send success ");     // Catch: RemoteException -> L7
        a(this, r0, r2);     // Catch: RemoteException -> L7
    L9:
        r2.readException();
        r0.recycle();
        r2.recycle();
        return;
    L7:
        e = move-exception;
        e.printStackTrace();
        tt5.a.e("drive_in_doc_attachment_ICallback", "sendResult: ", e, false);
        goto L9
    }

    @Skip({"com.obric.assistant.interaction.impl.performance"})
    public static void a(d r13, Parcel r14, Parcel r16) throws RemoteException {
        if (Looper.myLooper() == Looper.getMainLooper()) goto L6;
        r13.transact(2, r14, r16, 0);
        return;
    L6:
        long r1 = SystemClock.uptimeMillis();
        r13.transact(2, r14, r16, 0);     // Catch: Throwable -> L12
        long r7 = SystemClock.uptimeMillis() - r1;
        if (r7 < 100) goto L22;
        BinderPerformanceReporter.report(r7, r13.getClass().getName(), 2, 0, new Throwable("Slow main-thread Binder transaction"));
        return;
    L22:
        return;
    L12:
        th = move-exception;
        long r8 = SystemClock.uptimeMillis() - r1;
        if (r8 < 100) goto L19;
        if (r13 != null) goto L17;
        String r17 = "";
    L18:
        BinderPerformanceReporter.report(r8, r17, 2, 0, new Throwable("Slow main-thread Binder transaction"));
        goto L19
    L17:
        r17 = r13.getClass().getName();
    L19:
        throw th;
    }

    @Override // android.os.Binder
    public final boolean onTransact(int r4, Parcel r5, Parcel r6, int r7) throws RemoteException {
        if (r4 != 2) goto L10;
        r5.enforceInterface("android.os.IBinder");     // Catch: Exception -> L7
        a r0 = new a();     // Catch: Exception -> L7
        r0.a = r5.readInt();     // Catch: Exception -> L7
        r0.b = (BaseOpenEntity) r5.readParcelable(BaseOpenEntity.class.getClassLoader());     // Catch: Exception -> L7
        b(r0);     // Catch: Exception -> L7
        r6.writeNoException();     // Catch: Exception -> L7
        return true;
    L7:
        e = move-exception;
        tt5.a.l("drive_in_doc_attachment_ICallback", "Callback ERROR!", e);
    L10:
        return super.onTransact(r4, r5, r6, r7);
    }
}
