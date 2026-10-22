package com.bytedance.lark.pb.feed.v1;

import annotation.Debug;
import com.google.protobuf.FieldOptions;
import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import java.io.IOException;
import okio.ByteString;

/* JADX INFO: loaded from: classes20.dex */
public final class MeetingContent extends Message<MeetingContent, Builder> {
    public static final ProtoAdapter<MeetingContent> ADAPTER = null;
    public static final Boolean DEFAULT_IS_IN_MEETING = null;
    public static final Boolean DEFAULT_IS_WEBINAR = null;
    public static final Integer DEFAULT_MEETING_COUNT = null;
    public static final String DEFAULT_MEETING_DIGEST = "";
    public static final Long DEFAULT_MEETING_ID = null;
    public static final Long DEFAULT_MEETING_NUMBER = null;
    public static final Integer DEFAULT_MEETING_SUB_TYPE = null;
    public static final Boolean DEFAULT_REHEARSAL_STATUS_ON = null;
    public static final String DEFAULT_TITLE = "";
    public static final FieldOptions FIELD_OPTIONS_IS_IN_MEETING = null;
    public static final FieldOptions FIELD_OPTIONS_IS_WEBINAR = null;
    public static final FieldOptions FIELD_OPTIONS_MEETING_COUNT = null;
    public static final FieldOptions FIELD_OPTIONS_MEETING_ID = null;
    public static final FieldOptions FIELD_OPTIONS_MEETING_NUMBER = null;
    public static final FieldOptions FIELD_OPTIONS_MEETING_SUB_TYPE = null;
    public static final FieldOptions FIELD_OPTIONS_REHEARSAL_STATUS_ON = null;
    private static final long serialVersionUID = 0;
    public final Boolean is_in_meeting;
    public final Boolean is_webinar;
    public final Integer meeting_count;
    public final String meeting_digest;
    public final Long meeting_id;
    public final Long meeting_number;
    public final Integer meeting_sub_type;
    public final Boolean rehearsal_status_on;
    public final String title;

    public static final class Builder extends Message.Builder<MeetingContent, Builder> {
        public Boolean is_in_meeting;
        public Boolean is_webinar;
        public Integer meeting_count;
        public String meeting_digest;
        public Long meeting_id;
        public Long meeting_number;
        public Integer meeting_sub_type;
        public Boolean rehearsal_status_on;
        public String title;

        @Override // com.squareup.wire.Message.Builder
        public MeetingContent build() {
            return new MeetingContent(this.title, this.meeting_id, this.meeting_count, this.meeting_digest, this.is_webinar, this.rehearsal_status_on, this.is_in_meeting, this.meeting_sub_type, this.meeting_number, super.buildUnknownFields());
        }

