package com.bytedance.lark.pb.im.v1;

import com.bytedance.ee.bear.document.offline.sync.PreloadConfigModel;
import com.bytedance.lark.pb.basic.v1.ChatContext;
import com.huawei.hms.support.api.entity.common.CommonConstant;
import com.obric.miniapp.alarm.AccountType;
import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import com.squareup.wire.WireEnum;
import com.squareup.wire.internal.Internal;
import java.io.IOException;
import java.util.Map;
import okio.ByteString;
import r27.a;

/* JADX INFO: loaded from: classes20.dex */
public final class FetchQuickActionsRequest extends Message<FetchQuickActionsRequest, Builder> {
    public static final ProtoAdapter<FetchQuickActionsRequest> ADAPTER = null;
    public static final String DEFAULT_AI_CHAT_MODE_ID = "";
    public static final String DEFAULT_CHAT_ID = "";
    public static final FetchActionType DEFAULT_FETCH_ACTION_TYPE = null;
    public static final Scenario DEFAULT_SCENARIO = null;
    private static final long serialVersionUID = 0;
    public final String ai_chat_mode_id;
    public final ChatContext chat_context;
    public final String chat_id;
    public final FetchActionType fetch_action_type;
    public final Scenario scenario;
    public final Map<String, String> trigger_params_map;

    public static final class Builder extends Message.Builder<FetchQuickActionsRequest, Builder> {
        public String ai_chat_mode_id;
        public ChatContext chat_context;
        public String chat_id;
        public FetchActionType fetch_action_type;
        public Scenario scenario;
        public Map<String, String> trigger_params_map;

        @Override // com.squareup.wire.Message.Builder
        public FetchQuickActionsRequest build() {
            return new FetchQuickActionsRequest(this.trigger_params_map, this.scenario, this.chat_id, this.ai_chat_mode_id, this.chat_context, this.fetch_action_type, super.buildUnknownFields());
        }

        public Builder() {
            this.trigger_params_map = Internal.newMutableMap();
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder ai_chat_mode_id(String r100) {
            this.ai_chat_mode_id = r100;
            return this;
        }

        public Builder chat_context(ChatContext r100) {
            this.chat_context = r100;
            return this;
        }

        public Builder chat_id(String r100) {
            this.chat_id = r100;
            return this;
        }

        public Builder fetch_action_type(FetchActionType r100) {
            this.fetch_action_type = r100;
            return this;
        }

        public Builder scenario(Scenario r100) {
            this.scenario = r100;
            return this;
        }

        public Builder trigger_params_map(Map<String, String> r100) {
            Internal.checkElementsNotNull(r100);
            this.trigger_params_map = r100;
            return this;
        }
    }

    public static final enum FetchActionType extends Enum<FetchActionType> implements WireEnum {
        private static final /* synthetic */ FetchActionType[] $VALUES = null;
        public static final ProtoAdapter<FetchActionType> ADAPTER = null;
        public static final FetchActionType ALL = null;
        public static final FetchActionType PRE_CONFIG = null;
        public static final FetchActionType QUERY_GENERATION = null;
        private final int value;

        static {
            FetchActionType r100 = new FetchActionType("PRE_CONFIG", 0, 0);
            PRE_CONFIG = r100;
            FetchActionType r101 = new FetchActionType("QUERY_GENERATION", 1, 1);
            QUERY_GENERATION = r101;
            FetchActionType r102 = new FetchActionType(AccountType.ALL, 2, 10);
            ALL = r102;
            $VALUES = new FetchActionType[]{r100, r101, r102};
            ADAPTER = ProtoAdapter.newEnumAdapter(FetchActionType.class);
        }

        public static FetchActionType[] values() {
            return (FetchActionType[]) $VALUES.clone();
        }

        @Override // com.squareup.wire.WireEnum
        public final int getValue() {
            return this.value;
        }

        public static FetchActionType fromValue(int r100) {
            if (r100 == 0) goto L14;
            if (r100 == 1) goto L12;
            if (r100 == 10) goto L10;
            return null;
        L10:
            return ALL;
        L12:
            return QUERY_GENERATION;
        L14:
            return PRE_CONFIG;
        }

        public static FetchActionType valueOf(String r100) {
            return (FetchActionType) a.a(FetchActionType.class, r100);
        }

        private FetchActionType(String r100, int r101, int r102) {
            super(r100, r101);
            this.value = r102;
        }
    }

