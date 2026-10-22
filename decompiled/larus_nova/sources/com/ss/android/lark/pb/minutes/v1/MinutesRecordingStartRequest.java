package com.ss.android.lark.pb.minutes.v1;

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

/* JADX INFO: loaded from: classes37.dex */
public final class MinutesRecordingStartRequest extends Message<MinutesRecordingStartRequest, Builder> {
    public static final ProtoAdapter<MinutesRecordingStartRequest> ADAPTER = null;
    public static final Boolean DEFAULT_APPLY_RECORDING_ID = null;
    public static final ContentType DEFAULT_CONTENT_TYPE = null;
    public static final ExtraType DEFAULT_EXTRA_TYPE = null;
    public static final ProtoAdapter_MinutesRecordingStartRequest RAW_TYPE_ADAPTER = null;
    private static final long serialVersionUID = 0;
    public final Boolean apply_recording_id;
    public final ContentType content_type;
    public final DoubaoBizInfo doubao_biz_info;
    public final ExtraType extra_type;
    public final HardwareInfo hardware_info;

    public static final class Builder extends Message.Builder<MinutesRecordingStartRequest, Builder> implements d<MinutesRecordingStartRequest> {
        public Boolean apply_recording_id;
        public ContentType content_type;
        public DoubaoBizInfo doubao_biz_info;
        public ExtraType extra_type;
        public HardwareInfo hardware_info;

        @Override // com.squareup.wire.Message.Builder
        public MinutesRecordingStartRequest build() {
            return new MinutesRecordingStartRequest(this.doubao_biz_info, this.extra_type, this.apply_recording_id, this.content_type, this.hardware_info, super.buildUnknownFields());
        }

        public Builder() {
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder apply_recording_id(Boolean r100) {
            this.apply_recording_id = r100;
            return this;
        }

        public Builder content_type(ContentType r100) {
            this.content_type = r100;
            return this;
        }

        public Builder doubao_biz_info(DoubaoBizInfo r100) {
            this.doubao_biz_info = r100;
            return this;
        }

        public Builder extra_type(ExtraType r100) {
            this.extra_type = r100;
            return this;
        }

        public Builder hardware_info(HardwareInfo r100) {
            this.hardware_info = r100;
            return this;
        }
    }

    public static final enum ContentType extends Enum<ContentType> implements WireEnum {
        private static final /* synthetic */ ContentType[] $VALUES = null;
        public static final ProtoAdapter<ContentType> ADAPTER = null;
        public static final ContentType COMMONRECORDING = null;
        public static final ContentType INTERPRETATION = null;
        private final int value;

        static {
            ContentType r100 = new ContentType("COMMONRECORDING", 0, 0);
            COMMONRECORDING = r100;
            ContentType r101 = new ContentType("INTERPRETATION", 1, 1);
            INTERPRETATION = r101;
            $VALUES = new ContentType[]{r100, r101};
            ADAPTER = ProtoAdapter.newEnumAdapter(ContentType.class);
        }

        public static ContentType[] values() {
            return (ContentType[]) $VALUES.clone();
        }

        @Override // com.squareup.wire.WireEnum
        public final int getValue() {
            return this.value;
        }

        public static ContentType fromValue(int r100) {
            if (r100 == 0) goto L10;
            if (r100 == 1) goto L8;
            return null;
        L8:
            return INTERPRETATION;
        L10:
            return COMMONRECORDING;
        }

        public static ContentType valueOf(String r100) {
            return (ContentType) a.a(ContentType.class, r100);
        }

        private ContentType(String r100, int r101, int r102) {
            super(r100, r101);
            this.value = r102;
        }
    }

