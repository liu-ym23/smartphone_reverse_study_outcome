package com.bytedance.ee.bear.doc.newresupdate.provider.interceptor;

import android.content.Context;
import com.bytedance.ee.bear.doc.resupdate.e0;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes16.dex */
public final class b extends a {
    @Override // com.bytedance.ee.bear.doc.newresupdate.provider.interceptor.a
    public final boolean d() {
        return true;
    }

    @Override // com.bytedance.ee.bear.doc.newresupdate.provider.interceptor.a
    public final e0 b() {
        tt5.a.h("AbsResourceInterceptor", "getResource, use assert");
        return a();
    }

    public b(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100);
    }
}
