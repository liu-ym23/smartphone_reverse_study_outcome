package ms.bd.c;

import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.ttm.player.MediaPlayer;
import kotlin.jvm.internal.ByteCompanionObject;

/* JADX INFO: loaded from: classes6.dex */
public final class l1 implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ n1 f515203a;

    public final void a() {
        this.f515203a.f515240b.f515280a.a(false);
        String r100 = (String) p2.a(MediaPlayer.MEDIA_INFO_DUMMY_PLAYER_SESSON_STOP, 0, 0, "f989d6", new byte[]{83, 52, 94, 116, 82, 47, 73, 17, ByteCompanionObject.MAX_VALUE, 108});
        String r101 = (String) p2.a(MediaPlayer.MEDIA_INFO_DUMMY_PLAYER_SESSON_STOP, 0, 0, "c01490", new byte[]{46, 110, 30, 0, 53, 51, 111, 1, 112, 97, 118, 126, 2, 87, 15, 43, 108, 81, 98, 97, 50, 32, 71, 83, 18, 38, 114, 5, 101, 96, 50, 51, 68, 84, 3, 53, 32, 84, 100, 119});
        int r102 = this.f515203a.f515240b.f515281b.f515400d;
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

    public l1(n1 r100) {
        this.f515203a = r100;
    }
}
