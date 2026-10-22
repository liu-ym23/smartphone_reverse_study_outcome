package com.lark.kmp.pb.basic.v1;

import com.lark.wire.FieldEncoding;
import com.lark.wire.ProtoAdapter;
import com.lark.wire.Syntax;
import com.lark.wire.d;
import com.lark.wire.g0;
import com.lark.wire.j0;
import com.lark.wire.l;
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
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\n\u0018\u0000 %2\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00020\u0001:\u0004$%&'B\u001b\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\b\u0010\"\u001a\u00020\u0002H\u0016J\b\u0010#\u001a\u00020\tH\u0016R\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\f\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000bR\u0013\u0010\u000e\u001a\u0004\u0018\u00010\u000f¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0015\u0010\u0012\u001a\u0004\u0018\u00010\u0013¢\u0006\n\n\u0002\u0010\u0016\u001a\u0004\b\u0014\u0010\u0015R\u0013\u0010\u0017\u001a\u0004\u0018\u00010\u0018¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001aR\u0013\u0010\u001b\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u000bR\u0015\u0010\u001d\u001a\u0004\u0018\u00010\u001e¢\u0006\n\n\u0002\u0010 \u001a\u0004\b\u001d\u0010\u001fR\u0015\u0010!\u001a\u0004\u0018\u00010\u001e¢\u0006\n\n\u0002\u0010 \u001a\u0004\b!\u0010\u001f¨\u0006("}, d2 = {"Lcom/lark/kmp/pb/basic/v1/Urgent;", "Lcom/lark/wire/Message;", "Lcom/lark/kmp/pb/basic/v1/Urgent$Builder;", "builder", "unknownFields", "Lokio/ByteString;", "<init>", "(Lcom/lark/kmp/pb/basic/v1/Urgent$Builder;Lokio/ByteString;)V", "id", "", "getId", "()Ljava/lang/String;", "message_id", "getMessage_id", "type", "Lcom/lark/kmp/pb/basic/v1/Urgent$Type;", "getType", "()Lcom/lark/kmp/pb/basic/v1/Urgent$Type;", "send_time", "", "getSend_time", "()Ljava/lang/Long;", "Ljava/lang/Long;", "status", "Lcom/lark/kmp/pb/basic/v1/Urgent$Status;", "getStatus", "()Lcom/lark/kmp/pb/basic/v1/Urgent$Status;", "ack_chatter_id", "getAck_chatter_id", "is_closed", "", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "is_muted", "newBuilder", "toString", "Builder", "Companion", "Type", "Status", "rust-sdk-kotlin-pb_release"}, k = 1, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
public final class Urgent extends com.lark.wire.Message<Urgent, a> {
    public static final ProtoAdapter<Urgent> ADAPTER = null;
    public static final c Companion = null;
    private static final long serialVersionUID = 0;
    private final String ack_chatter_id;
    private final String id;
    private final Boolean is_closed;
    private final Boolean is_muted;
    private final String message_id;
    private final Long send_time;
    private final Status status;
    private final Type type;

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\n\b\u0086\u0081\u0002\u0018\u0000 \r2\u00020\u00012\b\u0012\u0004\u0012\u00020\u00000\u0002:\u0001\rB\u0011\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u0004X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\f¨\u0006\u000e"}, d2 = {"Lcom/lark/kmp/pb/basic/v1/Urgent$Status;", "Lcom/lark/wire/WireEnum;", "", "value", "", "<init>", "(Ljava/lang/String;II)V", "getValue", "()I", "ME_CREATE", "ME_ACK", "URGENT_ME", "ACK_ME", "Companion", "rust-sdk-kotlin-pb_release"}, k = 1, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
    public static final enum Status extends Enum<Status> implements o0 {
        public static final Status ACK_ME = null;
        public static final ProtoAdapter<Status> ADAPTER = null;
        public static final b Companion = null;
        public static final Status ME_ACK = null;
        public static final Status ME_CREATE = null;
        public static final Status URGENT_ME = null;
        public static final /* synthetic */ Status[] a = null;
        public static final /* synthetic */ EnumEntries b = null;
        private final int value;

