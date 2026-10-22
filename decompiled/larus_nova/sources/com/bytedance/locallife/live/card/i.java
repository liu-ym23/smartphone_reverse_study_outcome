package com.bytedance.locallife.live.card;

import io.reactivex.functions.Function;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes21.dex */
public final class i<T, R> implements Function {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ LiveLocalLifeBaseCard f259242a;

    public i(LiveLocalLifeBaseCard r100) {
        this.f259242a = r100;
    }

    @Override // io.reactivex.functions.Function
    public final Object apply(Object r100) {
        String r101 = (String) r100;
        Intrinsics.checkNotNullParameter(r101, "it");
        int r102 = com.bytedance.locallife.live.goodsshelves.manager.n.f259731a;
        return com.bytedance.locallife.live.goodsshelves.manager.n.a(r101, this.f259242a.f259162a);
    }
}
