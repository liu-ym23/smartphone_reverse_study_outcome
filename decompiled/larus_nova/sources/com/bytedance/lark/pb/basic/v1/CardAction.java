package com.bytedance.lark.pb.basic.v1;

import com.alipay.sdk.m.p.e;
import com.squareup.wire.FieldEncoding;
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
public final class CardAction extends com.squareup.wire.Message<CardAction, Builder> {
    public static final ProtoAdapter<CardAction> ADAPTER = null;
    public static final Integer DEFAULT_CMD = null;
    public static final Method DEFAULT_METHOD = null;
    public static final String DEFAULT_URL = "";
    private static final long serialVersionUID = 0;
    public final Integer cmd;
    public final Method method;
    public final Url open_url;
    public final CardActionPacket packet;
    public final Parameters parameters;
    public final RequiredParameters required_parameters;
    public final String url;

    public static final class Builder extends com.squareup.wire.Message.Builder<CardAction, Builder> {
        public Integer cmd;
        public Method method;
        public Url open_url;
        public CardActionPacket packet;
        public Parameters parameters;
        public RequiredParameters required_parameters;
        public String url;

        @Override // com.squareup.wire.Message.Builder
        public CardAction build() {
            String r100 = this.url;
            if (r100 == null) goto L9;
            if (this.method == null) goto L9;
            return new CardAction(this.url, this.method, this.required_parameters, this.parameters, this.cmd, this.packet, this.open_url, super.buildUnknownFields());
        L9:
            throw Internal.missingRequiredFields(new Object[]{r100, "url", this.method, e.f25671s});
        }

        public Builder() {
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ com.squareup.wire.Message build() {
            return build();
        }

        public Builder cmd(Integer r100) {
            this.cmd = r100;
            return this;
        }

        public Builder method(Method r100) {
            this.method = r100;
            return this;
        }

        public Builder open_url(Url r100) {
            this.open_url = r100;
            return this;
        }

        public Builder packet(CardActionPacket r100) {
            this.packet = r100;
            return this;
        }

        public Builder parameters(Parameters r100) {
            this.parameters = r100;
            return this;
        }

        public Builder required_parameters(RequiredParameters r100) {
            this.required_parameters = r100;
            return this;
        }

        public Builder url(String r100) {
            this.url = r100;
            return this;
        }
    }

    public static final class MessageInfo extends com.squareup.wire.Message<MessageInfo, Builder> {
        public static final ProtoAdapter<MessageInfo> ADAPTER = null;
        public static final String DEFAULT_MESSAGE_OPEN_ID = "";
        private static final long serialVersionUID = 0;
        public final String message_open_id;

        public static final class Builder extends com.squareup.wire.Message.Builder<MessageInfo, Builder> {
            public String message_open_id;

            @Override // com.squareup.wire.Message.Builder
            public MessageInfo build() {
                return new MessageInfo(this.message_open_id, super.buildUnknownFields());
            }

            public Builder() {
            }

            @Override // com.squareup.wire.Message.Builder
            public /* bridge */ /* synthetic */ com.squareup.wire.Message build() {
                return build();
            }

            public Builder message_open_id(String r100) {
                this.message_open_id = r100;
                return this;
            }
        }

