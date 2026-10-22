package ms.bd.c;

import com.ss.ttm.player.MediaPlayer;
import java.util.Arrays;

/* JADX INFO: loaded from: classes5.dex */
public abstract class q {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final String f515291a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final String f515292b = null;

    static {
        f515291a = (String) p2.a(MediaPlayer.MEDIA_INFO_DUMMY_PLAYER_SESSON_STOP, 0, 0, "4e3009", new byte[]{4, 69, 99, 96, 42, 8, 16, 108, 75, 74, 14, 75, 109, 106, 32, 30, 6, 118, 81, 84, 16, 81, 119, 124, 54, 20, 54, 70, 97, 100, 32, 97, 71, 76, 6, 36, 60, 72, 111, 110, 42, 119, 81, 86, 28, 58, 34, 82, 117, 120, 60, 125, 16, 21, 93, 125, 99, 17, 52, 55, 125, 62, 11, 11});
        f515292b = (String) p2.a(MediaPlayer.MEDIA_INFO_DUMMY_PLAYER_SESSON_STOP, 0, 0, "11f351", new byte[]{125});
    }

    public static String a(String r100) {
        if (r100 != null) goto L4;
        return r100;
    L4:
        if (r100.length() > 0) goto L7;
        return r100;
    L7:
        return r100.replaceAll((String) p2.a(MediaPlayer.MEDIA_INFO_DUMMY_PLAYER_SESSON_STOP, 0, 0, "1986be", new byte[]{28, 112}), (String) p2.a(MediaPlayer.MEDIA_INFO_DUMMY_PLAYER_SESSON_STOP, 0, 0, "b3e506", new byte[]{62})).replaceAll((String) p2.a(MediaPlayer.MEDIA_INFO_DUMMY_PLAYER_SESSON_STOP, 0, 0, "d3fe47", new byte[]{58}), (String) p2.a(MediaPlayer.MEDIA_INFO_DUMMY_PLAYER_SESSON_STOP, 0, 0, "d053ad", new byte[]{74})).replaceAll(f515292b, "");
    }

    public static byte[] b(String r110) {
        int r100 = (r110.length() * 3) / 4;     // Catch: Throwable -> L16
        byte[] r101 = new byte[r100];     // Catch: Throwable -> L16
        int r102 = r110.length();     // Catch: Throwable -> L16
        String r103 = "";
        int r104 = 0;
    L5:
        if (r104 >= 2) goto L10;
        if (r110.charAt((r102 - 1) - r104) != f515292b.charAt(0)) goto L9;
        r103 = r103 + f515291a.charAt(0);     // Catch: Throwable -> L16
    L9:
        r104 = r104 + 1;     // Catch: Throwable -> L16
        goto L5
    L10:
        String r111 = r110.substring(0, r102 - r103.length()) + r103;     // Catch: Throwable -> L16
        int r105 = 0;
        int r106 = 0;
    L12:
        if (r105 >= r111.length()) goto L14;
        String r107 = f515291a;     // Catch: Throwable -> L16
        int r108 = r107.indexOf(r111.charAt(r105));     // Catch: Throwable -> L16
        int r109 = r107.indexOf(r111.charAt(r105 + 1));     // Catch: Throwable -> L16
        int r112 = r107.indexOf(r111.charAt(r105 + 2));     // Catch: Throwable -> L16
        int r113 = r107.indexOf(r111.charAt(r105 + 3));     // Catch: Throwable -> L16
        int r114 = ((r108 << 2) | (r109 >> 4)) & 255;     // Catch: Throwable -> L16
        r101[r106] = (byte) r114;     // Catch: Throwable -> L16
        r101[r106 + 1] = (byte) (((r109 << 4) | (r112 >> 2)) & 255);     // Catch: Throwable -> L16
        r101[r106 + 2] = (byte) ((r113 | (r112 << 6)) & 255);     // Catch: Throwable -> L16
        r105 = r105 + 4;     // Catch: Throwable -> L16
        r106 = r106 + 3;     // Catch: Throwable -> L16
        goto L12
    L14:
        return Arrays.copyOfRange(r101, 0, r100 - r103.length());
    L17:
        return new byte[0];
    }
}
