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
public final class ExtractPackageRequest extends Message<ExtractPackageRequest, Builder> {
    public static final ProtoAdapter<ExtractPackageRequest> ADAPTER = null;
    public static final ProtoAdapter_ExtractPackageRequest RAW_TYPE_ADAPTER = null;
    private static final long serialVersionUID = 0;
    public final BrowseFolderRequest request;

    public static final class Builder extends Message.Builder<ExtractPackageRequest, Builder> implements d<ExtractPackageRequest> {
        public BrowseFolderRequest request;

        @Override // com.squareup.wire.Message.Builder
        public ExtractPackageRequest build() {
            return new ExtractPackageRequest(this.request, super.buildUnknownFields());
        }

        public Builder() {
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder request(BrowseFolderRequest r100) {
            this.request = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_ExtractPackageRequest extends ProtoAdapter<ExtractPackageRequest> implements c<ExtractPackageRequest> {
        public ProtoAdapter_ExtractPackageRequest() {
            super(FieldEncoding.LENGTH_DELIMITED, ExtractPackageRequest.class);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public ExtractPackageRequest decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L9;
            if (r103 != 1) goto L7;
            r101.request = BrowseFolderRequest.ADAPTER.decode(r100);
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
        public int encodedSize2(ExtractPackageRequest r100) {
            BrowseFolderRequest r101 = r100.request;
            if (r101 == null) goto L5;
            int r102 = BrowseFolderRequest.ADAPTER.encodedSizeWithTag(1, r101);
        L7:
            return r102 + r100.unknownFields().size();
        L5:
            r102 = 0;
            goto L7
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ ExtractPackageRequest decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(ExtractPackageRequest r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, ExtractPackageRequest r101) throws IOException {
            BrowseFolderRequest r102 = r101.request;
            if (r102 == null) goto L5;
            BrowseFolderRequest.ADAPTER.encodeWithTag(r100, 1, r102);
        L5:
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, ExtractPackageRequest r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ProtoAdapter_ExtractPackageRequest r100 = new ProtoAdapter_ExtractPackageRequest();
        RAW_TYPE_ADAPTER = r100;
        ADAPTER = r100;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.request = this.request;
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return ExtractPackageRequest.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public ExtractPackageRequest(BrowseFolderRequest r100) {
        this(r100, ByteString.EMPTY);
    }

    public ExtractPackageRequest(BrowseFolderRequest r100, ByteString r101) {
        super(ADAPTER, r101);
        this.request = r100;
    }
}
