package com.bytedance.retrofit2;

import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import com.bytedance.mira.exception.PluginClassNotFoundException;
import com.larus.mirabridge.impl.lancet.FastClassNotFoundHandler;
import com.larus.mirabridge.impl.lancet.MiraPluginFix;
import el9.a;
import java.lang.reflect.Method;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Executor;
import javax.annotation.Nullable;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: classes3.dex */
class Platform {
    private static final Platform PLATFORM = null;
    private static final boolean SQUARE_RETROFIT_EXISTS = false;

    public static class Android extends Platform {

        public static class MainThreadExecutor implements Executor {
            private final Handler handler;

            public MainThreadExecutor() {
                this.handler = new Handler(Looper.getMainLooper());
            }

            @Override // java.util.concurrent.Executor
            public void execute(Runnable r100) {
                this.handler.post(r100);
            }
        }

        @Override // com.bytedance.retrofit2.Platform
        public int defaultCallAdapterFactoriesSize() {
            return 1;
        }

        @Override // com.bytedance.retrofit2.Platform
        public int defaultConverterFactoriesSize() {
            return 0;
        }

        @Override // com.bytedance.retrofit2.Platform
        public Executor defaultCallbackExecutor() {
            return new MainThreadExecutor();
        }

        @Override // com.bytedance.retrofit2.Platform
        public List<? extends Converter.Factory> defaultConverterFactories() {
            return Collections.emptyList();
        }

        public Android() {
        }

        @Override // com.bytedance.retrofit2.Platform
        public List<? extends CallAdapter.Factory> defaultCallAdapterFactories(@Nullable Executor r100) {
            if (r100 == null) goto L6;
            return Collections.singletonList(new ExecutorCallAdapterFactory(r100));
        L6:
            throw new AssertionError();
        }

        @Override // com.bytedance.retrofit2.Platform
        public boolean isDefaultMethod(Method r100) {
            if (Build.VERSION.SDK_INT >= 24) goto L7;
            return false;
        L7:
            return r100.isDefault();
        }
    }

    public Platform() {
    }

    public static /* synthetic */ Class access$000(String r100) throws ClassNotFoundException {
        return Class.forName(r100);
    }

    public int defaultCallAdapterFactoriesSize() {
        return 1;
    }

    @Nullable
    public Executor defaultCallbackExecutor() {
        return null;
    }

    public int defaultConverterFactoriesSize() {
        return 0;
    }

    public boolean isDefaultMethod(Method r100) {
        return false;
    }

    private static Platform findPlatform() {
        INVOKESTATIC_com_bytedance_retrofit2_Platform_com_larus_mirabridge_impl_lancet_MiraReflectLancet_forName("android.os.Build");     // Catch: ClassNotFoundException -> L4
        return new Android();
    L5:
        return new Platform();
    }

    private static boolean findSquareRetrofit() {
        new retrofit2.Retrofit.Builder();     // Catch: NoClassDefFoundError -> L5
        return true;
    L5:
        return false;
    }

    static {
        PLATFORM = findPlatform();
        SQUARE_RETROFIT_EXISTS = findSquareRetrofit();
    }

    public List<? extends Converter.Factory> defaultConverterFactories() {
        return Collections.emptyList();
    }

    public static Platform get() {
        return PLATFORM;
    }

    public static boolean squareRetrofitExists() {
        return SQUARE_RETROFIT_EXISTS;
    }

    @Skip({"com.larus.mirabridge.impl.lancet+", "com.bytedance.mira.hook.delegate.DyMiraClassLoader", "com.bytedance.mira.hook.delegate.MiraClassLoader", "com.bytedance.ies.stark.util.NReflectUtils", "-com.bytedance.mira.core.PluginClassLoader", "com.bytedance.common.jato.util.DeviceInfoUtils", "com.bytedance.mira.helper.ClassLoaderHelper", "com.bytedance.mira.core.opt.res+"})
    public static Class INVOKESTATIC_com_bytedance_retrofit2_Platform_com_larus_mirabridge_impl_lancet_MiraReflectLancet_forName(String r100) throws ClassNotFoundException {
        ConcurrentHashMap<String, FastClassNotFoundHandler.Status> r101 = FastClassNotFoundHandler.f359329a;
        FastClassNotFoundHandler.Status r102 = FastClassNotFoundHandler.Status.STATUS_NOTING;
        if (a.a() == true) goto L34;
        Class r103 = access$000(r100);     // Catch: Throwable -> L8
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
        Class r104 = access$000(r100);     // Catch: Throwable -> L17
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

    public List<? extends CallAdapter.Factory> defaultCallAdapterFactories(@Nullable Executor r100) {
        if (r100 == null) goto L6;
        return Collections.singletonList(new ExecutorCallAdapterFactory(r100));
    L6:
        return Collections.singletonList(DefaultCallAdapterFactory.INSTANCE);
    }

    @Nullable
    public Object invokeDefaultMethod(Method r100, Class<?> r101, Object r102, @Nullable Object... r103) throws Throwable {
        throw new UnsupportedOperationException();
    }
}
