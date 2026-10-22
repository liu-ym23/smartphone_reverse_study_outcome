package ms.bd.c;

import com.ss.ttm.player.MediaPlayer;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.IOException;
import kotlin.io.encoding.Base64;

/* JADX INFO: loaded from: classes6.dex */
public abstract class t0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final String f515365a = null;

    static {
        String r100 = (String) p2.a(MediaPlayer.MEDIA_INFO_DUMMY_PLAYER_SESSON_STOP, 0, 0, "2ad15a", new byte[]{24, 63, 86, 27, 55});
        f515365a = (String) p2.a(MediaPlayer.MEDIA_INFO_DUMMY_PLAYER_SESSON_STOP, 0, 0, "05e7d2", new byte[]{44, 50, 24, 71});
    }

    public static String a(BufferedInputStream r100) {
        byte[] r101 = new byte[4096];
        StringBuilder r102 = new StringBuilder();
    L11:
        int r103 = r100.read(r101);     // Catch: Exception -> L8
        if (r103 <= 0) goto L6;
        r102.append(new String(r101, 0, r103));     // Catch: Exception -> L8
    L6:
        if (r103 >= 4096) goto L11;
    L10:
        return r102.toString();
    L8:
        String r104 = (String) p2.a(MediaPlayer.MEDIA_INFO_DUMMY_PLAYER_SESSON_STOP, 0, 0, "b64299", new byte[]{118, Base64.padSymbol, 68});
        goto L10
    }

    public static String b(String r110) {
        BufferedOutputStream r100 = null;
        BufferedInputStream r101 = null;
        r100 = null;
        String r102 = null;
        r102 = null;
        Process r103 = c(Runtime.getRuntime(), (String) p2.a(MediaPlayer.MEDIA_INFO_DUMMY_PLAYER_SESSON_STOP, 0, 0, "dae412", new byte[]{102, 107}));     // Catch: Throwable -> L21 Exception -> L23
    L75:
        BufferedOutputStream r104 = new BufferedOutputStream(r103.getOutputStream());     // Catch: Throwable -> L19 Exception -> L54
        BufferedInputStream r105 = new BufferedInputStream(r103.getInputStream());     // Catch: Throwable -> L16 Exception -> L18
        r104.write(r110.getBytes());     // Catch: Throwable -> L14 Exception -> L53
        r104.write(10);     // Catch: Throwable -> L14 Exception -> L53
        r104.flush();     // Catch: Throwable -> L14 Exception -> L53
        r104.close();     // Catch: Throwable -> L14 Exception -> L53
        r103.waitFor();     // Catch: Throwable -> L14 Exception -> L53
        String r111 = a(r105);     // Catch: Throwable -> L14 Exception -> L53
        r104.close();     // Catch: IOException -> L9
    L61:
        r105.close();     // Catch: IOException -> L12
    L13:
        r102 = r111;
    L36:
        r103.destroy();
    L37:
        return r102;
    L12:
        String r106 = (String) p2.a(MediaPlayer.MEDIA_INFO_DUMMY_PLAYER_SESSON_STOP, 0, 0, "f56691", new byte[]{114, 62, 70, 125, 3});
    L9:
        String r107 = (String) p2.a(MediaPlayer.MEDIA_INFO_DUMMY_PLAYER_SESSON_STOP, 0, 0, "6260dd", new byte[]{34, 57, 70, 123, 94});
        goto L61
    L14:
        th = th;
    L41:
        r101 = r105;
    L42:
        if (r104 != null) goto L67;
    L46:
        if (r101 != null) goto L57;
    L50:
        if (r103 == null) goto L77;
        r103.destroy();
        throw th;
    L77:
        throw th;
    L57:
        r101.close();     // Catch: IOException -> L49
    L49:
        String r108 = (String) p2.a(MediaPlayer.MEDIA_INFO_DUMMY_PLAYER_SESSON_STOP, 0, 0, "63ffd3", new byte[]{34, 56, 22, 45, 94});
        goto L50
    L67:
        r104.close();     // Catch: IOException -> L45
    L45:
        String r109 = (String) p2.a(MediaPlayer.MEDIA_INFO_DUMMY_PLAYER_SESSON_STOP, 0, 0, "4af50d", new byte[]{32, 106, 22, 126, 10});
    L63:
        String r112 = (String) p2.a(MediaPlayer.MEDIA_INFO_DUMMY_PLAYER_SESSON_STOP, 0, 0, "280914", new byte[]{38, 51, 64, 114, 11});     // Catch: Throwable -> L38
        if (r104 != null) goto L65;
    L31:
        if (r105 != null) goto L55;
    L35:
        if (r103 == null) goto L37;
    L55:
        r105.close();     // Catch: IOException -> L34
    L34:
        String r113 = (String) p2.a(MediaPlayer.MEDIA_INFO_DUMMY_PLAYER_SESSON_STOP, 0, 0, "656fd2", new byte[]{34, 62, 70, 45, 94});
        goto L35
    L65:
        r104.close();     // Catch: IOException -> L30
    L30:
        String r114 = (String) p2.a(MediaPlayer.MEDIA_INFO_DUMMY_PLAYER_SESSON_STOP, 0, 0, "703ced", new byte[]{35, 59, 67, 40, 95});
    L38:
        th = th;
        r100 = r104;
    L40:
        r104 = r100;
        goto L41
    L18:
        r105 = null;
    L16:
        th = th;
        goto L42
    L19:
        th = th;
        r105 = null;
    L24:
        r104 = null;
        r105 = null;
    L23:
        r103 = null;
    L21:
        th = th;
        r103 = null;
        r105 = null;
        goto L40
    }

    public static Process c(Runtime r110, String r111) {
        f06.c r100 = new f06.c();
        Object[] r101 = {r111};
        f06.b r112 = new f06.b();
        f06.d r113 = r100.b(102900, "java/lang/Runtime", "exec", r110, r101, "java.lang.Process", r112);
        if (r113.f474982a == false) goto L6;
        r100.a(102900, "java/lang/Runtime", "exec", r110, r101, null, r112, false);
        return (Process) r113.f474983b;
    L6:
        Process r114 = r110.exec(r111);
        r100.a(102900, "java/lang/Runtime", "exec", r110, r101, r114, r112, true);
        return r114;
    }
}
