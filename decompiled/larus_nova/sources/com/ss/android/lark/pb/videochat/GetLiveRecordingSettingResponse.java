package com.ss.android.lark.pb.videochat;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import com.squareup.wire.internal.Internal;
import java.io.IOException;
import java.util.List;
import okio.ByteString;

/* JADX INFO: loaded from: classes37.dex */
public final class GetLiveRecordingSettingResponse extends Message<GetLiveRecordingSettingResponse, Builder> {
    public static final ProtoAdapter<GetLiveRecordingSettingResponse> ADAPTER = null;
    public static final Boolean DEFAULT_CAN_RECORDING_MARK = null;
    public static final Boolean DEFAULT_IS_BILINGUAL = null;
    public static final Long DEFAULT_WAITING_TIME = null;
    private static final long serialVersionUID = 0;
    public final Boolean mcan_recording_mark;
    public final Boolean mis_bilingual;
    public final SubtitleLanguage mspoken_language;
    public final List<SubtitleLanguage> mspoken_language_list;
    public final SubtitleLanguage mtranslation_language;
    public final List<SubtitleLanguage> mtranslation_language_list;
    public final Long mwaiting_time;

    public static final class Builder extends Message.Builder<GetLiveRecordingSettingResponse, Builder> {
        public Boolean mcan_recording_mark;
        public Boolean mis_bilingual;
        public SubtitleLanguage mspoken_language;
        public List<SubtitleLanguage> mspoken_language_list;
        public SubtitleLanguage mtranslation_language;
        public List<SubtitleLanguage> mtranslation_language_list;
        public Long mwaiting_time;

        @Override // com.squareup.wire.Message.Builder
        public GetLiveRecordingSettingResponse build() {
            return new GetLiveRecordingSettingResponse(this.mspoken_language_list, this.mtranslation_language_list, this.mspoken_language, this.mtranslation_language, this.mis_bilingual, this.mwaiting_time, this.mcan_recording_mark, super.buildUnknownFields());
        }