    public static final class DoubaoBizInfo extends Message<DoubaoBizInfo, Builder> {
        public static final ProtoAdapter<DoubaoBizInfo> ADAPTER = null;
        public static final String DEFAULT_APP_ID = "";
        public static final String DEFAULT_BIZ_ID = "";
        public static final String DEFAULT_CONVERSATION_ID = "";
        public static final String DEFAULT_DEVICE_ID = "";
        public static final String DEFAULT_MESSAGE_ID = "";
        public static final String DEFAULT_RECORDING_ID = "";
        public static final String DEFAULT_REPLY_MESSAGE_ID = "";
        public static final String DEFAULT_TENANT_ID = "";
        public static final String DEFAULT_USER_ID = "";
        private static final long serialVersionUID = 0;
        public final String app_id;
        public final String biz_id;
        public final String conversation_id;
        public final String device_id;
        public final String message_id;
        public final String recording_id;
        public final String reply_message_id;
        public final String tenant_id;
        public final String user_id;

        public static final class Builder extends Message.Builder<DoubaoBizInfo, Builder> {
            public String app_id;
            public String biz_id;
            public String conversation_id;
            public String device_id;
            public String message_id;
            public String recording_id;
            public String reply_message_id;
            public String tenant_id;
            public String user_id;

            @Override // com.squareup.wire.Message.Builder
            public DoubaoBizInfo build() {
                return new DoubaoBizInfo(this.user_id, this.conversation_id, this.message_id, this.reply_message_id, this.biz_id, this.app_id, this.tenant_id, this.device_id, this.recording_id, super.buildUnknownFields());
            }

            public Builder() {
            }

            @Override // com.squareup.wire.Message.Builder
            public /* bridge */ /* synthetic */ Message build() {
                return build();
            }

            public Builder app_id(String r100) {
                this.app_id = r100;
                return this;
            }

            public Builder biz_id(String r100) {
                this.biz_id = r100;
                return this;
            }

            public Builder conversation_id(String r100) {
                this.conversation_id = r100;
                return this;
            }

            public Builder device_id(String r100) {
                this.device_id = r100;
                return this;
            }

            public Builder message_id(String r100) {
                this.message_id = r100;
                return this;
            }

            public Builder recording_id(String r100) {
                this.recording_id = r100;
                return this;
            }

            public Builder reply_message_id(String r100) {
                this.reply_message_id = r100;
                return this;
            }

            public Builder tenant_id(String r100) {
                this.tenant_id = r100;
                return this;
            }

            public Builder user_id(String r100) {
                this.user_id = r100;
                return this;
            }
        }