        public static final class a extends d<Status> {
            @Override // com.lark.wire.d
            public final o0 n(int r2) {
                Status.Companion.getClass();
                if (r2 == 1) goto L15;
                if (r2 == 2) goto L19;
                if (r2 == 3) goto L18;
                if (r2 == 4) goto L17;
                return null;
            L17:
                return Status.ACK_ME;
            L18:
                return Status.URGENT_ME;
            L19:
                return Status.ME_ACK;
            L15:
                return Status.ME_CREATE;
            }

            public a(KClass<Status> r2, Syntax r3) {
                super(r2, r3, null);
            }
        }

        public static final class b {
            public b() {
            }
        }

        public static EnumEntries<Status> getEntries() {
            return b;
        }

        static {
            Status r0 = new Status("ME_CREATE", 0, 1);
            ME_CREATE = r0;
            Status r1 = new Status("ME_ACK", 1, 2);
            ME_ACK = r1;
            Status r4 = new Status("URGENT_ME", 2, 3);
            URGENT_ME = r4;
            Status r6 = new Status("ACK_ME", 3, 4);
            ACK_ME = r6;
            Status[] r8 = {r0, r1, r4, r6};
            a = r8;
            b = EnumEntriesKt.enumEntries(r8);
            Companion = new b();
            ADAPTER = new a(Reflection.getOrCreateKotlinClass(Status.class), Syntax.PROTO_2);
        }

        public static Status[] values() {
            return (Status[]) a.clone();
        }

        @Override // com.lark.wire.o0
        public int getValue() {
            return this.value;
        }

        @JvmStatic
        public static final Status fromValue(int r1) {
            Companion.getClass();
            if (r1 == 1) goto L15;
            if (r1 == 2) goto L19;
            if (r1 == 3) goto L18;
            if (r1 == 4) goto L17;
            return null;
        L17:
            return ACK_ME;
        L18:
            return URGENT_ME;
        L19:
            return ME_ACK;
        L15:
            return ME_CREATE;
        }

        public static Status valueOf(String r1) {
            return (Status) r27.a.a(Status.class, r1);
        }

        public Status(String r1, int r2, int r3) {
            super(r1, r2);
            this.value = r3;
        }
    }

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\t\b\u0086\u0081\u0002\u0018\u0000 \f2\u00020\u00012\b\u0012\u0004\u0012\u00020\u00000\u0002:\u0001\fB\u0011\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u0004X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000b¨\u0006\r"}, d2 = {"Lcom/lark/kmp/pb/basic/v1/Urgent$Type;", "Lcom/lark/wire/WireEnum;", "", "value", "", "<init>", "(Ljava/lang/String;II)V", "getValue", "()I", "APP", "SMS", "PHONE", "Companion", "rust-sdk-kotlin-pb_release"}, k = 1, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
    public static final enum Type extends Enum<Type> implements o0 {
        public static final ProtoAdapter<Type> ADAPTER = null;
        public static final Type APP = null;
        public static final b Companion = null;
        public static final Type PHONE = null;
        public static final Type SMS = null;
        public static final /* synthetic */ Type[] a = null;
        public static final /* synthetic */ EnumEntries b = null;
        private final int value;

        public static final class a extends d<Type> {
            @Override // com.lark.wire.d
            public final o0 n(int r2) {
                Type.Companion.getClass();
                if (r2 == 1) goto L12;
                if (r2 == 2) goto L15;
                if (r2 == 3) goto L14;
                return null;
            L14:
                return Type.PHONE;
            L15:
                return Type.SMS;
            L12:
                return Type.APP;
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
            Type r0 = new Type("APP", 0, 1);
            APP = r0;
            Type r1 = new Type("SMS", 1, 2);
            SMS = r1;
            Type r4 = new Type("PHONE", 2, 3);
            PHONE = r4;
            Type[] r6 = {r0, r1, r4};
            a = r6;
            b = EnumEntriesKt.enumEntries(r6);
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
            if (r1 == 1) goto L12;
            if (r1 == 2) goto L15;
            if (r1 == 3) goto L14;
            return null;
        L14:
            return PHONE;
        L15:
            return SMS;
        L12:
            return APP;
        }

