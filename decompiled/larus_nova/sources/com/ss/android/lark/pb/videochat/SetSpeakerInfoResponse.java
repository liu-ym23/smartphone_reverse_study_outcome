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
public final class SetSpeakerInfoResponse extends Message<SetSpeakerInfoResponse, Builder> {
    public static final ProtoAdapter<SetSpeakerInfoResponse> ADAPTER = null;
    public static final Boolean DEFAULT_IS_SET_SUCCESS = null;
    private static final long serialVersionUID = 0;
    public final Boolean mis_set_success;

    public static final class Builder extends Message.Builder<SetSpeakerInfoResponse, Builder> {
        public Boolean mis_set_success;

        @Override // com.squareup.wire.Message.Builder
        public SetSpeakerInfoResponse build() {
            Boolean r100 = this.mis_set_success;
            if (r100 == null) goto L7;
            return new SetSpeakerInfoResponse(this.mis_set_success, super.buildUnknownFields());
        L7:
            throw Internal.missingRequiredFields(new Object[]{r100, "mis_set_success"});
        }

        public Builder() {
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder is_set_success(Boolean r100) {
            this.mis_set_success = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_SetSpeakerInfoResponse extends ProtoAdapter<SetSpeakerInfoResponse> {
        public ProtoAdapter_SetSpeakerInfoResponse() {
            super(FieldEncoding.LENGTH_DELIMITED, SetSpeakerInfoResponse.class);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public SetSpeakerInfoResponse decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            r101.mis_set_success = Boolean.FALSE;
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L9;
            if (r103 != 1) goto L7;
            r101.mis_set_success = ProtoAdapter.BOOL.decode(r100);
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
        public int encodedSize2(SetSpeakerInfoResponse r100) {
            return ProtoAdapter.BOOL.encodedSizeWithTag(1, r100.mis_set_success) + r100.unknownFields().size();
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ SetSpeakerInfoResponse decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(SetSpeakerInfoResponse r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, SetSpeakerInfoResponse r101) throws IOException {
            ProtoAdapter.BOOL.encodeWithTag(r100, 1, r101.mis_set_success);
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, SetSpeakerInfoResponse r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_SetSpeakerInfoResponse();
        DEFAULT_IS_SET_SUCCESS = Boolean.FALSE;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.mis_set_success = this.mis_set_success;
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return SetSpeakerInfoResponse.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public SetSpeakerInfoResponse(Boolean r100) {
        this(r100, ByteString.EMPTY);
    }

    public SetSpeakerInfoResponse(Boolean r100, ByteString r101) {
        super(ADAPTER, r101);
        this.mis_set_success = r100;
    }
}
