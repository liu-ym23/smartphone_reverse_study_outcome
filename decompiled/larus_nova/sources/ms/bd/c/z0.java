package ms.bd.c;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import android.os.Parcel;
import android.os.RemoteException;
import android.os.SystemClock;
import com.obric.assistant.interaction.impl.performance.BinderPerformanceReporter;
import com.ss.ttm.player.MediaPlayer;
import kotlin.io.encoding.Base64;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: classes6.dex */
public final class z0 implements IInterface {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final IBinder f515445a;

    public final String a() {
        Parcel r100 = Parcel.obtain();
        Parcel r101 = Parcel.obtain();
        r100.writeInterfaceToken((String) p2.a(MediaPlayer.MEDIA_INFO_DUMMY_PLAYER_SESSON_STOP, 0, 0, "7b5de8", new byte[]{37, 111, 75, 94, 79, 32, 48, 74, 119, 122, 41, 112, 67, 30, 94, 42, 34, 74, 103, 49, 104, 97, 79, 20, 86, 97, 27, 83, 97, 58, 2, 101, 80, 25, 89, 42, 29, 71, 97, 58, 50, 105, 64, 25, 95, Base64.padSymbol, 7, 70, 118, 34, 47, 99, 67}));     // Catch: Throwable -> L9
        INVOKEINTERFACE_ms_bd_c_z0_com_obric_assistant_interaction_impl_BinderLancet_transact(this.f515445a, 1, r100, r101, 0);     // Catch: Throwable -> L7
        r101.readException();     // Catch: Throwable -> L7
        String r102 = r101.readString();     // Catch: Throwable -> L7
    L12:
        r100.recycle();
        r101.recycle();
        return r102;
    L7:
        th = th;
    L11:
        r100.recycle();
        r101.recycle();
        th.printStackTrace();
        r102 = null;
    L9:
        th = th;
        goto L11
    }

    @Override // android.os.IInterface
    public final IBinder asBinder() {
        return this.f515445a;
    }

    public z0(IBinder r100) {
        this.f515445a = r100;
    }

    @Skip({"com.obric.assistant.interaction.impl.performance"})
    public static boolean INVOKEINTERFACE_ms_bd_c_z0_com_obric_assistant_interaction_impl_BinderLancet_transact(IBinder r110, int r111, Parcel r112, Parcel r113, int r114) throws RemoteException {
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
