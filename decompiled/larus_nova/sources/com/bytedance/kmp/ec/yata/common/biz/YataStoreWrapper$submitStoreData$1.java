package com.bytedance.kmp.ec.yata.common.biz;

import aa6.b;
import ba6.h;
import com.bytedance.kmp.ec.yata.common.biz.callback.e;
import com.bytedance.kmp.ec.yata.common.biz.callback.g;
import com.bytedance.kmp.ec.yata.common.log.YaTaLog;
import com.bytedance.kmp.ec.yata.store.core.YataStoreData;
import java.util.Iterator;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes19.dex */
public final class YataStoreWrapper$submitStoreData$1 implements ba6.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ YataStoreWrapper f251356a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ YataStoreData f251357b;

    @Override // ba6.a
    public final void c(h r100) {
        Intrinsics.checkNotNullParameter(r100, "result");
    }

    @Override // ba6.a
    public final void a(h r100) {
        Intrinsics.checkNotNullParameter(r100, "result");
        String r101 = YaTaLog.f251436a;
        final YataStoreData r102 = this.f251357b;
        YaTaLog.c("YataStoreWrapper", new YataStoreWrapper$submitStoreData$1$onDataSubmitFinish$1(r102));
        YataStoreWrapper r103 = this.f251356a;
        if (r103.f251348i == false) goto L5;
        return;
    L5:
        g r104 = (g) r103.f251353n.getValue();
        YataStoreData r105 = this.f251357b;
        r104.getClass();
        Intrinsics.checkNotNullParameter(r105, "storeData");
        r105.a();
        r104.f251373a.s().f().c(r105);
        Iterator<e> r106 = r104.f251374b.snapshot().iterator();
    L7:
        if (r106.hasNext() == false) goto L9;
        r106.next().c(r105);
        goto L7
    }

    @Override // ba6.a
    public final void b(h r100) {
        Intrinsics.checkNotNullParameter(r100, "result");
        String r101 = YaTaLog.f251436a;
        final YataStoreData r102 = this.f251357b;
        YaTaLog.c("YataStoreWrapper", new YataStoreWrapper$submitStoreData$1$onRenderFinish$1(r102));
        YataStoreWrapper r103 = this.f251356a;
        if (r103.f251348i == false) goto L5;
        return;
    L5:
        b r104 = r103.r().a();
        if (r104 == null) goto L8;
        Intrinsics.checkNotNullParameter(r104, "<this>");
        r104.k(Boolean.FALSE);
        r104.r(Boolean.TRUE);
    L8:
        g r105 = (g) this.f251356a.f251353n.getValue();
        YataStoreData r106 = this.f251357b;
        r105.getClass();
        Intrinsics.checkNotNullParameter(r106, "storeData");
        Intrinsics.checkNotNullParameter(r100, "result");
        Function0<Unit> r107 = r106.f251725i;
        if (r107 == null) goto L11;
        r107.invoke();
    L11:
        h.a r108 = null;
        if ((r100 instanceof h.b) == false) goto L15;
        Object r109 = Result.m9449constructorimpl(null);
    L22:
        r105.f251373a.s().f().f(r106, r109);
        Iterator<e> r110 = r105.f251374b.snapshot().iterator();
    L24:
        if (r110.hasNext() == false) goto L26;
        r110.next().f(r106, r109);
        goto L24
    L26:
        this.f251356a.k().c(this.f251357b.f251719c);
        return;
    L15:
        if ((r100 instanceof h.a) == false) goto L17;
        r108 = (h.a) r100;
    L17:
        if (r108 == null) goto L20;
        String r111 = r108.f18417a;
        if (r111 == null) goto L20;
    L21:
        Result.Companion r112 = Result.Companion;
        r109 = Result.m9449constructorimpl(ResultKt.createFailure(new Exception(r111)));
    L20:
        r111 = "NotSuccess";
        goto L21
    }

    public YataStoreWrapper$submitStoreData$1(YataStoreWrapper r100, YataStoreData r101) {
        this.f251356a = r100;
        this.f251357b = r101;
    }
}
