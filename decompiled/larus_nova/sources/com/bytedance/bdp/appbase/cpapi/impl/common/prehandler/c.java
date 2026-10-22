package com.bytedance.bdp.appbase.cpapi.impl.common.prehandler;

import kotlin.Lazy;
import kotlin.LazyKt;

/* JADX INFO: loaded from: classes11.dex */
public final class c extends com.bytedance.bdp.appbase.cpapi.contextservice.base.a {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Lazy f200786c;

    public c(com.bytedance.bdp.appbase.cpapi.contextservice.base.b r100) {
        super(r100);
        this.f200786c = LazyKt.lazy(new AppPermissionPreHandler$userPrivacyAgreementService$2(this));
    }
}
