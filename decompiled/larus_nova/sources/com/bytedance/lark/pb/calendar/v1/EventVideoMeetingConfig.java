package com.bytedance.lark.pb.calendar.v1;

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
public final class EventVideoMeetingConfig extends Message<EventVideoMeetingConfig, Builder> {
    public static final ProtoAdapter<EventVideoMeetingConfig> ADAPTER = null;
    public static final String DEFAULT_MEETING_URL = "";
    public static final VideoMeeting.VideoMeetingType DEFAULT_VIDEO_MEETING_TYPE = null;
    private static final long serialVersionUID = 0;
    public final GoogleVideoMeetingConfigs google_configs;
    public final LarkVCBindingData lark_vc_binding_data;
    public final String meeting_url;
    public final OtherVideoMeetingConfigs other_configs;
    public final ThirdPartyMeetingConfigs third_party_configs;
    public final VideoMeeting.VideoMeetingType video_meeting_type;
    public final ZoomVideoMeetingConfigs zoom_configs;

    public static final class Builder extends Message.Builder<EventVideoMeetingConfig, Builder> {
        public GoogleVideoMeetingConfigs google_configs;
        public LarkVCBindingData lark_vc_binding_data;
        public String meeting_url;
        public OtherVideoMeetingConfigs other_configs;
        public ThirdPartyMeetingConfigs third_party_configs;
        public VideoMeeting.VideoMeetingType video_meeting_type;
        public ZoomVideoMeetingConfigs zoom_configs;

        @Override // com.squareup.wire.Message.Builder
        public EventVideoMeetingConfig build() {
            return new EventVideoMeetingConfig(this.video_meeting_type, this.meeting_url, this.lark_vc_binding_data, this.other_configs, this.google_configs, this.zoom_configs, this.third_party_configs, super.buildUnknownFields());
        }

        public Builder() {
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder google_configs(GoogleVideoMeetingConfigs r100) {
            this.google_configs = r100;
            this.other_configs = null;
            this.zoom_configs = null;
            this.third_party_configs = null;
            return this;
        }

        public Builder lark_vc_binding_data(LarkVCBindingData r100) {
            this.lark_vc_binding_data = r100;
            return this;
        }

        public Builder meeting_url(String r100) {
            this.meeting_url = r100;
            return this;
        }

        public Builder other_configs(OtherVideoMeetingConfigs r100) {
            this.other_configs = r100;
            this.google_configs = null;
            this.zoom_configs = null;
            this.third_party_configs = null;
            return this;
        }

        public Builder third_party_configs(ThirdPartyMeetingConfigs r100) {
            this.third_party_configs = r100;
            this.other_configs = null;
            this.google_configs = null;
            this.zoom_configs = null;
            return this;
        }

        public Builder video_meeting_type(VideoMeeting.VideoMeetingType r100) {
            this.video_meeting_type = r100;
            return this;
        }

        public Builder zoom_configs(ZoomVideoMeetingConfigs r100) {
            this.zoom_configs = r100;
            this.other_configs = null;
            this.google_configs = null;
            this.third_party_configs = null;
            return this;
        }
    }

    public static final class GoogleVideoMeetingConfigs extends Message<GoogleVideoMeetingConfigs, Builder> {
        public static final ProtoAdapter<GoogleVideoMeetingConfigs> ADAPTER = null;
        public static final String DEFAULT_MORE_PHONE_NUMBER_URL = "";
        public static final String DEFAULT_PHONE_NUMBER = "";
        private static final long serialVersionUID = 0;
        public final String more_phone_number_url;
        public final String phone_number;

        public static final class Builder extends Message.Builder<GoogleVideoMeetingConfigs, Builder> {
            public String more_phone_number_url;
            public String phone_number;

            @Override // com.squareup.wire.Message.Builder
            public GoogleVideoMeetingConfigs build() {
                return new GoogleVideoMeetingConfigs(this.phone_number, this.more_phone_number_url, super.buildUnknownFields());
            }

            public Builder() {
            }

            @Override // com.squareup.wire.Message.Builder
            public /* bridge */ /* synthetic */ Message build() {
                return build();
            }

            public Builder more_phone_number_url(String r100) {
                this.more_phone_number_url = r100;
                return this;
            }

            public Builder phone_number(String r100) {
                this.phone_number = r100;
                return this;
            }
        }

