package com.bytedance.lark.pb.im.v1;

import com.alibaba.gaiax.model.GXAnimation;
import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import com.squareup.wire.WireEnum;
import java.io.IOException;
import okio.ByteString;
import r27.a;
import we6.c;
import we6.d;

/* JADX INFO: loaded from: classes20.dex */
public final class SendSpeechRecognitionRequest extends Message<SendSpeechRecognitionRequest, Builder> {
    public static final ProtoAdapter<SendSpeechRecognitionRequest> ADAPTER = null;
    public static final Action DEFAULT_ACTION = null;
    public static final ByteString DEFAULT_AUDIO_DATA = null;
    public static final String DEFAULT_AUDIO_FORMAT = "opus";
    public static final Integer DEFAULT_AUDIO_RATE = null;
    public static final String DEFAULT_CHAT_ID = "";
    public static final String DEFAULT_DEVICE_LOCALE = "";
    public static final Boolean DEFAULT_ENABLE_FORMAT = null;
    public static final Boolean DEFAULT_ENABLE_MARKDOWN = null;
    public static final Boolean DEFAULT_ENABLE_NER = null;
    public static final Boolean DEFAULT_PUSH_RESPONSE = null;
    public static final Scene DEFAULT_SCENE = null;
    public static final Integer DEFAULT_SEQUENCE_ID = null;
    public static final String DEFAULT_SESSION = "";
    public static final Boolean DEFAULT_SHOULD_DIFF_RESULT = null;
    public static final String DEFAULT_SOURCE_ID = "";
    public static final String DEFAULT_SPEECH_LOCALE = "";
    public static final Boolean DEFAULT_UPLOAD_AUDIO = null;
    public static final String DEFAULT_VOICE_INPUT_DEVICE = "";
    public static final ProtoAdapter_SendSpeechRecognitionRequest RAW_TYPE_ADAPTER = null;
    private static final long serialVersionUID = 0;
    public final Action action;
    public final ByteString audio_data;
    public final String audio_format;
    public final Integer audio_rate;
    public final String chat_id;
    public final String device_locale;
    public final Boolean enable_format;
    public final Boolean enable_markdown;
    public final Boolean enable_ner;
    public final Boolean push_response;
    public final Scene scene;
    public final Integer sequence_id;
    public final String session;
    public final Boolean should_diff_result;
    public final String source_id;
    public final String speech_locale;
    public final SpeechScene speech_scene;
    public final Boolean upload_audio;
    public final String voice_input_device;

    public static final enum Action extends Enum<Action> implements WireEnum {
        private static final /* synthetic */ Action[] $VALUES = null;
        public static final ProtoAdapter<Action> ADAPTER = null;
        public static final Action BEGIN = null;
        public static final Action END = null;
        public static final Action UNKNOWN = null;
        private final int value;

        static {
            Action r100 = new Action("UNKNOWN", 0, 0);
            UNKNOWN = r100;
            Action r101 = new Action("BEGIN", 1, 1);
            BEGIN = r101;
            Action r102 = new Action(GXAnimation.STATE_END, 2, 2);
            END = r102;
            $VALUES = new Action[]{r100, r101, r102};
            ADAPTER = ProtoAdapter.newEnumAdapter(Action.class);
        }

        public static Action[] values() {
            return (Action[]) $VALUES.clone();
        }

        @Override // com.squareup.wire.WireEnum
        public final int getValue() {
            return this.value;
        }

        public static Action fromValue(int r100) {
            if (r100 == 0) goto L14;
            if (r100 == 1) goto L12;
            if (r100 == 2) goto L10;
            return null;
        L10:
            return END;
        L12:
            return BEGIN;
        L14:
            return UNKNOWN;
        }

        public static Action valueOf(String r100) {
            return (Action) a.a(Action.class, r100);
        }

        private Action(String r100, int r101, int r102) {
            super(r100, r101);
            this.value = r102;
        }
    }

    public static final class Builder extends Message.Builder<SendSpeechRecognitionRequest, Builder> implements d<SendSpeechRecognitionRequest> {
        public Action action;
        public ByteString audio_data;
        public String audio_format;
        public Integer audio_rate;
        public String chat_id;
        public String device_locale;
        public Boolean enable_format;
        public Boolean enable_markdown;
        public Boolean enable_ner;
        public Boolean push_response;
        public Scene scene;
        public Integer sequence_id;
        public String session;
        public Boolean should_diff_result;
        public String source_id;
        public String speech_locale;
        public SpeechScene speech_scene;
        public Boolean upload_audio;
        public String voice_input_device;

