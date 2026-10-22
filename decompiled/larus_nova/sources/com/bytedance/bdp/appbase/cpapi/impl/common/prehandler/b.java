package com.bytedance.bdp.appbase.cpapi.impl.common.prehandler;

import kotlin.Lazy;
import kotlin.LazyKt;

/* JADX INFO: loaded from: classes11.dex */
public final class b extends com.bytedance.bdp.appbase.cpapi.contextservice.base.a {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Lazy f200784c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Lazy f200785d;

    public static final class a {
    }

    static {
    }

    public b(com.bytedance.bdp.appbase.cpapi.contextservice.base.b r100) {
        super(r100);
        this.f200784c = LazyKt.lazy(new ApiPermissionPreHandler$mPermissionService$2(this));
        this.f200785d = LazyKt.lazy(new ApiPermissionPreHandler$mSafeCheckService$2(this));
    }
}
