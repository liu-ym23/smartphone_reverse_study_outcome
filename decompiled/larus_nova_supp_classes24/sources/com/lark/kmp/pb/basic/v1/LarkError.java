package com.lark.kmp.pb.basic.v1;

import com.lark.wire.FieldEncoding;
import com.lark.wire.ProtoAdapter;
import com.lark.wire.Syntax;
import com.lark.wire.g0;
import com.lark.wire.j0;
import com.lark.wire.n0;
import com.lark.wire.s;
import com.lark.wire.w;
import com.larksuite.component.universe_design.timepicker.impl.base.WheelView;
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

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u000f\u0018\u0000 \"2\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0003:\u0003!\"#B\u001b\b\u0002\u0012\u0006\u0010\u0004\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006¢\u0006\u0004\b\u0007\u0010\bJ\b\u0010\u001f\u001a\u00020\u0002H\u0016J\b\u0010 \u001a\u00020\u0015H\u0016R\u0015\u0010\t\u001a\u0004\u0018\u00010\n¢\u0006\n\n\u0002\u0010\r\u001a\u0004\b\u000b\u0010\fR\u0015\u0010\u000e\u001a\u0004\u0018\u00010\n¢\u0006\n\n\u0002\u0010\r\u001a\u0004\b\u000f\u0010\fR\u0013\u0010\u0010\u001a\u0004\u0018\u00010\u0011¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0013\u0010\u0014\u001a\u0004\u0018\u00010\u0015¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u0013\u0010\u0018\u001a\u0004\u0018\u00010\u0015¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0017R\u0013\u0010\u001a\u001a\u0004\u0018\u00010\u0015¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u0017R\u0013\u0010\u001c\u001a\u0004\u0018\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001e¨\u0006$"}, d2 = {"Lcom/lark/kmp/pb/basic/v1/LarkError;", "Lcom/lark/wire/Message;", "Lcom/lark/kmp/pb/basic/v1/LarkError$Builder;", "Lcom/bytedance/larksuite/wire/IUserScopeMessage;", "builder", "unknownFields", "Lokio/ByteString;", "<init>", "(Lcom/lark/kmp/pb/basic/v1/LarkError$Builder;Lokio/ByteString;)V", "status", "", "getStatus", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "code", "getCode", "details", "Lcom/lark/kmp/pb/basic/v1/LarkError$ErrorDetails;", "getDetails", "()Lcom/lark/kmp/pb/basic/v1/LarkError$ErrorDetails;", "display_message", "", "getDisplay_message", "()Ljava/lang/String;", "display_title", "getDisplay_title", "server_message", "getServer_message", "extra", "getExtra", "()Lokio/ByteString;", "newBuilder", "toString", "Builder", "Companion", "ErrorDetails", "rust-sdk-kotlin-pb_release"}, k = 1, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
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

    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 \u00182\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00020\u0001:\u0002\u0017\u0018B\u001b\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\b\u0010\u0015\u001a\u00020\u0002H\u0016J\b\u0010\u0016\u001a\u00020\tH\u0016R\u0013\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0013\u0010\f\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000bR\u0013\u0010\u000e\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000bR\u0017\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00120\u0011¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014¨\u0006\u0019"}, d2 = {"Lcom/lark/kmp/pb/basic/v1/LarkError$ErrorDetails;", "Lcom/lark/wire/Message;", "Lcom/lark/kmp/pb/basic/v1/LarkError$ErrorDetails$Builder;", "builder", "unknownFields", "Lokio/ByteString;", "<init>", "(Lcom/lark/kmp/pb/basic/v1/LarkError$ErrorDetails$Builder;Lokio/ByteString;)V", "debug_message", "", "getDebug_message", "()Ljava/lang/String;", "server_request_id", "getServer_request_id", "x_tt_logid", "getX_tt_logid", "headers", "", "Lcom/lark/kmp/pb/basic/v1/HttpHeader;", "getHeaders", "()Ljava/util/List;", "newBuilder", "toString", "Builder", "Companion", "rust-sdk-kotlin-pb_release"}, k = 1, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
    public static final class ErrorDetails extends com.lark.wire.Message<ErrorDetails, a> {
        public static final ProtoAdapter<ErrorDetails> ADAPTER = null;
        public static final c Companion = null;
        private static final long serialVersionUID = 0;
        private final String debug_message;
        private final List<HttpHeader> headers;
        private final String server_request_id;
        private final String x_tt_logid;

        public static final class a extends com.lark.wire.Message.a<ErrorDetails, a> {
            public String d;
            public String e;
            public String f;
            public List<HttpHeader> g;

            @Override // com.lark.wire.Message.a
            public final com.lark.wire.Message b() {
                return new ErrorDetails(this, c(), null);
            }

            public a() {
                this.g = CollectionsKt.emptyList();
            }
        }

        public static final class b extends ProtoAdapter<ErrorDetails> {
            @Override // com.lark.wire.ProtoAdapter
            public final ErrorDetails c(g0 r8) {
                Intrinsics.checkNotNullParameter(r8, "reader");
                a r1 = new a();
                ArrayList r2 = new ArrayList();
                long r3 = r8.c();
            L3:
                int r5 = r8.e();
                if (r5 == (-1)) goto L18;
                if (r5 != 1) goto L8;
                ProtoAdapter.q.getClass();
                Intrinsics.checkNotNullParameter(r8, "reader");
                r1.d = r8.i();
                goto L3
            L8:
                if (r5 != 2) goto L10;
                ProtoAdapter.q.getClass();
                Intrinsics.checkNotNullParameter(r8, "reader");
                r1.e = r8.i();
                goto L3
            L10:
                if (r5 != 3) goto L12;
                ProtoAdapter.q.getClass();
                Intrinsics.checkNotNullParameter(r8, "reader");
                r1.f = r8.i();
                goto L3
            L12:
                if (r5 != 4) goto L13;
                r2.add(HttpHeader.ADAPTER.c(r8));
                goto L3
            L13:
                r8.j(r5);
                Unit r6 = Unit.INSTANCE;
                goto L3
            L18:
                ByteString r9 = r8.d(r3);
                Intrinsics.checkNotNullParameter(r2, "headers");
                com.lark.wire.internal.a.a(r2);
                r1.g = r2;
                return new ErrorDetails(r1, r9, null);
            }

            @Override // com.lark.wire.ProtoAdapter
            public final int k(ErrorDetails r5) {
                ErrorDetails r6 = r5;
                Intrinsics.checkNotNullParameter(r6, "value");
                int r0 = r6.unknownFields().size();
                w r1 = ProtoAdapter.q;
                return (((r0 + r1.l(1, r6.getDebug_message())) + r1.l(2, r6.getServer_request_id())) + r1.l(3, r6.getX_tt_logid())) + HttpHeader.ADAPTER.a().l(4, r6.getHeaders());
            }

            @Override // com.lark.wire.ProtoAdapter
            public final void f(j0 r4, ErrorDetails r5) {
                ErrorDetails r6 = r5;
                Intrinsics.checkNotNullParameter(r4, "writer");
                Intrinsics.checkNotNullParameter(r6, "value");
                w r0 = ProtoAdapter.q;
                r0.i(r4, 1, r6.getDebug_message());
                r0.i(r4, 2, r6.getServer_request_id());
                r0.i(r4, 3, r6.getX_tt_logid());
                HttpHeader.ADAPTER.a().i(r4, 4, r6.getHeaders());
                r4.a(r6.unknownFields());
            }

            @Override // com.lark.wire.ProtoAdapter
            public final void g(n0 r4, ErrorDetails r5) {
                ErrorDetails r6 = r5;
                Intrinsics.checkNotNullParameter(r4, "writer");
                Intrinsics.checkNotNullParameter(r6, "value");
                r4.d(r6.unknownFields());
                HttpHeader.ADAPTER.a().j(r4, 4, r6.getHeaders());
                w r0 = ProtoAdapter.q;
                r0.j(r4, 3, r6.getX_tt_logid());
                r0.j(r4, 2, r6.getServer_request_id());
                r0.j(r4, 1, r6.getDebug_message());
            }

            public b(FieldEncoding r7, KClass<ErrorDetails> r8, Syntax r9) {
                super(r7, r8, "type.googleapis.com/basic.v1.LarkError.ErrorDetails", r9, null);
            }
        }

        public static final class c {
            public c() {
            }
        }

        public /* synthetic */ ErrorDetails(a r1, ByteString r2, DefaultConstructorMarker r3) {
            this(r1, r2);
        }

        static {
            Companion = new c();
            ADAPTER = new b(FieldEncoding.LENGTH_DELIMITED, Reflection.getOrCreateKotlinClass(ErrorDetails.class), Syntax.PROTO_2);
        }

        @Override // com.lark.wire.Message
        public a newBuilder() {
            a r0 = new a();
            r0.d = this.debug_message;
            r0.e = this.server_request_id;
            r0.f = this.x_tt_logid;
            r0.g = this.headers;
            r0.a(unknownFields());
            return r0;
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

        public ErrorDetails(a r2, ByteString r3) {
            super(ADAPTER, r3);
            this.debug_message = r2.d;
            this.server_request_id = r2.e;
            this.x_tt_logid = r2.f;
            this.headers = com.lark.wire.internal.a.c("headers", r2.g);
        }

        public /* synthetic */ ErrorDetails(a r1, ByteString r2, int r3, DefaultConstructorMarker r4) {
            if ((r3 & 2) == 0) goto L5;
            r2 = ByteString.EMPTY;
        L5:
            this(r1, r2);
        }
    }

    public static final class a extends com.lark.wire.Message.a<LarkError, a> implements d<LarkError> {
        public Integer d;
        public Integer e;
        public ErrorDetails f;
        public String g;
        public String h;
        public String i;
        public ByteString j;

        @Override // com.lark.wire.Message.a
        public final com.lark.wire.Message b() {
            return new LarkError(this, c(), null);
        }

        public a() {
        }
    }

    public static final class b extends ProtoAdapter<LarkError> implements we6.c<LarkError> {
        @Override // com.lark.wire.ProtoAdapter
        public final LarkError c(g0 r7) {
            Intrinsics.checkNotNullParameter(r7, "reader");
            a r1 = new a();
            long r2 = r7.c();
        L3:
            int r4 = r7.e();
            if (r4 == (-1)) goto L15;
            switch(r4) {
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
            ProtoAdapter.p.getClass();
            Intrinsics.checkNotNullParameter(r7, "reader");
            r1.j = r7.f();
            goto L3
        L8:
            ProtoAdapter.q.getClass();
            Intrinsics.checkNotNullParameter(r7, "reader");
            r1.i = r7.i();
            goto L3
        L9:
            ProtoAdapter.q.getClass();
            Intrinsics.checkNotNullParameter(r7, "reader");
            r1.h = r7.i();
            goto L3
        L10:
            ProtoAdapter.q.getClass();
            Intrinsics.checkNotNullParameter(r7, "reader");
            r1.g = r7.i();
            goto L3
        L11:
            r1.f = ErrorDetails.ADAPTER.c(r7);
            goto L3
        L12:
            r1.e = (Integer) ProtoAdapter.h.c(r7);
            goto L3
        L13:
            r1.d = (Integer) ProtoAdapter.h.c(r7);
            goto L3
        L6:
            r7.j(r4);
            Unit r5 = Unit.INSTANCE;
            goto L3
        L15:
            return new LarkError(r1, r7.d(r2), null);
        }

        @Override // com.lark.wire.ProtoAdapter
        public final int k(LarkError r5) {
            LarkError r6 = r5;
            Intrinsics.checkNotNullParameter(r6, "value");
            int r0 = r6.unknownFields().size();
            s r1 = ProtoAdapter.h;
            int r2 = ((r0 + r1.l(1, r6.getStatus())) + r1.l(2, r6.getCode())) + ErrorDetails.ADAPTER.l(3, r6.getDetails());
            w r3 = ProtoAdapter.q;
            return (((r2 + r3.l(4, r6.getDisplay_message())) + r3.l(5, r6.getDisplay_title())) + r3.l(6, r6.getServer_message())) + ProtoAdapter.p.l(7, r6.getExtra());
        }

        @Override // com.lark.wire.ProtoAdapter
        public final void f(j0 r4, LarkError r5) {
            LarkError r6 = r5;
            Intrinsics.checkNotNullParameter(r4, "writer");
            Intrinsics.checkNotNullParameter(r6, "value");
            s r0 = ProtoAdapter.h;
            r0.i(r4, 1, r6.getStatus());
            r0.i(r4, 2, r6.getCode());
            ErrorDetails.ADAPTER.i(r4, 3, r6.getDetails());
            w r1 = ProtoAdapter.q;
            r1.i(r4, 4, r6.getDisplay_message());
            r1.i(r4, 5, r6.getDisplay_title());
            r1.i(r4, 6, r6.getServer_message());
            ProtoAdapter.p.i(r4, 7, r6.getExtra());
            r4.a(r6.unknownFields());
        }

        @Override // com.lark.wire.ProtoAdapter
        public final void g(n0 r4, LarkError r5) {
            LarkError r6 = r5;
            Intrinsics.checkNotNullParameter(r4, "writer");
            Intrinsics.checkNotNullParameter(r6, "value");
            r4.d(r6.unknownFields());
            ProtoAdapter.p.j(r4, 7, r6.getExtra());
            w r0 = ProtoAdapter.q;
            r0.j(r4, 6, r6.getServer_message());
            r0.j(r4, 5, r6.getDisplay_title());
            r0.j(r4, 4, r6.getDisplay_message());
            ErrorDetails.ADAPTER.j(r4, 3, r6.getDetails());
            s r1 = ProtoAdapter.h;
            r1.j(r4, 2, r6.getCode());
            r1.j(r4, 1, r6.getStatus());
        }

        public b(FieldEncoding r7, KClass<LarkError> r8, Syntax r9) {
            super(r7, r8, "type.googleapis.com/basic.v1.LarkError", r9, null);
        }
    }

    public static final class c {
        public c() {
        }
    }

    public /* synthetic */ LarkError(a r1, ByteString r2, DefaultConstructorMarker r3) {
        this(r1, r2);
    }

    static {
        Companion = new c();
        b r3 = new b(FieldEncoding.LENGTH_DELIMITED, Reflection.getOrCreateKotlinClass(LarkError.class), Syntax.PROTO_2);
        ADAPTER = r3;
        Intrinsics.checkNotNull(r3, "null cannot be cast to non-null type com.bytedance.larksuite.wire.IUserScopeAdapter<com.lark.kmp.pb.basic.v1.LarkError>");
        RAW_TYPE_ADAPTER = r3;
    }

    @Override // com.lark.wire.Message
    public a newBuilder() {
        a r0 = new a();
        r0.d = this.status;
        r0.e = this.code;
        r0.f = this.details;
        r0.g = this.display_message;
        r0.h = this.display_title;
        r0.i = this.server_message;
        r0.j = this.extra;
        r0.a(unknownFields());
        return r0;
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

    public LarkError(a r2, ByteString r3) {
        super(ADAPTER, r3);
        this.status = r2.d;
        this.code = r2.e;
        this.details = r2.f;
        this.display_message = r2.g;
        this.display_title = r2.h;
        this.server_message = r2.i;
        this.extra = r2.j;
    }

    public /* synthetic */ LarkError(a r1, ByteString r2, int r3, DefaultConstructorMarker r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = ByteString.EMPTY;
    L5:
        this(r1, r2);
    }
}