        @Override // com.squareup.wire.Message.Builder
        public SendSpeechRecognitionRequest build() {
            return new SendSpeechRecognitionRequest(this.source_id, this.sequence_id, this.device_locale, this.audio_data, this.action, this.audio_rate, this.audio_format, this.should_diff_result, this.speech_locale, this.session, this.chat_id, this.upload_audio, this.push_response, this.enable_ner, this.scene, this.enable_format, this.speech_scene, this.voice_input_device, this.enable_markdown, super.buildUnknownFields());
        }

        public Builder() {
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder action(Action r100) {
            this.action = r100;
            return this;
        }

        public Builder audio_data(ByteString r100) {
            this.audio_data = r100;
            return this;
        }

        public Builder audio_format(String r100) {
            this.audio_format = r100;
            return this;
        }

        public Builder audio_rate(Integer r100) {
            this.audio_rate = r100;
            return this;
        }

        public Builder chat_id(String r100) {
            this.chat_id = r100;
            return this;
        }

        public Builder device_locale(String r100) {
            this.device_locale = r100;
            return this;
        }

        public Builder enable_format(Boolean r100) {
            this.enable_format = r100;
            return this;
        }

        public Builder enable_markdown(Boolean r100) {
            this.enable_markdown = r100;
            return this;
        }

        public Builder enable_ner(Boolean r100) {
            this.enable_ner = r100;
            return this;
        }

        public Builder push_response(Boolean r100) {
            this.push_response = r100;
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

        public Builder session(String r100) {
            this.session = r100;
            return this;
        }

        public Builder should_diff_result(Boolean r100) {
            this.should_diff_result = r100;
            return this;
        }

        public Builder source_id(String r100) {
            this.source_id = r100;
            return this;
        }

        public Builder speech_locale(String r100) {
            this.speech_locale = r100;
            return this;
        }

        public Builder speech_scene(SpeechScene r100) {
            this.speech_scene = r100;
            return this;
        }

        public Builder upload_audio(Boolean r100) {
            this.upload_audio = r100;
            return this;
        }

        public Builder voice_input_device(String r100) {
            this.voice_input_device = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_SendSpeechRecognitionRequest extends ProtoAdapter<SendSpeechRecognitionRequest> implements c<SendSpeechRecognitionRequest> {
        public ProtoAdapter_SendSpeechRecognitionRequest() {
            super(FieldEncoding.LENGTH_DELIMITED, SendSpeechRecognitionRequest.class);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public SendSpeechRecognitionRequest decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            r101.source_id = "";
            r101.sequence_id = 0;
            r101.device_locale = "";
            r101.audio_data = ByteString.EMPTY;
            r101.action = Action.UNKNOWN;
            r101.audio_rate = 16;
            r101.audio_format = "opus";
            Boolean r102 = Boolean.FALSE;
            r101.should_diff_result = r102;
            r101.speech_locale = "";
            r101.session = "";
            r101.chat_id = "";
            r101.upload_audio = r102;
            r101.push_response = r102;
            r101.enable_ner = r102;
            r101.scene = Scene.NORMAL_SCENE;
            r101.enable_format = Boolean.TRUE;
            r101.voice_input_device = "";
            r101.enable_markdown = r102;
            long r103 = r100.beginMessage();
        L3:
            int r104 = r100.nextTag();
            if (r104 == (-1)) goto L32;
            switch(r104) {
                case 1: goto L31;
                case 2: goto L30;
                case 3: goto L29;
                case 4: goto L28;
                case 5: goto L36;
                case 6: goto L23;
                case 7: goto L22;
                case 8: goto L21;
                case 9: goto L20;
                case 10: goto L19;
                case 11: goto L18;
                case 12: goto L17;
                case 13: goto L16;
                case 14: goto L15;
                case 15: goto L34;
                case 16: goto L10;
                case 17: goto L9;
                case 18: goto L8;
                case 19: goto L7;
                default: goto L6;
            };
        L34:
            r101.scene = Scene.ADAPTER.decode(r100);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L13
        L13:
            e = move-exception;
            r101.addUnknownField(r104, FieldEncoding.VARINT, Long.valueOf(e.value));
            goto L3
        L36:
            r101.action = Action.ADAPTER.decode(r100);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L26
        L26:
            e = move-exception;
            r101.addUnknownField(r104, FieldEncoding.VARINT, Long.valueOf(e.value));
            goto L3
        L7:
            r101.enable_markdown = ProtoAdapter.BOOL.decode(r100);
            goto L3
        L8:
            r101.voice_input_device = ProtoAdapter.STRING.decode(r100);
            goto L3
        L9:
            r101.speech_scene = SpeechScene.ADAPTER.decode(r100);
            goto L3
        L10:
            r101.enable_format = ProtoAdapter.BOOL.decode(r100);
            goto L3
        L15:
            r101.enable_ner = ProtoAdapter.BOOL.decode(r100);
            goto L3
        L16:
            r101.push_response = ProtoAdapter.BOOL.decode(r100);
            goto L3
        L17:
            r101.upload_audio = ProtoAdapter.BOOL.decode(r100);
            goto L3
        L18:
            r101.chat_id = ProtoAdapter.STRING.decode(r100);
            goto L3
        L19:
            r101.session = ProtoAdapter.STRING.decode(r100);
            goto L3
        L20:
            r101.speech_locale = ProtoAdapter.STRING.decode(r100);
            goto L3
        L21:
            r101.should_diff_result = ProtoAdapter.BOOL.decode(r100);
            goto L3
        L22:
            r101.audio_format = ProtoAdapter.STRING.decode(r100);
            goto L3
        L23:
            r101.audio_rate = ProtoAdapter.INT32.decode(r100);
            goto L3
        L28:
            r101.audio_data = ProtoAdapter.BYTES.decode(r100);
            goto L3
        L29:
            r101.device_locale = ProtoAdapter.STRING.decode(r100);
            goto L3
        L30:
            r101.sequence_id = ProtoAdapter.INT32.decode(r100);
            goto L3
        L31:
            r101.source_id = ProtoAdapter.STRING.decode(r100);
            goto L3
        L6:
            FieldEncoding r105 = r100.peekFieldEncoding();
            r101.addUnknownField(r104, r105, r105.rawProtoAdapter().decode(r100));
            goto L3
        L32:
            r100.endMessage(r103);
            return r101.build();
        }

        /* JADX INFO: renamed from: encodedSize, reason: avoid collision after fix types in other method */
        public int encodedSize2(SendSpeechRecognitionRequest r100) {
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
            String r107 = r100.device_locale;
            if (r107 == null) goto L13;
            int r108 = ProtoAdapter.STRING.encodedSizeWithTag(3, r107);
        L14:
            int r109 = r106 + r108;
            ByteString r110 = r100.audio_data;
            if (r110 == null) goto L17;
            int r111 = ProtoAdapter.BYTES.encodedSizeWithTag(4, r110);
        L18:
            int r112 = r109 + r111;
            Action r113 = r100.action;
            if (r113 == null) goto L21;
            int r114 = Action.ADAPTER.encodedSizeWithTag(5, r113);
        L22:
            int r115 = r112 + r114;
            Integer r116 = r100.audio_rate;
            if (r116 == null) goto L25;
            int r117 = ProtoAdapter.INT32.encodedSizeWithTag(6, r116);
        L26:
            int r118 = r115 + r117;
            String r119 = r100.audio_format;
            if (r119 == null) goto L29;
            int r120 = ProtoAdapter.STRING.encodedSizeWithTag(7, r119);
        L30:
            int r121 = r118 + r120;
            Boolean r122 = r100.should_diff_result;
            if (r122 == null) goto L33;
            int r123 = ProtoAdapter.BOOL.encodedSizeWithTag(8, r122);
        L34:
            int r124 = r121 + r123;
            String r125 = r100.speech_locale;
            if (r125 == null) goto L37;
            int r126 = ProtoAdapter.STRING.encodedSizeWithTag(9, r125);
        L38:
            int r127 = r124 + r126;
            String r128 = r100.session;
            if (r128 == null) goto L41;
            int r129 = ProtoAdapter.STRING.encodedSizeWithTag(10, r128);
        L42:
            int r130 = r127 + r129;
            String r131 = r100.chat_id;
            if (r131 == null) goto L45;
            int r132 = ProtoAdapter.STRING.encodedSizeWithTag(11, r131);
        L46:
            int r133 = r130 + r132;
            Boolean r134 = r100.upload_audio;
            if (r134 == null) goto L49;
            int r135 = ProtoAdapter.BOOL.encodedSizeWithTag(12, r134);
        L50:
            int r136 = r133 + r135;
            Boolean r137 = r100.push_response;
            if (r137 == null) goto L53;
            int r138 = ProtoAdapter.BOOL.encodedSizeWithTag(13, r137);
        L54:
            int r139 = r136 + r138;
            Boolean r140 = r100.enable_ner;
            if (r140 == null) goto L57;
            int r141 = ProtoAdapter.BOOL.encodedSizeWithTag(14, r140);
        L58:
            int r142 = r139 + r141;
            Scene r143 = r100.scene;
            if (r143 == null) goto L61;
            int r144 = Scene.ADAPTER.encodedSizeWithTag(15, r143);
        L62:
            int r145 = r142 + r144;
            Boolean r146 = r100.enable_format;
            if (r146 == null) goto L65;
            int r147 = ProtoAdapter.BOOL.encodedSizeWithTag(16, r146);
        L66:
            int r148 = r145 + r147;
            SpeechScene r149 = r100.speech_scene;
            if (r149 == null) goto L69;
            int r150 = SpeechScene.ADAPTER.encodedSizeWithTag(17, r149);
        L70:
            int r151 = r148 + r150;
            String r152 = r100.voice_input_device;
            if (r152 == null) goto L73;
            int r153 = ProtoAdapter.STRING.encodedSizeWithTag(18, r152);
        L74:
            int r154 = r151 + r153;
            Boolean r155 = r100.enable_markdown;
            if (r155 == null) goto L78;
            r102 = ProtoAdapter.BOOL.encodedSizeWithTag(19, r155);
        L78:
            return (r154 + r102) + r100.unknownFields().size();
        L73:
            r153 = 0;
            goto L74
        L69:
            r150 = 0;
            goto L70
        L65:
            r147 = 0;
            goto L66
        L61:
            r144 = 0;
            goto L62
        L57:
            r141 = 0;
            goto L58
        L53:
            r138 = 0;
            goto L54
        L49:
            r135 = 0;
            goto L50
        L45:
            r132 = 0;
            goto L46
        L41:
            r129 = 0;
            goto L42
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
        public /* bridge */ /* synthetic */ SendSpeechRecognitionRequest decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(SendSpeechRecognitionRequest r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, SendSpeechRecognitionRequest r101) throws IOException {
            String r102 = r101.source_id;
            if (r102 == null) goto L5;
            ProtoAdapter.STRING.encodeWithTag(r100, 1, r102);
        L5:
            Integer r103 = r101.sequence_id;
            if (r103 == null) goto L8;
            ProtoAdapter.INT32.encodeWithTag(r100, 2, r103);
        L8:
            String r104 = r101.device_locale;
            if (r104 == null) goto L11;
            ProtoAdapter.STRING.encodeWithTag(r100, 3, r104);
        L11:
            ByteString r105 = r101.audio_data;
            if (r105 == null) goto L14;
            ProtoAdapter.BYTES.encodeWithTag(r100, 4, r105);
        L14:
            Action r106 = r101.action;
            if (r106 == null) goto L17;
            Action.ADAPTER.encodeWithTag(r100, 5, r106);
        L17:
            Integer r107 = r101.audio_rate;
            if (r107 == null) goto L20;
            ProtoAdapter.INT32.encodeWithTag(r100, 6, r107);
        L20:
            String r108 = r101.audio_format;
            if (r108 == null) goto L23;
            ProtoAdapter.STRING.encodeWithTag(r100, 7, r108);
        L23:
            Boolean r109 = r101.should_diff_result;
            if (r109 == null) goto L26;
            ProtoAdapter.BOOL.encodeWithTag(r100, 8, r109);
        L26:
            String r110 = r101.speech_locale;
            if (r110 == null) goto L29;
            ProtoAdapter.STRING.encodeWithTag(r100, 9, r110);
        L29:
            String r111 = r101.session;
            if (r111 == null) goto L32;
            ProtoAdapter.STRING.encodeWithTag(r100, 10, r111);
        L32:
            String r112 = r101.chat_id;
            if (r112 == null) goto L35;
            ProtoAdapter.STRING.encodeWithTag(r100, 11, r112);
        L35:
            Boolean r113 = r101.upload_audio;
            if (r113 == null) goto L38;
            ProtoAdapter.BOOL.encodeWithTag(r100, 12, r113);
        L38:
            Boolean r114 = r101.push_response;
            if (r114 == null) goto L41;
            ProtoAdapter.BOOL.encodeWithTag(r100, 13, r114);
        L41:
            Boolean r115 = r101.enable_ner;
            if (r115 == null) goto L44;
            ProtoAdapter.BOOL.encodeWithTag(r100, 14, r115);
        L44:
            Scene r116 = r101.scene;
            if (r116 == null) goto L47;
            Scene.ADAPTER.encodeWithTag(r100, 15, r116);
        L47:
            Boolean r117 = r101.enable_format;
            if (r117 == null) goto L50;
            ProtoAdapter.BOOL.encodeWithTag(r100, 16, r117);
        L50:
            SpeechScene r118 = r101.speech_scene;
            if (r118 == null) goto L53;
            SpeechScene.ADAPTER.encodeWithTag(r100, 17, r118);
        L53:
            String r119 = r101.voice_input_device;
            if (r119 == null) goto L56;
            ProtoAdapter.STRING.encodeWithTag(r100, 18, r119);
        L56:
            Boolean r120 = r101.enable_markdown;
            if (r120 == null) goto L59;
            ProtoAdapter.BOOL.encodeWithTag(r100, 19, r120);
        L59:
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, SendSpeechRecognitionRequest r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ProtoAdapter_SendSpeechRecognitionRequest r100 = new ProtoAdapter_SendSpeechRecognitionRequest();
        RAW_TYPE_ADAPTER = r100;
        ADAPTER = r100;
        DEFAULT_SEQUENCE_ID = 0;
        DEFAULT_AUDIO_DATA = ByteString.EMPTY;
        DEFAULT_ACTION = Action.UNKNOWN;
        DEFAULT_AUDIO_RATE = 16;
        Boolean r101 = Boolean.FALSE;
        DEFAULT_SHOULD_DIFF_RESULT = r101;
        DEFAULT_UPLOAD_AUDIO = r101;
        DEFAULT_PUSH_RESPONSE = r101;
        DEFAULT_ENABLE_NER = r101;
        DEFAULT_SCENE = Scene.NORMAL_SCENE;
        DEFAULT_ENABLE_FORMAT = Boolean.TRUE;
        DEFAULT_ENABLE_MARKDOWN = r101;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.source_id = this.source_id;
        r100.sequence_id = this.sequence_id;
        r100.device_locale = this.device_locale;
        r100.audio_data = this.audio_data;
        r100.action = this.action;
        r100.audio_rate = this.audio_rate;
        r100.audio_format = this.audio_format;
        r100.should_diff_result = this.should_diff_result;
        r100.speech_locale = this.speech_locale;
        r100.session = this.session;
        r100.chat_id = this.chat_id;
        r100.upload_audio = this.upload_audio;
        r100.push_response = this.push_response;
        r100.enable_ner = this.enable_ner;
        r100.scene = this.scene;
        r100.enable_format = this.enable_format;
        r100.speech_scene = this.speech_scene;
        r100.voice_input_device = this.voice_input_device;
        r100.enable_markdown = this.enable_markdown;
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return SendSpeechRecognitionRequest.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public SendSpeechRecognitionRequest(String r210, Integer r211, String r212, ByteString r213, Action r214, Integer r215, String r216, Boolean r217, String r310, String r311, String r312, Boolean r313, Boolean r314, Boolean r315, Scene r316, Boolean r317, SpeechScene r318, String r319, Boolean r410) {
        this(r210, r211, r212, r213, r214, r215, r216, r217, r310, r311, r312, r313, r314, r315, r316, r317, r318, r319, r410, ByteString.EMPTY);
    }

    public SendSpeechRecognitionRequest(String r100, Integer r101, String r102, ByteString r103, Action r104, Integer r105, String r110, Boolean r111, String r112, String r113, String r114, Boolean r115, Boolean r116, Boolean r117, Scene r118, Boolean r119, SpeechScene r210, String r211, Boolean r212, ByteString r213) {
        super(ADAPTER, r213);
        this.source_id = r100;
        this.sequence_id = r101;
        this.device_locale = r102;
        this.audio_data = r103;
        this.action = r104;
        this.audio_rate = r105;
        this.audio_format = r110;
        this.should_diff_result = r111;
        this.speech_locale = r112;
        this.session = r113;
        this.chat_id = r114;
        this.upload_audio = r115;
        this.push_response = r116;
        this.enable_ner = r117;
        this.scene = r118;
        this.enable_format = r119;
        this.speech_scene = r210;
        this.voice_input_device = r211;
        this.enable_markdown = r212;
    }
}
