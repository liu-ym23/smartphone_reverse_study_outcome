package com.bytedance.platform.aio.channel.js;

import com.bytedance.platform.aio.channel.js.model.e;
import com.bytedance.revenue.platform.api.core.rx.q;
import io.reactivex.Single;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes21.dex */
public final class c implements b<e, Unit> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Function1<e, Unit> f266598a;

    /* JADX WARN: Multi-variable type inference failed */
    public c(Function1<? super e, Unit> r100) {
        Intrinsics.checkNotNullParameter(r100, "onMessage");
        this.f266598a = r100;
    }

    @Override // com.bytedance.platform.aio.channel.js.b
    public final Single<Unit> invoke(e r100) {
        e r101 = r100;
        Intrinsics.checkNotNullParameter(r101, "param");
        this.f266598a.invoke(r101);     // Catch: Exception -> L5
        int r102 = q.f267523a;     // Catch: Exception -> L5
        return Single.just(Unit.INSTANCE);
    L5:
        e = move-exception;
        int r103 = q.f267523a;
        return Single.error(e);
    }
}
