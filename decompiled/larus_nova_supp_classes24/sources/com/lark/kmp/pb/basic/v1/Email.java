package com.lark.kmp.pb.basic.v1;

import com.lark.wire.FieldEncoding;
import com.lark.wire.ProtoAdapter;
import com.lark.wire.Syntax;
import com.lark.wire.d;
import com.lark.wire.g0;
import com.lark.wire.j0;
import com.lark.wire.n0;
import com.lark.wire.o0;
import com.lark.wire.s;
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
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\t\u0018\u0000 )2\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00020\u0001:\u0003()*B\u001b\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\b\u0010&\u001a\u00020\u0002H\u0016J\b\u0010'\u001a\u00020\tH\u0016R\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0013\u0010\f\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000bR\u0013\u0010\u000e\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000bR\u0015\u0010\u0010\u001a\u0004\u0018\u00010\u0011¢\u0006\n\n\u0002\u0010\u0014\u001a\u0004\b\u0012\u0010\u0013R\u0015\u0010\u0015\u001a\u0004\u0018\u00010\u0011¢\u0006\n\n\u0002\u0010\u0014\u001a\u0004\b\u0016\u0010\u0013R\u0013\u0010\u0017\u001a\u0004\u0018\u00010\u0018¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001aR\u0017\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\t0\u001c¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001eR\u0013\u0010\u001f\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b \u0010\u000bR\u0015\u0010!\u001a\u0004\u0018\u00010\"¢\u0006\n\n\u0002\u0010%\u001a\u0004\b#\u0010$¨\u0006+"}, d2 = {"Lcom/lark/kmp/pb/basic/v1/Email;", "Lcom/lark/wire/Message;", "Lcom/lark/kmp/pb/basic/v1/Email$Builder;", "builder", "unknownFields", "Lokio/ByteString;", "<init>", "(Lcom/lark/kmp/pb/basic/v1/Email$Builder;Lokio/ByteString;)V", "id", "", "getId", "()Ljava/lang/String;", "owner_id", "getOwner_id", "last_message_id", "getLast_message_id", "new_message_count", "", "getNew_message_count", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "last_message_position", "getLast_message_position", "role", "Lcom/lark/kmp/pb/basic/v1/Email$Role;", "getRole", "()Lcom/lark/kmp/pb/basic/v1/Email$Role;", "reply_draft_ids", "", "getReply_draft_ids", "()Ljava/util/List;", "subject", "getSubject", "update_time", "", "getUpdate_time", "()Ljava/lang/Long;", "Ljava/lang/Long;", "newBuilder", "toString", "Builder", "Companion", "Role", "rust-sdk-kotlin-pb_release"}, k = 1, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
public final class Email extends com.lark.wire.Message<Email, a> {
    public static final ProtoAdapter<Email> ADAPTER = null;
    public static final c Companion = null;
    public static final String DEFAULT_LAST_MESSAGE_ID = "";
    public static final int DEFAULT_LAST_MESSAGE_POSITION = 0;
    public static final int DEFAULT_NEW_MESSAGE_COUNT = 0;
    public static final String DEFAULT_OWNER_ID = "";
    public static final Role DEFAULT_ROLE = null;
    public static final String DEFAULT_SUBJECT = "";
    public static final long DEFAULT_UPDATE_TIME = 0;
    private static final long serialVersionUID = 0;
    private final String id;
    private final String last_message_id;
    private final Integer last_message_position;
    private final Integer new_message_count;
    private final String owner_id;
    private final List<String> reply_draft_ids;
    private final Role role;
    private final String subject;
    private final Long update_time;

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\t\b\u0086\u0081\u0002\u0018\u0000 \f2\u00020\u00012\b\u0012\u0004\u0012\u00020\u00000\u0002:\u0001\fB\u0011\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u0004X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000b¨\u0006\r"}, d2 = {"Lcom/lark/kmp/pb/basic/v1/Email$Role;", "Lcom/lark/wire/WireEnum;", "", "value", "", "<init>", "(Ljava/lang/String;II)V", "getValue", "()I", "TO", "CC", "STRANGER", "Companion", "rust-sdk-kotlin-pb_release"}, k = 1, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
    public static final enum Role extends Enum<Role> implements o0 {
        public static final ProtoAdapter<Role> ADAPTER = null;
        public static final Role CC = null;
        public static final b Companion = null;
        public static final Role STRANGER = null;
        public static final Role TO = null;
        public static final /* synthetic */ Role[] a = null;
        public static final /* synthetic */ EnumEntries b = null;
        private final int value;

        public static final class a extends d<Role> {
            @Override // com.lark.wire.d
            public final o0 n(int r2) {
                Role.Companion.getClass();
                if (r2 == 1) goto L12;
                if (r2 == 2) goto L15;
                if (r2 == 3) goto L14;
                return null;
            L14:
                return Role.STRANGER;
            L15:
                return Role.CC;
            L12:
                return Role.TO;
            }

