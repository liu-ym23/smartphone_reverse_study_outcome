package com.lark.kmp.pb.calendar.v1;

import com.lark.kmp.pb.basic.v1.ImageSet;
import com.lark.kmp.pb.basic.v1.TagData;
import com.lark.wire.FieldEncoding;
import com.lark.wire.Message;
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
@Metadata(d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u0000 E2\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00020\u0001:\u0004DEFGB\u001b\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\b\u0010B\u001a\u00020\u0002H\u0016J\b\u0010C\u001a\u00020\tH\u0016R\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\f\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000bR\u0011\u0010\u000e\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000bR\u0013\u0010\u0010\u001a\u0004\u0018\u00010\u0011¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0013\u0010\u0014\u001a\u0004\u0018\u00010\u0015¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u0013\u0010\u0018\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u000bR\u001e\u0010\u001a\u001a\u0004\u0018\u00010\u001b8\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u001c\u0010\u001d\u001a\u0004\b\u001e\u0010\u001fR\u0013\u0010 \u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\u000bR\u0013\u0010\"\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b#\u0010\u000bR\u0013\u0010$\u001a\u0004\u0018\u00010%¢\u0006\b\n\u0000\u001a\u0004\b&\u0010'R\u0013\u0010(\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b)\u0010\u000bR\u0015\u0010*\u001a\u0004\u0018\u00010+¢\u0006\n\n\u0002\u0010.\u001a\u0004\b,\u0010-R\u0013\u0010/\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b0\u0010\u000bR\u0013\u00101\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b2\u0010\u000bR\u0015\u00103\u001a\u0004\u0018\u000104¢\u0006\n\n\u0002\u00106\u001a\u0004\b3\u00105R\u0015\u00107\u001a\u0004\u0018\u000104¢\u0006\n\n\u0002\u00106\u001a\u0004\b8\u00105R\u0013\u00109\u001a\u0004\u0018\u00010:¢\u0006\b\n\u0000\u001a\u0004\b;\u0010<R\u0013\u0010=\u001a\u0004\u0018\u00010>¢\u0006\b\n\u0000\u001a\u0004\b?\u0010@R\u0015\u0010A\u001a\u0004\u0018\u000104¢\u0006\n\n\u0002\u00106\u001a\u0004\bA\u00105¨\u0006H"}, d2 = {"Lcom/lark/kmp/pb/calendar/v1/CalendarMember;", "Lcom/lark/wire/Message;", "Lcom/lark/kmp/pb/calendar/v1/CalendarMember$Builder;", "builder", "unknownFields", "Lokio/ByteString;", "<init>", "(Lcom/lark/kmp/pb/calendar/v1/CalendarMember$Builder;Lokio/ByteString;)V", "id", "", "getId", "()Ljava/lang/String;", "calendar_id", "getCalendar_id", "user_id", "getUser_id", "access_role", "Lcom/lark/kmp/pb/calendar/v1/Calendar$AccessRole;", "getAccess_role", "()Lcom/lark/kmp/pb/calendar/v1/Calendar$AccessRole;", "status", "Lcom/lark/kmp/pb/calendar/v1/Calendar$Status;", "getStatus", "()Lcom/lark/kmp/pb/calendar/v1/Calendar$Status;", "name", "getName", "avatar", "Lcom/lark/kmp/pb/basic/v1/ImageSet;", "getAvatar$annotations", "()V", "getAvatar", "()Lcom/lark/kmp/pb/basic/v1/ImageSet;", "avatar_key", "getAvatar_key", "localized_name", "getLocalized_name", "member_type", "Lcom/lark/kmp/pb/calendar/v1/CalendarMember$CalendarMemberType;", "getMember_type", "()Lcom/lark/kmp/pb/calendar/v1/CalendarMember$CalendarMemberType;", "chat_id", "getChat_id", "chat_member_count", "", "getChat_member_count", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "avatar_path", "getAvatar_path", "tenant_id", "getTenant_id", "is_cross_tenant", "", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "use_server_member_num", "getUse_server_member_num", "relation_tag", "Lcom/lark/kmp/pb/basic/v1/TagData;", "getRelation_tag", "()Lcom/lark/kmp/pb/basic/v1/TagData;", "relation_type", "Lcom/lark/kmp/pb/calendar/v1/CalendarMember$RelationType;", "getRelation_type", "()Lcom/lark/kmp/pb/calendar/v1/CalendarMember$RelationType;", "is_user_count_visible", "newBuilder", "toString", "Builder", "Companion", "CalendarMemberType", "RelationType", "rust-sdk-kotlin-pb_release"}, k = 1, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
public final class CalendarMember extends Message<CalendarMember, a> {
    public static final ProtoAdapter<CalendarMember> ADAPTER = null;
    public static final c Companion = null;
    public static final Calendar.AccessRole DEFAULT_ACCESS_ROLE = null;
    public static final String DEFAULT_CHAT_ID = "";
    public static final int DEFAULT_CHAT_MEMBER_COUNT = 0;
    public static final String DEFAULT_LOCALIZED_NAME = "";
    public static final CalendarMemberType DEFAULT_MEMBER_TYPE = null;
    public static final String DEFAULT_NAME = "";
    public static final Calendar.Status DEFAULT_STATUS = null;
    public static final boolean DEFAULT_USE_SERVER_MEMBER_NUM = false;
    private static final long serialVersionUID = 0;
    private final Calendar.AccessRole access_role;
    private final ImageSet avatar;
    private final String avatar_key;
    private final String avatar_path;
    private final String calendar_id;
    private final String chat_id;
    private final Integer chat_member_count;
    private final String id;
    private final Boolean is_cross_tenant;
    private final Boolean is_user_count_visible;
    private final String localized_name;
    private final CalendarMemberType member_type;
    private final String name;
    private final TagData relation_tag;
    private final RelationType relation_type;
    private final Calendar.Status status;
    private final String tenant_id;
    private final Boolean use_server_member_num;
    private final String user_id;

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\b\b\u0086\u0081\u0002\u0018\u0000 \u000b2\u00020\u00012\b\u0012\u0004\u0012\u00020\u00000\u0002:\u0001\u000bB\u0011\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u0004X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bj\u0002\b\tj\u0002\b\n¨\u0006\f"}, d2 = {"Lcom/lark/kmp/pb/calendar/v1/CalendarMember$CalendarMemberType;", "Lcom/lark/wire/WireEnum;", "", "value", "", "<init>", "(Ljava/lang/String;II)V", "getValue", "()I", "INDIVIDUAL", "GROUP", "Companion", "rust-sdk-kotlin-pb_release"}, k = 1, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
    public static final enum CalendarMemberType extends Enum<CalendarMemberType> implements o0 {
        public static final ProtoAdapter<CalendarMemberType> ADAPTER = null;
        public static final b Companion = null;
        public static final CalendarMemberType GROUP = null;
        public static final CalendarMemberType INDIVIDUAL = null;
        public static final /* synthetic */ CalendarMemberType[] a = null;
        public static final /* synthetic */ EnumEntries b = null;
        private final int value;

