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
public final class FileSecurityEncryptV2Response extends Message<FileSecurityEncryptV2Response, Builder> {
    public static final ProtoAdapter<FileSecurityEncryptV2Response> ADAPTER = null;
    public static final String DEFAULT_ENCRYPTED_FILE_PATH = "";
    public static final Integer DEFAULT_ERROR = null;
    public static final String DEFAULT_STAGE_PATH = "";
    public static final ProtoAdapter_FileSecurityEncryptV2Response RAW_TYPE_ADAPTER = null;
    private static final long serialVersionUID = 0;
    public final String encrypted_file_path;
    public final Integer error;
    public final String stage_path;

    public static final class Builder extends Message.Builder<FileSecurityEncryptV2Response, Builder> implements d<FileSecurityEncryptV2Response> {
        public String encrypted_file_path;
        public Integer error;
        public String stage_path;

        @Override // com.squareup.wire.Message.Builder
        public FileSecurityEncryptV2Response build() {
            String r100 = this.encrypted_file_path;
            if (r100 == null) goto L9;
            if (this.error == null) goto L9;
            return new FileSecurityEncryptV2Response(this.encrypted_file_path, this.error, this.stage_path, super.buildUnknownFields());
        L9:
            throw Internal.missingRequiredFields(new Object[]{r100, "encrypted_file_path", this.error, "error"});
        }

        public Builder() {
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder encrypted_file_path(String r100) {
            this.encrypted_file_path = r100;
            return this;
        }

        public Builder error(Integer r100) {
            this.error = r100;
            return this;
        }

        public Builder stage_path(String r100) {
            this.stage_path = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_FileSecurityEncryptV2Response extends ProtoAdapter<FileSecurityEncryptV2Response> implements c<FileSecurityEncryptV2Response> {
        public ProtoAdapter_FileSecurityEncryptV2Response() {
            super(FieldEncoding.LENGTH_DELIMITED, FileSecurityEncryptV2Response.class);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public FileSecurityEncryptV2Response decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            r101.encrypted_file_path = "";
            r101.error = 0;
            r101.stage_path = "";
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L15;
            if (r103 != 1) goto L8;
            r101.encrypted_file_path = ProtoAdapter.STRING.decode(r100);
            goto L3
        L8:
            if (r103 != 2) goto L10;
            r101.error = ProtoAdapter.INT32.decode(r100);
            goto L3
        L10:
            if (r103 != 3) goto L11;
            r101.stage_path = ProtoAdapter.STRING.decode(r100);
            goto L3
        L11:
            FieldEncoding r104 = r100.peekFieldEncoding();
            r101.addUnknownField(r103, r104, r104.rawProtoAdapter().decode(r100));
            goto L3
        L15:
            r100.endMessage(r102);
            return r101.build();
        }

        /* JADX INFO: renamed from: encodedSize, reason: avoid collision after fix types in other method */
        public int encodedSize2(FileSecurityEncryptV2Response r100) {
            ProtoAdapter<String> r101 = ProtoAdapter.STRING;
            int r102 = r101.encodedSizeWithTag(1, r100.encrypted_file_path) + ProtoAdapter.INT32.encodedSizeWithTag(2, r100.error);
            String r103 = r100.stage_path;
            if (r103 == null) goto L5;
            int r104 = r101.encodedSizeWithTag(3, r103);
        L7:
            return (r102 + r104) + r100.unknownFields().size();
        L5:
            r104 = 0;
            goto L7
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ FileSecurityEncryptV2Response decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(FileSecurityEncryptV2Response r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, FileSecurityEncryptV2Response r101) throws IOException {
            ProtoAdapter<String> r102 = ProtoAdapter.STRING;
            r102.encodeWithTag(r100, 1, r101.encrypted_file_path);
            ProtoAdapter.INT32.encodeWithTag(r100, 2, r101.error);
            String r103 = r101.stage_path;
            if (r103 == null) goto L5;
            r102.encodeWithTag(r100, 3, r103);
        L5:
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, FileSecurityEncryptV2Response r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ProtoAdapter_FileSecurityEncryptV2Response r100 = new ProtoAdapter_FileSecurityEncryptV2Response();
        RAW_TYPE_ADAPTER = r100;
        ADAPTER = r100;
        DEFAULT_ERROR = 0;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.encrypted_file_path = this.encrypted_file_path;
        r100.error = this.error;
        r100.stage_path = this.stage_path;
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return FileSecurityEncryptV2Response.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public FileSecurityEncryptV2Response(String r100, Integer r101, String r102) {
        this(r100, r101, r102, ByteString.EMPTY);
    }

    public FileSecurityEncryptV2Response(String r100, Integer r101, String r102, ByteString r103) {
        super(ADAPTER, r103);
        this.encrypted_file_path = r100;
        this.error = r101;
        this.stage_path = r102;
    }
}
