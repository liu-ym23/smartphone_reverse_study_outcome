package com.bytedance.ee.bear.wikiv2.home2.model;

import io.reactivex.functions.Function;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class j<T, R> implements Function {
    public final /* synthetic */ WikiHomeRepositoryImpl a;

    public j(WikiHomeRepositoryImpl r1) {
        this.a = r1;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final T apply(T r3) {
        Intrinsics.checkNotNullParameter(r3, "it");
        this.a.c = (WikiSpacesResp) r3;
        return r3;
    }
}
