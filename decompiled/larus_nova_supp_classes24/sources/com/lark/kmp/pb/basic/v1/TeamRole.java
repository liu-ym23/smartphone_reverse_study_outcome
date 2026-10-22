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
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0004\u0018\u0000 \u00102\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00020\u0001:\u0003\u000f\u0010\u0011B\u001b\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\b\u0010\f\u001a\u00020\u0002H\u0016J\b\u0010\r\u001a\u00020\u000eH\u0016R\u0013\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0012"}, d2 = {"Lcom/lark/kmp/pb/basic/v1/TeamRole;", "Lcom/lark/wire/Message;", "Lcom/lark/kmp/pb/basic/v1/TeamRole$Builder;", "builder", "unknownFields", "Lokio/ByteString;", "<init>", "(Lcom/lark/kmp/pb/basic/v1/TeamRole$Builder;Lokio/ByteString;)V", "role_type", "Lcom/lark/kmp/pb/basic/v1/TeamRole$RoleType;", "getRole_type", "()Lcom/lark/kmp/pb/basic/v1/TeamRole$RoleType;", "newBuilder", "toString", "", "Builder", "Companion", "RoleType", "rust-sdk-kotlin-pb_release"}, k = 1, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
public final class TeamRole extends com.lark.wire.Message<TeamRole, a> {
    public static final ProtoAdapter<TeamRole> ADAPTER = null;
    public static final c Companion = null;
    private static final long serialVersionUID = 0;
    private final RoleType role_type;

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\t\b\u0086\u0081\u0002\u0018\u0000 \f2\u00020\u00012\b\u0012\u0004\u0012\u00020\u00000\u0002:\u0001\fB\u0011\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u0004X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000b¨\u0006\r"}, d2 = {"Lcom/lark/kmp/pb/basic/v1/TeamRole$RoleType;", "Lcom/lark/wire/WireEnum;", "", "value", "", "<init>", "(Ljava/lang/String;II)V", "getValue", "()I", "UNKNOWN", "OWNER", "ADMIN", "Companion", "rust-sdk-kotlin-pb_release"}, k = 1, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
    public static final enum RoleType extends Enum<RoleType> implements o0 {
        public static final ProtoAdapter<RoleType> ADAPTER = null;
        public static final RoleType ADMIN = null;
        public static final b Companion = null;
        public static final RoleType OWNER = null;
        public static final RoleType UNKNOWN = null;
        public static final /* synthetic */ RoleType[] a = null;
        public static final /* synthetic */ EnumEntries b = null;
        private final int value;

        public static final class a extends d<RoleType> {
            @Override // com.lark.wire.d
            public final o0 n(int r2) {
                RoleType.Companion.getClass();
                if (r2 == 0) goto L12;
                if (r2 == 1) goto L15;
                if (r2 == 2) goto L14;
                return null;
            L14:
                return RoleType.ADMIN;
            L15:
                return RoleType.OWNER;
            L12:
                return RoleType.UNKNOWN;
            }

            public a(KClass<RoleType> r1, Syntax r2, RoleType r3) {
                super(r1, r2, r3);
            }
        }

        public static final class b {
            public b() {
            }
        }

        public static EnumEntries<RoleType> getEntries() {
            return b;
        }

        static {
            RoleType r0 = new RoleType("UNKNOWN", 0, 0);
            UNKNOWN = r0;
            RoleType r1 = new RoleType("OWNER", 1, 1);
            OWNER = r1;
            RoleType r3 = new RoleType("ADMIN", 2, 2);
            ADMIN = r3;
            RoleType[] r5 = {r0, r1, r3};
            a = r5;
            b = EnumEntriesKt.enumEntries(r5);
            Companion = new b();
            ADAPTER = new a(Reflection.getOrCreateKotlinClass(RoleType.class), Syntax.PROTO_2, r0);
        }

        public static RoleType[] values() {
            return (RoleType[]) a.clone();
        }

        @Override // com.lark.wire.o0
        public int getValue() {
            return this.value;
        }

