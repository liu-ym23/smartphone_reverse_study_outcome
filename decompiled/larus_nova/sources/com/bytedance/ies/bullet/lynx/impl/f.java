package com.bytedance.ies.bullet.lynx.impl;

import com.bytedance.ies.bullet.base.utils.logger.HybridLogger;
import com.lynx.canvas.KryptonApp;
import com.lynx.canvas.KryptonService;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes19.dex */
public final class f extends KryptonService {
    public f() {
    }

    @Override // com.lynx.canvas.KryptonService
    public final void onBootstrap(KryptonApp r110) {
        Intrinsics.checkNotNullParameter(r110, "kryptonApp");
        super.onBootstrap(r110);
        HybridLogger r100 = HybridLogger.f246343a;
        HybridLogger.m("XMotion", "PhysicsKryptonRuntimeServiceImpl onBootstrap run" + r110.getJsEnv(), null, null, 12);
        Long r111 = Long.valueOf(r110.getJsEnv());
        if (r111 == null) goto L22;
        long r101 = r111.longValue();
        Class<?> r112 = h26.b.f483614a;
        HybridLogger.m("XMotion", "callBindMotion call", null, null, 12);
    L17:
        e = move-exception;
        HybridLogger r102 = HybridLogger.f246343a;
        HybridLogger.i("XMotion", "motion bind error:" + e.getMessage(), null, 12);
        return;
    L6:
        if (h26.b.f483614a != null) goto L8;
        h26.b.f483614a = h26.b.a("com.bytedance.interaction.game.ext.motion.MotionSdk");     // Catch: Exception -> L17
    L8:
        Class<?> r113 = h26.b.f483614a;     // Catch: Exception -> L17
        if (r113 != null) goto L12;
        Intrinsics.throwUninitializedPropertyAccessException("motionClass");     // Catch: Exception -> L17
        r113 = null;
    L12:
        Object r114 = r113.getDeclaredField("INSTANCE").get(null);     // Catch: Exception -> L17
        Class<?> r103 = h26.b.f483614a;     // Catch: Exception -> L17
        if (r103 != null) goto L15;
        Intrinsics.throwUninitializedPropertyAccessException("motionClass");     // Catch: Exception -> L17
        r103 = null;
    L15:
        r103.getDeclaredMethod("nativeBindMotion", new Class[]{Long.TYPE}).invoke(r114, new Object[]{Long.valueOf(r101)});     // Catch: Exception -> L17
        return;
    }
}
