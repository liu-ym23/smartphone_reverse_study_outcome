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
import kotlin.Deprecated;
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
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\b\u0018\u0000 $2\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00020\u0001:\u0007#$%&'()B\u001b\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\b\u0010 \u001a\u00020\u0002H\u0016J\b\u0010!\u001a\u00020\"H\u0016R\u001e\u0010\b\u001a\u0004\u0018\u00010\t8\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\rR\u001e\u0010\u000e\u001a\u0004\u0018\u00010\u000f8\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0010\u0010\u000b\u001a\u0004\b\u0011\u0010\u0012R\u001e\u0010\u0013\u001a\u0004\u0018\u00010\u00148\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0015\u0010\u000b\u001a\u0004\b\u0016\u0010\u0017R\u0013\u0010\u0018\u001a\u0004\u0018\u00010\u0019¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u001bR\u0013\u0010\u001c\u001a\u0004\u0018\u00010\u001d¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001f¨\u0006*"}, d2 = {"Lcom/lark/kmp/pb/basic/v1/TeamSetting;", "Lcom/lark/wire/Message;", "Lcom/lark/kmp/pb/basic/v1/TeamSetting$Builder;", "builder", "unknownFields", "Lokio/ByteString;", "<init>", "(Lcom/lark/kmp/pb/basic/v1/TeamSetting$Builder;Lokio/ByteString;)V", "add_member_permission", "Lcom/lark/kmp/pb/basic/v1/TeamSetting$AddMemberPermission$Type;", "getAdd_member_permission$annotations", "()V", "getAdd_member_permission", "()Lcom/lark/kmp/pb/basic/v1/TeamSetting$AddMemberPermission$Type;", "create_team_chat_permission", "Lcom/lark/kmp/pb/basic/v1/TeamSetting$CreateTeamChatPermission$Type;", "getCreate_team_chat_permission$annotations", "getCreate_team_chat_permission", "()Lcom/lark/kmp/pb/basic/v1/TeamSetting$CreateTeamChatPermission$Type;", "bind_team_chat_permission", "Lcom/lark/kmp/pb/basic/v1/TeamSetting$BindTeamChatPermission$Type;", "getBind_team_chat_permission$annotations", "getBind_team_chat_permission", "()Lcom/lark/kmp/pb/basic/v1/TeamSetting$BindTeamChatPermission$Type;", "add_team_chat_permission", "Lcom/lark/kmp/pb/basic/v1/TeamSetting$AddTeamChatPermission$Type;", "getAdd_team_chat_permission", "()Lcom/lark/kmp/pb/basic/v1/TeamSetting$AddTeamChatPermission$Type;", "add_private_team_chat_permission", "Lcom/lark/kmp/pb/basic/v1/TeamSetting$AddPrivateTeamChatPermission$Type;", "getAdd_private_team_chat_permission", "()Lcom/lark/kmp/pb/basic/v1/TeamSetting$AddPrivateTeamChatPermission$Type;", "newBuilder", "toString", "", "Builder", "Companion", "AddMemberPermission", "CreateTeamChatPermission", "BindTeamChatPermission", "AddTeamChatPermission", "AddPrivateTeamChatPermission", "rust-sdk-kotlin-pb_release"}, k = 1, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
public final class TeamSetting extends com.lark.wire.Message<TeamSetting, a> {
    public static final ProtoAdapter<TeamSetting> ADAPTER = null;
    public static final c Companion = null;
    private static final long serialVersionUID = 0;
    private final AddMemberPermission.Type add_member_permission;
    private final AddPrivateTeamChatPermission.Type add_private_team_chat_permission;
    private final AddTeamChatPermission.Type add_team_chat_permission;
    private final BindTeamChatPermission.Type bind_team_chat_permission;
    private final CreateTeamChatPermission.Type create_team_chat_permission;

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0004\u0018\u0000 \f2\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00020\u0001:\u0003\u000b\f\rB\u001b\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\b\u0010\b\u001a\u00020\u0002H\u0016J\b\u0010\t\u001a\u00020\nH\u0016¨\u0006\u000e"}, d2 = {"Lcom/lark/kmp/pb/basic/v1/TeamSetting$AddMemberPermission;", "Lcom/lark/wire/Message;", "Lcom/lark/kmp/pb/basic/v1/TeamSetting$AddMemberPermission$Builder;", "builder", "unknownFields", "Lokio/ByteString;", "<init>", "(Lcom/lark/kmp/pb/basic/v1/TeamSetting$AddMemberPermission$Builder;Lokio/ByteString;)V", "newBuilder", "toString", "", "Builder", "Companion", "Type", "rust-sdk-kotlin-pb_release"}, k = 1, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
    public static final class AddMemberPermission extends com.lark.wire.Message<AddMemberPermission, a> {
        public static final ProtoAdapter<AddMemberPermission> ADAPTER = null;
        public static final c Companion = null;
        private static final long serialVersionUID = 0;

        @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\t\b\u0086\u0081\u0002\u0018\u0000 \f2\u00020\u00012\b\u0012\u0004\u0012\u00020\u00000\u0002:\u0001\fB\u0011\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u0004X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000b¨\u0006\r"}, d2 = {"Lcom/lark/kmp/pb/basic/v1/TeamSetting$AddMemberPermission$Type;", "Lcom/lark/wire/WireEnum;", "", "value", "", "<init>", "(Ljava/lang/String;II)V", "getValue", "()I", "UNKNOWN", "ALL_MEMBERS", "ONLY_OWNER", "Companion", "rust-sdk-kotlin-pb_release"}, k = 1, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
        public static final enum Type extends Enum<Type> implements o0 {
            public static final ProtoAdapter<Type> ADAPTER = null;
            public static final Type ALL_MEMBERS = null;
            public static final b Companion = null;
            public static final Type ONLY_OWNER = null;
            public static final Type UNKNOWN = null;
            public static final /* synthetic */ Type[] a = null;
            public static final /* synthetic */ EnumEntries b = null;
            private final int value;

