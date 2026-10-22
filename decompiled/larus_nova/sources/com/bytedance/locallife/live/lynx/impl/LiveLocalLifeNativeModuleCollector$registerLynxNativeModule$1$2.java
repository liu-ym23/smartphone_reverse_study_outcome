package com.bytedance.locallife.live.lynx.impl;

import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import com.lynx.tasm.LynxEnv;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes21.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", AbsMethodDelegate.TAG_INVOKE}, k = 3, mv = {1, 4, 3}, xi = 48)
final class LiveLocalLifeNativeModuleCollector$registerLynxNativeModule$1$2 extends Lambda implements Function0<Unit> {
    public static final LiveLocalLifeNativeModuleCollector$registerLynxNativeModule$1$2 INSTANCE = null;

    static {
        INSTANCE = new LiveLocalLifeNativeModuleCollector$registerLynxNativeModule$1$2();
    }

    public LiveLocalLifeNativeModuleCollector$registerLynxNativeModule$1$2() {
        super(0);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2() {
        int r100 = g.f260559a;
        LynxEnv r101 = LynxEnv.inst();
        if (r101 == null) goto L6;
        r101.registerModule("LiveLifeNativeModule", LiveLifeNativeModule.class);
        return;
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ Unit invoke() {
        invoke2();
        return Unit.INSTANCE;
    }
}
