package ms.bd.c;

import android.text.TextUtils;
import android.view.Display;
import com.ss.ttm.player.MediaPlayer;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import kotlin.jvm.internal.ByteCompanionObject;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes5.dex */
public final class r3 {

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static r3 f515339j;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public long f515340a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public long f515341b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public long f515342c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f515343d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public long f515344e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public String f515345f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public String f515346g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public String f515347h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public boolean f515348i;

    public final JSONObject c() {
        JSONObject r100 = new JSONObject();     // Catch: Exception -> L14
        r100.put((String) p2.a(MediaPlayer.MEDIA_INFO_DUMMY_PLAYER_SESSON_STOP, 0, 0, "e3d03f", new byte[]{117, 37}), this.f515340a);     // Catch: Exception -> L14
        r100.put((String) p2.a(MediaPlayer.MEDIA_INFO_DUMMY_PLAYER_SESSON_STOP, 0, 0, "2883e4", new byte[]{49, 46}), this.f515341b);     // Catch: Exception -> L14
        r100.put((String) p2.a(MediaPlayer.MEDIA_INFO_DUMMY_PLAYER_SESSON_STOP, 0, 0, "43c9f0", new byte[]{33, 60}), this.f515343d);     // Catch: Exception -> L14
        r100.put((String) p2.a(MediaPlayer.MEDIA_INFO_DUMMY_PLAYER_SESSON_STOP, 0, 0, "9a8558", new byte[]{44, 119}), this.f515344e);     // Catch: Exception -> L14
        r100.put((String) p2.a(MediaPlayer.MEDIA_INFO_DUMMY_PLAYER_SESSON_STOP, 0, 0, "f92e31", new byte[]{116, 58, 69}), this.f515348i ? 1 : 0);     // Catch: Exception -> L14
        r100.put((String) p2.a(MediaPlayer.MEDIA_INFO_DUMMY_PLAYER_SESSON_STOP, 0, 0, "f7ddf8", new byte[]{122, 49}), this.f515345f);     // Catch: Exception -> L14
        if (TextUtils.isEmpty(this.f515346g) == true) goto L7;
        r100.put((String) p2.a(MediaPlayer.MEDIA_INFO_DUMMY_PLAYER_SESSON_STOP, 0, 0, "9dc04f", new byte[]{56, 109}), this.f515346g);     // Catch: Exception -> L14
    L7:
        if (TextUtils.isEmpty(this.f515347h) == true) goto L9;
        r100.put((String) p2.a(MediaPlayer.MEDIA_INFO_DUMMY_PLAYER_SESSON_STOP, 0, 0, "033488", new byte[]{37, 56}), this.f515347h);     // Catch: Exception -> L14
    L9:
        this.f515342c = System.currentTimeMillis();     // Catch: Exception -> L14
        r100.put((String) p2.a(MediaPlayer.MEDIA_INFO_DUMMY_PLAYER_SESSON_STOP, 0, 0, "2d9c91", new byte[]{32, 114}), this.f515342c / 1000);     // Catch: Exception -> L14
        if (r100.length() <= 0) goto L12;
        return r100;
    L12:
        return null;
    L17:
        return null;
    }

    public r3() {
        this.f515343d = 1;
    }

