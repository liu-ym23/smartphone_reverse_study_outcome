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
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u000b\u0018\u0000  2\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00020\u0001:\u0006\u001f !\"#$B\u001b\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\b\u0010\u001d\u001a\u00020\u0002H\u0016J\b\u0010\u001e\u001a\u00020\tH\u0016R\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0013\u0010\f\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000bR\u0015\u0010\u000e\u001a\u0004\u0018\u00010\u000f¢\u0006\n\n\u0002\u0010\u0012\u001a\u0004\b\u0010\u0010\u0011R\u0015\u0010\u0013\u001a\u0004\u0018\u00010\u000f¢\u0006\n\n\u0002\u0010\u0012\u001a\u0004\b\u0013\u0010\u0011R\u0013\u0010\u0014\u001a\u0004\u0018\u00010\u0015¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u0017\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u001a0\u0019¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001c¨\u0006%"}, d2 = {"Lcom/lark/kmp/pb/basic/v1/UrlPreviewHangPoint;", "Lcom/lark/wire/Message;", "Lcom/lark/kmp/pb/basic/v1/UrlPreviewHangPoint$Builder;", "builder", "unknownFields", "Lokio/ByteString;", "<init>", "(Lcom/lark/kmp/pb/basic/v1/UrlPreviewHangPoint$Builder;Lokio/ByteString;)V", "url", "", "getUrl", "()Ljava/lang/String;", "preview_id", "getPreview_id", "need_local_preview", "", "getNeed_local_preview", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "is_lazy_load", "send_scene", "Lcom/lark/kmp/pb/basic/v1/UrlPreviewHangPoint$SendScene;", "getSend_scene", "()Lcom/lark/kmp/pb/basic/v1/UrlPreviewHangPoint$SendScene;", "client_custom_strategies", "", "Lcom/lark/kmp/pb/basic/v1/UrlPreviewHangPoint$ClientCustomStrategy;", "getClient_custom_strategies", "()Ljava/util/List;", "newBuilder", "toString", "Builder", "Companion", "SendScene", "ClientContainer", "PreviewSourceStrategy", "ClientCustomStrategy", "rust-sdk-kotlin-pb_release"}, k = 1, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
public final class UrlPreviewHangPoint extends com.lark.wire.Message<UrlPreviewHangPoint, a> {
    public static final ProtoAdapter<UrlPreviewHangPoint> ADAPTER = null;
    public static final c Companion = null;
    public static final boolean DEFAULT_IS_LAZY_LOAD = false;
    public static final boolean DEFAULT_NEED_LOCAL_PREVIEW = false;
    private static final long serialVersionUID = 0;
    private final List<ClientCustomStrategy> client_custom_strategies;
    private final Boolean is_lazy_load;
    private final Boolean need_local_preview;
    private final String preview_id;
    private final SendScene send_scene;
    private final String url;

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\t\b\u0086\u0081\u0002\u0018\u0000 \f2\u00020\u00012\b\u0012\u0004\u0012\u00020\u00000\u0002:\u0001\fB\u0011\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u0004X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000b¨\u0006\r"}, d2 = {"Lcom/lark/kmp/pb/basic/v1/UrlPreviewHangPoint$ClientContainer;", "Lcom/lark/wire/WireEnum;", "", "value", "", "<init>", "(Ljava/lang/String;II)V", "getValue", "()I", "UNKNOWN_CLIENT_CONTAINER", "FEISHU", "DOUBAO", "Companion", "rust-sdk-kotlin-pb_release"}, k = 1, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
    public static final enum ClientContainer extends Enum<ClientContainer> implements o0 {
        public static final ProtoAdapter<ClientContainer> ADAPTER = null;
        public static final b Companion = null;
        public static final ClientContainer DOUBAO = null;
        public static final ClientContainer FEISHU = null;
        public static final ClientContainer UNKNOWN_CLIENT_CONTAINER = null;
        public static final /* synthetic */ ClientContainer[] a = null;
        public static final /* synthetic */ EnumEntries b = null;
        private final int value;

