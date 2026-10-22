package com.bytedance.ee.bear.wikiv2.home2.model;

import io.reactivex.functions.Function;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes18.dex */
public final class b<T, R> implements Function {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ WikiHomeRepositoryImpl f240924a;

    public b(WikiHomeRepositoryImpl r100) {
        this.f240924a = r100;
    }

    @Override // io.reactivex.functions.Function
    public final Object apply(Object r100) {
        Intrinsics.checkNotNullParameter((Boolean) r100, "it");
        WikiSpaceFilter r101 = new WikiSpaceFilter((String) WikiHomeRepositoryImpl.j(this.f240924a).a("space_type", "all"), (String) WikiHomeRepositoryImpl.j(this.f240924a).a("space_class_id", "all"));
        boolean r102 = ((Boolean) WikiHomeRepositoryImpl.j(this.f240924a).a("last_filter_option_empty", Boolean.TRUE)).booleanValue();
        WikiSpaceFilterInfo.Companion.getClass();
        return new WikiSpaceFilterInfo(r101, WikiSpaceFilterInfo.access$getNoFilterOption$cp(), r102);
    }
}
