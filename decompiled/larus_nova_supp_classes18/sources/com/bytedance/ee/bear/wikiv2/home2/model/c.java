package com.bytedance.ee.bear.wikiv2.home2.model;

import com.bytedance.ee.bear.wikiv2.wikitreev2.widget.db.WikiDatabase;
import io.reactivex.functions.Function;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class c<T, R> implements Function {
    public final /* synthetic */ WikiSpaceFilter a;

    public c(WikiSpaceFilter r1) {
        this.a = r1;
    }

    public final Object apply(Object r4) {
        Intrinsics.checkNotNullParameter((Boolean) r4, "it");
        return zp5.a.d(WikiDatabase.c().f().a(1, this.a.getSpaceTypeId(), this.a.getSpaceClassId()));
    }
}