        public static final class a extends d<ClientContainer> {
            @Override // com.lark.wire.d
            public final o0 n(int r2) {
                ClientContainer.Companion.getClass();
                if (r2 == 0) goto L12;
                if (r2 == 1) goto L15;
                if (r2 == 2) goto L14;
                return null;
            L14:
                return ClientContainer.DOUBAO;
            L15:
                return ClientContainer.FEISHU;
            L12:
                return ClientContainer.UNKNOWN_CLIENT_CONTAINER;
            }

            public a(KClass<ClientContainer> r1, Syntax r2, ClientContainer r3) {
                super(r1, r2, r3);
            }
        }

        public static final class b {
            public b() {
            }
        }

        public static EnumEntries<ClientContainer> getEntries() {
            return b;
        }

        static {
            ClientContainer r0 = new ClientContainer("UNKNOWN_CLIENT_CONTAINER", 0, 0);
            UNKNOWN_CLIENT_CONTAINER = r0;
            ClientContainer r1 = new ClientContainer("FEISHU", 1, 1);
            FEISHU = r1;
            ClientContainer r3 = new ClientContainer("DOUBAO", 2, 2);
            DOUBAO = r3;
            ClientContainer[] r5 = {r0, r1, r3};
            a = r5;
            b = EnumEntriesKt.enumEntries(r5);
            Companion = new b();
            ADAPTER = new a(Reflection.getOrCreateKotlinClass(ClientContainer.class), Syntax.PROTO_2, r0);
        }

        public static ClientContainer[] values() {
            return (ClientContainer[]) a.clone();
        }

        @Override // com.lark.wire.o0
        public int getValue() {
            return this.value;
        }

        @JvmStatic
        public static final ClientContainer fromValue(int r1) {
            Companion.getClass();
            if (r1 == 0) goto L12;
            if (r1 == 1) goto L15;
            if (r1 == 2) goto L14;
            return null;
        L14:
            return DOUBAO;
        L15:
            return FEISHU;
        L12:
            return UNKNOWN_CLIENT_CONTAINER;
        }

        public static ClientContainer valueOf(String r1) {
            return (ClientContainer) r27.a.a(ClientContainer.class, r1);
        }

        public ClientContainer(String r1, int r2, int r3) {
            super(r1, r2);
            this.value = r3;
        }
    }

    @Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0003\u0018\u0000 \u00182\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00020\u0001:\u0002\u0017\u0018B\u001b\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\b\u0010\u0014\u001a\u00020\u0002H\u0016J\b\u0010\u0015\u001a\u00020\u0016H\u0016R\u0013\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0013\u0010\f\u001a\u0004\u0018\u00010\r¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0015\u0010\u0010\u001a\u0004\u0018\u00010\u0011¢\u0006\n\n\u0002\u0010\u0013\u001a\u0004\b\u0010\u0010\u0012¨\u0006\u0019"}, d2 = {"Lcom/lark/kmp/pb/basic/v1/UrlPreviewHangPoint$ClientCustomStrategy;", "Lcom/lark/wire/Message;", "Lcom/lark/kmp/pb/basic/v1/UrlPreviewHangPoint$ClientCustomStrategy$Builder;", "builder", "unknownFields", "Lokio/ByteString;", "<init>", "(Lcom/lark/kmp/pb/basic/v1/UrlPreviewHangPoint$ClientCustomStrategy$Builder;Lokio/ByteString;)V", "container", "Lcom/lark/kmp/pb/basic/v1/UrlPreviewHangPoint$ClientContainer;", "getContainer", "()Lcom/lark/kmp/pb/basic/v1/UrlPreviewHangPoint$ClientContainer;", "strategy", "Lcom/lark/kmp/pb/basic/v1/UrlPreviewHangPoint$PreviewSourceStrategy;", "getStrategy", "()Lcom/lark/kmp/pb/basic/v1/UrlPreviewHangPoint$PreviewSourceStrategy;", "is_lazy_load", "", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "newBuilder", "toString", "", "Builder", "Companion", "rust-sdk-kotlin-pb_release"}, k = 1, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
    public static final class ClientCustomStrategy extends com.lark.wire.Message<ClientCustomStrategy, a> {
        public static final ProtoAdapter<ClientCustomStrategy> ADAPTER = null;
        public static final c Companion = null;
        private static final long serialVersionUID = 0;
        private final ClientContainer container;
        private final Boolean is_lazy_load;
        private final PreviewSourceStrategy strategy;

