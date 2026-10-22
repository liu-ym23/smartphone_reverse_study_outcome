package com.bytedance.reparo.core;

import android.text.TextUtils;
import androidx.exifinterface.media.ExifInterface;
import com.bytedance.caijing.sdk.infra.base.api.face.FaceService;
import com.bytedance.mira.exception.PluginClassNotFoundException;
import com.bytedance.mt.protector.impl.string2number.CastIntegerProtector;
import com.larus.mirabridge.impl.lancet.FastClassNotFoundHandler;
import com.larus.mirabridge.impl.lancet.MiraPluginFix;
import com.miui.easygo.constant.EasyGoConstant;
import dalvik.system.DexFile;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.concurrent.ConcurrentHashMap;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: classes6.dex */
public final class n {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final HashMap<String, Class> f267407a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final ArrayList<DexFile> f267408b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final String f267409c = null;

    public n() {
    }

    public static boolean h() {
        String r100 = f267409c;     // Catch: Exception -> L13
        if (r100 != null) goto L6;
        return true;
    L6:
        if (r100.length() < 1) goto L17;
        if (CastIntegerProtector.parseInt(String.valueOf(r100.charAt(0))) >= 2) goto L18;
        return false;
    L18:
        return true;
    L17:
        return true;
    L19:
        return true;
    }

    static {
        f267407a = new HashMap();
        f267408b = new ArrayList();
        f267409c = System.getProperty("java.vm.version", "");
    }

