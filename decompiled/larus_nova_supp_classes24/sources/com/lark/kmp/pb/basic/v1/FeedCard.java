package com.lark.kmp.pb.basic.v1;

import com.lark.wire.FieldEncoding;
import com.lark.wire.ProtoAdapter;
import com.lark.wire.Syntax;
import com.lark.wire.d;
import com.lark.wire.g0;
import com.lark.wire.j0;
import com.lark.wire.n0;
import com.lark.wire.o0;
import com.lark.wire.w;
import com.larksuite.component.universe_design.timepicker.impl.base.WheelView;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClass;
import okio.ByteString;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\f\u0018\u0000 \u001e2\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00020\u0001:\u0004\u001d\u001e\u001f B\u001b\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\b\u0010\u001b\u001a\u00020\u0002H\u0016J\b\u0010\u001c\u001a\u00020\tH\u0016R\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\f\u001a\u00020\r¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0013\u0010\u0010\u001a\u0004\u0018\u00010\u0011¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0015\u0010\u0014\u001a\u0004\u0018\u00010\u0015¢\u0006\n\n\u0002\u0010\u0018\u001a\u0004\b\u0016\u0010\u0017R\u0013\u0010\u0019\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u000b¨\u0006!"}, d2 = {"Lcom/lark/kmp/pb/basic/v1/FeedCard;", "Lcom/lark/wire/Message;", "Lcom/lark/kmp/pb/basic/v1/FeedCard$Builder;", "builder", "unknownFields", "Lokio/ByteString;", "<init>", "(Lcom/lark/kmp/pb/basic/v1/FeedCard$Builder;Lokio/ByteString;)V", "id", "", "getId", "()Ljava/lang/String;", "entity_type", "Lcom/lark/kmp/pb/basic/v1/FeedCard$EntityType;", "getEntity_type", "()Lcom/lark/kmp/pb/basic/v1/FeedCard$EntityType;", "feed_type", "Lcom/lark/kmp/pb/basic/v1/FeedCard$FeedType;", "getFeed_type", "()Lcom/lark/kmp/pb/basic/v1/FeedCard$FeedType;", "update_time", "", "getUpdate_time", "()Ljava/lang/Long;", "Ljava/lang/Long;", "parent_card_id", "getParent_card_id", "newBuilder", "toString", "Builder", "Companion", "FeedType", "EntityType", "rust-sdk-kotlin-pb_release"}, k = 1, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
public final class FeedCard extends com.lark.wire.Message<FeedCard, a> {
    public static final ProtoAdapter<FeedCard> ADAPTER = null;
    public static final c Companion = null;
    public static final long DEFAULT_UPDATE_TIME = 0;
    private static final long serialVersionUID = 0;
    private final EntityType entity_type;
    private final FeedType feed_type;
    private final String id;
    private final String parent_card_id;
    private final Long update_time;

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\u0015\b\u0086\u0081\u0002\u0018\u0000 \u00182\u00020\u00012\b\u0012\u0004\u0012\u00020\u00000\u0002:\u0001\u0018B\u0011\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u0004X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012j\u0002\b\u0013j\u0002\b\u0014j\u0002\b\u0015j\u0002\b\u0016j\u0002\b\u0017¨\u0006\u0019"}, d2 = {"Lcom/lark/kmp/pb/basic/v1/FeedCard$EntityType;", "Lcom/lark/wire/WireEnum;", "", "value", "", "<init>", "(Ljava/lang/String;II)V", "getValue", "()I", "UNKNOWN_ENTITY", "CHAT", "EMAIL", "DOC_FEED", "THREAD", "BOX", "OPENAPP", "TOPIC", "SUBSCRIPTION", "MSG_THREAD", "MY_AI", "APP_FEED", "KNOWLEDGE_AI", "DOUBAO_CUSTOM", "EMAIL_ROOT_DRAFT", "Companion", "rust-sdk-kotlin-pb_release"}, k = 1, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
    public static final enum EntityType extends Enum<EntityType> implements o0 {
        public static final ProtoAdapter<EntityType> ADAPTER = null;
        public static final EntityType APP_FEED = null;
        public static final EntityType BOX = null;
        public static final EntityType CHAT = null;
        public static final b Companion = null;
        public static final EntityType DOC_FEED = null;
        public static final EntityType DOUBAO_CUSTOM = null;
        public static final EntityType EMAIL = null;
        public static final EntityType EMAIL_ROOT_DRAFT = null;
        public static final EntityType KNOWLEDGE_AI = null;
        public static final EntityType MSG_THREAD = null;
        public static final EntityType MY_AI = null;
        public static final EntityType OPENAPP = null;
        public static final EntityType SUBSCRIPTION = null;
        public static final EntityType THREAD = null;
        public static final EntityType TOPIC = null;
        public static final EntityType UNKNOWN_ENTITY = null;
        public static final /* synthetic */ EntityType[] a = null;
        public static final /* synthetic */ EnumEntries b = null;
        private final int value;

