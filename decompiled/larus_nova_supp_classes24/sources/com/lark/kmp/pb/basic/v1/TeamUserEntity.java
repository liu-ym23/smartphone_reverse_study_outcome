package com.lark.kmp.pb.basic.v1;

import com.lark.wire.FieldEncoding;
import com.lark.wire.ProtoAdapter;
import com.lark.wire.Syntax;
import com.lark.wire.d;
import com.lark.wire.g0;
import com.lark.wire.j0;
import com.lark.wire.n0;
import com.lark.wire.o0;
import com.larksuite.component.universe_design.timepicker.impl.base.WheelView;
import java.util.ArrayList;
import java.util.List;
import kotlin.Deprecated;
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
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0004\u0018\u0000 \u001c2\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00020\u0001:\u0003\u001b\u001c\u001dB\u001b\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\b\u0010\u0018\u001a\u00020\u0002H\u0016J\b\u0010\u0019\u001a\u00020\u001aH\u0016R\u001e\u0010\b\u001a\u0004\u0018\u00010\t8\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\rR\u0017\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00100\u000f¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0015\u0010\u0013\u001a\u0004\u0018\u00010\u0014¢\u0006\n\n\u0002\u0010\u0017\u001a\u0004\b\u0015\u0010\u0016¨\u0006\u001e"}, d2 = {"Lcom/lark/kmp/pb/basic/v1/TeamUserEntity;", "Lcom/lark/wire/Message;", "Lcom/lark/kmp/pb/basic/v1/TeamUserEntity$Builder;", "builder", "unknownFields", "Lokio/ByteString;", "<init>", "(Lcom/lark/kmp/pb/basic/v1/TeamUserEntity$Builder;Lokio/ByteString;)V", "user_role", "Lcom/lark/kmp/pb/basic/v1/TeamUserEntity$Role;", "getUser_role$annotations", "()V", "getUser_role", "()Lcom/lark/kmp/pb/basic/v1/TeamUserEntity$Role;", "user_roles", "", "Lcom/lark/kmp/pb/basic/v1/TeamRole;", "getUser_roles", "()Ljava/util/List;", "version", "", "getVersion", "()Ljava/lang/Long;", "Ljava/lang/Long;", "newBuilder", "toString", "", "Builder", "Companion", "Role", "rust-sdk-kotlin-pb_release"}, k = 1, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
public final class TeamUserEntity extends com.lark.wire.Message<TeamUserEntity, a> {
    public static final ProtoAdapter<TeamUserEntity> ADAPTER = null;
    public static final c Companion = null;
    private static final long serialVersionUID = 0;
    private final Role user_role;
    private final List<TeamRole> user_roles;
    private final Long version;

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\t\b\u0086\u0081\u0002\u0018\u0000 \f2\u00020\u00012\b\u0012\u0004\u0012\u00020\u00000\u0002:\u0001\fB\u0011\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u0004X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000b¨\u0006\r"}, d2 = {"Lcom/lark/kmp/pb/basic/v1/TeamUserEntity$Role;", "Lcom/lark/wire/WireEnum;", "", "value", "", "<init>", "(Ljava/lang/String;II)V", "getValue", "()I", "UNKNOWN", "MEMBER", "OWNER", "Companion", "rust-sdk-kotlin-pb_release"}, k = 1, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
    public static final enum Role extends Enum<Role> implements o0 {
        public static final ProtoAdapter<Role> ADAPTER = null;
        public static final b Companion = null;
        public static final Role MEMBER = null;
        public static final Role OWNER = null;
        public static final Role UNKNOWN = null;
        public static final /* synthetic */ Role[] a = null;
        public static final /* synthetic */ EnumEntries b = null;
        private final int value;

        public static final class a extends d<Role> {
            @Override // com.lark.wire.d
            public final o0 n(int r2) {
                Role.Companion.getClass();
                if (r2 == 0) goto L12;
                if (r2 == 1) goto L15;
                if (r2 == 2) goto L14;
                return null;
            L14:
                return Role.OWNER;
            L15:
                return Role.MEMBER;
            L12:
                return Role.UNKNOWN;
            }

            public a(KClass<Role> r1, Syntax r2, Role r3) {
                super(r1, r2, r3);
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
            Role r0 = new Role("UNKNOWN", 0, 0);
            UNKNOWN = r0;
            Role r1 = new Role("MEMBER", 1, 1);
            MEMBER = r1;
            Role r3 = new Role("OWNER", 2, 2);
            OWNER = r3;
            Role[] r5 = {r0, r1, r3};
            a = r5;
            b = EnumEntriesKt.enumEntries(r5);
            Companion = new b();
            ADAPTER = new a(Reflection.getOrCreateKotlinClass(Role.class), Syntax.PROTO_2, r0);
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
            if (r1 == 0) goto L12;
            if (r1 == 1) goto L15;
            if (r1 == 2) goto L14;
            return null;
        L14:
            return OWNER;
        L15:
            return MEMBER;
        L12:
            return UNKNOWN;
        }

        public static Role valueOf(String r1) {
            return (Role) r27.a.a(Role.class, r1);
        }

        public Role(String r1, int r2, int r3) {
            super(r1, r2);
            this.value = r3;
        }
    }

