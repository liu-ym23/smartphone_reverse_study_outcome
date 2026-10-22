package com.bytedance.lark.pb.space.drive.v1;

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
public final class DownloadResponse extends Message<DownloadResponse, Builder> {
    public static final ProtoAdapter<DownloadResponse> ADAPTER = null;
    public static final String DEFAULT_KEY = "";
    public static final ProtoAdapter_DownloadResponse RAW_TYPE_ADAPTER = null;
    private static final long serialVersionUID = 0;
    public final String key;

    public static final class Builder extends Message.Builder<DownloadResponse, Builder> implements d<DownloadResponse> {
        public String key;

        @Override // com.squareup.wire.Message.Builder
        public DownloadResponse build() {
            String r100 = this.key;
            if (r100 == null) goto L7;
            return new DownloadResponse(this.key, super.buildUnknownFields());
        L7:
            throw Internal.missingRequiredFields(new Object[]{r100, "key"});
        }

        public Builder() {
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder key(String r100) {
            this.key = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_DownloadResponse extends ProtoAdapter<DownloadResponse> implements c<DownloadResponse> {
        public ProtoAdapter_DownloadResponse() {
            super(FieldEncoding.LENGTH_DELIMITED, DownloadResponse.class);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public DownloadResponse decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            r101.key = "";
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L9;
            if (r103 != 1) goto L7;
            r101.key = ProtoAdapter.STRING.decode(r100);
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
        public int encodedSize2(DownloadResponse r100) {
            return ProtoAdapter.STRING.encodedSizeWithTag(1, r100.key) + r100.unknownFields().size();
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ DownloadResponse decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(DownloadResponse r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, DownloadResponse r101) throws IOException {
            ProtoAdapter.STRING.encodeWithTag(r100, 1, r101.key);
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, DownloadResponse r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ProtoAdapter_DownloadResponse r100 = new ProtoAdapter_DownloadResponse();
        RAW_TYPE_ADAPTER = r100;
        ADAPTER = r100;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.key = this.key;
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return DownloadResponse.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public DownloadResponse(String r100) {
        this(r100, ByteString.EMPTY);
    }

    public DownloadResponse(String r100, ByteString r101) {
        super(ADAPTER, r101);
        this.key = r100;
    }
}