        public static final class a extends com.lark.wire.Message.a<ClientCustomStrategy, a> {
            public ClientContainer d;
            public PreviewSourceStrategy e;
            public Boolean f;

            @Override // com.lark.wire.Message.a
            public final com.lark.wire.Message b() {
                return new ClientCustomStrategy(this, c(), null);
            }

            public a() {
            }
        }

        public static final class b extends ProtoAdapter<ClientCustomStrategy> {
            @Override // com.lark.wire.ProtoAdapter
            public final ClientCustomStrategy c(g0 r9) {
                Intrinsics.checkNotNullParameter(r9, "reader");
                a r0 = new a();
                long r1 = r9.c();
            L3:
                int r3 = r9.e();
                if (r3 == (-1)) goto L22;
                if (r3 != 1) goto L8;
                r0.d = ClientContainer.ADAPTER.c(r9);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L19
            L19:
                e = move-exception;
                r9.a(r3, FieldEncoding.VARINT, Long.valueOf(e.value));
                Unit r4 = Unit.INSTANCE;
                goto L3
            L8:
                if (r3 != 2) goto L10;
                r0.e = PreviewSourceStrategy.ADAPTER.c(r9);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L15
            L15:
                e = move-exception;
                r9.a(r3, FieldEncoding.VARINT, Long.valueOf(e.value));
                Unit r5 = Unit.INSTANCE;
                goto L3
            L10:
                if (r3 != 3) goto L11;
                r0.f = (Boolean) ProtoAdapter.g.c(r9);
                goto L3
            L11:
                r9.j(r3);
                goto L3
            L22:
                return new ClientCustomStrategy(r0, r9.d(r1), null);
            }

            @Override // com.lark.wire.ProtoAdapter
            public final int k(ClientCustomStrategy r5) {
                ClientCustomStrategy r6 = r5;
                Intrinsics.checkNotNullParameter(r6, "value");
                return ((r6.unknownFields().size() + ClientContainer.ADAPTER.l(1, r6.getContainer())) + PreviewSourceStrategy.ADAPTER.l(2, r6.getStrategy())) + ProtoAdapter.g.l(3, r6.is_lazy_load());
            }

            @Override // com.lark.wire.ProtoAdapter
            public final void f(j0 r4, ClientCustomStrategy r5) {
                ClientCustomStrategy r6 = r5;
                Intrinsics.checkNotNullParameter(r4, "writer");
                Intrinsics.checkNotNullParameter(r6, "value");
                ClientContainer.ADAPTER.i(r4, 1, r6.getContainer());
                PreviewSourceStrategy.ADAPTER.i(r4, 2, r6.getStrategy());
                ProtoAdapter.g.i(r4, 3, r6.is_lazy_load());
                r4.a(r6.unknownFields());
            }

            @Override // com.lark.wire.ProtoAdapter
            public final void g(n0 r4, ClientCustomStrategy r5) {
                ClientCustomStrategy r6 = r5;
                Intrinsics.checkNotNullParameter(r4, "writer");
                Intrinsics.checkNotNullParameter(r6, "value");
                r4.d(r6.unknownFields());
                ProtoAdapter.g.j(r4, 3, r6.is_lazy_load());
                PreviewSourceStrategy.ADAPTER.j(r4, 2, r6.getStrategy());
                ClientContainer.ADAPTER.j(r4, 1, r6.getContainer());
            }

            public b(FieldEncoding r7, KClass<ClientCustomStrategy> r8, Syntax r9) {
                super(r7, r8, "type.googleapis.com/basic.v1.UrlPreviewHangPoint.ClientCustomStrategy", r9, null);
            }
        }

        public static final class c {
            public c() {
            }
        }

        public /* synthetic */ ClientCustomStrategy(a r1, ByteString r2, DefaultConstructorMarker r3) {
            this(r1, r2);
        }

        static {
            Companion = new c();
            ADAPTER = new b(FieldEncoding.LENGTH_DELIMITED, Reflection.getOrCreateKotlinClass(ClientCustomStrategy.class), Syntax.PROTO_2);
        }

