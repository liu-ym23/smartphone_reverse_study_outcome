package com.lark.kmp.pb.basic.v1;

import com.lark.kmp.pb.entity_num.v1.EntityNumInfo;
import com.lark.kmp.pb.todo.v1.CustomComplete;
import com.lark.kmp.pb.todo.v1.TaskMode;
import com.lark.kmp.pb.todo.v1.TodoAssignee;
import com.lark.kmp.pb.todo.v1.TodoFollower;
import com.lark.kmp.pb.todo.v1.TodoOwner;
import com.lark.kmp.pb.todo.v1.TodoReminder;
import com.lark.kmp.pb.todo.v1.TodoSource;
import com.lark.kmp.pb.todo.v1.TodoUser;
import com.lark.wire.FieldEncoding;
import com.lark.wire.ProtoAdapter;
import com.lark.wire.Syntax;
import com.lark.wire.d;
import com.lark.wire.g0;
import com.lark.wire.j0;
import com.lark.wire.l;
import com.lark.wire.n0;
import com.lark.wire.o0;
import com.larksuite.component.universe_design.timepicker.impl.base.WheelView;
import java.util.List;
import java.util.Map;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClass;
import okio.ByteString;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
@Metadata(d1 = {"\u0000\u0098\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\f\u0018\u0000 [2\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00020\u0001:\u0004Z[\\]B\u001b\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\b\u0010X\u001a\u00020\u0002H\u0016J\b\u0010Y\u001a\u00020\tH\u0016R\u0013\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0017\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000e0\r¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0013\u0010\u0011\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u000bR\u0015\u0010\u0013\u001a\u0004\u0018\u00010\u0014¢\u0006\n\n\u0002\u0010\u0017\u001a\u0004\b\u0015\u0010\u0016R\u0013\u0010\u0018\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u000bR\u0015\u0010\u001a\u001a\u0004\u0018\u00010\u001b¢\u0006\n\n\u0002\u0010\u001d\u001a\u0004\b\u001a\u0010\u001cR\u0013\u0010\u001e\u001a\u0004\u0018\u00010\u001f¢\u0006\b\n\u0000\u001a\u0004\b \u0010!R\u0013\u0010\"\u001a\u0004\u0018\u00010#¢\u0006\b\n\u0000\u001a\u0004\b$\u0010%R\u0017\u0010&\u001a\b\u0012\u0004\u0012\u00020'0\r¢\u0006\b\n\u0000\u001a\u0004\b(\u0010\u0010R\u0013\u0010)\u001a\u0004\u0018\u00010*¢\u0006\b\n\u0000\u001a\u0004\b+\u0010,R\u0015\u0010-\u001a\u0004\u0018\u00010\u0014¢\u0006\n\n\u0002\u0010\u0017\u001a\u0004\b.\u0010\u0016R\u0015\u0010/\u001a\u0004\u0018\u00010\u0014¢\u0006\n\n\u0002\u0010\u0017\u001a\u0004\b0\u0010\u0016R\u0013\u00101\u001a\u0004\u0018\u000102¢\u0006\b\n\u0000\u001a\u0004\b3\u00104R\u0015\u00105\u001a\u0004\u0018\u00010\u001b¢\u0006\n\n\u0002\u0010\u001d\u001a\u0004\b6\u0010\u001cR\u001d\u00107\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020908¢\u0006\b\n\u0000\u001a\u0004\b:\u0010;R\u0015\u0010<\u001a\u0004\u0018\u00010\u001b¢\u0006\n\n\u0002\u0010\u001d\u001a\u0004\b=\u0010\u001cR\u0013\u0010>\u001a\u0004\u0018\u00010?¢\u0006\b\n\u0000\u001a\u0004\b@\u0010AR\u0013\u0010B\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\bC\u0010\u000bR\u0017\u0010D\u001a\b\u0012\u0004\u0012\u00020E0\r¢\u0006\b\n\u0000\u001a\u0004\bF\u0010\u0010R\u0013\u0010G\u001a\u0004\u0018\u00010H¢\u0006\b\n\u0000\u001a\u0004\bI\u0010JR\u001e\u0010K\u001a\u0004\u0018\u00010L8\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\bM\u0010N\u001a\u0004\bO\u0010PR\u0013\u0010Q\u001a\u0004\u0018\u00010R¢\u0006\b\n\u0000\u001a\u0004\bS\u0010TR\u0015\u0010U\u001a\u0004\u0018\u00010\u0014¢\u0006\n\n\u0002\u0010\u0017\u001a\u0004\bV\u0010\u0016R\u0015\u0010W\u001a\u0004\u0018\u00010\u001b¢\u0006\n\n\u0002\u0010\u001d\u001a\u0004\bW\u0010\u001c¨\u0006^"}, d2 = {"Lcom/lark/kmp/pb/basic/v1/TodoDetail;", "Lcom/lark/wire/Message;", "Lcom/lark/kmp/pb/basic/v1/TodoDetail$Builder;", "builder", "unknownFields", "Lokio/ByteString;", "<init>", "(Lcom/lark/kmp/pb/basic/v1/TodoDetail$Builder;Lokio/ByteString;)V", "guid", "", "getGuid", "()Ljava/lang/String;", "assignees", "", "Lcom/lark/kmp/pb/todo/v1/TodoAssignee;", "getAssignees", "()Ljava/util/List;", "summary", "getSummary", "due_time", "", "getDue_time", "()Ljava/lang/Long;", "Ljava/lang/Long;", "due_timezone", "getDue_timezone", "is_all_day", "", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "msg_belong_to", "Lcom/lark/kmp/pb/basic/v1/TodoDetail$MsgBelongTo;", "getMsg_belong_to", "()Lcom/lark/kmp/pb/basic/v1/TodoDetail$MsgBelongTo;", "rich_summary", "Lcom/lark/kmp/pb/basic/v1/RichContent;", "getRich_summary", "()Lcom/lark/kmp/pb/basic/v1/RichContent;", "followers", "Lcom/lark/kmp/pb/todo/v1/TodoFollower;", "getFollowers", "creator", "Lcom/lark/kmp/pb/todo/v1/TodoUser;", "getCreator", "()Lcom/lark/kmp/pb/todo/v1/TodoUser;", "completed_milli_time", "getCompleted_milli_time", "deleted_milli_time", "getDeleted_milli_time", "source", "Lcom/lark/kmp/pb/todo/v1/TodoSource;", "getSource", "()Lcom/lark/kmp/pb/todo/v1/TodoSource;", "can_follow", "getCan_follow", "user_to_permission", "", "Lcom/lark/kmp/pb/basic/v1/TodoDetail$Permission;", "getUser_to_permission", "()Ljava/util/Map;", "user_complete_enabled", "getUser_complete_enabled", "custom_complete", "Lcom/lark/kmp/pb/todo/v1/CustomComplete;", "getCustom_complete", "()Lcom/lark/kmp/pb/todo/v1/CustomComplete;", "rrule", "getRrule", "reminders", "Lcom/lark/kmp/pb/todo/v1/TodoReminder;", "getReminders", "entity_num", "Lcom/lark/kmp/pb/entity_num/v1/EntityNumInfo;", "getEntity_num", "()Lcom/lark/kmp/pb/entity_num/v1/EntityNumInfo;", "owner", "Lcom/lark/kmp/pb/todo/v1/TodoOwner;", "getOwner$annotations", "()V", "getOwner", "()Lcom/lark/kmp/pb/todo/v1/TodoOwner;", "mode", "Lcom/lark/kmp/pb/todo/v1/TaskMode;", "getMode", "()Lcom/lark/kmp/pb/todo/v1/TaskMode;", "start_milli_time", "getStart_milli_time", "is_milestone", "newBuilder", "toString", "Builder", "Companion", "MsgBelongTo", "Permission", "rust-sdk-kotlin-pb_release"}, k = 1, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
public final class TodoDetail extends com.lark.wire.Message<TodoDetail, a> {
    public static final ProtoAdapter<TodoDetail> ADAPTER = null;
    public static final b Companion = null;
    public static final TodoSource DEFAULT_SOURCE = null;
    private static final long serialVersionUID = 0;
    private final List<TodoAssignee> assignees;
    private final Boolean can_follow;
    private final Long completed_milli_time;
    private final TodoUser creator;
    private final CustomComplete custom_complete;
    private final Long deleted_milli_time;
    private final Long due_time;
    private final String due_timezone;
    private final EntityNumInfo entity_num;
    private final List<TodoFollower> followers;
    private final String guid;
    private final Boolean is_all_day;
    private final Boolean is_milestone;
    private final TaskMode mode;
    private final MsgBelongTo msg_belong_to;
    private final TodoOwner owner;
    private final List<TodoReminder> reminders;
    private final RichContent rich_summary;
    private final String rrule;
    private final TodoSource source;
    private final Long start_milli_time;
    private final String summary;
    private final Boolean user_complete_enabled;
    private final Map<String, Permission> user_to_permission;

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\t\b\u0086\u0081\u0002\u0018\u0000 \f2\u00020\u00012\b\u0012\u0004\u0012\u00020\u00000\u0002:\u0001\fB\u0011\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u0004X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000b¨\u0006\r"}, d2 = {"Lcom/lark/kmp/pb/basic/v1/TodoDetail$MsgBelongTo;", "Lcom/lark/wire/WireEnum;", "", "value", "", "<init>", "(Ljava/lang/String;II)V", "getValue", "()I", "UNKNOWN", "BOT", "CHAT", "Companion", "rust-sdk-kotlin-pb_release"}, k = 1, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
    public static final enum MsgBelongTo extends Enum<MsgBelongTo> implements o0 {
        public static final ProtoAdapter<MsgBelongTo> ADAPTER = null;
        public static final MsgBelongTo BOT = null;
        public static final MsgBelongTo CHAT = null;
        public static final b Companion = null;
        public static final MsgBelongTo UNKNOWN = null;
        public static final /* synthetic */ MsgBelongTo[] a = null;
        public static final /* synthetic */ EnumEntries b = null;
        private final int value;

        public static final class a extends d<MsgBelongTo> {
            @Override // com.lark.wire.d
            public final o0 n(int r2) {
                MsgBelongTo.Companion.getClass();
                if (r2 == 0) goto L12;
                if (r2 == 1) goto L15;
                if (r2 == 2) goto L14;
                return null;
            L14:
                return MsgBelongTo.CHAT;
            L15:
                return MsgBelongTo.BOT;
            L12:
                return MsgBelongTo.UNKNOWN;
            }

            public a(KClass<MsgBelongTo> r1, Syntax r2, MsgBelongTo r3) {
                super(r1, r2, r3);
            }
        }

        public static final class b {
            public b() {
            }
        }

        public static EnumEntries<MsgBelongTo> getEntries() {
            return b;
        }

        static {
            MsgBelongTo r0 = new MsgBelongTo("UNKNOWN", 0, 0);
            UNKNOWN = r0;
            MsgBelongTo r1 = new MsgBelongTo("BOT", 1, 1);
            BOT = r1;
            MsgBelongTo r3 = new MsgBelongTo("CHAT", 2, 2);
            CHAT = r3;
            MsgBelongTo[] r5 = {r0, r1, r3};
            a = r5;
            b = EnumEntriesKt.enumEntries(r5);
            Companion = new b();
            ADAPTER = new a(Reflection.getOrCreateKotlinClass(MsgBelongTo.class), Syntax.PROTO_2, r0);
        }

        public static MsgBelongTo[] values() {
            return (MsgBelongTo[]) a.clone();
        }

        @Override // com.lark.wire.o0
        public int getValue() {
            return this.value;
        }

        @JvmStatic
        public static final MsgBelongTo fromValue(int r1) {
            Companion.getClass();
            if (r1 == 0) goto L12;
            if (r1 == 1) goto L15;
            if (r1 == 2) goto L14;
            return null;
        L14:
            return CHAT;
        L15:
            return BOT;
        L12:
            return UNKNOWN;
        }

        public static MsgBelongTo valueOf(String r1) {
            return (MsgBelongTo) r27.a.a(MsgBelongTo.class, r1);
        }

        public MsgBelongTo(String r1, int r2, int r3) {
            super(r1, r2);
            this.value = r3;
        }
    }

    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0010\u000e\n\u0002\b\u0003\u0018\u0000 \u00152\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00020\u0001:\u0002\u0014\u0015B\u001b\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\b\u0010\u0011\u001a\u00020\u0002H\u0016J\b\u0010\u0012\u001a\u00020\u0013H\u0016R\u0015\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\n\n\u0002\u0010\f\u001a\u0004\b\n\u0010\u000bR\u0015\u0010\r\u001a\u0004\u0018\u00010\t¢\u0006\n\n\u0002\u0010\f\u001a\u0004\b\u000e\u0010\u000bR\u0015\u0010\u000f\u001a\u0004\u0018\u00010\t¢\u0006\n\n\u0002\u0010\f\u001a\u0004\b\u0010\u0010\u000b¨\u0006\u0016"}, d2 = {"Lcom/lark/kmp/pb/basic/v1/TodoDetail$Permission;", "Lcom/lark/wire/Message;", "Lcom/lark/kmp/pb/basic/v1/TodoDetail$Permission$Builder;", "builder", "unknownFields", "Lokio/ByteString;", "<init>", "(Lcom/lark/kmp/pb/basic/v1/TodoDetail$Permission$Builder;Lokio/ByteString;)V", "can_complete_todo", "", "getCan_complete_todo", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "can_complete_self", "getCan_complete_self", "can_follow", "getCan_follow", "newBuilder", "toString", "", "Builder", "Companion", "rust-sdk-kotlin-pb_release"}, k = 1, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
    public static final class Permission extends com.lark.wire.Message<Permission, a> {
        public static final ProtoAdapter<Permission> ADAPTER = null;
        public static final c Companion = null;
        private static final long serialVersionUID = 0;
        private final Boolean can_complete_self;
        private final Boolean can_complete_todo;
        private final Boolean can_follow;

        public static final class a extends com.lark.wire.Message.a<Permission, a> {
            public Boolean d;
            public Boolean e;
            public Boolean f;

            @Override // com.lark.wire.Message.a
            public final com.lark.wire.Message b() {
                return new Permission(this, c(), null);
            }

            public a() {
            }
        }

        public static final class b extends ProtoAdapter<Permission> {
            @Override // com.lark.wire.ProtoAdapter
            public final Permission c(g0 r6) {
                Intrinsics.checkNotNullParameter(r6, "reader");
                a r0 = new a();
                long r1 = r6.c();
            L3:
                int r3 = r6.e();
                if (r3 == (-1)) goto L16;
                if (r3 != 1) goto L8;
                r0.d = (Boolean) ProtoAdapter.g.c(r6);
                goto L3
            L8:
                if (r3 != 2) goto L10;
                r0.e = (Boolean) ProtoAdapter.g.c(r6);
                goto L3
            L10:
                if (r3 != 3) goto L11;
                r0.f = (Boolean) ProtoAdapter.g.c(r6);
                goto L3
            L11:
                r6.j(r3);
                Unit r4 = Unit.INSTANCE;
                goto L3
            L16:
                return new Permission(r0, r6.d(r1), null);
            }

            @Override // com.lark.wire.ProtoAdapter
            public final int k(Permission r5) {
                Permission r6 = r5;
                Intrinsics.checkNotNullParameter(r6, "value");
                int r0 = r6.unknownFields().size();
                l r1 = ProtoAdapter.g;
                return ((r0 + r1.l(1, r6.getCan_complete_todo())) + r1.l(2, r6.getCan_complete_self())) + r1.l(3, r6.getCan_follow());
            }

            @Override // com.lark.wire.ProtoAdapter
            public final void f(j0 r4, Permission r5) {
                Permission r6 = r5;
                Intrinsics.checkNotNullParameter(r4, "writer");
                Intrinsics.checkNotNullParameter(r6, "value");
                l r0 = ProtoAdapter.g;
                r0.i(r4, 1, r6.getCan_complete_todo());
                r0.i(r4, 2, r6.getCan_complete_self());
                r0.i(r4, 3, r6.getCan_follow());
                r4.a(r6.unknownFields());
            }

            @Override // com.lark.wire.ProtoAdapter
            public final void g(n0 r4, Permission r5) {
                Permission r6 = r5;
                Intrinsics.checkNotNullParameter(r4, "writer");
                Intrinsics.checkNotNullParameter(r6, "value");
                r4.d(r6.unknownFields());
                l r0 = ProtoAdapter.g;
                r0.j(r4, 3, r6.getCan_follow());
                r0.j(r4, 2, r6.getCan_complete_self());
                r0.j(r4, 1, r6.getCan_complete_todo());
            }

            public b(FieldEncoding r7, KClass<Permission> r8, Syntax r9) {
                super(r7, r8, "type.googleapis.com/basic.v1.TodoDetail.Permission", r9, null);
            }
        }

        public static final class c {
            public c() {
            }
        }

        public /* synthetic */ Permission(a r1, ByteString r2, DefaultConstructorMarker r3) {
            this(r1, r2);
        }

        static {
            Companion = new c();
            ADAPTER = new b(FieldEncoding.LENGTH_DELIMITED, Reflection.getOrCreateKotlinClass(Permission.class), Syntax.PROTO_2);
        }

        @Override // com.lark.wire.Message
        public a newBuilder() {
            a r0 = new a();
            r0.d = this.can_complete_todo;
            r0.e = this.can_complete_self;
            r0.f = this.can_follow;
            r0.a(unknownFields());
            return r0;
        }

        @Override // com.lark.wire.Message
        public String toString() {
            return Reflection.getOrCreateKotlinClass(Permission.class).getSimpleName() + '@' + hashCode();
        }

        public final Boolean getCan_complete_self() {
            return this.can_complete_self;
        }

        public final Boolean getCan_complete_todo() {
            return this.can_complete_todo;
        }

        public final Boolean getCan_follow() {
            return this.can_follow;
        }

        @Override // com.lark.wire.Message
        public /* bridge */ /* synthetic */ com.lark.wire.Message.a newBuilder() {
            return newBuilder();
        }

        public Permission(a r2, ByteString r3) {
            super(ADAPTER, r3);
            this.can_complete_todo = r2.d;
            this.can_complete_self = r2.e;
            this.can_follow = r2.f;
        }

        public /* synthetic */ Permission(a r1, ByteString r2, int r3, DefaultConstructorMarker r4) {
            if ((r3 & 2) == 0) goto L5;
            r2 = ByteString.EMPTY;
        L5:
            this(r1, r2);
        }
    }

    public static final class a extends com.lark.wire.Message.a<TodoDetail, a> {
        public Boolean A;
        public String d;
        public List<TodoAssignee> e;
        public String f;
        public Long g;
        public String h;
        public Boolean i;
        public MsgBelongTo j;
        public RichContent k;
        public List<TodoFollower> l;
        public TodoUser m;
        public Long n;
        public Long o;
        public TodoSource p;
        public Boolean q;
        public Map<String, Permission> r;
        public Boolean s;
        public CustomComplete t;
        public String u;
        public List<TodoReminder> v;
        public EntityNumInfo w;
        public TodoOwner x;
        public TaskMode y;
        public Long z;

        @Override // com.lark.wire.Message.a
        public final com.lark.wire.Message b() {
            return new TodoDetail(this, c(), null);
        }

        public a() {
            this.e = CollectionsKt.emptyList();
            this.l = CollectionsKt.emptyList();
            this.r = MapsKt.emptyMap();
            this.v = CollectionsKt.emptyList();
        }
    }

    public static final class b {
        public b() {
        }
    }

    public /* synthetic */ TodoDetail(a r1, ByteString r2, DefaultConstructorMarker r3) {
        this(r1, r2);
    }

    @Deprecated(message = "owner is deprecated")
    public static /* synthetic */ void getOwner$annotations() {
    }

    static {
        Companion = new b();
        DEFAULT_SOURCE = TodoSource.TODO;
        final FieldEncoding r0 = FieldEncoding.LENGTH_DELIMITED;
        final KClass r1 = Reflection.getOrCreateKotlinClass(TodoDetail.class);
        final Syntax r2 = Syntax.PROTO_2;
        ADAPTER = new TodoDetail$Companion$ADAPTER$1(r0, r1, r2);
    }

    @Override // com.lark.wire.Message
    public a newBuilder() {
        a r0 = new a();
        r0.d = this.guid;
        r0.e = this.assignees;
        r0.f = this.summary;
        r0.g = this.due_time;
        r0.h = this.due_timezone;
        r0.i = this.is_all_day;
        r0.j = this.msg_belong_to;
        r0.k = this.rich_summary;
        r0.l = this.followers;
        r0.m = this.creator;
        r0.n = this.completed_milli_time;
        r0.o = this.deleted_milli_time;
        r0.p = this.source;
        r0.q = this.can_follow;
        r0.r = this.user_to_permission;
        r0.s = this.user_complete_enabled;
        r0.t = this.custom_complete;
        r0.u = this.rrule;
        r0.v = this.reminders;
        r0.w = this.entity_num;
        r0.x = this.owner;
        r0.y = this.mode;
        r0.z = this.start_milli_time;
        r0.A = this.is_milestone;
        r0.a(unknownFields());
        return r0;
    }

    @Override // com.lark.wire.Message
    public String toString() {
        return Reflection.getOrCreateKotlinClass(TodoDetail.class).getSimpleName() + '@' + hashCode();
    }

    public final List<TodoAssignee> getAssignees() {
        return this.assignees;
    }

    public final Boolean getCan_follow() {
        return this.can_follow;
    }

    public final Long getCompleted_milli_time() {
        return this.completed_milli_time;
    }

    public final TodoUser getCreator() {
        return this.creator;
    }

    public final CustomComplete getCustom_complete() {
        return this.custom_complete;
    }

    public final Long getDeleted_milli_time() {
        return this.deleted_milli_time;
    }

    public final Long getDue_time() {
        return this.due_time;
    }

    public final String getDue_timezone() {
        return this.due_timezone;
    }

    public final EntityNumInfo getEntity_num() {
        return this.entity_num;
    }

    public final List<TodoFollower> getFollowers() {
        return this.followers;
    }

    public final String getGuid() {
        return this.guid;
    }

    public final TaskMode getMode() {
        return this.mode;
    }

    public final MsgBelongTo getMsg_belong_to() {
        return this.msg_belong_to;
    }

    public final TodoOwner getOwner() {
        return this.owner;
    }

    public final List<TodoReminder> getReminders() {
        return this.reminders;
    }

    public final RichContent getRich_summary() {
        return this.rich_summary;
    }

    public final String getRrule() {
        return this.rrule;
    }

    public final TodoSource getSource() {
        return this.source;
    }

    public final Long getStart_milli_time() {
        return this.start_milli_time;
    }

    public final String getSummary() {
        return this.summary;
    }

    public final Boolean getUser_complete_enabled() {
        return this.user_complete_enabled;
    }

    public final Map<String, Permission> getUser_to_permission() {
        return this.user_to_permission;
    }

    public final Boolean is_all_day() {
        return this.is_all_day;
    }

    public final Boolean is_milestone() {
        return this.is_milestone;
    }

    @Override // com.lark.wire.Message
    public /* bridge */ /* synthetic */ com.lark.wire.Message.a newBuilder() {
        return newBuilder();
    }

    public TodoDetail(a r2, ByteString r3) {
        super(ADAPTER, r3);
        this.guid = r2.d;
        this.assignees = com.lark.wire.internal.a.c("assignees", r2.e);
        this.summary = r2.f;
        this.due_time = r2.g;
        this.due_timezone = r2.h;
        this.is_all_day = r2.i;
        this.msg_belong_to = r2.j;
        this.rich_summary = r2.k;
        this.followers = com.lark.wire.internal.a.c("followers", r2.l);
        this.creator = r2.m;
        this.completed_milli_time = r2.n;
        this.deleted_milli_time = r2.o;
        this.source = r2.p;
        this.can_follow = r2.q;
        this.user_to_permission = com.lark.wire.internal.a.d("user_to_permission", r2.r);
        this.user_complete_enabled = r2.s;
        this.custom_complete = r2.t;
        this.rrule = r2.u;
        this.reminders = com.lark.wire.internal.a.c("reminders", r2.v);
        this.entity_num = r2.w;
        this.owner = r2.x;
        this.mode = r2.y;
        this.start_milli_time = r2.z;
        this.is_milestone = r2.A;
    }

    public /* synthetic */ TodoDetail(a r1, ByteString r2, int r3, DefaultConstructorMarker r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = ByteString.EMPTY;
    L5:
        this(r1, r2);
    }
}