    public static final class a extends com.lark.wire.Message.a<TeamUserEntity, a> {
        public Role d;
        public List<TeamRole> e;
        public Long f;

        @Override // com.lark.wire.Message.a
        public final com.lark.wire.Message b() {
            return new TeamUserEntity(this, c(), null);
        }

        public a() {
            this.e = CollectionsKt.emptyList();
        }
    }

    public static final class b extends ProtoAdapter<TeamUserEntity> {
        @Override // com.lark.wire.ProtoAdapter
        public final TeamUserEntity c(g0 r10) {
            Intrinsics.checkNotNullParameter(r10, "reader");
            a r0 = new a();
            ArrayList r1 = new ArrayList();
            long r2 = r10.c();
        L3:
            int r4 = r10.e();
            if (r4 == (-1)) goto L18;
            if (r4 != 1) goto L8;
            r0.d = Role.ADAPTER.c(r10);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L16
        L16:
            e = move-exception;
            r10.a(r4, FieldEncoding.VARINT, Long.valueOf(e.value));
            Unit r5 = Unit.INSTANCE;
            goto L3
        L8:
            if (r4 != 2) goto L10;
            r1.add(TeamRole.ADAPTER.c(r10));
            goto L3
        L10:
            if (r4 != 100) goto L11;
            r0.f = (Long) ProtoAdapter.k.c(r10);
            goto L3
        L11:
            r10.j(r4);
            goto L3
        L18:
            ByteString r11 = r10.d(r2);
            Intrinsics.checkNotNullParameter(r1, "user_roles");
            com.lark.wire.internal.a.a(r1);
            r0.e = r1;
            return new TeamUserEntity(r0, r11, null);
        }

        @Override // com.lark.wire.ProtoAdapter
        public final int k(TeamUserEntity r5) {
            TeamUserEntity r6 = r5;
            Intrinsics.checkNotNullParameter(r6, "value");
            return ((r6.unknownFields().size() + Role.ADAPTER.l(1, r6.getUser_role())) + TeamRole.ADAPTER.a().l(2, r6.getUser_roles())) + ProtoAdapter.k.l(100, r6.getVersion());
        }

        @Override // com.lark.wire.ProtoAdapter
        public final void f(j0 r4, TeamUserEntity r5) {
            TeamUserEntity r6 = r5;
            Intrinsics.checkNotNullParameter(r4, "writer");
            Intrinsics.checkNotNullParameter(r6, "value");
            Role.ADAPTER.i(r4, 1, r6.getUser_role());
            TeamRole.ADAPTER.a().i(r4, 2, r6.getUser_roles());
            ProtoAdapter.k.i(r4, 100, r6.getVersion());
            r4.a(r6.unknownFields());
        }

        @Override // com.lark.wire.ProtoAdapter
        public final void g(n0 r4, TeamUserEntity r5) {
            TeamUserEntity r6 = r5;
            Intrinsics.checkNotNullParameter(r4, "writer");
            Intrinsics.checkNotNullParameter(r6, "value");
            r4.d(r6.unknownFields());
            ProtoAdapter.k.j(r4, 100, r6.getVersion());
            TeamRole.ADAPTER.a().j(r4, 2, r6.getUser_roles());
            Role.ADAPTER.j(r4, 1, r6.getUser_role());
        }

        public b(FieldEncoding r7, KClass<TeamUserEntity> r8, Syntax r9) {
            super(r7, r8, "type.googleapis.com/basic.v1.TeamUserEntity", r9, null);
        }
    }

    public static final class c {
        public c() {
        }
    }

    public /* synthetic */ TeamUserEntity(a r1, ByteString r2, DefaultConstructorMarker r3) {
        this(r1, r2);
    }

    @Deprecated(message = "user_role is deprecated")
    public static /* synthetic */ void getUser_role$annotations() {
    }

    static {
        Companion = new c();
        ADAPTER = new b(FieldEncoding.LENGTH_DELIMITED, Reflection.getOrCreateKotlinClass(TeamUserEntity.class), Syntax.PROTO_2);
    }

    @Override // com.lark.wire.Message
    public a newBuilder() {
        a r0 = new a();
        r0.d = this.user_role;
        r0.e = this.user_roles;
        r0.f = this.version;
        r0.a(unknownFields());
        return r0;
    }

    @Override // com.lark.wire.Message
    public String toString() {
        return Reflection.getOrCreateKotlinClass(TeamUserEntity.class).getSimpleName() + '@' + hashCode();
    }

    public final Role getUser_role() {
        return this.user_role;
    }

    public final List<TeamRole> getUser_roles() {
        return this.user_roles;
    }

    public final Long getVersion() {
        return this.version;
    }

    @Override // com.lark.wire.Message
    public /* bridge */ /* synthetic */ com.lark.wire.Message.a newBuilder() {
        return newBuilder();
    }

    public TeamUserEntity(a r2, ByteString r3) {
        super(ADAPTER, r3);
        this.user_role = r2.d;
        this.user_roles = com.lark.wire.internal.a.c("user_roles", r2.e);
        this.version = r2.f;
    }

    public /* synthetic */ TeamUserEntity(a r1, ByteString r2, int r3, DefaultConstructorMarker r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = ByteString.EMPTY;
    L5:
        this(r1, r2);
    }
}
