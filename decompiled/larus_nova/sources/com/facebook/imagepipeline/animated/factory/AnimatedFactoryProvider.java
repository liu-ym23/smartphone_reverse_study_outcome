package com.facebook.imagepipeline.animated.factory;

import android.graphics.Bitmap;
import com.bytedance.mira.exception.PluginClassNotFoundException;
import com.facebook.cache.common.CacheKey;
import com.facebook.imagepipeline.bitmaps.PlatformBitmapFactory;
import com.facebook.imagepipeline.cache.CountingMemoryCache;
import com.facebook.imagepipeline.cache.HashMapMemoryCache;
import com.facebook.imagepipeline.core.ExecutorSupplier;
import com.facebook.imagepipeline.image.CloseableImage;
import com.larus.mirabridge.impl.lancet.FastClassNotFoundHandler;
import com.larus.mirabridge.impl.lancet.MiraPluginFix;
import el9.a;
import java.util.concurrent.ConcurrentHashMap;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: classes3.dex */
public class AnimatedFactoryProvider {
    private static AnimatedTempBitmapFactory sAnimatedTempBitmapFactory;
    private static AnimatedFactory sImpl;
    private static boolean sImplLoaded;
    private static int sPreDecodeCount;

    public AnimatedFactoryProvider() {
    }

    public static /* synthetic */ Class access$000(String r100) throws ClassNotFoundException {
        return Class.forName(r100);
    }

    public static AnimatedFactory getImpl() {
        if (sImplLoaded == true) goto L7;
        return null;
    L7:
        return sImpl;
    }

    public static AnimatedTempBitmapFactory getAnimatedTempBitmapFactory() {
        return sAnimatedTempBitmapFactory;
    }

    public static int getDefaultPreDecodeCount() {
        return sPreDecodeCount;
    }

    @Skip({"com.larus.mirabridge.impl.lancet+", "com.bytedance.mira.hook.delegate.DyMiraClassLoader", "com.bytedance.mira.hook.delegate.MiraClassLoader", "com.bytedance.ies.stark.util.NReflectUtils", "-com.bytedance.mira.core.PluginClassLoader", "com.bytedance.common.jato.util.DeviceInfoUtils", "com.bytedance.mira.helper.ClassLoaderHelper", "com.bytedance.mira.core.opt.res+"})
    public static Class INVOKESTATIC_com_facebook_imagepipeline_animated_factory_AnimatedFactoryProvider_com_larus_mirabridge_impl_lancet_MiraReflectLancet_forName(String r100) throws ClassNotFoundException {
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

    public static void setAnimatedTempBitmapFactory(AnimatedTempBitmapFactory r100) {
        sAnimatedTempBitmapFactory = r100;
    }

    public static void setDefaultPreDecodeCount(int r100) {
        sPreDecodeCount = r100;
    }

    public static AnimatedFactory getAnimatedFactory(PlatformBitmapFactory r100, ExecutorSupplier r101, CountingMemoryCache<CacheKey, CloseableImage> r110, HashMapMemoryCache<CacheKey, Bitmap> r111) {
        if (sImplLoaded == true) goto L12;
        sImpl = (AnimatedFactory) INVOKESTATIC_com_facebook_imagepipeline_animated_factory_AnimatedFactoryProvider_com_larus_mirabridge_impl_lancet_MiraReflectLancet_forName("com.facebook.fresco.animation.factory.AnimatedFactoryV2Impl").getConstructor(new Class[]{PlatformBitmapFactory.class, ExecutorSupplier.class, CountingMemoryCache.class, HashMapMemoryCache.class}).newInstance(new Object[]{r100, r101, r110, r111});     // Catch: Throwable -> L7
    L9:
        if (sImpl == null) goto L12;
        sImplLoaded = true;
    L12:
        return sImpl;
    }
}
