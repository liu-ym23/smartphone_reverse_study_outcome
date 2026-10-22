package com.lark.kmp.pb.basic.v1;

import com.lark.wire.FieldEncoding;
import com.lark.wire.ProtoAdapter;
import com.lark.wire.Syntax;
import com.lark.wire.g0;
import com.lark.wire.j0;
import com.lark.wire.n0;
import com.lark.wire.s;
import com.lark.wire.w;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClass;
import okio.ByteString;
import we6.d;

/* JADX INFO: loaded from: classes24.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u000f\u0018\u0000 \"2\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0003:\u0003!\"#B\u001b\b\u0002\u0012\u0006\u0010\u0004\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006¢\u0006\u0004\b\u0007\u0010\bJ\b\u0010\u001f\u001a\u00020\u0002H\u0016J\b\u0010 \u001a\u00020\u0015H\u0016R\u0015\u0010\t\u001a\u0004\u0018\u00010\n¢\u0006\n\n\u0002\u0010\r\u001a\u0004\b\u000b\u0010\fR\u0015\u0010\u000e\u001a\u0004\u0018\u00010\n¢\u0006\n\n\u0002\u0010\r\u001a\u0004\b\u000f\u0010\fR\u0013\u0010\u0010\u001a\u0004\u0018\u00010\u0011¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0013\u0010\u0014\u001a\u0004\u0018\u00010\u0015¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u0013\u0010\u0018\u001a\u0004\u0018\u00010\u0015¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0017R\u0013\u0010\u001a\u001a\u0004\u0018\u00010\u0015¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u0017R\u0013\u0010\u001c\u001a\u0004\u0018\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001e¨\u0006$"}, d2 = {"Lcom/lark/kmp/pb/basic/v1/LarkError;", "Lcom/lark/wire/Message;", "Lcom/lark/kmp/pb/basic/v1/LarkError$Builder;", "Lcom/bytedance/larksuite/wire/IUserScopeMessage;", "builder", "unknownFields", "Lokio/ByteString;", "<init>", "(Lcom/lark/kmp/pb/basic/v1/LarkError$Builder;Lokio/ByteString;)V", "status", "", "getStatus", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "code", "getCode", "details", "Lcom/lark/kmp/pb/basic/v1/LarkError$ErrorDetails;", "getDetails", "()Lcom/lark/kmp/pb/basic/v1/LarkError$ErrorDetails;", "display_message", "", "getDisplay_message", "()Ljava/lang/String;", "display_title", "getDisplay_title", "server_message", "getServer_message", "extra", "getExtra", "()Lokio/ByteString;", "newBuilder", "toString", "Builder", "Companion", "ErrorDetails", "rust-sdk-kotlin-pb_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class LarkError extends com.lark.wire.Message<LarkError, a> {
    public static final ProtoAdapter<LarkError> ADAPTER = null;
    public static final c Companion = null;
    public static final we6.c<LarkError> RAW_TYPE_ADAPTER = null;
    private static final long serialVersionUID = 0;
    private final Integer code;
    private final ErrorDetails details;
    private final String display_message;
    private final String display_title;
    private final ByteString extra;
    private final String server_message;
    private final Integer status;

    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 \u00182\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00020\u0001:\u0002\u0017\u0018B\u001b\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\b\u0010\u0015\u001a\u00020\u0002H\u0016J\b\u0010\u0016\u001a\u00020\tH\u0016R\u0013\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0013\u0010\f\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000bR\u0013\u0010\u000e\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000bR\u0017\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00120\u0011¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014¨\u0006\u0019"}, d2 = {"Lcom/lark/kmp/pb/basic/v1/LarkError$ErrorDetails;", "Lcom/lark/wire/Message;", "Lcom/lark/kmp/pb/basic/v1/LarkError$ErrorDetails$Builder;", "builder", "unknownFields", "Lokio/ByteString;", "<init>", "(Lcom/lark/kmp/pb/basic/v1/LarkError$ErrorDetails$Builder;Lokio/ByteString;)V", "debug_message", "", "getDebug_message", "()Ljava/lang/String;", "server_request_id", "getServer_request_id", "x_tt_logid", "getX_tt_logid", "headers", "", "Lcom/lark/kmp/pb/basic/v1/HttpHeader;", "getHeaders", "()Ljava/util/List;", "newBuilder", "toString", "Builder", "Companion", "rust-sdk-kotlin-pb_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class ErrorDetails extends com.lark.wire.Message<ErrorDetails, a> {
        public static final ProtoAdapter<ErrorDetails> ADAPTER = null;
        public static final c Companion = null;
        private static final long serialVersionUID = 0;
        private final String debug_message;
        private final List<HttpHeader> headers;
        private final String server_request_id;
        private final String x_tt_logid;

        public static final class a extends com.lark.wire.Message.a<ErrorDetails, a> {

            /* JADX INFO: renamed from: d, reason: collision with root package name */
            public String f279829d;

            /* JADX INFO: renamed from: e, reason: collision with root package name */
            public String f279830e;

            /* JADX INFO: renamed from: f, reason: collision with root package name */
            public String f279831f;

            /* JADX INFO: renamed from: g, reason: collision with root package name */
            public List<HttpHeader> f279832g;

            @Override // com.lark.wire.Message.a
            public final com.lark.wire.Message b() {
                return new ErrorDetails(this, c(), null);
            }

            public a() {
                this.f279832g = CollectionsKt.emptyList();
            }
        }

        public static final class b extends ProtoAdapter<ErrorDetails> {
            @Override // com.lark.wire.ProtoAdapter
            public final ErrorDetails c(g0 r100) {
                Intrinsics.checkNotNullParameter(r100, "reader");
                a r101 = new a();
                ArrayList r102 = new ArrayList();
                long r103 = r100.c();
            L3:
                int r104 = r100.e();
                if (r104 == (-1)) goto L18;
                if (r104 != 1) goto L8;
                ProtoAdapter.f282728q.getClass();
                Intrinsics.checkNotNullParameter(r100, "reader");
                r101.f279829d = r100.i();
                goto L3
            L8:
                if (r104 != 2) goto L10;
                ProtoAdapter.f282728q.getClass();
                Intrinsics.checkNotNullParameter(r100, "reader");
                r101.f279830e = r100.i();
                goto L3
            L10:
                if (r104 != 3) goto L12;
                ProtoAdapter.f282728q.getClass();
                Intrinsics.checkNotNullParameter(r100, "reader");
                r101.f279831f = r100.i();
                goto L3
            L12:
                if (r104 != 4) goto L13;
                r102.add(HttpHeader.ADAPTER.c(r100));
                goto L3
            L13:
                r100.j(r104);
                Unit r105 = Unit.INSTANCE;
                goto L3
            L18:
                ByteString r106 = r100.d(r103);
                Intrinsics.checkNotNullParameter(r102, "headers");
                com.lark.wire.internal.a.a(r102);
                r101.f279832g = r102;
                return new ErrorDetails(r101, r106, null);
            }

            @Override // com.lark.wire.ProtoAdapter
            public final int k(ErrorDetails r100) {
                ErrorDetails r101 = r100;
                Intrinsics.checkNotNullParameter(r101, "value");
                int r102 = r101.unknownFields().size();
                w r103 = ProtoAdapter.f282728q;
                return (((r102 + r103.l(1, r101.getDebug_message())) + r103.l(2, r101.getServer_request_id())) + r103.l(3, r101.getX_tt_logid())) + HttpHeader.ADAPTER.a().l(4, r101.getHeaders());
            }

            @Override // com.lark.wire.ProtoAdapter
            public final void f(j0 r100, ErrorDetails r101) {
                ErrorDetails r102 = r101;
                Intrinsics.checkNotNullParameter(r100, "writer");
                Intrinsics.checkNotNullParameter(r102, "value");
                w r103 = ProtoAdapter.f282728q;
                r103.i(r100, 1, r102.getDebug_message());
                r103.i(r100, 2, r102.getServer_request_id());
                r103.i(r100, 3, r102.getX_tt_logid());
                HttpHeader.ADAPTER.a().i(r100, 4, r102.getHeaders());
                r100.a(r102.unknownFields());
            }

            @Override // com.lark.wire.ProtoAdapter
            public final void g(n0 r100, ErrorDetails r101) {
                ErrorDetails r102 = r101;
                Intrinsics.checkNotNullParameter(r100, "writer");
                Intrinsics.checkNotNullParameter(r102, "value");
                r100.d(r102.unknownFields());
                HttpHeader.ADAPTER.a().j(r100, 4, r102.getHeaders());
                w r103 = ProtoAdapter.f282728q;
                r103.j(r100, 3, r102.getX_tt_logid());
                r103.j(r100, 2, r102.getServer_request_id());
                r103.j(r100, 1, r102.getDebug_message());
            }

            public b(FieldEncoding r100, KClass<ErrorDetails> r101, Syntax r102) {
                super(r100, r101, "type.googleapis.com/basic.v1.LarkError.ErrorDetails", r102, null);
            }
        }

        public static final class c {
            public c() {
            }
        }

        public /* synthetic */ ErrorDetails(a r100, ByteString r101, DefaultConstructorMarker r102) {
            this(r100, r101);
        }

        static {
            Companion = new c();
            ADAPTER = new b(FieldEncoding.LENGTH_DELIMITED, Reflection.getOrCreateKotlinClass(ErrorDetails.class), Syntax.PROTO_2);
        }

        @Override // com.lark.wire.Message
        public a newBuilder() {
            a r100 = new a();
            r100.f279829d = this.debug_message;
            r100.f279830e = this.server_request_id;
            r100.f279831f = this.x_tt_logid;
            r100.f279832g = this.headers;
            r100.a(unknownFields());
            return r100;
        }

        @Override // com.lark.wire.Message
        public String toString() {
            return Reflection.getOrCreateKotlinClass(ErrorDetails.class).getSimpleName() + '@' + hashCode();
        }

        public final String getDebug_message() {
            return this.debug_message;
        }

        public final List<HttpHeader> getHeaders() {
            return this.headers;
        }

        public final String getServer_request_id() {
            return this.server_request_id;
        }

        public final String getX_tt_logid() {
            return this.x_tt_logid;
        }

        @Override // com.lark.wire.Message
        public /* bridge */ /* synthetic */ com.lark.wire.Message.a newBuilder() {
            return newBuilder();
        }

        public ErrorDetails(a r100, ByteString r101) {
            super(ADAPTER, r101);
            this.debug_message = r100.f279829d;
            this.server_request_id = r100.f279830e;
            this.x_tt_logid = r100.f279831f;
            this.headers = com.lark.wire.internal.a.c("headers", r100.f279832g);
        }

        public /* synthetic */ ErrorDetails(a r100, ByteString r101, int r102, DefaultConstructorMarker r103) {
            if ((r102 & 2) == 0) goto L5;
            r101 = ByteString.EMPTY;
        L5:
            this(r100, r101);
        }
    }

    public static final class a extends com.lark.wire.Message.a<LarkError, a> implements d<LarkError> {

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public Integer f279833d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public Integer f279834e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public ErrorDetails f279835f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public String f279836g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public String f279837h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public String f279838i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public ByteString f279839j;

        @Override // com.lark.wire.Message.a
        public final com.lark.wire.Message b() {
            return new LarkError(this, c(), null);
        }

        public a() {
        }
    }

    public static final class b extends ProtoAdapter<LarkError> implements we6.c<LarkError> {
        @Override // com.lark.wire.ProtoAdapter
        public final LarkError c(g0 r100) {
            Intrinsics.checkNotNullParameter(r100, "reader");
            a r101 = new a();
            long r102 = r100.c();
        L3:
            int r103 = r100.e();
            if (r103 == (-1)) goto L15;
            switch(r103) {
                case 1: goto L13;
                case 2: goto L12;
                case 3: goto L11;
                case 4: goto L10;
                case 5: goto L9;
                case 6: goto L8;
                case 7: goto L7;
                default: goto L6;
            };
        L7:
            ProtoAdapter.f282727p.getClass();
            Intrinsics.checkNotNullParameter(r100, "reader");
            r101.f279839j = r100.f();
            goto L3
        L8:
            ProtoAdapter.f282728q.getClass();
            Intrinsics.checkNotNullParameter(r100, "reader");
            r101.f279838i = r100.i();
            goto L3
        L9:
            ProtoAdapter.f282728q.getClass();
            Intrinsics.checkNotNullParameter(r100, "reader");
            r101.f279837h = r100.i();
            goto L3
        L10:
            ProtoAdapter.f282728q.getClass();
            Intrinsics.checkNotNullParameter(r100, "reader");
            r101.f279836g = r100.i();
            goto L3
        L11:
            r101.f279835f = ErrorDetails.ADAPTER.c(r100);
            goto L3
        L12:
            r101.f279834e = (Integer) ProtoAdapter.f282719h.c(r100);
            goto L3
        L13:
            r101.f279833d = (Integer) ProtoAdapter.f282719h.c(r100);
            goto L3
        L6:
            r100.j(r103);
            Unit r104 = Unit.INSTANCE;
            goto L3
        L15:
            return new LarkError(r101, r100.d(r102), null);
        }

        @Override // com.lark.wire.ProtoAdapter
        public final int k(LarkError r100) {
            LarkError r101 = r100;
            Intrinsics.checkNotNullParameter(r101, "value");
            int r102 = r101.unknownFields().size();
            s r103 = ProtoAdapter.f282719h;
            int r104 = ((r102 + r103.l(1, r101.getStatus())) + r103.l(2, r101.getCode())) + ErrorDetails.ADAPTER.l(3, r101.getDetails());
            w r105 = ProtoAdapter.f282728q;
            return (((r104 + r105.l(4, r101.getDisplay_message())) + r105.l(5, r101.getDisplay_title())) + r105.l(6, r101.getServer_message())) + ProtoAdapter.f282727p.l(7, r101.getExtra());
        }

        @Override // com.lark.wire.ProtoAdapter
        public final void f(j0 r100, LarkError r101) {
            LarkError r102 = r101;
            Intrinsics.checkNotNullParameter(r100, "writer");
            Intrinsics.checkNotNullParameter(r102, "value");
            s r103 = ProtoAdapter.f282719h;
            r103.i(r100, 1, r102.getStatus());
            r103.i(r100, 2, r102.getCode());
            ErrorDetails.ADAPTER.i(r100, 3, r102.getDetails());
            w r104 = ProtoAdapter.f282728q;
            r104.i(r100, 4, r102.getDisplay_message());
            r104.i(r100, 5, r102.getDisplay_title());
            r104.i(r100, 6, r102.getServer_message());
            ProtoAdapter.f282727p.i(r100, 7, r102.getExtra());
            r100.a(r102.unknownFields());
        }

        @Override // com.lark.wire.ProtoAdapter
        public final void g(n0 r100, LarkError r101) {
            LarkError r102 = r101;
            Intrinsics.checkNotNullParameter(r100, "writer");
            Intrinsics.checkNotNullParameter(r102, "value");
            r100.d(r102.unknownFields());
            ProtoAdapter.f282727p.j(r100, 7, r102.getExtra());
            w r103 = ProtoAdapter.f282728q;
            r103.j(r100, 6, r102.getServer_message());
            r103.j(r100, 5, r102.getDisplay_title());
            r103.j(r100, 4, r102.getDisplay_message());
            ErrorDetails.ADAPTER.j(r100, 3, r102.getDetails());
            s r104 = ProtoAdapter.f282719h;
            r104.j(r100, 2, r102.getCode());
            r104.j(r100, 1, r102.getStatus());
        }

        public b(FieldEncoding r100, KClass<LarkError> r101, Syntax r102) {
            super(r100, r101, "type.googleapis.com/basic.v1.LarkError", r102, null);
        }
    }

    public static final class c {
        public c() {
        }
    }

    public /* synthetic */ LarkError(a r100, ByteString r101, DefaultConstructorMarker r102) {
        this(r100, r101);
    }

    static {
        Companion = new c();
        b r100 = new b(FieldEncoding.LENGTH_DELIMITED, Reflection.getOrCreateKotlinClass(LarkError.class), Syntax.PROTO_2);
        ADAPTER = r100;
        Intrinsics.checkNotNull(r100, "null cannot be cast to non-null type com.bytedance.larksuite.wire.IUserScopeAdapter<com.lark.kmp.pb.basic.v1.LarkError>");
        RAW_TYPE_ADAPTER = r100;
    }

    @Override // com.lark.wire.Message
    public a newBuilder() {
        a r100 = new a();
        r100.f279833d = this.status;
        r100.f279834e = this.code;
        r100.f279835f = this.details;
        r100.f279836g = this.display_message;
        r100.f279837h = this.display_title;
        r100.f279838i = this.server_message;
        r100.f279839j = this.extra;
        r100.a(unknownFields());
        return r100;
    }

    @Override // com.lark.wire.Message
    public String toString() {
        return Reflection.getOrCreateKotlinClass(LarkError.class).getSimpleName() + '@' + hashCode();
    }

    public final Integer getCode() {
        return this.code;
    }

    public final ErrorDetails getDetails() {
        return this.details;
    }

    public final String getDisplay_message() {
        return this.display_message;
    }

    public final String getDisplay_title() {
        return this.display_title;
    }

    public final ByteString getExtra() {
        return this.extra;
    }

    public final String getServer_message() {
        return this.server_message;
    }

    public final Integer getStatus() {
        return this.status;
    }

    @Override // com.lark.wire.Message
    public /* bridge */ /* synthetic */ com.lark.wire.Message.a newBuilder() {
        return newBuilder();
    }

    public LarkError(a r100, ByteString r101) {
        super(ADAPTER, r101);
        this.status = r100.f279833d;
        this.code = r100.f279834e;
        this.details = r100.f279835f;
        this.display_message = r100.f279836g;
        this.display_title = r100.f279837h;
        this.server_message = r100.f279838i;
        this.extra = r100.f279839j;
    }

    public /* synthetic */ LarkError(a r100, ByteString r101, int r102, DefaultConstructorMarker r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = ByteString.EMPTY;
    L5:
        this(r100, r101);
    }
}
