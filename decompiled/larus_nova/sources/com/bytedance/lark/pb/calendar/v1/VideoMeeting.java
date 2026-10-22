package com.bytedance.lark.pb.calendar.v1;

import annotation.Debug;
import com.google.protobuf.FieldOptions;
import com.larus.dora.api.model.FlowDoraWifiScene;
import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import com.squareup.wire.WireEnum;
import com.squareup.wire.internal.Internal;
import java.io.IOException;
import okio.ByteString;
import r27.a;

/* JADX INFO: loaded from: classes20.dex */
public final class VideoMeeting extends Message<VideoMeeting, Builder> {
    public static final ProtoAdapter<VideoMeeting> ADAPTER = null;
    public static final Boolean DEFAULT_IS_EXPIRED = null;
    public static final String DEFAULT_MEETING_NUMBER = "";
    public static final String DEFAULT_MEETING_URL = "";
    public static final String DEFAULT_UNIQUE_ID = "";
    public static final VideoMeetingType DEFAULT_VIDEO_MEETING_TYPE = null;
    public static final FieldOptions FIELD_OPTIONS_GOOGLE_CONFIGS = null;
    public static final FieldOptions FIELD_OPTIONS_OTHER_CONFIGS = null;
    public static final FieldOptions FIELD_OPTIONS_THIRD_PARTY_CONFIGS = null;
    public static final FieldOptions FIELD_OPTIONS_ZOOM_CONFIGS = null;
    private static final long serialVersionUID = 0;
    public final EventVideoMeetingConfig.GoogleVideoMeetingConfigs google_configs;
    public final Boolean is_expired;
    public final EventVideoMeetingConfig.LarkVCBindingData lark_vc_binding_data;
    public final String meeting_number;
    public final String meeting_url;
    public final EventVideoMeetingConfig.OtherVideoMeetingConfigs other_configs;
    public final EventVideoMeetingConfig.ThirdPartyMeetingConfigs third_party_configs;
    public final String unique_id;
    public final VideoMeetingType video_meeting_type;
    public final EventVideoMeetingConfig.ZoomVideoMeetingConfigs zoom_configs;

    public static final class Builder extends Message.Builder<VideoMeeting, Builder> {
        public EventVideoMeetingConfig.GoogleVideoMeetingConfigs google_configs;
        public Boolean is_expired;
        public EventVideoMeetingConfig.LarkVCBindingData lark_vc_binding_data;
        public String meeting_number;
        public String meeting_url;
        public EventVideoMeetingConfig.OtherVideoMeetingConfigs other_configs;
        public EventVideoMeetingConfig.ThirdPartyMeetingConfigs third_party_configs;
        public String unique_id;
        public VideoMeetingType video_meeting_type;
        public EventVideoMeetingConfig.ZoomVideoMeetingConfigs zoom_configs;

        @Override // com.squareup.wire.Message.Builder
        public VideoMeeting build() {
            return new VideoMeeting(this.unique_id, this.meeting_number, this.is_expired, this.meeting_url, this.video_meeting_type, this.lark_vc_binding_data, this.other_configs, this.google_configs, this.zoom_configs, this.third_party_configs, super.buildUnknownFields());
        }

        public Builder() {
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder google_configs(EventVideoMeetingConfig.GoogleVideoMeetingConfigs r100) {
            this.google_configs = r100;
            this.other_configs = null;
            this.zoom_configs = null;
            this.third_party_configs = null;
            return this;
        }

        public Builder is_expired(Boolean r100) {
            this.is_expired = r100;
            return this;
        }

        public Builder lark_vc_binding_data(EventVideoMeetingConfig.LarkVCBindingData r100) {
            this.lark_vc_binding_data = r100;
            return this;
        }

        public Builder meeting_number(String r100) {
            this.meeting_number = r100;
            return this;
        }

        public Builder meeting_url(String r100) {
            this.meeting_url = r100;
            return this;
        }

        public Builder other_configs(EventVideoMeetingConfig.OtherVideoMeetingConfigs r100) {
            this.other_configs = r100;
            this.google_configs = null;
            this.zoom_configs = null;
            this.third_party_configs = null;
            return this;
        }

        public Builder third_party_configs(EventVideoMeetingConfig.ThirdPartyMeetingConfigs r100) {
            this.third_party_configs = r100;
            this.other_configs = null;
            this.google_configs = null;
            this.zoom_configs = null;
            return this;
        }

        public Builder unique_id(String r100) {
            this.unique_id = r100;
            return this;
        }

        public Builder video_meeting_type(VideoMeetingType r100) {
            this.video_meeting_type = r100;
            return this;
        }

        public Builder zoom_configs(EventVideoMeetingConfig.ZoomVideoMeetingConfigs r100) {
            this.zoom_configs = r100;
            this.other_configs = null;
            this.google_configs = null;
            this.third_party_configs = null;
            return this;
        }
    }

