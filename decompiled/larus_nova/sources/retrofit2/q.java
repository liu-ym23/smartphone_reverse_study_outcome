package retrofit2;

import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import com.bytedance.mira.exception.PluginClassNotFoundException;
import com.larus.mirabridge.impl.lancet.FastClassNotFoundHandler;
import com.larus.mirabridge.impl.lancet.MiraPluginFix;
import java.lang.invoke.MethodHandles;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Executor;
import javax.annotation.Nullable;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: classes.dex */
public class q {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final q f537548a = null;

    public static class a extends q {

        /* JADX INFO: renamed from: retrofit2.q$a$a, reason: collision with other inner class name */
        /* JADX INFO: loaded from: classes41.dex */
        public static class ExecutorC7475a implements Executor {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final Handler f537549a;

            public ExecutorC7475a() {
                this.f537549a = new Handler(Looper.getMainLooper());
            }

            @Override // java.util.concurrent.Executor
            public final void execute(Runnable r100) {
                this.f537549a.post(r100);
            }
        }

        @Override // retrofit2.q
        public final int c() {
            if (Build.VERSION.SDK_INT < 24) goto L5;
            return 2;
        L5:
            return 1;
        }

        @Override // retrofit2.q
        public final Executor d() {
            return new ExecutorC7475a();
        }

        @Override // retrofit2.q
        public final List<? extends g.a> e() {
            if (Build.VERSION.SDK_INT < 24) goto L6;
            return Collections.singletonList(m.f537520a);
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
        public final List<? extends CallAdapter.Factory> b(@Nullable Executor r100) {
            if (r100 == null) goto L9;
            i r101 = new i(r100);
            if (Build.VERSION.SDK_INT < 24) goto L7;
            return Arrays.asList(new CallAdapter.Factory[]{d.f537481a, r101});
        L7:
            return Collections.singletonList(r101);
        L9:
            throw new AssertionError();
        }

        @Override // retrofit2.q
        public final boolean h(Method r100) {
            if (Build.VERSION.SDK_INT >= 24) goto L7;
            return false;
        L7:
            return r100.isDefault();
        }
    }

    /* JADX INFO: loaded from: classes41.dex */
    public static class b extends q {
        @Override // retrofit2.q
        public final int c() {
            return 2;
        }

        @Override // retrofit2.q
        public final int f() {
            return 1;
        }

        @Override // retrofit2.q
        public final List<? extends g.a> e() {
            return Collections.singletonList(m.f537520a);
        }

        public b() {
        }

        @Override // retrofit2.q
        public final List<? extends CallAdapter.Factory> b(@Nullable Executor r100) {
            ArrayList r101 = new ArrayList(2);
            r101.add(d.f537481a);
            if (r100 == null) goto L5;
            r101.add(new i(r100));
        L7:
            return Collections.unmodifiableList(r101);
        L5:
            r101.add(h.f537486a);
            goto L7
        }

        @Override // retrofit2.q
        public final boolean h(Method r100) {
            return r100.isDefault();
        }

        @Override // retrofit2.q
        public final Object g(Method r100, Class<?> r101, Object r102, @Nullable Object... r110) throws Throwable {
            Constructor r103 = MethodHandles.Lookup.class.getDeclaredConstructor(new Class[]{Class.class, Integer.TYPE});
            r103.setAccessible(true);
            return ((MethodHandles.Lookup) r103.newInstance(new Object[]{r101, -1})).unreflectSpecial(r100, r101).bindTo(r102).invokeWithArguments(r110);
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

    public boolean h(Method r100) {
        return false;
    }

    static {
        a("android.os.Build");     // Catch: ClassNotFoundException -> L4
        q r100 = new a();     // Catch: ClassNotFoundException -> L4
    L7:
        f537548a = r100;
        return;
    L4:
        a("java.util.Optional");     // Catch: ClassNotFoundException -> L6
        r100 = new b();     // Catch: ClassNotFoundException -> L6
    L6:
        r100 = new q();
        goto L7
    }

    public List<? extends g.a> e() {
        return Collections.emptyList();
    }

    @Skip({"com.larus.mirabridge.impl.lancet+", "com.bytedance.mira.hook.delegate.DyMiraClassLoader", "com.bytedance.mira.hook.delegate.MiraClassLoader", "com.bytedance.ies.stark.util.NReflectUtils", "-com.bytedance.mira.core.PluginClassLoader", "com.bytedance.common.jato.util.DeviceInfoUtils", "com.bytedance.mira.helper.ClassLoaderHelper", "com.bytedance.mira.core.opt.res+"})
    public static void a(String r100) throws ClassNotFoundException {
        ConcurrentHashMap<String, FastClassNotFoundHandler.Status> r101 = FastClassNotFoundHandler.f359329a;
        FastClassNotFoundHandler.Status r102 = FastClassNotFoundHandler.Status.STATUS_NOTING;
        if (el9.a.a() == true) goto L34;
        Class.forName(r100);     // Catch: Throwable -> L8
        if (r102 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L36;
        FastClassNotFoundHandler.a(r100);     // Catch: Throwable -> L8
        return;
    L36:
        return;
    L8:
        th = move-exception;
        if (r102 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L12;
        FastClassNotFoundHandler.b(r100);
    L12:
        throw th;
    L34:
        Class.forName(r100);     // Catch: Throwable -> L17
        if (r102 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L37;
        FastClassNotFoundHandler.a(r100);     // Catch: Throwable -> L17
        return;
    L37:
        return;
    L17:
        th = move-exception;
        if (r102 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L22;
        FastClassNotFoundHandler.b(r100);
    L22:
        if ((th instanceof PluginClassNotFoundException) == false) goto L24;
        throw th;
    L24:
        if ((th instanceof ClassNotFoundException) == false) goto L26;
    L29:
        MiraPluginFix.forName(r100);
        return;
    L26:
        if ((th instanceof NoClassDefFoundError) == true) goto L29;
        throw th;
    }

    public List<? extends CallAdapter.Factory> b(@Nullable Executor r100) {
        if (r100 == null) goto L6;
        return Collections.singletonList(new i(r100));
    L6:
        return Collections.singletonList(h.f537486a);
    }

    @Nullable
    public Object g(Method r100, Class<?> r101, Object r102, @Nullable Object... r103) throws Throwable {
        throw new UnsupportedOperationException();
    }
}
