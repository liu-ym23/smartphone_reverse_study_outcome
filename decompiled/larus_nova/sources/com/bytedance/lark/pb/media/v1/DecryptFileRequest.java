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
public final class DecryptFileRequest extends Message<DecryptFileRequest, Builder> {
    public static final ProtoAdapter<DecryptFileRequest> ADAPTER = null;
    public static final String DEFAULT_DST_PATH = "";
    public static final String DEFAULT_SRC_PATH = "";
    public static final ProtoAdapter_DecryptFileRequest RAW_TYPE_ADAPTER = null;
    private static final long serialVersionUID = 0;
    public final String dst_path;
    public final String src_path;

    public static final class Builder extends Message.Builder<DecryptFileRequest, Builder> implements d<DecryptFileRequest> {
        public String dst_path;
        public String src_path;

        @Override // com.squareup.wire.Message.Builder
        public DecryptFileRequest build() {
            String r100 = this.src_path;
            if (r100 == null) goto L9;
            if (this.dst_path == null) goto L9;
            return new DecryptFileRequest(this.src_path, this.dst_path, super.buildUnknownFields());
        L9:
            throw Internal.missingRequiredFields(new Object[]{r100, "src_path", this.dst_path, "dst_path"});
        }

        public Builder() {
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder dst_path(String r100) {
            this.dst_path = r100;
            return this;
        }

        public Builder src_path(String r100) {
            this.src_path = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_DecryptFileRequest extends ProtoAdapter<DecryptFileRequest> implements c<DecryptFileRequest> {
        public ProtoAdapter_DecryptFileRequest() {
            super(FieldEncoding.LENGTH_DELIMITED, DecryptFileRequest.class);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public DecryptFileRequest decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            r101.src_path = "";
            r101.dst_path = "";
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L12;
            if (r103 != 1) goto L8;
            r101.src_path = ProtoAdapter.STRING.decode(r100);
            goto L3
        L8:
            if (r103 != 2) goto L9;
            r101.dst_path = ProtoAdapter.STRING.decode(r100);
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
        public int encodedSize2(DecryptFileRequest r100) {
            ProtoAdapter<String> r101 = ProtoAdapter.STRING;
            return (r101.encodedSizeWithTag(1, r100.src_path) + r101.encodedSizeWithTag(2, r100.dst_path)) + r100.unknownFields().size();
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ DecryptFileRequest decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(DecryptFileRequest r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, DecryptFileRequest r101) throws IOException {
            ProtoAdapter<String> r102 = ProtoAdapter.STRING;
            r102.encodeWithTag(r100, 1, r101.src_path);
            r102.encodeWithTag(r100, 2, r101.dst_path);
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, DecryptFileRequest r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ProtoAdapter_DecryptFileRequest r100 = new ProtoAdapter_DecryptFileRequest();
        RAW_TYPE_ADAPTER = r100;
        ADAPTER = r100;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.src_path = this.src_path;
        r100.dst_path = this.dst_path;
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return DecryptFileRequest.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public DecryptFileRequest(String r100, String r101) {
        this(r100, r101, ByteString.EMPTY);
    }

    public DecryptFileRequest(String r100, String r101, ByteString r102) {
        super(ADAPTER, r102);
        this.src_path = r100;
        this.dst_path = r101;
    }
}
