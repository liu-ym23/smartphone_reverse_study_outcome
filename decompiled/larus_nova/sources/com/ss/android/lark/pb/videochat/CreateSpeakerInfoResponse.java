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
public final class CreateSpeakerInfoResponse extends Message<CreateSpeakerInfoResponse, Builder> {
    public static final ProtoAdapter<CreateSpeakerInfoResponse> ADAPTER = null;
    public static final Boolean DEFAULT_IS_SPEAKER_NAME_DUPLICATED = null;
    private static final long serialVersionUID = 0;
    public final Boolean mis_speaker_name_duplicated;
    public final SpeakerInfo mspeaker_info;

    public static final class Builder extends Message.Builder<CreateSpeakerInfoResponse, Builder> {
        public Boolean mis_speaker_name_duplicated;
        public SpeakerInfo mspeaker_info;

        @Override // com.squareup.wire.Message.Builder
        public CreateSpeakerInfoResponse build() {
            Boolean r100 = this.mis_speaker_name_duplicated;
            if (r100 == null) goto L7;
            return new CreateSpeakerInfoResponse(this.mis_speaker_name_duplicated, this.mspeaker_info, super.buildUnknownFields());
        L7:
            throw Internal.missingRequiredFields(new Object[]{r100, "mis_speaker_name_duplicated"});
        }

        public Builder() {
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder is_speaker_name_duplicated(Boolean r100) {
            this.mis_speaker_name_duplicated = r100;
            return this;
        }

        public Builder speaker_info(SpeakerInfo r100) {
            this.mspeaker_info = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_CreateSpeakerInfoResponse extends ProtoAdapter<CreateSpeakerInfoResponse> {
        public ProtoAdapter_CreateSpeakerInfoResponse() {
            super(FieldEncoding.LENGTH_DELIMITED, CreateSpeakerInfoResponse.class);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public CreateSpeakerInfoResponse decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            r101.mis_speaker_name_duplicated = Boolean.FALSE;
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L12;
            if (r103 != 1) goto L8;
            r101.mis_speaker_name_duplicated = ProtoAdapter.BOOL.decode(r100);
            goto L3
        L8:
            if (r103 != 2) goto L9;
            r101.mspeaker_info = SpeakerInfo.ADAPTER.decode(r100);
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
        public int encodedSize2(CreateSpeakerInfoResponse r100) {
            int r101 = ProtoAdapter.BOOL.encodedSizeWithTag(1, r100.mis_speaker_name_duplicated);
            SpeakerInfo r102 = r100.mspeaker_info;
            if (r102 == null) goto L5;
            int r103 = SpeakerInfo.ADAPTER.encodedSizeWithTag(2, r102);
        L7:
            return (r101 + r103) + r100.unknownFields().size();
        L5:
            r103 = 0;
            goto L7
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ CreateSpeakerInfoResponse decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(CreateSpeakerInfoResponse r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, CreateSpeakerInfoResponse r101) throws IOException {
            ProtoAdapter.BOOL.encodeWithTag(r100, 1, r101.mis_speaker_name_duplicated);
            SpeakerInfo r102 = r101.mspeaker_info;
            if (r102 == null) goto L5;
            SpeakerInfo.ADAPTER.encodeWithTag(r100, 2, r102);
        L5:
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, CreateSpeakerInfoResponse r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_CreateSpeakerInfoResponse();
        DEFAULT_IS_SPEAKER_NAME_DUPLICATED = Boolean.FALSE;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.mis_speaker_name_duplicated = this.mis_speaker_name_duplicated;
        r100.mspeaker_info = this.mspeaker_info;
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return CreateSpeakerInfoResponse.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public CreateSpeakerInfoResponse(Boolean r100, SpeakerInfo r101) {
        this(r100, r101, ByteString.EMPTY);
    }

    public CreateSpeakerInfoResponse(Boolean r100, SpeakerInfo r101, ByteString r102) {
        super(ADAPTER, r102);
        this.mis_speaker_name_duplicated = r100;
        this.mspeaker_info = r101;
    }
}
