package com.lark.kmp.pb.basic.v1;

import com.lark.wire.FieldEncoding;
import com.lark.wire.ProtoAdapter;
import com.lark.wire.Syntax;
import com.lark.wire.d;
import com.lark.wire.g0;
import com.lark.wire.j0;
import com.lark.wire.n0;
import com.lark.wire.o0;
import com.lark.wire.w;
import com.larksuite.component.card.protocol.context.action.CardActionService;
import com.larksuite.component.universe_design.timepicker.impl.base.WheelView;
import com.larus.audio.call.dora.CommandStatus;
import java.util.ArrayList;
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
@Metadata(d1 = {"\u0000\u0080\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0010\u0018\u0000 B2\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00020\u0001:\u000bABCDEFGHIJKB\u001b\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\b\u0010?\u001a\u00020\u0002H\u0016J\b\u0010@\u001a\u00020\tH\u0016R\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\f\u001a\u00020\r¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0013\u0010\u0010\u001a\u0004\u0018\u00010\u0011¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0015\u0010\u0014\u001a\u0004\u0018\u00010\u0015¢\u0006\n\n\u0002\u0010\u0018\u001a\u0004\b\u0016\u0010\u0017R\u0013\u0010\u0019\u001a\u0004\u0018\u00010\u001a¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001cR\u0013\u0010\u001d\u001a\u0004\u0018\u00010\u001e¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010 R\u0013\u0010!\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010\u000bR\u0013\u0010#\u001a\u0004\u0018\u00010$¢\u0006\b\n\u0000\u001a\u0004\b%\u0010&R\u0013\u0010'\u001a\u0004\u0018\u00010(¢\u0006\b\n\u0000\u001a\u0004\b)\u0010*R\u0013\u0010+\u001a\u0004\u0018\u00010,¢\u0006\b\n\u0000\u001a\u0004\b-\u0010.R\u0013\u0010/\u001a\u0004\u0018\u000100¢\u0006\b\n\u0000\u001a\u0004\b1\u00102R\u0013\u00103\u001a\u0004\u0018\u000104¢\u0006\b\n\u0000\u001a\u0004\b5\u00106R\u0013\u00107\u001a\u0004\u0018\u000108¢\u0006\b\n\u0000\u001a\u0004\b9\u0010:R\u0013\u0010;\u001a\u0004\u0018\u00010<¢\u0006\b\n\u0000\u001a\u0004\b=\u0010>¨\u0006L"}, d2 = {"Lcom/lark/kmp/pb/basic/v1/UrlPreviewAction;", "Lcom/lark/wire/Message;", "Lcom/lark/kmp/pb/basic/v1/UrlPreviewAction$Builder;", "builder", "unknownFields", "Lokio/ByteString;", "<init>", "(Lcom/lark/kmp/pb/basic/v1/UrlPreviewAction$Builder;Lokio/ByteString;)V", "url", "", "getUrl", "()Ljava/lang/String;", "method", "Lcom/lark/kmp/pb/basic/v1/UrlPreviewAction$Method;", "getMethod", "()Lcom/lark/kmp/pb/basic/v1/UrlPreviewAction$Method;", "parameters", "Lcom/lark/kmp/pb/basic/v1/UrlPreviewAction$Parameters;", "getParameters", "()Lcom/lark/kmp/pb/basic/v1/UrlPreviewAction$Parameters;", "cmd", "", "getCmd", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "packet", "Lcom/lark/kmp/pb/basic/v1/CardActionPacket;", "getPacket", "()Lcom/lark/kmp/pb/basic/v1/CardActionPacket;", "open_url", "Lcom/lark/kmp/pb/basic/v1/URL;", "getOpen_url", "()Lcom/lark/kmp/pb/basic/v1/URL;", "fallback_action_id", "getFallback_action_id", "get", "Lcom/lark/kmp/pb/basic/v1/UrlPreviewAction$GetAction;", "getGet", "()Lcom/lark/kmp/pb/basic/v1/UrlPreviewAction$GetAction;", "post", "Lcom/lark/kmp/pb/basic/v1/UrlPreviewAction$PostAction;", "getPost", "()Lcom/lark/kmp/pb/basic/v1/UrlPreviewAction$PostAction;", "command", "Lcom/lark/kmp/pb/basic/v1/UrlPreviewAction$LarkCommandAction;", "getCommand", "()Lcom/lark/kmp/pb/basic/v1/UrlPreviewAction$LarkCommandAction;", "open_url_v2", "Lcom/lark/kmp/pb/basic/v1/UrlPreviewAction$OpenURLAction;", "getOpen_url_v2", "()Lcom/lark/kmp/pb/basic/v1/UrlPreviewAction$OpenURLAction;", "switch_state", "Lcom/lark/kmp/pb/basic/v1/UrlPreviewAction$SwitchStateAction;", "getSwitch_state", "()Lcom/lark/kmp/pb/basic/v1/UrlPreviewAction$SwitchStateAction;", "show_toast", "Lcom/lark/kmp/pb/basic/v1/UrlPreviewAction$ShowToastAction;", "getShow_toast", "()Lcom/lark/kmp/pb/basic/v1/UrlPreviewAction$ShowToastAction;", "show_dialog", "Lcom/lark/kmp/pb/basic/v1/UrlPreviewAction$ShowDialogAction;", "getShow_dialog", "()Lcom/lark/kmp/pb/basic/v1/UrlPreviewAction$ShowDialogAction;", "newBuilder", "toString", "Builder", "Companion", "Method", "Parameters", "GetAction", "PostAction", "LarkCommandAction", "OpenURLAction", "SwitchStateAction", "ShowToastAction", "ShowDialogAction", "rust-sdk-kotlin-pb_release"}, k = 1, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
public final class UrlPreviewAction extends com.lark.wire.Message<UrlPreviewAction, a> {
    public static final ProtoAdapter<UrlPreviewAction> ADAPTER = null;
    public static final c Companion = null;
    private static final long serialVersionUID = 0;
    private final Integer cmd;
    private final LarkCommandAction command;
    private final String fallback_action_id;
    private final GetAction get;
    private final Method method;
    private final URL open_url;
    private final OpenURLAction open_url_v2;
    private final CardActionPacket packet;
    private final Parameters parameters;
    private final PostAction post;
    private final ShowDialogAction show_dialog;
    private final ShowToastAction show_toast;
    private final SwitchStateAction switch_state;
    private final String url;

    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0003\u0018\u0000 \u00102\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00020\u0001:\u0002\u000f\u0010B\u001b\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\b\u0010\f\u001a\u00020\u0002H\u0016J\b\u0010\r\u001a\u00020\u000eH\u0016R\u0013\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0011"}, d2 = {"Lcom/lark/kmp/pb/basic/v1/UrlPreviewAction$GetAction;", "Lcom/lark/wire/Message;", "Lcom/lark/kmp/pb/basic/v1/UrlPreviewAction$GetAction$Builder;", "builder", "unknownFields", "Lokio/ByteString;", "<init>", "(Lcom/lark/kmp/pb/basic/v1/UrlPreviewAction$GetAction$Builder;Lokio/ByteString;)V", "parameters", "Lcom/lark/kmp/pb/basic/v1/UrlPreviewAction$Parameters;", "getParameters", "()Lcom/lark/kmp/pb/basic/v1/UrlPreviewAction$Parameters;", "newBuilder", "toString", "", "Builder", "Companion", "rust-sdk-kotlin-pb_release"}, k = 1, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
    public static final class GetAction extends com.lark.wire.Message<GetAction, a> {
        public static final ProtoAdapter<GetAction> ADAPTER = null;
        public static final c Companion = null;
        private static final long serialVersionUID = 0;
        private final Parameters parameters;

        public static final class a extends com.lark.wire.Message.a<GetAction, a> {
            public Parameters d;

            @Override // com.lark.wire.Message.a
            public final com.lark.wire.Message b() {
                return new GetAction(this, c(), null);
            }

            public a() {
            }
        }

        public static final class b extends ProtoAdapter<GetAction> {
            @Override // com.lark.wire.ProtoAdapter
            public final GetAction c(g0 r6) {
                Intrinsics.checkNotNullParameter(r6, "reader");
                a r0 = new a();
                long r1 = r6.c();
            L3:
                int r3 = r6.e();
                if (r3 == (-1)) goto L10;
                if (r3 == 1) goto L7;
                r6.j(r3);
                goto L3
            L7:
                r0.d = Parameters.ADAPTER.c(r6);
                goto L3
            L10:
                return new GetAction(r0, r6.d(r1), null);
            }

            @Override // com.lark.wire.ProtoAdapter
            public final int k(GetAction r4) {
                GetAction r5 = r4;
                Intrinsics.checkNotNullParameter(r5, "value");
                return r5.unknownFields().size() + Parameters.ADAPTER.l(1, r5.getParameters());
            }

            @Override // com.lark.wire.ProtoAdapter
            public final void f(j0 r4, GetAction r5) {
                GetAction r6 = r5;
                Intrinsics.checkNotNullParameter(r4, "writer");
                Intrinsics.checkNotNullParameter(r6, "value");
                Parameters.ADAPTER.i(r4, 1, r6.getParameters());
                r4.a(r6.unknownFields());
            }

            @Override // com.lark.wire.ProtoAdapter
            public final void g(n0 r3, GetAction r4) {
                GetAction r5 = r4;
                Intrinsics.checkNotNullParameter(r3, "writer");
                Intrinsics.checkNotNullParameter(r5, "value");
                r3.d(r5.unknownFields());
                Parameters.ADAPTER.j(r3, 1, r5.getParameters());
            }

            public b(FieldEncoding r7, KClass<GetAction> r8, Syntax r9) {
                super(r7, r8, "type.googleapis.com/basic.v1.UrlPreviewAction.GetAction", r9, null);
            }
        }

        public static final class c {
            public c() {
            }
        }

        public /* synthetic */ GetAction(a r1, ByteString r2, DefaultConstructorMarker r3) {
            this(r1, r2);
        }

        static {
            Companion = new c();
            ADAPTER = new b(FieldEncoding.LENGTH_DELIMITED, Reflection.getOrCreateKotlinClass(GetAction.class), Syntax.PROTO_2);
        }

        @Override // com.lark.wire.Message
        public a newBuilder() {
            a r0 = new a();
            r0.d = this.parameters;
            r0.a(unknownFields());
            return r0;
        }

        @Override // com.lark.wire.Message
        public String toString() {
            return Reflection.getOrCreateKotlinClass(GetAction.class).getSimpleName() + '@' + hashCode();
        }

        public final Parameters getParameters() {
            return this.parameters;
        }

        @Override // com.lark.wire.Message
        public /* bridge */ /* synthetic */ com.lark.wire.Message.a newBuilder() {
            return newBuilder();
        }

        public GetAction(a r2, ByteString r3) {
            super(ADAPTER, r3);
            this.parameters = r2.d;
        }

        public /* synthetic */ GetAction(a r1, ByteString r2, int r3, DefaultConstructorMarker r4) {
            if ((r3 & 2) == 0) goto L5;
            r2 = ByteString.EMPTY;
        L5:
            this(r1, r2);
        }
    }

    @Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0003\u0018\u0000 \u00192\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00020\u0001:\u0002\u0018\u0019B\u001b\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\b\u0010\u0015\u001a\u00020\u0002H\u0016J\b\u0010\u0016\u001a\u00020\u0017H\u0016R\u0015\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\n\n\u0002\u0010\f\u001a\u0004\b\n\u0010\u000bR\u0013\u0010\r\u001a\u0004\u0018\u00010\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0013\u0010\u0011\u001a\u0004\u0018\u00010\u0012¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014¨\u0006\u001a"}, d2 = {"Lcom/lark/kmp/pb/basic/v1/UrlPreviewAction$LarkCommandAction;", "Lcom/lark/wire/Message;", "Lcom/lark/kmp/pb/basic/v1/UrlPreviewAction$LarkCommandAction$Builder;", "builder", "unknownFields", "Lokio/ByteString;", "<init>", "(Lcom/lark/kmp/pb/basic/v1/UrlPreviewAction$LarkCommandAction$Builder;Lokio/ByteString;)V", "cmd", "", "getCmd", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "packet", "Lcom/lark/kmp/pb/basic/v1/CardActionPacket;", "getPacket", "()Lcom/lark/kmp/pb/basic/v1/CardActionPacket;", "parameters", "Lcom/lark/kmp/pb/basic/v1/UrlPreviewAction$Parameters;", "getParameters", "()Lcom/lark/kmp/pb/basic/v1/UrlPreviewAction$Parameters;", "newBuilder", "toString", "", "Builder", "Companion", "rust-sdk-kotlin-pb_release"}, k = 1, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
    public static final class LarkCommandAction extends com.lark.wire.Message<LarkCommandAction, a> {
        public static final ProtoAdapter<LarkCommandAction> ADAPTER = null;
        public static final c Companion = null;
        private static final long serialVersionUID = 0;
        private final Integer cmd;
        private final CardActionPacket packet;
        private final Parameters parameters;

        public static final class a extends com.lark.wire.Message.a<LarkCommandAction, a> {
            public Integer d;
            public CardActionPacket e;
            public Parameters f;

            @Override // com.lark.wire.Message.a
            public final com.lark.wire.Message b() {
                return new LarkCommandAction(this, c(), null);
            }

            public a() {
            }
        }

        public static final class b extends ProtoAdapter<LarkCommandAction> {
            @Override // com.lark.wire.ProtoAdapter
            public final LarkCommandAction c(g0 r6) {
                Intrinsics.checkNotNullParameter(r6, "reader");
                a r0 = new a();
                long r1 = r6.c();
            L3:
                int r3 = r6.e();
                if (r3 == (-1)) goto L16;
                if (r3 != 1) goto L8;
                r0.d = (Integer) ProtoAdapter.h.c(r6);
                goto L3
            L8:
                if (r3 != 2) goto L10;
                r0.e = CardActionPacket.ADAPTER.c(r6);
                goto L3
            L10:
                if (r3 != 3) goto L11;
                r0.f = Parameters.ADAPTER.c(r6);
                goto L3
            L11:
                r6.j(r3);
                Unit r4 = Unit.INSTANCE;
                goto L3
            L16:
                return new LarkCommandAction(r0, r6.d(r1), null);
            }

            @Override // com.lark.wire.ProtoAdapter
            public final int k(LarkCommandAction r5) {
                LarkCommandAction r6 = r5;
                Intrinsics.checkNotNullParameter(r6, "value");
                return ((r6.unknownFields().size() + ProtoAdapter.h.l(1, r6.getCmd())) + CardActionPacket.ADAPTER.l(2, r6.getPacket())) + Parameters.ADAPTER.l(3, r6.getParameters());
            }

            @Override // com.lark.wire.ProtoAdapter
            public final void f(j0 r4, LarkCommandAction r5) {
                LarkCommandAction r6 = r5;
                Intrinsics.checkNotNullParameter(r4, "writer");
                Intrinsics.checkNotNullParameter(r6, "value");
                ProtoAdapter.h.i(r4, 1, r6.getCmd());
                CardActionPacket.ADAPTER.i(r4, 2, r6.getPacket());
                Parameters.ADAPTER.i(r4, 3, r6.getParameters());
                r4.a(r6.unknownFields());
            }

            @Override // com.lark.wire.ProtoAdapter
            public final void g(n0 r4, LarkCommandAction r5) {
                LarkCommandAction r6 = r5;
                Intrinsics.checkNotNullParameter(r4, "writer");
                Intrinsics.checkNotNullParameter(r6, "value");
                r4.d(r6.unknownFields());
                Parameters.ADAPTER.j(r4, 3, r6.getParameters());
                CardActionPacket.ADAPTER.j(r4, 2, r6.getPacket());
                ProtoAdapter.h.j(r4, 1, r6.getCmd());
            }

            public b(FieldEncoding r7, KClass<LarkCommandAction> r8, Syntax r9) {
                super(r7, r8, "type.googleapis.com/basic.v1.UrlPreviewAction.LarkCommandAction", r9, null);
            }
        }

        public static final class c {
            public c() {
            }
        }

        public /* synthetic */ LarkCommandAction(a r1, ByteString r2, DefaultConstructorMarker r3) {
            this(r1, r2);
        }

        static {
            Companion = new c();
            ADAPTER = new b(FieldEncoding.LENGTH_DELIMITED, Reflection.getOrCreateKotlinClass(LarkCommandAction.class), Syntax.PROTO_2);
        }

        @Override // com.lark.wire.Message
        public a newBuilder() {
            a r0 = new a();
            r0.d = this.cmd;
            r0.e = this.packet;
            r0.f = this.parameters;
            r0.a(unknownFields());
            return r0;
        }

        @Override // com.lark.wire.Message
        public String toString() {
            return Reflection.getOrCreateKotlinClass(LarkCommandAction.class).getSimpleName() + '@' + hashCode();
        }

        public final Integer getCmd() {
            return this.cmd;
        }

        public final CardActionPacket getPacket() {
            return this.packet;
        }

        public final Parameters getParameters() {
            return this.parameters;
        }

        @Override // com.lark.wire.Message
        public /* bridge */ /* synthetic */ com.lark.wire.Message.a newBuilder() {
            return newBuilder();
        }

        public LarkCommandAction(a r2, ByteString r3) {
            super(ADAPTER, r3);
            this.cmd = r2.d;
            this.packet = r2.e;
            this.parameters = r2.f;
        }

        public /* synthetic */ LarkCommandAction(a r1, ByteString r2, int r3, DefaultConstructorMarker r4) {
            if ((r3 & 2) == 0) goto L5;
            r2 = ByteString.EMPTY;
        L5:
            this(r1, r2);
        }
    }

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\r\b\u0086\u0081\u0002\u0018\u0000 \u00102\u00020\u00012\b\u0012\u0004\u0012\u00020\u00000\u0002:\u0001\u0010B\u0011\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u0004X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000f¨\u0006\u0011"}, d2 = {"Lcom/lark/kmp/pb/basic/v1/UrlPreviewAction$Method;", "Lcom/lark/wire/WireEnum;", "", "value", "", "<init>", "(Ljava/lang/String;II)V", "getValue", "()I", "GET", "POST", "LARK_COMMAND", "OPEN_URL", "SWITCH_STATE", "SHOW_TOAST", "SHOW_DIALOG", "Companion", "rust-sdk-kotlin-pb_release"}, k = 1, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
    public static final enum Method extends Enum<Method> implements o0 {
        public static final ProtoAdapter<Method> ADAPTER = null;
        public static final b Companion = null;
        public static final Method GET = null;
        public static final Method LARK_COMMAND = null;
        public static final Method OPEN_URL = null;
        public static final Method POST = null;
        public static final Method SHOW_DIALOG = null;
        public static final Method SHOW_TOAST = null;
        public static final Method SWITCH_STATE = null;
        public static final /* synthetic */ Method[] a = null;
        public static final /* synthetic */ EnumEntries b = null;
        private final int value;

        public static final class a extends d<Method> {
            @Override // com.lark.wire.d
            public final o0 n(int r2) {
                Method.Companion.getClass();
                return b.a(r2);
            }

            public a(KClass<Method> r2, Syntax r3) {
                super(r2, r3, null);
            }
        }

        public static final class b {
            public b() {
            }

            @JvmStatic
            public static Method a(int r0) {
                switch(r0) {
                    case 1: goto L11;
                    case 2: goto L18;
                    case 3: goto L17;
                    case 4: goto L16;
                    case 5: goto L15;
                    case 6: goto L14;
                    case 7: goto L13;
                    default: goto L3;
                };
            L3:
                return null;
            L13:
                return Method.SHOW_DIALOG;
            L14:
                return Method.SHOW_TOAST;
            L15:
                return Method.SWITCH_STATE;
            L16:
                return Method.OPEN_URL;
            L17:
                return Method.LARK_COMMAND;
            L18:
                return Method.POST;
            L11:
                return Method.GET;
            }
        }

        @JvmStatic
        public static final Method fromValue(int r1) {
            Companion.getClass();
            return b.a(r1);
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
            Method r8 = new Method("SWITCH_STATE", 4, 5);
            SWITCH_STATE = r8;
            Method r10 = new Method("SHOW_TOAST", 5, 6);
            SHOW_TOAST = r10;
            Method r12 = new Method("SHOW_DIALOG", 6, 7);
            SHOW_DIALOG = r12;
            Method[] r14 = {r0, r1, r4, r6, r8, r10, r12};
            a = r14;
            b = EnumEntriesKt.enumEntries(r14);
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

        public static Method valueOf(String r1) {
            return (Method) r27.a.a(Method.class, r1);
        }

        public Method(String r1, int r2, int r3) {
            super(r1, r2);
            this.value = r3;
        }
    }

    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0003\u0018\u0000 \u00102\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00020\u0001:\u0002\u000f\u0010B\u001b\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\b\u0010\f\u001a\u00020\u0002H\u0016J\b\u0010\r\u001a\u00020\u000eH\u0016R\u0013\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0011"}, d2 = {"Lcom/lark/kmp/pb/basic/v1/UrlPreviewAction$OpenURLAction;", "Lcom/lark/wire/Message;", "Lcom/lark/kmp/pb/basic/v1/UrlPreviewAction$OpenURLAction$Builder;", "builder", "unknownFields", "Lokio/ByteString;", "<init>", "(Lcom/lark/kmp/pb/basic/v1/UrlPreviewAction$OpenURLAction$Builder;Lokio/ByteString;)V", "open_url", "Lcom/lark/kmp/pb/basic/v1/URL;", "getOpen_url", "()Lcom/lark/kmp/pb/basic/v1/URL;", "newBuilder", "toString", "", "Builder", "Companion", "rust-sdk-kotlin-pb_release"}, k = 1, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
    public static final class OpenURLAction extends com.lark.wire.Message<OpenURLAction, a> {
        public static final ProtoAdapter<OpenURLAction> ADAPTER = null;
        public static final c Companion = null;
        private static final long serialVersionUID = 0;
        private final URL open_url;

        public static final class a extends com.lark.wire.Message.a<OpenURLAction, a> {
            public URL d;

            @Override // com.lark.wire.Message.a
            public final com.lark.wire.Message b() {
                return new OpenURLAction(this, c(), null);
            }

            public a() {
            }
        }

        public static final class b extends ProtoAdapter<OpenURLAction> {
            @Override // com.lark.wire.ProtoAdapter
            public final OpenURLAction c(g0 r6) {
                Intrinsics.checkNotNullParameter(r6, "reader");
                a r0 = new a();
                long r1 = r6.c();
            L3:
                int r3 = r6.e();
                if (r3 == (-1)) goto L10;
                if (r3 == 1) goto L7;
                r6.j(r3);
                goto L3
            L7:
                r0.d = URL.ADAPTER.c(r6);
                goto L3
            L10:
                return new OpenURLAction(r0, r6.d(r1), null);
            }

            @Override // com.lark.wire.ProtoAdapter
            public final int k(OpenURLAction r4) {
                OpenURLAction r5 = r4;
                Intrinsics.checkNotNullParameter(r5, "value");
                return r5.unknownFields().size() + URL.ADAPTER.l(1, r5.getOpen_url());
            }

            @Override // com.lark.wire.ProtoAdapter
            public final void f(j0 r4, OpenURLAction r5) {
                OpenURLAction r6 = r5;
                Intrinsics.checkNotNullParameter(r4, "writer");
                Intrinsics.checkNotNullParameter(r6, "value");
                URL.ADAPTER.i(r4, 1, r6.getOpen_url());
                r4.a(r6.unknownFields());
            }

            @Override // com.lark.wire.ProtoAdapter
            public final void g(n0 r3, OpenURLAction r4) {
                OpenURLAction r5 = r4;
                Intrinsics.checkNotNullParameter(r3, "writer");
                Intrinsics.checkNotNullParameter(r5, "value");
                r3.d(r5.unknownFields());
                URL.ADAPTER.j(r3, 1, r5.getOpen_url());
            }

            public b(FieldEncoding r7, KClass<OpenURLAction> r8, Syntax r9) {
                super(r7, r8, "type.googleapis.com/basic.v1.UrlPreviewAction.OpenURLAction", r9, null);
            }
        }

        public static final class c {
            public c() {
            }
        }

        public /* synthetic */ OpenURLAction(a r1, ByteString r2, DefaultConstructorMarker r3) {
            this(r1, r2);
        }

        static {
            Companion = new c();
            ADAPTER = new b(FieldEncoding.LENGTH_DELIMITED, Reflection.getOrCreateKotlinClass(OpenURLAction.class), Syntax.PROTO_2);
        }

        @Override // com.lark.wire.Message
        public a newBuilder() {
            a r0 = new a();
            r0.d = this.open_url;
            r0.a(unknownFields());
            return r0;
        }

        @Override // com.lark.wire.Message
        public String toString() {
            return Reflection.getOrCreateKotlinClass(OpenURLAction.class).getSimpleName() + '@' + hashCode();
        }

        public final URL getOpen_url() {
            return this.open_url;
        }

        @Override // com.lark.wire.Message
        public /* bridge */ /* synthetic */ com.lark.wire.Message.a newBuilder() {
            return newBuilder();
        }

        public OpenURLAction(a r2, ByteString r3) {
            super(ADAPTER, r3);
            this.open_url = r2.d;
        }

        public /* synthetic */ OpenURLAction(a r1, ByteString r2, int r3, DefaultConstructorMarker r4) {
            if ((r3 & 2) == 0) goto L5;
            r2 = ByteString.EMPTY;
        L5:
            this(r1, r2);
        }
    }

    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\u000e\u0018\u0000 \u00172\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00020\u0001:\u0002\u0016\u0017B\u001b\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\b\u0010\u0014\u001a\u00020\u0002H\u0016J\b\u0010\u0015\u001a\u00020\nH\u0016R\u001d\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\n0\t¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0013\u0010\r\u001a\u0004\u0018\u00010\n¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0013\u0010\u0010\u001a\u0004\u0018\u00010\n¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u000fR\u0013\u0010\u0012\u001a\u0004\u0018\u00010\n¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u000f¨\u0006\u0018"}, d2 = {"Lcom/lark/kmp/pb/basic/v1/UrlPreviewAction$Parameters;", "Lcom/lark/wire/Message;", "Lcom/lark/kmp/pb/basic/v1/UrlPreviewAction$Parameters$Builder;", "builder", "unknownFields", "Lokio/ByteString;", "<init>", "(Lcom/lark/kmp/pb/basic/v1/UrlPreviewAction$Parameters$Builder;Lokio/ByteString;)V", "parameters", "", "", "getParameters", "()Ljava/util/Map;", "user_id", "getUser_id", "()Ljava/lang/String;", "source_id", "getSource_id", "preview_id", "getPreview_id", "newBuilder", "toString", "Builder", "Companion", "rust-sdk-kotlin-pb_release"}, k = 1, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
    public static final class Parameters extends com.lark.wire.Message<Parameters, a> {
        public static final ProtoAdapter<Parameters> ADAPTER = null;
        public static final b Companion = null;
        private static final long serialVersionUID = 0;
        private final Map<String, String> parameters;
        private final String preview_id;
        private final String source_id;
        private final String user_id;

        public static final class a extends com.lark.wire.Message.a<Parameters, a> {
            public Map<String, String> d;
            public String e;
            public String f;
            public String g;

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
            ADAPTER = new UrlPreviewAction$Parameters$Companion$ADAPTER$1(r0, r1, r2);
        }

        @Override // com.lark.wire.Message
        public a newBuilder() {
            a r0 = new a();
            r0.d = this.parameters;
            r0.e = this.user_id;
            r0.f = this.source_id;
            r0.g = this.preview_id;
            r0.a(unknownFields());
            return r0;
        }

        @Override // com.lark.wire.Message
        public String toString() {
            return Reflection.getOrCreateKotlinClass(Parameters.class).getSimpleName() + '@' + hashCode();
        }

        public final Map<String, String> getParameters() {
            return this.parameters;
        }

        public final String getPreview_id() {
            return this.preview_id;
        }

        public final String getSource_id() {
            return this.source_id;
        }

        public final String getUser_id() {
            return this.user_id;
        }

        @Override // com.lark.wire.Message
        public /* bridge */ /* synthetic */ com.lark.wire.Message.a newBuilder() {
            return newBuilder();
        }

        public Parameters(a r2, ByteString r3) {
            super(ADAPTER, r3);
            this.parameters = com.lark.wire.internal.a.d("parameters", r2.d);
            this.user_id = r2.e;
            this.source_id = r2.f;
            this.preview_id = r2.g;
        }

        public /* synthetic */ Parameters(a r1, ByteString r2, int r3, DefaultConstructorMarker r4) {
            if ((r3 & 2) == 0) goto L5;
            r2 = ByteString.EMPTY;
        L5:
            this(r1, r2);
        }
    }

    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0003\u0018\u0000 \u00102\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00020\u0001:\u0002\u000f\u0010B\u001b\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\b\u0010\f\u001a\u00020\u0002H\u0016J\b\u0010\r\u001a\u00020\u000eH\u0016R\u0013\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0011"}, d2 = {"Lcom/lark/kmp/pb/basic/v1/UrlPreviewAction$PostAction;", "Lcom/lark/wire/Message;", "Lcom/lark/kmp/pb/basic/v1/UrlPreviewAction$PostAction$Builder;", "builder", "unknownFields", "Lokio/ByteString;", "<init>", "(Lcom/lark/kmp/pb/basic/v1/UrlPreviewAction$PostAction$Builder;Lokio/ByteString;)V", "parameters", "Lcom/lark/kmp/pb/basic/v1/UrlPreviewAction$Parameters;", "getParameters", "()Lcom/lark/kmp/pb/basic/v1/UrlPreviewAction$Parameters;", "newBuilder", "toString", "", "Builder", "Companion", "rust-sdk-kotlin-pb_release"}, k = 1, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
    public static final class PostAction extends com.lark.wire.Message<PostAction, a> {
        public static final ProtoAdapter<PostAction> ADAPTER = null;
        public static final c Companion = null;
        private static final long serialVersionUID = 0;
        private final Parameters parameters;

        public static final class a extends com.lark.wire.Message.a<PostAction, a> {
            public Parameters d;

            @Override // com.lark.wire.Message.a
            public final com.lark.wire.Message b() {
                return new PostAction(this, c(), null);
            }

            public a() {
            }
        }

        public static final class b extends ProtoAdapter<PostAction> {
            @Override // com.lark.wire.ProtoAdapter
            public final PostAction c(g0 r6) {
                Intrinsics.checkNotNullParameter(r6, "reader");
                a r0 = new a();
                long r1 = r6.c();
            L3:
                int r3 = r6.e();
                if (r3 == (-1)) goto L10;
                if (r3 == 1) goto L7;
                r6.j(r3);
                goto L3
            L7:
                r0.d = Parameters.ADAPTER.c(r6);
                goto L3
            L10:
                return new PostAction(r0, r6.d(r1), null);
            }

            @Override // com.lark.wire.ProtoAdapter
            public final int k(PostAction r4) {
                PostAction r5 = r4;
                Intrinsics.checkNotNullParameter(r5, "value");
                return r5.unknownFields().size() + Parameters.ADAPTER.l(1, r5.getParameters());
            }

            @Override // com.lark.wire.ProtoAdapter
            public final void f(j0 r4, PostAction r5) {
                PostAction r6 = r5;
                Intrinsics.checkNotNullParameter(r4, "writer");
                Intrinsics.checkNotNullParameter(r6, "value");
                Parameters.ADAPTER.i(r4, 1, r6.getParameters());
                r4.a(r6.unknownFields());
            }

            @Override // com.lark.wire.ProtoAdapter
            public final void g(n0 r3, PostAction r4) {
                PostAction r5 = r4;
                Intrinsics.checkNotNullParameter(r3, "writer");
                Intrinsics.checkNotNullParameter(r5, "value");
                r3.d(r5.unknownFields());
                Parameters.ADAPTER.j(r3, 1, r5.getParameters());
            }

            public b(FieldEncoding r7, KClass<PostAction> r8, Syntax r9) {
                super(r7, r8, "type.googleapis.com/basic.v1.UrlPreviewAction.PostAction", r9, null);
            }
        }

        public static final class c {
            public c() {
            }
        }

        public /* synthetic */ PostAction(a r1, ByteString r2, DefaultConstructorMarker r3) {
            this(r1, r2);
        }

        static {
            Companion = new c();
            ADAPTER = new b(FieldEncoding.LENGTH_DELIMITED, Reflection.getOrCreateKotlinClass(PostAction.class), Syntax.PROTO_2);
        }

        @Override // com.lark.wire.Message
        public a newBuilder() {
            a r0 = new a();
            r0.d = this.parameters;
            r0.a(unknownFields());
            return r0;
        }

        @Override // com.lark.wire.Message
        public String toString() {
            return Reflection.getOrCreateKotlinClass(PostAction.class).getSimpleName() + '@' + hashCode();
        }

        public final Parameters getParameters() {
            return this.parameters;
        }

        @Override // com.lark.wire.Message
        public /* bridge */ /* synthetic */ com.lark.wire.Message.a newBuilder() {
            return newBuilder();
        }

        public PostAction(a r2, ByteString r3) {
            super(ADAPTER, r3);
            this.parameters = r2.d;
        }

        public /* synthetic */ PostAction(a r1, ByteString r2, int r3, DefaultConstructorMarker r4) {
            if ((r3 & 2) == 0) goto L5;
            r2 = ByteString.EMPTY;
        L5:
            this(r1, r2);
        }
    }

    @Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0006\u0018\u0000 \u00172\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00020\u0001:\u0005\u0016\u0017\u0018\u0019\u001aB\u001b\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\b\u0010\u0013\u001a\u00020\u0002H\u0016J\b\u0010\u0014\u001a\u00020\u0015H\u0016R\u0013\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0013\u0010\f\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000bR\u0017\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00100\u000f¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012¨\u0006\u001b"}, d2 = {"Lcom/lark/kmp/pb/basic/v1/UrlPreviewAction$ShowDialogAction;", "Lcom/lark/wire/Message;", "Lcom/lark/kmp/pb/basic/v1/UrlPreviewAction$ShowDialogAction$Builder;", "builder", "unknownFields", "Lokio/ByteString;", "<init>", "(Lcom/lark/kmp/pb/basic/v1/UrlPreviewAction$ShowDialogAction$Builder;Lokio/ByteString;)V", "title", "Lcom/lark/kmp/pb/basic/v1/UrlPreviewAction$ShowDialogAction$DialogItem;", "getTitle", "()Lcom/lark/kmp/pb/basic/v1/UrlPreviewAction$ShowDialogAction$DialogItem;", "content", "getContent", "buttons", "", "Lcom/lark/kmp/pb/basic/v1/UrlPreviewAction$ShowDialogAction$DialogButton;", "getButtons", "()Ljava/util/List;", "newBuilder", "toString", "", "Builder", "Companion", "DialogItem", "DialogButtonType", "DialogButton", "rust-sdk-kotlin-pb_release"}, k = 1, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
    public static final class ShowDialogAction extends com.lark.wire.Message<ShowDialogAction, a> {
        public static final ProtoAdapter<ShowDialogAction> ADAPTER = null;
        public static final c Companion = null;
        private static final long serialVersionUID = 0;
        private final List<DialogButton> buttons;
        private final DialogItem content;
        private final DialogItem title;

        @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u0000 \u00152\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00020\u0001:\u0002\u0014\u0015B\u001b\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\b\u0010\u0012\u001a\u00020\u0002H\u0016J\b\u0010\u0013\u001a\u00020\tH\u0016R\u0013\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0013\u0010\f\u001a\u0004\u0018\u00010\r¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0013\u0010\u0010\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u000b¨\u0006\u0016"}, d2 = {"Lcom/lark/kmp/pb/basic/v1/UrlPreviewAction$ShowDialogAction$DialogButton;", "Lcom/lark/wire/Message;", "Lcom/lark/kmp/pb/basic/v1/UrlPreviewAction$ShowDialogAction$DialogButton$Builder;", "builder", "unknownFields", "Lokio/ByteString;", "<init>", "(Lcom/lark/kmp/pb/basic/v1/UrlPreviewAction$ShowDialogAction$DialogButton$Builder;Lokio/ByteString;)V", "text", "", "getText", "()Ljava/lang/String;", "type", "Lcom/lark/kmp/pb/basic/v1/UrlPreviewAction$ShowDialogAction$DialogButtonType;", "getType", "()Lcom/lark/kmp/pb/basic/v1/UrlPreviewAction$ShowDialogAction$DialogButtonType;", CardActionService.ACTION_ID, "getAction_id", "newBuilder", "toString", "Builder", "Companion", "rust-sdk-kotlin-pb_release"}, k = 1, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
        public static final class DialogButton extends com.lark.wire.Message<DialogButton, a> {
            public static final ProtoAdapter<DialogButton> ADAPTER = null;
            public static final c Companion = null;
            public static final DialogButtonType DEFAULT_TYPE = null;
            private static final long serialVersionUID = 0;
            private final String action_id;
            private final String text;
            private final DialogButtonType type;

            public static final class a extends com.lark.wire.Message.a<DialogButton, a> {
                public String d;
                public DialogButtonType e;
                public String f;

                @Override // com.lark.wire.Message.a
                public final com.lark.wire.Message b() {
                    return new DialogButton(this, c(), null);
                }

                public a() {
                }
            }

            public static final class b extends ProtoAdapter<DialogButton> {
                @Override // com.lark.wire.ProtoAdapter
                public final DialogButton c(g0 r10) {
                    Intrinsics.checkNotNullParameter(r10, "reader");
                    a r1 = new a();
                    long r2 = r10.c();
                L3:
                    int r4 = r10.e();
                    if (r4 == (-1)) goto L19;
                    if (r4 != 1) goto L8;
                    ProtoAdapter.q.getClass();
                    Intrinsics.checkNotNullParameter(r10, "reader");
                    r1.d = r10.i();
                    goto L3
                L8:
                    if (r4 != 2) goto L10;
                    r1.e = DialogButtonType.ADAPTER.c(r10);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L15
                L15:
                    e = move-exception;
                    r10.a(r4, FieldEncoding.VARINT, Long.valueOf(e.value));
                    Unit r5 = Unit.INSTANCE;
                    goto L3
                L10:
                    if (r4 != 3) goto L11;
                    ProtoAdapter.q.getClass();
                    Intrinsics.checkNotNullParameter(r10, "reader");
                    r1.f = r10.i();
                    goto L3
                L11:
                    r10.j(r4);
                    goto L3
                L19:
                    return new DialogButton(r1, r10.d(r2), null);
                }

                @Override // com.lark.wire.ProtoAdapter
                public final int k(DialogButton r6) {
                    DialogButton r7 = r6;
                    Intrinsics.checkNotNullParameter(r7, "value");
                    int r0 = r7.unknownFields().size();
                    w r1 = ProtoAdapter.q;
                    return ((r0 + r1.l(1, r7.getText())) + DialogButtonType.ADAPTER.l(2, r7.getType())) + r1.l(3, r7.getAction_id());
                }

                @Override // com.lark.wire.ProtoAdapter
                public final void f(j0 r5, DialogButton r6) {
                    DialogButton r7 = r6;
                    Intrinsics.checkNotNullParameter(r5, "writer");
                    Intrinsics.checkNotNullParameter(r7, "value");
                    w r0 = ProtoAdapter.q;
                    r0.i(r5, 1, r7.getText());
                    DialogButtonType.ADAPTER.i(r5, 2, r7.getType());
                    r0.i(r5, 3, r7.getAction_id());
                    r5.a(r7.unknownFields());
                }

                @Override // com.lark.wire.ProtoAdapter
                public final void g(n0 r5, DialogButton r6) {
                    DialogButton r7 = r6;
                    Intrinsics.checkNotNullParameter(r5, "writer");
                    Intrinsics.checkNotNullParameter(r7, "value");
                    r5.d(r7.unknownFields());
                    w r0 = ProtoAdapter.q;
                    r0.j(r5, 3, r7.getAction_id());
                    DialogButtonType.ADAPTER.j(r5, 2, r7.getType());
                    r0.j(r5, 1, r7.getText());
                }

                public b(FieldEncoding r7, KClass<DialogButton> r8, Syntax r9) {
                    super(r7, r8, "type.googleapis.com/basic.v1.UrlPreviewAction.ShowDialogAction.DialogButton", r9, null);
                }
            }

            public static final class c {
                public c() {
                }
            }

            public /* synthetic */ DialogButton(a r1, ByteString r2, DefaultConstructorMarker r3) {
                this(r1, r2);
            }

            static {
                Companion = new c();
                DEFAULT_TYPE = DialogButtonType.DEFAULT;
                ADAPTER = new b(FieldEncoding.LENGTH_DELIMITED, Reflection.getOrCreateKotlinClass(DialogButton.class), Syntax.PROTO_2);
            }

            @Override // com.lark.wire.Message
            public a newBuilder() {
                a r0 = new a();
                r0.d = this.text;
                r0.e = this.type;
                r0.f = this.action_id;
                r0.a(unknownFields());
                return r0;
            }

            @Override // com.lark.wire.Message
            public String toString() {
                return Reflection.getOrCreateKotlinClass(DialogButton.class).getSimpleName() + '@' + hashCode();
            }

            public final String getAction_id() {
                return this.action_id;
            }

            public final String getText() {
                return this.text;
            }

            public final DialogButtonType getType() {
                return this.type;
            }

            @Override // com.lark.wire.Message
            public /* bridge */ /* synthetic */ com.lark.wire.Message.a newBuilder() {
                return newBuilder();
            }

            public DialogButton(a r2, ByteString r3) {
                super(ADAPTER, r3);
                this.text = r2.d;
                this.type = r2.e;
                this.action_id = r2.f;
            }

            public /* synthetic */ DialogButton(a r1, ByteString r2, int r3, DefaultConstructorMarker r4) {
                if ((r3 & 2) == 0) goto L5;
                r2 = ByteString.EMPTY;
            L5:
                this(r1, r2);
            }
        }

        @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\t\b\u0086\u0081\u0002\u0018\u0000 \f2\u00020\u00012\b\u0012\u0004\u0012\u00020\u00000\u0002:\u0001\fB\u0011\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u0004X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000b¨\u0006\r"}, d2 = {"Lcom/lark/kmp/pb/basic/v1/UrlPreviewAction$ShowDialogAction$DialogButtonType;", "Lcom/lark/wire/WireEnum;", "", "value", "", "<init>", "(Ljava/lang/String;II)V", "getValue", "()I", "DEFAULT", "PRIMARY", "DANGER", "Companion", "rust-sdk-kotlin-pb_release"}, k = 1, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
        public static final enum DialogButtonType extends Enum<DialogButtonType> implements o0 {
            public static final ProtoAdapter<DialogButtonType> ADAPTER = null;
            public static final b Companion = null;
            public static final DialogButtonType DANGER = null;
            public static final DialogButtonType DEFAULT = null;
            public static final DialogButtonType PRIMARY = null;
            public static final /* synthetic */ DialogButtonType[] a = null;
            public static final /* synthetic */ EnumEntries b = null;
            private final int value;

            public static final class a extends d<DialogButtonType> {
                @Override // com.lark.wire.d
                public final o0 n(int r2) {
                    DialogButtonType.Companion.getClass();
                    if (r2 == 0) goto L12;
                    if (r2 == 1) goto L15;
                    if (r2 == 2) goto L14;
                    return null;
                L14:
                    return DialogButtonType.DANGER;
                L15:
                    return DialogButtonType.PRIMARY;
                L12:
                    return DialogButtonType.DEFAULT;
                }

                public a(KClass<DialogButtonType> r1, Syntax r2, DialogButtonType r3) {
                    super(r1, r2, r3);
                }
            }

            public static final class b {
                public b() {
                }
            }

            public static EnumEntries<DialogButtonType> getEntries() {
                return b;
            }

            static {
                DialogButtonType r0 = new DialogButtonType("DEFAULT", 0, 0);
                DEFAULT = r0;
                DialogButtonType r1 = new DialogButtonType("PRIMARY", 1, 1);
                PRIMARY = r1;
                DialogButtonType r3 = new DialogButtonType("DANGER", 2, 2);
                DANGER = r3;
                DialogButtonType[] r5 = {r0, r1, r3};
                a = r5;
                b = EnumEntriesKt.enumEntries(r5);
                Companion = new b();
                ADAPTER = new a(Reflection.getOrCreateKotlinClass(DialogButtonType.class), Syntax.PROTO_2, r0);
            }

            public static DialogButtonType[] values() {
                return (DialogButtonType[]) a.clone();
            }

            @Override // com.lark.wire.o0
            public int getValue() {
                return this.value;
            }

            @JvmStatic
            public static final DialogButtonType fromValue(int r1) {
                Companion.getClass();
                if (r1 == 0) goto L12;
                if (r1 == 1) goto L15;
                if (r1 == 2) goto L14;
                return null;
            L14:
                return DANGER;
            L15:
                return PRIMARY;
            L12:
                return DEFAULT;
            }

            public static DialogButtonType valueOf(String r1) {
                return (DialogButtonType) r27.a.a(DialogButtonType.class, r1);
            }

            public DialogButtonType(String r1, int r2, int r3) {
                super(r1, r2);
                this.value = r3;
            }
        }

        @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\b\u0018\u0000 \u00142\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00020\u0001:\u0002\u0013\u0014B\u001b\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\b\u0010\u0011\u001a\u00020\u0002H\u0016J\b\u0010\u0012\u001a\u00020\tH\u0016R\u0013\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0015\u0010\f\u001a\u0004\u0018\u00010\r¢\u0006\n\n\u0002\u0010\u0010\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u0015"}, d2 = {"Lcom/lark/kmp/pb/basic/v1/UrlPreviewAction$ShowDialogAction$DialogItem;", "Lcom/lark/wire/Message;", "Lcom/lark/kmp/pb/basic/v1/UrlPreviewAction$ShowDialogAction$DialogItem$Builder;", "builder", "unknownFields", "Lokio/ByteString;", "<init>", "(Lcom/lark/kmp/pb/basic/v1/UrlPreviewAction$ShowDialogAction$DialogItem$Builder;Lokio/ByteString;)V", "text", "", "getText", "()Ljava/lang/String;", "number_of_lines", "", "getNumber_of_lines", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "newBuilder", "toString", "Builder", "Companion", "rust-sdk-kotlin-pb_release"}, k = 1, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
        public static final class DialogItem extends com.lark.wire.Message<DialogItem, a> {
            public static final ProtoAdapter<DialogItem> ADAPTER = null;
            public static final c Companion = null;
            public static final int DEFAULT_NUMBER_OF_LINES = 0;
            private static final long serialVersionUID = 0;
            private final Integer number_of_lines;
            private final String text;

            public static final class a extends com.lark.wire.Message.a<DialogItem, a> {
                public String d;
                public Integer e;

                @Override // com.lark.wire.Message.a
                public final com.lark.wire.Message b() {
                    return new DialogItem(this, c(), null);
                }

                public a() {
                }
            }

            public static final class b extends ProtoAdapter<DialogItem> {
                @Override // com.lark.wire.ProtoAdapter
                public final DialogItem c(g0 r7) {
                    Intrinsics.checkNotNullParameter(r7, "reader");
                    a r1 = new a();
                    long r2 = r7.c();
                L3:
                    int r4 = r7.e();
                    if (r4 == (-1)) goto L13;
                    if (r4 != 1) goto L8;
                    ProtoAdapter.q.getClass();
                    Intrinsics.checkNotNullParameter(r7, "reader");
                    r1.d = r7.i();
                    goto L3
                L8:
                    if (r4 != 2) goto L9;
                    r1.e = (Integer) ProtoAdapter.h.c(r7);
                    goto L3
                L9:
                    r7.j(r4);
                    Unit r5 = Unit.INSTANCE;
                    goto L3
                L13:
                    return new DialogItem(r1, r7.d(r2), null);
                }

                @Override // com.lark.wire.ProtoAdapter
                public final int k(DialogItem r5) {
                    DialogItem r6 = r5;
                    Intrinsics.checkNotNullParameter(r6, "value");
                    return (r6.unknownFields().size() + ProtoAdapter.q.l(1, r6.getText())) + ProtoAdapter.h.l(2, r6.getNumber_of_lines());
                }

                @Override // com.lark.wire.ProtoAdapter
                public final void f(j0 r4, DialogItem r5) {
                    DialogItem r6 = r5;
                    Intrinsics.checkNotNullParameter(r4, "writer");
                    Intrinsics.checkNotNullParameter(r6, "value");
                    ProtoAdapter.q.i(r4, 1, r6.getText());
                    ProtoAdapter.h.i(r4, 2, r6.getNumber_of_lines());
                    r4.a(r6.unknownFields());
                }

                @Override // com.lark.wire.ProtoAdapter
                public final void g(n0 r4, DialogItem r5) {
                    DialogItem r6 = r5;
                    Intrinsics.checkNotNullParameter(r4, "writer");
                    Intrinsics.checkNotNullParameter(r6, "value");
                    r4.d(r6.unknownFields());
                    ProtoAdapter.h.j(r4, 2, r6.getNumber_of_lines());
                    ProtoAdapter.q.j(r4, 1, r6.getText());
                }

                public b(FieldEncoding r7, KClass<DialogItem> r8, Syntax r9) {
                    super(r7, r8, "type.googleapis.com/basic.v1.UrlPreviewAction.ShowDialogAction.DialogItem", r9, null);
                }
            }

            public static final class c {
                public c() {
                }
            }

            public /* synthetic */ DialogItem(a r1, ByteString r2, DefaultConstructorMarker r3) {
                this(r1, r2);
            }

            static {
                Companion = new c();
                ADAPTER = new b(FieldEncoding.LENGTH_DELIMITED, Reflection.getOrCreateKotlinClass(DialogItem.class), Syntax.PROTO_2);
            }

            @Override // com.lark.wire.Message
            public a newBuilder() {
                a r0 = new a();
                r0.d = this.text;
                r0.e = this.number_of_lines;
                r0.a(unknownFields());
                return r0;
            }

            @Override // com.lark.wire.Message
            public String toString() {
                return Reflection.getOrCreateKotlinClass(DialogItem.class).getSimpleName() + '@' + hashCode();
            }

            public final Integer getNumber_of_lines() {
                return this.number_of_lines;
            }

            public final String getText() {
                return this.text;
            }

            @Override // com.lark.wire.Message
            public /* bridge */ /* synthetic */ com.lark.wire.Message.a newBuilder() {
                return newBuilder();
            }

            public DialogItem(a r2, ByteString r3) {
                super(ADAPTER, r3);
                this.text = r2.d;
                this.number_of_lines = r2.e;
            }

            public /* synthetic */ DialogItem(a r1, ByteString r2, int r3, DefaultConstructorMarker r4) {
                if ((r3 & 2) == 0) goto L5;
                r2 = ByteString.EMPTY;
            L5:
                this(r1, r2);
            }
        }

        public static final class a extends com.lark.wire.Message.a<ShowDialogAction, a> {
            public DialogItem d;
            public DialogItem e;
            public List<DialogButton> f;

            @Override // com.lark.wire.Message.a
            public final com.lark.wire.Message b() {
                return new ShowDialogAction(this, c(), null);
            }

            public a() {
                this.f = CollectionsKt.emptyList();
            }
        }

        public static final class b extends ProtoAdapter<ShowDialogAction> {
            @Override // com.lark.wire.ProtoAdapter
            public final ShowDialogAction c(g0 r7) {
                Intrinsics.checkNotNullParameter(r7, "reader");
                a r0 = new a();
                ArrayList r1 = new ArrayList();
                long r2 = r7.c();
            L3:
                int r4 = r7.e();
                if (r4 == (-1)) goto L15;
                if (r4 != 1) goto L8;
                r0.d = DialogItem.ADAPTER.c(r7);
                goto L3
            L8:
                if (r4 != 2) goto L10;
                r0.e = DialogItem.ADAPTER.c(r7);
                goto L3
            L10:
                if (r4 != 3) goto L11;
                r1.add(DialogButton.ADAPTER.c(r7));
                goto L3
            L11:
                r7.j(r4);
                Unit r5 = Unit.INSTANCE;
                goto L3
            L15:
                ByteString r8 = r7.d(r2);
                Intrinsics.checkNotNullParameter(r1, "buttons");
                com.lark.wire.internal.a.a(r1);
                r0.f = r1;
                return new ShowDialogAction(r0, r8, null);
            }

            @Override // com.lark.wire.ProtoAdapter
            public final int k(ShowDialogAction r5) {
                ShowDialogAction r6 = r5;
                Intrinsics.checkNotNullParameter(r6, "value");
                int r0 = r6.unknownFields().size();
                ProtoAdapter<DialogItem> r1 = DialogItem.ADAPTER;
                return ((r0 + r1.l(1, r6.getTitle())) + r1.l(2, r6.getContent())) + DialogButton.ADAPTER.a().l(3, r6.getButtons());
            }

            @Override // com.lark.wire.ProtoAdapter
            public final void f(j0 r4, ShowDialogAction r5) {
                ShowDialogAction r6 = r5;
                Intrinsics.checkNotNullParameter(r4, "writer");
                Intrinsics.checkNotNullParameter(r6, "value");
                ProtoAdapter<DialogItem> r0 = DialogItem.ADAPTER;
                r0.i(r4, 1, r6.getTitle());
                r0.i(r4, 2, r6.getContent());
                DialogButton.ADAPTER.a().i(r4, 3, r6.getButtons());
                r4.a(r6.unknownFields());
            }

            @Override // com.lark.wire.ProtoAdapter
            public final void g(n0 r4, ShowDialogAction r5) {
                ShowDialogAction r6 = r5;
                Intrinsics.checkNotNullParameter(r4, "writer");
                Intrinsics.checkNotNullParameter(r6, "value");
                r4.d(r6.unknownFields());
                DialogButton.ADAPTER.a().j(r4, 3, r6.getButtons());
                ProtoAdapter<DialogItem> r0 = DialogItem.ADAPTER;
                r0.j(r4, 2, r6.getContent());
                r0.j(r4, 1, r6.getTitle());
            }

            public b(FieldEncoding r7, KClass<ShowDialogAction> r8, Syntax r9) {
                super(r7, r8, "type.googleapis.com/basic.v1.UrlPreviewAction.ShowDialogAction", r9, null);
            }
        }

        public static final class c {
            public c() {
            }
        }

        public /* synthetic */ ShowDialogAction(a r1, ByteString r2, DefaultConstructorMarker r3) {
            this(r1, r2);
        }

        static {
            Companion = new c();
            ADAPTER = new b(FieldEncoding.LENGTH_DELIMITED, Reflection.getOrCreateKotlinClass(ShowDialogAction.class), Syntax.PROTO_2);
        }

        @Override // com.lark.wire.Message
        public a newBuilder() {
            a r0 = new a();
            r0.d = this.title;
            r0.e = this.content;
            r0.f = this.buttons;
            r0.a(unknownFields());
            return r0;
        }

        @Override // com.lark.wire.Message
        public String toString() {
            return Reflection.getOrCreateKotlinClass(ShowDialogAction.class).getSimpleName() + '@' + hashCode();
        }

        public final List<DialogButton> getButtons() {
            return this.buttons;
        }

        public final DialogItem getContent() {
            return this.content;
        }

        public final DialogItem getTitle() {
            return this.title;
        }

        @Override // com.lark.wire.Message
        public /* bridge */ /* synthetic */ com.lark.wire.Message.a newBuilder() {
            return newBuilder();
        }

        public ShowDialogAction(a r2, ByteString r3) {
            super(ADAPTER, r3);
            this.title = r2.d;
            this.content = r2.e;
            this.buttons = com.lark.wire.internal.a.c("buttons", r2.f);
        }

        public /* synthetic */ ShowDialogAction(a r1, ByteString r2, int r3, DefaultConstructorMarker r4) {
            if ((r3 & 2) == 0) goto L5;
            r2 = ByteString.EMPTY;
        L5:
            this(r1, r2);
        }
    }

    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\t\u0018\u0000 \u00182\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00020\u0001:\u0003\u0017\u0018\u0019B\u001b\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\b\u0010\u0015\u001a\u00020\u0002H\u0016J\b\u0010\u0016\u001a\u00020\rH\u0016R\u0013\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0013\u0010\f\u001a\u0004\u0018\u00010\r¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0015\u0010\u0010\u001a\u0004\u0018\u00010\u0011¢\u0006\n\n\u0002\u0010\u0014\u001a\u0004\b\u0012\u0010\u0013¨\u0006\u001a"}, d2 = {"Lcom/lark/kmp/pb/basic/v1/UrlPreviewAction$ShowToastAction;", "Lcom/lark/wire/Message;", "Lcom/lark/kmp/pb/basic/v1/UrlPreviewAction$ShowToastAction$Builder;", "builder", "unknownFields", "Lokio/ByteString;", "<init>", "(Lcom/lark/kmp/pb/basic/v1/UrlPreviewAction$ShowToastAction$Builder;Lokio/ByteString;)V", "type", "Lcom/lark/kmp/pb/basic/v1/UrlPreviewAction$ShowToastAction$ToastType;", "getType", "()Lcom/lark/kmp/pb/basic/v1/UrlPreviewAction$ShowToastAction$ToastType;", "content", "", "getContent", "()Ljava/lang/String;", "duration", "", "getDuration", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "newBuilder", "toString", "Builder", "Companion", "ToastType", "rust-sdk-kotlin-pb_release"}, k = 1, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
    public static final class ShowToastAction extends com.lark.wire.Message<ShowToastAction, a> {
        public static final ProtoAdapter<ShowToastAction> ADAPTER = null;
        public static final c Companion = null;
        public static final ToastType DEFAULT_TYPE = null;
        private static final long serialVersionUID = 0;
        private final String content;
        private final Integer duration;
        private final ToastType type;

        @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\n\b\u0086\u0081\u0002\u0018\u0000 \r2\u00020\u00012\b\u0012\u0004\u0012\u00020\u00000\u0002:\u0001\rB\u0011\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u0004X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\f¨\u0006\u000e"}, d2 = {"Lcom/lark/kmp/pb/basic/v1/UrlPreviewAction$ShowToastAction$ToastType;", "Lcom/lark/wire/WireEnum;", "", "value", "", "<init>", "(Ljava/lang/String;II)V", "getValue", "()I", "success", "error", "info", "warning", "Companion", "rust-sdk-kotlin-pb_release"}, k = 1, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
        public static final enum ToastType extends Enum<ToastType> implements o0 {
            public static final ProtoAdapter<ToastType> ADAPTER = null;
            public static final b Companion = null;
            public static final /* synthetic */ ToastType[] a = null;
            public static final /* synthetic */ EnumEntries b = null;
            public static final ToastType error = null;
            public static final ToastType info = null;
            public static final ToastType success = null;
            public static final ToastType warning = null;
            private final int value;

            public static final class a extends d<ToastType> {
                @Override // com.lark.wire.d
                public final o0 n(int r2) {
                    ToastType.Companion.getClass();
                    if (r2 == 1) goto L15;
                    if (r2 == 2) goto L19;
                    if (r2 == 3) goto L18;
                    if (r2 == 4) goto L17;
                    return null;
                L17:
                    return ToastType.warning;
                L18:
                    return ToastType.info;
                L19:
                    return ToastType.error;
                L15:
                    return ToastType.success;
                }

                public a(KClass<ToastType> r2, Syntax r3) {
                    super(r2, r3, null);
                }
            }

            public static final class b {
                public b() {
                }
            }

            public static EnumEntries<ToastType> getEntries() {
                return b;
            }

            static {
                ToastType r0 = new ToastType("success", 0, 1);
                success = r0;
                ToastType r1 = new ToastType("error", 1, 2);
                error = r1;
                ToastType r4 = new ToastType("info", 2, 3);
                info = r4;
                ToastType r6 = new ToastType("warning", 3, 4);
                warning = r6;
                ToastType[] r8 = {r0, r1, r4, r6};
                a = r8;
                b = EnumEntriesKt.enumEntries(r8);
                Companion = new b();
                ADAPTER = new a(Reflection.getOrCreateKotlinClass(ToastType.class), Syntax.PROTO_2);
            }

            public static ToastType[] values() {
                return (ToastType[]) a.clone();
            }

            @Override // com.lark.wire.o0
            public int getValue() {
                return this.value;
            }

            @JvmStatic
            public static final ToastType fromValue(int r1) {
                Companion.getClass();
                if (r1 == 1) goto L15;
                if (r1 == 2) goto L19;
                if (r1 == 3) goto L18;
                if (r1 == 4) goto L17;
                return null;
            L17:
                return warning;
            L18:
                return info;
            L19:
                return error;
            L15:
                return success;
            }

            public static ToastType valueOf(String r1) {
                return (ToastType) r27.a.a(ToastType.class, r1);
            }

            public ToastType(String r1, int r2, int r3) {
                super(r1, r2);
                this.value = r3;
            }
        }

        public static final class a extends com.lark.wire.Message.a<ShowToastAction, a> {
            public ToastType d;
            public String e;
            public Integer f;

            @Override // com.lark.wire.Message.a
            public final com.lark.wire.Message b() {
                return new ShowToastAction(this, c(), null);
            }

            public a() {
            }
        }

        public static final class b extends ProtoAdapter<ShowToastAction> {
            @Override // com.lark.wire.ProtoAdapter
            public final ShowToastAction c(g0 r10) {
                Intrinsics.checkNotNullParameter(r10, "reader");
                a r1 = new a();
                long r2 = r10.c();
            L3:
                int r4 = r10.e();
                if (r4 == (-1)) goto L19;
                if (r4 != 1) goto L8;
                r1.d = ToastType.ADAPTER.c(r10);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L16
            L16:
                e = move-exception;
                r10.a(r4, FieldEncoding.VARINT, Long.valueOf(e.value));
                Unit r5 = Unit.INSTANCE;
                goto L3
            L8:
                if (r4 != 2) goto L10;
                ProtoAdapter.q.getClass();
                Intrinsics.checkNotNullParameter(r10, "reader");
                r1.e = r10.i();
                goto L3
            L10:
                if (r4 != 3) goto L11;
                r1.f = (Integer) ProtoAdapter.h.c(r10);
                goto L3
            L11:
                r10.j(r4);
                goto L3
            L19:
                return new ShowToastAction(r1, r10.d(r2), null);
            }

            @Override // com.lark.wire.ProtoAdapter
            public final int k(ShowToastAction r5) {
                ShowToastAction r6 = r5;
                Intrinsics.checkNotNullParameter(r6, "value");
                return ((r6.unknownFields().size() + ToastType.ADAPTER.l(1, r6.getType())) + ProtoAdapter.q.l(2, r6.getContent())) + ProtoAdapter.h.l(3, r6.getDuration());
            }

            @Override // com.lark.wire.ProtoAdapter
            public final void f(j0 r4, ShowToastAction r5) {
                ShowToastAction r6 = r5;
                Intrinsics.checkNotNullParameter(r4, "writer");
                Intrinsics.checkNotNullParameter(r6, "value");
                ToastType.ADAPTER.i(r4, 1, r6.getType());
                ProtoAdapter.q.i(r4, 2, r6.getContent());
                ProtoAdapter.h.i(r4, 3, r6.getDuration());
                r4.a(r6.unknownFields());
            }

            @Override // com.lark.wire.ProtoAdapter
            public final void g(n0 r4, ShowToastAction r5) {
                ShowToastAction r6 = r5;
                Intrinsics.checkNotNullParameter(r4, "writer");
                Intrinsics.checkNotNullParameter(r6, "value");
                r4.d(r6.unknownFields());
                ProtoAdapter.h.j(r4, 3, r6.getDuration());
                ProtoAdapter.q.j(r4, 2, r6.getContent());
                ToastType.ADAPTER.j(r4, 1, r6.getType());
            }

            public b(FieldEncoding r7, KClass<ShowToastAction> r8, Syntax r9) {
                super(r7, r8, "type.googleapis.com/basic.v1.UrlPreviewAction.ShowToastAction", r9, null);
            }
        }

        public static final class c {
            public c() {
            }
        }

        public /* synthetic */ ShowToastAction(a r1, ByteString r2, DefaultConstructorMarker r3) {
            this(r1, r2);
        }

        static {
            Companion = new c();
            DEFAULT_TYPE = ToastType.info;
            ADAPTER = new b(FieldEncoding.LENGTH_DELIMITED, Reflection.getOrCreateKotlinClass(ShowToastAction.class), Syntax.PROTO_2);
        }

        @Override // com.lark.wire.Message
        public a newBuilder() {
            a r0 = new a();
            r0.d = this.type;
            r0.e = this.content;
            r0.f = this.duration;
            r0.a(unknownFields());
            return r0;
        }

        @Override // com.lark.wire.Message
        public String toString() {
            return Reflection.getOrCreateKotlinClass(ShowToastAction.class).getSimpleName() + '@' + hashCode();
        }

        public final String getContent() {
            return this.content;
        }

        public final Integer getDuration() {
            return this.duration;
        }

        public final ToastType getType() {
            return this.type;
        }

        @Override // com.lark.wire.Message
        public /* bridge */ /* synthetic */ com.lark.wire.Message.a newBuilder() {
            return newBuilder();
        }

        public ShowToastAction(a r2, ByteString r3) {
            super(ADAPTER, r3);
            this.type = r2.d;
            this.content = r2.e;
            this.duration = r2.f;
        }

        public /* synthetic */ ShowToastAction(a r1, ByteString r2, int r3, DefaultConstructorMarker r4) {
            if ((r3 & 2) == 0) goto L5;
            r2 = ByteString.EMPTY;
        L5:
            this(r1, r2);
        }
    }

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0007\u0018\u0000 \u000f2\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00020\u0001:\u0002\u000e\u000fB\u001b\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\b\u0010\f\u001a\u00020\u0002H\u0016J\b\u0010\r\u001a\u00020\tH\u0016R\u0013\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0010"}, d2 = {"Lcom/lark/kmp/pb/basic/v1/UrlPreviewAction$SwitchStateAction;", "Lcom/lark/wire/Message;", "Lcom/lark/kmp/pb/basic/v1/UrlPreviewAction$SwitchStateAction$Builder;", "builder", "unknownFields", "Lokio/ByteString;", "<init>", "(Lcom/lark/kmp/pb/basic/v1/UrlPreviewAction$SwitchStateAction$Builder;Lokio/ByteString;)V", "next_state_id", "", "getNext_state_id", "()Ljava/lang/String;", "newBuilder", "toString", "Builder", "Companion", "rust-sdk-kotlin-pb_release"}, k = 1, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
    public static final class SwitchStateAction extends com.lark.wire.Message<SwitchStateAction, a> {
        public static final ProtoAdapter<SwitchStateAction> ADAPTER = null;
        public static final c Companion = null;
        private static final long serialVersionUID = 0;
        private final String next_state_id;

        public static final class a extends com.lark.wire.Message.a<SwitchStateAction, a> {
            public String d;

            @Override // com.lark.wire.Message.a
            public final com.lark.wire.Message b() {
                return new SwitchStateAction(this, c(), null);
            }

            public a() {
            }
        }

        public static final class b extends ProtoAdapter<SwitchStateAction> {
            @Override // com.lark.wire.ProtoAdapter
            public final SwitchStateAction c(g0 r7) {
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
                return new SwitchStateAction(r1, r7.d(r2), null);
            }

            @Override // com.lark.wire.ProtoAdapter
            public final int k(SwitchStateAction r4) {
                SwitchStateAction r5 = r4;
                Intrinsics.checkNotNullParameter(r5, "value");
                return r5.unknownFields().size() + ProtoAdapter.q.l(1, r5.getNext_state_id());
            }

            @Override // com.lark.wire.ProtoAdapter
            public final void f(j0 r4, SwitchStateAction r5) {
                SwitchStateAction r6 = r5;
                Intrinsics.checkNotNullParameter(r4, "writer");
                Intrinsics.checkNotNullParameter(r6, "value");
                ProtoAdapter.q.i(r4, 1, r6.getNext_state_id());
                r4.a(r6.unknownFields());
            }

            @Override // com.lark.wire.ProtoAdapter
            public final void g(n0 r3, SwitchStateAction r4) {
                SwitchStateAction r5 = r4;
                Intrinsics.checkNotNullParameter(r3, "writer");
                Intrinsics.checkNotNullParameter(r5, "value");
                r3.d(r5.unknownFields());
                ProtoAdapter.q.j(r3, 1, r5.getNext_state_id());
            }

            public b(FieldEncoding r7, KClass<SwitchStateAction> r8, Syntax r9) {
                super(r7, r8, "type.googleapis.com/basic.v1.UrlPreviewAction.SwitchStateAction", r9, null);
            }
        }

        public static final class c {
            public c() {
            }
        }

        public /* synthetic */ SwitchStateAction(a r1, ByteString r2, DefaultConstructorMarker r3) {
            this(r1, r2);
        }

        static {
            Companion = new c();
            ADAPTER = new b(FieldEncoding.LENGTH_DELIMITED, Reflection.getOrCreateKotlinClass(SwitchStateAction.class), Syntax.PROTO_2);
        }

        @Override // com.lark.wire.Message
        public a newBuilder() {
            a r0 = new a();
            r0.d = this.next_state_id;
            r0.a(unknownFields());
            return r0;
        }

        @Override // com.lark.wire.Message
        public String toString() {
            return Reflection.getOrCreateKotlinClass(SwitchStateAction.class).getSimpleName() + '@' + hashCode();
        }

        public final String getNext_state_id() {
            return this.next_state_id;
        }

        @Override // com.lark.wire.Message
        public /* bridge */ /* synthetic */ com.lark.wire.Message.a newBuilder() {
            return newBuilder();
        }

        public SwitchStateAction(a r2, ByteString r3) {
            super(ADAPTER, r3);
            this.next_state_id = r2.d;
        }

        public /* synthetic */ SwitchStateAction(a r1, ByteString r2, int r3, DefaultConstructorMarker r4) {
            if ((r3 & 2) == 0) goto L5;
            r2 = ByteString.EMPTY;
        L5:
            this(r1, r2);
        }
    }

    public static final class a extends com.lark.wire.Message.a<UrlPreviewAction, a> {
        public String d;
        public Method e;
        public Parameters f;
        public Integer g;
        public CardActionPacket h;
        public URL i;
        public String j;
        public GetAction k;
        public PostAction l;
        public LarkCommandAction m;
        public OpenURLAction n;
        public SwitchStateAction o;
        public ShowToastAction p;
        public ShowDialogAction q;

        @Override // com.lark.wire.Message.a
        public final com.lark.wire.Message b() {
            return new UrlPreviewAction(this, c(), null);
        }

        public a() {
        }
    }

    public static final class b extends ProtoAdapter<UrlPreviewAction> {
        @Override // com.lark.wire.ProtoAdapter
        public final UrlPreviewAction c(g0 r10) {
            Intrinsics.checkNotNullParameter(r10, "reader");
            a r1 = new a();
            long r2 = r10.c();
        L3:
            int r4 = r10.e();
            DefaultConstructorMarker r6 = null;
            if (r4 == (-1)) goto L26;
            switch(r4) {
                case 1: goto L17;
                case 2: goto L27;
                case 3: goto L12;
                case 4: goto L11;
                case 5: goto L10;
                case 6: goto L9;
                case 7: goto L8;
                default: goto L6;
            };
        L27:
            Method r5 = Method.ADAPTER.c(r10);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L15
            Intrinsics.checkNotNullParameter(r5, "method");     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L15
            r1.e = r5;     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L15
        L15:
            e = move-exception;
            r10.a(r4, FieldEncoding.VARINT, Long.valueOf(e.value));
            Unit r7 = Unit.INSTANCE;
            goto L3
        L8:
            ProtoAdapter.q.getClass();
            Intrinsics.checkNotNullParameter(r10, "reader");
            r1.j = r10.i();
            goto L3
        L9:
            r1.i = URL.ADAPTER.c(r10);
            goto L3
        L10:
            r1.h = CardActionPacket.ADAPTER.c(r10);
            goto L3
        L11:
            r1.g = (Integer) ProtoAdapter.h.c(r10);
            goto L3
        L12:
            r1.f = Parameters.ADAPTER.c(r10);
            goto L3
        L17:
            ProtoAdapter.q.getClass();
            Intrinsics.checkNotNullParameter(r10, "reader");
            String r8 = r10.i();
            Intrinsics.checkNotNullParameter(r8, "url");
            r1.d = r8;
            goto L3
        L6:
            switch(r4) {
                case 1000: goto L24;
                case 1001: goto L23;
                case 1002: goto L22;
                case 1003: goto L21;
                case 1004: goto L20;
                case 1005: goto L19;
                case 1006: goto L18;
                default: goto L7;
            };
        L18:
            r1.q = ShowDialogAction.ADAPTER.c(r10);
            r1.k = null;
            r1.l = null;
            r1.m = null;
            r1.n = null;
            r1.o = null;
            r1.p = null;
            goto L3
        L19:
            r1.p = ShowToastAction.ADAPTER.c(r10);
            r1.k = null;
            r1.l = null;
            r1.m = null;
            r1.n = null;
            r1.o = null;
            r1.q = null;
            goto L3
        L20:
            r1.o = SwitchStateAction.ADAPTER.c(r10);
            r1.k = null;
            r1.l = null;
            r1.m = null;
            r1.n = null;
            r1.p = null;
            r1.q = null;
            goto L3
        L21:
            r1.n = OpenURLAction.ADAPTER.c(r10);
            r1.k = null;
            r1.l = null;
            r1.m = null;
            r1.o = null;
            r1.p = null;
            r1.q = null;
            goto L3
        L22:
            r1.m = LarkCommandAction.ADAPTER.c(r10);
            r1.k = null;
            r1.l = null;
            r1.n = null;
            r1.o = null;
            r1.p = null;
            r1.q = null;
            goto L3
        L23:
            r1.l = PostAction.ADAPTER.c(r10);
            r1.k = null;
            r1.m = null;
            r1.n = null;
            r1.o = null;
            r1.p = null;
            r1.q = null;
            goto L3
        L24:
            r1.k = GetAction.ADAPTER.c(r10);
            r1.l = null;
            r1.m = null;
            r1.n = null;
            r1.o = null;
            r1.p = null;
            r1.q = null;
            goto L3
        L7:
            r10.j(r4);
            Unit r9 = Unit.INSTANCE;
            goto L3
        L26:
            return new UrlPreviewAction(r1, r10.d(r2), r6);
        }

        @Override // com.lark.wire.ProtoAdapter
        public final int k(UrlPreviewAction r6) {
            UrlPreviewAction r7 = r6;
            Intrinsics.checkNotNullParameter(r7, "value");
            int r0 = r7.unknownFields().size();
            w r1 = ProtoAdapter.q;
            return (((((((((((((r0 + r1.l(1, r7.getUrl())) + Method.ADAPTER.l(2, r7.getMethod())) + Parameters.ADAPTER.l(3, r7.getParameters())) + ProtoAdapter.h.l(4, r7.getCmd())) + CardActionPacket.ADAPTER.l(5, r7.getPacket())) + URL.ADAPTER.l(6, r7.getOpen_url())) + r1.l(7, r7.getFallback_action_id())) + GetAction.ADAPTER.l(CommandStatus.DORA_TRACE, r7.getGet())) + PostAction.ADAPTER.l(1001, r7.getPost())) + LarkCommandAction.ADAPTER.l(1002, r7.getCommand())) + OpenURLAction.ADAPTER.l(1003, r7.getOpen_url_v2())) + SwitchStateAction.ADAPTER.l(1004, r7.getSwitch_state())) + ShowToastAction.ADAPTER.l(1005, r7.getShow_toast())) + ShowDialogAction.ADAPTER.l(1006, r7.getShow_dialog());
        }

        @Override // com.lark.wire.ProtoAdapter
        public final void f(j0 r5, UrlPreviewAction r6) {
            UrlPreviewAction r7 = r6;
            Intrinsics.checkNotNullParameter(r5, "writer");
            Intrinsics.checkNotNullParameter(r7, "value");
            w r0 = ProtoAdapter.q;
            r0.i(r5, 1, r7.getUrl());
            Method.ADAPTER.i(r5, 2, r7.getMethod());
            Parameters.ADAPTER.i(r5, 3, r7.getParameters());
            ProtoAdapter.h.i(r5, 4, r7.getCmd());
            CardActionPacket.ADAPTER.i(r5, 5, r7.getPacket());
            URL.ADAPTER.i(r5, 6, r7.getOpen_url());
            r0.i(r5, 7, r7.getFallback_action_id());
            GetAction.ADAPTER.i(r5, CommandStatus.DORA_TRACE, r7.getGet());
            PostAction.ADAPTER.i(r5, 1001, r7.getPost());
            LarkCommandAction.ADAPTER.i(r5, 1002, r7.getCommand());
            OpenURLAction.ADAPTER.i(r5, 1003, r7.getOpen_url_v2());
            SwitchStateAction.ADAPTER.i(r5, 1004, r7.getSwitch_state());
            ShowToastAction.ADAPTER.i(r5, 1005, r7.getShow_toast());
            ShowDialogAction.ADAPTER.i(r5, 1006, r7.getShow_dialog());
            r5.a(r7.unknownFields());
        }

        @Override // com.lark.wire.ProtoAdapter
        public final void g(n0 r5, UrlPreviewAction r6) {
            UrlPreviewAction r7 = r6;
            Intrinsics.checkNotNullParameter(r5, "writer");
            Intrinsics.checkNotNullParameter(r7, "value");
            r5.d(r7.unknownFields());
            ShowDialogAction.ADAPTER.j(r5, 1006, r7.getShow_dialog());
            ShowToastAction.ADAPTER.j(r5, 1005, r7.getShow_toast());
            SwitchStateAction.ADAPTER.j(r5, 1004, r7.getSwitch_state());
            OpenURLAction.ADAPTER.j(r5, 1003, r7.getOpen_url_v2());
            LarkCommandAction.ADAPTER.j(r5, 1002, r7.getCommand());
            PostAction.ADAPTER.j(r5, 1001, r7.getPost());
            GetAction.ADAPTER.j(r5, CommandStatus.DORA_TRACE, r7.getGet());
            w r0 = ProtoAdapter.q;
            r0.j(r5, 7, r7.getFallback_action_id());
            URL.ADAPTER.j(r5, 6, r7.getOpen_url());
            CardActionPacket.ADAPTER.j(r5, 5, r7.getPacket());
            ProtoAdapter.h.j(r5, 4, r7.getCmd());
            Parameters.ADAPTER.j(r5, 3, r7.getParameters());
            Method.ADAPTER.j(r5, 2, r7.getMethod());
            r0.j(r5, 1, r7.getUrl());
        }

        public b(FieldEncoding r7, KClass<UrlPreviewAction> r8, Syntax r9) {
            super(r7, r8, "type.googleapis.com/basic.v1.UrlPreviewAction", r9, null);
        }
    }

    public static final class c {
        public c() {
        }
    }

    public /* synthetic */ UrlPreviewAction(a r1, ByteString r2, DefaultConstructorMarker r3) {
        this(r1, r2);
    }

    static {
        Companion = new c();
        ADAPTER = new b(FieldEncoding.LENGTH_DELIMITED, Reflection.getOrCreateKotlinClass(UrlPreviewAction.class), Syntax.PROTO_2);
    }

    @Override // com.lark.wire.Message
    public a newBuilder() {
        a r0 = new a();
        r0.d = this.url;
        r0.e = this.method;
        r0.f = this.parameters;
        r0.g = this.cmd;
        r0.h = this.packet;
        r0.i = this.open_url;
        r0.j = this.fallback_action_id;
        r0.k = this.get;
        r0.l = this.post;
        r0.m = this.command;
        r0.n = this.open_url_v2;
        r0.o = this.switch_state;
        r0.p = this.show_toast;
        r0.q = this.show_dialog;
        r0.a(unknownFields());
        return r0;
    }

    @Override // com.lark.wire.Message
    public String toString() {
        return Reflection.getOrCreateKotlinClass(UrlPreviewAction.class).getSimpleName() + '@' + hashCode();
    }

    public final Integer getCmd() {
        return this.cmd;
    }

    public final LarkCommandAction getCommand() {
        return this.command;
    }

    public final String getFallback_action_id() {
        return this.fallback_action_id;
    }

    public final GetAction getGet() {
        return this.get;
    }

    public final Method getMethod() {
        return this.method;
    }

    public final URL getOpen_url() {
        return this.open_url;
    }

    public final OpenURLAction getOpen_url_v2() {
        return this.open_url_v2;
    }

    public final CardActionPacket getPacket() {
        return this.packet;
    }

    public final Parameters getParameters() {
        return this.parameters;
    }

    public final PostAction getPost() {
        return this.post;
    }

    public final ShowDialogAction getShow_dialog() {
        return this.show_dialog;
    }

    public final ShowToastAction getShow_toast() {
        return this.show_toast;
    }

    public final SwitchStateAction getSwitch_state() {
        return this.switch_state;
    }

    public final String getUrl() {
        return this.url;
    }

    @Override // com.lark.wire.Message
    public /* bridge */ /* synthetic */ com.lark.wire.Message.a newBuilder() {
        return newBuilder();
    }

    public UrlPreviewAction(a r8, ByteString r9) {
        super(ADAPTER, r9);
        String r10 = r8.d;
        Intrinsics.checkNotNull(r10);
        this.url = r10;
        Method r11 = r8.e;
        Intrinsics.checkNotNull(r11);
        this.method = r11;
        this.parameters = r8.f;
        this.cmd = r8.g;
        this.packet = r8.h;
        this.open_url = r8.i;
        this.fallback_action_id = r8.j;
        GetAction r12 = r8.k;
        this.get = r12;
        PostAction r0 = r8.l;
        this.post = r0;
        LarkCommandAction r1 = r8.m;
        this.command = r1;
        OpenURLAction r2 = r8.n;
        this.open_url_v2 = r2;
        SwitchStateAction r3 = r8.o;
        this.switch_state = r3;
        ShowToastAction r4 = r8.p;
        this.show_toast = r4;
        ShowDialogAction r13 = r8.q;
        this.show_dialog = r13;
        boolean r6 = false;
        if (com.lark.wire.internal.a.b(r12, r0, r1, r2, new Object[]{r3, r4, r13}) > 1) goto L5;
        r6 = true;
    L5:
        if (r6 == false) goto L8;
        return;
    L8:
        throw new IllegalArgumentException("At most one of get, post, command, open_url_v2, switch_state, show_toast, show_dialog may be non-null".toString());
    }

    public /* synthetic */ UrlPreviewAction(a r1, ByteString r2, int r3, DefaultConstructorMarker r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = ByteString.EMPTY;
    L5:
        this(r1, r2);
    }
}
