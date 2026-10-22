package com.ss.android.lark.pb.videochat;

import com.google.protobuf.server.FieldOptions;
import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import com.squareup.wire.WireEnum;
import java.io.IOException;
import okio.ByteString;
import r27.a;

/* JADX INFO: loaded from: classes37.dex */
public final class UpdateLiveRecordingSettingRequest extends Message<UpdateLiveRecordingSettingRequest, Builder> {
    public static final ProtoAdapter<UpdateLiveRecordingSettingRequest> ADAPTER = null;
    public static final Boolean DEFAULT_IS_AUTO_SET_BILINGUAL = null;
    public static final Boolean DEFAULT_IS_AUTO_SET_TRANSCRIPT_LANGUAGE = null;
    public static final Boolean DEFAULT_IS_BILINGUAL = null;
    public static final String DEFAULT_MEETING_ID = "";
    public static final String DEFAULT_ORIGINAL_MEETING_ID = "";
    public static final String DEFAULT_SOURCE_TYPE = "";
    public static final String DEFAULT_SPOKEN_LANGUAGE = "";
    public static final String DEFAULT_TRANSLATION_LANGUAGE = "";
    public static final FieldOptions FIELD_OPTIONS_MMEETING_ID = null;
    private static final long serialVersionUID = 0;
    public final Action maction;
    public final Boolean mis_auto_set_bilingual;
    public final Boolean mis_auto_set_transcript_language;
    public final Boolean mis_bilingual;
    public final String mmeeting_id;
    public final String moriginal_meeting_id;
    public final String msource_type;
    public final String mspoken_language;
    public final String mtranslation_language;

    public static final enum Action extends Enum<Action> implements WireEnum {
        private static final /* synthetic */ Action[] $VALUES = null;
        public static final ProtoAdapter<Action> ADAPTER = null;
        public static final Action SET_BILINGUAL_STATUS = null;
        public static final Action SET_SPOKEN_LANGUAGE = null;
        public static final Action SET_TRANSLATION_LANGUAGE = null;
        public static final Action TURN_OFF = null;
        public static final Action TURN_ON = null;
        public static final Action UNKNOWN = null;
        private final int value;