            public static final class a extends d<Type> {
                @Override // com.lark.wire.d
                public final o0 n(int r2) {
                    Type.Companion.getClass();
                    if (r2 == 0) goto L12;
                    if (r2 == 1) goto L15;
                    if (r2 == 2) goto L14;
                    return null;
                L14:
                    return Type.ONLY_OWNER;
                L15:
                    return Type.ALL_MEMBERS;
                L12:
                    return Type.UNKNOWN;
                }

                public a(KClass<Type> r1, Syntax r2, Type r3) {
                    super(r1, r2, r3);
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
                Type r0 = new Type("UNKNOWN", 0, 0);
                UNKNOWN = r0;
                Type r1 = new Type("ALL_MEMBERS", 1, 1);
                ALL_MEMBERS = r1;
                Type r3 = new Type("ONLY_OWNER", 2, 2);
                ONLY_OWNER = r3;
                Type[] r5 = {r0, r1, r3};
                a = r5;
                b = EnumEntriesKt.enumEntries(r5);
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

            @JvmStatic
            public static final Type fromValue(int r1) {
                Companion.getClass();
                if (r1 == 0) goto L12;
                if (r1 == 1) goto L15;
                if (r1 == 2) goto L14;
                return null;
            L14:
                return ONLY_OWNER;
            L15:
                return ALL_MEMBERS;
            L12:
                return UNKNOWN;
            }

            public static Type valueOf(String r1) {
                return (Type) r27.a.a(Type.class, r1);
            }

            public Type(String r1, int r2, int r3) {
                super(r1, r2);
                this.value = r3;
            }
        }

        public static final class a extends com.lark.wire.Message.a<AddMemberPermission, a> {
            @Override // com.lark.wire.Message.a
            public final com.lark.wire.Message b() {
                return new AddMemberPermission(this, c(), null);
            }

            public a() {
            }
        }

        public static final class b extends ProtoAdapter<AddMemberPermission> {
            @Override // com.lark.wire.ProtoAdapter
            public final AddMemberPermission c(g0 r6) {
                Intrinsics.checkNotNullParameter(r6, "reader");
                a r0 = new a();
                long r1 = r6.c();
            L3:
                int r3 = r6.e();
                if (r3 == (-1)) goto L7;
                r6.j(r3);
                goto L3
            L7:
                return new AddMemberPermission(r0, r6.d(r1), null);
            }

            @Override // com.lark.wire.ProtoAdapter
            public final int k(AddMemberPermission r2) {
                AddMemberPermission r3 = r2;
                Intrinsics.checkNotNullParameter(r3, "value");
                return r3.unknownFields().size();
            }

            @Override // com.lark.wire.ProtoAdapter
            public final void f(j0 r2, AddMemberPermission r3) {
                AddMemberPermission r4 = r3;
                Intrinsics.checkNotNullParameter(r2, "writer");
                Intrinsics.checkNotNullParameter(r4, "value");
                r2.a(r4.unknownFields());
            }

            @Override // com.lark.wire.ProtoAdapter
            public final void g(n0 r2, AddMemberPermission r3) {
                AddMemberPermission r4 = r3;
                Intrinsics.checkNotNullParameter(r2, "writer");
                Intrinsics.checkNotNullParameter(r4, "value");
                r2.d(r4.unknownFields());
            }

            public b(FieldEncoding r7, KClass<AddMemberPermission> r8, Syntax r9) {
                super(r7, r8, "type.googleapis.com/basic.v1.TeamSetting.AddMemberPermission", r9, null);
            }
        }

        public static final class c {
            public c() {
            }
        }

        public /* synthetic */ AddMemberPermission(a r1, ByteString r2, DefaultConstructorMarker r3) {
            this(r2);
        }

        static {
            Companion = new c();
            ADAPTER = new b(FieldEncoding.LENGTH_DELIMITED, Reflection.getOrCreateKotlinClass(AddMemberPermission.class), Syntax.PROTO_2);
        }

        @Override // com.lark.wire.Message
        public a newBuilder() {
            a r0 = new a();
            r0.a(unknownFields());
            return r0;
        }

        @Override // com.lark.wire.Message
        public String toString() {
            return Reflection.getOrCreateKotlinClass(AddMemberPermission.class).getSimpleName() + '@' + hashCode();
        }

        @Override // com.lark.wire.Message
        public /* bridge */ /* synthetic */ com.lark.wire.Message.a newBuilder() {
            return newBuilder();
        }

        public AddMemberPermission(ByteString r2) {
            super(ADAPTER, r2);
        }

        public /* synthetic */ AddMemberPermission(a r1, ByteString r2, int r3, DefaultConstructorMarker r4) {
            if ((r3 & 2) == 0) goto L5;
            r2 = ByteString.EMPTY;
        L5:
            this(r2);
        }
    }

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0004\u0018\u0000 \f2\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00020\u0001:\u0003\u000b\f\rB\u001b\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\b\u0010\b\u001a\u00020\u0002H\u0016J\b\u0010\t\u001a\u00020\nH\u0016¨\u0006\u000e"}, d2 = {"Lcom/lark/kmp/pb/basic/v1/TeamSetting$AddPrivateTeamChatPermission;", "Lcom/lark/wire/Message;", "Lcom/lark/kmp/pb/basic/v1/TeamSetting$AddPrivateTeamChatPermission$Builder;", "builder", "unknownFields", "Lokio/ByteString;", "<init>", "(Lcom/lark/kmp/pb/basic/v1/TeamSetting$AddPrivateTeamChatPermission$Builder;Lokio/ByteString;)V", "newBuilder", "toString", "", "Builder", "Companion", "Type", "rust-sdk-kotlin-pb_release"}, k = 1, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
    public static final class AddPrivateTeamChatPermission extends com.lark.wire.Message<AddPrivateTeamChatPermission, a> {
        public static final ProtoAdapter<AddPrivateTeamChatPermission> ADAPTER = null;
        public static final c Companion = null;
        private static final long serialVersionUID = 0;

