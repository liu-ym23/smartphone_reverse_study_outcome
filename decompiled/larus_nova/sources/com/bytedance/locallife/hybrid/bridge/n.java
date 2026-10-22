package com.bytedance.locallife.hybrid.bridge;

import com.bytedance.sdk.xbridge.cn.registry.core.model.idl.CompletionBlock;
import com.bytedance.sdk.xbridge.cn.registry.core.model.idl.XBaseModel;
import com.bytedance.sdk.xbridge.cn.registry.core.model.idl.XBaseResultModel;
import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.ttvideoengine.TTVideoEngineInterface;
import java.util.LinkedHashMap;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.internal.Reflection;

/* JADX INFO: loaded from: classes21.dex */
public final class n implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ CompletionBlock<mu6.b.c> f259031a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ LinkedHashMap<String, String> f259032b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ String f259033c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ int f259034d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final /* synthetic */ Integer f259035e;

    public n(CompletionBlock<mu6.b.c> r100, LinkedHashMap<String, String> r101, String r102, int r103, Integer r104) {
        this.f259031a = r100;
        this.f259032b = r101;
        this.f259033c = r102;
        this.f259034d = r103;
        this.f259035e = r104;
    }

    public final void a() {
        CompletionBlock<mu6.b.c> r100 = this.f259031a;
        XBaseModel r101 = ne7.e.c(Reflection.getOrCreateKotlinClass(mu6.b.c.class));
        LinkedHashMap<String, String> r102 = this.f259032b;
        String r103 = this.f259033c;
        int r104 = this.f259034d;
        Integer r105 = this.f259035e;
        mu6.b.c r106 = (mu6.b.c) r101;
        r106.setPrefetchStatus(0);
        Result.Companion r107 = Result.Companion;     // Catch: Throwable -> L5
        Object r108 = Result.m9449constructorimpl(Integer.valueOf(r104));     // Catch: Throwable -> L5
    L7:
        boolean r109 = Result.m9455isFailureimpl(r108);
        Object r110 = r108;
        if (r109 == false) goto L10;
        r110 = 0;
    L10:
        r106.setHttpCode((Number) r110);
        if (r105 != null) goto L27;
        Integer r111 = null;
    L16:
        Object r112 = Result.m9449constructorimpl(r111);     // Catch: Throwable -> L13
    L19:
        Object r113 = 0;
        if (Result.m9455isFailureimpl(r112) == true) goto L23;
        r113 = r112;
    L23:
        r106.setClientCode((Number) r113);
        r106.setHeader(r102);
        r106.setResponse(r103);
        r106.setResponseType(TTVideoEngineInterface.PLAY_API_KEY_BASE64);
        CompletionBlock.DefaultImpls.onSuccess$default(r100, (XBaseResultModel) r101, null, 2, null);
        return;
    L13:
        th = move-exception;
        Result.Companion r114 = Result.Companion;
        r112 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L19
    L27:
        r111 = Integer.valueOf(r105.intValue());     // Catch: Throwable -> L13
    L5:
        th = move-exception;
        Result.Companion r115 = Result.Companion;
        r108 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L7
    }

    @Override // java.lang.Runnable
    public final void run() {
        a();     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }
}
