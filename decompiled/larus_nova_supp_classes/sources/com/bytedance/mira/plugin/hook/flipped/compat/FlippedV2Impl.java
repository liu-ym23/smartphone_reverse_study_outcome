package com.bytedance.mira.plugin.hook.flipped.compat;

import android.util.Log;
import com.bytedance.mira.exception.PluginClassNotFoundException;
import com.larus.mirabridge.impl.lancet.FastClassNotFoundHandler;
import com.larus.mirabridge.impl.lancet.MiraPluginFix;
import el9.a;
import java.lang.reflect.Method;
import java.util.concurrent.ConcurrentHashMap;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes.dex */
public class FlippedV2Impl implements IFlipped {
    private static final String TAG = "FlippedV2Impl";

    public FlippedV2Impl() {
    }

    public static /* synthetic */ Class access$000(String r0) throws ClassNotFoundException {
        return Class.forName(r0);
    }

    private native Method getDeclaredMethod(Object r1, String r2, Class<?>[] r3);

    static {
        System.loadLibrary("flipped");
    }

    @Override // com.bytedance.mira.plugin.hook.flipped.compat.IFlipped
    public void invokeHiddenApiRestrictions() {
        Class r0 = INVOKESTATIC_com_bytedance_mira_plugin_hook_flipped_compat_FlippedV2Impl_com_larus_mirabridge_impl_lancet_MiraReflectLancet_forName("dalvik.system.VMRuntime");     // Catch: Exception -> L4
        Method r1 = getDeclaredMethod(r0, "getRuntime", new Class[0]);     // Catch: Exception -> L4
        r1.setAccessible(true);     // Catch: Exception -> L4
        Object r2 = r1.invoke(null, new Object[0]);     // Catch: Exception -> L4
        Method r3 = getDeclaredMethod(r0, "setHiddenApiExemptions", new Class[]{String[].class});     // Catch: Exception -> L4
        r3.setAccessible(true);     // Catch: Exception -> L4
        r3.invoke(r2, new Object[]{new String[]{"L"}});     // Catch: Exception -> L4
        return;
    L4:
        e = move-exception;
        Log.getStackTraceString(e);
    }

    @Skip({"com.larus.mirabridge.impl.lancet+", "com.bytedance.mira.hook.delegate.DyMiraClassLoader", "com.bytedance.mira.hook.delegate.MiraClassLoader", "com.bytedance.ies.stark.util.NReflectUtils", "-com.bytedance.mira.core.PluginClassLoader", "com.bytedance.common.jato.util.DeviceInfoUtils", "com.bytedance.mira.helper.ClassLoaderHelper", "com.bytedance.mira.core.opt.res+"})
    public static Class INVOKESTATIC_com_bytedance_mira_plugin_hook_flipped_compat_FlippedV2Impl_com_larus_mirabridge_impl_lancet_MiraReflectLancet_forName(String r3) throws ClassNotFoundException {
        ConcurrentHashMap<String, FastClassNotFoundHandler.Status> r0 = FastClassNotFoundHandler.a;
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
}
