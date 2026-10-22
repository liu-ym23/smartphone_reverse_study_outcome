package ms.bd.c;

import android.content.Context;
import android.os.Build;
import android.view.WindowManager;
import com.ss.ttm.player.MediaPlayer;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes5.dex */
public final class v3 {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static volatile v3 f515406d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final JSONObject f515407e = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f515408a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f515409b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public s3 f515410c;

    public final synchronized void b() {
        monitor-enter(this);
    L16:
        th = move-exception;
        throw th;
    L4:
        if (this.f515409b == false) goto L8;
        monitor-exit(this);
        return;
    L8:
        this.f515409b = true;     // Catch: Throwable -> L16
        if (Build.VERSION.SDK_INT >= 35) goto L13;
        monitor-exit(this);
        return;
    L13:
        c();     // Catch: Throwable -> L16
        monitor-exit(this);
    }

    public final synchronized void c() {
        monitor-enter(this);
        if (this.f515409b == false) goto L10;
        Context r100 = this.f515408a;     // Catch: Throwable -> L12
        if (r100 == null) goto L10;
        if (Build.VERSION.SDK_INT < 35) goto L10;
        this.f515410c = new s3();     // Catch: Throwable -> L12
        ((WindowManager) r100.getSystemService((String) p2.a(MediaPlayer.MEDIA_INFO_DUMMY_PLAYER_SESSON_STOP, 0, 0, "d87c2f", new byte[]{98, 51, 74, 19, 2, 102}))).addScreenRecordingCallback(this.f515408a.getMainExecutor(), this.f515410c);     // Catch: Throwable -> L12
    L10:
        monitor-exit(this);
    }

    public final void finalize() {
        monitor-enter(this);
    L14:
        th = move-exception;
        throw th;
    L4:
        if (this.f515409b == true) goto L6;
    L11:
        monitor-exit(this);
        super.finalize();
        return;
    L6:
        if (Build.VERSION.SDK_INT < 35) goto L11;
        if (this.f515410c == null) goto L10;
        ((WindowManager) this.f515408a.getSystemService((String) p2.a(MediaPlayer.MEDIA_INFO_DUMMY_PLAYER_SESSON_STOP, 0, 0, "d54e11", new byte[]{98, 62, 73, 21, 1, 49}))).removeScreenRecordingCallback(this.f515410c);     // Catch: Throwable -> L14
    L10:
        this.f515409b = false;     // Catch: Throwable -> L14
        goto L11
    }

    static {
        f515407e = new JSONObject();
    }

    public v3(Context r100) {
        this.f515409b = false;
        this.f515408a = r100.getApplicationContext();
    }

    public static v3 a(Context r100) {
        if (f515406d != null) goto L15;
        monitor-enter(v3.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (f515406d != null) goto L9;
        f515406d = new v3(r100);     // Catch: Throwable -> L11
    L9:
        monitor-exit(v3.class);     // Catch: Throwable -> L11
    L15:
        return f515406d;
    }
}
