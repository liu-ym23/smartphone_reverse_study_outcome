package com.bytedance.lark.pb.media.v1;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import java.io.IOException;
import okio.ByteString;
import we6.c;
import we6.d;

/* JADX INFO: loaded from: classes20.dex */
public final class SaveToSpaceStoreResponse extends Message<SaveToSpaceStoreResponse, Builder> {
    public static final ProtoAdapter<SaveToSpaceStoreResponse> ADAPTER = null;
    public static final String DEFAULT_FILE_TOKEN = "";
    public static final ProtoAdapter_SaveToSpaceStoreResponse RAW_TYPE_ADAPTER = null;
    private static final long serialVersionUID = 0;
    public final String file_token;

    public static final class Builder extends Message.Builder<SaveToSpaceStoreResponse, Builder> implements d<SaveToSpaceStoreResponse> {
        public String file_token;

        @Override // com.squareup.wire.Message.Builder
        public SaveToSpaceStoreResponse build() {
            return new SaveToSpaceStoreResponse(this.file_token, super.buildUnknownFields());
        }

        public Builder() {
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder file_token(String r100) {
            this.file_token = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_SaveToSpaceStoreResponse extends ProtoAdapter<SaveToSpaceStoreResponse> implements c<SaveToSpaceStoreResponse> {
        public ProtoAdapter_SaveToSpaceStoreResponse() {
            super(FieldEncoding.LENGTH_DELIMITED, SaveToSpaceStoreResponse.class);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public SaveToSpaceStoreResponse decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            r101.file_token = "";
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L9;
            if (r103 != 1) goto L7;
            r101.file_token = ProtoAdapter.STRING.decode(r100);
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
        public int encodedSize2(SaveToSpaceStoreResponse r100) {
            String r101 = r100.file_token;
            if (r101 == null) goto L5;
            int r102 = ProtoAdapter.STRING.encodedSizeWithTag(1, r101);
        L7:
            return r102 + r100.unknownFields().size();
        L5:
            r102 = 0;
            goto L7
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ SaveToSpaceStoreResponse decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(SaveToSpaceStoreResponse r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, SaveToSpaceStoreResponse r101) throws IOException {
            String r102 = r101.file_token;
            if (r102 == null) goto L5;
            ProtoAdapter.STRING.encodeWithTag(r100, 1, r102);
        L5:
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, SaveToSpaceStoreResponse r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ProtoAdapter_SaveToSpaceStoreResponse r100 = new ProtoAdapter_SaveToSpaceStoreResponse();
        RAW_TYPE_ADAPTER = r100;
        ADAPTER = r100;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.file_token = this.file_token;
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return SaveToSpaceStoreResponse.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public SaveToSpaceStoreResponse(String r100) {
        this(r100, ByteString.EMPTY);
    }

    public SaveToSpaceStoreResponse(String r100, ByteString r101) {
        super(ADAPTER, r101);
        this.file_token = r100;
    }
}