        public static final class a extends d<CalendarMemberType> {
            @Override // com.lark.wire.d
            public final o0 n(int r2) {
                CalendarMemberType.Companion.getClass();
                if (r2 == 1) goto L9;
                if (r2 == 2) goto L11;
                return null;
            L11:
                return CalendarMemberType.GROUP;
            L9:
                return CalendarMemberType.INDIVIDUAL;
            }

            public a(KClass<CalendarMemberType> r2, Syntax r3) {
                super(r2, r3, null);
            }
        }

        public static final class b {
            public b() {
            }
        }

        public static EnumEntries<CalendarMemberType> getEntries() {
            return b;
        }

        static {
            CalendarMemberType r0 = new CalendarMemberType("INDIVIDUAL", 0, 1);
            INDIVIDUAL = r0;
            CalendarMemberType r1 = new CalendarMemberType("GROUP", 1, 2);
            GROUP = r1;
            CalendarMemberType[] r4 = {r0, r1};
            a = r4;
            b = EnumEntriesKt.enumEntries(r4);
            Companion = new b();
            ADAPTER = new a(Reflection.getOrCreateKotlinClass(CalendarMemberType.class), Syntax.PROTO_2);
        }

        public static CalendarMemberType[] values() {
            return (CalendarMemberType[]) a.clone();
        }

        @Override // com.lark.wire.o0
        public int getValue() {
            return this.value;
        }

        @JvmStatic
        public static final CalendarMemberType fromValue(int r1) {
            Companion.getClass();
            if (r1 == 1) goto L9;
            if (r1 == 2) goto L11;
            return null;
        L11:
            return GROUP;
        L9:
            return INDIVIDUAL;
        }

        public static CalendarMemberType valueOf(String r1) {
            return (CalendarMemberType) r27.a.a(CalendarMemberType.class, r1);
        }

