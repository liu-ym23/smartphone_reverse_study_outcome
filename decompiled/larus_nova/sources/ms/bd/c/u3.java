package ms.bd.c;

import android.app.Application;
import android.content.Context;
import android.hardware.display.DisplayManager;
import com.bytedance.mira.exception.PluginClassNotFoundException;
import com.larus.mirabridge.impl.lancet.FastClassNotFoundHandler;
import com.larus.mirabridge.impl.lancet.MiraPluginFix;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import com.ss.android.ugc.bytex.pthread.base.proxy.PthreadHandlerThreadV2;
import com.ss.android.ugc.bytex.pthread.base.proxy.PthreadThreadV2;
import com.ss.ttm.player.MediaPlayer;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.io.encoding.Base64;
import kotlin.jvm.internal.ByteCompanionObject;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: classes5.dex */
public final class u3 {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static volatile u3 f515379f;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final PthreadHandlerThreadV2 f515380a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Context f515381b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f515382c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public DisplayManager f515383d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public e0 f515384e;

    public final synchronized void b() {
        monitor-enter(this);
    L11:
        th = move-exception;
        throw th;
    L4:
        if (this.f515382c == false) goto L8;
        monitor-exit(this);
        return;
    L8:
        this.f515382c = true;     // Catch: Throwable -> L11
        ThreadMethodProxy.start(new PthreadThreadV2(new t3(this), "ms/bd/c/u3"));     // Catch: Throwable -> L11
        monitor-exit(this);
    }

    public final void finalize() {
        monitor-enter(this);
        DisplayManager r100 = this.f515383d;     // Catch: Throwable -> L17
        if (r100 == null) goto L21;
        e0 r101 = this.f515384e;     // Catch: Throwable -> L17
        if (r101 == null) goto L21;
        r100.unregisterDisplayListener(r101);     // Catch: Throwable -> L17
    L21:
        PthreadHandlerThreadV2 r102 = this.f515380a;     // Catch: Throwable -> L14
        if (r102 != null) goto L19;
    L11:
        monitor-exit(this);
        super.finalize();
        return;
    L19:
        r102.quitSafely();     // Catch: Throwable -> L18
    L14:
        th = move-exception;
        throw th;
    }

    public u3(Context r310) {
        this.f515382c = false;
        Context r100 = r310.getApplicationContext();
        this.f515381b = r100;
        if ((r100 instanceof Application) == false) goto L17;
    L14:
        this.f515380a = new PthreadHandlerThreadV2((String) p2.a(MediaPlayer.MEDIA_INFO_DUMMY_PLAYER_SESSON_STOP, 0, 0, "a1e5d9", new byte[]{93, 0, 37, 115}));
        return;
    L17:
        Context r101 = null;
        r101 = (Application) a((String) p2.a(MediaPlayer.MEDIA_INFO_DUMMY_PLAYER_SESSON_STOP, 0, 0, "47a00e", new byte[]{36, 59, 22, 86, 0, 123, 51, 88, 49, 112, 53, 123, 51, 71, 27, 123, 33, 31, 36, 121, 17, Base64.padSymbol, 0, 65, 14, 118})).getMethod((String) p2.a(MediaPlayer.MEDIA_INFO_DUMMY_PLAYER_SESSON_STOP, 0, 0, "23394a", new byte[]{32, 36, 82, 95, 14, 120, 37, 51, 114, 121, 47, 56, 67, 76, 31, ByteCompanionObject.MAX_VALUE, 62, 28}), null).invoke(null, null);     // Catch: Throwable -> L16
    L11:
        if (r101 != null) goto L13;
        r101 = this.f515381b;
    L13:
        this.f515381b = r101;
    L9:
        r101 = null;
        goto L11
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
