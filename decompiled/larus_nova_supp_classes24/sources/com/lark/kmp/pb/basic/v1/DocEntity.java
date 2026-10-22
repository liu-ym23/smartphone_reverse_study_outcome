package com.lark.kmp.pb.basic.v1;

import com.lark.wire.FieldEncoding;
import com.lark.wire.ProtoAdapter;
import com.lark.wire.Syntax;
import com.lark.wire.g0;
import com.lark.wire.j0;
import com.lark.wire.n0;
import com.lark.wire.w;
import com.larksuite.component.universe_design.timepicker.impl.base.WheelView;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClass;
import okio.ByteString;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 \u00112\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00020\u0001:\u0003\u0010\u0011\u0012B\u001b\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\b\u0010\u000e\u001a\u00020\u0002H\u0016J\b\u0010\u000f\u001a\u00020\nH\u0016R\u001d\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u000b0\t¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\r¨\u0006\u0013"}, d2 = {"Lcom/lark/kmp/pb/basic/v1/DocEntity;", "Lcom/lark/wire/Message;", "Lcom/lark/kmp/pb/basic/v1/DocEntity$Builder;", "builder", "unknownFields", "Lokio/ByteString;", "<init>", "(Lcom/lark/kmp/pb/basic/v1/DocEntity$Builder;Lokio/ByteString;)V", "element_entity_ref", "", "", "Lcom/lark/kmp/pb/basic/v1/DocEntity$ElementEntity;", "getElement_entity_ref", "()Ljava/util/Map;", "newBuilder", "toString", "Builder", "Companion", "ElementEntity", "rust-sdk-kotlin-pb_release"}, k = 1, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
public final class DocEntity extends com.lark.wire.Message<DocEntity, a> {
    public static final ProtoAdapter<DocEntity> ADAPTER = null;
    public static final b Companion = null;
    private static final long serialVersionUID = 0;
    private final Map<String, ElementEntity> element_entity_ref;

    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 \u001b2\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00020\u0001:\u0002\u001a\u001bB\u001b\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\b\u0010\u0018\u001a\u00020\u0002H\u0016J\b\u0010\u0019\u001a\u00020\tH\u0016R\u0013\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0013\u0010\f\u001a\u0004\u0018\u00010\r¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0013\u0010\u0010\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u000bR\u0013\u0010\u0012\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u000bR\u0013\u0010\u0014\u001a\u0004\u0018\u00010\u0015¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017¨\u0006\u001c"}, d2 = {"Lcom/lark/kmp/pb/basic/v1/DocEntity$ElementEntity;", "Lcom/lark/wire/Message;", "Lcom/lark/kmp/pb/basic/v1/DocEntity$ElementEntity$Builder;", "builder", "unknownFields", "Lokio/ByteString;", "<init>", "(Lcom/lark/kmp/pb/basic/v1/DocEntity$ElementEntity$Builder;Lokio/ByteString;)V", "title", "", "getTitle", "()Ljava/lang/String;", "doc_type", "Lcom/lark/kmp/pb/basic/v1/Doc$Type;", "getDoc_type", "()Lcom/lark/kmp/pb/basic/v1/Doc$Type;", "token", "getToken", "doc_url", "getDoc_url", "icon", "Lcom/lark/kmp/pb/basic/v1/Icon;", "getIcon", "()Lcom/lark/kmp/pb/basic/v1/Icon;", "newBuilder", "toString", "Builder", "Companion", "rust-sdk-kotlin-pb_release"}, k = 1, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
    public static final class ElementEntity extends com.lark.wire.Message<ElementEntity, a> {
        public static final ProtoAdapter<ElementEntity> ADAPTER = null;
        public static final c Companion = null;
        private static final long serialVersionUID = 0;
        private final Doc.Type doc_type;
        private final String doc_url;
        private final Icon icon;
        private final String title;
        private final String token;

        public static final class a extends com.lark.wire.Message.a<ElementEntity, a> {
            public String d;
            public Doc.Type e;
            public String f;
            public String g;
            public Icon h;

