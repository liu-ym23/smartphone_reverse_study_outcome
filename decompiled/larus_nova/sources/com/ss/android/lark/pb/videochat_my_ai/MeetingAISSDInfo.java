package com.ss.android.lark.pb.videochat_my_ai;

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
public final class MeetingAISSDInfo extends Message<MeetingAISSDInfo, Builder> {
    public static final ProtoAdapter<MeetingAISSDInfo> ADAPTER = null;
    public static final Long DEFAULT_SPEAKER_ID = null;
    private static final long serialVersionUID = 0;
    public final VoicePrintMethodType mspeaker_detect_type;
    public final Long mspeaker_id;
    public final SSDType mspeaker_type;

    public static final class Builder extends Message.Builder<MeetingAISSDInfo, Builder> {
        public VoicePrintMethodType mspeaker_detect_type;
        public Long mspeaker_id;
        public SSDType mspeaker_type;

        @Override // com.squareup.wire.Message.Builder
        public MeetingAISSDInfo build() {
            return new MeetingAISSDInfo(this.mspeaker_type, this.mspeaker_id, this.mspeaker_detect_type, super.buildUnknownFields());
        }

        public Builder() {
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder speaker_detect_type(VoicePrintMethodType r100) {
            this.mspeaker_detect_type = r100;
            return this;
        }

        public Builder speaker_id(Long r100) {
            this.mspeaker_id = r100;
            return this;
        }

        public Builder speaker_type(SSDType r100) {
            this.mspeaker_type = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_MeetingAISSDInfo extends ProtoAdapter<MeetingAISSDInfo> {
        public ProtoAdapter_MeetingAISSDInfo() {
            super(FieldEncoding.LENGTH_DELIMITED, MeetingAISSDInfo.class);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public MeetingAISSDInfo decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            r101.mspeaker_id = 0L;
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L21;
            if (r103 != 1) goto L8;
            r101.mspeaker_type = SSDType.ADAPTER.decode(r100);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L19
        L19:
            e = move-exception;
            r101.addUnknownField(r103, FieldEncoding.VARINT, Long.valueOf(e.value));
            goto L3
        L8:
            if (r103 != 2) goto L10;
            r101.mspeaker_id = ProtoAdapter.INT64.decode(r100);
            goto L3
        L10:
            if (r103 != 3) goto L11;
            r101.mspeaker_detect_type = VoicePrintMethodType.ADAPTER.decode(r100);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L14
        L14:
            e = move-exception;
            r101.addUnknownField(r103, FieldEncoding.VARINT, Long.valueOf(e.value));
            goto L3
        L11:
            FieldEncoding r104 = r100.peekFieldEncoding();
            r101.addUnknownField(r103, r104, r104.rawProtoAdapter().decode(r100));
            goto L3
        L21:
            r100.endMessage(r102);
            return r101.build();
        }

        /* JADX INFO: renamed from: encodedSize, reason: avoid collision after fix types in other method */
        public int encodedSize2(MeetingAISSDInfo r100) {
            SSDType r101 = r100.mspeaker_type;
            int r102 = 0;
            if (r101 == null) goto L5;
            int r103 = SSDType.ADAPTER.encodedSizeWithTag(1, r101);
        L6:
            Long r104 = r100.mspeaker_id;
            if (r104 == null) goto L9;
            int r105 = ProtoAdapter.INT64.encodedSizeWithTag(2, r104);
        L10:
            int r106 = r103 + r105;
            VoicePrintMethodType r107 = r100.mspeaker_detect_type;
            if (r107 == null) goto L14;
            r102 = VoicePrintMethodType.ADAPTER.encodedSizeWithTag(3, r107);
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
        public /* bridge */ /* synthetic */ MeetingAISSDInfo decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(MeetingAISSDInfo r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, MeetingAISSDInfo r101) throws IOException {
            SSDType r102 = r101.mspeaker_type;
            if (r102 == null) goto L5;
            SSDType.ADAPTER.encodeWithTag(r100, 1, r102);
        L5:
            Long r103 = r101.mspeaker_id;
            if (r103 == null) goto L8;
            ProtoAdapter.INT64.encodeWithTag(r100, 2, r103);
        L8:
            VoicePrintMethodType r104 = r101.mspeaker_detect_type;
            if (r104 == null) goto L11;
            VoicePrintMethodType.ADAPTER.encodeWithTag(r100, 3, r104);
        L11:
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, MeetingAISSDInfo r101) throws IOException {
            encode2(r100, r101);
        }
    }

    public static final enum SSDType extends Enum<SSDType> implements WireEnum {
        private static final /* synthetic */ SSDType[] $VALUES = null;
        public static final ProtoAdapter<SSDType> ADAPTER = null;
        public static final SSDType TYPE_SID_DETECT = null;
        public static final SSDType TYPE_SSD_DETECT = null;
        public static final SSDType TYPE_UNKNOWN = null;
        private final int value;

        static {
            SSDType r100 = new SSDType("TYPE_UNKNOWN", 0, 0);
            TYPE_UNKNOWN = r100;
            SSDType r101 = new SSDType("TYPE_SSD_DETECT", 1, 1);
            TYPE_SSD_DETECT = r101;
            SSDType r102 = new SSDType("TYPE_SID_DETECT", 2, 2);
            TYPE_SID_DETECT = r102;
            $VALUES = new SSDType[]{r100, r101, r102};
            ADAPTER = ProtoAdapter.newEnumAdapter(SSDType.class);
        }

        public static SSDType[] values() {
            return (SSDType[]) $VALUES.clone();
        }

        @Override // com.squareup.wire.WireEnum
        public final int getValue() {
            return this.value;
        }

        public static SSDType fromValue(int r100) {
            if (r100 == 0) goto L14;
            if (r100 == 1) goto L12;
            if (r100 == 2) goto L10;
            return null;
        L10:
            return TYPE_SID_DETECT;
        L12:
            return TYPE_SSD_DETECT;
        L14:
            return TYPE_UNKNOWN;
        }

        public static SSDType valueOf(String r100) {
            return (SSDType) a.a(SSDType.class, r100);
        }

        private SSDType(String r100, int r101, int r102) {
            super(r100, r101);
            this.value = r102;
        }
    }

    public static final enum VoicePrintMethodType extends Enum<VoicePrintMethodType> implements WireEnum {
        private static final /* synthetic */ VoicePrintMethodType[] $VALUES = null;
        public static final ProtoAdapter<VoicePrintMethodType> ADAPTER = null;
        public static final VoicePrintMethodType METHOD_TYPE_IDENTIFY = null;
        public static final VoicePrintMethodType METHOD_TYPE_INFERENCE = null;
        public static final VoicePrintMethodType METHOD_TYPE_UNKNOWN = null;
        private final int value;

        static {
            VoicePrintMethodType r100 = new VoicePrintMethodType("METHOD_TYPE_UNKNOWN", 0, 0);
            METHOD_TYPE_UNKNOWN = r100;
            VoicePrintMethodType r101 = new VoicePrintMethodType("METHOD_TYPE_IDENTIFY", 1, 1);
            METHOD_TYPE_IDENTIFY = r101;
            VoicePrintMethodType r102 = new VoicePrintMethodType("METHOD_TYPE_INFERENCE", 2, 2);
            METHOD_TYPE_INFERENCE = r102;
            $VALUES = new VoicePrintMethodType[]{r100, r101, r102};
            ADAPTER = ProtoAdapter.newEnumAdapter(VoicePrintMethodType.class);
        }

        public static VoicePrintMethodType[] values() {
            return (VoicePrintMethodType[]) $VALUES.clone();
        }

        @Override // com.squareup.wire.WireEnum
        public final int getValue() {
            return this.value;
        }

        public static VoicePrintMethodType fromValue(int r100) {
            if (r100 == 0) goto L14;
            if (r100 == 1) goto L12;
            if (r100 == 2) goto L10;
            return null;
        L10:
            return METHOD_TYPE_INFERENCE;
        L12:
            return METHOD_TYPE_IDENTIFY;
        L14:
            return METHOD_TYPE_UNKNOWN;
        }

        public static VoicePrintMethodType valueOf(String r100) {
            return (VoicePrintMethodType) a.a(VoicePrintMethodType.class, r100);
        }

        private VoicePrintMethodType(String r100, int r101, int r102) {
            super(r100, r101);
            this.value = r102;
        }
    }

    static {
        ADAPTER = new ProtoAdapter_MeetingAISSDInfo();
        DEFAULT_SPEAKER_ID = 0L;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.mspeaker_type = this.mspeaker_type;
        r100.mspeaker_id = this.mspeaker_id;
        r100.mspeaker_detect_type = this.mspeaker_detect_type;
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return MeetingAISSDInfo.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public MeetingAISSDInfo(SSDType r100, Long r101, VoicePrintMethodType r102) {
        this(r100, r101, r102, ByteString.EMPTY);
    }

    public MeetingAISSDInfo(SSDType r100, Long r101, VoicePrintMethodType r102, ByteString r103) {
        super(ADAPTER, r103);
        this.mspeaker_type = r100;
        this.mspeaker_id = r101;
        this.mspeaker_detect_type = r102;
    }
}
