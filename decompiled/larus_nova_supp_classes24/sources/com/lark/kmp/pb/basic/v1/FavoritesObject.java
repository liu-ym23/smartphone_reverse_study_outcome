package com.lark.kmp.pb.basic.v1;

import com.lark.wire.FieldEncoding;
import com.lark.wire.ProtoAdapter;
import com.lark.wire.Syntax;
import com.lark.wire.g0;
import com.lark.wire.j0;
import com.lark.wire.n0;
import com.larksuite.component.universe_design.timepicker.impl.base.WheelView;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClass;
import okio.ByteString;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 \u001f2\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00020\u0001:\u0003\u001e\u001f B\u001b\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\b\u0010\u001c\u001a\u00020\u0002H\u0016J\b\u0010\u001d\u001a\u00020\tH\u0016R\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\f\u001a\u00020\r¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0010\u001a\u00020\u0011¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0013\u0010\u0014\u001a\u0004\u0018\u00010\u0015¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u0013\u0010\u0018\u001a\u0004\u0018\u00010\u0019¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u001b¨\u0006!"}, d2 = {"Lcom/lark/kmp/pb/basic/v1/FavoritesObject;", "Lcom/lark/wire/Message;", "Lcom/lark/kmp/pb/basic/v1/FavoritesObject$Builder;", "builder", "unknownFields", "Lokio/ByteString;", "<init>", "(Lcom/lark/kmp/pb/basic/v1/FavoritesObject$Builder;Lokio/ByteString;)V", "id", "", "getId", "()Ljava/lang/String;", "create_time", "", "getCreate_time", "()J", "type", "Lcom/lark/kmp/pb/basic/v1/FavoritesType;", "getType", "()Lcom/lark/kmp/pb/basic/v1/FavoritesType;", "content", "Lcom/lark/kmp/pb/basic/v1/FavoritesObject$FavoritesContent;", "getContent", "()Lcom/lark/kmp/pb/basic/v1/FavoritesObject$FavoritesContent;", "translation_content", "Lcom/lark/kmp/pb/basic/v1/Content;", "getTranslation_content", "()Lcom/lark/kmp/pb/basic/v1/Content;", "newBuilder", "toString", "Builder", "Companion", "FavoritesContent", "rust-sdk-kotlin-pb_release"}, k = 1, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
public final class FavoritesObject extends com.lark.wire.Message<FavoritesObject, a> {
    public static final ProtoAdapter<FavoritesObject> ADAPTER = null;
    public static final c Companion = null;
    private static final long serialVersionUID = 0;
    private final FavoritesContent content;
    private final long create_time;
    private final String id;
    private final Content translation_content;
    private final FavoritesType type;

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0007\u0018\u0000 \u000f2\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00020\u0001:\u0002\u000e\u000fB\u001b\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\b\u0010\f\u001a\u00020\u0002H\u0016J\b\u0010\r\u001a\u00020\tH\u0016R\u0013\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0010"}, d2 = {"Lcom/lark/kmp/pb/basic/v1/FavoritesObject$FavoritesContent;", "Lcom/lark/wire/Message;", "Lcom/lark/kmp/pb/basic/v1/FavoritesObject$FavoritesContent$Builder;", "builder", "unknownFields", "Lokio/ByteString;", "<init>", "(Lcom/lark/kmp/pb/basic/v1/FavoritesObject$FavoritesContent$Builder;Lokio/ByteString;)V", "message_id", "", "getMessage_id", "()Ljava/lang/String;", "newBuilder", "toString", "Builder", "Companion", "rust-sdk-kotlin-pb_release"}, k = 1, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
    public static final class FavoritesContent extends com.lark.wire.Message<FavoritesContent, a> {
        public static final ProtoAdapter<FavoritesContent> ADAPTER = null;
        public static final c Companion = null;
        private static final long serialVersionUID = 0;
        private final String message_id;

        public static final class a extends com.lark.wire.Message.a<FavoritesContent, a> {
            public String d;

            @Override // com.lark.wire.Message.a
            public final com.lark.wire.Message b() {
                return new FavoritesContent(this, c(), null);
            }

            public a() {
            }
        }

        public static final class b extends ProtoAdapter<FavoritesContent> {
            @Override // com.lark.wire.ProtoAdapter
            public final FavoritesContent c(g0 r7) {
                Intrinsics.checkNotNullParameter(r7, "reader");
                a r1 = new a();
                long r2 = r7.c();
            L3:
                int r4 = r7.e();
                if (r4 == (-1)) goto L10;
                if (r4 == 1) goto L7;
                r7.j(r4);
                goto L3
            L7:
                ProtoAdapter.q.getClass();
                Intrinsics.checkNotNullParameter(r7, "reader");
                r1.d = r7.i();
                goto L3
            L10:
                return new FavoritesContent(r1, r7.d(r2), null);
            }

