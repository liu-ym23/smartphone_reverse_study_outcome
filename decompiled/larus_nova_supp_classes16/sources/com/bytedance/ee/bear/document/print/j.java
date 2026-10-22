package com.bytedance.ee.bear.document.print;

import io.reactivex.functions.Function;
import java.util.concurrent.TimeUnit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class j<T, R> implements Function {
    public final /* synthetic */ PrintExportCoordinator a;
    public final /* synthetic */ int b;
    public final /* synthetic */ String c;

    public j(PrintExportCoordinator r1, int r2, String r3) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
    }

    public final Object apply(Object r4) {
        Throwable r5 = (Throwable) r4;
        Intrinsics.checkNotNullParameter(r5, "throwable");
        tt5.a.k("PrintExportCoordinator", "query comment state from JSB failed, fallback to server: ".concat(r5.getClass().getSimpleName()));
        PrintExportCoordinator r6 = this.a;
        int r0 = this.b;
        String r1 = this.c;
        ((tj5.k) r6.k.getValue()).getClass();
        return tj5.k.a(r0, r1).map(k.a).firstOrError().timeout(3, TimeUnit.SECONDS).doOnError(l.a).onErrorReturnItem(Boolean.TRUE);
    }
}
