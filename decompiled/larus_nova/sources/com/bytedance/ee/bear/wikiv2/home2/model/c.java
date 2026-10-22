package com.bytedance.ee.bear.wikiv2.home2.model;

import com.bytedance.ee.bear.wikiv2.wikitreev2.widget.db.WikiDatabase;
import io.reactivex.functions.Function;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes18.dex */
public final class c<T, R> implements Function {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ WikiSpaceFilter f240925a;

    public c(WikiSpaceFilter r100) {
        this.f240925a = r100;
    }

    @Override // io.reactivex.functions.Function
    public final Object apply(Object r100) {
        Intrinsics.checkNotNullParameter((Boolean) r100, "it");
        return zp5.a.d(WikiDatabase.c().f().a(1, this.f240925a.getSpaceTypeId(), this.f240925a.getSpaceClassId()));
    }
}
