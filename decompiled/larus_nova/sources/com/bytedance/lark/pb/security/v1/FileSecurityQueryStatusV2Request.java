package com.bytedance.lark.pb.security.v1;

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
public final class FileSecurityQueryStatusV2Request extends Message<FileSecurityQueryStatusV2Request, Builder> {
    public static final ProtoAdapter<FileSecurityQueryStatusV2Request> ADAPTER = null;
    public static final Long DEFAULT_DID = null;
    public static final Long DEFAULT_UID = null;
    public static final ProtoAdapter_FileSecurityQueryStatusV2Request RAW_TYPE_ADAPTER = null;
    private static final long serialVersionUID = 0;
    public final Long did;
    public final Long uid;

    public static final class Builder extends Message.Builder<FileSecurityQueryStatusV2Request, Builder> implements d<FileSecurityQueryStatusV2Request> {
        public Long did;
        public Long uid;

        @Override // com.squareup.wire.Message.Builder
        public FileSecurityQueryStatusV2Request build() {
            return new FileSecurityQueryStatusV2Request(this.did, this.uid, super.buildUnknownFields());
        }

        public Builder() {
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder did(Long r100) {
            this.did = r100;
            return this;
        }

        public Builder uid(Long r100) {
            this.uid = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_FileSecurityQueryStatusV2Request extends ProtoAdapter<FileSecurityQueryStatusV2Request> implements c<FileSecurityQueryStatusV2Request> {
        public ProtoAdapter_FileSecurityQueryStatusV2Request() {
            super(FieldEncoding.LENGTH_DELIMITED, FileSecurityQueryStatusV2Request.class);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public FileSecurityQueryStatusV2Request decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            r101.did = 0L;
            r101.uid = 0L;
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L12;
            if (r103 != 1) goto L8;
            r101.did = ProtoAdapter.INT64.decode(r100);
            goto L3
        L8:
            if (r103 != 2) goto L9;
            r101.uid = ProtoAdapter.INT64.decode(r100);
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
        public int encodedSize2(FileSecurityQueryStatusV2Request r100) {
            Long r101 = r100.did;
            int r102 = 0;
            if (r101 == null) goto L5;
            int r103 = ProtoAdapter.INT64.encodedSizeWithTag(1, r101);
        L6:
            Long r104 = r100.uid;
            if (r104 == null) goto L10;
            r102 = ProtoAdapter.INT64.encodedSizeWithTag(2, r104);
        L10:
            return (r103 + r102) + r100.unknownFields().size();
        L5:
            r103 = 0;
            goto L6
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ FileSecurityQueryStatusV2Request decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(FileSecurityQueryStatusV2Request r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, FileSecurityQueryStatusV2Request r101) throws IOException {
            Long r102 = r101.did;
            if (r102 == null) goto L5;
            ProtoAdapter.INT64.encodeWithTag(r100, 1, r102);
        L5:
            Long r103 = r101.uid;
            if (r103 == null) goto L8;
            ProtoAdapter.INT64.encodeWithTag(r100, 2, r103);
        L8:
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, FileSecurityQueryStatusV2Request r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ProtoAdapter_FileSecurityQueryStatusV2Request r100 = new ProtoAdapter_FileSecurityQueryStatusV2Request();
        RAW_TYPE_ADAPTER = r100;
        ADAPTER = r100;
        DEFAULT_DID = 0L;
        DEFAULT_UID = 0L;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.did = this.did;
        r100.uid = this.uid;
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return FileSecurityQueryStatusV2Request.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public FileSecurityQueryStatusV2Request(Long r100, Long r101) {
        this(r100, r101, ByteString.EMPTY);
    }

    public FileSecurityQueryStatusV2Request(Long r100, Long r101, ByteString r102) {
        super(ADAPTER, r102);
        this.did = r100;
        this.uid = r101;
    }
}
