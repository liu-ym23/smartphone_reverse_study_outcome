package com.bytedance.android.livesdk.maker;

import java.lang.reflect.Method;
import kotlin.Lazy;
import kotlin.LazyKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class HonorStreamKit {
    public final Lazy a;

    public final Method a() {
        return (Method) this.a.getValue();
    }

    public HonorStreamKit() {
        this.a = LazyKt.lazy(new HonorStreamKit$method$2(this));
    }
}
