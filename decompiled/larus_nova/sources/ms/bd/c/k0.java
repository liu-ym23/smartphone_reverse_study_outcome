package ms.bd.c;

import android.os.Message;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import com.ss.android.ugc.bytex.pthread.base.proxy.PthreadHandlerThreadV2;
import com.ss.ttm.player.MediaPlayer;

/* JADX INFO: loaded from: classes5.dex */
public final class k0 {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static volatile k0 f515177c;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final h0 f515178a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public r0 f515179b;

    static {
        String r100 = (String) p2.a(MediaPlayer.MEDIA_INFO_DUMMY_PLAYER_SESSON_STOP, 0, 0, "a6a261", new byte[]{84, 45, 63, 85, 14, 23, 119, 18, 37, 103});
        f515177c = null;
    }

    public static k0 a() {
        if (f515177c != null) goto L15;
        monitor-enter(k0.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (f515177c != null) goto L9;
        f515177c = new k0();     // Catch: Throwable -> L11
    L9:
        monitor-exit(k0.class);     // Catch: Throwable -> L11
    L15:
        return f515177c;
    }

    public k0() {
        PthreadHandlerThreadV2 r100 = new PthreadHandlerThreadV2((String) p2.a(MediaPlayer.MEDIA_INFO_DUMMY_PLAYER_SESSON_STOP, 0, 0, "6a8263", new byte[]{3, 122, 102, 85, 14, 21, 32, 69, 124, 103}));
        ThreadMethodProxy.start(r100);
        this.f515178a = new h0(this, r100.getLooper());
    }

    public final boolean b(i0 r100, String r101) {
        h0 r102 = this.f515178a;
        if (r102 != null) goto L6;
        return false;
    L6:
        if (r100 != i0.f515160d) goto L8;
        r102.removeMessages(r100.f515162a);
        return true;
    L8:
        Message r103 = new Message();
        r103.what = r100.ordinal();
        r103.obj = r101;
        return this.f515178a.sendMessage(r103);
    }
}