        @Override // com.lark.wire.Message
        public a newBuilder() {
            a r0 = new a();
            r0.d = this.container;
            r0.e = this.strategy;
            r0.f = this.is_lazy_load;
            r0.a(unknownFields());
            return r0;
        }

        @Override // com.lark.wire.Message
        public String toString() {
            return Reflection.getOrCreateKotlinClass(ClientCustomStrategy.class).getSimpleName() + '@' + hashCode();
        }

        public final ClientContainer getContainer() {
            return this.container;
        }

        public final PreviewSourceStrategy getStrategy() {
            return this.strategy;
        }

        public final Boolean is_lazy_load() {
            return this.is_lazy_load;
        }

        @Override // com.lark.wire.Message
        public /* bridge */ /* synthetic */ com.lark.wire.Message.a newBuilder() {
            return newBuilder();
        }

        public ClientCustomStrategy(a r2, ByteString r3) {
            super(ADAPTER, r3);
            this.container = r2.d;
            this.strategy = r2.e;
            this.is_lazy_load = r2.f;
        }

        public /* synthetic */ ClientCustomStrategy(a r1, ByteString r2, int r3, DefaultConstructorMarker r4) {
            if ((r3 & 2) == 0) goto L5;
            r2 = ByteString.EMPTY;
        L5:
            this(r1, r2);
        }
    }

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\n\b\u0086\u0081\u0002\u0018\u0000 \r2\u00020\u00012\b\u0012\u0004\u0012\u00020\u00000\u0002:\u0001\rB\u0011\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u0004X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\f¨\u0006\u000e"}, d2 = {"Lcom/lark/kmp/pb/basic/v1/UrlPreviewHangPoint$PreviewSourceStrategy;", "Lcom/lark/wire/WireEnum;", "", "value", "", "<init>", "(Ljava/lang/String;II)V", "getValue", "()I", "UNKNOWN_PREVIEW_SOURCE_STRATEGY", "SERVER_PULL", "CLIENT_CRAWL", "DISABLED", "Companion", "rust-sdk-kotlin-pb_release"}, k = 1, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
    public static final enum PreviewSourceStrategy extends Enum<PreviewSourceStrategy> implements o0 {
        public static final ProtoAdapter<PreviewSourceStrategy> ADAPTER = null;
        public static final PreviewSourceStrategy CLIENT_CRAWL = null;
        public static final b Companion = null;
        public static final PreviewSourceStrategy DISABLED = null;
        public static final PreviewSourceStrategy SERVER_PULL = null;
        public static final PreviewSourceStrategy UNKNOWN_PREVIEW_SOURCE_STRATEGY = null;
        public static final /* synthetic */ PreviewSourceStrategy[] a = null;
        public static final /* synthetic */ EnumEntries b = null;
        private final int value;

        public static final class a extends d<PreviewSourceStrategy> {
            @Override // com.lark.wire.d
            public final o0 n(int r2) {
                PreviewSourceStrategy.Companion.getClass();
                if (r2 == 0) goto L15;
                if (r2 == 1) goto L19;
                if (r2 == 2) goto L18;
                if (r2 == 3) goto L17;
                return null;
            L17:
                return PreviewSourceStrategy.DISABLED;
            L18:
                return PreviewSourceStrategy.CLIENT_CRAWL;
            L19:
                return PreviewSourceStrategy.SERVER_PULL;
            L15:
                return PreviewSourceStrategy.UNKNOWN_PREVIEW_SOURCE_STRATEGY;
            }

            public a(KClass<PreviewSourceStrategy> r1, Syntax r2, PreviewSourceStrategy r3) {
                super(r1, r2, r3);
            }
        }

        public static final class b {
            public b() {
            }
        }

        public static EnumEntries<PreviewSourceStrategy> getEntries() {
            return b;
        }

