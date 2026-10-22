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
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClass;
import okio.ByteString;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 \u00142\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00020\u0001:\u0003\u0013\u0014\u0015B\u001b\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\b\u0010\u0011\u001a\u00020\u0002H\u0016J\b\u0010\u0012\u001a\u00020\tH\u0016R\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0017\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000e0\r¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010¨\u0006\u0016"}, d2 = {"Lcom/lark/kmp/pb/basic/v1/VideoChatI18nDefaultTopic;", "Lcom/lark/wire/Message;", "Lcom/lark/kmp/pb/basic/v1/VideoChatI18nDefaultTopic$Builder;", "builder", "unknownFields", "Lokio/ByteString;", "<init>", "(Lcom/lark/kmp/pb/basic/v1/VideoChatI18nDefaultTopic$Builder;Lokio/ByteString;)V", "i18n_key", "", "getI18n_key", "()Ljava/lang/String;", "params", "", "Lcom/lark/kmp/pb/basic/v1/VideoChatI18nDefaultTopic$Param;", "getParams", "()Ljava/util/List;", "newBuilder", "toString", "Builder", "Companion", "Param", "rust-sdk-kotlin-pb_release"}, k = 1, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
public final class VideoChatI18nDefaultTopic extends com.lark.wire.Message<VideoChatI18nDefaultTopic, a> {
    public static final ProtoAdapter<VideoChatI18nDefaultTopic> ADAPTER = null;
    public static final c Companion = null;
    private static final long serialVersionUID = 0;
    private final String i18n_key;
    private final List<Param> params;

    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u000e\u0018\u0000 \u00192\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00020\u0001:\u0003\u0018\u0019\u001aB\u001b\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\b\u0010\u0016\u001a\u00020\u0002H\u0016J\b\u0010\u0017\u001a\u00020\rH\u0016R\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0013\u0010\f\u001a\u0004\u0018\u00010\r¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0013\u0010\u0010\u001a\u0004\u0018\u00010\r¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u000fR\u0013\u0010\u0012\u001a\u0004\u0018\u00010\r¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u000fR\u0013\u0010\u0014\u001a\u0004\u0018\u00010\r¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u000f¨\u0006\u001b"}, d2 = {"Lcom/lark/kmp/pb/basic/v1/VideoChatI18nDefaultTopic$Param;", "Lcom/lark/wire/Message;", "Lcom/lark/kmp/pb/basic/v1/VideoChatI18nDefaultTopic$Param$Builder;", "builder", "unknownFields", "Lokio/ByteString;", "<init>", "(Lcom/lark/kmp/pb/basic/v1/VideoChatI18nDefaultTopic$Param$Builder;Lokio/ByteString;)V", "type", "Lcom/lark/kmp/pb/basic/v1/VideoChatI18nDefaultTopic$Param$Type;", "getType", "()Lcom/lark/kmp/pb/basic/v1/VideoChatI18nDefaultTopic$Param$Type;", "default_content", "", "getDefault_content", "()Ljava/lang/String;", "fixed_content", "getFixed_content", "chat_id", "getChat_id", "user_id", "getUser_id", "newBuilder", "toString", "Builder", "Companion", "Type", "rust-sdk-kotlin-pb_release"}, k = 1, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
    public static final class Param extends com.lark.wire.Message<Param, a> {
        public static final ProtoAdapter<Param> ADAPTER = null;
        public static final c Companion = null;
        private static final long serialVersionUID = 0;
        private final String chat_id;
        private final String default_content;
        private final String fixed_content;
        private final Type type;
        private final String user_id;

        @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\u000b\b\u0086\u0081\u0002\u0018\u0000 \u000e2\u00020\u00012\b\u0012\u0004\u0012\u00020\u00000\u0002:\u0001\u000eB\u0011\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u0004X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\r¨\u0006\u000f"}, d2 = {"Lcom/lark/kmp/pb/basic/v1/VideoChatI18nDefaultTopic$Param$Type;", "Lcom/lark/wire/WireEnum;", "", "value", "", "<init>", "(Ljava/lang/String;II)V", "getValue", "()I", "UNKNOWN", "FIXED_CONTENT", "GROUP", "LARK_USER", "ROOM", "Companion", "rust-sdk-kotlin-pb_release"}, k = 1, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
        public static final enum Type extends Enum<Type> implements o0 {
            public static final ProtoAdapter<Type> ADAPTER = null;
            public static final b Companion = null;
            public static final Type FIXED_CONTENT = null;
            public static final Type GROUP = null;
            public static final Type LARK_USER = null;
            public static final Type ROOM = null;
            public static final Type UNKNOWN = null;
            public static final /* synthetic */ Type[] a = null;
            public static final /* synthetic */ EnumEntries b = null;
            private final int value;