        public Builder() {
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder is_in_meeting(Boolean r100) {
            this.is_in_meeting = r100;
            return this;
        }

        public Builder is_webinar(Boolean r100) {
            this.is_webinar = r100;
            return this;
        }

        public Builder meeting_count(Integer r100) {
            this.meeting_count = r100;
            return this;
        }

        public Builder meeting_digest(String r100) {
            this.meeting_digest = r100;
            return this;
        }

        public Builder meeting_id(Long r100) {
            this.meeting_id = r100;
            return this;
        }

        public Builder meeting_number(Long r100) {
            this.meeting_number = r100;
            return this;
        }

        public Builder meeting_sub_type(Integer r100) {
            this.meeting_sub_type = r100;
            return this;
        }

        public Builder rehearsal_status_on(Boolean r100) {
            this.rehearsal_status_on = r100;
            return this;
        }

        public Builder title(String r100) {
            this.title = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_MeetingContent extends ProtoAdapter<MeetingContent> {
        public ProtoAdapter_MeetingContent() {
            super(FieldEncoding.LENGTH_DELIMITED, MeetingContent.class);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public MeetingContent decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            r101.title = "";
            r101.meeting_id = 0L;
            r101.meeting_count = 0;
            r101.meeting_digest = "";
            Boolean r102 = Boolean.FALSE;
            r101.is_webinar = r102;
            r101.rehearsal_status_on = r102;
            r101.is_in_meeting = r102;
            r101.meeting_sub_type = 0;
            r101.meeting_number = 0L;
            long r103 = r100.beginMessage();
        L3:
            int r104 = r100.nextTag();
            if (r104 == (-1)) goto L16;
            switch(r104) {
                case 1: goto L15;
                case 2: goto L14;
                case 3: goto L13;
                case 4: goto L12;
                case 5: goto L11;
                case 6: goto L10;
                case 7: goto L9;
                case 8: goto L8;
                case 9: goto L7;
                default: goto L6;
            };
        L7:
            r101.meeting_number = ProtoAdapter.INT64.decode(r100);
            goto L3
        L8:
            r101.meeting_sub_type = ProtoAdapter.INT32.decode(r100);
            goto L3
        L9:
            r101.is_in_meeting = ProtoAdapter.BOOL.decode(r100);
            goto L3
        L10:
            r101.rehearsal_status_on = ProtoAdapter.BOOL.decode(r100);
            goto L3
        L11:
            r101.is_webinar = ProtoAdapter.BOOL.decode(r100);
            goto L3
        L12:
            r101.meeting_digest = ProtoAdapter.STRING.decode(r100);
            goto L3
        L13:
            r101.meeting_count = ProtoAdapter.INT32.decode(r100);
            goto L3
        L14:
            r101.meeting_id = ProtoAdapter.INT64.decode(r100);
            goto L3
        L15:
            r101.title = ProtoAdapter.STRING.decode(r100);
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
        public int encodedSize2(MeetingContent r100) {
            String r101 = r100.title;
            int r102 = 0;
            if (r101 == null) goto L5;
            int r103 = ProtoAdapter.STRING.encodedSizeWithTag(1, r101);
        L6:
            Long r104 = r100.meeting_id;
            if (r104 == null) goto L9;
            int r105 = ProtoAdapter.INT64.encodedSizeWithTag(2, r104);
        L10:
            int r106 = r103 + r105;
            Integer r107 = r100.meeting_count;
            if (r107 == null) goto L13;
            int r108 = ProtoAdapter.INT32.encodedSizeWithTag(3, r107);
        L14:
            int r109 = r106 + r108;
            String r110 = r100.meeting_digest;
            if (r110 == null) goto L17;
            int r111 = ProtoAdapter.STRING.encodedSizeWithTag(4, r110);
        L18:
            int r112 = r109 + r111;
            Boolean r113 = r100.is_webinar;
            if (r113 == null) goto L21;
            int r114 = ProtoAdapter.BOOL.encodedSizeWithTag(5, r113);
        L22:
            int r115 = r112 + r114;
            Boolean r116 = r100.rehearsal_status_on;
            if (r116 == null) goto L25;
            int r117 = ProtoAdapter.BOOL.encodedSizeWithTag(6, r116);
        L26:
            int r118 = r115 + r117;
            Boolean r119 = r100.is_in_meeting;
            if (r119 == null) goto L29;
            int r120 = ProtoAdapter.BOOL.encodedSizeWithTag(7, r119);
        L30:
            int r121 = r118 + r120;
            Integer r122 = r100.meeting_sub_type;
            if (r122 == null) goto L33;
            int r123 = ProtoAdapter.INT32.encodedSizeWithTag(8, r122);
        L34:
            int r124 = r121 + r123;
            Long r125 = r100.meeting_number;
            if (r125 == null) goto L38;
            r102 = ProtoAdapter.INT64.encodedSizeWithTag(9, r125);
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
        public /* bridge */ /* synthetic */ MeetingContent decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(MeetingContent r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, MeetingContent r101) throws IOException {
            String r102 = r101.title;
            if (r102 == null) goto L5;
            ProtoAdapter.STRING.encodeWithTag(r100, 1, r102);
        L5:
            Long r103 = r101.meeting_id;
            if (r103 == null) goto L8;
            ProtoAdapter.INT64.encodeWithTag(r100, 2, r103);
        L8:
            Integer r104 = r101.meeting_count;
            if (r104 == null) goto L11;
            ProtoAdapter.INT32.encodeWithTag(r100, 3, r104);
        L11:
            String r105 = r101.meeting_digest;
            if (r105 == null) goto L14;
            ProtoAdapter.STRING.encodeWithTag(r100, 4, r105);
        L14:
            Boolean r106 = r101.is_webinar;
            if (r106 == null) goto L17;
            ProtoAdapter.BOOL.encodeWithTag(r100, 5, r106);
        L17:
            Boolean r107 = r101.rehearsal_status_on;
            if (r107 == null) goto L20;
            ProtoAdapter.BOOL.encodeWithTag(r100, 6, r107);
        L20:
            Boolean r108 = r101.is_in_meeting;
            if (r108 == null) goto L23;
            ProtoAdapter.BOOL.encodeWithTag(r100, 7, r108);
        L23:
            Integer r109 = r101.meeting_sub_type;
            if (r109 == null) goto L26;
            ProtoAdapter.INT32.encodeWithTag(r100, 8, r109);
        L26:
            Long r110 = r101.meeting_number;
            if (r110 == null) goto L29;
            ProtoAdapter.INT64.encodeWithTag(r100, 9, r110);
        L29:
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, MeetingContent r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_MeetingContent();
        FIELD_OPTIONS_MEETING_ID = new FieldOptions.Builder().debug(new Debug.Builder().build()).build();
        FIELD_OPTIONS_MEETING_COUNT = new FieldOptions.Builder().debug(new Debug.Builder().build()).build();
        FIELD_OPTIONS_IS_WEBINAR = new FieldOptions.Builder().debug(new Debug.Builder().build()).build();
        FIELD_OPTIONS_REHEARSAL_STATUS_ON = new FieldOptions.Builder().debug(new Debug.Builder().build()).build();
        FIELD_OPTIONS_IS_IN_MEETING = new FieldOptions.Builder().debug(new Debug.Builder().build()).build();
        FIELD_OPTIONS_MEETING_SUB_TYPE = new FieldOptions.Builder().debug(new Debug.Builder().build()).build();
        FIELD_OPTIONS_MEETING_NUMBER = new FieldOptions.Builder().debug(new Debug.Builder().build()).build();
        DEFAULT_MEETING_ID = 0L;
        DEFAULT_MEETING_COUNT = 0;
        Boolean r100 = Boolean.FALSE;
        DEFAULT_IS_WEBINAR = r100;
        DEFAULT_REHEARSAL_STATUS_ON = r100;
        DEFAULT_IS_IN_MEETING = r100;
        DEFAULT_MEETING_SUB_TYPE = 0;
        DEFAULT_MEETING_NUMBER = 0L;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.title = this.title;
        r100.meeting_id = this.meeting_id;
        r100.meeting_count = this.meeting_count;
        r100.meeting_digest = this.meeting_digest;
        r100.is_webinar = this.is_webinar;
        r100.rehearsal_status_on = this.rehearsal_status_on;
        r100.is_in_meeting = this.is_in_meeting;
        r100.meeting_sub_type = this.meeting_sub_type;
        r100.meeting_number = this.meeting_number;
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return MeetingContent.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public MeetingContent(String r110, Long r111, Integer r112, String r113, Boolean r114, Boolean r115, Boolean r116, Integer r117, Long r210) {
        this(r110, r111, r112, r113, r114, r115, r116, r117, r210, ByteString.EMPTY);
    }

    public MeetingContent(String r100, Long r101, Integer r102, String r103, Boolean r104, Boolean r105, Boolean r106, Integer r107, Long r110, ByteString r111) {
        super(ADAPTER, r111);
        this.title = r100;
        this.meeting_id = r101;
        this.meeting_count = r102;
        this.meeting_digest = r103;
        this.is_webinar = r104;
        this.rehearsal_status_on = r105;
        this.is_in_meeting = r106;
        this.meeting_sub_type = r107;
        this.meeting_number = r110;
    }
}