            public a(KClass<Role> r2, Syntax r3) {
                super(r2, r3, null);
            }
        }

        public static final class b {
            public b() {
            }
        }

        public static EnumEntries<Role> getEntries() {
            return b;
        }

        static {
            Role r0 = new Role("TO", 0, 1);
            TO = r0;
            Role r1 = new Role("CC", 1, 2);
            CC = r1;
            Role r4 = new Role("STRANGER", 2, 3);
            STRANGER = r4;
            Role[] r6 = {r0, r1, r4};
            a = r6;
            b = EnumEntriesKt.enumEntries(r6);
            Companion = new b();
            ADAPTER = new a(Reflection.getOrCreateKotlinClass(Role.class), Syntax.PROTO_2);
        }

        public static Role[] values() {
            return (Role[]) a.clone();
        }

        @Override // com.lark.wire.o0
        public int getValue() {
            return this.value;
        }

        @JvmStatic
        public static final Role fromValue(int r1) {
            Companion.getClass();
            if (r1 == 1) goto L12;
            if (r1 == 2) goto L15;
            if (r1 == 3) goto L14;
            return null;
        L14:
            return STRANGER;
        L15:
            return CC;
        L12:
            return TO;
        }

        public static Role valueOf(String r1) {
            return (Role) r27.a.a(Role.class, r1);
        }

        public Role(String r1, int r2, int r3) {
            super(r1, r2);
            this.value = r3;
        }
    }

    public static final class a extends com.lark.wire.Message.a<Email, a> {
        public String d;
        public String e;
        public String f;
        public Integer g;
        public Integer h;
        public Role i;
        public List<String> j;
        public String k;
        public Long l;

        @Override // com.lark.wire.Message.a
        public final com.lark.wire.Message b() {
            return new Email(this, c(), null);
        }

        public a() {
            this.j = CollectionsKt.emptyList();
        }
    }

    public static final class b extends ProtoAdapter<Email> {
        @Override // com.lark.wire.ProtoAdapter
        public final Email c(g0 r11) {
            Intrinsics.checkNotNullParameter(r11, "reader");
            a r1 = new a();
            ArrayList r2 = new ArrayList();
            long r3 = r11.c();
        L3:
            int r5 = r11.e();
            if (r5 == (-1)) goto L19;
            switch(r5) {
                case 1: goto L18;
                case 2: goto L17;
                case 3: goto L16;
                case 4: goto L15;
                case 5: goto L14;
                case 6: goto L21;
                case 7: goto L9;
                case 8: goto L8;
                case 9: goto L7;
                default: goto L6;
            };
        L21:
            r1.i = Role.ADAPTER.c(r11);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L12
        L12:
            e = move-exception;
            r11.a(r5, FieldEncoding.VARINT, Long.valueOf(e.value));
            Unit r6 = Unit.INSTANCE;
            goto L3
        L7:
            r1.l = (Long) ProtoAdapter.k.c(r11);
            goto L3
        L8:
            ProtoAdapter.q.getClass();
            Intrinsics.checkNotNullParameter(r11, "reader");
            r1.k = r11.i();
            goto L3
        L9:
            ProtoAdapter.q.getClass();
            Intrinsics.checkNotNullParameter(r11, "reader");
            r2.add(r11.i());
            goto L3
        L14:
            r1.h = (Integer) ProtoAdapter.h.c(r11);
            goto L3
        L15:
            r1.g = (Integer) ProtoAdapter.h.c(r11);
            goto L3
        L16:
            ProtoAdapter.q.getClass();
            Intrinsics.checkNotNullParameter(r11, "reader");
            r1.f = r11.i();
            goto L3
        L17:
            ProtoAdapter.q.getClass();
            Intrinsics.checkNotNullParameter(r11, "reader");
            r1.e = r11.i();
            goto L3
        L18:
            ProtoAdapter.q.getClass();
            Intrinsics.checkNotNullParameter(r11, "reader");
            String r7 = r11.i();
            Intrinsics.checkNotNullParameter(r7, "id");
            r1.d = r7;
            goto L3
        L6:
            r11.j(r5);
            Unit r8 = Unit.INSTANCE;
            goto L3
        L19:
            ByteString r12 = r11.d(r3);
            Intrinsics.checkNotNullParameter(r2, "reply_draft_ids");
            com.lark.wire.internal.a.a(r2);
            r1.j = r2;
            return new Email(r1, r12, null);
        }

        @Override // com.lark.wire.ProtoAdapter
        public final int k(Email r6) {
            Email r7 = r6;
            Intrinsics.checkNotNullParameter(r7, "value");
            int r0 = r7.unknownFields().size();
            w r1 = ProtoAdapter.q;
            int r2 = ((r0 + r1.l(1, r7.getId())) + r1.l(2, r7.getOwner_id())) + r1.l(3, r7.getLast_message_id());
            s r3 = ProtoAdapter.h;
            return (((((r2 + r3.l(4, r7.getNew_message_count())) + r3.l(5, r7.getLast_message_position())) + Role.ADAPTER.l(6, r7.getRole())) + r1.a().l(7, r7.getReply_draft_ids())) + r1.l(8, r7.getSubject())) + ProtoAdapter.k.l(9, r7.getUpdate_time());
        }