        public CalendarMemberType(String r1, int r2, int r3) {
            super(r1, r2);
            this.value = r3;
        }
    }

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\b\b\u0086\u0081\u0002\u0018\u0000 \u000b2\u00020\u00012\b\u0012\u0004\u0012\u00020\u00000\u0002:\u0001\u000bB\u0011\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u0004X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bj\u0002\b\tj\u0002\b\n¨\u0006\f"}, d2 = {"Lcom/lark/kmp/pb/calendar/v1/CalendarMember$RelationType;", "Lcom/lark/wire/WireEnum;", "", "value", "", "<init>", "(Ljava/lang/String;II)V", "getValue", "()I", "INTERNAL", "EXTERNAL", "Companion", "rust-sdk-kotlin-pb_release"}, k = 1, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
    public static final enum RelationType extends Enum<RelationType> implements o0 {
        public static final ProtoAdapter<RelationType> ADAPTER = null;
        public static final b Companion = null;
        public static final RelationType EXTERNAL = null;
        public static final RelationType INTERNAL = null;
        public static final /* synthetic */ RelationType[] a = null;
        public static final /* synthetic */ EnumEntries b = null;
        private final int value;

        public static final class a extends d<RelationType> {
            @Override // com.lark.wire.d
            public final o0 n(int r2) {
                RelationType.Companion.getClass();
                if (r2 == 0) goto L9;
                if (r2 == 1) goto L11;
                return null;
            L11:
                return RelationType.EXTERNAL;
            L9:
                return RelationType.INTERNAL;
            }

            public a(KClass<RelationType> r1, Syntax r2, RelationType r3) {
                super(r1, r2, r3);
            }
        }

        public static final class b {
            public b() {
            }
        }

        public static EnumEntries<RelationType> getEntries() {
            return b;
        }

        static {
            RelationType r0 = new RelationType("INTERNAL", 0, 0);
            INTERNAL = r0;
            RelationType r1 = new RelationType("EXTERNAL", 1, 1);
            EXTERNAL = r1;
            RelationType[] r3 = {r0, r1};
            a = r3;
            b = EnumEntriesKt.enumEntries(r3);
            Companion = new b();
            ADAPTER = new a(Reflection.getOrCreateKotlinClass(RelationType.class), Syntax.PROTO_2, r0);
        }

        public static RelationType[] values() {
            return (RelationType[]) a.clone();
        }

        @Override // com.lark.wire.o0
        public int getValue() {
            return this.value;
        }

        @JvmStatic
        public static final RelationType fromValue(int r1) {
            Companion.getClass();
            if (r1 == 0) goto L9;
            if (r1 == 1) goto L11;
            return null;
        L11:
            return EXTERNAL;
        L9:
            return INTERNAL;
        }

        public static RelationType valueOf(String r1) {
            return (RelationType) r27.a.a(RelationType.class, r1);
        }

        public RelationType(String r1, int r2, int r3) {
            super(r1, r2);
            this.value = r3;
        }
    }

    public static final class a extends Message.a<CalendarMember, a> {
        public String d;
        public String e;
        public String f;
        public Calendar.AccessRole g;
        public Calendar.Status h;
        public String i;
        public ImageSet j;
        public String k;
        public String l;
        public CalendarMemberType m;
        public String n;
        public Integer o;
        public String p;
        public String q;
        public Boolean r;
        public Boolean s;
        public TagData t;
        public RelationType u;
        public Boolean v;

        @Override // com.lark.wire.Message.a
        public final Message b() {
            return new CalendarMember(this, c(), null);
        }

        public a() {
        }
    }

