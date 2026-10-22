package com.bytedance.ee.bear.bitable.chameleon.render.fetcher;

import com.bytedance.ee.bear.bitable.dao.resourcedata.BitableAppData;
import com.bytedance.ee.bear.contract.Result;
import io.reactivex.functions.Consumer;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: classes15.dex */
public final class f<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Function1<com.bytedance.ee.bear.bitable.chameleon.render.a.C3020a<BaseAppFirstScreenDataFetcher.Payload>, Unit> f209772a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ long f209773b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ BaseAppFirstScreenDataFetcher f209774c;

    /* JADX WARN: Multi-variable type inference failed */
    public f(Function1<? super com.bytedance.ee.bear.bitable.chameleon.render.a.C3020a<BaseAppFirstScreenDataFetcher.Payload>, Unit> r100, long r101, BaseAppFirstScreenDataFetcher r102) {
        this.f209772a = r100;
        this.f209773b = r101;
        this.f209774c = r102;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r210) {
        Result r100 = (Result) r210;
        int r101 = r100.code;
        if (r101 != 0) goto L7;
        DATA r102 = r100.data;
        if (r102 == 0) goto L7;
        this.f209772a.invoke(new com.bytedance.ee.bear.bitable.chameleon.render.a.C3020a(new BaseAppFirstScreenDataFetcher.Payload((BitableAppData) r102, this.f209773b, r101, "", "", null), null));
        return;
    L7:
        Function1<com.bytedance.ee.bear.bitable.chameleon.render.a.C3020a<BaseAppFirstScreenDataFetcher.Payload>, Unit> r103 = this.f209772a;
        BaseAppFirstScreenDataFetcher r104 = this.f209774c;
        BitableAppData r110 = new BitableAppData("", r104.f209748c, r104.f209749d);
        long r111 = this.f209773b;
        int r112 = r100.code;
        String r105 = r100.msg;
        if (r105 != null) goto L10;
        String r113 = "";
    L11:
        r103.invoke(new com.bytedance.ee.bear.bitable.chameleon.render.a.C3020a(new BaseAppFirstScreenDataFetcher.Payload(r110, r111, r112, r113, "", new Exception(r100.code + ',' + r100.msg)), null));
        return;
    L10:
        r113 = r105;
        goto L11
    }
}
