package com.bytedance.assem.arch.reused;

import com.bytedance.assem.arch.viewModel.AssemViewModel;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.reflect.KClass;

/* JADX INFO: loaded from: classes14.dex */
public final class s {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ConcurrentHashMap<KClass<?>, Object> f193039a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ConcurrentHashMap<KClass<?>, AssemViewModel<?>> f193040b;

    public s() {
        this.f193039a = new ConcurrentHashMap();
        this.f193040b = new ConcurrentHashMap();
    }
}