            @Override // com.lark.wire.Message.a
            public final com.lark.wire.Message b() {
                return new ElementEntity(this, c(), null);
            }

            public a() {
            }
        }

        public static final class b extends ProtoAdapter<ElementEntity> {
            @Override // com.lark.wire.ProtoAdapter
            public final ElementEntity c(g0 r10) {
                Intrinsics.checkNotNullParameter(r10, "reader");
                a r1 = new a();
                long r2 = r10.c();
            L3:
                int r4 = r10.e();
                if (r4 == (-1)) goto L25;
                if (r4 != 1) goto L8;
                ProtoAdapter.q.getClass();
                Intrinsics.checkNotNullParameter(r10, "reader");
                r1.d = r10.i();
                goto L3
            L8:
                if (r4 != 2) goto L10;
                r1.e = Doc.Type.ADAPTER.c(r10);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L21
            L21:
                e = move-exception;
                r10.a(r4, FieldEncoding.VARINT, Long.valueOf(e.value));
                Unit r5 = Unit.INSTANCE;
                goto L3
            L10:
                if (r4 != 3) goto L12;
                ProtoAdapter.q.getClass();
                Intrinsics.checkNotNullParameter(r10, "reader");
                r1.f = r10.i();
                goto L3
            L12:
                if (r4 != 4) goto L14;
                ProtoAdapter.q.getClass();
                Intrinsics.checkNotNullParameter(r10, "reader");
                r1.g = r10.i();
                goto L3
            L14:
                if (r4 != 5) goto L15;
                r1.h = Icon.ADAPTER.c(r10);
                goto L3
            L15:
                r10.j(r4);
                Unit r6 = Unit.INSTANCE;
                goto L3
            L25:
                return new ElementEntity(r1, r10.d(r2), null);
            }

            @Override // com.lark.wire.ProtoAdapter
            public final int k(ElementEntity r6) {
                ElementEntity r7 = r6;
                Intrinsics.checkNotNullParameter(r7, "value");
                int r0 = r7.unknownFields().size();
                w r1 = ProtoAdapter.q;
                return ((((r0 + r1.l(1, r7.getTitle())) + Doc.Type.ADAPTER.l(2, r7.getDoc_type())) + r1.l(3, r7.getToken())) + r1.l(4, r7.getDoc_url())) + Icon.ADAPTER.l(5, r7.getIcon());
            }

            @Override // com.lark.wire.ProtoAdapter
            public final void f(j0 r5, ElementEntity r6) {
                ElementEntity r7 = r6;
                Intrinsics.checkNotNullParameter(r5, "writer");
                Intrinsics.checkNotNullParameter(r7, "value");
                w r0 = ProtoAdapter.q;
                r0.i(r5, 1, r7.getTitle());
                Doc.Type.ADAPTER.i(r5, 2, r7.getDoc_type());
                r0.i(r5, 3, r7.getToken());
                r0.i(r5, 4, r7.getDoc_url());
                Icon.ADAPTER.i(r5, 5, r7.getIcon());
                r5.a(r7.unknownFields());
            }

            @Override // com.lark.wire.ProtoAdapter
            public final void g(n0 r5, ElementEntity r6) {
                ElementEntity r7 = r6;
                Intrinsics.checkNotNullParameter(r5, "writer");
                Intrinsics.checkNotNullParameter(r7, "value");
                r5.d(r7.unknownFields());
                Icon.ADAPTER.j(r5, 5, r7.getIcon());
                w r0 = ProtoAdapter.q;
                r0.j(r5, 4, r7.getDoc_url());
                r0.j(r5, 3, r7.getToken());
                Doc.Type.ADAPTER.j(r5, 2, r7.getDoc_type());
                r0.j(r5, 1, r7.getTitle());
            }

            public b(FieldEncoding r7, KClass<ElementEntity> r8, Syntax r9) {
                super(r7, r8, "type.googleapis.com/basic.v1.DocEntity.ElementEntity", r9, null);
            }
        }

