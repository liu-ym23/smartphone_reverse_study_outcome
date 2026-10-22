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
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\t\u0018\u0000 \u00142\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00020\u0001:\u0003\u0013\u0014\u0015B\u001b\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\b\u0010\u0011\u001a\u00020\u0002H\u0016J\b\u0010\u0012\u001a\u00020\tH\u0016R\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0015\u0010\f\u001a\u0004\u0018\u00010\r¢\u0006\n\n\u0002\u0010\u0010\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u0016"}, d2 = {"Lcom/lark/kmp/pb/basic/v1/ChatOptionInfo;", "Lcom/lark/wire/Message;", "Lcom/lark/kmp/pb/basic/v1/ChatOptionInfo$Builder;", "builder", "unknownFields", "Lokio/ByteString;", "<init>", "(Lcom/lark/kmp/pb/basic/v1/ChatOptionInfo$Builder;Lokio/ByteString;)V", "id", "", "getId", "()Ljava/lang/String;", "announce", "", "getAnnounce", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "newBuilder", "toString", "Builder", "Companion", "Config", "rust-sdk-kotlin-pb_release"}, k = 1, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
public final class ChatOptionInfo extends com.lark.wire.Message<ChatOptionInfo, a> {
    public static final ProtoAdapter<ChatOptionInfo> ADAPTER = null;
    public static final c Companion = null;
    public static final boolean DEFAULT_ANNOUNCE = true;
    private static final long serialVersionUID = 0;
    private final Boolean announce;
    private final String id;

    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\b\u0018\u0000 \u00142\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00020\u0001:\u0002\u0013\u0014B\u001b\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\b\u0010\u0011\u001a\u00020\u0002H\u0016J\b\u0010\u0012\u001a\u00020\tH\u0016R\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0015\u0010\f\u001a\u0004\u0018\u00010\r¢\u0006\n\n\u0002\u0010\u0010\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u0015"}, d2 = {"Lcom/lark/kmp/pb/basic/v1/ChatOptionInfo$Config;", "Lcom/lark/wire/Message;", "Lcom/lark/kmp/pb/basic/v1/ChatOptionInfo$Config$Builder;", "builder", "unknownFields", "Lokio/ByteString;", "<init>", "(Lcom/lark/kmp/pb/basic/v1/ChatOptionInfo$Config$Builder;Lokio/ByteString;)V", "id", "", "getId", "()Ljava/lang/String;", "announce", "", "getAnnounce", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "newBuilder", "toString", "Builder", "Companion", "rust-sdk-kotlin-pb_release"}, k = 1, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
    public static final class Config extends com.lark.wire.Message<Config, a> {
        public static final ProtoAdapter<Config> ADAPTER = null;
        public static final c Companion = null;
        public static final boolean DEFAULT_ANNOUNCE = false;
        private static final long serialVersionUID = 0;
        private final Boolean announce;
        private final String id;

        public static final class a extends com.lark.wire.Message.a<Config, a> {
            public String d;
            public Boolean e;

            @Override // com.lark.wire.Message.a
            public final com.lark.wire.Message b() {
                return new Config(this, c(), null);
            }

            public a() {
            }
        }

        public static final class b extends ProtoAdapter<Config> {
            @Override // com.lark.wire.ProtoAdapter
            public final Config c(g0 r7) {
                Intrinsics.checkNotNullParameter(r7, "reader");
                a r1 = new a();
                long r2 = r7.c();
            L3:
                int r4 = r7.e();
                if (r4 == (-1)) goto L13;
                if (r4 != 1) goto L8;
                ProtoAdapter.q.getClass();
                Intrinsics.checkNotNullParameter(r7, "reader");
                String r5 = r7.i();
                Intrinsics.checkNotNullParameter(r5, "id");
                r1.d = r5;
                goto L3
            L8:
                if (r4 != 2) goto L9;
                r1.e = (Boolean) ProtoAdapter.g.c(r7);
                goto L3
            L9:
                r7.j(r4);
                Unit r6 = Unit.INSTANCE;
                goto L3
            L13:
                return new Config(r1, r7.d(r2), null);
            }

            @Override // com.lark.wire.ProtoAdapter
            public final int k(Config r5) {
                Config r6 = r5;
                Intrinsics.checkNotNullParameter(r6, "value");
                return (r6.unknownFields().size() + ProtoAdapter.q.l(1, r6.getId())) + ProtoAdapter.g.l(2, r6.getAnnounce());
            }

            @Override // com.lark.wire.ProtoAdapter
            public final void f(j0 r4, Config r5) {
                Config r6 = r5;
                Intrinsics.checkNotNullParameter(r4, "writer");
                Intrinsics.checkNotNullParameter(r6, "value");
                ProtoAdapter.q.i(r4, 1, r6.getId());
                ProtoAdapter.g.i(r4, 2, r6.getAnnounce());
                r4.a(r6.unknownFields());
            }

            @Override // com.lark.wire.ProtoAdapter
            public final void g(n0 r4, Config r5) {
                Config r6 = r5;
                Intrinsics.checkNotNullParameter(r4, "writer");
                Intrinsics.checkNotNullParameter(r6, "value");
                r4.d(r6.unknownFields());
                ProtoAdapter.g.j(r4, 2, r6.getAnnounce());
                ProtoAdapter.q.j(r4, 1, r6.getId());
            }

            public b(FieldEncoding r7, KClass<Config> r8, Syntax r9) {
                super(r7, r8, "type.googleapis.com/basic.v1.ChatOptionInfo.Config", r9, null);
            }
        }

        public static final class c {
            public c() {
            }
        }

        public /* synthetic */ Config(a r1, ByteString r2, DefaultConstructorMarker r3) {
            this(r1, r2);
        }

