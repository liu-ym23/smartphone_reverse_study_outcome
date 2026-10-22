package com.ss.android.lark.security.compliance.infra.network.userscpoe;

import com.bytedance.lark.rustclient.api.l;
import com.ss.android.lark.passportc.dwarf.UserScope;
import javax.inject.Inject;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.Dispatchers;

/* JADX INFO: loaded from: classes38.dex */
@UserScope
public final class SCRequestUserScopeImpl implements a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final d f440457a;

    @Inject
    public SCRequestUserScopeImpl(l r100, final jdb.g r101) {
        Intrinsics.checkNotNullParameter(r100, "userClient");
        Intrinsics.checkNotNullParameter(r101, "userFG");
        if (w4c.c.a().x() == false) goto L5;
        com.ss.android.lark.security.compliance.infra.network.f r102 = new g(r100);
    L6:
        this.f440457a = new d(r102, new SCRequestUserScopeImpl$requestManager$1(r101));
        return;
    L5:
        r102 = new f(r100);
        goto L6
    }

    @Override // com.ss.android.lark.security.compliance.infra.network.userscpoe.a
    public final <T> void a(com.ss.android.lark.security.compliance.infra.network.g r100, com.ss.android.lark.security.compliance.infra.network.d<T> r101) {
        Intrinsics.checkNotNullParameter(r100, "request");
        Intrinsics.checkNotNullParameter(r101, "callback");
        BuildersKt.launch$default(com.ss.android.lark.security.compliance.infra.base.a.f440424a, Dispatchers.getIO(), null, new SCRequestUserScopeImpl$async$1(this, r100, r101, null), 2, null);
    }
}
