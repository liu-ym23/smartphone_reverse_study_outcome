package com.bytedance.reparo.core;

import androidx.camera.video.AudioStats;
import androidx.exifinterface.media.ExifInterface;
import com.bytedance.caijing.sdk.infra.base.api.face.FaceService;
import com.bytedance.mira.exception.PluginClassNotFoundException;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larus.mirabridge.impl.lancet.FastClassNotFoundHandler;
import com.larus.mirabridge.impl.lancet.MiraPluginFix;
import java.lang.reflect.Array;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.ConcurrentHashMap;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: classes21.dex */
public class PatchClassLayoutChangeHelper {
    public static Map<String, Object> mAddedFieldMap;

    public PatchClassLayoutChangeHelper() {
    }

    public static /* synthetic */ Class access$000(String r100) throws ClassNotFoundException {
        return Class.forName(r100);
    }

    public static /* synthetic */ Class access$001(String r100, boolean r101, ClassLoader r102) throws ClassNotFoundException {
        return Class.forName(r100, r101, r102);
    }

    static {
        mAddedFieldMap = new HashMap();
    }

    @Skip({"com.larus.mirabridge.impl.lancet+", "com.bytedance.mira.hook.delegate.DyMiraClassLoader", "com.bytedance.mira.hook.delegate.MiraClassLoader", "com.bytedance.ies.stark.util.NReflectUtils", "-com.bytedance.mira.core.PluginClassLoader", "com.bytedance.common.jato.util.DeviceInfoUtils", "com.bytedance.mira.helper.ClassLoaderHelper", "com.bytedance.mira.core.opt.res+"})
    public static Class INVOKESTATIC_com_bytedance_reparo_core_PatchClassLayoutChangeHelper_com_larus_mirabridge_impl_lancet_MiraReflectLancet_forName(String r100) throws ClassNotFoundException {
        ConcurrentHashMap<String, FastClassNotFoundHandler.Status> r101 = FastClassNotFoundHandler.f359329a;
        FastClassNotFoundHandler.Status r102 = FastClassNotFoundHandler.Status.STATUS_NOTING;
        if (el9.a.a() == true) goto L34;
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

    public static Class a(String r100) throws ClassNotFoundException {
        int r101 = r100.hashCode();     // Catch: Throwable -> L69
        if (r101 == 70) goto L36;
        if (r101 == 83) goto L33;
        if (r101 == 90) goto L30;
        if (r101 == 73) goto L27;
        if (r101 == 74) goto L24;
        switch(r101) {
            case 66: goto L21;
            case 67: goto L18;
            case 68: goto L15;
            default: goto L38;
        };     // Catch: Throwable -> L69
    L38:
        byte r102 = -1;
    L39:
        switch(r102) {
            case 0: goto L56;
            case 1: goto L54;
            case 2: goto L52;
            case 3: goto L50;
            case 4: goto L48;
            case 5: goto L46;
            case 6: goto L44;
            case 7: goto L42;
            default: goto L58;
        };     // Catch: Throwable -> L69
    L58:
        if ('[' != r100.charAt(0)) goto L62;
        return Array.newInstance(a(r100.substring(1)), 0).getClass();
    L62:
        if (r100.startsWith("L") == true) goto L64;
    L66:
        String r103 = r100;
    L68:
        return INVOKESTATIC_com_bytedance_reparo_core_PatchClassLayoutChangeHelper_com_larus_mirabridge_impl_lancet_MiraReflectLancet_forName(r103, false, j.class.getClassLoader());
    L64:
        if (r100.endsWith(com.alipay.sdk.m.u.i.f25853b) == false) goto L66;
        r103 = r100.substring(1, r100.length() - 1).replace('/', '.');     // Catch: Throwable -> L69
        goto L68
    L42:
        return Long.TYPE;
    L44:
        return Double.TYPE;
    L46:
        return Float.TYPE;
    L48:
        return Integer.TYPE;
    L50:
        return Character.TYPE;
    L52:
        return Short.TYPE;
    L54:
        return Byte.TYPE;
    L56:
        return Boolean.TYPE;
    L15:
        if (r100.equals("D") == false) goto L38;
        r102 = 6;
        goto L39
    L18:
        if (r100.equals("C") == false) goto L38;
        r102 = 3;
        goto L39
    L21:
        if (r100.equals("B") == false) goto L38;
        r102 = 1;
        goto L39
    L24:
        if (r100.equals("J") == false) goto L38;
        r102 = 7;
        goto L39
    L27:
        if (r100.equals("I") == false) goto L38;
        r102 = 4;
        goto L39
    L30:
        if (r100.equals("Z") == false) goto L38;
        r102 = 0;
        goto L39
    L33:
        if (r100.equals(ExifInterface.LATITUDE_SOUTH) == false) goto L38;
        r102 = 2;
        goto L39
    L36:
        if (r100.equals(FaceService.girlLabel) == false) goto L38;
        r102 = 5;
    L69:
        th = move-exception;
        th.printStackTrace();
        System.err.println("getClassByClassType " + r100);
        b97.a.c("getClassByClassType " + r100, th);
        return null;
    }

    public static void classForName(String r100) {
        INVOKESTATIC_com_bytedance_reparo_core_PatchClassLayoutChangeHelper_com_larus_mirabridge_impl_lancet_MiraReflectLancet_forName(r100);     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        b97.a.c("error classForName " + r100, th);
    }

    public static Object newInstanceWithoutConstruct(String r100) throws ClassNotFoundException {
        return WandTrick.allocObject(a(r100));
    }

    public static String b(Object r100, String r101) {
        return r100.getClass().getName() + "_" + System.identityHashCode(r100) + "_" + r101;
    }

    @Skip({"com.larus.mirabridge.impl.lancet+", "com.bytedance.mira.hook.delegate.DyMiraClassLoader", "com.bytedance.mira.hook.delegate.MiraClassLoader", "com.bytedance.ies.stark.util.NReflectUtils", "-com.bytedance.mira.core.PluginClassLoader", "com.bytedance.mira.core.opt.res+"})
    public static Class INVOKESTATIC_com_bytedance_reparo_core_PatchClassLayoutChangeHelper_com_larus_mirabridge_impl_lancet_MiraReflectLancet_forName(String r100, boolean r101, ClassLoader r102) throws ClassNotFoundException {
        ConcurrentHashMap<String, FastClassNotFoundHandler.Status> r103 = FastClassNotFoundHandler.f359329a;
        FastClassNotFoundHandler.Status r104 = FastClassNotFoundHandler.Status.STATUS_NOTING;
        if (el9.a.a() == true) goto L34;
        Class r105 = access$001(r100, r101, r102);     // Catch: Throwable -> L8
        if (r104 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L7;
        FastClassNotFoundHandler.a(r100);     // Catch: Throwable -> L8
    L7:
        return r105;
    L8:
        th = move-exception;
        if (r104 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L12;
        FastClassNotFoundHandler.b(r100);
    L12:
        throw th;
    L34:
        Class r106 = access$001(r100, r101, r102);     // Catch: Throwable -> L17
        if (r104 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L16;
        FastClassNotFoundHandler.a(r100);     // Catch: Throwable -> L17
    L16:
        return r106;
    L17:
        th = move-exception;
        if (r104 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L22;
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

    public static synchronized Object getInstanceField(Object r100, String r101, String r102) {
        monitor-enter(PatchClassLayoutChangeHelper.class);
        String r103 = b(r100, r101);     // Catch: Throwable -> L57
        if (mAddedFieldMap.containsKey(r103) == true) goto L54;
        Map<String, Object> r104 = mAddedFieldMap;     // Catch: Throwable -> L57
        r102.getClass();     // Catch: Throwable -> L57
        byte r105 = -1;
        switch(r102.hashCode()) {
            case 66: goto L40;
            case 67: goto L36;
            case 68: goto L32;
            case 70: goto L28;
            case 73: goto L24;
            case 74: goto L20;
            case 83: goto L16;
            case 90: goto L12;
            default: goto L43;
        };
    L43:
        switch(r105) {
            case 0: goto L52;
            case 1: goto L51;
            case 2: goto L50;
            case 3: goto L49;
            case 4: goto L48;
            case 5: goto L47;
            case 6: goto L46;
            case 7: goto L45;
            default: goto L44;
        };
    L44:
        Object r106 = null;
    L53:
        r104.put(r103, r106);     // Catch: Throwable -> L57
        goto L54
    L45:
        r106 = Boolean.FALSE;     // Catch: Throwable -> L57
        goto L53
    L46:
        r106 = (short) 0;     // Catch: Throwable -> L57
        goto L53
    L47:
        r106 = 0L;     // Catch: Throwable -> L57
        goto L53
    L48:
        r106 = 0;     // Catch: Throwable -> L57
        goto L53
    L49:
        r106 = Float.valueOf(0.0f);     // Catch: Throwable -> L57
        goto L53
    L50:
        r106 = Double.valueOf(AudioStats.AUDIO_AMPLITUDE_NONE);     // Catch: Throwable -> L57
        goto L53
    L51:
        r106 = (char) 0;     // Catch: Throwable -> L57
        goto L53
    L52:
        r106 = (byte) 0;     // Catch: Throwable -> L57
        goto L53
    L12:
        if (r102.equals("Z") == false) goto L43;
        r105 = 7;
        goto L43
    L16:
        if (r102.equals(ExifInterface.LATITUDE_SOUTH) == false) goto L43;
        r105 = 6;
        goto L43
    L20:
        if (r102.equals("J") == false) goto L43;
        r105 = 5;
        goto L43
    L24:
        if (r102.equals("I") == false) goto L43;
        r105 = 4;
        goto L43
    L28:
        if (r102.equals(FaceService.girlLabel) == false) goto L43;
        r105 = 3;
        goto L43
    L32:
        if (r102.equals("D") == false) goto L43;
        r105 = 2;
        goto L43
    L36:
        if (r102.equals("C") == false) goto L43;
        r105 = 1;
        goto L43
    L40:
        if (r102.equals("B") == false) goto L43;
        r105 = 0;
    L54:
        Object r107 = mAddedFieldMap.get(r103);     // Catch: Throwable -> L57
        monitor-exit(PatchClassLayoutChangeHelper.class);
        return r107;
    L57:
        th = move-exception;
        th.printStackTrace();     // Catch: Throwable -> L61
        return null;
    L61:
        th = move-exception;
        throw th;
    }

    public static Object getPrivateField(Object r100, String r101, String r102) {
        Field r103 = e97.g.a(a(r101), r102);     // Catch: Exception -> L4
        r103.setAccessible(true);     // Catch: Exception -> L4
        return r103.get(r100);
    L4:
        e = move-exception;
        e.printStackTrace();
        return null;
    }

    public static Object newWithPrivateConstructor(String r100, ArrayList<String> r101, ArrayList<Object> r102) {
        Class r103 = a(r100);     // Catch: Throwable -> L8
        Class<?>[] r104 = new Class[r101.size()];     // Catch: Throwable -> L8
        int r105 = 0;
    L4:
        if (r105 >= r101.size()) goto L6;
        r104[r105] = a((String) ListProtector.get(r101, r105));     // Catch: Throwable -> L8
        r105 = r105 + 1;     // Catch: Throwable -> L8
        goto L4
    L6:
        Constructor r106 = r103.getDeclaredConstructor(r104);     // Catch: Throwable -> L8
        r106.setAccessible(true);     // Catch: Throwable -> L8
        return WandTrick.createInstance(r103, r106, r101.toArray(), r102.toArray());
    L8:
        k.f267379a.b();
        return null;
    }

    public static synchronized void setInstanceField(Object r100, String r101, Object r102) {
        monitor-enter(PatchClassLayoutChangeHelper.class);
        mAddedFieldMap.put(b(r100, r101), r102);     // Catch: Throwable -> L6
    L8:
        monitor-exit(PatchClassLayoutChangeHelper.class);
        return;
    L6:
        th = move-exception;
        th.printStackTrace();     // Catch: Throwable -> L10
    L10:
        th = move-exception;
        throw th;
    }

    public static void setPrivateField(Object r100, String r101, String r102, ArrayList<Object> r103) {
        Field r104 = e97.g.a(a(r101), r102);     // Catch: Exception -> L4
        r104.setAccessible(true);     // Catch: Exception -> L4
        r104.set(r100, ListProtector.get(r103, 0));     // Catch: Exception -> L4
        return;
    L4:
        e = move-exception;
        e.printStackTrace();
    }

    public static Object invokePrivateMethod(Object r100, String r101, String r110, ArrayList<String> r111, ArrayList<Object> r112) throws Throwable {
        Class r102 = a(r101);     // Catch: Exception -> L16 InvocationTargetException -> L18
        Class<?>[] r103 = new Class[r111.size()];     // Catch: Exception -> L16 InvocationTargetException -> L18
        int r104 = 0;
    L5:
        if (r104 >= r111.size()) goto L8;
        r103[r104] = a((String) ListProtector.get(r111, r104));     // Catch: Exception -> L16 InvocationTargetException -> L18
        r104 = r104 + 1;     // Catch: Exception -> L16 InvocationTargetException -> L18
        goto L5
    L8:
        if (r110.equals("<init>") == false) goto L11;
        WandTrick.callMethodDirect(r102, r102.getDeclaredConstructor(r103), r100, r111.toArray(), r112.toArray(), null, null);     // Catch: Exception -> L16 InvocationTargetException -> L18
        return null;
    L11:
        Method r105 = e97.g.c(r102, r110, r103);     // Catch: Exception -> L16 InvocationTargetException -> L18
        r105.setAccessible(true);     // Catch: Exception -> L16 InvocationTargetException -> L18
        if (r105.getParameterTypes().length != (r112.size() + 1)) goto L15;
        ListProtector.add(r112, 0, r100);     // Catch: Exception -> L16 InvocationTargetException -> L18
    L15:
        return r105.invoke(r100, r112.toArray());
    L18:
        e = move-exception;
        throw e.getCause();
    L16:
        Objects.toString(r111);
        k.f267379a.b();
        return null;
    }

    public static Object invokePrivateSuperMethod(Object r100, String r101, String r102, ArrayList<String> r110, ArrayList<Object> r111) throws Throwable {
        Class r103 = a(r101);     // Catch: Exception -> L12 InvocationTargetException -> L14
        Class[] r104 = new Class[r110.size()];     // Catch: Exception -> L12 InvocationTargetException -> L14
        int r105 = 0;
    L4:
        if (r105 >= r110.size()) goto L6;
        r104[r105] = a((String) ListProtector.get(r110, r105));     // Catch: Exception -> L12 InvocationTargetException -> L14
        r105 = r105 + 1;     // Catch: Exception -> L12 InvocationTargetException -> L14
        goto L4
    L6:
        Method r106 = e97.g.c(r103, r102, r104);     // Catch: Exception -> L12 InvocationTargetException -> L14
        r106.setAccessible(true);     // Catch: Exception -> L12 InvocationTargetException -> L14
        if (r106.getParameterTypes().length != (r111.size() + 1)) goto L11;
        ListProtector.add(r111, 0, r100);     // Catch: Exception -> L12 InvocationTargetException -> L14
        return r106.invoke(r100, r111.toArray());
    L11:
        return WandTrick.callMethodDirect(r103, r106, r100, r110.toArray(), r111.toArray(), n.g(r106.getReturnType()), r106.getReturnType());
    L14:
        e = move-exception;
        throw e.getCause();
    L12:
        Objects.toString(r110);
        k.f267379a.b();
        return null;
    }
}
