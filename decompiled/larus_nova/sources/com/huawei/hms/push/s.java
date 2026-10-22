package com.huawei.hms.push;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.os.Bundle;
import com.bytedance.mira.exception.PluginClassNotFoundException;
import com.bytedance.mt.protector.impl.string2number.CastIntegerProtector;
import com.huawei.hms.support.log.HMSLog;
import com.larus.mirabridge.impl.lancet.FastClassNotFoundHandler;
import com.larus.mirabridge.impl.lancet.MiraPluginFix;
import java.lang.reflect.Field;
import java.util.concurrent.ConcurrentHashMap;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: classes23.dex */
public class s {
    public static /* synthetic */ Class access$000(String r100) throws ClassNotFoundException {
        return Class.forName(r100);
    }

    @Skip({"com.larus.mirabridge.impl.lancet+", "com.bytedance.mira.hook.delegate.DyMiraClassLoader", "com.bytedance.mira.hook.delegate.MiraClassLoader", "com.bytedance.ies.stark.util.NReflectUtils", "-com.bytedance.mira.core.PluginClassLoader", "com.bytedance.common.jato.util.DeviceInfoUtils", "com.bytedance.mira.helper.ClassLoaderHelper", "com.bytedance.mira.core.opt.res+"})
    public static Class INVOKESTATIC_com_huawei_hms_push_s_com_larus_mirabridge_impl_lancet_MiraReflectLancet_forName(String r100) throws ClassNotFoundException {
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

    public static int a(Context r100, String r101) {
        ApplicationInfo r102 = r100.getPackageManager().getApplicationInfo(r100.getPackageName(), 128);     // Catch: Throwable -> L8
        if (r102 == null) goto L13;
        Bundle r103 = r102.metaData;     // Catch: Throwable -> L8
        if (r103 == null) goto L14;
        return r103.getInt(r101);
    L14:
        return 0;
    L13:
        return 0;
    L8:
        HMSLog.w("ResourceLoader", "load meta data resource failed.");
        return 0;
    }

    public static int a(Context r100, String r101, String r102) {
        int r103 = r100.getResources().getIdentifier(r102, r101, r100.getPackageName());     // Catch: IllegalArgumentException -> L9 IllegalAccessException -> L11 NumberFormatException -> L13 NoSuchFieldException -> L15 ClassNotFoundException -> L17
        if (r103 != 0) goto L8;
        Field r104 = INVOKESTATIC_com_huawei_hms_push_s_com_larus_mirabridge_impl_lancet_MiraReflectLancet_forName(r100.getPackageName() + ".R$" + r101).getField(r102);     // Catch: IllegalArgumentException -> L9 IllegalAccessException -> L11 NumberFormatException -> L13 NoSuchFieldException -> L15 ClassNotFoundException -> L17
        r103 = CastIntegerProtector.parseInt(r104.get(r104.getName()).toString());     // Catch: IllegalArgumentException -> L9 IllegalAccessException -> L11 NumberFormatException -> L13 NoSuchFieldException -> L15 ClassNotFoundException -> L17
        if (r103 != 0) goto L8;
        HMSLog.i("ResourceLoader", "Error-resourceType=" + r101 + "--resourceName=" + r102 + "--resourceId =" + r103);     // Catch: IllegalArgumentException -> L9 IllegalAccessException -> L11 NumberFormatException -> L13 NoSuchFieldException -> L15 ClassNotFoundException -> L17
    L8:
        return r103;
    L17:
        e = move-exception;
        HMSLog.e("ResourceLoader", "!!!! ResourceLoader: ClassNotFoundException-resourceType=" + r101 + "--resourceName=" + r102, e);
        return 0;
    L11:
        e = move-exception;
        HMSLog.e("ResourceLoader", "!!!! ResourceLoader: IllegalAccessException-resourceType=" + r101 + "--resourceName=" + r102, e);
        return 0;
    L13:
        e = move-exception;
        HMSLog.e("ResourceLoader", "!!!! ResourceLoader: NumberFormatException-resourceType=" + r101 + "--resourceName=" + r102, e);
        return 0;
    L9:
        e = move-exception;
        HMSLog.e("ResourceLoader", "!!!! ResourceLoader: IllegalArgumentException-resourceType=" + r101 + "--resourceName=" + r102, e);
        return 0;
    L15:
        e = move-exception;
        HMSLog.e("ResourceLoader", "!!!! ResourceLoader: NoSuchFieldException-resourceType=" + r101 + "--resourceName=" + r102, e);
        return 0;
    }
}
