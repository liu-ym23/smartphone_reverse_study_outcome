package com.bytedance.lark.pb.basic.v1;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import com.squareup.wire.WireEnum;
import com.squareup.wire.internal.Internal;
import java.io.IOException;
import java.util.List;
import okio.ByteString;
import r27.a;

/* JADX INFO: loaded from: classes20.dex */
public final class UrlPreviewHangPoint extends com.squareup.wire.Message<UrlPreviewHangPoint, Builder> {
    public static final ProtoAdapter<UrlPreviewHangPoint> ADAPTER = null;
    public static final Boolean DEFAULT_IS_LAZY_LOAD = null;
    public static final Boolean DEFAULT_NEED_LOCAL_PREVIEW = null;
    public static final String DEFAULT_PREVIEW_ID = "";
    public static final SendScene DEFAULT_SEND_SCENE = null;
    public static final String DEFAULT_URL = "";
    private static final long serialVersionUID = 0;
    public final List<ClientCustomStrategy> client_custom_strategies;
    public final Boolean is_lazy_load;
    public final Boolean need_local_preview;
    public final String preview_id;
    public final SendScene send_scene;
    public final String url;

    public static final class Builder extends com.squareup.wire.Message.Builder<UrlPreviewHangPoint, Builder> {
        public List<ClientCustomStrategy> client_custom_strategies;
        public Boolean is_lazy_load;
        public Boolean need_local_preview;
        public String preview_id;
        public SendScene send_scene;
        public String url;

        @Override // com.squareup.wire.Message.Builder
        public UrlPreviewHangPoint build() {
            String r100 = this.url;
            if (r100 == null) goto L7;
            return new UrlPreviewHangPoint(this.url, this.preview_id, this.need_local_preview, this.is_lazy_load, this.send_scene, this.client_custom_strategies, super.buildUnknownFields());
        L7:
            throw Internal.missingRequiredFields(new Object[]{r100, "url"});
        }

        public Builder() {
            this.client_custom_strategies = Internal.newMutableList();
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ com.squareup.wire.Message build() {
            return build();
        }

        public Builder client_custom_strategies(List<ClientCustomStrategy> r100) {
            Internal.checkElementsNotNull(r100);
            this.client_custom_strategies = r100;
            return this;
        }

        public Builder is_lazy_load(Boolean r100) {
            this.is_lazy_load = r100;
            return this;
        }

        public Builder need_local_preview(Boolean r100) {
            this.need_local_preview = r100;
            return this;
        }

        public Builder preview_id(String r100) {
            this.preview_id = r100;
            return this;
        }

        public Builder send_scene(SendScene r100) {
            this.send_scene = r100;
            return this;
        }

        public Builder url(String r100) {
            this.url = r100;
            return this;
        }
    }

    public static final enum ClientContainer extends Enum<ClientContainer> implements WireEnum {
        private static final /* synthetic */ ClientContainer[] $VALUES = null;
        public static final ProtoAdapter<ClientContainer> ADAPTER = null;
        public static final ClientContainer DOUBAO = null;
        public static final ClientContainer FEISHU = null;
        public static final ClientContainer UNKNOWN_CLIENT_CONTAINER = null;
        private final int value;

        static {
            ClientContainer r100 = new ClientContainer("UNKNOWN_CLIENT_CONTAINER", 0, 0);
            UNKNOWN_CLIENT_CONTAINER = r100;
            ClientContainer r101 = new ClientContainer("FEISHU", 1, 1);
            FEISHU = r101;
            ClientContainer r102 = new ClientContainer("DOUBAO", 2, 2);
            DOUBAO = r102;
            $VALUES = new ClientContainer[]{r100, r101, r102};
            ADAPTER = ProtoAdapter.newEnumAdapter(ClientContainer.class);
        }

        public static ClientContainer[] values() {
            return (ClientContainer[]) $VALUES.clone();
        }

        @Override // com.squareup.wire.WireEnum
        public final int getValue() {
            return this.value;
        }

        public static ClientContainer fromValue(int r100) {
            if (r100 == 0) goto L14;
            if (r100 == 1) goto L12;
            if (r100 == 2) goto L10;
            return null;
        L10:
            return DOUBAO;
        L12:
            return FEISHU;
        L14:
            return UNKNOWN_CLIENT_CONTAINER;
        }