        public static Type valueOf(String r1) {
            return (Type) r27.a.a(Type.class, r1);
        }

        public Type(String r1, int r2, int r3) {
            super(r1, r2);
            this.value = r3;
        }
    }

    public static final class a extends com.lark.wire.Message.a<Urgent, a> {
        public String d;
        public String e;
        public Type f;
        public Long g;
        public Status h;
        public String i;
        public Boolean j;
        public Boolean k;

        @Override // com.lark.wire.Message.a
        public final com.lark.wire.Message b() {
            return new Urgent(this, c(), null);
        }

        public a() {
        }
    }

    public static final class b extends ProtoAdapter<Urgent> {
        @Override // com.lark.wire.ProtoAdapter
        public final Urgent c(g0 r10) {
            Intrinsics.checkNotNullParameter(r10, "reader");
            a r1 = new a();
            long r2 = r10.c();
        L3:
            int r4 = r10.e();
            if (r4 == (-1)) goto L22;
            switch(r4) {
                case 1: goto L20;
                case 2: goto L19;
                case 3: goto L23;
                case 4: goto L14;
                case 5: goto L25;
                case 6: goto L9;
                case 7: goto L8;
                case 8: goto L7;
                default: goto L6;
            };
        L23:
            r1.f = Type.ADAPTER.c(r10);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L17
        L17:
            e = move-exception;
            r10.a(r4, FieldEncoding.VARINT, Long.valueOf(e.value));
            Unit r5 = Unit.INSTANCE;
            goto L3
        L25:
            r1.h = Status.ADAPTER.c(r10);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L12
        L12:
            e = move-exception;
            r10.a(r4, FieldEncoding.VARINT, Long.valueOf(e.value));
            Unit r6 = Unit.INSTANCE;
            goto L3
        L7:
            r1.k = (Boolean) ProtoAdapter.g.c(r10);
            goto L3
        L8:
            r1.j = (Boolean) ProtoAdapter.g.c(r10);
            goto L3
        L9:
            ProtoAdapter.q.getClass();
            Intrinsics.checkNotNullParameter(r10, "reader");
            r1.i = r10.i();
            goto L3
        L14:
            r1.g = (Long) ProtoAdapter.k.c(r10);
            goto L3
        L19:
            ProtoAdapter.q.getClass();
            Intrinsics.checkNotNullParameter(r10, "reader");
            String r7 = r10.i();
            Intrinsics.checkNotNullParameter(r7, "message_id");
            r1.e = r7;
            goto L3
        L20:
            ProtoAdapter.q.getClass();
            Intrinsics.checkNotNullParameter(r10, "reader");
            String r8 = r10.i();
            Intrinsics.checkNotNullParameter(r8, "id");
            r1.d = r8;
            goto L3
        L6:
            r10.j(r4);
            Unit r9 = Unit.INSTANCE;
            goto L3
        L22:
            return new Urgent(r1, r10.d(r2), null);
        }

        @Override // com.lark.wire.ProtoAdapter
        public final int k(Urgent r6) {
            Urgent r7 = r6;
            Intrinsics.checkNotNullParameter(r7, "value");
            int r0 = r7.unknownFields().size();
            w r1 = ProtoAdapter.q;
            int r2 = (((((r0 + r1.l(1, r7.getId())) + r1.l(2, r7.getMessage_id())) + Type.ADAPTER.l(3, r7.getType())) + ProtoAdapter.k.l(4, r7.getSend_time())) + Status.ADAPTER.l(5, r7.getStatus())) + r1.l(6, r7.getAck_chatter_id());
            l r3 = ProtoAdapter.g;
            return (r2 + r3.l(7, r7.is_closed())) + r3.l(8, r7.is_muted());
        }