        static {
            PreviewSourceStrategy r0 = new PreviewSourceStrategy("UNKNOWN_PREVIEW_SOURCE_STRATEGY", 0, 0);
            UNKNOWN_PREVIEW_SOURCE_STRATEGY = r0;
            PreviewSourceStrategy r1 = new PreviewSourceStrategy("SERVER_PULL", 1, 1);
            SERVER_PULL = r1;
            PreviewSourceStrategy r3 = new PreviewSourceStrategy("CLIENT_CRAWL", 2, 2);
            CLIENT_CRAWL = r3;
            PreviewSourceStrategy r5 = new PreviewSourceStrategy("DISABLED", 3, 3);
            DISABLED = r5;
            PreviewSourceStrategy[] r7 = {r0, r1, r3, r5};
            a = r7;
            b = EnumEntriesKt.enumEntries(r7);
            Companion = new b();
            ADAPTER = new a(Reflection.getOrCreateKotlinClass(PreviewSourceStrategy.class), Syntax.PROTO_2, r0);
        }

        public static PreviewSourceStrategy[] values() {
            return (PreviewSourceStrategy[]) a.clone();
        }

        @Override // com.lark.wire.o0
        public int getValue() {
            return this.value;
        }

        @JvmStatic
        public static final PreviewSourceStrategy fromValue(int r1) {
            Companion.getClass();
            if (r1 == 0) goto L15;
            if (r1 == 1) goto L19;
            if (r1 == 2) goto L18;
            if (r1 == 3) goto L17;
            return null;
        L17:
            return DISABLED;
        L18:
            return CLIENT_CRAWL;
        L19:
            return SERVER_PULL;
        L15:
            return UNKNOWN_PREVIEW_SOURCE_STRATEGY;
        }

        public static PreviewSourceStrategy valueOf(String r1) {
            return (PreviewSourceStrategy) r27.a.a(PreviewSourceStrategy.class, r1);
        }

        public PreviewSourceStrategy(String r1, int r2, int r3) {
            super(r1, r2);
            this.value = r3;
        }
    }

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\b\b\u0086\u0081\u0002\u0018\u0000 \u000b2\u00020\u00012\b\u0012\u0004\u0012\u00020\u00000\u0002:\u0001\u000bB\u0011\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u0004X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bj\u0002\b\tj\u0002\b\n¨\u0006\f"}, d2 = {"Lcom/lark/kmp/pb/basic/v1/UrlPreviewHangPoint$SendScene;", "Lcom/lark/wire/WireEnum;", "", "value", "", "<init>", "(Ljava/lang/String;II)V", "getValue", "()I", "DEFAULT", "DOUBAO_CLOUD_DRIVE_CHOOSE", "Companion", "rust-sdk-kotlin-pb_release"}, k = 1, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
    public static final enum SendScene extends Enum<SendScene> implements o0 {
        public static final ProtoAdapter<SendScene> ADAPTER = null;
        public static final b Companion = null;
        public static final SendScene DEFAULT = null;
        public static final SendScene DOUBAO_CLOUD_DRIVE_CHOOSE = null;
        public static final /* synthetic */ SendScene[] a = null;
        public static final /* synthetic */ EnumEntries b = null;
        private final int value;

        public static final class a extends d<SendScene> {
            @Override // com.lark.wire.d
            public final o0 n(int r2) {
                SendScene.Companion.getClass();
                if (r2 == 0) goto L9;
                if (r2 == 1) goto L11;
                return null;
            L11:
                return SendScene.DOUBAO_CLOUD_DRIVE_CHOOSE;
            L9:
                return SendScene.DEFAULT;
            }

            public a(KClass<SendScene> r1, Syntax r2, SendScene r3) {
                super(r1, r2, r3);
            }
        }

        public static final class b {
            public b() {
            }
        }

        public static EnumEntries<SendScene> getEntries() {
            return b;
        }

        static {
            SendScene r0 = new SendScene("DEFAULT", 0, 0);
            DEFAULT = r0;
            SendScene r1 = new SendScene("DOUBAO_CLOUD_DRIVE_CHOOSE", 1, 1);
            DOUBAO_CLOUD_DRIVE_CHOOSE = r1;
            SendScene[] r3 = {r0, r1};
            a = r3;
            b = EnumEntriesKt.enumEntries(r3);
            Companion = new b();
            ADAPTER = new a(Reflection.getOrCreateKotlinClass(SendScene.class), Syntax.PROTO_2, r0);
        }

