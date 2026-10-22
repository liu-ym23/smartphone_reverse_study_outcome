package com.larus.im.internal;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
public final class s implements hd9.n {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final gd9.r f350069a;

    @Override // hd9.n
    public final hd9.p a() {
        return new OmniNativeHandlerBridgeProvider(this.f350069a);
    }

    @Override // hd9.n
    public final hd9.l b() {
        return new r(this.f350069a);
    }

    @Override // hd9.n
    public final hd9.q c() {
        return u.f350517a;
    }

    public s(gd9.r r100) {
        Intrinsics.checkNotNullParameter(r100, "dependency");
        this.f350069a = r100;
    }
}
