package com.ss.android.lark.chat.chatwindow.chat.data.convert.textrender.v2;

import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes35.dex */
public final class g<R> extends e implements Function0<R> {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Function0<R> f412508c;

    @Override // kotlin.jvm.functions.Function0
    public final R invoke() {
        return this.f412508c.invoke();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public g(a r100, String r101, Function0<? extends R> r102) {
        Intrinsics.checkNotNullParameter(r100, "scope");
        Intrinsics.checkNotNullParameter(r101, "role");
        Intrinsics.checkNotNullParameter(r102, "action");
        super(r100, r101);
        this.f412508c = r102;
    }
}