    public static final class ProtoAdapter_FetchQuickActionsRequest extends ProtoAdapter<FetchQuickActionsRequest> {
        private final ProtoAdapter<Map<String, String>> trigger_params_map;

        public ProtoAdapter_FetchQuickActionsRequest() {
            super(FieldEncoding.LENGTH_DELIMITED, FetchQuickActionsRequest.class);
            ProtoAdapter<String> r100 = ProtoAdapter.STRING;
            this.trigger_params_map = ProtoAdapter.newMapAdapter(r100, r100);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public FetchQuickActionsRequest decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            r101.scenario = Scenario.IM;
            r101.chat_id = "";
            r101.ai_chat_mode_id = "";
            r101.fetch_action_type = FetchActionType.PRE_CONFIG;
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L19;
            switch(r103) {
                case 1: goto L18;
                case 2: goto L23;
                case 3: goto L13;
                case 4: goto L12;
                case 5: goto L11;
                case 6: goto L21;
                default: goto L6;
            };
        L21:
            r101.fetch_action_type = FetchActionType.ADAPTER.decode(r100);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L9
        L9:
            e = move-exception;
            r101.addUnknownField(r103, FieldEncoding.VARINT, Long.valueOf(e.value));
            goto L3
        L23:
            r101.scenario = Scenario.ADAPTER.decode(r100);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L16
        L16:
            e = move-exception;
            r101.addUnknownField(r103, FieldEncoding.VARINT, Long.valueOf(e.value));
            goto L3
        L11:
            r101.chat_context = ChatContext.ADAPTER.decode(r100);
            goto L3
        L12:
            r101.ai_chat_mode_id = ProtoAdapter.STRING.decode(r100);
            goto L3
        L13:
            r101.chat_id = ProtoAdapter.STRING.decode(r100);
            goto L3
        L18:
            r101.trigger_params_map.putAll(this.trigger_params_map.decode(r100));
            goto L3
        L6:
            FieldEncoding r104 = r100.peekFieldEncoding();
            r101.addUnknownField(r103, r104, r104.rawProtoAdapter().decode(r100));
            goto L3
        L19:
            r100.endMessage(r102);
            return r101.build();
        }

        /* JADX INFO: renamed from: encodedSize, reason: avoid collision after fix types in other method */
        public int encodedSize2(FetchQuickActionsRequest r100) {
            int r101 = this.trigger_params_map.encodedSizeWithTag(1, r100.trigger_params_map);
            Scenario r102 = r100.scenario;
            int r103 = 0;
            if (r102 == null) goto L5;
            int r104 = Scenario.ADAPTER.encodedSizeWithTag(2, r102);
        L6:
            int r105 = r101 + r104;
            String r106 = r100.chat_id;
            if (r106 == null) goto L9;
            int r107 = ProtoAdapter.STRING.encodedSizeWithTag(3, r106);
        L10:
            int r108 = r105 + r107;
            String r109 = r100.ai_chat_mode_id;
            if (r109 == null) goto L13;
            int r110 = ProtoAdapter.STRING.encodedSizeWithTag(4, r109);
        L14:
            int r111 = r108 + r110;
            ChatContext r112 = r100.chat_context;
            if (r112 == null) goto L17;
            int r113 = ChatContext.ADAPTER.encodedSizeWithTag(5, r112);
        L18:
            int r114 = r111 + r113;
            FetchActionType r115 = r100.fetch_action_type;
            if (r115 == null) goto L22;
            r103 = FetchActionType.ADAPTER.encodedSizeWithTag(6, r115);
        L22:
            return (r114 + r103) + r100.unknownFields().size();
        L17:
            r113 = 0;
            goto L18
        L13:
            r110 = 0;
            goto L14
        L9:
            r107 = 0;
            goto L10
        L5:
            r104 = 0;
            goto L6
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ FetchQuickActionsRequest decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(FetchQuickActionsRequest r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, FetchQuickActionsRequest r101) throws IOException {
            this.trigger_params_map.encodeWithTag(r100, 1, r101.trigger_params_map);
            Scenario r102 = r101.scenario;
            if (r102 == null) goto L5;
            Scenario.ADAPTER.encodeWithTag(r100, 2, r102);
        L5:
            String r103 = r101.chat_id;
            if (r103 == null) goto L8;
            ProtoAdapter.STRING.encodeWithTag(r100, 3, r103);
        L8:
            String r104 = r101.ai_chat_mode_id;
            if (r104 == null) goto L11;
            ProtoAdapter.STRING.encodeWithTag(r100, 4, r104);
        L11:
            ChatContext r105 = r101.chat_context;
            if (r105 == null) goto L14;
            ChatContext.ADAPTER.encodeWithTag(r100, 5, r105);
        L14:
            FetchActionType r106 = r101.fetch_action_type;
            if (r106 == null) goto L17;
            FetchActionType.ADAPTER.encodeWithTag(r100, 6, r106);
        L17:
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, FetchQuickActionsRequest r101) throws IOException {
            encode2(r100, r101);
        }
    }

