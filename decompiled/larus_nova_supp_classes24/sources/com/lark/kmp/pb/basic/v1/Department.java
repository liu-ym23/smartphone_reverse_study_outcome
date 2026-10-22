package com.lark.kmp.pb.basic.v1;

import com.lark.wire.FieldEncoding;
import com.lark.wire.ProtoAdapter;
import com.lark.wire.Syntax;
import com.lark.wire.g0;
import com.lark.wire.j0;
import com.lark.wire.l;
import com.lark.wire.n0;
import com.lark.wire.s;
import com.lark.wire.w;
import com.larksuite.component.universe_design.timepicker.impl.base.WheelView;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClass;
import okio.ByteString;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u000e\u0018\u0000 )2\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00020\u0001:\u0002()B\u001b\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\b\u0010&\u001a\u00020\u0002H\u0016J\b\u0010'\u001a\u00020\tH\u0016R\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\f\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000bR\u0013\u0010\u000e\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000bR\u0013\u0010\u0010\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u000bR\u0015\u0010\u0012\u001a\u0004\u0018\u00010\u0013¢\u0006\n\n\u0002\u0010\u0016\u001a\u0004\b\u0014\u0010\u0015R\u0013\u0010\u0017\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u000bR\u0013\u0010\u0019\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u000bR\u0015\u0010\u001b\u001a\u0004\u0018\u00010\u001c¢\u0006\n\n\u0002\u0010\u001f\u001a\u0004\b\u001d\u0010\u001eR \u0010 \u001a\u0004\u0018\u00010\u001c8\u0006X\u0087\u0004¢\u0006\u0010\n\u0002\u0010\u001f\u0012\u0004\b!\u0010\"\u001a\u0004\b#\u0010\u001eR\u0015\u0010$\u001a\u0004\u0018\u00010\u0013¢\u0006\n\n\u0002\u0010\u0016\u001a\u0004\b%\u0010\u0015¨\u0006*"}, d2 = {"Lcom/lark/kmp/pb/basic/v1/Department;", "Lcom/lark/wire/Message;", "Lcom/lark/kmp/pb/basic/v1/Department$Builder;", "builder", "unknownFields", "Lokio/ByteString;", "<init>", "(Lcom/lark/kmp/pb/basic/v1/Department$Builder;Lokio/ByteString;)V", "id", "", "getId", "()Ljava/lang/String;", "name", "getName", "parent_id", "getParent_id", "leader_id", "getLeader_id", "member_count", "", "getMember_count", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "ref_parent_id", "getRef_parent_id", "chat_id", "getChat_id", "has_sub_departments", "", "getHas_sub_departments", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "can_create_department", "getCan_create_department$annotations", "()V", "getCan_create_department", "member_count_by_display_rule", "getMember_count_by_display_rule", "newBuilder", "toString", "Builder", "Companion", "rust-sdk-kotlin-pb_release"}, k = 1, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
public final class Department extends com.lark.wire.Message<Department, a> {
    public static final ProtoAdapter<Department> ADAPTER = null;
    public static final c Companion = null;
    public static final boolean DEFAULT_CAN_CREATE_DEPARTMENT = false;
    public static final String DEFAULT_LEADER_ID = "";
    public static final int DEFAULT_MEMBER_COUNT = 0;
    public static final int DEFAULT_MEMBER_COUNT_BY_DISPLAY_RULE = 0;
    public static final String DEFAULT_PARENT_ID = "";
    public static final String DEFAULT_REF_PARENT_ID = "";
    private static final long serialVersionUID = 0;
    private final Boolean can_create_department;
    private final String chat_id;
    private final Boolean has_sub_departments;
    private final String id;
    private final String leader_id;
    private final Integer member_count;
    private final Integer member_count_by_display_rule;
    private final String name;
    private final String parent_id;
    private final String ref_parent_id;

    public static final class a extends com.lark.wire.Message.a<Department, a> {
        public String d;
        public String e;
        public String f;
        public String g;
        public Integer h;
        public String i;
        public String j;
        public Boolean k;
        public Boolean l;
        public Integer m;

        @Override // com.lark.wire.Message.a
        public final com.lark.wire.Message b() {
            return new Department(this, c(), null);
        }

        public a() {
        }
    }

