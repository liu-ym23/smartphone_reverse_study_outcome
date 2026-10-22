package kta;

import android.content.Context;
import com.bytedance.mira.exception.PluginClassNotFoundException;
import com.larus.mirabridge.impl.lancet.FastClassNotFoundHandler;
import com.larus.mirabridge.impl.lancet.MiraPluginFix;
import java.lang.reflect.Method;
import java.util.concurrent.ConcurrentHashMap;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: classes6.dex */
public final class x implements o {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Object f506163a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Class<?> f506164b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final Method f506165c = null;

    @Skip({"com.larus.mirabridge.impl.lancet+", "com.bytedance.mira.hook.delegate.DyMiraClassLoader", "com.bytedance.mira.hook.delegate.MiraClassLoader", "com.bytedance.ies.stark.util.NReflectUtils", "-com.bytedance.mira.core.PluginClassLoader", "com.bytedance.common.jato.util.DeviceInfoUtils", "com.bytedance.mira.helper.ClassLoaderHelper", "com.bytedance.mira.core.opt.res+"})
    public static Class b() throws ClassNotFoundException {
        ConcurrentHashMap<String, FastClassNotFoundHandler.Status> r100 = FastClassNotFoundHandler.f359329a;
        FastClassNotFoundHandler.Status r101 = FastClassNotFoundHandler.Status.STATUS_NOTING;
        if (el9.a.a() == true) goto L34;
        Class<?> r102 = Class.forName("com.android.id.impl.IdProviderImpl");     // Catch: Throwable -> L8
        if (r101 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L7;
        FastClassNotFoundHandler.a("com.android.id.impl.IdProviderImpl");     // Catch: Throwable -> L8
    L7:
        return r102;
    L8:
        th = move-exception;
        if (r101 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L12;
        FastClassNotFoundHandler.b("com.android.id.impl.IdProviderImpl");
    L12:
        throw th;
    L34:
        Class<?> r103 = Class.forName("com.android.id.impl.IdProviderImpl");     // Catch: Throwable -> L17
        if (r101 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L16;
        FastClassNotFoundHandler.a("com.android.id.impl.IdProviderImpl");     // Catch: Throwable -> L17
    L16:
        return r103;
    L17:
        th = move-exception;
        if (r101 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L22;
        FastClassNotFoundHandler.b("com.android.id.impl.IdProviderImpl");
    L22:
        if ((th instanceof PluginClassNotFoundException) == false) goto L24;
        throw th;
    L24:
        if ((th instanceof ClassNotFoundException) == true) goto L30;
        if ((th instanceof NoClassDefFoundError) == true) goto L30;
        throw th;
    L30:
        return MiraPluginFix.forName("com.android.id.impl.IdProviderImpl");
    }

    static {
        Class<?> r100 = b();     // Catch: Exception -> L4
        f506164b = r100;     // Catch: Exception -> L4
        f506163a = r100.newInstance();     // Catch: Exception -> L4
        f506165c = r100.getMethod("getOAID", new Class[]{Context.class});     // Catch: Exception -> L4
        return;
    L4:
        e = move-exception;
        e.getMessage();
    }

    public x() {
    }

    @Override // kta.o
    public final boolean a(Context r100) {
        if (f506164b != null) goto L5;
    L9:
        return false;
    L5:
        if (f506163a == null) goto L9;
        if (f506165c == null) goto L9;
        return true;
    }

    @Override // kta.o
    public final o.a getOaid(Context r100) {
        o.a r101 = new o.a();     // Catch: Exception -> L14
        Method r102 = f506165c;     // Catch: Exception -> L14
        Object r103 = f506163a;     // Catch: Exception -> L14
        if (r103 == null) goto L11;
        if (r102 == null) goto L11;
        Object r104 = r102.invoke(r103, new Object[]{r100});     // Catch: Exception -> L17
        if (r104 == null) goto L11;
        String r105 = (String) r104;     // Catch: Exception -> L17
    L12:
        r101.f506112a = r105;     // Catch: Exception -> L14
        return r101;
    L11:
        r105 = null;
    L14:
        e = move-exception;
        e.printStackTrace();
        return null;
    }
}