            @Override // com.lark.wire.ProtoAdapter
            public final int k(FavoritesContent r4) {
                FavoritesContent r5 = r4;
                Intrinsics.checkNotNullParameter(r5, "value");
                return r5.unknownFields().size() + ProtoAdapter.q.l(1, r5.getMessage_id());
            }

            @Override // com.lark.wire.ProtoAdapter
            public final void f(j0 r4, FavoritesContent r5) {
                FavoritesContent r6 = r5;
                Intrinsics.checkNotNullParameter(r4, "writer");
                Intrinsics.checkNotNullParameter(r6, "value");
                ProtoAdapter.q.i(r4, 1, r6.getMessage_id());
                r4.a(r6.unknownFields());
            }

            @Override // com.lark.wire.ProtoAdapter
            public final void g(n0 r3, FavoritesContent r4) {
                FavoritesContent r5 = r4;
                Intrinsics.checkNotNullParameter(r3, "writer");
                Intrinsics.checkNotNullParameter(r5, "value");
                r3.d(r5.unknownFields());
                ProtoAdapter.q.j(r3, 1, r5.getMessage_id());
            }

            public b(FieldEncoding r7, KClass<FavoritesContent> r8, Syntax r9) {
                super(r7, r8, "type.googleapis.com/basic.v1.FavoritesObject.FavoritesContent", r9, null);
            }
        }

        public static final class c {
            public c() {
            }
        }

        public /* synthetic */ FavoritesContent(a r1, ByteString r2, DefaultConstructorMarker r3) {
            this(r1, r2);
        }

        static {
            Companion = new c();
            ADAPTER = new b(FieldEncoding.LENGTH_DELIMITED, Reflection.getOrCreateKotlinClass(FavoritesContent.class), Syntax.PROTO_2);
        }

        @Override // com.lark.wire.Message
        public a newBuilder() {
            a r0 = new a();
            r0.d = this.message_id;
            r0.a(unknownFields());
            return r0;
        }

        @Override // com.lark.wire.Message
        public String toString() {
            return Reflection.getOrCreateKotlinClass(FavoritesContent.class).getSimpleName() + '@' + hashCode();
        }

        public final String getMessage_id() {
            return this.message_id;
        }

        @Override // com.lark.wire.Message
        public /* bridge */ /* synthetic */ com.lark.wire.Message.a newBuilder() {
            return newBuilder();
        }

        public FavoritesContent(a r2, ByteString r3) {
            super(ADAPTER, r3);
            this.message_id = r2.d;
        }

        public /* synthetic */ FavoritesContent(a r1, ByteString r2, int r3, DefaultConstructorMarker r4) {
            if ((r3 & 2) == 0) goto L5;
            r2 = ByteString.EMPTY;
        L5:
            this(r1, r2);
        }
    }

    public static final class a extends com.lark.wire.Message.a<FavoritesObject, a> {
        public String d;
        public Long e;
        public FavoritesType f;
        public FavoritesContent g;
        public Content h;

        @Override // com.lark.wire.Message.a
        public final com.lark.wire.Message b() {
            return new FavoritesObject(this, c(), null);
        }

        public a() {
        }
    }

    public static final class b extends ProtoAdapter<FavoritesObject> {
        @Override // com.lark.wire.ProtoAdapter
        public final FavoritesObject c(g0 r10) {
            Intrinsics.checkNotNullParameter(r10, "reader");
            a r1 = new a();
            long r2 = r10.c();
        L3:
            int r4 = r10.e();
            if (r4 == (-1)) goto L25;
            if (r4 != 1) goto L8;
            ProtoAdapter.q.getClass();
            Intrinsics.checkNotNullParameter(r10, "reader");
            String r5 = r10.i();
            Intrinsics.checkNotNullParameter(r5, "id");
            r1.d = r5;
            goto L3
        L8:
            if (r4 != 2) goto L10;
            r1.e = Long.valueOf(((Number) ProtoAdapter.k.c(r10)).longValue());
            goto L3
        L10:
            if (r4 != 3) goto L12;
            FavoritesType r6 = FavoritesType.ADAPTER.c(r10);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L20
            Intrinsics.checkNotNullParameter(r6, "type");     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L20
            r1.f = r6;     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L20
        L20:
            e = move-exception;
            r10.a(r4, FieldEncoding.VARINT, Long.valueOf(e.value));
            Unit r7 = Unit.INSTANCE;
            goto L3
        L12:
            if (r4 != 4) goto L14;
            r1.g = FavoritesContent.ADAPTER.c(r10);
            goto L3
        L14:
            if (r4 != 5) goto L15;
            r1.h = Content.ADAPTER.c(r10);
            goto L3
        L15:
            r10.j(r4);
            Unit r8 = Unit.INSTANCE;
            goto L3
        L25:
            return new FavoritesObject(r1, r10.d(r2), null);
        }

