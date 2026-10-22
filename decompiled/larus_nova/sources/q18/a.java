package q18;

import com.byted.cast.linkcommon.cybergarage.http.HTTP;
import com.bytedance.mira.exception.PluginClassNotFoundException;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larus.mirabridge.impl.lancet.FastClassNotFoundHandler;
import com.larus.mirabridge.impl.lancet.MiraPluginFix;
import i18.d;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: classes24.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List<String> f531310a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Map<Class<? extends d>, Map<String, us5.b>> f531311b;

    /* JADX INFO: renamed from: q18.a$a, reason: collision with other inner class name */
    public static class C7269a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final a f531312a = null;

        static {
            f531312a = new a();
        }
    }

    public a() {
        this.f531310a = new ArrayList();
        this.f531311b = new ConcurrentHashMap();
        int r100 = 0;
    L4:
        if (r100 >= ((ArrayList) this.f531310a).size()) goto L11;
        String r101 = ((String) ListProtector.get(this.f531310a, r100)).replace(HTTP.URL_DEFAULT, ".");
        b(((vs5.a) a(r101.substring(0, r101.indexOf(".class"))).newInstance()).a());     // Catch: Exception -> L8
    L10:
        r100 = r100 + 1;
    L8:
        e = move-exception;
        e.printStackTrace();
        goto L10
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

    public final void b(Map<Class, us5.a> r100) {
        Iterator<Map.Entry<Class, us5.a>> r101 = r100.entrySet().iterator();
    L4:
        if (r101.hasNext() == false) goto L13;
        Map.Entry<Class, us5.a> r102 = r101.next();
        if (this.f531311b.get(r102.getKey()) != null) goto L8;
        new HashMap();
    L8:
        us5.a r103 = r102.getValue();
        if (r103 == null) goto L4;
        monitor-enter(r103);
        monitor-exit(r103);
        goto L4
    }
}
