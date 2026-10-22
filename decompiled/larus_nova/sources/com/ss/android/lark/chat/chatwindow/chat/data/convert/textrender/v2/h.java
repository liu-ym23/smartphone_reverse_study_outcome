package com.ss.android.lark.chat.chatwindow.chat.data.convert.textrender.v2;

import com.bytedance.android.livesdkapi.distribution.config.GestureAction;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes35.dex */
public final class h<A, R> extends e implements Function1<A, R> {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Function1<A, R> f412509c;

    @Override // kotlin.jvm.functions.Function1
    public final R invoke(A r100) {
        return this.f412509c.invoke(r100);
    }

    public h(a r100, Function1 r101) {
        Intrinsics.checkNotNullParameter(r100, "scope");
        Intrinsics.checkNotNullParameter(GestureAction.longPress, "role");
        Intrinsics.checkNotNullParameter(r101, "action");
        super(r100, GestureAction.longPress);
        this.f412509c = r101;
    }
}
