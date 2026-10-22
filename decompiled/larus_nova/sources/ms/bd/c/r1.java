package ms.bd.c;

import android.content.Context;
import android.os.Build;
import android.os.SystemClock;
import android.provider.Settings;
import android.view.WindowManager;
import com.ss.ttm.player.MediaPlayer;
import java.util.Iterator;
import java.util.concurrent.LinkedBlockingDeque;
import kotlin.io.encoding.Base64;
import kotlin.jvm.internal.ByteCompanionObject;

/* JADX INFO: loaded from: classes6.dex */
public final class r1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f515331a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Context f515332b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final WindowManager f515333c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public q1 f515334d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f515335e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final LinkedBlockingDeque f515336f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final u1 f515337g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final Object f515338h;

    static {
        String r100 = (String) p2.a(MediaPlayer.MEDIA_INFO_DUMMY_PLAYER_SESSON_STOP, 0, 0, "98756b", new byte[]{12, 53, 81, 120, 0, 123, 22, 16, 112, 96});
        String r101 = (String) p2.a(MediaPlayer.MEDIA_INFO_DUMMY_PLAYER_SESSON_STOP, 0, 0, "2ef3ba", new byte[]{47, 110, 3, 66, 98, 98, 52, 87});
    }

    public final String b() {
        if (this.f515331a == true) goto L7;
        u1 r100 = this.f515337g;
        r100.f515372b = -1;
        return r100.toString();
    L7:
        if (this.f515336f.isEmpty() == true) goto L31;
        Object r101 = this.f515338h;
        monitor-enter(r101);
        int r102 = 0;
        String r103 = (String) p2.a(MediaPlayer.MEDIA_INFO_DUMMY_PLAYER_SESSON_STOP, 0, 0, "f516bb", new byte[]{50, 51, 2, 80, 88, 120, 100, 29, 110, 99, 115, 119, 86, 77, 29, 119, 96, 84, 114, 99, 103, 56, 80, 86, 88, 113, 43});     // Catch: Throwable -> L28
        this.f515336f.size();     // Catch: Throwable -> L28
        LinkedBlockingDeque r104 = this.f515336f;     // Catch: Throwable -> L28
        int r105 = b4.f515115a;     // Catch: Throwable -> L28
        if (r104 != null) goto L14;
    L24:
        String r106 = "";
    L25:
        this.f515336f.clear();     // Catch: Throwable -> L28
        monitor-exit(r101);     // Catch: Throwable -> L28
        return r106;
    L14:
        if (r104.isEmpty() == true) goto L24;
        StringBuilder r107 = new StringBuilder();     // Catch: Throwable -> L28
        Iterator r108 = r104.iterator();     // Catch: Throwable -> L28
    L18:
        if (r108.hasNext() == false) goto L23;
        r107.append(r108.next().toString());     // Catch: Throwable -> L28
        if (r102 >= (r104.size() - 1)) goto L22;
        r107.append('|');     // Catch: Throwable -> L28
    L22:
        r102 = r102 + 1;     // Catch: Throwable -> L28
        goto L18
    L23:
        r106 = r107.toString();     // Catch: Throwable -> L28
    L28:
        th = move-exception;
        throw th;
    L31:
        return "";
    }

    public final void c() {
        if (this.f515331a == false) goto L15;
        this.f515337g.f515376f = SystemClock.uptimeMillis();
        this.f515337g.f515371a++;
        String r100 = (String) p2.a(MediaPlayer.MEDIA_INFO_DUMMY_PLAYER_SESSON_STOP, 0, 0, "5d47e8", new byte[]{121, 59, 26, 30, 7, 114, 107, 24, 56, 58, 100, 35, 84, 3, 7, 114, 107, 24, 56, 58, 121, 59, 26, 30, 26});
        u1 r101 = this.f515337g.a();
        Object r102 = this.f515338h;
        monitor-enter(r102);
    L12:
        th = move-exception;
        throw th;
    L7:
        if (this.f515336f.size() <= 50) goto L9;
        this.f515336f.pop();     // Catch: Throwable -> L12
    L9:
        this.f515336f.add(r101);     // Catch: Throwable -> L12
        monitor-exit(r102);     // Catch: Throwable -> L12
        u1 r103 = this.f515337g;
        r103.f515372b = 0;
        r103.f515373c = 0;
        return;
    }

    public r1(Context r100) {
        this.f515335e = false;
        this.f515337g = new u1();
        this.f515336f = new LinkedBlockingDeque();
        this.f515338h = new Object();
        if (Build.VERSION.SDK_INT < 23) goto L5;
        boolean r101 = Settings.canDrawOverlays(r100);
    L6:
        this.f515331a = r101;
        if (r101 == true) goto L10;
        String r102 = (String) p2.a(MediaPlayer.MEDIA_INFO_DUMMY_PLAYER_SESSON_STOP, 0, 0, "99850b", new byte[]{12, 52, 94, 120, 6, 123, 22, 17, ByteCompanionObject.MAX_VALUE, 96});
        String r103 = (String) p2.a(MediaPlayer.MEDIA_INFO_DUMMY_PLAYER_SESSON_STOP, 0, 0, "f20c14", new byte[]{88, 38, 70, 5, 2, 34, 124, 83, 113, 54, 101, Base64.padSymbol, 74, 4, 29, 42, 106, 29, 33, 58, 100, 112, 77, 24, 26, 99, 98, 1, 96, Base64.padSymbol, 99, 53, 71, 89});
        return;
    L10:
        this.f515332b = r100;
        this.f515333c = (WindowManager) r100.getSystemService((String) p2.a(MediaPlayer.MEDIA_INFO_DUMMY_PLAYER_SESSON_STOP, 0, 0, "7f9e42", new byte[]{49, 109, 68, 21, 4, 50}));
        return;
    L5:
        r101 = true;
        goto L6
    }

    public final void a(boolean r100) {
        if (this.f515331a == false) goto L16;
        q1 r101 = this.f515334d;
        if (r101 != null) goto L7;
    L10:
        if (r100 == false) goto L17;
        this.f515334d = null;
        u1 r102 = this.f515337g;
        r102.f515372b = 0;
        r102.f515373c = 0;
        r102.f515371a = 0;
        return;
    L17:
        return;
    L7:
        if (this.f515335e == false) goto L10;
        this.f515333c.removeView(r101);     // Catch: Exception -> L13
    L9:
        this.f515335e = false;
        goto L10
    }
}
