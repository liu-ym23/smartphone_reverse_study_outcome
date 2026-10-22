package com.lark.kmp.pb.basic.v1;

import com.lark.wire.FieldEncoding;
import com.lark.wire.ProtoAdapter;
import com.lark.wire.Syntax;
import com.lark.wire.g0;
import com.lark.wire.j0;
import com.lark.wire.n0;
import com.larksuite.component.universe_design.timepicker.impl.base.WheelView;
import com.larus.audio.call.dora.CommandStatus;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClass;
import okio.ByteString;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0004\u0018\u0000 \u00142\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00020\u0001:\u0003\u0013\u0014\u0015B\u001b\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\b\u0010\u0010\u001a\u00020\u0002H\u0016J\b\u0010\u0011\u001a\u00020\u0012H\u0016R\u0013\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0013\u0010\f\u001a\u0004\u0018\u00010\r¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u0016"}, d2 = {"Lcom/lark/kmp/pb/basic/v1/EngineEntity;", "Lcom/lark/wire/Message;", "Lcom/lark/kmp/pb/basic/v1/EngineEntity$Builder;", "builder", "unknownFields", "Lokio/ByteString;", "<init>", "(Lcom/lark/kmp/pb/basic/v1/EngineEntity$Builder;Lokio/ByteString;)V", "universal_card_entity", "Lcom/lark/kmp/pb/basic/v1/UniversalCardEntity;", "getUniversal_card_entity", "()Lcom/lark/kmp/pb/basic/v1/UniversalCardEntity;", "default_entity", "Lcom/lark/kmp/pb/basic/v1/EngineEntity$DefaultEntity;", "getDefault_entity", "()Lcom/lark/kmp/pb/basic/v1/EngineEntity$DefaultEntity;", "newBuilder", "toString", "", "Builder", "Companion", "DefaultEntity", "rust-sdk-kotlin-pb_release"}, k = 1, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
public final class EngineEntity extends com.lark.wire.Message<EngineEntity, a> {
    public static final ProtoAdapter<EngineEntity> ADAPTER = null;
    public static final c Companion = null;
    private static final long serialVersionUID = 0;
    private final DefaultEntity default_entity;
    private final UniversalCardEntity universal_card_entity;

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\u0003\u0018\u0000 \u000f2\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00020\u0001:\u0002\u000e\u000fB\u001b\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\b\u0010\u000b\u001a\u00020\u0002H\u0016J\b\u0010\f\u001a\u00020\rH\u0016R\u0013\u0010\b\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u0010"}, d2 = {"Lcom/lark/kmp/pb/basic/v1/EngineEntity$DefaultEntity;", "Lcom/lark/wire/Message;", "Lcom/lark/kmp/pb/basic/v1/EngineEntity$DefaultEntity$Builder;", "builder", "unknownFields", "Lokio/ByteString;", "<init>", "(Lcom/lark/kmp/pb/basic/v1/EngineEntity$DefaultEntity$Builder;Lokio/ByteString;)V", "body", "getBody", "()Lokio/ByteString;", "newBuilder", "toString", "", "Builder", "Companion", "rust-sdk-kotlin-pb_release"}, k = 1, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
    public static final class DefaultEntity extends com.lark.wire.Message<DefaultEntity, a> {
        public static final ProtoAdapter<DefaultEntity> ADAPTER = null;
        public static final c Companion = null;
        private static final long serialVersionUID = 0;
        private final ByteString body;

        public static final class a extends com.lark.wire.Message.a<DefaultEntity, a> {
            public ByteString d;

            @Override // com.lark.wire.Message.a
            public final com.lark.wire.Message b() {
                return new DefaultEntity(this, c(), null);
            }

            public a() {
            }
        }

        public static final class b extends ProtoAdapter<DefaultEntity> {
            @Override // com.lark.wire.ProtoAdapter
            public final DefaultEntity c(g0 r7) {
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
                ProtoAdapter.p.getClass();
                Intrinsics.checkNotNullParameter(r7, "reader");
                r1.d = r7.f();
                goto L3
            L10:
                return new DefaultEntity(r1, r7.d(r2), null);
            }