        static {
            Action r100 = new Action("UNKNOWN", 0, 0);
            UNKNOWN = r100;
            Action r101 = new Action("TURN_ON", 1, 1);
            TURN_ON = r101;
            Action r102 = new Action("TURN_OFF", 2, 2);
            TURN_OFF = r102;
            Action r103 = new Action("SET_SPOKEN_LANGUAGE", 3, 3);
            SET_SPOKEN_LANGUAGE = r103;
            Action r104 = new Action("SET_TRANSLATION_LANGUAGE", 4, 4);
            SET_TRANSLATION_LANGUAGE = r104;
            Action r105 = new Action("SET_BILINGUAL_STATUS", 5, 5);
            SET_BILINGUAL_STATUS = r105;
            $VALUES = new Action[]{r100, r101, r102, r103, r104, r105};
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
            if (r100 == 0) goto L26;
            if (r100 == 1) goto L24;
            if (r100 == 2) goto L22;
            if (r100 == 3) goto L20;
            if (r100 == 4) goto L18;
            if (r100 == 5) goto L16;
            return null;
        L16:
            return SET_BILINGUAL_STATUS;
        L18:
            return SET_TRANSLATION_LANGUAGE;
        L20:
            return SET_SPOKEN_LANGUAGE;
        L22:
            return TURN_OFF;
        L24:
            return TURN_ON;
        L26:
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

    public static final class Builder extends Message.Builder<UpdateLiveRecordingSettingRequest, Builder> {
        public Action maction;
        public Boolean mis_auto_set_bilingual;
        public Boolean mis_auto_set_transcript_language;
        public Boolean mis_bilingual;
        public String mmeeting_id;
        public String moriginal_meeting_id;
        public String msource_type;
        public String mspoken_language;
        public String mtranslation_language;

        @Override // com.squareup.wire.Message.Builder
        public UpdateLiveRecordingSettingRequest build() {
            return new UpdateLiveRecordingSettingRequest(this.mmeeting_id, this.maction, this.mspoken_language, this.mtranslation_language, this.mis_bilingual, this.mis_auto_set_transcript_language, this.mis_auto_set_bilingual, this.moriginal_meeting_id, this.msource_type, super.buildUnknownFields());
        }

        public Builder() {
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder action(Action r100) {
            this.maction = r100;
            return this;
        }

        public Builder is_auto_set_bilingual(Boolean r100) {
            this.mis_auto_set_bilingual = r100;
            return this;
        }

        public Builder is_auto_set_transcript_language(Boolean r100) {
            this.mis_auto_set_transcript_language = r100;
            return this;
        }

        public Builder is_bilingual(Boolean r100) {
            this.mis_bilingual = r100;
            return this;
        }

        public Builder meeting_id(String r100) {
            this.mmeeting_id = r100;
            return this;
        }

        public Builder original_meeting_id(String r100) {
            this.moriginal_meeting_id = r100;
            return this;
        }

        public Builder source_type(String r100) {
            this.msource_type = r100;
            return this;
        }

        public Builder spoken_language(String r100) {
            this.mspoken_language = r100;
            return this;
        }

        public Builder translation_language(String r100) {
            this.mtranslation_language = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_UpdateLiveRecordingSettingRequest extends ProtoAdapter<UpdateLiveRecordingSettingRequest> {
        public ProtoAdapter_UpdateLiveRecordingSettingRequest() {
            super(FieldEncoding.LENGTH_DELIMITED, UpdateLiveRecordingSettingRequest.class);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public UpdateLiveRecordingSettingRequest decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            r101.mmeeting_id = "";
            r101.mspoken_language = "";
            r101.mtranslation_language = "";
            Boolean r102 = Boolean.FALSE;
            r101.mis_bilingual = r102;
            r101.mis_auto_set_transcript_language = r102;
            r101.mis_auto_set_bilingual = r102;
            r101.moriginal_meeting_id = "";
            r101.msource_type = "";
            long r103 = r100.beginMessage();
        L3:
            int r104 = r100.nextTag();
            if (r104 == (-1)) goto L19;
            switch(r104) {
                case 1: goto L18;
                case 2: goto L21;
                case 3: goto L13;
                case 4: goto L12;
                case 5: goto L11;
                case 6: goto L10;
                case 7: goto L9;
                case 8: goto L8;
                case 9: goto L7;
                default: goto L6;
            };
        L21:
            r101.maction = Action.ADAPTER.decode(r100);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L16
        L16:
            e = move-exception;
            r101.addUnknownField(r104, FieldEncoding.VARINT, Long.valueOf(e.value));
            goto L3
        L7:
            r101.msource_type = ProtoAdapter.STRING.decode(r100);
            goto L3
        L8:
            r101.moriginal_meeting_id = ProtoAdapter.STRING.decode(r100);
            goto L3
        L9:
            r101.mis_auto_set_bilingual = ProtoAdapter.BOOL.decode(r100);
            goto L3
        L10:
            r101.mis_auto_set_transcript_language = ProtoAdapter.BOOL.decode(r100);
            goto L3
        L11:
            r101.mis_bilingual = ProtoAdapter.BOOL.decode(r100);
            goto L3
        L12:
            r101.mtranslation_language = ProtoAdapter.STRING.decode(r100);
            goto L3
        L13:
            r101.mspoken_language = ProtoAdapter.STRING.decode(r100);
            goto L3
        L18:
            r101.mmeeting_id = ProtoAdapter.STRING.decode(r100);
            goto L3
        L6:
            FieldEncoding r105 = r100.peekFieldEncoding();
            r101.addUnknownField(r104, r105, r105.rawProtoAdapter().decode(r100));
            goto L3
        L19:
            r100.endMessage(r103);
            return r101.build();
        }

        /* JADX INFO: renamed from: encodedSize, reason: avoid collision after fix types in other method */
        public int encodedSize2(UpdateLiveRecordingSettingRequest r100) {
            String r101 = r100.mmeeting_id;
            int r102 = 0;
            if (r101 == null) goto L5;
            int r103 = ProtoAdapter.STRING.encodedSizeWithTag(1, r101);
        L6:
            Action r104 = r100.maction;
            if (r104 == null) goto L9;
            int r105 = Action.ADAPTER.encodedSizeWithTag(2, r104);
        L10:
            int r106 = r103 + r105;
            String r107 = r100.mspoken_language;
            if (r107 == null) goto L13;
            int r108 = ProtoAdapter.STRING.encodedSizeWithTag(3, r107);
        L14:
            int r109 = r106 + r108;
            String r110 = r100.mtranslation_language;
            if (r110 == null) goto L17;
            int r111 = ProtoAdapter.STRING.encodedSizeWithTag(4, r110);
        L18:
            int r112 = r109 + r111;
            Boolean r113 = r100.mis_bilingual;
            if (r113 == null) goto L21;
            int r114 = ProtoAdapter.BOOL.encodedSizeWithTag(5, r113);
        L22:
            int r115 = r112 + r114;
            Boolean r116 = r100.mis_auto_set_transcript_language;
            if (r116 == null) goto L25;
            int r117 = ProtoAdapter.BOOL.encodedSizeWithTag(6, r116);
        L26:
            int r118 = r115 + r117;
            Boolean r119 = r100.mis_auto_set_bilingual;
            if (r119 == null) goto L29;
            int r120 = ProtoAdapter.BOOL.encodedSizeWithTag(7, r119);
        L30:
            int r121 = r118 + r120;
            String r122 = r100.moriginal_meeting_id;
            if (r122 == null) goto L33;
            int r123 = ProtoAdapter.STRING.encodedSizeWithTag(8, r122);
        L34:
            int r124 = r121 + r123;
            String r125 = r100.msource_type;
            if (r125 == null) goto L38;
            r102 = ProtoAdapter.STRING.encodedSizeWithTag(9, r125);
        L38:
            return (r124 + r102) + r100.unknownFields().size();
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
        public /* bridge */ /* synthetic */ UpdateLiveRecordingSettingRequest decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(UpdateLiveRecordingSettingRequest r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, UpdateLiveRecordingSettingRequest r101) throws IOException {
            String r102 = r101.mmeeting_id;
            if (r102 == null) goto L5;
            ProtoAdapter.STRING.encodeWithTag(r100, 1, r102);
        L5:
            Action r103 = r101.maction;
            if (r103 == null) goto L8;
            Action.ADAPTER.encodeWithTag(r100, 2, r103);
        L8:
            String r104 = r101.mspoken_language;
            if (r104 == null) goto L11;
            ProtoAdapter.STRING.encodeWithTag(r100, 3, r104);
        L11:
            String r105 = r101.mtranslation_language;
            if (r105 == null) goto L14;
            ProtoAdapter.STRING.encodeWithTag(r100, 4, r105);
        L14:
            Boolean r106 = r101.mis_bilingual;
            if (r106 == null) goto L17;
            ProtoAdapter.BOOL.encodeWithTag(r100, 5, r106);
        L17:
            Boolean r107 = r101.mis_auto_set_transcript_language;
            if (r107 == null) goto L20;
            ProtoAdapter.BOOL.encodeWithTag(r100, 6, r107);
        L20:
            Boolean r108 = r101.mis_auto_set_bilingual;
            if (r108 == null) goto L23;
            ProtoAdapter.BOOL.encodeWithTag(r100, 7, r108);
        L23:
            String r109 = r101.moriginal_meeting_id;
            if (r109 == null) goto L26;
            ProtoAdapter.STRING.encodeWithTag(r100, 8, r109);
        L26:
            String r110 = r101.msource_type;
            if (r110 == null) goto L29;
            ProtoAdapter.STRING.encodeWithTag(r100, 9, r110);
        L29:
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, UpdateLiveRecordingSettingRequest r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_UpdateLiveRecordingSettingRequest();
        FIELD_OPTIONS_MMEETING_ID = new FieldOptions.Builder().FieldInfo("split,type=meeting").build();
        Boolean r100 = Boolean.FALSE;
        DEFAULT_IS_BILINGUAL = r100;
        DEFAULT_IS_AUTO_SET_TRANSCRIPT_LANGUAGE = r100;
        DEFAULT_IS_AUTO_SET_BILINGUAL = r100;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.mmeeting_id = this.mmeeting_id;
        r100.maction = this.maction;
        r100.mspoken_language = this.mspoken_language;
        r100.mtranslation_language = this.mtranslation_language;
        r100.mis_bilingual = this.mis_bilingual;
        r100.mis_auto_set_transcript_language = this.mis_auto_set_transcript_language;
        r100.mis_auto_set_bilingual = this.mis_auto_set_bilingual;
        r100.moriginal_meeting_id = this.moriginal_meeting_id;
        r100.msource_type = this.msource_type;
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return UpdateLiveRecordingSettingRequest.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public UpdateLiveRecordingSettingRequest(String r110, Action r111, String r112, String r113, Boolean r114, Boolean r115, Boolean r116, String r117, String r210) {
        this(r110, r111, r112, r113, r114, r115, r116, r117, r210, ByteString.EMPTY);
    }

    public UpdateLiveRecordingSettingRequest(String r100, Action r101, String r102, String r103, Boolean r104, Boolean r105, Boolean r106, String r107, String r110, ByteString r111) {
        super(ADAPTER, r111);
        this.mmeeting_id = r100;
        this.maction = r101;
        this.mspoken_language = r102;
        this.mtranslation_language = r103;
        this.mis_bilingual = r104;
        this.mis_auto_set_transcript_language = r105;
        this.mis_auto_set_bilingual = r106;
        this.moriginal_meeting_id = r107;
        this.msource_type = r110;
    }
}
