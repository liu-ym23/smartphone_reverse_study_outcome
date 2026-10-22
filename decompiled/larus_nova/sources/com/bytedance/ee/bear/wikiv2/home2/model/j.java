package com.bytedance.ee.bear.wikiv2.home2.model;

import io.reactivex.functions.Function;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes18.dex */
public final class j<T, R> implements Function {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ WikiHomeRepositoryImpl f240934a;

    public j(WikiHomeRepositoryImpl r100) {
        this.f240934a = r100;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // io.reactivex.functions.Function
    public final T apply(T r100) {
        Intrinsics.checkNotNullParameter(r100, "it");
        this.f240934a.f240859c = (WikiSpacesResp) r100;
        return r100;
    }
}
