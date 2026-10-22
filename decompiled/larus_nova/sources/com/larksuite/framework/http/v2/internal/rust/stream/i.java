package com.larksuite.framework.http.v2.internal.rust.stream;

import com.bytedance.kmp.ec.yata.view.render.controller.common.ContainerPosition;
import com.bytedance.lark.pb.tool.v1.HttpHeader;
import com.bytedance.lark.pb.tool.v1.OnFetchResponse;
import com.bytedance.lark.sdk.LarkResponse;
import com.ss.android.socialbase.downloader.utils.DownloadHelper;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.atomic.AtomicReference;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import okhttp3.Interceptor;
import okhttp3.MediaType;
import okhttp3.Protocol;
import okhttp3.Request;
import okhttp3.Response;

/* JADX INFO: loaded from: classes24.dex */
public final class i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Request f285656a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Interceptor.Chain f285657b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final com.bytedance.lark.sdk.stream.c f285658c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final CountDownLatch f285659d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final AtomicReference<Response.Builder> f285660e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final AtomicReference<IOException> f285661f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final AtomicReference<com.bytedance.lark.sdk.stream.d> f285662g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final LinkedBlockingQueue<StreamingResponseBody.a> f285663h;

    public final class a implements com.bytedance.lark.sdk.stream.f {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final StreamingResponseBody f285664a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ i f285665b;

        @Override // com.bytedance.lark.sdk.stream.f
        public final void b(OnFetchResponse.OnProgressResponse r100) {
            Intrinsics.checkNotNullParameter(r100, "response");
        }

        @Override // com.bytedance.lark.sdk.stream.f
        public final void a(OnFetchResponse.OnErrorResponse r100) {
            Intrinsics.checkNotNullParameter(r100, "response");
            String r101 = r100.message;
            if (r101.length() != 0) goto L5;
            boolean r102 = true;
        L6:
            if (r102 == false) goto L8;
            r101 = "Rust fetch failed";
        L8:
            h(new IOException(r101));
            return;
        L5:
            r102 = false;
            goto L6
        }

        @Override // com.bytedance.lark.sdk.stream.f
        public final void c(OnFetchResponse.OnSuccessResponse r100) {
            Intrinsics.checkNotNullParameter(r100, "response");
            this.f285664a.f285612g.set(true);
            this.f285665b.f285663h.offer(StreamingResponseBody.a.b.f285616a);
        }

        @Override // com.bytedance.lark.sdk.stream.f
        public final void d(LarkResponse r100) {
            Intrinsics.checkNotNullParameter(r100, "response");
            if (r100.f254082b != LarkResponse.ResponseStatus.ERROR) goto L14;
            LarkResponse.d r101 = r100.f254085e;
            if (r101 == null) goto L8;
            String r102 = r101.f254106b;
            if (r102 == null) goto L8;
        L12:
            h(new IOException(r102));
            return;
        L8:
            LarkResponse.b r103 = r100.f254084d;
            if (r103 == null) goto L11;
            r102 = r103.f254102b;
            goto L12
        L11:
            r102 = "Rust fetch failed";
            goto L12
        }

        @Override // com.bytedance.lark.sdk.stream.f
        public final void e(OnFetchResponse.OnHeaderResponse r100) {
            Intrinsics.checkNotNullParameter(r100, "response");
            i r101 = this.f285665b;
            AtomicReference<Response.Builder> r102 = r101.f285660e;
            r101.getClass();
            Response.Builder r103 = new Response.Builder().request(r101.f285656a);
            int r104 = b.f285666a[r100.protocol.ordinal()];
            if (r104 != 1) goto L5;
            Protocol r105 = Protocol.HTTP_1_1;
        L12:
            Response.Builder r106 = r103.protocol(r105).code(r100.status_code.intValue()).message("");
            Iterator<T> r107 = r100.headers.iterator();
        L14:
            if (r107.hasNext() == false) goto L21;
            HttpHeader r108 = (HttpHeader) r107.next();
            String r109 = r108.name.toLowerCase(Locale.ROOT);
            if (Intrinsics.areEqual(r109, "content-encoding") == false) goto L20;
            if (StringsKt.equals(r108.value, DownloadHelper.GZIP, true) == true) goto L14;
        L20:
            r106.addHeader(r109, r108.value);
            goto L14
        L21:
            Intrinsics.checkNotNull(r106);
            r102.set(r106);
            StreamingResponseBody r110 = this.f285664a;
            List<HttpHeader> r111 = r100.headers;
            r110.getClass();
            Intrinsics.checkNotNullParameter(r111, "headers");
            List<HttpHeader> r112 = r111;
            Iterator<T> r113 = r112.iterator();
        L22:
            Object r114 = null;
            if (r113.hasNext() == false) goto L27;
            Object r115 = r113.next();
            if (StringsKt.equals(((HttpHeader) r115).name, com.alipay.sdk.m.p.e.f25658f, true) == false) goto L22;
        L28:
            HttpHeader r116 = (HttpHeader) r115;
            if (r116 == null) goto L33;
            String r117 = r116.value;
            if (r117 == null) goto L33;
            MediaType r118 = MediaType.get(r117);
        L34:
            r110.f285613h = r118;
            Iterator<T> r119 = r112.iterator();
        L36:
            if (r119.hasNext() == false) goto L40;
            Object r120 = r119.next();
            if (StringsKt.equals(((HttpHeader) r120).name, "content-length", true) == false) goto L36;
            r114 = r120;
        L40:
            HttpHeader r121 = (HttpHeader) r114;
            if (r121 == null) goto L47;
            String r122 = r121.value;
            if (r122 == null) goto L47;
            Long r123 = StringsKt.toLongOrNull(r122);
            if (r123 == null) goto L47;
            long r124 = r123.longValue();
        L48:
            r110.f285614i = r124;
            this.f285665b.f285659d.countDown();
            return;
        L47:
            r124 = -1;
        L33:
            r118 = null;
            goto L34
        L27:
            r115 = null;
            goto L28
        L5:
            if (r104 != 2) goto L7;
            r105 = Protocol.HTTP_2;
            goto L12
        L7:
            if (r104 == 3) goto L9;
            r105 = Protocol.HTTP_1_0;
            goto L12
        L9:
            r105 = Protocol.QUIC;
            goto L12
        }

        @Override // com.bytedance.lark.sdk.stream.f
        public final void f(OnFetchResponse.OnBodyResponse r100) {
            Intrinsics.checkNotNullParameter(r100, "response");
            byte[] r101 = r100.body.toByteArray();
            if (r101.length != 0) goto L5;
            boolean r102 = true;
        L7:
            if ((!r102) == false) goto L10;
            this.f285665b.f285663h.offer(new StreamingResponseBody.a.C3924a(r101));
            return;
        L10:
            return;
        L5:
            r102 = false;
            goto L7
        }

        @Override // com.bytedance.lark.sdk.stream.f
        public final void g(OnFetchResponse.OnCancelResponse r100) {
            Intrinsics.checkNotNullParameter(r100, "response");
            h(new IOException("Canceled"));
        }

        public final void h(IOException r100) {
            AtomicReference<IOException> r101 = this.f285665b.f285661f;
        L4:
            if (r101.compareAndSet(null, r100) == true) goto L8;
            if (r101.get() == null) goto L4;
        L8:
            this.f285664a.f285612g.set(true);
            this.f285665b.f285663h.offer(StreamingResponseBody.a.b.f285616a);
            this.f285665b.f285659d.countDown();
        }

        public a(i r100, StreamingResponseBody r101) {
            Intrinsics.checkNotNullParameter(r101, ContainerPosition.BODY);
            this.f285665b = r100;
            this.f285664a = r101;
        }
    }

    public /* synthetic */ class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f285666a = null;

        static {
            int[] r100 = new int[OnFetchResponse.OnHeaderResponse.Protocol.values().length];
            r100[OnFetchResponse.OnHeaderResponse.Protocol.HTTP_1_1.ordinal()] = 1;     // Catch: NoSuchFieldError -> L8
        L11:
            r100[OnFetchResponse.OnHeaderResponse.Protocol.HTTP_2.ordinal()] = 2;     // Catch: NoSuchFieldError -> L9
        L15:
            r100[OnFetchResponse.OnHeaderResponse.Protocol.QUIC.ordinal()] = 3;     // Catch: NoSuchFieldError -> L10
        L6:
            f285666a = r100;
        }
    }

    public i(Request r100, Interceptor.Chain r101, com.bytedance.lark.sdk.stream.c r102) {
        Intrinsics.checkNotNullParameter(r100, "request");
        Intrinsics.checkNotNullParameter(r101, "chain");
        Intrinsics.checkNotNullParameter(r102, "rustFetchClient");
        this.f285656a = r100;
        this.f285657b = r101;
        this.f285658c = r102;
        this.f285659d = new CountDownLatch(1);
        this.f285660e = new AtomicReference();
        this.f285661f = new AtomicReference();
        this.f285662g = new AtomicReference();
        this.f285663h = new LinkedBlockingQueue();
    }
}
