package com.bytedance.assem.arch.reused;

import com.bytedance.assem.arch.viewModel.AssemViewModel;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.reflect.KClass;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class s {
    public final ConcurrentHashMap<KClass<?>, Object> a;
    public final ConcurrentHashMap<KClass<?>, AssemViewModel<?>> b;

    public s() {
        this.a = new ConcurrentHashMap();
        this.b = new ConcurrentHashMap();
    }
}
