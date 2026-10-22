package com.bytedance.ee.bear.facade.common.empty;

import android.content.Context;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class DefaultConfig {
    public final Context a;
    public final Function0<Config> b;

    public final Context getContext() {
        return this.a;
    }

    public DefaultConfig(Context r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
        this.a = r2;
        this.b = new DefaultConfig$default$1(this);
    }
}
