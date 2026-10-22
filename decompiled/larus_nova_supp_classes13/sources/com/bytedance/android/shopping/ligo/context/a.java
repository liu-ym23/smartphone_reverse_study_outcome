package com.bytedance.android.shopping.ligo.context;

import kotlin.jvm.internal.Intrinsics;
import w83.c;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class a<T extends w83.c> implements w83.b<T> {
    public final b<T> a;

    @Override // w83.b
    public final Object a() {
        Intrinsics.checkNotNullParameter("room_unique_key", "key");
        return this.a.d("room_unique_key");
    }

    public a(b<T> r2, T r3) {
        Intrinsics.checkNotNullParameter(r2, "ligoContext");
        Intrinsics.checkNotNullParameter(r3, "ability");
        this.a = r2;
    }
}
