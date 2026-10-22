package com.bytedance.ee.bear.bitable.superagent;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class q {
    public static final /* synthetic */ int a = 0;

    static {
    }

    public static BitableMobileAIConfig a() {
        int r1 = com.bytedance.ee.bear.bitable.core.usercomponent.b.a;
        Intrinsics.checkNotNullParameter(BitableMobileAIConfig.class, "clazz");
        BitableMobileAIConfig r0 = (BitableMobileAIConfig) com.bytedance.ee.bear.bitable.core.usercomponent.b.a().J().get(BitableMobileAIConfig.class);
        if (r0 == null) goto L5;
        return r0;
    L5:
        return new BitableMobileAIConfig();
    }
}
