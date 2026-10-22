package ms.bd.c;

import android.app.Activity;
import android.os.Build;
import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.ttm.player.MediaPlayer;
import java.lang.reflect.Field;

/* JADX INFO: loaded from: classes6.dex */
public final class i implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Activity f515157a;

    public final void a() {
        Activity r100 = this.f515157a;
        int r101 = n.f515223a;
        if (Build.VERSION.SDK_INT >= 22) goto L11;
    L8:
        n.c(1);
        return;
    L11:
        Field r102 = n.a((String) p2.a(MediaPlayer.MEDIA_INFO_DUMMY_PLAYER_SESSON_STOP, 0, 0, "ffca17", new byte[]{118, 106, 20, 7, 1, 41, 97, 9, 51, 33, 103, 42, 49, 22, 26, 41, 115, 78, 38, 40})).getDeclaredField((String) p2.a(MediaPlayer.MEDIA_INFO_DUMMY_PLAYER_SESSON_STOP, 0, 0, "d50414", new byte[]{120, 5, 70, 70, 11, 49, 117, 17, 115}));     // Catch: Throwable -> L10
        r102.setAccessible(true);     // Catch: Throwable -> L10
        String r103 = r102.get(r100).toString();     // Catch: Throwable -> L10
        String r104 = r100.getComponentName().getClassName();     // Catch: Throwable -> L10
        if (r104.contains(r103) == true) goto L8;
        p2.a(16777222, 0, 0, r104 + ((String) p2.a(MediaPlayer.MEDIA_INFO_DUMMY_PLAYER_SESSON_STOP, 0, 0, "a71127", new byte[]{43})) + r103, null);     // Catch: Throwable -> L10
        goto L8
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

    public i(Activity r100) {
        this.f515157a = r100;
    }
}
