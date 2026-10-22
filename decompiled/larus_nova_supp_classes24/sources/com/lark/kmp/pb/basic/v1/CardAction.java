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
import com.lark.wire.w;
import com.larksuite.component.card.protocol.context.action.CardActionService;
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
@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\r\u0018\u0000 (2\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00020\u0001:\b'()*+,-.B\u001b\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\b\u0010%\u001a\u00020\u0002H\u0016J\b\u0010&\u001a\u00020\tH\u0016R\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\f\u001a\u00020\r¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0013\u0010\u0010\u001a\u0004\u0018\u00010\u0011¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0013\u0010\u0014\u001a\u0004\u0018\u00010\u0015¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u0015\u0010\u0018\u001a\u0004\u0018\u00010\u0019¢\u0006\n\n\u0002\u0010\u001c\u001a\u0004\b\u001a\u0010\u001bR\u0013\u0010\u001d\u001a\u0004\u0018\u00010\u001e¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010 R\u0013\u0010!\u001a\u0004\u0018\u00010\"¢\u0006\b\n\u0000\u001a\u0004\b#\u0010$¨\u0006/"}, d2 = {"Lcom/lark/kmp/pb/basic/v1/CardAction;", "Lcom/lark/wire/Message;", "Lcom/lark/kmp/pb/basic/v1/CardAction$Builder;", "builder", "unknownFields", "Lokio/ByteString;", "<init>", "(Lcom/lark/kmp/pb/basic/v1/CardAction$Builder;Lokio/ByteString;)V", "url", "", "getUrl", "()Ljava/lang/String;", "method", "Lcom/lark/kmp/pb/basic/v1/CardAction$Method;", "getMethod", "()Lcom/lark/kmp/pb/basic/v1/CardAction$Method;", "required_parameters", "Lcom/lark/kmp/pb/basic/v1/CardAction$RequiredParameters;", "getRequired_parameters", "()Lcom/lark/kmp/pb/basic/v1/CardAction$RequiredParameters;", "parameters", "Lcom/lark/kmp/pb/basic/v1/CardAction$Parameters;", "getParameters", "()Lcom/lark/kmp/pb/basic/v1/CardAction$Parameters;", "cmd", "", "getCmd", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "packet", "Lcom/lark/kmp/pb/basic/v1/CardActionPacket;", "getPacket", "()Lcom/lark/kmp/pb/basic/v1/CardActionPacket;", "open_url", "Lcom/lark/kmp/pb/basic/v1/CardAction$Url;", "getOpen_url", "()Lcom/lark/kmp/pb/basic/v1/CardAction$Url;", "newBuilder", "toString", "Builder", "Companion", "Method", "Url", "RequiredParameters", "UserInfo", "MessageInfo", "Parameters", "rust-sdk-kotlin-pb_release"}, k = 1, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
public final class CardAction extends com.lark.wire.Message<CardAction, a> {
    public static final ProtoAdapter<CardAction> ADAPTER = null;
    public static final c Companion = null;
    private static final long serialVersionUID = 0;
    private final Integer cmd;
    private final Method method;
    private final Url open_url;
    private final CardActionPacket packet;
    private final Parameters parameters;
    private final RequiredParameters required_parameters;
    private final String url;

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0007\u0018\u0000 \u000f2\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00020\u0001:\u0002\u000e\u000fB\u001b\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\b\u0010\f\u001a\u00020\u0002H\u0016J\b\u0010\r\u001a\u00020\tH\u0016R\u0013\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0010"}, d2 = {"Lcom/lark/kmp/pb/basic/v1/CardAction$MessageInfo;", "Lcom/lark/wire/Message;", "Lcom/lark/kmp/pb/basic/v1/CardAction$MessageInfo$Builder;", "builder", "unknownFields", "Lokio/ByteString;", "<init>", "(Lcom/lark/kmp/pb/basic/v1/CardAction$MessageInfo$Builder;Lokio/ByteString;)V", "message_open_id", "", "getMessage_open_id", "()Ljava/lang/String;", "newBuilder", "toString", "Builder", "Companion", "rust-sdk-kotlin-pb_release"}, k = 1, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
    public static final class MessageInfo extends com.lark.wire.Message<MessageInfo, a> {
        public static final ProtoAdapter<MessageInfo> ADAPTER = null;
        public static final c Companion = null;
        private static final long serialVersionUID = 0;
        private final String message_open_id;

        public static final class a extends com.lark.wire.Message.a<MessageInfo, a> {
            public String d;

            @Override // com.lark.wire.Message.a
            public final com.lark.wire.Message b() {
                return new MessageInfo(this, c(), null);
            }

            public a() {
            }
        }

        public static final class b extends ProtoAdapter<MessageInfo> {
            @Override // com.lark.wire.ProtoAdapter
            public final MessageInfo c(g0 r7) {
                Intrinsics.checkNotNullParameter(r7, "reader");
                a r1 = new a();
                long r2 = r7.c();
            L3:
                int r4 = r7.e();
                if (r4 == (-1)) goto L10;
                if (r4 == 2) goto L7;
                r7.j(r4);
                goto L3
            L7:
                ProtoAdapter.q.getClass();
                Intrinsics.checkNotNullParameter(r7, "reader");
                r1.d = r7.i();
                goto L3
            L10:
                return new MessageInfo(r1, r7.d(r2), null);
            }

            @Override // com.lark.wire.ProtoAdapter
            public final int k(MessageInfo r4) {
                MessageInfo r5 = r4;
                Intrinsics.checkNotNullParameter(r5, "value");
                return r5.unknownFields().size() + ProtoAdapter.q.l(2, r5.getMessage_open_id());
            }

            @Override // com.lark.wire.ProtoAdapter
            public final void f(j0 r4, MessageInfo r5) {
                MessageInfo r6 = r5;
                Intrinsics.checkNotNullParameter(r4, "writer");
                Intrinsics.checkNotNullParameter(r6, "value");
                ProtoAdapter.q.i(r4, 2, r6.getMessage_open_id());
                r4.a(r6.unknownFields());
            }

            @Override // com.lark.wire.ProtoAdapter
            public final void g(n0 r3, MessageInfo r4) {
                MessageInfo r5 = r4;
                Intrinsics.checkNotNullParameter(r3, "writer");
                Intrinsics.checkNotNullParameter(r5, "value");
                r3.d(r5.unknownFields());
                ProtoAdapter.q.j(r3, 2, r5.getMessage_open_id());
            }

            public b(FieldEncoding r7, KClass<MessageInfo> r8, Syntax r9) {
                super(r7, r8, "type.googleapis.com/basic.v1.CardAction.MessageInfo", r9, null);
            }
        }

        public static final class c {
            public c() {
            }
        }

        public /* synthetic */ MessageInfo(a r1, ByteString r2, DefaultConstructorMarker r3) {
            this(r1, r2);
        }

        static {
            Companion = new c();
            ADAPTER = new b(FieldEncoding.LENGTH_DELIMITED, Reflection.getOrCreateKotlinClass(MessageInfo.class), Syntax.PROTO_2);
        }

        @Override // com.lark.wire.Message
        public a newBuilder() {
            a r0 = new a();
            r0.d = this.message_open_id;
            r0.a(unknownFields());
            return r0;
        }

        @Override // com.lark.wire.Message
        public String toString() {
            return Reflection.getOrCreateKotlinClass(MessageInfo.class).getSimpleName() + '@' + hashCode();
        }

        public final String getMessage_open_id() {
            return this.message_open_id;
        }

        @Override // com.lark.wire.Message
        public /* bridge */ /* synthetic */ com.lark.wire.Message.a newBuilder() {
            return newBuilder();
        }

        public MessageInfo(a r2, ByteString r3) {
            super(ADAPTER, r3);
            this.message_open_id = r2.d;
        }

        public /* synthetic */ MessageInfo(a r1, ByteString r2, int r3, DefaultConstructorMarker r4) {
            if ((r3 & 2) == 0) goto L5;
            r2 = ByteString.EMPTY;
        L5:
            this(r1, r2);
        }
    }

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\n\b\u0086\u0081\u0002\u0018\u0000 \r2\u00020\u00012\b\u0012\u0004\u0012\u00020\u00000\u0002:\u0001\rB\u0011\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u0004X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\f¨\u0006\u000e"}, d2 = {"Lcom/lark/kmp/pb/basic/v1/CardAction$Method;", "Lcom/lark/wire/WireEnum;", "", "value", "", "<init>", "(Ljava/lang/String;II)V", "getValue", "()I", "GET", "POST", "LARK_COMMAND", "OPEN_URL", "Companion", "rust-sdk-kotlin-pb_release"}, k = 1, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
    public static final enum Method extends Enum<Method> implements o0 {
        public static final ProtoAdapter<Method> ADAPTER = null;
        public static final b Companion = null;
        public static final Method GET = null;
        public static final Method LARK_COMMAND = null;
        public static final Method OPEN_URL = null;
        public static final Method POST = null;
        public static final /* synthetic */ Method[] a = null;
        public static final /* synthetic */ EnumEntries b = null;
        private final int value;

        public static final class a extends d<Method> {
            @Override // com.lark.wire.d
            public final o0 n(int r2) {
                Method.Companion.getClass();
                if (r2 == 1) goto L15;
                if (r2 == 2) goto L19;
                if (r2 == 3) goto L18;
                if (r2 == 4) goto L17;
                return null;
            L17:
                return Method.OPEN_URL;
            L18:
                return Method.LARK_COMMAND;
            L19:
                return Method.POST;
            L15:
                return Method.GET;
            }

            public a(KClass<Method> r2, Syntax r3) {
                super(r2, r3, null);
            }
        }

        public static final class b {
            public b() {
            }
        }

        public static EnumEntries<Method> getEntries() {
            return b;
        }

        static {
            Method r0 = new Method("GET", 0, 1);
            GET = r0;
            Method r1 = new Method("POST", 1, 2);
            POST = r1;
            Method r4 = new Method("LARK_COMMAND", 2, 3);
            LARK_COMMAND = r4;
            Method r6 = new Method("OPEN_URL", 3, 4);
            OPEN_URL = r6;
            Method[] r8 = {r0, r1, r4, r6};
            a = r8;
            b = EnumEntriesKt.enumEntries(r8);
            Companion = new b();
            ADAPTER = new a(Reflection.getOrCreateKotlinClass(Method.class), Syntax.PROTO_2);
        }

        public static Method[] values() {
            return (Method[]) a.clone();
        }

        @Override // com.lark.wire.o0
        public int getValue() {
            return this.value;
        }

        @JvmStatic
        public static final Method fromValue(int r1) {
            Companion.getClass();
            if (r1 == 1) goto L15;
            if (r1 == 2) goto L19;
            if (r1 == 3) goto L18;
            if (r1 == 4) goto L17;
            return null;
        L17:
            return OPEN_URL;
        L18:
            return LARK_COMMAND;
        L19:
            return POST;
        L15:
            return GET;
        }

        public static Method valueOf(String r1) {
            return (Method) r27.a.a(Method.class, r1);
        }

        public Method(String r1, int r2, int r3) {
            super(r1, r2);
            this.value = r3;
        }
    }

    @Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000e\u0018\u0000 \u001f2\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00020\u0001:\u0002\u001e\u001fB\u001b\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\b\u0010\u001c\u001a\u00020\u0002H\u0016J\b\u0010\u001d\u001a\u00020\nH\u0016R\u001d\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\n0\t¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0013\u0010\r\u001a\u0004\u0018\u00010\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0013\u0010\u0011\u001a\u0004\u0018\u00010\u0012¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0013\u0010\u0015\u001a\u0004\u0018\u00010\n¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u0013\u0010\u0018\u001a\u0004\u0018\u00010\n¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0017R\u0013\u0010\u001a\u001a\u0004\u0018\u00010\n¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u0017¨\u0006 "}, d2 = {"Lcom/lark/kmp/pb/basic/v1/CardAction$Parameters;", "Lcom/lark/wire/Message;", "Lcom/lark/kmp/pb/basic/v1/CardAction$Parameters$Builder;", "builder", "unknownFields", "Lokio/ByteString;", "<init>", "(Lcom/lark/kmp/pb/basic/v1/CardAction$Parameters$Builder;Lokio/ByteString;)V", "parameters", "", "", "getParameters", "()Ljava/util/Map;", "user_info", "Lcom/lark/kmp/pb/basic/v1/CardAction$UserInfo;", "getUser_info", "()Lcom/lark/kmp/pb/basic/v1/CardAction$UserInfo;", "message_info", "Lcom/lark/kmp/pb/basic/v1/CardAction$MessageInfo;", "getMessage_info", "()Lcom/lark/kmp/pb/basic/v1/CardAction$MessageInfo;", "user_id", "getUser_id", "()Ljava/lang/String;", "message_id", "getMessage_id", CardActionService.CARD_ID, "getCard_id", "newBuilder", "toString", "Builder", "Companion", "rust-sdk-kotlin-pb_release"}, k = 1, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
    public static final class Parameters extends com.lark.wire.Message<Parameters, a> {
        public static final ProtoAdapter<Parameters> ADAPTER = null;
        public static final b Companion = null;
        private static final long serialVersionUID = 0;
        private final String card_id;
        private final String message_id;
        private final MessageInfo message_info;
        private final Map<String, String> parameters;
        private final String user_id;
        private final UserInfo user_info;

        public static final class a extends com.lark.wire.Message.a<Parameters, a> {
            public Map<String, String> d;
            public UserInfo e;
            public MessageInfo f;
            public String g;
            public String h;
            public String i;

            @Override // com.lark.wire.Message.a
            public final com.lark.wire.Message b() {
                return new Parameters(this, c(), null);
            }

            public a() {
                this.d = MapsKt.emptyMap();
            }
        }

        public static final class b {
            public b() {
            }
        }

        public /* synthetic */ Parameters(a r1, ByteString r2, DefaultConstructorMarker r3) {
            this(r1, r2);
        }

        static {
            Companion = new b();
            final FieldEncoding r0 = FieldEncoding.LENGTH_DELIMITED;
            final KClass r1 = Reflection.getOrCreateKotlinClass(Parameters.class);
            final Syntax r2 = Syntax.PROTO_2;
            ADAPTER = new CardAction$Parameters$Companion$ADAPTER$1(r0, r1, r2);
        }

        @Override // com.lark.wire.Message
        public a newBuilder() {
            a r0 = new a();
            r0.d = this.parameters;
            r0.e = this.user_info;
            r0.f = this.message_info;
            r0.g = this.user_id;
            r0.h = this.message_id;
            r0.i = this.card_id;
            r0.a(unknownFields());
            return r0;
        }

        @Override // com.lark.wire.Message
        public String toString() {
            return Reflection.getOrCreateKotlinClass(Parameters.class).getSimpleName() + '@' + hashCode();
        }

        public final String getCard_id() {
            return this.card_id;
        }

        public final String getMessage_id() {
            return this.message_id;
        }

        public final MessageInfo getMessage_info() {
            return this.message_info;
        }

        public final Map<String, String> getParameters() {
            return this.parameters;
        }

        public final String getUser_id() {
            return this.user_id;
        }

        public final UserInfo getUser_info() {
            return this.user_info;
        }

        @Override // com.lark.wire.Message
        public /* bridge */ /* synthetic */ com.lark.wire.Message.a newBuilder() {
            return newBuilder();
        }

        public Parameters(a r2, ByteString r3) {
            super(ADAPTER, r3);
            this.parameters = com.lark.wire.internal.a.d("parameters", r2.d);
            this.user_info = r2.e;
            this.message_info = r2.f;
            this.user_id = r2.g;
            this.message_id = r2.h;
            this.card_id = r2.i;
        }

        public /* synthetic */ Parameters(a r1, ByteString r2, int r3, DefaultConstructorMarker r4) {
            if ((r3 & 2) == 0) goto L5;
            r2 = ByteString.EMPTY;
        L5:
            this(r1, r2);
        }
    }

    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u000b\n\u0002\u0010\u000e\n\u0002\b\u0003\u0018\u0000 \u00172\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00020\u0001:\u0002\u0016\u0017B\u001b\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\b\u0010\u0013\u001a\u00020\u0002H\u0016J\b\u0010\u0014\u001a\u00020\u0015H\u0016R\u0015\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\n\n\u0002\u0010\f\u001a\u0004\b\n\u0010\u000bR\u0015\u0010\r\u001a\u0004\u0018\u00010\t¢\u0006\n\n\u0002\u0010\f\u001a\u0004\b\u000e\u0010\u000bR\u0015\u0010\u000f\u001a\u0004\u0018\u00010\t¢\u0006\n\n\u0002\u0010\f\u001a\u0004\b\u0010\u0010\u000bR\u0015\u0010\u0011\u001a\u0004\u0018\u00010\t¢\u0006\n\n\u0002\u0010\f\u001a\u0004\b\u0012\u0010\u000b¨\u0006\u0018"}, d2 = {"Lcom/lark/kmp/pb/basic/v1/CardAction$RequiredParameters;", "Lcom/lark/wire/Message;", "Lcom/lark/kmp/pb/basic/v1/CardAction$RequiredParameters$Builder;", "builder", "unknownFields", "Lokio/ByteString;", "<init>", "(Lcom/lark/kmp/pb/basic/v1/CardAction$RequiredParameters$Builder;Lokio/ByteString;)V", "need_user_info", "", "getNeed_user_info", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "need_message_info", "getNeed_message_info", "need_user_id", "getNeed_user_id", "need_message_id", "getNeed_message_id", "newBuilder", "toString", "", "Builder", "Companion", "rust-sdk-kotlin-pb_release"}, k = 1, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
    public static final class RequiredParameters extends com.lark.wire.Message<RequiredParameters, a> {
        public static final ProtoAdapter<RequiredParameters> ADAPTER = null;
        public static final c Companion = null;
        public static final boolean DEFAULT_NEED_MESSAGE_ID = false;
        public static final boolean DEFAULT_NEED_MESSAGE_INFO = false;
        public static final boolean DEFAULT_NEED_USER_ID = false;
        public static final boolean DEFAULT_NEED_USER_INFO = false;
        private static final long serialVersionUID = 0;
        private final Boolean need_message_id;
        private final Boolean need_message_info;
        private final Boolean need_user_id;
        private final Boolean need_user_info;

        public static final class a extends com.lark.wire.Message.a<RequiredParameters, a> {
            public Boolean d;
            public Boolean e;
            public Boolean f;
            public Boolean g;

            @Override // com.lark.wire.Message.a
            public final com.lark.wire.Message b() {
                return new RequiredParameters(this, c(), null);
            }

            public a() {
            }
        }

        public static final class b extends ProtoAdapter<RequiredParameters> {
            @Override // com.lark.wire.ProtoAdapter
            public final RequiredParameters c(g0 r6) {
                Intrinsics.checkNotNullParameter(r6, "reader");
                a r0 = new a();
                long r1 = r6.c();
            L3:
                int r3 = r6.e();
                if (r3 == (-1)) goto L19;
                if (r3 != 1) goto L8;
                r0.d = (Boolean) ProtoAdapter.g.c(r6);
                goto L3
            L8:
                if (r3 != 2) goto L10;
                r0.e = (Boolean) ProtoAdapter.g.c(r6);
                goto L3
            L10:
                if (r3 != 3) goto L12;
                r0.f = (Boolean) ProtoAdapter.g.c(r6);
                goto L3
            L12:
                if (r3 != 4) goto L13;
                r0.g = (Boolean) ProtoAdapter.g.c(r6);
                goto L3
            L13:
                r6.j(r3);
                Unit r4 = Unit.INSTANCE;
                goto L3
            L19:
                return new RequiredParameters(r0, r6.d(r1), null);
            }

            @Override // com.lark.wire.ProtoAdapter
            public final int k(RequiredParameters r5) {
                RequiredParameters r6 = r5;
                Intrinsics.checkNotNullParameter(r6, "value");
                int r0 = r6.unknownFields().size();
                l r1 = ProtoAdapter.g;
                return (((r0 + r1.l(1, r6.getNeed_user_info())) + r1.l(2, r6.getNeed_message_info())) + r1.l(3, r6.getNeed_user_id())) + r1.l(4, r6.getNeed_message_id());
            }

            @Override // com.lark.wire.ProtoAdapter
            public final void f(j0 r4, RequiredParameters r5) {
                RequiredParameters r6 = r5;
                Intrinsics.checkNotNullParameter(r4, "writer");
                Intrinsics.checkNotNullParameter(r6, "value");
                l r0 = ProtoAdapter.g;
                r0.i(r4, 1, r6.getNeed_user_info());
                r0.i(r4, 2, r6.getNeed_message_info());
                r0.i(r4, 3, r6.getNeed_user_id());
                r0.i(r4, 4, r6.getNeed_message_id());
                r4.a(r6.unknownFields());
            }

            @Override // com.lark.wire.ProtoAdapter
            public final void g(n0 r4, RequiredParameters r5) {
                RequiredParameters r6 = r5;
                Intrinsics.checkNotNullParameter(r4, "writer");
                Intrinsics.checkNotNullParameter(r6, "value");
                r4.d(r6.unknownFields());
                l r0 = ProtoAdapter.g;
                r0.j(r4, 4, r6.getNeed_message_id());
                r0.j(r4, 3, r6.getNeed_user_id());
                r0.j(r4, 2, r6.getNeed_message_info());
                r0.j(r4, 1, r6.getNeed_user_info());
            }

            public b(FieldEncoding r7, KClass<RequiredParameters> r8, Syntax r9) {
                super(r7, r8, "type.googleapis.com/basic.v1.CardAction.RequiredParameters", r9, null);
            }
        }

        public static final class c {
            public c() {
            }
        }

        public /* synthetic */ RequiredParameters(a r1, ByteString r2, DefaultConstructorMarker r3) {
            this(r1, r2);
        }

        static {
            Companion = new c();
            ADAPTER = new b(FieldEncoding.LENGTH_DELIMITED, Reflection.getOrCreateKotlinClass(RequiredParameters.class), Syntax.PROTO_2);
        }

        @Override // com.lark.wire.Message
        public a newBuilder() {
            a r0 = new a();
            r0.d = this.need_user_info;
            r0.e = this.need_message_info;
            r0.f = this.need_user_id;
            r0.g = this.need_message_id;
            r0.a(unknownFields());
            return r0;
        }

        @Override // com.lark.wire.Message
        public String toString() {
            return Reflection.getOrCreateKotlinClass(RequiredParameters.class).getSimpleName() + '@' + hashCode();
        }

        public final Boolean getNeed_message_id() {
            return this.need_message_id;
        }

        public final Boolean getNeed_message_info() {
            return this.need_message_info;
        }

        public final Boolean getNeed_user_id() {
            return this.need_user_id;
        }

        public final Boolean getNeed_user_info() {
            return this.need_user_info;
        }

        @Override // com.lark.wire.Message
        public /* bridge */ /* synthetic */ com.lark.wire.Message.a newBuilder() {
            return newBuilder();
        }

        public RequiredParameters(a r2, ByteString r3) {
            super(ADAPTER, r3);
            this.need_user_info = r2.d;
            this.need_message_info = r2.e;
            this.need_user_id = r2.f;
            this.need_message_id = r2.g;
        }

        public /* synthetic */ RequiredParameters(a r1, ByteString r2, int r3, DefaultConstructorMarker r4) {
            if ((r3 & 2) == 0) goto L5;
            r2 = ByteString.EMPTY;
        L5:
            this(r1, r2);
        }
    }

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\r\u0018\u0000 \u00152\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00020\u0001:\u0002\u0014\u0015B\u001b\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\b\u0010\u0012\u001a\u00020\u0002H\u0016J\b\u0010\u0013\u001a\u00020\tH\u0016R\u0013\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0013\u0010\f\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000bR\u0013\u0010\u000e\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000bR\u0013\u0010\u0010\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u000b¨\u0006\u0016"}, d2 = {"Lcom/lark/kmp/pb/basic/v1/CardAction$Url;", "Lcom/lark/wire/Message;", "Lcom/lark/kmp/pb/basic/v1/CardAction$Url$Builder;", "builder", "unknownFields", "Lokio/ByteString;", "<init>", "(Lcom/lark/kmp/pb/basic/v1/CardAction$Url$Builder;Lokio/ByteString;)V", "url", "", "getUrl", "()Ljava/lang/String;", "ios_url", "getIos_url", "android_url", "getAndroid_url", "pc_url", "getPc_url", "newBuilder", "toString", "Builder", "Companion", "rust-sdk-kotlin-pb_release"}, k = 1, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
    public static final class Url extends com.lark.wire.Message<Url, a> {
        public static final ProtoAdapter<Url> ADAPTER = null;
        public static final c Companion = null;
        private static final long serialVersionUID = 0;
        private final String android_url;
        private final String ios_url;
        private final String pc_url;
        private final String url;

        public static final class a extends com.lark.wire.Message.a<Url, a> {
            public String d;
            public String e;
            public String f;
            public String g;

            @Override // com.lark.wire.Message.a
            public final com.lark.wire.Message b() {
                return new Url(this, c(), null);
            }

            public a() {
            }
        }

        public static final class b extends ProtoAdapter<Url> {
            @Override // com.lark.wire.ProtoAdapter
            public final Url c(g0 r7) {
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
                return new Url(r1, r7.d(r2), null);
            }

            @Override // com.lark.wire.ProtoAdapter
            public final int k(Url r5) {
                Url r6 = r5;
                Intrinsics.checkNotNullParameter(r6, "value");
                int r0 = r6.unknownFields().size();
                w r1 = ProtoAdapter.q;
                return (((r0 + r1.l(1, r6.getUrl())) + r1.l(2, r6.getIos_url())) + r1.l(3, r6.getAndroid_url())) + r1.l(4, r6.getPc_url());
            }

            @Override // com.lark.wire.ProtoAdapter
            public final void f(j0 r4, Url r5) {
                Url r6 = r5;
                Intrinsics.checkNotNullParameter(r4, "writer");
                Intrinsics.checkNotNullParameter(r6, "value");
                w r0 = ProtoAdapter.q;
                r0.i(r4, 1, r6.getUrl());
                r0.i(r4, 2, r6.getIos_url());
                r0.i(r4, 3, r6.getAndroid_url());
                r0.i(r4, 4, r6.getPc_url());
                r4.a(r6.unknownFields());
            }

            @Override // com.lark.wire.ProtoAdapter
            public final void g(n0 r4, Url r5) {
                Url r6 = r5;
                Intrinsics.checkNotNullParameter(r4, "writer");
                Intrinsics.checkNotNullParameter(r6, "value");
                r4.d(r6.unknownFields());
                w r0 = ProtoAdapter.q;
                r0.j(r4, 4, r6.getPc_url());
                r0.j(r4, 3, r6.getAndroid_url());
                r0.j(r4, 2, r6.getIos_url());
                r0.j(r4, 1, r6.getUrl());
            }

            public b(FieldEncoding r7, KClass<Url> r8, Syntax r9) {
                super(r7, r8, "type.googleapis.com/basic.v1.CardAction.Url", r9, null);
            }
        }

        public static final class c {
            public c() {
            }
        }

        public /* synthetic */ Url(a r1, ByteString r2, DefaultConstructorMarker r3) {
            this(r1, r2);
        }

        static {
            Companion = new c();
            ADAPTER = new b(FieldEncoding.LENGTH_DELIMITED, Reflection.getOrCreateKotlinClass(Url.class), Syntax.PROTO_2);
        }

        @Override // com.lark.wire.Message
        public a newBuilder() {
            a r0 = new a();
            r0.d = this.url;
            r0.e = this.ios_url;
            r0.f = this.android_url;
            r0.g = this.pc_url;
            r0.a(unknownFields());
            return r0;
        }

        @Override // com.lark.wire.Message
        public String toString() {
            return Reflection.getOrCreateKotlinClass(Url.class).getSimpleName() + '@' + hashCode();
        }

        public final String getAndroid_url() {
            return this.android_url;
        }

        public final String getIos_url() {
            return this.ios_url;
        }

        public final String getPc_url() {
            return this.pc_url;
        }

        public final String getUrl() {
            return this.url;
        }

        @Override // com.lark.wire.Message
        public /* bridge */ /* synthetic */ com.lark.wire.Message.a newBuilder() {
            return newBuilder();
        }

        public Url(a r2, ByteString r3) {
            super(ADAPTER, r3);
            this.url = r2.d;
            this.ios_url = r2.e;
            this.android_url = r2.f;
            this.pc_url = r2.g;
        }

        public /* synthetic */ Url(a r1, ByteString r2, int r3, DefaultConstructorMarker r4) {
            if ((r3 & 2) == 0) goto L5;
            r2 = ByteString.EMPTY;
        L5:
            this(r1, r2);
        }
    }

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0007\u0018\u0000 \u000f2\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00020\u0001:\u0002\u000e\u000fB\u001b\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\b\u0010\f\u001a\u00020\u0002H\u0016J\b\u0010\r\u001a\u00020\tH\u0016R\u0013\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0010"}, d2 = {"Lcom/lark/kmp/pb/basic/v1/CardAction$UserInfo;", "Lcom/lark/wire/Message;", "Lcom/lark/kmp/pb/basic/v1/CardAction$UserInfo$Builder;", "builder", "unknownFields", "Lokio/ByteString;", "<init>", "(Lcom/lark/kmp/pb/basic/v1/CardAction$UserInfo$Builder;Lokio/ByteString;)V", "user_open_id", "", "getUser_open_id", "()Ljava/lang/String;", "newBuilder", "toString", "Builder", "Companion", "rust-sdk-kotlin-pb_release"}, k = 1, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
    public static final class UserInfo extends com.lark.wire.Message<UserInfo, a> {
        public static final ProtoAdapter<UserInfo> ADAPTER = null;
        public static final c Companion = null;
        private static final long serialVersionUID = 0;
        private final String user_open_id;

        public static final class a extends com.lark.wire.Message.a<UserInfo, a> {
            public String d;

            @Override // com.lark.wire.Message.a
            public final com.lark.wire.Message b() {
                return new UserInfo(this, c(), null);
            }

            public a() {
            }
        }

        public static final class b extends ProtoAdapter<UserInfo> {
            @Override // com.lark.wire.ProtoAdapter
            public final UserInfo c(g0 r7) {
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
                return new UserInfo(r1, r7.d(r2), null);
            }

            @Override // com.lark.wire.ProtoAdapter
            public final int k(UserInfo r4) {
                UserInfo r5 = r4;
                Intrinsics.checkNotNullParameter(r5, "value");
                return r5.unknownFields().size() + ProtoAdapter.q.l(1, r5.getUser_open_id());
            }

            @Override // com.lark.wire.ProtoAdapter
            public final void f(j0 r4, UserInfo r5) {
                UserInfo r6 = r5;
                Intrinsics.checkNotNullParameter(r4, "writer");
                Intrinsics.checkNotNullParameter(r6, "value");
                ProtoAdapter.q.i(r4, 1, r6.getUser_open_id());
                r4.a(r6.unknownFields());
            }

            @Override // com.lark.wire.ProtoAdapter
            public final void g(n0 r3, UserInfo r4) {
                UserInfo r5 = r4;
                Intrinsics.checkNotNullParameter(r3, "writer");
                Intrinsics.checkNotNullParameter(r5, "value");
                r3.d(r5.unknownFields());
                ProtoAdapter.q.j(r3, 1, r5.getUser_open_id());
            }

            public b(FieldEncoding r7, KClass<UserInfo> r8, Syntax r9) {
                super(r7, r8, "type.googleapis.com/basic.v1.CardAction.UserInfo", r9, null);
            }
        }

        public static final class c {
            public c() {
            }
        }

        public /* synthetic */ UserInfo(a r1, ByteString r2, DefaultConstructorMarker r3) {
            this(r1, r2);
        }

        static {
            Companion = new c();
            ADAPTER = new b(FieldEncoding.LENGTH_DELIMITED, Reflection.getOrCreateKotlinClass(UserInfo.class), Syntax.PROTO_2);
        }

        @Override // com.lark.wire.Message
        public a newBuilder() {
            a r0 = new a();
            r0.d = this.user_open_id;
            r0.a(unknownFields());
            return r0;
        }

        @Override // com.lark.wire.Message
        public String toString() {
            return Reflection.getOrCreateKotlinClass(UserInfo.class).getSimpleName() + '@' + hashCode();
        }

        public final String getUser_open_id() {
            return this.user_open_id;
        }

        @Override // com.lark.wire.Message
        public /* bridge */ /* synthetic */ com.lark.wire.Message.a newBuilder() {
            return newBuilder();
        }

        public UserInfo(a r2, ByteString r3) {
            super(ADAPTER, r3);
            this.user_open_id = r2.d;
        }

        public /* synthetic */ UserInfo(a r1, ByteString r2, int r3, DefaultConstructorMarker r4) {
            if ((r3 & 2) == 0) goto L5;
            r2 = ByteString.EMPTY;
        L5:
            this(r1, r2);
        }
    }

    public static final class a extends com.lark.wire.Message.a<CardAction, a> {
        public String d;
        public Method e;
        public RequiredParameters f;
        public Parameters g;
        public Integer h;
        public CardActionPacket i;
        public Url j;

        @Override // com.lark.wire.Message.a
        public final com.lark.wire.Message b() {
            return new CardAction(this, c(), null);
        }

        public a() {
        }
    }

    public static final class b extends ProtoAdapter<CardAction> {
        @Override // com.lark.wire.ProtoAdapter
        public final CardAction c(g0 r10) {
            Intrinsics.checkNotNullParameter(r10, "reader");
            a r1 = new a();
            long r2 = r10.c();
        L3:
            int r4 = r10.e();
            if (r4 == (-1)) goto L18;
            switch(r4) {
                case 1: goto L16;
                case 2: goto L19;
                case 3: goto L11;
                case 4: goto L10;
                case 5: goto L9;
                case 6: goto L8;
                case 7: goto L7;
                default: goto L6;
            };
        L19:
            Method r5 = Method.ADAPTER.c(r10);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L14
            Intrinsics.checkNotNullParameter(r5, "method");     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L14
            r1.e = r5;     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L14
        L14:
            e = move-exception;
            r10.a(r4, FieldEncoding.VARINT, Long.valueOf(e.value));
            Unit r6 = Unit.INSTANCE;
            goto L3
        L7:
            r1.j = Url.ADAPTER.c(r10);
            goto L3
        L8:
            r1.i = CardActionPacket.ADAPTER.c(r10);
            goto L3
        L9:
            r1.h = (Integer) ProtoAdapter.h.c(r10);
            goto L3
        L10:
            r1.g = Parameters.ADAPTER.c(r10);
            goto L3
        L11:
            r1.f = RequiredParameters.ADAPTER.c(r10);
            goto L3
        L16:
            ProtoAdapter.q.getClass();
            Intrinsics.checkNotNullParameter(r10, "reader");
            String r7 = r10.i();
            Intrinsics.checkNotNullParameter(r7, "url");
            r1.d = r7;
            goto L3
        L6:
            r10.j(r4);
            Unit r8 = Unit.INSTANCE;
            goto L3
        L18:
            return new CardAction(r1, r10.d(r2), null);
        }

        @Override // com.lark.wire.ProtoAdapter
        public final int k(CardAction r5) {
            CardAction r6 = r5;
            Intrinsics.checkNotNullParameter(r6, "value");
            return ((((((r6.unknownFields().size() + ProtoAdapter.q.l(1, r6.getUrl())) + Method.ADAPTER.l(2, r6.getMethod())) + RequiredParameters.ADAPTER.l(3, r6.getRequired_parameters())) + Parameters.ADAPTER.l(4, r6.getParameters())) + ProtoAdapter.h.l(5, r6.getCmd())) + CardActionPacket.ADAPTER.l(6, r6.getPacket())) + Url.ADAPTER.l(7, r6.getOpen_url());
        }

        @Override // com.lark.wire.ProtoAdapter
        public final void f(j0 r4, CardAction r5) {
            CardAction r6 = r5;
            Intrinsics.checkNotNullParameter(r4, "writer");
            Intrinsics.checkNotNullParameter(r6, "value");
            ProtoAdapter.q.i(r4, 1, r6.getUrl());
            Method.ADAPTER.i(r4, 2, r6.getMethod());
            RequiredParameters.ADAPTER.i(r4, 3, r6.getRequired_parameters());
            Parameters.ADAPTER.i(r4, 4, r6.getParameters());
            ProtoAdapter.h.i(r4, 5, r6.getCmd());
            CardActionPacket.ADAPTER.i(r4, 6, r6.getPacket());
            Url.ADAPTER.i(r4, 7, r6.getOpen_url());
            r4.a(r6.unknownFields());
        }

        @Override // com.lark.wire.ProtoAdapter
        public final void g(n0 r4, CardAction r5) {
            CardAction r6 = r5;
            Intrinsics.checkNotNullParameter(r4, "writer");
            Intrinsics.checkNotNullParameter(r6, "value");
            r4.d(r6.unknownFields());
            Url.ADAPTER.j(r4, 7, r6.getOpen_url());
            CardActionPacket.ADAPTER.j(r4, 6, r6.getPacket());
            ProtoAdapter.h.j(r4, 5, r6.getCmd());
            Parameters.ADAPTER.j(r4, 4, r6.getParameters());
            RequiredParameters.ADAPTER.j(r4, 3, r6.getRequired_parameters());
            Method.ADAPTER.j(r4, 2, r6.getMethod());
            ProtoAdapter.q.j(r4, 1, r6.getUrl());
        }

        public b(FieldEncoding r7, KClass<CardAction> r8, Syntax r9) {
            super(r7, r8, "type.googleapis.com/basic.v1.CardAction", r9, null);
        }
    }

    public static final class c {
        public c() {
        }
    }

    public /* synthetic */ CardAction(a r1, ByteString r2, DefaultConstructorMarker r3) {
        this(r1, r2);
    }

    static {
        Companion = new c();
        ADAPTER = new b(FieldEncoding.LENGTH_DELIMITED, Reflection.getOrCreateKotlinClass(CardAction.class), Syntax.PROTO_2);
    }

    @Override // com.lark.wire.Message
    public a newBuilder() {
        a r0 = new a();
        r0.d = this.url;
        r0.e = this.method;
        r0.f = this.required_parameters;
        r0.g = this.parameters;
        r0.h = this.cmd;
        r0.i = this.packet;
        r0.j = this.open_url;
        r0.a(unknownFields());
        return r0;
    }

    @Override // com.lark.wire.Message
    public String toString() {
        return Reflection.getOrCreateKotlinClass(CardAction.class).getSimpleName() + '@' + hashCode();
    }

    public final Integer getCmd() {
        return this.cmd;
    }

    public final Method getMethod() {
        return this.method;
    }

    public final Url getOpen_url() {
        return this.open_url;
    }

    public final CardActionPacket getPacket() {
        return this.packet;
    }

    public final Parameters getParameters() {
        return this.parameters;
    }

    public final RequiredParameters getRequired_parameters() {
        return this.required_parameters;
    }

    public final String getUrl() {
        return this.url;
    }

    @Override // com.lark.wire.Message
    public /* bridge */ /* synthetic */ com.lark.wire.Message.a newBuilder() {
        return newBuilder();
    }

    public CardAction(a r2, ByteString r3) {
        super(ADAPTER, r3);
        String r4 = r2.d;
        Intrinsics.checkNotNull(r4);
        this.url = r4;
        Method r5 = r2.e;
        Intrinsics.checkNotNull(r5);
        this.method = r5;
        this.required_parameters = r2.f;
        this.parameters = r2.g;
        this.cmd = r2.h;
        this.packet = r2.i;
        this.open_url = r2.j;
    }

    public /* synthetic */ CardAction(a r1, ByteString r2, int r3, DefaultConstructorMarker r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = ByteString.EMPTY;
    L5:
        this(r1, r2);
    }
}
