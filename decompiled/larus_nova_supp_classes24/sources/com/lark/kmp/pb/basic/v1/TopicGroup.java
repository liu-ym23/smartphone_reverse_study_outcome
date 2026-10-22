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
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u0000 \u00172\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00020\u0001:\u0004\u0016\u0017\u0018\u0019B\u001b\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\b\u0010\u0014\u001a\u00020\u0002H\u0016J\b\u0010\u0015\u001a\u00020\tH\u0016R\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\f\u001a\u00020\r¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0013\u0010\u0010\u001a\u0004\u0018\u00010\u0011¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013¨\u0006\u001a"}, d2 = {"Lcom/lark/kmp/pb/basic/v1/TopicGroup;", "Lcom/lark/wire/Message;", "Lcom/lark/kmp/pb/basic/v1/TopicGroup$Builder;", "builder", "unknownFields", "Lokio/ByteString;", "<init>", "(Lcom/lark/kmp/pb/basic/v1/TopicGroup$Builder;Lokio/ByteString;)V", "id", "", "getId", "()Ljava/lang/String;", "type", "Lcom/lark/kmp/pb/basic/v1/TopicGroup$Type;", "getType", "()Lcom/lark/kmp/pb/basic/v1/TopicGroup$Type;", "user_setting", "Lcom/lark/kmp/pb/basic/v1/TopicGroup$UserSetting;", "getUser_setting", "()Lcom/lark/kmp/pb/basic/v1/TopicGroup$UserSetting;", "newBuilder", "toString", "Builder", "Companion", "Type", "UserSetting", "rust-sdk-kotlin-pb_release"}, k = 1, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
public final class TopicGroup extends com.lark.wire.Message<TopicGroup, a> {
    public static final ProtoAdapter<TopicGroup> ADAPTER = null;
    public static final c Companion = null;
    private static final long serialVersionUID = 0;
    private final String id;
    private final Type type;
    private final UserSetting user_setting;

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\n\b\u0086\u0081\u0002\u0018\u0000 \r2\u00020\u00012\b\u0012\u0004\u0012\u00020\u00000\u0002:\u0001\rB\u0011\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u0004X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\f¨\u0006\u000e"}, d2 = {"Lcom/lark/kmp/pb/basic/v1/TopicGroup$Type;", "Lcom/lark/wire/WireEnum;", "", "value", "", "<init>", "(Ljava/lang/String;II)V", "getValue", "()I", "UNKNOWN_TYPE", "NORMAL", "DEFAULT", "PUBLIC", "Companion", "rust-sdk-kotlin-pb_release"}, k = 1, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
    public static final enum Type extends Enum<Type> implements o0 {
        public static final ProtoAdapter<Type> ADAPTER = null;
        public static final b Companion = null;
        public static final Type DEFAULT = null;
        public static final Type NORMAL = null;
        public static final Type PUBLIC = null;
        public static final Type UNKNOWN_TYPE = null;
        public static final /* synthetic */ Type[] a = null;
        public static final /* synthetic */ EnumEntries b = null;
        private final int value;

        public static final class a extends d<Type> {
            @Override // com.lark.wire.d
            public final o0 n(int r2) {
                Type.Companion.getClass();
                if (r2 == 0) goto L15;
                if (r2 == 1) goto L19;
                if (r2 == 2) goto L18;
                if (r2 == 3) goto L17;
                return null;
            L17:
                return Type.PUBLIC;
            L18:
                return Type.DEFAULT;
            L19:
                return Type.NORMAL;
            L15:
                return Type.UNKNOWN_TYPE;
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
            Type r0 = new Type("UNKNOWN_TYPE", 0, 0);
            UNKNOWN_TYPE = r0;
            Type r1 = new Type("NORMAL", 1, 1);
            NORMAL = r1;
            Type r3 = new Type("DEFAULT", 2, 2);
            DEFAULT = r3;
            Type r5 = new Type("PUBLIC", 3, 3);
            PUBLIC = r5;
            Type[] r7 = {r0, r1, r3, r5};
            a = r7;
            b = EnumEntriesKt.enumEntries(r7);
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
            if (r1 == 0) goto L15;
            if (r1 == 1) goto L19;
            if (r1 == 2) goto L18;
            if (r1 == 3) goto L17;
            return null;
        L17:
            return PUBLIC;
        L18:
            return DEFAULT;
        L19:
            return NORMAL;
        L15:
            return UNKNOWN_TYPE;
        }

