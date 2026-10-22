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
public final class GetSpeakerInfoListResponse extends Message<GetSpeakerInfoListResponse, Builder> {
    public static final ProtoAdapter<GetSpeakerInfoListResponse> ADAPTER = null;
    private static final long serialVersionUID = 0;
    public final List<LarkSpeakerInfo> mlark_speaker_info_list;
    public final List<SpeakerInfo> mspeaker_info_list;

    public static final class Builder extends Message.Builder<GetSpeakerInfoListResponse, Builder> {
        public List<LarkSpeakerInfo> mlark_speaker_info_list;
        public List<SpeakerInfo> mspeaker_info_list;

        @Override // com.squareup.wire.Message.Builder
        public GetSpeakerInfoListResponse build() {
            return new GetSpeakerInfoListResponse(this.mspeaker_info_list, this.mlark_speaker_info_list, super.buildUnknownFields());
        }

        public Builder() {
            this.mspeaker_info_list = Internal.newMutableList();
            this.mlark_speaker_info_list = Internal.newMutableList();
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder lark_speaker_info_list(List<LarkSpeakerInfo> r100) {
            Internal.checkElementsNotNull(r100);
            this.mlark_speaker_info_list = r100;
            return this;
        }

        public Builder speaker_info_list(List<SpeakerInfo> r100) {
            Internal.checkElementsNotNull(r100);
            this.mspeaker_info_list = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_GetSpeakerInfoListResponse extends ProtoAdapter<GetSpeakerInfoListResponse> {
        public ProtoAdapter_GetSpeakerInfoListResponse() {
            super(FieldEncoding.LENGTH_DELIMITED, GetSpeakerInfoListResponse.class);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public GetSpeakerInfoListResponse decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L12;
            if (r103 != 1) goto L8;
            r101.mspeaker_info_list.add(SpeakerInfo.ADAPTER.decode(r100));
            goto L3
        L8:
            if (r103 != 2) goto L9;
            r101.mlark_speaker_info_list.add(LarkSpeakerInfo.ADAPTER.decode(r100));
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
        public int encodedSize2(GetSpeakerInfoListResponse r100) {
            return (SpeakerInfo.ADAPTER.asRepeated().encodedSizeWithTag(1, r100.mspeaker_info_list) + LarkSpeakerInfo.ADAPTER.asRepeated().encodedSizeWithTag(2, r100.mlark_speaker_info_list)) + r100.unknownFields().size();
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ GetSpeakerInfoListResponse decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(GetSpeakerInfoListResponse r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, GetSpeakerInfoListResponse r101) throws IOException {
            SpeakerInfo.ADAPTER.asRepeated().encodeWithTag(r100, 1, r101.mspeaker_info_list);
            LarkSpeakerInfo.ADAPTER.asRepeated().encodeWithTag(r100, 2, r101.mlark_speaker_info_list);
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, GetSpeakerInfoListResponse r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_GetSpeakerInfoListResponse();
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.mspeaker_info_list = Internal.copyOf("mspeaker_info_list", this.mspeaker_info_list);
        r100.mlark_speaker_info_list = Internal.copyOf("mlark_speaker_info_list", this.mlark_speaker_info_list);
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return GetSpeakerInfoListResponse.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public GetSpeakerInfoListResponse(List<SpeakerInfo> r100, List<LarkSpeakerInfo> r101) {
        this(r100, r101, ByteString.EMPTY);
    }

    public GetSpeakerInfoListResponse(List<SpeakerInfo> r100, List<LarkSpeakerInfo> r101, ByteString r102) {
        super(ADAPTER, r102);
        this.mspeaker_info_list = Internal.immutableCopyOf("mspeaker_info_list", r100);
        this.mlark_speaker_info_list = Internal.immutableCopyOf("mlark_speaker_info_list", r101);
    }
}
