package com.bytedance.locallife.biz.prefetch.newsdk;

import com.bytedance.locallife.biz.common.utils.HostServiceUtilsKt;
import kotlin.Result;
import kotlin.ResultKt;

/* JADX INFO: loaded from: classes21.dex */
public final class o {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final o f256971a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static volatile p f256972b;

    static {
        f256971a = new o();
    }

    public o() {
    }

    public static p a() {
        p r100 = f256972b;
        if (r100 == null) goto L5;
        return r100;
    L5:
        Object r101 = null;
        Result.Companion r102 = Result.Companion;     // Catch: Throwable -> L8
        Object r103 = Result.m9449constructorimpl((p) HostServiceUtilsKt.g0().a("poi_request_prefetch", p.class, null));     // Catch: Throwable -> L8
    L11:
        if (Result.m9455isFailureimpl(r103) == true) goto L14;
        r101 = r103;
    L14:
        p r104 = (p) r101;
        f256972b = r104;
        if (r104 == null) goto L17;
        return r104;
    L17:
        return new p(0);
    L8:
        th = move-exception;
        Result.Companion r105 = Result.Companion;
        r103 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L11
    }
}