        public static ClientContainer valueOf(String r100) {
            return (ClientContainer) a.a(ClientContainer.class, r100);
        }

        private ClientContainer(String r100, int r101, int r102) {
            super(r100, r101);
            this.value = r102;
        }
    }

    public static final class ClientCustomStrategy extends com.squareup.wire.Message<ClientCustomStrategy, Builder> {
        public static final ProtoAdapter<ClientCustomStrategy> ADAPTER = null;
        public static final ClientContainer DEFAULT_CONTAINER = null;
        public static final Boolean DEFAULT_IS_LAZY_LOAD = null;
        public static final PreviewSourceStrategy DEFAULT_STRATEGY = null;
        private static final long serialVersionUID = 0;
        public final ClientContainer container;
        public final Boolean is_lazy_load;
        public final PreviewSourceStrategy strategy;

        public static final class Builder extends com.squareup.wire.Message.Builder<ClientCustomStrategy, Builder> {
            public ClientContainer container;
            public Boolean is_lazy_load;
            public PreviewSourceStrategy strategy;

            @Override // com.squareup.wire.Message.Builder
            public ClientCustomStrategy build() {
                return new ClientCustomStrategy(this.container, this.strategy, this.is_lazy_load, super.buildUnknownFields());
            }

            public Builder() {
            }

            @Override // com.squareup.wire.Message.Builder
            public /* bridge */ /* synthetic */ com.squareup.wire.Message build() {
                return build();
            }

            public Builder container(ClientContainer r100) {
                this.container = r100;
                return this;
            }

            public Builder is_lazy_load(Boolean r100) {
                this.is_lazy_load = r100;
                return this;
            }

            public Builder strategy(PreviewSourceStrategy r100) {
                this.strategy = r100;
                return this;
            }
        }

