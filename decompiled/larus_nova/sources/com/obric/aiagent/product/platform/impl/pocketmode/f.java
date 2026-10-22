package com.obric.aiagent.product.platform.impl.pocketmode;

import android.hardware.SensorManager;
import com.larus.apm.impl.protector.RunnableProtector;
import com.obric.aiagent.platform.depend.ILogDepend;

/* JADX INFO: loaded from: classes32.dex */
public final class f implements Runnable {
    public f() {
    }

    public static void a() {
        if (CommonPocketModeDetector.f385026h == false) goto L15;
        int r100 = 0;
        CommonPocketModeDetector.f385026h = false;
        int r101 = CommonPocketModeDetector.f385019a;
        if (CommonPocketModeDetector.b.a() == null) goto L16;
        SensorManager r102 = CommonPocketModeDetector.b.b();
        CommonPocketModeDetector.a r103 = CommonPocketModeDetector.f385025g;
        if (fna.g.d() == true) goto L9;
        r102.unregisterListener(r103);
    L13:
        ILogDepend.f384986a.i("CommonPocketModeDetector", "sensor unregistered");
        return;
    L9:
        r102.unregisterListener(r103);
        if (r103 == null) goto L12;
        r100 = r103.hashCode();
    L12:
        ona.b.c(new ona.a(r100, null));
        goto L13
    L16:
        return;
    }

    @Override // java.lang.Runnable
    public final void run() {
        a();     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }
}
