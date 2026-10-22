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
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
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
@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u0000 12\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00020\u0001:\u00040123B\u001b\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\b\u0010.\u001a\u00020\u0002H\u0016J\b\u0010/\u001a\u00020\tH\u0016R\u0013\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0013\u0010\f\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000bR\u0013\u0010\u000e\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000bR\u0011\u0010\u0010\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u000bR\u0011\u0010\u0012\u001a\u00020\u0013¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0013\u0010\u0016\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u000bR\u0013\u0010\u0018\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u000bR\u0013\u0010\u001a\u001a\u0004\u0018\u00010\u001b¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001dR\u0013\u0010\u001e\u001a\u0004\u0018\u00010\u001f¢\u0006\b\n\u0000\u001a\u0004\b \u0010!R\u0013\u0010\"\u001a\u0004\u0018\u00010#¢\u0006\b\n\u0000\u001a\u0004\b$\u0010%R\u001d\u0010&\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\t0'¢\u0006\b\n\u0000\u001a\u0004\b(\u0010)R\u0013\u0010*\u001a\u0004\u0018\u00010+¢\u0006\b\n\u0000\u001a\u0004\b,\u0010-¨\u00064"}, d2 = {"Lcom/lark/kmp/pb/basic/v1/Draft;", "Lcom/lark/wire/Message;", "Lcom/lark/kmp/pb/basic/v1/Draft$Builder;", "builder", "unknownFields", "Lokio/ByteString;", "<init>", "(Lcom/lark/kmp/pb/basic/v1/Draft$Builder;Lokio/ByteString;)V", "id", "", "getId", "()Ljava/lang/String;", "chat_id", "getChat_id", "message_id", "getMessage_id", "content", "getContent", "type", "Lcom/lark/kmp/pb/basic/v1/Draft$Type;", "getType", "()Lcom/lark/kmp/pb/basic/v1/Draft$Type;", "edit_message_id", "getEdit_message_id", "thread_id", "getThread_id", "schedule_info", "Lcom/lark/kmp/pb/basic/v1/Draft$ScheduleInfo;", "getSchedule_info", "()Lcom/lark/kmp/pb/basic/v1/Draft$ScheduleInfo;", "partial_reply_info", "Lcom/lark/kmp/pb/basic/v1/Message$PartialReplyInfo;", "getPartial_reply_info", "()Lcom/lark/kmp/pb/basic/v1/Message$PartialReplyInfo;", "cloud_draft_content", "Lcom/lark/kmp/pb/basic/v1/CloudDraftContent;", "getCloud_draft_content", "()Lcom/lark/kmp/pb/basic/v1/CloudDraftContent;", "local_extra", "", "getLocal_extra", "()Ljava/util/Map;", "attachment_snapshot", "Lcom/lark/kmp/pb/basic/v1/DraftAttachmentSnapshot;", "getAttachment_snapshot", "()Lcom/lark/kmp/pb/basic/v1/DraftAttachmentSnapshot;", "newBuilder", "toString", "Builder", "Companion", "Type", "ScheduleInfo", "rust-sdk-kotlin-pb_release"}, k = 1, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
public final class Draft extends com.lark.wire.Message<Draft, a> {
    public static final ProtoAdapter<Draft> ADAPTER = null;
    public static final b Companion = null;
    public static final String DEFAULT_CHAT_ID = "";
    public static final String DEFAULT_EDIT_MESSAGE_ID = "";
    public static final String DEFAULT_ID = "";
    public static final String DEFAULT_MESSAGE_ID = "";
    private static final long serialVersionUID = 0;
    private final DraftAttachmentSnapshot attachment_snapshot;
    private final String chat_id;
    private final CloudDraftContent cloud_draft_content;
    private final String content;
    private final String edit_message_id;
    private final String id;
    private final Map<String, String> local_extra;
    private final String message_id;
    private final Message.PartialReplyInfo partial_reply_info;
    private final ScheduleInfo schedule_info;
    private final String thread_id;
    private final Type type;

    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0003\u0018\u0000 \u00152\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00020\u0001:\u0002\u0014\u0015B\u001b\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\b\u0010\u0011\u001a\u00020\u0002H\u0016J\b\u0010\u0012\u001a\u00020\u0013H\u0016R\u0013\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0015\u0010\f\u001a\u0004\u0018\u00010\r¢\u0006\n\n\u0002\u0010\u0010\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u0016"}, d2 = {"Lcom/lark/kmp/pb/basic/v1/Draft$ScheduleInfo;", "Lcom/lark/wire/Message;", "Lcom/lark/kmp/pb/basic/v1/Draft$ScheduleInfo$Builder;", "builder", "unknownFields", "Lokio/ByteString;", "<init>", "(Lcom/lark/kmp/pb/basic/v1/Draft$ScheduleInfo$Builder;Lokio/ByteString;)V", "item", "Lcom/lark/kmp/pb/basic/v1/ScheduleMessageItem;", "getItem", "()Lcom/lark/kmp/pb/basic/v1/ScheduleMessageItem;", "schedule_time", "", "getSchedule_time", "()Ljava/lang/Long;", "Ljava/lang/Long;", "newBuilder", "toString", "", "Builder", "Companion", "rust-sdk-kotlin-pb_release"}, k = 1, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
    public static final class ScheduleInfo extends com.lark.wire.Message<ScheduleInfo, a> {
        public static final ProtoAdapter<ScheduleInfo> ADAPTER = null;
        public static final c Companion = null;
        private static final long serialVersionUID = 0;
        private final ScheduleMessageItem item;
        private final Long schedule_time;

