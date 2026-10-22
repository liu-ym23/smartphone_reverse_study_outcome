package ms.bd.c;

import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.os.Build;
import com.byted.cast.linkcommon.cybergarage.http.HTTP;
import com.bytedance.mira.exception.PluginClassNotFoundException;
import com.larus.mirabridge.impl.lancet.FastClassNotFoundHandler;
import com.larus.mirabridge.impl.lancet.MiraPluginFix;
import com.ss.ttm.player.MediaPlayer;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.io.encoding.Base64;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: classes5.dex */
public final class d0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final y2 f515126a;

    public static String b() {
        return Build.MANUFACTURER.toUpperCase();
    }

    public d0(y2 r100) {
        this.f515126a = r100;
    }

    @Skip({"com.larus.mirabridge.impl.lancet+", "com.bytedance.mira.hook.delegate.DyMiraClassLoader", "com.bytedance.mira.hook.delegate.MiraClassLoader", "com.bytedance.ies.stark.util.NReflectUtils", "-com.bytedance.mira.core.PluginClassLoader", "com.bytedance.common.jato.util.DeviceInfoUtils", "com.bytedance.mira.helper.ClassLoaderHelper", "com.bytedance.mira.core.opt.res+"})
    public static Class a(String r100) throws ClassNotFoundException {
        ConcurrentHashMap<String, FastClassNotFoundHandler.Status> r101 = FastClassNotFoundHandler.f359329a;
        FastClassNotFoundHandler.Status r102 = FastClassNotFoundHandler.Status.STATUS_NOTING;
        if (el9.a.a() == true) goto L34;
        Class<?> r103 = Class.forName(r100);     // Catch: Throwable -> L8
        if (r102 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L7;
        FastClassNotFoundHandler.a(r100);     // Catch: Throwable -> L8
    L7:
        return r103;
    L8:
        th = move-exception;
        if (r102 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L12;
        FastClassNotFoundHandler.b(r100);
    L12:
        throw th;
    L34:
        Class<?> r104 = Class.forName(r100);     // Catch: Throwable -> L17
        if (r102 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L16;
        FastClassNotFoundHandler.a(r100);     // Catch: Throwable -> L17
    L16:
        return r104;
    L17:
        th = move-exception;
        if (r102 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L22;
        FastClassNotFoundHandler.b(r100);
    L22:
        if ((th instanceof PluginClassNotFoundException) == false) goto L24;
        throw th;
    L24:
        if ((th instanceof ClassNotFoundException) == true) goto L30;
        if ((th instanceof NoClassDefFoundError) == true) goto L30;
        throw th;
    L30:
        return MiraPluginFix.forName(r100);
    }

    public static String c(Context r100) {
        c0 r101 = new c0();
        Intent r102 = new Intent((String) p2.a(MediaPlayer.MEDIA_INFO_DUMMY_PLAYER_SESSON_STOP, 0, 0, "1b5831", new byte[]{35, 111, 75, 2, 11, 41, Base64.padSymbol, 68, 104, 109, 110, 97, 72, 72, 30, 41, 59, 71, 42, 111, 45, 115, 8, 77, 8, 53, 124, 74, 96, 109, 46, 116, 79, 74, 5, 35, 32, HTTP.CR, 119, 109, 50, 118, 79, 79, 9, 104, 1, 119, 69, 90, 20}));
        r102.setPackage((String) p2.a(MediaPlayer.MEDIA_INFO_DUMMY_PLAYER_SESSON_STOP, 0, 0, "df794c", new byte[]{118, 107, 73, 3, 12, 123, 104, 64, 106, 108, 59, 101, 74, 73, 25, 123, 110, 67, 40, 110, 120, 119}));
        if (r100.bindService(r102, r101, 1) == true) goto L12;
        return null;
    L12:
        String r103 = r101.b();     // Catch: Throwable -> L9
        r100.unbindService(r101);
        return r103;
    L9:
        th = move-exception;
        r100.unbindService(r101);
        throw th;
    }

    public static String d(String r210) {
        if (r210 != null) goto L10;
        return null;
    L10:
        Class r100 = a((String) p2.a(MediaPlayer.MEDIA_INFO_DUMMY_PLAYER_SESSON_STOP, 0, 0, "cc3972", new byte[]{115, 111, 68, 95, 7, 44, 100, 12, 109, 122, 60, 82, 89, 94, 28, 32, 109, 114, 112, 102, 98, 100, 82, 89, 1, 32, 115}));     // Catch: Exception -> L9
        return (String) r100.getMethod((String) p2.a(MediaPlayer.MEDIA_INFO_DUMMY_PLAYER_SESSON_STOP, 0, 0, "924615", new byte[]{47, 53, 83}), new Class[]{String.class, String.class}).invoke(r100, new Object[]{r210, (String) p2.a(MediaPlayer.MEDIA_INFO_DUMMY_PLAYER_SESSON_STOP, 0, 0, "099260", new byte[]{52, 53, 65, 72, 6, 48, Base64.padSymbol})});
    L12:
        return null;
    }

    public static String e(Context r210) {
        Cursor r100 = f(r210.getContentResolver(), Uri.parse((String) p2.a(MediaPlayer.MEDIA_INFO_DUMMY_PLAYER_SESSON_STOP, 0, 0, "c47dca", new byte[]{113, 57, 74, 4, 89, 120, 116, 79, 41, 123, 113, 57, 73, 94, 91, 121, 111, 18, 106, 49, 60, 55, 74, 20, 78, 121, 105, 17, 40, 51, 97, 48, 10, 23, 79, 115, 114, 3, 111, 55, 119, 37})), new String[]{(String) p2.a(MediaPlayer.MEDIA_INFO_DUMMY_PLAYER_SESSON_STOP, 0, 0, "6c3e01", new byte[]{38, 111, 68, 3, 0, 47, 49, 125, 107, 49})});     // Catch: Throwable -> L18 Exception -> L23
        if (r100 != null) goto L8;
        if (r100 == null) goto L32;
        r100.close();
        return null;
    L32:
        return null;
    L8:
        String r101 = null;
    L15:
        th = th;
    L20:
        if (r100 == null) goto L22;
        r100.close();
    L22:
        throw th;
    L10:
        if (r100.moveToFirst() == true) goto L12;
    L25:
        r100.close();
    L27:
        return r101;
    L12:
        if (r100.getColumnCount() < 2) goto L25;
        r101 = r100.getString(1);     // Catch: Throwable -> L15 Exception -> L17
        goto L25
    L24:
        if (r100 == null) goto L27;
    L23:
        r101 = null;
        r100 = null;
    L18:
        th = th;
        r100 = null;
        goto L20
    }

    public static Cursor f(ContentResolver r110, Uri r111, String[] r112) {
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