        @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\t\b\u0086\u0081\u0002\u0018\u0000 \f2\u00020\u00012\b\u0012\u0004\u0012\u00020\u00000\u0002:\u0001\fB\u0011\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u0004X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000b¨\u0006\r"}, d2 = {"Lcom/lark/kmp/pb/basic/v1/TeamSetting$AddPrivateTeamChatPermission$Type;", "Lcom/lark/wire/WireEnum;", "", "value", "", "<init>", "(Ljava/lang/String;II)V", "getValue", "()I", "UNKNOWN", "ALL_MEMBERS", "ONLY_MANAGER", "Companion", "rust-sdk-kotlin-pb_release"}, k = 1, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
        public static final enum Type extends Enum<Type> implements o0 {
            public static final ProtoAdapter<Type> ADAPTER = null;
            public static final Type ALL_MEMBERS = null;
            public static final b Companion = null;
            public static final Type ONLY_MANAGER = null;
            public static final Type UNKNOWN = null;
            public static final /* synthetic */ Type[] a = null;
            public static final /* synthetic */ EnumEntries b = null;
            private final int value;

            public static final class a extends d<Type> {
                @Override // com.lark.wire.d
                public final o0 n(int r2) {
                    Type.Companion.getClass();
                    if (r2 == 0) goto L12;
                    if (r2 == 1) goto L15;
                    if (r2 == 2) goto L14;
                    return null;
                L14:
                    return Type.ONLY_MANAGER;
                L15:
                    return Type.ALL_MEMBERS;
                L12:
                    return Type.UNKNOWN;
                }

                public a(KClass<Type> r1, Syntax r2, Type r3) {
                    super(r1, r2, r3);
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
                Type r0 = new Type("UNKNOWN", 0, 0);
                UNKNOWN = r0;
                Type r1 = new Type("ALL_MEMBERS", 1, 1);
                ALL_MEMBERS = r1;
                Type r3 = new Type("ONLY_MANAGER", 2, 2);
                ONLY_MANAGER = r3;
                Type[] r5 = {r0, r1, r3};
                a = r5;
                b = EnumEntriesKt.enumEntries(r5);
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

            @JvmStatic
            public static final Type fromValue(int r1) {
                Companion.getClass();
                if (r1 == 0) goto L12;
                if (r1 == 1) goto L15;
                if (r1 == 2) goto L14;
                return null;
            L14:
                return ONLY_MANAGER;
            L15:
                return ALL_MEMBERS;
            L12:
                return UNKNOWN;
            }

            public static Type valueOf(String r1) {
                return (Type) r27.a.a(Type.class, r1);
            }

            public Type(String r1, int r2, int r3) {
                super(r1, r2);
                this.value = r3;
            }
        }

        public static final class a extends com.lark.wire.Message.a<AddPrivateTeamChatPermission, a> {
            @Override // com.lark.wire.Message.a
            public final com.lark.wire.Message b() {
                return new AddPrivateTeamChatPermission(this, c(), null);
            }

            public a() {
            }
        }

        public static final class b extends ProtoAdapter<AddPrivateTeamChatPermission> {
            @Override // com.lark.wire.ProtoAdapter
            public final AddPrivateTeamChatPermission c(g0 r6) {
                Intrinsics.checkNotNullParameter(r6, "reader");
                a r0 = new a();
                long r1 = r6.c();
            L3:
                int r3 = r6.e();
                if (r3 == (-1)) goto L7;
                r6.j(r3);
                goto L3
            L7:
                return new AddPrivateTeamChatPermission(r0, r6.d(r1), null);
            }

            @Override // com.lark.wire.ProtoAdapter
            public final int k(AddPrivateTeamChatPermission r2) {
                AddPrivateTeamChatPermission r3 = r2;
                Intrinsics.checkNotNullParameter(r3, "value");
                return r3.unknownFields().size();
            }

            @Override // com.lark.wire.ProtoAdapter
            public final void f(j0 r2, AddPrivateTeamChatPermission r3) {
                AddPrivateTeamChatPermission r4 = r3;
                Intrinsics.checkNotNullParameter(r2, "writer");
                Intrinsics.checkNotNullParameter(r4, "value");
                r2.a(r4.unknownFields());
            }

            @Override // com.lark.wire.ProtoAdapter
            public final void g(n0 r2, AddPrivateTeamChatPermission r3) {
                AddPrivateTeamChatPermission r4 = r3;
                Intrinsics.checkNotNullParameter(r2, "writer");
                Intrinsics.checkNotNullParameter(r4, "value");
                r2.d(r4.unknownFields());
            }

            public b(FieldEncoding r7, KClass<AddPrivateTeamChatPermission> r8, Syntax r9) {
                super(r7, r8, "type.googleapis.com/basic.v1.TeamSetting.AddPrivateTeamChatPermission", r9, null);
            }
        }

        public static final class c {
            public c() {
            }
        }

        public /* synthetic */ AddPrivateTeamChatPermission(a r1, ByteString r2, DefaultConstructorMarker r3) {
            this(r2);
        }

        static {
            Companion = new c();
            ADAPTER = new b(FieldEncoding.LENGTH_DELIMITED, Reflection.getOrCreateKotlinClass(AddPrivateTeamChatPermission.class), Syntax.PROTO_2);
        }

        @Override // com.lark.wire.Message
        public a newBuilder() {
            a r0 = new a();
            r0.a(unknownFields());
            return r0;
        }

        @Override // com.lark.wire.Message
        public String toString() {
            return Reflection.getOrCreateKotlinClass(AddPrivateTeamChatPermission.class).getSimpleName() + '@' + hashCode();
        }

        @Override // com.lark.wire.Message
        public /* bridge */ /* synthetic */ com.lark.wire.Message.a newBuilder() {
            return newBuilder();
        }

        public AddPrivateTeamChatPermission(ByteString r2) {
            super(ADAPTER, r2);
        }

