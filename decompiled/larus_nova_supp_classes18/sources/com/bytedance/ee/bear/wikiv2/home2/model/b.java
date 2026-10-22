package com.bytedance.ee.bear.wikiv2.home2.model;

import io.reactivex.functions.Function;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class b<T, R> implements Function {
    public final /* synthetic */ WikiHomeRepositoryImpl a;

    public b(WikiHomeRepositoryImpl r1) {
        this.a = r1;
    }

    public final Object apply(Object r4) {
        Intrinsics.checkNotNullParameter((Boolean) r4, "it");
        WikiSpaceFilter r1 = new WikiSpaceFilter((String) WikiHomeRepositoryImpl.j(this.a).a("space_type", "all"), (String) WikiHomeRepositoryImpl.j(this.a).a("space_class_id", "all"));
        boolean r5 = ((Boolean) WikiHomeRepositoryImpl.j(this.a).a("last_filter_option_empty", Boolean.TRUE)).booleanValue();
        WikiSpaceFilterInfo.Companion.getClass();
        return new WikiSpaceFilterInfo(r1, WikiSpaceFilterInfo.access$getNoFilterOption$cp(), r5);
    }
}
