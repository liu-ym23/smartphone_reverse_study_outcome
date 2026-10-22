package com.bytedance.ies.bullet.lynx.impl;

import com.bytedance.ies.bullet.base.utils.logger.HybridLogger;
import com.lynx.canvas.KryptonApp;
import com.lynx.canvas.KryptonService;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes19.dex */
public final class d extends KryptonService {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Long f247321a;

    @Override // com.lynx.canvas.KryptonService
    public final void onDestroy() {
        super.onDestroy();
        Long r100 = this.f247321a;
        if (r100 == null) goto L22;
        long r101 = r100.longValue();
        Class<?> r102 = h26.b.f483614a;
        HybridLogger r103 = HybridLogger.f246343a;
        HybridLogger.m("XMotion", "callUnbindKtx2 call,jsEnv:" + r101, null, null, 12);
    L17:
        e = move-exception;
        HybridLogger r104 = HybridLogger.f246343a;
        HybridLogger.i("XMotion", "ktx2 unbind error:" + e.getMessage(), null, 12);
        return;
    L6:
        if (h26.b.f483615b != null) goto L8;
        h26.b.f483615b = h26.b.a("com.bytedance.interaction.game.ext.compress.MotionCompressSdk");     // Catch: Exception -> L17
    L8:
        Class<?> r105 = h26.b.f483615b;     // Catch: Exception -> L17
        if (r105 != null) goto L12;
        Intrinsics.throwUninitializedPropertyAccessException("compressClass");     // Catch: Exception -> L17
        r105 = null;
    L12:
        Object r106 = r105.getDeclaredField("INSTANCE").get(null);     // Catch: Exception -> L17
        Class<?> r107 = h26.b.f483615b;     // Catch: Exception -> L17
        if (r107 != null) goto L15;
        Intrinsics.throwUninitializedPropertyAccessException("compressClass");     // Catch: Exception -> L17
        r107 = null;
    L15:
        r107.getDeclaredMethod("nativeUnBindKTX2", new Class[0]).invoke(r106, new Object[0]);     // Catch: Exception -> L17
        return;
    }

    public d() {
    }

    @Override // com.lynx.canvas.KryptonService
    public final void onBootstrap(KryptonApp r110) {
        Intrinsics.checkNotNullParameter(r110, "kryptonApp");
        super.onBootstrap(r110);
        HybridLogger r100 = HybridLogger.f246343a;
        HybridLogger.m("XMotion", "KTX2KryptonRuntimeServiceImpl onBootstrap run" + r110.getJsEnv(), null, null, 12);
        Long r111 = Long.valueOf(r110.getJsEnv());
        this.f247321a = r111;
        if (r111 == null) goto L22;
        long r101 = r111.longValue();
        Class<?> r112 = h26.b.f483614a;
        HybridLogger.m("XMotion", "callBindKtx2 call", null, null, 12);
    L17:
        e = move-exception;
        HybridLogger r102 = HybridLogger.f246343a;
        HybridLogger.i("XMotion", "ktx2 bind error:" + e.getMessage(), null, 12);
        return;
    L6:
        if (h26.b.f483615b != null) goto L8;
        h26.b.f483615b = h26.b.a("com.bytedance.interaction.game.ext.compress.MotionCompressSdk");     // Catch: Exception -> L17
    L8:
        Class<?> r113 = h26.b.f483615b;     // Catch: Exception -> L17
        if (r113 != null) goto L12;
        Intrinsics.throwUninitializedPropertyAccessException("compressClass");     // Catch: Exception -> L17
        r113 = null;
    L12:
        Object r114 = r113.getDeclaredField("INSTANCE").get(null);     // Catch: Exception -> L17
        Class<?> r103 = h26.b.f483615b;     // Catch: Exception -> L17
        if (r103 != null) goto L15;
        Intrinsics.throwUninitializedPropertyAccessException("compressClass");     // Catch: Exception -> L17
        r103 = null;
    L15:
        r103.getDeclaredMethod("nativeBindKTX2", new Class[]{Long.TYPE}).invoke(r114, new Object[]{Long.valueOf(r101)});     // Catch: Exception -> L17
        return;
    }
}
