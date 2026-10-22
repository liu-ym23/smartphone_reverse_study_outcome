package com.ss.android.lark.officesdk.integrator.im.sdk.service;

import kotlin.Lazy;
import kotlin.LazyKt;
import okb.i;

/* JADX INFO: loaded from: classes37.dex */
public final class ImSdkStorageProxy implements okb.g {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final com.ss.android.lark.storage.a f433308c = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Lazy f433309a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Lazy f433310b;

    public static final class a {
    }

    static {
        f433308c = new com.ss.android.lark.storage.a("IM");
    }

    @Override // okb.g
    public final i a() {
        return (i) this.f433310b.getValue();
    }

    public ImSdkStorageProxy() {
        this.f433309a = LazyKt.lazy(new ImSdkStorageProxy$kvStoreOfUser$2(this));
        this.f433310b = LazyKt.lazy(new ImSdkStorageProxy$kvStoreOfDevice$2(this));
    }
}