    public static final class b extends ProtoAdapter<CalendarMember> {
        @Override // com.lark.wire.ProtoAdapter
        public final CalendarMember c(g0 r10) {
            Intrinsics.checkNotNullParameter(r10, "reader");
            a r1 = new a();
            long r2 = r10.c();
        L3:
            int r4 = r10.e();
            if (r4 == (-1)) goto L39;
            switch(r4) {
                case 1: goto L37;
                case 2: goto L36;
                case 3: goto L35;
                case 4: goto L46;
                case 5: goto L40;
                case 6: goto L26;
                case 7: goto L25;
                case 8: goto L24;
                case 9: goto L23;
                case 10: goto L44;
                case 11: goto L18;
                case 12: goto L17;
                case 13: goto L16;
                case 14: goto L15;
                case 15: goto L14;
                case 16: goto L13;
                case 17: goto L12;
                case 18: goto L42;
                case 19: goto L7;
                default: goto L6;
            };
        L40:
            r1.h = Calendar.Status.ADAPTER.c(r10);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L29
        L29:
            e = move-exception;
            r10.a(r4, FieldEncoding.VARINT, Long.valueOf(e.value));
            Unit r5 = Unit.INSTANCE;
            goto L3
        L42:
            r1.u = RelationType.ADAPTER.c(r10);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L10
        L10:
            e = move-exception;
            r10.a(r4, FieldEncoding.VARINT, Long.valueOf(e.value));
            Unit r6 = Unit.INSTANCE;
            goto L3
        L44:
            r1.m = CalendarMemberType.ADAPTER.c(r10);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L21
        L21:
            e = move-exception;
            r10.a(r4, FieldEncoding.VARINT, Long.valueOf(e.value));
            Unit r7 = Unit.INSTANCE;
            goto L3
        L46:
            r1.g = Calendar.AccessRole.ADAPTER.c(r10);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L33
        L33:
            e = move-exception;
            r10.a(r4, FieldEncoding.VARINT, Long.valueOf(e.value));
            Unit r8 = Unit.INSTANCE;
            goto L3
        L7:
            r1.v = (Boolean) ProtoAdapter.g.c(r10);
            goto L3
        L12:
            r1.t = TagData.ADAPTER.c(r10);
            goto L3
        L13:
            r1.s = (Boolean) ProtoAdapter.g.c(r10);
            goto L3
        L14:
            r1.r = (Boolean) ProtoAdapter.g.c(r10);
            goto L3
        L15:
            ProtoAdapter.q.getClass();
            Intrinsics.checkNotNullParameter(r10, "reader");
            r1.q = r10.i();
            goto L3
        L16:
            ProtoAdapter.q.getClass();
            Intrinsics.checkNotNullParameter(r10, "reader");
            r1.p = r10.i();
            goto L3
        L17:
            r1.o = (Integer) ProtoAdapter.h.c(r10);
            goto L3
        L18:
            ProtoAdapter.q.getClass();
            Intrinsics.checkNotNullParameter(r10, "reader");
            r1.n = r10.i();
            goto L3
        L23:
            ProtoAdapter.q.getClass();
            Intrinsics.checkNotNullParameter(r10, "reader");
            r1.l = r10.i();
            goto L3
        L24:
            ProtoAdapter.q.getClass();
            Intrinsics.checkNotNullParameter(r10, "reader");
            r1.k = r10.i();
            goto L3
        L25:
            r1.j = ImageSet.ADAPTER.c(r10);
            goto L3
        L26:
            ProtoAdapter.q.getClass();
            Intrinsics.checkNotNullParameter(r10, "reader");
            r1.i = r10.i();
            goto L3
        L35:
            ProtoAdapter.q.getClass();
            Intrinsics.checkNotNullParameter(r10, "reader");
            String r9 = r10.i();
            Intrinsics.checkNotNullParameter(r9, "user_id");
            r1.f = r9;
            goto L3
        L36:
            ProtoAdapter.q.getClass();
            Intrinsics.checkNotNullParameter(r10, "reader");
            String r11 = r10.i();
            Intrinsics.checkNotNullParameter(r11, "calendar_id");
            r1.e = r11;
            goto L3
        L37:
            ProtoAdapter.q.getClass();
            Intrinsics.checkNotNullParameter(r10, "reader");
            String r12 = r10.i();
            Intrinsics.checkNotNullParameter(r12, "id");
            r1.d = r12;
            goto L3
        L6:
            r10.j(r4);
            Unit r13 = Unit.INSTANCE;
            goto L3
        L39:
            return new CalendarMember(r1, r10.d(r2), null);
        }