    public static final enum Scenario extends Enum<Scenario> implements WireEnum {
        private static final /* synthetic */ Scenario[] $VALUES = null;
        public static final ProtoAdapter<Scenario> ADAPTER = null;
        public static final Scenario BASE = null;
        public static final Scenario CALENDAR = null;
        public static final Scenario DOC = null;
        public static final Scenario EMAIL = null;
        public static final Scenario IM = null;
        public static final Scenario MEEGO = null;
        public static final Scenario SHEET = null;
        public static final Scenario VC = null;
        private final int value;

        static {
            Scenario r100 = new Scenario("IM", 0, 0);
            IM = r100;
            Scenario r101 = new Scenario(PreloadConfigModel.VERSION_CHECK_TYPE_DOC, 1, 1);
            DOC = r101;
            Scenario r102 = new Scenario("SHEET", 2, 2);
            SHEET = r102;
            Scenario r103 = new Scenario("BASE", 3, 3);
            BASE = r103;
            Scenario r104 = new Scenario("VC", 4, 4);
            VC = r104;
            Scenario r105 = new Scenario("CALENDAR", 5, 5);
            CALENDAR = r105;
            Scenario r110 = new Scenario(CommonConstant.RETKEY.EMAIL, 6, 6);
            EMAIL = r110;
            Scenario r111 = new Scenario("MEEGO", 7, 7);
            MEEGO = r111;
            $VALUES = new Scenario[]{r100, r101, r102, r103, r104, r105, r110, r111};
            ADAPTER = ProtoAdapter.newEnumAdapter(Scenario.class);
        }

        public static Scenario[] values() {
            return (Scenario[]) $VALUES.clone();
        }

        @Override // com.squareup.wire.WireEnum
        public final int getValue() {
            return this.value;
        }

        public static Scenario fromValue(int r100) {
            switch(r100) {
                case 0: goto L20;
                case 1: goto L18;
                case 2: goto L16;
                case 3: goto L14;
                case 4: goto L12;
                case 5: goto L10;
                case 6: goto L8;
                case 7: goto L6;
                default: goto L3;
            };
        L3:
            return null;
        L6:
            return MEEGO;
        L8:
            return EMAIL;
        L10:
            return CALENDAR;
        L12:
            return VC;
        L14:
            return BASE;
        L16:
            return SHEET;
        L18:
            return DOC;
        L20:
            return IM;
        }

        public static Scenario valueOf(String r100) {
            return (Scenario) a.a(Scenario.class, r100);
        }

        private Scenario(String r100, int r101, int r102) {
            super(r100, r101);
            this.value = r102;
        }
    }

    static {
        ADAPTER = new ProtoAdapter_FetchQuickActionsRequest();
        DEFAULT_SCENARIO = Scenario.IM;
        DEFAULT_FETCH_ACTION_TYPE = FetchActionType.PRE_CONFIG;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.trigger_params_map = Internal.copyOf("trigger_params_map", this.trigger_params_map);
        r100.scenario = this.scenario;
        r100.chat_id = this.chat_id;
        r100.ai_chat_mode_id = this.ai_chat_mode_id;
        r100.chat_context = this.chat_context;
        r100.fetch_action_type = this.fetch_action_type;
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return FetchQuickActionsRequest.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public FetchQuickActionsRequest(Map<String, String> r100, Scenario r110, String r111, String r112, ChatContext r113, FetchActionType r114) {
        this(r100, r110, r111, r112, r113, r114, ByteString.EMPTY);
    }

    public FetchQuickActionsRequest(Map<String, String> r100, Scenario r101, String r102, String r103, ChatContext r104, FetchActionType r105, ByteString r106) {
        super(ADAPTER, r106);
        this.trigger_params_map = Internal.immutableCopyOf("trigger_params_map", r100);
        this.scenario = r101;
        this.chat_id = r102;
        this.ai_chat_mode_id = r103;
        this.chat_context = r104;
        this.fetch_action_type = r105;
    }
}
