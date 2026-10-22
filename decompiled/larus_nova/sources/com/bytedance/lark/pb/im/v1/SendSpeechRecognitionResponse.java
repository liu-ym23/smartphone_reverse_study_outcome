package com.bytedance.lark.pb.im.v1;

import com.bytedance.lark.pb.basic.v1.RichText;
import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import com.squareup.wire.WireEnum;
import com.squareup.wire.internal.Internal;
import java.io.IOException;
import java.util.List;
import okio.ByteString;
import r27.a;
import we6.c;
import we6.d;

/* JADX INFO: loaded from: classes20.dex */
public final class SendSpeechRecognitionResponse extends Message<SendSpeechRecognitionResponse, Builder> {
    public static final ProtoAdapter<SendSpeechRecognitionResponse> ADAPTER = null;
    public static final Integer DEFAULT_ERROR_CODE = null;
    public static final HandleAction DEFAULT_HANDLE_ACTION = null;
    public static final Boolean DEFAULT_IS_END = null;
    public static final Boolean DEFAULT_IS_FORMATTED = null;
    public static final String DEFAULT_RESULT = "";
    public static final Scene DEFAULT_SCENE = null;
    public static final Integer DEFAULT_SEQUENCE_ID = null;
    public static final String DEFAULT_SOURCE_ID = "";
    public static final String DEFAULT_TIP_MESSAGE = "";
    public static final ProtoAdapter_SendSpeechRecognitionResponse RAW_TYPE_ADAPTER = null;
    private static final long serialVersionUID = 0;
    public final List<ASRName> asr_names;
    public final List<Integer> diff_index_slice;
    public final Integer error_code;
    public final HandleAction handle_action;
    public final Boolean is_end;
    public final Boolean is_formatted;
    public final List<NERInfo> ner_info;
    public final ASRTextResult origin_asr_result;
    public final String result;
    public final RichText rich_text_result;
    public final Scene scene;
    public final Integer sequence_id;
    public final String source_id;
    public final String tip_message;

    public static final class Builder extends Message.Builder<SendSpeechRecognitionResponse, Builder> implements d<SendSpeechRecognitionResponse> {
        public List<ASRName> asr_names;
        public List<Integer> diff_index_slice;
        public Integer error_code;
        public HandleAction handle_action;
        public Boolean is_end;
        public Boolean is_formatted;
        public List<NERInfo> ner_info;
        public ASRTextResult origin_asr_result;
        public String result;
        public RichText rich_text_result;
        public Scene scene;
        public Integer sequence_id;
        public String source_id;
        public String tip_message;

        @Override // com.squareup.wire.Message.Builder
        public SendSpeechRecognitionResponse build() {
            return new SendSpeechRecognitionResponse(this.source_id, this.sequence_id, this.result, this.is_end, this.diff_index_slice, this.error_code, this.handle_action, this.ner_info, this.scene, this.asr_names, this.rich_text_result, this.origin_asr_result, this.is_formatted, this.tip_message, super.buildUnknownFields());
        }

        public Builder() {
            this.diff_index_slice = Internal.newMutableList();
            this.ner_info = Internal.newMutableList();
            this.asr_names = Internal.newMutableList();
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder asr_names(List<ASRName> r100) {
            Internal.checkElementsNotNull(r100);
            this.asr_names = r100;
            return this;
        }

        public Builder diff_index_slice(List<Integer> r100) {
            Internal.checkElementsNotNull(r100);
            this.diff_index_slice = r100;
            return this;
        }

        public Builder error_code(Integer r100) {
            this.error_code = r100;
            return this;
        }

        public Builder handle_action(HandleAction r100) {
            this.handle_action = r100;
            return this;
        }

        public Builder is_end(Boolean r100) {
            this.is_end = r100;
            return this;
        }

        public Builder is_formatted(Boolean r100) {
            this.is_formatted = r100;
            return this;
        }

        public Builder ner_info(List<NERInfo> r100) {
            Internal.checkElementsNotNull(r100);
            this.ner_info = r100;
            return this;
        }

        public Builder origin_asr_result(ASRTextResult r100) {
            this.origin_asr_result = r100;
            return this;
        }

        public Builder result(String r100) {
            this.result = r100;
            return this;
        }

        public Builder rich_text_result(RichText r100) {
            this.rich_text_result = r100;
            return this;
        }

        public Builder scene(Scene r100) {
            this.scene = r100;
            return this;
        }

        public Builder sequence_id(Integer r100) {
            this.sequence_id = r100;
            return this;
        }

        public Builder source_id(String r100) {
            this.source_id = r100;
            return this;
        }

        public Builder tip_message(String r100) {
            this.tip_message = r100;
            return this;
        }
    }

