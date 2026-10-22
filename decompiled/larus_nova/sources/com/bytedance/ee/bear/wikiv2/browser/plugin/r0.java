package com.bytedance.ee.bear.wikiv2.browser.plugin;

import com.bytedance.ee.bear.contract.route.parcelable.WikiInfo;
import io.reactivex.functions.Function;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes18.dex */
public final class r0<T, R> implements Function {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ WikiInfo f240613a;

    public r0(WikiInfo r100) {
        this.f240613a = r100;
    }

    @Override // io.reactivex.functions.Function
    public final Object apply(Object r100) {
        Intrinsics.checkNotNullParameter((String) r100, "it");
        tt5.a.b("WikiRepository", "readParamsWikiInfoFlow success:" + this.f240613a);
        WikiInfo r101 = this.f240613a;
        r101.from_cache = true;
        return new up5.b(r101);
    }
}
