package com.bytedance.lark.sdk.stream;

import com.bytedance.lark.pb.tool.v1.OnFetchResponse;
import com.bytedance.lark.sdk.LarkResponse;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes20.dex */
public final class a implements h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ConcurrentHashMap<Long, C3617a> f254371a;

    /* JADX INFO: renamed from: com.bytedance.lark.sdk.stream.a$a, reason: collision with other inner class name */
    public static final class C3617a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final long f254372a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final f f254373b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final j f254374c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final LarkResponse.a f254375d;

        public C3617a(long r100, com.larksuite.framework.http.v2.internal.rust.stream.i.a r101, j r102) {
            LarkResponse.a r103 = new LarkResponse.a();
            Intrinsics.checkNotNullParameter(r101, "callback");
            Intrinsics.checkNotNullParameter(r102, "requestBodyReader");
            Intrinsics.checkNotNullParameter(r103, "builder");
            this.f254372a = r100;
            this.f254373b = r101;
            this.f254374c = r102;
            this.f254375d = r103;
        }
    }

    public /* synthetic */ class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f254376a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ int[] f254377b = null;

        static {
            int[] r100 = new int[OnFetchResponse.OnErrorResponse.Code.values().length];
            r100[OnFetchResponse.OnErrorResponse.Code.TIMEOUT.ordinal()] = 1;     // Catch: NoSuchFieldError -> L15
        L26:
            r100[OnFetchResponse.OnErrorResponse.Code.SDK.ordinal()] = 2;     // Catch: NoSuchFieldError -> L16
        L34:
            r100[OnFetchResponse.OnErrorResponse.Code.OFFLINE.ordinal()] = 3;     // Catch: NoSuchFieldError -> L17
        L28:
            r100[OnFetchResponse.OnErrorResponse.Code.IO.ordinal()] = 4;     // Catch: NoSuchFieldError -> L18
        L9:
            f254376a = r100;
            int[] r101 = new int[OnFetchResponse.OnHeaderResponse.Protocol.values().length];
            r101[OnFetchResponse.OnHeaderResponse.Protocol.HTTP_1_1.ordinal()] = 1;     // Catch: NoSuchFieldError -> L19
        L30:
            r101[OnFetchResponse.OnHeaderResponse.Protocol.HTTP_2.ordinal()] = 2;     // Catch: NoSuchFieldError -> L20
        L22:
            r101[OnFetchResponse.OnHeaderResponse.Protocol.QUIC.ordinal()] = 3;     // Catch: NoSuchFieldError -> L21
        L13:
            f254377b = r101;
        }
    }

    public a() {
        this.f254371a = new ConcurrentHashMap();
    }

    @Override // com.bytedance.lark.sdk.stream.h
    public final f a(long r100) {
        C3617a r101 = this.f254371a.remove(Long.valueOf(r100));
        if (r101 != null) goto L7;
        return null;
    L7:
        return r101.f254373b;
    }

    @Override // com.bytedance.lark.sdk.stream.h
    public final boolean b(long r100, com.larksuite.framework.http.v2.internal.rust.stream.i.a r101, j r102) {
        Intrinsics.checkNotNullParameter(r101, "callback");
        Intrinsics.checkNotNullParameter(r102, "requestBodyReader");
        if (this.f254371a.putIfAbsent(Long.valueOf(r100), new C3617a(r100, r101, r102)) != null) goto L5;
        return true;
    L5:
        return false;
    }
}
