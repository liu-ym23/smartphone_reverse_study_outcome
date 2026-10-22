package com.lark.kmp.storage;

import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes24.dex */
public final class GlobalLarkStorage {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List<com.lark.kmp.storage.file.c> f282679a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final List<com.lark.kmp.storage.kv.b> f282680b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final f.a f282681c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Lazy f282682d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Lazy f282683e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Lazy f282684f;

    /* JADX WARN: Multi-variable type inference failed */
    public GlobalLarkStorage(List<? extends com.lark.kmp.storage.file.c> r100, List<? extends com.lark.kmp.storage.kv.b> r101) {
        Intrinsics.checkNotNullParameter(r100, "fileDelegateFactories");
        Intrinsics.checkNotNullParameter(r101, "kvDelegateFactories");
        this.f282679a = r100;
        this.f282680b = r101;
        this.f282681c = new f.a(0);
        this.f282682d = LazyKt.lazy(GlobalLarkStorage$storageConfiguration$2.INSTANCE);
        this.f282683e = LazyKt.lazy(new GlobalLarkStorage$fs$2(this));
        this.f282684f = LazyKt.lazy(new GlobalLarkStorage$kvs$2(this));
    }
}