        public static final class ProtoAdapter_MessageInfo extends ProtoAdapter<MessageInfo> {
            public ProtoAdapter_MessageInfo() {
                super(FieldEncoding.LENGTH_DELIMITED, MessageInfo.class);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.squareup.wire.ProtoAdapter
            public MessageInfo decode(ProtoReader r100) throws IOException {
                Builder r101 = new Builder();
                r101.message_open_id = "";
                long r102 = r100.beginMessage();
            L3:
                int r103 = r100.nextTag();
                if (r103 == (-1)) goto L9;
                if (r103 != 2) goto L7;
                r101.message_open_id = ProtoAdapter.STRING.decode(r100);
                goto L3
            L7:
                FieldEncoding r104 = r100.peekFieldEncoding();
                r101.addUnknownField(r103, r104, r104.rawProtoAdapter().decode(r100));
                goto L3
            L9:
                r100.endMessage(r102);
                return r101.build();
            }

            /* JADX INFO: renamed from: encodedSize, reason: avoid collision after fix types in other method */
            public int encodedSize2(MessageInfo r100) {
                String r101 = r100.message_open_id;
                if (r101 == null) goto L5;
                int r102 = ProtoAdapter.STRING.encodedSizeWithTag(2, r101);
            L7:
                return r102 + r100.unknownFields().size();
            L5:
                r102 = 0;
                goto L7
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ MessageInfo decode(ProtoReader r100) throws IOException {
                return decode(r100);
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ int encodedSize(MessageInfo r100) {
                return encodedSize2(r100);
            }

            /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
            public void encode2(ProtoWriter r100, MessageInfo r101) throws IOException {
                String r102 = r101.message_open_id;
                if (r102 == null) goto L5;
                ProtoAdapter.STRING.encodeWithTag(r100, 2, r102);
            L5:
                r100.writeBytes(r101.unknownFields());
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, MessageInfo r101) throws IOException {
                encode2(r100, r101);
            }
        }

        static {
            ADAPTER = new ProtoAdapter_MessageInfo();
        }

        @Override // com.squareup.wire.Message
        public Builder newBuilder() {
            Builder r100 = new Builder();
            r100.message_open_id = this.message_open_id;
            r100.addUnknownFields(unknownFields());
            return r100;
        }

        @Override // com.squareup.wire.Message
        public String toString() {
            return MessageInfo.class.getName() + "@" + Integer.toHexString(hashCode());
        }

        @Override // com.squareup.wire.Message
        public /* bridge */ /* synthetic */ com.squareup.wire.Message.Builder newBuilder() {
            return newBuilder();
        }

        public MessageInfo(String r100) {
            this(r100, ByteString.EMPTY);
        }

        public MessageInfo(String r100, ByteString r101) {
            super(ADAPTER, r101);
            this.message_open_id = r100;
        }
    }

    public static final enum Method extends Enum<Method> implements WireEnum {
        private static final /* synthetic */ Method[] $VALUES = null;
        public static final ProtoAdapter<Method> ADAPTER = null;
        public static final Method GET = null;
        public static final Method LARK_COMMAND = null;
        public static final Method OPEN_URL = null;
        public static final Method POST = null;
        private final int value;

        static {
            Method r100 = new Method("GET", 0, 1);
            GET = r100;
            Method r101 = new Method("POST", 1, 2);
            POST = r101;
            Method r102 = new Method("LARK_COMMAND", 2, 3);
            LARK_COMMAND = r102;
            Method r103 = new Method("OPEN_URL", 3, 4);
            OPEN_URL = r103;
            $VALUES = new Method[]{r100, r101, r102, r103};
            ADAPTER = ProtoAdapter.newEnumAdapter(Method.class);
        }

        public static Method[] values() {
            return (Method[]) $VALUES.clone();
        }

        @Override // com.squareup.wire.WireEnum
        public final int getValue() {
            return this.value;
        }

        public static Method fromValue(int r100) {
            if (r100 == 1) goto L19;
            if (r100 == 2) goto L17;
            if (r100 == 3) goto L15;
            if (r100 == 4) goto L13;
            return null;
        L13:
            return OPEN_URL;
        L15:
            return LARK_COMMAND;
        L17:
            return POST;
        L19:
            return GET;
        }

        public static Method valueOf(String r100) {
            return (Method) a.a(Method.class, r100);
        }

        private Method(String r100, int r101, int r102) {
            super(r100, r101);
            this.value = r102;
        }
    }

    public static final class Parameters extends com.squareup.wire.Message<Parameters, Builder> {
        public static final ProtoAdapter<Parameters> ADAPTER = null;
        public static final String DEFAULT_CARD_ID = "";
        public static final String DEFAULT_MESSAGE_ID = "";
        public static final String DEFAULT_USER_ID = "";
        private static final long serialVersionUID = 0;
        public final String card_id;
        public final String message_id;
        public final MessageInfo message_info;
        public final Map<String, String> parameters;
        public final String user_id;
        public final UserInfo user_info;

        public static final class Builder extends com.squareup.wire.Message.Builder<Parameters, Builder> {
            public String card_id;
            public String message_id;
            public MessageInfo message_info;
            public Map<String, String> parameters;
            public String user_id;
            public UserInfo user_info;

            @Override // com.squareup.wire.Message.Builder
            public Parameters build() {
                return new Parameters(this.parameters, this.user_info, this.message_info, this.user_id, this.message_id, this.card_id, super.buildUnknownFields());
            }

            public Builder() {
                this.parameters = Internal.newMutableMap();
            }

            @Override // com.squareup.wire.Message.Builder
            public /* bridge */ /* synthetic */ com.squareup.wire.Message build() {
                return build();
            }

            public Builder card_id(String r100) {
                this.card_id = r100;
                return this;
            }

            public Builder message_id(String r100) {
                this.message_id = r100;
                return this;
            }

            public Builder message_info(MessageInfo r100) {
                this.message_info = r100;
                return this;
            }

            public Builder parameters(Map<String, String> r100) {
                Internal.checkElementsNotNull(r100);
                this.parameters = r100;
                return this;
            }

            public Builder user_id(String r100) {
                this.user_id = r100;
                return this;
            }

            public Builder user_info(UserInfo r100) {
                this.user_info = r100;
                return this;
            }
        }

        public static final class ProtoAdapter_Parameters extends ProtoAdapter<Parameters> {
            private final ProtoAdapter<Map<String, String>> parameters;

            public ProtoAdapter_Parameters() {
                super(FieldEncoding.LENGTH_DELIMITED, Parameters.class);
                ProtoAdapter<String> r100 = ProtoAdapter.STRING;
                this.parameters = ProtoAdapter.newMapAdapter(r100, r100);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.squareup.wire.ProtoAdapter
            public Parameters decode(ProtoReader r100) throws IOException {
                Builder r101 = new Builder();
                r101.user_id = "";
                r101.message_id = "";
                r101.card_id = "";
                long r102 = r100.beginMessage();
            L3:
                int r103 = r100.nextTag();
                if (r103 == (-1)) goto L13;
                switch(r103) {
                    case 1: goto L12;
                    case 2: goto L11;
                    case 3: goto L10;
                    case 4: goto L9;
                    case 5: goto L8;
                    case 6: goto L7;
                    default: goto L6;
                };
            L7:
                r101.card_id = ProtoAdapter.STRING.decode(r100);
                goto L3
            L8:
                r101.message_id = ProtoAdapter.STRING.decode(r100);
                goto L3
            L9:
                r101.user_id = ProtoAdapter.STRING.decode(r100);
                goto L3
            L10:
                r101.message_info = MessageInfo.ADAPTER.decode(r100);
                goto L3
            L11:
                r101.user_info = UserInfo.ADAPTER.decode(r100);
                goto L3
            L12:
                r101.parameters.putAll(this.parameters.decode(r100));
                goto L3
            L6:
                FieldEncoding r104 = r100.peekFieldEncoding();
                r101.addUnknownField(r103, r104, r104.rawProtoAdapter().decode(r100));
                goto L3
            L13:
                r100.endMessage(r102);
                return r101.build();
            }

            /* JADX INFO: renamed from: encodedSize, reason: avoid collision after fix types in other method */
            public int encodedSize2(Parameters r100) {
                int r101 = this.parameters.encodedSizeWithTag(1, r100.parameters);
                UserInfo r102 = r100.user_info;
                int r103 = 0;
                if (r102 == null) goto L5;
                int r104 = UserInfo.ADAPTER.encodedSizeWithTag(2, r102);
            L6:
                int r105 = r101 + r104;
                MessageInfo r106 = r100.message_info;
                if (r106 == null) goto L9;
                int r107 = MessageInfo.ADAPTER.encodedSizeWithTag(3, r106);
            L10:
                int r108 = r105 + r107;
                String r109 = r100.user_id;
                if (r109 == null) goto L13;
                int r110 = ProtoAdapter.STRING.encodedSizeWithTag(4, r109);
            L14:
                int r111 = r108 + r110;
                String r112 = r100.message_id;
                if (r112 == null) goto L17;
                int r113 = ProtoAdapter.STRING.encodedSizeWithTag(5, r112);
            L18:
                int r114 = r111 + r113;
                String r115 = r100.card_id;
                if (r115 == null) goto L22;
                r103 = ProtoAdapter.STRING.encodedSizeWithTag(6, r115);
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
            public /* bridge */ /* synthetic */ Parameters decode(ProtoReader r100) throws IOException {
                return decode(r100);
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ int encodedSize(Parameters r100) {
                return encodedSize2(r100);
            }

            /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
            public void encode2(ProtoWriter r100, Parameters r101) throws IOException {
                this.parameters.encodeWithTag(r100, 1, r101.parameters);
                UserInfo r102 = r101.user_info;
                if (r102 == null) goto L5;
                UserInfo.ADAPTER.encodeWithTag(r100, 2, r102);
            L5:
                MessageInfo r103 = r101.message_info;
                if (r103 == null) goto L8;
                MessageInfo.ADAPTER.encodeWithTag(r100, 3, r103);
            L8:
                String r104 = r101.user_id;
                if (r104 == null) goto L11;
                ProtoAdapter.STRING.encodeWithTag(r100, 4, r104);
            L11:
                String r105 = r101.message_id;
                if (r105 == null) goto L14;
                ProtoAdapter.STRING.encodeWithTag(r100, 5, r105);
            L14:
                String r106 = r101.card_id;
                if (r106 == null) goto L17;
                ProtoAdapter.STRING.encodeWithTag(r100, 6, r106);
            L17:
                r100.writeBytes(r101.unknownFields());
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, Parameters r101) throws IOException {
                encode2(r100, r101);
            }
        }

        static {
            ADAPTER = new ProtoAdapter_Parameters();
        }

        @Override // com.squareup.wire.Message
        public Builder newBuilder() {
            Builder r100 = new Builder();
            r100.parameters = Internal.copyOf("parameters", this.parameters);
            r100.user_info = this.user_info;
            r100.message_info = this.message_info;
            r100.user_id = this.user_id;
            r100.message_id = this.message_id;
            r100.card_id = this.card_id;
            r100.addUnknownFields(unknownFields());
            return r100;
        }

        @Override // com.squareup.wire.Message
        public String toString() {
            return Parameters.class.getName() + "@" + Integer.toHexString(hashCode());
        }

        @Override // com.squareup.wire.Message
        public /* bridge */ /* synthetic */ com.squareup.wire.Message.Builder newBuilder() {
            return newBuilder();
        }

        public Parameters(Map<String, String> r100, UserInfo r110, MessageInfo r111, String r112, String r113, String r114) {
            this(r100, r110, r111, r112, r113, r114, ByteString.EMPTY);
        }

        public Parameters(Map<String, String> r100, UserInfo r101, MessageInfo r102, String r103, String r104, String r105, ByteString r106) {
            super(ADAPTER, r106);
            this.parameters = Internal.immutableCopyOf("parameters", r100);
            this.user_info = r101;
            this.message_info = r102;
            this.user_id = r103;
            this.message_id = r104;
            this.card_id = r105;
        }
    }

    public static final class ProtoAdapter_CardAction extends ProtoAdapter<CardAction> {
        public ProtoAdapter_CardAction() {
            super(FieldEncoding.LENGTH_DELIMITED, CardAction.class);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public CardAction decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            r101.url = "";
            r101.method = Method.GET;
            r101.cmd = 0;
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L17;
            switch(r103) {
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
            r101.method = Method.ADAPTER.decode(r100);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L14
        L14:
            e = move-exception;
            r101.addUnknownField(r103, FieldEncoding.VARINT, Long.valueOf(e.value));
            goto L3
        L7:
            r101.open_url = Url.ADAPTER.decode(r100);
            goto L3
        L8:
            r101.packet = CardActionPacket.ADAPTER.decode(r100);
            goto L3
        L9:
            r101.cmd = ProtoAdapter.INT32.decode(r100);
            goto L3
        L10:
            r101.parameters = Parameters.ADAPTER.decode(r100);
            goto L3
        L11:
            r101.required_parameters = RequiredParameters.ADAPTER.decode(r100);
            goto L3
        L16:
            r101.url = ProtoAdapter.STRING.decode(r100);
            goto L3
        L6:
            FieldEncoding r104 = r100.peekFieldEncoding();
            r101.addUnknownField(r103, r104, r104.rawProtoAdapter().decode(r100));
            goto L3
        L17:
            r100.endMessage(r102);
            return r101.build();
        }

        /* JADX INFO: renamed from: encodedSize, reason: avoid collision after fix types in other method */
        public int encodedSize2(CardAction r100) {
            int r101 = ProtoAdapter.STRING.encodedSizeWithTag(1, r100.url) + Method.ADAPTER.encodedSizeWithTag(2, r100.method);
            RequiredParameters r102 = r100.required_parameters;
            int r103 = 0;
            if (r102 == null) goto L5;
            int r104 = RequiredParameters.ADAPTER.encodedSizeWithTag(3, r102);
        L6:
            int r105 = r101 + r104;
            Parameters r106 = r100.parameters;
            if (r106 == null) goto L9;
            int r107 = Parameters.ADAPTER.encodedSizeWithTag(4, r106);
        L10:
            int r108 = r105 + r107;
            Integer r109 = r100.cmd;
            if (r109 == null) goto L13;
            int r110 = ProtoAdapter.INT32.encodedSizeWithTag(5, r109);
        L14:
            int r111 = r108 + r110;
            CardActionPacket r112 = r100.packet;
            if (r112 == null) goto L17;
            int r113 = CardActionPacket.ADAPTER.encodedSizeWithTag(6, r112);
        L18:
            int r114 = r111 + r113;
            Url r115 = r100.open_url;
            if (r115 == null) goto L22;
            r103 = Url.ADAPTER.encodedSizeWithTag(7, r115);
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
        public /* bridge */ /* synthetic */ CardAction decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(CardAction r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, CardAction r101) throws IOException {
            ProtoAdapter.STRING.encodeWithTag(r100, 1, r101.url);
            Method.ADAPTER.encodeWithTag(r100, 2, r101.method);
            RequiredParameters r102 = r101.required_parameters;
            if (r102 == null) goto L5;
            RequiredParameters.ADAPTER.encodeWithTag(r100, 3, r102);
        L5:
            Parameters r103 = r101.parameters;
            if (r103 == null) goto L8;
            Parameters.ADAPTER.encodeWithTag(r100, 4, r103);
        L8:
            Integer r104 = r101.cmd;
            if (r104 == null) goto L11;
            ProtoAdapter.INT32.encodeWithTag(r100, 5, r104);
        L11:
            CardActionPacket r105 = r101.packet;
            if (r105 == null) goto L14;
            CardActionPacket.ADAPTER.encodeWithTag(r100, 6, r105);
        L14:
            Url r106 = r101.open_url;
            if (r106 == null) goto L17;
            Url.ADAPTER.encodeWithTag(r100, 7, r106);
        L17:
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, CardAction r101) throws IOException {
            encode2(r100, r101);
        }
    }

    public static final class RequiredParameters extends com.squareup.wire.Message<RequiredParameters, Builder> {
        public static final ProtoAdapter<RequiredParameters> ADAPTER = null;
        public static final Boolean DEFAULT_NEED_MESSAGE_ID = null;
        public static final Boolean DEFAULT_NEED_MESSAGE_INFO = null;
        public static final Boolean DEFAULT_NEED_USER_ID = null;
        public static final Boolean DEFAULT_NEED_USER_INFO = null;
        private static final long serialVersionUID = 0;
        public final Boolean need_message_id;
        public final Boolean need_message_info;
        public final Boolean need_user_id;
        public final Boolean need_user_info;

        public static final class Builder extends com.squareup.wire.Message.Builder<RequiredParameters, Builder> {
            public Boolean need_message_id;
            public Boolean need_message_info;
            public Boolean need_user_id;
            public Boolean need_user_info;

            @Override // com.squareup.wire.Message.Builder
            public RequiredParameters build() {
                return new RequiredParameters(this.need_user_info, this.need_message_info, this.need_user_id, this.need_message_id, super.buildUnknownFields());
            }

            public Builder() {
            }

            @Override // com.squareup.wire.Message.Builder
            public /* bridge */ /* synthetic */ com.squareup.wire.Message build() {
                return build();
            }

            public Builder need_message_id(Boolean r100) {
                this.need_message_id = r100;
                return this;
            }

            public Builder need_message_info(Boolean r100) {
                this.need_message_info = r100;
                return this;
            }

            public Builder need_user_id(Boolean r100) {
                this.need_user_id = r100;
                return this;
            }

            public Builder need_user_info(Boolean r100) {
                this.need_user_info = r100;
                return this;
            }
        }

        public static final class ProtoAdapter_RequiredParameters extends ProtoAdapter<RequiredParameters> {
            public ProtoAdapter_RequiredParameters() {
                super(FieldEncoding.LENGTH_DELIMITED, RequiredParameters.class);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.squareup.wire.ProtoAdapter
            public RequiredParameters decode(ProtoReader r100) throws IOException {
                Builder r101 = new Builder();
                Boolean r102 = Boolean.FALSE;
                r101.need_user_info = r102;
                r101.need_message_info = r102;
                r101.need_user_id = r102;
                r101.need_message_id = r102;
                long r103 = r100.beginMessage();
            L3:
                int r104 = r100.nextTag();
                if (r104 == (-1)) goto L18;
                if (r104 != 1) goto L8;
                r101.need_user_info = ProtoAdapter.BOOL.decode(r100);
                goto L3
            L8:
                if (r104 != 2) goto L10;
                r101.need_message_info = ProtoAdapter.BOOL.decode(r100);
                goto L3
            L10:
                if (r104 != 3) goto L12;
                r101.need_user_id = ProtoAdapter.BOOL.decode(r100);
                goto L3
            L12:
                if (r104 != 4) goto L13;
                r101.need_message_id = ProtoAdapter.BOOL.decode(r100);
                goto L3
            L13:
                FieldEncoding r105 = r100.peekFieldEncoding();
                r101.addUnknownField(r104, r105, r105.rawProtoAdapter().decode(r100));
                goto L3
            L18:
                r100.endMessage(r103);
                return r101.build();
            }

            /* JADX INFO: renamed from: encodedSize, reason: avoid collision after fix types in other method */
            public int encodedSize2(RequiredParameters r100) {
                Boolean r101 = r100.need_user_info;
                int r102 = 0;
                if (r101 == null) goto L5;
                int r103 = ProtoAdapter.BOOL.encodedSizeWithTag(1, r101);
            L6:
                Boolean r104 = r100.need_message_info;
                if (r104 == null) goto L9;
                int r105 = ProtoAdapter.BOOL.encodedSizeWithTag(2, r104);
            L10:
                int r106 = r103 + r105;
                Boolean r107 = r100.need_user_id;
                if (r107 == null) goto L13;
                int r108 = ProtoAdapter.BOOL.encodedSizeWithTag(3, r107);
            L14:
                int r109 = r106 + r108;
                Boolean r110 = r100.need_message_id;
                if (r110 == null) goto L18;
                r102 = ProtoAdapter.BOOL.encodedSizeWithTag(4, r110);
            L18:
                return (r109 + r102) + r100.unknownFields().size();
            L13:
                r108 = 0;
                goto L14
            L9:
                r105 = 0;
                goto L10
            L5:
                r103 = 0;
                goto L6
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ RequiredParameters decode(ProtoReader r100) throws IOException {
                return decode(r100);
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ int encodedSize(RequiredParameters r100) {
                return encodedSize2(r100);
            }

            /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
            public void encode2(ProtoWriter r100, RequiredParameters r101) throws IOException {
                Boolean r102 = r101.need_user_info;
                if (r102 == null) goto L5;
                ProtoAdapter.BOOL.encodeWithTag(r100, 1, r102);
            L5:
                Boolean r103 = r101.need_message_info;
                if (r103 == null) goto L8;
                ProtoAdapter.BOOL.encodeWithTag(r100, 2, r103);
            L8:
                Boolean r104 = r101.need_user_id;
                if (r104 == null) goto L11;
                ProtoAdapter.BOOL.encodeWithTag(r100, 3, r104);
            L11:
                Boolean r105 = r101.need_message_id;
                if (r105 == null) goto L14;
                ProtoAdapter.BOOL.encodeWithTag(r100, 4, r105);
            L14:
                r100.writeBytes(r101.unknownFields());
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, RequiredParameters r101) throws IOException {
                encode2(r100, r101);
            }
        }

        static {
            ADAPTER = new ProtoAdapter_RequiredParameters();
            Boolean r100 = Boolean.FALSE;
            DEFAULT_NEED_USER_INFO = r100;
            DEFAULT_NEED_MESSAGE_INFO = r100;
            DEFAULT_NEED_USER_ID = r100;
            DEFAULT_NEED_MESSAGE_ID = r100;
        }

        @Override // com.squareup.wire.Message
        public Builder newBuilder() {
            Builder r100 = new Builder();
            r100.need_user_info = this.need_user_info;
            r100.need_message_info = this.need_message_info;
            r100.need_user_id = this.need_user_id;
            r100.need_message_id = this.need_message_id;
            r100.addUnknownFields(unknownFields());
            return r100;
        }

        @Override // com.squareup.wire.Message
        public String toString() {
            return RequiredParameters.class.getName() + "@" + Integer.toHexString(hashCode());
        }

        @Override // com.squareup.wire.Message
        public /* bridge */ /* synthetic */ com.squareup.wire.Message.Builder newBuilder() {
            return newBuilder();
        }

        public RequiredParameters(Boolean r100, Boolean r101, Boolean r102, Boolean r110) {
            this(r100, r101, r102, r110, ByteString.EMPTY);
        }

        public RequiredParameters(Boolean r100, Boolean r101, Boolean r102, Boolean r103, ByteString r104) {
            super(ADAPTER, r104);
            this.need_user_info = r100;
            this.need_message_info = r101;
            this.need_user_id = r102;
            this.need_message_id = r103;
        }
    }

    public static final class Url extends com.squareup.wire.Message<Url, Builder> {
        public static final ProtoAdapter<Url> ADAPTER = null;
        public static final String DEFAULT_ANDROID_URL = "";
        public static final String DEFAULT_IOS_URL = "";
        public static final String DEFAULT_PC_URL = "";
        public static final String DEFAULT_URL = "";
        private static final long serialVersionUID = 0;
        public final String android_url;
        public final String ios_url;
        public final String pc_url;
        public final String url;

        public static final class Builder extends com.squareup.wire.Message.Builder<Url, Builder> {
            public String android_url;
            public String ios_url;
            public String pc_url;
            public String url;

            @Override // com.squareup.wire.Message.Builder
            public Url build() {
                return new Url(this.url, this.ios_url, this.android_url, this.pc_url, super.buildUnknownFields());
            }

            public Builder() {
            }

            @Override // com.squareup.wire.Message.Builder
            public /* bridge */ /* synthetic */ com.squareup.wire.Message build() {
                return build();
            }

            public Builder android_url(String r100) {
                this.android_url = r100;
                return this;
            }

            public Builder ios_url(String r100) {
                this.ios_url = r100;
                return this;
            }

            public Builder pc_url(String r100) {
                this.pc_url = r100;
                return this;
            }

            public Builder url(String r100) {
                this.url = r100;
                return this;
            }
        }

        public static final class ProtoAdapter_Url extends ProtoAdapter<Url> {
            public ProtoAdapter_Url() {
                super(FieldEncoding.LENGTH_DELIMITED, Url.class);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.squareup.wire.ProtoAdapter
            public Url decode(ProtoReader r100) throws IOException {
                Builder r101 = new Builder();
                r101.url = "";
                r101.ios_url = "";
                r101.android_url = "";
                r101.pc_url = "";
                long r102 = r100.beginMessage();
            L3:
                int r103 = r100.nextTag();
                if (r103 == (-1)) goto L18;
                if (r103 != 1) goto L8;
                r101.url = ProtoAdapter.STRING.decode(r100);
                goto L3
            L8:
                if (r103 != 2) goto L10;
                r101.ios_url = ProtoAdapter.STRING.decode(r100);
                goto L3
            L10:
                if (r103 != 3) goto L12;
                r101.android_url = ProtoAdapter.STRING.decode(r100);
                goto L3
            L12:
                if (r103 != 4) goto L13;
                r101.pc_url = ProtoAdapter.STRING.decode(r100);
                goto L3
            L13:
                FieldEncoding r104 = r100.peekFieldEncoding();
                r101.addUnknownField(r103, r104, r104.rawProtoAdapter().decode(r100));
                goto L3
            L18:
                r100.endMessage(r102);
                return r101.build();
            }

            /* JADX INFO: renamed from: encodedSize, reason: avoid collision after fix types in other method */
            public int encodedSize2(Url r100) {
                String r101 = r100.url;
                int r102 = 0;
                if (r101 == null) goto L5;
                int r103 = ProtoAdapter.STRING.encodedSizeWithTag(1, r101);
            L6:
                String r104 = r100.ios_url;
                if (r104 == null) goto L9;
                int r105 = ProtoAdapter.STRING.encodedSizeWithTag(2, r104);
            L10:
                int r106 = r103 + r105;
                String r107 = r100.android_url;
                if (r107 == null) goto L13;
                int r108 = ProtoAdapter.STRING.encodedSizeWithTag(3, r107);
            L14:
                int r109 = r106 + r108;
                String r110 = r100.pc_url;
                if (r110 == null) goto L18;
                r102 = ProtoAdapter.STRING.encodedSizeWithTag(4, r110);
            L18:
                return (r109 + r102) + r100.unknownFields().size();
            L13:
                r108 = 0;
                goto L14
            L9:
                r105 = 0;
                goto L10
            L5:
                r103 = 0;
                goto L6
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ Url decode(ProtoReader r100) throws IOException {
                return decode(r100);
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ int encodedSize(Url r100) {
                return encodedSize2(r100);
            }

            /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
            public void encode2(ProtoWriter r100, Url r101) throws IOException {
                String r102 = r101.url;
                if (r102 == null) goto L5;
                ProtoAdapter.STRING.encodeWithTag(r100, 1, r102);
            L5:
                String r103 = r101.ios_url;
                if (r103 == null) goto L8;
                ProtoAdapter.STRING.encodeWithTag(r100, 2, r103);
            L8:
                String r104 = r101.android_url;
                if (r104 == null) goto L11;
                ProtoAdapter.STRING.encodeWithTag(r100, 3, r104);
            L11:
                String r105 = r101.pc_url;
                if (r105 == null) goto L14;
                ProtoAdapter.STRING.encodeWithTag(r100, 4, r105);
            L14:
                r100.writeBytes(r101.unknownFields());
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, Url r101) throws IOException {
                encode2(r100, r101);
            }
        }

        static {
            ADAPTER = new ProtoAdapter_Url();
        }

        @Override // com.squareup.wire.Message
        public Builder newBuilder() {
            Builder r100 = new Builder();
            r100.url = this.url;
            r100.ios_url = this.ios_url;
            r100.android_url = this.android_url;
            r100.pc_url = this.pc_url;
            r100.addUnknownFields(unknownFields());
            return r100;
        }

        @Override // com.squareup.wire.Message
        public String toString() {
            return Url.class.getName() + "@" + Integer.toHexString(hashCode());
        }

        @Override // com.squareup.wire.Message
        public /* bridge */ /* synthetic */ com.squareup.wire.Message.Builder newBuilder() {
            return newBuilder();
        }

        public Url(String r100, String r101, String r102, String r110) {
            this(r100, r101, r102, r110, ByteString.EMPTY);
        }

        public Url(String r100, String r101, String r102, String r103, ByteString r104) {
            super(ADAPTER, r104);
            this.url = r100;
            this.ios_url = r101;
            this.android_url = r102;
            this.pc_url = r103;
        }
    }

    public static final class UserInfo extends com.squareup.wire.Message<UserInfo, Builder> {
        public static final ProtoAdapter<UserInfo> ADAPTER = null;
        public static final String DEFAULT_USER_OPEN_ID = "";
        private static final long serialVersionUID = 0;
        public final String user_open_id;

        public static final class Builder extends com.squareup.wire.Message.Builder<UserInfo, Builder> {
            public String user_open_id;

            @Override // com.squareup.wire.Message.Builder
            public UserInfo build() {
                return new UserInfo(this.user_open_id, super.buildUnknownFields());
            }

            public Builder() {
            }

            @Override // com.squareup.wire.Message.Builder
            public /* bridge */ /* synthetic */ com.squareup.wire.Message build() {
                return build();
            }

            public Builder user_open_id(String r100) {
                this.user_open_id = r100;
                return this;
            }
        }

        public static final class ProtoAdapter_UserInfo extends ProtoAdapter<UserInfo> {
            public ProtoAdapter_UserInfo() {
                super(FieldEncoding.LENGTH_DELIMITED, UserInfo.class);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.squareup.wire.ProtoAdapter
            public UserInfo decode(ProtoReader r100) throws IOException {
                Builder r101 = new Builder();
                r101.user_open_id = "";
                long r102 = r100.beginMessage();
            L3:
                int r103 = r100.nextTag();
                if (r103 == (-1)) goto L9;
                if (r103 != 1) goto L7;
                r101.user_open_id = ProtoAdapter.STRING.decode(r100);
                goto L3
            L7:
                FieldEncoding r104 = r100.peekFieldEncoding();
                r101.addUnknownField(r103, r104, r104.rawProtoAdapter().decode(r100));
                goto L3
            L9:
                r100.endMessage(r102);
                return r101.build();
            }

            /* JADX INFO: renamed from: encodedSize, reason: avoid collision after fix types in other method */
            public int encodedSize2(UserInfo r100) {
                String r101 = r100.user_open_id;
                if (r101 == null) goto L5;
                int r102 = ProtoAdapter.STRING.encodedSizeWithTag(1, r101);
            L7:
                return r102 + r100.unknownFields().size();
            L5:
                r102 = 0;
                goto L7
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ UserInfo decode(ProtoReader r100) throws IOException {
                return decode(r100);
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ int encodedSize(UserInfo r100) {
                return encodedSize2(r100);
            }

            /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
            public void encode2(ProtoWriter r100, UserInfo r101) throws IOException {
                String r102 = r101.user_open_id;
                if (r102 == null) goto L5;
                ProtoAdapter.STRING.encodeWithTag(r100, 1, r102);
            L5:
                r100.writeBytes(r101.unknownFields());
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, UserInfo r101) throws IOException {
                encode2(r100, r101);
            }
        }

        static {
            ADAPTER = new ProtoAdapter_UserInfo();
        }

        @Override // com.squareup.wire.Message
        public Builder newBuilder() {
            Builder r100 = new Builder();
            r100.user_open_id = this.user_open_id;
            r100.addUnknownFields(unknownFields());
            return r100;
        }

        @Override // com.squareup.wire.Message
        public String toString() {
            return UserInfo.class.getName() + "@" + Integer.toHexString(hashCode());
        }

        @Override // com.squareup.wire.Message
        public /* bridge */ /* synthetic */ com.squareup.wire.Message.Builder newBuilder() {
            return newBuilder();
        }

        public UserInfo(String r100) {
            this(r100, ByteString.EMPTY);
        }

        public UserInfo(String r100, ByteString r101) {
            super(ADAPTER, r101);
            this.user_open_id = r100;
        }
    }

    static {
        ADAPTER = new ProtoAdapter_CardAction();
        DEFAULT_METHOD = Method.GET;
        DEFAULT_CMD = 0;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.url = this.url;
        r100.method = this.method;
        r100.required_parameters = this.required_parameters;
        r100.parameters = this.parameters;
        r100.cmd = this.cmd;
        r100.packet = this.packet;
        r100.open_url = this.open_url;
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return CardAction.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ com.squareup.wire.Message.Builder newBuilder() {
        return newBuilder();
    }

    public CardAction(String r110, Method r111, RequiredParameters r112, Parameters r113, Integer r114, CardActionPacket r115, Url r116) {
        this(r110, r111, r112, r113, r114, r115, r116, ByteString.EMPTY);
    }

    public CardAction(String r100, Method r101, RequiredParameters r102, Parameters r103, Integer r104, CardActionPacket r105, Url r106, ByteString r107) {
        super(ADAPTER, r107);
        this.url = r100;
        this.method = r101;
        this.required_parameters = r102;
        this.parameters = r103;
        this.cmd = r104;
        this.packet = r105;
        this.open_url = r106;
    }
}
