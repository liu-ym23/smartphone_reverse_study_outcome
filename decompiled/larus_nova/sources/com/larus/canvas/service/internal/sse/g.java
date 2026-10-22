package com.larus.canvas.service.internal.sse;

import com.larus.platform.service.o;
import com.larus.utils.logger.FLogger;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes26.dex */
public final class g implements e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ e f323876a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ StreamPullHandler f323877b;

    @Override // com.larus.canvas.service.internal.sse.e
    public final void a(f r110) {
        Intrinsics.checkNotNullParameter(r110, "data");
        this.f323876a.a(r110);
        if (this.f323877b.f323856h != 0) goto L5;
        long r100 = -1;
    L6:
        long r101 = r100;
        int r102 = d.f323863a;
        int r103 = r110.f323872a;
        StreamPullHandler r104 = this.f323877b;
        int r105 = r104.f323857i;
        String r106 = r110.f323875d;
        int r107 = r110.f323874c;
        String r111 = r110.f323873b;
        if (r111 != null) goto L9;
        r111 = "";
    L9:
        d.a r108 = new d.a(r103, r105, r101, r106, r107, r111, r104.f323849a);
        Intrinsics.checkNotNullParameter(r108, "info");
        o.f365780a.b("flow_canvas_chunk_request", com.larus.utils.f.c(new Pair[]{TuplesKt.to("status", Integer.valueOf(r108.f323864a)), TuplesKt.to("count", Integer.valueOf(r108.f323865b)), TuplesKt.to("duration", Long.valueOf(r108.f323866c)), TuplesKt.to("error_description", r108.f323867d), TuplesKt.to("error_code", Integer.valueOf(r108.f323868e)), TuplesKt.to("binary_type", r108.f323869f), TuplesKt.to("log_id", r108.f323870g), TuplesKt.to("request_path", r108.f323871h), TuplesKt.to("scene", "end")}));     // Catch: Exception -> L12
        return;
    L12:
        e = move-exception;
        FLogger.f375446a.e("flow_canvas_chunk_request_end", "reportEvent error", e);
        return;
    L5:
        r100 = System.currentTimeMillis() - this.f323877b.f323856h;
        goto L6
    }

    @Override // com.larus.canvas.service.internal.sse.e
    public final void b(b r100) {
        Intrinsics.checkNotNullParameter(r100, "chunkPackage");
        this.f323876a.b(r100);
        this.f323877b.f323857i++;
    }

    public g(CanvasChunkReceiver r100, StreamPullHandler r101) {
        this.f323876a = r100;
        this.f323877b = r101;
    }
}