        @Override // com.lark.wire.ProtoAdapter
        public final int k(CalendarMember r6) {
            CalendarMember r7 = r6;
            Intrinsics.checkNotNullParameter(r7, "value");
            int r0 = r7.unknownFields().size();
            w r1 = ProtoAdapter.q;
            int r2 = (((((((((((((r0 + r1.l(1, r7.getId())) + r1.l(2, r7.getCalendar_id())) + r1.l(3, r7.getUser_id())) + Calendar.AccessRole.ADAPTER.l(4, r7.getAccess_role())) + Calendar.Status.ADAPTER.l(5, r7.getStatus())) + r1.l(6, r7.getName())) + ImageSet.ADAPTER.l(7, r7.getAvatar())) + r1.l(8, r7.getAvatar_key())) + r1.l(9, r7.getLocalized_name())) + CalendarMemberType.ADAPTER.l(10, r7.getMember_type())) + r1.l(11, r7.getChat_id())) + ProtoAdapter.h.l(12, r7.getChat_member_count())) + r1.l(13, r7.getAvatar_path())) + r1.l(14, r7.getTenant_id());
            l r3 = ProtoAdapter.g;
            return ((((r2 + r3.l(15, r7.is_cross_tenant())) + r3.l(16, r7.getUse_server_member_num())) + TagData.ADAPTER.l(17, r7.getRelation_tag())) + RelationType.ADAPTER.l(18, r7.getRelation_type())) + r3.l(19, r7.is_user_count_visible());
        }

        @Override // com.lark.wire.ProtoAdapter
        public final void f(j0 r5, CalendarMember r6) {
            CalendarMember r7 = r6;
            Intrinsics.checkNotNullParameter(r5, "writer");
            Intrinsics.checkNotNullParameter(r7, "value");
            w r0 = ProtoAdapter.q;
            r0.i(r5, 1, r7.getId());
            r0.i(r5, 2, r7.getCalendar_id());
            r0.i(r5, 3, r7.getUser_id());
            Calendar.AccessRole.ADAPTER.i(r5, 4, r7.getAccess_role());
            Calendar.Status.ADAPTER.i(r5, 5, r7.getStatus());
            r0.i(r5, 6, r7.getName());
            ImageSet.ADAPTER.i(r5, 7, r7.getAvatar());
            r0.i(r5, 8, r7.getAvatar_key());
            r0.i(r5, 9, r7.getLocalized_name());
            CalendarMemberType.ADAPTER.i(r5, 10, r7.getMember_type());
            r0.i(r5, 11, r7.getChat_id());
            ProtoAdapter.h.i(r5, 12, r7.getChat_member_count());
            r0.i(r5, 13, r7.getAvatar_path());
            r0.i(r5, 14, r7.getTenant_id());
            l r1 = ProtoAdapter.g;
            r1.i(r5, 15, r7.is_cross_tenant());
            r1.i(r5, 16, r7.getUse_server_member_num());
            TagData.ADAPTER.i(r5, 17, r7.getRelation_tag());
            RelationType.ADAPTER.i(r5, 18, r7.getRelation_type());
            r1.i(r5, 19, r7.is_user_count_visible());
            r5.a(r7.unknownFields());
        }

        @Override // com.lark.wire.ProtoAdapter
        public final void g(n0 r5, CalendarMember r6) {
            CalendarMember r7 = r6;
            Intrinsics.checkNotNullParameter(r5, "writer");
            Intrinsics.checkNotNullParameter(r7, "value");
            r5.d(r7.unknownFields());
            l r0 = ProtoAdapter.g;
            r0.j(r5, 19, r7.is_user_count_visible());
            RelationType.ADAPTER.j(r5, 18, r7.getRelation_type());
            TagData.ADAPTER.j(r5, 17, r7.getRelation_tag());
            r0.j(r5, 16, r7.getUse_server_member_num());
            r0.j(r5, 15, r7.is_cross_tenant());
            w r1 = ProtoAdapter.q;
            r1.j(r5, 14, r7.getTenant_id());
            r1.j(r5, 13, r7.getAvatar_path());
            ProtoAdapter.h.j(r5, 12, r7.getChat_member_count());
            r1.j(r5, 11, r7.getChat_id());
            CalendarMemberType.ADAPTER.j(r5, 10, r7.getMember_type());
            r1.j(r5, 9, r7.getLocalized_name());
            r1.j(r5, 8, r7.getAvatar_key());
            ImageSet.ADAPTER.j(r5, 7, r7.getAvatar());
            r1.j(r5, 6, r7.getName());
            Calendar.Status.ADAPTER.j(r5, 5, r7.getStatus());
            Calendar.AccessRole.ADAPTER.j(r5, 4, r7.getAccess_role());
            r1.j(r5, 3, r7.getUser_id());
            r1.j(r5, 2, r7.getCalendar_id());
            r1.j(r5, 1, r7.getId());
        }

        public b(FieldEncoding r7, KClass<CalendarMember> r8, Syntax r9) {
            super(r7, r8, "type.googleapis.com/calendar.v1.CalendarMember", r9, null);
        }
    }

    public static final class c {
        public c() {
        }
    }