        public /* synthetic */ AddPrivateTeamChatPermission(a r1, ByteString r2, int r3, DefaultConstructorMarker r4) {
            if ((r3 & 2) == 0) goto L5;
            r2 = ByteString.EMPTY;
        L5:
            this(r2);
        }
    }

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0004\u0018\u0000 \f2\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00020\u0001:\u0003\u000b\f\rB\u001b\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\b\u0010\b\u001a\u00020\u0002H\u0016J\b\u0010\t\u001a\u00020\nH\u0016¨\u0006\u000e"}, d2 = {"Lcom/lark/kmp/pb/basic/v1/TeamSetting$AddTeamChatPermission;", "Lcom/lark/wire/Message;", "Lcom/lark/kmp/pb/basic/v1/TeamSetting$AddTeamChatPermission$Builder;", "builder", "unknownFields", "Lokio/ByteString;", "<init>", "(Lcom/lark/kmp/pb/basic/v1/TeamSetting$AddTeamChatPermission$Builder;Lokio/ByteString;)V", "newBuilder", "toString", "", "Builder", "Companion", "Type", "rust-sdk-kotlin-pb_release"}, k = 1, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
    public static final class AddTeamChatPermission extends com.lark.wire.Message<AddTeamChatPermission, a> {
        public static final ProtoAdapter<AddTeamChatPermission> ADAPTER = null;
        public static final c Companion = null;
        private static final long serialVersionUID = 0;

        @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\t\b\u0086\u0081\u0002\u0018\u0000 \f2\u00020\u00012\b\u0012\u0004\u0012\u00020\u00000\u0002:\u0001\fB\u0011\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u0004X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000b¨\u0006\r"}, d2 = {"Lcom/lark/kmp/pb/basic/v1/TeamSetting$AddTeamChatPermission$Type;", "Lcom/lark/wire/WireEnum;", "", "value", "", "<init>", "(Ljava/lang/String;II)V", "getValue", "()I", "UNKNOWN", "ALL_MEMBERS", "ONLY_MANAGER", "Companion", "rust-sdk-kotlin-pb_release"}, k = 1, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
        public static final enum Type extends Enum<Type> implements o0 {
            public static final ProtoAdapter<Type> ADAPTER = null;
            public static final Type ALL_MEMBERS = null;
            public static final b Companion = null;
            public static final Type ONLY_MANAGER = null;
            public static final Type UNKNOWN = null;
            public static final /* synthetic */ Type[] a = null;
            public static final /* synthetic */ EnumEntries b = null;
            private final int value;

            public static final class a extends d<Type> {
                @Override // com.lark.wire.d
                public final o0 n(int r2) {
                    Type.Companion.getClass();
                    if (r2 == 0) goto L12;
                    if (r2 == 1) goto L15;
                    if (r2 == 2) goto L14;
                    return null;
                L14:
                    return Type.ONLY_MANAGER;
                L15:
                    return Type.ALL_MEMBERS;
                L12:
                    return Type.UNKNOWN;
                }

                public a(KClass<Type> r1, Syntax r2, Type r3) {
                    super(r1, r2, r3);
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
                Type r0 = new Type("UNKNOWN", 0, 0);
                UNKNOWN = r0;
                Type r1 = new Type("ALL_MEMBERS", 1, 1);
                ALL_MEMBERS = r1;
                Type r3 = new Type("ONLY_MANAGER", 2, 2);
                ONLY_MANAGER = r3;
                Type[] r5 = {r0, r1, r3};
                a = r5;
                b = EnumEntriesKt.enumEntries(r5);
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

            @JvmStatic
            public static final Type fromValue(int r1) {
                Companion.getClass();
                if (r1 == 0) goto L12;
                if (r1 == 1) goto L15;
                if (r1 == 2) goto L14;
                return null;
            L14:
                return ONLY_MANAGER;
            L15:
                return ALL_MEMBERS;
            L12:
                return UNKNOWN;
            }

            public static Type valueOf(String r1) {
                return (Type) r27.a.a(Type.class, r1);
            }

            public Type(String r1, int r2, int r3) {
                super(r1, r2);
                this.value = r3;
            }
        }

        public static final class a extends com.lark.wire.Message.a<AddTeamChatPermission, a> {
            @Override // com.lark.wire.Message.a
            public final com.lark.wire.Message b() {
                return new AddTeamChatPermission(this, c(), null);
            }

            public a() {
            }
        }

        public static final class b extends ProtoAdapter<AddTeamChatPermission> {
            @Override // com.lark.wire.ProtoAdapter
            public final AddTeamChatPermission c(g0 r6) {
                Intrinsics.checkNotNullParameter(r6, "reader");
                a r0 = new a();
                long r1 = r6.c();
            L3:
                int r3 = r6.e();
                if (r3 == (-1)) goto L7;
                r6.j(r3);
                goto L3
            L7:
                return new AddTeamChatPermission(r0, r6.d(r1), null);
            }

            @Override // com.lark.wire.ProtoAdapter
            public final int k(AddTeamChatPermission r2) {
                AddTeamChatPermission r3 = r2;
                Intrinsics.checkNotNullParameter(r3, "value");
                return r3.unknownFields().size();
            }

            @Override // com.lark.wire.ProtoAdapter
            public final void f(j0 r2, AddTeamChatPermission r3) {
                AddTeamChatPermission r4 = r3;
                Intrinsics.checkNotNullParameter(r2, "writer");
                Intrinsics.checkNotNullParameter(r4, "value");
                r2.a(r4.unknownFields());
            }

            @Override // com.lark.wire.ProtoAdapter
            public final void g(n0 r2, AddTeamChatPermission r3) {
                AddTeamChatPermission r4 = r3;
                Intrinsics.checkNotNullParameter(r2, "writer");
                Intrinsics.checkNotNullParameter(r4, "value");
                r2.d(r4.unknownFields());
            }

            public b(FieldEncoding r7, KClass<AddTeamChatPermission> r8, Syntax r9) {
                super(r7, r8, "type.googleapis.com/basic.v1.TeamSetting.AddTeamChatPermission", r9, null);
            }
        }

        public static final class c {
            public c() {
            }
        }

        public /* synthetic */ AddTeamChatPermission(a r1, ByteString r2, DefaultConstructorMarker r3) {
            this(r2);
        }

        static {
            Companion = new c();
            ADAPTER = new b(FieldEncoding.LENGTH_DELIMITED, Reflection.getOrCreateKotlinClass(AddTeamChatPermission.class), Syntax.PROTO_2);
        }

