package com.lark.kmp.pb.basic.v1;

import com.lark.wire.FieldEncoding;
import com.lark.wire.ProtoAdapter;
import com.lark.wire.Syntax;
import com.lark.wire.d;
import com.lark.wire.g0;
import com.lark.wire.j0;
import com.lark.wire.n0;
import com.lark.wire.o0;
import com.lark.wire.t;
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
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 12\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00020\u0001:\u0003012B\u001b\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\b\u0010.\u001a\u00020\u0002H\u0016J\b\u0010/\u001a\u00020\u000eH\u0016R\u0015\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\n\n\u0002\u0010\f\u001a\u0004\b\n\u0010\u000bR\u0013\u0010\r\u001a\u0004\u0018\u00010\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0013\u0010\u0011\u001a\u0004\u0018\u00010\u0012¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0015\u0010\u0015\u001a\u0004\u0018\u00010\t¢\u0006\n\n\u0002\u0010\f\u001a\u0004\b\u0016\u0010\u000bR\u0015\u0010\u0017\u001a\u0004\u0018\u00010\u0018¢\u0006\n\n\u0002\u0010\u001b\u001a\u0004\b\u0019\u0010\u001aR\u0015\u0010\u001c\u001a\u0004\u0018\u00010\t¢\u0006\n\n\u0002\u0010\f\u001a\u0004\b\u001d\u0010\u000bR\u0013\u0010\u001e\u001a\u0004\u0018\u00010\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010\u0010R\u0013\u0010 \u001a\u0004\u0018\u00010\u000e¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\u0010R\u0015\u0010\"\u001a\u0004\u0018\u00010\t¢\u0006\n\n\u0002\u0010\f\u001a\u0004\b#\u0010\u000bR\u0015\u0010$\u001a\u0004\u0018\u00010\t¢\u0006\n\n\u0002\u0010\f\u001a\u0004\b%\u0010\u000bR\u0013\u0010&\u001a\u0004\u0018\u00010'¢\u0006\b\n\u0000\u001a\u0004\b(\u0010)R\u0013\u0010*\u001a\u0004\u0018\u00010+¢\u0006\b\n\u0000\u001a\u0004\b,\u0010-¨\u00063"}, d2 = {"Lcom/lark/kmp/pb/basic/v1/Team;", "Lcom/lark/wire/Message;", "Lcom/lark/kmp/pb/basic/v1/Team$Builder;", "builder", "unknownFields", "Lokio/ByteString;", "<init>", "(Lcom/lark/kmp/pb/basic/v1/Team$Builder;Lokio/ByteString;)V", "id", "", "getId", "()Ljava/lang/Long;", "Ljava/lang/Long;", "name", "", "getName", "()Ljava/lang/String;", "status", "Lcom/lark/kmp/pb/basic/v1/Team$Status;", "getStatus", "()Lcom/lark/kmp/pb/basic/v1/Team$Status;", "owner_id", "getOwner_id", "member_count", "", "getMember_count", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "default_chat_id", "getDefault_chat_id", "description", "getDescription", "avatar_key", "getAvatar_key", "create_time", "getCreate_time", "version", "getVersion", "setting", "Lcom/lark/kmp/pb/basic/v1/TeamSetting;", "getSetting", "()Lcom/lark/kmp/pb/basic/v1/TeamSetting;", "user_entity", "Lcom/lark/kmp/pb/basic/v1/TeamUserEntity;", "getUser_entity", "()Lcom/lark/kmp/pb/basic/v1/TeamUserEntity;", "newBuilder", "toString", "Builder", "Companion", "Status", "rust-sdk-kotlin-pb_release"}, k = 1, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
public final class Team extends com.lark.wire.Message<Team, a> {
    public static final ProtoAdapter<Team> ADAPTER = null;
    public static final c Companion = null;
    private static final long serialVersionUID = 0;
    private final String avatar_key;
    private final Long create_time;
    private final Long default_chat_id;
    private final String description;
    private final Long id;
    private final Integer member_count;
    private final String name;
    private final Long owner_id;
    private final TeamSetting setting;
    private final Status status;
    private final TeamUserEntity user_entity;
    private final Long version;

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\t\b\u0086\u0081\u0002\u0018\u0000 \f2\u00020\u00012\b\u0012\u0004\u0012\u00020\u00000\u0002:\u0001\fB\u0011\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u0004X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000b¨\u0006\r"}, d2 = {"Lcom/lark/kmp/pb/basic/v1/Team$Status;", "Lcom/lark/wire/WireEnum;", "", "value", "", "<init>", "(Ljava/lang/String;II)V", "getValue", "()I", "UNKNOWN", "ACTIVE", "DISSOLVED", "Companion", "rust-sdk-kotlin-pb_release"}, k = 1, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
    public static final enum Status extends Enum<Status> implements o0 {
        public static final Status ACTIVE = null;
        public static final ProtoAdapter<Status> ADAPTER = null;
        public static final b Companion = null;
        public static final Status DISSOLVED = null;
        public static final Status UNKNOWN = null;
        public static final /* synthetic */ Status[] a = null;
        public static final /* synthetic */ EnumEntries b = null;
        private final int value;

