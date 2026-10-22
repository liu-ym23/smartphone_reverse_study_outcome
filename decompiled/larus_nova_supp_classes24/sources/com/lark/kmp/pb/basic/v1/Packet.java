package com.lark.kmp.pb.basic.v1;

import com.lark.wire.FieldEncoding;
import com.lark.wire.ProtoAdapter;
import com.lark.wire.Syntax;
import com.lark.wire.d;
import com.lark.wire.o0;
import com.larksuite.component.universe_design.timepicker.impl.base.WheelView;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.MapsKt;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClass;
import okio.ByteString;
import we6.c;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
@Metadata(d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010$\n\u0002\b\u000b\u0018\u0000 =2\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0003:\u0003<=>B\u001b\b\u0002\u0012\u0006\u0010\u0004\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006¢\u0006\u0004\b\u0007\u0010\bJ\b\u0010:\u001a\u00020\u0002H\u0016J\b\u0010;\u001a\u00020\u0013H\u0016R\u0013\u0010\t\u001a\u0004\u0018\u00010\n¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0015\u0010\r\u001a\u0004\u0018\u00010\u000e¢\u0006\n\n\u0002\u0010\u0011\u001a\u0004\b\u000f\u0010\u0010R\u0013\u0010\u0012\u001a\u0004\u0018\u00010\u0013¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0013\u0010\u0016\u001a\u0004\u0018\u00010\u0013¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0015R\u0013\u0010\u0018\u001a\u0004\u0018\u00010\u0013¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0015R\u0013\u0010\u001a\u001a\u0004\u0018\u00010\u0013¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u0015R\u0015\u0010\u001c\u001a\u0004\u0018\u00010\u001d¢\u0006\n\n\u0002\u0010 \u001a\u0004\b\u001e\u0010\u001fR\u0015\u0010!\u001a\u0004\u0018\u00010\"¢\u0006\n\n\u0002\u0010$\u001a\u0004\b!\u0010#R\u0013\u0010%\u001a\u0004\u0018\u00010&¢\u0006\b\n\u0000\u001a\u0004\b'\u0010(R\u0013\u0010)\u001a\u0004\u0018\u00010\u0013¢\u0006\b\n\u0000\u001a\u0004\b*\u0010\u0015R\u0013\u0010+\u001a\u0004\u0018\u00010,¢\u0006\b\n\u0000\u001a\u0004\b-\u0010.R\u0015\u0010/\u001a\u0004\u0018\u00010\"¢\u0006\n\n\u0002\u0010$\u001a\u0004\b0\u0010#R\u0015\u00101\u001a\u0004\u0018\u00010\u001d¢\u0006\n\n\u0002\u0010 \u001a\u0004\b2\u0010\u001fR\u001d\u00103\u001a\u000e\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\u001304¢\u0006\b\n\u0000\u001a\u0004\b5\u00106R\u0013\u00107\u001a\u0004\u0018\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\b8\u00109¨\u0006?"}, d2 = {"Lcom/lark/kmp/pb/basic/v1/Packet;", "Lcom/lark/wire/Message;", "Lcom/lark/kmp/pb/basic/v1/Packet$Builder;", "Lcom/bytedance/larksuite/wire/IUserScopeMessage;", "builder", "unknownFields", "Lokio/ByteString;", "<init>", "(Lcom/lark/kmp/pb/basic/v1/Packet$Builder;Lokio/ByteString;)V", "cmd", "Lcom/lark/kmp/pb/basic/v1/Command;", "getCmd", "()Lcom/lark/kmp/pb/basic/v1/Command;", "status", "", "getStatus", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "message", "", "getMessage", "()Ljava/lang/String;", "context_id", "getContext_id", "user_id", "getUser_id", "start_callback_time", "getStart_callback_time", "task_id", "", "getTask_id", "()Ljava/lang/Long;", "Ljava/lang/Long;", "is_err", "", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "stream_status", "Lcom/lark/kmp/pb/basic/v1/Packet$StreamStatus;", "getStream_status", "()Lcom/lark/kmp/pb/basic/v1/Packet$StreamStatus;", "mail_account_id", "getMail_account_id", "trace", "Lcom/lark/kmp/pb/basic/v1/Trace;", "getTrace", "()Lcom/lark/kmp/pb/basic/v1/Trace;", "verify_user_id", "getVerify_user_id", "user_container_id", "getUser_container_id", "biz_response_meta", "", "getBiz_response_meta", "()Ljava/util/Map;", "payload", "getPayload", "()Lokio/ByteString;", "newBuilder", "toString", "Builder", "Companion", "StreamStatus", "rust-sdk-kotlin-pb_release"}, k = 1, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
public final class Packet extends com.lark.wire.Message<Packet, a> {
    public static final ProtoAdapter<Packet> ADAPTER = null;
    public static final b Companion = null;
    public static final boolean DEFAULT_IS_ERR = false;
    public static final int DEFAULT_STATUS = 0;
    public static final long DEFAULT_TASK_ID = 0;
    public static final c<Packet> RAW_TYPE_ADAPTER = null;
    private static final long serialVersionUID = 0;
    private final Map<String, String> biz_response_meta;
    private final Command cmd;
    private final String context_id;
    private final Boolean is_err;
    private final String mail_account_id;
    private final String message;
    private final ByteString payload;
    private final String start_callback_time;
    private final Integer status;
    private final StreamStatus stream_status;
    private final Long task_id;
    private final Trace trace;
    private final Long user_container_id;
    private final String user_id;
    private final Boolean verify_user_id;

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\t\b\u0086\u0081\u0002\u0018\u0000 \f2\u00020\u00012\b\u0012\u0004\u0012\u00020\u00000\u0002:\u0001\fB\u0011\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u0004X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000b¨\u0006\r"}, d2 = {"Lcom/lark/kmp/pb/basic/v1/Packet$StreamStatus;", "Lcom/lark/wire/WireEnum;", "", "value", "", "<init>", "(Ljava/lang/String;II)V", "getValue", "()I", "ACTIVE", "FINAL_WITH_PAYLOAD", "FINAL_WITHOUT_PAYLOAD", "Companion", "rust-sdk-kotlin-pb_release"}, k = 1, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
    public static final enum StreamStatus extends Enum<StreamStatus> implements o0 {
        public static final StreamStatus ACTIVE = null;
        public static final ProtoAdapter<StreamStatus> ADAPTER = null;
        public static final b Companion = null;
        public static final StreamStatus FINAL_WITHOUT_PAYLOAD = null;
        public static final StreamStatus FINAL_WITH_PAYLOAD = null;
        public static final /* synthetic */ StreamStatus[] a = null;
        public static final /* synthetic */ EnumEntries b = null;
        private final int value;

