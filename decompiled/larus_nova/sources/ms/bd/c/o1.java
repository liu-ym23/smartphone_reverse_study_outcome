package ms.bd.c;

import com.byted.cast.linkcommon.cybergarage.http.HTTP;
import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.ttm.player.MediaPlayer;
import kotlin.io.encoding.Base64;

/* JADX INFO: loaded from: classes6.dex */
public final class o1 implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ p1 f515272a;

    public final void a() {
        this.f515272a.f515287h.await();     // Catch: InterruptedException -> L5
    L3:
        this.f515272a.f515286g.quitSafely();
        String r100 = (String) p2.a(MediaPlayer.MEDIA_INFO_DUMMY_PLAYER_SESSON_STOP, 0, 0, "4305aa", new byte[]{1, 62, 86, 120, 87, 120, 27, 27, 119, 96});
        String r101 = (String) p2.a(MediaPlayer.MEDIA_INFO_DUMMY_PLAYER_SESSON_STOP, 0, 0, "f729a5", new byte[]{67, Base64.padSymbol, 68, HTTP.CR, 73, 45, 119, 26, 103, 41, 96, 52, 82, HTTP.CR, 80, 45, 114, 86, 114, 124, 126, 48, 85, 3});
    }

    @Override // java.lang.Runnable
    public final void run() {
        a();     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }

    public o1(p1 r100) {
        this.f515272a = r100;
    }
}
