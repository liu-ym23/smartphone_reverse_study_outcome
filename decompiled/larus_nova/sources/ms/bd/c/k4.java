package ms.bd.c;

import android.content.Context;
import com.bytedance.mira.exception.PluginClassNotFoundException;
import com.larus.mirabridge.impl.lancet.FastClassNotFoundHandler;
import com.larus.mirabridge.impl.lancet.MiraPluginFix;
import com.ss.ttm.player.MediaPlayer;
import java.lang.reflect.Method;
import java.util.concurrent.ConcurrentHashMap;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: classes42.dex */
public final class k4 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Class f515186a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Object f515187b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Method f515188c;

    public k4() {
        int r110 = 1;
        Class r100 = a((String) p2.a(MediaPlayer.MEDIA_INFO_DUMMY_PLAYER_SESSON_STOP, 0, 0, "e710f7", new byte[]{119, 58, 79, 10, 88, 46, 98, 4, 111, 105, 112, 123, 75, 64, 23, 41, 107, 6, 108, 46, 93, 49, 114, 86, 86, 54, 111, 18, 101, 114, 93, 56, 82, 72}));     // Catch: Exception -> L10
        this.f515186a = r100;     // Catch: Exception -> L10
        this.f515187b = r100.newInstance();     // Catch: Exception -> L10
    L16:
        Class r101 = this.f515186a;     // Catch: Exception -> L11
        byte[] r102 = new byte[7];     // Catch: Exception -> L11
        r102[0] = 38;     // Catch: Exception -> L11
        r102[r110] = 48;     // Catch: Exception -> L11
        r102[2] = 80;     // Catch: Exception -> L11
        r102[3] = 98;     // Catch: Exception -> L11
        r102[4] = 47;     // Catch: Exception -> L11
        r102[5] = 8;     // Catch: Exception -> L11
        r102[6] = 23;     // Catch: Exception -> L11
        String r103 = (String) p2.a(MediaPlayer.MEDIA_INFO_DUMMY_PLAYER_SESSON_STOP, 0, 0, "077916", r102);     // Catch: Exception -> L11
        Class<?>[] r104 = new Class[r110];     // Catch: Exception -> L11
        r104[0] = Context.class;     // Catch: Exception -> L11
        this.f515188c = r101.getMethod(r103, r104);     // Catch: Exception -> L11
        return;
    L18:
        return;
    L7:
        r110 = 1;
        goto L16
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
