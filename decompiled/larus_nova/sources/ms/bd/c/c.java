package ms.bd.c;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import android.os.Parcel;
import android.os.RemoteException;
import android.os.SystemClock;
import com.obric.assistant.interaction.impl.performance.BinderPerformanceReporter;
import com.ss.ttm.player.MediaPlayer;
import kotlin.jvm.internal.ByteCompanionObject;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: classes6.dex */
public final class c implements IInterface {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final IBinder f515116a;

    public final String a() {
        Parcel r100 = Parcel.obtain();
        Parcel r101 = Parcel.obtain();
        r100.writeInterfaceToken((String) p2.a(MediaPlayer.MEDIA_INFO_DUMMY_PLAYER_SESSON_STOP, 0, 0, "79bfa5", new byte[]{37, 52, 28, 92, 95, 49, 33, 11, 125, 59, 53, 58, 95, 33, 75, 50, 36, 20, 54, 59, 35, 53, 5, 19, 76, 59, 16, 49, 23, 120, 15, 31, 24, 22, ByteCompanionObject.MAX_VALUE, 43, 48, 20, 26, 56, 50, 62, 3, 20, 95, 33, 49}));     // Catch: Throwable -> L7
        INVOKEINTERFACE_ms_bd_c_c_com_obric_assistant_interaction_impl_BinderLancet_transact(this.f515116a, 3, r100, r101, 0);     // Catch: Throwable -> L11
        r101.readException();     // Catch: Throwable -> L11
        String r102 = r101.readString();     // Catch: Throwable -> L11
    L9:
        r100.recycle();
        r101.recycle();
        return r102;
    L8:
        r100.recycle();
        r101.recycle();
        r102 = null;
        goto L9
    }

    @Override // android.os.IInterface
    public final IBinder asBinder() {
        return this.f515116a;
    }

    public c(IBinder r100) {
        this.f515116a = r100;
    }

    @Skip({"com.obric.assistant.interaction.impl.performance"})
    public static boolean INVOKEINTERFACE_ms_bd_c_c_com_obric_assistant_interaction_impl_BinderLancet_transact(IBinder r110, int r111, Parcel r112, Parcel r113, int r114) throws RemoteException {
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