            public static final class a extends d<Type> {
                @Override // com.lark.wire.d
                public final o0 n(int r2) {
                    Type.Companion.getClass();
                    return b.a(r2);
                }

                public a(KClass<Type> r1, Syntax r2, Type r3) {
                    super(r1, r2, r3);
                }
            }

            public static final class b {
                public b() {
                }

                @JvmStatic
                public static Type a(int r1) {
                    if (r1 == 0) goto L17;
                    if (r1 == 1) goto L22;
                    if (r1 == 2) goto L21;
                    if (r1 == 3) goto L20;
                    if (r1 == 4) goto L19;
                    return null;
                L19:
                    return Type.ROOM;
                L20:
                    return Type.LARK_USER;
                L21:
                    return Type.GROUP;
                L22:
                    return Type.FIXED_CONTENT;
                L17:
                    return Type.UNKNOWN;
                }
            }

            @JvmStatic
            public static final Type fromValue(int r1) {
                Companion.getClass();
                return b.a(r1);
            }

            public static EnumEntries<Type> getEntries() {
                return b;
            }

            static {
                Type r0 = new Type("UNKNOWN", 0, 0);
                UNKNOWN = r0;
                Type r1 = new Type("FIXED_CONTENT", 1, 1);
                FIXED_CONTENT = r1;
                Type r3 = new Type("GROUP", 2, 2);
                GROUP = r3;
                Type r5 = new Type("LARK_USER", 3, 3);
                LARK_USER = r5;
                Type r7 = new Type("ROOM", 4, 4);
                ROOM = r7;
                Type[] r9 = {r0, r1, r3, r5, r7};
                a = r9;
                b = EnumEntriesKt.enumEntries(r9);
                Companion = new b();
                ADAPTER = new a(Reflection.getOrCreateKotlinClass(Type.class), Syntax.PROTO_2, r0);
            }

            public static Type[] values() {
                return (Type[]) a.clone();
            }

            @Override // com.lark.wire.o0
            public int getValue() {
                return this.value;
            }

            public static Type valueOf(String r1) {
                return (Type) r27.a.a(Type.class, r1);
            }

            public Type(String r1, int r2, int r3) {
                super(r1, r2);
                this.value = r3;
            }
        }

        public static final class a extends com.lark.wire.Message.a<Param, a> {
            public Type d;
            public String e;
            public String f;
            public String g;
            public String h;

            @Override // com.lark.wire.Message.a
            public final com.lark.wire.Message b() {
                return new Param(this, c(), null);
            }

            public a() {
            }
        }

        public static final class b extends ProtoAdapter<Param> {
            @Override // com.lark.wire.ProtoAdapter
            public final Param c(g0 r10) {
                Intrinsics.checkNotNullParameter(r10, "reader");
                a r1 = new a();
                long r2 = r10.c();
            L3:
                int r4 = r10.e();
                DefaultConstructorMarker r6 = null;
                if (r4 == (-1)) goto L25;
                if (r4 != 1) goto L8;
                Type r5 = Type.ADAPTER.c(r10);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L22
                Intrinsics.checkNotNullParameter(r5, "type");     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L22
                r1.d = r5;     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L22
            L22:
                e = move-exception;
                r10.a(r4, FieldEncoding.VARINT, Long.valueOf(e.value));
                Unit r7 = Unit.INSTANCE;
                goto L3
            L8:
                if (r4 != 2) goto L10;
                ProtoAdapter.q.getClass();
                Intrinsics.checkNotNullParameter(r10, "reader");
                r1.e = r10.i();
                goto L3
            L10:
                if (r4 != 3) goto L12;
                ProtoAdapter.q.getClass();
                Intrinsics.checkNotNullParameter(r10, "reader");
                r1.f = r10.i();
                r1.g = null;
                r1.h = null;
                goto L3
            L12:
                if (r4 != 4) goto L14;
                ProtoAdapter.q.getClass();
                Intrinsics.checkNotNullParameter(r10, "reader");
                r1.g = r10.i();
                r1.f = null;
                r1.h = null;
                goto L3
            L14:
                if (r4 != 5) goto L15;
                ProtoAdapter.q.getClass();
                Intrinsics.checkNotNullParameter(r10, "reader");
                r1.h = r10.i();
                r1.f = null;
                r1.g = null;
                goto L3
            L15:
                r10.j(r4);
                Unit r8 = Unit.INSTANCE;
                goto L3
            L25:
                return new Param(r1, r10.d(r2), r6);
            }

