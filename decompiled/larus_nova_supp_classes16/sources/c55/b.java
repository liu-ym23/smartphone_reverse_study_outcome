package c55;

import android.os.Binder;
import android.os.Looper;
import android.os.Parcel;
import android.os.RemoteException;
import android.os.SystemClock;
import com.obric.assistant.interaction.impl.performance.BinderPerformanceReporter;
import kotlin.jvm.internal.Intrinsics;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public abstract class b extends Binder {

    public static final class a {
    }

    /* JADX INFO: renamed from: c55.b$b, reason: collision with other inner class name */
    public static final class C0012b {
        public static final /* synthetic */ int b = 0;
        public boolean a;

        /* JADX INFO: renamed from: c55.b$b$a */
        public static final class a {
        }

        static {
        }

        public C0012b() {
        }

        public final String toString() {
            return "Result {handled=" + this.a + '}';
        }
    }

    static {
    }

    public abstract void b(C0012b r1);

    public b() {
    }

    public final void c(boolean r6) {
        tt5.a.k("drive_in_doc_attachment_ITouchEventCallback", "ITouchEventCallbackProxy.sendTouchEventHandled: handled= " + r6);
        if (isBinderAlive() == false) goto L13;
        Parcel r0 = Parcel.obtain();
        Parcel r2 = Parcel.obtain();
        r0.writeInterfaceToken("android.os.IBinder");
        int r3 = C0012b.b;
        r0.writeInt(r6 ? 1 : 0);
        tt5.a.k("drive_in_doc_attachment_ITouchEventCallback", "ITouchEventCallbackProxy.sendTouchEventHandled: send success ");     // Catch: RemoteException -> L7
        a(this, r0, r2);     // Catch: RemoteException -> L7
    L9:
        r2.readException();
        r0.recycle();
        r2.recycle();
        return;
    L7:
        e = move-exception;
        tt5.a.d("drive_in_doc_attachment_ITouchEventCallback", "sendTouchEventHandled: send fail: " + e);
        goto L9
    }

    @Skip({"com.obric.assistant.interaction.impl.performance"})
    public static void a(b r13, Parcel r14, Parcel r16) throws RemoteException {
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
    public final boolean onTransact(int r4, Parcel r5, Parcel r6, int r7) {
        Intrinsics.checkNotNullParameter(r5, "data");
        if (r4 != 2) goto L13;
        r5.enforceInterface("android.os.IBinder");     // Catch: Exception -> L10
        C0012b r0 = new C0012b();     // Catch: Exception -> L10
        int r1 = C0012b.b;     // Catch: Exception -> L10
        if (r5.readInt() != 1) goto L7;
        boolean r2 = true;
    L8:
        r0.a = r2;     // Catch: Exception -> L10
        b(r0);     // Catch: Exception -> L10
        Intrinsics.checkNotNull(r6);     // Catch: Exception -> L10
        r6.writeNoException();     // Catch: Exception -> L10
        return true;
    L7:
        r2 = false;
    L10:
        e = move-exception;
        tt5.a.k("drive_in_doc_attachment_ITouchEventCallback", "Callback ERROR! " + e);
    L13:
        return super.onTransact(r4, r5, r6, r7);
    }
}
