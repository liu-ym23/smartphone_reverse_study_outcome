package ms.bd.c;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import com.byted.cast.linkcommon.cybergarage.http.HTTP;
import com.ss.ttm.player.MediaPlayer;
import java.util.concurrent.LinkedBlockingQueue;
import kotlin.io.encoding.Base64;

/* JADX INFO: loaded from: classes42.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f515104a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final LinkedBlockingQueue f515105b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final a f515106c;

    public b(Context r100) {
        this.f515105b = new LinkedBlockingQueue(1);
        this.f515106c = new a(this);
        this.f515104a = r100;
    }

    public final void a(y2 r110) {
        if (z2.b(this.f515104a, (String) p2.a(MediaPlayer.MEDIA_INFO_DUMMY_PLAYER_SESSON_STOP, 0, 0, "50f1b7", new byte[]{39, Base64.padSymbol, 24, 11, 92, 51, 35, 2, 121, 108, 55, 51, 91, 118, 72, 48, 38, 29, 50, 108, 33, 60, 1, 68, 79, 57, 18, 56, 19})) == true) goto L5;
        return;
    L5:
        Intent r100 = new Intent();
        r100.setAction((String) p2.a(MediaPlayer.MEDIA_INFO_DUMMY_PLAYER_SESSON_STOP, 0, 0, "d94fdc", new byte[]{118, 52, 74, 92, 90, 103, 114, 11, 43, 59, 102, 58, 9, 19, 88, 96, 110, 23, 107, 120, 84, 24, 100, 55, 104, 71, 88, 60, 76, 18}));
        r100.setComponent(new ComponentName((String) p2.a(MediaPlayer.MEDIA_INFO_DUMMY_PLAYER_SESSON_STOP, 0, 0, "18d7cd", new byte[]{35, 53, 26, HTTP.CR, 93, 96, 39, 10, 123, 106, 51, 59, 89, 112, 73, 99, 34, 21, 48, 106, 37, 52, 3, 66, 78, 106, 22, 48, 17}), (String) p2.a(MediaPlayer.MEDIA_INFO_DUMMY_PLAYER_SESSON_STOP, 0, 0, "d147fd", new byte[]{118, 60, 74, HTTP.CR, 88, 96, 114, 3, 43, 106, 102, 50, 9, 112, 76, 99, 119, 28, 96, 106, 112, Base64.padSymbol, 83, 66, 75, 106, 67, 57, 65, 41, 70, 38, 87, 83, 85, 118, 106, 21, 107, 115, 116, 33, 94, 103, 112, 87, 84, 21, 119, 113, 124, 48, 66})));
        if (this.f515104a.bindService(r100, this.f515106c, 1) == false) goto L17;
        r110.f515441a.f515447a = new c((IBinder) this.f515105b.take()).a();     // Catch: Throwable -> L9 Exception -> L14
    L9:
        th = move-exception;
        this.f515104a.unbindService(this.f515106c);
        throw th;
    L12:
        this.f515104a.unbindService(this.f515106c);
        return;
    }
}
