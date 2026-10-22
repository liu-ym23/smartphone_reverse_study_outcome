package com.bytedance.android.shopping.store.viewmodel;

import android.view.KeyCharacterMap;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClass;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class h implements i {
    public final ConcurrentHashMap<KClass<?>, i> a;

    public h() {
        this.a = new ConcurrentHashMap();
    }

    public final <T extends i> void d(KClass<?> r3, T r4) {
        Intrinsics.checkNotNullParameter(r3, "className");
        Intrinsics.checkNotNullParameter(r4, "instance");
        if (this.a.containsKey(Reflection.getOrCreateKotlinClass(r3.getClass())) == true) goto L7;
        this.a.put(r3, r4);
        return;
    L7:
        throw new KeyCharacterMap.UnavailableException("重复设置function");
    }
}
