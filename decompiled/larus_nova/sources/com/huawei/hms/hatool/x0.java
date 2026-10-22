package com.huawei.hms.hatool;

import android.content.Context;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import android.util.AndroidRuntimeException;
import android.util.Pair;
import com.bytedance.mira.exception.PluginClassNotFoundException;
import com.larus.mirabridge.impl.lancet.FastClassNotFoundHandler;
import com.larus.mirabridge.impl.lancet.MiraPluginFix;
import java.lang.reflect.InvocationTargetException;
import java.util.concurrent.ConcurrentHashMap;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: classes23.dex */
public class x0 extends o {
    public static /* synthetic */ Class access$000(String r100) throws ClassNotFoundException {
        return Class.forName(r100);
    }

    public static String c() {
        String r100 = "";
        String r101 = (String) INVOKESTATIC_com_huawei_hms_hatool_x0_com_larus_mirabridge_impl_lancet_MiraReflectLancet_forName("com.huawei.android.os.BuildEx").getMethod("getUDID", new Class[0]).invoke(null, new Object[0]);     // Catch: InvocationTargetException -> L22 IllegalArgumentException -> L23 IllegalAccessException -> L24 NoSuchMethodException -> L25 AndroidRuntimeException -> L26 ClassNotFoundException -> L27
        v.c("hmsSdk", "getUDID success");     // Catch: InvocationTargetException -> L8 IllegalArgumentException -> L9 IllegalAccessException -> L10 NoSuchMethodException -> L11 AndroidRuntimeException -> L12 ClassNotFoundException -> L13
    L32:
        return r101;
    L12:
        r100 = r101;
    L13:
        r100 = r101;
    L10:
        r100 = r101;
    L9:
        r100 = r101;
    L11:
        r100 = r101;
    L8:
        r100 = r101;
        goto L14
    L18:
        String r102 = "getUDID getudid failed, RuntimeException is AndroidRuntimeException";
    L20:
        v.f("hmsSdk", r102);
        return r100;
    L19:
        r102 = "getUDID method invoke failed";
    L16:
        r102 = "getUDID method invoke failed : Illegal AccessException";
    L15:
        r102 = "getUDID method invoke failed : Illegal ArgumentException";
    L17:
        r102 = "getUDID method invoke failed : NoSuchMethodException";
    L14:
        r102 = "getUDID method invoke failed : InvocationTargetException";
        goto L20
    }

    public static Pair<String, String> e(Context r100) {
        if (c0.a(r100, "android.permission.READ_PHONE_STATE") == false) goto L6;
        v.f("hmsSdk", "getMccAndMnc() Pair value is empty");
        return new Pair("", "");
    L6:
        TelephonyManager r101 = (TelephonyManager) r100.getSystemService("phone");
        if (r101 != null) goto L11;
        return new Pair("", "");
    L11:
        if (r101.getSimState() != 5) goto L13;
        String r102 = r101.getNetworkOperator();
        if (TextUtils.isEmpty(r102) == true) goto L26;
        if (TextUtils.equals(r102, "null") == true) goto L26;
        if (r102.length() <= 3) goto L24;
        return new Pair(r102.substring(0, 3), r102.substring(3));
    L24:
        return new Pair("", "");
    L26:
        return new Pair("", "");
    L13:
        return new Pair("", "");
    }

    @Skip({"com.larus.mirabridge.impl.lancet+", "com.bytedance.mira.hook.delegate.DyMiraClassLoader", "com.bytedance.mira.hook.delegate.MiraClassLoader", "com.bytedance.ies.stark.util.NReflectUtils", "-com.bytedance.mira.core.PluginClassLoader", "com.bytedance.common.jato.util.DeviceInfoUtils", "com.bytedance.mira.helper.ClassLoaderHelper", "com.bytedance.mira.core.opt.res+"})
    public static Class INVOKESTATIC_com_huawei_hms_hatool_x0_com_larus_mirabridge_impl_lancet_MiraReflectLancet_forName(String r100) throws ClassNotFoundException {
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
}