        public static final class a extends com.lark.wire.Message.a<ScheduleInfo, a> {
            public ScheduleMessageItem d;
            public Long e;

            @Override // com.lark.wire.Message.a
            public final com.lark.wire.Message b() {
                return new ScheduleInfo(this, c(), null);
            }

            public a() {
            }
        }

        public static final class b extends ProtoAdapter<ScheduleInfo> {
            @Override // com.lark.wire.ProtoAdapter
            public final ScheduleInfo c(g0 r6) {
                Intrinsics.checkNotNullParameter(r6, "reader");
                a r0 = new a();
                long r1 = r6.c();
            L3:
                int r3 = r6.e();
                if (r3 == (-1)) goto L13;
                if (r3 != 1) goto L8;
                r0.d = ScheduleMessageItem.ADAPTER.c(r6);
                goto L3
            L8:
                if (r3 != 2) goto L9;
                r0.e = (Long) ProtoAdapter.k.c(r6);
                goto L3
            L9:
                r6.j(r3);
                Unit r4 = Unit.INSTANCE;
                goto L3
            L13:
                return new ScheduleInfo(r0, r6.d(r1), null);
            }

            @Override // com.lark.wire.ProtoAdapter
            public final int k(ScheduleInfo r5) {
                ScheduleInfo r6 = r5;
                Intrinsics.checkNotNullParameter(r6, "value");
                return (r6.unknownFields().size() + ScheduleMessageItem.ADAPTER.l(1, r6.getItem())) + ProtoAdapter.k.l(2, r6.getSchedule_time());
            }

            @Override // com.lark.wire.ProtoAdapter
            public final void f(j0 r4, ScheduleInfo r5) {
                ScheduleInfo r6 = r5;
                Intrinsics.checkNotNullParameter(r4, "writer");
                Intrinsics.checkNotNullParameter(r6, "value");
                ScheduleMessageItem.ADAPTER.i(r4, 1, r6.getItem());
                ProtoAdapter.k.i(r4, 2, r6.getSchedule_time());
                r4.a(r6.unknownFields());
            }

            @Override // com.lark.wire.ProtoAdapter
            public final void g(n0 r4, ScheduleInfo r5) {
                ScheduleInfo r6 = r5;
                Intrinsics.checkNotNullParameter(r4, "writer");
                Intrinsics.checkNotNullParameter(r6, "value");
                r4.d(r6.unknownFields());
                ProtoAdapter.k.j(r4, 2, r6.getSchedule_time());
                ScheduleMessageItem.ADAPTER.j(r4, 1, r6.getItem());
            }

            public b(FieldEncoding r7, KClass<ScheduleInfo> r8, Syntax r9) {
                super(r7, r8, "type.googleapis.com/basic.v1.Draft.ScheduleInfo", r9, null);
            }
        }

        public static final class c {
            public c() {
            }
        }

        public /* synthetic */ ScheduleInfo(a r1, ByteString r2, DefaultConstructorMarker r3) {
            this(r1, r2);
        }

        static {
            Companion = new c();
            ADAPTER = new b(FieldEncoding.LENGTH_DELIMITED, Reflection.getOrCreateKotlinClass(ScheduleInfo.class), Syntax.PROTO_2);
        }

