package ms.bd.c;

import android.util.Base64;
import com.ss.ttm.player.MediaPlayer;
import java.nio.charset.StandardCharsets;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes6.dex */
public final class x1 {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final String f515422e = null;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final String f515423f = null;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final String f515424g = null;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final String f515425h = null;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final String f515426i = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f515427a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f515428b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f515429c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Throwable f515430d;

    static {
        f515422e = (String) p2.a(MediaPlayer.MEDIA_INFO_DUMMY_PLAYER_SESSON_STOP, 0, 0, "7ce50b", new byte[]{50});
        f515423f = (String) p2.a(MediaPlayer.MEDIA_INFO_DUMMY_PLAYER_SESSON_STOP, 0, 0, "1ea8ad", new byte[]{50});
        f515424g = (String) p2.a(MediaPlayer.MEDIA_INFO_DUMMY_PLAYER_SESSON_STOP, 0, 0, "927675", new byte[]{59});
        f515425h = (String) p2.a(MediaPlayer.MEDIA_INFO_DUMMY_PLAYER_SESSON_STOP, 0, 0, "e19cea", new byte[]{114});
        f515426i = (String) p2.a(MediaPlayer.MEDIA_INFO_DUMMY_PLAYER_SESSON_STOP, 0, 0, "fdf624", new byte[]{116});
    }

    public final String[] a() {
        String r100 = String.valueOf(this.f515427a);
        JSONObject r101 = new JSONObject();
        r101.put(f515422e, System.currentTimeMillis());     // Catch: Throwable -> L16
        r101.put(f515423f, this.f515427a);     // Catch: Throwable -> L16
        if (this.f515430d == null) goto L13;
        String r102 = f515424g;     // Catch: Throwable -> L16
        StringBuilder r103 = new StringBuilder();     // Catch: Throwable -> L16
        r103.append(this.f515430d.getMessage());     // Catch: Throwable -> L16
        StackTraceElement[] r104 = this.f515430d.getStackTrace();     // Catch: Throwable -> L16
        int r105 = r104.length;     // Catch: Throwable -> L16
        int r106 = 0;
        int r107 = 0;
    L6:
        if (r106 >= r105) goto L11;
        StackTraceElement r110 = r104[r106];     // Catch: Throwable -> L16
        int r111 = r107 + 1;     // Catch: Throwable -> L16
        if (r107 >= 3) goto L11;
        r103.append("\n");     // Catch: Throwable -> L16
        r103.append(r110.toString());     // Catch: Throwable -> L16
        r106 = r106 + 1;     // Catch: Throwable -> L16
        r107 = r111;
    L11:
        String r108 = r103.toString();     // Catch: Throwable -> L16
    L12:
        r101.put(r102, r108);     // Catch: Throwable -> L16
        String r109 = Base64.encodeToString(r101.toString().getBytes(StandardCharsets.UTF_8), 2);     // Catch: Throwable -> L16
    L18:
        return new String[]{r100, r109};
    L13:
        r101.put(f515425h, this.f515428b);     // Catch: Throwable -> L16
        r102 = f515426i;     // Catch: Throwable -> L16
        r108 = this.f515429c;     // Catch: Throwable -> L16
    L16:
        r109 = "";
        goto L18
    }

    public x1(int r100, String r101, String r102, Throwable r103) {
        this.f515427a = r100;
        this.f515428b = r101;
        this.f515429c = r102;
        this.f515430d = r103;
    }
}
