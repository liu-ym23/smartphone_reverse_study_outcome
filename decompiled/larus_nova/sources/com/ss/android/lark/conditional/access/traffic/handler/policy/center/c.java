package com.ss.android.lark.conditional.access.traffic.handler.policy.center;

import com.ss.android.lark.conditional.access.traffic.InternalSecurityAction;
import com.ss.android.lark.passportc.api.j;
import com.ss.android.lark.passportc.internal.v;
import com.ss.android.lark.security.compliance.infra.base.UserScopeProxy;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes35.dex */
public final class c extends UserScopeProxy<a> implements a {
    @Override // com.ss.android.lark.conditional.access.traffic.handler.policy.center.a
    public final boolean C5(InternalSecurityAction r100) {
        Intrinsics.checkNotNullParameter(r100, "action");
        return rf().C5(r100);
    }

    @Override // com.ss.android.lark.conditional.access.traffic.handler.policy.center.a
    public final void i3(InternalSecurityAction r100) {
        rf().i3(r100);
    }

    public c(j r100, v r101) {
        Intrinsics.checkNotNullParameter(r100, "passport");
        Intrinsics.checkNotNullParameter(r101, "accessor");
        super(r100, r101, a.class);
    }
}