        public static final class a extends d<Status> {
            @Override // com.lark.wire.d
            public final o0 n(int r2) {
                Status.Companion.getClass();
                if (r2 == 0) goto L12;
                if (r2 == 1) goto L15;
                if (r2 == 2) goto L14;
                return null;
            L14:
                return Status.DISSOLVED;
            L15:
                return Status.ACTIVE;
            L12:
                return Status.UNKNOWN;
            }

            public a(KClass<Status> r1, Syntax r2, Status r3) {
                super(r1, r2, r3);
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
            Status r0 = new Status("UNKNOWN", 0, 0);
            UNKNOWN = r0;
            Status r1 = new Status("ACTIVE", 1, 1);
            ACTIVE = r1;
            Status r3 = new Status("DISSOLVED", 2, 2);
            DISSOLVED = r3;
            Status[] r5 = {r0, r1, r3};
            a = r5;
            b = EnumEntriesKt.enumEntries(r5);
            Companion = new b();
            ADAPTER = new a(Reflection.getOrCreateKotlinClass(Status.class), Syntax.PROTO_2, r0);
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
            if (r1 == 0) goto L12;
            if (r1 == 1) goto L15;
            if (r1 == 2) goto L14;
            return null;
        L14:
            return DISSOLVED;
        L15:
            return ACTIVE;
        L12:
            return UNKNOWN;
        }

        public static Status valueOf(String r1) {
            return (Status) r27.a.a(Status.class, r1);
        }

        public Status(String r1, int r2, int r3) {
            super(r1, r2);
            this.value = r3;
        }
    }

    public static final class a extends com.lark.wire.Message.a<Team, a> {
        public Long d;
        public String e;
        public Status f;
        public Long g;
        public Integer h;
        public Long i;
        public String j;
        public String k;
        public Long l;
        public Long m;
        public TeamSetting n;
        public TeamUserEntity o;

        @Override // com.lark.wire.Message.a
        public final com.lark.wire.Message b() {
            return new Team(this, c(), null);
        }

        public a() {
        }
    }

