package com.larksuite.framework.http.v2.internal.rust;

import com.bytedance.lark.rustclient.api.l;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes24.dex */
public final class h implements d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final l f285604a;

    public h(l r100) {
        Intrinsics.checkNotNullParameter(r100, "rustClient");
        this.f285604a = r100;
    }

    @Override // com.larksuite.framework.http.v2.internal.rust.d
    public final l a(com.larksuite.framework.http.v2.d r100) {
        Intrinsics.checkNotNullParameter(r100, "userCookieStrategy");
        if ((r100 instanceof com.larksuite.framework.http.v2.d.b) == true) goto L14;
        if ((r100 instanceof com.larksuite.framework.http.v2.d.c) == true) goto L14;
        if ((r100 instanceof com.larksuite.framework.http.v2.d.a) == false) goto L12;
        throw new IllegalArgumentException("LarkHttp can't apply custom user cookie strategy in user scope.");
    L12:
        throw new NoWhenBranchMatchedException();
    L14:
        return this.f285604a;
    }
}
