package com.ss.android.lark.pb.videochat_my_ai;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import com.squareup.wire.internal.Internal;
import com.ss.android.lark.pb.vc_common.ByteviewUser;
import java.io.IOException;
import java.util.List;
import okio.ByteString;

/* JADX INFO: loaded from: classes37.dex */
public final class CustomSummarySpeakerSummary extends Message<CustomSummarySpeakerSummary, Builder> {
    public static final ProtoAdapter<CustomSummarySpeakerSummary> ADAPTER = null;
    public static final String DEFAULT_CONTENT = "";
    public static final String DEFAULT_CONTENT_PERCENTAGE = "";
    private static final long serialVersionUID = 0;
    public final String mcontent;
    public final String mcontent_percentage;
    public final ByteviewUser mfrom_speaker;
    public final ByteviewUser mspeaker;
    public final List<MeetingAISSDInfo.VoicePrintMethodType> mspeaker_detect_type;
    public final MeetingAISSDInfo.SSDType mspeaker_type;

    public static final class Builder extends Message.Builder<CustomSummarySpeakerSummary, Builder> {
        public String mcontent;
        public String mcontent_percentage;
        public ByteviewUser mfrom_speaker;
        public ByteviewUser mspeaker;
        public List<MeetingAISSDInfo.VoicePrintMethodType> mspeaker_detect_type;
        public MeetingAISSDInfo.SSDType mspeaker_type;

        @Override // com.squareup.wire.Message.Builder
        public CustomSummarySpeakerSummary build() {
            return new CustomSummarySpeakerSummary(this.mspeaker, this.mcontent, this.mcontent_percentage, this.mspeaker_type, this.mfrom_speaker, this.mspeaker_detect_type, super.buildUnknownFields());
        }

