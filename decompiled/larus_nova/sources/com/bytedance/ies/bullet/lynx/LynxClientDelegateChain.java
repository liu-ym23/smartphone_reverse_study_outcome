package com.bytedance.ies.bullet.lynx;

import java.util.Iterator;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes19.dex */
public final class LynxClientDelegateChain {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final com.bytedance.ies.bullet.service.base.o f247089a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final List<u26.b> f247090b;

    public LynxClientDelegateChain(u26.d r100, List r101) {
        Intrinsics.checkNotNullParameter(r101, "delegates");
        this.f247089a = r100;
        this.f247090b = r101;
    }

    public final void a(final Iterator<? extends u26.b> r110, final g r111, final Function1<Object, Unit> r210, final Function1<? super Throwable, Unit> r211) {
        u26.b r100 = r110.next();
        r100.a(this.f247089a, r111.getContext(), r111.f247257b, r111.f247258c, r111.f247259d, r111.f247260e, r111.f247261f, new LynxClientDelegateChain$doLoadImage$1(this, r110, r111, r210, r211));     // Catch: Exception -> L5
        return;
    L5:
        e = move-exception;
        if (r110.hasNext() == false) goto L9;
        a(r110, r111, r210, r211);
        return;
    L9:
        r211.invoke(e);
    }
}
