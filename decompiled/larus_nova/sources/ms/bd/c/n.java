package ms.bd.c;

import android.app.Activity;
import android.os.Handler;
import android.text.TextUtils;
import android.util.ArrayMap;
import com.bytedance.mira.exception.PluginClassNotFoundException;
import com.bytedance.mobsec.metasec.ml.MSManagerUtils;
import com.larus.mirabridge.impl.lancet.FastClassNotFoundHandler;
import com.larus.mirabridge.impl.lancet.MiraPluginFix;
import com.ss.android.ugc.bytex.pthread.base.proxy.PthreadHandlerThreadV2;
import com.ss.ttm.player.MediaPlayer;
import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.jvm.internal.ByteCompanionObject;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: classes5.dex */
public abstract class n {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static volatile int f515223a = -1;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static volatile String f515224b = "";

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static volatile String f515225c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final HashMap f515226d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static boolean f515227e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final PthreadHandlerThreadV2 f515228f = null;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final AtomicBoolean f515229g = null;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static Handler f515230h;

    static {
        f515226d = new HashMap(3);
        f515227e = false;
        f515228f = new PthreadHandlerThreadV2((String) p2.a(MediaPlayer.MEDIA_INFO_DUMMY_PLAYER_SESSON_STOP, 0, 0, "62adef", new byte[]{42, 35, 1, 20, 81}));
        f515229g = new AtomicBoolean(true);
        f515230h = null;
    }

    public static int b() {
        if (d() == null) goto L6;
        return 1;
    L6:
        return 0;
    L8:
        return -1;
    }

    public static Activity d() {
        Class r100 = a((String) p2.a(MediaPlayer.MEDIA_INFO_DUMMY_PLAYER_SESSON_STOP, 0, 0, "6e355a", new byte[]{38, 105, 68, 83, 5, ByteCompanionObject.MAX_VALUE, 49, 10, 99, 117, 55, 41, 97, 66, 30, ByteCompanionObject.MAX_VALUE, 35, 77, 118, 124, 19, 111, 82, 68, 11, 114}));     // Catch: Exception -> L14
        Object r101 = r100.getMethod((String) p2.a(MediaPlayer.MEDIA_INFO_DUMMY_PLAYER_SESSON_STOP, 0, 0, "8b2db9", new byte[]{42, 117, 83, 2, 88, 32, 47, 98, 96, 32, 32, 118, 72, 4, 68, 26, 51, 81, 102, 53, 45}), null).invoke(null, null);     // Catch: Exception -> L14
        Field r102 = r100.getDeclaredField((String) p2.a(MediaPlayer.MEDIA_INFO_DUMMY_PLAYER_SESSON_STOP, 0, 0, "4ea5eb", new byte[]{40, 70, 17, 85, 83, 99, 62, 80, 57, 96, 54}));     // Catch: Exception -> L14
        r102.setAccessible(true);     // Catch: Exception -> L14
        ArrayMap r103 = (ArrayMap) r102.get(r101);     // Catch: Exception -> L14
        if (r103.size() >= 1) goto L7;
        return null;
    L7:
        Iterator r104 = r103.values().iterator();     // Catch: Exception -> L14
    L9:
        if (r104.hasNext() == false) goto L22;
        Object r105 = r104.next();     // Catch: Exception -> L14
        Class<?> r106 = r105.getClass();     // Catch: Exception -> L14
        Field r107 = r106.getDeclaredField((String) p2.a(MediaPlayer.MEDIA_INFO_DUMMY_PLAYER_SESSON_STOP, 0, 0, "3d81c5", new byte[]{49, 114, 68, 85, 76, 39, 52}));     // Catch: Exception -> L14
        r107.setAccessible(true);     // Catch: Exception -> L14
        if (r107.getBoolean(r105) == true) goto L9;
        Field r108 = r106.getDeclaredField((String) p2.a(MediaPlayer.MEDIA_INFO_DUMMY_PLAYER_SESSON_STOP, 0, 0, "e9fd31", new byte[]{117, 56, 1, 25, 26, 47, 114, 1}));     // Catch: Exception -> L14
        r108.setAccessible(true);     // Catch: Exception -> L14
        return (Activity) r108.get(r105);
    L22:
        return null;
    L14:
        String r109 = (String) p2.a(MediaPlayer.MEDIA_INFO_DUMMY_PLAYER_SESSON_STOP, 0, 0, "0eb2b2", new byte[]{32, 110, 46, 65});
        return null;
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

    public static void c(int r110) {
        HashMap r100 = f515226d;
        if (r100 != null) goto L5;
    L15:
        String r101 = null;
    L16:
        String r102 = r101;
        if (TextUtils.isEmpty(r102) == true) goto L25;
        p2.a(16777223, r110, System.currentTimeMillis(), r102, null);
        return;
    L25:
        return;
    L5:
        if (r100.size() <= 0) goto L15;
        Iterator r103 = r100.entrySet().iterator();
        r101 = "";
        int r104 = 0;
    L8:
        if (r103.hasNext() == false) goto L16;
        int r105 = ((MSManagerUtils.ScenePageNameCallback) ((Map.Entry) r103.next()).getValue()).getScenePageName();
        if (r105 == 0) goto L8;
        if (r104 <= 0) goto L14;
        r101 = r101 + ((String) p2.a(MediaPlayer.MEDIA_INFO_DUMMY_PLAYER_SESSON_STOP, 0, 0, "17b7f4", new byte[]{31}));
    L14:
        r101 = r101 + r105;
        r104 = r104 + 1;
        goto L8
    }
}
