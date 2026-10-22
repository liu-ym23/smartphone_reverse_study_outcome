package com.bytedance.ee.permission;

import kotlin.Lazy;
import kotlin.LazyKt;

/* JADX INFO: loaded from: classes19.dex */
public final class PermissionSdk implements a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Lazy f243012a;

    public final b a() {
        return (b) this.f243012a.getValue();
    }

    public PermissionSdk() {
        this.f243012a = LazyKt.lazy(PermissionSdk$apiAll$2.INSTANCE);
    }
}
