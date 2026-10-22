package t6;

import com.bytedance.android.ad.sdk.spi.ReflectServiceFactory;
import com.bytedance.mira.exception.PluginClassNotFoundException;
import com.larus.mirabridge.impl.lancet.FastClassNotFoundHandler;
import com.larus.mirabridge.impl.lancet.MiraPluginFix;
import java.util.Objects;
import java.util.concurrent.ConcurrentHashMap;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: classes43.dex */
public class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ConcurrentHashMap<Class<?>, d<?>> f544653a;

    public static final class a {
    }

    static {
    }

    public b() {
        this.f544653a = new ConcurrentHashMap();
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

    public <T> T b(Class<T> r100, Object r101) {
        d<?> r102 = this.f544653a.get(r100);
        if (r102 == null) goto L5;
        Object r103 = r102.create();
    L7:
        if (r100.isInstance(r103) == false) goto L10;
        return r100.cast(r103);
    L10:
        if (r100.isAnnotationPresent(ReflectServiceFactory.class) == false) goto L31;
        ReflectServiceFactory r104 = (ReflectServiceFactory) r100.getAnnotation(ReflectServiceFactory.class);
        if (r104 != null) goto L14;
        return null;
    L14:
        if (r104.implClassName().length() <= 0) goto L16;
        boolean r105 = true;
    L17:
        if (r105 == false) goto L33;
        T r106 = r100.cast(a(r104.implClassName()).newInstance());     // Catch: Throwable -> L26
        if (r106 != null) goto L21;
        return null;
    L21:
        if (r104.singleton() == false) goto L35;
        c r107 = new c(r106);     // Catch: Throwable -> L26
        if (this.f544653a.containsKey(r100) == true) goto L35;
        this.f544653a.put(r100, r107);     // Catch: Throwable -> L26
    L35:
        return r106;
    L26:
        Objects.toString(r100);
        return null;
    L33:
        return null;
    L16:
        r105 = false;
        goto L17
    L31:
        return null;
    L5:
        r103 = null;
        goto L7
    }
}
