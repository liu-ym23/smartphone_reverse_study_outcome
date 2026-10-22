package com.bytedance.mira.plugin.trip.opt;

import android.os.Build;
import com.bytedance.mira.exception.PluginClassNotFoundException;
import com.bytedance.mira.plugin.trip.opt.utils.ReflectUtils;
import com.larus.mirabridge.impl.lancet.FastClassNotFoundHandler;
import com.larus.mirabridge.impl.lancet.MiraPluginFix;
import dalvik.system.BaseDexClassLoader;
import dalvik.system.DexFile;
import dalvik.system.DexPathList;
import el9.a;
import java.lang.reflect.Field;
import java.util.concurrent.ConcurrentHashMap;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: classes21.dex */
public class ClassDefOpt {
    private static final Field sCookieField = null;
    private static final Field sDexElementsFiled = null;
    private static final Field sDexFileField = null;
    private static final Field sPathListFiled = null;

    public ClassDefOpt() {
    }

    public static /* synthetic */ Class access$000(String r100) throws ClassNotFoundException {
        return Class.forName(r100);
    }

    private static native boolean opt_class_def_native(Object r100, String r101);

    static {
        sPathListFiled = ReflectUtils.findDeclaredField(BaseDexClassLoader.class, "pathList");
        sDexElementsFiled = ReflectUtils.findDeclaredField(DexPathList.class, "dexElements");
        sCookieField = ReflectUtils.findDeclaredField(DexFile.class, "mCookie");
        Field r100 = ReflectUtils.findDeclaredField(INVOKESTATIC_com_bytedance_mira_plugin_trip_opt_ClassDefOpt_com_larus_mirabridge_impl_lancet_MiraReflectLancet_forName("dalvik.system.DexPathList$Element"), "dexFile");     // Catch: Throwable -> L5
    L6:
        sDexFileField = r100;
        return;
    L5:
        r100 = null;
        goto L6
    }

    @Skip({"com.larus.mirabridge.impl.lancet+", "com.bytedance.mira.hook.delegate.DyMiraClassLoader", "com.bytedance.mira.hook.delegate.MiraClassLoader", "com.bytedance.ies.stark.util.NReflectUtils", "-com.bytedance.mira.core.PluginClassLoader", "com.bytedance.common.jato.util.DeviceInfoUtils", "com.bytedance.mira.helper.ClassLoaderHelper", "com.bytedance.mira.core.opt.res+"})
    public static Class INVOKESTATIC_com_bytedance_mira_plugin_trip_opt_ClassDefOpt_com_larus_mirabridge_impl_lancet_MiraReflectLancet_forName(String r100) throws ClassNotFoundException {
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

    public static boolean optClassDef(BaseDexClassLoader r100, String r101) {
        return realOptClassDef(r100, r101);
    L4:
        return false;
    }

    private static boolean realOptClassDef(BaseDexClassLoader r100, String r101) throws IllegalAccessException {
        int r102 = Build.VERSION.SDK_INT;
        int r103 = 0;
        if (r102 >= 29) goto L5;
    L43:
        return false;
    L5:
        if (r102 > 34) goto L43;
        if (r100 != null) goto L9;
        return false;
    L9:
        Field r104 = sPathListFiled;
        if (r104 == null) goto L12;
        Object r105 = r104.get(r100);
    L13:
        if (r105 != null) goto L15;
        return false;
    L15:
        Field r106 = sDexElementsFiled;
        if (r106 == null) goto L18;
        Object r107 = r106.get(r105);
    L19:
        if (r107 != null) goto L22;
        return false;
    L22:
        if ((r107 instanceof Object[]) == false) goto L24;
        Object[] r108 = (Object[]) r107;
    L25:
        if (r108 != null) goto L27;
        return false;
    L27:
        int r109 = r108.length;
    L28:
        if (r103 >= r109) goto L41;
        Object r110 = r108[r103];
        Field r111 = sDexFileField;
        if (r111 == null) goto L32;
        Object r112 = r111.get(r110);
    L33:
        if (r112 == null) goto L37;
        Field r113 = sCookieField;
        if (r113 == null) goto L37;
        Object r114 = r113.get(r112);
    L38:
        if (r114 == null) goto L40;
        opt_class_def_native(r114, r101);
    L40:
        r103 = r103 + 1;
    L37:
        r114 = null;
        goto L38
    L32:
        r112 = null;
        goto L33
    L41:
        return true;
    L24:
        r108 = null;
        goto L25
    L18:
        r107 = null;
        goto L19
    L12:
        r105 = null;
        goto L13
    }
}