    public /* synthetic */ CalendarMember(a r1, ByteString r2, DefaultConstructorMarker r3) {
        this(r1, r2);
    }

    @Deprecated(message = "avatar is deprecated")
    public static /* synthetic */ void getAvatar$annotations() {
    }

    static {
        Companion = new c();
        DEFAULT_ACCESS_ROLE = Calendar.AccessRole.READER;
        DEFAULT_STATUS = Calendar.Status.DEFAULT;
        DEFAULT_MEMBER_TYPE = CalendarMemberType.INDIVIDUAL;
        ADAPTER = new b(FieldEncoding.LENGTH_DELIMITED, Reflection.getOrCreateKotlinClass(CalendarMember.class), Syntax.PROTO_2);
    }

    @Override // com.lark.wire.Message
    public a newBuilder() {
        a r0 = new a();
        r0.d = this.id;
        r0.e = this.calendar_id;
        r0.f = this.user_id;
        r0.g = this.access_role;
        r0.h = this.status;
        r0.i = this.name;
        r0.j = this.avatar;
        r0.k = this.avatar_key;
        r0.l = this.localized_name;
        r0.m = this.member_type;
        r0.n = this.chat_id;
        r0.o = this.chat_member_count;
        r0.p = this.avatar_path;
        r0.q = this.tenant_id;
        r0.r = this.is_cross_tenant;
        r0.s = this.use_server_member_num;
        r0.t = this.relation_tag;
        r0.u = this.relation_type;
        r0.v = this.is_user_count_visible;
        r0.a(unknownFields());
        return r0;
    }

    @Override // com.lark.wire.Message
    public String toString() {
        return Reflection.getOrCreateKotlinClass(CalendarMember.class).getSimpleName() + '@' + hashCode();
    }

    public final Calendar.AccessRole getAccess_role() {
        return this.access_role;
    }

    public final ImageSet getAvatar() {
        return this.avatar;
    }

    public final String getAvatar_key() {
        return this.avatar_key;
    }

    public final String getAvatar_path() {
        return this.avatar_path;
    }

    public final String getCalendar_id() {
        return this.calendar_id;
    }

    public final String getChat_id() {
        return this.chat_id;
    }

    public final Integer getChat_member_count() {
        return this.chat_member_count;
    }

    public final String getId() {
        return this.id;
    }

    public final String getLocalized_name() {
        return this.localized_name;
    }

    public final CalendarMemberType getMember_type() {
        return this.member_type;
    }

    public final String getName() {
        return this.name;
    }

    public final TagData getRelation_tag() {
        return this.relation_tag;
    }

    public final RelationType getRelation_type() {
        return this.relation_type;
    }

    public final Calendar.Status getStatus() {
        return this.status;
    }

    public final String getTenant_id() {
        return this.tenant_id;
    }

    public final Boolean getUse_server_member_num() {
        return this.use_server_member_num;
    }

    public final String getUser_id() {
        return this.user_id;
    }

    public final Boolean is_cross_tenant() {
        return this.is_cross_tenant;
    }

    public final Boolean is_user_count_visible() {
        return this.is_user_count_visible;
    }

    @Override // com.lark.wire.Message
    public /* bridge */ /* synthetic */ Message.a newBuilder() {
        return newBuilder();
    }

    public CalendarMember(a r2, ByteString r3) {
        super(ADAPTER, r3);
        String r4 = r2.d;
        Intrinsics.checkNotNull(r4);
        this.id = r4;
        String r5 = r2.e;
        Intrinsics.checkNotNull(r5);
        this.calendar_id = r5;
        String r6 = r2.f;
        Intrinsics.checkNotNull(r6);
        this.user_id = r6;
        this.access_role = r2.g;
        this.status = r2.h;
        this.name = r2.i;
        this.avatar = r2.j;
        this.avatar_key = r2.k;
        this.localized_name = r2.l;
        this.member_type = r2.m;
        this.chat_id = r2.n;
        this.chat_member_count = r2.o;
        this.avatar_path = r2.p;
        this.tenant_id = r2.q;
        this.is_cross_tenant = r2.r;
        this.use_server_member_num = r2.s;
        this.relation_tag = r2.t;
        this.relation_type = r2.u;
        this.is_user_count_visible = r2.v;
    }

    public /* synthetic */ CalendarMember(a r1, ByteString r2, int r3, DefaultConstructorMarker r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = ByteString.EMPTY;
    L5:
        this(r1, r2);
    }
}