    @Skip({"com.larus.mirabridge.impl.lancet+", "com.bytedance.mira.hook.delegate.DyMiraClassLoader", "com.bytedance.mira.hook.delegate.MiraClassLoader", "com.bytedance.ies.stark.util.NReflectUtils", "-com.bytedance.mira.core.PluginClassLoader", "com.bytedance.common.jato.util.DeviceInfoUtils", "com.bytedance.mira.helper.ClassLoaderHelper", "com.bytedance.mira.core.opt.res+"})
    public static Class b() throws ClassNotFoundException {
        ConcurrentHashMap<String, FastClassNotFoundHandler.Status> r100 = FastClassNotFoundHandler.f359329a;
        FastClassNotFoundHandler.Status r101 = FastClassNotFoundHandler.Status.STATUS_NOTING;
        if (el9.a.a() == true) goto L34;
        Class<?> r102 = Class.forName("android.os.SystemProperties");     // Catch: Throwable -> L8
        if (r101 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L7;
        FastClassNotFoundHandler.a("android.os.SystemProperties");     // Catch: Throwable -> L8
    L7:
        return r102;
    L8:
        th = move-exception;
        if (r101 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L12;
        FastClassNotFoundHandler.b("android.os.SystemProperties");
    L12:
        throw th;
    L34:
        Class<?> r103 = Class.forName("android.os.SystemProperties");     // Catch: Throwable -> L17
        if (r101 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L16;
        FastClassNotFoundHandler.a("android.os.SystemProperties");     // Catch: Throwable -> L17
    L16:
        return r103;
    L17:
        th = move-exception;
        if (r101 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L22;
        FastClassNotFoundHandler.b("android.os.SystemProperties");
    L22:
        if ((th instanceof PluginClassNotFoundException) == false) goto L24;
        throw th;
    L24:
        if ((th instanceof ClassNotFoundException) == true) goto L30;
        if ((th instanceof NoClassDefFoundError) == true) goto L30;
        throw th;
    L30:
        return MiraPluginFix.forName("android.os.SystemProperties");
    }

    public static String a(String r100) {
        int r101 = r100.length();
        if (r101 > 1) goto L5;
        return r100;
    L5:
        if (r100.charAt(0) != 'L') goto L11;
        int r102 = r101 - 1;
        if (r100.charAt(r102) != ';') goto L11;
        return r100.substring(1, r102).replace('/', '.');
    L11:
        return r100.replace('/', '.');
    }

    public static String c(Constructor r100) {
        StringBuilder r101 = new StringBuilder("(");
        Class<?>[] r102 = r100.getParameterTypes();
        int r103 = 0;
    L4:
        if (r103 >= r102.length) goto L9;
        String r104 = g(r102[r103]);
        if (TextUtils.isEmpty(r104) == true) goto L8;
        r101.append(r104);
    L8:
        r103 = r103 + 1;
        goto L4
    L9:
        r101.append(")");
        r101.append(e(Void.TYPE));
        return r101.toString();
    }

    public static String d(Method r100) {
        StringBuilder r101 = new StringBuilder("(");
        Class<?>[] r102 = r100.getParameterTypes();
        int r103 = 0;
    L4:
        if (r103 >= r102.length) goto L9;
        String r104 = g(r102[r103]);
        if (TextUtils.isEmpty(r104) == true) goto L8;
        r101.append(r104);
    L8:
        r103 = r103 + 1;
        goto L4
    L9:
        r101.append(")");
        r101.append(g(r100.getReturnType()));
        return r101.toString();
    }

    public static String e(Class<?> r100) {
        if (Boolean.TYPE.equals(r100) == false) goto L7;
        return "Z";
    L7:
        if (Byte.TYPE.equals(r100) == false) goto L11;
        return "B";
    L11:
        if (Character.TYPE.equals(r100) == false) goto L15;
        return "C";
    L15:
        if (Short.TYPE.equals(r100) == false) goto L19;
        return ExifInterface.LATITUDE_SOUTH;
    L19:
        if (Integer.TYPE.equals(r100) == false) goto L23;
        return "I";
    L23:
        if (Long.TYPE.equals(r100) == false) goto L27;
        return "J";
    L27:
        if (Float.TYPE.equals(r100) == false) goto L31;
        return FaceService.girlLabel;
    L31:
        if (Double.TYPE.equals(r100) == false) goto L35;
        return "D";
    L35:
        if (Void.TYPE.equals(r100) == false) goto L38;
        return "V";
    L38:
        return null;
    }

    public static String g(Class<?> r100) {
        if (r100.isPrimitive() == false) goto L7;
        return e(r100);
    L7:
        if (r100.isArray() == true) goto L9;
        String r101 = r100.getName().replace('.', '/');
        if (r101.length() > 0) goto L13;
        return r101;
    L13:
        if (r101.charAt(0) != '[') goto L15;
        return r101;
    L15:
        return "L" + r101 + com.alipay.sdk.m.u.i.f25853b;
    L9:
        return "[" + g(r100.getComponentType());
    }

    public static String f(String r100, String r101) {
        return "L" + r100.replaceAll(EasyGoConstant.VERSION_SEPARATIVE_SIGN, "_") + "_" + r101.replaceAll("<", "_i_").replaceAll(">", "_i_");
    }

    public static Class i(String r100, DexFile r101) throws Exception {
        Class r102 = r101.loadClass(r100, n.class.getClassLoader());
        if (r102 == null) goto L36;
        String r103 = r102.getName();
        ClassLoader r104 = r102.getClassLoader();
        ConcurrentHashMap<String, FastClassNotFoundHandler.Status> r105 = FastClassNotFoundHandler.f359329a;
        FastClassNotFoundHandler.Status r106 = FastClassNotFoundHandler.Status.STATUS_NOTING;
        if (el9.a.a() == true) goto L39;
        Class.forName(r103, false, r104);     // Catch: Throwable -> L10
        if (r106 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L32;
        FastClassNotFoundHandler.a(r103);     // Catch: Throwable -> L10
    L32:
        f267407a.put(r102.getName(), r102);
        return r102;
    L10:
        th = move-exception;
        if (r106 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L14;
        FastClassNotFoundHandler.b(r103);
    L14:
        throw th;
    L39:
        Class.forName(r103, false, r104);     // Catch: Throwable -> L19
        if (r106 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L32;
        FastClassNotFoundHandler.a(r103);     // Catch: Throwable -> L19
    L19:
        th = move-exception;
        if (r106 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L24;
        FastClassNotFoundHandler.b(r103);
    L24:
        if ((th instanceof PluginClassNotFoundException) == false) goto L26;
        throw th;
    L26:
        if ((th instanceof ClassNotFoundException) == false) goto L28;
    L31:
        MiraPluginFix.forName(r103);
        goto L32
    L28:
        if ((th instanceof NoClassDefFoundError) == true) goto L31;
        throw th;
    L36:
        throw new ClassNotFoundException(r100);
    }
}