        public static final class a extends d<EntityType> {
            @Override // com.lark.wire.d
            public final o0 n(int r2) {
                EntityType.Companion.getClass();
                return b.a(r2);
            }

            public a(KClass<EntityType> r1, Syntax r2, EntityType r3) {
                super(r1, r2, r3);
            }
        }

        public static final class b {
            public b() {
            }

            @JvmStatic
            public static EntityType a(int r1) {
                if (r1 == 100) goto L22;
                switch(r1) {
                    case 0: goto L31;
                    case 1: goto L30;
                    case 2: goto L29;
                    case 3: goto L28;
                    case 4: goto L27;
                    case 5: goto L26;
                    case 6: goto L25;
                    case 7: goto L24;
                    default: goto L5;
                };
            L5:
                switch(r1) {
                    case 10: goto L37;
                    case 11: goto L36;
                    case 12: goto L35;
                    case 13: goto L34;
                    case 14: goto L33;
                    case 15: goto L32;
                    default: goto L6;
                };
            L6:
                return null;
            L32:
                return EntityType.DOUBAO_CUSTOM;
            L33:
                return EntityType.KNOWLEDGE_AI;
            L34:
                return EntityType.APP_FEED;
            L35:
                return EntityType.MY_AI;
            L36:
                return EntityType.MSG_THREAD;
            L37:
                return EntityType.SUBSCRIPTION;
            L24:
                return EntityType.TOPIC;
            L25:
                return EntityType.OPENAPP;
            L26:
                return EntityType.BOX;
            L27:
                return EntityType.THREAD;
            L28:
                return EntityType.DOC_FEED;
            L29:
                return EntityType.EMAIL;
            L30:
                return EntityType.CHAT;
            L31:
                return EntityType.UNKNOWN_ENTITY;
            L22:
                return EntityType.EMAIL_ROOT_DRAFT;
            }
        }

        @JvmStatic
        public static final EntityType fromValue(int r1) {
            Companion.getClass();
            return b.a(r1);
        }

        public static EnumEntries<EntityType> getEntries() {
            return b;
        }