    public static final class ProtoAdapter_VideoMeeting extends ProtoAdapter<VideoMeeting> {
        public ProtoAdapter_VideoMeeting() {
            super(FieldEncoding.LENGTH_DELIMITED, VideoMeeting.class);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public VideoMeeting decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            r101.unique_id = "";
            r101.meeting_number = "";
            r101.is_expired = Boolean.FALSE;
            r101.meeting_url = "";
            r101.video_meeting_type = VideoMeetingType.UNKNOWN_VIDEO_MEETING_TYPE;
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L21;
            switch(r103) {
                case 1: goto L20;
                case 2: goto L19;
                case 3: goto L18;
                case 4: goto L17;
                case 5: goto L23;
                case 6: goto L12;
                default: goto L6;
            };
        L23:
            r101.video_meeting_type = VideoMeetingType.ADAPTER.decode(r100);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L15
        L15:
            e = move-exception;
            r101.addUnknownField(r103, FieldEncoding.VARINT, Long.valueOf(e.value));
            goto L3
        L12:
            r101.lark_vc_binding_data = EventVideoMeetingConfig.LarkVCBindingData.ADAPTER.decode(r100);
            goto L3
        L17:
            r101.meeting_url = ProtoAdapter.STRING.decode(r100);
            goto L3
        L18:
            r101.is_expired = ProtoAdapter.BOOL.decode(r100);
            goto L3
        L19:
            r101.meeting_number = ProtoAdapter.STRING.decode(r100);
            goto L3
        L20:
            r101.unique_id = ProtoAdapter.STRING.decode(r100);
            goto L3
        L6:
            switch(r103) {
                case 101: goto L11;
                case 102: goto L10;
                case 103: goto L9;
                case 104: goto L8;
                default: goto L7;
            };
        L8:
            r101.third_party_configs(EventVideoMeetingConfig.ThirdPartyMeetingConfigs.ADAPTER.decode(r100));
            goto L3
        L9:
            r101.zoom_configs(EventVideoMeetingConfig.ZoomVideoMeetingConfigs.ADAPTER.decode(r100));
            goto L3
        L10:
            r101.google_configs(EventVideoMeetingConfig.GoogleVideoMeetingConfigs.ADAPTER.decode(r100));
            goto L3
        L11:
            r101.other_configs(EventVideoMeetingConfig.OtherVideoMeetingConfigs.ADAPTER.decode(r100));
            goto L3
        L7:
            FieldEncoding r104 = r100.peekFieldEncoding();
            r101.addUnknownField(r103, r104, r104.rawProtoAdapter().decode(r100));
            goto L3
        L21:
            r100.endMessage(r102);
            return r101.build();
        }

