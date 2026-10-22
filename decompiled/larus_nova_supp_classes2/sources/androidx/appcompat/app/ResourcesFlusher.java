package androidx.appcompat.app;

import android.content.res.Resources;
import android.os.Build;
import android.util.LongSparseArray;
import com.bytedance.mira.exception.PluginClassNotFoundException;
import com.larus.mirabridge.impl.lancet.FastClassNotFoundHandler;
import com.larus.mirabridge.impl.lancet.MiraPluginFix;
import el9.a;
import java.lang.reflect.Field;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
class ResourcesFlusher {
    private static final String TAG = "ResourcesFlusher";
    private static Field sDrawableCacheField;
    private static boolean sDrawableCacheFieldFetched;
    private static Field sResourcesImplField;
    private static boolean sResourcesImplFieldFetched;
    private static Class<?> sThemedResourceCacheClazz;
    private static boolean sThemedResourceCacheClazzFetched;
    private static Field sThemedResourceCache_mUnthemedEntriesField;
    private static boolean sThemedResourceCache_mUnthemedEntriesFieldFetched;

    public static /* synthetic */ Class access$000(String r0) throws ClassNotFoundException {
        return Class.forName(r0);
    }

    private ResourcesFlusher() {
    }

    @Skip({"com.larus.mirabridge.impl.lancet+", "com.bytedance.mira.hook.delegate.DyMiraClassLoader", "com.bytedance.mira.hook.delegate.MiraClassLoader", "com.bytedance.ies.stark.util.NReflectUtils", "-com.bytedance.mira.core.PluginClassLoader", "com.bytedance.common.jato.util.DeviceInfoUtils", "com.bytedance.mira.helper.ClassLoaderHelper", "com.bytedance.mira.core.opt.res+"})
    public static Class INVOKESTATIC_androidx_appcompat_app_ResourcesFlusher_com_larus_mirabridge_impl_lancet_MiraReflectLancet_forName(String r3) throws ClassNotFoundException {
        ConcurrentHashMap r0 = FastClassNotFoundHandler.a;
        FastClassNotFoundHandler.Status r1 = FastClassNotFoundHandler.Status.STATUS_NOTING;
        if (a.a() == true) goto L34;
        Class r2 = access$000(r3);     // Catch: Throwable -> L8
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
        Class r4 = access$000(r3);     // Catch: Throwable -> L17
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

    public static void flush(Resources r2) {
        int r0 = Build.VERSION.SDK_INT;
        if (r0 < 28) goto L6;
        return;
    L6:
        if (r0 < 24) goto L9;
        flushNougats(r2);
        return;
    L9:
        if (r0 < 23) goto L11;
        flushMarshmallows(r2);
        return;
    L11:
        flushLollipops(r2);
    }

    private static void flushLollipops(Resources r3) {
        if (sDrawableCacheFieldFetched == false) goto L18;
    L7:
        Field r0 = sDrawableCacheField;
        if (r0 == null) goto L20;
        Map r4 = (Map) r0.get(r3);     // Catch: IllegalAccessException -> L11
    L12:
        if (r4 == null) goto L21;
        r4.clear();
        return;
    L21:
        return;
    L11:
        r4 = null;
        goto L12
    L20:
        return;
    L18:
        Field r1 = Resources.class.getDeclaredField("mDrawableCache");     // Catch: NoSuchFieldException -> L15
        sDrawableCacheField = r1;     // Catch: NoSuchFieldException -> L15
        r1.setAccessible(true);     // Catch: NoSuchFieldException -> L15
    L6:
        sDrawableCacheFieldFetched = true;
        goto L7
    }

    private static void flushMarshmallows(Resources r3) {
        if (sDrawableCacheFieldFetched == false) goto L18;
    L7:
        Field r0 = sDrawableCacheField;
        if (r0 != null) goto L20;
    L11:
        Object r4 = null;
    L12:
        if (r4 != null) goto L14;
        return;
    L14:
        flushThemedResourcesCache(r4);
        return;
    L20:
        r4 = r0.get(r3);     // Catch: IllegalAccessException -> L17
    L18:
        Field r1 = Resources.class.getDeclaredField("mDrawableCache");     // Catch: NoSuchFieldException -> L16
        sDrawableCacheField = r1;     // Catch: NoSuchFieldException -> L16
        r1.setAccessible(true);     // Catch: NoSuchFieldException -> L16
    L6:
        sDrawableCacheFieldFetched = true;
        goto L7
    }

    private static void flushNougats(Resources r4) {
        if (sResourcesImplFieldFetched == false) goto L35;
    L6:
        Field r0 = sResourcesImplField;
        if (r0 != null) goto L9;
        return;
    L9:
        Object r2 = null;
        Object r5 = r0.get(r4);     // Catch: IllegalAccessException -> L12
    L13:
        if (r5 != null) goto L16;
        return;
    L16:
        if (sDrawableCacheFieldFetched == false) goto L29;
    L19:
        Field r1 = sDrawableCacheField;
        if (r1 != null) goto L33;
    L24:
        if (r2 == null) goto L37;
        flushThemedResourcesCache(r2);
        return;
    L37:
        return;
    L33:
        r2 = r1.get(r5);     // Catch: IllegalAccessException -> L23
        goto L24
    L29:
        Field r3 = r5.getClass().getDeclaredField("mDrawableCache");     // Catch: NoSuchFieldException -> L27
        sDrawableCacheField = r3;     // Catch: NoSuchFieldException -> L27
        r3.setAccessible(true);     // Catch: NoSuchFieldException -> L27
    L18:
        sDrawableCacheFieldFetched = true;
    L12:
        r5 = null;
        goto L13
    L35:
        Field r6 = Resources.class.getDeclaredField("mResourcesImpl");     // Catch: NoSuchFieldException -> L28
        sResourcesImplField = r6;     // Catch: NoSuchFieldException -> L28
        r6.setAccessible(true);     // Catch: NoSuchFieldException -> L28
    L5:
        sResourcesImplFieldFetched = true;
        goto L6
    }

    private static void flushThemedResourcesCache(Object r3) {
        if (sThemedResourceCacheClazzFetched == false) goto L28;
    L6:
        Class<?> r0 = sThemedResourceCacheClazz;
        if (r0 != null) goto L10;
        return;
    L10:
        if (sThemedResourceCache_mUnthemedEntriesFieldFetched == false) goto L26;
    L13:
        Field r1 = sThemedResourceCache_mUnthemedEntriesField;
        if (r1 != null) goto L24;
        return;
    L24:
        LongSparseArray r4 = (LongSparseArray) r1.get(r3);     // Catch: IllegalAccessException -> L18
    L19:
        if (r4 == null) goto L30;
        r4.clear();
        return;
    L30:
        return;
    L18:
        r4 = null;
        goto L19
    L26:
        Field r2 = r0.getDeclaredField("mUnthemedEntries");     // Catch: NoSuchFieldException -> L22
        sThemedResourceCache_mUnthemedEntriesField = r2;     // Catch: NoSuchFieldException -> L22
        r2.setAccessible(true);     // Catch: NoSuchFieldException -> L22
    L12:
        sThemedResourceCache_mUnthemedEntriesFieldFetched = true;
        goto L13
    L28:
        sThemedResourceCacheClazz = INVOKESTATIC_androidx_appcompat_app_ResourcesFlusher_com_larus_mirabridge_impl_lancet_MiraReflectLancet_forName("android.content.res.ThemedResourceCache");     // Catch: ClassNotFoundException -> L23
    L5:
        sThemedResourceCacheClazzFetched = true;
        goto L6
    }
}