        static {
            EntityType r0 = new EntityType("UNKNOWN_ENTITY", 0, 0);
            UNKNOWN_ENTITY = r0;
            EntityType r1 = new EntityType("CHAT", 1, 1);
            CHAT = r1;
            EntityType r3 = new EntityType("EMAIL", 2, 2);
            EMAIL = r3;
            EntityType r5 = new EntityType("DOC_FEED", 3, 3);
            DOC_FEED = r5;
            EntityType r7 = new EntityType("THREAD", 4, 4);
            THREAD = r7;
            EntityType r9 = new EntityType("BOX", 5, 5);
            BOX = r9;
            EntityType r11 = new EntityType("OPENAPP", 6, 6);
            OPENAPP = r11;
            EntityType r13 = new EntityType("TOPIC", 7, 7);
            TOPIC = r13;
            EntityType r15 = new EntityType("SUBSCRIPTION", 8, 10);
            SUBSCRIPTION = r15;
            EntityType r14 = new EntityType("MSG_THREAD", 9, 11);
            MSG_THREAD = r14;
            EntityType r12 = new EntityType("MY_AI", 10, 12);
            MY_AI = r12;
            EntityType r8 = new EntityType("APP_FEED", 11, 13);
            APP_FEED = r8;
            EntityType r10 = new EntityType("KNOWLEDGE_AI", 12, 14);
            KNOWLEDGE_AI = r10;
            EntityType r6 = new EntityType("DOUBAO_CUSTOM", 13, 15);
            DOUBAO_CUSTOM = r6;
            EntityType r4 = new EntityType("EMAIL_ROOT_DRAFT", 14, 100);
            EMAIL_ROOT_DRAFT = r4;
            EntityType[] r2 = {r0, r1, r3, r5, r7, r9, r11, r13, r15, r14, r12, r8, r10, r6, r4};
            a = r2;
            b = EnumEntriesKt.enumEntries(r2);
            Companion = new b();
            ADAPTER = new a(Reflection.getOrCreateKotlinClass(EntityType.class), Syntax.PROTO_2, r0);
        }

        public static EntityType[] values() {
            return (EntityType[]) a.clone();
        }

        @Override // com.lark.wire.o0
        public int getValue() {
            return this.value;
        }

        public static EntityType valueOf(String r1) {
            return (EntityType) r27.a.a(EntityType.class, r1);
        }

        public EntityType(String r1, int r2, int r3) {
            super(r1, r2);
            this.value = r3;
        }
    }

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\n\b\u0086\u0081\u0002\u0018\u0000 \r2\u00020\u00012\b\u0012\u0004\u0012\u00020\u00000\u0002:\u0001\rB\u0011\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u0004X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\f¨\u0006\u000e"}, d2 = {"Lcom/lark/kmp/pb/basic/v1/FeedCard$FeedType;", "Lcom/lark/wire/WireEnum;", "", "value", "", "<init>", "(Ljava/lang/String;II)V", "getValue", "()I", "UNKNOWN", "INBOX", "DONE", "MARK_AS_DELETED", "Companion", "rust-sdk-kotlin-pb_release"}, k = 1, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
    public static final enum FeedType extends Enum<FeedType> implements o0 {
        public static final ProtoAdapter<FeedType> ADAPTER = null;
        public static final b Companion = null;
        public static final FeedType DONE = null;
        public static final FeedType INBOX = null;
        public static final FeedType MARK_AS_DELETED = null;
        public static final FeedType UNKNOWN = null;
        public static final /* synthetic */ FeedType[] a = null;
        public static final /* synthetic */ EnumEntries b = null;
        private final int value;

        public static final class a extends d<FeedType> {
            @Override // com.lark.wire.d
            public final o0 n(int r2) {
                FeedType.Companion.getClass();
                if (r2 == 0) goto L15;
                if (r2 == 1) goto L19;
                if (r2 == 2) goto L18;
                if (r2 == 3) goto L17;
                return null;
            L17:
                return FeedType.MARK_AS_DELETED;
            L18:
                return FeedType.DONE;
            L19:
                return FeedType.INBOX;
            L15:
                return FeedType.UNKNOWN;
            }

            public a(KClass<FeedType> r1, Syntax r2, FeedType r3) {
                super(r1, r2, r3);
            }
        }

        public static final class b {
            public b() {
            }
        }

        public static EnumEntries<FeedType> getEntries() {
            return b;
        }

