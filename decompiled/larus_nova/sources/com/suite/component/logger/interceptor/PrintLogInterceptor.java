package com.suite.component.logger.interceptor;

import com.ss.android.lark.utils.statistics.PerfLog;
import com.suite.component.logger.api.d;
import com.suite.component.logger.api.e;
import com.suite.component.logger.c;
import java.util.Iterator;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes38.dex */
public final class PrintLogInterceptor implements d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final com.suite.component.logger.b f460142a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Lazy f460143b;

    public PrintLogInterceptor(com.suite.component.logger.b r100, final List<? extends e> r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "printers");
        this.f460142a = r100;
        this.f460143b = LazyKt.lazy(LazyThreadSafetyMode.SYNCHRONIZED, new PrintLogInterceptor$logPrinters$2(r101, this));
    }

    @Override // com.suite.component.logger.api.d
    public final void a(d.a r100, com.suite.component.logger.b r101, c r102) {
        Intrinsics.checkNotNullParameter(r100, "chain");
        Intrinsics.checkNotNullParameter(r101, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r102, "entity");
        Iterator r103 = ((List) this.f460143b.getValue()).iterator();
    L4:
        if (r103.hasNext() == false) goto L8;
        e r104 = (e) r103.next();
        if (r104.isEnable() == false) goto L4;
        r104.a(r102);
        goto L4
    }
}