        public static SendScene[] values() {
            return (SendScene[]) a.clone();
        }

        @Override // com.lark.wire.o0
        public int getValue() {
            return this.value;
        }

        @JvmStatic
        public static final SendScene fromValue(int r1) {
            Companion.getClass();
            if (r1 == 0) goto L9;
            if (r1 == 1) goto L11;
            return null;
        L11:
            return DOUBAO_CLOUD_DRIVE_CHOOSE;
        L9:
            return DEFAULT;
        }

        public static SendScene valueOf(String r1) {
            return (SendScene) r27.a.a(SendScene.class, r1);
        }

        public SendScene(String r1, int r2, int r3) {
            super(r1, r2);
            this.value = r3;
        }
    }

    public static final class a extends com.lark.wire.Message.a<UrlPreviewHangPoint, a> {
        public String d;
        public String e;
        public Boolean f;
        public Boolean g;
        public SendScene h;
        public List<ClientCustomStrategy> i;

        @Override // com.lark.wire.Message.a
        public final com.lark.wire.Message b() {
            return new UrlPreviewHangPoint(this, c(), null);
        }

        public a() {
            this.i = CollectionsKt.emptyList();
        }
    }

    public static final class b extends ProtoAdapter<UrlPreviewHangPoint> {
        @Override // com.lark.wire.ProtoAdapter
        public final UrlPreviewHangPoint c(g0 r11) {
            Intrinsics.checkNotNullParameter(r11, "reader");
            a r1 = new a();
            ArrayList r2 = new ArrayList();
            long r3 = r11.c();
        L3:
            int r5 = r11.e();
            if (r5 == (-1)) goto L16;
            switch(r5) {
                case 1: goto L15;
                case 2: goto L14;
                case 3: goto L13;
                case 4: goto L12;
                case 5: goto L18;
                case 6: goto L7;
                default: goto L6;
            };
        L18:
            r1.h = SendScene.ADAPTER.c(r11);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L10
        L10:
            e = move-exception;
            r11.a(r5, FieldEncoding.VARINT, Long.valueOf(e.value));
            Unit r6 = Unit.INSTANCE;
            goto L3
        L7:
            r2.add(ClientCustomStrategy.ADAPTER.c(r11));
            goto L3
        L12:
            r1.g = (Boolean) ProtoAdapter.g.c(r11);
            goto L3
        L13:
            r1.f = (Boolean) ProtoAdapter.g.c(r11);
            goto L3
        L14:
            ProtoAdapter.q.getClass();
            Intrinsics.checkNotNullParameter(r11, "reader");
            r1.e = r11.i();
            goto L3
        L15:
            ProtoAdapter.q.getClass();
            Intrinsics.checkNotNullParameter(r11, "reader");
            String r7 = r11.i();
            Intrinsics.checkNotNullParameter(r7, "url");
            r1.d = r7;
            goto L3
        L6:
            r11.j(r5);
            Unit r8 = Unit.INSTANCE;
            goto L3
        L16:
            ByteString r12 = r11.d(r3);
            Intrinsics.checkNotNullParameter(r2, "client_custom_strategies");
            com.lark.wire.internal.a.a(r2);
            r1.i = r2;
            return new UrlPreviewHangPoint(r1, r12, null);
        }

        @Override // com.lark.wire.ProtoAdapter
        public final int k(UrlPreviewHangPoint r5) {
            UrlPreviewHangPoint r6 = r5;
            Intrinsics.checkNotNullParameter(r6, "value");
            int r0 = r6.unknownFields().size();
            w r1 = ProtoAdapter.q;
            int r2 = (r0 + r1.l(1, r6.getUrl())) + r1.l(2, r6.getPreview_id());
            l r3 = ProtoAdapter.g;
            return (((r2 + r3.l(3, r6.getNeed_local_preview())) + r3.l(4, r6.is_lazy_load())) + SendScene.ADAPTER.l(5, r6.getSend_scene())) + ClientCustomStrategy.ADAPTER.a().l(6, r6.getClient_custom_strategies());
        }

