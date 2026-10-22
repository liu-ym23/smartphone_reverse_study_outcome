package ms.bd.c;

import android.hardware.display.DisplayManager;
import android.os.Handler;
import android.text.TextUtils;
import android.view.Display;
import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import com.ss.ttm.player.MediaPlayer;

/* JADX INFO: loaded from: classes5.dex */
public final class t3 implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ u3 f515370a;

    public final void a() {
        u3 r100 = this.f515370a;     // Catch: Throwable -> L22
        if (r100.f515381b == null) goto L25;
        ThreadMethodProxy.start(r100.f515380a);     // Catch: Throwable -> L22
        Handler r101 = new Handler(this.f515370a.f515380a.getLooper());     // Catch: Throwable -> L22
        u3 r102 = this.f515370a;     // Catch: Throwable -> L22
        r102.f515383d = (DisplayManager) r102.f515381b.getApplicationContext().getSystemService((String) p2.a(MediaPlayer.MEDIA_INFO_DUMMY_PLAYER_SESSON_STOP, 0, 0, "8ce276", new byte[]{45, 104, 5, 86, 4, 32, 34}));     // Catch: Throwable -> L22
        DisplayManager r103 = this.f515370a.f515383d;     // Catch: Throwable -> L22
        if (r103 == null) goto L26;
        Display[] r104 = r103.getDisplays();     // Catch: Throwable -> L22
        int r105 = r104.length;     // Catch: Throwable -> L22
        if (r105 > 1) goto L9;
    L20:
        u3 r106 = this.f515370a;     // Catch: Throwable -> L22
        DisplayManager r107 = r106.f515383d;     // Catch: Throwable -> L22
        e0 r108 = new e0(r107);     // Catch: Throwable -> L22
        r106.f515384e = r108;     // Catch: Throwable -> L22
        r107.registerDisplayListener(r108, r101);     // Catch: Throwable -> L22
        return;
    L9:
        if (r3.f515339j != null) goto L11;
        r3.f515339j = new r3();     // Catch: Throwable -> L22
    L11:
        r3 r109 = r3.f515339j;     // Catch: Throwable -> L22
        r109.getClass();     // Catch: Throwable -> L22
        String r110 = r3.d(r104);     // Catch: Throwable -> L22
        String r111 = r3.b(r104);     // Catch: Throwable -> L22
        if (r109.f515343d == r105) goto L14;
        r109.f515344e = System.currentTimeMillis() / 1000;     // Catch: Throwable -> L22
    L14:
        r109.f515343d = r105;     // Catch: Throwable -> L22
        r109.f515348i = true;     // Catch: Throwable -> L22
        if (TextUtils.isEmpty(r110) == true) goto L18;
        r109.f515346g = r110;     // Catch: Throwable -> L22
    L18:
        if (TextUtils.isEmpty(r111) == true) goto L20;
        r109.f515347h = r111;     // Catch: Throwable -> L22
        goto L20
    L26:
        return;
    L25:
        return;
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

    public t3(u3 r100) {
        this.f515370a = r100;
    }
}
