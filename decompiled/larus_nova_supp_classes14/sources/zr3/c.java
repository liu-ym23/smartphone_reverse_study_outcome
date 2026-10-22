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

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class c implements InvocationHandler {
    public final Object a;
    public final b b;

    public class a implements InvocationHandler {
        public final /* synthetic */ Object a;
        public final /* synthetic */ c b;

        public a(c r1, Object r2) {
            this.b = r1;
            this.a = r2;
        }

        @Override // java.lang.reflect.InvocationHandler
        public final Object invoke(Object r2, Method r3, Object[] r4) throws Throwable {
            this.b.b.e(r3, r4);     // Catch: Throwable -> L4
        L16:
            return r3.invoke(this.a, r4);
        L8:
            th = move-exception;
            if ((th instanceof InvocationTargetException) == false) goto L15;
            Throwable r5 = th.getTargetException();
            if (r5 == null) goto L14;
            throw r5;
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
    public static Class a(String r3) throws ClassNotFoundException {
        ConcurrentHashMap r0 = FastClassNotFoundHandler.a;
        FastClassNotFoundHandler.Status r1 = FastClassNotFoundHandler.Status.STATUS_NOTING;
        if (el9.a.a() == true) goto L34;
        Class<?> r2 = Class.forName(r3);     // Catch: Throwable -> L8
        if (r1 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L7;
        FastClassNotFoundHandler.a(r3);     // Catch: Throwable -> L8
    L7:
        return r2;
    L8:
        th = move-exception;
        if (r1 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L12;
        FastClassNotFoundHandler.b(r3);
    L12:
        throw th;
    L34:
        Class<?> r4 = Class.forName(r3);     // Catch: Throwable -> L17
        if (r1 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L16;
        FastClassNotFoundHandler.a(r3);     // Catch: Throwable -> L17
    L16:
        return r4;
    L17:
        th = move-exception;
        if (r1 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L22;
        FastClassNotFoundHandler.b(r3);
    L22:
        if ((th instanceof PluginClassNotFoundException) == false) goto L24;
        throw th;
    L24:
        if ((th instanceof ClassNotFoundException) == true) goto L30;
        if ((th instanceof NoClassDefFoundError) == true) goto L30;
        throw th;
    L30:
        return MiraPluginFix.forName(r3);
    }

    public c(Object r1, b r2) {
        this.a = r1;
        this.b = r2;
    }

    @Override // java.lang.reflect.InvocationHandler
    public final Object invoke(Object r7, Method r8, Object[] r9) throws Throwable {
    L11:
        th = move-exception;
        th.getMessage();
    L14:
        return r8.invoke(this.a, r9);
    L3:
        if ("getService".equals(r8.getName()) == false) goto L14;
        Object r10 = r8.invoke(this.a, r9);     // Catch: Throwable -> L11
        Field r0 = r10.getClass().getDeclaredField("mService");     // Catch: Throwable -> L11
        r0.setAccessible(true);     // Catch: Throwable -> L11
        Object r2 = r0.get(r10);     // Catch: Throwable -> L11
        String r3 = r2.getClass().getName();     // Catch: Throwable -> L11
        if (TextUtils.isEmpty(r3) == false) goto L7;
    L10:
        return r10;
    L7:
        if (r3.startsWith(this.b.g()) == false) goto L10;
        r0.set(r10, Proxy.newProxyInstance(r2.getClass().getClassLoader(), new Class[]{a(this.b.g())}, new a(this, r2)));     // Catch: Throwable -> L11
        goto L10
    }
}