        static {
            FeedType r0 = new FeedType("UNKNOWN", 0, 0);
            UNKNOWN = r0;
            FeedType r1 = new FeedType("INBOX", 1, 1);
            INBOX = r1;
            FeedType r3 = new FeedType("DONE", 2, 2);
            DONE = r3;
            FeedType r5 = new FeedType("MARK_AS_DELETED", 3, 3);
            MARK_AS_DELETED = r5;
            FeedType[] r7 = {r0, r1, r3, r5};
            a = r7;
            b = EnumEntriesKt.enumEntries(r7);
            Companion = new b();
            ADAPTER = new a(Reflection.getOrCreateKotlinClass(FeedType.class), Syntax.PROTO_2, r0);
        }

        public static FeedType[] values() {
            return (FeedType[]) a.clone();
        }

        @Override // com.lark.wire.o0
        public int getValue() {
            return this.value;
        }

        @JvmStatic
        public static final FeedType fromValue(int r1) {
            Companion.getClass();
            if (r1 == 0) goto L15;
            if (r1 == 1) goto L19;
            if (r1 == 2) goto L18;
            if (r1 == 3) goto L17;
            return null;
        L17:
            return MARK_AS_DELETED;
        L18:
            return DONE;
        L19:
            return INBOX;
        L15:
            return UNKNOWN;
        }

        public static FeedType valueOf(String r1) {
            return (FeedType) r27.a.a(FeedType.class, r1);
        }

        public FeedType(String r1, int r2, int r3) {
            super(r1, r2);
            this.value = r3;
        }
    }

    public static final class a extends com.lark.wire.Message.a<FeedCard, a> {
        public String d;
        public EntityType e;
        public FeedType f;
        public Long g;
        public String h;

        @Override // com.lark.wire.Message.a
        public final com.lark.wire.Message b() {
            return new FeedCard(this, c(), null);
        }

        public a() {
        }
    }

    public static final class b extends ProtoAdapter<FeedCard> {
        @Override // com.lark.wire.ProtoAdapter
        public final FeedCard c(g0 r10) {
            Intrinsics.checkNotNullParameter(r10, "reader");
            a r1 = new a();
            long r2 = r10.c();
        L3:
            int r4 = r10.e();
            if (r4 == (-1)) goto L28;
            if (r4 != 1) goto L8;
            ProtoAdapter.q.getClass();
            Intrinsics.checkNotNullParameter(r10, "reader");
            String r5 = r10.i();
            Intrinsics.checkNotNullParameter(r5, "id");
            r1.d = r5;
            goto L3
        L8:
            if (r4 != 2) goto L10;
            EntityType r6 = EntityType.ADAPTER.c(r10);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L24
            Intrinsics.checkNotNullParameter(r6, "entity_type");     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L24
            r1.e = r6;     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L24
        L24:
            e = move-exception;
            r10.a(r4, FieldEncoding.VARINT, Long.valueOf(e.value));
            Unit r7 = Unit.INSTANCE;
            goto L3
        L10:
            if (r4 != 3) goto L12;
            r1.f = FeedType.ADAPTER.c(r10);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L20
        L20:
            e = move-exception;
            r10.a(r4, FieldEncoding.VARINT, Long.valueOf(e.value));
            Unit r8 = Unit.INSTANCE;
            goto L3
        L12:
            if (r4 != 4) goto L14;
            r1.g = (Long) ProtoAdapter.k.c(r10);
            goto L3
        L14:
            if (r4 != 5) goto L15;
            ProtoAdapter.q.getClass();
            Intrinsics.checkNotNullParameter(r10, "reader");
            r1.h = r10.i();
            goto L3
        L15:
            r10.j(r4);
            goto L3
        L28:
            return new FeedCard(r1, r10.d(r2), null);
        }

        @Override // com.lark.wire.ProtoAdapter
        public final int k(FeedCard r6) {
            FeedCard r7 = r6;
            Intrinsics.checkNotNullParameter(r7, "value");
            int r0 = r7.unknownFields().size();
            w r1 = ProtoAdapter.q;
            return ((((r0 + r1.l(1, r7.getId())) + EntityType.ADAPTER.l(2, r7.getEntity_type())) + FeedType.ADAPTER.l(3, r7.getFeed_type())) + ProtoAdapter.k.l(4, r7.getUpdate_time())) + r1.l(5, r7.getParent_card_id());
        }

