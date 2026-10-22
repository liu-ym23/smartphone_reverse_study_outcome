package ms.bd.c;

import android.app.Application;
import android.os.Handler;
import com.byted.cast.linkcommon.cybergarage.http.HTTP;
import com.bytedance.mira.exception.PluginClassNotFoundException;
import com.larus.apm.impl.protector.RunnableProtector;
import com.larus.mirabridge.impl.lancet.FastClassNotFoundHandler;
import com.larus.mirabridge.impl.lancet.MiraPluginFix;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import com.ss.android.ugc.bytex.pthread.base.proxy.PthreadHandlerThreadV2;
import com.ss.ttm.player.MediaPlayer;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.io.encoding.Base64;
import kotlin.jvm.internal.ByteCompanionObject;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: classes5.dex */
public final class m implements Runnable {
    public static void b() {
        if (n.f515229g.getAndSet(false) == false) goto L25;
        PthreadHandlerThreadV2 r100 = n.f515228f;     // Catch: Exception -> L15
        ThreadMethodProxy.start(r100);     // Catch: Exception -> L15
        n.f515230h = new Handler(r100.getLooper());     // Catch: Exception -> L15
    L21:
        Application r101 = null;
        Application r102 = (Application) a((String) p2.a(MediaPlayer.MEDIA_INFO_DUMMY_PLAYER_SESSON_STOP, 0, 0, "b13686", new byte[]{114, Base64.padSymbol, 68, 80, 8, 40, 101, 94, 99, 118, 99, 125, 97, 65, 19, 40, 119, 25, 118, ByteCompanionObject.MAX_VALUE, 71, 59, 82, 71, 6, 37})).getMethod((String) p2.a(MediaPlayer.MEDIA_INFO_DUMMY_PLAYER_SESSON_STOP, 0, 0, "b7437f", new byte[]{112, 32, 85, 85, HTTP.CR, ByteCompanionObject.MAX_VALUE, 117, 55, 117, 115, ByteCompanionObject.MAX_VALUE, 60, 68, 70, 28, 120, 110, 24}), null).invoke(null, null);     // Catch: Throwable -> L16
    L17:
        r102.registerActivityLifecycleCallbacks(new l());     // Catch: Throwable -> L14
        return;
    L26:
        return;
    L11:
        r102 = r101;
    L10:
        r101 = null;
        goto L11
    }

    @Override // java.lang.Runnable
    public final void run() {
        b();     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }

    public m() {
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
