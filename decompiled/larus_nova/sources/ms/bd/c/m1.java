package ms.bd.c;

import android.os.Build;
import android.view.WindowManager;
import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.ttm.player.MediaPlayer;
import kotlin.io.encoding.Base64;

/* JADX INFO: loaded from: classes6.dex */
public final class m1 implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ n1 f515216a;

    public final void a() {
        r1 r100 = this.f515216a.f515240b.f515280a;
        if (r100.f515331a == true) goto L5;
    L17:
        String r101 = (String) p2.a(MediaPlayer.MEDIA_INFO_DUMMY_PLAYER_SESSON_STOP, 0, 0, "ead419", new byte[]{80, 108, 2, 121, 7, 32, 74, 73, 35, 97});
        String r102 = (String) p2.a(MediaPlayer.MEDIA_INFO_DUMMY_PLAYER_SESSON_STOP, 0, 0, "22aa4b", new byte[]{125, 110, 76, 85, 56, 97, 48, 1, 36, 52, 39, 124, 82, 2, 2, 121, Base64.padSymbol, 83, 50, 52, 99, 35, 6, 26, 27, 101, 52, 23, 112, 48, 37, 36, 23, 7, 75, 48, 53, 0});
        int r103 = this.f515216a.f515240b.f515281b.f515398b;
        return;
    L5:
        if (r100.f515334d != null) goto L8;
        r100.f515334d = new q1(r100, r100.f515332b);
    L8:
        if (r100.f515335e == true) goto L17;
        if (Build.VERSION.SDK_INT < 26) goto L13;
        int r104 = 2038;
    L14:
        WindowManager.LayoutParams r105 = new WindowManager.LayoutParams(1, 1, r104, 262152, -3);
        r105.gravity = 8388661;
        r100.f515333c.addView(r100.f515334d, r105);     // Catch: Exception -> L19
    L16:
        r100.f515335e = true;
        goto L17
    L13:
        r104 = 2002;
        goto L14
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

    public m1(n1 r100) {
        this.f515216a = r100;
    }
}