        @Override // com.lark.wire.ProtoAdapter
        public final int k(FavoritesObject r5) {
            FavoritesObject r6 = r5;
            Intrinsics.checkNotNullParameter(r6, "value");
            return ((((r6.unknownFields().size() + ProtoAdapter.q.l(1, r6.getId())) + ProtoAdapter.k.l(2, Long.valueOf(r6.getCreate_time()))) + FavoritesType.ADAPTER.l(3, r6.getType())) + FavoritesContent.ADAPTER.l(4, r6.getContent())) + Content.ADAPTER.l(5, r6.getTranslation_content());
        }

        @Override // com.lark.wire.ProtoAdapter
        public final void f(j0 r4, FavoritesObject r5) {
            FavoritesObject r6 = r5;
            Intrinsics.checkNotNullParameter(r4, "writer");
            Intrinsics.checkNotNullParameter(r6, "value");
            ProtoAdapter.q.i(r4, 1, r6.getId());
            ProtoAdapter.k.i(r4, 2, Long.valueOf(r6.getCreate_time()));
            FavoritesType.ADAPTER.i(r4, 3, r6.getType());
            FavoritesContent.ADAPTER.i(r4, 4, r6.getContent());
            Content.ADAPTER.i(r4, 5, r6.getTranslation_content());
            r4.a(r6.unknownFields());
        }

        @Override // com.lark.wire.ProtoAdapter
        public final void g(n0 r4, FavoritesObject r5) {
            FavoritesObject r6 = r5;
            Intrinsics.checkNotNullParameter(r4, "writer");
            Intrinsics.checkNotNullParameter(r6, "value");
            r4.d(r6.unknownFields());
            Content.ADAPTER.j(r4, 5, r6.getTranslation_content());
            FavoritesContent.ADAPTER.j(r4, 4, r6.getContent());
            FavoritesType.ADAPTER.j(r4, 3, r6.getType());
            ProtoAdapter.k.j(r4, 2, Long.valueOf(r6.getCreate_time()));
            ProtoAdapter.q.j(r4, 1, r6.getId());
        }

        public b(FieldEncoding r7, KClass<FavoritesObject> r8, Syntax r9) {
            super(r7, r8, "type.googleapis.com/basic.v1.FavoritesObject", r9, null);
        }
    }

    public static final class c {
        public c() {
        }
    }

    public /* synthetic */ FavoritesObject(a r1, ByteString r2, DefaultConstructorMarker r3) {
        this(r1, r2);
    }

    static {
        Companion = new c();
        ADAPTER = new b(FieldEncoding.LENGTH_DELIMITED, Reflection.getOrCreateKotlinClass(FavoritesObject.class), Syntax.PROTO_2);
    }

    @Override // com.lark.wire.Message
    public a newBuilder() {
        a r0 = new a();
        r0.d = this.id;
        r0.e = Long.valueOf(this.create_time);
        r0.f = this.type;
        r0.g = this.content;
        r0.h = this.translation_content;
        r0.a(unknownFields());
        return r0;
    }

    @Override // com.lark.wire.Message
    public String toString() {
        return Reflection.getOrCreateKotlinClass(FavoritesObject.class).getSimpleName() + '@' + hashCode();
    }

    public final FavoritesContent getContent() {
        return this.content;
    }

    public final long getCreate_time() {
        return this.create_time;
    }

    public final String getId() {
        return this.id;
    }

    public final Content getTranslation_content() {
        return this.translation_content;
    }

    public final FavoritesType getType() {
        return this.type;
    }

    @Override // com.lark.wire.Message
    public /* bridge */ /* synthetic */ com.lark.wire.Message.a newBuilder() {
        return newBuilder();
    }

    public FavoritesObject(a r3, ByteString r4) {
        super(ADAPTER, r4);
        String r5 = r3.d;
        Intrinsics.checkNotNull(r5);
        this.id = r5;
        Long r6 = r3.e;
        Intrinsics.checkNotNull(r6);
        this.create_time = r6.longValue();
        FavoritesType r7 = r3.f;
        Intrinsics.checkNotNull(r7);
        this.type = r7;
        this.content = r3.g;
        this.translation_content = r3.h;
    }

    public /* synthetic */ FavoritesObject(a r1, ByteString r2, int r3, DefaultConstructorMarker r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = ByteString.EMPTY;
    L5:
        this(r1, r2);
    }
}