        public static final class c {
            public c() {
            }
        }

        public /* synthetic */ ElementEntity(a r1, ByteString r2, DefaultConstructorMarker r3) {
            this(r1, r2);
        }

        static {
            Companion = new c();
            ADAPTER = new b(FieldEncoding.LENGTH_DELIMITED, Reflection.getOrCreateKotlinClass(ElementEntity.class), Syntax.PROTO_2);
        }

        @Override // com.lark.wire.Message
        public a newBuilder() {
            a r0 = new a();
            r0.d = this.title;
            r0.e = this.doc_type;
            r0.f = this.token;
            r0.g = this.doc_url;
            r0.h = this.icon;
            r0.a(unknownFields());
            return r0;
        }

        @Override // com.lark.wire.Message
        public String toString() {
            return Reflection.getOrCreateKotlinClass(ElementEntity.class).getSimpleName() + '@' + hashCode();
        }

        public final Doc.Type getDoc_type() {
            return this.doc_type;
        }

        public final String getDoc_url() {
            return this.doc_url;
        }

        public final Icon getIcon() {
            return this.icon;
        }

        public final String getTitle() {
            return this.title;
        }

        public final String getToken() {
            return this.token;
        }

        @Override // com.lark.wire.Message
        public /* bridge */ /* synthetic */ com.lark.wire.Message.a newBuilder() {
            return newBuilder();
        }

        public ElementEntity(a r2, ByteString r3) {
            super(ADAPTER, r3);
            this.title = r2.d;
            this.doc_type = r2.e;
            this.token = r2.f;
            this.doc_url = r2.g;
            this.icon = r2.h;
        }

        public /* synthetic */ ElementEntity(a r1, ByteString r2, int r3, DefaultConstructorMarker r4) {
            if ((r3 & 2) == 0) goto L5;
            r2 = ByteString.EMPTY;
        L5:
            this(r1, r2);
        }
    }

    public static final class a extends com.lark.wire.Message.a<DocEntity, a> {
        public Map<String, ElementEntity> d;

        @Override // com.lark.wire.Message.a
        public final com.lark.wire.Message b() {
            return new DocEntity(this, c(), null);
        }

        public a() {
            this.d = MapsKt.emptyMap();
        }
    }

    public static final class b {
        public b() {
        }
    }

    public /* synthetic */ DocEntity(a r1, ByteString r2, DefaultConstructorMarker r3) {
        this(r1, r2);
    }

    static {
        Companion = new b();
        final FieldEncoding r0 = FieldEncoding.LENGTH_DELIMITED;
        final KClass r1 = Reflection.getOrCreateKotlinClass(DocEntity.class);
        final Syntax r2 = Syntax.PROTO_2;
        ADAPTER = new DocEntity$Companion$ADAPTER$1(r0, r1, r2);
    }

    @Override // com.lark.wire.Message
    public a newBuilder() {
        a r0 = new a();
        r0.d = this.element_entity_ref;
        r0.a(unknownFields());
        return r0;
    }

    @Override // com.lark.wire.Message
    public String toString() {
        return Reflection.getOrCreateKotlinClass(DocEntity.class).getSimpleName() + '@' + hashCode();
    }

    public final Map<String, ElementEntity> getElement_entity_ref() {
        return this.element_entity_ref;
    }

    @Override // com.lark.wire.Message
    public /* bridge */ /* synthetic */ com.lark.wire.Message.a newBuilder() {
        return newBuilder();
    }

    public DocEntity(a r2, ByteString r3) {
        super(ADAPTER, r3);
        this.element_entity_ref = com.lark.wire.internal.a.d("element_entity_ref", r2.d);
    }

    public /* synthetic */ DocEntity(a r1, ByteString r2, int r3, DefaultConstructorMarker r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = ByteString.EMPTY;
    L5:
        this(r1, r2);
    }
}
