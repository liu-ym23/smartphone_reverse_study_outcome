package ms.bd.c;

import android.opengl.EGL14;
import android.opengl.GLES20;
import android.os.Build;
import com.ss.ttm.player.MediaPlayer;

/* JADX INFO: loaded from: classes5.dex */
public abstract class w0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static volatile String f515412a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final String f515413b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final String f515414c = null;

    static {
        f515413b = (String) p2.a(MediaPlayer.MEDIA_INFO_DUMMY_PLAYER_SESSON_STOP, 0, 0, "b306cc", new byte[]{50, 36, 77, 81, 73, 100, 113, 29, 115, 114, 118, 53, 2});
        f515414c = (String) p2.a(MediaPlayer.MEDIA_INFO_DUMMY_PLAYER_SESSON_STOP, 0, 0, "8bcf51", new byte[]{104, 101, 2, 0, 75});
    }

    public static String a() {
        if (f515412a == null) goto L7;
        return f515412a;
    L7:
        monitor-enter(w0.class);
    L38:
        th = move-exception;
        throw th;
    L9:
        if (f515412a == null) goto L14;
        String r100 = f515412a;     // Catch: Throwable -> L38
        monitor-exit(w0.class);     // Catch: Throwable -> L38
        return r100;
    L14:
        if (Build.VERSION.SDK_INT >= 23) goto L18;
        f515412a = f515413b;     // Catch: Throwable -> L38
        String r101 = f515412a;     // Catch: Throwable -> L38
        monitor-exit(w0.class);     // Catch: Throwable -> L38
        return r101;
    L18:
        v0 r102 = null;
        v0 r103 = new v0();     // Catch: Throwable -> L26 Exception -> L41
        r103.c(EGL14.EGL_NO_SURFACE);     // Catch: Throwable -> L23 Exception -> L25
        f515412a = GLES20.glGetString(7936) + ((String) p2.a(MediaPlayer.MEDIA_INFO_DUMMY_PLAYER_SESSON_STOP, 0, 0, "fd58ac", new byte[]{107})) + GLES20.glGetString(7937) + ((String) p2.a(MediaPlayer.MEDIA_INFO_DUMMY_PLAYER_SESSON_STOP, 0, 0, "e3ea61", new byte[]{104})) + GLES20.glGetString(7938);     // Catch: Throwable -> L23 Exception -> L25
        r103.b();     // Catch: Throwable -> L38
    L31:
        monitor-exit(w0.class);     // Catch: Throwable -> L38
        return f515412a;
    L25:
        r102 = r103;
    L23:
        th = th;
    L35:
        if (r103 == null) goto L37;
        r103.b();     // Catch: Throwable -> L38
    L37:
        throw th;     // Catch: Throwable -> L38
    L26:
        th = th;
        r103 = r102;
    L28:
        f515412a = f515414c;     // Catch: Throwable -> L26
        if (r102 == null) goto L31;
        r102.b();     // Catch: Throwable -> L38
        goto L31
    }
}