            @Override // com.lark.wire.ProtoAdapter
            public final int k(Param r5) {
                Param r6 = r5;
                Intrinsics.checkNotNullParameter(r6, "value");
                int r0 = r6.unknownFields().size() + Type.ADAPTER.l(1, r6.getType());
                w r1 = ProtoAdapter.q;
                return (((r0 + r1.l(2, r6.getDefault_content())) + r1.l(3, r6.getFixed_content())) + r1.l(4, r6.getChat_id())) + r1.l(5, r6.getUser_id());
            }

            @Override // com.lark.wire.ProtoAdapter
            public final void f(j0 r4, Param r5) {
                Param r6 = r5;
                Intrinsics.checkNotNullParameter(r4, "writer");
                Intrinsics.checkNotNullParameter(r6, "value");
                Type.ADAPTER.i(r4, 1, r6.getType());
                w r0 = ProtoAdapter.q;
                r0.i(r4, 2, r6.getDefault_content());
                r0.i(r4, 3, r6.getFixed_content());
                r0.i(r4, 4, r6.getChat_id());
                r0.i(r4, 5, r6.getUser_id());
                r4.a(r6.unknownFields());
            }

            @Override // com.lark.wire.ProtoAdapter
            public final void g(n0 r4, Param r5) {
                Param r6 = r5;
                Intrinsics.checkNotNullParameter(r4, "writer");
                Intrinsics.checkNotNullParameter(r6, "value");
                r4.d(r6.unknownFields());
                w r0 = ProtoAdapter.q;
                r0.j(r4, 5, r6.getUser_id());
                r0.j(r4, 4, r6.getChat_id());
                r0.j(r4, 3, r6.getFixed_content());
                r0.j(r4, 2, r6.getDefault_content());
                Type.ADAPTER.j(r4, 1, r6.getType());
            }

            public b(FieldEncoding r7, KClass<Param> r8, Syntax r9) {
                super(r7, r8, "type.googleapis.com/basic.v1.VideoChatI18nDefaultTopic.Param", r9, null);
            }
        }

        public static final class c {
            public c() {
            }
        }

        public /* synthetic */ Param(a r1, ByteString r2, DefaultConstructorMarker r3) {
            this(r1, r2);
        }

        static {
            Companion = new c();
            ADAPTER = new b(FieldEncoding.LENGTH_DELIMITED, Reflection.getOrCreateKotlinClass(Param.class), Syntax.PROTO_2);
        }

        @Override // com.lark.wire.Message
        public a newBuilder() {
            a r0 = new a();
            r0.d = this.type;
            r0.e = this.default_content;
            r0.f = this.fixed_content;
            r0.g = this.chat_id;
            r0.h = this.user_id;
            r0.a(unknownFields());
            return r0;
        }

        @Override // com.lark.wire.Message
        public String toString() {
            return Reflection.getOrCreateKotlinClass(Param.class).getSimpleName() + '@' + hashCode();
        }

        public final String getChat_id() {
            return this.chat_id;
        }

        public final String getDefault_content() {
            return this.default_content;
        }

        public final String getFixed_content() {
            return this.fixed_content;
        }

        public final Type getType() {
            return this.type;
        }

        public final String getUser_id() {
            return this.user_id;
        }

        @Override // com.lark.wire.Message
        public /* bridge */ /* synthetic */ com.lark.wire.Message.a newBuilder() {
            return newBuilder();
        }

        public Param(a r4, ByteString r5) {
            super(ADAPTER, r5);
            Type r6 = r4.d;
            Intrinsics.checkNotNull(r6);
            this.type = r6;
            this.default_content = r4.e;
            String r7 = r4.f;
            this.fixed_content = r7;
            String r0 = r4.g;
            this.chat_id = r0;
            String r8 = r4.h;
            this.user_id = r8;
            boolean r1 = false;
            if (r7 == null) goto L5;
            int r9 = 1;
        L6:
            if (r0 == null) goto L8;
            int r2 = 1;
        L9:
            int r10 = r9 + r2;
            if (r8 == null) goto L12;
            int r11 = 1;
        L14:
            if ((r10 + r11) > 1) goto L16;
            r1 = true;
        L16:
            if (r1 == false) goto L19;
            return;
        L19:
            throw new IllegalArgumentException("At most one of fixed_content, chat_id, user_id may be non-null".toString());
        L12:
            r11 = 0;
            goto L14
        L8:
            r2 = 0;
            goto L9
        L5:
            r9 = 0;
            goto L6
        }

        public /* synthetic */ Param(a r1, ByteString r2, int r3, DefaultConstructorMarker r4) {
            if ((r3 & 2) == 0) goto L5;
            r2 = ByteString.EMPTY;
        L5:
            this(r1, r2);
        }
    }

    public static final class a extends com.lark.wire.Message.a<VideoChatI18nDefaultTopic, a> {
        public String d;
        public List<Param> e;

        @Override // com.lark.wire.Message.a
        public final com.lark.wire.Message b() {
            return new VideoChatI18nDefaultTopic(this, c(), null);
        }

