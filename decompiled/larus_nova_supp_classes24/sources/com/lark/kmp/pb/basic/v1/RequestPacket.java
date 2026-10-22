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
import java.util.List;
import java.util.Map;
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
@Metadata(d1 = {"\u0000l\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0012\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\r\u0018\u0000 J2\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00020\u0001:\u0005IJKLMB\u001b\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\b\u0010G\u001a\u00020\u0002H\u0016J\b\u0010H\u001a\u00020\rH\u0016R\u0013\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0013\u0010\f\u001a\u0004\u0018\u00010\r¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0013\u0010\u0010\u001a\u0004\u0018\u00010\r¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u000fR\u0015\u0010\u0012\u001a\u0004\u0018\u00010\u0013¢\u0006\n\n\u0002\u0010\u0015\u001a\u0004\b\u0012\u0010\u0014R\u0013\u0010\u0016\u001a\u0004\u0018\u00010\u0017¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R\u001d\u0010\u001a\u001a\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\r0\u001b¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001dR\u0013\u0010\u001e\u001a\u0004\u0018\u00010\u001f¢\u0006\b\n\u0000\u001a\u0004\b \u0010!R\u0015\u0010\"\u001a\u0004\u0018\u00010#¢\u0006\n\n\u0002\u0010&\u001a\u0004\b$\u0010%R\u0015\u0010'\u001a\u0004\u0018\u00010#¢\u0006\n\n\u0002\u0010&\u001a\u0004\b(\u0010%R\u0015\u0010)\u001a\u0004\u0018\u00010\u0013¢\u0006\n\n\u0002\u0010\u0015\u001a\u0004\b*\u0010\u0014R\u0015\u0010+\u001a\u0004\u0018\u00010#¢\u0006\n\n\u0002\u0010&\u001a\u0004\b,\u0010%R\u0015\u0010-\u001a\u0004\u0018\u00010#¢\u0006\n\n\u0002\u0010&\u001a\u0004\b.\u0010%R\u0015\u0010/\u001a\u0004\u0018\u00010\u0013¢\u0006\n\n\u0002\u0010\u0015\u001a\u0004\b0\u0010\u0014R\u0013\u00101\u001a\u0004\u0018\u00010\r¢\u0006\b\n\u0000\u001a\u0004\b2\u0010\u000fR\u0015\u00103\u001a\u0004\u0018\u00010\u0013¢\u0006\n\n\u0002\u0010\u0015\u001a\u0004\b4\u0010\u0014R\u0017\u00105\u001a\b\u0012\u0004\u0012\u00020706¢\u0006\b\n\u0000\u001a\u0004\b8\u00109R\u0015\u0010:\u001a\u0004\u0018\u00010#¢\u0006\n\n\u0002\u0010&\u001a\u0004\b;\u0010%R\u0013\u0010<\u001a\u0004\u0018\u00010=¢\u0006\b\n\u0000\u001a\u0004\b>\u0010?R\u0013\u0010@\u001a\u0004\u0018\u00010A¢\u0006\b\n\u0000\u001a\u0004\bB\u0010CR\u0013\u0010D\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\bE\u0010F¨\u0006N"}, d2 = {"Lcom/lark/kmp/pb/basic/v1/RequestPacket;", "Lcom/lark/wire/Message;", "Lcom/lark/kmp/pb/basic/v1/RequestPacket$Builder;", "builder", "unknownFields", "Lokio/ByteString;", "<init>", "(Lcom/lark/kmp/pb/basic/v1/RequestPacket$Builder;Lokio/ByteString;)V", "cmd", "Lcom/lark/kmp/pb/basic/v1/Command;", "getCmd", "()Lcom/lark/kmp/pb/basic/v1/Command;", "context_id", "", "getContext_id", "()Ljava/lang/String;", "user_id", "getUser_id", "is_callback_by_stream", "", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "pass_through", "Lcom/lark/kmp/pb/basic/v1/RequestPacket$PassThrough;", "getPass_through", "()Lcom/lark/kmp/pb/basic/v1/RequestPacket$PassThrough;", "biz_request_meta", "", "getBiz_request_meta", "()Ljava/util/Map;", "biz_config", "Lcom/lark/kmp/pb/basic/v1/RequestPacket$BizConfig;", "getBiz_config", "()Lcom/lark/kmp/pb/basic/v1/RequestPacket$BizConfig;", "task_id", "", "getTask_id", "()Ljava/lang/Long;", "Ljava/lang/Long;", "max_age", "getMax_age", "use_cache_control", "getUse_cache_control", "thread_id", "getThread_id", "span_id", "getSpan_id", "collect_trace", "getCollect_trace", "mail_account_id", "getMail_account_id", "enable_start_up_control", "getEnable_start_up_control", "headers", "", "Lcom/lark/kmp/pb/basic/v1/HttpHeader;", "getHeaders", "()Ljava/util/List;", "user_container_id", "getUser_container_id", "mail_context", "Lcom/lark/kmp/pb/basic/v1/MailContext;", "getMail_context", "()Lcom/lark/kmp/pb/basic/v1/MailContext;", "traffic_type", "Lcom/lark/kmp/pb/basic/v1/RequestPacket$TrafficType;", "getTraffic_type", "()Lcom/lark/kmp/pb/basic/v1/RequestPacket$TrafficType;", "payload", "getPayload", "()Lokio/ByteString;", "newBuilder", "toString", "Builder", "Companion", "BizConfig", "PassThrough", "TrafficType", "rust-sdk-kotlin-pb_release"}, k = 1, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
public final class RequestPacket extends com.lark.wire.Message<RequestPacket, a> {
    public static final ProtoAdapter<RequestPacket> ADAPTER = null;
    public static final b Companion = null;
    public static final boolean DEFAULT_ENABLE_START_UP_CONTROL = false;
    public static final boolean DEFAULT_IS_CALLBACK_BY_STREAM = false;
    public static final long DEFAULT_TASK_ID = 0;
    private static final long serialVersionUID = 0;
    private final BizConfig biz_config;
    private final Map<String, String> biz_request_meta;
    private final Command cmd;
    private final Boolean collect_trace;
    private final String context_id;
    private final Boolean enable_start_up_control;
    private final List<HttpHeader> headers;
    private final Boolean is_callback_by_stream;
    private final String mail_account_id;
    private final MailContext mail_context;
    private final Long max_age;
    private final PassThrough pass_through;
    private final ByteString payload;
    private final Long span_id;
    private final Long task_id;
    private final Long thread_id;
    private final TrafficType traffic_type;
    private final Boolean use_cache_control;
    private final Long user_container_id;
    private final String user_id;

    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0004\u0018\u0000 \u00102\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00020\u0001:\u0003\u000f\u0010\u0011B\u001b\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\b\u0010\f\u001a\u00020\u0002H\u0016J\b\u0010\r\u001a\u00020\u000eH\u0016R\u0013\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0012"}, d2 = {"Lcom/lark/kmp/pb/basic/v1/RequestPacket$BizConfig;", "Lcom/lark/wire/Message;", "Lcom/lark/kmp/pb/basic/v1/RequestPacket$BizConfig$Builder;", "builder", "unknownFields", "Lokio/ByteString;", "<init>", "(Lcom/lark/kmp/pb/basic/v1/RequestPacket$BizConfig$Builder;Lokio/ByteString;)V", "data_source", "Lcom/lark/kmp/pb/basic/v1/RequestPacket$BizConfig$DataSource;", "getData_source", "()Lcom/lark/kmp/pb/basic/v1/RequestPacket$BizConfig$DataSource;", "newBuilder", "toString", "", "Builder", "Companion", "DataSource", "rust-sdk-kotlin-pb_release"}, k = 1, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
    public static final class BizConfig extends com.lark.wire.Message<BizConfig, a> {
        public static final ProtoAdapter<BizConfig> ADAPTER = null;
        public static final c Companion = null;
        public static final DataSource DEFAULT_DATA_SOURCE = null;
        private static final long serialVersionUID = 0;
        private final DataSource data_source;

        @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\t\b\u0086\u0081\u0002\u0018\u0000 \f2\u00020\u00012\b\u0012\u0004\u0012\u00020\u00000\u0002:\u0001\fB\u0011\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u0004X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000b¨\u0006\r"}, d2 = {"Lcom/lark/kmp/pb/basic/v1/RequestPacket$BizConfig$DataSource;", "Lcom/lark/wire/WireEnum;", "", "value", "", "<init>", "(Ljava/lang/String;II)V", "getValue", "()I", "DEFAULT", "LOCAL", "PREFERRED_ONLINE", "Companion", "rust-sdk-kotlin-pb_release"}, k = 1, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
        public static final enum DataSource extends Enum<DataSource> implements o0 {
            public static final ProtoAdapter<DataSource> ADAPTER = null;
            public static final b Companion = null;
            public static final DataSource DEFAULT = null;
            public static final DataSource LOCAL = null;
            public static final DataSource PREFERRED_ONLINE = null;
            public static final /* synthetic */ DataSource[] a = null;
            public static final /* synthetic */ EnumEntries b = null;
            private final int value;

            public static final class a extends d<DataSource> {
                @Override // com.lark.wire.d
                public final o0 n(int r2) {
                    DataSource.Companion.getClass();
                    return b.a(r2);
                }

                public a(KClass<DataSource> r2, Syntax r3) {
                    super(r2, r3, null);
                }
            }

            public static final class b {
                public b() {
                }

                @JvmStatic
                public static DataSource a(int r1) {
                    if (r1 == 1) goto L12;
                    if (r1 == 2) goto L15;
                    if (r1 == 3) goto L14;
                    return null;
                L14:
                    return DataSource.PREFERRED_ONLINE;
                L15:
                    return DataSource.LOCAL;
                L12:
                    return DataSource.DEFAULT;
                }
            }

            @JvmStatic
            public static final DataSource fromValue(int r1) {
                Companion.getClass();
                return b.a(r1);
            }

            public static EnumEntries<DataSource> getEntries() {
                return b;
            }

            static {
                DataSource r0 = new DataSource("DEFAULT", 0, 1);
                DEFAULT = r0;
                DataSource r1 = new DataSource("LOCAL", 1, 2);
                LOCAL = r1;
                DataSource r4 = new DataSource("PREFERRED_ONLINE", 2, 3);
                PREFERRED_ONLINE = r4;
                DataSource[] r6 = {r0, r1, r4};
                a = r6;
                b = EnumEntriesKt.enumEntries(r6);
                Companion = new b();
                ADAPTER = new a(Reflection.getOrCreateKotlinClass(DataSource.class), Syntax.PROTO_2);
            }

            public static DataSource[] values() {
                return (DataSource[]) a.clone();
            }

            @Override // com.lark.wire.o0
            public int getValue() {
                return this.value;
            }

            public static DataSource valueOf(String r1) {
                return (DataSource) r27.a.a(DataSource.class, r1);
            }

            public DataSource(String r1, int r2, int r3) {
                super(r1, r2);
                this.value = r3;
            }
        }

        public static final class a extends com.lark.wire.Message.a<BizConfig, a> {
            public DataSource d;

            @Override // com.lark.wire.Message.a
            public final com.lark.wire.Message b() {
                return new BizConfig(this, c(), null);
            }

            public a() {
            }
        }

        public static final class b extends ProtoAdapter<BizConfig> {
            @Override // com.lark.wire.ProtoAdapter
            public final BizConfig c(g0 r9) {
                Intrinsics.checkNotNullParameter(r9, "reader");
                a r0 = new a();
                long r1 = r9.c();
            L3:
                int r3 = r9.e();
                if (r3 == (-1)) goto L13;
                if (r3 != 1) goto L11;
                r0.d = DataSource.ADAPTER.c(r9);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L9
            L9:
                e = move-exception;
                r9.a(r3, FieldEncoding.VARINT, Long.valueOf(e.value));
                Unit r4 = Unit.INSTANCE;
                goto L3
            L11:
                r9.j(r3);
                goto L3
            L13:
                return new BizConfig(r0, r9.d(r1), null);
            }

            @Override // com.lark.wire.ProtoAdapter
            public final int k(BizConfig r4) {
                BizConfig r5 = r4;
                Intrinsics.checkNotNullParameter(r5, "value");
                return r5.unknownFields().size() + DataSource.ADAPTER.l(1, r5.getData_source());
            }

            @Override // com.lark.wire.ProtoAdapter
            public final void f(j0 r4, BizConfig r5) {
                BizConfig r6 = r5;
                Intrinsics.checkNotNullParameter(r4, "writer");
                Intrinsics.checkNotNullParameter(r6, "value");
                DataSource.ADAPTER.i(r4, 1, r6.getData_source());
                r4.a(r6.unknownFields());
            }

            @Override // com.lark.wire.ProtoAdapter
            public final void g(n0 r3, BizConfig r4) {
                BizConfig r5 = r4;
                Intrinsics.checkNotNullParameter(r3, "writer");
                Intrinsics.checkNotNullParameter(r5, "value");
                r3.d(r5.unknownFields());
                DataSource.ADAPTER.j(r3, 1, r5.getData_source());
            }

            public b(FieldEncoding r7, KClass<BizConfig> r8, Syntax r9) {
                super(r7, r8, "type.googleapis.com/basic.v1.RequestPacket.BizConfig", r9, null);
            }
        }

        public static final class c {
            public c() {
            }
        }

        public /* synthetic */ BizConfig(a r1, ByteString r2, DefaultConstructorMarker r3) {
            this(r1, r2);
        }

        static {
            Companion = new c();
            DEFAULT_DATA_SOURCE = DataSource.DEFAULT;
            ADAPTER = new b(FieldEncoding.LENGTH_DELIMITED, Reflection.getOrCreateKotlinClass(BizConfig.class), Syntax.PROTO_2);
        }

        @Override // com.lark.wire.Message
        public a newBuilder() {
            a r0 = new a();
            r0.d = this.data_source;
            r0.a(unknownFields());
            return r0;
        }

        @Override // com.lark.wire.Message
        public String toString() {
            return Reflection.getOrCreateKotlinClass(BizConfig.class).getSimpleName() + '@' + hashCode();
        }

        public final DataSource getData_source() {
            return this.data_source;
        }

        @Override // com.lark.wire.Message
        public /* bridge */ /* synthetic */ com.lark.wire.Message.a newBuilder() {
            return newBuilder();
        }

        public BizConfig(a r2, ByteString r3) {
            super(ADAPTER, r3);
            this.data_source = r2.d;
        }

        public /* synthetic */ BizConfig(a r1, ByteString r2, int r3, DefaultConstructorMarker r4) {
            if ((r3 & 2) == 0) goto L5;
            r2 = ByteString.EMPTY;
        L5:
            this(r1, r2);
        }
    }

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0007\u0018\u0000 \u000f2\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00020\u0001:\u0002\u000e\u000fB\u001b\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\b\u0010\f\u001a\u00020\u0002H\u0016J\b\u0010\r\u001a\u00020\tH\u0016R\u0013\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0010"}, d2 = {"Lcom/lark/kmp/pb/basic/v1/RequestPacket$PassThrough;", "Lcom/lark/wire/Message;", "Lcom/lark/kmp/pb/basic/v1/RequestPacket$PassThrough$Builder;", "builder", "unknownFields", "Lokio/ByteString;", "<init>", "(Lcom/lark/kmp/pb/basic/v1/RequestPacket$PassThrough$Builder;Lokio/ByteString;)V", "ser_command", "", "getSer_command", "()Ljava/lang/String;", "newBuilder", "toString", "Builder", "Companion", "rust-sdk-kotlin-pb_release"}, k = 1, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
    public static final class PassThrough extends com.lark.wire.Message<PassThrough, a> {
        public static final ProtoAdapter<PassThrough> ADAPTER = null;
        public static final c Companion = null;
        private static final long serialVersionUID = 0;
        private final String ser_command;

        public static final class a extends com.lark.wire.Message.a<PassThrough, a> {
            public String d;

            @Override // com.lark.wire.Message.a
            public final com.lark.wire.Message b() {
                return new PassThrough(this, c(), null);
            }

            public a() {
            }
        }

        public static final class b extends ProtoAdapter<PassThrough> {
            @Override // com.lark.wire.ProtoAdapter
            public final PassThrough c(g0 r7) {
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
                return new PassThrough(r1, r7.d(r2), null);
            }

            @Override // com.lark.wire.ProtoAdapter
            public final int k(PassThrough r4) {
                PassThrough r5 = r4;
                Intrinsics.checkNotNullParameter(r5, "value");
                return r5.unknownFields().size() + ProtoAdapter.q.l(1, r5.getSer_command());
            }

            @Override // com.lark.wire.ProtoAdapter
            public final void f(j0 r4, PassThrough r5) {
                PassThrough r6 = r5;
                Intrinsics.checkNotNullParameter(r4, "writer");
                Intrinsics.checkNotNullParameter(r6, "value");
                ProtoAdapter.q.i(r4, 1, r6.getSer_command());
                r4.a(r6.unknownFields());
            }

            @Override // com.lark.wire.ProtoAdapter
            public final void g(n0 r3, PassThrough r4) {
                PassThrough r5 = r4;
                Intrinsics.checkNotNullParameter(r3, "writer");
                Intrinsics.checkNotNullParameter(r5, "value");
                r3.d(r5.unknownFields());
                ProtoAdapter.q.j(r3, 1, r5.getSer_command());
            }

            public b(FieldEncoding r7, KClass<PassThrough> r8, Syntax r9) {
                super(r7, r8, "type.googleapis.com/basic.v1.RequestPacket.PassThrough", r9, null);
            }
        }

        public static final class c {
            public c() {
            }
        }

        public /* synthetic */ PassThrough(a r1, ByteString r2, DefaultConstructorMarker r3) {
            this(r1, r2);
        }

        static {
            Companion = new c();
            ADAPTER = new b(FieldEncoding.LENGTH_DELIMITED, Reflection.getOrCreateKotlinClass(PassThrough.class), Syntax.PROTO_2);
        }

        @Override // com.lark.wire.Message
        public a newBuilder() {
            a r0 = new a();
            r0.d = this.ser_command;
            r0.a(unknownFields());
            return r0;
        }

        @Override // com.lark.wire.Message
        public String toString() {
            return Reflection.getOrCreateKotlinClass(PassThrough.class).getSimpleName() + '@' + hashCode();
        }

        public final String getSer_command() {
            return this.ser_command;
        }

        @Override // com.lark.wire.Message
        public /* bridge */ /* synthetic */ com.lark.wire.Message.a newBuilder() {
            return newBuilder();
        }

        public PassThrough(a r2, ByteString r3) {
            super(ADAPTER, r3);
            this.ser_command = r2.d;
        }

        public /* synthetic */ PassThrough(a r1, ByteString r2, int r3, DefaultConstructorMarker r4) {
            if ((r3 & 2) == 0) goto L5;
            r2 = ByteString.EMPTY;
        L5:
            this(r1, r2);
        }
    }

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\t\b\u0086\u0081\u0002\u0018\u0000 \f2\u00020\u00012\b\u0012\u0004\u0012\u00020\u00000\u0002:\u0001\fB\u0011\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u0004X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000b¨\u0006\r"}, d2 = {"Lcom/lark/kmp/pb/basic/v1/RequestPacket$TrafficType;", "Lcom/lark/wire/WireEnum;", "", "value", "", "<init>", "(Ljava/lang/String;II)V", "getValue", "()I", "UNKNOWN", "HIGH_PRIORITY", "LOW_PRIORITY", "Companion", "rust-sdk-kotlin-pb_release"}, k = 1, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
    public static final enum TrafficType extends Enum<TrafficType> implements o0 {
        public static final ProtoAdapter<TrafficType> ADAPTER = null;
        public static final b Companion = null;
        public static final TrafficType HIGH_PRIORITY = null;
        public static final TrafficType LOW_PRIORITY = null;
        public static final TrafficType UNKNOWN = null;
        public static final /* synthetic */ TrafficType[] a = null;
        public static final /* synthetic */ EnumEntries b = null;
        private final int value;

        public static final class a extends d<TrafficType> {
            @Override // com.lark.wire.d
            public final o0 n(int r2) {
                TrafficType.Companion.getClass();
                if (r2 == 0) goto L12;
                if (r2 == 1) goto L15;
                if (r2 == 10) goto L14;
                return null;
            L14:
                return TrafficType.LOW_PRIORITY;
            L15:
                return TrafficType.HIGH_PRIORITY;
            L12:
                return TrafficType.UNKNOWN;
            }

            public a(KClass<TrafficType> r1, Syntax r2, TrafficType r3) {
                super(r1, r2, r3);
            }
        }

        public static final class b {
            public b() {
            }
        }

        public static EnumEntries<TrafficType> getEntries() {
            return b;
        }

        static {
            TrafficType r0 = new TrafficType("UNKNOWN", 0, 0);
            UNKNOWN = r0;
            TrafficType r1 = new TrafficType("HIGH_PRIORITY", 1, 1);
            HIGH_PRIORITY = r1;
            TrafficType r3 = new TrafficType("LOW_PRIORITY", 2, 10);
            LOW_PRIORITY = r3;
            TrafficType[] r5 = {r0, r1, r3};
            a = r5;
            b = EnumEntriesKt.enumEntries(r5);
            Companion = new b();
            ADAPTER = new a(Reflection.getOrCreateKotlinClass(TrafficType.class), Syntax.PROTO_2, r0);
        }

        public static TrafficType[] values() {
            return (TrafficType[]) a.clone();
        }

        @Override // com.lark.wire.o0
        public int getValue() {
            return this.value;
        }

        @JvmStatic
        public static final TrafficType fromValue(int r1) {
            Companion.getClass();
            if (r1 == 0) goto L12;
            if (r1 == 1) goto L15;
            if (r1 == 10) goto L14;
            return null;
        L14:
            return LOW_PRIORITY;
        L15:
            return HIGH_PRIORITY;
        L12:
            return UNKNOWN;
        }

        public static TrafficType valueOf(String r1) {
            return (TrafficType) r27.a.a(TrafficType.class, r1);
        }

        public TrafficType(String r1, int r2, int r3) {
            super(r1, r2);
            this.value = r3;
        }
    }

    public static final class a extends com.lark.wire.Message.a<RequestPacket, a> {
        public Command d;
        public String e;
        public String f;
        public Boolean g;
        public PassThrough h;
        public Map<String, String> i;
        public BizConfig j;
        public Long k;
        public Long l;
        public Boolean m;
        public Long n;
        public Long o;
        public Boolean p;
        public String q;
        public Boolean r;
        public List<HttpHeader> s;
        public Long t;
        public MailContext u;
        public TrafficType v;
        public ByteString w;

        @Override // com.lark.wire.Message.a
        public final com.lark.wire.Message b() {
            return new RequestPacket(this, c(), null);
        }

        public a() {
            this.i = MapsKt.emptyMap();
            this.s = CollectionsKt.emptyList();
        }
    }

    public static final class b {
        public b() {
        }
    }

    public /* synthetic */ RequestPacket(a r1, ByteString r2, DefaultConstructorMarker r3) {
        this(r1, r2);
    }

    static {
        Companion = new b();
        final FieldEncoding r0 = FieldEncoding.LENGTH_DELIMITED;
        final KClass r1 = Reflection.getOrCreateKotlinClass(RequestPacket.class);
        final Syntax r2 = Syntax.PROTO_2;
        ADAPTER = new RequestPacket$Companion$ADAPTER$1(r0, r1, r2);
    }

    @Override // com.lark.wire.Message
    public a newBuilder() {
        a r0 = new a();
        r0.d = this.cmd;
        r0.e = this.context_id;
        r0.f = this.user_id;
        r0.g = this.is_callback_by_stream;
        r0.h = this.pass_through;
        r0.i = this.biz_request_meta;
        r0.j = this.biz_config;
        r0.k = this.task_id;
        r0.l = this.max_age;
        r0.m = this.use_cache_control;
        r0.n = this.thread_id;
        r0.o = this.span_id;
        r0.p = this.collect_trace;
        r0.q = this.mail_account_id;
        r0.r = this.enable_start_up_control;
        r0.s = this.headers;
        r0.t = this.user_container_id;
        r0.u = this.mail_context;
        r0.v = this.traffic_type;
        r0.w = this.payload;
        r0.a(unknownFields());
        return r0;
    }

    @Override // com.lark.wire.Message
    public String toString() {
        return Reflection.getOrCreateKotlinClass(RequestPacket.class).getSimpleName() + '@' + hashCode();
    }

    public final BizConfig getBiz_config() {
        return this.biz_config;
    }

    public final Map<String, String> getBiz_request_meta() {
        return this.biz_request_meta;
    }

    public final Command getCmd() {
        return this.cmd;
    }

    public final Boolean getCollect_trace() {
        return this.collect_trace;
    }

    public final String getContext_id() {
        return this.context_id;
    }

    public final Boolean getEnable_start_up_control() {
        return this.enable_start_up_control;
    }

    public final List<HttpHeader> getHeaders() {
        return this.headers;
    }

    public final String getMail_account_id() {
        return this.mail_account_id;
    }

    public final MailContext getMail_context() {
        return this.mail_context;
    }

    public final Long getMax_age() {
        return this.max_age;
    }

    public final PassThrough getPass_through() {
        return this.pass_through;
    }

    public final ByteString getPayload() {
        return this.payload;
    }

    public final Long getSpan_id() {
        return this.span_id;
    }

    public final Long getTask_id() {
        return this.task_id;
    }

    public final Long getThread_id() {
        return this.thread_id;
    }

    public final TrafficType getTraffic_type() {
        return this.traffic_type;
    }

    public final Boolean getUse_cache_control() {
        return this.use_cache_control;
    }

    public final Long getUser_container_id() {
        return this.user_container_id;
    }

    public final String getUser_id() {
        return this.user_id;
    }

    public final Boolean is_callback_by_stream() {
        return this.is_callback_by_stream;
    }

    @Override // com.lark.wire.Message
    public /* bridge */ /* synthetic */ com.lark.wire.Message.a newBuilder() {
        return newBuilder();
    }

    public RequestPacket(a r2, ByteString r3) {
        super(ADAPTER, r3);
        this.cmd = r2.d;
        this.context_id = r2.e;
        this.user_id = r2.f;
        this.is_callback_by_stream = r2.g;
        this.pass_through = r2.h;
        this.biz_request_meta = com.lark.wire.internal.a.d("biz_request_meta", r2.i);
        this.biz_config = r2.j;
        this.task_id = r2.k;
        this.max_age = r2.l;
        this.use_cache_control = r2.m;
        this.thread_id = r2.n;
        this.span_id = r2.o;
        this.collect_trace = r2.p;
        this.mail_account_id = r2.q;
        this.enable_start_up_control = r2.r;
        this.headers = com.lark.wire.internal.a.c("headers", r2.s);
        this.user_container_id = r2.t;
        this.mail_context = r2.u;
        this.traffic_type = r2.v;
        this.payload = r2.w;
    }

    public /* synthetic */ RequestPacket(a r1, ByteString r2, int r3, DefaultConstructorMarker r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = ByteString.EMPTY;
    L5:
        this(r1, r2);
    }
}
