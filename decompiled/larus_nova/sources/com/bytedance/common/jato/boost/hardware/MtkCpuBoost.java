package com.bytedance.common.jato.boost.hardware;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import com.bytedance.mira.exception.PluginClassNotFoundException;
import com.larus.mirabridge.impl.lancet.FastClassNotFoundHandler;
import com.larus.mirabridge.impl.lancet.MiraPluginFix;
import el9.a;
import java.lang.reflect.Method;
import java.util.concurrent.ConcurrentHashMap;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: classes15.dex */
public class MtkCpuBoost implements ICpuBoost {
    private Method disableMethod;
    private Method enableMethod;
    private BoostFramework mFramework;
    private Object perfObject;
    private Method registerMethod;
    private Method setConfigMethod;

    public MtkCpuBoost() {
    }

    public static /* synthetic */ Class access$001(String r100) throws ClassNotFoundException {
        return Class.forName(r100);
    }

    @Override // com.bytedance.common.jato.boost.hardware.ICpuBoost
    public void release() {
        this.disableMethod.invoke(this.perfObject, new Object[0]);     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        this.mFramework.errorLog("cpuboost release fail" + th.getMessage());
    }

    @Skip({"com.larus.mirabridge.impl.lancet+", "com.bytedance.mira.hook.delegate.DyMiraClassLoader", "com.bytedance.mira.hook.delegate.MiraClassLoader", "com.bytedance.ies.stark.util.NReflectUtils", "-com.bytedance.mira.core.PluginClassLoader", "com.bytedance.common.jato.util.DeviceInfoUtils", "com.bytedance.mira.helper.ClassLoaderHelper", "com.bytedance.mira.core.opt.res+"})
    public static Class INVOKESTATIC_com_bytedance_common_jato_boost_hardware_MtkCpuBoost_com_larus_mirabridge_impl_lancet_MiraReflectLancet_forName(String r100) throws ClassNotFoundException {
        ConcurrentHashMap<String, FastClassNotFoundHandler.Status> r101 = FastClassNotFoundHandler.f359329a;
        FastClassNotFoundHandler.Status r102 = FastClassNotFoundHandler.Status.STATUS_NOTING;
        if (a.a() == true) goto L34;
        Class r103 = access$001(r100);     // Catch: Throwable -> L8
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
        Class r104 = access$001(r100);     // Catch: Throwable -> L17
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

    public static /* synthetic */ Object access$000(MtkCpuBoost r100) {
        return r100.perfObject;
    }

    public static /* synthetic */ Method access$100(MtkCpuBoost r100) {
        return r100.disableMethod;
    }

    public static /* synthetic */ BoostFramework access$200(MtkCpuBoost r100) {
        return r100.mFramework;
    }

    @Override // com.bytedance.common.jato.boost.hardware.ICpuBoost
    public boolean tryBoostCpu(long r100) {
        if (invokeBoost(r100, 23) == false) goto L5;
    L8:
        return true;
    L5:
        if (invokeBoost(r100, 4) == true) goto L8;
        return false;
    }

    @Override // com.bytedance.common.jato.boost.hardware.ICpuBoost
    public boolean tryBoostGpu(long r100) {
        return invokeBoost(r100, 8);
    }

    private boolean invokeBoost(long r100, int r110) {
        if (r100 > 0) goto L10;
        return false;
    L10:
        int r101 = ((Integer) this.registerMethod.invoke(this.perfObject, new Object[0])).intValue();     // Catch: Throwable -> L7
        this.setConfigMethod.invoke(this.perfObject, new Object[]{Integer.valueOf(r101), Integer.valueOf(r110), 1000, 0, 0, 0});     // Catch: Throwable -> L7
        this.enableMethod.invoke(this.perfObject, new Object[]{Integer.valueOf(r101)});     // Catch: Throwable -> L7
        new Handler(Looper.getMainLooper()).postDelayed(new AnonymousClass1(this), r100);     // Catch: Throwable -> L7
        return true;
    L7:
        th = move-exception;
        this.mFramework.errorLog("cpuboost boost fail: " + th.getMessage());
        return false;
    }

    @Override // com.bytedance.common.jato.boost.hardware.ICpuBoost
    public void init(BoostFramework r100, Context r101) {
        this.mFramework = r100;
        Class r102 = INVOKESTATIC_com_bytedance_common_jato_boost_hardware_MtkCpuBoost_com_larus_mirabridge_impl_lancet_MiraReflectLancet_forName("com.mediatek.perfservice.PerfServiceWrapper");     // Catch: Throwable -> L10
        this.perfObject = r102.getConstructor(new Class[0]).newInstance(new Object[0]);     // Catch: Throwable -> L7
    L8:
        this.registerMethod = r102.getDeclaredMethod("userRegScn", new Class[0]);     // Catch: Throwable -> L10
        Class<?> r103 = Integer.TYPE;     // Catch: Throwable -> L10
        this.setConfigMethod = r102.getDeclaredMethod("userRegScnConfig", new Class[]{r103, r103, r103, r103, r103, r103});     // Catch: Throwable -> L10
        this.enableMethod = r102.getDeclaredMethod("userEnable", new Class[]{r103});     // Catch: Throwable -> L10
        this.disableMethod = r102.getDeclaredMethod("userResetAll", new Class[0]);     // Catch: Throwable -> L10
        return;
    L7:
        this.perfObject = r102.getConstructor(new Class[]{Context.class}).newInstance(new Object[]{r101});     // Catch: Throwable -> L10
    L10:
        th = move-exception;
        this.mFramework.errorLog("cpuboost init fail: " + th.getMessage());
    }
}
