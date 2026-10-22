package ms.bd.c;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import android.os.Parcel;
import android.os.RemoteException;
import android.os.SystemClock;
import com.byted.cast.linkcommon.cybergarage.http.HTTP;
import com.obric.assistant.interaction.impl.performance.BinderPerformanceReporter;
import com.ss.ttm.player.MediaPlayer;
import kotlin.jvm.internal.ByteCompanionObject;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: classes42.dex */
public final class q3 implements IInterface {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final IBinder f515301a;

    public final String a() {
        Parcel r100 = Parcel.obtain();
        Parcel r101 = Parcel.obtain();
        r100.writeInterfaceToken((String) p2.a(MediaPlayer.MEDIA_INFO_DUMMY_PLAYER_SESSON_STOP, 0, 0, "f3357e", new byte[]{116, 62, 77, 15, 27, 115, 104, 1, 119, 107, 112, ByteCompanionObject.MAX_VALUE, 65, 79, 12, 96, 106, 27, 102, 43, 115, 52, 86, 72, 11, 119, 108, 22, 113, 96, 101, 39, 73, 66, HTTP.CR, 60, 76, 54, 103, 115, 126, 50, 69, 104, 12, 65, 96, 0, 116, 108, 116, 52}));     // Catch: Throwable -> L9
        INVOKEINTERFACE_ms_bd_c_q3_com_obric_assistant_interaction_impl_BinderLancet_transact(this.f515301a, 1, r100, r101, 0);     // Catch: Throwable -> L7
        r101.readException();     // Catch: Throwable -> L7
        String r102 = r101.readString();     // Catch: Throwable -> L7
    L12:
        r101.recycle();
        r100.recycle();
        return r102;
    L7:
        th = th;
    L11:
        r101.recycle();
        r100.recycle();
        th.printStackTrace();
        r102 = null;
    L9:
        th = th;
        goto L11
    }

    @Override // android.os.IInterface
    public final IBinder asBinder() {
        return this.f515301a;
    }

    public q3(IBinder r100) {
        this.f515301a = r100;
    }

    @Skip({"com.obric.assistant.interaction.impl.performance"})
    public static boolean INVOKEINTERFACE_ms_bd_c_q3_com_obric_assistant_interaction_impl_BinderLancet_transact(IBinder r110, int r111, Parcel r112, Parcel r113, int r114) throws RemoteException {
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