        @Override // com.lark.wire.Message
        public a newBuilder() {
            a r0 = new a();
            r0.d = this.item;
            r0.e = this.schedule_time;
            r0.a(unknownFields());
            return r0;
        }

        @Override // com.lark.wire.Message
        public String toString() {
            return Reflection.getOrCreateKotlinClass(ScheduleInfo.class).getSimpleName() + '@' + hashCode();
        }

        public final ScheduleMessageItem getItem() {
            return this.item;
        }

        public final Long getSchedule_time() {
            return this.schedule_time;
        }

        @Override // com.lark.wire.Message
        public /* bridge */ /* synthetic */ com.lark.wire.Message.a newBuilder() {
            return newBuilder();
        }

        public ScheduleInfo(a r2, ByteString r3) {
            super(ADAPTER, r3);
            this.item = r2.d;
            this.schedule_time = r2.e;
        }

        public /* synthetic */ ScheduleInfo(a r1, ByteString r2, int r3, DefaultConstructorMarker r4) {
            if ((r3 & 2) == 0) goto L5;
            r2 = ByteString.EMPTY;
        L5:
            this(r1, r2);
        }
    }

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\f\b\u0086\u0081\u0002\u0018\u0000 \u000f2\u00020\u00012\b\u0012\u0004\u0012\u00020\u00000\u0002:\u0001\u000fB\u0011\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u0004X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000e¨\u0006\u0010"}, d2 = {"Lcom/lark/kmp/pb/basic/v1/Draft$Type;", "Lcom/lark/wire/WireEnum;", "", "value", "", "<init>", "(Ljava/lang/String;II)V", "getValue", "()I", "TEXT", "POST", "INDIVIDUAL_TOPIC", "EDIT_MESSAGE", "MSG_THREAD", "SCHEDULE_MESSAGE", "Companion", "rust-sdk-kotlin-pb_release"}, k = 1, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
    public static final enum Type extends Enum<Type> implements o0 {
        public static final ProtoAdapter<Type> ADAPTER = null;
        public static final b Companion = null;
        public static final Type EDIT_MESSAGE = null;
        public static final Type INDIVIDUAL_TOPIC = null;
        public static final Type MSG_THREAD = null;
        public static final Type POST = null;
        public static final Type SCHEDULE_MESSAGE = null;
        public static final Type TEXT = null;
        public static final /* synthetic */ Type[] a = null;
        public static final /* synthetic */ EnumEntries b = null;
        private final int value;

        public static final class a extends d<Type> {
            @Override // com.lark.wire.d
            public final o0 n(int r2) {
                Type.Companion.getClass();
                return b.a(r2);
            }

            public a(KClass<Type> r2, Syntax r3) {
                super(r2, r3, null);
            }
        }

        public static final class b {
            public b() {
            }

            @JvmStatic
            public static Type a(int r0) {
                switch(r0) {
                    case 1: goto L10;
                    case 2: goto L16;
                    case 3: goto L15;
                    case 4: goto L14;
                    case 5: goto L13;
                    case 6: goto L12;
                    default: goto L3;
                };
            L3:
                return null;
            L12:
                return Type.SCHEDULE_MESSAGE;
            L13:
                return Type.MSG_THREAD;
            L14:
                return Type.EDIT_MESSAGE;
            L15:
                return Type.INDIVIDUAL_TOPIC;
            L16:
                return Type.POST;
            L10:
                return Type.TEXT;
            }
        }

        @JvmStatic
        public static final Type fromValue(int r1) {
            Companion.getClass();
            return b.a(r1);
        }

        public static EnumEntries<Type> getEntries() {
            return b;
        }

        static {
            Type r0 = new Type("TEXT", 0, 1);
            TEXT = r0;
            Type r1 = new Type("POST", 1, 2);
            POST = r1;
            Type r4 = new Type("INDIVIDUAL_TOPIC", 2, 3);
            INDIVIDUAL_TOPIC = r4;
            Type r6 = new Type("EDIT_MESSAGE", 3, 4);
            EDIT_MESSAGE = r6;
            Type r8 = new Type("MSG_THREAD", 4, 5);
            MSG_THREAD = r8;
            Type r10 = new Type("SCHEDULE_MESSAGE", 5, 6);
            SCHEDULE_MESSAGE = r10;
            Type[] r12 = {r0, r1, r4, r6, r8, r10};
            a = r12;
            b = EnumEntriesKt.enumEntries(r12);
            Companion = new b();
            ADAPTER = new a(Reflection.getOrCreateKotlinClass(Type.class), Syntax.PROTO_2);
        }