        public static Type valueOf(String r1) {
            return (Type) r27.a.a(Type.class, r1);
        }

        public Type(String r1, int r2, int r3) {
            super(r1, r2);
            this.value = r3;
        }
    }

    @Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0003\u0018\u0000 \u00192\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00020\u0001:\u0002\u0018\u0019B\u001b\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\b\u0010\u0015\u001a\u00020\u0002H\u0016J\b\u0010\u0016\u001a\u00020\u0017H\u0016R\u0015\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\n\n\u0002\u0010\u000b\u001a\u0004\b\b\u0010\nR\u0015\u0010\f\u001a\u0004\u0018\u00010\r¢\u0006\n\n\u0002\u0010\u0010\u001a\u0004\b\u000e\u0010\u000fR\u0013\u0010\u0011\u001a\u0004\u0018\u00010\u0012¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014¨\u0006\u001a"}, d2 = {"Lcom/lark/kmp/pb/basic/v1/TopicGroup$UserSetting;", "Lcom/lark/wire/Message;", "Lcom/lark/kmp/pb/basic/v1/TopicGroup$UserSetting$Builder;", "builder", "unknownFields", "Lokio/ByteString;", "<init>", "(Lcom/lark/kmp/pb/basic/v1/TopicGroup$UserSetting$Builder;Lokio/ByteString;)V", "is_favorite", "", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "update_time", "", "getUpdate_time", "()Ljava/lang/Long;", "Ljava/lang/Long;", "topic_group_role", "Lcom/lark/kmp/pb/basic/v1/TopicGroupRole;", "getTopic_group_role", "()Lcom/lark/kmp/pb/basic/v1/TopicGroupRole;", "newBuilder", "toString", "", "Builder", "Companion", "rust-sdk-kotlin-pb_release"}, k = 1, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
    public static final class UserSetting extends com.lark.wire.Message<UserSetting, a> {
        public static final ProtoAdapter<UserSetting> ADAPTER = null;
        public static final c Companion = null;
        private static final long serialVersionUID = 0;
        private final Boolean is_favorite;
        private final TopicGroupRole topic_group_role;
        private final Long update_time;

        public static final class a extends com.lark.wire.Message.a<UserSetting, a> {
            public Boolean d;
            public Long e;
            public TopicGroupRole f;

            @Override // com.lark.wire.Message.a
            public final com.lark.wire.Message b() {
                return new UserSetting(this, c(), null);
            }

            public a() {
            }
        }

        public static final class b extends ProtoAdapter<UserSetting> {
            @Override // com.lark.wire.ProtoAdapter
            public final UserSetting c(g0 r9) {
                Intrinsics.checkNotNullParameter(r9, "reader");
                a r0 = new a();
                long r1 = r9.c();
            L3:
                int r3 = r9.e();
                if (r3 == (-1)) goto L19;
                if (r3 != 1) goto L8;
                r0.d = (Boolean) ProtoAdapter.g.c(r9);
                goto L3
            L8:
                if (r3 != 2) goto L10;
                r0.e = (Long) ProtoAdapter.k.c(r9);
                goto L3
            L10:
                if (r3 != 3) goto L11;
                r0.f = TopicGroupRole.ADAPTER.c(r9);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L14
            L14:
                e = move-exception;
                r9.a(r3, FieldEncoding.VARINT, Long.valueOf(e.value));
                Unit r4 = Unit.INSTANCE;
                goto L3
            L11:
                r9.j(r3);
                goto L3
            L19:
                return new UserSetting(r0, r9.d(r1), null);
            }

            @Override // com.lark.wire.ProtoAdapter
            public final int k(UserSetting r5) {
                UserSetting r6 = r5;
                Intrinsics.checkNotNullParameter(r6, "value");
                return ((r6.unknownFields().size() + ProtoAdapter.g.l(1, r6.is_favorite())) + ProtoAdapter.k.l(2, r6.getUpdate_time())) + TopicGroupRole.ADAPTER.l(3, r6.getTopic_group_role());
            }