        public static final class a extends d<StreamStatus> {
            @Override // com.lark.wire.d
            public final o0 n(int r2) {
                StreamStatus.Companion.getClass();
                if (r2 == 1) goto L12;
                if (r2 == 2) goto L15;
                if (r2 == 3) goto L14;
                return null;
            L14:
                return StreamStatus.FINAL_WITHOUT_PAYLOAD;
            L15:
                return StreamStatus.FINAL_WITH_PAYLOAD;
            L12:
                return StreamStatus.ACTIVE;
            }

            public a(KClass<StreamStatus> r2, Syntax r3) {
                super(r2, r3, null);
            }
        }

        public static final class b {
            public b() {
            }
        }

        public static EnumEntries<StreamStatus> getEntries() {
            return b;
        }

        static {
            StreamStatus r0 = new StreamStatus("ACTIVE", 0, 1);
            ACTIVE = r0;
            StreamStatus r1 = new StreamStatus("FINAL_WITH_PAYLOAD", 1, 2);
            FINAL_WITH_PAYLOAD = r1;
            StreamStatus r4 = new StreamStatus("FINAL_WITHOUT_PAYLOAD", 2, 3);
            FINAL_WITHOUT_PAYLOAD = r4;
            StreamStatus[] r6 = {r0, r1, r4};
            a = r6;
            b = EnumEntriesKt.enumEntries(r6);
            Companion = new b();
            ADAPTER = new a(Reflection.getOrCreateKotlinClass(StreamStatus.class), Syntax.PROTO_2);
        }

        public static StreamStatus[] values() {
            return (StreamStatus[]) a.clone();
        }

        @Override // com.lark.wire.o0
        public int getValue() {
            return this.value;
        }

        @JvmStatic
        public static final StreamStatus fromValue(int r1) {
            Companion.getClass();
            if (r1 == 1) goto L12;
            if (r1 == 2) goto L15;
            if (r1 == 3) goto L14;
            return null;
        L14:
            return FINAL_WITHOUT_PAYLOAD;
        L15:
            return FINAL_WITH_PAYLOAD;
        L12:
            return ACTIVE;
        }

