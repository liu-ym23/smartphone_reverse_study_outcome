package com.lark.kmp.storage;

import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes24.dex */
public final class UserLarkStorage {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f282687a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final List<com.lark.kmp.storage.file.c> f282688b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final List<com.lark.kmp.storage.kv.b> f282689c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Lazy f282690d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Lazy f282691e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Lazy f282692f;

    /* JADX WARN: Multi-variable type inference failed */
    public UserLarkStorage(String r100, List<? extends com.lark.kmp.storage.file.c> r101, List<? extends com.lark.kmp.storage.kv.b> r102) {
        Intrinsics.checkNotNullParameter(r100, "userId");
        Intrinsics.checkNotNullParameter(r101, "fileDelegateFactories");
        Intrinsics.checkNotNullParameter(r102, "kvDelegateFactories");
        this.f282687a = r100;
        this.f282688b = r101;
        this.f282689c = r102;
        this.f282690d = LazyKt.lazy(UserLarkStorage$storageConfiguration$2.INSTANCE);
        this.f282691e = LazyKt.lazy(new UserLarkStorage$fs$2(this));
        this.f282692f = LazyKt.lazy(new UserLarkStorage$kvs$2(this));
    }
}
