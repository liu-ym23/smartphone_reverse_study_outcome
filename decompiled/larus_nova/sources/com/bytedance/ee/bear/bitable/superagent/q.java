package com.bytedance.ee.bear.bitable.superagent;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes16.dex */
public final class q {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f215917a = 0;

    static {
    }

    public static BitableMobileAIConfig a() {
        int r100 = com.bytedance.ee.bear.bitable.core.usercomponent.b.f210588a;
        Intrinsics.checkNotNullParameter(BitableMobileAIConfig.class, "clazz");
        BitableMobileAIConfig r101 = (BitableMobileAIConfig) com.bytedance.ee.bear.bitable.core.usercomponent.b.a().J().get(BitableMobileAIConfig.class);
        if (r101 == null) goto L5;
        return r101;
    L5:
        return new BitableMobileAIConfig();
    }
}
