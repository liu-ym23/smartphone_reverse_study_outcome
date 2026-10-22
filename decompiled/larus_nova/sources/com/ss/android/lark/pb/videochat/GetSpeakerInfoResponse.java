package com.ss.android.lark.pb.videochat;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import com.squareup.wire.internal.Internal;
import java.io.IOException;
import java.util.Map;
import okio.ByteString;

/* JADX INFO: loaded from: classes37.dex */
public final class GetSpeakerInfoResponse extends Message<GetSpeakerInfoResponse, Builder> {
    public static final ProtoAdapter<GetSpeakerInfoResponse> ADAPTER = null;
    private static final long serialVersionUID = 0;
    public final Map<String, LarkSpeakerInfo> mlark_speaker_info_map;
    public final Map<String, SpeakerInfo> mspeaker_info_map;

    public static final class Builder extends Message.Builder<GetSpeakerInfoResponse, Builder> {
        public Map<String, LarkSpeakerInfo> mlark_speaker_info_map;
        public Map<String, SpeakerInfo> mspeaker_info_map;

        @Override // com.squareup.wire.Message.Builder
        public GetSpeakerInfoResponse build() {
            return new GetSpeakerInfoResponse(this.mspeaker_info_map, this.mlark_speaker_info_map, super.buildUnknownFields());
        }

        public Builder() {
            this.mspeaker_info_map = Internal.newMutableMap();
            this.mlark_speaker_info_map = Internal.newMutableMap();
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder lark_speaker_info_map(Map<String, LarkSpeakerInfo> r100) {
            Internal.checkElementsNotNull(r100);
            this.mlark_speaker_info_map = r100;
            return this;
        }

        public Builder speaker_info_map(Map<String, SpeakerInfo> r100) {
            Internal.checkElementsNotNull(r100);
            this.mspeaker_info_map = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_GetSpeakerInfoResponse extends ProtoAdapter<GetSpeakerInfoResponse> {
        private final ProtoAdapter<Map<String, LarkSpeakerInfo>> mlark_speaker_info_map;
        private final ProtoAdapter<Map<String, SpeakerInfo>> mspeaker_info_map;

        public ProtoAdapter_GetSpeakerInfoResponse() {
            super(FieldEncoding.LENGTH_DELIMITED, GetSpeakerInfoResponse.class);
            ProtoAdapter<String> r100 = ProtoAdapter.STRING;
            this.mspeaker_info_map = ProtoAdapter.newMapAdapter(r100, SpeakerInfo.ADAPTER);
            this.mlark_speaker_info_map = ProtoAdapter.newMapAdapter(r100, LarkSpeakerInfo.ADAPTER);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public GetSpeakerInfoResponse decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L12;
            if (r103 != 1) goto L8;
            r101.mspeaker_info_map.putAll(this.mspeaker_info_map.decode(r100));
            goto L3
        L8:
            if (r103 != 2) goto L9;
            r101.mlark_speaker_info_map.putAll(this.mlark_speaker_info_map.decode(r100));
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
        public int encodedSize2(GetSpeakerInfoResponse r100) {
            return (this.mspeaker_info_map.encodedSizeWithTag(1, r100.mspeaker_info_map) + this.mlark_speaker_info_map.encodedSizeWithTag(2, r100.mlark_speaker_info_map)) + r100.unknownFields().size();
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ GetSpeakerInfoResponse decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(GetSpeakerInfoResponse r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, GetSpeakerInfoResponse r101) throws IOException {
            this.mspeaker_info_map.encodeWithTag(r100, 1, r101.mspeaker_info_map);
            this.mlark_speaker_info_map.encodeWithTag(r100, 2, r101.mlark_speaker_info_map);
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, GetSpeakerInfoResponse r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_GetSpeakerInfoResponse();
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.mspeaker_info_map = Internal.copyOf("mspeaker_info_map", this.mspeaker_info_map);
        r100.mlark_speaker_info_map = Internal.copyOf("mlark_speaker_info_map", this.mlark_speaker_info_map);
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return GetSpeakerInfoResponse.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public GetSpeakerInfoResponse(Map<String, SpeakerInfo> r100, Map<String, LarkSpeakerInfo> r101) {
        this(r100, r101, ByteString.EMPTY);
    }

    public GetSpeakerInfoResponse(Map<String, SpeakerInfo> r100, Map<String, LarkSpeakerInfo> r101, ByteString r102) {
        super(ADAPTER, r102);
        this.mspeaker_info_map = Internal.immutableCopyOf("mspeaker_info_map", r100);
        this.mlark_speaker_info_map = Internal.immutableCopyOf("mlark_speaker_info_map", r101);
    }
}