        public a() {
            this.e = CollectionsKt.emptyList();
        }
    }

    public static final class b extends ProtoAdapter<VideoChatI18nDefaultTopic> {
        @Override // com.lark.wire.ProtoAdapter
        public final VideoChatI18nDefaultTopic c(g0 r8) {
            Intrinsics.checkNotNullParameter(r8, "reader");
            a r1 = new a();
            ArrayList r2 = new ArrayList();
            long r3 = r8.c();
        L3:
            int r5 = r8.e();
            if (r5 == (-1)) goto L12;
            if (r5 != 1) goto L8;
            ProtoAdapter.q.getClass();
            Intrinsics.checkNotNullParameter(r8, "reader");
            String r6 = r8.i();
            Intrinsics.checkNotNullParameter(r6, "i18n_key");
            r1.d = r6;
            goto L3
        L8:
            if (r5 != 2) goto L9;
            r2.add(Param.ADAPTER.c(r8));
            goto L3
        L9:
            r8.j(r5);
            goto L3
        L12:
            ByteString r9 = r8.d(r3);
            Intrinsics.checkNotNullParameter(r2, "params");
            com.lark.wire.internal.a.a(r2);
            r1.e = r2;
            return new VideoChatI18nDefaultTopic(r1, r9, null);
        }

        @Override // com.lark.wire.ProtoAdapter
        public final int k(VideoChatI18nDefaultTopic r5) {
            VideoChatI18nDefaultTopic r6 = r5;
            Intrinsics.checkNotNullParameter(r6, "value");
            return (r6.unknownFields().size() + ProtoAdapter.q.l(1, r6.getI18n_key())) + Param.ADAPTER.a().l(2, r6.getParams());
        }

        @Override // com.lark.wire.ProtoAdapter
        public final void f(j0 r4, VideoChatI18nDefaultTopic r5) {
            VideoChatI18nDefaultTopic r6 = r5;
            Intrinsics.checkNotNullParameter(r4, "writer");
            Intrinsics.checkNotNullParameter(r6, "value");
            ProtoAdapter.q.i(r4, 1, r6.getI18n_key());
            Param.ADAPTER.a().i(r4, 2, r6.getParams());
            r4.a(r6.unknownFields());
        }

        @Override // com.lark.wire.ProtoAdapter
        public final void g(n0 r4, VideoChatI18nDefaultTopic r5) {
            VideoChatI18nDefaultTopic r6 = r5;
            Intrinsics.checkNotNullParameter(r4, "writer");
            Intrinsics.checkNotNullParameter(r6, "value");
            r4.d(r6.unknownFields());
            Param.ADAPTER.a().j(r4, 2, r6.getParams());
            ProtoAdapter.q.j(r4, 1, r6.getI18n_key());
        }

        public b(FieldEncoding r7, KClass<VideoChatI18nDefaultTopic> r8, Syntax r9) {
            super(r7, r8, "type.googleapis.com/basic.v1.VideoChatI18nDefaultTopic", r9, null);
        }
    }

    public static final class c {
        public c() {
        }
    }

    public /* synthetic */ VideoChatI18nDefaultTopic(a r1, ByteString r2, DefaultConstructorMarker r3) {
        this(r1, r2);
    }

    static {
        Companion = new c();
        ADAPTER = new b(FieldEncoding.LENGTH_DELIMITED, Reflection.getOrCreateKotlinClass(VideoChatI18nDefaultTopic.class), Syntax.PROTO_2);
    }

    @Override // com.lark.wire.Message
    public a newBuilder() {
        a r0 = new a();
        r0.d = this.i18n_key;
        r0.e = this.params;
        r0.a(unknownFields());
        return r0;
    }

    @Override // com.lark.wire.Message
    public String toString() {
        return Reflection.getOrCreateKotlinClass(VideoChatI18nDefaultTopic.class).getSimpleName() + '@' + hashCode();
    }

    public final String getI18n_key() {
        return this.i18n_key;
    }

    public final List<Param> getParams() {
        return this.params;
    }

    @Override // com.lark.wire.Message
    public /* bridge */ /* synthetic */ com.lark.wire.Message.a newBuilder() {
        return newBuilder();
    }

    public VideoChatI18nDefaultTopic(a r2, ByteString r3) {
        super(ADAPTER, r3);
        String r4 = r2.d;
        Intrinsics.checkNotNull(r4);
        this.i18n_key = r4;
        this.params = com.lark.wire.internal.a.c("params", r2.e);
    }

    public /* synthetic */ VideoChatI18nDefaultTopic(a r1, ByteString r2, int r3, DefaultConstructorMarker r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = ByteString.EMPTY;
    L5:
        this(r1, r2);
    }
}