            @Override // com.lark.wire.ProtoAdapter
            public final void f(j0 r4, UserSetting r5) {
                UserSetting r6 = r5;
                Intrinsics.checkNotNullParameter(r4, "writer");
                Intrinsics.checkNotNullParameter(r6, "value");
                ProtoAdapter.g.i(r4, 1, r6.is_favorite());
                ProtoAdapter.k.i(r4, 2, r6.getUpdate_time());
                TopicGroupRole.ADAPTER.i(r4, 3, r6.getTopic_group_role());
                r4.a(r6.unknownFields());
            }

            @Override // com.lark.wire.ProtoAdapter
            public final void g(n0 r4, UserSetting r5) {
                UserSetting r6 = r5;
                Intrinsics.checkNotNullParameter(r4, "writer");
                Intrinsics.checkNotNullParameter(r6, "value");
                r4.d(r6.unknownFields());
                TopicGroupRole.ADAPTER.j(r4, 3, r6.getTopic_group_role());
                ProtoAdapter.k.j(r4, 2, r6.getUpdate_time());
                ProtoAdapter.g.j(r4, 1, r6.is_favorite());
            }

            public b(FieldEncoding r7, KClass<UserSetting> r8, Syntax r9) {
                super(r7, r8, "type.googleapis.com/basic.v1.TopicGroup.UserSetting", r9, null);
            }
        }

        public static final class c {
            public c() {
            }
        }

        public /* synthetic */ UserSetting(a r1, ByteString r2, DefaultConstructorMarker r3) {
            this(r1, r2);
        }

        static {
            Companion = new c();
            ADAPTER = new b(FieldEncoding.LENGTH_DELIMITED, Reflection.getOrCreateKotlinClass(UserSetting.class), Syntax.PROTO_2);
        }

        @Override // com.lark.wire.Message
        public a newBuilder() {
            a r0 = new a();
            r0.d = this.is_favorite;
            r0.e = this.update_time;
            r0.f = this.topic_group_role;
            r0.a(unknownFields());
            return r0;
        }

        @Override // com.lark.wire.Message
        public String toString() {
            return Reflection.getOrCreateKotlinClass(UserSetting.class).getSimpleName() + '@' + hashCode();
        }

        public final TopicGroupRole getTopic_group_role() {
            return this.topic_group_role;
        }

        public final Long getUpdate_time() {
            return this.update_time;
        }

        public final Boolean is_favorite() {
            return this.is_favorite;
        }

        @Override // com.lark.wire.Message
        public /* bridge */ /* synthetic */ com.lark.wire.Message.a newBuilder() {
            return newBuilder();
        }

        public UserSetting(a r2, ByteString r3) {
            super(ADAPTER, r3);
            this.is_favorite = r2.d;
            this.update_time = r2.e;
            this.topic_group_role = r2.f;
        }

        public /* synthetic */ UserSetting(a r1, ByteString r2, int r3, DefaultConstructorMarker r4) {
            if ((r3 & 2) == 0) goto L5;
            r2 = ByteString.EMPTY;
        L5:
            this(r1, r2);
        }
    }

    public static final class a extends com.lark.wire.Message.a<TopicGroup, a> {
        public String d;
        public Type e;
        public UserSetting f;

        @Override // com.lark.wire.Message.a
        public final com.lark.wire.Message b() {
            return new TopicGroup(this, c(), null);
        }

        public a() {
        }
    }