        public static final class ProtoAdapter_GoogleVideoMeetingConfigs extends ProtoAdapter<GoogleVideoMeetingConfigs> {
            public ProtoAdapter_GoogleVideoMeetingConfigs() {
                super(FieldEncoding.LENGTH_DELIMITED, GoogleVideoMeetingConfigs.class);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.squareup.wire.ProtoAdapter
            public GoogleVideoMeetingConfigs decode(ProtoReader r100) throws IOException {
                Builder r101 = new Builder();
                r101.phone_number = "";
                r101.more_phone_number_url = "";
                long r102 = r100.beginMessage();
            L3:
                int r103 = r100.nextTag();
                if (r103 == (-1)) goto L12;
                if (r103 != 1) goto L8;
                r101.phone_number = ProtoAdapter.STRING.decode(r100);
                goto L3
            L8:
                if (r103 != 2) goto L9;
                r101.more_phone_number_url = ProtoAdapter.STRING.decode(r100);
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
            public int encodedSize2(GoogleVideoMeetingConfigs r100) {
                String r101 = r100.phone_number;
                int r102 = 0;
                if (r101 == null) goto L5;
                int r103 = ProtoAdapter.STRING.encodedSizeWithTag(1, r101);
            L6:
                String r104 = r100.more_phone_number_url;
                if (r104 == null) goto L10;
                r102 = ProtoAdapter.STRING.encodedSizeWithTag(2, r104);
            L10:
                return (r103 + r102) + r100.unknownFields().size();
            L5:
                r103 = 0;
                goto L6
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ GoogleVideoMeetingConfigs decode(ProtoReader r100) throws IOException {
                return decode(r100);
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ int encodedSize(GoogleVideoMeetingConfigs r100) {
                return encodedSize2(r100);
            }

            /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
            public void encode2(ProtoWriter r100, GoogleVideoMeetingConfigs r101) throws IOException {
                String r102 = r101.phone_number;
                if (r102 == null) goto L5;
                ProtoAdapter.STRING.encodeWithTag(r100, 1, r102);
            L5:
                String r103 = r101.more_phone_number_url;
                if (r103 == null) goto L8;
                ProtoAdapter.STRING.encodeWithTag(r100, 2, r103);
            L8:
                r100.writeBytes(r101.unknownFields());
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, GoogleVideoMeetingConfigs r101) throws IOException {
                encode2(r100, r101);
            }
        }

        static {
            ADAPTER = new ProtoAdapter_GoogleVideoMeetingConfigs();
        }

        @Override // com.squareup.wire.Message
        public Builder newBuilder() {
            Builder r100 = new Builder();
            r100.phone_number = this.phone_number;
            r100.more_phone_number_url = this.more_phone_number_url;
            r100.addUnknownFields(unknownFields());
            return r100;
        }

        @Override // com.squareup.wire.Message
        public String toString() {
            return GoogleVideoMeetingConfigs.class.getName() + "@" + Integer.toHexString(hashCode());
        }

        @Override // com.squareup.wire.Message
        public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
            return newBuilder();
        }

        public GoogleVideoMeetingConfigs(String r100, String r101) {
            this(r100, r101, ByteString.EMPTY);
        }

        public GoogleVideoMeetingConfigs(String r100, String r101, ByteString r102) {
            super(ADAPTER, r102);
            this.phone_number = r100;
            this.more_phone_number_url = r101;
        }
    }

    public static final class LarkVCBindingData extends Message<LarkVCBindingData, Builder> {
        public static final ProtoAdapter<LarkVCBindingData> ADAPTER = null;
        public static final String DEFAULT_VC_SETTING_ID = "";
        private static final long serialVersionUID = 0;
        public final String vc_setting_id;

        public static final class Builder extends Message.Builder<LarkVCBindingData, Builder> {
            public String vc_setting_id;

            @Override // com.squareup.wire.Message.Builder
            public LarkVCBindingData build() {
                return new LarkVCBindingData(this.vc_setting_id, super.buildUnknownFields());
            }

            public Builder() {
            }

            @Override // com.squareup.wire.Message.Builder
            public /* bridge */ /* synthetic */ Message build() {
                return build();
            }

            public Builder vc_setting_id(String r100) {
                this.vc_setting_id = r100;
                return this;
            }
        }

        public static final class ProtoAdapter_LarkVCBindingData extends ProtoAdapter<LarkVCBindingData> {
            public ProtoAdapter_LarkVCBindingData() {
                super(FieldEncoding.LENGTH_DELIMITED, LarkVCBindingData.class);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.squareup.wire.ProtoAdapter
            public LarkVCBindingData decode(ProtoReader r100) throws IOException {
                Builder r101 = new Builder();
                r101.vc_setting_id = "";
                long r102 = r100.beginMessage();
            L3:
                int r103 = r100.nextTag();
                if (r103 == (-1)) goto L9;
                if (r103 != 1) goto L7;
                r101.vc_setting_id = ProtoAdapter.STRING.decode(r100);
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
            public int encodedSize2(LarkVCBindingData r100) {
                String r101 = r100.vc_setting_id;
                if (r101 == null) goto L5;
                int r102 = ProtoAdapter.STRING.encodedSizeWithTag(1, r101);
            L7:
                return r102 + r100.unknownFields().size();
            L5:
                r102 = 0;
                goto L7
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ LarkVCBindingData decode(ProtoReader r100) throws IOException {
                return decode(r100);
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ int encodedSize(LarkVCBindingData r100) {
                return encodedSize2(r100);
            }

            /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
            public void encode2(ProtoWriter r100, LarkVCBindingData r101) throws IOException {
                String r102 = r101.vc_setting_id;
                if (r102 == null) goto L5;
                ProtoAdapter.STRING.encodeWithTag(r100, 1, r102);
            L5:
                r100.writeBytes(r101.unknownFields());
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, LarkVCBindingData r101) throws IOException {
                encode2(r100, r101);
            }
        }

        static {
            ADAPTER = new ProtoAdapter_LarkVCBindingData();
        }

        @Override // com.squareup.wire.Message
        public Builder newBuilder() {
            Builder r100 = new Builder();
            r100.vc_setting_id = this.vc_setting_id;
            r100.addUnknownFields(unknownFields());
            return r100;
        }

        @Override // com.squareup.wire.Message
        public String toString() {
            return LarkVCBindingData.class.getName() + "@" + Integer.toHexString(hashCode());
        }

        @Override // com.squareup.wire.Message
        public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
            return newBuilder();
        }

        public LarkVCBindingData(String r100) {
            this(r100, ByteString.EMPTY);
        }

        public LarkVCBindingData(String r100, ByteString r101) {
            super(ADAPTER, r101);
            this.vc_setting_id = r100;
        }
    }

    public static final class OtherVideoMeetingConfigs extends Message<OtherVideoMeetingConfigs, Builder> {
        public static final ProtoAdapter<OtherVideoMeetingConfigs> ADAPTER = null;
        public static final String DEFAULT_CUSTOMIZED_DESCRIPTION = "";
        public static final IconType DEFAULT_ICON = null;
        private static final long serialVersionUID = 0;
        public final String customized_description;
        public final IconType icon;

        public static final class Builder extends Message.Builder<OtherVideoMeetingConfigs, Builder> {
            public String customized_description;
            public IconType icon;

            @Override // com.squareup.wire.Message.Builder
            public OtherVideoMeetingConfigs build() {
                return new OtherVideoMeetingConfigs(this.icon, this.customized_description, super.buildUnknownFields());
            }

            public Builder() {
            }

            @Override // com.squareup.wire.Message.Builder
            public /* bridge */ /* synthetic */ Message build() {
                return build();
            }

            public Builder customized_description(String r100) {
                this.customized_description = r100;
                return this;
            }

            public Builder icon(IconType r100) {
                this.icon = r100;
                return this;
            }
        }

        public static final enum IconType extends Enum<IconType> implements WireEnum {
            private static final /* synthetic */ IconType[] $VALUES = null;
            public static final ProtoAdapter<IconType> ADAPTER = null;
            public static final IconType DEFAULT = null;
            public static final IconType LIVE = null;
            public static final IconType VIDEO_MEETING = null;
            private final int value;

            static {
                IconType r100 = new IconType("DEFAULT", 0, 0);
                DEFAULT = r100;
                IconType r101 = new IconType("VIDEO_MEETING", 1, 1);
                VIDEO_MEETING = r101;
                IconType r102 = new IconType("LIVE", 2, 2);
                LIVE = r102;
                $VALUES = new IconType[]{r100, r101, r102};
                ADAPTER = ProtoAdapter.newEnumAdapter(IconType.class);
            }

            public static IconType[] values() {
                return (IconType[]) $VALUES.clone();
            }

            @Override // com.squareup.wire.WireEnum
            public final int getValue() {
                return this.value;
            }

            public static IconType fromValue(int r100) {
                if (r100 == 0) goto L14;
                if (r100 == 1) goto L12;
                if (r100 == 2) goto L10;
                return null;
            L10:
                return LIVE;
            L12:
                return VIDEO_MEETING;
            L14:
                return DEFAULT;
            }

            public static IconType valueOf(String r100) {
                return (IconType) a.a(IconType.class, r100);
            }

            private IconType(String r100, int r101, int r102) {
                super(r100, r101);
                this.value = r102;
            }
        }

        public static final class ProtoAdapter_OtherVideoMeetingConfigs extends ProtoAdapter<OtherVideoMeetingConfigs> {
            public ProtoAdapter_OtherVideoMeetingConfigs() {
                super(FieldEncoding.LENGTH_DELIMITED, OtherVideoMeetingConfigs.class);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.squareup.wire.ProtoAdapter
            public OtherVideoMeetingConfigs decode(ProtoReader r100) throws IOException {
                Builder r101 = new Builder();
                r101.icon = IconType.DEFAULT;
                r101.customized_description = "";
                long r102 = r100.beginMessage();
            L3:
                int r103 = r100.nextTag();
                if (r103 == (-1)) goto L15;
                if (r103 != 1) goto L8;
                r101.icon = IconType.ADAPTER.decode(r100);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L13
            L13:
                e = move-exception;
                r101.addUnknownField(r103, FieldEncoding.VARINT, Long.valueOf(e.value));
                goto L3
            L8:
                if (r103 != 2) goto L9;
                r101.customized_description = ProtoAdapter.STRING.decode(r100);
                goto L3
            L9:
                FieldEncoding r104 = r100.peekFieldEncoding();
                r101.addUnknownField(r103, r104, r104.rawProtoAdapter().decode(r100));
                goto L3
            L15:
                r100.endMessage(r102);
                return r101.build();
            }

            /* JADX INFO: renamed from: encodedSize, reason: avoid collision after fix types in other method */
            public int encodedSize2(OtherVideoMeetingConfigs r100) {
                IconType r101 = r100.icon;
                int r102 = 0;
                if (r101 == null) goto L5;
                int r103 = IconType.ADAPTER.encodedSizeWithTag(1, r101);
            L6:
                String r104 = r100.customized_description;
                if (r104 == null) goto L10;
                r102 = ProtoAdapter.STRING.encodedSizeWithTag(2, r104);
            L10:
                return (r103 + r102) + r100.unknownFields().size();
            L5:
                r103 = 0;
                goto L6
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ OtherVideoMeetingConfigs decode(ProtoReader r100) throws IOException {
                return decode(r100);
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ int encodedSize(OtherVideoMeetingConfigs r100) {
                return encodedSize2(r100);
            }

            /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
            public void encode2(ProtoWriter r100, OtherVideoMeetingConfigs r101) throws IOException {
                IconType r102 = r101.icon;
                if (r102 == null) goto L5;
                IconType.ADAPTER.encodeWithTag(r100, 1, r102);
            L5:
                String r103 = r101.customized_description;
                if (r103 == null) goto L8;
                ProtoAdapter.STRING.encodeWithTag(r100, 2, r103);
            L8:
                r100.writeBytes(r101.unknownFields());
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, OtherVideoMeetingConfigs r101) throws IOException {
                encode2(r100, r101);
            }
        }

        static {
            ADAPTER = new ProtoAdapter_OtherVideoMeetingConfigs();
            DEFAULT_ICON = IconType.DEFAULT;
        }

        @Override // com.squareup.wire.Message
        public Builder newBuilder() {
            Builder r100 = new Builder();
            r100.icon = this.icon;
            r100.customized_description = this.customized_description;
            r100.addUnknownFields(unknownFields());
            return r100;
        }

        @Override // com.squareup.wire.Message
        public String toString() {
            return OtherVideoMeetingConfigs.class.getName() + "@" + Integer.toHexString(hashCode());
        }

        @Override // com.squareup.wire.Message
        public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
            return newBuilder();
        }

        public OtherVideoMeetingConfigs(IconType r100, String r101) {
            this(r100, r101, ByteString.EMPTY);
        }

        public OtherVideoMeetingConfigs(IconType r100, String r101, ByteString r102) {
            super(ADAPTER, r102);
            this.icon = r100;
            this.customized_description = r101;
        }
    }

    public static final class ProtoAdapter_EventVideoMeetingConfig extends ProtoAdapter<EventVideoMeetingConfig> {
        public ProtoAdapter_EventVideoMeetingConfig() {
            super(FieldEncoding.LENGTH_DELIMITED, EventVideoMeetingConfig.class);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public EventVideoMeetingConfig decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            r101.video_meeting_type = VideoMeeting.VideoMeetingType.UNKNOWN_VIDEO_MEETING_TYPE;
            r101.meeting_url = "";
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L23;
            if (r103 != 1) goto L8;
            r101.video_meeting_type = VideoMeeting.VideoMeetingType.ADAPTER.decode(r100);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L21
        L21:
            e = move-exception;
            r101.addUnknownField(r103, FieldEncoding.VARINT, Long.valueOf(e.value));
            goto L3
        L8:
            if (r103 != 2) goto L10;
            r101.meeting_url = ProtoAdapter.STRING.decode(r100);
            goto L3
        L10:
            if (r103 != 3) goto L11;
            r101.lark_vc_binding_data = LarkVCBindingData.ADAPTER.decode(r100);
            goto L3
        L11:
            switch(r103) {
                case 101: goto L16;
                case 102: goto L15;
                case 103: goto L14;
                case 104: goto L13;
                default: goto L12;
            };
        L13:
            r101.third_party_configs(ThirdPartyMeetingConfigs.ADAPTER.decode(r100));
            goto L3
        L14:
            r101.zoom_configs(ZoomVideoMeetingConfigs.ADAPTER.decode(r100));
            goto L3
        L15:
            r101.google_configs(GoogleVideoMeetingConfigs.ADAPTER.decode(r100));
            goto L3
        L16:
            r101.other_configs(OtherVideoMeetingConfigs.ADAPTER.decode(r100));
            goto L3
        L12:
            FieldEncoding r104 = r100.peekFieldEncoding();
            r101.addUnknownField(r103, r104, r104.rawProtoAdapter().decode(r100));
            goto L3
        L23:
            r100.endMessage(r102);
            return r101.build();
        }

        /* JADX INFO: renamed from: encodedSize, reason: avoid collision after fix types in other method */
        public int encodedSize2(EventVideoMeetingConfig r100) {
            VideoMeeting.VideoMeetingType r101 = r100.video_meeting_type;
            int r102 = 0;
            if (r101 == null) goto L5;
            int r103 = VideoMeeting.VideoMeetingType.ADAPTER.encodedSizeWithTag(1, r101);
        L6:
            String r104 = r100.meeting_url;
            if (r104 == null) goto L9;
            int r105 = ProtoAdapter.STRING.encodedSizeWithTag(2, r104);
        L10:
            int r106 = r103 + r105;
            LarkVCBindingData r107 = r100.lark_vc_binding_data;
            if (r107 == null) goto L13;
            int r108 = LarkVCBindingData.ADAPTER.encodedSizeWithTag(3, r107);
        L14:
            int r109 = r106 + r108;
            OtherVideoMeetingConfigs r110 = r100.other_configs;
            if (r110 == null) goto L17;
            int r111 = OtherVideoMeetingConfigs.ADAPTER.encodedSizeWithTag(101, r110);
        L18:
            int r112 = r109 + r111;
            GoogleVideoMeetingConfigs r113 = r100.google_configs;
            if (r113 == null) goto L21;
            int r114 = GoogleVideoMeetingConfigs.ADAPTER.encodedSizeWithTag(102, r113);
        L22:
            int r115 = r112 + r114;
            ZoomVideoMeetingConfigs r116 = r100.zoom_configs;
            if (r116 == null) goto L25;
            int r117 = ZoomVideoMeetingConfigs.ADAPTER.encodedSizeWithTag(103, r116);
        L26:
            int r118 = r115 + r117;
            ThirdPartyMeetingConfigs r119 = r100.third_party_configs;
            if (r119 == null) goto L30;
            r102 = ThirdPartyMeetingConfigs.ADAPTER.encodedSizeWithTag(104, r119);
        L30:
            return (r118 + r102) + r100.unknownFields().size();
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
        public /* bridge */ /* synthetic */ EventVideoMeetingConfig decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(EventVideoMeetingConfig r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, EventVideoMeetingConfig r101) throws IOException {
            VideoMeeting.VideoMeetingType r102 = r101.video_meeting_type;
            if (r102 == null) goto L5;
            VideoMeeting.VideoMeetingType.ADAPTER.encodeWithTag(r100, 1, r102);
        L5:
            String r103 = r101.meeting_url;
            if (r103 == null) goto L8;
            ProtoAdapter.STRING.encodeWithTag(r100, 2, r103);
        L8:
            LarkVCBindingData r104 = r101.lark_vc_binding_data;
            if (r104 == null) goto L11;
            LarkVCBindingData.ADAPTER.encodeWithTag(r100, 3, r104);
        L11:
            OtherVideoMeetingConfigs r105 = r101.other_configs;
            if (r105 == null) goto L14;
            OtherVideoMeetingConfigs.ADAPTER.encodeWithTag(r100, 101, r105);
        L14:
            GoogleVideoMeetingConfigs r106 = r101.google_configs;
            if (r106 == null) goto L17;
            GoogleVideoMeetingConfigs.ADAPTER.encodeWithTag(r100, 102, r106);
        L17:
            ZoomVideoMeetingConfigs r107 = r101.zoom_configs;
            if (r107 == null) goto L20;
            ZoomVideoMeetingConfigs.ADAPTER.encodeWithTag(r100, 103, r107);
        L20:
            ThirdPartyMeetingConfigs r108 = r101.third_party_configs;
            if (r108 == null) goto L23;
            ThirdPartyMeetingConfigs.ADAPTER.encodeWithTag(r100, 104, r108);
        L23:
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, EventVideoMeetingConfig r101) throws IOException {
            encode2(r100, r101);
        }
    }

    public static final class ThirdPartyMeetingConfigs extends Message<ThirdPartyMeetingConfigs, Builder> {
        public static final ProtoAdapter<ThirdPartyMeetingConfigs> ADAPTER = null;
        public static final String DEFAULT_MEETING_ID = "";
        public static final String DEFAULT_MEETING_NO = "";
        public static final ThirdPartyMeetingType DEFAULT_MEETING_TYPE = null;
        public static final String DEFAULT_PASSWORD = "";
        private static final long serialVersionUID = 0;
        public final Map<String, String> meeting_description;
        public final String meeting_id;
        public final String meeting_no;
        public final ThirdPartyMeetingType meeting_type;
        public final String password;

        public static final class Builder extends Message.Builder<ThirdPartyMeetingConfigs, Builder> {
            public Map<String, String> meeting_description;
            public String meeting_id;
            public String meeting_no;
            public ThirdPartyMeetingType meeting_type;
            public String password;

            @Override // com.squareup.wire.Message.Builder
            public ThirdPartyMeetingConfigs build() {
                ThirdPartyMeetingType r100 = this.meeting_type;
                if (r100 == null) goto L7;
                return new ThirdPartyMeetingConfigs(this.meeting_type, this.meeting_id, this.meeting_no, this.password, this.meeting_description, super.buildUnknownFields());
            L7:
                throw Internal.missingRequiredFields(new Object[]{r100, "meeting_type"});
            }

            public Builder() {
                this.meeting_description = Internal.newMutableMap();
            }

            @Override // com.squareup.wire.Message.Builder
            public /* bridge */ /* synthetic */ Message build() {
                return build();
            }

            public Builder meeting_description(Map<String, String> r100) {
                Internal.checkElementsNotNull(r100);
                this.meeting_description = r100;
                return this;
            }

            public Builder meeting_id(String r100) {
                this.meeting_id = r100;
                return this;
            }

            public Builder meeting_no(String r100) {
                this.meeting_no = r100;
                return this;
            }

            public Builder meeting_type(ThirdPartyMeetingType r100) {
                this.meeting_type = r100;
                return this;
            }

            public Builder password(String r100) {
                this.password = r100;
                return this;
            }
        }

        public static final class ProtoAdapter_ThirdPartyMeetingConfigs extends ProtoAdapter<ThirdPartyMeetingConfigs> {
            private final ProtoAdapter<Map<String, String>> meeting_description;

            public ProtoAdapter_ThirdPartyMeetingConfigs() {
                super(FieldEncoding.LENGTH_DELIMITED, ThirdPartyMeetingConfigs.class);
                ProtoAdapter<String> r100 = ProtoAdapter.STRING;
                this.meeting_description = ProtoAdapter.newMapAdapter(r100, r100);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.squareup.wire.ProtoAdapter
            public ThirdPartyMeetingConfigs decode(ProtoReader r100) throws IOException {
                Builder r101 = new Builder();
                r101.meeting_type = ThirdPartyMeetingType.UNKNOWN_MEETING_TYPE;
                r101.meeting_id = "";
                r101.meeting_no = "";
                r101.password = "";
                long r102 = r100.beginMessage();
            L3:
                int r103 = r100.nextTag();
                if (r103 == (-1)) goto L24;
                if (r103 != 1) goto L8;
                r101.meeting_type = ThirdPartyMeetingType.ADAPTER.decode(r100);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L22
            L22:
                e = move-exception;
                r101.addUnknownField(r103, FieldEncoding.VARINT, Long.valueOf(e.value));
                goto L3
            L8:
                if (r103 != 2) goto L10;
                r101.meeting_id = ProtoAdapter.STRING.decode(r100);
                goto L3
            L10:
                if (r103 != 3) goto L12;
                r101.meeting_no = ProtoAdapter.STRING.decode(r100);
                goto L3
            L12:
                if (r103 != 4) goto L14;
                r101.password = ProtoAdapter.STRING.decode(r100);
                goto L3
            L14:
                if (r103 != 5) goto L15;
                r101.meeting_description.putAll(this.meeting_description.decode(r100));
                goto L3
            L15:
                FieldEncoding r104 = r100.peekFieldEncoding();
                r101.addUnknownField(r103, r104, r104.rawProtoAdapter().decode(r100));
                goto L3
            L24:
                r100.endMessage(r102);
                return r101.build();
            }

            /* JADX INFO: renamed from: encodedSize, reason: avoid collision after fix types in other method */
            public int encodedSize2(ThirdPartyMeetingConfigs r100) {
                int r101 = ThirdPartyMeetingType.ADAPTER.encodedSizeWithTag(1, r100.meeting_type);
                String r102 = r100.meeting_id;
                int r103 = 0;
                if (r102 == null) goto L5;
                int r104 = ProtoAdapter.STRING.encodedSizeWithTag(2, r102);
            L6:
                int r105 = r101 + r104;
                String r106 = r100.meeting_no;
                if (r106 == null) goto L9;
                int r107 = ProtoAdapter.STRING.encodedSizeWithTag(3, r106);
            L10:
                int r108 = r105 + r107;
                String r109 = r100.password;
                if (r109 == null) goto L14;
                r103 = ProtoAdapter.STRING.encodedSizeWithTag(4, r109);
            L14:
                return ((r108 + r103) + this.meeting_description.encodedSizeWithTag(5, r100.meeting_description)) + r100.unknownFields().size();
            L9:
                r107 = 0;
                goto L10
            L5:
                r104 = 0;
                goto L6
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ ThirdPartyMeetingConfigs decode(ProtoReader r100) throws IOException {
                return decode(r100);
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ int encodedSize(ThirdPartyMeetingConfigs r100) {
                return encodedSize2(r100);
            }

            /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
            public void encode2(ProtoWriter r100, ThirdPartyMeetingConfigs r101) throws IOException {
                ThirdPartyMeetingType.ADAPTER.encodeWithTag(r100, 1, r101.meeting_type);
                String r102 = r101.meeting_id;
                if (r102 == null) goto L5;
                ProtoAdapter.STRING.encodeWithTag(r100, 2, r102);
            L5:
                String r103 = r101.meeting_no;
                if (r103 == null) goto L8;
                ProtoAdapter.STRING.encodeWithTag(r100, 3, r103);
            L8:
                String r104 = r101.password;
                if (r104 == null) goto L11;
                ProtoAdapter.STRING.encodeWithTag(r100, 4, r104);
            L11:
                this.meeting_description.encodeWithTag(r100, 5, r101.meeting_description);
                r100.writeBytes(r101.unknownFields());
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, ThirdPartyMeetingConfigs r101) throws IOException {
                encode2(r100, r101);
            }
        }

        static {
            ADAPTER = new ProtoAdapter_ThirdPartyMeetingConfigs();
            DEFAULT_MEETING_TYPE = ThirdPartyMeetingType.UNKNOWN_MEETING_TYPE;
        }

        @Override // com.squareup.wire.Message
        public Builder newBuilder() {
            Builder r100 = new Builder();
            r100.meeting_type = this.meeting_type;
            r100.meeting_id = this.meeting_id;
            r100.meeting_no = this.meeting_no;
            r100.password = this.password;
            r100.meeting_description = Internal.copyOf("meeting_description", this.meeting_description);
            r100.addUnknownFields(unknownFields());
            return r100;
        }

        @Override // com.squareup.wire.Message
        public String toString() {
            return ThirdPartyMeetingConfigs.class.getName() + "@" + Integer.toHexString(hashCode());
        }

        @Override // com.squareup.wire.Message
        public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
            return newBuilder();
        }

        public ThirdPartyMeetingConfigs(ThirdPartyMeetingType r100, String r101, String r110, String r111, Map<String, String> r112) {
            this(r100, r101, r110, r111, r112, ByteString.EMPTY);
        }

        public ThirdPartyMeetingConfigs(ThirdPartyMeetingType r100, String r101, String r102, String r103, Map<String, String> r104, ByteString r105) {
            super(ADAPTER, r105);
            this.meeting_type = r100;
            this.meeting_id = r101;
            this.meeting_no = r102;
            this.password = r103;
            this.meeting_description = Internal.immutableCopyOf("meeting_description", r104);
        }
    }

    public static final class ZoomVideoMeetingConfigs extends Message<ZoomVideoMeetingConfigs, Builder> {
        public static final ProtoAdapter<ZoomVideoMeetingConfigs> ADAPTER = null;
        public static final String DEFAULT_CREATOR_ACCOUNT = "";
        public static final Long DEFAULT_CREATOR_USER_ID = null;
        public static final Boolean DEFAULT_IS_EDITABLE = null;
        public static final Long DEFAULT_MEETING_ID = null;
        public static final Long DEFAULT_MEETING_NO = null;
        public static final String DEFAULT_MEETING_URL = "";
        public static final String DEFAULT_PASSWORD = "";
        private static final long serialVersionUID = 0;
        public final String creator_account;
        public final Long creator_user_id;
        public final Boolean is_editable;
        public final Long meeting_id;
        public final Long meeting_no;
        public final String meeting_url;
        public final String password;

        public static final class Builder extends Message.Builder<ZoomVideoMeetingConfigs, Builder> {
            public String creator_account;
            public Long creator_user_id;
            public Boolean is_editable;
            public Long meeting_id;
            public Long meeting_no;
            public String meeting_url;
            public String password;

            @Override // com.squareup.wire.Message.Builder
            public ZoomVideoMeetingConfigs build() {
                return new ZoomVideoMeetingConfigs(this.meeting_id, this.meeting_no, this.creator_account, this.meeting_url, this.password, this.is_editable, this.creator_user_id, super.buildUnknownFields());
            }

            public Builder() {
            }

            @Override // com.squareup.wire.Message.Builder
            public /* bridge */ /* synthetic */ Message build() {
                return build();
            }

            public Builder creator_account(String r100) {
                this.creator_account = r100;
                return this;
            }

            public Builder creator_user_id(Long r100) {
                this.creator_user_id = r100;
                return this;
            }

            public Builder is_editable(Boolean r100) {
                this.is_editable = r100;
                return this;
            }

            public Builder meeting_id(Long r100) {
                this.meeting_id = r100;
                return this;
            }

            public Builder meeting_no(Long r100) {
                this.meeting_no = r100;
                return this;
            }

            public Builder meeting_url(String r100) {
                this.meeting_url = r100;
                return this;
            }

            public Builder password(String r100) {
                this.password = r100;
                return this;
            }
        }

        public static final class ProtoAdapter_ZoomVideoMeetingConfigs extends ProtoAdapter<ZoomVideoMeetingConfigs> {
            public ProtoAdapter_ZoomVideoMeetingConfigs() {
                super(FieldEncoding.LENGTH_DELIMITED, ZoomVideoMeetingConfigs.class);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.squareup.wire.ProtoAdapter
            public ZoomVideoMeetingConfigs decode(ProtoReader r100) throws IOException {
                Builder r101 = new Builder();
                r101.meeting_id = 0L;
                r101.meeting_no = 0L;
                r101.creator_account = "";
                r101.meeting_url = "";
                r101.password = "";
                r101.is_editable = Boolean.FALSE;
                r101.creator_user_id = 0L;
                long r102 = r100.beginMessage();
            L3:
                int r103 = r100.nextTag();
                if (r103 == (-1)) goto L14;
                switch(r103) {
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
                r101.creator_user_id = ProtoAdapter.INT64.decode(r100);
                goto L3
            L8:
                r101.is_editable = ProtoAdapter.BOOL.decode(r100);
                goto L3
            L9:
                r101.password = ProtoAdapter.STRING.decode(r100);
                goto L3
            L10:
                r101.meeting_url = ProtoAdapter.STRING.decode(r100);
                goto L3
            L11:
                r101.creator_account = ProtoAdapter.STRING.decode(r100);
                goto L3
            L12:
                r101.meeting_no = ProtoAdapter.INT64.decode(r100);
                goto L3
            L13:
                r101.meeting_id = ProtoAdapter.INT64.decode(r100);
                goto L3
            L6:
                FieldEncoding r104 = r100.peekFieldEncoding();
                r101.addUnknownField(r103, r104, r104.rawProtoAdapter().decode(r100));
                goto L3
            L14:
                r100.endMessage(r102);
                return r101.build();
            }

            /* JADX INFO: renamed from: encodedSize, reason: avoid collision after fix types in other method */
            public int encodedSize2(ZoomVideoMeetingConfigs r100) {
                Long r101 = r100.meeting_id;
                int r102 = 0;
                if (r101 == null) goto L5;
                int r103 = ProtoAdapter.INT64.encodedSizeWithTag(1, r101);
            L6:
                Long r104 = r100.meeting_no;
                if (r104 == null) goto L9;
                int r105 = ProtoAdapter.INT64.encodedSizeWithTag(2, r104);
            L10:
                int r106 = r103 + r105;
                String r107 = r100.creator_account;
                if (r107 == null) goto L13;
                int r108 = ProtoAdapter.STRING.encodedSizeWithTag(3, r107);
            L14:
                int r109 = r106 + r108;
                String r110 = r100.meeting_url;
                if (r110 == null) goto L17;
                int r111 = ProtoAdapter.STRING.encodedSizeWithTag(4, r110);
            L18:
                int r112 = r109 + r111;
                String r113 = r100.password;
                if (r113 == null) goto L21;
                int r114 = ProtoAdapter.STRING.encodedSizeWithTag(5, r113);
            L22:
                int r115 = r112 + r114;
                Boolean r116 = r100.is_editable;
                if (r116 == null) goto L25;
                int r117 = ProtoAdapter.BOOL.encodedSizeWithTag(6, r116);
            L26:
                int r118 = r115 + r117;
                Long r119 = r100.creator_user_id;
                if (r119 == null) goto L30;
                r102 = ProtoAdapter.INT64.encodedSizeWithTag(7, r119);
            L30:
                return (r118 + r102) + r100.unknownFields().size();
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
            public /* bridge */ /* synthetic */ ZoomVideoMeetingConfigs decode(ProtoReader r100) throws IOException {
                return decode(r100);
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ int encodedSize(ZoomVideoMeetingConfigs r100) {
                return encodedSize2(r100);
            }

            /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
            public void encode2(ProtoWriter r100, ZoomVideoMeetingConfigs r101) throws IOException {
                Long r102 = r101.meeting_id;
                if (r102 == null) goto L5;
                ProtoAdapter.INT64.encodeWithTag(r100, 1, r102);
            L5:
                Long r103 = r101.meeting_no;
                if (r103 == null) goto L8;
                ProtoAdapter.INT64.encodeWithTag(r100, 2, r103);
            L8:
                String r104 = r101.creator_account;
                if (r104 == null) goto L11;
                ProtoAdapter.STRING.encodeWithTag(r100, 3, r104);
            L11:
                String r105 = r101.meeting_url;
                if (r105 == null) goto L14;
                ProtoAdapter.STRING.encodeWithTag(r100, 4, r105);
            L14:
                String r106 = r101.password;
                if (r106 == null) goto L17;
                ProtoAdapter.STRING.encodeWithTag(r100, 5, r106);
            L17:
                Boolean r107 = r101.is_editable;
                if (r107 == null) goto L20;
                ProtoAdapter.BOOL.encodeWithTag(r100, 6, r107);
            L20:
                Long r108 = r101.creator_user_id;
                if (r108 == null) goto L23;
                ProtoAdapter.INT64.encodeWithTag(r100, 7, r108);
            L23:
                r100.writeBytes(r101.unknownFields());
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, ZoomVideoMeetingConfigs r101) throws IOException {
                encode2(r100, r101);
            }
        }

        static {
            ADAPTER = new ProtoAdapter_ZoomVideoMeetingConfigs();
            DEFAULT_MEETING_ID = 0L;
            DEFAULT_MEETING_NO = 0L;
            DEFAULT_IS_EDITABLE = Boolean.FALSE;
            DEFAULT_CREATOR_USER_ID = 0L;
        }

        @Override // com.squareup.wire.Message
        public Builder newBuilder() {
            Builder r100 = new Builder();
            r100.meeting_id = this.meeting_id;
            r100.meeting_no = this.meeting_no;
            r100.creator_account = this.creator_account;
            r100.meeting_url = this.meeting_url;
            r100.password = this.password;
            r100.is_editable = this.is_editable;
            r100.creator_user_id = this.creator_user_id;
            r100.addUnknownFields(unknownFields());
            return r100;
        }

        @Override // com.squareup.wire.Message
        public String toString() {
            return ZoomVideoMeetingConfigs.class.getName() + "@" + Integer.toHexString(hashCode());
        }

        @Override // com.squareup.wire.Message
        public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
            return newBuilder();
        }

        public ZoomVideoMeetingConfigs(Long r110, Long r111, String r112, String r113, String r114, Boolean r115, Long r116) {
            this(r110, r111, r112, r113, r114, r115, r116, ByteString.EMPTY);
        }

        public ZoomVideoMeetingConfigs(Long r100, Long r101, String r102, String r103, String r104, Boolean r105, Long r106, ByteString r107) {
            super(ADAPTER, r107);
            this.meeting_id = r100;
            this.meeting_no = r101;
            this.creator_account = r102;
            this.meeting_url = r103;
            this.password = r104;
            this.is_editable = r105;
            this.creator_user_id = r106;
        }
    }

    static {
        ADAPTER = new ProtoAdapter_EventVideoMeetingConfig();
        DEFAULT_VIDEO_MEETING_TYPE = VideoMeeting.VideoMeetingType.UNKNOWN_VIDEO_MEETING_TYPE;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.video_meeting_type = this.video_meeting_type;
        r100.meeting_url = this.meeting_url;
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
        return EventVideoMeetingConfig.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public EventVideoMeetingConfig(VideoMeeting.VideoMeetingType r110, String r111, LarkVCBindingData r112, OtherVideoMeetingConfigs r113, GoogleVideoMeetingConfigs r114, ZoomVideoMeetingConfigs r115, ThirdPartyMeetingConfigs r116) {
        this(r110, r111, r112, r113, r114, r115, r116, ByteString.EMPTY);
    }

    public EventVideoMeetingConfig(VideoMeeting.VideoMeetingType r100, String r101, LarkVCBindingData r102, OtherVideoMeetingConfigs r103, GoogleVideoMeetingConfigs r104, ZoomVideoMeetingConfigs r105, ThirdPartyMeetingConfigs r106, ByteString r107) {
        super(ADAPTER, r107);
        if (Internal.countNonNull(r103, r104, r105, r106, new Object[0]) > 1) goto L7;
        this.video_meeting_type = r100;
        this.meeting_url = r101;
        this.lark_vc_binding_data = r102;
        this.other_configs = r103;
        this.google_configs = r104;
        this.zoom_configs = r105;
        this.third_party_configs = r106;
        return;
    L7:
        throw new IllegalArgumentException("at most one of other_configs, google_configs, zoom_configs, third_party_configs may be non-null");
    }
}
