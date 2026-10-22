package ms.bd.c;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.Signature;
import android.os.IBinder;
import android.os.Looper;
import android.os.Parcel;
import android.os.RemoteException;
import android.os.SystemClock;
import com.byted.cast.linkcommon.cybergarage.http.HTTP;
import com.obric.assistant.interaction.impl.performance.BinderPerformanceReporter;
import com.ss.ttm.player.MediaPlayer;
import java.security.MessageDigest;
import java.util.concurrent.CountDownLatch;
import kotlin.UByte;
import kotlin.jvm.internal.ByteCompanionObject;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: classes42.dex */
public final class b3 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f515110a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f515111b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public c3 f515112c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final CountDownLatch f515113d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final a3 f515114e;

    public b3(Context r100) {
        String r101 = (String) p2.a(MediaPlayer.MEDIA_INFO_DUMMY_PLAYER_SESSON_STOP, 0, 0, "d02d73", new byte[]{90, 7, 104, 52});
        this.f515114e = new a3(this);
        this.f515110a = r100;
        this.f515113d = new CountDownLatch(1);
    }

    public final void c(y2 r110) {
        if (z2.b(this.f515110a, (String) p2.a(MediaPlayer.MEDIA_INFO_DUMMY_PLAYER_SESSON_STOP, 0, 0, "d5c718", new byte[]{118, 56, 29, HTTP.CR, 6, 42, 126, 0, 51, 119, 59, 56, 0, 70, 0, 38, 99})) == true) goto L6;
        return;
    L6:
        if (Looper.myLooper() == Looper.getMainLooper()) goto L26;
        Intent r100 = new Intent();
        r100.setComponent(new ComponentName((String) p2.a(MediaPlayer.MEDIA_INFO_DUMMY_PLAYER_SESSON_STOP, 0, 0, "c74c66", new byte[]{113, 58, 74, 89, 1, 36, 121, 2, 100, 35, 60, 58, 87, 18, 7, 40, 100}), (String) p2.a(MediaPlayer.MEDIA_INFO_DUMMY_PLAYER_SESSON_STOP, 0, 0, "e681fa", new byte[]{119, 59, 70, 11, 81, 115, ByteCompanionObject.MAX_VALUE, 3, 104, 113, 58, 59, 91, 64, 87, ByteCompanionObject.MAX_VALUE, 98, 89, 64, 101, 113, 58, 95, 76, 95, 111, 85, 18, 123, 119, 125, 55, 78})));
        r100.setAction((String) p2.a(MediaPlayer.MEDIA_INFO_DUMMY_PLAYER_SESSON_STOP, 0, 0, "d6b2a2", new byte[]{116, 55, 5, 79, 81, 43, 41, 20, 60, 111, 59, 60, 20, 95, 74, 36, 119, 89, 60, 114, 112, 58, 24, 66, 16, 10, 87, 50, 29, 93, 92, 16, 46, 117, 123, 23, 81, 62, 16, 71}));
        if (this.f515110a.bindService(r100, this.f515114e, 1) == false) goto L33;
        this.f515113d.await();     // Catch: Throwable -> L14
        c3 r101 = this.f515112c;     // Catch: Throwable -> L14
        if (r101 == null) goto L19;
        r110.f515441a.f515447a = b(r101, (String) p2.a(MediaPlayer.MEDIA_INFO_DUMMY_PLAYER_SESSON_STOP, 0, 0, "136bcf", new byte[]{15, 4, 108, 50}));     // Catch: Throwable -> L14
    L19:
        this.f515110a.unbindService(this.f515114e);
        return;
    L14:
        boolean r111 = true;
    L31:
        String r102 = (String) p2.a(MediaPlayer.MEDIA_INFO_DUMMY_PLAYER_SESSON_STOP, 0, 0, "e1e8c2", new byte[]{123, 35});     // Catch: Throwable -> L21
        if (r111 == true) goto L19;
        return;
    L21:
        th = move-exception;
        if (r111 == false) goto L24;
        this.f515110a.unbindService(this.f515114e);
    L24:
        throw th;
    L33:
        return;
    L15:
        r111 = false;
        goto L31
    L26:
        throw new IllegalStateException((String) p2.a(MediaPlayer.MEDIA_INFO_DUMMY_PLAYER_SESSON_STOP, 0, 0, "bc60d7", new byte[]{80, 96, 75, 74, 84, 52, 33, 80, 114, 110, 51, 110, 75, 4, 118, 33, 104, 76, 83, 104, 97, 100, 68, 64}));
    }

    public final String b(c3 r110, String r210) {
        String r100 = this.f515110a.getPackageName();
        if (this.f515111b == null) goto L39;
    L21:
        String r101 = this.f515111b;
        Parcel r102 = Parcel.obtain();
        Parcel r111 = Parcel.obtain();
        r102.writeInterfaceToken((String) p2.a(MediaPlayer.MEDIA_INFO_DUMMY_PLAYER_SESSON_STOP, 0, 0, "f62a41", new byte[]{116, 59, 76, 91, 3, 35, 124, 3, 98, 33, 57, 59, 81, 16, 5, 47, 97, 89, 74, 30, 103, 49, 79, 60, 47}));     // Catch: Throwable -> L24 Exception -> L26
        r102.writeString(r100);     // Catch: Throwable -> L24 Exception -> L26
        r102.writeString(r101);     // Catch: Throwable -> L24 Exception -> L26
        r102.writeString(r210);     // Catch: Throwable -> L24 Exception -> L26
        a(r110.f515123a, r102, r111);     // Catch: Throwable -> L24 Exception -> L26
        r111.readException();     // Catch: Throwable -> L24 Exception -> L26
        String r103 = r111.readString();     // Catch: Throwable -> L24 Exception -> L26
    L29:
        r102.recycle();
        r111.recycle();
        return r103;
    L24:
        th = move-exception;
        r102.recycle();
        r111.recycle();
        throw th;
    L27:
        String r104 = (String) p2.a(MediaPlayer.MEDIA_INFO_DUMMY_PLAYER_SESSON_STOP, 0, 0, "d24dd6", new byte[]{122, 32, 78});     // Catch: Throwable -> L24
        r103 = null;
        goto L29
    L39:
        Signature[] r112 = this.f515110a.getPackageManager().getPackageInfo(r100, 64).signatures;     // Catch: Exception -> L7
    L8:
        if (r112 != null) goto L10;
    L19:
        String r105 = null;
    L20:
        this.f515111b = r105;
        goto L21
    L10:
        if (r112.length <= 0) goto L19;
        byte[] r113 = r112[0].toByteArray();
        MessageDigest r106 = MessageDigest.getInstance((String) p2.a(MediaPlayer.MEDIA_INFO_DUMMY_PLAYER_SESSON_STOP, 0, 0, "766e6a", new byte[]{21, 28, 100, 64}));     // Catch: Exception -> L33
        if (r106 == null) goto L19;
        byte[] r107 = r106.digest(r113);     // Catch: Exception -> L33
        StringBuilder r108 = new StringBuilder();     // Catch: Exception -> L33
        int r114 = r107.length;     // Catch: Exception -> L33
        int r115 = 0;
    L15:
        if (r115 >= r114) goto L17;
        r108.append(Integer.toHexString((r107[r115] & UByte.MAX_VALUE) | 256).substring(1, 3));     // Catch: Exception -> L33
        r115 = r115 + 1;     // Catch: Exception -> L33
        goto L15
    L17:
        r105 = r108.toString();     // Catch: Exception -> L33
    L7:
        r112 = null;
        goto L8
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
