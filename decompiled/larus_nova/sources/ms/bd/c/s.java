package ms.bd.c;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.text.TextUtils;
import com.bytedance.mt.protector.impl.JSONObjectProtectorUtils;
import com.ss.ttm.player.MediaPlayer;
import java.util.ArrayList;
import kotlin.io.encoding.Base64;
import kotlin.jvm.internal.ByteCompanionObject;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes5.dex */
public final class s {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final String f515349c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final String f515350d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final String f515351e = null;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static s f515352f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final String f515353g = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final SharedPreferences f515354a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public ArrayList f515355b;

    static {
        f515349c = (String) p2.a(MediaPlayer.MEDIA_INFO_DUMMY_PLAYER_SESSON_STOP, 0, 0, "e5c990", new byte[]{59, 52, 17, 93, 18, 36, 110, 21, 125, ByteCompanionObject.MAX_VALUE, 113, 37, 25, 75, 31});
        f515350d = (String) p2.a(MediaPlayer.MEDIA_INFO_DUMMY_PLAYER_SESSON_STOP, 0, 0, "ad8651", new byte[]{63, 118, 74, 81, 25, 54, 109, 87, 125, 41, 125, 105, 73, 75, 6, 35, 45, 72, 102, 100, 121, 106, 78, 125, 9, 39, 112, 65, 86, 106, ByteCompanionObject.MAX_VALUE, 97, 66, 76, 69});
        f515351e = (String) p2.a(MediaPlayer.MEDIA_INFO_DUMMY_PLAYER_SESSON_STOP, 0, 0, "83d835", new byte[]{102, 33, 22, 95, 31, 50, 52, 0, 33, 39, 36, 62, 21, 69, 0, 39, 116, 1, 56, 123, 22, Base64.padSymbol, 24, 75, 5, 44, 116});
        f515353g = (String) p2.a(MediaPlayer.MEDIA_INFO_DUMMY_PLAYER_SESSON_STOP, 0, 0, "741fa3", new byte[]{52, 51, 69, 23, 70, 27, 57, 26, 100, 51, 25, 58, 75, 1, 74});
    }

    public s(Context r110) {
        this.f515355b = new ArrayList(10);
        SharedPreferences r111 = PreferenceManager.getDefaultSharedPreferences(r110);
        this.f515354a = r111;
        b(r111.getString((String) p2.a(MediaPlayer.MEDIA_INFO_DUMMY_PLAYER_SESSON_STOP, 0, 0, "593f0d", new byte[]{54, 62, 71, 23, 23, 76, 59, 23, 102, 51, 27, 55, 73, 1, 27}), ""), false);
        if (this.f515355b.size() >= 1) goto L18;
        Object r112 = p2.a(33554445, 3, 0, null, null);
        Object r100 = p2.a(33554445, 2, 0, null, null);
        Object r101 = p2.a(33554445, 1, 0, null, null);
        if (r112 != null) goto L7;
    L9:
        if (r100 != null) goto L11;
    L13:
        if (r101 != null) goto L15;
        return;
    L15:
        if (((Integer) r101).intValue() != 1) goto L20;
        r r113 = new r((String) p2.a(MediaPlayer.MEDIA_INFO_DUMMY_PLAYER_SESSON_STOP, 0, 0, "9c7828", new byte[]{103, 113, 69, 95, 30, 63, 53, 80, 114, 39, 37, 110, 70, 69, 1, 42, 117, 81, 107, 123, 23, 109, 75, 75, 4, 33, 117}), (String) p2.a(MediaPlayer.MEDIA_INFO_DUMMY_PLAYER_SESSON_STOP, 0, 0, "d04d13", new byte[]{102, 43, 73, 19}));
        this.f515355b.add(r113);
        return;
    L20:
        return;
    L11:
        if (((Integer) r100).intValue() != 1) goto L13;
        r r114 = new r((String) p2.a(MediaPlayer.MEDIA_INFO_DUMMY_PLAYER_SESSON_STOP, 0, 0, "e61670", new byte[]{59, 36, 67, 81, 27, 55, 105, 5, 116, 41, 121, 59, 64, 75, 4, 34, 41, 26, 111, 100, 125, 56, 71, 125, 11, 38, 116, 19, 95, 106, 123, 51, 75, 76, 71}), (String) p2.a(MediaPlayer.MEDIA_INFO_DUMMY_PLAYER_SESSON_STOP, 0, 0, "3beb37", new byte[]{49, 121, 24, 21}));
        this.f515355b.add(r114);
        goto L13
    L7:
        if (((Integer) r112).intValue() == 0) goto L9;
        r r115 = new r((String) p2.a(MediaPlayer.MEDIA_INFO_DUMMY_PLAYER_SESSON_STOP, 0, 0, "0a0e5c", new byte[]{110, 96, 66, 1, 30, 119, 59, 65, 46, 35, 36, 113, 74, 23, 19}), (String) p2.a(MediaPlayer.MEDIA_INFO_DUMMY_PLAYER_SESSON_STOP, 0, 0, "095e8a", new byte[]{50, 34, 72, 18}));
        this.f515355b.add(r115);
        goto L9
    }

