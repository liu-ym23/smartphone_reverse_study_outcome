package com.bytedance.lark.pb.security.v1;

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
public final class FileSecurityWriteBackV2Response extends Message<FileSecurityWriteBackV2Response, Builder> {
    public static final ProtoAdapter<FileSecurityWriteBackV2Response> ADAPTER = null;
    public static final String DEFAULT_ENCRYPTED_PATH = "";
    public static final Integer DEFAULT_ERROR = null;
    public static final ProtoAdapter_FileSecurityWriteBackV2Response RAW_TYPE_ADAPTER = null;
    private static final long serialVersionUID = 0;
    public final String encrypted_path;
    public final Integer error;

    public static final class Builder extends Message.Builder<FileSecurityWriteBackV2Response, Builder> implements d<FileSecurityWriteBackV2Response> {
        public String encrypted_path;
        public Integer error;

        @Override // com.squareup.wire.Message.Builder
        public FileSecurityWriteBackV2Response build() {
            String r100 = this.encrypted_path;
            if (r100 == null) goto L9;
            if (this.error == null) goto L9;
            return new FileSecurityWriteBackV2Response(this.encrypted_path, this.error, super.buildUnknownFields());
        L9:
            throw Internal.missingRequiredFields(new Object[]{r100, "encrypted_path", this.error, "error"});
        }

        public Builder() {
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder encrypted_path(String r100) {
            this.encrypted_path = r100;
            return this;
        }

        public Builder error(Integer r100) {
            this.error = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_FileSecurityWriteBackV2Response extends ProtoAdapter<FileSecurityWriteBackV2Response> implements c<FileSecurityWriteBackV2Response> {
        public ProtoAdapter_FileSecurityWriteBackV2Response() {
            super(FieldEncoding.LENGTH_DELIMITED, FileSecurityWriteBackV2Response.class);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public FileSecurityWriteBackV2Response decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            r101.encrypted_path = "";
            r101.error = 0;
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L12;
            if (r103 != 1) goto L8;
            r101.encrypted_path = ProtoAdapter.STRING.decode(r100);
            goto L3
        L8:
            if (r103 != 2) goto L9;
            r101.error = ProtoAdapter.INT32.decode(r100);
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
        public int encodedSize2(FileSecurityWriteBackV2Response r100) {
            return (ProtoAdapter.STRING.encodedSizeWithTag(1, r100.encrypted_path) + ProtoAdapter.INT32.encodedSizeWithTag(2, r100.error)) + r100.unknownFields().size();
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ FileSecurityWriteBackV2Response decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(FileSecurityWriteBackV2Response r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, FileSecurityWriteBackV2Response r101) throws IOException {
            ProtoAdapter.STRING.encodeWithTag(r100, 1, r101.encrypted_path);
            ProtoAdapter.INT32.encodeWithTag(r100, 2, r101.error);
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, FileSecurityWriteBackV2Response r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ProtoAdapter_FileSecurityWriteBackV2Response r100 = new ProtoAdapter_FileSecurityWriteBackV2Response();
        RAW_TYPE_ADAPTER = r100;
        ADAPTER = r100;
        DEFAULT_ERROR = 0;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.encrypted_path = this.encrypted_path;
        r100.error = this.error;
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return FileSecurityWriteBackV2Response.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public FileSecurityWriteBackV2Response(String r100, Integer r101) {
        this(r100, r101, ByteString.EMPTY);
    }

    public FileSecurityWriteBackV2Response(String r100, Integer r101, ByteString r102) {
        super(ADAPTER, r102);
        this.encrypted_path = r100;
        this.error = r101;
    }
}