        @Override // com.lark.wire.ProtoAdapter
        public final void f(j0 r5, FeedCard r6) {
            FeedCard r7 = r6;
            Intrinsics.checkNotNullParameter(r5, "writer");
            Intrinsics.checkNotNullParameter(r7, "value");
            w r0 = ProtoAdapter.q;
            r0.i(r5, 1, r7.getId());
            EntityType.ADAPTER.i(r5, 2, r7.getEntity_type());
            FeedType.ADAPTER.i(r5, 3, r7.getFeed_type());
            ProtoAdapter.k.i(r5, 4, r7.getUpdate_time());
            r0.i(r5, 5, r7.getParent_card_id());
            r5.a(r7.unknownFields());
        }

        @Override // com.lark.wire.ProtoAdapter
        public final void g(n0 r5, FeedCard r6) {
            FeedCard r7 = r6;
            Intrinsics.checkNotNullParameter(r5, "writer");
            Intrinsics.checkNotNullParameter(r7, "value");
            r5.d(r7.unknownFields());
            w r0 = ProtoAdapter.q;
            r0.j(r5, 5, r7.getParent_card_id());
            ProtoAdapter.k.j(r5, 4, r7.getUpdate_time());
            FeedType.ADAPTER.j(r5, 3, r7.getFeed_type());
            EntityType.ADAPTER.j(r5, 2, r7.getEntity_type());
            r0.j(r5, 1, r7.getId());
        }

        public b(FieldEncoding r7, KClass<FeedCard> r8, Syntax r9) {
            super(r7, r8, "type.googleapis.com/basic.v1.FeedCard", r9, null);
        }
    }

    public static final class c {
        public c() {
        }
    }

    public /* synthetic */ FeedCard(a r1, ByteString r2, DefaultConstructorMarker r3) {
        this(r1, r2);
    }

    static {
        Companion = new c();
        ADAPTER = new b(FieldEncoding.LENGTH_DELIMITED, Reflection.getOrCreateKotlinClass(FeedCard.class), Syntax.PROTO_2);
    }

    @Override // com.lark.wire.Message
    public a newBuilder() {
        a r0 = new a();
        r0.d = this.id;
        r0.e = this.entity_type;
        r0.f = this.feed_type;
        r0.g = this.update_time;
        r0.h = this.parent_card_id;
        r0.a(unknownFields());
        return r0;
    }

    @Override // com.lark.wire.Message
    public String toString() {
        return Reflection.getOrCreateKotlinClass(FeedCard.class).getSimpleName() + '@' + hashCode();
    }

    public final EntityType getEntity_type() {
        return this.entity_type;
    }

    public final FeedType getFeed_type() {
        return this.feed_type;
    }

    public final String getId() {
        return this.id;
    }

    public final String getParent_card_id() {
        return this.parent_card_id;
    }

    public final Long getUpdate_time() {
        return this.update_time;
    }

    @Override // com.lark.wire.Message
    public /* bridge */ /* synthetic */ com.lark.wire.Message.a newBuilder() {
        return newBuilder();
    }

    public FeedCard(a r2, ByteString r3) {
        super(ADAPTER, r3);
        String r4 = r2.d;
        Intrinsics.checkNotNull(r4);
        this.id = r4;
        EntityType r5 = r2.e;
        Intrinsics.checkNotNull(r5);
        this.entity_type = r5;
        this.feed_type = r2.f;
        this.update_time = r2.g;
        this.parent_card_id = r2.h;
    }

    public /* synthetic */ FeedCard(a r1, ByteString r2, int r3, DefaultConstructorMarker r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = ByteString.EMPTY;
    L5:
        this(r1, r2);
    }
}