        public static final class ProtoAdapter_ClientCustomStrategy extends ProtoAdapter<ClientCustomStrategy> {
            public ProtoAdapter_ClientCustomStrategy() {
                super(FieldEncoding.LENGTH_DELIMITED, ClientCustomStrategy.class);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.squareup.wire.ProtoAdapter
            public ClientCustomStrategy decode(ProtoReader r100) throws IOException {
                Builder r101 = new Builder();
                r101.container = ClientContainer.UNKNOWN_CLIENT_CONTAINER;
                r101.strategy = PreviewSourceStrategy.UNKNOWN_PREVIEW_SOURCE_STRATEGY;
                r101.is_lazy_load = Boolean.FALSE;
                long r102 = r100.beginMessage();
            L3:
                int r103 = r100.nextTag();
                if (r103 == (-1)) goto L21;
                if (r103 != 1) goto L8;
                r101.container = ClientContainer.ADAPTER.decode(r100);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L19
            L19:
                e = move-exception;
                r101.addUnknownField(r103, FieldEncoding.VARINT, Long.valueOf(e.value));
                goto L3
            L8:
                if (r103 != 2) goto L10;
                r101.strategy = PreviewSourceStrategy.ADAPTER.decode(r100);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L15
            L15:
                e = move-exception;
                r101.addUnknownField(r103, FieldEncoding.VARINT, Long.valueOf(e.value));
                goto L3
            L10:
                if (r103 != 3) goto L11;
                r101.is_lazy_load = ProtoAdapter.BOOL.decode(r100);
                goto L3
            L11:
                FieldEncoding r104 = r100.peekFieldEncoding();
                r101.addUnknownField(r103, r104, r104.rawProtoAdapter().decode(r100));
                goto L3
            L21:
                r100.endMessage(r102);
                return r101.build();
            }

            /* JADX INFO: renamed from: encodedSize, reason: avoid collision after fix types in other method */
            public int encodedSize2(ClientCustomStrategy r100) {
                ClientContainer r101 = r100.container;
                int r102 = 0;
                if (r101 == null) goto L5;
                int r103 = ClientContainer.ADAPTER.encodedSizeWithTag(1, r101);
            L6:
                PreviewSourceStrategy r104 = r100.strategy;
                if (r104 == null) goto L9;
                int r105 = PreviewSourceStrategy.ADAPTER.encodedSizeWithTag(2, r104);
            L10:
                int r106 = r103 + r105;
                Boolean r107 = r100.is_lazy_load;
                if (r107 == null) goto L14;
                r102 = ProtoAdapter.BOOL.encodedSizeWithTag(3, r107);
            L14:
                return (r106 + r102) + r100.unknownFields().size();
            L9:
                r105 = 0;
                goto L10
            L5:
                r103 = 0;
                goto L6
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ ClientCustomStrategy decode(ProtoReader r100) throws IOException {
                return decode(r100);
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ int encodedSize(ClientCustomStrategy r100) {
                return encodedSize2(r100);
            }

            /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
            public void encode2(ProtoWriter r100, ClientCustomStrategy r101) throws IOException {
                ClientContainer r102 = r101.container;
                if (r102 == null) goto L5;
                ClientContainer.ADAPTER.encodeWithTag(r100, 1, r102);
            L5:
                PreviewSourceStrategy r103 = r101.strategy;
                if (r103 == null) goto L8;
                PreviewSourceStrategy.ADAPTER.encodeWithTag(r100, 2, r103);
            L8:
                Boolean r104 = r101.is_lazy_load;
                if (r104 == null) goto L11;
                ProtoAdapter.BOOL.encodeWithTag(r100, 3, r104);
            L11:
                r100.writeBytes(r101.unknownFields());
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, ClientCustomStrategy r101) throws IOException {
                encode2(r100, r101);
            }
        }

        static {
            ADAPTER = new ProtoAdapter_ClientCustomStrategy();
            DEFAULT_CONTAINER = ClientContainer.UNKNOWN_CLIENT_CONTAINER;
            DEFAULT_STRATEGY = PreviewSourceStrategy.UNKNOWN_PREVIEW_SOURCE_STRATEGY;
            DEFAULT_IS_LAZY_LOAD = Boolean.FALSE;
        }

        @Override // com.squareup.wire.Message
        public Builder newBuilder() {
            Builder r100 = new Builder();
            r100.container = this.container;
            r100.strategy = this.strategy;
            r100.is_lazy_load = this.is_lazy_load;
            r100.addUnknownFields(unknownFields());
            return r100;
        }

        @Override // com.squareup.wire.Message
        public String toString() {
            return ClientCustomStrategy.class.getName() + "@" + Integer.toHexString(hashCode());
        }

        @Override // com.squareup.wire.Message
        public /* bridge */ /* synthetic */ com.squareup.wire.Message.Builder newBuilder() {
            return newBuilder();
        }

        public ClientCustomStrategy(ClientContainer r100, PreviewSourceStrategy r101, Boolean r102) {
            this(r100, r101, r102, ByteString.EMPTY);
        }

        public ClientCustomStrategy(ClientContainer r100, PreviewSourceStrategy r101, Boolean r102, ByteString r103) {
            super(ADAPTER, r103);
            this.container = r100;
            this.strategy = r101;
            this.is_lazy_load = r102;
        }
    }

    public static final enum PreviewSourceStrategy extends Enum<PreviewSourceStrategy> implements WireEnum {
        private static final /* synthetic */ PreviewSourceStrategy[] $VALUES = null;
        public static final ProtoAdapter<PreviewSourceStrategy> ADAPTER = null;
        public static final PreviewSourceStrategy CLIENT_CRAWL = null;
        public static final PreviewSourceStrategy DISABLED = null;
        public static final PreviewSourceStrategy SERVER_PULL = null;
        public static final PreviewSourceStrategy UNKNOWN_PREVIEW_SOURCE_STRATEGY = null;
        private final int value;

        static {
            PreviewSourceStrategy r100 = new PreviewSourceStrategy("UNKNOWN_PREVIEW_SOURCE_STRATEGY", 0, 0);
            UNKNOWN_PREVIEW_SOURCE_STRATEGY = r100;
            PreviewSourceStrategy r101 = new PreviewSourceStrategy("SERVER_PULL", 1, 1);
            SERVER_PULL = r101;
            PreviewSourceStrategy r102 = new PreviewSourceStrategy("CLIENT_CRAWL", 2, 2);
            CLIENT_CRAWL = r102;
            PreviewSourceStrategy r103 = new PreviewSourceStrategy("DISABLED", 3, 3);
            DISABLED = r103;
            $VALUES = new PreviewSourceStrategy[]{r100, r101, r102, r103};
            ADAPTER = ProtoAdapter.newEnumAdapter(PreviewSourceStrategy.class);
        }

        public static PreviewSourceStrategy[] values() {
            return (PreviewSourceStrategy[]) $VALUES.clone();
        }

        @Override // com.squareup.wire.WireEnum
        public final int getValue() {
            return this.value;
        }

        public static PreviewSourceStrategy fromValue(int r100) {
            if (r100 == 0) goto L18;
            if (r100 == 1) goto L16;
            if (r100 == 2) goto L14;
            if (r100 == 3) goto L12;
            return null;
        L12:
            return DISABLED;
        L14:
            return CLIENT_CRAWL;
        L16:
            return SERVER_PULL;
        L18:
            return UNKNOWN_PREVIEW_SOURCE_STRATEGY;
        }

        public static PreviewSourceStrategy valueOf(String r100) {
            return (PreviewSourceStrategy) a.a(PreviewSourceStrategy.class, r100);
        }

        private PreviewSourceStrategy(String r100, int r101, int r102) {
            super(r100, r101);
            this.value = r102;
        }
    }

    public static final class ProtoAdapter_UrlPreviewHangPoint extends ProtoAdapter<UrlPreviewHangPoint> {
        public ProtoAdapter_UrlPreviewHangPoint() {
            super(FieldEncoding.LENGTH_DELIMITED, UrlPreviewHangPoint.class);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public UrlPreviewHangPoint decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            r101.url = "";
            r101.preview_id = "";
            Boolean r102 = Boolean.FALSE;
            r101.need_local_preview = r102;
            r101.is_lazy_load = r102;
            r101.send_scene = SendScene.DEFAULT;
            long r103 = r100.beginMessage();
        L3:
            int r104 = r100.nextTag();
            if (r104 == (-1)) goto L16;
            switch(r104) {
                case 1: goto L15;
                case 2: goto L14;
                case 3: goto L13;
                case 4: goto L12;
                case 5: goto L18;
                case 6: goto L7;
                default: goto L6;
            };
        L18:
            r101.send_scene = SendScene.ADAPTER.decode(r100);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L10
        L10:
            e = move-exception;
            r101.addUnknownField(r104, FieldEncoding.VARINT, Long.valueOf(e.value));
            goto L3
        L7:
            r101.client_custom_strategies.add(ClientCustomStrategy.ADAPTER.decode(r100));
            goto L3
        L12:
            r101.is_lazy_load = ProtoAdapter.BOOL.decode(r100);
            goto L3
        L13:
            r101.need_local_preview = ProtoAdapter.BOOL.decode(r100);
            goto L3
        L14:
            r101.preview_id = ProtoAdapter.STRING.decode(r100);
            goto L3
        L15:
            r101.url = ProtoAdapter.STRING.decode(r100);
            goto L3
        L6:
            FieldEncoding r105 = r100.peekFieldEncoding();
            r101.addUnknownField(r104, r105, r105.rawProtoAdapter().decode(r100));
            goto L3
        L16:
            r100.endMessage(r103);
            return r101.build();
        }

        /* JADX INFO: renamed from: encodedSize, reason: avoid collision after fix types in other method */
        public int encodedSize2(UrlPreviewHangPoint r100) {
            ProtoAdapter<String> r101 = ProtoAdapter.STRING;
            int r102 = r101.encodedSizeWithTag(1, r100.url);
            String r103 = r100.preview_id;
            int r104 = 0;
            if (r103 == null) goto L5;
            int r105 = r101.encodedSizeWithTag(2, r103);
        L6:
            int r106 = r102 + r105;
            Boolean r107 = r100.need_local_preview;
            if (r107 == null) goto L9;
            int r108 = ProtoAdapter.BOOL.encodedSizeWithTag(3, r107);
        L10:
            int r109 = r106 + r108;
            Boolean r110 = r100.is_lazy_load;
            if (r110 == null) goto L13;
            int r111 = ProtoAdapter.BOOL.encodedSizeWithTag(4, r110);
        L14:
            int r112 = r109 + r111;
            SendScene r113 = r100.send_scene;
            if (r113 == null) goto L18;
            r104 = SendScene.ADAPTER.encodedSizeWithTag(5, r113);
        L18:
            return ((r112 + r104) + ClientCustomStrategy.ADAPTER.asRepeated().encodedSizeWithTag(6, r100.client_custom_strategies)) + r100.unknownFields().size();
        L13:
            r111 = 0;
            goto L14
        L9:
            r108 = 0;
            goto L10
        L5:
            r105 = 0;
            goto L6
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ UrlPreviewHangPoint decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(UrlPreviewHangPoint r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, UrlPreviewHangPoint r101) throws IOException {
            ProtoAdapter<String> r102 = ProtoAdapter.STRING;
            r102.encodeWithTag(r100, 1, r101.url);
            String r103 = r101.preview_id;
            if (r103 == null) goto L5;
            r102.encodeWithTag(r100, 2, r103);
        L5:
            Boolean r104 = r101.need_local_preview;
            if (r104 == null) goto L8;
            ProtoAdapter.BOOL.encodeWithTag(r100, 3, r104);
        L8:
            Boolean r105 = r101.is_lazy_load;
            if (r105 == null) goto L11;
            ProtoAdapter.BOOL.encodeWithTag(r100, 4, r105);
        L11:
            SendScene r106 = r101.send_scene;
            if (r106 == null) goto L14;
            SendScene.ADAPTER.encodeWithTag(r100, 5, r106);
        L14:
            ClientCustomStrategy.ADAPTER.asRepeated().encodeWithTag(r100, 6, r101.client_custom_strategies);
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, UrlPreviewHangPoint r101) throws IOException {
            encode2(r100, r101);
        }
    }

    public static final enum SendScene extends Enum<SendScene> implements WireEnum {
        private static final /* synthetic */ SendScene[] $VALUES = null;
        public static final ProtoAdapter<SendScene> ADAPTER = null;
        public static final SendScene DEFAULT = null;
        public static final SendScene DOUBAO_CLOUD_DRIVE_CHOOSE = null;
        private final int value;

        static {
            SendScene r100 = new SendScene("DEFAULT", 0, 0);
            DEFAULT = r100;
            SendScene r101 = new SendScene("DOUBAO_CLOUD_DRIVE_CHOOSE", 1, 1);
            DOUBAO_CLOUD_DRIVE_CHOOSE = r101;
            $VALUES = new SendScene[]{r100, r101};
            ADAPTER = ProtoAdapter.newEnumAdapter(SendScene.class);
        }

        public static SendScene[] values() {
            return (SendScene[]) $VALUES.clone();
        }

        @Override // com.squareup.wire.WireEnum
        public final int getValue() {
            return this.value;
        }

        public static SendScene fromValue(int r100) {
            if (r100 == 0) goto L10;
            if (r100 == 1) goto L8;
            return null;
        L8:
            return DOUBAO_CLOUD_DRIVE_CHOOSE;
        L10:
            return DEFAULT;
        }

        public static SendScene valueOf(String r100) {
            return (SendScene) a.a(SendScene.class, r100);
        }

        private SendScene(String r100, int r101, int r102) {
            super(r100, r101);
            this.value = r102;
        }
    }

    static {
        ADAPTER = new ProtoAdapter_UrlPreviewHangPoint();
        Boolean r100 = Boolean.FALSE;
        DEFAULT_NEED_LOCAL_PREVIEW = r100;
        DEFAULT_IS_LAZY_LOAD = r100;
        DEFAULT_SEND_SCENE = SendScene.DEFAULT;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.url = this.url;
        r100.preview_id = this.preview_id;
        r100.need_local_preview = this.need_local_preview;
        r100.is_lazy_load = this.is_lazy_load;
        r100.send_scene = this.send_scene;
        r100.client_custom_strategies = Internal.copyOf("client_custom_strategies", this.client_custom_strategies);
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return UrlPreviewHangPoint.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ com.squareup.wire.Message.Builder newBuilder() {
        return newBuilder();
    }

    public UrlPreviewHangPoint(String r100, String r110, Boolean r111, Boolean r112, SendScene r113, List<ClientCustomStrategy> r114) {
        this(r100, r110, r111, r112, r113, r114, ByteString.EMPTY);
    }

    public UrlPreviewHangPoint(String r100, String r101, Boolean r102, Boolean r103, SendScene r104, List<ClientCustomStrategy> r105, ByteString r106) {
        super(ADAPTER, r106);
        this.url = r100;
        this.preview_id = r101;
        this.need_local_preview = r102;
        this.is_lazy_load = r103;
        this.send_scene = r104;
        this.client_custom_strategies = Internal.immutableCopyOf("client_custom_strategies", r105);
    }
}