    public static synchronized s a(Context r100) {
        monitor-enter(s.class);
    L10:
        th = move-exception;
        throw th;
    L5:
        if (f515352f != null) goto L7;
        f515352f = new s(r100);     // Catch: Throwable -> L10
    L7:
        s r101 = f515352f;     // Catch: Throwable -> L10
        monitor-exit(s.class);
        return r101;
    }

    public final synchronized void b(String r210, boolean r211) {
        monitor-enter(this);
    L23:
        th = move-exception;
        throw th;
    L5:
        if (TextUtils.isEmpty(r210) == false) goto L8;
        monitor-exit(this);
        return;
    L8:
        ArrayList r100 = new ArrayList(20);     // Catch: Throwable -> L23 JSONException -> L28
        JSONObject r101 = new JSONObject(r210);     // Catch: Throwable -> L23 JSONException -> L28
        String r102 = JSONObjectProtectorUtils.getString(r101, (String) p2.a(MediaPlayer.MEDIA_INFO_DUMMY_PLAYER_SESSON_STOP, 0, 0, "b0e83b", new byte[]{101, 55, 4, 95, 5, 122, 111}));     // Catch: Throwable -> L23 JSONException -> L28
        String r103 = JSONObjectProtectorUtils.getString(r101, (String) p2.a(MediaPlayer.MEDIA_INFO_DUMMY_PLAYER_SESSON_STOP, 0, 0, "02e611", new byte[]{51, 37, 26, 71, 29}));     // Catch: Throwable -> L23 JSONException -> L28
        if (((String) p2.a(MediaPlayer.MEDIA_INFO_DUMMY_PLAYER_SESSON_STOP, 0, 0, "abfd97", new byte[]{33})).equals(r102) == false) goto L19;
        if (r103 == null) goto L19;
        String[] r104 = r103.split((String) p2.a(MediaPlayer.MEDIA_INFO_DUMMY_PLAYER_SESSON_STOP, 0, 0, "34e61f", new byte[]{30, 42}));     // Catch: Throwable -> L23 JSONException -> L28
        int r105 = r104.length;     // Catch: Throwable -> L23 JSONException -> L28
        int r106 = 0;
    L12:
        if (r106 >= r105) goto L19;
        String[] r107 = r104[r106].split((String) p2.a(MediaPlayer.MEDIA_INFO_DUMMY_PLAYER_SESSON_STOP, 0, 0, "7beba9", new byte[]{124}));     // Catch: Throwable -> L23 JSONException -> L28
        if (r107 == null) goto L18;
        if (r107.length < 2) goto L18;
        r100.add(new r(new String(q.b(r107[0])), r107[1]));     // Catch: Throwable -> L23 JSONException -> L28
    L18:
        r106 = r106 + 1;     // Catch: Throwable -> L23 JSONException -> L28
    L19:
        this.f515355b = r100;     // Catch: Throwable -> L23 JSONException -> L28
        if (r211 == false) goto L26;
        this.f515354a.edit().putString(f515353g, r210).apply();     // Catch: Throwable -> L23 JSONException -> L28
    L26:
        monitor-exit(this);
    }
}
