package com.bytedance.fresco.nativeheif;

import android.graphics.Bitmap;
import android.os.Build;
import android.text.TextUtils;
import com.bytedance.mira.exception.PluginClassNotFoundException;
import com.larus.mirabridge.impl.lancet.FastClassNotFoundHandler;
import com.larus.mirabridge.impl.lancet.MiraPluginFix;
import com.ss.android.socialbase.downloader.constants.MonitorConstants;
import el9.a;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.util.concurrent.ConcurrentHashMap;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: classes19.dex */
public class GainmapReflectionHelper {
    private static final String GAINMAP_CLASS_NAME = "android.graphics.Gainmap";
    private static final String TAG = "GainmapReflection";
    private static Object bt2020HlgNamed;
    private static Class<?> colorSpaceClass;
    private static Class<?> configClass;
    private static Class<?> gainmapClass;
    private static Class<?> namedClass;

    public GainmapReflectionHelper() {
    }

    public static /* synthetic */ Class access$000(String r100) throws ClassNotFoundException {
        return Class.forName(r100);
    }

    public static boolean isGainmapSupported() {
        INVOKESTATIC_com_bytedance_fresco_nativeheif_GainmapReflectionHelper_com_larus_mirabridge_impl_lancet_MiraReflectLancet_forName(GAINMAP_CLASS_NAME);     // Catch: ClassNotFoundException -> L5
        return true;
    L5:
        return false;
    }

