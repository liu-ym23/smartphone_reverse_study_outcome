package ms.bd.c;

import android.content.Context;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import com.ss.android.ugc.bytex.pthread.base.proxy.PthreadThreadV2;
import com.ss.ttm.player.MediaPlayer;
import kotlin.jvm.internal.ByteCompanionObject;

/* JADX INFO: loaded from: classes5.dex */
public final class z2 {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static volatile z2 f515446d;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f515447a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f515448b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public String f515449c;

    public z2(Context r100) {
        this.f515447a = null;
        this.f515448b = null;
        this.f515449c = null;
        ThreadMethodProxy.start(new PthreadThreadV2(new b0(new d0(new y2(this)), r100), "ms/bd/c/z2"));     // Catch: Throwable -> L5
        return;
    L5:
        String r101 = (String) p2.a(MediaPlayer.MEDIA_INFO_DUMMY_PLAYER_SESSON_STOP, 0, 0, "ac18ae", new byte[]{ByteCompanionObject.MAX_VALUE, 116, 65});
    }

    public static z2 a(Context r100) {
        if (f515446d != null) goto L15;
        monitor-enter(z2.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (f515446d != null) goto L9;
        f515446d = new z2(r100);     // Catch: Throwable -> L11
    L9:
        monitor-exit(z2.class);     // Catch: Throwable -> L11
    L15:
        return f515446d;
    }

    public static boolean b(Context r100, String r101) {
        if (r100.getPackageManager().getPackageInfo(r101, 128) == null) goto L10;
        return true;
    L10:
        return false;
    L11:
        return false;
    }
}