            @Override // com.lark.wire.ProtoAdapter
            public final int k(DefaultEntity r4) {
                DefaultEntity r5 = r4;
                Intrinsics.checkNotNullParameter(r5, "value");
                return r5.unknownFields().size() + ProtoAdapter.p.l(1, r5.getBody());
            }

            @Override // com.lark.wire.ProtoAdapter
            public final void f(j0 r4, DefaultEntity r5) {
                DefaultEntity r6 = r5;
                Intrinsics.checkNotNullParameter(r4, "writer");
                Intrinsics.checkNotNullParameter(r6, "value");
                ProtoAdapter.p.i(r4, 1, r6.getBody());
                r4.a(r6.unknownFields());
            }

            @Override // com.lark.wire.ProtoAdapter
            public final void g(n0 r3, DefaultEntity r4) {
                DefaultEntity r5 = r4;
                Intrinsics.checkNotNullParameter(r3, "writer");
                Intrinsics.checkNotNullParameter(r5, "value");
                r3.d(r5.unknownFields());
                ProtoAdapter.p.j(r3, 1, r5.getBody());
            }

            public b(FieldEncoding r7, KClass<DefaultEntity> r8, Syntax r9) {
                super(r7, r8, "type.googleapis.com/basic.v1.EngineEntity.DefaultEntity", r9, null);
            }
        }

        public static final class c {
            public c() {
            }
        }

        public /* synthetic */ DefaultEntity(a r1, ByteString r2, DefaultConstructorMarker r3) {
            this(r1, r2);
        }

        static {
            Companion = new c();
            ADAPTER = new b(FieldEncoding.LENGTH_DELIMITED, Reflection.getOrCreateKotlinClass(DefaultEntity.class), Syntax.PROTO_2);
        }

        @Override // com.lark.wire.Message
        public a newBuilder() {
            a r0 = new a();
            r0.d = this.body;
            r0.a(unknownFields());
            return r0;
        }

        @Override // com.lark.wire.Message
        public String toString() {
            return Reflection.getOrCreateKotlinClass(DefaultEntity.class).getSimpleName() + '@' + hashCode();
        }

        public final ByteString getBody() {
            return this.body;
        }

        @Override // com.lark.wire.Message
        public /* bridge */ /* synthetic */ com.lark.wire.Message.a newBuilder() {
            return newBuilder();
        }

        public DefaultEntity(a r2, ByteString r3) {
            super(ADAPTER, r3);
            this.body = r2.d;
        }

        public /* synthetic */ DefaultEntity(a r1, ByteString r2, int r3, DefaultConstructorMarker r4) {
            if ((r3 & 2) == 0) goto L5;
            r2 = ByteString.EMPTY;
        L5:
            this(r1, r2);
        }
    }

    public static final class a extends com.lark.wire.Message.a<EngineEntity, a> {
        public UniversalCardEntity d;
        public DefaultEntity e;

        @Override // com.lark.wire.Message.a
        public final com.lark.wire.Message b() {
            return new EngineEntity(this, c(), null);
        }

        public a() {
        }
    }

    public static final class b extends ProtoAdapter<EngineEntity> {
        @Override // com.lark.wire.ProtoAdapter
        public final EngineEntity c(g0 r7) {
            Intrinsics.checkNotNullParameter(r7, "reader");
            a r0 = new a();
            long r1 = r7.c();
        L3:
            int r3 = r7.e();
            DefaultConstructorMarker r5 = null;
            if (r3 == (-1)) goto L13;
            if (r3 != 1) goto L8;
            r0.d = UniversalCardEntity.ADAPTER.c(r7);
            r0.e = null;
            goto L3
        L8:
            if (r3 != 1000) goto L9;
            r0.e = DefaultEntity.ADAPTER.c(r7);
            r0.d = null;
            goto L3
        L9:
            r7.j(r3);
            Unit r4 = Unit.INSTANCE;
            goto L3
        L13:
            return new EngineEntity(r0, r7.d(r1), r5);
        }