    public static final class b extends ProtoAdapter<Department> {
        @Override // com.lark.wire.ProtoAdapter
        public final Department c(g0 r7) {
            Intrinsics.checkNotNullParameter(r7, "reader");
            a r1 = new a();
            long r2 = r7.c();
        L3:
            int r4 = r7.e();
            if (r4 == (-1)) goto L18;
            switch(r4) {
                case 1: goto L16;
                case 2: goto L15;
                case 3: goto L14;
                case 4: goto L13;
                case 5: goto L12;
                case 6: goto L11;
                case 7: goto L10;
                case 8: goto L9;
                case 9: goto L8;
                case 10: goto L7;
                default: goto L6;
            };
        L7:
            r1.m = (Integer) ProtoAdapter.h.c(r7);
            goto L3
        L8:
            r1.l = (Boolean) ProtoAdapter.g.c(r7);
            goto L3
        L9:
            r1.k = (Boolean) ProtoAdapter.g.c(r7);
            goto L3
        L10:
            ProtoAdapter.q.getClass();
            Intrinsics.checkNotNullParameter(r7, "reader");
            r1.j = r7.i();
            goto L3
        L11:
            ProtoAdapter.q.getClass();
            Intrinsics.checkNotNullParameter(r7, "reader");
            r1.i = r7.i();
            goto L3
        L12:
            r1.h = (Integer) ProtoAdapter.h.c(r7);
            goto L3
        L13:
            ProtoAdapter.q.getClass();
            Intrinsics.checkNotNullParameter(r7, "reader");
            r1.g = r7.i();
            goto L3
        L14:
            ProtoAdapter.q.getClass();
            Intrinsics.checkNotNullParameter(r7, "reader");
            r1.f = r7.i();
            goto L3
        L15:
            ProtoAdapter.q.getClass();
            Intrinsics.checkNotNullParameter(r7, "reader");
            String r5 = r7.i();
            Intrinsics.checkNotNullParameter(r5, "name");
            r1.e = r5;
            goto L3
        L16:
            ProtoAdapter.q.getClass();
            Intrinsics.checkNotNullParameter(r7, "reader");
            String r6 = r7.i();
            Intrinsics.checkNotNullParameter(r6, "id");
            r1.d = r6;
            goto L3
        L6:
            r7.j(r4);
            Unit r8 = Unit.INSTANCE;
            goto L3
        L18:
            return new Department(r1, r7.d(r2), null);
        }

        @Override // com.lark.wire.ProtoAdapter
        public final int k(Department r6) {
            Department r7 = r6;
            Intrinsics.checkNotNullParameter(r7, "value");
            int r0 = r7.unknownFields().size();
            w r1 = ProtoAdapter.q;
            int r2 = (((r0 + r1.l(1, r7.getId())) + r1.l(2, r7.getName())) + r1.l(3, r7.getParent_id())) + r1.l(4, r7.getLeader_id());
            s r3 = ProtoAdapter.h;
            int r4 = ((r2 + r3.l(5, r7.getMember_count())) + r1.l(6, r7.getRef_parent_id())) + r1.l(7, r7.getChat_id());
            l r5 = ProtoAdapter.g;
            return ((r4 + r5.l(8, r7.getHas_sub_departments())) + r5.l(9, r7.getCan_create_department())) + r3.l(10, r7.getMember_count_by_display_rule());
        }

        @Override // com.lark.wire.ProtoAdapter
        public final void f(j0 r5, Department r6) {
            Department r7 = r6;
            Intrinsics.checkNotNullParameter(r5, "writer");
            Intrinsics.checkNotNullParameter(r7, "value");
            w r0 = ProtoAdapter.q;
            r0.i(r5, 1, r7.getId());
            r0.i(r5, 2, r7.getName());
            r0.i(r5, 3, r7.getParent_id());
            r0.i(r5, 4, r7.getLeader_id());
            s r1 = ProtoAdapter.h;
            r1.i(r5, 5, r7.getMember_count());
            r0.i(r5, 6, r7.getRef_parent_id());
            r0.i(r5, 7, r7.getChat_id());
            l r2 = ProtoAdapter.g;
            r2.i(r5, 8, r7.getHas_sub_departments());
            r2.i(r5, 9, r7.getCan_create_department());
            r1.i(r5, 10, r7.getMember_count_by_display_rule());
            r5.a(r7.unknownFields());
        }

