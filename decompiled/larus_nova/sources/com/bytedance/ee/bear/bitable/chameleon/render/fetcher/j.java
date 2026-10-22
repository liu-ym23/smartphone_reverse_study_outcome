package com.bytedance.ee.bear.bitable.chameleon.render.fetcher;

import com.bytedance.ee.bear.bitable.dao.resourcedata.BitableAppData;
import com.bytedance.ee.bear.contract.NetService;
import io.reactivex.functions.Consumer;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: classes15.dex */
public final class j<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Function1<com.bytedance.ee.bear.bitable.chameleon.render.a.C3020a<BaseAppTableSsrDataFetcher.Payload>, Unit> f209781a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ BaseAppTableSsrDataFetcher f209782b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ long f209783c;

    /* JADX WARN: Multi-variable type inference failed */
    public j(Function1<? super com.bytedance.ee.bear.bitable.chameleon.render.a.C3020a<BaseAppTableSsrDataFetcher.Payload>, Unit> r100, BaseAppTableSsrDataFetcher r101, long r102) {
        this.f209781a = r100;
        this.f209782b = r101;
        this.f209783c = r102;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r110) {
        Throwable r100 = (Throwable) r110;
        Function1<com.bytedance.ee.bear.bitable.chameleon.render.a.C3020a<BaseAppTableSsrDataFetcher.Payload>, Unit> r111 = this.f209781a;
        BaseAppTableSsrDataFetcher r101 = this.f209782b;
        BitableAppData r102 = new BitableAppData("", r101.f209752c, r101.f209753d);
        long r103 = this.f209783c;
        String r104 = r100.getMessage();
        if (r104 != null) goto L5;
        String r112 = "";
    L7:
        if ((r100 instanceof NetService.ServerErrorException) == false) goto L12;
        String r105 = ((NetService.ServerErrorException) r100).getLogId();
        if (r105 == null) goto L12;
        String r113 = r105;
    L13:
        r111.invoke(new com.bytedance.ee.bear.bitable.chameleon.render.a.C3020a(new BaseAppTableSsrDataFetcher.Payload(r102, r103, -1, r112, r113, r100), null));
        return;
    L12:
        r113 = "";
        goto L13
    L5:
        r112 = r104;
        goto L7
    }
}
