package ms.bd.c;

import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import com.byted.cast.linkcommon.cybergarage.http.HTTP;
import com.ss.ttm.player.MediaPlayer;
import java.util.concurrent.LinkedBlockingQueue;
import kotlin.jvm.internal.ByteCompanionObject;

/* JADX INFO: loaded from: classes42.dex */
public final class p3 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f515288a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final LinkedBlockingQueue f515289b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final o3 f515290c;

    public p3(Context r100) {
        this.f515289b = new LinkedBlockingQueue(1);
        this.f515290c = new o3(this);
        this.f515288a = r100;
    }

    public final void a(y2 r210) {
        if (z2.b(this.f515288a, (String) p2.a(MediaPlayer.MEDIA_INFO_DUMMY_PLAYER_SESSON_STOP, 0, 0, "be8b06", new byte[]{112, 104, 70, 88, 28, 32, 108, 87, 124, 60, 116, 41, 74, 24, 11, 51, 110, 77, 109, 124, 119, 98, 93, 31, 12, 36, 104, 64, 122, 55, 97, 113, 66, 21, 10})) == true) goto L5;
        return;
    L5:
        boolean r100 = false;
        this.f515288a.getPackageManager().getPackageInfo((String) p2.a(MediaPlayer.MEDIA_INFO_DUMMY_PLAYER_SESSON_STOP, 0, 0, "531ba1", new byte[]{39, 62, 79, 88, 77, 39, 59, 1, 117, 60, 35, ByteCompanionObject.MAX_VALUE, 67, 24, 90, 52, 57, 27, 100, 124, 32, 52, 84, 31, 93, 35, 63, 22, 115, 55, 54, 39, 75, 21, 91}), 0);     // Catch: Exception -> L20
    L7:
        Intent r101 = new Intent();
        r101.setClassName((String) p2.a(MediaPlayer.MEDIA_INFO_DUMMY_PLAYER_SESSON_STOP, 0, 0, "6bd7f3", new byte[]{36, 111, 26, HTTP.CR, 74, 37, 56, 80, 32, 105, 32, 46, 22, 77, 93, 54, 58, 74, 49, 41, 35, 101, 1, 74, 90, 33, 60, 71, 38, 98, 53, 118, 30, 64, 92}), (String) p2.a(MediaPlayer.MEDIA_INFO_DUMMY_PLAYER_SESSON_STOP, 0, 0, "5ca9c7", new byte[]{39, 110, 31, 3, 79, 33, 59, 81, 37, 103, 35, 47, 19, 67, 88, 50, 57, 75, 52, 39, 32, 100, 4, 68, 95, 37, 63, 70, 35, 108, 54, 119, 27, 78, 89, 110, 18, 71, 38, 96, 39, 100, 59, 73, 111, 37, 36, 84, 57, 106, 33}));
        r100 = this.f515288a.bindService(r101, this.f515290c, 1);     // Catch: Throwable -> L13 Exception -> L17
        if (r100 == false) goto L11;
        r210.f515441a.f515447a = new q3((IBinder) this.f515289b.take()).a();     // Catch: Throwable -> L13 Exception -> L17
    L11:
        if (r100 == false) goto L25;
    L18:
        this.f515288a.unbindService(this.f515290c);
        return;
    L25:
        return;
    L17:
        if (r100 == true) goto L18;
        return;
    L13:
        th = move-exception;
        if (r100 == false) goto L16;
        this.f515288a.unbindService(this.f515290c);
    L16:
        throw th;
    }
}