        @Override // com.lark.wire.ProtoAdapter
        public final void f(j0 r5, Urgent r6) {
            Urgent r7 = r6;
            Intrinsics.checkNotNullParameter(r5, "writer");
            Intrinsics.checkNotNullParameter(r7, "value");
            w r0 = ProtoAdapter.q;
            r0.i(r5, 1, r7.getId());
            r0.i(r5, 2, r7.getMessage_id());
            Type.ADAPTER.i(r5, 3, r7.getType());
            ProtoAdapter.k.i(r5, 4, r7.getSend_time());
            Status.ADAPTER.i(r5, 5, r7.getStatus());
            r0.i(r5, 6, r7.getAck_chatter_id());
            l r1 = ProtoAdapter.g;
            r1.i(r5, 7, r7.is_closed());
            r1.i(r5, 8, r7.is_muted());
            r5.a(r7.unknownFields());
        }

        @Override // com.lark.wire.ProtoAdapter
        public final void g(n0 r5, Urgent r6) {
            Urgent r7 = r6;
            Intrinsics.checkNotNullParameter(r5, "writer");
            Intrinsics.checkNotNullParameter(r7, "value");
            r5.d(r7.unknownFields());
            l r0 = ProtoAdapter.g;
            r0.j(r5, 8, r7.is_muted());
            r0.j(r5, 7, r7.is_closed());
            w r1 = ProtoAdapter.q;
            r1.j(r5, 6, r7.getAck_chatter_id());
            Status.ADAPTER.j(r5, 5, r7.getStatus());
            ProtoAdapter.k.j(r5, 4, r7.getSend_time());
            Type.ADAPTER.j(r5, 3, r7.getType());
            r1.j(r5, 2, r7.getMessage_id());
            r1.j(r5, 1, r7.getId());
        }

        public b(FieldEncoding r7, KClass<Urgent> r8, Syntax r9) {
            super(r7, r8, "type.googleapis.com/basic.v1.Urgent", r9, null);
        }
    }

    public static final class c {
        public c() {
        }
    }

    public /* synthetic */ Urgent(a r1, ByteString r2, DefaultConstructorMarker r3) {
        this(r1, r2);
    }

    static {
        Companion = new c();
        ADAPTER = new b(FieldEncoding.LENGTH_DELIMITED, Reflection.getOrCreateKotlinClass(Urgent.class), Syntax.PROTO_2);
    }

    @Override // com.lark.wire.Message
    public a newBuilder() {
        a r0 = new a();
        r0.d = this.id;
        r0.e = this.message_id;
        r0.f = this.type;
        r0.g = this.send_time;
        r0.h = this.status;
        r0.i = this.ack_chatter_id;
        r0.j = this.is_closed;
        r0.k = this.is_muted;
        r0.a(unknownFields());
        return r0;
    }

    @Override // com.lark.wire.Message
    public String toString() {
        return Reflection.getOrCreateKotlinClass(Urgent.class).getSimpleName() + '@' + hashCode();
    }

    public final String getAck_chatter_id() {
        return this.ack_chatter_id;
    }

    public final String getId() {
        return this.id;
    }

    public final String getMessage_id() {
        return this.message_id;
    }

    public final Long getSend_time() {
        return this.send_time;
    }

    public final Status getStatus() {
        return this.status;
    }

    public final Type getType() {
        return this.type;
    }

    public final Boolean is_closed() {
        return this.is_closed;
    }

    public final Boolean is_muted() {
        return this.is_muted;
    }

    @Override // com.lark.wire.Message
    public /* bridge */ /* synthetic */ com.lark.wire.Message.a newBuilder() {
        return newBuilder();
    }

    public Urgent(a r2, ByteString r3) {
        super(ADAPTER, r3);
        String r4 = r2.d;
        Intrinsics.checkNotNull(r4);
        this.id = r4;
        String r5 = r2.e;
        Intrinsics.checkNotNull(r5);
        this.message_id = r5;
        this.type = r2.f;
        this.send_time = r2.g;
        this.status = r2.h;
        this.ack_chatter_id = r2.i;
        this.is_closed = r2.j;
        this.is_muted = r2.k;
    }

    public /* synthetic */ Urgent(a r1, ByteString r2, int r3, DefaultConstructorMarker r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = ByteString.EMPTY;
    L5:
        this(r1, r2);
    }
}
