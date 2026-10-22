package com.ss.android.lark.pb.videochat;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import com.squareup.wire.internal.Internal;
import java.io.IOException;
import okio.ByteString;

/* JADX INFO: loaded from: classes37.dex */
public final class SetSpeakerInfoRequest extends Message<SetSpeakerInfoRequest, Builder> {
    public static final ProtoAdapter<SetSpeakerInfoRequest> ADAPTER = null;
    public static final String DEFAULT_CLUSTER_ID = "";
    public static final String DEFAULT_MEETING_ID = "";
    public static final String DEFAULT_OPERATOR_ID = "";
    public static final Long DEFAULT_SEG_ID = null;
    private static final long serialVersionUID = 0;
    public final String mcluster_id;
    public final LarkSpeakerInfo mlark_speaker_info;
    public final String mmeeting_id;
    public final String moperator_id;
    public final Long mseg_id;
    public final SpeakerInfo mspeaker_info;
    public final SpeakerInfoType mspeaker_info_type;

    public static final class Builder extends Message.Builder<SetSpeakerInfoRequest, Builder> {
        public String mcluster_id;
        public LarkSpeakerInfo mlark_speaker_info;
        public String mmeeting_id;
        public String moperator_id;
        public Long mseg_id;
        public SpeakerInfo mspeaker_info;
        public SpeakerInfoType mspeaker_info_type;

        @Override // com.squareup.wire.Message.Builder
        public SetSpeakerInfoRequest build() {
            String r100 = this.moperator_id;
            if (r100 == null) goto L13;
            if (this.mmeeting_id == null) goto L13;
            if (this.mcluster_id == null) goto L13;
            if (this.mspeaker_info_type == null) goto L13;
            return new SetSpeakerInfoRequest(this.moperator_id, this.mmeeting_id, this.mcluster_id, this.mspeaker_info_type, this.mspeaker_info, this.mlark_speaker_info, this.mseg_id, super.buildUnknownFields());
        L13:
            throw Internal.missingRequiredFields(new Object[]{r100, "moperator_id", this.mmeeting_id, "mmeeting_id", this.mcluster_id, "mcluster_id", this.mspeaker_info_type, "mspeaker_info_type"});
        }