        /* JADX INFO: renamed from: encodedSize, reason: avoid collision after fix types in other method */
        public int encodedSize2(VideoMeeting r100) {
            String r101 = r100.unique_id;
            int r102 = 0;
            if (r101 == null) goto L5;
            int r103 = ProtoAdapter.STRING.encodedSizeWithTag(1, r101);
        L6:
            String r104 = r100.meeting_number;
            if (r104 == null) goto L9;
            int r105 = ProtoAdapter.STRING.encodedSizeWithTag(2, r104);
        L10:
            int r106 = r103 + r105;
            Boolean r107 = r100.is_expired;
            if (r107 == null) goto L13;
            int r108 = ProtoAdapter.BOOL.encodedSizeWithTag(3, r107);
        L14:
            int r109 = r106 + r108;
            String r110 = r100.meeting_url;
            if (r110 == null) goto L17;
            int r111 = ProtoAdapter.STRING.encodedSizeWithTag(4, r110);
        L18:
            int r112 = r109 + r111;
            VideoMeetingType r113 = r100.video_meeting_type;
            if (r113 == null) goto L21;
            int r114 = VideoMeetingType.ADAPTER.encodedSizeWithTag(5, r113);
        L22:
            int r115 = r112 + r114;
            EventVideoMeetingConfig.LarkVCBindingData r116 = r100.lark_vc_binding_data;
            if (r116 == null) goto L25;
            int r117 = EventVideoMeetingConfig.LarkVCBindingData.ADAPTER.encodedSizeWithTag(6, r116);
        L26:
            int r118 = r115 + r117;
            EventVideoMeetingConfig.OtherVideoMeetingConfigs r119 = r100.other_configs;
            if (r119 == null) goto L29;
            int r120 = EventVideoMeetingConfig.OtherVideoMeetingConfigs.ADAPTER.encodedSizeWithTag(101, r119);
        L30:
            int r121 = r118 + r120;
            EventVideoMeetingConfig.GoogleVideoMeetingConfigs r122 = r100.google_configs;
            if (r122 == null) goto L33;
            int r123 = EventVideoMeetingConfig.GoogleVideoMeetingConfigs.ADAPTER.encodedSizeWithTag(102, r122);
        L34:
            int r124 = r121 + r123;
            EventVideoMeetingConfig.ZoomVideoMeetingConfigs r125 = r100.zoom_configs;
            if (r125 == null) goto L37;
            int r126 = EventVideoMeetingConfig.ZoomVideoMeetingConfigs.ADAPTER.encodedSizeWithTag(103, r125);
        L38:
            int r127 = r124 + r126;
            EventVideoMeetingConfig.ThirdPartyMeetingConfigs r128 = r100.third_party_configs;
            if (r128 == null) goto L42;
            r102 = EventVideoMeetingConfig.ThirdPartyMeetingConfigs.ADAPTER.encodedSizeWithTag(104, r128);
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
        public /* bridge */ /* synthetic */ VideoMeeting decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(VideoMeeting r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, VideoMeeting r101) throws IOException {
            String r102 = r101.unique_id;
            if (r102 == null) goto L5;
            ProtoAdapter.STRING.encodeWithTag(r100, 1, r102);
        L5:
            String r103 = r101.meeting_number;
            if (r103 == null) goto L8;
            ProtoAdapter.STRING.encodeWithTag(r100, 2, r103);
        L8:
            Boolean r104 = r101.is_expired;
            if (r104 == null) goto L11;
            ProtoAdapter.BOOL.encodeWithTag(r100, 3, r104);
        L11:
            String r105 = r101.meeting_url;
            if (r105 == null) goto L14;
            ProtoAdapter.STRING.encodeWithTag(r100, 4, r105);
        L14:
            VideoMeetingType r106 = r101.video_meeting_type;
            if (r106 == null) goto L17;
            VideoMeetingType.ADAPTER.encodeWithTag(r100, 5, r106);
        L17:
            EventVideoMeetingConfig.LarkVCBindingData r107 = r101.lark_vc_binding_data;
            if (r107 == null) goto L20;
            EventVideoMeetingConfig.LarkVCBindingData.ADAPTER.encodeWithTag(r100, 6, r107);
        L20:
            EventVideoMeetingConfig.OtherVideoMeetingConfigs r108 = r101.other_configs;
            if (r108 == null) goto L23;
            EventVideoMeetingConfig.OtherVideoMeetingConfigs.ADAPTER.encodeWithTag(r100, 101, r108);
        L23:
            EventVideoMeetingConfig.GoogleVideoMeetingConfigs r109 = r101.google_configs;
            if (r109 == null) goto L26;
            EventVideoMeetingConfig.GoogleVideoMeetingConfigs.ADAPTER.encodeWithTag(r100, 102, r109);
        L26:
            EventVideoMeetingConfig.ZoomVideoMeetingConfigs r110 = r101.zoom_configs;
            if (r110 == null) goto L29;
            EventVideoMeetingConfig.ZoomVideoMeetingConfigs.ADAPTER.encodeWithTag(r100, 103, r110);
        L29:
            EventVideoMeetingConfig.ThirdPartyMeetingConfigs r111 = r101.third_party_configs;
            if (r111 == null) goto L32;
            EventVideoMeetingConfig.ThirdPartyMeetingConfigs.ADAPTER.encodeWithTag(r100, 104, r111);
        L32:
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, VideoMeeting r101) throws IOException {
            encode2(r100, r101);
        }
    }