        @Override // com.lark.wire.Message
        public a newBuilder() {
            a r0 = new a();
            r0.a(unknownFields());
            return r0;
        }

        @Override // com.lark.wire.Message
        public String toString() {
            return Reflection.getOrCreateKotlinClass(AddTeamChatPermission.class).getSimpleName() + '@' + hashCode();
        }

        @Override // com.lark.wire.Message
        public /* bridge */ /* synthetic */ com.lark.wire.Message.a newBuilder() {
            return newBuilder();
        }

        public AddTeamChatPermission(ByteString r2) {
            super(ADAPTER, r2);
        }

        public /* synthetic */ AddTeamChatPermission(a r1, ByteString r2, int r3, DefaultConstructorMarker r4) {
            if ((r3 & 2) == 0) goto L5;
            r2 = ByteString.EMPTY;
        L5:
            this(r2);
        }
    }

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0004\u0018\u0000 \f2\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00020\u0001:\u0003\u000b\f\rB\u001b\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\b\u0010\b\u001a\u00020\u0002H\u0016J\b\u0010\t\u001a\u00020\nH\u0016¨\u0006\u000e"}, d2 = {"Lcom/lark/kmp/pb/basic/v1/TeamSetting$BindTeamChatPermission;", "Lcom/lark/wire/Message;", "Lcom/lark/kmp/pb/basic/v1/TeamSetting$BindTeamChatPermission$Builder;", "builder", "unknownFields", "Lokio/ByteString;", "<init>", "(Lcom/lark/kmp/pb/basic/v1/TeamSetting$BindTeamChatPermission$Builder;Lokio/ByteString;)V", "newBuilder", "toString", "", "Builder", "Companion", "Type", "rust-sdk-kotlin-pb_release"}, k = 1, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
    public static final class BindTeamChatPermission extends com.lark.wire.Message<BindTeamChatPermission, a> {
        public static final ProtoAdapter<BindTeamChatPermission> ADAPTER = null;
        public static final c Companion = null;
        private static final long serialVersionUID = 0;

        @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\t\b\u0086\u0081\u0002\u0018\u0000 \f2\u00020\u00012\b\u0012\u0004\u0012\u00020\u00000\u0002:\u0001\fB\u0011\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u0004X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000b¨\u0006\r"}, d2 = {"Lcom/lark/kmp/pb/basic/v1/TeamSetting$BindTeamChatPermission$Type;", "Lcom/lark/wire/WireEnum;", "", "value", "", "<init>", "(Ljava/lang/String;II)V", "getValue", "()I", "BIND_TEAM_CHAT_PERMISSION_UNKNOWN", "BIND_TEAM_CHAT_PERMISSION_ALL_MEMBERS", "BIND_TEAM_CHAT_PERMISSION_ONLY_OWNER", "Companion", "rust-sdk-kotlin-pb_release"}, k = 1, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
        public static final enum Type extends Enum<Type> implements o0 {
            public static final ProtoAdapter<Type> ADAPTER = null;
            public static final Type BIND_TEAM_CHAT_PERMISSION_ALL_MEMBERS = null;
            public static final Type BIND_TEAM_CHAT_PERMISSION_ONLY_OWNER = null;
            public static final Type BIND_TEAM_CHAT_PERMISSION_UNKNOWN = null;
            public static final b Companion = null;
            public static final /* synthetic */ Type[] a = null;
            public static final /* synthetic */ EnumEntries b = null;
            private final int value;

            public static final class a extends d<Type> {
                @Override // com.lark.wire.d
                public final o0 n(int r2) {
                    Type.Companion.getClass();
                    if (r2 == 0) goto L12;
                    if (r2 == 1) goto L15;
                    if (r2 == 2) goto L14;
                    return null;
                L14:
                    return Type.BIND_TEAM_CHAT_PERMISSION_ONLY_OWNER;
                L15:
                    return Type.BIND_TEAM_CHAT_PERMISSION_ALL_MEMBERS;
                L12:
                    return Type.BIND_TEAM_CHAT_PERMISSION_UNKNOWN;
                }

                public a(KClass<Type> r1, Syntax r2, Type r3) {
                    super(r1, r2, r3);
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
                Type r0 = new Type("BIND_TEAM_CHAT_PERMISSION_UNKNOWN", 0, 0);
                BIND_TEAM_CHAT_PERMISSION_UNKNOWN = r0;
                Type r1 = new Type("BIND_TEAM_CHAT_PERMISSION_ALL_MEMBERS", 1, 1);
                BIND_TEAM_CHAT_PERMISSION_ALL_MEMBERS = r1;
                Type r3 = new Type("BIND_TEAM_CHAT_PERMISSION_ONLY_OWNER", 2, 2);
                BIND_TEAM_CHAT_PERMISSION_ONLY_OWNER = r3;
                Type[] r5 = {r0, r1, r3};
                a = r5;
                b = EnumEntriesKt.enumEntries(r5);
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

            @JvmStatic
            public static final Type fromValue(int r1) {
                Companion.getClass();
                if (r1 == 0) goto L12;
                if (r1 == 1) goto L15;
                if (r1 == 2) goto L14;
                return null;
            L14:
                return BIND_TEAM_CHAT_PERMISSION_ONLY_OWNER;
            L15:
                return BIND_TEAM_CHAT_PERMISSION_ALL_MEMBERS;
            L12:
                return BIND_TEAM_CHAT_PERMISSION_UNKNOWN;
            }

            public static Type valueOf(String r1) {
                return (Type) r27.a.a(Type.class, r1);
            }

            public Type(String r1, int r2, int r3) {
                super(r1, r2);
                this.value = r3;
            }
        }

        public static final class a extends com.lark.wire.Message.a<BindTeamChatPermission, a> {
            @Override // com.lark.wire.Message.a
            public final com.lark.wire.Message b() {
                return new BindTeamChatPermission(this, c(), null);
            }

            public a() {
            }
        }