        public Builder() {
            this.mspoken_language_list = Internal.newMutableList();
            this.mtranslation_language_list = Internal.newMutableList();
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder can_recording_mark(Boolean r100) {
            this.mcan_recording_mark = r100;
            return this;
        }

        public Builder is_bilingual(Boolean r100) {
            this.mis_bilingual = r100;
            return this;
        }

        public Builder spoken_language(SubtitleLanguage r100) {
            this.mspoken_language = r100;
            return this;
        }

        public Builder spoken_language_list(List<SubtitleLanguage> r100) {
            Internal.checkElementsNotNull(r100);
            this.mspoken_language_list = r100;
            return this;
        }

        public Builder translation_language(SubtitleLanguage r100) {
            this.mtranslation_language = r100;
            return this;
        }

        public Builder translation_language_list(List<SubtitleLanguage> r100) {
            Internal.checkElementsNotNull(r100);
            this.mtranslation_language_list = r100;
            return this;
        }

        public Builder waiting_time(Long r100) {
            this.mwaiting_time = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_GetLiveRecordingSettingResponse extends ProtoAdapter<GetLiveRecordingSettingResponse> {
        public ProtoAdapter_GetLiveRecordingSettingResponse() {
            super(FieldEncoding.LENGTH_DELIMITED, GetLiveRecordingSettingResponse.class);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public GetLiveRecordingSettingResponse decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            Boolean r102 = Boolean.FALSE;
            r101.mis_bilingual = r102;
            r101.mwaiting_time = 0L;
            r101.mcan_recording_mark = r102;
            long r103 = r100.beginMessage();
        L3:
            int r104 = r100.nextTag();
            if (r104 == (-1)) goto L14;
            switch(r104) {
                case 1: goto L13;
                case 2: goto L12;
                case 3: goto L11;
                case 4: goto L10;
                case 5: goto L9;
                case 6: goto L8;
                case 7: goto L7;
                default: goto L6;
            };
        L7:
            r101.mcan_recording_mark = ProtoAdapter.BOOL.decode(r100);
            goto L3
        L8:
            r101.mwaiting_time = ProtoAdapter.INT64.decode(r100);
            goto L3
        L9:
            r101.mis_bilingual = ProtoAdapter.BOOL.decode(r100);
            goto L3
        L10:
            r101.mtranslation_language = SubtitleLanguage.ADAPTER.decode(r100);
            goto L3
        L11:
            r101.mspoken_language = SubtitleLanguage.ADAPTER.decode(r100);
            goto L3
        L12:
            r101.mtranslation_language_list.add(SubtitleLanguage.ADAPTER.decode(r100));
            goto L3
        L13:
            r101.mspoken_language_list.add(SubtitleLanguage.ADAPTER.decode(r100));
            goto L3
        L6:
            FieldEncoding r105 = r100.peekFieldEncoding();
            r101.addUnknownField(r104, r105, r105.rawProtoAdapter().decode(r100));
            goto L3
        L14:
            r100.endMessage(r103);
            return r101.build();
        }

        /* JADX INFO: renamed from: encodedSize, reason: avoid collision after fix types in other method */
        public int encodedSize2(GetLiveRecordingSettingResponse r100) {
            ProtoAdapter<SubtitleLanguage> r101 = SubtitleLanguage.ADAPTER;
            int r102 = r101.asRepeated().encodedSizeWithTag(1, r100.mspoken_language_list) + r101.asRepeated().encodedSizeWithTag(2, r100.mtranslation_language_list);
            SubtitleLanguage r103 = r100.mspoken_language;
            int r104 = 0;
            if (r103 == null) goto L5;
            int r105 = r101.encodedSizeWithTag(3, r103);
        L6:
            int r106 = r102 + r105;
            SubtitleLanguage r107 = r100.mtranslation_language;
            if (r107 == null) goto L9;
            int r108 = r101.encodedSizeWithTag(4, r107);
        L10:
            int r109 = r106 + r108;
            Boolean r110 = r100.mis_bilingual;
            if (r110 == null) goto L13;
            int r111 = ProtoAdapter.BOOL.encodedSizeWithTag(5, r110);
        L14:
            int r112 = r109 + r111;
            Long r113 = r100.mwaiting_time;
            if (r113 == null) goto L17;
            int r114 = ProtoAdapter.INT64.encodedSizeWithTag(6, r113);
        L18:
            int r115 = r112 + r114;
            Boolean r116 = r100.mcan_recording_mark;
            if (r116 == null) goto L22;
            r104 = ProtoAdapter.BOOL.encodedSizeWithTag(7, r116);
        L22:
            return (r115 + r104) + r100.unknownFields().size();
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
        public /* bridge */ /* synthetic */ GetLiveRecordingSettingResponse decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(GetLiveRecordingSettingResponse r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, GetLiveRecordingSettingResponse r101) throws IOException {
            ProtoAdapter<SubtitleLanguage> r102 = SubtitleLanguage.ADAPTER;
            r102.asRepeated().encodeWithTag(r100, 1, r101.mspoken_language_list);
            r102.asRepeated().encodeWithTag(r100, 2, r101.mtranslation_language_list);
            SubtitleLanguage r103 = r101.mspoken_language;
            if (r103 == null) goto L5;
            r102.encodeWithTag(r100, 3, r103);
        L5:
            SubtitleLanguage r104 = r101.mtranslation_language;
            if (r104 == null) goto L8;
            r102.encodeWithTag(r100, 4, r104);
        L8:
            Boolean r105 = r101.mis_bilingual;
            if (r105 == null) goto L11;
            ProtoAdapter.BOOL.encodeWithTag(r100, 5, r105);
        L11:
            Long r106 = r101.mwaiting_time;
            if (r106 == null) goto L14;
            ProtoAdapter.INT64.encodeWithTag(r100, 6, r106);
        L14:
            Boolean r107 = r101.mcan_recording_mark;
            if (r107 == null) goto L17;
            ProtoAdapter.BOOL.encodeWithTag(r100, 7, r107);
        L17:
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, GetLiveRecordingSettingResponse r101) throws IOException {
            encode2(r100, r101);
        }
    }

    public static final class SubtitleLanguage extends Message<SubtitleLanguage, Builder> {
        public static final ProtoAdapter<SubtitleLanguage> ADAPTER = null;
        public static final String DEFAULT_DESCRIPTION_I18N = "";
        public static final String DEFAULT_LANGUAGE = "";
        private static final long serialVersionUID = 0;
        public final String mdescription_i18n;
        public final String mlanguage;

        public static final class Builder extends Message.Builder<SubtitleLanguage, Builder> {
            public String mdescription_i18n;
            public String mlanguage;

            @Override // com.squareup.wire.Message.Builder
            public SubtitleLanguage build() {
                return new SubtitleLanguage(this.mlanguage, this.mdescription_i18n, super.buildUnknownFields());
            }

            public Builder() {
            }

            @Override // com.squareup.wire.Message.Builder
            public /* bridge */ /* synthetic */ Message build() {
                return build();
            }

            public Builder description_i18n(String r100) {
                this.mdescription_i18n = r100;
                return this;
            }

            public Builder language(String r100) {
                this.mlanguage = r100;
                return this;
            }
        }

        public static final class ProtoAdapter_SubtitleLanguage extends ProtoAdapter<SubtitleLanguage> {
            public ProtoAdapter_SubtitleLanguage() {
                super(FieldEncoding.LENGTH_DELIMITED, SubtitleLanguage.class);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.squareup.wire.ProtoAdapter
            public SubtitleLanguage decode(ProtoReader r100) throws IOException {
                Builder r101 = new Builder();
                r101.mlanguage = "";
                r101.mdescription_i18n = "";
                long r102 = r100.beginMessage();
            L3:
                int r103 = r100.nextTag();
                if (r103 == (-1)) goto L12;
                if (r103 != 1) goto L8;
                r101.mlanguage = ProtoAdapter.STRING.decode(r100);
                goto L3
            L8:
                if (r103 != 2) goto L9;
                r101.mdescription_i18n = ProtoAdapter.STRING.decode(r100);
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
            public int encodedSize2(SubtitleLanguage r100) {
                String r101 = r100.mlanguage;
                int r102 = 0;
                if (r101 == null) goto L5;
                int r103 = ProtoAdapter.STRING.encodedSizeWithTag(1, r101);
            L6:
                String r104 = r100.mdescription_i18n;
                if (r104 == null) goto L10;
                r102 = ProtoAdapter.STRING.encodedSizeWithTag(2, r104);
            L10:
                return (r103 + r102) + r100.unknownFields().size();
            L5:
                r103 = 0;
                goto L6
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ SubtitleLanguage decode(ProtoReader r100) throws IOException {
                return decode(r100);
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ int encodedSize(SubtitleLanguage r100) {
                return encodedSize2(r100);
            }

            /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
            public void encode2(ProtoWriter r100, SubtitleLanguage r101) throws IOException {
                String r102 = r101.mlanguage;
                if (r102 == null) goto L5;
                ProtoAdapter.STRING.encodeWithTag(r100, 1, r102);
            L5:
                String r103 = r101.mdescription_i18n;
                if (r103 == null) goto L8;
                ProtoAdapter.STRING.encodeWithTag(r100, 2, r103);
            L8:
                r100.writeBytes(r101.unknownFields());
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, SubtitleLanguage r101) throws IOException {
                encode2(r100, r101);
            }
        }

        static {
            ADAPTER = new ProtoAdapter_SubtitleLanguage();
        }

        @Override // com.squareup.wire.Message
        public Builder newBuilder() {
            Builder r100 = new Builder();
            r100.mlanguage = this.mlanguage;
            r100.mdescription_i18n = this.mdescription_i18n;
            r100.addUnknownFields(unknownFields());
            return r100;
        }

        @Override // com.squareup.wire.Message
        public String toString() {
            return SubtitleLanguage.class.getName() + "@" + Integer.toHexString(hashCode());
        }

        @Override // com.squareup.wire.Message
        public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
            return newBuilder();
        }

        public SubtitleLanguage(String r100, String r101) {
            this(r100, r101, ByteString.EMPTY);
        }

        public SubtitleLanguage(String r100, String r101, ByteString r102) {
            super(ADAPTER, r102);
            this.mlanguage = r100;
            this.mdescription_i18n = r101;
        }
    }

    static {
        ADAPTER = new ProtoAdapter_GetLiveRecordingSettingResponse();
        Boolean r100 = Boolean.FALSE;
        DEFAULT_IS_BILINGUAL = r100;
        DEFAULT_WAITING_TIME = 0L;
        DEFAULT_CAN_RECORDING_MARK = r100;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.mspoken_language_list = Internal.copyOf("mspoken_language_list", this.mspoken_language_list);
        r100.mtranslation_language_list = Internal.copyOf("mtranslation_language_list", this.mtranslation_language_list);
        r100.mspoken_language = this.mspoken_language;
        r100.mtranslation_language = this.mtranslation_language;
        r100.mis_bilingual = this.mis_bilingual;
        r100.mwaiting_time = this.mwaiting_time;
        r100.mcan_recording_mark = this.mcan_recording_mark;
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return GetLiveRecordingSettingResponse.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public GetLiveRecordingSettingResponse(List<SubtitleLanguage> r110, List<SubtitleLanguage> r111, SubtitleLanguage r112, SubtitleLanguage r113, Boolean r114, Long r115, Boolean r116) {
        this(r110, r111, r112, r113, r114, r115, r116, ByteString.EMPTY);
    }

    public GetLiveRecordingSettingResponse(List<SubtitleLanguage> r100, List<SubtitleLanguage> r101, SubtitleLanguage r102, SubtitleLanguage r103, Boolean r104, Long r105, Boolean r106, ByteString r107) {
        super(ADAPTER, r107);
        this.mspoken_language_list = Internal.immutableCopyOf("mspoken_language_list", r100);
        this.mtranslation_language_list = Internal.immutableCopyOf("mtranslation_language_list", r101);
        this.mspoken_language = r102;
        this.mtranslation_language = r103;
        this.mis_bilingual = r104;
        this.mwaiting_time = r105;
        this.mcan_recording_mark = r106;
    }
}
