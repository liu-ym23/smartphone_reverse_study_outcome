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
public final class FileSecurityWriteBackRequest extends Message<FileSecurityWriteBackRequest, Builder> {
    public static final ProtoAdapter<FileSecurityWriteBackRequest> ADAPTER = null;
    public static final Long DEFAULT_DEST_FD = null;
    public static final String DEFAULT_STAGE_PATH = "";
    public static final ProtoAdapter_FileSecurityWriteBackRequest RAW_TYPE_ADAPTER = null;
    private static final long serialVersionUID = 0;
    public final Long dest_fd;
    public final String stage_path;

    public static final class Builder extends Message.Builder<FileSecurityWriteBackRequest, Builder> implements b<FileSecurityWriteBackRequest> {
        public Long dest_fd;
        public String stage_path;

        @Override // com.squareup.wire.Message.Builder
        public FileSecurityWriteBackRequest build() {
            String r100 = this.stage_path;
            if (r100 == null) goto L7;
            return new FileSecurityWriteBackRequest(this.stage_path, this.dest_fd, super.buildUnknownFields());
        L7:
            throw Internal.missingRequiredFields(new Object[]{r100, "stage_path"});
        }

        public Builder() {
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder dest_fd(Long r100) {
            this.dest_fd = r100;
            return this;
        }

        public Builder stage_path(String r100) {
            this.stage_path = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_FileSecurityWriteBackRequest extends ProtoAdapter<FileSecurityWriteBackRequest> implements a<FileSecurityWriteBackRequest> {
        public ProtoAdapter_FileSecurityWriteBackRequest() {
            super(FieldEncoding.LENGTH_DELIMITED, FileSecurityWriteBackRequest.class);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public FileSecurityWriteBackRequest decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            r101.stage_path = "";
            r101.dest_fd = 0L;
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L12;
            if (r103 != 1) goto L8;
            r101.stage_path = ProtoAdapter.STRING.decode(r100);
            goto L3
        L8:
            if (r103 != 2) goto L9;
            r101.dest_fd = ProtoAdapter.INT64.decode(r100);
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
        public int encodedSize2(FileSecurityWriteBackRequest r100) {
            int r101 = ProtoAdapter.STRING.encodedSizeWithTag(1, r100.stage_path);
            Long r102 = r100.dest_fd;
            if (r102 == null) goto L5;
            int r103 = ProtoAdapter.INT64.encodedSizeWithTag(2, r102);
        L7:
            return (r101 + r103) + r100.unknownFields().size();
        L5:
            r103 = 0;
            goto L7
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ FileSecurityWriteBackRequest decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(FileSecurityWriteBackRequest r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, FileSecurityWriteBackRequest r101) throws IOException {
            ProtoAdapter.STRING.encodeWithTag(r100, 1, r101.stage_path);
            Long r102 = r101.dest_fd;
            if (r102 == null) goto L5;
            ProtoAdapter.INT64.encodeWithTag(r100, 2, r102);
        L5:
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, FileSecurityWriteBackRequest r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ProtoAdapter_FileSecurityWriteBackRequest r100 = new ProtoAdapter_FileSecurityWriteBackRequest();
        RAW_TYPE_ADAPTER = r100;
        ADAPTER = r100;
        DEFAULT_DEST_FD = 0L;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.stage_path = this.stage_path;
        r100.dest_fd = this.dest_fd;
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return FileSecurityWriteBackRequest.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public FileSecurityWriteBackRequest(String r100, Long r101) {
        this(r100, r101, ByteString.EMPTY);
    }

    public FileSecurityWriteBackRequest(String r100, Long r101, ByteString r102) {
        super(ADAPTER, r102);
        this.stage_path = r100;
        this.dest_fd = r101;
    }
}
