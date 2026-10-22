package com.bytedance.lark.pb.space.doc.v1;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import com.squareup.wire.internal.Internal;
import java.io.IOException;
import java.util.Map;
import okio.ByteString;
import we6.c;
import we6.d;

/* JADX INFO: loaded from: classes20.dex */
public final class InlineAICreateTaskRequest extends Message<InlineAICreateTaskRequest, Builder> {
    public static final ProtoAdapter<InlineAICreateTaskRequest> ADAPTER = null;
    public static final String DEFAULT_ACTION_ID = "";
    public static final String DEFAULT_ACTION_TYPE = "";
    public static final String DEFAULT_DISPLAY_CONTENT = "";
    public static final String DEFAULT_OBJ_TOKEN = "";
    public static final Long DEFAULT_OBJ_TYPE = null;
    public static final Scenario DEFAULT_SCENARIO = null;
    public static final String DEFAULT_SESSION_ID = "";
    public static final String DEFAULT_UNIQUE_TASK_ID = "";
    public static final String DEFAULT_USER_PROMPT = "";
    public static final ProtoAdapter_InlineAICreateTaskRequest RAW_TYPE_ADAPTER = null;
    private static final long serialVersionUID = 0;
    public final String action_id;
    public final String action_type;
    public final String display_content;
    public final String obj_token;
    public final Long obj_type;
    public final Map<String, String> params;
    public final Scenario scenario;
    public final String session_id;
    public final String unique_task_id;
    public final InlineAIUserContext user_context;
    public final String user_prompt;

    public static final class Builder extends Message.Builder<InlineAICreateTaskRequest, Builder> implements d<InlineAICreateTaskRequest> {
        public String action_id;
        public String action_type;
        public String display_content;
        public String obj_token;
        public Long obj_type;
        public Map<String, String> params;
        public Scenario scenario;
        public String session_id;
        public String unique_task_id;
        public InlineAIUserContext user_context;
        public String user_prompt;

        @Override // com.squareup.wire.Message.Builder
        public InlineAICreateTaskRequest build() {
            return new InlineAICreateTaskRequest(this.unique_task_id, this.session_id, this.scenario, this.action_type, this.action_id, this.obj_type, this.obj_token, this.params, this.user_prompt, this.user_context, this.display_content, super.buildUnknownFields());
        }

