package com.lark.kmp.pb.basic.v1;

import com.lark.wire.FieldEncoding;
import com.lark.wire.ProtoAdapter;
import com.lark.wire.Syntax;
import com.lark.wire.g0;
import com.lark.wire.j0;
import com.lark.wire.n0;
import com.larksuite.component.universe_design.timepicker.impl.base.WheelView;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClass;
import okio.ByteString;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0004\u0018\u0000 \u00112\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00020\u0001:\u0003\u0010\u0011\u0012B\u001b\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\b\u0010\r\u001a\u00020\u0002H\u0016J\b\u0010\u000e\u001a\u00020\u000fH\u0016R\u0017\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\t¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f¨\u0006\u0013"}, d2 = {"Lcom/lark/kmp/pb/basic/v1/Trace;", "Lcom/lark/wire/Message;", "Lcom/lark/kmp/pb/basic/v1/Trace$Builder;", "builder", "unknownFields", "Lokio/ByteString;", "<init>", "(Lcom/lark/kmp/pb/basic/v1/Trace$Builder;Lokio/ByteString;)V", "spans", "", "Lcom/lark/kmp/pb/basic/v1/Trace$Span;", "getSpans", "()Ljava/util/List;", "newBuilder", "toString", "", "Builder", "Companion", "Span", "rust-sdk-kotlin-pb_release"}, k = 1, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
public final class Trace extends com.lark.wire.Message<Trace, a> {
    public static final ProtoAdapter<Trace> ADAPTER = null;
    public static final c Companion = null;
    private static final long serialVersionUID = 0;
    private final List<Span> spans;

    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0010$\n\u0002\b\u0007\u0018\u0000 \u00182\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00020\u0001:\u0002\u0017\u0018B\u001b\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\b\u0010\u0015\u001a\u00020\u0002H\u0016J\b\u0010\u0016\u001a\u00020\tH\u0016R\u0013\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0015\u0010\f\u001a\u0004\u0018\u00010\r¢\u0006\n\n\u0002\u0010\u0010\u001a\u0004\b\u000e\u0010\u000fR\u001d\u0010\u0011\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\t0\u0012¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014¨\u0006\u0019"}, d2 = {"Lcom/lark/kmp/pb/basic/v1/Trace$Span;", "Lcom/lark/wire/Message;", "Lcom/lark/kmp/pb/basic/v1/Trace$Span$Builder;", "builder", "unknownFields", "Lokio/ByteString;", "<init>", "(Lcom/lark/kmp/pb/basic/v1/Trace$Span$Builder;Lokio/ByteString;)V", "name", "", "getName", "()Ljava/lang/String;", "duration_millis", "", "getDuration_millis", "()Ljava/lang/Long;", "Ljava/lang/Long;", "attributes", "", "getAttributes", "()Ljava/util/Map;", "newBuilder", "toString", "Builder", "Companion", "rust-sdk-kotlin-pb_release"}, k = 1, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
    public static final class Span extends com.lark.wire.Message<Span, a> {
        public static final ProtoAdapter<Span> ADAPTER = null;
        public static final b Companion = null;
        private static final long serialVersionUID = 0;
        private final Map<String, String> attributes;
        private final Long duration_millis;
        private final String name;

        public static final class a extends com.lark.wire.Message.a<Span, a> {
            public String d;
            public Long e;
            public Map<String, String> f;

            @Override // com.lark.wire.Message.a
            public final com.lark.wire.Message b() {
                return new Span(this, c(), null);
            }

            public a() {
                this.f = MapsKt.emptyMap();
            }
        }

        public static final class b {
            public b() {
            }
        }

        public /* synthetic */ Span(a r1, ByteString r2, DefaultConstructorMarker r3) {
            this(r1, r2);
        }

        static {
            Companion = new b();
            final FieldEncoding r0 = FieldEncoding.LENGTH_DELIMITED;
            final KClass r1 = Reflection.getOrCreateKotlinClass(Span.class);
            final Syntax r2 = Syntax.PROTO_2;
            ADAPTER = new Trace$Span$Companion$ADAPTER$1(r0, r1, r2);
        }

        @Override // com.lark.wire.Message
        public a newBuilder() {
            a r0 = new a();
            r0.d = this.name;
            r0.e = this.duration_millis;
            r0.f = this.attributes;
            r0.a(unknownFields());
            return r0;
        }

        @Override // com.lark.wire.Message
        public String toString() {
            return Reflection.getOrCreateKotlinClass(Span.class).getSimpleName() + '@' + hashCode();
        }

