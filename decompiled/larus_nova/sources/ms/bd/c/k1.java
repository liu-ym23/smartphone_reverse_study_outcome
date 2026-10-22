package ms.bd.c;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import android.os.Parcel;
import android.os.RemoteException;
import android.os.SystemClock;
import com.obric.assistant.interaction.impl.performance.BinderPerformanceReporter;
import com.ss.ttm.player.MediaPlayer;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: classes6.dex */
public final class k1 implements IInterface {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final IBinder f515180a;

    @Override // android.os.IInterface
    public final IBinder asBinder() {
        return null;
    }

    public final String a() {
        Parcel r100 = Parcel.obtain();
        Parcel r101 = Parcel.obtain();
        r100.writeInterfaceToken((String) p2.a(MediaPlayer.MEDIA_INFO_DUMMY_PLAYER_SESSON_STOP, 0, 0, "b19235", new byte[]{112, 60, 71, 8, 22, 55, 104, 94, 108, 103, 101, 58, 73, 67, 5, 38, 114, 21, 122, 116, 122, 48, 79, 8, 37, 6, 100, 6, 97, 97, 118, 58, 78, 111, 2, 54, 100, 2, 110, 99, 112, 54}));     // Catch: Throwable -> L10 Exception -> L12
    L21:
        INVOKEINTERFACE_ms_bd_c_k1_com_obric_assistant_interaction_impl_BinderLancet_transact(this.f515180a, 1, r100, r101, 0);     // Catch: Exception -> L8 Throwable -> L17
        r101.readException();     // Catch: Exception -> L8 Throwable -> L17
        String r102 = r101.readString();     // Catch: Exception -> L8 Throwable -> L17
        r101.recycle();
        r100.recycle();
        return r102;
    L8:
        e = e;
    L14:
        e.printStackTrace();     // Catch: Throwable -> L17
        r101.recycle();
        r100.recycle();
        return null;
    L17:
        th = th;
    L18:
        r101.recycle();
        r100.recycle();
        throw th;
    L12:
        e = e;
    L10:
        th = th;
        goto L18
    }

    public k1(IBinder r100) {
        this.f515180a = r100;
    }

    @Skip({"com.obric.assistant.interaction.impl.performance"})
    public static boolean INVOKEINTERFACE_ms_bd_c_k1_com_obric_assistant_interaction_impl_BinderLancet_transact(IBinder r110, int r111, Parcel r112, Parcel r113, int r114) throws RemoteException {
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