    public static final enum Status extends Enum<Status> implements WireEnum {
        private static final /* synthetic */ Status[] $VALUES = null;
        public static final ProtoAdapter<Status> ADAPTER = null;
        public static final Status LIVE = null;
        public static final Status UNKNOWN = null;
        private final int value;

        static {
            Status r100 = new Status("UNKNOWN", 0, 0);
            UNKNOWN = r100;
            Status r101 = new Status("LIVE", 1, 1);
            LIVE = r101;
            $VALUES = new Status[]{r100, r101};
            ADAPTER = ProtoAdapter.newEnumAdapter(Status.class);
        }

        public static Status[] values() {
            return (Status[]) $VALUES.clone();
        }

        @Override // com.squareup.wire.WireEnum
        public final int getValue() {
            return this.value;
        }

        public static Status fromValue(int r100) {
            if (r100 == 0) goto L10;
            if (r100 == 1) goto L8;
            return null;
        L8:
            return LIVE;
        L10:
            return UNKNOWN;
        }

        public static Status valueOf(String r100) {
            return (Status) a.a(Status.class, r100);
        }

        private Status(String r100, int r101, int r102) {
            super(r100, r101);
            this.value = r102;
        }
    }

    public static final enum VideoMeetingType extends Enum<VideoMeetingType> implements WireEnum {
        private static final /* synthetic */ VideoMeetingType[] $VALUES = null;
        public static final ProtoAdapter<VideoMeetingType> ADAPTER = null;
        public static final VideoMeetingType GOOGLE_VIDEO_CONFERENCE = null;
        public static final VideoMeetingType LARK_LIVE_HOST = null;
        public static final VideoMeetingType NO_VIDEO_MEETING = null;
        public static final VideoMeetingType OTHER = null;
        public static final VideoMeetingType THIRD_PARTY_MEETING = null;
        public static final VideoMeetingType UNKNOWN_VIDEO_MEETING_TYPE = null;
        public static final VideoMeetingType VCHAT = null;
        public static final VideoMeetingType ZOOM_VIDEO_MEETING = null;
        private final int value;

        static {
            VideoMeetingType r100 = new VideoMeetingType("UNKNOWN_VIDEO_MEETING_TYPE", 0, 0);
            UNKNOWN_VIDEO_MEETING_TYPE = r100;
            VideoMeetingType r101 = new VideoMeetingType("VCHAT", 1, 1);
            VCHAT = r101;
            VideoMeetingType r102 = new VideoMeetingType(FlowDoraWifiScene.OTHER, 2, 2);
            OTHER = r102;
            VideoMeetingType r103 = new VideoMeetingType("LARK_LIVE_HOST", 3, 3);
            LARK_LIVE_HOST = r103;
            VideoMeetingType r104 = new VideoMeetingType("NO_VIDEO_MEETING", 4, 4);
            NO_VIDEO_MEETING = r104;
            VideoMeetingType r105 = new VideoMeetingType("GOOGLE_VIDEO_CONFERENCE", 5, 5);
            GOOGLE_VIDEO_CONFERENCE = r105;
            VideoMeetingType r110 = new VideoMeetingType("ZOOM_VIDEO_MEETING", 6, 6);
            ZOOM_VIDEO_MEETING = r110;
            VideoMeetingType r111 = new VideoMeetingType("THIRD_PARTY_MEETING", 7, 7);
            THIRD_PARTY_MEETING = r111;
            $VALUES = new VideoMeetingType[]{r100, r101, r102, r103, r104, r105, r110, r111};
            ADAPTER = ProtoAdapter.newEnumAdapter(VideoMeetingType.class);
        }

