package com.bytedance.lark.pb.media.v1;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import com.squareup.wire.internal.Internal;
import java.io.IOException;
import okio.ByteString;
import we6.c;
import we6.d;

/* JADX INFO: loaded from: classes20.dex */
public final class AbortUploadAudioRequest extends Message<AbortUploadAudioRequest, Builder> {
    public static final ProtoAdapter<AbortUploadAudioRequest> ADAPTER = null;
    public static final String DEFAULT_SOURCE_ID = "";
    public static final ProtoAdapter_AbortUploadAudioRequest RAW_TYPE_ADAPTER = null;
    private static final long serialVersionUID = 0;
    public final String source_id;

    public static final class Builder extends Message.Builder<AbortUploadAudioRequest, Builder> implements d<AbortUploadAudioRequest> {
        public String source_id;

        @Override // com.squareup.wire.Message.Builder
        public AbortUploadAudioRequest build() {
            String r100 = this.source_id;
            if (r100 == null) goto L7;
            return new AbortUploadAudioRequest(this.source_id, super.buildUnknownFields());
        L7:
            throw Internal.missingRequiredFields(new Object[]{r100, "source_id"});
        }

        public Builder() {
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder source_id(String r100) {
            this.source_id = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_AbortUploadAudioRequest extends ProtoAdapter<AbortUploadAudioRequest> implements c<AbortUploadAudioRequest> {
        public ProtoAdapter_AbortUploadAudioRequest() {
            super(FieldEncoding.LENGTH_DELIMITED, AbortUploadAudioRequest.class);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public AbortUploadAudioRequest decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            r101.source_id = "";
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L9;
            if (r103 != 1) goto L7;
            r101.source_id = ProtoAdapter.STRING.decode(r100);
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
        public int encodedSize2(AbortUploadAudioRequest r100) {
            return ProtoAdapter.STRING.encodedSizeWithTag(1, r100.source_id) + r100.unknownFields().size();
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ AbortUploadAudioRequest decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(AbortUploadAudioRequest r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, AbortUploadAudioRequest r101) throws IOException {
            ProtoAdapter.STRING.encodeWithTag(r100, 1, r101.source_id);
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, AbortUploadAudioRequest r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ProtoAdapter_AbortUploadAudioRequest r100 = new ProtoAdapter_AbortUploadAudioRequest();
        RAW_TYPE_ADAPTER = r100;
        ADAPTER = r100;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.source_id = this.source_id;
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return AbortUploadAudioRequest.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public AbortUploadAudioRequest(String r100) {
        this(r100, ByteString.EMPTY);
    }

    public AbortUploadAudioRequest(String r100, ByteString r101) {
        super(ADAPTER, r101);
        this.source_id = r100;
    }
}
