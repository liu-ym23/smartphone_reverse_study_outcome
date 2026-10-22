package ms.bd.c;

import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import android.os.Parcel;
import android.os.RemoteException;
import android.os.SystemClock;
import com.obric.assistant.interaction.impl.performance.BinderPerformanceReporter;
import com.ss.ttm.player.MediaPlayer;
import java.util.concurrent.LinkedBlockingQueue;
import kotlin.jvm.internal.ByteCompanionObject;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: classes6.dex */
public final class d1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f515127a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Context f515128b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final LinkedBlockingQueue f515129c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final b1 f515130d;

    public d1(Context r100) {
        this.f515127a = (String) p2.a(MediaPlayer.MEDIA_INFO_DUMMY_PLAYER_SESSON_STOP, 0, 0, "4a3723", new byte[]{42, 98, ByteCompanionObject.MAX_VALUE, 74, 9, 27, 49, 76, 99, 96});
        this.f515129c = new LinkedBlockingQueue(1);
        this.f515130d = new b1(this);
        this.f515128b = r100;
    }

    public final void b(y2 r210) {
        if (z2.b(this.f515128b, (String) p2.a(MediaPlayer.MEDIA_INFO_DUMMY_PLAYER_SESSON_STOP, 0, 0, "4d227d", new byte[]{38, 105, 76, 8, 0, 122, 63, 74, 109, 109, 55, 40, 72, 66})) == true) goto L5;
        return;
    L5:
        Intent r100 = new Intent();
        r100.setAction((String) p2.a(MediaPlayer.MEDIA_INFO_DUMMY_PLAYER_SESSON_STOP, 0, 0, "2cee9b", new byte[]{32, 110, 27, 95, 14, 124, 57, 77, 58, 58, 49, 47, 31, 21, 72, 93, 63, 109, 53, 28, 39, 82, 19, 3, 16, 124, 50, 71}));
        r100.setPackage((String) p2.a(MediaPlayer.MEDIA_INFO_DUMMY_PLAYER_SESSON_STOP, 0, 0, "d4a8c6", new byte[]{118, 57, 31, 2, 84, 40, 111, 26, 62, 103, 103, 120, 27, 72}));
        if (this.f515128b.bindService(r100, this.f515130d, 1) == false) goto L32;
        IBinder r101 = (IBinder) this.f515129c.take();     // Catch: Throwable -> L24 Exception -> L27
        if (r101 != null) goto L10;
        String r102 = f1.f515139a;     // Catch: Throwable -> L24 Exception -> L27
        g1 r103 = null;
    L16:
        c1 r104 = new c1(this, r210);     // Catch: Throwable -> L24 Exception -> L27
        e1 r105 = (e1) r103;     // Catch: Throwable -> L24 Exception -> L27
        r105.getClass();     // Catch: Throwable -> L24 Exception -> L27
        Parcel r106 = Parcel.obtain();     // Catch: Throwable -> L24 Exception -> L27
        Parcel r107 = Parcel.obtain();     // Catch: Throwable -> L24 Exception -> L27
        r106.writeInterfaceToken((String) p2.a(MediaPlayer.MEDIA_INFO_DUMMY_PLAYER_SESSON_STOP, 0, 0, "d8925d", new byte[]{118, 53, 71, 8, 2, 122, 111, 22, 102, 109, 103, 116, 73, 74, 5, 102, 99, 10, 109, 112, 99, 51, 73, 67, 68, 124, 102, 16, 108, 44, 92, 21, 107, 111, 46, 64, 98, 11, 126, 107, 118, 63}));     // Catch: Throwable -> L21
        r106.writeStrongBinder(r104);     // Catch: Throwable -> L21
        a(r105.f515135a, r106, r107);     // Catch: Throwable -> L21
        r107.readException();     // Catch: Throwable -> L21
        r107.recycle();     // Catch: Throwable -> L24 Exception -> L27
        r106.recycle();     // Catch: Throwable -> L24 Exception -> L27
        this.f515128b.unbindService(this.f515130d);
        return;
    L21:
        th = move-exception;
        r107.recycle();     // Catch: Throwable -> L24 Exception -> L27
        r106.recycle();     // Catch: Throwable -> L24 Exception -> L27
        throw th;     // Catch: Throwable -> L24 Exception -> L27
    L10:
        IInterface r108 = r101.queryLocalInterface(f1.f515139a);     // Catch: Throwable -> L24 Exception -> L27
        if (r108 != null) goto L13;
    L15:
        r103 = new e1(r101);     // Catch: Throwable -> L24 Exception -> L27
        goto L16
    L13:
        if ((r108 instanceof g1) == false) goto L15;
        r103 = (g1) r108;     // Catch: Throwable -> L24 Exception -> L27
    L27:
        this.f515128b.unbindService(this.f515130d);
        return;
    L24:
        th = move-exception;
        this.f515128b.unbindService(this.f515130d);
        throw th;
    }

    @Skip({"com.obric.assistant.interaction.impl.performance"})
    public static void a(IBinder r110, Parcel r111, Parcel r112) throws RemoteException {
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
}
