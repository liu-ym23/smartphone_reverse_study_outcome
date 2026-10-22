package f4;

import android.view.WindowManager;
import com.bytedance.mira.exception.PluginClassNotFoundException;
import com.google.gson.JsonObject;
import com.larus.mirabridge.impl.lancet.FastClassNotFoundHandler;
import com.larus.mirabridge.impl.lancet.MiraPluginFix;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Lazy;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: classes43.dex */
public final class w {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final w f475483a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Object f475484b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final r f475485c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static WindowManager f475486d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static Object f475487e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static Class<?> f475488f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static Boolean f475489g;

    public w() {
    }

    /* JADX WARN: Type inference failed for: r0v2, types: [f4.r] */
    static {
        f475483a = new w();
        f475484b = new Object();
        f475485c = new r();
    }

    @Skip({"com.larus.mirabridge.impl.lancet+", "com.bytedance.mira.hook.delegate.DyMiraClassLoader", "com.bytedance.mira.hook.delegate.MiraClassLoader", "com.bytedance.ies.stark.util.NReflectUtils", "-com.bytedance.mira.core.PluginClassLoader", "com.bytedance.common.jato.util.DeviceInfoUtils", "com.bytedance.mira.helper.ClassLoaderHelper", "com.bytedance.mira.core.opt.res+"})
    public static Class a() throws ClassNotFoundException {
        ConcurrentHashMap<String, FastClassNotFoundHandler.Status> r100 = FastClassNotFoundHandler.f359329a;
        FastClassNotFoundHandler.Status r101 = FastClassNotFoundHandler.Status.STATUS_NOTING;
        if (el9.a.a() == true) goto L34;
        Class<?> r102 = Class.forName("java.util.function.Consumer");     // Catch: Throwable -> L8
        if (r101 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L7;
        FastClassNotFoundHandler.a("java.util.function.Consumer");     // Catch: Throwable -> L8
    L7:
        return r102;
    L8:
        th = move-exception;
        if (r101 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L12;
        FastClassNotFoundHandler.b("java.util.function.Consumer");
    L12:
        throw th;
    L34:
        Class<?> r103 = Class.forName("java.util.function.Consumer");     // Catch: Throwable -> L17
        if (r101 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L16;
        FastClassNotFoundHandler.a("java.util.function.Consumer");     // Catch: Throwable -> L17
    L16:
        return r103;
    L17:
        th = move-exception;
        if (r101 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L22;
        FastClassNotFoundHandler.b("java.util.function.Consumer");
    L22:
        if ((th instanceof PluginClassNotFoundException) == false) goto L24;
        throw th;
    L24:
        if ((th instanceof ClassNotFoundException) == true) goto L30;
        if ((th instanceof NoClassDefFoundError) == true) goto L30;
        throw th;
    L30:
        return MiraPluginFix.forName("java.util.function.Consumer");
    }

    public static void c() {
        WindowManager r100 = f475486d;
        Object r101 = f475487e;
        Class<?> r102 = f475488f;
        if (r100 == null) goto L13;
        if (r101 == null) goto L13;
        if (r102 == null) goto L13;
        Result.Companion r103 = Result.Companion;     // Catch: Throwable -> L8
        Object r104 = Result.m9449constructorimpl(WindowManager.class.getMethod("removeScreenRecordingCallback", new Class[]{r102}).invoke(r100, new Object[]{r101}));     // Catch: Throwable -> L8
    L10:
        Throwable r105 = Result.m9452exceptionOrNullimpl(r104);
        if (r105 == null) goto L13;
        com.bytedance.ai.utils.g.f37637a.w("UserScreenRecordEventHelper", "unregister screen recording callback failed", r105);
    L8:
        th = move-exception;
        Result.Companion r106 = Result.Companion;
        r104 = Result.m9449constructorimpl(ResultKt.createFailure(th));
    L13:
        f475486d = null;
        f475487e = null;
        f475488f = null;
        f475489g = null;
    }

    public static void b(int r100, boolean r101) {
        Result.Companion r102 = Result.Companion;     // Catch: Throwable -> L4
        Object r103 = Result.m9449constructorimpl(Integer.valueOf(WindowManager.class.getField("SCREEN_RECORDING_STATE_VISIBLE").getInt(null)));     // Catch: Throwable -> L4
    L6:
        boolean r104 = true;
        if (Result.m9455isFailureimpl(r103) == false) goto L10;
        r103 = 1;
    L10:
        if (r100 != ((Number) r103).intValue()) goto L12;
        boolean r105 = true;
    L13:
        if (r105 == false) goto L15;
        String r106 = "start";
    L16:
        Object r107 = f475484b;
        monitor-enter(r107);
        Boolean r108 = f475489g;     // Catch: Throwable -> L32
        if (Intrinsics.areEqual(r108, Boolean.valueOf(r105)) == true) goto L26;
        f475489g = Boolean.valueOf(r105);     // Catch: Throwable -> L32
        if (r105 == true) goto L27;
        if (r108 != null) goto L27;
        if (r101 == false) goto L26;
    L27:
        monitor-exit(r107);
        if (r104 == true) goto L30;
        return;
    L30:
        Lazy r109 = l3.d.f507201a;
        JsonObject r110 = new JsonObject();
        r110.addProperty("state", r106);
        Unit r111 = Unit.INSTANCE;
        l3.d.c(new l3.a("doubao.onUserScreenRecord", r110, 4));
        return;
    L26:
        r104 = false;
    L32:
        th = move-exception;
        throw th;
    L15:
        r106 = "stop";
        goto L16
    L12:
        r105 = false;
    L4:
        th = move-exception;
        Result.Companion r112 = Result.Companion;
        r103 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L6
    }
}
