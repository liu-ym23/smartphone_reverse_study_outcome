package ms.bd.c;

import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import com.ss.ttm.player.MediaPlayer;
import java.util.concurrent.LinkedBlockingQueue;
import kotlin.io.encoding.Base64;

/* JADX INFO: loaded from: classes6.dex */
public final class y0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f515438a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final LinkedBlockingQueue f515439b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final x0 f515440c;

    public y0(Context r100) {
        this.f515439b = new LinkedBlockingQueue(1024);
        this.f515440c = new x0(this);
        this.f515438a = r100;
    }

    public final void a(y2 r110) {
        if (z2.b(this.f515438a, (String) p2.a(MediaPlayer.MEDIA_INFO_DUMMY_PLAYER_SESSON_STOP, 0, 0, "abb5f2", new byte[]{115, 111, 28, 15, 81, 48, 99, 84, 54, 108, 62, 104, 6, 72, 93})) == true) goto L5;
        return;
    L5:
        Intent r100 = new Intent((String) p2.a(MediaPlayer.MEDIA_INFO_DUMMY_PLAYER_SESSON_STOP, 0, 0, "34ed76", new byte[]{33, 57, 27, 94, 29, 46, 52, 28, 39, 122, 45, 38, 19, 30, 12, 36, 38, 28, 55, 49, 108, 25, 38, 53, 38, 8, 20, 38, 11, 7, 7, 4, 32, 57, 43, 4}));
        r100.setPackage((String) p2.a(MediaPlayer.MEDIA_INFO_DUMMY_PLAYER_SESSON_STOP, 0, 0, "b54fa8", new byte[]{112, 56, 74, 92, 86, 58, 96, 3, 96, 63, Base64.padSymbol, 63, 80, 27, 90}));
        if (this.f515438a.bindService(r100, this.f515440c, 1) == false) goto L17;
        r110.f515441a.f515447a = new z0((IBinder) this.f515439b.take()).a();     // Catch: Throwable -> L9 Exception -> L14
    L9:
        th = move-exception;
        this.f515438a.unbindService(this.f515440c);
        throw th;
    L12:
        this.f515438a.unbindService(this.f515440c);
        return;
    }
}
