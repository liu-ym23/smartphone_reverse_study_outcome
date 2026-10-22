package com.bytedance.bdp.appbase.cpapi.impl.common.prehandler;

import kotlin.Lazy;
import kotlin.LazyKt;

/* JADX INFO: loaded from: classes11.dex */
public final class e extends com.bytedance.bdp.appbase.cpapi.contextservice.base.a {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Lazy f200789c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Lazy f200790d;

    public e(com.bytedance.bdp.appbase.cpapi.contextservice.base.b r100) {
        super(r100);
        this.f200789c = LazyKt.lazy(new LoginStatusPreHandler$mHostInfoService$2(this));
        this.f200790d = LazyKt.lazy(new LoginStatusPreHandler$mSandboxAppService$2(this));
    }
}