        public Builder() {
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder cluster_id(String r100) {
            this.mcluster_id = r100;
            return this;
        }

        public Builder lark_speaker_info(LarkSpeakerInfo r100) {
            this.mlark_speaker_info = r100;
            return this;
        }

        public Builder meeting_id(String r100) {
            this.mmeeting_id = r100;
            return this;
        }

        public Builder operator_id(String r100) {
            this.moperator_id = r100;
            return this;
        }

        public Builder seg_id(Long r100) {
            this.mseg_id = r100;
            return this;
        }

        public Builder speaker_info(SpeakerInfo r100) {
            this.mspeaker_info = r100;
            return this;
        }

        public Builder speaker_info_type(SpeakerInfoType r100) {
            this.mspeaker_info_type = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_SetSpeakerInfoRequest extends ProtoAdapter<SetSpeakerInfoRequest> {
        public ProtoAdapter_SetSpeakerInfoRequest() {
            super(FieldEncoding.LENGTH_DELIMITED, SetSpeakerInfoRequest.class);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public SetSpeakerInfoRequest decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            r101.moperator_id = "";
            r101.mmeeting_id = "";
            r101.mcluster_id = "";
            r101.mseg_id = 0L;
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L17;
            switch(r103) {
                case 1: goto L16;
                case 2: goto L15;
                case 3: goto L14;
                case 4: goto L19;
                case 5: goto L9;
                case 6: goto L8;
                case 7: goto L7;
                default: goto L6;
            };
        L19:
            r101.mspeaker_info_type = SpeakerInfoType.ADAPTER.decode(r100);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L12
        L12:
            e = move-exception;
            r101.addUnknownField(r103, FieldEncoding.VARINT, Long.valueOf(e.value));
            goto L3
        L7:
            r101.mseg_id = ProtoAdapter.INT64.decode(r100);
            goto L3
        L8:
            r101.mlark_speaker_info = LarkSpeakerInfo.ADAPTER.decode(r100);
            goto L3
        L9:
            r101.mspeaker_info = SpeakerInfo.ADAPTER.decode(r100);
            goto L3
        L14:
            r101.mcluster_id = ProtoAdapter.STRING.decode(r100);
            goto L3
        L15:
            r101.mmeeting_id = ProtoAdapter.STRING.decode(r100);
            goto L3
        L16:
            r101.moperator_id = ProtoAdapter.STRING.decode(r100);
            goto L3
        L6:
            FieldEncoding r104 = r100.peekFieldEncoding();
            r101.addUnknownField(r103, r104, r104.rawProtoAdapter().decode(r100));
            goto L3
        L17:
            r100.endMessage(r102);
            return r101.build();
        }

        /* JADX INFO: renamed from: encodedSize, reason: avoid collision after fix types in other method */
        public int encodedSize2(SetSpeakerInfoRequest r100) {
            ProtoAdapter<String> r101 = ProtoAdapter.STRING;
            int r102 = ((r101.encodedSizeWithTag(1, r100.moperator_id) + r101.encodedSizeWithTag(2, r100.mmeeting_id)) + r101.encodedSizeWithTag(3, r100.mcluster_id)) + SpeakerInfoType.ADAPTER.encodedSizeWithTag(4, r100.mspeaker_info_type);
            SpeakerInfo r103 = r100.mspeaker_info;
            int r104 = 0;
            if (r103 == null) goto L5;
            int r105 = SpeakerInfo.ADAPTER.encodedSizeWithTag(5, r103);
        L6:
            int r106 = r102 + r105;
            LarkSpeakerInfo r107 = r100.mlark_speaker_info;
            if (r107 == null) goto L9;
            int r108 = LarkSpeakerInfo.ADAPTER.encodedSizeWithTag(6, r107);
        L10:
            int r109 = r106 + r108;
            Long r110 = r100.mseg_id;
            if (r110 == null) goto L14;
            r104 = ProtoAdapter.INT64.encodedSizeWithTag(7, r110);
        L14:
            return (r109 + r104) + r100.unknownFields().size();
        L9:
            r108 = 0;
            goto L10
        L5:
            r105 = 0;
            goto L6
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ SetSpeakerInfoRequest decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(SetSpeakerInfoRequest r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, SetSpeakerInfoRequest r101) throws IOException {
            ProtoAdapter<String> r102 = ProtoAdapter.STRING;
            r102.encodeWithTag(r100, 1, r101.moperator_id);
            r102.encodeWithTag(r100, 2, r101.mmeeting_id);
            r102.encodeWithTag(r100, 3, r101.mcluster_id);
            SpeakerInfoType.ADAPTER.encodeWithTag(r100, 4, r101.mspeaker_info_type);
            SpeakerInfo r103 = r101.mspeaker_info;
            if (r103 == null) goto L5;
            SpeakerInfo.ADAPTER.encodeWithTag(r100, 5, r103);
        L5:
            LarkSpeakerInfo r104 = r101.mlark_speaker_info;
            if (r104 == null) goto L8;
            LarkSpeakerInfo.ADAPTER.encodeWithTag(r100, 6, r104);
        L8:
            Long r105 = r101.mseg_id;
            if (r105 == null) goto L11;
            ProtoAdapter.INT64.encodeWithTag(r100, 7, r105);
        L11:
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, SetSpeakerInfoRequest r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_SetSpeakerInfoRequest();
        DEFAULT_SEG_ID = 0L;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.moperator_id = this.moperator_id;
        r100.mmeeting_id = this.mmeeting_id;
        r100.mcluster_id = this.mcluster_id;
        r100.mspeaker_info_type = this.mspeaker_info_type;
        r100.mspeaker_info = this.mspeaker_info;
        r100.mlark_speaker_info = this.mlark_speaker_info;
        r100.mseg_id = this.mseg_id;
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return SetSpeakerInfoRequest.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public SetSpeakerInfoRequest(String r110, String r111, String r112, SpeakerInfoType r113, SpeakerInfo r114, LarkSpeakerInfo r115, Long r116) {
        this(r110, r111, r112, r113, r114, r115, r116, ByteString.EMPTY);
    }

    public SetSpeakerInfoRequest(String r100, String r101, String r102, SpeakerInfoType r103, SpeakerInfo r104, LarkSpeakerInfo r105, Long r106, ByteString r107) {
        super(ADAPTER, r107);
        this.moperator_id = r100;
        this.mmeeting_id = r101;
        this.mcluster_id = r102;
        this.mspeaker_info_type = r103;
        this.mspeaker_info = r104;
        this.mlark_speaker_info = r105;
        this.mseg_id = r106;
    }
}
