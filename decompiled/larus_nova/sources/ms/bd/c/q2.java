package ms.bd.c;

import android.content.ContentResolver;
import android.content.Context;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.net.Uri;
import com.byted.cast.linkcommon.cybergarage.http.HTTP;
import com.bytedance.mt.protector.impl.UriProtector;
import com.ss.ttm.player.MediaPlayer;

/* JADX INFO: loaded from: classes42.dex */
public final class q2 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f515300a;

    public q2(Context r100) {
        this.f515300a = r100;
    }

    public static String a(Cursor r100) {
        String r101 = null;
        if (r100 != null) goto L6;
        return null;
    L6:
        if (r100.isClosed() == false) goto L8;
        return null;
    L8:
        r100.moveToFirst();
        int r102 = r100.getColumnIndex((String) p2.a(MediaPlayer.MEDIA_INFO_DUMMY_PLAYER_SESSON_STOP, 0, 0, "de1552", new byte[]{99, 102, 78, 84, 15}));
        if (r102 <= 0) goto L11;
        r101 = r100.getString(r102);
    L11:
        int r103 = r100.getColumnIndex((String) p2.a(MediaPlayer.MEDIA_INFO_DUMMY_PLAYER_SESSON_STOP, 0, 0, "213e40", new byte[]{32, 60, 68, 20}));
        if (r103 <= 0) goto L14;
        r100.getInt(r103);
    L14:
        int r104 = r100.getColumnIndex((String) p2.a(MediaPlayer.MEDIA_INFO_DUMMY_PLAYER_SESSON_STOP, 0, 0, "05cbbf", new byte[]{36, 47, 0, 31, 79, 116, 55}));
        if (r104 <= 0) goto L17;
        r100.getLong(r104);
    L17:
        return r101;
    }

    public final void b(y2 r210) {
        PackageManager r100 = this.f515300a.getPackageManager();     // Catch: Exception -> L17
        if (r100 == null) goto L24;
        if (r100.resolveContentProvider((String) p2.a(MediaPlayer.MEDIA_INFO_DUMMY_PLAYER_SESSON_STOP, 0, 0, "c6f554", new byte[]{113, 59, 24, 15, 7, 38, 105, HTTP.CR, 34, 43, 116, 56, 12, 76, 15, 109, 111, 7, 50, 107, 123, 48, 6, 69, 1}), 0) == null) goto L25;
        Uri r101 = UriProtector.parse((String) p2.a(MediaPlayer.MEDIA_INFO_DUMMY_PLAYER_SESSON_STOP, 0, 0, "ecc3d9", new byte[]{119, 110, 30, 83, 94, 32, 114, 24, 125, 44, 119, 110, 29, 9, 86, 43, 111, 88, 39, 45, 114, 109, 9, 74, 94, 96, 105, 82, 55, 109, 125, 101, 3, 67, 80, 97}));
        ContentResolver r102 = this.f515300a.getContentResolver();
        Cursor r103 = c(r102, r101, new String[]{(String) p2.a(MediaPlayer.MEDIA_INFO_DUMMY_PLAYER_SESSON_STOP, 0, 0, "ff1844", new byte[]{120, 101, 75, 72})});     // Catch: Throwable -> L13
        r210.f515441a.f515447a = a(r103);     // Catch: Throwable -> L12
        if (r103 == null) goto L26;
    L15:
        r103.close();
        return;
    L26:
        return;
    L14:
        if (r103 != null) goto L15;
        return;
    L13:
        r103 = null;
        goto L14
    L25:
        return;
    L24:
        return;
    }

    public static Cursor c(ContentResolver r110, Uri r111, String[] r112) {
        f06.c r100 = new f06.c();
        Object[] r101 = {r111, null, null, r112, null};
        f06.b r113 = new f06.b();
        f06.d r114 = r100.b(240004, "android/content/ContentResolver", "query", r110, r101, "android.database.Cursor", r113);
        if (r114.f474982a == false) goto L6;
        r100.a(240004, "android/content/ContentResolver", "query", r110, r101, null, r113, false);
        return (Cursor) r114.f474983b;
    L6:
        Cursor r115 = r110.query(r111, null, null, r112, null);
        r100.a(240004, "android/content/ContentResolver", "query", r110, r101, r115, r113, true);
        return r115;
    }
}
