package com.ss.android.lark.chat.chatwindow.chat.data.convert.textrender.v2;

import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes35.dex */
public final class i<A, B, C, R> extends e implements Function3<A, B, C, R> {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Function3<A, B, C, R> f412510c;

    public i(a r100, Function3 r101) {
        Intrinsics.checkNotNullParameter(r100, "scope");
        Intrinsics.checkNotNullParameter("image", "role");
        Intrinsics.checkNotNullParameter(r101, "action");
        super(r100, "image");
        this.f412510c = r101;
    }

    @Override // kotlin.jvm.functions.Function3
    public final R invoke(A r100, B r101, C r102) {
        return this.f412510c.invoke(r100, r101, r102);
    }
}