        @Override // com.lark.wire.ProtoAdapter
        public final void f(j0 r5, Email r6) {
            Email r7 = r6;
            Intrinsics.checkNotNullParameter(r5, "writer");
            Intrinsics.checkNotNullParameter(r7, "value");
            w r0 = ProtoAdapter.q;
            r0.i(r5, 1, r7.getId());
            r0.i(r5, 2, r7.getOwner_id());
            r0.i(r5, 3, r7.getLast_message_id());
            s r1 = ProtoAdapter.h;
            r1.i(r5, 4, r7.getNew_message_count());
            r1.i(r5, 5, r7.getLast_message_position());
            Role.ADAPTER.i(r5, 6, r7.getRole());
            r0.a().i(r5, 7, r7.getReply_draft_ids());
            r0.i(r5, 8, r7.getSubject());
            ProtoAdapter.k.i(r5, 9, r7.getUpdate_time());
            r5.a(r7.unknownFields());
        }

        @Override // com.lark.wire.ProtoAdapter
        public final void g(n0 r5, Email r6) {
            Email r7 = r6;
            Intrinsics.checkNotNullParameter(r5, "writer");
            Intrinsics.checkNotNullParameter(r7, "value");
            r5.d(r7.unknownFields());
            ProtoAdapter.k.j(r5, 9, r7.getUpdate_time());
            w r0 = ProtoAdapter.q;
            r0.j(r5, 8, r7.getSubject());
            r0.a().j(r5, 7, r7.getReply_draft_ids());
            Role.ADAPTER.j(r5, 6, r7.getRole());
            s r1 = ProtoAdapter.h;
            r1.j(r5, 5, r7.getLast_message_position());
            r1.j(r5, 4, r7.getNew_message_count());
            r0.j(r5, 3, r7.getLast_message_id());
            r0.j(r5, 2, r7.getOwner_id());
            r0.j(r5, 1, r7.getId());
        }

        public b(FieldEncoding r7, KClass<Email> r8, Syntax r9) {
            super(r7, r8, "type.googleapis.com/basic.v1.Email", r9, null);
        }
    }

    public static final class c {
        public c() {
        }
    }

    public /* synthetic */ Email(a r1, ByteString r2, DefaultConstructorMarker r3) {
        this(r1, r2);
    }

    static {
        Companion = new c();
        DEFAULT_ROLE = Role.TO;
        ADAPTER = new b(FieldEncoding.LENGTH_DELIMITED, Reflection.getOrCreateKotlinClass(Email.class), Syntax.PROTO_2);
    }

    @Override // com.lark.wire.Message
    public a newBuilder() {
        a r0 = new a();
        r0.d = this.id;
        r0.e = this.owner_id;
        r0.f = this.last_message_id;
        r0.g = this.new_message_count;
        r0.h = this.last_message_position;
        r0.i = this.role;
        r0.j = this.reply_draft_ids;
        r0.k = this.subject;
        r0.l = this.update_time;
        r0.a(unknownFields());
        return r0;
    }

    @Override // com.lark.wire.Message
    public String toString() {
        return Reflection.getOrCreateKotlinClass(Email.class).getSimpleName() + '@' + hashCode();
    }

    public final String getId() {
        return this.id;
    }

    public final String getLast_message_id() {
        return this.last_message_id;
    }

    public final Integer getLast_message_position() {
        return this.last_message_position;
    }

    public final Integer getNew_message_count() {
        return this.new_message_count;
    }

    public final String getOwner_id() {
        return this.owner_id;
    }

    public final List<String> getReply_draft_ids() {
        return this.reply_draft_ids;
    }

    public final Role getRole() {
        return this.role;
    }

    public final String getSubject() {
        return this.subject;
    }

    public final Long getUpdate_time() {
        return this.update_time;
    }

    @Override // com.lark.wire.Message
    public /* bridge */ /* synthetic */ com.lark.wire.Message.a newBuilder() {
        return newBuilder();
    }

    public Email(a r2, ByteString r3) {
        super(ADAPTER, r3);
        String r4 = r2.d;
        Intrinsics.checkNotNull(r4);
        this.id = r4;
        this.owner_id = r2.e;
        this.last_message_id = r2.f;
        this.new_message_count = r2.g;
        this.last_message_position = r2.h;
        this.role = r2.i;
        this.reply_draft_ids = com.lark.wire.internal.a.c("reply_draft_ids", r2.j);
        this.subject = r2.k;
        this.update_time = r2.l;
    }

    public /* synthetic */ Email(a r1, ByteString r2, int r3, DefaultConstructorMarker r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = ByteString.EMPTY;
    L5:
        this(r1, r2);
    }
}
