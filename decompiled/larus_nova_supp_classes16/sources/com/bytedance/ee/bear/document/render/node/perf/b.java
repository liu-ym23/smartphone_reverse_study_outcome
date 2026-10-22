package com.bytedance.ee.bear.document.render.node.perf;

import com.bytedance.ee.bear.document.render.loader.DocumentLoaderV3;
import com.bytedance.ee.bear.document.x2;
import com.ss.android.lark.officesdk.utils.di.j;
import kotlinx.coroutines.Job;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class b extends x2.c {
    public final /* synthetic */ com.bytedance.ee.bear.document.render.node.e a;
    public final /* synthetic */ PerfReportRenderNode b;

    @Override // com.bytedance.ee.bear.document.x2.c, com.bytedance.ee.bear.document.x2.b
    public final void onLoadSuccess() {
        j.e("PerfReportRenderNode", this.a.f() + ", loadSuccess, cancel timeout");
        Job r0 = this.b.a;
        if (r0 == null) goto L6;
        Job.DefaultImpls.cancel$default(r0, null, 1, null);
        return;
    }

    public b(DocumentLoaderV3 r1, PerfReportRenderNode r2) {
        this.a = r1;
        this.b = r2;
    }

    @Override // com.bytedance.ee.bear.document.x2.c, com.bytedance.ee.bear.document.x2.b
    public final void onLoadFail(int r2, Throwable r3) {
        j.e("PerfReportRenderNode", this.a.f() + ", loadFail, cancel timeout");
        Job r4 = this.b.a;
        if (r4 == null) goto L6;
        Job.DefaultImpls.cancel$default(r4, null, 1, null);
        return;
    }
}