        public static final class ProtoAdapter_DoubaoBizInfo extends ProtoAdapter<DoubaoBizInfo> {
            public ProtoAdapter_DoubaoBizInfo() {
                super(FieldEncoding.LENGTH_DELIMITED, DoubaoBizInfo.class);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.squareup.wire.ProtoAdapter
            public DoubaoBizInfo decode(ProtoReader r100) throws IOException {
                Builder r101 = new Builder();
                r101.user_id = "";
                r101.conversation_id = "";
                r101.message_id = "";
                r101.reply_message_id = "";
                r101.biz_id = "";
                r101.app_id = "";
                r101.tenant_id = "";
                r101.device_id = "";
                r101.recording_id = "";
                long r102 = r100.beginMessage();
            L3:
                int r103 = r100.nextTag();
                if (r103 == (-1)) goto L16;
                switch(r103) {
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
                r101.recording_id = ProtoAdapter.STRING.decode(r100);
                goto L3
            L8:
                r101.device_id = ProtoAdapter.STRING.decode(r100);
                goto L3
            L9:
                r101.tenant_id = ProtoAdapter.STRING.decode(r100);
                goto L3
            L10:
                r101.app_id = ProtoAdapter.STRING.decode(r100);
                goto L3
            L11:
                r101.biz_id = ProtoAdapter.STRING.decode(r100);
                goto L3
            L12:
                r101.reply_message_id = ProtoAdapter.STRING.decode(r100);
                goto L3
            L13:
                r101.message_id = ProtoAdapter.STRING.decode(r100);
                goto L3
            L14:
                r101.conversation_id = ProtoAdapter.STRING.decode(r100);
                goto L3
            L15:
                r101.user_id = ProtoAdapter.STRING.decode(r100);
                goto L3
            L6:
                FieldEncoding r104 = r100.peekFieldEncoding();
                r101.addUnknownField(r103, r104, r104.rawProtoAdapter().decode(r100));
                goto L3
            L16:
                r100.endMessage(r102);
                return r101.build();
            }

            /* JADX INFO: renamed from: encodedSize, reason: avoid collision after fix types in other method */
            public int encodedSize2(DoubaoBizInfo r100) {
                String r101 = r100.user_id;
                int r102 = 0;
                if (r101 == null) goto L5;
                int r103 = ProtoAdapter.STRING.encodedSizeWithTag(1, r101);
            L6:
                String r104 = r100.conversation_id;
                if (r104 == null) goto L9;
                int r105 = ProtoAdapter.STRING.encodedSizeWithTag(2, r104);
            L10:
                int r106 = r103 + r105;
                String r107 = r100.message_id;
                if (r107 == null) goto L13;
                int r108 = ProtoAdapter.STRING.encodedSizeWithTag(3, r107);
            L14:
                int r109 = r106 + r108;
                String r110 = r100.reply_message_id;
                if (r110 == null) goto L17;
                int r111 = ProtoAdapter.STRING.encodedSizeWithTag(4, r110);
            L18:
                int r112 = r109 + r111;
                String r113 = r100.biz_id;
                if (r113 == null) goto L21;
                int r114 = ProtoAdapter.STRING.encodedSizeWithTag(5, r113);
            L22:
                int r115 = r112 + r114;
                String r116 = r100.app_id;
                if (r116 == null) goto L25;
                int r117 = ProtoAdapter.STRING.encodedSizeWithTag(6, r116);
            L26:
                int r118 = r115 + r117;
                String r119 = r100.tenant_id;
                if (r119 == null) goto L29;
                int r120 = ProtoAdapter.STRING.encodedSizeWithTag(7, r119);
            L30:
                int r121 = r118 + r120;
                String r122 = r100.device_id;
                if (r122 == null) goto L33;
                int r123 = ProtoAdapter.STRING.encodedSizeWithTag(8, r122);
            L34:
                int r124 = r121 + r123;
                String r125 = r100.recording_id;
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
            public /* bridge */ /* synthetic */ DoubaoBizInfo decode(ProtoReader r100) throws IOException {
                return decode(r100);
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ int encodedSize(DoubaoBizInfo r100) {
                return encodedSize2(r100);
            }

            /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
            public void encode2(ProtoWriter r100, DoubaoBizInfo r101) throws IOException {
                String r102 = r101.user_id;
                if (r102 == null) goto L5;
                ProtoAdapter.STRING.encodeWithTag(r100, 1, r102);
            L5:
                String r103 = r101.conversation_id;
                if (r103 == null) goto L8;
                ProtoAdapter.STRING.encodeWithTag(r100, 2, r103);
            L8:
                String r104 = r101.message_id;
                if (r104 == null) goto L11;
                ProtoAdapter.STRING.encodeWithTag(r100, 3, r104);
            L11:
                String r105 = r101.reply_message_id;
                if (r105 == null) goto L14;
                ProtoAdapter.STRING.encodeWithTag(r100, 4, r105);
            L14:
                String r106 = r101.biz_id;
                if (r106 == null) goto L17;
                ProtoAdapter.STRING.encodeWithTag(r100, 5, r106);
            L17:
                String r107 = r101.app_id;
                if (r107 == null) goto L20;
                ProtoAdapter.STRING.encodeWithTag(r100, 6, r107);
            L20:
                String r108 = r101.tenant_id;
                if (r108 == null) goto L23;
                ProtoAdapter.STRING.encodeWithTag(r100, 7, r108);
            L23:
                String r109 = r101.device_id;
                if (r109 == null) goto L26;
                ProtoAdapter.STRING.encodeWithTag(r100, 8, r109);
            L26:
                String r110 = r101.recording_id;
                if (r110 == null) goto L29;
                ProtoAdapter.STRING.encodeWithTag(r100, 9, r110);
            L29:
                r100.writeBytes(r101.unknownFields());
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, DoubaoBizInfo r101) throws IOException {
                encode2(r100, r101);
            }
        }

        static {
            ADAPTER = new ProtoAdapter_DoubaoBizInfo();
        }

        @Override // com.squareup.wire.Message
        public Builder newBuilder() {
            Builder r100 = new Builder();
            r100.user_id = this.user_id;
            r100.conversation_id = this.conversation_id;
            r100.message_id = this.message_id;
            r100.reply_message_id = this.reply_message_id;
            r100.biz_id = this.biz_id;
            r100.app_id = this.app_id;
            r100.tenant_id = this.tenant_id;
            r100.device_id = this.device_id;
            r100.recording_id = this.recording_id;
            r100.addUnknownFields(unknownFields());
            return r100;
        }

        @Override // com.squareup.wire.Message
        public String toString() {
            return DoubaoBizInfo.class.getName() + "@" + Integer.toHexString(hashCode());
        }

        @Override // com.squareup.wire.Message
        public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
            return newBuilder();
        }

        public DoubaoBizInfo(String r110, String r111, String r112, String r113, String r114, String r115, String r116, String r117, String r210) {
            this(r110, r111, r112, r113, r114, r115, r116, r117, r210, ByteString.EMPTY);
        }

        public DoubaoBizInfo(String r100, String r101, String r102, String r103, String r104, String r105, String r106, String r107, String r110, ByteString r111) {
            super(ADAPTER, r111);
            this.user_id = r100;
            this.conversation_id = r101;
            this.message_id = r102;
            this.reply_message_id = r103;
            this.biz_id = r104;
            this.app_id = r105;
            this.tenant_id = r106;
            this.device_id = r107;
            this.recording_id = r110;
        }
    }

    public static final enum ExtraType extends Enum<ExtraType> implements WireEnum {
        private static final /* synthetic */ ExtraType[] $VALUES = null;
        public static final ProtoAdapter<ExtraType> ADAPTER = null;
        public static final ExtraType DOUBAO_EARBUDS = null;
        public static final ExtraType DOUBAO_GLASSES = null;
        public static final ExtraType DOUBAO_IN_LARK = null;
        public static final ExtraType UNKNOWN = null;
        private final int value;

        static {
            ExtraType r100 = new ExtraType("UNKNOWN", 0, 0);
            UNKNOWN = r100;
            ExtraType r101 = new ExtraType("DOUBAO_IN_LARK", 1, 1);
            DOUBAO_IN_LARK = r101;
            ExtraType r102 = new ExtraType("DOUBAO_GLASSES", 2, 2);
            DOUBAO_GLASSES = r102;
            ExtraType r103 = new ExtraType("DOUBAO_EARBUDS", 3, 3);
            DOUBAO_EARBUDS = r103;
            $VALUES = new ExtraType[]{r100, r101, r102, r103};
            ADAPTER = ProtoAdapter.newEnumAdapter(ExtraType.class);
        }

        public static ExtraType[] values() {
            return (ExtraType[]) $VALUES.clone();
        }

        @Override // com.squareup.wire.WireEnum
        public final int getValue() {
            return this.value;
        }

        public static ExtraType fromValue(int r100) {
            if (r100 == 0) goto L18;
            if (r100 == 1) goto L16;
            if (r100 == 2) goto L14;
            if (r100 == 3) goto L12;
            return null;
        L12:
            return DOUBAO_EARBUDS;
        L14:
            return DOUBAO_GLASSES;
        L16:
            return DOUBAO_IN_LARK;
        L18:
            return UNKNOWN;
        }

        public static ExtraType valueOf(String r100) {
            return (ExtraType) a.a(ExtraType.class, r100);
        }

        private ExtraType(String r100, int r101, int r102) {
            super(r100, r101);
            this.value = r102;
        }
    }

    public static final class HardwareInfo extends Message<HardwareInfo, Builder> {
        public static final ProtoAdapter<HardwareInfo> ADAPTER = null;
        public static final HardwareSubType DEFAULT_HARDWARE_SUBTYPE = null;
        public static final String DEFAULT_HARDWARE_UNIQUE_KEY = "";
        private static final long serialVersionUID = 0;
        public final HardwareSubType hardware_subtype;
        public final String hardware_unique_key;

        public static final class Builder extends Message.Builder<HardwareInfo, Builder> {
            public HardwareSubType hardware_subtype;
            public String hardware_unique_key;

            @Override // com.squareup.wire.Message.Builder
            public HardwareInfo build() {
                return new HardwareInfo(this.hardware_unique_key, this.hardware_subtype, super.buildUnknownFields());
            }

            public Builder() {
            }

            @Override // com.squareup.wire.Message.Builder
            public /* bridge */ /* synthetic */ Message build() {
                return build();
            }

            public Builder hardware_subtype(HardwareSubType r100) {
                this.hardware_subtype = r100;
                return this;
            }

            public Builder hardware_unique_key(String r100) {
                this.hardware_unique_key = r100;
                return this;
            }
        }

        public static final enum HardwareSubType extends Enum<HardwareSubType> implements WireEnum {
            private static final /* synthetic */ HardwareSubType[] $VALUES = null;
            public static final ProtoAdapter<HardwareSubType> ADAPTER = null;
            public static final HardwareSubType LIBERTY = null;
            public static final HardwareSubType SOUNDCORE = null;
            private final int value;

            static {
                HardwareSubType r100 = new HardwareSubType("SOUNDCORE", 0, 0);
                SOUNDCORE = r100;
                HardwareSubType r101 = new HardwareSubType("LIBERTY", 1, 1);
                LIBERTY = r101;
                $VALUES = new HardwareSubType[]{r100, r101};
                ADAPTER = ProtoAdapter.newEnumAdapter(HardwareSubType.class);
            }

            public static HardwareSubType[] values() {
                return (HardwareSubType[]) $VALUES.clone();
            }

            @Override // com.squareup.wire.WireEnum
            public final int getValue() {
                return this.value;
            }

            public static HardwareSubType fromValue(int r100) {
                if (r100 == 0) goto L10;
                if (r100 == 1) goto L8;
                return null;
            L8:
                return LIBERTY;
            L10:
                return SOUNDCORE;
            }

            public static HardwareSubType valueOf(String r100) {
                return (HardwareSubType) a.a(HardwareSubType.class, r100);
            }

            private HardwareSubType(String r100, int r101, int r102) {
                super(r100, r101);
                this.value = r102;
            }
        }

        public static final class ProtoAdapter_HardwareInfo extends ProtoAdapter<HardwareInfo> {
            public ProtoAdapter_HardwareInfo() {
                super(FieldEncoding.LENGTH_DELIMITED, HardwareInfo.class);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.squareup.wire.ProtoAdapter
            public HardwareInfo decode(ProtoReader r100) throws IOException {
                Builder r101 = new Builder();
                r101.hardware_unique_key = "";
                r101.hardware_subtype = HardwareSubType.SOUNDCORE;
                long r102 = r100.beginMessage();
            L3:
                int r103 = r100.nextTag();
                if (r103 == (-1)) goto L15;
                if (r103 != 1) goto L8;
                r101.hardware_unique_key = ProtoAdapter.STRING.decode(r100);
                goto L3
            L8:
                if (r103 != 2) goto L9;
                r101.hardware_subtype = HardwareSubType.ADAPTER.decode(r100);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L12
            L12:
                e = move-exception;
                r101.addUnknownField(r103, FieldEncoding.VARINT, Long.valueOf(e.value));
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
            public int encodedSize2(HardwareInfo r100) {
                String r101 = r100.hardware_unique_key;
                int r102 = 0;
                if (r101 == null) goto L5;
                int r103 = ProtoAdapter.STRING.encodedSizeWithTag(1, r101);
            L6:
                HardwareSubType r104 = r100.hardware_subtype;
                if (r104 == null) goto L10;
                r102 = HardwareSubType.ADAPTER.encodedSizeWithTag(2, r104);
            L10:
                return (r103 + r102) + r100.unknownFields().size();
            L5:
                r103 = 0;
                goto L6
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ HardwareInfo decode(ProtoReader r100) throws IOException {
                return decode(r100);
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ int encodedSize(HardwareInfo r100) {
                return encodedSize2(r100);
            }

            /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
            public void encode2(ProtoWriter r100, HardwareInfo r101) throws IOException {
                String r102 = r101.hardware_unique_key;
                if (r102 == null) goto L5;
                ProtoAdapter.STRING.encodeWithTag(r100, 1, r102);
            L5:
                HardwareSubType r103 = r101.hardware_subtype;
                if (r103 == null) goto L8;
                HardwareSubType.ADAPTER.encodeWithTag(r100, 2, r103);
            L8:
                r100.writeBytes(r101.unknownFields());
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, HardwareInfo r101) throws IOException {
                encode2(r100, r101);
            }
        }

        static {
            ADAPTER = new ProtoAdapter_HardwareInfo();
            DEFAULT_HARDWARE_SUBTYPE = HardwareSubType.SOUNDCORE;
        }

        @Override // com.squareup.wire.Message
        public Builder newBuilder() {
            Builder r100 = new Builder();
            r100.hardware_unique_key = this.hardware_unique_key;
            r100.hardware_subtype = this.hardware_subtype;
            r100.addUnknownFields(unknownFields());
            return r100;
        }

        @Override // com.squareup.wire.Message
        public String toString() {
            return HardwareInfo.class.getName() + "@" + Integer.toHexString(hashCode());
        }

        @Override // com.squareup.wire.Message
        public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
            return newBuilder();
        }

        public HardwareInfo(String r100, HardwareSubType r101) {
            this(r100, r101, ByteString.EMPTY);
        }

        public HardwareInfo(String r100, HardwareSubType r101, ByteString r102) {
            super(ADAPTER, r102);
            this.hardware_unique_key = r100;
            this.hardware_subtype = r101;
        }
    }

    public static final class ProtoAdapter_MinutesRecordingStartRequest extends ProtoAdapter<MinutesRecordingStartRequest> implements c<MinutesRecordingStartRequest> {
        public ProtoAdapter_MinutesRecordingStartRequest() {
            super(FieldEncoding.LENGTH_DELIMITED, MinutesRecordingStartRequest.class);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public MinutesRecordingStartRequest decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            r101.extra_type = ExtraType.UNKNOWN;
            r101.apply_recording_id = Boolean.FALSE;
            r101.content_type = ContentType.COMMONRECORDING;
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L27;
            if (r103 != 1) goto L8;
            r101.doubao_biz_info = DoubaoBizInfo.ADAPTER.decode(r100);
            goto L3
        L8:
            if (r103 != 2) goto L10;
            r101.extra_type = ExtraType.ADAPTER.decode(r100);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L24
        L24:
            e = move-exception;
            r101.addUnknownField(r103, FieldEncoding.VARINT, Long.valueOf(e.value));
            goto L3
        L10:
            if (r103 != 3) goto L12;
            r101.apply_recording_id = ProtoAdapter.BOOL.decode(r100);
            goto L3
        L12:
            if (r103 != 4) goto L14;
            r101.content_type = ContentType.ADAPTER.decode(r100);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L19
        L19:
            e = move-exception;
            r101.addUnknownField(r103, FieldEncoding.VARINT, Long.valueOf(e.value));
            goto L3
        L14:
            if (r103 != 5) goto L15;
            r101.hardware_info = HardwareInfo.ADAPTER.decode(r100);
            goto L3
        L15:
            FieldEncoding r104 = r100.peekFieldEncoding();
            r101.addUnknownField(r103, r104, r104.rawProtoAdapter().decode(r100));
            goto L3
        L27:
            r100.endMessage(r102);
            return r101.build();
        }

        /* JADX INFO: renamed from: encodedSize, reason: avoid collision after fix types in other method */
        public int encodedSize2(MinutesRecordingStartRequest r100) {
            DoubaoBizInfo r101 = r100.doubao_biz_info;
            int r102 = 0;
            if (r101 == null) goto L5;
            int r103 = DoubaoBizInfo.ADAPTER.encodedSizeWithTag(1, r101);
        L6:
            ExtraType r104 = r100.extra_type;
            if (r104 == null) goto L9;
            int r105 = ExtraType.ADAPTER.encodedSizeWithTag(2, r104);
        L10:
            int r106 = r103 + r105;
            Boolean r107 = r100.apply_recording_id;
            if (r107 == null) goto L13;
            int r108 = ProtoAdapter.BOOL.encodedSizeWithTag(3, r107);
        L14:
            int r109 = r106 + r108;
            ContentType r110 = r100.content_type;
            if (r110 == null) goto L17;
            int r111 = ContentType.ADAPTER.encodedSizeWithTag(4, r110);
        L18:
            int r112 = r109 + r111;
            HardwareInfo r113 = r100.hardware_info;
            if (r113 == null) goto L22;
            r102 = HardwareInfo.ADAPTER.encodedSizeWithTag(5, r113);
        L22:
            return (r112 + r102) + r100.unknownFields().size();
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
        public /* bridge */ /* synthetic */ MinutesRecordingStartRequest decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(MinutesRecordingStartRequest r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, MinutesRecordingStartRequest r101) throws IOException {
            DoubaoBizInfo r102 = r101.doubao_biz_info;
            if (r102 == null) goto L5;
            DoubaoBizInfo.ADAPTER.encodeWithTag(r100, 1, r102);
        L5:
            ExtraType r103 = r101.extra_type;
            if (r103 == null) goto L8;
            ExtraType.ADAPTER.encodeWithTag(r100, 2, r103);
        L8:
            Boolean r104 = r101.apply_recording_id;
            if (r104 == null) goto L11;
            ProtoAdapter.BOOL.encodeWithTag(r100, 3, r104);
        L11:
            ContentType r105 = r101.content_type;
            if (r105 == null) goto L14;
            ContentType.ADAPTER.encodeWithTag(r100, 4, r105);
        L14:
            HardwareInfo r106 = r101.hardware_info;
            if (r106 == null) goto L17;
            HardwareInfo.ADAPTER.encodeWithTag(r100, 5, r106);
        L17:
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, MinutesRecordingStartRequest r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ProtoAdapter_MinutesRecordingStartRequest r100 = new ProtoAdapter_MinutesRecordingStartRequest();
        RAW_TYPE_ADAPTER = r100;
        ADAPTER = r100;
        DEFAULT_EXTRA_TYPE = ExtraType.UNKNOWN;
        DEFAULT_APPLY_RECORDING_ID = Boolean.FALSE;
        DEFAULT_CONTENT_TYPE = ContentType.COMMONRECORDING;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.doubao_biz_info = this.doubao_biz_info;
        r100.extra_type = this.extra_type;
        r100.apply_recording_id = this.apply_recording_id;
        r100.content_type = this.content_type;
        r100.hardware_info = this.hardware_info;
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return MinutesRecordingStartRequest.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public MinutesRecordingStartRequest(DoubaoBizInfo r100, ExtraType r101, Boolean r110, ContentType r111, HardwareInfo r112) {
        this(r100, r101, r110, r111, r112, ByteString.EMPTY);
    }

    public MinutesRecordingStartRequest(DoubaoBizInfo r100, ExtraType r101, Boolean r102, ContentType r103, HardwareInfo r104, ByteString r105) {
        super(ADAPTER, r105);
        this.doubao_biz_info = r100;
        this.extra_type = r101;
        this.apply_recording_id = r102;
        this.content_type = r103;
        this.hardware_info = r104;
    }
}
