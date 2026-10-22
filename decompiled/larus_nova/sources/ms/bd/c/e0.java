package ms.bd.c;

import android.hardware.display.DisplayManager;
import android.text.TextUtils;
import android.view.Display;
import com.ss.ttm.player.MediaPlayer;

/* JADX INFO: loaded from: classes5.dex */
public final class e0 implements DisplayManager.DisplayListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final DisplayManager f515134a;

    @Override // android.hardware.display.DisplayManager.DisplayListener
    public final void onDisplayChanged(int r100) {
    }

    public e0(DisplayManager r100) {
        this.f515134a = r100;
    }

    @Override // android.hardware.display.DisplayManager.DisplayListener
    public final void onDisplayAdded(int r110) {
        Display[] r111 = this.f515134a.getDisplays();     // Catch: Exception -> L18
        int r100 = r111.length;     // Catch: Exception -> L18
        if (r100 > 0) goto L5;
        return;
    L5:
        if (r3.f515339j != null) goto L7;
        r3.f515339j = new r3();     // Catch: Exception -> L18
    L7:
        r3 r101 = r3.f515339j;     // Catch: Exception -> L18
        r101.getClass();     // Catch: Exception -> L18
        String r102 = r3.d(r111);     // Catch: Exception -> L18
        String r112 = r3.b(r111);     // Catch: Exception -> L18
        if (r101.f515343d == r100) goto L10;
        r101.f515344e = System.currentTimeMillis() / 1000;     // Catch: Exception -> L18
    L10:
        r101.f515343d = r100;     // Catch: Exception -> L18
        if (TextUtils.isEmpty(r102) == true) goto L14;
        r101.f515346g = r102;     // Catch: Exception -> L18
    L14:
        if (TextUtils.isEmpty(r112) == true) goto L16;
        r101.f515347h = r112;     // Catch: Exception -> L18
    L16:
        r101.f515340a = System.currentTimeMillis() / 1000;     // Catch: Exception -> L18
        r101.f515345f = (String) p2.a(MediaPlayer.MEDIA_INFO_DUMMY_PLAYER_SESSON_STOP, 0, 0, "73890a", new byte[]{39, 53, 79});     // Catch: Exception -> L18
        return;
    }

    @Override // android.hardware.display.DisplayManager.DisplayListener
    public final void onDisplayRemoved(int r110) {
        Display[] r111 = this.f515134a.getDisplays();     // Catch: Exception -> L18
        int r100 = r111.length;     // Catch: Exception -> L18
        if (r100 > 0) goto L5;
        return;
    L5:
        if (r3.f515339j != null) goto L7;
        r3.f515339j = new r3();     // Catch: Exception -> L18
    L7:
        r3 r101 = r3.f515339j;     // Catch: Exception -> L18
        r101.getClass();     // Catch: Exception -> L18
        String r102 = r3.d(r111);     // Catch: Exception -> L18
        String r112 = r3.b(r111);     // Catch: Exception -> L18
        if (r101.f515343d == r100) goto L10;
        r101.f515344e = System.currentTimeMillis() / 1000;     // Catch: Exception -> L18
    L10:
        r101.f515343d = r100;     // Catch: Exception -> L18
        if (TextUtils.isEmpty(r102) == true) goto L14;
        r101.f515346g = r102;     // Catch: Exception -> L18
    L14:
        if (TextUtils.isEmpty(r112) == true) goto L16;
        r101.f515347h = r112;     // Catch: Exception -> L18
    L16:
        r101.f515341b = System.currentTimeMillis() / 1000;     // Catch: Exception -> L18
        r101.f515345f = (String) p2.a(MediaPlayer.MEDIA_INFO_DUMMY_PLAYER_SESSON_STOP, 0, 0, "c7f849", new byte[]{96, 48, 24, 67, 29, 43});     // Catch: Exception -> L18
        return;
    }
}
