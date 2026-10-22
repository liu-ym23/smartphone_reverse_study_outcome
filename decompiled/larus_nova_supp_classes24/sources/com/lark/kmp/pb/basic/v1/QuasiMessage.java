package com.lark.kmp.pb.basic.v1;

import com.lark.wire.FieldEncoding;
import com.lark.wire.ProtoAdapter;
import com.lark.wire.Syntax;
import com.lark.wire.d;
import com.lark.wire.g0;
import com.lark.wire.j0;
import com.lark.wire.l;
import com.lark.wire.n0;
import com.lark.wire.o0;
import com.lark.wire.s;
import com.lark.wire.t;
import com.lark.wire.w;
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
@Metadata(d1 = {"\u0000\u0088\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\t\n\u0002\b\u0007\n\u0002\u0010 \n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\r\u0018\u0000 o2\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00020\u0001:\u0003nopB\u001b\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\b\u0010l\u001a\u00020\u0002H\u0016J\b\u0010m\u001a\u00020\tH\u0016R\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\f\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000bR\u0013\u0010\u000e\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000bR\u0011\u0010\u0010\u001a\u00020\u0011¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0011\u0010\u0014\u001a\u00020\u0015¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u0015\u0010\u0018\u001a\u0004\u0018\u00010\u0019¢\u0006\n\n\u0002\u0010\u001c\u001a\u0004\b\u001a\u0010\u001bR\u0011\u0010\u001d\u001a\u00020\u001e¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010 R\u0013\u0010!\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010\u000bR\u0013\u0010#\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b$\u0010\u000bR\u0013\u0010%\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b&\u0010\u000bR\u0011\u0010'\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b(\u0010\u000bR\u0011\u0010)\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b*\u0010\u000bR\u0011\u0010+\u001a\u00020,¢\u0006\b\n\u0000\u001a\u0004\b-\u0010.R\u0015\u0010/\u001a\u0004\u0018\u00010\u0019¢\u0006\n\n\u0002\u0010\u001c\u001a\u0004\b0\u0010\u001bR\u0015\u00101\u001a\u0004\u0018\u00010\u0019¢\u0006\n\n\u0002\u0010\u001c\u001a\u0004\b2\u0010\u001bR\u0017\u00103\u001a\b\u0012\u0004\u0012\u00020\t04¢\u0006\b\n\u0000\u001a\u0004\b5\u00106R \u00107\u001a\u0004\u0018\u00010,8\u0006X\u0087\u0004¢\u0006\u0010\n\u0002\u0010<\u0012\u0004\b8\u00109\u001a\u0004\b:\u0010;R\u0013\u0010=\u001a\u0004\u0018\u00010>¢\u0006\b\n\u0000\u001a\u0004\b?\u0010@R\u0015\u0010A\u001a\u0004\u0018\u00010\u0019¢\u0006\n\n\u0002\u0010\u001c\u001a\u0004\bB\u0010\u001bR\u0013\u0010C\u001a\u0004\u0018\u00010D¢\u0006\b\n\u0000\u001a\u0004\bE\u0010FR\u0013\u0010G\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\bH\u0010\u000bR\u0015\u0010I\u001a\u0004\u0018\u00010\u0019¢\u0006\n\n\u0002\u0010\u001c\u001a\u0004\bJ\u0010\u001bR\u0013\u0010K\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\bL\u0010\u000bR\u0013\u0010M\u001a\u0004\u0018\u00010N¢\u0006\b\n\u0000\u001a\u0004\bO\u0010PR\u0013\u0010Q\u001a\u0004\u0018\u00010R¢\u0006\b\n\u0000\u001a\u0004\bS\u0010TR\u0013\u0010U\u001a\u0004\u0018\u00010V¢\u0006\b\n\u0000\u001a\u0004\bW\u0010XR\u0015\u0010Y\u001a\u0004\u0018\u00010,¢\u0006\n\n\u0002\u0010<\u001a\u0004\bZ\u0010;R\u0015\u0010[\u001a\u0004\u0018\u00010,¢\u0006\n\n\u0002\u0010<\u001a\u0004\b\\\u0010;R\u0013\u0010]\u001a\u0004\u0018\u00010^¢\u0006\b\n\u0000\u001a\u0004\b_\u0010`R\u0015\u0010a\u001a\u0004\u0018\u00010,¢\u0006\n\n\u0002\u0010<\u001a\u0004\bb\u0010;R\u0013\u0010c\u001a\u0004\u0018\u00010d¢\u0006\b\n\u0000\u001a\u0004\be\u0010fR\u0015\u0010g\u001a\u0004\u0018\u00010\u0015¢\u0006\n\n\u0002\u0010i\u001a\u0004\bg\u0010hR\u0015\u0010j\u001a\u0004\u0018\u00010,¢\u0006\n\n\u0002\u0010<\u001a\u0004\bk\u0010;¨\u0006q"}, d2 = {"Lcom/lark/kmp/pb/basic/v1/QuasiMessage;", "Lcom/lark/wire/Message;", "Lcom/lark/kmp/pb/basic/v1/QuasiMessage$Builder;", "builder", "unknownFields", "Lokio/ByteString;", "<init>", "(Lcom/lark/kmp/pb/basic/v1/QuasiMessage$Builder;Lokio/ByteString;)V", "cid", "", "getCid", "()Ljava/lang/String;", "chat_id", "getChat_id", "root_id", "getRoot_id", "type", "Lcom/lark/kmp/pb/basic/v1/Message$Type;", "getType", "()Lcom/lark/kmp/pb/basic/v1/Message$Type;", "should_notify", "", "getShould_notify", "()Z", "position", "", "getPosition", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "content", "Lcom/lark/kmp/pb/basic/v1/Content;", "getContent", "()Lcom/lark/kmp/pb/basic/v1/Content;", "parent_id", "getParent_id", "parent_source_id", "getParent_source_id", "root_source_id", "getRoot_source_id", "id", "getId", "from_id", "getFrom_id", "create_time", "", "getCreate_time", "()J", "unread_count", "getUnread_count", "read_count", "getRead_count", "unread_chatter_ids", "", "getUnread_chatter_ids", "()Ljava/util/List;", "image_compressed_size_kb", "getImage_compressed_size_kb$annotations", "()V", "getImage_compressed_size_kb", "()Ljava/lang/Long;", "Ljava/lang/Long;", "status", "Lcom/lark/kmp/pb/basic/v1/QuasiMessage$Status;", "getStatus", "()Lcom/lark/kmp/pb/basic/v1/QuasiMessage$Status;", "version", "getVersion", "channel", "Lcom/lark/kmp/pb/basic/v1/Channel;", "getChannel", "()Lcom/lark/kmp/pb/basic/v1/Channel;", "thread_id", "getThread_id", "thread_position", "getThread_position", "crypto_token", "getCrypto_token", "dlp_state", "Lcom/lark/kmp/pb/basic/v1/MessageDLPState;", "getDlp_state", "()Lcom/lark/kmp/pb/basic/v1/MessageDLPState;", "in_chat_display_mode", "Lcom/lark/kmp/pb/basic/v1/Message$ChatDisplayModeSetting;", "getIn_chat_display_mode", "()Lcom/lark/kmp/pb/basic/v1/Message$ChatDisplayModeSetting;", "security_extra", "Lcom/lark/kmp/pb/basic/v1/SecurityESCReviewExtra;", "getSecurity_extra", "()Lcom/lark/kmp/pb/basic/v1/SecurityESCReviewExtra;", "ai_chat_mode_id", "getAi_chat_mode_id", "sync_to_chat_thread_root_id", "getSync_to_chat_thread_root_id", "sync_to_chat_message_type", "Lcom/lark/kmp/pb/basic/v1/Message$SyncToChatMessageType;", "getSync_to_chat_message_type", "()Lcom/lark/kmp/pb/basic/v1/Message$SyncToChatMessageType;", "sync_to_chat_related_message_id", "getSync_to_chat_related_message_id", "partial_reply_info", "Lcom/lark/kmp/pb/basic/v1/Message$PartialReplyInfo;", "getPartial_reply_info", "()Lcom/lark/kmp/pb/basic/v1/Message$PartialReplyInfo;", "is_new_topic", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "create_time_us", "getCreate_time_us", "newBuilder", "toString", "Builder", "Companion", "Status", "rust-sdk-kotlin-pb_release"}, k = 1, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
public final class QuasiMessage extends com.lark.wire.Message<QuasiMessage, a> {
    public static final ProtoAdapter<QuasiMessage> ADAPTER = null;
    public static final c Companion = null;
    public static final String DEFAULT_PARENT_ID = "";
    public static final String DEFAULT_PARENT_SOURCE_ID = "";
    public static final int DEFAULT_POSITION = 0;
    public static final int DEFAULT_READ_COUNT = 1;
    public static final String DEFAULT_ROOT_ID = "";
    public static final String DEFAULT_ROOT_SOURCE_ID = "";
    public static final Status DEFAULT_STATUS = null;
    public static final int DEFAULT_UNREAD_COUNT = 0;
    public static final int DEFAULT_VERSION = 0;
    private static final long serialVersionUID = 0;
    private final Long ai_chat_mode_id;
    private final Channel channel;
    private final String chat_id;
    private final String cid;
    private final Content content;
    private final long create_time;
    private final Long create_time_us;
    private final String crypto_token;
    private final MessageDLPState dlp_state;
    private final String from_id;
    private final String id;
    private final Long image_compressed_size_kb;
    private final Message.ChatDisplayModeSetting in_chat_display_mode;
    private final Boolean is_new_topic;
    private final String parent_id;
    private final String parent_source_id;
    private final Message.PartialReplyInfo partial_reply_info;
    private final Integer position;
    private final Integer read_count;
    private final String root_id;
    private final String root_source_id;
    private final SecurityESCReviewExtra security_extra;
    private final boolean should_notify;
    private final Status status;
    private final Message.SyncToChatMessageType sync_to_chat_message_type;
    private final Long sync_to_chat_related_message_id;
    private final Long sync_to_chat_thread_root_id;
    private final String thread_id;
    private final Integer thread_position;
    private final Message.Type type;
    private final List<String> unread_chatter_ids;
    private final Integer unread_count;
    private final Integer version;

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\b\b\u0086\u0081\u0002\u0018\u0000 \u000b2\u00020\u00012\b\u0012\u0004\u0012\u00020\u00000\u0002:\u0001\u000bB\u0011\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u0004X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bj\u0002\b\tj\u0002\b\n¨\u0006\f"}, d2 = {"Lcom/lark/kmp/pb/basic/v1/QuasiMessage$Status;", "Lcom/lark/wire/WireEnum;", "", "value", "", "<init>", "(Ljava/lang/String;II)V", "getValue", "()I", "PENDING", "FAILED", "Companion", "rust-sdk-kotlin-pb_release"}, k = 1, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
    public static final enum Status extends Enum<Status> implements o0 {
        public static final ProtoAdapter<Status> ADAPTER = null;
        public static final b Companion = null;
        public static final Status FAILED = null;
        public static final Status PENDING = null;
        public static final /* synthetic */ Status[] a = null;
        public static final /* synthetic */ EnumEntries b = null;
        private final int value;

        public static final class a extends d<Status> {
            @Override // com.lark.wire.d
            public final o0 n(int r2) {
                Status.Companion.getClass();
                if (r2 == 1) goto L9;
                if (r2 == 2) goto L11;
                return null;
            L11:
                return Status.FAILED;
            L9:
                return Status.PENDING;
            }

            public a(KClass<Status> r2, Syntax r3) {
                super(r2, r3, null);
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
            Status r0 = new Status("PENDING", 0, 1);
            PENDING = r0;
            Status r1 = new Status("FAILED", 1, 2);
            FAILED = r1;
            Status[] r4 = {r0, r1};
            a = r4;
            b = EnumEntriesKt.enumEntries(r4);
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

        @JvmStatic
        public static final Status fromValue(int r1) {
            Companion.getClass();
            if (r1 == 1) goto L9;
            if (r1 == 2) goto L11;
            return null;
        L11:
            return FAILED;
        L9:
            return PENDING;
        }

        public static Status valueOf(String r1) {
            return (Status) r27.a.a(Status.class, r1);
        }

        public Status(String r1, int r2, int r3) {
            super(r1, r2);
            this.value = r3;
        }
    }

    public static final class a extends com.lark.wire.Message.a<QuasiMessage, a> {
        public MessageDLPState A;
        public Message.ChatDisplayModeSetting B;
        public SecurityESCReviewExtra C;
        public Long D;
        public Long E;
        public Message.SyncToChatMessageType F;
        public Long G;
        public Message.PartialReplyInfo H;
        public Boolean I;
        public Long J;
        public String d;
        public String e;
        public String f;
        public Message.Type g;
        public Boolean h;
        public Integer i;
        public Content j;
        public String k;
        public String l;
        public String m;
        public String n;
        public String o;
        public Long p;
        public Integer q;
        public Integer r;
        public List<String> s;
        public Long t;
        public Status u;
        public Integer v;
        public Channel w;
        public String x;
        public Integer y;
        public String z;

        @Override // com.lark.wire.Message.a
        public final com.lark.wire.Message b() {
            return new QuasiMessage(this, c(), null);
        }

        public a() {
            this.s = CollectionsKt.emptyList();
        }
    }

    public static final class b extends ProtoAdapter<QuasiMessage> {
        @Override // com.lark.wire.ProtoAdapter
        public final QuasiMessage c(g0 r11) {
            Intrinsics.checkNotNullParameter(r11, "reader");
            a r1 = new a();
            ArrayList r2 = new ArrayList();
            long r3 = r11.c();
        L3:
            int r5 = r11.e();
            if (r5 == (-1)) goto L55;
            switch(r5) {
                case 1: goto L54;
                case 2: goto L53;
                case 3: goto L52;
                case 4: goto L61;
                case 5: goto L47;
                case 6: goto L46;
                case 7: goto L45;
                case 8: goto L44;
                case 9: goto L43;
                case 10: goto L42;
                case 11: goto L41;
                case 12: goto L40;
                case 13: goto L39;
                case 14: goto L38;
                case 15: goto L37;
                case 16: goto L36;
                case 17: goto L35;
                case 18: goto L59;
                case 19: goto L30;
                case 20: goto L29;
                case 21: goto L28;
                case 22: goto L27;
                case 23: goto L26;
                case 24: goto L57;
                case 25: goto L63;
                case 26: goto L17;
                case 27: goto L16;
                case 28: goto L15;
                case 29: goto L65;
                case 30: goto L10;
                case 31: goto L9;
                case 32: goto L8;
                case 33: goto L7;
                default: goto L6;
            };
        L57:
            r1.A = MessageDLPState.ADAPTER.c(r11);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L24
        L24:
            e = move-exception;
            r11.a(r5, FieldEncoding.VARINT, Long.valueOf(e.value));
            Unit r6 = Unit.INSTANCE;
            goto L3
        L59:
            r1.u = Status.ADAPTER.c(r11);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L33
        L33:
            e = move-exception;
            r11.a(r5, FieldEncoding.VARINT, Long.valueOf(e.value));
            Unit r7 = Unit.INSTANCE;
            goto L3
        L61:
            Message.Type r8 = Message.Type.ADAPTER.c(r11);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L50
            Intrinsics.checkNotNullParameter(r8, "type");     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L50
            r1.g = r8;     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L50
        L50:
            e = move-exception;
            r11.a(r5, FieldEncoding.VARINT, Long.valueOf(e.value));
            Unit r9 = Unit.INSTANCE;
            goto L3
        L63:
            r1.B = Message.ChatDisplayModeSetting.ADAPTER.c(r11);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L20
        L20:
            e = move-exception;
            r11.a(r5, FieldEncoding.VARINT, Long.valueOf(e.value));
            Unit r10 = Unit.INSTANCE;
            goto L3
        L65:
            r1.F = Message.SyncToChatMessageType.ADAPTER.c(r11);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L13
        L13:
            e = move-exception;
            r11.a(r5, FieldEncoding.VARINT, Long.valueOf(e.value));
            Unit r12 = Unit.INSTANCE;
            goto L3
        L7:
            r1.J = (Long) ProtoAdapter.k.c(r11);
            goto L3
        L8:
            r1.I = (Boolean) ProtoAdapter.g.c(r11);
            goto L3
        L9:
            r1.H = Message.PartialReplyInfo.ADAPTER.c(r11);
            goto L3
        L10:
            r1.G = (Long) ProtoAdapter.k.c(r11);
            goto L3
        L15:
            r1.E = (Long) ProtoAdapter.k.c(r11);
            goto L3
        L16:
            r1.D = (Long) ProtoAdapter.k.c(r11);
            goto L3
        L17:
            r1.C = SecurityESCReviewExtra.ADAPTER.c(r11);
            goto L3
        L26:
            ProtoAdapter.q.getClass();
            Intrinsics.checkNotNullParameter(r11, "reader");
            r1.z = r11.i();
            goto L3
        L27:
            r1.y = (Integer) ProtoAdapter.h.c(r11);
            goto L3
        L28:
            ProtoAdapter.q.getClass();
            Intrinsics.checkNotNullParameter(r11, "reader");
            r1.x = r11.i();
            goto L3
        L29:
            r1.w = Channel.ADAPTER.c(r11);
            goto L3
        L30:
            r1.v = (Integer) ProtoAdapter.h.c(r11);
            goto L3
        L35:
            r1.t = (Long) ProtoAdapter.k.c(r11);
            goto L3
        L36:
            ProtoAdapter.q.getClass();
            Intrinsics.checkNotNullParameter(r11, "reader");
            r2.add(r11.i());
            goto L3
        L37:
            r1.r = (Integer) ProtoAdapter.h.c(r11);
            goto L3
        L38:
            r1.q = (Integer) ProtoAdapter.h.c(r11);
            goto L3
        L39:
            r1.p = Long.valueOf(((Number) ProtoAdapter.k.c(r11)).longValue());
            goto L3
        L40:
            ProtoAdapter.q.getClass();
            Intrinsics.checkNotNullParameter(r11, "reader");
            String r13 = r11.i();
            Intrinsics.checkNotNullParameter(r13, "from_id");
            r1.o = r13;
            goto L3
        L41:
            ProtoAdapter.q.getClass();
            Intrinsics.checkNotNullParameter(r11, "reader");
            String r14 = r11.i();
            Intrinsics.checkNotNullParameter(r14, "id");
            r1.n = r14;
            goto L3
        L42:
            ProtoAdapter.q.getClass();
            Intrinsics.checkNotNullParameter(r11, "reader");
            r1.m = r11.i();
            goto L3
        L43:
            ProtoAdapter.q.getClass();
            Intrinsics.checkNotNullParameter(r11, "reader");
            r1.l = r11.i();
            goto L3
        L44:
            ProtoAdapter.q.getClass();
            Intrinsics.checkNotNullParameter(r11, "reader");
            r1.k = r11.i();
            goto L3
        L45:
            r1.j = Content.ADAPTER.c(r11);
            goto L3
        L46:
            r1.i = (Integer) ProtoAdapter.h.c(r11);
            goto L3
        L47:
            r1.h = Boolean.valueOf(((Boolean) ProtoAdapter.g.c(r11)).booleanValue());
            goto L3
        L52:
            ProtoAdapter.q.getClass();
            Intrinsics.checkNotNullParameter(r11, "reader");
            r1.f = r11.i();
            goto L3
        L53:
            ProtoAdapter.q.getClass();
            Intrinsics.checkNotNullParameter(r11, "reader");
            String r15 = r11.i();
            Intrinsics.checkNotNullParameter(r15, "chat_id");
            r1.e = r15;
            goto L3
        L54:
            ProtoAdapter.q.getClass();
            Intrinsics.checkNotNullParameter(r11, "reader");
            String r16 = r11.i();
            Intrinsics.checkNotNullParameter(r16, "cid");
            r1.d = r16;
            goto L3
        L6:
            r11.j(r5);
            Unit r17 = Unit.INSTANCE;
            goto L3
        L55:
            ByteString r19 = r11.d(r3);
            Intrinsics.checkNotNullParameter(r2, "unread_chatter_ids");
            com.lark.wire.internal.a.a(r2);
            r1.s = r2;
            return new QuasiMessage(r1, r19, null);
        }

        @Override // com.lark.wire.ProtoAdapter
        public final int k(QuasiMessage r9) {
            QuasiMessage r10 = r9;
            Intrinsics.checkNotNullParameter(r10, "value");
            int r0 = r10.unknownFields().size();
            w r1 = ProtoAdapter.q;
            int r2 = (((r0 + r1.l(1, r10.getCid())) + r1.l(2, r10.getChat_id())) + r1.l(3, r10.getRoot_id())) + Message.Type.ADAPTER.l(4, r10.getType());
            l r3 = ProtoAdapter.g;
            int r4 = r2 + r3.l(5, Boolean.valueOf(r10.getShould_notify()));
            s r5 = ProtoAdapter.h;
            int r6 = ((((((r4 + r5.l(6, r10.getPosition())) + Content.ADAPTER.l(7, r10.getContent())) + r1.l(8, r10.getParent_id())) + r1.l(9, r10.getParent_source_id())) + r1.l(10, r10.getRoot_source_id())) + r1.l(11, r10.getId())) + r1.l(12, r10.getFrom_id());
            t r7 = ProtoAdapter.k;
            return ((((((((((((((((((((r6 + r7.l(13, Long.valueOf(r10.getCreate_time()))) + r5.l(14, r10.getUnread_count())) + r5.l(15, r10.getRead_count())) + r1.a().l(16, r10.getUnread_chatter_ids())) + r7.l(17, r10.getImage_compressed_size_kb())) + Status.ADAPTER.l(18, r10.getStatus())) + r5.l(19, r10.getVersion())) + Channel.ADAPTER.l(20, r10.getChannel())) + r1.l(21, r10.getThread_id())) + r5.l(22, r10.getThread_position())) + r1.l(23, r10.getCrypto_token())) + MessageDLPState.ADAPTER.l(24, r10.getDlp_state())) + Message.ChatDisplayModeSetting.ADAPTER.l(25, r10.getIn_chat_display_mode())) + SecurityESCReviewExtra.ADAPTER.l(26, r10.getSecurity_extra())) + r7.l(27, r10.getAi_chat_mode_id())) + r7.l(28, r10.getSync_to_chat_thread_root_id())) + Message.SyncToChatMessageType.ADAPTER.l(29, r10.getSync_to_chat_message_type())) + r7.l(30, r10.getSync_to_chat_related_message_id())) + Message.PartialReplyInfo.ADAPTER.l(31, r10.getPartial_reply_info())) + r3.l(32, r10.is_new_topic())) + r7.l(33, r10.getCreate_time_us());
        }

        @Override // com.lark.wire.ProtoAdapter
        public final void f(j0 r8, QuasiMessage r9) {
            QuasiMessage r10 = r9;
            Intrinsics.checkNotNullParameter(r8, "writer");
            Intrinsics.checkNotNullParameter(r10, "value");
            w r0 = ProtoAdapter.q;
            r0.i(r8, 1, r10.getCid());
            r0.i(r8, 2, r10.getChat_id());
            r0.i(r8, 3, r10.getRoot_id());
            Message.Type.ADAPTER.i(r8, 4, r10.getType());
            l r1 = ProtoAdapter.g;
            r1.i(r8, 5, Boolean.valueOf(r10.getShould_notify()));
            s r2 = ProtoAdapter.h;
            r2.i(r8, 6, r10.getPosition());
            Content.ADAPTER.i(r8, 7, r10.getContent());
            r0.i(r8, 8, r10.getParent_id());
            r0.i(r8, 9, r10.getParent_source_id());
            r0.i(r8, 10, r10.getRoot_source_id());
            r0.i(r8, 11, r10.getId());
            r0.i(r8, 12, r10.getFrom_id());
            t r3 = ProtoAdapter.k;
            r3.i(r8, 13, Long.valueOf(r10.getCreate_time()));
            r2.i(r8, 14, r10.getUnread_count());
            r2.i(r8, 15, r10.getRead_count());
            r0.a().i(r8, 16, r10.getUnread_chatter_ids());
            r3.i(r8, 17, r10.getImage_compressed_size_kb());
            Status.ADAPTER.i(r8, 18, r10.getStatus());
            r2.i(r8, 19, r10.getVersion());
            Channel.ADAPTER.i(r8, 20, r10.getChannel());
            r0.i(r8, 21, r10.getThread_id());
            r2.i(r8, 22, r10.getThread_position());
            r0.i(r8, 23, r10.getCrypto_token());
            MessageDLPState.ADAPTER.i(r8, 24, r10.getDlp_state());
            Message.ChatDisplayModeSetting.ADAPTER.i(r8, 25, r10.getIn_chat_display_mode());
            SecurityESCReviewExtra.ADAPTER.i(r8, 26, r10.getSecurity_extra());
            r3.i(r8, 27, r10.getAi_chat_mode_id());
            r3.i(r8, 28, r10.getSync_to_chat_thread_root_id());
            Message.SyncToChatMessageType.ADAPTER.i(r8, 29, r10.getSync_to_chat_message_type());
            r3.i(r8, 30, r10.getSync_to_chat_related_message_id());
            Message.PartialReplyInfo.ADAPTER.i(r8, 31, r10.getPartial_reply_info());
            r1.i(r8, 32, r10.is_new_topic());
            r3.i(r8, 33, r10.getCreate_time_us());
            r8.a(r10.unknownFields());
        }

        @Override // com.lark.wire.ProtoAdapter
        public final void g(n0 r8, QuasiMessage r9) {
            QuasiMessage r10 = r9;
            Intrinsics.checkNotNullParameter(r8, "writer");
            Intrinsics.checkNotNullParameter(r10, "value");
            r8.d(r10.unknownFields());
            t r0 = ProtoAdapter.k;
            r0.j(r8, 33, r10.getCreate_time_us());
            l r1 = ProtoAdapter.g;
            r1.j(r8, 32, r10.is_new_topic());
            Message.PartialReplyInfo.ADAPTER.j(r8, 31, r10.getPartial_reply_info());
            r0.j(r8, 30, r10.getSync_to_chat_related_message_id());
            Message.SyncToChatMessageType.ADAPTER.j(r8, 29, r10.getSync_to_chat_message_type());
            r0.j(r8, 28, r10.getSync_to_chat_thread_root_id());
            r0.j(r8, 27, r10.getAi_chat_mode_id());
            SecurityESCReviewExtra.ADAPTER.j(r8, 26, r10.getSecurity_extra());
            Message.ChatDisplayModeSetting.ADAPTER.j(r8, 25, r10.getIn_chat_display_mode());
            MessageDLPState.ADAPTER.j(r8, 24, r10.getDlp_state());
            w r2 = ProtoAdapter.q;
            r2.j(r8, 23, r10.getCrypto_token());
            s r3 = ProtoAdapter.h;
            r3.j(r8, 22, r10.getThread_position());
            r2.j(r8, 21, r10.getThread_id());
            Channel.ADAPTER.j(r8, 20, r10.getChannel());
            r3.j(r8, 19, r10.getVersion());
            Status.ADAPTER.j(r8, 18, r10.getStatus());
            r0.j(r8, 17, r10.getImage_compressed_size_kb());
            r2.a().j(r8, 16, r10.getUnread_chatter_ids());
            r3.j(r8, 15, r10.getRead_count());
            r3.j(r8, 14, r10.getUnread_count());
            r0.j(r8, 13, Long.valueOf(r10.getCreate_time()));
            r2.j(r8, 12, r10.getFrom_id());
            r2.j(r8, 11, r10.getId());
            r2.j(r8, 10, r10.getRoot_source_id());
            r2.j(r8, 9, r10.getParent_source_id());
            r2.j(r8, 8, r10.getParent_id());
            Content.ADAPTER.j(r8, 7, r10.getContent());
            r3.j(r8, 6, r10.getPosition());
            r1.j(r8, 5, Boolean.valueOf(r10.getShould_notify()));
            Message.Type.ADAPTER.j(r8, 4, r10.getType());
            r2.j(r8, 3, r10.getRoot_id());
            r2.j(r8, 2, r10.getChat_id());
            r2.j(r8, 1, r10.getCid());
        }

        public b(FieldEncoding r7, KClass<QuasiMessage> r8, Syntax r9) {
            super(r7, r8, "type.googleapis.com/basic.v1.QuasiMessage", r9, null);
        }
    }

    public static final class c {
        public c() {
        }
    }

    public /* synthetic */ QuasiMessage(a r1, ByteString r2, DefaultConstructorMarker r3) {
        this(r1, r2);
    }

    @Deprecated(message = "image_compressed_size_kb is deprecated")
    public static /* synthetic */ void getImage_compressed_size_kb$annotations() {
    }

    static {
        Companion = new c();
        DEFAULT_STATUS = Status.PENDING;
        ADAPTER = new b(FieldEncoding.LENGTH_DELIMITED, Reflection.getOrCreateKotlinClass(QuasiMessage.class), Syntax.PROTO_2);
    }

    @Override // com.lark.wire.Message
    public a newBuilder() {
        a r0 = new a();
        r0.d = this.cid;
        r0.e = this.chat_id;
        r0.f = this.root_id;
        r0.g = this.type;
        r0.h = Boolean.valueOf(this.should_notify);
        r0.i = this.position;
        r0.j = this.content;
        r0.k = this.parent_id;
        r0.l = this.parent_source_id;
        r0.m = this.root_source_id;
        r0.n = this.id;
        r0.o = this.from_id;
        r0.p = Long.valueOf(this.create_time);
        r0.q = this.unread_count;
        r0.r = this.read_count;
        r0.s = this.unread_chatter_ids;
        r0.t = this.image_compressed_size_kb;
        r0.u = this.status;
        r0.v = this.version;
        r0.w = this.channel;
        r0.x = this.thread_id;
        r0.y = this.thread_position;
        r0.z = this.crypto_token;
        r0.A = this.dlp_state;
        r0.B = this.in_chat_display_mode;
        r0.C = this.security_extra;
        r0.D = this.ai_chat_mode_id;
        r0.E = this.sync_to_chat_thread_root_id;
        r0.F = this.sync_to_chat_message_type;
        r0.G = this.sync_to_chat_related_message_id;
        r0.H = this.partial_reply_info;
        r0.I = this.is_new_topic;
        r0.J = this.create_time_us;
        r0.a(unknownFields());
        return r0;
    }

    @Override // com.lark.wire.Message
    public String toString() {
        return Reflection.getOrCreateKotlinClass(QuasiMessage.class).getSimpleName() + '@' + hashCode();
    }

    public final Long getAi_chat_mode_id() {
        return this.ai_chat_mode_id;
    }

    public final Channel getChannel() {
        return this.channel;
    }

    public final String getChat_id() {
        return this.chat_id;
    }

    public final String getCid() {
        return this.cid;
    }

    public final Content getContent() {
        return this.content;
    }

    public final long getCreate_time() {
        return this.create_time;
    }

    public final Long getCreate_time_us() {
        return this.create_time_us;
    }

    public final String getCrypto_token() {
        return this.crypto_token;
    }

    public final MessageDLPState getDlp_state() {
        return this.dlp_state;
    }

    public final String getFrom_id() {
        return this.from_id;
    }

    public final String getId() {
        return this.id;
    }

    public final Long getImage_compressed_size_kb() {
        return this.image_compressed_size_kb;
    }

    public final Message.ChatDisplayModeSetting getIn_chat_display_mode() {
        return this.in_chat_display_mode;
    }

    public final String getParent_id() {
        return this.parent_id;
    }

    public final String getParent_source_id() {
        return this.parent_source_id;
    }

    public final Message.PartialReplyInfo getPartial_reply_info() {
        return this.partial_reply_info;
    }

    public final Integer getPosition() {
        return this.position;
    }

    public final Integer getRead_count() {
        return this.read_count;
    }

    public final String getRoot_id() {
        return this.root_id;
    }

    public final String getRoot_source_id() {
        return this.root_source_id;
    }

    public final SecurityESCReviewExtra getSecurity_extra() {
        return this.security_extra;
    }

    public final boolean getShould_notify() {
        return this.should_notify;
    }

    public final Status getStatus() {
        return this.status;
    }

    public final Message.SyncToChatMessageType getSync_to_chat_message_type() {
        return this.sync_to_chat_message_type;
    }

    public final Long getSync_to_chat_related_message_id() {
        return this.sync_to_chat_related_message_id;
    }

    public final Long getSync_to_chat_thread_root_id() {
        return this.sync_to_chat_thread_root_id;
    }

    public final String getThread_id() {
        return this.thread_id;
    }

    public final Integer getThread_position() {
        return this.thread_position;
    }

    public final Message.Type getType() {
        return this.type;
    }

    public final List<String> getUnread_chatter_ids() {
        return this.unread_chatter_ids;
    }

    public final Integer getUnread_count() {
        return this.unread_count;
    }

    public final Integer getVersion() {
        return this.version;
    }

    public final Boolean is_new_topic() {
        return this.is_new_topic;
    }

    @Override // com.lark.wire.Message
    public /* bridge */ /* synthetic */ com.lark.wire.Message.a newBuilder() {
        return newBuilder();
    }

    public QuasiMessage(a r3, ByteString r4) {
        super(ADAPTER, r4);
        String r5 = r3.d;
        Intrinsics.checkNotNull(r5);
        this.cid = r5;
        String r6 = r3.e;
        Intrinsics.checkNotNull(r6);
        this.chat_id = r6;
        this.root_id = r3.f;
        Message.Type r7 = r3.g;
        Intrinsics.checkNotNull(r7);
        this.type = r7;
        Boolean r8 = r3.h;
        Intrinsics.checkNotNull(r8);
        this.should_notify = r8.booleanValue();
        this.position = r3.i;
        Content r9 = r3.j;
        Intrinsics.checkNotNull(r9);
        this.content = r9;
        this.parent_id = r3.k;
        this.parent_source_id = r3.l;
        this.root_source_id = r3.m;
        String r10 = r3.n;
        Intrinsics.checkNotNull(r10);
        this.id = r10;
        String r11 = r3.o;
        Intrinsics.checkNotNull(r11);
        this.from_id = r11;
        Long r12 = r3.p;
        Intrinsics.checkNotNull(r12);
        this.create_time = r12.longValue();
        this.unread_count = r3.q;
        this.read_count = r3.r;
        this.unread_chatter_ids = com.lark.wire.internal.a.c("unread_chatter_ids", r3.s);
        this.image_compressed_size_kb = r3.t;
        this.status = r3.u;
        this.version = r3.v;
        this.channel = r3.w;
        this.thread_id = r3.x;
        this.thread_position = r3.y;
        this.crypto_token = r3.z;
        this.dlp_state = r3.A;
        this.in_chat_display_mode = r3.B;
        this.security_extra = r3.C;
        this.ai_chat_mode_id = r3.D;
        this.sync_to_chat_thread_root_id = r3.E;
        this.sync_to_chat_message_type = r3.F;
        this.sync_to_chat_related_message_id = r3.G;
        this.partial_reply_info = r3.H;
        this.is_new_topic = r3.I;
        this.create_time_us = r3.J;
    }

    public /* synthetic */ QuasiMessage(a r1, ByteString r2, int r3, DefaultConstructorMarker r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = ByteString.EMPTY;
    L5:
        this(r1, r2);
    }
}
