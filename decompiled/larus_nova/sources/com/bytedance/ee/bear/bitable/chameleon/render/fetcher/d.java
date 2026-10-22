package com.bytedance.ee.bear.bitable.chameleon.render.fetcher;

import com.bytedance.ee.bear.bitable.dao.resourcedata.BitableAppData;
import com.bytedance.ee.bear.contract.NetService;
import io.reactivex.functions.Consumer;
import java.util.concurrent.TimeoutException;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: classes15.dex */
public final class d<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Function1<com.bytedance.ee.bear.bitable.chameleon.render.a.C3020a<BaseAppClientVarsFetcher.Payload>, Unit> f209769a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ BaseAppClientVarsFetcher f209770b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ long f209771c;

    /* JADX WARN: Multi-variable type inference failed */
    public d(Function1<? super com.bytedance.ee.bear.bitable.chameleon.render.a.C3020a<BaseAppClientVarsFetcher.Payload>, Unit> r100, BaseAppClientVarsFetcher r101, long r102) {
        this.f209769a = r100;
        this.f209770b = r101;
        this.f209771c = r102;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r210) {
        Throwable r100 = (Throwable) r210;
        if ((r100 instanceof TimeoutException) == false) goto L5;
        String r101 = "timeout";
    L6:
        String r110 = r101;
        tt5.a.l("AppClientVarsFetcher", "query app clientVars failed: ".concat(r110), r100);
        Function1<com.bytedance.ee.bear.bitable.chameleon.render.a.C3020a<BaseAppClientVarsFetcher.Payload>, Unit> r102 = this.f209769a;
        BitableAppData r111 = new BitableAppData("", this.f209770b.f209739c, null);
        long r103 = this.f209771c;
        String r104 = r100.getMessage();
        if (r104 != null) goto L9;
        String r105 = "";
    L11:
        if ((r100 instanceof NetService.ServerErrorException) == false) goto L16;
        String r106 = ((NetService.ServerErrorException) r100).getLogId();
        if (r106 == null) goto L16;
        String r107 = r106;
    L17:
        r102.invoke(new com.bytedance.ee.bear.bitable.chameleon.render.a.C3020a(new BaseAppClientVarsFetcher.Payload(r111, new BaseAppClientVarsFetcher.b(r103, -1, r105, r107, "preload", 0, r110), r100), null));
        return;
    L16:
        r107 = "";
        goto L17
    L9:
        r105 = r104;
        goto L11
    L5:
        r101 = "rust_error";
        goto L6
    }
}