    @Skip({"com.larus.mirabridge.impl.lancet+", "com.bytedance.mira.hook.delegate.DyMiraClassLoader", "com.bytedance.mira.hook.delegate.MiraClassLoader", "com.bytedance.ies.stark.util.NReflectUtils", "-com.bytedance.mira.core.PluginClassLoader", "com.bytedance.common.jato.util.DeviceInfoUtils", "com.bytedance.mira.helper.ClassLoaderHelper", "com.bytedance.mira.core.opt.res+"})
    public static Class INVOKESTATIC_com_bytedance_fresco_nativeheif_GainmapReflectionHelper_com_larus_mirabridge_impl_lancet_MiraReflectLancet_forName(String r100) throws ClassNotFoundException {
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

    private static Object createGainmap(Bitmap r100) {
    L7:
        return null;
    L3:
        if (gainmapClass != null) goto L5;
        gainmapClass = INVOKESTATIC_com_bytedance_fresco_nativeheif_GainmapReflectionHelper_com_larus_mirabridge_impl_lancet_MiraReflectLancet_forName(GAINMAP_CLASS_NAME);     // Catch: Exception -> L7
    L5:
        Constructor<?> r101 = gainmapClass.getDeclaredConstructor(new Class[]{Bitmap.class});     // Catch: Exception -> L7
        r101.setAccessible(true);     // Catch: Exception -> L7
        return r101.newInstance(new Object[]{r100});
    }

    private static Object getColorSpace(Object r100) {
    L8:
        e = move-exception;
        e.printStackTrace();
        return null;
    L4:
        if (colorSpaceClass != null) goto L6;
        colorSpaceClass = INVOKESTATIC_com_bytedance_fresco_nativeheif_GainmapReflectionHelper_com_larus_mirabridge_impl_lancet_MiraReflectLancet_forName("android.graphics.ColorSpace");     // Catch: Exception -> L8
    L6:
        Method r101 = colorSpaceClass.getDeclaredMethod(MonitorConstants.CONNECT_TYPE_GET, new Class[]{r100.getClass()});     // Catch: Exception -> L8
        r101.setAccessible(true);     // Catch: Exception -> L8
        return r101.invoke(null, new Object[]{r100});
    }

    private static Object getColorSpaceNamed(String r100) {
    L8:
        e = move-exception;
        e.printStackTrace();
        return null;
    L4:
        if (namedClass != null) goto L6;
        namedClass = INVOKESTATIC_com_bytedance_fresco_nativeheif_GainmapReflectionHelper_com_larus_mirabridge_impl_lancet_MiraReflectLancet_forName("android.graphics.ColorSpace$Named");     // Catch: Exception -> L8
    L6:
        return namedClass.getField(r100).get(null);
    }

    private static Object getConfig(String r100) {
    L8:
        e = move-exception;
        e.printStackTrace();
        return null;
    L4:
        if (configClass != null) goto L6;
        configClass = INVOKESTATIC_com_bytedance_fresco_nativeheif_GainmapReflectionHelper_com_larus_mirabridge_impl_lancet_MiraReflectLancet_forName("android.graphics.Bitmap$Config");     // Catch: Exception -> L8
    L6:
        return configClass.getField(r100).get(null);
    }

    public static boolean setBT2020HLGColorSpace(Bitmap r100) {
        if (r100 != null) goto L19;
        return false;
    L19:
    L16:
        e = move-exception;
        e.printStackTrace();
        return false;
    L6:
        if (bt2020HlgNamed != null) goto L9;
        bt2020HlgNamed = getColorSpaceNamed("BT2020_HLG");     // Catch: Exception -> L16
    L9:
        if (bt2020HlgNamed != null) goto L11;
        return false;
    L11:
        Object r101 = getColorSpace(bt2020HlgNamed);     // Catch: Exception -> L16
        if (r101 != null) goto L14;
        return false;
    L14:
        return setColorSpaceReflectively(r100, r101);
    }

    public static void safeSetGainmap(Bitmap r100, Object r101) {
        if (r100 == null) goto L19;
        if (r101 != null) goto L6;
        return;
    L6:
        if (Build.VERSION.SDK_INT >= 34) goto L18;
        return;
    L18:
        Class<?> r102 = r101.getClass();     // Catch: Exception -> L14 NoSuchMethodException -> L17
        if (r102.getName().equals(GAINMAP_CLASS_NAME) == false) goto L11;
        Method r103 = Bitmap.class.getDeclaredMethod("setGainmap", new Class[]{r102});     // Catch: Exception -> L14 NoSuchMethodException -> L17
        r103.setAccessible(true);     // Catch: Exception -> L14 NoSuchMethodException -> L17
        r103.invoke(r100, new Object[]{r101});     // Catch: Exception -> L14 NoSuchMethodException -> L17
        return;
    L11:
        return;
    L14:
        e = move-exception;
        e.getMessage();
        return;
    L22:
        return;
    }

    private static boolean setColorSpaceReflectively(Bitmap r100, Object r101) {
        if (r100 == null) goto L10;
        if (r101 == null) goto L10;
        Method r102 = Bitmap.class.getDeclaredMethod("setColorSpace", new Class[]{INVOKESTATIC_com_bytedance_fresco_nativeheif_GainmapReflectionHelper_com_larus_mirabridge_impl_lancet_MiraReflectLancet_forName("android.graphics.ColorSpace")});     // Catch: Exception -> L8
        r102.setAccessible(true);     // Catch: Exception -> L8
        r102.invoke(r100, new Object[]{r101});     // Catch: Exception -> L8
        return true;
    L8:
        e = move-exception;
        e.printStackTrace();
    L10:
        return false;
    }

    private static boolean setDisplayRatioForFullHdr(Object r100, float r101) {
        return invokeFloatMethod(r100, "setDisplayRatioForFullHdr", r101);
    }

    private static boolean setEpsilonHdr(Object r100, float[] r101) {
        return invokeFloatArrayMethod(r100, "setEpsilonHdr", r101);
    }

    private static boolean setEpsilonSdr(Object r100, float[] r101) {
        return invokeFloatArrayMethod(r100, "setEpsilonSdr", r101);
    }

    private static boolean setGamma(Object r100, float[] r101) {
        return invokeFloatArrayMethod(r100, "setGamma", r101);
    }

    private static boolean setMinDisplayRatioForHdrTransition(Object r100, float r101) {
        return invokeFloatMethod(r100, "setMinDisplayRatioForHdrTransition", r101);
    }

    private static boolean setRatioMax(Object r100, float[] r101) {
        return invokeFloatArrayMethod(r100, "setRatioMax", r101);
    }

    private static boolean setRatioMin(Object r100, float[] r101) {
        return invokeFloatArrayMethod(r100, "setRatioMin", r101);
    }

    private static Bitmap createBitmapReflectively(int r100, int r110, Object r111) {
        if (r100 <= 0) goto L11;
        if (r110 <= 0) goto L11;
        if (r111 == null) goto L11;
        Class r101 = Integer.TYPE;     // Catch: Exception -> L9
        Method r102 = Bitmap.class.getDeclaredMethod("createBitmap", new Class[]{r101, r101, INVOKESTATIC_com_bytedance_fresco_nativeheif_GainmapReflectionHelper_com_larus_mirabridge_impl_lancet_MiraReflectLancet_forName("android.graphics.Bitmap$Config")});     // Catch: Exception -> L9
        r102.setAccessible(true);     // Catch: Exception -> L9
        return (Bitmap) r102.invoke(null, new Object[]{Integer.valueOf(r100), Integer.valueOf(r110), r111});
    L9:
        e = move-exception;
        e.printStackTrace();
    L11:
        return null;
    }

    public static Bitmap createBitmapWithConfig(int r100, int r101, String r102) {
        if (r100 <= 0) goto L19;
        if (r101 <= 0) goto L19;
        if (Build.VERSION.SDK_INT < 33) goto L8;
        Object r103 = getConfig(r102);     // Catch: Exception -> L15
        if (r103 != null) goto L14;
        return Bitmap.createBitmap(r100, r101, Bitmap.Config.ARGB_8888);
    L14:
        return createBitmapReflectively(r100, r101, r103);
    L15:
        e = move-exception;
        e.getMessage();
        return Bitmap.createBitmap(r100, r101, Bitmap.Config.ARGB_8888);
    L8:
        return Bitmap.createBitmap(r100, r101, Bitmap.Config.ARGB_8888);
    L19:
        return null;
    }

    private static boolean invokeFloatArrayMethod(Object r100, String r101, float[] r102) {
        if (r100 != null) goto L5;
    L14:
        return false;
    L5:
        if (TextUtils.isEmpty(r101) == true) goto L14;
        if (r102 == null) goto L14;
        if (r102.length < 3) goto L14;
        Class<?> r103 = gainmapClass;     // Catch: Exception -> L12 NoSuchMethodException -> L13
        Class<?> r104 = Float.TYPE;     // Catch: Exception -> L12 NoSuchMethodException -> L13
        r103.getMethod(r101, new Class[]{r104, r104, r104}).invoke(r100, new Object[]{Float.valueOf(r102[0]), Float.valueOf(r102[1]), Float.valueOf(r102[2])});     // Catch: Exception -> L12 NoSuchMethodException -> L13
        r102.toString();     // Catch: Exception -> L12 NoSuchMethodException -> L13
        return true;
        goto L14
    }

    private static boolean invokeFloatMethod(Object r100, String r101, float r102) {
        if (r100 != null) goto L10;
        return false;
    L10:
        gainmapClass.getMethod(r101, new Class[]{Float.TYPE}).invoke(r100, new Object[]{Float.valueOf(r102)});     // Catch: Exception -> L7 NoSuchMethodException -> L8
        return true;
    L9:
        return false;
    }

    public static Object createGainmapWithMeta(Bitmap r100, float[] r101, float[] r102, float[] r103, float[] r104, float[] r105, float r106, float r107) {
        Object r108 = createGainmap(r100);     // Catch: Exception -> L6
        if (r108 == null) goto L5;
        setGamma(r108, r101);     // Catch: Exception -> L6
        setEpsilonSdr(r108, r102);     // Catch: Exception -> L6
        setEpsilonHdr(r108, r103);     // Catch: Exception -> L6
        setRatioMax(r108, r104);     // Catch: Exception -> L6
        setRatioMin(r108, r105);     // Catch: Exception -> L6
        setDisplayRatioForFullHdr(r108, r106);     // Catch: Exception -> L6
        setMinDisplayRatioForHdrTransition(r108, r107);     // Catch: Exception -> L6
    L5:
        return r108;
    L6:
        return null;
    }
}