        public Builder() {
            this.params = Internal.newMutableMap();
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder action_id(String r100) {
            this.action_id = r100;
            return this;
        }

        public Builder action_type(String r100) {
            this.action_type = r100;
            return this;
        }

        public Builder display_content(String r100) {
            this.display_content = r100;
            return this;
        }

        public Builder obj_token(String r100) {
            this.obj_token = r100;
            return this;
        }

        public Builder obj_type(Long r100) {
            this.obj_type = r100;
            return this;
        }

        public Builder params(Map<String, String> r100) {
            Internal.checkElementsNotNull(r100);
            this.params = r100;
            return this;
        }

        public Builder scenario(Scenario r100) {
            this.scenario = r100;
            return this;
        }

        public Builder session_id(String r100) {
            this.session_id = r100;
            return this;
        }

        public Builder unique_task_id(String r100) {
            this.unique_task_id = r100;
            return this;
        }

        public Builder user_context(InlineAIUserContext r100) {
            this.user_context = r100;
            return this;
        }

        public Builder user_prompt(String r100) {
            this.user_prompt = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_InlineAICreateTaskRequest extends ProtoAdapter<InlineAICreateTaskRequest> implements c<InlineAICreateTaskRequest> {
        private final ProtoAdapter<Map<String, String>> params;

        public ProtoAdapter_InlineAICreateTaskRequest() {
            super(FieldEncoding.LENGTH_DELIMITED, InlineAICreateTaskRequest.class);
            ProtoAdapter<String> r100 = ProtoAdapter.STRING;
            this.params = ProtoAdapter.newMapAdapter(r100, r100);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public InlineAICreateTaskRequest decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            r101.unique_task_id = "";
            r101.session_id = "";
            r101.scenario = Scenario.IM;
            r101.action_type = "";
            r101.action_id = "";
            r101.obj_type = 0L;
            r101.obj_token = "";
            r101.user_prompt = "";
            r101.display_content = "";
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L21;
            switch(r103) {
                case 1: goto L20;
                case 2: goto L19;
                case 3: goto L23;
                case 4: goto L14;
                case 5: goto L13;
                case 6: goto L12;
                case 7: goto L11;
                case 8: goto L10;
                case 9: goto L9;
                case 10: goto L8;
                case 11: goto L7;
                default: goto L6;
            };
        L23:
            r101.scenario = Scenario.ADAPTER.decode(r100);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L17
        L17:
            e = move-exception;
            r101.addUnknownField(r103, FieldEncoding.VARINT, Long.valueOf(e.value));
            goto L3
        L7:
            r101.display_content = ProtoAdapter.STRING.decode(r100);
            goto L3
        L8:
            r101.user_context = InlineAIUserContext.ADAPTER.decode(r100);
            goto L3
        L9:
            r101.user_prompt = ProtoAdapter.STRING.decode(r100);
            goto L3
        L10:
            r101.params.putAll(this.params.decode(r100));
            goto L3
        L11:
            r101.obj_token = ProtoAdapter.STRING.decode(r100);
            goto L3
        L12:
            r101.obj_type = ProtoAdapter.INT64.decode(r100);
            goto L3
        L13:
            r101.action_id = ProtoAdapter.STRING.decode(r100);
            goto L3
        L14:
            r101.action_type = ProtoAdapter.STRING.decode(r100);
            goto L3
        L19:
            r101.session_id = ProtoAdapter.STRING.decode(r100);
            goto L3
        L20:
            r101.unique_task_id = ProtoAdapter.STRING.decode(r100);
            goto L3
        L6:
            FieldEncoding r104 = r100.peekFieldEncoding();
            r101.addUnknownField(r103, r104, r104.rawProtoAdapter().decode(r100));
            goto L3
        L21:
            r100.endMessage(r102);
            return r101.build();
        }

        /* JADX INFO: renamed from: encodedSize, reason: avoid collision after fix types in other method */
        public int encodedSize2(InlineAICreateTaskRequest r100) {
            String r101 = r100.unique_task_id;
            int r102 = 0;
            if (r101 == null) goto L5;
            int r103 = ProtoAdapter.STRING.encodedSizeWithTag(1, r101);
        L6:
            String r104 = r100.session_id;
            if (r104 == null) goto L9;
            int r105 = ProtoAdapter.STRING.encodedSizeWithTag(2, r104);
        L10:
            int r106 = r103 + r105;
            Scenario r107 = r100.scenario;
            if (r107 == null) goto L13;
            int r108 = Scenario.ADAPTER.encodedSizeWithTag(3, r107);
        L14:
            int r109 = r106 + r108;
            String r110 = r100.action_type;
            if (r110 == null) goto L17;
            int r111 = ProtoAdapter.STRING.encodedSizeWithTag(4, r110);
        L18:
            int r112 = r109 + r111;
            String r113 = r100.action_id;
            if (r113 == null) goto L21;
            int r114 = ProtoAdapter.STRING.encodedSizeWithTag(5, r113);
        L22:
            int r115 = r112 + r114;
            Long r116 = r100.obj_type;
            if (r116 == null) goto L25;
            int r117 = ProtoAdapter.INT64.encodedSizeWithTag(6, r116);
        L26:
            int r118 = r115 + r117;
            String r119 = r100.obj_token;
            if (r119 == null) goto L29;
            int r120 = ProtoAdapter.STRING.encodedSizeWithTag(7, r119);
        L30:
            int r121 = (r118 + r120) + this.params.encodedSizeWithTag(8, r100.params);
            String r122 = r100.user_prompt;
            if (r122 == null) goto L33;
            int r123 = ProtoAdapter.STRING.encodedSizeWithTag(9, r122);
        L34:
            int r124 = r121 + r123;
            InlineAIUserContext r125 = r100.user_context;
            if (r125 == null) goto L37;
            int r126 = InlineAIUserContext.ADAPTER.encodedSizeWithTag(10, r125);
        L38:
            int r127 = r124 + r126;
            String r128 = r100.display_content;
            if (r128 == null) goto L42;
            r102 = ProtoAdapter.STRING.encodedSizeWithTag(11, r128);
        L42:
            return (r127 + r102) + r100.unknownFields().size();
        L37:
            r126 = 0;
            goto L38
        L33:
            r123 = 0;
            goto L34
        L29:
            r120 = 0;
            goto L30
        L25:
            r117 = 0;
            goto L26
        L21:
            r114 = 0;
            goto L22
        L17:
            r111 = 0;
            goto L18
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
        public /* bridge */ /* synthetic */ InlineAICreateTaskRequest decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(InlineAICreateTaskRequest r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, InlineAICreateTaskRequest r101) throws IOException {
            String r102 = r101.unique_task_id;
            if (r102 == null) goto L5;
            ProtoAdapter.STRING.encodeWithTag(r100, 1, r102);
        L5:
            String r103 = r101.session_id;
            if (r103 == null) goto L8;
            ProtoAdapter.STRING.encodeWithTag(r100, 2, r103);
        L8:
            Scenario r104 = r101.scenario;
            if (r104 == null) goto L11;
            Scenario.ADAPTER.encodeWithTag(r100, 3, r104);
        L11:
            String r105 = r101.action_type;
            if (r105 == null) goto L14;
            ProtoAdapter.STRING.encodeWithTag(r100, 4, r105);
        L14:
            String r106 = r101.action_id;
            if (r106 == null) goto L17;
            ProtoAdapter.STRING.encodeWithTag(r100, 5, r106);
        L17:
            Long r107 = r101.obj_type;
            if (r107 == null) goto L20;
            ProtoAdapter.INT64.encodeWithTag(r100, 6, r107);
        L20:
            String r108 = r101.obj_token;
            if (r108 == null) goto L23;
            ProtoAdapter.STRING.encodeWithTag(r100, 7, r108);
        L23:
            this.params.encodeWithTag(r100, 8, r101.params);
            String r109 = r101.user_prompt;
            if (r109 == null) goto L26;
            ProtoAdapter.STRING.encodeWithTag(r100, 9, r109);
        L26:
            InlineAIUserContext r110 = r101.user_context;
            if (r110 == null) goto L29;
            InlineAIUserContext.ADAPTER.encodeWithTag(r100, 10, r110);
        L29:
            String r111 = r101.display_content;
            if (r111 == null) goto L32;
            ProtoAdapter.STRING.encodeWithTag(r100, 11, r111);
        L32:
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, InlineAICreateTaskRequest r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ProtoAdapter_InlineAICreateTaskRequest r100 = new ProtoAdapter_InlineAICreateTaskRequest();
        RAW_TYPE_ADAPTER = r100;
        ADAPTER = r100;
        DEFAULT_SCENARIO = Scenario.IM;
        DEFAULT_OBJ_TYPE = 0L;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.unique_task_id = this.unique_task_id;
        r100.session_id = this.session_id;
        r100.scenario = this.scenario;
        r100.action_type = this.action_type;
        r100.action_id = this.action_id;
        r100.obj_type = this.obj_type;
        r100.obj_token = this.obj_token;
        r100.params = Internal.copyOf("params", this.params);
        r100.user_prompt = this.user_prompt;
        r100.user_context = this.user_context;
        r100.display_content = this.display_content;
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return InlineAICreateTaskRequest.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public InlineAICreateTaskRequest(String r110, String r111, Scenario r112, String r113, String r114, Long r115, String r210, Map<String, String> r211, String r212, InlineAIUserContext r213, String r214) {
        this(r110, r111, r112, r113, r114, r115, r210, r211, r212, r213, r214, ByteString.EMPTY);
    }

    public InlineAICreateTaskRequest(String r100, String r101, Scenario r102, String r103, String r104, Long r105, String r106, Map<String, String> r107, String r110, InlineAIUserContext r111, String r112, ByteString r113) {
        super(ADAPTER, r113);
        this.unique_task_id = r100;
        this.session_id = r101;
        this.scenario = r102;
        this.action_type = r103;
        this.action_id = r104;
        this.obj_type = r105;
        this.obj_token = r106;
        this.params = Internal.immutableCopyOf("params", r107);
        this.user_prompt = r110;
        this.user_context = r111;
        this.display_content = r112;
    }
}