        @Override // com.lark.wire.ProtoAdapter
        public final void g(n0 r5, Department r6) {
            Department r7 = r6;
            Intrinsics.checkNotNullParameter(r5, "writer");
            Intrinsics.checkNotNullParameter(r7, "value");
            r5.d(r7.unknownFields());
            s r0 = ProtoAdapter.h;
            r0.j(r5, 10, r7.getMember_count_by_display_rule());
            l r1 = ProtoAdapter.g;
            r1.j(r5, 9, r7.getCan_create_department());
            r1.j(r5, 8, r7.getHas_sub_departments());
            w r2 = ProtoAdapter.q;
            r2.j(r5, 7, r7.getChat_id());
            r2.j(r5, 6, r7.getRef_parent_id());
            r0.j(r5, 5, r7.getMember_count());
            r2.j(r5, 4, r7.getLeader_id());
            r2.j(r5, 3, r7.getParent_id());
            r2.j(r5, 2, r7.getName());
            r2.j(r5, 1, r7.getId());
        }

        public b(FieldEncoding r7, KClass<Department> r8, Syntax r9) {
            super(r7, r8, "type.googleapis.com/basic.v1.Department", r9, null);
        }
    }

    public static final class c {
        public c() {
        }
    }

    public /* synthetic */ Department(a r1, ByteString r2, DefaultConstructorMarker r3) {
        this(r1, r2);
    }

    @Deprecated(message = "can_create_department is deprecated")
    public static /* synthetic */ void getCan_create_department$annotations() {
    }

    static {
        Companion = new c();
        ADAPTER = new b(FieldEncoding.LENGTH_DELIMITED, Reflection.getOrCreateKotlinClass(Department.class), Syntax.PROTO_2);
    }

    @Override // com.lark.wire.Message
    public a newBuilder() {
        a r0 = new a();
        r0.d = this.id;
        r0.e = this.name;
        r0.f = this.parent_id;
        r0.g = this.leader_id;
        r0.h = this.member_count;
        r0.i = this.ref_parent_id;
        r0.j = this.chat_id;
        r0.k = this.has_sub_departments;
        r0.l = this.can_create_department;
        r0.m = this.member_count_by_display_rule;
        r0.a(unknownFields());
        return r0;
    }

    @Override // com.lark.wire.Message
    public String toString() {
        return Reflection.getOrCreateKotlinClass(Department.class).getSimpleName() + '@' + hashCode();
    }

    public final Boolean getCan_create_department() {
        return this.can_create_department;
    }

    public final String getChat_id() {
        return this.chat_id;
    }

    public final Boolean getHas_sub_departments() {
        return this.has_sub_departments;
    }

    public final String getId() {
        return this.id;
    }

    public final String getLeader_id() {
        return this.leader_id;
    }

    public final Integer getMember_count() {
        return this.member_count;
    }

    public final Integer getMember_count_by_display_rule() {
        return this.member_count_by_display_rule;
    }

    public final String getName() {
        return this.name;
    }

    public final String getParent_id() {
        return this.parent_id;
    }

    public final String getRef_parent_id() {
        return this.ref_parent_id;
    }

    @Override // com.lark.wire.Message
    public /* bridge */ /* synthetic */ com.lark.wire.Message.a newBuilder() {
        return newBuilder();
    }

    public Department(a r2, ByteString r3) {
        super(ADAPTER, r3);
        String r4 = r2.d;
        Intrinsics.checkNotNull(r4);
        this.id = r4;
        String r5 = r2.e;
        Intrinsics.checkNotNull(r5);
        this.name = r5;
        this.parent_id = r2.f;
        this.leader_id = r2.g;
        this.member_count = r2.h;
        this.ref_parent_id = r2.i;
        this.chat_id = r2.j;
        this.has_sub_departments = r2.k;
        this.can_create_department = r2.l;
        this.member_count_by_display_rule = r2.m;
    }

    public /* synthetic */ Department(a r1, ByteString r2, int r3, DefaultConstructorMarker r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = ByteString.EMPTY;
    L5:
        this(r1, r2);
    }
}
