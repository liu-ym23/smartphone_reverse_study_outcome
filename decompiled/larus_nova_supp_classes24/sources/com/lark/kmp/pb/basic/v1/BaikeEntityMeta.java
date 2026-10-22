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
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u0000 \u001a2\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00020\u0001:\u0003\u0019\u001a\u001bB\u001b\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\b\u0010\u0017\u001a\u00020\u0002H\u0016J\b\u0010\u0018\u001a\u00020\tH\u0016R\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0015\u0010\f\u001a\u0004\u0018\u00010\r¢\u0006\n\n\u0002\u0010\u000f\u001a\u0004\b\f\u0010\u000eR\u001d\u0010\u0010\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u00120\u0011¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u001d\u0010\u0015\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\t0\u0011¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0014¨\u0006\u001c"}, d2 = {"Lcom/lark/kmp/pb/basic/v1/BaikeEntityMeta;", "Lcom/lark/wire/Message;", "Lcom/lark/kmp/pb/basic/v1/BaikeEntityMeta$Builder;", "builder", "unknownFields", "Lokio/ByteString;", "<init>", "(Lcom/lark/kmp/pb/basic/v1/BaikeEntityMeta$Builder;Lokio/ByteString;)V", "id", "", "getId", "()Ljava/lang/String;", "is_allow_all", "", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "allowed_typed_ids", "", "Lcom/lark/kmp/pb/basic/v1/BaikeEntityMeta$TypedIDs;", "getAllowed_typed_ids", "()Ljava/util/Map;", "platform_disable_option", "getPlatform_disable_option", "newBuilder", "toString", "Builder", "Companion", "TypedIDs", "rust-sdk-kotlin-pb_release"}, k = 1, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
public final class BaikeEntityMeta extends com.lark.wire.Message<BaikeEntityMeta, a> {
    public static final ProtoAdapter<BaikeEntityMeta> ADAPTER = null;
    public static final b Companion = null;
    private static final long serialVersionUID = 0;
    private final Map<String, TypedIDs> allowed_typed_ids;
    private final String id;
    private final Boolean is_allow_all;
    private final Map<String, String> platform_disable_option;

    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0007\u0018\u0000 \u00102\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00020\u0001:\u0002\u000f\u0010B\u001b\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\b\u0010\r\u001a\u00020\u0002H\u0016J\b\u0010\u000e\u001a\u00020\nH\u0016R\u0017\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\t¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f¨\u0006\u0011"}, d2 = {"Lcom/lark/kmp/pb/basic/v1/BaikeEntityMeta$TypedIDs;", "Lcom/lark/wire/Message;", "Lcom/lark/kmp/pb/basic/v1/BaikeEntityMeta$TypedIDs$Builder;", "builder", "unknownFields", "Lokio/ByteString;", "<init>", "(Lcom/lark/kmp/pb/basic/v1/BaikeEntityMeta$TypedIDs$Builder;Lokio/ByteString;)V", "ids", "", "", "getIds", "()Ljava/util/List;", "newBuilder", "toString", "Builder", "Companion", "rust-sdk-kotlin-pb_release"}, k = 1, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
    public static final class TypedIDs extends com.lark.wire.Message<TypedIDs, a> {
        public static final ProtoAdapter<TypedIDs> ADAPTER = null;
        public static final c Companion = null;
        private static final long serialVersionUID = 0;
        private final List<String> ids;

        public static final class a extends com.lark.wire.Message.a<TypedIDs, a> {
            public List<String> d;

            @Override // com.lark.wire.Message.a
            public final com.lark.wire.Message b() {
                return new TypedIDs(this, c(), null);
            }

            public a() {
                this.d = CollectionsKt.emptyList();
            }
        }

        public static final class b extends ProtoAdapter<TypedIDs> {
            @Override // com.lark.wire.ProtoAdapter
            public final TypedIDs c(g0 r8) {
                Intrinsics.checkNotNullParameter(r8, "reader");
                a r1 = new a();
                ArrayList r2 = new ArrayList();
                long r3 = r8.c();
            L3:
                int r5 = r8.e();
                if (r5 == (-1)) goto L9;
                if (r5 == 1) goto L7;
                r8.j(r5);
                goto L3
            L7:
                ProtoAdapter.q.getClass();
                Intrinsics.checkNotNullParameter(r8, "reader");
                r2.add(r8.i());
                goto L3
            L9:
                ByteString r9 = r8.d(r3);
                Intrinsics.checkNotNullParameter(r2, "ids");
                com.lark.wire.internal.a.a(r2);
                r1.d = r2;
                return new TypedIDs(r1, r9, null);
            }

            @Override // com.lark.wire.ProtoAdapter
            public final int k(TypedIDs r4) {
                TypedIDs r5 = r4;
                Intrinsics.checkNotNullParameter(r5, "value");
                return r5.unknownFields().size() + ProtoAdapter.q.a().l(1, r5.getIds());
            }