    public static final class b extends ProtoAdapter<TopicGroup> {
        @Override // com.lark.wire.ProtoAdapter
        public final TopicGroup c(g0 r10) {
            Intrinsics.checkNotNullParameter(r10, "reader");
            a r1 = new a();
            long r2 = r10.c();
        L3:
            int r4 = r10.e();
            if (r4 == (-1)) goto L19;
            if (r4 != 1) goto L8;
            ProtoAdapter.q.getClass();
            Intrinsics.checkNotNullParameter(r10, "reader");
            String r5 = r10.i();
            Intrinsics.checkNotNullParameter(r5, "id");
            r1.d = r5;
            goto L3
        L8:
            if (r4 != 2) goto L10;
            Type r6 = Type.ADAPTER.c(r10);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L15
            Intrinsics.checkNotNullParameter(r6, "type");     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L15
            r1.e = r6;     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L15
        L15:
            e = move-exception;
            r10.a(r4, FieldEncoding.VARINT, Long.valueOf(e.value));
            Unit r7 = Unit.INSTANCE;
            goto L3
        L10:
            if (r4 != 3) goto L11;
            r1.f = UserSetting.ADAPTER.c(r10);
            goto L3
        L11:
            r10.j(r4);
            goto L3
        L19:
            return new TopicGroup(r1, r10.d(r2), null);
        }

        @Override // com.lark.wire.ProtoAdapter
        public final int k(TopicGroup r5) {
            TopicGroup r6 = r5;
            Intrinsics.checkNotNullParameter(r6, "value");
            return ((r6.unknownFields().size() + ProtoAdapter.q.l(1, r6.getId())) + Type.ADAPTER.l(2, r6.getType())) + UserSetting.ADAPTER.l(3, r6.getUser_setting());
        }

        @Override // com.lark.wire.ProtoAdapter
        public final void f(j0 r4, TopicGroup r5) {
            TopicGroup r6 = r5;
            Intrinsics.checkNotNullParameter(r4, "writer");
            Intrinsics.checkNotNullParameter(r6, "value");
            ProtoAdapter.q.i(r4, 1, r6.getId());
            Type.ADAPTER.i(r4, 2, r6.getType());
            UserSetting.ADAPTER.i(r4, 3, r6.getUser_setting());
            r4.a(r6.unknownFields());
        }

        @Override // com.lark.wire.ProtoAdapter
        public final void g(n0 r4, TopicGroup r5) {
            TopicGroup r6 = r5;
            Intrinsics.checkNotNullParameter(r4, "writer");
            Intrinsics.checkNotNullParameter(r6, "value");
            r4.d(r6.unknownFields());
            UserSetting.ADAPTER.j(r4, 3, r6.getUser_setting());
            Type.ADAPTER.j(r4, 2, r6.getType());
            ProtoAdapter.q.j(r4, 1, r6.getId());
        }

        public b(FieldEncoding r7, KClass<TopicGroup> r8, Syntax r9) {
            super(r7, r8, "type.googleapis.com/basic.v1.TopicGroup", r9, null);
        }
    }

    public static final class c {
        public c() {
        }
    }

    public /* synthetic */ TopicGroup(a r1, ByteString r2, DefaultConstructorMarker r3) {
        this(r1, r2);
    }

    static {
        Companion = new c();
        ADAPTER = new b(FieldEncoding.LENGTH_DELIMITED, Reflection.getOrCreateKotlinClass(TopicGroup.class), Syntax.PROTO_2);
    }

    @Override // com.lark.wire.Message
    public a newBuilder() {
        a r0 = new a();
        r0.d = this.id;
        r0.e = this.type;
        r0.f = this.user_setting;
        r0.a(unknownFields());
        return r0;
    }

    @Override // com.lark.wire.Message
    public String toString() {
        return Reflection.getOrCreateKotlinClass(TopicGroup.class).getSimpleName() + '@' + hashCode();
    }

    public final String getId() {
        return this.id;
    }

    public final Type getType() {
        return this.type;
    }

    public final UserSetting getUser_setting() {
        return this.user_setting;
    }

    @Override // com.lark.wire.Message
    public /* bridge */ /* synthetic */ com.lark.wire.Message.a newBuilder() {
        return newBuilder();
    }

    public TopicGroup(a r2, ByteString r3) {
        super(ADAPTER, r3);
        String r4 = r2.d;
        Intrinsics.checkNotNull(r4);
        this.id = r4;
        Type r5 = r2.e;
        Intrinsics.checkNotNull(r5);
        this.type = r5;
        this.user_setting = r2.f;
    }

    public /* synthetic */ TopicGroup(a r1, ByteString r2, int r3, DefaultConstructorMarker r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = ByteString.EMPTY;
    L5:
        this(r1, r2);
    }
}
