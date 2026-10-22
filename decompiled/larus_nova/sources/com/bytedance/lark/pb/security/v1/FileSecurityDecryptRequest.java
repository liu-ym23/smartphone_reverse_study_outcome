package com.bytedance.lark.pb.security.v1;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import com.squareup.wire.internal.Internal;
import java.io.IOException;
import okio.ByteString;
import we6.a;
import we6.b;

/* JADX INFO: loaded from: classes20.dex */
public final class FileSecurityDecryptRequest extends Message<FileSecurityDecryptRequest, Builder> {
    public static final ProtoAdapter<FileSecurityDecryptRequest> ADAPTER = null;
    public static final Long DEFAULT_FD = null;
    public static final String DEFAULT_FILE_PATH = "";
    public static final ProtoAdapter_FileSecurityDecryptRequest RAW_TYPE_ADAPTER = null;
    private static final long serialVersionUID = 0;

    /* JADX INFO: renamed from: fd, reason: collision with root package name */
    public final Long f253757fd;
    public final String file_path;

    public static final class Builder extends Message.Builder<FileSecurityDecryptRequest, Builder> implements b<FileSecurityDecryptRequest> {

        /* JADX INFO: renamed from: fd, reason: collision with root package name */
        public Long f253758fd;
        public String file_path;

        @Override // com.squareup.wire.Message.Builder
        public FileSecurityDecryptRequest build() {
            String r100 = this.file_path;
            if (r100 == null) goto L7;
            return new FileSecurityDecryptRequest(this.file_path, this.f253758fd, super.buildUnknownFields());
        L7:
            throw Internal.missingRequiredFields(new Object[]{r100, "file_path"});
        }

        public Builder() {
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder fd(Long r100) {
            this.f253758fd = r100;
            return this;
        }

        public Builder file_path(String r100) {
            this.file_path = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_FileSecurityDecryptRequest extends ProtoAdapter<FileSecurityDecryptRequest> implements a<FileSecurityDecryptRequest> {
        public ProtoAdapter_FileSecurityDecryptRequest() {
            super(FieldEncoding.LENGTH_DELIMITED, FileSecurityDecryptRequest.class);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public FileSecurityDecryptRequest decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            r101.file_path = "";
            r101.f253758fd = 0L;
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L12;
            if (r103 != 1) goto L8;
            r101.file_path = ProtoAdapter.STRING.decode(r100);
            goto L3
        L8:
            if (r103 != 2) goto L9;
            r101.f253758fd = ProtoAdapter.INT64.decode(r100);
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
        public int encodedSize2(FileSecurityDecryptRequest r100) {
            int r101 = ProtoAdapter.STRING.encodedSizeWithTag(1, r100.file_path);
            Long r102 = r100.f253757fd;
            if (r102 == null) goto L5;
            int r103 = ProtoAdapter.INT64.encodedSizeWithTag(2, r102);
        L7:
            return (r101 + r103) + r100.unknownFields().size();
        L5:
            r103 = 0;
            goto L7
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ FileSecurityDecryptRequest decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(FileSecurityDecryptRequest r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, FileSecurityDecryptRequest r101) throws IOException {
            ProtoAdapter.STRING.encodeWithTag(r100, 1, r101.file_path);
            Long r102 = r101.f253757fd;
            if (r102 == null) goto L5;
            ProtoAdapter.INT64.encodeWithTag(r100, 2, r102);
        L5:
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, FileSecurityDecryptRequest r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ProtoAdapter_FileSecurityDecryptRequest r100 = new ProtoAdapter_FileSecurityDecryptRequest();
        RAW_TYPE_ADAPTER = r100;
        ADAPTER = r100;
        DEFAULT_FD = 0L;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.file_path = this.file_path;
        r100.f253758fd = this.f253757fd;
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return FileSecurityDecryptRequest.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public FileSecurityDecryptRequest(String r100, Long r101) {
        this(r100, r101, ByteString.EMPTY);
    }

    public FileSecurityDecryptRequest(String r100, Long r101, ByteString r102) {
        super(ADAPTER, r102);
        this.file_path = r100;
        this.f253757fd = r101;
    }
}
