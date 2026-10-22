package iaa;

import com.bytedance.mira.exception.PluginClassNotFoundException;
import com.larus.mirabridge.impl.lancet.FastClassNotFoundHandler;
import com.larus.mirabridge.impl.lancet.MiraPluginFix;
import com.ss.android.socialbase.downloader.constants.MonitorConstants;
import com.ss.android.ugc.effectmanager.effect.model.ComposerHelper;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Iterator;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.jvm.internal.ArrayIteratorKt;
import kotlin.jvm.internal.Intrinsics;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: classes.dex */
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Method f488967a = null;

    static {
        Iterator r100 = ArrayIteratorKt.iterator(a().getMethods());     // Catch: ClassNotFoundException -> L19
    L4:
        if (r100.hasNext() == false) goto L38;
        Method r101 = (Method) r100.next();     // Catch: ClassNotFoundException -> L19
        String r102 = r101.getName();     // Catch: ClassNotFoundException -> L19
        if (r102 == null) goto L4;
        switch(r102.hashCode()) {
            case -1249359687: goto L16;
            case -75354382: goto L15;
            case 102230: goto L13;
            case 113762: goto L11;
            default: goto L4;
        };     // Catch: ClassNotFoundException -> L19
    L11:
        String r103 = "set";
    L17:
        r102.equals(r103);     // Catch: ClassNotFoundException -> L19
        goto L4
    L13:
        if (r102.equals(MonitorConstants.CONNECT_TYPE_GET) == false) goto L4;
        f488967a = r101;     // Catch: ClassNotFoundException -> L19
        goto L4
    L15:
        r103 = "getLong";
        goto L17
    L16:
        r103 = "getInt";
        goto L17
    L38:
        return;
    L19:
        e = move-exception;
        e.printStackTrace();
    }

    @Skip({"com.larus.mirabridge.impl.lancet+", "com.bytedance.mira.hook.delegate.DyMiraClassLoader", "com.bytedance.mira.hook.delegate.MiraClassLoader", "com.bytedance.ies.stark.util.NReflectUtils", "-com.bytedance.mira.core.PluginClassLoader", "com.bytedance.common.jato.util.DeviceInfoUtils", "com.bytedance.mira.helper.ClassLoaderHelper", "com.bytedance.mira.core.opt.res+"})
    public static Class a() throws ClassNotFoundException {
        ConcurrentHashMap<String, FastClassNotFoundHandler.Status> r100 = FastClassNotFoundHandler.f359329a;
        FastClassNotFoundHandler.Status r101 = FastClassNotFoundHandler.Status.STATUS_NOTING;
        if (el9.a.a() == true) goto L34;
        Class<?> r102 = Class.forName("android.os.SystemProperties");     // Catch: Throwable -> L8
        if (r101 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L7;
        FastClassNotFoundHandler.a("android.os.SystemProperties");     // Catch: Throwable -> L8
    L7:
        return r102;
    L8:
        th = move-exception;
        if (r101 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L12;
        FastClassNotFoundHandler.b("android.os.SystemProperties");
    L12:
        throw th;
    L34:
        Class<?> r103 = Class.forName("android.os.SystemProperties");     // Catch: Throwable -> L17
        if (r101 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L16;
        FastClassNotFoundHandler.a("android.os.SystemProperties");     // Catch: Throwable -> L17
    L16:
        return r103;
    L17:
        th = move-exception;
        if (r101 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L22;
        FastClassNotFoundHandler.b("android.os.SystemProperties");
    L22:
        if ((th instanceof PluginClassNotFoundException) == false) goto L24;
        throw th;
    L24:
        if ((th instanceof ClassNotFoundException) == true) goto L30;
        if ((th instanceof NoClassDefFoundError) == true) goto L30;
        throw th;
    L30:
        return MiraPluginFix.forName("android.os.SystemProperties");
    }

    public static String b(String r100, String r101) {
        Intrinsics.checkNotNullParameter(r101, ComposerHelper.COMPOSER_DEFAULT_VALUE);
        Method r102 = f488967a;
        if (r102 != null) goto L18;
        return r101;
    L18:
        Object r103 = r102.invoke(null, new Object[]{r100, r101});     // Catch: InvocationTargetException -> L8 IllegalAccessException -> L10 IllegalArgumentException -> L12
        Intrinsics.checkNotNull(r103, "null cannot be cast to non-null type kotlin.String");     // Catch: InvocationTargetException -> L8 IllegalAccessException -> L10 IllegalArgumentException -> L12
        return (String) r103;
    L10:
        e = move-exception;
        e.printStackTrace();
    L17:
        return r101;
    L12:
        e = move-exception;
        e.printStackTrace();
    L8:
        e = move-exception;
        e.printStackTrace();
        goto L17
    }
}