    public static String b(Display[] r310) {
        StringBuilder r100 = new StringBuilder();     // Catch: Exception -> L18
        int r101 = r310.length;     // Catch: Exception -> L18
        int r102 = 0;
    L4:
        if (r102 >= r101) goto L13;
        Display r103 = r310[r102];     // Catch: Exception -> L18
        StringBuilder r104 = new StringBuilder();     // Catch: Exception -> L18
        Object r105 = a(r103, (String) p2.a(MediaPlayer.MEDIA_INFO_DUMMY_PLAYER_SESSON_STOP, 0, 0, "ea21a1", new byte[]{121, 71, 72, 86, 78, 42, 103, 89, 74, 111, 114, 108}));     // Catch: Exception -> L18
        r104.append(a(r105, (String) p2.a(MediaPlayer.MEDIA_INFO_DUMMY_PLAYER_SESSON_STOP, 0, 0, "f22b10", new byte[]{120, 39, 79, 19, 28, 23, 100, 16, 104, 51, 112, 53, 111, 23, 3, 34})));     // Catch: Exception -> L18
        r104.append((String) p2.a(MediaPlayer.MEDIA_INFO_DUMMY_PLAYER_SESSON_STOP, 0, 0, "4ba1b2", new byte[]{105}));     // Catch: Exception -> L18
        r104.append(a(r105, (String) p2.a(MediaPlayer.MEDIA_INFO_DUMMY_PLAYER_SESSON_STOP, 0, 0, "28fc58", new byte[]{37, 54, 20, 16, 25})));     // Catch: Exception -> L18
        r104.append((String) p2.a(MediaPlayer.MEDIA_INFO_DUMMY_PLAYER_SESSON_STOP, 0, 0, "56b230", new byte[]{104}));     // Catch: Exception -> L18
        r104.append(a(r105, (String) p2.a(MediaPlayer.MEDIA_INFO_DUMMY_PLAYER_SESSON_STOP, 0, 0, "cd029e", new byte[]{124, 103, 78, 67})));     // Catch: Exception -> L18
        r104.append((String) p2.a(MediaPlayer.MEDIA_INFO_DUMMY_PLAYER_SESSON_STOP, 0, 0, "fb719f", new byte[]{59}));     // Catch: Exception -> L18
        r104.append(a(r105, (String) p2.a(MediaPlayer.MEDIA_INFO_DUMMY_PLAYER_SESSON_STOP, 0, 0, "ed6bca", new byte[]{96, ByteCompanionObject.MAX_VALUE, 85, 19})));     // Catch: Exception -> L18
        if (r100.toString().contains(r104.toString()) == true) goto L11;
        if (r100.length() <= 0) goto L10;
        r100.append((String) p2.a(MediaPlayer.MEDIA_INFO_DUMMY_PLAYER_SESSON_STOP, 0, 0, "880e3e", new byte[]{114}));     // Catch: Exception -> L18
    L10:
        r100.append(r104);     // Catch: Exception -> L18
    L11:
        r102 = r102 + 1;     // Catch: Exception -> L18
        goto L4
    L13:
        if (r100.length() <= 0) goto L16;
        return r100.toString();
    L16:
        return null;
    L24:
        return null;
    }

    public static String d(Display[] r110) {
        StringBuilder r100 = new StringBuilder();     // Catch: Exception -> L17
        int r101 = r110.length;     // Catch: Exception -> L17
        int r102 = 0;
    L4:
        if (r102 >= r101) goto L12;
        Object r103 = a(r110[r102], (String) p2.a(MediaPlayer.MEDIA_INFO_DUMMY_PLAYER_SESSON_STOP, 0, 0, "7c6225", new byte[]{43, 78, 82, 72, 8, 48, 4, 67, 100, 105, 39, 102, 64, 104, 12, 47, 49}));     // Catch: Exception -> L17
        if (r103 == null) goto L10;
        if (r100.toString().contains(r103.toString()) == true) goto L10;
        r100.append(r103);     // Catch: Exception -> L17
        r100.append((String) p2.a(MediaPlayer.MEDIA_INFO_DUMMY_PLAYER_SESSON_STOP, 0, 0, "97fc79", new byte[]{115}));     // Catch: Exception -> L17
    L10:
        r102 = r102 + 1;     // Catch: Exception -> L17
        goto L4
    L12:
        if (r100.length() <= 0) goto L15;
        return r100.toString();
    L15:
        return null;
    L24:
        return null;
    }

    public static Object a(Object r110, String r111) {
        Method r100 = Class.class.getDeclaredMethod((String) p2.a(MediaPlayer.MEDIA_INFO_DUMMY_PLAYER_SESSON_STOP, 0, 0, "9e49b9", new byte[]{47, 98, 83, 105, 88, 45, 54, 69, 119, 108, 44, 65, 78, 72, 81, 42}), new Class[]{String.class});     // Catch: Throwable -> L10
        if (r100 == null) goto L8;
        Field r112 = (Field) r100.invoke(r110.getClass(), new Object[]{r111});     // Catch: Throwable -> L10
        if (r112 == null) goto L13;
        r112.setAccessible(true);     // Catch: Throwable -> L10
        return r112.get(r110);
    L13:
        return null;
    L8:
        return null;
    L14:
        return null;
    }
}