        @JvmStatic
        public static final RoleType fromValue(int r1) {
            Companion.getClass();
            if (r1 == 0) goto L12;
            if (r1 == 1) goto L15;
            if (r1 == 2) goto L14;
            return null;
        L14:
            return ADMIN;
        L15:
            return OWNER;
        L12:
            return UNKNOWN;
        }

        public static RoleType valueOf(String r1) {
            return (RoleType) r27.a.a(RoleType.class, r1);
        }

        public RoleType(String r1, int r2, int r3) {
            super(r1, r2);
            this.value = r3;
        }
    }

    public static final class a extends com.lark.wire.Message.a<TeamRole, a> {
        public RoleType d;

        @Override // com.lark.wire.Message.a
        public final com.lark.wire.Message b() {
            return new TeamRole(this, c(), null);
        }

        public a() {
        }
    }

    public static final class b extends ProtoAdapter<TeamRole> {
        @Override // com.lark.wire.ProtoAdapter
        public final TeamRole c(g0 r9) {
            Intrinsics.checkNotNullParameter(r9, "reader");
            a r0 = new a();
            long r1 = r9.c();
        L3:
            int r3 = r9.e();
            if (r3 == (-1)) goto L13;
            if (r3 != 1) goto L11;
            r0.d = RoleType.ADAPTER.c(r9);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L9
        L9:
            e = move-exception;
            r9.a(r3, FieldEncoding.VARINT, Long.valueOf(e.value));
            Unit r4 = Unit.INSTANCE;
            goto L3
        L11:
            r9.j(r3);
            goto L3
        L13:
            return new TeamRole(r0, r9.d(r1), null);
        }

        @Override // com.lark.wire.ProtoAdapter
        public final int k(TeamRole r4) {
            TeamRole r5 = r4;
            Intrinsics.checkNotNullParameter(r5, "value");
            return r5.unknownFields().size() + RoleType.ADAPTER.l(1, r5.getRole_type());
        }

        @Override // com.lark.wire.ProtoAdapter
        public final void f(j0 r4, TeamRole r5) {
            TeamRole r6 = r5;
            Intrinsics.checkNotNullParameter(r4, "writer");
            Intrinsics.checkNotNullParameter(r6, "value");
            RoleType.ADAPTER.i(r4, 1, r6.getRole_type());
            r4.a(r6.unknownFields());
        }

        @Override // com.lark.wire.ProtoAdapter
        public final void g(n0 r3, TeamRole r4) {
            TeamRole r5 = r4;
            Intrinsics.checkNotNullParameter(r3, "writer");
            Intrinsics.checkNotNullParameter(r5, "value");
            r3.d(r5.unknownFields());
            RoleType.ADAPTER.j(r3, 1, r5.getRole_type());
        }

        public b(FieldEncoding r7, KClass<TeamRole> r8, Syntax r9) {
            super(r7, r8, "type.googleapis.com/basic.v1.TeamRole", r9, null);
        }
    }

    public static final class c {
        public c() {
        }
    }

    public /* synthetic */ TeamRole(a r1, ByteString r2, DefaultConstructorMarker r3) {
        this(r1, r2);
    }

    static {
        Companion = new c();
        ADAPTER = new b(FieldEncoding.LENGTH_DELIMITED, Reflection.getOrCreateKotlinClass(TeamRole.class), Syntax.PROTO_2);
    }

    @Override // com.lark.wire.Message
    public a newBuilder() {
        a r0 = new a();
        r0.d = this.role_type;
        r0.a(unknownFields());
        return r0;
    }

    @Override // com.lark.wire.Message
    public String toString() {
        return Reflection.getOrCreateKotlinClass(TeamRole.class).getSimpleName() + '@' + hashCode();
    }

    public final RoleType getRole_type() {
        return this.role_type;
    }

    @Override // com.lark.wire.Message
    public /* bridge */ /* synthetic */ com.lark.wire.Message.a newBuilder() {
        return newBuilder();
    }

    public TeamRole(a r2, ByteString r3) {
        super(ADAPTER, r3);
        this.role_type = r2.d;
    }

    public /* synthetic */ TeamRole(a r1, ByteString r2, int r3, DefaultConstructorMarker r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = ByteString.EMPTY;
    L5:
        this(r1, r2);
    }
}