        public static VideoMeetingType[] values() {
            return (VideoMeetingType[]) $VALUES.clone();
        }

        @Override // com.squareup.wire.WireEnum
        public final int getValue() {
            return this.value;
        }

        public static VideoMeetingType fromValue(int r100) {
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
            return THIRD_PARTY_MEETING;
        L8:
            return ZOOM_VIDEO_MEETING;
        L10:
            return GOOGLE_VIDEO_CONFERENCE;
        L12:
            return NO_VIDEO_MEETING;
        L14:
            return LARK_LIVE_HOST;
        L16:
            return OTHER;
        L18:
            return VCHAT;
        L20:
            return UNKNOWN_VIDEO_MEETING_TYPE;
        }

        public static VideoMeetingType valueOf(String r100) {
            return (VideoMeetingType) a.a(VideoMeetingType.class, r100);
        }

        private VideoMeetingType(String r100, int r101, int r102) {
            super(r100, r101);
            this.value = r102;
        }
    }

    static {
        ADAPTER = new ProtoAdapter_VideoMeeting();
        FIELD_OPTIONS_OTHER_CONFIGS = new FieldOptions.Builder().debug(new Debug.Builder().build()).build();
        FIELD_OPTIONS_GOOGLE_CONFIGS = new FieldOptions.Builder().debug(new Debug.Builder().build()).build();
        FIELD_OPTIONS_ZOOM_CONFIGS = new FieldOptions.Builder().debug(new Debug.Builder().build()).build();
        FIELD_OPTIONS_THIRD_PARTY_CONFIGS = new FieldOptions.Builder().debug(new Debug.Builder().build()).build();
        DEFAULT_IS_EXPIRED = Boolean.FALSE;
        DEFAULT_VIDEO_MEETING_TYPE = VideoMeetingType.UNKNOWN_VIDEO_MEETING_TYPE;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.unique_id = this.unique_id;
        r100.meeting_number = this.meeting_number;
        r100.is_expired = this.is_expired;
        r100.meeting_url = this.meeting_url;
        r100.video_meeting_type = this.video_meeting_type;
        r100.lark_vc_binding_data = this.lark_vc_binding_data;
        r100.other_configs = this.other_configs;
        r100.google_configs = this.google_configs;
        r100.zoom_configs = this.zoom_configs;
        r100.third_party_configs = this.third_party_configs;
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return VideoMeeting.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public VideoMeeting(String r110, String r111, Boolean r112, String r113, VideoMeetingType r114, EventVideoMeetingConfig.LarkVCBindingData r115, EventVideoMeetingConfig.OtherVideoMeetingConfigs r116, EventVideoMeetingConfig.GoogleVideoMeetingConfigs r210, EventVideoMeetingConfig.ZoomVideoMeetingConfigs r211, EventVideoMeetingConfig.ThirdPartyMeetingConfigs r212) {
        this(r110, r111, r112, r113, r114, r115, r116, r210, r211, r212, ByteString.EMPTY);
    }

    public VideoMeeting(String r100, String r101, Boolean r102, String r103, VideoMeetingType r104, EventVideoMeetingConfig.LarkVCBindingData r105, EventVideoMeetingConfig.OtherVideoMeetingConfigs r106, EventVideoMeetingConfig.GoogleVideoMeetingConfigs r107, EventVideoMeetingConfig.ZoomVideoMeetingConfigs r110, EventVideoMeetingConfig.ThirdPartyMeetingConfigs r111, ByteString r112) {
        super(ADAPTER, r112);
        if (Internal.countNonNull(r106, r107, r110, r111, new Object[0]) > 1) goto L7;
        this.unique_id = r100;
        this.meeting_number = r101;
        this.is_expired = r102;
        this.meeting_url = r103;
        this.video_meeting_type = r104;
        this.lark_vc_binding_data = r105;
        this.other_configs = r106;
        this.google_configs = r107;
        this.zoom_configs = r110;
        this.third_party_configs = r111;
        return;
    L7:
        throw new IllegalArgumentException("at most one of other_configs, google_configs, zoom_configs, third_party_configs may be non-null");
    }
}
