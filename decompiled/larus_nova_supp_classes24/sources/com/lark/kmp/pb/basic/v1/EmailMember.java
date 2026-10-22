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
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\t\u0018\u0000 \u001a2\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00020\u0001:\u0003\u0019\u001a\u001bB\u001b\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\b\u0010\u0017\u001a\u00020\u0002H\u0016J\b\u0010\u0018\u001a\u00020\tH\u0016R\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\f\u001a\u00020\r¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0013\u0010\u0010\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u000bR\u0015\u0010\u0012\u001a\u0004\u0018\u00010\u0013¢\u0006\n\n\u0002\u0010\u0016\u001a\u0004\b\u0014\u0010\u0015¨\u0006\u001c"}, d2 = {"Lcom/lark/kmp/pb/basic/v1/EmailMember;", "Lcom/lark/wire/Message;", "Lcom/lark/kmp/pb/basic/v1/EmailMember$Builder;", "builder", "unknownFields", "Lokio/ByteString;", "<init>", "(Lcom/lark/kmp/pb/basic/v1/EmailMember$Builder;Lokio/ByteString;)V", "id", "", "getId", "()Ljava/lang/String;", "type", "Lcom/lark/kmp/pb/basic/v1/EmailMember$Type;", "getType", "()Lcom/lark/kmp/pb/basic/v1/EmailMember$Type;", "inviter_id", "getInviter_id", "join_time", "", "getJoin_time", "()Ljava/lang/Long;", "Ljava/lang/Long;", "newBuilder", "toString", "Builder", "Companion", "Type", "rust-sdk-kotlin-pb_release"}, k = 1, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
public final class EmailMember extends com.lark.wire.Message<EmailMember, a> {
    public static final ProtoAdapter<EmailMember> ADAPTER = null;
    public static final c Companion = null;
    private static final long serialVersionUID = 0;
    private final String id;
    private final String inviter_id;
    private final Long join_time;
    private final Type type;

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\b\b\u0086\u0081\u0002\u0018\u0000 \u000b2\u00020\u00012\b\u0012\u0004\u0012\u00020\u00000\u0002:\u0001\u000bB\u0011\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u0004X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bj\u0002\b\tj\u0002\b\n¨\u0006\f"}, d2 = {"Lcom/lark/kmp/pb/basic/v1/EmailMember$Type;", "Lcom/lark/wire/WireEnum;", "", "value", "", "<init>", "(Ljava/lang/String;II)V", "getValue", "()I", "CHATTER", "CHAT", "Companion", "rust-sdk-kotlin-pb_release"}, k = 1, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
    public static final enum Type extends Enum<Type> implements o0 {
        public static final ProtoAdapter<Type> ADAPTER = null;
        public static final Type CHAT = null;
        public static final Type CHATTER = null;
        public static final b Companion = null;
        public static final /* synthetic */ Type[] a = null;
        public static final /* synthetic */ EnumEntries b = null;
        private final int value;

        public static final class a extends d<Type> {
            @Override // com.lark.wire.d
            public final o0 n(int r2) {
                Type.Companion.getClass();
                if (r2 == 1) goto L9;
                if (r2 == 2) goto L11;
                return null;
            L11:
                return Type.CHAT;
            L9:
                return Type.CHATTER;
            }

            public a(KClass<Type> r2, Syntax r3) {
                super(r2, r3, null);
            }
        }

        public static final class b {
            public b() {
            }
        }

        public static EnumEntries<Type> getEntries() {
            return b;
        }

        static {
            Type r0 = new Type("CHATTER", 0, 1);
            CHATTER = r0;
            Type r1 = new Type("CHAT", 1, 2);
            CHAT = r1;
            Type[] r4 = {r0, r1};
            a = r4;
            b = EnumEntriesKt.enumEntries(r4);
            Companion = new b();
            ADAPTER = new a(Reflection.getOrCreateKotlinClass(Type.class), Syntax.PROTO_2);
        }

        public static Type[] values() {
            return (Type[]) a.clone();
        }

        @Override // com.lark.wire.o0
        public int getValue() {
            return this.value;
        }

        @JvmStatic
        public static final Type fromValue(int r1) {
            Companion.getClass();
            if (r1 == 1) goto L9;
            if (r1 == 2) goto L11;
            return null;
        L11:
            return CHAT;
        L9:
            return CHATTER;
        }

        public static Type valueOf(String r1) {
            return (Type) r27.a.a(Type.class, r1);
        }

        public Type(String r1, int r2, int r3) {
            super(r1, r2);
            this.value = r3;
        }
    }

    public static final class a extends com.lark.wire.Message.a<EmailMember, a> {
        public String d;
        public Type e;
        public String f;
        public Long g;

        @Override // com.lark.wire.Message.a
        public final com.lark.wire.Message b() {
            return new EmailMember(this, c(), null);
        }

        public a() {
        }
    }

