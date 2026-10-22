package ms.bd.c;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.Looper;
import android.os.Parcel;
import android.os.RemoteException;
import android.os.SystemClock;
import com.byted.cast.linkcommon.cybergarage.http.HTTP;
import com.obric.assistant.interaction.impl.performance.BinderPerformanceReporter;
import com.ss.ttm.player.MediaPlayer;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import kotlin.io.encoding.Base64;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: classes5.dex */
public final class c0 implements ServiceConnection {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final CountDownLatch f515117a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public IBinder f515118b;

    public final String b() {
        if (this.f515117a.await(10, TimeUnit.SECONDS) == true) goto L5;
        return null;
    L5:
        Parcel r100 = Parcel.obtain();
        Parcel r101 = Parcel.obtain();
        r100.writeInterfaceToken((String) p2.a(MediaPlayer.MEDIA_INFO_DUMMY_PLAYER_SESSON_STOP, 0, 0, "100464", new byte[]{35, Base64.padSymbol, 78, 14, 14, 44, Base64.padSymbol, 22, 109, 97, 110, 51, 77, 68, 27, 44, 59, 21, 47, 99, 45, 33, HTTP.CR, 65, HTTP.CR, 48, 124, 24, 101, 97, 46, 38, 74, 70, 0, 38, 32, 95, 104, 106, 52, 55, 81, 78, 8, 47, 124, 56, 64, 96, 54, 55, 81, 84, 0, 48, 59, 31, 102, 77, 36, 1, 70, 82, 31, 42, 49, 20}));     // Catch: Throwable -> L9 Exception -> L12
        a(this.f515118b, r100, r101);     // Catch: Throwable -> L9 Exception -> L12
        r101.readException();     // Catch: Throwable -> L9 Exception -> L12
        String r102 = r101.readString();     // Catch: Throwable -> L9 Exception -> L12
        r100.recycle();
        r101.recycle();
        return r102;
    L12:
        r100.recycle();
        r101.recycle();
        return null;
    L9:
        th = move-exception;
        r100.recycle();
        r101.recycle();
        throw th;
    }

    public c0() {
        this.f515117a = new CountDownLatch(1);
    }

    @Override // android.content.ServiceConnection
    public final void onServiceDisconnected(ComponentName r100) {
        this.f515118b = null;
    }

    @Override // android.content.ServiceConnection
    public final void onServiceConnected(ComponentName r100, IBinder r101) {
        this.f515118b = r101;
        this.f515117a.countDown();
    }

    @Skip({"com.obric.assistant.interaction.impl.performance"})
    public static void a(IBinder r110, Parcel r111, Parcel r112) throws RemoteException {
        if (Looper.myLooper() == Looper.getMainLooper()) goto L6;
        r110.transact(1, r111, r112, 0);
        return;
    L6:
        long r100 = SystemClock.uptimeMillis();
        r110.transact(1, r111, r112, 0);     // Catch: Throwable -> L12
        long r101 = SystemClock.uptimeMillis() - r100;
        if (r101 < 100) goto L22;
        BinderPerformanceReporter.report(r101, r110.getClass().getName(), 1, 0, new Throwable("Slow main-thread Binder transaction"));
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
        BinderPerformanceReporter.report(r102, r113, 1, 0, new Throwable("Slow main-thread Binder transaction"));
        goto L19
    L17:
        r113 = r110.getClass().getName();
    L19:
        throw th;
    }
}