        public Builder() {
            this.mspeaker_detect_type = Internal.newMutableList();
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder content(String r100) {
            this.mcontent = r100;
            return this;
        }

        public Builder content_percentage(String r100) {
            this.mcontent_percentage = r100;
            return this;
        }

        public Builder from_speaker(ByteviewUser r100) {
            this.mfrom_speaker = r100;
            return this;
        }

        public Builder speaker(ByteviewUser r100) {
            this.mspeaker = r100;
            return this;
        }

        public Builder speaker_detect_type(List<MeetingAISSDInfo.VoicePrintMethodType> r100) {
            Internal.checkElementsNotNull(r100);
            this.mspeaker_detect_type = r100;
            return this;
        }

        public Builder speaker_type(MeetingAISSDInfo.SSDType r100) {
            this.mspeaker_type = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_CustomSummarySpeakerSummary extends ProtoAdapter<CustomSummarySpeakerSummary> {
        public ProtoAdapter_CustomSummarySpeakerSummary() {
            super(FieldEncoding.LENGTH_DELIMITED, CustomSummarySpeakerSummary.class);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public CustomSummarySpeakerSummary decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            r101.mcontent = "";
            r101.mcontent_percentage = "";
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L19;
            switch(r103) {
                case 1: goto L18;
                case 2: goto L17;
                case 3: goto L16;
                case 4: goto L23;
                case 5: goto L11;
                case 6: goto L21;
                default: goto L6;
            };
        L21:
            r101.mspeaker_detect_type.add(MeetingAISSDInfo.VoicePrintMethodType.ADAPTER.decode(r100));     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L9
        L9:
            e = move-exception;
            r101.addUnknownField(r103, FieldEncoding.VARINT, Long.valueOf(e.value));
            goto L3
        L23:
            r101.mspeaker_type = MeetingAISSDInfo.SSDType.ADAPTER.decode(r100);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L14
        L14:
            e = move-exception;
            r101.addUnknownField(r103, FieldEncoding.VARINT, Long.valueOf(e.value));
            goto L3
        L11:
            r101.mfrom_speaker = ByteviewUser.ADAPTER.decode(r100);
            goto L3
        L16:
            r101.mcontent_percentage = ProtoAdapter.STRING.decode(r100);
            goto L3
        L17:
            r101.mcontent = ProtoAdapter.STRING.decode(r100);
            goto L3
        L18:
            r101.mspeaker = ByteviewUser.ADAPTER.decode(r100);
            goto L3
        L6:
            FieldEncoding r104 = r100.peekFieldEncoding();
            r101.addUnknownField(r103, r104, r104.rawProtoAdapter().decode(r100));
            goto L3
        L19:
            r100.endMessage(r102);
            return r101.build();
        }

        /* JADX INFO: renamed from: encodedSize, reason: avoid collision after fix types in other method */
        public int encodedSize2(CustomSummarySpeakerSummary r100) {
            ByteviewUser r101 = r100.mspeaker;
            int r102 = 0;
            if (r101 == null) goto L5;
            int r103 = ByteviewUser.ADAPTER.encodedSizeWithTag(1, r101);
        L6:
            String r104 = r100.mcontent;
            if (r104 == null) goto L9;
            int r105 = ProtoAdapter.STRING.encodedSizeWithTag(2, r104);
        L10:
            int r106 = r103 + r105;
            String r107 = r100.mcontent_percentage;
            if (r107 == null) goto L13;
            int r108 = ProtoAdapter.STRING.encodedSizeWithTag(3, r107);
        L14:
            int r109 = r106 + r108;
            MeetingAISSDInfo.SSDType r110 = r100.mspeaker_type;
            if (r110 == null) goto L17;
            int r111 = MeetingAISSDInfo.SSDType.ADAPTER.encodedSizeWithTag(4, r110);
        L18:
            int r112 = r109 + r111;
            ByteviewUser r113 = r100.mfrom_speaker;
            if (r113 == null) goto L22;
            r102 = ByteviewUser.ADAPTER.encodedSizeWithTag(5, r113);
        L22:
            return ((r112 + r102) + MeetingAISSDInfo.VoicePrintMethodType.ADAPTER.asRepeated().encodedSizeWithTag(6, r100.mspeaker_detect_type)) + r100.unknownFields().size();
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
        public /* bridge */ /* synthetic */ CustomSummarySpeakerSummary decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(CustomSummarySpeakerSummary r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, CustomSummarySpeakerSummary r101) throws IOException {
            ByteviewUser r102 = r101.mspeaker;
            if (r102 == null) goto L5;
            ByteviewUser.ADAPTER.encodeWithTag(r100, 1, r102);
        L5:
            String r103 = r101.mcontent;
            if (r103 == null) goto L8;
            ProtoAdapter.STRING.encodeWithTag(r100, 2, r103);
        L8:
            String r104 = r101.mcontent_percentage;
            if (r104 == null) goto L11;
            ProtoAdapter.STRING.encodeWithTag(r100, 3, r104);
        L11:
            MeetingAISSDInfo.SSDType r105 = r101.mspeaker_type;
            if (r105 == null) goto L14;
            MeetingAISSDInfo.SSDType.ADAPTER.encodeWithTag(r100, 4, r105);
        L14:
            ByteviewUser r106 = r101.mfrom_speaker;
            if (r106 == null) goto L17;
            ByteviewUser.ADAPTER.encodeWithTag(r100, 5, r106);
        L17:
            MeetingAISSDInfo.VoicePrintMethodType.ADAPTER.asRepeated().encodeWithTag(r100, 6, r101.mspeaker_detect_type);
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, CustomSummarySpeakerSummary r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_CustomSummarySpeakerSummary();
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.mspeaker = this.mspeaker;
        r100.mcontent = this.mcontent;
        r100.mcontent_percentage = this.mcontent_percentage;
        r100.mspeaker_type = this.mspeaker_type;
        r100.mfrom_speaker = this.mfrom_speaker;
        r100.mspeaker_detect_type = Internal.copyOf("mspeaker_detect_type", this.mspeaker_detect_type);
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return CustomSummarySpeakerSummary.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public CustomSummarySpeakerSummary(ByteviewUser r100, String r110, String r111, MeetingAISSDInfo.SSDType r112, ByteviewUser r113, List<MeetingAISSDInfo.VoicePrintMethodType> r114) {
        this(r100, r110, r111, r112, r113, r114, ByteString.EMPTY);
    }

    public CustomSummarySpeakerSummary(ByteviewUser r100, String r101, String r102, MeetingAISSDInfo.SSDType r103, ByteviewUser r104, List<MeetingAISSDInfo.VoicePrintMethodType> r105, ByteString r106) {
        super(ADAPTER, r106);
        this.mspeaker = r100;
        this.mcontent = r101;
        this.mcontent_percentage = r102;
        this.mspeaker_type = r103;
        this.mfrom_speaker = r104;
        this.mspeaker_detect_type = Internal.immutableCopyOf("mspeaker_detect_type", r105);
    }
}
