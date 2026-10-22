package com.bytedance.lark.sdk.stream;

import com.bytedance.lark.pb.tool.v1.FetchRequest;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes20.dex */
public final class g implements c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final b f254379a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final h f254380b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Function0<Long> f254381c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Function1<FetchRequest, j> f254382d;

    public static final class a implements d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final long f254383a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final b f254384b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final h f254385c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final AtomicBoolean f254386d;

        @Override // com.bytedance.lark.sdk.stream.d
        public final void cancel() {
            if (this.f254386d.compareAndSet(false, true) == false) goto L6;
            this.f254385c.a(this.f254383a);
            this.f254384b.cancel(this.f254383a);
            return;
        }

        public a(long r100, b r101, h r102) {
            Intrinsics.checkNotNullParameter(r101, "fetchAsyncRepository");
            Intrinsics.checkNotNullParameter(r102, "callbackRegistry");
            this.f254383a = r100;
            this.f254384b = r101;
            this.f254385c = r102;
            this.f254386d = new AtomicBoolean(false);
        }
    }

    public g(RustFetchAsyncRepository r100, Function1 r101) {
        i r102 = i.f254387a;
        RustStreamClientImpl$1 r103 = RustStreamClientImpl$1.INSTANCE;
        Intrinsics.checkNotNullParameter(r100, "fetchAsyncRepository");
        Intrinsics.checkNotNullParameter(r102, "callbackRegistry");
        Intrinsics.checkNotNullParameter(r103, "taskIdGenerator");
        Intrinsics.checkNotNullParameter(r101, "requestBodyReaderProvider");
        this.f254379a = r100;
        this.f254380b = r102;
        this.f254381c = r103;
        this.f254382d = r101;
    }

    @Override // com.bytedance.lark.sdk.stream.c
    public final a a(FetchRequest r100, com.larksuite.framework.http.v2.internal.rust.stream.i.a r101) {
        Intrinsics.checkNotNullParameter(r100, "request");
        Intrinsics.checkNotNullParameter(r101, "callback");
        long r102 = this.f254381c.invoke().longValue();
        FetchRequest.Builder r103 = r100.newBuilder();
        r103.request_id = Long.valueOf(r102);
        FetchRequest r104 = r103.build();
        h r105 = this.f254380b;
        Function1<FetchRequest, j> r106 = this.f254382d;
        Intrinsics.checkNotNull(r104);
        if (r105.b(r102, r101, r106.invoke(r104)) == false) goto L11;
        this.f254379a.a(r104, r102);     // Catch: Throwable -> L7
        return new a(r102, this.f254379a, this.f254380b);
    L7:
        th = move-exception;
        this.f254380b.a(r102);
        throw th;
    L11:
        throw new IllegalStateException("Fetch task id " + r102 + " is already registered");
    }
}
