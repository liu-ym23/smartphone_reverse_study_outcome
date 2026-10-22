package com.bytedance.common.jato.boost.hardware;

import android.content.Context;
import android.os.Build;
import com.bytedance.common.jato.util.DoubleReflector;
import java.lang.reflect.Method;

/* JADX INFO: loaded from: classes15.dex */
public class HisiCpuBoost implements ICpuBoost {
    private BoostFramework mFramework;
    private Class perfClass;
    private Method perfEventMethod;
    private Object perfObject;

    @Override // com.bytedance.common.jato.boost.hardware.ICpuBoost
    public void release() {
    }

    @Override // com.bytedance.common.jato.boost.hardware.ICpuBoost
    public boolean tryBoostGpu(long r100) {
        return false;
    }

    public HisiCpuBoost() {
        this.perfClass = null;
        this.perfEventMethod = null;
        this.perfObject = null;
    }

    @Override // com.bytedance.common.jato.boost.hardware.ICpuBoost
    public boolean tryBoostCpu(long r100) {
        if (r100 > 0) goto L27;
        return false;
    L27:
        int r101 = Build.VERSION.SDK_INT;     // Catch: Throwable -> L24
        if (r101 != 29) goto L9;
        this.perfEventMethod.invoke(this.perfObject, new Object[]{Integer.valueOf((int) r100)});     // Catch: Throwable -> L24
    L23:
        return true;
    L9:
        if (r101 != 28) goto L11;
        boolean r102 = true;
    L13:
        if (r101 != 27) goto L15;
        boolean r103 = true;
    L16:
        boolean r104 = r102 | r103;     // Catch: Throwable -> L24
        if (r101 != 26) goto L19;
        boolean r105 = true;
    L21:
        if ((r104 | r105) == false) goto L23;
        ((Integer) this.perfEventMethod.invoke(this.perfObject, new Object[]{4099, "canBoost=true|screenOn=1", new int[0]})).intValue();     // Catch: Throwable -> L24
        goto L23
    L19:
        r105 = false;
        goto L21
    L15:
        r103 = false;
        goto L16
    L11:
        r102 = false;
    L24:
        th = move-exception;
        this.mFramework.errorLog("cpuboost boost fail:" + th);
        return false;
    }

    @Override // com.bytedance.common.jato.boost.hardware.ICpuBoost
    public void init(BoostFramework r100, Context r101) {
        this.mFramework = r100;
        int r102 = Build.VERSION.SDK_INT;     // Catch: Throwable -> L23
        if (r102 != 29) goto L8;
        Class<?> r103 = DoubleReflector.getClass("android.scrollerboostmanager.ScrollerBoostManager");     // Catch: Throwable -> L23
        this.perfObject = DoubleReflector.getMethod(r103, "getInstance", null).invoke(r103, null);     // Catch: Throwable -> L23
        this.perfEventMethod = DoubleReflector.getMethod(r103, "listFling", new Class[]{Integer.TYPE});     // Catch: Throwable -> L23
        r103.getDeclaredMethod("init", null).invoke(this.perfObject, null);     // Catch: Throwable -> L23
    L26:
        return;
    L8:
        if (r102 != 28) goto L10;
        boolean r104 = true;
    L12:
        if (r102 != 27) goto L14;
        boolean r105 = true;
    L15:
        boolean r106 = r104 | r105;     // Catch: Throwable -> L23
        if (r102 != 26) goto L18;
        boolean r107 = true;
    L20:
        if ((r107 | r106) == false) goto L26;
        Class<?> r108 = DoubleReflector.getClass("android.iawareperf.UniPerf");     // Catch: Throwable -> L23
        this.perfClass = r108;     // Catch: Throwable -> L23
        this.perfEventMethod = DoubleReflector.getMethod(r108, "uniPerfEvent", new Class[]{Integer.TYPE, String.class, int[].class});     // Catch: Throwable -> L23
        this.perfObject = DoubleReflector.getMethod(this.perfClass, "getInstance", new Class[0]).invoke(null, new Object[0]);     // Catch: Throwable -> L23
        goto L26
    L18:
        r107 = false;
        goto L20
    L14:
        r105 = false;
        goto L15
    L10:
        r104 = false;
    L23:
        th = move-exception;
        this.mFramework.errorLog("cpuboost init fail:" + th);
    }
}