        public static Type[] values() {
            return (Type[]) a.clone();
        }

        @Override // com.lark.wire.o0
        public int getValue() {
            return this.value;
        }

        public static Type valueOf(String r1) {
            return (Type) r27.a.a(Type.class, r1);
        }

        public Type(String r1, int r2, int r3) {
            super(r1, r2);
            this.value = r3;
        }
    }

    public static final class a extends com.lark.wire.Message.a<Draft, a> {
        public String d;
        public String e;
        public String f;
        public String g;
        public Type h;
        public String i;
        public String j;
        public ScheduleInfo k;
        public Message.PartialReplyInfo l;
        public CloudDraftContent m;
        public Map<String, String> n;
        public DraftAttachmentSnapshot o;

        @Override // com.lark.wire.Message.a
        public final com.lark.wire.Message b() {
            return new Draft(this, c(), null);
        }

        public a() {
            this.n = MapsKt.emptyMap();
        }
    }

    public static final class b {
        public b() {
        }
    }

    public /* synthetic */ Draft(a r1, ByteString r2, DefaultConstructorMarker r3) {
        this(r1, r2);
    }

    static {
        Companion = new b();
        final FieldEncoding r0 = FieldEncoding.LENGTH_DELIMITED;
        final KClass r1 = Reflection.getOrCreateKotlinClass(Draft.class);
        final Syntax r2 = Syntax.PROTO_2;
        ADAPTER = new Draft$Companion$ADAPTER$1(r0, r1, r2);
    }

    @Override // com.lark.wire.Message
    public a newBuilder() {
        a r0 = new a();
        r0.d = this.id;
        r0.e = this.chat_id;
        r0.f = this.message_id;
        r0.g = this.content;
        r0.h = this.type;
        r0.i = this.edit_message_id;
        r0.j = this.thread_id;
        r0.k = this.schedule_info;
        r0.l = this.partial_reply_info;
        r0.m = this.cloud_draft_content;
        r0.n = this.local_extra;
        r0.o = this.attachment_snapshot;
        r0.a(unknownFields());
        return r0;
    }

    @Override // com.lark.wire.Message
    public String toString() {
        return Reflection.getOrCreateKotlinClass(Draft.class).getSimpleName() + '@' + hashCode();
    }

    public final DraftAttachmentSnapshot getAttachment_snapshot() {
        return this.attachment_snapshot;
    }

    public final String getChat_id() {
        return this.chat_id;
    }

    public final CloudDraftContent getCloud_draft_content() {
        return this.cloud_draft_content;
    }

    public final String getContent() {
        return this.content;
    }

    public final String getEdit_message_id() {
        return this.edit_message_id;
    }

    public final String getId() {
        return this.id;
    }

    public final Map<String, String> getLocal_extra() {
        return this.local_extra;
    }

    public final String getMessage_id() {
        return this.message_id;
    }

    public final Message.PartialReplyInfo getPartial_reply_info() {
        return this.partial_reply_info;
    }

    public final ScheduleInfo getSchedule_info() {
        return this.schedule_info;
    }

    public final String getThread_id() {
        return this.thread_id;
    }

    public final Type getType() {
        return this.type;
    }

    @Override // com.lark.wire.Message
    public /* bridge */ /* synthetic */ com.lark.wire.Message.a newBuilder() {
        return newBuilder();
    }

    public Draft(a r2, ByteString r3) {
        super(ADAPTER, r3);
        this.id = r2.d;
        this.chat_id = r2.e;
        this.message_id = r2.f;
        String r4 = r2.g;
        Intrinsics.checkNotNull(r4);
        this.content = r4;
        Type r5 = r2.h;
        Intrinsics.checkNotNull(r5);
        this.type = r5;
        this.edit_message_id = r2.i;
        this.thread_id = r2.j;
        this.schedule_info = r2.k;
        this.partial_reply_info = r2.l;
        this.cloud_draft_content = r2.m;
        this.local_extra = com.lark.wire.internal.a.d("local_extra", r2.n);
        this.attachment_snapshot = r2.o;
    }

    public /* synthetic */ Draft(a r1, ByteString r2, int r3, DefaultConstructorMarker r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = ByteString.EMPTY;
    L5:
        this(r1, r2);
    }
}
