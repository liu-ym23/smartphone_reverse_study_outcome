package zr3;

import android.text.TextUtils;
import com.bytedance.mira.exception.PluginClassNotFoundException;
import com.larus.mirabridge.impl.lancet.FastClassNotFoundHandler;
import com.larus.mirabridge.impl.lancet.MiraPluginFix;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.concurrent.ConcurrentHashMap;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: classes14.dex */
public final class c implements InvocationHandler {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Object f573409a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final b f573410b;

    public class a implements InvocationHandler {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Object f573411a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ c f573412b;

        public a(c r100, Object r101) {
            this.f573412b = r100;
            this.f573411a = r101;
        }

        @Override // java.lang.reflect.InvocationHandler
        public final Object invoke(Object r100, Method r101, Object[] r102) throws Throwable {
            this.f573412b.f573410b.e(r101, r102);     // Catch: Throwable -> L4
        L16:
            return r101.invoke(this.f573411a, r102);
        L8:
            th = move-exception;
            if ((th instanceof InvocationTargetException) == false) goto L15;
            Throwable r103 = th.getTargetException();
            if (r103 == null) goto L14;
            throw r103;
        L14:
            throw th;
        L15:
            throw th;
        L4:
            th = move-exception;
            th.getMessage();
            goto L16
        }
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

    public c(Object r100, b r101) {
        this.f573409a = r100;
        this.f573410b = r101;
    }

    @Override // java.lang.reflect.InvocationHandler
    public final Object invoke(Object r100, Method r101, Object[] r102) throws Throwable {
    L11:
        th = move-exception;
        th.getMessage();
    L14:
        return r101.invoke(this.f573409a, r102);
    L3:
        if ("getService".equals(r101.getName()) == false) goto L14;
        Object r103 = r101.invoke(this.f573409a, r102);     // Catch: Throwable -> L11
        Field r104 = r103.getClass().getDeclaredField("mService");     // Catch: Throwable -> L11
        r104.setAccessible(true);     // Catch: Throwable -> L11
        Object r105 = r104.get(r103);     // Catch: Throwable -> L11
        String r106 = r105.getClass().getName();     // Catch: Throwable -> L11
        if (TextUtils.isEmpty(r106) == false) goto L7;
    L10:
        return r103;
    L7:
        if (r106.startsWith(this.f573410b.g()) == false) goto L10;
        r104.set(r103, Proxy.newProxyInstance(r105.getClass().getClassLoader(), new Class[]{a(this.f573410b.g())}, new a(this, r105)));     // Catch: Throwable -> L11
        goto L10
    }
}
