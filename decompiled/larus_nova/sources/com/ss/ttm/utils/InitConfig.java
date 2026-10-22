package com.ss.ttm.utils;

import com.bytedance.mira.exception.PluginClassNotFoundException;
import com.larus.mirabridge.impl.lancet.FastClassNotFoundHandler;
import com.larus.mirabridge.impl.lancet.MiraPluginFix;
import el9.a;
import java.lang.reflect.Method;
import java.util.concurrent.ConcurrentHashMap;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: classes40.dex */
public class InitConfig {
    static final int Chain = 0;
    static final int Copy = 1;
    static ConfigFactory gFactory;
    private static volatile boolean mHasTriedGetMethod;
    static Method sMethodCreate;
    private boolean committed;
    private ConfigAPI mNative;

    public static /* synthetic */ Class access$000(String r100) throws ClassNotFoundException {
        return Class.forName(r100);
    }

    public void commit() {
        this.committed = true;
    }

    public long nativeHandle() {
        ConfigAPI r100 = this.mNative;
        if (r100 != null) goto L6;
        return 0;
    L6:
        return r100.nativeHandle();
    }

    public void release() {
        ConfigAPI r100 = this.mNative;
        this.mNative = null;
        if (r100 == null) goto L6;
        r100.release();
        return;
    }

    public void finalize() throws Throwable {
        super.finalize();
        release();
    }

    @Skip({"com.larus.mirabridge.impl.lancet+", "com.bytedance.mira.hook.delegate.DyMiraClassLoader", "com.bytedance.mira.hook.delegate.MiraClassLoader", "com.bytedance.ies.stark.util.NReflectUtils", "-com.bytedance.mira.core.PluginClassLoader", "com.bytedance.common.jato.util.DeviceInfoUtils", "com.bytedance.mira.helper.ClassLoaderHelper", "com.bytedance.mira.core.opt.res+"})
    public static Class INVOKESTATIC_com_ss_ttm_utils_InitConfig_com_larus_mirabridge_impl_lancet_MiraReflectLancet_forName(String r100) throws ClassNotFoundException {
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

    public static void setFactory(ConfigFactory r100) {
        gFactory = r100;
    }

    public InitConfig(long r110, int r111) {
        this.mNative = null;
        this.committed = false;
        ConfigFactory r100 = gFactory;
        if (r100 == null) goto L6;
        this.mNative = r100.createConfig(r110, r111);
        return;
    L6:
        if (mHasTriedGetMethod == false) goto L8;
    L20:
        Method r101 = sMethodCreate;
        if (r101 != null) goto L30;
        return;
    L30:
        r101.setAccessible(true);     // Catch: Exception -> L25
        this.mNative = (ConfigAPI) sMethodCreate.invoke(null, new Object[]{Long.valueOf(r110), Integer.valueOf(r111)});     // Catch: Exception -> L25
        return;
    L33:
        return;
    L8:
        monitor-enter(InitConfig.class);
    L17:
        th = move-exception;
        throw th;
    L10:
        if (mHasTriedGetMethod == true) goto L15;
        mHasTriedGetMethod = true;     // Catch: Throwable -> L17
        sMethodCreate = INVOKESTATIC_com_ss_ttm_utils_InitConfig_com_larus_mirabridge_impl_lancet_MiraReflectLancet_forName("com.ss.ttm.utils.ConfigImpl").getDeclaredMethod("create", new Class[]{Long.TYPE, Integer.TYPE});     // Catch: Exception -> L14 Throwable -> L17
    L14:
        sMethodCreate = null;     // Catch: Throwable -> L17
    L15:
        monitor-exit(InitConfig.class);     // Catch: Throwable -> L17
        goto L20
    }

    public int getIntValue(int r100, int r101) {
        ConfigAPI r102 = this.mNative;
        if (r102 != null) goto L5;
        return r101;
    L5:
        return r102.getIntValue(r100, r101);
    }

    public void setIntValue(int r100, int r101) {
        ConfigAPI r102 = this.mNative;
        if (r102 != null) goto L5;
        return;
    L5:
        if (this.committed == true) goto L9;
        r102.setIntValue(r100, r101);
        return;
    }
}