        static {
            Companion = new c();
            ADAPTER = new b(FieldEncoding.LENGTH_DELIMITED, Reflection.getOrCreateKotlinClass(Config.class), Syntax.PROTO_2);
        }

        @Override // com.lark.wire.Message
        public a newBuilder() {
            a r0 = new a();
            r0.d = this.id;
            r0.e = this.announce;
            r0.a(unknownFields());
            return r0;
        }

        @Override // com.lark.wire.Message
        public String toString() {
            return Reflection.getOrCreateKotlinClass(Config.class).getSimpleName() + '@' + hashCode();
        }

        public final Boolean getAnnounce() {
            return this.announce;
        }

        public final String getId() {
            return this.id;
        }

        @Override // com.lark.wire.Message
        public /* bridge */ /* synthetic */ com.lark.wire.Message.a newBuilder() {
            return newBuilder();
        }

        public Config(a r2, ByteString r3) {
            super(ADAPTER, r3);
            String r4 = r2.d;
            Intrinsics.checkNotNull(r4);
            this.id = r4;
            this.announce = r2.e;
        }

        public /* synthetic */ Config(a r1, ByteString r2, int r3, DefaultConstructorMarker r4) {
            if ((r3 & 2) == 0) goto L5;
            r2 = ByteString.EMPTY;
        L5:
            this(r1, r2);
        }
    }

    public static final class a extends com.lark.wire.Message.a<ChatOptionInfo, a> {
        public String d;
        public Boolean e;

        @Override // com.lark.wire.Message.a
        public final com.lark.wire.Message b() {
            return new ChatOptionInfo(this, c(), null);
        }

        public a() {
        }
    }

    public static final class b extends ProtoAdapter<ChatOptionInfo> {
        @Override // com.lark.wire.ProtoAdapter
        public final ChatOptionInfo c(g0 r7) {
            Intrinsics.checkNotNullParameter(r7, "reader");
            a r1 = new a();
            long r2 = r7.c();
        L3:
            int r4 = r7.e();
            if (r4 == (-1)) goto L13;
            if (r4 != 1) goto L8;
            ProtoAdapter.q.getClass();
            Intrinsics.checkNotNullParameter(r7, "reader");
            String r5 = r7.i();
            Intrinsics.checkNotNullParameter(r5, "id");
            r1.d = r5;
            goto L3
        L8:
            if (r4 != 2) goto L9;
            r1.e = (Boolean) ProtoAdapter.g.c(r7);
            goto L3
        L9:
            r7.j(r4);
            Unit r6 = Unit.INSTANCE;
            goto L3
        L13:
            return new ChatOptionInfo(r1, r7.d(r2), null);
        }

        @Override // com.lark.wire.ProtoAdapter
        public final int k(ChatOptionInfo r5) {
            ChatOptionInfo r6 = r5;
            Intrinsics.checkNotNullParameter(r6, "value");
            return (r6.unknownFields().size() + ProtoAdapter.q.l(1, r6.getId())) + ProtoAdapter.g.l(2, r6.getAnnounce());
        }

        @Override // com.lark.wire.ProtoAdapter
        public final void f(j0 r4, ChatOptionInfo r5) {
            ChatOptionInfo r6 = r5;
            Intrinsics.checkNotNullParameter(r4, "writer");
            Intrinsics.checkNotNullParameter(r6, "value");
            ProtoAdapter.q.i(r4, 1, r6.getId());
            ProtoAdapter.g.i(r4, 2, r6.getAnnounce());
            r4.a(r6.unknownFields());
        }

        @Override // com.lark.wire.ProtoAdapter
        public final void g(n0 r4, ChatOptionInfo r5) {
            ChatOptionInfo r6 = r5;
            Intrinsics.checkNotNullParameter(r4, "writer");
            Intrinsics.checkNotNullParameter(r6, "value");
            r4.d(r6.unknownFields());
            ProtoAdapter.g.j(r4, 2, r6.getAnnounce());
            ProtoAdapter.q.j(r4, 1, r6.getId());
        }

        public b(FieldEncoding r7, KClass<ChatOptionInfo> r8, Syntax r9) {
            super(r7, r8, "type.googleapis.com/basic.v1.ChatOptionInfo", r9, null);
        }
    }

    public static final class c {
        public c() {
        }
    }

    public /* synthetic */ ChatOptionInfo(a r1, ByteString r2, DefaultConstructorMarker r3) {
        this(r1, r2);
    }

    static {
        Companion = new c();
        ADAPTER = new b(FieldEncoding.LENGTH_DELIMITED, Reflection.getOrCreateKotlinClass(ChatOptionInfo.class), Syntax.PROTO_2);
    }

    @Override // com.lark.wire.Message
    public a newBuilder() {
        a r0 = new a();
        r0.d = this.id;
        r0.e = this.announce;
        r0.a(unknownFields());
        return r0;
    }

    @Override // com.lark.wire.Message
    public String toString() {
        return Reflection.getOrCreateKotlinClass(ChatOptionInfo.class).getSimpleName() + '@' + hashCode();
    }

    public final Boolean getAnnounce() {
        return this.announce;
    }

    public final String getId() {
        return this.id;
    }

    @Override // com.lark.wire.Message
    public /* bridge */ /* synthetic */ com.lark.wire.Message.a newBuilder() {
        return newBuilder();
    }

    public ChatOptionInfo(a r2, ByteString r3) {
        super(ADAPTER, r3);
        String r4 = r2.d;
        Intrinsics.checkNotNull(r4);
        this.id = r4;
        this.announce = r2.e;
    }

    public /* synthetic */ ChatOptionInfo(a r1, ByteString r2, int r3, DefaultConstructorMarker r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = ByteString.EMPTY;
    L5:
        this(r1, r2);
    }
}
