package vma;

import android.graphics.drawable.AnimatedVectorDrawable;
import android.graphics.drawable.VectorDrawable;
import android.util.ArrayMap;
import com.bytedance.mira.exception.PluginClassNotFoundException;
import com.larus.mirabridge.impl.lancet.FastClassNotFoundHandler;
import com.larus.mirabridge.impl.lancet.MiraPluginFix;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.jvm.internal.Intrinsics;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: classes34.dex */
public final class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f556352a = 0;

    static {
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

    public static void b(VectorDrawable r100, int r101) throws Exception {
        Field r102 = VectorDrawable.class.getDeclaredField("mVectorState");
        r102.setAccessible(true);
        Object r103 = r102.get(r100);
        Field r104 = r103.getClass().getDeclaredField("mVGTargetsMap");
        r104.setAccessible(true);
        Object r105 = r104.get(r103);
        if (r105 == null) goto L15;
        Object r106 = ((ArrayMap) r105).get("primary_shape");
        if (r106 != null) goto L7;
        return;
    L7:
        if (Intrinsics.areEqual(r106.getClass().getSimpleName(), "VFullPath") == false) goto L16;
        Field r107 = a("android.graphics.drawable.VectorDrawable$VFullPath").getDeclaredField("mNativePtr");
        r107.setAccessible(true);
        Object r108 = r107.get(r106);
        if (r108 == null) goto L12;
        long r109 = ((Long) r108).longValue();
        Method r110 = a("android.graphics.drawable.VectorDrawable").getDeclaredMethod("nSetFillColor", new Class[]{Long.TYPE, Integer.TYPE});
        r110.setAccessible(true);
        r110.invoke(null, new Object[]{Long.valueOf(r109), Integer.valueOf(r101)});
        return;
    L12:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Long");
    L16:
        return;
    L15:
        throw new NullPointerException("null cannot be cast to non-null type android.util.ArrayMap<kotlin.String, kotlin.Any>");
    }

    public static void c(AnimatedVectorDrawable r100, int r101) throws Exception {
        Field r102 = AnimatedVectorDrawable.class.getDeclaredField("mAnimatedVectorState");
        r102.setAccessible(true);
        Object r103 = r102.get(r100);
        Field r104 = r103.getClass().getDeclaredField("mVectorDrawable");
        if (r104 == null) goto L18;
        r104.setAccessible(true);
        int r105 = c.f556351a;
        Object r106 = r104.get(r103);
        if (r106 != null) goto L8;
    L10:
        r106 = null;
    L11:
        VectorDrawable r107 = (VectorDrawable) r106;
        if (r107 == null) goto L16;
        b(r107, r101);
        return;
    L16:
        throw new IllegalStateException("mVectorDrawable is null");
    L8:
        if ((r106 instanceof VectorDrawable) == false) goto L10;
    L18:
        throw new IllegalStateException("mVectorDrawable Field is null");
    }
}