            @Override // com.lark.wire.ProtoAdapter
            public final void f(j0 r4, TypedIDs r5) {
                TypedIDs r6 = r5;
                Intrinsics.checkNotNullParameter(r4, "writer");
                Intrinsics.checkNotNullParameter(r6, "value");
                ProtoAdapter.q.a().i(r4, 1, r6.getIds());
                r4.a(r6.unknownFields());
            }

            @Override // com.lark.wire.ProtoAdapter
            public final void g(n0 r3, TypedIDs r4) {
                TypedIDs r5 = r4;
                Intrinsics.checkNotNullParameter(r3, "writer");
                Intrinsics.checkNotNullParameter(r5, "value");
                r3.d(r5.unknownFields());
                ProtoAdapter.q.a().j(r3, 1, r5.getIds());
            }

            public b(FieldEncoding r7, KClass<TypedIDs> r8, Syntax r9) {
                super(r7, r8, "type.googleapis.com/basic.v1.BaikeEntityMeta.TypedIDs", r9, null);
            }
        }

        public static final class c {
            public c() {
            }
        }

        public /* synthetic */ TypedIDs(a r1, ByteString r2, DefaultConstructorMarker r3) {
            this(r1, r2);
        }

        static {
            Companion = new c();
            ADAPTER = new b(FieldEncoding.LENGTH_DELIMITED, Reflection.getOrCreateKotlinClass(TypedIDs.class), Syntax.PROTO_2);
        }

        @Override // com.lark.wire.Message
        public a newBuilder() {
            a r0 = new a();
            r0.d = this.ids;
            r0.a(unknownFields());
            return r0;
        }

        @Override // com.lark.wire.Message
        public String toString() {
            return Reflection.getOrCreateKotlinClass(TypedIDs.class).getSimpleName() + '@' + hashCode();
        }

        public final List<String> getIds() {
            return this.ids;
        }

        @Override // com.lark.wire.Message
        public /* bridge */ /* synthetic */ com.lark.wire.Message.a newBuilder() {
            return newBuilder();
        }

        public TypedIDs(a r2, ByteString r3) {
            super(ADAPTER, r3);
            this.ids = com.lark.wire.internal.a.c("ids", r2.d);
        }

        public /* synthetic */ TypedIDs(a r1, ByteString r2, int r3, DefaultConstructorMarker r4) {
            if ((r3 & 2) == 0) goto L5;
            r2 = ByteString.EMPTY;
        L5:
            this(r1, r2);
        }
    }

    public static final class a extends com.lark.wire.Message.a<BaikeEntityMeta, a> {
        public String d;
        public Boolean e;
        public Map<String, TypedIDs> f;
        public Map<String, String> g;

        @Override // com.lark.wire.Message.a
        public final com.lark.wire.Message b() {
            return new BaikeEntityMeta(this, c(), null);
        }

        public a() {
            this.f = MapsKt.emptyMap();
            this.g = MapsKt.emptyMap();
        }
    }

    public static final class b {
        public b() {
        }
    }

    public /* synthetic */ BaikeEntityMeta(a r1, ByteString r2, DefaultConstructorMarker r3) {
        this(r1, r2);
    }

    static {
        Companion = new b();
        final FieldEncoding r0 = FieldEncoding.LENGTH_DELIMITED;
        final KClass r1 = Reflection.getOrCreateKotlinClass(BaikeEntityMeta.class);
        final Syntax r2 = Syntax.PROTO_2;
        ADAPTER = new BaikeEntityMeta$Companion$ADAPTER$1(r0, r1, r2);
    }

    @Override // com.lark.wire.Message
    public a newBuilder() {
        a r0 = new a();
        r0.d = this.id;
        r0.e = this.is_allow_all;
        r0.f = this.allowed_typed_ids;
        r0.g = this.platform_disable_option;
        r0.a(unknownFields());
        return r0;
    }

    @Override // com.lark.wire.Message
    public String toString() {
        return Reflection.getOrCreateKotlinClass(BaikeEntityMeta.class).getSimpleName() + '@' + hashCode();
    }

    public final Map<String, TypedIDs> getAllowed_typed_ids() {
        return this.allowed_typed_ids;
    }

    public final String getId() {
        return this.id;
    }

    public final Map<String, String> getPlatform_disable_option() {
        return this.platform_disable_option;
    }

    public final Boolean is_allow_all() {
        return this.is_allow_all;
    }

    @Override // com.lark.wire.Message
    public /* bridge */ /* synthetic */ com.lark.wire.Message.a newBuilder() {
        return newBuilder();
    }

    public BaikeEntityMeta(a r2, ByteString r3) {
        super(ADAPTER, r3);
        String r4 = r2.d;
        Intrinsics.checkNotNull(r4);
        this.id = r4;
        this.is_allow_all = r2.e;
        this.allowed_typed_ids = com.lark.wire.internal.a.d("allowed_typed_ids", r2.f);
        this.platform_disable_option = com.lark.wire.internal.a.d("platform_disable_option", r2.g);
    }

    public /* synthetic */ BaikeEntityMeta(a r1, ByteString r2, int r3, DefaultConstructorMarker r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = ByteString.EMPTY;
    L5:
        this(r1, r2);
    }
}
