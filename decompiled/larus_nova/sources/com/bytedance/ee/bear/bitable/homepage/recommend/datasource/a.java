package com.bytedance.ee.bear.bitable.homepage.recommend.datasource;

import com.bytedance.ee.bear.bitable.homepage.recommend.BitableRecommendResponse;
import com.bytedance.ee.bear.bitable.homepage.recommend.RecommendLoadType;
import io.reactivex.functions.Consumer;
import kotlin.Result;
import kotlinx.coroutines.i;
import kotlinx.coroutines.j;

/* JADX INFO: loaded from: classes15.dex */
public final class a<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ RecommendLoadType f213009a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ c f213010b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ long f213011c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ i<BitableRecommendResponse> f213012d;

    public a(RecommendLoadType r100, c r101, long r102, j r103) {
        this.f213009a = r100;
        this.f213010b = r101;
        this.f213011c = r102;
        this.f213012d = r103;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        BitableRecommendResponse r101 = (BitableRecommendResponse) r100;
        r101.setFromCache(false);
        r101.setLoadType(this.f213009a);
        c.a(this.f213010b, System.currentTimeMillis() - this.f213011c, r101.code, r101.msg, this.f213009a.name(), r101.getRequestId());
        this.f213012d.resumeWith(Result.m9449constructorimpl(r101));
    }
}
