package com.bytedance.lark.pb.basic.v1;

import com.alipay.sdk.m.p.e;
import com.squareup.wire.FieldEncoding;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import com.squareup.wire.WireEnum;
import com.squareup.wire.internal.Internal;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import okio.ByteString;
import r27.a;

/* JADX INFO: loaded from: classes20.dex */
public final class UrlPreviewAction extends com.squareup.wire.Message<UrlPreviewAction, Builder> {
    public static final ProtoAdapter<UrlPreviewAction> ADAPTER = null;
    public static final Integer DEFAULT_CMD = null;
    public static final String DEFAULT_FALLBACK_ACTION_ID = "";
    public static final Method DEFAULT_METHOD = null;
    public static final String DEFAULT_URL = "";
    private static final long serialVersionUID = 0;
    public final Integer cmd;
    public final LarkCommandAction command;
    public final String fallback_action_id;
    public final GetAction get;
    public final Method method;
    public final URL open_url;
    public final OpenURLAction open_url_v2;
    public final CardActionPacket packet;
    public final Parameters parameters;
    public final PostAction post;
    public final ShowDialogAction show_dialog;
    public final ShowToastAction show_toast;
    public final SwitchStateAction switch_state;
    public final String url;

    public static final class Builder extends com.squareup.wire.Message.Builder<UrlPreviewAction, Builder> {
        public Integer cmd;
        public LarkCommandAction command;
        public String fallback_action_id;
        public GetAction get;
        public Method method;
        public URL open_url;
        public OpenURLAction open_url_v2;
        public CardActionPacket packet;
        public Parameters parameters;
        public PostAction post;
        public ShowDialogAction show_dialog;
        public ShowToastAction show_toast;
        public SwitchStateAction switch_state;
        public String url;

