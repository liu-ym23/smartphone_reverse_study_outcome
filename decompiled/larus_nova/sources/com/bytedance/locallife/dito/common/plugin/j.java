package com.bytedance.locallife.dito.common.plugin;

import com.bytedance.locallife.dito.model.BaseDitoModel;
import com.larus.apm.impl.protector.RunnableProtector;
import java.util.LinkedHashMap;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: classes21.dex */
public final class j implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Function1<com.bytedance.locallife.dito.provider.b<Object>, Unit> f257586a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ BaseDitoModel<?> f257587b;

    /* JADX WARN: Multi-variable type inference failed */
    public j(Function1<? super com.bytedance.locallife.dito.provider.b<Object>, Unit> r100, BaseDitoModel<?> r101) {
        this.f257586a = r100;
        this.f257587b = r101;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Function1<com.bytedance.locallife.dito.provider.b<Object>, Unit> r100 = this.f257586a;     // Catch: Throwable -> L11
        if (r100 == null) goto L14;
        BaseDitoModel<?> r101 = this.f257587b;     // Catch: Throwable -> L11
        if (r101 == null) goto L8;
        String r102 = r101.f258493b.f258222b;     // Catch: Throwable -> L11
        if (r102 == null) goto L8;
    L9:
        Unit r103 = r100.invoke(aq6.c.b(r102, new LinkedHashMap()));     // Catch: Throwable -> L11
        return;
    L8:
        r102 = "";
        goto L9
    L14:
        return;
    L11:
        th = move-exception;
        if (RunnableProtector.intercept(th) == true) goto L18;
        throw th;
    }
}