    public static final enum HandleAction extends Enum<HandleAction> implements WireEnum {
        private static final /* synthetic */ HandleAction[] $VALUES = null;
        public static final ProtoAdapter<HandleAction> ADAPTER = null;
        public static final HandleAction BLOCK = null;
        public static final HandleAction DEFAULT = null;
        public static final HandleAction RETRY = null;
        private final int value;

        static {
            HandleAction r100 = new HandleAction("DEFAULT", 0, 0);
            DEFAULT = r100;
            HandleAction r101 = new HandleAction("RETRY", 1, 1);
            RETRY = r101;
            HandleAction r102 = new HandleAction("BLOCK", 2, 2);
            BLOCK = r102;
            $VALUES = new HandleAction[]{r100, r101, r102};
            ADAPTER = ProtoAdapter.newEnumAdapter(HandleAction.class);
        }

        public static HandleAction[] values() {
            return (HandleAction[]) $VALUES.clone();
        }

        @Override // com.squareup.wire.WireEnum
        public final int getValue() {
            return this.value;
        }

        public static HandleAction fromValue(int r100) {
            if (r100 == 0) goto L14;
            if (r100 == 1) goto L12;
            if (r100 == 2) goto L10;
            return null;
        L10:
            return BLOCK;
        L12:
            return RETRY;
        L14:
            return DEFAULT;
        }

        public static HandleAction valueOf(String r100) {
            return (HandleAction) a.a(HandleAction.class, r100);
        }

        private HandleAction(String r100, int r101, int r102) {
            super(r100, r101);
            this.value = r102;
        }
    }

    public static final class ProtoAdapter_SendSpeechRecognitionResponse extends ProtoAdapter<SendSpeechRecognitionResponse> implements c<SendSpeechRecognitionResponse> {
        public ProtoAdapter_SendSpeechRecognitionResponse() {
            super(FieldEncoding.LENGTH_DELIMITED, SendSpeechRecognitionResponse.class);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public SendSpeechRecognitionResponse decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            r101.source_id = "";
            r101.sequence_id = 0;
            r101.result = "";
            Boolean r102 = Boolean.FALSE;
            r101.is_end = r102;
            r101.error_code = 0;
            r101.handle_action = HandleAction.DEFAULT;
            r101.scene = Scene.NORMAL_SCENE;
            r101.is_formatted = r102;
            r101.tip_message = "";
            long r103 = r100.beginMessage();
        L3:
            int r104 = r100.nextTag();
            if (r104 == (-1)) goto L27;
            switch(r104) {
                case 1: goto L26;
                case 2: goto L25;
                case 3: goto L24;
                case 4: goto L23;
                case 5: goto L6;
                case 6: goto L22;
                case 7: goto L21;
                case 8: goto L29;
                case 9: goto L16;
                case 10: goto L31;
                case 11: goto L11;
                case 12: goto L10;
                case 13: goto L9;
                case 14: goto L8;
                case 15: goto L7;
                default: goto L6;
            };
        L29:
            r101.handle_action = HandleAction.ADAPTER.decode(r100);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L19
        L19:
            e = move-exception;
            r101.addUnknownField(r104, FieldEncoding.VARINT, Long.valueOf(e.value));
            goto L3
        L31:
            r101.scene = Scene.ADAPTER.decode(r100);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L14
        L14:
            e = move-exception;
            r101.addUnknownField(r104, FieldEncoding.VARINT, Long.valueOf(e.value));
            goto L3
        L7:
            r101.tip_message = ProtoAdapter.STRING.decode(r100);
            goto L3
        L8:
            r101.is_formatted = ProtoAdapter.BOOL.decode(r100);
            goto L3
        L9:
            r101.origin_asr_result = ASRTextResult.ADAPTER.decode(r100);
            goto L3
        L10:
            r101.rich_text_result = RichText.ADAPTER.decode(r100);
            goto L3
        L11:
            r101.asr_names.add(ASRName.ADAPTER.decode(r100));
            goto L3
        L16:
            r101.ner_info.add(NERInfo.ADAPTER.decode(r100));
            goto L3
        L21:
            r101.error_code = ProtoAdapter.INT32.decode(r100);
            goto L3
        L22:
            r101.diff_index_slice.add(ProtoAdapter.INT32.decode(r100));
            goto L3
        L23:
            r101.is_end = ProtoAdapter.BOOL.decode(r100);
            goto L3
        L24:
            r101.result = ProtoAdapter.STRING.decode(r100);
            goto L3
        L25:
            r101.sequence_id = ProtoAdapter.INT32.decode(r100);
            goto L3
        L26:
            r101.source_id = ProtoAdapter.STRING.decode(r100);
            goto L3
        L6:
            FieldEncoding r105 = r100.peekFieldEncoding();
            r101.addUnknownField(r104, r105, r105.rawProtoAdapter().decode(r100));
            goto L3
        L27:
            r100.endMessage(r103);
            return r101.build();
        }