        public static final class b extends ProtoAdapter<BindTeamChatPermission> {
            @Override // com.lark.wire.ProtoAdapter
            public final BindTeamChatPermission c(g0 r6) {
                Intrinsics.checkNotNullParameter(r6, "reader");
                a r0 = new a();
                long r1 = r6.c();
            L3:
                int r3 = r6.e();
                if (r3 == (-1)) goto L7;
                r6.j(r3);
                goto L3
            L7:
                return new BindTeamChatPermission(r0, r6.d(r1), null);
            }

            @Override // com.lark.wire.ProtoAdapter
            public final int k(BindTeamChatPermission r2) {
                BindTeamChatPermission r3 = r2;
                Intrinsics.checkNotNullParameter(r3, "value");
                return r3.unknownFields().size();
            }

            @Override // com.lark.wire.ProtoAdapter
            public final void f(j0 r2, BindTeamChatPermission r3) {
                BindTeamChatPermission r4 = r3;
                Intrinsics.checkNotNullParameter(r2, "writer");
                Intrinsics.checkNotNullParameter(r4, "value");
                r2.a(r4.unknownFields());
            }

            @Override // com.lark.wire.ProtoAdapter
            public final void g(n0 r2, BindTeamChatPermission r3) {
                BindTeamChatPermission r4 = r3;
                Intrinsics.checkNotNullParameter(r2, "writer");
                Intrinsics.checkNotNullParameter(r4, "value");
                r2.d(r4.unknownFields());
            }

            public b(FieldEncoding r7, KClass<BindTeamChatPermission> r8, Syntax r9) {
                super(r7, r8, "type.googleapis.com/basic.v1.TeamSetting.BindTeamChatPermission", r9, null);
            }
        }

        public static final class c {
            public c() {
            }
        }

        public /* synthetic */ BindTeamChatPermission(a r1, ByteString r2, DefaultConstructorMarker r3) {
            this(r2);
        }

        static {
            Companion = new c();
            ADAPTER = new b(FieldEncoding.LENGTH_DELIMITED, Reflection.getOrCreateKotlinClass(BindTeamChatPermission.class), Syntax.PROTO_2);
        }

        @Override // com.lark.wire.Message
        public a newBuilder() {
            a r0 = new a();
            r0.a(unknownFields());
            return r0;
        }

        @Override // com.lark.wire.Message
        public String toString() {
            return Reflection.getOrCreateKotlinClass(BindTeamChatPermission.class).getSimpleName() + '@' + hashCode();
        }

        @Override // com.lark.wire.Message
        public /* bridge */ /* synthetic */ com.lark.wire.Message.a newBuilder() {
            return newBuilder();
        }

        public BindTeamChatPermission(ByteString r2) {
            super(ADAPTER, r2);
        }

        public /* synthetic */ BindTeamChatPermission(a r1, ByteString r2, int r3, DefaultConstructorMarker r4) {
            if ((r3 & 2) == 0) goto L5;
            r2 = ByteString.EMPTY;
        L5:
            this(r2);
        }
    }

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0004\u0018\u0000 \f2\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00020\u0001:\u0003\u000b\f\rB\u001b\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\b\u0010\b\u001a\u00020\u0002H\u0016J\b\u0010\t\u001a\u00020\nH\u0016¨\u0006\u000e"}, d2 = {"Lcom/lark/kmp/pb/basic/v1/TeamSetting$CreateTeamChatPermission;", "Lcom/lark/wire/Message;", "Lcom/lark/kmp/pb/basic/v1/TeamSetting$CreateTeamChatPermission$Builder;", "builder", "unknownFields", "Lokio/ByteString;", "<init>", "(Lcom/lark/kmp/pb/basic/v1/TeamSetting$CreateTeamChatPermission$Builder;Lokio/ByteString;)V", "newBuilder", "toString", "", "Builder", "Companion", "Type", "rust-sdk-kotlin-pb_release"}, k = 1, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
    public static final class CreateTeamChatPermission extends com.lark.wire.Message<CreateTeamChatPermission, a> {
        public static final ProtoAdapter<CreateTeamChatPermission> ADAPTER = null;
        public static final c Companion = null;
        private static final long serialVersionUID = 0;

        @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\t\b\u0086\u0081\u0002\u0018\u0000 \f2\u00020\u00012\b\u0012\u0004\u0012\u00020\u00000\u0002:\u0001\fB\u0011\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u0004X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000b¨\u0006\r"}, d2 = {"Lcom/lark/kmp/pb/basic/v1/TeamSetting$CreateTeamChatPermission$Type;", "Lcom/lark/wire/WireEnum;", "", "value", "", "<init>", "(Ljava/lang/String;II)V", "getValue", "()I", "UNKNOWN", "ALL_MEMBERS", "ONLY_OWNER", "Companion", "rust-sdk-kotlin-pb_release"}, k = 1, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
        public static final enum Type extends Enum<Type> implements o0 {
            public static final ProtoAdapter<Type> ADAPTER = null;
            public static final Type ALL_MEMBERS = null;
            public static final b Companion = null;
            public static final Type ONLY_OWNER = null;
            public static final Type UNKNOWN = null;
            public static final /* synthetic */ Type[] a = null;
            public static final /* synthetic */ EnumEntries b = null;
            private final int value;

            public static final class a extends d<Type> {
                @Override // com.lark.wire.d
                public final o0 n(int r2) {
                    Type.Companion.getClass();
                    if (r2 == 0) goto L12;
                    if (r2 == 1) goto L15;
                    if (r2 == 2) goto L14;
                    return null;
                L14:
                    return Type.ONLY_OWNER;
                L15:
                    return Type.ALL_MEMBERS;
                L12:
                    return Type.UNKNOWN;
                }

