package com.bytedance.salamander.adapter;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class o {
    public final p a;
    public final e b;

    public static final class a {
    }

    static {
    }

    public o(p r4) {
        Intrinsics.checkNotNullParameter(r4, "impl");
        new i("salamander_storage_async_queue", false);
        this.b = new e();
        this.a = r4;
    }
}
