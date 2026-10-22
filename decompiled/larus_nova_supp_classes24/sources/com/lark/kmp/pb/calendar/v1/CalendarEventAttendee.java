package com.lark.kmp.pb.calendar.v1;

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
@Metadata(d1 = {"\u0000\u0088\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0010\u0018\u0000 T2\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00020\u0001:\u000bSTUVWXYZ[\\]B\u001b\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\b\u0010Q\u001a\u00020\u0002H\u0016J\b\u0010R\u001a\u00020\tH\u0016R\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0013\u0010\f\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000bR\u0015\u0010\u000e\u001a\u0004\u0018\u00010\u000f¢\u0006\n\n\u0002\u0010\u0012\u001a\u0004\b\u0010\u0010\u0011R\u0013\u0010\u0013\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u000bR\u0011\u0010\u0015\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u000bR\u0015\u0010\u0017\u001a\u0004\u0018\u00010\u0018¢\u0006\n\n\u0002\u0010\u001a\u001a\u0004\b\u0017\u0010\u0019R\u0015\u0010\u001b\u001a\u0004\u0018\u00010\u0018¢\u0006\n\n\u0002\u0010\u001a\u001a\u0004\b\u001b\u0010\u0019R\u0013\u0010\u001c\u001a\u0004\u0018\u00010\u001d¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001fR\u0015\u0010 \u001a\u0004\u0018\u00010!¢\u0006\n\n\u0002\u0010$\u001a\u0004\b\"\u0010#R\u0015\u0010%\u001a\u0004\u0018\u00010\u0018¢\u0006\n\n\u0002\u0010\u001a\u001a\u0004\b%\u0010\u0019R\u0013\u0010&\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b'\u0010\u000bR\u0013\u0010(\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b)\u0010\u000bR\u0013\u0010*\u001a\u0004\u0018\u00010+¢\u0006\b\n\u0000\u001a\u0004\b,\u0010-R\u0013\u0010.\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b/\u0010\u000bR\u0013\u00100\u001a\u0004\u0018\u000101¢\u0006\b\n\u0000\u001a\u0004\b2\u00103R\u0013\u00104\u001a\u0004\u0018\u000105¢\u0006\b\n\u0000\u001a\u0004\b6\u00107R\u0015\u00108\u001a\u0004\u0018\u00010\u0018¢\u0006\n\n\u0002\u0010\u001a\u001a\u0004\b8\u0010\u0019R\u0013\u00109\u001a\u0004\u0018\u00010:¢\u0006\b\n\u0000\u001a\u0004\b;\u0010<R\u0013\u0010=\u001a\u0004\u0018\u00010>¢\u0006\b\n\u0000\u001a\u0004\b?\u0010@R\u0013\u0010A\u001a\u0004\u0018\u00010B¢\u0006\b\n\u0000\u001a\u0004\bC\u0010DR\u0013\u0010E\u001a\u0004\u0018\u00010F¢\u0006\b\n\u0000\u001a\u0004\bG\u0010HR\u0013\u0010I\u001a\u0004\u0018\u00010J¢\u0006\b\n\u0000\u001a\u0004\bK\u0010LR\u0013\u0010M\u001a\u0004\u0018\u00010N¢\u0006\b\n\u0000\u001a\u0004\bO\u0010P¨\u0006^"}, d2 = {"Lcom/lark/kmp/pb/calendar/v1/CalendarEventAttendee;", "Lcom/lark/wire/Message;", "Lcom/lark/kmp/pb/calendar/v1/CalendarEventAttendee$Builder;", "builder", "unknownFields", "Lokio/ByteString;", "<init>", "(Lcom/lark/kmp/pb/calendar/v1/CalendarEventAttendee$Builder;Lokio/ByteString;)V", "id", "", "getId", "()Ljava/lang/String;", "key", "getKey", "original_time", "", "getOriginal_time", "()Ljava/lang/Long;", "Ljava/lang/Long;", "display_name", "getDisplay_name", "attendee_calendar_id", "getAttendee_calendar_id", "is_organizer", "", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "is_optional", "status", "Lcom/lark/kmp/pb/calendar/v1/CalendarEventAttendee$Status;", "getStatus", "()Lcom/lark/kmp/pb/calendar/v1/CalendarEventAttendee$Status;", "additional_guests_count", "", "getAdditional_guests_count", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "is_editable", "inviter_calendar_id", "getInviter_calendar_id", "avatar_key", "getAvatar_key", "category", "Lcom/lark/kmp/pb/calendar/v1/CalendarEventAttendee$Category;", "getCategory", "()Lcom/lark/kmp/pb/calendar/v1/CalendarEventAttendee$Category;", "avatar_path", "getAvatar_path", "attendee_schema", "Lcom/lark/kmp/pb/calendar/v1/CalendarSchemaCollection;", "getAttendee_schema", "()Lcom/lark/kmp/pb/calendar/v1/CalendarSchemaCollection;", "schema_extra_data", "Lcom/lark/kmp/pb/calendar/v1/SchemaExtraData;", "getSchema_extra_data", "()Lcom/lark/kmp/pb/calendar/v1/SchemaExtraData;", "is_dirty", "relation_tag", "Lcom/lark/kmp/pb/basic/v1/TagData;", "getRelation_tag", "()Lcom/lark/kmp/pb/basic/v1/TagData;", "user", "Lcom/lark/kmp/pb/calendar/v1/CalendarEventAttendee$User;", "getUser", "()Lcom/lark/kmp/pb/calendar/v1/CalendarEventAttendee$User;", "group", "Lcom/lark/kmp/pb/calendar/v1/CalendarEventAttendee$Group;", "getGroup", "()Lcom/lark/kmp/pb/calendar/v1/CalendarEventAttendee$Group;", "resource", "Lcom/lark/kmp/pb/calendar/v1/CalendarEventAttendee$Resource;", "getResource", "()Lcom/lark/kmp/pb/calendar/v1/CalendarEventAttendee$Resource;", "third_party_user", "Lcom/lark/kmp/pb/calendar/v1/CalendarEventAttendee$ThirdPartyUser;", "getThird_party_user", "()Lcom/lark/kmp/pb/calendar/v1/CalendarEventAttendee$ThirdPartyUser;", "phone_user", "Lcom/lark/kmp/pb/calendar/v1/CalendarEventAttendee$PhoneUser;", "getPhone_user", "()Lcom/lark/kmp/pb/calendar/v1/CalendarEventAttendee$PhoneUser;", "newBuilder", "toString", "Builder", "Companion", "Status", "Category", "ResourceStatus", "MailContactType", "User", "Group", "Resource", "ThirdPartyUser", "PhoneUser", "rust-sdk-kotlin-pb_release"}, k = 1, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
public final class CalendarEventAttendee extends Message<CalendarEventAttendee, a> {
    public static final ProtoAdapter<CalendarEventAttendee> ADAPTER = null;
    public static final c Companion = null;
    public static final int DEFAULT_ADDITIONAL_GUESTS_COUNT = 0;
    public static final String DEFAULT_AVATAR_KEY = "";
    public static final Category DEFAULT_CATEGORY = null;
    public static final String DEFAULT_DISPLAY_NAME = "";
    public static final String DEFAULT_INVITER_CALENDAR_ID = "";
    public static final boolean DEFAULT_IS_EDITABLE = false;
    public static final boolean DEFAULT_IS_OPTIONAL = false;
    public static final boolean DEFAULT_IS_ORGANIZER = false;
    public static final String DEFAULT_KEY = "";
    public static final long DEFAULT_ORIGINAL_TIME = 0;
    public static final Status DEFAULT_STATUS = null;
    private static final long serialVersionUID = 0;
    private final Integer additional_guests_count;
    private final String attendee_calendar_id;
    private final CalendarSchemaCollection attendee_schema;
    private final String avatar_key;
    private final String avatar_path;
    private final Category category;
    private final String display_name;
    private final Group group;
    private final String id;
    private final String inviter_calendar_id;
    private final Boolean is_dirty;
    private final Boolean is_editable;
    private final Boolean is_optional;
    private final Boolean is_organizer;
    private final String key;
    private final Long original_time;
    private final PhoneUser phone_user;
    private final TagData relation_tag;
    private final Resource resource;
    private final SchemaExtraData schema_extra_data;
    private final Status status;
    private final ThirdPartyUser third_party_user;
    private final User user;

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\f\b\u0086\u0081\u0002\u0018\u0000 \u000f2\u00020\u00012\b\u0012\u0004\u0012\u00020\u00000\u0002:\u0001\u000fB\u0011\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u0004X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000e¨\u0006\u0010"}, d2 = {"Lcom/lark/kmp/pb/calendar/v1/CalendarEventAttendee$Category;", "Lcom/lark/wire/WireEnum;", "", "value", "", "<init>", "(Ljava/lang/String;II)V", "getValue", "()I", "UNKNOWN_CATEGORY", "USER", "GROUP", "RESOURCE", "THIRD_PARTY_USER", "PHONE", "Companion", "rust-sdk-kotlin-pb_release"}, k = 1, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
    public static final enum Category extends Enum<Category> implements o0 {
        public static final ProtoAdapter<Category> ADAPTER = null;
        public static final b Companion = null;
        public static final Category GROUP = null;
        public static final Category PHONE = null;
        public static final Category RESOURCE = null;
        public static final Category THIRD_PARTY_USER = null;
        public static final Category UNKNOWN_CATEGORY = null;
        public static final Category USER = null;
        public static final /* synthetic */ Category[] a = null;
        public static final /* synthetic */ EnumEntries b = null;
        private final int value;

        public static final class a extends d<Category> {
            @Override // com.lark.wire.d
            public final o0 n(int r2) {
                Category.Companion.getClass();
                return b.a(r2);
            }

            public a(KClass<Category> r1, Syntax r2, Category r3) {
                super(r1, r2, r3);
            }
        }

        public static final class b {
            public b() {
            }

            @JvmStatic
            public static Category a(int r1) {
                if (r1 == 0) goto L20;
                if (r1 == 1) goto L26;
                if (r1 == 2) goto L25;
                if (r1 == 3) goto L24;
                if (r1 == 4) goto L23;
                if (r1 == 5) goto L22;
                return null;
            L22:
                return Category.PHONE;
            L23:
                return Category.THIRD_PARTY_USER;
            L24:
                return Category.RESOURCE;
            L25:
                return Category.GROUP;
            L26:
                return Category.USER;
            L20:
                return Category.UNKNOWN_CATEGORY;
            }
        }

        @JvmStatic
        public static final Category fromValue(int r1) {
            Companion.getClass();
            return b.a(r1);
        }

        public static EnumEntries<Category> getEntries() {
            return b;
        }

        static {
            Category r0 = new Category("UNKNOWN_CATEGORY", 0, 0);
            UNKNOWN_CATEGORY = r0;
            Category r1 = new Category("USER", 1, 1);
            USER = r1;
            Category r3 = new Category("GROUP", 2, 2);
            GROUP = r3;
            Category r5 = new Category("RESOURCE", 3, 3);
            RESOURCE = r5;
            Category r7 = new Category("THIRD_PARTY_USER", 4, 4);
            THIRD_PARTY_USER = r7;
            Category r9 = new Category("PHONE", 5, 5);
            PHONE = r9;
            Category[] r11 = {r0, r1, r3, r5, r7, r9};
            a = r11;
            b = EnumEntriesKt.enumEntries(r11);
            Companion = new b();
            ADAPTER = new a(Reflection.getOrCreateKotlinClass(Category.class), Syntax.PROTO_2, r0);
        }

        public static Category[] values() {
            return (Category[]) a.clone();
        }

        @Override // com.lark.wire.o0
        public int getValue() {
            return this.value;
        }

        public static Category valueOf(String r1) {
            return (Category) r27.a.a(Category.class, r1);
        }

        public Category(String r1, int r2, int r3) {
            super(r1, r2);
            this.value = r3;
        }
    }

    @Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\r\u0018\u0000 &2\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00020\u0001:\u0002%&B\u001b\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\b\u0010#\u001a\u00020\u0002H\u0016J\b\u0010$\u001a\u00020\tH\u0016R\u0013\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0017\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000e0\r¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0013\u0010\u0011\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u000bR\u0015\u0010\u0013\u001a\u0004\u0018\u00010\u0014¢\u0006\n\n\u0002\u0010\u0016\u001a\u0004\b\u0013\u0010\u0015R\u0015\u0010\u0017\u001a\u0004\u0018\u00010\u0014¢\u0006\n\n\u0002\u0010\u0016\u001a\u0004\b\u0018\u0010\u0015R\u0015\u0010\u0019\u001a\u0004\u0018\u00010\u001a¢\u0006\n\n\u0002\u0010\u001d\u001a\u0004\b\u001b\u0010\u001cR\u0015\u0010\u001e\u001a\u0004\u0018\u00010\u001a¢\u0006\n\n\u0002\u0010\u001d\u001a\u0004\b\u001f\u0010\u001cR\u0015\u0010 \u001a\u0004\u0018\u00010\u0014¢\u0006\n\n\u0002\u0010\u0016\u001a\u0004\b \u0010\u0015R\u0015\u0010!\u001a\u0004\u0018\u00010\u0014¢\u0006\n\n\u0002\u0010\u0016\u001a\u0004\b!\u0010\u0015R\u0015\u0010\"\u001a\u0004\u0018\u00010\u0014¢\u0006\n\n\u0002\u0010\u0016\u001a\u0004\b\"\u0010\u0015¨\u0006'"}, d2 = {"Lcom/lark/kmp/pb/calendar/v1/CalendarEventAttendee$Group;", "Lcom/lark/wire/Message;", "Lcom/lark/kmp/pb/calendar/v1/CalendarEventAttendee$Group$Builder;", "builder", "unknownFields", "Lokio/ByteString;", "<init>", "(Lcom/lark/kmp/pb/calendar/v1/CalendarEventAttendee$Group$Builder;Lokio/ByteString;)V", "group_id", "", "getGroup_id", "()Ljava/lang/String;", "members", "", "Lcom/lark/kmp/pb/calendar/v1/CalendarEventAttendee;", "getMembers", "()Ljava/util/List;", "tenant_id", "getTenant_id", "is_cross_tenant", "", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "open_security", "getOpen_security", "show_member_limit", "", "getShow_member_limit", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "valid_member_count", "getValid_member_count", "is_any_removed", "is_self_in_group", "is_user_count_visible", "newBuilder", "toString", "Builder", "Companion", "rust-sdk-kotlin-pb_release"}, k = 1, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
    public static final class Group extends Message<Group, a> {
        public static final ProtoAdapter<Group> ADAPTER = null;
        public static final c Companion = null;
        public static final boolean DEFAULT_IS_ANY_REMOVED = false;
        public static final boolean DEFAULT_IS_CROSS_TENANT = false;
        public static final boolean DEFAULT_IS_SELF_IN_GROUP = false;
        public static final boolean DEFAULT_OPEN_SECURITY = false;
        public static final int DEFAULT_SHOW_MEMBER_LIMIT = 0;
        public static final String DEFAULT_TENANT_ID = "";
        public static final int DEFAULT_VALID_MEMBER_COUNT = 0;
        private static final long serialVersionUID = 0;
        private final String group_id;
        private final Boolean is_any_removed;
        private final Boolean is_cross_tenant;
        private final Boolean is_self_in_group;
        private final Boolean is_user_count_visible;
        private final List<CalendarEventAttendee> members;
        private final Boolean open_security;
        private final Integer show_member_limit;
        private final String tenant_id;
        private final Integer valid_member_count;

        public static final class a extends Message.a<Group, a> {
            public String d;
            public List<CalendarEventAttendee> e;
            public String f;
            public Boolean g;
            public Boolean h;
            public Integer i;
            public Integer j;
            public Boolean k;
            public Boolean l;
            public Boolean m;

            @Override // com.lark.wire.Message.a
            public final Message b() {
                return new Group(this, c(), null);
            }

            public a() {
                this.e = CollectionsKt.emptyList();
            }
        }

        public static final class b extends ProtoAdapter<Group> {
            @Override // com.lark.wire.ProtoAdapter
            public final Group c(g0 r8) {
                Intrinsics.checkNotNullParameter(r8, "reader");
                a r1 = new a();
                ArrayList r2 = new ArrayList();
                long r3 = r8.c();
            L3:
                int r5 = r8.e();
                if (r5 == (-1)) goto L17;
                switch(r5) {
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
                r1.m = (Boolean) ProtoAdapter.g.c(r8);
                goto L3
            L8:
                r1.l = (Boolean) ProtoAdapter.g.c(r8);
                goto L3
            L9:
                r1.k = (Boolean) ProtoAdapter.g.c(r8);
                goto L3
            L10:
                r1.j = (Integer) ProtoAdapter.h.c(r8);
                goto L3
            L11:
                r1.i = (Integer) ProtoAdapter.h.c(r8);
                goto L3
            L12:
                r1.h = (Boolean) ProtoAdapter.g.c(r8);
                goto L3
            L13:
                r1.g = (Boolean) ProtoAdapter.g.c(r8);
                goto L3
            L14:
                ProtoAdapter.q.getClass();
                Intrinsics.checkNotNullParameter(r8, "reader");
                r1.f = r8.i();
                goto L3
            L15:
                r2.add(CalendarEventAttendee.ADAPTER.c(r8));
                goto L3
            L16:
                ProtoAdapter.q.getClass();
                Intrinsics.checkNotNullParameter(r8, "reader");
                r1.d = r8.i();
                goto L3
            L6:
                r8.j(r5);
                Unit r6 = Unit.INSTANCE;
                goto L3
            L17:
                ByteString r9 = r8.d(r3);
                Intrinsics.checkNotNullParameter(r2, "members");
                com.lark.wire.internal.a.a(r2);
                r1.e = r2;
                return new Group(r1, r9, null);
            }

            @Override // com.lark.wire.ProtoAdapter
            public final int k(Group r6) {
                Group r7 = r6;
                Intrinsics.checkNotNullParameter(r7, "value");
                int r0 = r7.unknownFields().size();
                w r1 = ProtoAdapter.q;
                int r2 = ((r0 + r1.l(1, r7.getGroup_id())) + CalendarEventAttendee.ADAPTER.a().l(2, r7.getMembers())) + r1.l(3, r7.getTenant_id());
                l r3 = ProtoAdapter.g;
                int r4 = (r2 + r3.l(4, r7.is_cross_tenant())) + r3.l(5, r7.getOpen_security());
                s r5 = ProtoAdapter.h;
                return ((((r4 + r5.l(6, r7.getShow_member_limit())) + r5.l(7, r7.getValid_member_count())) + r3.l(8, r7.is_any_removed())) + r3.l(9, r7.is_self_in_group())) + r3.l(10, r7.is_user_count_visible());
            }

            @Override // com.lark.wire.ProtoAdapter
            public final void f(j0 r5, Group r6) {
                Group r7 = r6;
                Intrinsics.checkNotNullParameter(r5, "writer");
                Intrinsics.checkNotNullParameter(r7, "value");
                w r0 = ProtoAdapter.q;
                r0.i(r5, 1, r7.getGroup_id());
                CalendarEventAttendee.ADAPTER.a().i(r5, 2, r7.getMembers());
                r0.i(r5, 3, r7.getTenant_id());
                l r1 = ProtoAdapter.g;
                r1.i(r5, 4, r7.is_cross_tenant());
                r1.i(r5, 5, r7.getOpen_security());
                s r2 = ProtoAdapter.h;
                r2.i(r5, 6, r7.getShow_member_limit());
                r2.i(r5, 7, r7.getValid_member_count());
                r1.i(r5, 8, r7.is_any_removed());
                r1.i(r5, 9, r7.is_self_in_group());
                r1.i(r5, 10, r7.is_user_count_visible());
                r5.a(r7.unknownFields());
            }

            @Override // com.lark.wire.ProtoAdapter
            public final void g(n0 r5, Group r6) {
                Group r7 = r6;
                Intrinsics.checkNotNullParameter(r5, "writer");
                Intrinsics.checkNotNullParameter(r7, "value");
                r5.d(r7.unknownFields());
                l r0 = ProtoAdapter.g;
                r0.j(r5, 10, r7.is_user_count_visible());
                r0.j(r5, 9, r7.is_self_in_group());
                r0.j(r5, 8, r7.is_any_removed());
                s r1 = ProtoAdapter.h;
                r1.j(r5, 7, r7.getValid_member_count());
                r1.j(r5, 6, r7.getShow_member_limit());
                r0.j(r5, 5, r7.getOpen_security());
                r0.j(r5, 4, r7.is_cross_tenant());
                w r2 = ProtoAdapter.q;
                r2.j(r5, 3, r7.getTenant_id());
                CalendarEventAttendee.ADAPTER.a().j(r5, 2, r7.getMembers());
                r2.j(r5, 1, r7.getGroup_id());
            }

            public b(FieldEncoding r7, KClass<Group> r8, Syntax r9) {
                super(r7, r8, "type.googleapis.com/calendar.v1.CalendarEventAttendee.Group", r9, null);
            }
        }

        public static final class c {
            public c() {
            }
        }

        public /* synthetic */ Group(a r1, ByteString r2, DefaultConstructorMarker r3) {
            this(r1, r2);
        }

        static {
            Companion = new c();
            ADAPTER = new b(FieldEncoding.LENGTH_DELIMITED, Reflection.getOrCreateKotlinClass(Group.class), Syntax.PROTO_2);
        }

        @Override // com.lark.wire.Message
        public a newBuilder() {
            a r0 = new a();
            r0.d = this.group_id;
            r0.e = this.members;
            r0.f = this.tenant_id;
            r0.g = this.is_cross_tenant;
            r0.h = this.open_security;
            r0.i = this.show_member_limit;
            r0.j = this.valid_member_count;
            r0.k = this.is_any_removed;
            r0.l = this.is_self_in_group;
            r0.m = this.is_user_count_visible;
            r0.a(unknownFields());
            return r0;
        }

        @Override // com.lark.wire.Message
        public String toString() {
            return Reflection.getOrCreateKotlinClass(Group.class).getSimpleName() + '@' + hashCode();
        }

        public final String getGroup_id() {
            return this.group_id;
        }

        public final List<CalendarEventAttendee> getMembers() {
            return this.members;
        }

        public final Boolean getOpen_security() {
            return this.open_security;
        }

        public final Integer getShow_member_limit() {
            return this.show_member_limit;
        }

        public final String getTenant_id() {
            return this.tenant_id;
        }

        public final Integer getValid_member_count() {
            return this.valid_member_count;
        }

        public final Boolean is_any_removed() {
            return this.is_any_removed;
        }

        public final Boolean is_cross_tenant() {
            return this.is_cross_tenant;
        }

        public final Boolean is_self_in_group() {
            return this.is_self_in_group;
        }

        public final Boolean is_user_count_visible() {
            return this.is_user_count_visible;
        }

        @Override // com.lark.wire.Message
        public /* bridge */ /* synthetic */ Message.a newBuilder() {
            return newBuilder();
        }

        public Group(a r2, ByteString r3) {
            super(ADAPTER, r3);
            this.group_id = r2.d;
            this.members = com.lark.wire.internal.a.c("members", r2.e);
            this.tenant_id = r2.f;
            this.is_cross_tenant = r2.g;
            this.open_security = r2.h;
            this.show_member_limit = r2.i;
            this.valid_member_count = r2.j;
            this.is_any_removed = r2.k;
            this.is_self_in_group = r2.l;
            this.is_user_count_visible = r2.m;
        }

        public /* synthetic */ Group(a r1, ByteString r2, int r3, DefaultConstructorMarker r4) {
            if ((r3 & 2) == 0) goto L5;
            r2 = ByteString.EMPTY;
        L5:
            this(r1, r2);
        }
    }

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\u000b\b\u0086\u0081\u0002\u0018\u0000 \u000e2\u00020\u00012\b\u0012\u0004\u0012\u00020\u00000\u0002:\u0001\u000eB\u0011\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u0004X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\r¨\u0006\u000f"}, d2 = {"Lcom/lark/kmp/pb/calendar/v1/CalendarEventAttendee$MailContactType;", "Lcom/lark/wire/WireEnum;", "", "value", "", "<init>", "(Ljava/lang/String;II)V", "getValue", "()I", "NORMAL_MAIL", "MAIL_CONTACT", "PUBLIC_MAIL", "MAIL_GROUP", "UNKNOWN", "Companion", "rust-sdk-kotlin-pb_release"}, k = 1, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
    public static final enum MailContactType extends Enum<MailContactType> implements o0 {
        public static final ProtoAdapter<MailContactType> ADAPTER = null;
        public static final b Companion = null;
        public static final MailContactType MAIL_CONTACT = null;
        public static final MailContactType MAIL_GROUP = null;
        public static final MailContactType NORMAL_MAIL = null;
        public static final MailContactType PUBLIC_MAIL = null;
        public static final MailContactType UNKNOWN = null;
        public static final /* synthetic */ MailContactType[] a = null;
        public static final /* synthetic */ EnumEntries b = null;
        private final int value;

        public static final class a extends d<MailContactType> {
            @Override // com.lark.wire.d
            public final o0 n(int r2) {
                MailContactType.Companion.getClass();
                return b.a(r2);
            }

            public a(KClass<MailContactType> r1, Syntax r2, MailContactType r3) {
                super(r1, r2, r3);
            }
        }

        public static final class b {
            public b() {
            }

            @JvmStatic
            public static MailContactType a(int r1) {
                if (r1 == 0) goto L17;
                if (r1 == 1) goto L22;
                if (r1 == 2) goto L21;
                if (r1 == 3) goto L20;
                if (r1 == 4) goto L19;
                return null;
            L19:
                return MailContactType.UNKNOWN;
            L20:
                return MailContactType.MAIL_GROUP;
            L21:
                return MailContactType.PUBLIC_MAIL;
            L22:
                return MailContactType.MAIL_CONTACT;
            L17:
                return MailContactType.NORMAL_MAIL;
            }
        }

        @JvmStatic
        public static final MailContactType fromValue(int r1) {
            Companion.getClass();
            return b.a(r1);
        }

        public static EnumEntries<MailContactType> getEntries() {
            return b;
        }

        static {
            MailContactType r0 = new MailContactType("NORMAL_MAIL", 0, 0);
            NORMAL_MAIL = r0;
            MailContactType r1 = new MailContactType("MAIL_CONTACT", 1, 1);
            MAIL_CONTACT = r1;
            MailContactType r3 = new MailContactType("PUBLIC_MAIL", 2, 2);
            PUBLIC_MAIL = r3;
            MailContactType r5 = new MailContactType("MAIL_GROUP", 3, 3);
            MAIL_GROUP = r5;
            MailContactType r7 = new MailContactType("UNKNOWN", 4, 4);
            UNKNOWN = r7;
            MailContactType[] r9 = {r0, r1, r3, r5, r7};
            a = r9;
            b = EnumEntriesKt.enumEntries(r9);
            Companion = new b();
            ADAPTER = new a(Reflection.getOrCreateKotlinClass(MailContactType.class), Syntax.PROTO_2, r0);
        }

        public static MailContactType[] values() {
            return (MailContactType[]) a.clone();
        }

        @Override // com.lark.wire.o0
        public int getValue() {
            return this.value;
        }

        public static MailContactType valueOf(String r1) {
            return (MailContactType) r27.a.a(MailContactType.class, r1);
        }

        public MailContactType(String r1, int r2, int r3) {
            super(r1, r2);
            this.value = r3;
        }
    }

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0007\u0018\u0000 \u000f2\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00020\u0001:\u0002\u000e\u000fB\u001b\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\b\u0010\f\u001a\u00020\u0002H\u0016J\b\u0010\r\u001a\u00020\tH\u0016R\u0013\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0010"}, d2 = {"Lcom/lark/kmp/pb/calendar/v1/CalendarEventAttendee$PhoneUser;", "Lcom/lark/wire/Message;", "Lcom/lark/kmp/pb/calendar/v1/CalendarEventAttendee$PhoneUser$Builder;", "builder", "unknownFields", "Lokio/ByteString;", "<init>", "(Lcom/lark/kmp/pb/calendar/v1/CalendarEventAttendee$PhoneUser$Builder;Lokio/ByteString;)V", "phone", "", "getPhone", "()Ljava/lang/String;", "newBuilder", "toString", "Builder", "Companion", "rust-sdk-kotlin-pb_release"}, k = 1, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
    public static final class PhoneUser extends Message<PhoneUser, a> {
        public static final ProtoAdapter<PhoneUser> ADAPTER = null;
        public static final c Companion = null;
        private static final long serialVersionUID = 0;
        private final String phone;

        public static final class a extends Message.a<PhoneUser, a> {
            public String d;

            @Override // com.lark.wire.Message.a
            public final Message b() {
                return new PhoneUser(this, c(), null);
            }

            public a() {
            }
        }

        public static final class b extends ProtoAdapter<PhoneUser> {
            @Override // com.lark.wire.ProtoAdapter
            public final PhoneUser c(g0 r7) {
                Intrinsics.checkNotNullParameter(r7, "reader");
                a r1 = new a();
                long r2 = r7.c();
            L3:
                int r4 = r7.e();
                if (r4 == (-1)) goto L10;
                if (r4 == 1) goto L7;
                r7.j(r4);
                goto L3
            L7:
                ProtoAdapter.q.getClass();
                Intrinsics.checkNotNullParameter(r7, "reader");
                r1.d = r7.i();
                goto L3
            L10:
                return new PhoneUser(r1, r7.d(r2), null);
            }

            @Override // com.lark.wire.ProtoAdapter
            public final int k(PhoneUser r4) {
                PhoneUser r5 = r4;
                Intrinsics.checkNotNullParameter(r5, "value");
                return r5.unknownFields().size() + ProtoAdapter.q.l(1, r5.getPhone());
            }

            @Override // com.lark.wire.ProtoAdapter
            public final void f(j0 r4, PhoneUser r5) {
                PhoneUser r6 = r5;
                Intrinsics.checkNotNullParameter(r4, "writer");
                Intrinsics.checkNotNullParameter(r6, "value");
                ProtoAdapter.q.i(r4, 1, r6.getPhone());
                r4.a(r6.unknownFields());
            }

            @Override // com.lark.wire.ProtoAdapter
            public final void g(n0 r3, PhoneUser r4) {
                PhoneUser r5 = r4;
                Intrinsics.checkNotNullParameter(r3, "writer");
                Intrinsics.checkNotNullParameter(r5, "value");
                r3.d(r5.unknownFields());
                ProtoAdapter.q.j(r3, 1, r5.getPhone());
            }

            public b(FieldEncoding r7, KClass<PhoneUser> r8, Syntax r9) {
                super(r7, r8, "type.googleapis.com/calendar.v1.CalendarEventAttendee.PhoneUser", r9, null);
            }
        }

        public static final class c {
            public c() {
            }
        }

        public /* synthetic */ PhoneUser(a r1, ByteString r2, DefaultConstructorMarker r3) {
            this(r1, r2);
        }

        static {
            Companion = new c();
            ADAPTER = new b(FieldEncoding.LENGTH_DELIMITED, Reflection.getOrCreateKotlinClass(PhoneUser.class), Syntax.PROTO_2);
        }

        @Override // com.lark.wire.Message
        public a newBuilder() {
            a r0 = new a();
            r0.d = this.phone;
            r0.a(unknownFields());
            return r0;
        }

        @Override // com.lark.wire.Message
        public String toString() {
            return Reflection.getOrCreateKotlinClass(PhoneUser.class).getSimpleName() + '@' + hashCode();
        }

        public final String getPhone() {
            return this.phone;
        }

        @Override // com.lark.wire.Message
        public /* bridge */ /* synthetic */ Message.a newBuilder() {
            return newBuilder();
        }

        public PhoneUser(a r2, ByteString r3) {
            super(ADAPTER, r3);
            this.phone = r2.d;
        }

        public /* synthetic */ PhoneUser(a r1, ByteString r2, int r3, DefaultConstructorMarker r4) {
            if ((r3 & 2) == 0) goto L5;
            r2 = ByteString.EMPTY;
        L5:
            this(r1, r2);
        }
    }

    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u0000 \u00192\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00020\u0001:\u0002\u0018\u0019B\u001b\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\b\u0010\u0016\u001a\u00020\u0002H\u0016J\b\u0010\u0017\u001a\u00020\tH\u0016R\u0013\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0015\u0010\f\u001a\u0004\u0018\u00010\r¢\u0006\n\n\u0002\u0010\u000f\u001a\u0004\b\f\u0010\u000eR\u0013\u0010\u0010\u001a\u0004\u0018\u00010\u0011¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0013\u0010\u0014\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u000b¨\u0006\u001a"}, d2 = {"Lcom/lark/kmp/pb/calendar/v1/CalendarEventAttendee$Resource;", "Lcom/lark/wire/Message;", "Lcom/lark/kmp/pb/calendar/v1/CalendarEventAttendee$Resource$Builder;", "builder", "unknownFields", "Lokio/ByteString;", "<init>", "(Lcom/lark/kmp/pb/calendar/v1/CalendarEventAttendee$Resource$Builder;Lokio/ByteString;)V", "tenant_id", "", "getTenant_id", "()Ljava/lang/String;", "is_disabled", "", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "resource_status", "Lcom/lark/kmp/pb/calendar/v1/CalendarEventAttendee$ResourceStatus;", "getResource_status", "()Lcom/lark/kmp/pb/calendar/v1/CalendarEventAttendee$ResourceStatus;", "booker_id", "getBooker_id", "newBuilder", "toString", "Builder", "Companion", "rust-sdk-kotlin-pb_release"}, k = 1, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
    public static final class Resource extends Message<Resource, a> {
        public static final ProtoAdapter<Resource> ADAPTER = null;
        public static final c Companion = null;
        public static final String DEFAULT_BOOKER_ID = "";
        public static final boolean DEFAULT_IS_DISABLED = false;
        public static final ResourceStatus DEFAULT_RESOURCE_STATUS = null;
        public static final String DEFAULT_TENANT_ID = "";
        private static final long serialVersionUID = 0;
        private final String booker_id;
        private final Boolean is_disabled;
        private final ResourceStatus resource_status;
        private final String tenant_id;

        public static final class a extends Message.a<Resource, a> {
            public String d;
            public Boolean e;
            public ResourceStatus f;
            public String g;

            @Override // com.lark.wire.Message.a
            public final Message b() {
                return new Resource(this, c(), null);
            }

            public a() {
            }
        }

        public static final class b extends ProtoAdapter<Resource> {
            @Override // com.lark.wire.ProtoAdapter
            public final Resource c(g0 r10) {
                Intrinsics.checkNotNullParameter(r10, "reader");
                a r1 = new a();
                long r2 = r10.c();
            L3:
                int r4 = r10.e();
                if (r4 == (-1)) goto L22;
                if (r4 != 1) goto L8;
                ProtoAdapter.q.getClass();
                Intrinsics.checkNotNullParameter(r10, "reader");
                r1.d = r10.i();
                goto L3
            L8:
                if (r4 != 2) goto L10;
                r1.e = (Boolean) ProtoAdapter.g.c(r10);
                goto L3
            L10:
                if (r4 != 3) goto L12;
                r1.f = ResourceStatus.ADAPTER.c(r10);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L17
            L17:
                e = move-exception;
                r10.a(r4, FieldEncoding.VARINT, Long.valueOf(e.value));
                Unit r5 = Unit.INSTANCE;
                goto L3
            L12:
                if (r4 != 4) goto L13;
                ProtoAdapter.q.getClass();
                Intrinsics.checkNotNullParameter(r10, "reader");
                r1.g = r10.i();
                goto L3
            L13:
                r10.j(r4);
                Unit r6 = Unit.INSTANCE;
                goto L3
            L22:
                return new Resource(r1, r10.d(r2), null);
            }

            @Override // com.lark.wire.ProtoAdapter
            public final int k(Resource r6) {
                Resource r7 = r6;
                Intrinsics.checkNotNullParameter(r7, "value");
                int r0 = r7.unknownFields().size();
                w r1 = ProtoAdapter.q;
                return (((r0 + r1.l(1, r7.getTenant_id())) + ProtoAdapter.g.l(2, r7.is_disabled())) + ResourceStatus.ADAPTER.l(3, r7.getResource_status())) + r1.l(4, r7.getBooker_id());
            }

            @Override // com.lark.wire.ProtoAdapter
            public final void f(j0 r5, Resource r6) {
                Resource r7 = r6;
                Intrinsics.checkNotNullParameter(r5, "writer");
                Intrinsics.checkNotNullParameter(r7, "value");
                w r0 = ProtoAdapter.q;
                r0.i(r5, 1, r7.getTenant_id());
                ProtoAdapter.g.i(r5, 2, r7.is_disabled());
                ResourceStatus.ADAPTER.i(r5, 3, r7.getResource_status());
                r0.i(r5, 4, r7.getBooker_id());
                r5.a(r7.unknownFields());
            }

            @Override // com.lark.wire.ProtoAdapter
            public final void g(n0 r5, Resource r6) {
                Resource r7 = r6;
                Intrinsics.checkNotNullParameter(r5, "writer");
                Intrinsics.checkNotNullParameter(r7, "value");
                r5.d(r7.unknownFields());
                w r0 = ProtoAdapter.q;
                r0.j(r5, 4, r7.getBooker_id());
                ResourceStatus.ADAPTER.j(r5, 3, r7.getResource_status());
                ProtoAdapter.g.j(r5, 2, r7.is_disabled());
                r0.j(r5, 1, r7.getTenant_id());
            }

            public b(FieldEncoding r7, KClass<Resource> r8, Syntax r9) {
                super(r7, r8, "type.googleapis.com/calendar.v1.CalendarEventAttendee.Resource", r9, null);
            }
        }

        public static final class c {
            public c() {
            }
        }

        public /* synthetic */ Resource(a r1, ByteString r2, DefaultConstructorMarker r3) {
            this(r1, r2);
        }

        static {
            Companion = new c();
            DEFAULT_RESOURCE_STATUS = ResourceStatus.NORMAL;
            ADAPTER = new b(FieldEncoding.LENGTH_DELIMITED, Reflection.getOrCreateKotlinClass(Resource.class), Syntax.PROTO_2);
        }

        @Override // com.lark.wire.Message
        public a newBuilder() {
            a r0 = new a();
            r0.d = this.tenant_id;
            r0.e = this.is_disabled;
            r0.f = this.resource_status;
            r0.g = this.booker_id;
            r0.a(unknownFields());
            return r0;
        }

        @Override // com.lark.wire.Message
        public String toString() {
            return Reflection.getOrCreateKotlinClass(Resource.class).getSimpleName() + '@' + hashCode();
        }

        public final String getBooker_id() {
            return this.booker_id;
        }

        public final ResourceStatus getResource_status() {
            return this.resource_status;
        }

        public final String getTenant_id() {
            return this.tenant_id;
        }

        public final Boolean is_disabled() {
            return this.is_disabled;
        }

        @Override // com.lark.wire.Message
        public /* bridge */ /* synthetic */ Message.a newBuilder() {
            return newBuilder();
        }

        public Resource(a r2, ByteString r3) {
            super(ADAPTER, r3);
            this.tenant_id = r2.d;
            this.is_disabled = r2.e;
            this.resource_status = r2.f;
            this.booker_id = r2.g;
        }

        public /* synthetic */ Resource(a r1, ByteString r2, int r3, DefaultConstructorMarker r4) {
            if ((r3 & 2) == 0) goto L5;
            r2 = ByteString.EMPTY;
        L5:
            this(r1, r2);
        }
    }

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\b\b\u0086\u0081\u0002\u0018\u0000 \u000b2\u00020\u00012\b\u0012\u0004\u0012\u00020\u00000\u0002:\u0001\u000bB\u0011\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u0004X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bj\u0002\b\tj\u0002\b\n¨\u0006\f"}, d2 = {"Lcom/lark/kmp/pb/calendar/v1/CalendarEventAttendee$ResourceStatus;", "Lcom/lark/wire/WireEnum;", "", "value", "", "<init>", "(Ljava/lang/String;II)V", "getValue", "()I", "NORMAL", "RELEASED_EARLY", "Companion", "rust-sdk-kotlin-pb_release"}, k = 1, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
    public static final enum ResourceStatus extends Enum<ResourceStatus> implements o0 {
        public static final ProtoAdapter<ResourceStatus> ADAPTER = null;
        public static final b Companion = null;
        public static final ResourceStatus NORMAL = null;
        public static final ResourceStatus RELEASED_EARLY = null;
        public static final /* synthetic */ ResourceStatus[] a = null;
        public static final /* synthetic */ EnumEntries b = null;
        private final int value;

        public static final class a extends d<ResourceStatus> {
            @Override // com.lark.wire.d
            public final o0 n(int r2) {
                ResourceStatus.Companion.getClass();
                if (r2 == 0) goto L9;
                if (r2 == 1) goto L11;
                return null;
            L11:
                return ResourceStatus.RELEASED_EARLY;
            L9:
                return ResourceStatus.NORMAL;
            }

            public a(KClass<ResourceStatus> r1, Syntax r2, ResourceStatus r3) {
                super(r1, r2, r3);
            }
        }

        public static final class b {
            public b() {
            }
        }

        public static EnumEntries<ResourceStatus> getEntries() {
            return b;
        }

        static {
            ResourceStatus r0 = new ResourceStatus("NORMAL", 0, 0);
            NORMAL = r0;
            ResourceStatus r1 = new ResourceStatus("RELEASED_EARLY", 1, 1);
            RELEASED_EARLY = r1;
            ResourceStatus[] r3 = {r0, r1};
            a = r3;
            b = EnumEntriesKt.enumEntries(r3);
            Companion = new b();
            ADAPTER = new a(Reflection.getOrCreateKotlinClass(ResourceStatus.class), Syntax.PROTO_2, r0);
        }

        public static ResourceStatus[] values() {
            return (ResourceStatus[]) a.clone();
        }

        @Override // com.lark.wire.o0
        public int getValue() {
            return this.value;
        }

        @JvmStatic
        public static final ResourceStatus fromValue(int r1) {
            Companion.getClass();
            if (r1 == 0) goto L9;
            if (r1 == 1) goto L11;
            return null;
        L11:
            return RELEASED_EARLY;
        L9:
            return NORMAL;
        }

        public static ResourceStatus valueOf(String r1) {
            return (ResourceStatus) r27.a.a(ResourceStatus.class, r1);
        }

        public ResourceStatus(String r1, int r2, int r3) {
            super(r1, r2);
            this.value = r3;
        }
    }

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\u000b\b\u0086\u0081\u0002\u0018\u0000 \u000e2\u00020\u00012\b\u0012\u0004\u0012\u00020\u00000\u0002:\u0001\u000eB\u0011\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u0004X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\r¨\u0006\u000f"}, d2 = {"Lcom/lark/kmp/pb/calendar/v1/CalendarEventAttendee$Status;", "Lcom/lark/wire/WireEnum;", "", "value", "", "<init>", "(Ljava/lang/String;II)V", "getValue", "()I", "NEEDS_ACTION", "ACCEPT", "TENTATIVE", "DECLINE", "REMOVED", "Companion", "rust-sdk-kotlin-pb_release"}, k = 1, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
    public static final enum Status extends Enum<Status> implements o0 {
        public static final Status ACCEPT = null;
        public static final ProtoAdapter<Status> ADAPTER = null;
        public static final b Companion = null;
        public static final Status DECLINE = null;
        public static final Status NEEDS_ACTION = null;
        public static final Status REMOVED = null;
        public static final Status TENTATIVE = null;
        public static final /* synthetic */ Status[] a = null;
        public static final /* synthetic */ EnumEntries b = null;
        private final int value;

        public static final class a extends d<Status> {
            @Override // com.lark.wire.d
            public final o0 n(int r2) {
                Status.Companion.getClass();
                return b.a(r2);
            }

            public a(KClass<Status> r2, Syntax r3) {
                super(r2, r3, null);
            }
        }

        public static final class b {
            public b() {
            }

            @JvmStatic
            public static Status a(int r1) {
                if (r1 == 1) goto L18;
                if (r1 == 2) goto L23;
                if (r1 == 3) goto L22;
                if (r1 == 4) goto L21;
                if (r1 == 5) goto L20;
                return null;
            L20:
                return Status.REMOVED;
            L21:
                return Status.DECLINE;
            L22:
                return Status.TENTATIVE;
            L23:
                return Status.ACCEPT;
            L18:
                return Status.NEEDS_ACTION;
            }
        }

        @JvmStatic
        public static final Status fromValue(int r1) {
            Companion.getClass();
            return b.a(r1);
        }

        public static EnumEntries<Status> getEntries() {
            return b;
        }

        static {
            Status r0 = new Status("NEEDS_ACTION", 0, 1);
            NEEDS_ACTION = r0;
            Status r1 = new Status("ACCEPT", 1, 2);
            ACCEPT = r1;
            Status r4 = new Status("TENTATIVE", 2, 3);
            TENTATIVE = r4;
            Status r6 = new Status("DECLINE", 3, 4);
            DECLINE = r6;
            Status r8 = new Status("REMOVED", 4, 5);
            REMOVED = r8;
            Status[] r10 = {r0, r1, r4, r6, r8};
            a = r10;
            b = EnumEntriesKt.enumEntries(r10);
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

        public static Status valueOf(String r1) {
            return (Status) r27.a.a(Status.class, r1);
        }

        public Status(String r1, int r2, int r3) {
            super(r1, r2);
            this.value = r3;
        }
    }

    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 \u00132\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00020\u0001:\u0002\u0012\u0013B\u001b\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\b\u0010\u0010\u001a\u00020\u0002H\u0016J\b\u0010\u0011\u001a\u00020\tH\u0016R\u0013\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0013\u0010\f\u001a\u0004\u0018\u00010\r¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u0014"}, d2 = {"Lcom/lark/kmp/pb/calendar/v1/CalendarEventAttendee$ThirdPartyUser;", "Lcom/lark/wire/Message;", "Lcom/lark/kmp/pb/calendar/v1/CalendarEventAttendee$ThirdPartyUser$Builder;", "builder", "unknownFields", "Lokio/ByteString;", "<init>", "(Lcom/lark/kmp/pb/calendar/v1/CalendarEventAttendee$ThirdPartyUser$Builder;Lokio/ByteString;)V", "email", "", "getEmail", "()Ljava/lang/String;", "mail_contact_type", "Lcom/lark/kmp/pb/calendar/v1/CalendarEventAttendee$MailContactType;", "getMail_contact_type", "()Lcom/lark/kmp/pb/calendar/v1/CalendarEventAttendee$MailContactType;", "newBuilder", "toString", "Builder", "Companion", "rust-sdk-kotlin-pb_release"}, k = 1, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
    public static final class ThirdPartyUser extends Message<ThirdPartyUser, a> {
        public static final ProtoAdapter<ThirdPartyUser> ADAPTER = null;
        public static final c Companion = null;
        public static final MailContactType DEFAULT_MAIL_CONTACT_TYPE = null;
        private static final long serialVersionUID = 0;
        private final String email;
        private final MailContactType mail_contact_type;

        public static final class a extends Message.a<ThirdPartyUser, a> {
            public String d;
            public MailContactType e;

            @Override // com.lark.wire.Message.a
            public final Message b() {
                return new ThirdPartyUser(this, c(), null);
            }

            public a() {
            }
        }

        public static final class b extends ProtoAdapter<ThirdPartyUser> {
            @Override // com.lark.wire.ProtoAdapter
            public final ThirdPartyUser c(g0 r10) {
                Intrinsics.checkNotNullParameter(r10, "reader");
                a r1 = new a();
                long r2 = r10.c();
            L3:
                int r4 = r10.e();
                if (r4 == (-1)) goto L16;
                if (r4 != 1) goto L8;
                ProtoAdapter.q.getClass();
                Intrinsics.checkNotNullParameter(r10, "reader");
                r1.d = r10.i();
                goto L3
            L8:
                if (r4 != 2) goto L9;
                r1.e = MailContactType.ADAPTER.c(r10);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L12
            L12:
                e = move-exception;
                r10.a(r4, FieldEncoding.VARINT, Long.valueOf(e.value));
                Unit r5 = Unit.INSTANCE;
                goto L3
            L9:
                r10.j(r4);
                goto L3
            L16:
                return new ThirdPartyUser(r1, r10.d(r2), null);
            }

            @Override // com.lark.wire.ProtoAdapter
            public final int k(ThirdPartyUser r5) {
                ThirdPartyUser r6 = r5;
                Intrinsics.checkNotNullParameter(r6, "value");
                return (r6.unknownFields().size() + ProtoAdapter.q.l(1, r6.getEmail())) + MailContactType.ADAPTER.l(2, r6.getMail_contact_type());
            }

            @Override // com.lark.wire.ProtoAdapter
            public final void f(j0 r4, ThirdPartyUser r5) {
                ThirdPartyUser r6 = r5;
                Intrinsics.checkNotNullParameter(r4, "writer");
                Intrinsics.checkNotNullParameter(r6, "value");
                ProtoAdapter.q.i(r4, 1, r6.getEmail());
                MailContactType.ADAPTER.i(r4, 2, r6.getMail_contact_type());
                r4.a(r6.unknownFields());
            }

            @Override // com.lark.wire.ProtoAdapter
            public final void g(n0 r4, ThirdPartyUser r5) {
                ThirdPartyUser r6 = r5;
                Intrinsics.checkNotNullParameter(r4, "writer");
                Intrinsics.checkNotNullParameter(r6, "value");
                r4.d(r6.unknownFields());
                MailContactType.ADAPTER.j(r4, 2, r6.getMail_contact_type());
                ProtoAdapter.q.j(r4, 1, r6.getEmail());
            }

            public b(FieldEncoding r7, KClass<ThirdPartyUser> r8, Syntax r9) {
                super(r7, r8, "type.googleapis.com/calendar.v1.CalendarEventAttendee.ThirdPartyUser", r9, null);
            }
        }

        public static final class c {
            public c() {
            }
        }

        public /* synthetic */ ThirdPartyUser(a r1, ByteString r2, DefaultConstructorMarker r3) {
            this(r1, r2);
        }

        static {
            Companion = new c();
            DEFAULT_MAIL_CONTACT_TYPE = MailContactType.NORMAL_MAIL;
            ADAPTER = new b(FieldEncoding.LENGTH_DELIMITED, Reflection.getOrCreateKotlinClass(ThirdPartyUser.class), Syntax.PROTO_2);
        }

        @Override // com.lark.wire.Message
        public a newBuilder() {
            a r0 = new a();
            r0.d = this.email;
            r0.e = this.mail_contact_type;
            r0.a(unknownFields());
            return r0;
        }

        @Override // com.lark.wire.Message
        public String toString() {
            return Reflection.getOrCreateKotlinClass(ThirdPartyUser.class).getSimpleName() + '@' + hashCode();
        }

        public final String getEmail() {
            return this.email;
        }

        public final MailContactType getMail_contact_type() {
            return this.mail_contact_type;
        }

        @Override // com.lark.wire.Message
        public /* bridge */ /* synthetic */ Message.a newBuilder() {
            return newBuilder();
        }

        public ThirdPartyUser(a r2, ByteString r3) {
            super(ADAPTER, r3);
            this.email = r2.d;
            this.mail_contact_type = r2.e;
        }

        public /* synthetic */ ThirdPartyUser(a r1, ByteString r2, int r3, DefaultConstructorMarker r4) {
            if ((r3 & 2) == 0) goto L5;
            r2 = ByteString.EMPTY;
        L5:
            this(r1, r2);
        }
    }

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\r\u0018\u0000 \u00152\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00020\u0001:\u0002\u0014\u0015B\u001b\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\b\u0010\u0012\u001a\u00020\u0002H\u0016J\b\u0010\u0013\u001a\u00020\tH\u0016R\u0013\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0013\u0010\f\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000bR\u0013\u0010\u000e\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000bR\u0013\u0010\u0010\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u000b¨\u0006\u0016"}, d2 = {"Lcom/lark/kmp/pb/calendar/v1/CalendarEventAttendee$User;", "Lcom/lark/wire/Message;", "Lcom/lark/kmp/pb/calendar/v1/CalendarEventAttendee$User$Builder;", "builder", "unknownFields", "Lokio/ByteString;", "<init>", "(Lcom/lark/kmp/pb/calendar/v1/CalendarEventAttendee$User$Builder;Lokio/ByteString;)V", "user_id", "", "getUser_id", "()Ljava/lang/String;", "tenant_id", "getTenant_id", "tags", "getTags", "timezone_id", "getTimezone_id", "newBuilder", "toString", "Builder", "Companion", "rust-sdk-kotlin-pb_release"}, k = 1, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
    public static final class User extends Message<User, a> {
        public static final ProtoAdapter<User> ADAPTER = null;
        public static final c Companion = null;
        public static final String DEFAULT_TAGS = "";
        public static final String DEFAULT_TENANT_ID = "";
        public static final String DEFAULT_TIMEZONE_ID = "";
        public static final String DEFAULT_USER_ID = "";
        private static final long serialVersionUID = 0;
        private final String tags;
        private final String tenant_id;
        private final String timezone_id;
        private final String user_id;

        public static final class a extends Message.a<User, a> {
            public String d;
            public String e;
            public String f;
            public String g;

            @Override // com.lark.wire.Message.a
            public final Message b() {
                return new User(this, c(), null);
            }

            public a() {
            }
        }

        public static final class b extends ProtoAdapter<User> {
            @Override // com.lark.wire.ProtoAdapter
            public final User c(g0 r7) {
                Intrinsics.checkNotNullParameter(r7, "reader");
                a r1 = new a();
                long r2 = r7.c();
            L3:
                int r4 = r7.e();
                if (r4 == (-1)) goto L19;
                if (r4 != 1) goto L8;
                ProtoAdapter.q.getClass();
                Intrinsics.checkNotNullParameter(r7, "reader");
                r1.d = r7.i();
                goto L3
            L8:
                if (r4 != 2) goto L10;
                ProtoAdapter.q.getClass();
                Intrinsics.checkNotNullParameter(r7, "reader");
                r1.e = r7.i();
                goto L3
            L10:
                if (r4 != 3) goto L12;
                ProtoAdapter.q.getClass();
                Intrinsics.checkNotNullParameter(r7, "reader");
                r1.f = r7.i();
                goto L3
            L12:
                if (r4 != 4) goto L13;
                ProtoAdapter.q.getClass();
                Intrinsics.checkNotNullParameter(r7, "reader");
                r1.g = r7.i();
                goto L3
            L13:
                r7.j(r4);
                Unit r5 = Unit.INSTANCE;
                goto L3
            L19:
                return new User(r1, r7.d(r2), null);
            }

            @Override // com.lark.wire.ProtoAdapter
            public final int k(User r5) {
                User r6 = r5;
                Intrinsics.checkNotNullParameter(r6, "value");
                int r0 = r6.unknownFields().size();
                w r1 = ProtoAdapter.q;
                return (((r0 + r1.l(1, r6.getUser_id())) + r1.l(2, r6.getTenant_id())) + r1.l(3, r6.getTags())) + r1.l(4, r6.getTimezone_id());
            }

            @Override // com.lark.wire.ProtoAdapter
            public final void f(j0 r4, User r5) {
                User r6 = r5;
                Intrinsics.checkNotNullParameter(r4, "writer");
                Intrinsics.checkNotNullParameter(r6, "value");
                w r0 = ProtoAdapter.q;
                r0.i(r4, 1, r6.getUser_id());
                r0.i(r4, 2, r6.getTenant_id());
                r0.i(r4, 3, r6.getTags());
                r0.i(r4, 4, r6.getTimezone_id());
                r4.a(r6.unknownFields());
            }

            @Override // com.lark.wire.ProtoAdapter
            public final void g(n0 r4, User r5) {
                User r6 = r5;
                Intrinsics.checkNotNullParameter(r4, "writer");
                Intrinsics.checkNotNullParameter(r6, "value");
                r4.d(r6.unknownFields());
                w r0 = ProtoAdapter.q;
                r0.j(r4, 4, r6.getTimezone_id());
                r0.j(r4, 3, r6.getTags());
                r0.j(r4, 2, r6.getTenant_id());
                r0.j(r4, 1, r6.getUser_id());
            }

            public b(FieldEncoding r7, KClass<User> r8, Syntax r9) {
                super(r7, r8, "type.googleapis.com/calendar.v1.CalendarEventAttendee.User", r9, null);
            }
        }

        public static final class c {
            public c() {
            }
        }

        public /* synthetic */ User(a r1, ByteString r2, DefaultConstructorMarker r3) {
            this(r1, r2);
        }

        static {
            Companion = new c();
            ADAPTER = new b(FieldEncoding.LENGTH_DELIMITED, Reflection.getOrCreateKotlinClass(User.class), Syntax.PROTO_2);
        }

        @Override // com.lark.wire.Message
        public a newBuilder() {
            a r0 = new a();
            r0.d = this.user_id;
            r0.e = this.tenant_id;
            r0.f = this.tags;
            r0.g = this.timezone_id;
            r0.a(unknownFields());
            return r0;
        }

        @Override // com.lark.wire.Message
        public String toString() {
            return Reflection.getOrCreateKotlinClass(User.class).getSimpleName() + '@' + hashCode();
        }

        public final String getTags() {
            return this.tags;
        }

        public final String getTenant_id() {
            return this.tenant_id;
        }

        public final String getTimezone_id() {
            return this.timezone_id;
        }

        public final String getUser_id() {
            return this.user_id;
        }

        @Override // com.lark.wire.Message
        public /* bridge */ /* synthetic */ Message.a newBuilder() {
            return newBuilder();
        }

        public User(a r2, ByteString r3) {
            super(ADAPTER, r3);
            this.user_id = r2.d;
            this.tenant_id = r2.e;
            this.tags = r2.f;
            this.timezone_id = r2.g;
        }

        public /* synthetic */ User(a r1, ByteString r2, int r3, DefaultConstructorMarker r4) {
            if ((r3 & 2) == 0) goto L5;
            r2 = ByteString.EMPTY;
        L5:
            this(r1, r2);
        }
    }

    public static final class a extends Message.a<CalendarEventAttendee, a> {
        public String d;
        public String e;
        public Long f;
        public String g;
        public String h;
        public Boolean i;
        public Boolean j;
        public Status k;
        public Integer l;
        public Boolean m;
        public String n;
        public String o;
        public Category p;
        public String q;
        public CalendarSchemaCollection r;
        public SchemaExtraData s;
        public Boolean t;
        public TagData u;
        public User v;
        public Group w;
        public Resource x;
        public ThirdPartyUser y;
        public PhoneUser z;

        @Override // com.lark.wire.Message.a
        public final Message b() {
            return new CalendarEventAttendee(this, c(), null);
        }

        public a() {
        }
    }

    public static final class b extends ProtoAdapter<CalendarEventAttendee> {
        @Override // com.lark.wire.ProtoAdapter
        public final CalendarEventAttendee c(g0 r10) {
            Intrinsics.checkNotNullParameter(r10, "reader");
            a r1 = new a();
            long r2 = r10.c();
        L3:
            int r4 = r10.e();
            DefaultConstructorMarker r6 = null;
            if (r4 == (-1)) goto L38;
            switch(r4) {
                case 1: goto L31;
                case 2: goto L30;
                case 3: goto L29;
                case 4: goto L28;
                case 5: goto L27;
                case 6: goto L26;
                case 7: goto L25;
                case 8: goto L41;
                case 9: goto L20;
                case 10: goto L19;
                case 11: goto L18;
                case 12: goto L17;
                case 13: goto L39;
                case 14: goto L12;
                case 15: goto L11;
                case 16: goto L10;
                case 17: goto L9;
                case 18: goto L8;
                default: goto L6;
            };
        L39:
            r1.p = Category.ADAPTER.c(r10);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L15
        L15:
            e = move-exception;
            r10.a(r4, FieldEncoding.VARINT, Long.valueOf(e.value));
            Unit r5 = Unit.INSTANCE;
            goto L3
        L41:
            r1.k = Status.ADAPTER.c(r10);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L23
        L23:
            e = move-exception;
            r10.a(r4, FieldEncoding.VARINT, Long.valueOf(e.value));
            Unit r7 = Unit.INSTANCE;
            goto L3
        L8:
            r1.u = TagData.ADAPTER.c(r10);
            goto L3
        L9:
            r1.t = (Boolean) ProtoAdapter.g.c(r10);
            goto L3
        L10:
            r1.s = SchemaExtraData.ADAPTER.c(r10);
            goto L3
        L11:
            r1.r = CalendarSchemaCollection.ADAPTER.c(r10);
            goto L3
        L12:
            ProtoAdapter.q.getClass();
            Intrinsics.checkNotNullParameter(r10, "reader");
            r1.q = r10.i();
            goto L3
        L17:
            ProtoAdapter.q.getClass();
            Intrinsics.checkNotNullParameter(r10, "reader");
            r1.o = r10.i();
            goto L3
        L18:
            ProtoAdapter.q.getClass();
            Intrinsics.checkNotNullParameter(r10, "reader");
            r1.n = r10.i();
            goto L3
        L19:
            r1.m = (Boolean) ProtoAdapter.g.c(r10);
            goto L3
        L20:
            r1.l = (Integer) ProtoAdapter.h.c(r10);
            goto L3
        L25:
            r1.j = (Boolean) ProtoAdapter.g.c(r10);
            goto L3
        L26:
            r1.i = (Boolean) ProtoAdapter.g.c(r10);
            goto L3
        L27:
            ProtoAdapter.q.getClass();
            Intrinsics.checkNotNullParameter(r10, "reader");
            String r8 = r10.i();
            Intrinsics.checkNotNullParameter(r8, "attendee_calendar_id");
            r1.h = r8;
            goto L3
        L28:
            ProtoAdapter.q.getClass();
            Intrinsics.checkNotNullParameter(r10, "reader");
            r1.g = r10.i();
            goto L3
        L29:
            r1.f = (Long) ProtoAdapter.k.c(r10);
            goto L3
        L30:
            ProtoAdapter.q.getClass();
            Intrinsics.checkNotNullParameter(r10, "reader");
            r1.e = r10.i();
            goto L3
        L31:
            ProtoAdapter.q.getClass();
            Intrinsics.checkNotNullParameter(r10, "reader");
            String r9 = r10.i();
            Intrinsics.checkNotNullParameter(r9, "id");
            r1.d = r9;
            goto L3
        L6:
            switch(r4) {
                case 100: goto L36;
                case 101: goto L35;
                case 102: goto L34;
                case 103: goto L33;
                case 104: goto L32;
                default: goto L7;
            };
        L32:
            r1.z = PhoneUser.ADAPTER.c(r10);
            r1.v = null;
            r1.w = null;
            r1.x = null;
            r1.y = null;
            goto L3
        L33:
            r1.y = ThirdPartyUser.ADAPTER.c(r10);
            r1.v = null;
            r1.w = null;
            r1.x = null;
            r1.z = null;
            goto L3
        L34:
            r1.x = Resource.ADAPTER.c(r10);
            r1.v = null;
            r1.w = null;
            r1.y = null;
            r1.z = null;
            goto L3
        L35:
            r1.w = Group.ADAPTER.c(r10);
            r1.v = null;
            r1.x = null;
            r1.y = null;
            r1.z = null;
            goto L3
        L36:
            r1.v = User.ADAPTER.c(r10);
            r1.w = null;
            r1.x = null;
            r1.y = null;
            r1.z = null;
            goto L3
        L7:
            r10.j(r4);
            Unit r11 = Unit.INSTANCE;
            goto L3
        L38:
            return new CalendarEventAttendee(r1, r10.d(r2), r6);
        }

        @Override // com.lark.wire.ProtoAdapter
        public final int k(CalendarEventAttendee r7) {
            CalendarEventAttendee r8 = r7;
            Intrinsics.checkNotNullParameter(r8, "value");
            int r0 = r8.unknownFields().size();
            w r1 = ProtoAdapter.q;
            int r2 = ((((r0 + r1.l(1, r8.getId())) + r1.l(2, r8.getKey())) + ProtoAdapter.k.l(3, r8.getOriginal_time())) + r1.l(4, r8.getDisplay_name())) + r1.l(5, r8.getAttendee_calendar_id());
            l r3 = ProtoAdapter.g;
            return (((((((((((((((((r2 + r3.l(6, r8.is_organizer())) + r3.l(7, r8.is_optional())) + Status.ADAPTER.l(8, r8.getStatus())) + ProtoAdapter.h.l(9, r8.getAdditional_guests_count())) + r3.l(10, r8.is_editable())) + r1.l(11, r8.getInviter_calendar_id())) + r1.l(12, r8.getAvatar_key())) + Category.ADAPTER.l(13, r8.getCategory())) + r1.l(14, r8.getAvatar_path())) + CalendarSchemaCollection.ADAPTER.l(15, r8.getAttendee_schema())) + SchemaExtraData.ADAPTER.l(16, r8.getSchema_extra_data())) + r3.l(17, r8.is_dirty())) + TagData.ADAPTER.l(18, r8.getRelation_tag())) + User.ADAPTER.l(100, r8.getUser())) + Group.ADAPTER.l(101, r8.getGroup())) + Resource.ADAPTER.l(102, r8.getResource())) + ThirdPartyUser.ADAPTER.l(103, r8.getThird_party_user())) + PhoneUser.ADAPTER.l(104, r8.getPhone_user());
        }

        @Override // com.lark.wire.ProtoAdapter
        public final void f(j0 r6, CalendarEventAttendee r7) {
            CalendarEventAttendee r8 = r7;
            Intrinsics.checkNotNullParameter(r6, "writer");
            Intrinsics.checkNotNullParameter(r8, "value");
            w r0 = ProtoAdapter.q;
            r0.i(r6, 1, r8.getId());
            r0.i(r6, 2, r8.getKey());
            ProtoAdapter.k.i(r6, 3, r8.getOriginal_time());
            r0.i(r6, 4, r8.getDisplay_name());
            r0.i(r6, 5, r8.getAttendee_calendar_id());
            l r1 = ProtoAdapter.g;
            r1.i(r6, 6, r8.is_organizer());
            r1.i(r6, 7, r8.is_optional());
            Status.ADAPTER.i(r6, 8, r8.getStatus());
            ProtoAdapter.h.i(r6, 9, r8.getAdditional_guests_count());
            r1.i(r6, 10, r8.is_editable());
            r0.i(r6, 11, r8.getInviter_calendar_id());
            r0.i(r6, 12, r8.getAvatar_key());
            Category.ADAPTER.i(r6, 13, r8.getCategory());
            r0.i(r6, 14, r8.getAvatar_path());
            CalendarSchemaCollection.ADAPTER.i(r6, 15, r8.getAttendee_schema());
            SchemaExtraData.ADAPTER.i(r6, 16, r8.getSchema_extra_data());
            r1.i(r6, 17, r8.is_dirty());
            TagData.ADAPTER.i(r6, 18, r8.getRelation_tag());
            User.ADAPTER.i(r6, 100, r8.getUser());
            Group.ADAPTER.i(r6, 101, r8.getGroup());
            Resource.ADAPTER.i(r6, 102, r8.getResource());
            ThirdPartyUser.ADAPTER.i(r6, 103, r8.getThird_party_user());
            PhoneUser.ADAPTER.i(r6, 104, r8.getPhone_user());
            r6.a(r8.unknownFields());
        }

        @Override // com.lark.wire.ProtoAdapter
        public final void g(n0 r6, CalendarEventAttendee r7) {
            CalendarEventAttendee r8 = r7;
            Intrinsics.checkNotNullParameter(r6, "writer");
            Intrinsics.checkNotNullParameter(r8, "value");
            r6.d(r8.unknownFields());
            PhoneUser.ADAPTER.j(r6, 104, r8.getPhone_user());
            ThirdPartyUser.ADAPTER.j(r6, 103, r8.getThird_party_user());
            Resource.ADAPTER.j(r6, 102, r8.getResource());
            Group.ADAPTER.j(r6, 101, r8.getGroup());
            User.ADAPTER.j(r6, 100, r8.getUser());
            TagData.ADAPTER.j(r6, 18, r8.getRelation_tag());
            l r0 = ProtoAdapter.g;
            r0.j(r6, 17, r8.is_dirty());
            SchemaExtraData.ADAPTER.j(r6, 16, r8.getSchema_extra_data());
            CalendarSchemaCollection.ADAPTER.j(r6, 15, r8.getAttendee_schema());
            w r1 = ProtoAdapter.q;
            r1.j(r6, 14, r8.getAvatar_path());
            Category.ADAPTER.j(r6, 13, r8.getCategory());
            r1.j(r6, 12, r8.getAvatar_key());
            r1.j(r6, 11, r8.getInviter_calendar_id());
            r0.j(r6, 10, r8.is_editable());
            ProtoAdapter.h.j(r6, 9, r8.getAdditional_guests_count());
            Status.ADAPTER.j(r6, 8, r8.getStatus());
            r0.j(r6, 7, r8.is_optional());
            r0.j(r6, 6, r8.is_organizer());
            r1.j(r6, 5, r8.getAttendee_calendar_id());
            r1.j(r6, 4, r8.getDisplay_name());
            ProtoAdapter.k.j(r6, 3, r8.getOriginal_time());
            r1.j(r6, 2, r8.getKey());
            r1.j(r6, 1, r8.getId());
        }

        public b(FieldEncoding r7, KClass<CalendarEventAttendee> r8, Syntax r9) {
            super(r7, r8, "type.googleapis.com/calendar.v1.CalendarEventAttendee", r9, null);
        }
    }

    public static final class c {
        public c() {
        }
    }

    public /* synthetic */ CalendarEventAttendee(a r1, ByteString r2, DefaultConstructorMarker r3) {
        this(r1, r2);
    }

    static {
        Companion = new c();
        DEFAULT_STATUS = Status.NEEDS_ACTION;
        DEFAULT_CATEGORY = Category.UNKNOWN_CATEGORY;
        ADAPTER = new b(FieldEncoding.LENGTH_DELIMITED, Reflection.getOrCreateKotlinClass(CalendarEventAttendee.class), Syntax.PROTO_2);
    }

    @Override // com.lark.wire.Message
    public a newBuilder() {
        a r0 = new a();
        r0.d = this.id;
        r0.e = this.key;
        r0.f = this.original_time;
        r0.g = this.display_name;
        r0.h = this.attendee_calendar_id;
        r0.i = this.is_organizer;
        r0.j = this.is_optional;
        r0.k = this.status;
        r0.l = this.additional_guests_count;
        r0.m = this.is_editable;
        r0.n = this.inviter_calendar_id;
        r0.o = this.avatar_key;
        r0.p = this.category;
        r0.q = this.avatar_path;
        r0.r = this.attendee_schema;
        r0.s = this.schema_extra_data;
        r0.t = this.is_dirty;
        r0.u = this.relation_tag;
        r0.v = this.user;
        r0.w = this.group;
        r0.x = this.resource;
        r0.y = this.third_party_user;
        r0.z = this.phone_user;
        r0.a(unknownFields());
        return r0;
    }

    @Override // com.lark.wire.Message
    public String toString() {
        return Reflection.getOrCreateKotlinClass(CalendarEventAttendee.class).getSimpleName() + '@' + hashCode();
    }

    public final Integer getAdditional_guests_count() {
        return this.additional_guests_count;
    }

    public final String getAttendee_calendar_id() {
        return this.attendee_calendar_id;
    }

    public final CalendarSchemaCollection getAttendee_schema() {
        return this.attendee_schema;
    }

    public final String getAvatar_key() {
        return this.avatar_key;
    }

    public final String getAvatar_path() {
        return this.avatar_path;
    }

    public final Category getCategory() {
        return this.category;
    }

    public final String getDisplay_name() {
        return this.display_name;
    }

    public final Group getGroup() {
        return this.group;
    }

    public final String getId() {
        return this.id;
    }

    public final String getInviter_calendar_id() {
        return this.inviter_calendar_id;
    }

    public final String getKey() {
        return this.key;
    }

    public final Long getOriginal_time() {
        return this.original_time;
    }

    public final PhoneUser getPhone_user() {
        return this.phone_user;
    }

    public final TagData getRelation_tag() {
        return this.relation_tag;
    }

    public final Resource getResource() {
        return this.resource;
    }

    public final SchemaExtraData getSchema_extra_data() {
        return this.schema_extra_data;
    }

    public final Status getStatus() {
        return this.status;
    }

    public final ThirdPartyUser getThird_party_user() {
        return this.third_party_user;
    }

    public final User getUser() {
        return this.user;
    }

    public final Boolean is_dirty() {
        return this.is_dirty;
    }

    public final Boolean is_editable() {
        return this.is_editable;
    }

    public final Boolean is_optional() {
        return this.is_optional;
    }

    public final Boolean is_organizer() {
        return this.is_organizer;
    }

    @Override // com.lark.wire.Message
    public /* bridge */ /* synthetic */ Message.a newBuilder() {
        return newBuilder();
    }

    public CalendarEventAttendee(a r7, ByteString r8) {
        super(ADAPTER, r8);
        String r9 = r7.d;
        Intrinsics.checkNotNull(r9);
        this.id = r9;
        this.key = r7.e;
        this.original_time = r7.f;
        this.display_name = r7.g;
        String r10 = r7.h;
        Intrinsics.checkNotNull(r10);
        this.attendee_calendar_id = r10;
        this.is_organizer = r7.i;
        this.is_optional = r7.j;
        this.status = r7.k;
        this.additional_guests_count = r7.l;
        this.is_editable = r7.m;
        this.inviter_calendar_id = r7.n;
        this.avatar_key = r7.o;
        this.category = r7.p;
        this.avatar_path = r7.q;
        this.attendee_schema = r7.r;
        this.schema_extra_data = r7.s;
        this.is_dirty = r7.t;
        this.relation_tag = r7.u;
        User r11 = r7.v;
        this.user = r11;
        Group r0 = r7.w;
        this.group = r0;
        Resource r1 = r7.x;
        this.resource = r1;
        ThirdPartyUser r2 = r7.y;
        this.third_party_user = r2;
        PhoneUser r12 = r7.z;
        this.phone_user = r12;
        boolean r3 = true;
        if (com.lark.wire.internal.a.b(r11, r0, r1, r2, new Object[]{r12}) <= 1) goto L6;
        r3 = false;
    L6:
        if (r3 == false) goto L9;
        return;
    L9:
        throw new IllegalArgumentException("At most one of user, group, resource, third_party_user, phone_user may be non-null".toString());
    }

    public /* synthetic */ CalendarEventAttendee(a r1, ByteString r2, int r3, DefaultConstructorMarker r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = ByteString.EMPTY;
    L5:
        this(r1, r2);
    }
}