        @Override // com.squareup.wire.Message.Builder
        public UrlPreviewAction build() {
            String r100 = this.url;
            if (r100 == null) goto L9;
            if (this.method == null) goto L9;
            return new UrlPreviewAction(this.url, this.method, this.parameters, this.cmd, this.packet, this.open_url, this.fallback_action_id, this.get, this.post, this.command, this.open_url_v2, this.switch_state, this.show_toast, this.show_dialog, super.buildUnknownFields());
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

        public Builder command(LarkCommandAction r100) {
            this.command = r100;
            this.get = null;
            this.post = null;
            this.open_url_v2 = null;
            this.switch_state = null;
            this.show_toast = null;
            this.show_dialog = null;
            return this;
        }

        public Builder fallback_action_id(String r100) {
            this.fallback_action_id = r100;
            return this;
        }

        public Builder get(GetAction r100) {
            this.get = r100;
            this.post = null;
            this.command = null;
            this.open_url_v2 = null;
            this.switch_state = null;
            this.show_toast = null;
            this.show_dialog = null;
            return this;
        }

        public Builder method(Method r100) {
            this.method = r100;
            return this;
        }

        public Builder open_url(URL r100) {
            this.open_url = r100;
            return this;
        }

        public Builder open_url_v2(OpenURLAction r100) {
            this.open_url_v2 = r100;
            this.get = null;
            this.post = null;
            this.command = null;
            this.switch_state = null;
            this.show_toast = null;
            this.show_dialog = null;
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

        public Builder post(PostAction r100) {
            this.post = r100;
            this.get = null;
            this.command = null;
            this.open_url_v2 = null;
            this.switch_state = null;
            this.show_toast = null;
            this.show_dialog = null;
            return this;
        }

        public Builder show_dialog(ShowDialogAction r100) {
            this.show_dialog = r100;
            this.get = null;
            this.post = null;
            this.command = null;
            this.open_url_v2 = null;
            this.switch_state = null;
            this.show_toast = null;
            return this;
        }

        public Builder show_toast(ShowToastAction r100) {
            this.show_toast = r100;
            this.get = null;
            this.post = null;
            this.command = null;
            this.open_url_v2 = null;
            this.switch_state = null;
            this.show_dialog = null;
            return this;
        }

        public Builder switch_state(SwitchStateAction r100) {
            this.switch_state = r100;
            this.get = null;
            this.post = null;
            this.command = null;
            this.open_url_v2 = null;
            this.show_toast = null;
            this.show_dialog = null;
            return this;
        }

        public Builder url(String r100) {
            this.url = r100;
            return this;
        }
    }

    public static final class GetAction extends com.squareup.wire.Message<GetAction, Builder> {
        public static final ProtoAdapter<GetAction> ADAPTER = null;
        private static final long serialVersionUID = 0;
        public final Parameters parameters;

        public static final class Builder extends com.squareup.wire.Message.Builder<GetAction, Builder> {
            public Parameters parameters;

            @Override // com.squareup.wire.Message.Builder
            public GetAction build() {
                return new GetAction(this.parameters, super.buildUnknownFields());
            }

            public Builder() {
            }

            @Override // com.squareup.wire.Message.Builder
            public /* bridge */ /* synthetic */ com.squareup.wire.Message build() {
                return build();
            }

            public Builder parameters(Parameters r100) {
                this.parameters = r100;
                return this;
            }
        }

        public static final class ProtoAdapter_GetAction extends ProtoAdapter<GetAction> {
            public ProtoAdapter_GetAction() {
                super(FieldEncoding.LENGTH_DELIMITED, GetAction.class);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.squareup.wire.ProtoAdapter
            public GetAction decode(ProtoReader r100) throws IOException {
                Builder r101 = new Builder();
                long r102 = r100.beginMessage();
            L3:
                int r103 = r100.nextTag();
                if (r103 == (-1)) goto L9;
                if (r103 != 1) goto L7;
                r101.parameters = Parameters.ADAPTER.decode(r100);
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
            public int encodedSize2(GetAction r100) {
                Parameters r101 = r100.parameters;
                if (r101 == null) goto L5;
                int r102 = Parameters.ADAPTER.encodedSizeWithTag(1, r101);
            L7:
                return r102 + r100.unknownFields().size();
            L5:
                r102 = 0;
                goto L7
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ GetAction decode(ProtoReader r100) throws IOException {
                return decode(r100);
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ int encodedSize(GetAction r100) {
                return encodedSize2(r100);
            }

            /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
            public void encode2(ProtoWriter r100, GetAction r101) throws IOException {
                Parameters r102 = r101.parameters;
                if (r102 == null) goto L5;
                Parameters.ADAPTER.encodeWithTag(r100, 1, r102);
            L5:
                r100.writeBytes(r101.unknownFields());
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, GetAction r101) throws IOException {
                encode2(r100, r101);
            }
        }

        static {
            ADAPTER = new ProtoAdapter_GetAction();
        }

        @Override // com.squareup.wire.Message
        public Builder newBuilder() {
            Builder r100 = new Builder();
            r100.parameters = this.parameters;
            r100.addUnknownFields(unknownFields());
            return r100;
        }

        @Override // com.squareup.wire.Message
        public String toString() {
            return GetAction.class.getName() + "@" + Integer.toHexString(hashCode());
        }

        @Override // com.squareup.wire.Message
        public /* bridge */ /* synthetic */ com.squareup.wire.Message.Builder newBuilder() {
            return newBuilder();
        }

        public GetAction(Parameters r100) {
            this(r100, ByteString.EMPTY);
        }

        public GetAction(Parameters r100, ByteString r101) {
            super(ADAPTER, r101);
            this.parameters = r100;
        }
    }

    public static final class LarkCommandAction extends com.squareup.wire.Message<LarkCommandAction, Builder> {
        public static final ProtoAdapter<LarkCommandAction> ADAPTER = null;
        public static final Integer DEFAULT_CMD = null;
        private static final long serialVersionUID = 0;
        public final Integer cmd;
        public final CardActionPacket packet;
        public final Parameters parameters;

        public static final class Builder extends com.squareup.wire.Message.Builder<LarkCommandAction, Builder> {
            public Integer cmd;
            public CardActionPacket packet;
            public Parameters parameters;

            @Override // com.squareup.wire.Message.Builder
            public LarkCommandAction build() {
                return new LarkCommandAction(this.cmd, this.packet, this.parameters, super.buildUnknownFields());
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

            public Builder packet(CardActionPacket r100) {
                this.packet = r100;
                return this;
            }

            public Builder parameters(Parameters r100) {
                this.parameters = r100;
                return this;
            }
        }

        public static final class ProtoAdapter_LarkCommandAction extends ProtoAdapter<LarkCommandAction> {
            public ProtoAdapter_LarkCommandAction() {
                super(FieldEncoding.LENGTH_DELIMITED, LarkCommandAction.class);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.squareup.wire.ProtoAdapter
            public LarkCommandAction decode(ProtoReader r100) throws IOException {
                Builder r101 = new Builder();
                r101.cmd = 0;
                long r102 = r100.beginMessage();
            L3:
                int r103 = r100.nextTag();
                if (r103 == (-1)) goto L15;
                if (r103 != 1) goto L8;
                r101.cmd = ProtoAdapter.INT32.decode(r100);
                goto L3
            L8:
                if (r103 != 2) goto L10;
                r101.packet = CardActionPacket.ADAPTER.decode(r100);
                goto L3
            L10:
                if (r103 != 3) goto L11;
                r101.parameters = Parameters.ADAPTER.decode(r100);
                goto L3
            L11:
                FieldEncoding r104 = r100.peekFieldEncoding();
                r101.addUnknownField(r103, r104, r104.rawProtoAdapter().decode(r100));
                goto L3
            L15:
                r100.endMessage(r102);
                return r101.build();
            }

            /* JADX INFO: renamed from: encodedSize, reason: avoid collision after fix types in other method */
            public int encodedSize2(LarkCommandAction r100) {
                Integer r101 = r100.cmd;
                int r102 = 0;
                if (r101 == null) goto L5;
                int r103 = ProtoAdapter.INT32.encodedSizeWithTag(1, r101);
            L6:
                CardActionPacket r104 = r100.packet;
                if (r104 == null) goto L9;
                int r105 = CardActionPacket.ADAPTER.encodedSizeWithTag(2, r104);
            L10:
                int r106 = r103 + r105;
                Parameters r107 = r100.parameters;
                if (r107 == null) goto L14;
                r102 = Parameters.ADAPTER.encodedSizeWithTag(3, r107);
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
            public /* bridge */ /* synthetic */ LarkCommandAction decode(ProtoReader r100) throws IOException {
                return decode(r100);
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ int encodedSize(LarkCommandAction r100) {
                return encodedSize2(r100);
            }

            /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
            public void encode2(ProtoWriter r100, LarkCommandAction r101) throws IOException {
                Integer r102 = r101.cmd;
                if (r102 == null) goto L5;
                ProtoAdapter.INT32.encodeWithTag(r100, 1, r102);
            L5:
                CardActionPacket r103 = r101.packet;
                if (r103 == null) goto L8;
                CardActionPacket.ADAPTER.encodeWithTag(r100, 2, r103);
            L8:
                Parameters r104 = r101.parameters;
                if (r104 == null) goto L11;
                Parameters.ADAPTER.encodeWithTag(r100, 3, r104);
            L11:
                r100.writeBytes(r101.unknownFields());
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, LarkCommandAction r101) throws IOException {
                encode2(r100, r101);
            }
        }

        static {
            ADAPTER = new ProtoAdapter_LarkCommandAction();
            DEFAULT_CMD = 0;
        }

        @Override // com.squareup.wire.Message
        public Builder newBuilder() {
            Builder r100 = new Builder();
            r100.cmd = this.cmd;
            r100.packet = this.packet;
            r100.parameters = this.parameters;
            r100.addUnknownFields(unknownFields());
            return r100;
        }

        @Override // com.squareup.wire.Message
        public String toString() {
            return LarkCommandAction.class.getName() + "@" + Integer.toHexString(hashCode());
        }

        @Override // com.squareup.wire.Message
        public /* bridge */ /* synthetic */ com.squareup.wire.Message.Builder newBuilder() {
            return newBuilder();
        }

        public LarkCommandAction(Integer r100, CardActionPacket r101, Parameters r102) {
            this(r100, r101, r102, ByteString.EMPTY);
        }

        public LarkCommandAction(Integer r100, CardActionPacket r101, Parameters r102, ByteString r103) {
            super(ADAPTER, r103);
            this.cmd = r100;
            this.packet = r101;
            this.parameters = r102;
        }
    }

    public static final enum Method extends Enum<Method> implements WireEnum {
        private static final /* synthetic */ Method[] $VALUES = null;
        public static final ProtoAdapter<Method> ADAPTER = null;
        public static final Method GET = null;
        public static final Method LARK_COMMAND = null;
        public static final Method OPEN_URL = null;
        public static final Method POST = null;
        public static final Method SHOW_DIALOG = null;
        public static final Method SHOW_TOAST = null;
        public static final Method SWITCH_STATE = null;
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
            Method r104 = new Method("SWITCH_STATE", 4, 5);
            SWITCH_STATE = r104;
            Method r110 = new Method("SHOW_TOAST", 5, 6);
            SHOW_TOAST = r110;
            Method r111 = new Method("SHOW_DIALOG", 6, 7);
            SHOW_DIALOG = r111;
            $VALUES = new Method[]{r100, r101, r102, r103, r104, r110, r111};
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
            switch(r100) {
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
            return SHOW_DIALOG;
        L8:
            return SHOW_TOAST;
        L10:
            return SWITCH_STATE;
        L12:
            return OPEN_URL;
        L14:
            return LARK_COMMAND;
        L16:
            return POST;
        L18:
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

    public static final class OpenURLAction extends com.squareup.wire.Message<OpenURLAction, Builder> {
        public static final ProtoAdapter<OpenURLAction> ADAPTER = null;
        private static final long serialVersionUID = 0;
        public final URL open_url;

        public static final class Builder extends com.squareup.wire.Message.Builder<OpenURLAction, Builder> {
            public URL open_url;

            @Override // com.squareup.wire.Message.Builder
            public OpenURLAction build() {
                return new OpenURLAction(this.open_url, super.buildUnknownFields());
            }

            public Builder() {
            }

            @Override // com.squareup.wire.Message.Builder
            public /* bridge */ /* synthetic */ com.squareup.wire.Message build() {
                return build();
            }

            public Builder open_url(URL r100) {
                this.open_url = r100;
                return this;
            }
        }

        public static final class ProtoAdapter_OpenURLAction extends ProtoAdapter<OpenURLAction> {
            public ProtoAdapter_OpenURLAction() {
                super(FieldEncoding.LENGTH_DELIMITED, OpenURLAction.class);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.squareup.wire.ProtoAdapter
            public OpenURLAction decode(ProtoReader r100) throws IOException {
                Builder r101 = new Builder();
                long r102 = r100.beginMessage();
            L3:
                int r103 = r100.nextTag();
                if (r103 == (-1)) goto L9;
                if (r103 != 1) goto L7;
                r101.open_url = URL.ADAPTER.decode(r100);
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
            public int encodedSize2(OpenURLAction r100) {
                URL r101 = r100.open_url;
                if (r101 == null) goto L5;
                int r102 = URL.ADAPTER.encodedSizeWithTag(1, r101);
            L7:
                return r102 + r100.unknownFields().size();
            L5:
                r102 = 0;
                goto L7
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ OpenURLAction decode(ProtoReader r100) throws IOException {
                return decode(r100);
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ int encodedSize(OpenURLAction r100) {
                return encodedSize2(r100);
            }

            /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
            public void encode2(ProtoWriter r100, OpenURLAction r101) throws IOException {
                URL r102 = r101.open_url;
                if (r102 == null) goto L5;
                URL.ADAPTER.encodeWithTag(r100, 1, r102);
            L5:
                r100.writeBytes(r101.unknownFields());
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, OpenURLAction r101) throws IOException {
                encode2(r100, r101);
            }
        }

        static {
            ADAPTER = new ProtoAdapter_OpenURLAction();
        }

        @Override // com.squareup.wire.Message
        public Builder newBuilder() {
            Builder r100 = new Builder();
            r100.open_url = this.open_url;
            r100.addUnknownFields(unknownFields());
            return r100;
        }

        @Override // com.squareup.wire.Message
        public String toString() {
            return OpenURLAction.class.getName() + "@" + Integer.toHexString(hashCode());
        }

        @Override // com.squareup.wire.Message
        public /* bridge */ /* synthetic */ com.squareup.wire.Message.Builder newBuilder() {
            return newBuilder();
        }

        public OpenURLAction(URL r100) {
            this(r100, ByteString.EMPTY);
        }

        public OpenURLAction(URL r100, ByteString r101) {
            super(ADAPTER, r101);
            this.open_url = r100;
        }
    }

    public static final class Parameters extends com.squareup.wire.Message<Parameters, Builder> {
        public static final ProtoAdapter<Parameters> ADAPTER = null;
        public static final String DEFAULT_PREVIEW_ID = "";
        public static final String DEFAULT_SOURCE_ID = "";
        public static final String DEFAULT_USER_ID = "";
        private static final long serialVersionUID = 0;
        public final Map<String, String> parameters;
        public final String preview_id;
        public final String source_id;
        public final String user_id;

        public static final class Builder extends com.squareup.wire.Message.Builder<Parameters, Builder> {
            public Map<String, String> parameters;
            public String preview_id;
            public String source_id;
            public String user_id;

            @Override // com.squareup.wire.Message.Builder
            public Parameters build() {
                return new Parameters(this.parameters, this.user_id, this.source_id, this.preview_id, super.buildUnknownFields());
            }

            public Builder() {
                this.parameters = Internal.newMutableMap();
            }

            @Override // com.squareup.wire.Message.Builder
            public /* bridge */ /* synthetic */ com.squareup.wire.Message build() {
                return build();
            }

            public Builder parameters(Map<String, String> r100) {
                Internal.checkElementsNotNull(r100);
                this.parameters = r100;
                return this;
            }

            public Builder preview_id(String r100) {
                this.preview_id = r100;
                return this;
            }

            public Builder source_id(String r100) {
                this.source_id = r100;
                return this;
            }

            public Builder user_id(String r100) {
                this.user_id = r100;
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
                r101.source_id = "";
                r101.preview_id = "";
                long r102 = r100.beginMessage();
            L3:
                int r103 = r100.nextTag();
                if (r103 == (-1)) goto L18;
                if (r103 != 1) goto L8;
                r101.parameters.putAll(this.parameters.decode(r100));
                goto L3
            L8:
                if (r103 != 2) goto L10;
                r101.user_id = ProtoAdapter.STRING.decode(r100);
                goto L3
            L10:
                if (r103 != 3) goto L12;
                r101.source_id = ProtoAdapter.STRING.decode(r100);
                goto L3
            L12:
                if (r103 != 4) goto L13;
                r101.preview_id = ProtoAdapter.STRING.decode(r100);
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
            public int encodedSize2(Parameters r100) {
                int r101 = this.parameters.encodedSizeWithTag(1, r100.parameters);
                String r102 = r100.user_id;
                int r103 = 0;
                if (r102 == null) goto L5;
                int r104 = ProtoAdapter.STRING.encodedSizeWithTag(2, r102);
            L6:
                int r105 = r101 + r104;
                String r106 = r100.source_id;
                if (r106 == null) goto L9;
                int r107 = ProtoAdapter.STRING.encodedSizeWithTag(3, r106);
            L10:
                int r108 = r105 + r107;
                String r109 = r100.preview_id;
                if (r109 == null) goto L14;
                r103 = ProtoAdapter.STRING.encodedSizeWithTag(4, r109);
            L14:
                return (r108 + r103) + r100.unknownFields().size();
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
                String r102 = r101.user_id;
                if (r102 == null) goto L5;
                ProtoAdapter.STRING.encodeWithTag(r100, 2, r102);
            L5:
                String r103 = r101.source_id;
                if (r103 == null) goto L8;
                ProtoAdapter.STRING.encodeWithTag(r100, 3, r103);
            L8:
                String r104 = r101.preview_id;
                if (r104 == null) goto L11;
                ProtoAdapter.STRING.encodeWithTag(r100, 4, r104);
            L11:
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
            r100.user_id = this.user_id;
            r100.source_id = this.source_id;
            r100.preview_id = this.preview_id;
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

        public Parameters(Map<String, String> r100, String r101, String r102, String r110) {
            this(r100, r101, r102, r110, ByteString.EMPTY);
        }

        public Parameters(Map<String, String> r100, String r101, String r102, String r103, ByteString r104) {
            super(ADAPTER, r104);
            this.parameters = Internal.immutableCopyOf("parameters", r100);
            this.user_id = r101;
            this.source_id = r102;
            this.preview_id = r103;
        }
    }

    public static final class PostAction extends com.squareup.wire.Message<PostAction, Builder> {
        public static final ProtoAdapter<PostAction> ADAPTER = null;
        private static final long serialVersionUID = 0;
        public final Parameters parameters;

        public static final class Builder extends com.squareup.wire.Message.Builder<PostAction, Builder> {
            public Parameters parameters;

            @Override // com.squareup.wire.Message.Builder
            public PostAction build() {
                return new PostAction(this.parameters, super.buildUnknownFields());
            }

            public Builder() {
            }

            @Override // com.squareup.wire.Message.Builder
            public /* bridge */ /* synthetic */ com.squareup.wire.Message build() {
                return build();
            }

            public Builder parameters(Parameters r100) {
                this.parameters = r100;
                return this;
            }
        }

        public static final class ProtoAdapter_PostAction extends ProtoAdapter<PostAction> {
            public ProtoAdapter_PostAction() {
                super(FieldEncoding.LENGTH_DELIMITED, PostAction.class);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.squareup.wire.ProtoAdapter
            public PostAction decode(ProtoReader r100) throws IOException {
                Builder r101 = new Builder();
                long r102 = r100.beginMessage();
            L3:
                int r103 = r100.nextTag();
                if (r103 == (-1)) goto L9;
                if (r103 != 1) goto L7;
                r101.parameters = Parameters.ADAPTER.decode(r100);
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
            public int encodedSize2(PostAction r100) {
                Parameters r101 = r100.parameters;
                if (r101 == null) goto L5;
                int r102 = Parameters.ADAPTER.encodedSizeWithTag(1, r101);
            L7:
                return r102 + r100.unknownFields().size();
            L5:
                r102 = 0;
                goto L7
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ PostAction decode(ProtoReader r100) throws IOException {
                return decode(r100);
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ int encodedSize(PostAction r100) {
                return encodedSize2(r100);
            }

            /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
            public void encode2(ProtoWriter r100, PostAction r101) throws IOException {
                Parameters r102 = r101.parameters;
                if (r102 == null) goto L5;
                Parameters.ADAPTER.encodeWithTag(r100, 1, r102);
            L5:
                r100.writeBytes(r101.unknownFields());
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, PostAction r101) throws IOException {
                encode2(r100, r101);
            }
        }

        static {
            ADAPTER = new ProtoAdapter_PostAction();
        }

        @Override // com.squareup.wire.Message
        public Builder newBuilder() {
            Builder r100 = new Builder();
            r100.parameters = this.parameters;
            r100.addUnknownFields(unknownFields());
            return r100;
        }

        @Override // com.squareup.wire.Message
        public String toString() {
            return PostAction.class.getName() + "@" + Integer.toHexString(hashCode());
        }

        @Override // com.squareup.wire.Message
        public /* bridge */ /* synthetic */ com.squareup.wire.Message.Builder newBuilder() {
            return newBuilder();
        }

        public PostAction(Parameters r100) {
            this(r100, ByteString.EMPTY);
        }

        public PostAction(Parameters r100, ByteString r101) {
            super(ADAPTER, r101);
            this.parameters = r100;
        }
    }

    public static final class ProtoAdapter_UrlPreviewAction extends ProtoAdapter<UrlPreviewAction> {
        public ProtoAdapter_UrlPreviewAction() {
            super(FieldEncoding.LENGTH_DELIMITED, UrlPreviewAction.class);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public UrlPreviewAction decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            r101.url = "";
            r101.method = Method.GET;
            r101.cmd = 0;
            r101.fallback_action_id = "";
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L25;
            switch(r103) {
                case 1: goto L24;
                case 2: goto L27;
                case 3: goto L19;
                case 4: goto L18;
                case 5: goto L17;
                case 6: goto L16;
                case 7: goto L15;
                default: goto L6;
            };
        L27:
            r101.method = Method.ADAPTER.decode(r100);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L22
        L22:
            e = move-exception;
            r101.addUnknownField(r103, FieldEncoding.VARINT, Long.valueOf(e.value));
            goto L3
        L15:
            r101.fallback_action_id = ProtoAdapter.STRING.decode(r100);
            goto L3
        L16:
            r101.open_url = URL.ADAPTER.decode(r100);
            goto L3
        L17:
            r101.packet = CardActionPacket.ADAPTER.decode(r100);
            goto L3
        L18:
            r101.cmd = ProtoAdapter.INT32.decode(r100);
            goto L3
        L19:
            r101.parameters = Parameters.ADAPTER.decode(r100);
            goto L3
        L24:
            r101.url = ProtoAdapter.STRING.decode(r100);
            goto L3
        L6:
            switch(r103) {
                case 1000: goto L14;
                case 1001: goto L13;
                case 1002: goto L12;
                case 1003: goto L11;
                case 1004: goto L10;
                case 1005: goto L9;
                case 1006: goto L8;
                default: goto L7;
            };
        L8:
            r101.show_dialog(ShowDialogAction.ADAPTER.decode(r100));
            goto L3
        L9:
            r101.show_toast(ShowToastAction.ADAPTER.decode(r100));
            goto L3
        L10:
            r101.switch_state(SwitchStateAction.ADAPTER.decode(r100));
            goto L3
        L11:
            r101.open_url_v2(OpenURLAction.ADAPTER.decode(r100));
            goto L3
        L12:
            r101.command(LarkCommandAction.ADAPTER.decode(r100));
            goto L3
        L13:
            r101.post(PostAction.ADAPTER.decode(r100));
            goto L3
        L14:
            r101.get(GetAction.ADAPTER.decode(r100));
            goto L3
        L7:
            FieldEncoding r104 = r100.peekFieldEncoding();
            r101.addUnknownField(r103, r104, r104.rawProtoAdapter().decode(r100));
            goto L3
        L25:
            r100.endMessage(r102);
            return r101.build();
        }

        /* JADX INFO: renamed from: encodedSize, reason: avoid collision after fix types in other method */
        public int encodedSize2(UrlPreviewAction r100) {
            ProtoAdapter<String> r101 = ProtoAdapter.STRING;
            int r102 = r101.encodedSizeWithTag(1, r100.url) + Method.ADAPTER.encodedSizeWithTag(2, r100.method);
            Parameters r103 = r100.parameters;
            int r104 = 0;
            if (r103 == null) goto L5;
            int r105 = Parameters.ADAPTER.encodedSizeWithTag(3, r103);
        L6:
            int r106 = r102 + r105;
            Integer r107 = r100.cmd;
            if (r107 == null) goto L9;
            int r108 = ProtoAdapter.INT32.encodedSizeWithTag(4, r107);
        L10:
            int r109 = r106 + r108;
            CardActionPacket r110 = r100.packet;
            if (r110 == null) goto L13;
            int r111 = CardActionPacket.ADAPTER.encodedSizeWithTag(5, r110);
        L14:
            int r112 = r109 + r111;
            URL r113 = r100.open_url;
            if (r113 == null) goto L17;
            int r114 = URL.ADAPTER.encodedSizeWithTag(6, r113);
        L18:
            int r115 = r112 + r114;
            String r116 = r100.fallback_action_id;
            if (r116 == null) goto L21;
            int r117 = r101.encodedSizeWithTag(7, r116);
        L22:
            int r118 = r115 + r117;
            GetAction r119 = r100.get;
            if (r119 == null) goto L25;
            int r120 = GetAction.ADAPTER.encodedSizeWithTag(1000, r119);
        L26:
            int r121 = r118 + r120;
            PostAction r122 = r100.post;
            if (r122 == null) goto L29;
            int r123 = PostAction.ADAPTER.encodedSizeWithTag(1001, r122);
        L30:
            int r124 = r121 + r123;
            LarkCommandAction r125 = r100.command;
            if (r125 == null) goto L33;
            int r126 = LarkCommandAction.ADAPTER.encodedSizeWithTag(1002, r125);
        L34:
            int r127 = r124 + r126;
            OpenURLAction r128 = r100.open_url_v2;
            if (r128 == null) goto L37;
            int r129 = OpenURLAction.ADAPTER.encodedSizeWithTag(1003, r128);
        L38:
            int r130 = r127 + r129;
            SwitchStateAction r131 = r100.switch_state;
            if (r131 == null) goto L41;
            int r132 = SwitchStateAction.ADAPTER.encodedSizeWithTag(1004, r131);
        L42:
            int r133 = r130 + r132;
            ShowToastAction r134 = r100.show_toast;
            if (r134 == null) goto L45;
            int r135 = ShowToastAction.ADAPTER.encodedSizeWithTag(1005, r134);
        L46:
            int r136 = r133 + r135;
            ShowDialogAction r137 = r100.show_dialog;
            if (r137 == null) goto L50;
            r104 = ShowDialogAction.ADAPTER.encodedSizeWithTag(1006, r137);
        L50:
            return (r136 + r104) + r100.unknownFields().size();
        L45:
            r135 = 0;
            goto L46
        L41:
            r132 = 0;
            goto L42
        L37:
            r129 = 0;
            goto L38
        L33:
            r126 = 0;
            goto L34
        L29:
            r123 = 0;
            goto L30
        L25:
            r120 = 0;
            goto L26
        L21:
            r117 = 0;
            goto L22
        L17:
            r114 = 0;
            goto L18
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
        public /* bridge */ /* synthetic */ UrlPreviewAction decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(UrlPreviewAction r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, UrlPreviewAction r101) throws IOException {
            ProtoAdapter<String> r102 = ProtoAdapter.STRING;
            r102.encodeWithTag(r100, 1, r101.url);
            Method.ADAPTER.encodeWithTag(r100, 2, r101.method);
            Parameters r103 = r101.parameters;
            if (r103 == null) goto L5;
            Parameters.ADAPTER.encodeWithTag(r100, 3, r103);
        L5:
            Integer r104 = r101.cmd;
            if (r104 == null) goto L8;
            ProtoAdapter.INT32.encodeWithTag(r100, 4, r104);
        L8:
            CardActionPacket r105 = r101.packet;
            if (r105 == null) goto L11;
            CardActionPacket.ADAPTER.encodeWithTag(r100, 5, r105);
        L11:
            URL r106 = r101.open_url;
            if (r106 == null) goto L14;
            URL.ADAPTER.encodeWithTag(r100, 6, r106);
        L14:
            String r107 = r101.fallback_action_id;
            if (r107 == null) goto L17;
            r102.encodeWithTag(r100, 7, r107);
        L17:
            GetAction r108 = r101.get;
            if (r108 == null) goto L20;
            GetAction.ADAPTER.encodeWithTag(r100, 1000, r108);
        L20:
            PostAction r109 = r101.post;
            if (r109 == null) goto L23;
            PostAction.ADAPTER.encodeWithTag(r100, 1001, r109);
        L23:
            LarkCommandAction r110 = r101.command;
            if (r110 == null) goto L26;
            LarkCommandAction.ADAPTER.encodeWithTag(r100, 1002, r110);
        L26:
            OpenURLAction r111 = r101.open_url_v2;
            if (r111 == null) goto L29;
            OpenURLAction.ADAPTER.encodeWithTag(r100, 1003, r111);
        L29:
            SwitchStateAction r112 = r101.switch_state;
            if (r112 == null) goto L32;
            SwitchStateAction.ADAPTER.encodeWithTag(r100, 1004, r112);
        L32:
            ShowToastAction r113 = r101.show_toast;
            if (r113 == null) goto L35;
            ShowToastAction.ADAPTER.encodeWithTag(r100, 1005, r113);
        L35:
            ShowDialogAction r114 = r101.show_dialog;
            if (r114 == null) goto L38;
            ShowDialogAction.ADAPTER.encodeWithTag(r100, 1006, r114);
        L38:
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, UrlPreviewAction r101) throws IOException {
            encode2(r100, r101);
        }
    }

    public static final class ShowDialogAction extends com.squareup.wire.Message<ShowDialogAction, Builder> {
        public static final ProtoAdapter<ShowDialogAction> ADAPTER = null;
        private static final long serialVersionUID = 0;
        public final List<DialogButton> buttons;
        public final DialogItem content;
        public final DialogItem title;

        public static final class Builder extends com.squareup.wire.Message.Builder<ShowDialogAction, Builder> {
            public List<DialogButton> buttons;
            public DialogItem content;
            public DialogItem title;

            @Override // com.squareup.wire.Message.Builder
            public ShowDialogAction build() {
                return new ShowDialogAction(this.title, this.content, this.buttons, super.buildUnknownFields());
            }

            public Builder() {
                this.buttons = Internal.newMutableList();
            }

            @Override // com.squareup.wire.Message.Builder
            public /* bridge */ /* synthetic */ com.squareup.wire.Message build() {
                return build();
            }

            public Builder buttons(List<DialogButton> r100) {
                Internal.checkElementsNotNull(r100);
                this.buttons = r100;
                return this;
            }

            public Builder content(DialogItem r100) {
                this.content = r100;
                return this;
            }

            public Builder title(DialogItem r100) {
                this.title = r100;
                return this;
            }
        }

        public static final class DialogButton extends com.squareup.wire.Message<DialogButton, Builder> {
            public static final ProtoAdapter<DialogButton> ADAPTER = null;
            public static final String DEFAULT_ACTION_ID = "";
            public static final String DEFAULT_TEXT = "";
            public static final DialogButtonType DEFAULT_TYPE = null;
            private static final long serialVersionUID = 0;
            public final String action_id;
            public final String text;
            public final DialogButtonType type;

            public static final class Builder extends com.squareup.wire.Message.Builder<DialogButton, Builder> {
                public String action_id;
                public String text;
                public DialogButtonType type;

                @Override // com.squareup.wire.Message.Builder
                public DialogButton build() {
                    return new DialogButton(this.text, this.type, this.action_id, super.buildUnknownFields());
                }

                public Builder() {
                }

                @Override // com.squareup.wire.Message.Builder
                public /* bridge */ /* synthetic */ com.squareup.wire.Message build() {
                    return build();
                }

                public Builder action_id(String r100) {
                    this.action_id = r100;
                    return this;
                }

                public Builder text(String r100) {
                    this.text = r100;
                    return this;
                }

                public Builder type(DialogButtonType r100) {
                    this.type = r100;
                    return this;
                }
            }

            public static final class ProtoAdapter_DialogButton extends ProtoAdapter<DialogButton> {
                public ProtoAdapter_DialogButton() {
                    super(FieldEncoding.LENGTH_DELIMITED, DialogButton.class);
                }

                /* JADX WARN: Can't rename method to resolve collision */
                @Override // com.squareup.wire.ProtoAdapter
                public DialogButton decode(ProtoReader r100) throws IOException {
                    Builder r101 = new Builder();
                    r101.text = "";
                    r101.type = DialogButtonType.DEFAULT;
                    r101.action_id = "";
                    long r102 = r100.beginMessage();
                L3:
                    int r103 = r100.nextTag();
                    if (r103 == (-1)) goto L18;
                    if (r103 != 1) goto L8;
                    r101.text = ProtoAdapter.STRING.decode(r100);
                    goto L3
                L8:
                    if (r103 != 2) goto L10;
                    r101.type = DialogButtonType.ADAPTER.decode(r100);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L15
                L15:
                    e = move-exception;
                    r101.addUnknownField(r103, FieldEncoding.VARINT, Long.valueOf(e.value));
                    goto L3
                L10:
                    if (r103 != 3) goto L11;
                    r101.action_id = ProtoAdapter.STRING.decode(r100);
                    goto L3
                L11:
                    FieldEncoding r104 = r100.peekFieldEncoding();
                    r101.addUnknownField(r103, r104, r104.rawProtoAdapter().decode(r100));
                    goto L3
                L18:
                    r100.endMessage(r102);
                    return r101.build();
                }

                /* JADX INFO: renamed from: encodedSize, reason: avoid collision after fix types in other method */
                public int encodedSize2(DialogButton r100) {
                    String r101 = r100.text;
                    int r102 = 0;
                    if (r101 == null) goto L5;
                    int r103 = ProtoAdapter.STRING.encodedSizeWithTag(1, r101);
                L6:
                    DialogButtonType r104 = r100.type;
                    if (r104 == null) goto L9;
                    int r105 = DialogButtonType.ADAPTER.encodedSizeWithTag(2, r104);
                L10:
                    int r106 = r103 + r105;
                    String r107 = r100.action_id;
                    if (r107 == null) goto L14;
                    r102 = ProtoAdapter.STRING.encodedSizeWithTag(3, r107);
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
                public /* bridge */ /* synthetic */ DialogButton decode(ProtoReader r100) throws IOException {
                    return decode(r100);
                }

                @Override // com.squareup.wire.ProtoAdapter
                public /* bridge */ /* synthetic */ int encodedSize(DialogButton r100) {
                    return encodedSize2(r100);
                }

                /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
                public void encode2(ProtoWriter r100, DialogButton r101) throws IOException {
                    String r102 = r101.text;
                    if (r102 == null) goto L5;
                    ProtoAdapter.STRING.encodeWithTag(r100, 1, r102);
                L5:
                    DialogButtonType r103 = r101.type;
                    if (r103 == null) goto L8;
                    DialogButtonType.ADAPTER.encodeWithTag(r100, 2, r103);
                L8:
                    String r104 = r101.action_id;
                    if (r104 == null) goto L11;
                    ProtoAdapter.STRING.encodeWithTag(r100, 3, r104);
                L11:
                    r100.writeBytes(r101.unknownFields());
                }

                @Override // com.squareup.wire.ProtoAdapter
                public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, DialogButton r101) throws IOException {
                    encode2(r100, r101);
                }
            }

            static {
                ADAPTER = new ProtoAdapter_DialogButton();
                DEFAULT_TYPE = DialogButtonType.DEFAULT;
            }

            @Override // com.squareup.wire.Message
            public Builder newBuilder() {
                Builder r100 = new Builder();
                r100.text = this.text;
                r100.type = this.type;
                r100.action_id = this.action_id;
                r100.addUnknownFields(unknownFields());
                return r100;
            }

            @Override // com.squareup.wire.Message
            public String toString() {
                return DialogButton.class.getName() + "@" + Integer.toHexString(hashCode());
            }

            @Override // com.squareup.wire.Message
            public /* bridge */ /* synthetic */ com.squareup.wire.Message.Builder newBuilder() {
                return newBuilder();
            }

            public DialogButton(String r100, DialogButtonType r101, String r102) {
                this(r100, r101, r102, ByteString.EMPTY);
            }

            public DialogButton(String r100, DialogButtonType r101, String r102, ByteString r103) {
                super(ADAPTER, r103);
                this.text = r100;
                this.type = r101;
                this.action_id = r102;
            }
        }

        public static final enum DialogButtonType extends Enum<DialogButtonType> implements WireEnum {
            private static final /* synthetic */ DialogButtonType[] $VALUES = null;
            public static final ProtoAdapter<DialogButtonType> ADAPTER = null;
            public static final DialogButtonType DANGER = null;
            public static final DialogButtonType DEFAULT = null;
            public static final DialogButtonType PRIMARY = null;
            private final int value;

            static {
                DialogButtonType r100 = new DialogButtonType("DEFAULT", 0, 0);
                DEFAULT = r100;
                DialogButtonType r101 = new DialogButtonType("PRIMARY", 1, 1);
                PRIMARY = r101;
                DialogButtonType r102 = new DialogButtonType("DANGER", 2, 2);
                DANGER = r102;
                $VALUES = new DialogButtonType[]{r100, r101, r102};
                ADAPTER = ProtoAdapter.newEnumAdapter(DialogButtonType.class);
            }

            public static DialogButtonType[] values() {
                return (DialogButtonType[]) $VALUES.clone();
            }

            @Override // com.squareup.wire.WireEnum
            public final int getValue() {
                return this.value;
            }

            public static DialogButtonType fromValue(int r100) {
                if (r100 == 0) goto L14;
                if (r100 == 1) goto L12;
                if (r100 == 2) goto L10;
                return null;
            L10:
                return DANGER;
            L12:
                return PRIMARY;
            L14:
                return DEFAULT;
            }

            public static DialogButtonType valueOf(String r100) {
                return (DialogButtonType) a.a(DialogButtonType.class, r100);
            }

            private DialogButtonType(String r100, int r101, int r102) {
                super(r100, r101);
                this.value = r102;
            }
        }

        public static final class DialogItem extends com.squareup.wire.Message<DialogItem, Builder> {
            public static final ProtoAdapter<DialogItem> ADAPTER = null;
            public static final Integer DEFAULT_NUMBER_OF_LINES = null;
            public static final String DEFAULT_TEXT = "";
            private static final long serialVersionUID = 0;
            public final Integer number_of_lines;
            public final String text;

            public static final class Builder extends com.squareup.wire.Message.Builder<DialogItem, Builder> {
                public Integer number_of_lines;
                public String text;

                @Override // com.squareup.wire.Message.Builder
                public DialogItem build() {
                    return new DialogItem(this.text, this.number_of_lines, super.buildUnknownFields());
                }

                public Builder() {
                }

                @Override // com.squareup.wire.Message.Builder
                public /* bridge */ /* synthetic */ com.squareup.wire.Message build() {
                    return build();
                }

                public Builder number_of_lines(Integer r100) {
                    this.number_of_lines = r100;
                    return this;
                }

                public Builder text(String r100) {
                    this.text = r100;
                    return this;
                }
            }

            public static final class ProtoAdapter_DialogItem extends ProtoAdapter<DialogItem> {
                public ProtoAdapter_DialogItem() {
                    super(FieldEncoding.LENGTH_DELIMITED, DialogItem.class);
                }

                /* JADX WARN: Can't rename method to resolve collision */
                @Override // com.squareup.wire.ProtoAdapter
                public DialogItem decode(ProtoReader r100) throws IOException {
                    Builder r101 = new Builder();
                    r101.text = "";
                    r101.number_of_lines = 0;
                    long r102 = r100.beginMessage();
                L3:
                    int r103 = r100.nextTag();
                    if (r103 == (-1)) goto L12;
                    if (r103 != 1) goto L8;
                    r101.text = ProtoAdapter.STRING.decode(r100);
                    goto L3
                L8:
                    if (r103 != 2) goto L9;
                    r101.number_of_lines = ProtoAdapter.INT32.decode(r100);
                    goto L3
                L9:
                    FieldEncoding r104 = r100.peekFieldEncoding();
                    r101.addUnknownField(r103, r104, r104.rawProtoAdapter().decode(r100));
                    goto L3
                L12:
                    r100.endMessage(r102);
                    return r101.build();
                }

                /* JADX INFO: renamed from: encodedSize, reason: avoid collision after fix types in other method */
                public int encodedSize2(DialogItem r100) {
                    String r101 = r100.text;
                    int r102 = 0;
                    if (r101 == null) goto L5;
                    int r103 = ProtoAdapter.STRING.encodedSizeWithTag(1, r101);
                L6:
                    Integer r104 = r100.number_of_lines;
                    if (r104 == null) goto L10;
                    r102 = ProtoAdapter.INT32.encodedSizeWithTag(2, r104);
                L10:
                    return (r103 + r102) + r100.unknownFields().size();
                L5:
                    r103 = 0;
                    goto L6
                }

                @Override // com.squareup.wire.ProtoAdapter
                public /* bridge */ /* synthetic */ DialogItem decode(ProtoReader r100) throws IOException {
                    return decode(r100);
                }

                @Override // com.squareup.wire.ProtoAdapter
                public /* bridge */ /* synthetic */ int encodedSize(DialogItem r100) {
                    return encodedSize2(r100);
                }

                /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
                public void encode2(ProtoWriter r100, DialogItem r101) throws IOException {
                    String r102 = r101.text;
                    if (r102 == null) goto L5;
                    ProtoAdapter.STRING.encodeWithTag(r100, 1, r102);
                L5:
                    Integer r103 = r101.number_of_lines;
                    if (r103 == null) goto L8;
                    ProtoAdapter.INT32.encodeWithTag(r100, 2, r103);
                L8:
                    r100.writeBytes(r101.unknownFields());
                }

                @Override // com.squareup.wire.ProtoAdapter
                public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, DialogItem r101) throws IOException {
                    encode2(r100, r101);
                }
            }

            static {
                ADAPTER = new ProtoAdapter_DialogItem();
                DEFAULT_NUMBER_OF_LINES = 0;
            }

            @Override // com.squareup.wire.Message
            public Builder newBuilder() {
                Builder r100 = new Builder();
                r100.text = this.text;
                r100.number_of_lines = this.number_of_lines;
                r100.addUnknownFields(unknownFields());
                return r100;
            }

            @Override // com.squareup.wire.Message
            public String toString() {
                return DialogItem.class.getName() + "@" + Integer.toHexString(hashCode());
            }

            @Override // com.squareup.wire.Message
            public /* bridge */ /* synthetic */ com.squareup.wire.Message.Builder newBuilder() {
                return newBuilder();
            }

            public DialogItem(String r100, Integer r101) {
                this(r100, r101, ByteString.EMPTY);
            }

            public DialogItem(String r100, Integer r101, ByteString r102) {
                super(ADAPTER, r102);
                this.text = r100;
                this.number_of_lines = r101;
            }
        }

        public static final class ProtoAdapter_ShowDialogAction extends ProtoAdapter<ShowDialogAction> {
            public ProtoAdapter_ShowDialogAction() {
                super(FieldEncoding.LENGTH_DELIMITED, ShowDialogAction.class);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.squareup.wire.ProtoAdapter
            public ShowDialogAction decode(ProtoReader r100) throws IOException {
                Builder r101 = new Builder();
                long r102 = r100.beginMessage();
            L3:
                int r103 = r100.nextTag();
                if (r103 == (-1)) goto L15;
                if (r103 != 1) goto L8;
                r101.title = DialogItem.ADAPTER.decode(r100);
                goto L3
            L8:
                if (r103 != 2) goto L10;
                r101.content = DialogItem.ADAPTER.decode(r100);
                goto L3
            L10:
                if (r103 != 3) goto L11;
                r101.buttons.add(DialogButton.ADAPTER.decode(r100));
                goto L3
            L11:
                FieldEncoding r104 = r100.peekFieldEncoding();
                r101.addUnknownField(r103, r104, r104.rawProtoAdapter().decode(r100));
                goto L3
            L15:
                r100.endMessage(r102);
                return r101.build();
            }

            /* JADX INFO: renamed from: encodedSize, reason: avoid collision after fix types in other method */
            public int encodedSize2(ShowDialogAction r100) {
                DialogItem r101 = r100.title;
                int r102 = 0;
                if (r101 == null) goto L5;
                int r103 = DialogItem.ADAPTER.encodedSizeWithTag(1, r101);
            L6:
                DialogItem r104 = r100.content;
                if (r104 == null) goto L10;
                r102 = DialogItem.ADAPTER.encodedSizeWithTag(2, r104);
            L10:
                return ((r103 + r102) + DialogButton.ADAPTER.asRepeated().encodedSizeWithTag(3, r100.buttons)) + r100.unknownFields().size();
            L5:
                r103 = 0;
                goto L6
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ ShowDialogAction decode(ProtoReader r100) throws IOException {
                return decode(r100);
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ int encodedSize(ShowDialogAction r100) {
                return encodedSize2(r100);
            }

            /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
            public void encode2(ProtoWriter r100, ShowDialogAction r101) throws IOException {
                DialogItem r102 = r101.title;
                if (r102 == null) goto L5;
                DialogItem.ADAPTER.encodeWithTag(r100, 1, r102);
            L5:
                DialogItem r103 = r101.content;
                if (r103 == null) goto L8;
                DialogItem.ADAPTER.encodeWithTag(r100, 2, r103);
            L8:
                DialogButton.ADAPTER.asRepeated().encodeWithTag(r100, 3, r101.buttons);
                r100.writeBytes(r101.unknownFields());
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, ShowDialogAction r101) throws IOException {
                encode2(r100, r101);
            }
        }

        static {
            ADAPTER = new ProtoAdapter_ShowDialogAction();
        }

        @Override // com.squareup.wire.Message
        public Builder newBuilder() {
            Builder r100 = new Builder();
            r100.title = this.title;
            r100.content = this.content;
            r100.buttons = Internal.copyOf("buttons", this.buttons);
            r100.addUnknownFields(unknownFields());
            return r100;
        }

        @Override // com.squareup.wire.Message
        public String toString() {
            return ShowDialogAction.class.getName() + "@" + Integer.toHexString(hashCode());
        }

        @Override // com.squareup.wire.Message
        public /* bridge */ /* synthetic */ com.squareup.wire.Message.Builder newBuilder() {
            return newBuilder();
        }

        public ShowDialogAction(DialogItem r100, DialogItem r101, List<DialogButton> r102) {
            this(r100, r101, r102, ByteString.EMPTY);
        }

        public ShowDialogAction(DialogItem r100, DialogItem r101, List<DialogButton> r102, ByteString r103) {
            super(ADAPTER, r103);
            this.title = r100;
            this.content = r101;
            this.buttons = Internal.immutableCopyOf("buttons", r102);
        }
    }

    public static final class ShowToastAction extends com.squareup.wire.Message<ShowToastAction, Builder> {
        public static final ProtoAdapter<ShowToastAction> ADAPTER = null;
        public static final String DEFAULT_CONTENT = "";
        public static final Integer DEFAULT_DURATION = null;
        public static final ToastType DEFAULT_TYPE = null;
        private static final long serialVersionUID = 0;
        public final String content;
        public final Integer duration;
        public final ToastType type;

        public static final class Builder extends com.squareup.wire.Message.Builder<ShowToastAction, Builder> {
            public String content;
            public Integer duration;
            public ToastType type;

            @Override // com.squareup.wire.Message.Builder
            public ShowToastAction build() {
                return new ShowToastAction(this.type, this.content, this.duration, super.buildUnknownFields());
            }

            public Builder() {
            }

            @Override // com.squareup.wire.Message.Builder
            public /* bridge */ /* synthetic */ com.squareup.wire.Message build() {
                return build();
            }

            public Builder content(String r100) {
                this.content = r100;
                return this;
            }

            public Builder duration(Integer r100) {
                this.duration = r100;
                return this;
            }

            public Builder type(ToastType r100) {
                this.type = r100;
                return this;
            }
        }

        public static final class ProtoAdapter_ShowToastAction extends ProtoAdapter<ShowToastAction> {
            public ProtoAdapter_ShowToastAction() {
                super(FieldEncoding.LENGTH_DELIMITED, ShowToastAction.class);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.squareup.wire.ProtoAdapter
            public ShowToastAction decode(ProtoReader r100) throws IOException {
                Builder r101 = new Builder();
                r101.type = ToastType.info;
                r101.content = "";
                r101.duration = 0;
                long r102 = r100.beginMessage();
            L3:
                int r103 = r100.nextTag();
                if (r103 == (-1)) goto L18;
                if (r103 != 1) goto L8;
                r101.type = ToastType.ADAPTER.decode(r100);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L16
            L16:
                e = move-exception;
                r101.addUnknownField(r103, FieldEncoding.VARINT, Long.valueOf(e.value));
                goto L3
            L8:
                if (r103 != 2) goto L10;
                r101.content = ProtoAdapter.STRING.decode(r100);
                goto L3
            L10:
                if (r103 != 3) goto L11;
                r101.duration = ProtoAdapter.INT32.decode(r100);
                goto L3
            L11:
                FieldEncoding r104 = r100.peekFieldEncoding();
                r101.addUnknownField(r103, r104, r104.rawProtoAdapter().decode(r100));
                goto L3
            L18:
                r100.endMessage(r102);
                return r101.build();
            }

            /* JADX INFO: renamed from: encodedSize, reason: avoid collision after fix types in other method */
            public int encodedSize2(ShowToastAction r100) {
                ToastType r101 = r100.type;
                int r102 = 0;
                if (r101 == null) goto L5;
                int r103 = ToastType.ADAPTER.encodedSizeWithTag(1, r101);
            L6:
                String r104 = r100.content;
                if (r104 == null) goto L9;
                int r105 = ProtoAdapter.STRING.encodedSizeWithTag(2, r104);
            L10:
                int r106 = r103 + r105;
                Integer r107 = r100.duration;
                if (r107 == null) goto L14;
                r102 = ProtoAdapter.INT32.encodedSizeWithTag(3, r107);
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
            public /* bridge */ /* synthetic */ ShowToastAction decode(ProtoReader r100) throws IOException {
                return decode(r100);
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ int encodedSize(ShowToastAction r100) {
                return encodedSize2(r100);
            }

            /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
            public void encode2(ProtoWriter r100, ShowToastAction r101) throws IOException {
                ToastType r102 = r101.type;
                if (r102 == null) goto L5;
                ToastType.ADAPTER.encodeWithTag(r100, 1, r102);
            L5:
                String r103 = r101.content;
                if (r103 == null) goto L8;
                ProtoAdapter.STRING.encodeWithTag(r100, 2, r103);
            L8:
                Integer r104 = r101.duration;
                if (r104 == null) goto L11;
                ProtoAdapter.INT32.encodeWithTag(r100, 3, r104);
            L11:
                r100.writeBytes(r101.unknownFields());
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, ShowToastAction r101) throws IOException {
                encode2(r100, r101);
            }
        }

        public static final enum ToastType extends Enum<ToastType> implements WireEnum {
            private static final /* synthetic */ ToastType[] $VALUES = null;
            public static final ProtoAdapter<ToastType> ADAPTER = null;
            public static final ToastType error = null;
            public static final ToastType info = null;
            public static final ToastType success = null;
            public static final ToastType warning = null;
            private final int value;

            static {
                ToastType r100 = new ToastType("success", 0, 1);
                success = r100;
                ToastType r101 = new ToastType("error", 1, 2);
                error = r101;
                ToastType r102 = new ToastType("info", 2, 3);
                info = r102;
                ToastType r103 = new ToastType("warning", 3, 4);
                warning = r103;
                $VALUES = new ToastType[]{r100, r101, r102, r103};
                ADAPTER = ProtoAdapter.newEnumAdapter(ToastType.class);
            }

            public static ToastType[] values() {
                return (ToastType[]) $VALUES.clone();
            }

            @Override // com.squareup.wire.WireEnum
            public final int getValue() {
                return this.value;
            }

            public static ToastType fromValue(int r100) {
                if (r100 == 1) goto L19;
                if (r100 == 2) goto L17;
                if (r100 == 3) goto L15;
                if (r100 == 4) goto L13;
                return null;
            L13:
                return warning;
            L15:
                return info;
            L17:
                return error;
            L19:
                return success;
            }

            public static ToastType valueOf(String r100) {
                return (ToastType) a.a(ToastType.class, r100);
            }

            private ToastType(String r100, int r101, int r102) {
                super(r100, r101);
                this.value = r102;
            }
        }

        static {
            ADAPTER = new ProtoAdapter_ShowToastAction();
            DEFAULT_TYPE = ToastType.info;
            DEFAULT_DURATION = 0;
        }

        @Override // com.squareup.wire.Message
        public Builder newBuilder() {
            Builder r100 = new Builder();
            r100.type = this.type;
            r100.content = this.content;
            r100.duration = this.duration;
            r100.addUnknownFields(unknownFields());
            return r100;
        }

        @Override // com.squareup.wire.Message
        public String toString() {
            return ShowToastAction.class.getName() + "@" + Integer.toHexString(hashCode());
        }

        @Override // com.squareup.wire.Message
        public /* bridge */ /* synthetic */ com.squareup.wire.Message.Builder newBuilder() {
            return newBuilder();
        }

        public ShowToastAction(ToastType r100, String r101, Integer r102) {
            this(r100, r101, r102, ByteString.EMPTY);
        }

        public ShowToastAction(ToastType r100, String r101, Integer r102, ByteString r103) {
            super(ADAPTER, r103);
            this.type = r100;
            this.content = r101;
            this.duration = r102;
        }
    }

    public static final class SwitchStateAction extends com.squareup.wire.Message<SwitchStateAction, Builder> {
        public static final ProtoAdapter<SwitchStateAction> ADAPTER = null;
        public static final String DEFAULT_NEXT_STATE_ID = "";
        private static final long serialVersionUID = 0;
        public final String next_state_id;

        public static final class Builder extends com.squareup.wire.Message.Builder<SwitchStateAction, Builder> {
            public String next_state_id;

            @Override // com.squareup.wire.Message.Builder
            public SwitchStateAction build() {
                return new SwitchStateAction(this.next_state_id, super.buildUnknownFields());
            }

            public Builder() {
            }

            @Override // com.squareup.wire.Message.Builder
            public /* bridge */ /* synthetic */ com.squareup.wire.Message build() {
                return build();
            }

            public Builder next_state_id(String r100) {
                this.next_state_id = r100;
                return this;
            }
        }

        public static final class ProtoAdapter_SwitchStateAction extends ProtoAdapter<SwitchStateAction> {
            public ProtoAdapter_SwitchStateAction() {
                super(FieldEncoding.LENGTH_DELIMITED, SwitchStateAction.class);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.squareup.wire.ProtoAdapter
            public SwitchStateAction decode(ProtoReader r100) throws IOException {
                Builder r101 = new Builder();
                r101.next_state_id = "";
                long r102 = r100.beginMessage();
            L3:
                int r103 = r100.nextTag();
                if (r103 == (-1)) goto L9;
                if (r103 != 1) goto L7;
                r101.next_state_id = ProtoAdapter.STRING.decode(r100);
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
            public int encodedSize2(SwitchStateAction r100) {
                String r101 = r100.next_state_id;
                if (r101 == null) goto L5;
                int r102 = ProtoAdapter.STRING.encodedSizeWithTag(1, r101);
            L7:
                return r102 + r100.unknownFields().size();
            L5:
                r102 = 0;
                goto L7
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ SwitchStateAction decode(ProtoReader r100) throws IOException {
                return decode(r100);
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ int encodedSize(SwitchStateAction r100) {
                return encodedSize2(r100);
            }

            /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
            public void encode2(ProtoWriter r100, SwitchStateAction r101) throws IOException {
                String r102 = r101.next_state_id;
                if (r102 == null) goto L5;
                ProtoAdapter.STRING.encodeWithTag(r100, 1, r102);
            L5:
                r100.writeBytes(r101.unknownFields());
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, SwitchStateAction r101) throws IOException {
                encode2(r100, r101);
            }
        }

        static {
            ADAPTER = new ProtoAdapter_SwitchStateAction();
        }

        @Override // com.squareup.wire.Message
        public Builder newBuilder() {
            Builder r100 = new Builder();
            r100.next_state_id = this.next_state_id;
            r100.addUnknownFields(unknownFields());
            return r100;
        }

        @Override // com.squareup.wire.Message
        public String toString() {
            return SwitchStateAction.class.getName() + "@" + Integer.toHexString(hashCode());
        }

        @Override // com.squareup.wire.Message
        public /* bridge */ /* synthetic */ com.squareup.wire.Message.Builder newBuilder() {
            return newBuilder();
        }

        public SwitchStateAction(String r100) {
            this(r100, ByteString.EMPTY);
        }

        public SwitchStateAction(String r100, ByteString r101) {
            super(ADAPTER, r101);
            this.next_state_id = r100;
        }
    }

    static {
        ADAPTER = new ProtoAdapter_UrlPreviewAction();
        DEFAULT_METHOD = Method.GET;
        DEFAULT_CMD = 0;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.url = this.url;
        r100.method = this.method;
        r100.parameters = this.parameters;
        r100.cmd = this.cmd;
        r100.packet = this.packet;
        r100.open_url = this.open_url;
        r100.fallback_action_id = this.fallback_action_id;
        r100.get = this.get;
        r100.post = this.post;
        r100.command = this.command;
        r100.open_url_v2 = this.open_url_v2;
        r100.switch_state = this.switch_state;
        r100.show_toast = this.show_toast;
        r100.show_dialog = this.show_dialog;
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return UrlPreviewAction.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ com.squareup.wire.Message.Builder newBuilder() {
        return newBuilder();
    }

    public UrlPreviewAction(String r110, Method r111, Parameters r112, Integer r210, CardActionPacket r211, URL r212, String r213, GetAction r214, PostAction r215, LarkCommandAction r216, OpenURLAction r217, SwitchStateAction r218, ShowToastAction r219, ShowDialogAction r310) {
        this(r110, r111, r112, r210, r211, r212, r213, r214, r215, r216, r217, r218, r219, r310, ByteString.EMPTY);
    }

    public UrlPreviewAction(String r110, Method r111, Parameters r112, Integer r113, CardActionPacket r114, URL r115, String r116, GetAction r117, PostAction r210, LarkCommandAction r211, OpenURLAction r212, SwitchStateAction r213, ShowToastAction r214, ShowDialogAction r215, ByteString r216) {
        super(ADAPTER, r216);
        if (Internal.countNonNull(r117, r210, r211, r212, new Object[]{r213, r214, r215}) > 1) goto L7;
        this.url = r110;
        this.method = r111;
        this.parameters = r112;
        this.cmd = r113;
        this.packet = r114;
        this.open_url = r115;
        this.fallback_action_id = r116;
        this.get = r117;
        this.post = r210;
        this.command = r211;
        this.open_url_v2 = r212;
        this.switch_state = r213;
        this.show_toast = r214;
        this.show_dialog = r215;
        return;
    L7:
        throw new IllegalArgumentException("at most one of get, post, command, open_url_v2, switch_state, show_toast, show_dialog may be non-null");
    }
}
