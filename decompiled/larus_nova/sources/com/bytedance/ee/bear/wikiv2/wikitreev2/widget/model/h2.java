package com.bytedance.ee.bear.wikiv2.wikitreev2.widget.model;

import com.bytedance.ee.bear.wikiv2.wikitreev2.widget.api.GetFavoriteRelationPuller;
import com.bytedance.ee.bear.wikiv2.wikitreev2.widget.bean.WikiRelation;
import io.reactivex.functions.Function;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes18.dex */
public final class h2<T, R> implements Function {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ WikiRelation f241907a;

    public h2(WikiRelation r100) {
        this.f241907a = r100;
    }

    @Override // io.reactivex.functions.Function
    public final Object apply(Object r100) {
        GetFavoriteRelationPuller.Result r101 = (GetFavoriteRelationPuller.Result) r100;
        Intrinsics.checkNotNullParameter(r101, "it");
        this.f241907a.addFavorite(r101);
        return this.f241907a;
    }
}