        public final Map<String, String> getAttributes() {
            return this.attributes;
        }

        public final Long getDuration_millis() {
            return this.duration_millis;
        }

        public final String getName() {
            return this.name;
        }

        @Override // com.lark.wire.Message
        public /* bridge */ /* synthetic */ com.lark.wire.Message.a newBuilder() {
            return newBuilder();
        }

        public Span(a r2, ByteString r3) {
            super(ADAPTER, r3);
            this.name = r2.d;
            this.duration_millis = r2.e;
            this.attributes = com.lark.wire.internal.a.d("attributes", r2.f);
        }

        public /* synthetic */ Span(a r1, ByteString r2, int r3, DefaultConstructorMarker r4) {
            if ((r3 & 2) == 0) goto L5;
            r2 = ByteString.EMPTY;
        L5:
            this(r1, r2);
        }
    }

    public static final class a extends com.lark.wire.Message.a<Trace, a> {
        public List<Span> d;

        @Override // com.lark.wire.Message.a
        public final com.lark.wire.Message b() {
            return new Trace(this, c(), null);
        }

        public a() {
            this.d = CollectionsKt.emptyList();
        }
    }

    public static final class b extends ProtoAdapter<Trace> {
        @Override // com.lark.wire.ProtoAdapter
        public final Trace c(g0 r7) {
            Intrinsics.checkNotNullParameter(r7, "reader");
            a r0 = new a();
            ArrayList r1 = new ArrayList();
            long r2 = r7.c();
        L3:
            int r4 = r7.e();
            if (r4 == (-1)) goto L9;
            if (r4 == 1) goto L7;
            r7.j(r4);
            goto L3
        L7:
            r1.add(Span.ADAPTER.c(r7));
            goto L3
        L9:
            ByteString r8 = r7.d(r2);
            Intrinsics.checkNotNullParameter(r1, "spans");
            com.lark.wire.internal.a.a(r1);
            r0.d = r1;
            return new Trace(r0, r8, null);
        }

        @Override // com.lark.wire.ProtoAdapter
        public final int k(Trace r4) {
            Trace r5 = r4;
            Intrinsics.checkNotNullParameter(r5, "value");
            return r5.unknownFields().size() + Span.ADAPTER.a().l(1, r5.getSpans());
        }

        @Override // com.lark.wire.ProtoAdapter
        public final void f(j0 r4, Trace r5) {
            Trace r6 = r5;
            Intrinsics.checkNotNullParameter(r4, "writer");
            Intrinsics.checkNotNullParameter(r6, "value");
            Span.ADAPTER.a().i(r4, 1, r6.getSpans());
            r4.a(r6.unknownFields());
        }

        @Override // com.lark.wire.ProtoAdapter
        public final void g(n0 r3, Trace r4) {
            Trace r5 = r4;
            Intrinsics.checkNotNullParameter(r3, "writer");
            Intrinsics.checkNotNullParameter(r5, "value");
            r3.d(r5.unknownFields());
            Span.ADAPTER.a().j(r3, 1, r5.getSpans());
        }

        public b(FieldEncoding r7, KClass<Trace> r8, Syntax r9) {
            super(r7, r8, "type.googleapis.com/basic.v1.Trace", r9, null);
        }
    }

    public static final class c {
        public c() {
        }
    }

    public /* synthetic */ Trace(a r1, ByteString r2, DefaultConstructorMarker r3) {
        this(r1, r2);
    }

    static {
        Companion = new c();
        ADAPTER = new b(FieldEncoding.LENGTH_DELIMITED, Reflection.getOrCreateKotlinClass(Trace.class), Syntax.PROTO_2);
    }

    @Override // com.lark.wire.Message
    public a newBuilder() {
        a r0 = new a();
        r0.d = this.spans;
        r0.a(unknownFields());
        return r0;
    }

    @Override // com.lark.wire.Message
    public String toString() {
        return Reflection.getOrCreateKotlinClass(Trace.class).getSimpleName() + '@' + hashCode();
    }

    public final List<Span> getSpans() {
        return this.spans;
    }

    @Override // com.lark.wire.Message
    public /* bridge */ /* synthetic */ com.lark.wire.Message.a newBuilder() {
        return newBuilder();
    }

    public Trace(a r2, ByteString r3) {
        super(ADAPTER, r3);
        this.spans = com.lark.wire.internal.a.c("spans", r2.d);
    }

    public /* synthetic */ Trace(a r1, ByteString r2, int r3, DefaultConstructorMarker r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = ByteString.EMPTY;
    L5:
        this(r1, r2);
    }
}
