package com.larksuite.framework.http.v2.internal.rust;

import com.bytedance.lark.rustclient.api.a0;
import com.bytedance.lark.rustclient.api.l;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes24.dex */
public final class GlobalClientProvider implements d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final com.bytedance.lark.rustclient.api.h f285597a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Function0<String> f285598b;

    @Override // com.larksuite.framework.http.v2.internal.rust.d
    public final l a(final com.larksuite.framework.http.v2.d r100) {
        Intrinsics.checkNotNullParameter(r100, "userCookieStrategy");
        if ((r100 instanceof com.larksuite.framework.http.v2.d.b) == false) goto L5;
    L12:
        Function0<String> r101 = this.f285598b;
    L13:
        com.bytedance.lark.rustclient.api.h r102 = this.f285597a;
        Intrinsics.checkNotNullParameter(r102, "<this>");
        Intrinsics.checkNotNullParameter(r101, "uidProvider");
        return new a0(r102, r101);
    L5:
        if ((r100 instanceof com.larksuite.framework.http.v2.d.c) == true) goto L12;
        if ((r100 instanceof com.larksuite.framework.http.v2.d.a) == false) goto L11;
        r101 = new GlobalClientProvider$provideClient$uid$1(r100);
        goto L13
    L11:
        throw new NoWhenBranchMatchedException();
    }

    public GlobalClientProvider(com.bytedance.lark.rustclient.api.h r100, Function0<String> r101) {
        Intrinsics.checkNotNullParameter(r100, "globalClient");
        Intrinsics.checkNotNullParameter(r101, "uidProvider");
        this.f285597a = r100;
        this.f285598b = r101;
    }
}