        @Override // com.lark.wire.ProtoAdapter
        public final int k(EngineEntity r5) {
            EngineEntity r6 = r5;
            Intrinsics.checkNotNullParameter(r6, "value");
            return (r6.unknownFields().size() + UniversalCardEntity.ADAPTER.l(1, r6.getUniversal_card_entity())) + DefaultEntity.ADAPTER.l(CommandStatus.DORA_TRACE, r6.getDefault_entity());
        }

        @Override // com.lark.wire.ProtoAdapter
        public final void f(j0 r4, EngineEntity r5) {
            EngineEntity r6 = r5;
            Intrinsics.checkNotNullParameter(r4, "writer");
            Intrinsics.checkNotNullParameter(r6, "value");
            UniversalCardEntity.ADAPTER.i(r4, 1, r6.getUniversal_card_entity());
            DefaultEntity.ADAPTER.i(r4, CommandStatus.DORA_TRACE, r6.getDefault_entity());
            r4.a(r6.unknownFields());
        }

        @Override // com.lark.wire.ProtoAdapter
        public final void g(n0 r4, EngineEntity r5) {
            EngineEntity r6 = r5;
            Intrinsics.checkNotNullParameter(r4, "writer");
            Intrinsics.checkNotNullParameter(r6, "value");
            r4.d(r6.unknownFields());
            DefaultEntity.ADAPTER.j(r4, CommandStatus.DORA_TRACE, r6.getDefault_entity());
            UniversalCardEntity.ADAPTER.j(r4, 1, r6.getUniversal_card_entity());
        }

        public b(FieldEncoding r7, KClass<EngineEntity> r8, Syntax r9) {
            super(r7, r8, "type.googleapis.com/basic.v1.EngineEntity", r9, null);
        }
    }

    public static final class c {
        public c() {
        }
    }

    public /* synthetic */ EngineEntity(a r1, ByteString r2, DefaultConstructorMarker r3) {
        this(r1, r2);
    }

    static {
        Companion = new c();
        ADAPTER = new b(FieldEncoding.LENGTH_DELIMITED, Reflection.getOrCreateKotlinClass(EngineEntity.class), Syntax.PROTO_2);
    }

    @Override // com.lark.wire.Message
    public a newBuilder() {
        a r0 = new a();
        r0.d = this.universal_card_entity;
        r0.e = this.default_entity;
        r0.a(unknownFields());
        return r0;
    }

    @Override // com.lark.wire.Message
    public String toString() {
        return Reflection.getOrCreateKotlinClass(EngineEntity.class).getSimpleName() + '@' + hashCode();
    }

    public final DefaultEntity getDefault_entity() {
        return this.default_entity;
    }

    public final UniversalCardEntity getUniversal_card_entity() {
        return this.universal_card_entity;
    }

    @Override // com.lark.wire.Message
    public /* bridge */ /* synthetic */ com.lark.wire.Message.a newBuilder() {
        return newBuilder();
    }

    public EngineEntity(a r3, ByteString r4) {
        super(ADAPTER, r4);
        UniversalCardEntity r5 = r3.d;
        this.universal_card_entity = r5;
        DefaultEntity r6 = r3.e;
        this.default_entity = r6;
        boolean r0 = false;
        if (r5 == null) goto L5;
        int r7 = 1;
    L6:
        if (r6 == null) goto L8;
        int r8 = 1;
    L10:
        if ((r7 + r8) > 1) goto L12;
        r0 = true;
    L12:
        if (r0 == false) goto L15;
        return;
    L15:
        throw new IllegalArgumentException("At most one of universal_card_entity, default_entity may be non-null".toString());
    L8:
        r8 = 0;
        goto L10
    L5:
        r7 = 0;
        goto L6
    }

    public /* synthetic */ EngineEntity(a r1, ByteString r2, int r3, DefaultConstructorMarker r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = ByteString.EMPTY;
    L5:
        this(r1, r2);
    }
}
