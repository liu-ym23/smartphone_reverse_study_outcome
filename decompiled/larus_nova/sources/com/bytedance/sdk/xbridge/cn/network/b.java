package com.bytedance.sdk.xbridge.cn.network;

import com.byted.cast.common.source.ISendResultListener;
import com.bytedance.sdk.xbridge.cn.registry.core.model.idl.CompletionBlock;
import com.bytedance.sdk.xbridge.cn.registry.core.model.idl.XBaseModel;
import com.bytedance.sdk.xbridge.cn.registry.core.model.idl.XBaseResultModel;
import com.larus.apm.impl.protector.RunnableProtector;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.internal.Reflection;

/* JADX INFO: loaded from: classes22.dex */
public final class b implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ CompletionBlock<a.c> f269921a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ String f269922b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ int f269923c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ Integer f269924d;

    public b(CompletionBlock<a.c> r100, String r101, int r102, Integer r103) {
        this.f269921a = r100;
        this.f269922b = r101;
        this.f269923c = r102;
        this.f269924d = r103;
    }

    public final void a() {
        CompletionBlock<a.c> r100 = this.f269921a;
        String r101 = this.f269922b;
        if (r101 != null) goto L5;
        r101 = ISendResultListener.ERROR_MSG_DLNA_CUSTOMIZED_SERVICE_BODY_IS_NULL;
    L5:
        XBaseModel r102 = ne7.e.c(Reflection.getOrCreateKotlinClass(a.c.class));
        int r103 = this.f269923c;
        Integer r104 = this.f269924d;
        a.c r105 = (a.c) r102;
        Result.Companion r106 = Result.Companion;     // Catch: Throwable -> L8
        Object r107 = Result.m9449constructorimpl(Integer.valueOf(r103));     // Catch: Throwable -> L8
    L11:
        if (Result.m9455isFailureimpl(r107) == false) goto L13;
        r107 = 0;
    L13:
        r105.setHttpCode((Number) r107);
        if (r104 != null) goto L29;
        Integer r108 = null;
    L19:
        Object r109 = Result.m9449constructorimpl(r108);     // Catch: Throwable -> L16
    L23:
        if (Result.m9455isFailureimpl(r109) == false) goto L25;
        r109 = 0;
    L25:
        r105.setClientCode((Number) r109);
        Unit r110 = Unit.INSTANCE;
        r100.onFailure(0, r101, (XBaseResultModel) r102);
        return;
    L16:
        th = move-exception;
        Result.Companion r111 = Result.Companion;
        r109 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L23
    L29:
        r108 = Integer.valueOf(r104.intValue());     // Catch: Throwable -> L16
    L8:
        th = move-exception;
        Result.Companion r112 = Result.Companion;
        r107 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L11
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