    public static final class b extends ProtoAdapter<Team> {
        @Override // com.lark.wire.ProtoAdapter
        public final Team c(g0 r10) {
            Intrinsics.checkNotNullParameter(r10, "reader");
            a r1 = new a();
            long r2 = r10.c();
        L3:
            int r4 = r10.e();
            if (r4 == (-1)) goto L31;
            if (r4 != 20) goto L8;
            r1.l = (Long) ProtoAdapter.k.c(r10);
            goto L3
        L8:
            if (r4 != 21) goto L10;
            r1.m = (Long) ProtoAdapter.k.c(r10);
            goto L3
        L10:
            if (r4 != 100) goto L12;
            r1.n = TeamSetting.ADAPTER.c(r10);
            goto L3
        L12:
            if (r4 != 101) goto L13;
            r1.o = TeamUserEntity.ADAPTER.c(r10);
            goto L3
        L13:
            switch(r4) {
                case 1: goto L25;
                case 2: goto L24;
                case 3: goto L32;
                case 4: goto L19;
                case 5: goto L18;
                case 6: goto L17;
                case 7: goto L16;
                case 8: goto L15;
                default: goto L14;
            };
        L32:
            r1.f = Status.ADAPTER.c(r10);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L22
        L22:
            e = move-exception;
            r10.a(r4, FieldEncoding.VARINT, Long.valueOf(e.value));
            Unit r5 = Unit.INSTANCE;
            goto L3
        L15:
            ProtoAdapter.q.getClass();
            Intrinsics.checkNotNullParameter(r10, "reader");
            r1.k = r10.i();
            goto L3
        L16:
            ProtoAdapter.q.getClass();
            Intrinsics.checkNotNullParameter(r10, "reader");
            r1.j = r10.i();
            goto L3
        L17:
            r1.i = (Long) ProtoAdapter.k.c(r10);
            goto L3
        L18:
            r1.h = (Integer) ProtoAdapter.h.c(r10);
            goto L3
        L19:
            r1.g = (Long) ProtoAdapter.k.c(r10);
            goto L3
        L24:
            ProtoAdapter.q.getClass();
            Intrinsics.checkNotNullParameter(r10, "reader");
            r1.e = r10.i();
            goto L3
        L25:
            r1.d = (Long) ProtoAdapter.k.c(r10);
            goto L3
        L14:
            r10.j(r4);
            Unit r6 = Unit.INSTANCE;
            goto L3
        L31:
            return new Team(r1, r10.d(r2), null);
        }

        @Override // com.lark.wire.ProtoAdapter
        public final int k(Team r7) {
            Team r8 = r7;
            Intrinsics.checkNotNullParameter(r8, "value");
            int r0 = r8.unknownFields().size();
            t r1 = ProtoAdapter.k;
            int r2 = r0 + r1.l(1, r8.getId());
            w r3 = ProtoAdapter.q;
            return ((((((((((r2 + r3.l(2, r8.getName())) + Status.ADAPTER.l(3, r8.getStatus())) + r1.l(4, r8.getOwner_id())) + ProtoAdapter.h.l(5, r8.getMember_count())) + r1.l(6, r8.getDefault_chat_id())) + r3.l(7, r8.getDescription())) + r3.l(8, r8.getAvatar_key())) + r1.l(20, r8.getCreate_time())) + r1.l(21, r8.getVersion())) + TeamSetting.ADAPTER.l(100, r8.getSetting())) + TeamUserEntity.ADAPTER.l(101, r8.getUser_entity());
        }

        @Override // com.lark.wire.ProtoAdapter
        public final void f(j0 r6, Team r7) {
            Team r8 = r7;
            Intrinsics.checkNotNullParameter(r6, "writer");
            Intrinsics.checkNotNullParameter(r8, "value");
            t r0 = ProtoAdapter.k;
            r0.i(r6, 1, r8.getId());
            w r1 = ProtoAdapter.q;
            r1.i(r6, 2, r8.getName());
            Status.ADAPTER.i(r6, 3, r8.getStatus());
            r0.i(r6, 4, r8.getOwner_id());
            ProtoAdapter.h.i(r6, 5, r8.getMember_count());
            r0.i(r6, 6, r8.getDefault_chat_id());
            r1.i(r6, 7, r8.getDescription());
            r1.i(r6, 8, r8.getAvatar_key());
            r0.i(r6, 20, r8.getCreate_time());
            r0.i(r6, 21, r8.getVersion());
            TeamSetting.ADAPTER.i(r6, 100, r8.getSetting());
            TeamUserEntity.ADAPTER.i(r6, 101, r8.getUser_entity());
            r6.a(r8.unknownFields());
        }

