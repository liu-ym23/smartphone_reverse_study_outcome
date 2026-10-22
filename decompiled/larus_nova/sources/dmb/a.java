package dmb;

import com.bytedance.mira.exception.PluginClassNotFoundException;
import com.larus.mirabridge.impl.lancet.FastClassNotFoundHandler;
import com.larus.mirabridge.impl.lancet.MiraPluginFix;
import com.ss.android.lark.abtest.api.IABTestService;
import com.ss.android.lark.utils.ApiUtils;
import java.util.concurrent.ConcurrentHashMap;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: classes36.dex */
public final class a implements xm4.a.InterfaceC8255a {
    public a() {
    }

    @Skip({"com.larus.mirabridge.impl.lancet+", "com.bytedance.mira.hook.delegate.DyMiraClassLoader", "com.bytedance.mira.hook.delegate.MiraClassLoader", "com.bytedance.ies.stark.util.NReflectUtils", "-com.bytedance.mira.core.PluginClassLoader", "com.bytedance.common.jato.util.DeviceInfoUtils", "com.bytedance.mira.helper.ClassLoaderHelper", "com.bytedance.mira.core.opt.res+"})
    public static Class c(String r100) throws ClassNotFoundException {
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

    public static Object d(String r100) {
        Class<? extends iua.a> r101 = c(r100);     // Catch: ClassNotFoundException -> L9
        if (iua.a.class.isAssignableFrom(r101) == false) goto L7;
        Object r102 = ((IABTestService) ApiUtils.getApi(IABTestService.class)).getAbTestValue(r101, true);     // Catch: ClassNotFoundException -> L9
        tt5.a.h("DocABTest", "getABTestValue<" + r101 + ">: " + r102);     // Catch: ClassNotFoundException -> L9
        return r102;
    L7:
        tt5.a.d("DocABTest", "error: Class<" + r100 + "> doesn't inherit from class<LarkExperimentConfig>.");     // Catch: ClassNotFoundException -> L9
        return null;
    L9:
        tt5.a.d("DocABTest", "error: Class< " + r100 + "> not found.");
        return null;
    }

    @Override // xm4.a
    public final Boolean a(String r100) {
        Object r101 = d(r100);
        if ((r101 instanceof Boolean) == true) goto L5;
        return null;
    L5:
        return (Boolean) r101;
    }

    @Override // xm4.a
    public final String b(String r100) {
        Object r101 = d(r100);
        if ((r101 instanceof String) == true) goto L5;
        return null;
    L5:
        return (String) r101;
    }
}
