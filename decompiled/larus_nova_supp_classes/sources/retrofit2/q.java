package retrofit2;

import android.os.Build;
import com.bytedance.mira.exception.PluginClassNotFoundException;
import com.larus.mirabridge.impl.lancet.FastClassNotFoundHandler;
import com.larus.mirabridge.impl.lancet.MiraPluginFix;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Executor;
import javax.annotation.Nullable;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes.dex */
public class q {
    public static final q a = null;

    public static class a extends q {
        @Override // retrofit2.q
        public final int c() {
            if (Build.VERSION.SDK_INT < 24) goto L5;
            return 2;
        L5:
            return 1;
        }

        @Override // retrofit2.q
        public final Executor d() {
            return new a();
        }

        @Override // retrofit2.q
        public final List<? extends g.a> e() {
            if (Build.VERSION.SDK_INT < 24) goto L6;
            return Collections.singletonList(m.a);
        L6:
            return Collections.emptyList();
        }

        @Override // retrofit2.q
        public final int f() {
            if (Build.VERSION.SDK_INT < 24) goto L5;
            return 1;
        L5:
            return 0;
        }

        public a() {
        }

        @Override // retrofit2.q
        public final List<? extends CallAdapter.Factory> b(@Nullable Executor r4) {
            if (r4 == null) goto L9;
            CallAdapter.Factory r0 = new i(r4);
            if (Build.VERSION.SDK_INT < 24) goto L7;
            return Arrays.asList(new CallAdapter.Factory[]{d.a, r0});
        L7:
            return Collections.singletonList(r0);
        L9:
            throw new AssertionError();
        }

        @Override // retrofit2.q
        public final boolean h(Method r3) {
            if (Build.VERSION.SDK_INT >= 24) goto L7;
            return false;
        L7:
            return r3.isDefault();
        }
    }

    public q() {
    }

    public int c() {
        return 1;
    }

    @Nullable
    public Executor d() {
        return null;
    }

    public int f() {
        return 0;
    }

    public boolean h(Method r1) {
        return false;
    }

    static {
        a("android.os.Build");     // Catch: ClassNotFoundException -> L4
        q r0 = new a();     // Catch: ClassNotFoundException -> L4
    L7:
        a = r0;
        return;
    L4:
        a("java.util.Optional");     // Catch: ClassNotFoundException -> L6
        r0 = new b();     // Catch: ClassNotFoundException -> L6
    L6:
        r0 = new q();
        goto L7
    }

    public List<? extends g.a> e() {
        return Collections.emptyList();
    }

    @Skip({"com.larus.mirabridge.impl.lancet+", "com.bytedance.mira.hook.delegate.DyMiraClassLoader", "com.bytedance.mira.hook.delegate.MiraClassLoader", "com.bytedance.ies.stark.util.NReflectUtils", "-com.bytedance.mira.core.PluginClassLoader", "com.bytedance.common.jato.util.DeviceInfoUtils", "com.bytedance.mira.helper.ClassLoaderHelper", "com.bytedance.mira.core.opt.res+"})
    public static void a(String r3) throws ClassNotFoundException {
        ConcurrentHashMap<String, FastClassNotFoundHandler.Status> r0 = FastClassNotFoundHandler.a;
        FastClassNotFoundHandler.Status r1 = FastClassNotFoundHandler.Status.STATUS_NOTING;
        if (el9.a.a() == true) goto L34;
        Class.forName(r3);     // Catch: Throwable -> L8
        if (r1 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L36;
        FastClassNotFoundHandler.a(r3);     // Catch: Throwable -> L8
        return;
    L36:
        return;
    L8:
        th = move-exception;
        if (r1 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L12;
        FastClassNotFoundHandler.b(r3);
    L12:
        throw th;
    L34:
        Class.forName(r3);     // Catch: Throwable -> L17
        if (r1 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L37;
        FastClassNotFoundHandler.a(r3);     // Catch: Throwable -> L17
        return;
    L37:
        return;
    L17:
        th = move-exception;
        if (r1 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L22;
        FastClassNotFoundHandler.b(r3);
    L22:
        if ((th instanceof PluginClassNotFoundException) == false) goto L24;
        throw th;
    L24:
        if ((th instanceof ClassNotFoundException) == false) goto L26;
    L29:
        MiraPluginFix.forName(r3);
        return;
    L26:
        if ((th instanceof NoClassDefFoundError) == true) goto L29;
        throw th;
    }

    public List<? extends CallAdapter.Factory> b(@Nullable Executor r2) {
        if (r2 == null) goto L6;
        return Collections.singletonList(new i(r2));
    L6:
        return Collections.singletonList(h.a);
    }

    @Nullable
    public Object g(Method r1, Class<?> r2, Object r3, @Nullable Object... r4) throws Throwable {
        throw new UnsupportedOperationException();
    }
}