        /* JADX INFO: renamed from: encodedSize, reason: avoid collision after fix types in other method */
        public int encodedSize2(SendSpeechRecognitionResponse r100) {
            String r101 = r100.source_id;
            int r102 = 0;
            if (r101 == null) goto L5;
            int r103 = ProtoAdapter.STRING.encodedSizeWithTag(1, r101);
        L6:
            Integer r104 = r100.sequence_id;
            if (r104 == null) goto L9;
            int r105 = ProtoAdapter.INT32.encodedSizeWithTag(2, r104);
        L10:
            int r106 = r103 + r105;
            String r107 = r100.result;
            if (r107 == null) goto L13;
            int r108 = ProtoAdapter.STRING.encodedSizeWithTag(3, r107);
        L14:
            int r109 = r106 + r108;
            Boolean r110 = r100.is_end;
            if (r110 == null) goto L17;
            int r111 = ProtoAdapter.BOOL.encodedSizeWithTag(4, r110);
        L18:
            int r112 = r109 + r111;
            ProtoAdapter<Integer> r113 = ProtoAdapter.INT32;
            int r114 = r112 + r113.asRepeated().encodedSizeWithTag(6, r100.diff_index_slice);
            Integer r115 = r100.error_code;
            if (r115 == null) goto L21;
            int r116 = r113.encodedSizeWithTag(7, r115);
        L22:
            int r117 = r114 + r116;
            HandleAction r118 = r100.handle_action;
            if (r118 == null) goto L25;
            int r119 = HandleAction.ADAPTER.encodedSizeWithTag(8, r118);
        L26:
            int r120 = (r117 + r119) + NERInfo.ADAPTER.asRepeated().encodedSizeWithTag(9, r100.ner_info);
            Scene r121 = r100.scene;
            if (r121 == null) goto L29;
            int r122 = Scene.ADAPTER.encodedSizeWithTag(10, r121);
        L30:
            int r123 = (r120 + r122) + ASRName.ADAPTER.asRepeated().encodedSizeWithTag(11, r100.asr_names);
            RichText r124 = r100.rich_text_result;
            if (r124 == null) goto L33;
            int r125 = RichText.ADAPTER.encodedSizeWithTag(12, r124);
        L34:
            int r126 = r123 + r125;
            ASRTextResult r127 = r100.origin_asr_result;
            if (r127 == null) goto L37;
            int r128 = ASRTextResult.ADAPTER.encodedSizeWithTag(13, r127);
        L38:
            int r129 = r126 + r128;
            Boolean r130 = r100.is_formatted;
            if (r130 == null) goto L41;
            int r131 = ProtoAdapter.BOOL.encodedSizeWithTag(14, r130);
        L42:
            int r132 = r129 + r131;
            String r133 = r100.tip_message;
            if (r133 == null) goto L46;
            r102 = ProtoAdapter.STRING.encodedSizeWithTag(15, r133);
        L46:
            return (r132 + r102) + r100.unknownFields().size();
        L41:
            r131 = 0;
            goto L42
        L37:
            r128 = 0;
            goto L38
        L33:
            r125 = 0;
            goto L34
        L29:
            r122 = 0;
            goto L30
        L25:
            r119 = 0;
            goto L26
        L21:
            r116 = 0;
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
        public /* bridge */ /* synthetic */ SendSpeechRecognitionResponse decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(SendSpeechRecognitionResponse r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, SendSpeechRecognitionResponse r101) throws IOException {
            String r102 = r101.source_id;
            if (r102 == null) goto L5;
            ProtoAdapter.STRING.encodeWithTag(r100, 1, r102);
        L5:
            Integer r103 = r101.sequence_id;
            if (r103 == null) goto L8;
            ProtoAdapter.INT32.encodeWithTag(r100, 2, r103);
        L8:
            String r104 = r101.result;
            if (r104 == null) goto L11;
            ProtoAdapter.STRING.encodeWithTag(r100, 3, r104);
        L11:
            Boolean r105 = r101.is_end;
            if (r105 == null) goto L14;
            ProtoAdapter.BOOL.encodeWithTag(r100, 4, r105);
        L14:
            ProtoAdapter<Integer> r106 = ProtoAdapter.INT32;
            r106.asRepeated().encodeWithTag(r100, 6, r101.diff_index_slice);
            Integer r107 = r101.error_code;
            if (r107 == null) goto L17;
            r106.encodeWithTag(r100, 7, r107);
        L17:
            HandleAction r108 = r101.handle_action;
            if (r108 == null) goto L20;
            HandleAction.ADAPTER.encodeWithTag(r100, 8, r108);
        L20:
            NERInfo.ADAPTER.asRepeated().encodeWithTag(r100, 9, r101.ner_info);
            Scene r109 = r101.scene;
            if (r109 == null) goto L23;
            Scene.ADAPTER.encodeWithTag(r100, 10, r109);
        L23:
            ASRName.ADAPTER.asRepeated().encodeWithTag(r100, 11, r101.asr_names);
            RichText r110 = r101.rich_text_result;
            if (r110 == null) goto L26;
            RichText.ADAPTER.encodeWithTag(r100, 12, r110);
        L26:
            ASRTextResult r111 = r101.origin_asr_result;
            if (r111 == null) goto L29;
            ASRTextResult.ADAPTER.encodeWithTag(r100, 13, r111);
        L29:
            Boolean r112 = r101.is_formatted;
            if (r112 == null) goto L32;
            ProtoAdapter.BOOL.encodeWithTag(r100, 14, r112);
        L32:
            String r113 = r101.tip_message;
            if (r113 == null) goto L35;
            ProtoAdapter.STRING.encodeWithTag(r100, 15, r113);
        L35:
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, SendSpeechRecognitionResponse r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ProtoAdapter_SendSpeechRecognitionResponse r100 = new ProtoAdapter_SendSpeechRecognitionResponse();
        RAW_TYPE_ADAPTER = r100;
        ADAPTER = r100;
        DEFAULT_SEQUENCE_ID = 0;
        Boolean r101 = Boolean.FALSE;
        DEFAULT_IS_END = r101;
        DEFAULT_ERROR_CODE = 0;
        DEFAULT_HANDLE_ACTION = HandleAction.DEFAULT;
        DEFAULT_SCENE = Scene.NORMAL_SCENE;
        DEFAULT_IS_FORMATTED = r101;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.source_id = this.source_id;
        r100.sequence_id = this.sequence_id;
        r100.result = this.result;
        r100.is_end = this.is_end;
        r100.diff_index_slice = Internal.copyOf("diff_index_slice", this.diff_index_slice);
        r100.error_code = this.error_code;
        r100.handle_action = this.handle_action;
        r100.ner_info = Internal.copyOf("ner_info", this.ner_info);
        r100.scene = this.scene;
        r100.asr_names = Internal.copyOf("asr_names", this.asr_names);
        r100.rich_text_result = this.rich_text_result;
        r100.origin_asr_result = this.origin_asr_result;
        r100.is_formatted = this.is_formatted;
        r100.tip_message = this.tip_message;
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return SendSpeechRecognitionResponse.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public SendSpeechRecognitionResponse(String r110, Integer r111, String r112, Boolean r210, List<Integer> r211, Integer r212, HandleAction r213, List<NERInfo> r214, Scene r215, List<ASRName> r216, RichText r217, ASRTextResult r218, Boolean r219, String r310) {
        this(r110, r111, r112, r210, r211, r212, r213, r214, r215, r216, r217, r218, r219, r310, ByteString.EMPTY);
    }

    public SendSpeechRecognitionResponse(String r100, Integer r101, String r102, Boolean r103, List<Integer> r104, Integer r105, HandleAction r110, List<NERInfo> r111, Scene r112, List<ASRName> r113, RichText r114, ASRTextResult r115, Boolean r116, String r117, ByteString r118) {
        super(ADAPTER, r118);
        this.source_id = r100;
        this.sequence_id = r101;
        this.result = r102;
        this.is_end = r103;
        this.diff_index_slice = Internal.immutableCopyOf("diff_index_slice", r104);
        this.error_code = r105;
        this.handle_action = r110;
        this.ner_info = Internal.immutableCopyOf("ner_info", r111);
        this.scene = r112;
        this.asr_names = Internal.immutableCopyOf("asr_names", r113);
        this.rich_text_result = r114;
        this.origin_asr_result = r115;
        this.is_formatted = r116;
        this.tip_message = r117;
    }
}