        public static StreamStatus valueOf(String r1) {
            return (StreamStatus) r27.a.a(StreamStatus.class, r1);
        }

        public StreamStatus(String r1, int r2, int r3) {
            super(r1, r2);
            this.value = r3;
        }
    }

    public static final class a extends com.lark.wire.Message.a<Packet, a> implements we6.d<Packet> {
        public Command d;
        public Integer e;
        public String f;
        public String g;
        public String h;
        public String i;
        public Long j;
        public Boolean k;
        public StreamStatus l;
        public String m;
        public Trace n;
        public Boolean o;
        public Long p;
        public Map<String, String> q;
        public ByteString r;

        @Override // com.lark.wire.Message.a
        public final com.lark.wire.Message b() {
            return new Packet(this, c(), null);
        }

        public a() {
            this.q = MapsKt.emptyMap();
        }
    }

    public static final class b {
        public b() {
        }
    }

    public /* synthetic */ Packet(a r1, ByteString r2, DefaultConstructorMarker r3) {
        this(r1, r2);
    }

    static {
        Companion = new b();
        Packet$Companion$ADAPTER$1 r3 = new Packet$Companion$ADAPTER$1(FieldEncoding.LENGTH_DELIMITED, Reflection.getOrCreateKotlinClass(Packet.class), Syntax.PROTO_2);
        ADAPTER = r3;
        Intrinsics.checkNotNull(r3, "null cannot be cast to non-null type com.bytedance.larksuite.wire.IUserScopeAdapter<com.lark.kmp.pb.basic.v1.Packet>");
        RAW_TYPE_ADAPTER = r3;
    }

    @Override // com.lark.wire.Message
    public a newBuilder() {
        a r0 = new a();
        r0.d = this.cmd;
        r0.e = this.status;
        r0.f = this.message;
        r0.g = this.context_id;
        r0.h = this.user_id;
        r0.i = this.start_callback_time;
        r0.j = this.task_id;
        r0.k = this.is_err;
        r0.l = this.stream_status;
        r0.m = this.mail_account_id;
        r0.n = this.trace;
        r0.o = this.verify_user_id;
        r0.p = this.user_container_id;
        r0.q = this.biz_response_meta;
        r0.r = this.payload;
        r0.a(unknownFields());
        return r0;
    }

    @Override // com.lark.wire.Message
    public String toString() {
        return Reflection.getOrCreateKotlinClass(Packet.class).getSimpleName() + '@' + hashCode();
    }

    public final Map<String, String> getBiz_response_meta() {
        return this.biz_response_meta;
    }

    public final Command getCmd() {
        return this.cmd;
    }

    public final String getContext_id() {
        return this.context_id;
    }

    public final String getMail_account_id() {
        return this.mail_account_id;
    }

    public final String getMessage() {
        return this.message;
    }

    public final ByteString getPayload() {
        return this.payload;
    }

    public final String getStart_callback_time() {
        return this.start_callback_time;
    }

    public final Integer getStatus() {
        return this.status;
    }

    public final StreamStatus getStream_status() {
        return this.stream_status;
    }

    public final Long getTask_id() {
        return this.task_id;
    }

    public final Trace getTrace() {
        return this.trace;
    }

    public final Long getUser_container_id() {
        return this.user_container_id;
    }

    public final String getUser_id() {
        return this.user_id;
    }

    public final Boolean getVerify_user_id() {
        return this.verify_user_id;
    }

    public final Boolean is_err() {
        return this.is_err;
    }

    @Override // com.lark.wire.Message
    public /* bridge */ /* synthetic */ com.lark.wire.Message.a newBuilder() {
        return newBuilder();
    }

    public Packet(a r2, ByteString r3) {
        super(ADAPTER, r3);
        this.cmd = r2.d;
        this.status = r2.e;
        this.message = r2.f;
        this.context_id = r2.g;
        this.user_id = r2.h;
        this.start_callback_time = r2.i;
        this.task_id = r2.j;
        this.is_err = r2.k;
        this.stream_status = r2.l;
        this.mail_account_id = r2.m;
        this.trace = r2.n;
        this.verify_user_id = r2.o;
        this.user_container_id = r2.p;
        this.biz_response_meta = com.lark.wire.internal.a.d("biz_response_meta", r2.q);
        this.payload = r2.r;
    }

    public /* synthetic */ Packet(a r1, ByteString r2, int r3, DefaultConstructorMarker r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = ByteString.EMPTY;
    L5:
        this(r1, r2);
    }
}