        @Override // com.lark.wire.ProtoAdapter
        public final void f(j0 r4, UrlPreviewHangPoint r5) {
            UrlPreviewHangPoint r6 = r5;
            Intrinsics.checkNotNullParameter(r4, "writer");
            Intrinsics.checkNotNullParameter(r6, "value");
            w r0 = ProtoAdapter.q;
            r0.i(r4, 1, r6.getUrl());
            r0.i(r4, 2, r6.getPreview_id());
            l r1 = ProtoAdapter.g;
            r1.i(r4, 3, r6.getNeed_local_preview());
            r1.i(r4, 4, r6.is_lazy_load());
            SendScene.ADAPTER.i(r4, 5, r6.getSend_scene());
            ClientCustomStrategy.ADAPTER.a().i(r4, 6, r6.getClient_custom_strategies());
            r4.a(r6.unknownFields());
        }

        @Override // com.lark.wire.ProtoAdapter
        public final void g(n0 r4, UrlPreviewHangPoint r5) {
            UrlPreviewHangPoint r6 = r5;
            Intrinsics.checkNotNullParameter(r4, "writer");
            Intrinsics.checkNotNullParameter(r6, "value");
            r4.d(r6.unknownFields());
            ClientCustomStrategy.ADAPTER.a().j(r4, 6, r6.getClient_custom_strategies());
            SendScene.ADAPTER.j(r4, 5, r6.getSend_scene());
            l r0 = ProtoAdapter.g;
            r0.j(r4, 4, r6.is_lazy_load());
            r0.j(r4, 3, r6.getNeed_local_preview());
            w r1 = ProtoAdapter.q;
            r1.j(r4, 2, r6.getPreview_id());
            r1.j(r4, 1, r6.getUrl());
        }

        public b(FieldEncoding r7, KClass<UrlPreviewHangPoint> r8, Syntax r9) {
            super(r7, r8, "type.googleapis.com/basic.v1.UrlPreviewHangPoint", r9, null);
        }
    }

    public static final class c {
        public c() {
        }
    }

    public /* synthetic */ UrlPreviewHangPoint(a r1, ByteString r2, DefaultConstructorMarker r3) {
        this(r1, r2);
    }

    static {
        Companion = new c();
        ADAPTER = new b(FieldEncoding.LENGTH_DELIMITED, Reflection.getOrCreateKotlinClass(UrlPreviewHangPoint.class), Syntax.PROTO_2);
    }

    @Override // com.lark.wire.Message
    public a newBuilder() {
        a r0 = new a();
        r0.d = this.url;
        r0.e = this.preview_id;
        r0.f = this.need_local_preview;
        r0.g = this.is_lazy_load;
        r0.h = this.send_scene;
        r0.i = this.client_custom_strategies;
        r0.a(unknownFields());
        return r0;
    }

    @Override // com.lark.wire.Message
    public String toString() {
        return Reflection.getOrCreateKotlinClass(UrlPreviewHangPoint.class).getSimpleName() + '@' + hashCode();
    }

    public final List<ClientCustomStrategy> getClient_custom_strategies() {
        return this.client_custom_strategies;
    }

    public final Boolean getNeed_local_preview() {
        return this.need_local_preview;
    }

    public final String getPreview_id() {
        return this.preview_id;
    }

    public final SendScene getSend_scene() {
        return this.send_scene;
    }

    public final String getUrl() {
        return this.url;
    }

    public final Boolean is_lazy_load() {
        return this.is_lazy_load;
    }

    @Override // com.lark.wire.Message
    public /* bridge */ /* synthetic */ com.lark.wire.Message.a newBuilder() {
        return newBuilder();
    }

    public UrlPreviewHangPoint(a r2, ByteString r3) {
        super(ADAPTER, r3);
        String r4 = r2.d;
        Intrinsics.checkNotNull(r4);
        this.url = r4;
        this.preview_id = r2.e;
        this.need_local_preview = r2.f;
        this.is_lazy_load = r2.g;
        this.send_scene = r2.h;
        this.client_custom_strategies = com.lark.wire.internal.a.c("client_custom_strategies", r2.i);
    }

    public /* synthetic */ UrlPreviewHangPoint(a r1, ByteString r2, int r3, DefaultConstructorMarker r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = ByteString.EMPTY;
    L5:
        this(r1, r2);
    }
}