                public a(KClass<Type> r1, Syntax r2, Type r3) {
                    super(r1, r2, r3);
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
                Type r0 = new Type("UNKNOWN", 0, 0);
                UNKNOWN = r0;
                Type r1 = new Type("ALL_MEMBERS", 1, 1);
                ALL_MEMBERS = r1;
                Type r3 = new Type("ONLY_OWNER", 2, 2);
                ONLY_OWNER = r3;
                Type[] r5 = {r0, r1, r3};
                a = r5;
                b = EnumEntriesKt.enumEntries(r5);
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

            @JvmStatic
            public static final Type fromValue(int r1) {
                Companion.getClass();
                if (r1 == 0) goto L12;
                if (r1 == 1) goto L15;
                if (r1 == 2) goto L14;
                return null;
            L14:
                return ONLY_OWNER;
            L15:
                return ALL_MEMBERS;
            L12:
                return UNKNOWN;
            }

            public static Type valueOf(String r1) {
                return (Type) r27.a.a(Type.class, r1);
            }

            public Type(String r1, int r2, int r3) {
                super(r1, r2);
                this.value = r3;
            }
        }

        public static final class a extends com.lark.wire.Message.a<CreateTeamChatPermission, a> {
            @Override // com.lark.wire.Message.a
            public final com.lark.wire.Message b() {
                return new CreateTeamChatPermission(this, c(), null);
            }

            public a() {
            }
        }

        public static final class b extends ProtoAdapter<CreateTeamChatPermission> {
            @Override // com.lark.wire.ProtoAdapter
            public final CreateTeamChatPermission c(g0 r6) {
                Intrinsics.checkNotNullParameter(r6, "reader");
                a r0 = new a();
                long r1 = r6.c();
            L3:
                int r3 = r6.e();
                if (r3 == (-1)) goto L7;
                r6.j(r3);
                goto L3
            L7:
                return new CreateTeamChatPermission(r0, r6.d(r1), null);
            }

            @Override // com.lark.wire.ProtoAdapter
            public final int k(CreateTeamChatPermission r2) {
                CreateTeamChatPermission r3 = r2;
                Intrinsics.checkNotNullParameter(r3, "value");
                return r3.unknownFields().size();
            }

            @Override // com.lark.wire.ProtoAdapter
            public final void f(j0 r2, CreateTeamChatPermission r3) {
                CreateTeamChatPermission r4 = r3;
                Intrinsics.checkNotNullParameter(r2, "writer");
                Intrinsics.checkNotNullParameter(r4, "value");
                r2.a(r4.unknownFields());
            }

            @Override // com.lark.wire.ProtoAdapter
            public final void g(n0 r2, CreateTeamChatPermission r3) {
                CreateTeamChatPermission r4 = r3;
                Intrinsics.checkNotNullParameter(r2, "writer");
                Intrinsics.checkNotNullParameter(r4, "value");
                r2.d(r4.unknownFields());
            }

            public b(FieldEncoding r7, KClass<CreateTeamChatPermission> r8, Syntax r9) {
                super(r7, r8, "type.googleapis.com/basic.v1.TeamSetting.CreateTeamChatPermission", r9, null);
            }
        }

        public static final class c {
            public c() {
            }
        }

        public /* synthetic */ CreateTeamChatPermission(a r1, ByteString r2, DefaultConstructorMarker r3) {
            this(r2);
        }

        static {
            Companion = new c();
            ADAPTER = new b(FieldEncoding.LENGTH_DELIMITED, Reflection.getOrCreateKotlinClass(CreateTeamChatPermission.class), Syntax.PROTO_2);
        }

        @Override // com.lark.wire.Message
        public a newBuilder() {
            a r0 = new a();
            r0.a(unknownFields());
            return r0;
        }

        @Override // com.lark.wire.Message
        public String toString() {
            return Reflection.getOrCreateKotlinClass(CreateTeamChatPermission.class).getSimpleName() + '@' + hashCode();
        }

        @Override // com.lark.wire.Message
        public /* bridge */ /* synthetic */ com.lark.wire.Message.a newBuilder() {
            return newBuilder();
        }

        public CreateTeamChatPermission(ByteString r2) {
            super(ADAPTER, r2);
        }

        public /* synthetic */ CreateTeamChatPermission(a r1, ByteString r2, int r3, DefaultConstructorMarker r4) {
            if ((r3 & 2) == 0) goto L5;
            r2 = ByteString.EMPTY;
        L5:
            this(r2);
        }
    }

    public static final class a extends com.lark.wire.Message.a<TeamSetting, a> {
        public AddMemberPermission.Type d;
        public CreateTeamChatPermission.Type e;
        public BindTeamChatPermission.Type f;
        public AddTeamChatPermission.Type g;
        public AddPrivateTeamChatPermission.Type h;

        @Override // com.lark.wire.Message.a
        public final com.lark.wire.Message b() {
            return new TeamSetting(this, c(), null);
        }

        public a() {
        }
    }

    public static final class b extends ProtoAdapter<TeamSetting> {
        @Override // com.lark.wire.ProtoAdapter
        public final TeamSetting c(g0 r9) {
            Intrinsics.checkNotNullParameter(r9, "reader");
            a r0 = new a();
            long r1 = r9.c();
        L3:
            int r3 = r9.e();
            if (r3 == (-1)) goto L37;
            if (r3 != 1) goto L8;
            r0.d = AddMemberPermission.Type.ADAPTER.c(r9);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L34
        L34:
            e = move-exception;
            r9.a(r3, FieldEncoding.VARINT, Long.valueOf(e.value));
            Unit r4 = Unit.INSTANCE;
            goto L3
        L8:
            if (r3 != 2) goto L10;
            r0.e = CreateTeamChatPermission.Type.ADAPTER.c(r9);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L30
        L30:
            e = move-exception;
            r9.a(r3, FieldEncoding.VARINT, Long.valueOf(e.value));
            Unit r5 = Unit.INSTANCE;
            goto L3
        L10:
            if (r3 != 3) goto L12;
            r0.f = BindTeamChatPermission.Type.ADAPTER.c(r9);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L26
        L26:
            e = move-exception;
            r9.a(r3, FieldEncoding.VARINT, Long.valueOf(e.value));
            Unit r6 = Unit.INSTANCE;
            goto L3
        L12:
            if (r3 != 4) goto L14;
            r0.g = AddTeamChatPermission.Type.ADAPTER.c(r9);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L22
        L22:
            e = move-exception;
            r9.a(r3, FieldEncoding.VARINT, Long.valueOf(e.value));
            Unit r7 = Unit.INSTANCE;
            goto L3
        L14:
            if (r3 != 5) goto L15;
            r0.h = AddPrivateTeamChatPermission.Type.ADAPTER.c(r9);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L18
        L18:
            e = move-exception;
            r9.a(r3, FieldEncoding.VARINT, Long.valueOf(e.value));
            Unit r8 = Unit.INSTANCE;
            goto L3
        L15:
            r9.j(r3);
            goto L3
        L37:
            return new TeamSetting(r0, r9.d(r1), null);
        }

