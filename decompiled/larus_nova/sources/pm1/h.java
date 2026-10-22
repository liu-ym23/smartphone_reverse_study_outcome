package pm1;

import com.bytedance.android.scope.l;
import com.bytedance.android.scope.m;
import com.bytedance.mira.exception.PluginClassNotFoundException;
import com.larus.mirabridge.impl.lancet.FastClassNotFoundHandler;
import com.larus.mirabridge.impl.lancet.MiraPluginFix;
import e33.k;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: classes7.dex */
public final class h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static volatile boolean f529819a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Object f529820b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static mm1.b f529821c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final h f529822d = null;

    public h() {
    }

    public final synchronized void d() {
        monitor-enter(this);
    L17:
        th = move-exception;
        throw th;
    L4:
        if (f529819a == false) goto L20;
    L15:
        monitor-exit(this);
        return;
    L20:
        int r100 = jc1.e.f498076a;     // Catch: Throwable -> L11
        a("com.bytedance.android.livesdk.chatroom.replay.base.VSFlexModelInitializer").newInstance();     // Catch: Throwable -> L11
        a("com.bytedance.android.livesdk.chatroom.vs_host.VSHostScopeInitializer").newInstance();     // Catch: Throwable -> L11
        a("com.bytedance.android.livesdk.chatroom.replay.base.VSScopeInitializer").newInstance();     // Catch: Throwable -> L11
    L22:
        a("com.bytedance.android.livesdk.chatroom.vs.VSMainScopeInitializer").newInstance();     // Catch: Throwable -> L8
    L10:
        f529819a = true;     // Catch: Throwable -> L17
        goto L15
    L8:
        th = move-exception;
        th.printStackTrace();     // Catch: Throwable -> L17
    L11:
        th = move-exception;
        th.printStackTrace();     // Catch: Throwable -> L17
    }

    static {
        f529822d = new h();
        f529820b = new Object();
    }

    public final mm1.a b() {
        d();
        if (f529821c != null) goto L15;
        Object r100 = f529820b;
        monitor-enter(r100);
    L12:
        th = move-exception;
        throw th;
    L7:
        if (f529821c != null) goto L9;
        m.f163449e.getClass();     // Catch: Throwable -> L12
        mm1.b r101 = new mm1.b(m.f163448d);     // Catch: Throwable -> L12
        Intrinsics.checkNotNullParameter(r101, "scope");     // Catch: Throwable -> L12
        Object r102 = k.f470908a;     // Catch: Throwable -> L12
        l.a(r101);     // Catch: Throwable -> L12
        f529821c = r101;     // Catch: Throwable -> L12
    L9:
        Unit r103 = Unit.INSTANCE;     // Catch: Throwable -> L12
        monitor-exit(r100);
    L15:
        mm1.b r104 = f529821c;
        Intrinsics.checkNotNull(r104);
        return r104;
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

    public final <T> T c(Class<?> r100) {
        Intrinsics.checkNotNullParameter(r100, "clazz");
        T r101 = (T) m.f163449e.d(b(), r100);
        if ((r101 instanceof Object) == true) goto L6;
        return null;
    L6:
        return r101;
    }
}