    public static final class b extends ProtoAdapter<EmailMember> {
        @Override // com.lark.wire.ProtoAdapter
        public final EmailMember c(g0 r10) {
            Intrinsics.checkNotNullParameter(r10, "reader");
            a r1 = new a();
            long r2 = r10.c();
        L3:
            int r4 = r10.e();
            if (r4 == (-1)) goto L22;
            if (r4 != 1) goto L8;
            ProtoAdapter.q.getClass();
            Intrinsics.checkNotNullParameter(r10, "reader");
            String r5 = r10.i();
            Intrinsics.checkNotNullParameter(r5, "id");
            r1.d = r5;
            goto L3
        L8:
            if (r4 != 2) goto L10;
            Type r6 = Type.ADAPTER.c(r10);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L18
            Intrinsics.checkNotNullParameter(r6, "type");     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L18
            r1.e = r6;     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L18
        L18:
            e = move-exception;
            r10.a(r4, FieldEncoding.VARINT, Long.valueOf(e.value));
            Unit r7 = Unit.INSTANCE;
            goto L3
        L10:
            if (r4 != 3) goto L12;
            ProtoAdapter.q.getClass();
            Intrinsics.checkNotNullParameter(r10, "reader");
            r1.f = r10.i();
            goto L3
        L12:
            if (r4 != 4) goto L13;
            r1.g = (Long) ProtoAdapter.k.c(r10);
            goto L3
        L13:
            r10.j(r4);
            Unit r8 = Unit.INSTANCE;
            goto L3
        L22:
            return new EmailMember(r1, r10.d(r2), null);
        }

        @Override // com.lark.wire.ProtoAdapter
        public final int k(EmailMember r6) {
            EmailMember r7 = r6;
            Intrinsics.checkNotNullParameter(r7, "value");
            int r0 = r7.unknownFields().size();
            w r1 = ProtoAdapter.q;
            return (((r0 + r1.l(1, r7.getId())) + Type.ADAPTER.l(2, r7.getType())) + r1.l(3, r7.getInviter_id())) + ProtoAdapter.k.l(4, r7.getJoin_time());
        }

        @Override // com.lark.wire.ProtoAdapter
        public final void f(j0 r5, EmailMember r6) {
            EmailMember r7 = r6;
            Intrinsics.checkNotNullParameter(r5, "writer");
            Intrinsics.checkNotNullParameter(r7, "value");
            w r0 = ProtoAdapter.q;
            r0.i(r5, 1, r7.getId());
            Type.ADAPTER.i(r5, 2, r7.getType());
            r0.i(r5, 3, r7.getInviter_id());
            ProtoAdapter.k.i(r5, 4, r7.getJoin_time());
            r5.a(r7.unknownFields());
        }

        @Override // com.lark.wire.ProtoAdapter
        public final void g(n0 r5, EmailMember r6) {
            EmailMember r7 = r6;
            Intrinsics.checkNotNullParameter(r5, "writer");
            Intrinsics.checkNotNullParameter(r7, "value");
            r5.d(r7.unknownFields());
            ProtoAdapter.k.j(r5, 4, r7.getJoin_time());
            w r0 = ProtoAdapter.q;
            r0.j(r5, 3, r7.getInviter_id());
            Type.ADAPTER.j(r5, 2, r7.getType());
            r0.j(r5, 1, r7.getId());
        }

        public b(FieldEncoding r7, KClass<EmailMember> r8, Syntax r9) {
            super(r7, r8, "type.googleapis.com/basic.v1.EmailMember", r9, null);
        }
    }

    public static final class c {
        public c() {
        }
    }

    public /* synthetic */ EmailMember(a r1, ByteString r2, DefaultConstructorMarker r3) {
        this(r1, r2);
    }

    static {
        Companion = new c();
        ADAPTER = new b(FieldEncoding.LENGTH_DELIMITED, Reflection.getOrCreateKotlinClass(EmailMember.class), Syntax.PROTO_2);
    }

    @Override // com.lark.wire.Message
    public a newBuilder() {
        a r0 = new a();
        r0.d = this.id;
        r0.e = this.type;
        r0.f = this.inviter_id;
        r0.g = this.join_time;
        r0.a(unknownFields());
        return r0;
    }

    @Override // com.lark.wire.Message
    public String toString() {
        return Reflection.getOrCreateKotlinClass(EmailMember.class).getSimpleName() + '@' + hashCode();
    }

    public final String getId() {
        return this.id;
    }

    public final String getInviter_id() {
        return this.inviter_id;
    }

    public final Long getJoin_time() {
        return this.join_time;
    }

    public final Type getType() {
        return this.type;
    }

    @Override // com.lark.wire.Message
    public /* bridge */ /* synthetic */ com.lark.wire.Message.a newBuilder() {
        return newBuilder();
    }

    public EmailMember(a r2, ByteString r3) {
        super(ADAPTER, r3);
        String r4 = r2.d;
        Intrinsics.checkNotNull(r4);
        this.id = r4;
        Type r5 = r2.e;
        Intrinsics.checkNotNull(r5);
        this.type = r5;
        this.inviter_id = r2.f;
        this.join_time = r2.g;
    }

    public /* synthetic */ EmailMember(a r1, ByteString r2, int r3, DefaultConstructorMarker r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = ByteString.EMPTY;
    L5:
        this(r1, r2);
    }
}
