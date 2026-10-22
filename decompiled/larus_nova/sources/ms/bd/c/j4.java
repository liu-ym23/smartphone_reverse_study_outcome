package ms.bd.c;

import android.content.ContentResolver;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import com.byted.cast.linkcommon.cybergarage.http.HTTP;
import com.bytedance.mira.exception.PluginClassNotFoundException;
import com.bytedance.mt.protector.impl.UriProtector;
import com.larus.mirabridge.impl.lancet.FastClassNotFoundHandler;
import com.larus.mirabridge.impl.lancet.MiraPluginFix;
import com.ss.ttm.player.MediaPlayer;
import java.lang.reflect.Method;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.io.encoding.Base64;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: classes42.dex */
public final class j4 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f515175a;

    public final String b() {
        String r100 = (String) p2.a(MediaPlayer.MEDIA_INFO_DUMMY_PLAYER_SESSON_STOP, 0, 0, "755524", new byte[]{54, 50, 84, 82, 4, 48, 32, 90, 119, 124, 53, 121, 79, 69, 8, 45, 32, 29, 98, 108, 35, 37, 79, 69, 67, 48, 33, 4, 116, 106, 52, 35, 67, 69});
        String r101 = (String) p2.a(MediaPlayer.MEDIA_INFO_DUMMY_PLAYER_SESSON_STOP, 0, 0, "cbe188", new byte[]{34});
        int r102 = 2;
        Class r103 = a((String) p2.a(MediaPlayer.MEDIA_INFO_DUMMY_PLAYER_SESSON_STOP, 0, 0, "55cbfc", new byte[]{37, 57, 20, 4, 86, 125, 50, 90, Base64.padSymbol, 33, 106, 4, 9, 5, 77, 113, 59, 36, 32, Base64.padSymbol, 52, 50, 2, 2, 80, 113, 37}));     // Catch: Exception -> L10
        Method r110 = r103.getMethod((String) p2.a(MediaPlayer.MEDIA_INFO_DUMMY_PLAYER_SESSON_STOP, 0, 0, "014728", new byte[]{38, 54, 83}), new Class[]{String.class, String.class});     // Catch: Exception -> L10
        byte[] r104 = new byte[7];     // Catch: Exception -> L10
        r104[0] = 48;     // Catch: Exception -> L10
        r104[1] = 110;     // Catch: Exception -> L10
        r104[2] = 65;     // Catch: Exception -> L10
        r104[3] = 25;     // Catch: Exception -> L10
        int r105 = 5;
        r104[4] = 5;     // Catch: Exception -> L35
        r104[5] = 55;     // Catch: Exception -> L35
        r104[6] = 57;     // Catch: Exception -> L35
        r101 = (String) r110.invoke(r103, new Object[]{r100, (String) p2.a(MediaPlayer.MEDIA_INFO_DUMMY_PLAYER_SESSON_STOP, 0, 0, "4b9c57", r104)});     // Catch: Exception -> L35
    L12:
        String r106 = null;
        if (r101.equals((String) p2.a(MediaPlayer.MEDIA_INFO_DUMMY_PLAYER_SESSON_STOP, 0, 0, "b77b5c", new byte[]{34})) == true) goto L15;
        return null;
    L15:
        Uri r111 = UriProtector.parse((String) p2.a(MediaPlayer.MEDIA_INFO_DUMMY_PLAYER_SESSON_STOP, 0, 0, "0b0883", new byte[]{34, 111, 77, 88, 2, 42, 39, 25, 46, 39, 34, 111, 78, 2, 17, 45, 37, 76, 47, 126, 44, 115, HTTP.CR, 101, 3, 20, 33, 76, 119, 97, 37, 101, 81, 3, 46, 32, 54, 77, 117, 97, 39, 105, 70, 94, 46, 32, 124, 108, 64, 65, 5}));
        ContentResolver r107 = this.f515175a.getContentResolver();
        f06.c r108 = new f06.c();
        Object[] r112 = new Object[r105];
        r112[0] = r111;
        r112[1] = null;
        r112[r102] = null;
        r112[3] = null;
        r112[4] = null;
        f06.b r113 = new f06.b();
        f06.d r114 = r108.b(240004, "android/content/ContentResolver", "query", r107, r112, "android.database.Cursor", r113);
        if (r114.f474982a == false) goto L18;
        r108.a(240004, "android/content/ContentResolver", "query", r107, r112, null, r113, false);
        Cursor r115 = (Cursor) r114.f474983b;
    L19:
        if (r115 != null) goto L38;
    L30:
        if (r115 != null) goto L42;
    L32:
        return r106;
    L42:
        r115.close();     // Catch: Throwable -> L33
        goto L32
    L38:
        if (r115.moveToNext() == false) goto L30;
        byte[] r109 = new byte[r105];     // Catch: Throwable -> L24
        r109[0] = 49;     // Catch: Throwable -> L24
        r109[1] = 54;     // Catch: Throwable -> L24
        r109[r102] = 27;     // Catch: Throwable -> L24
        r109[3] = 84;     // Catch: Throwable -> L24
        r109[4] = 94;     // Catch: Throwable -> L24
        r106 = r115.getString(r115.getColumnIndex((String) p2.a(MediaPlayer.MEDIA_INFO_DUMMY_PLAYER_SESSON_STOP, 0, 0, "65d5d9", r109)));     // Catch: Throwable -> L24
    L48:
        byte[] r116 = new byte[r102];     // Catch: Throwable -> L27
        r116[0] = 99;     // Catch: Throwable -> L27
        r116[1] = 110;     // Catch: Throwable -> L27
        String r117 = (String) p2.a(MediaPlayer.MEDIA_INFO_DUMMY_PLAYER_SESSON_STOP, 0, 0, "dc13c3", r116);     // Catch: Throwable -> L27
    L27:
        th = move-exception;
        r115.close();     // Catch: Throwable -> L34
    L29:
        throw th;
    L18:
        r115 = r107.query(r111, null, null, null, null);
        r108.a(240004, "android/content/ContentResolver", "query", r107, r112, r115, r113, true);
    L10:
        r105 = 5;
    L11:
        r105 = 5;
        r102 = 2;
        goto L12
    }

    public j4(Context r100) {
        this.f515175a = r100;
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
}