        @Override // com.lark.wire.ProtoAdapter
        public final int k(TeamSetting r5) {
            TeamSetting r6 = r5;
            Intrinsics.checkNotNullParameter(r6, "value");
            return ((((r6.unknownFields().size() + AddMemberPermission.Type.ADAPTER.l(1, r6.getAdd_member_permission())) + CreateTeamChatPermission.Type.ADAPTER.l(2, r6.getCreate_team_chat_permission())) + BindTeamChatPermission.Type.ADAPTER.l(3, r6.getBind_team_chat_permission())) + AddTeamChatPermission.Type.ADAPTER.l(4, r6.getAdd_team_chat_permission())) + AddPrivateTeamChatPermission.Type.ADAPTER.l(5, r6.getAdd_private_team_chat_permission());
        }

        @Override // com.lark.wire.ProtoAdapter
        public final void f(j0 r4, TeamSetting r5) {
            TeamSetting r6 = r5;
            Intrinsics.checkNotNullParameter(r4, "writer");
            Intrinsics.checkNotNullParameter(r6, "value");
            AddMemberPermission.Type.ADAPTER.i(r4, 1, r6.getAdd_member_permission());
            CreateTeamChatPermission.Type.ADAPTER.i(r4, 2, r6.getCreate_team_chat_permission());
            BindTeamChatPermission.Type.ADAPTER.i(r4, 3, r6.getBind_team_chat_permission());
            AddTeamChatPermission.Type.ADAPTER.i(r4, 4, r6.getAdd_team_chat_permission());
            AddPrivateTeamChatPermission.Type.ADAPTER.i(r4, 5, r6.getAdd_private_team_chat_permission());
            r4.a(r6.unknownFields());
        }

        @Override // com.lark.wire.ProtoAdapter
        public final void g(n0 r4, TeamSetting r5) {
            TeamSetting r6 = r5;
            Intrinsics.checkNotNullParameter(r4, "writer");
            Intrinsics.checkNotNullParameter(r6, "value");
            r4.d(r6.unknownFields());
            AddPrivateTeamChatPermission.Type.ADAPTER.j(r4, 5, r6.getAdd_private_team_chat_permission());
            AddTeamChatPermission.Type.ADAPTER.j(r4, 4, r6.getAdd_team_chat_permission());
            BindTeamChatPermission.Type.ADAPTER.j(r4, 3, r6.getBind_team_chat_permission());
            CreateTeamChatPermission.Type.ADAPTER.j(r4, 2, r6.getCreate_team_chat_permission());
            AddMemberPermission.Type.ADAPTER.j(r4, 1, r6.getAdd_member_permission());
        }

        public b(FieldEncoding r7, KClass<TeamSetting> r8, Syntax r9) {
            super(r7, r8, "type.googleapis.com/basic.v1.TeamSetting", r9, null);
        }
    }

    public static final class c {
        public c() {
        }
    }

    public /* synthetic */ TeamSetting(a r1, ByteString r2, DefaultConstructorMarker r3) {
        this(r1, r2);
    }

    @Deprecated(message = "add_member_permission is deprecated")
    public static /* synthetic */ void getAdd_member_permission$annotations() {
    }

    @Deprecated(message = "bind_team_chat_permission is deprecated")
    public static /* synthetic */ void getBind_team_chat_permission$annotations() {
    }

    @Deprecated(message = "create_team_chat_permission is deprecated")
    public static /* synthetic */ void getCreate_team_chat_permission$annotations() {
    }

    static {
        Companion = new c();
        ADAPTER = new b(FieldEncoding.LENGTH_DELIMITED, Reflection.getOrCreateKotlinClass(TeamSetting.class), Syntax.PROTO_2);
    }

    @Override // com.lark.wire.Message
    public a newBuilder() {
        a r0 = new a();
        r0.d = this.add_member_permission;
        r0.e = this.create_team_chat_permission;
        r0.f = this.bind_team_chat_permission;
        r0.g = this.add_team_chat_permission;
        r0.h = this.add_private_team_chat_permission;
        r0.a(unknownFields());
        return r0;
    }

    @Override // com.lark.wire.Message
    public String toString() {
        return Reflection.getOrCreateKotlinClass(TeamSetting.class).getSimpleName() + '@' + hashCode();
    }

    public final AddMemberPermission.Type getAdd_member_permission() {
        return this.add_member_permission;
    }

    public final AddPrivateTeamChatPermission.Type getAdd_private_team_chat_permission() {
        return this.add_private_team_chat_permission;
    }

    public final AddTeamChatPermission.Type getAdd_team_chat_permission() {
        return this.add_team_chat_permission;
    }

    public final BindTeamChatPermission.Type getBind_team_chat_permission() {
        return this.bind_team_chat_permission;
    }

    public final CreateTeamChatPermission.Type getCreate_team_chat_permission() {
        return this.create_team_chat_permission;
    }

    @Override // com.lark.wire.Message
    public /* bridge */ /* synthetic */ com.lark.wire.Message.a newBuilder() {
        return newBuilder();
    }

    public TeamSetting(a r2, ByteString r3) {
        super(ADAPTER, r3);
        this.add_member_permission = r2.d;
        this.create_team_chat_permission = r2.e;
        this.bind_team_chat_permission = r2.f;
        this.add_team_chat_permission = r2.g;
        this.add_private_team_chat_permission = r2.h;
    }

    public /* synthetic */ TeamSetting(a r1, ByteString r2, int r3, DefaultConstructorMarker r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = ByteString.EMPTY;
    L5:
        this(r1, r2);
    }
}