        @Override // com.lark.wire.ProtoAdapter
        public final void g(n0 r6, Team r7) {
            Team r8 = r7;
            Intrinsics.checkNotNullParameter(r6, "writer");
            Intrinsics.checkNotNullParameter(r8, "value");
            r6.d(r8.unknownFields());
            TeamUserEntity.ADAPTER.j(r6, 101, r8.getUser_entity());
            TeamSetting.ADAPTER.j(r6, 100, r8.getSetting());
            t r0 = ProtoAdapter.k;
            r0.j(r6, 21, r8.getVersion());
            r0.j(r6, 20, r8.getCreate_time());
            w r1 = ProtoAdapter.q;
            r1.j(r6, 8, r8.getAvatar_key());
            r1.j(r6, 7, r8.getDescription());
            r0.j(r6, 6, r8.getDefault_chat_id());
            ProtoAdapter.h.j(r6, 5, r8.getMember_count());
            r0.j(r6, 4, r8.getOwner_id());
            Status.ADAPTER.j(r6, 3, r8.getStatus());
            r1.j(r6, 2, r8.getName());
            r0.j(r6, 1, r8.getId());
        }

        public b(FieldEncoding r7, KClass<Team> r8, Syntax r9) {
            super(r7, r8, "type.googleapis.com/basic.v1.Team", r9, null);
        }
    }

    public static final class c {
        public c() {
        }
    }

    public /* synthetic */ Team(a r1, ByteString r2, DefaultConstructorMarker r3) {
        this(r1, r2);
    }

    static {
        Companion = new c();
        ADAPTER = new b(FieldEncoding.LENGTH_DELIMITED, Reflection.getOrCreateKotlinClass(Team.class), Syntax.PROTO_2);
    }

    @Override // com.lark.wire.Message
    public a newBuilder() {
        a r0 = new a();
        r0.d = this.id;
        r0.e = this.name;
        r0.f = this.status;
        r0.g = this.owner_id;
        r0.h = this.member_count;
        r0.i = this.default_chat_id;
        r0.j = this.description;
        r0.k = this.avatar_key;
        r0.l = this.create_time;
        r0.m = this.version;
        r0.n = this.setting;
        r0.o = this.user_entity;
        r0.a(unknownFields());
        return r0;
    }

    @Override // com.lark.wire.Message
    public String toString() {
        return Reflection.getOrCreateKotlinClass(Team.class).getSimpleName() + '@' + hashCode();
    }

    public final String getAvatar_key() {
        return this.avatar_key;
    }

    public final Long getCreate_time() {
        return this.create_time;
    }

    public final Long getDefault_chat_id() {
        return this.default_chat_id;
    }

    public final String getDescription() {
        return this.description;
    }

    public final Long getId() {
        return this.id;
    }

    public final Integer getMember_count() {
        return this.member_count;
    }

    public final String getName() {
        return this.name;
    }

    public final Long getOwner_id() {
        return this.owner_id;
    }

    public final TeamSetting getSetting() {
        return this.setting;
    }

    public final Status getStatus() {
        return this.status;
    }

    public final TeamUserEntity getUser_entity() {
        return this.user_entity;
    }

    public final Long getVersion() {
        return this.version;
    }

    @Override // com.lark.wire.Message
    public /* bridge */ /* synthetic */ com.lark.wire.Message.a newBuilder() {
        return newBuilder();
    }

    public Team(a r2, ByteString r3) {
        super(ADAPTER, r3);
        this.id = r2.d;
        this.name = r2.e;
        this.status = r2.f;
        this.owner_id = r2.g;
        this.member_count = r2.h;
        this.default_chat_id = r2.i;
        this.description = r2.j;
        this.avatar_key = r2.k;
        this.create_time = r2.l;
        this.version = r2.m;
        this.setting = r2.n;
        this.user_entity = r2.o;
    }

    public /* synthetic */ Team(a r1, ByteString r2, int r3, DefaultConstructorMarker r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = ByteString.EMPTY;
    L5:
        this(r1, r2);
    }
}
