package com.bytedance.lark.pb.space.drive.v1;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import com.squareup.wire.internal.Internal;
import java.io.IOException;
import java.util.List;
import okio.ByteString;
import we6.c;
import we6.d;

/* JADX INFO: loaded from: classes20.dex */
public final class CancelDownloadRequest extends Message<CancelDownloadRequest, Builder> {
    public static final ProtoAdapter<CancelDownloadRequest> ADAPTER = null;
    public static final Boolean DEFAULT_DELETE_FILE = null;
    public static final ProtoAdapter_CancelDownloadRequest RAW_TYPE_ADAPTER = null;
    private static final long serialVersionUID = 0;
    public final Boolean delete_file;
    public final List<String> keys;

    public static final class Builder extends Message.Builder<CancelDownloadRequest, Builder> implements d<CancelDownloadRequest> {
        public Boolean delete_file;
        public List<String> keys;

        @Override // com.squareup.wire.Message.Builder
        public CancelDownloadRequest build() {
            return new CancelDownloadRequest(this.keys, this.delete_file, super.buildUnknownFields());
        }

        public Builder() {
            this.keys = Internal.newMutableList();
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder delete_file(Boolean r100) {
            this.delete_file = r100;
            return this;
        }

        public Builder keys(List<String> r100) {
            Internal.checkElementsNotNull(r100);
            this.keys = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_CancelDownloadRequest extends ProtoAdapter<CancelDownloadRequest> implements c<CancelDownloadRequest> {
        public ProtoAdapter_CancelDownloadRequest() {
            super(FieldEncoding.LENGTH_DELIMITED, CancelDownloadRequest.class);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public CancelDownloadRequest decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            r101.delete_file = Boolean.FALSE;
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L12;
            if (r103 != 1) goto L8;
            r101.keys.add(ProtoAdapter.STRING.decode(r100));
            goto L3
        L8:
            if (r103 != 2) goto L9;
            r101.delete_file = ProtoAdapter.BOOL.decode(r100);
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
        public int encodedSize2(CancelDownloadRequest r100) {
            int r101 = ProtoAdapter.STRING.asRepeated().encodedSizeWithTag(1, r100.keys);
            Boolean r102 = r100.delete_file;
            if (r102 == null) goto L5;
            int r103 = ProtoAdapter.BOOL.encodedSizeWithTag(2, r102);
        L7:
            return (r101 + r103) + r100.unknownFields().size();
        L5:
            r103 = 0;
            goto L7
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ CancelDownloadRequest decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(CancelDownloadRequest r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, CancelDownloadRequest r101) throws IOException {
            ProtoAdapter.STRING.asRepeated().encodeWithTag(r100, 1, r101.keys);
            Boolean r102 = r101.delete_file;
            if (r102 == null) goto L5;
            ProtoAdapter.BOOL.encodeWithTag(r100, 2, r102);
        L5:
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, CancelDownloadRequest r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ProtoAdapter_CancelDownloadRequest r100 = new ProtoAdapter_CancelDownloadRequest();
        RAW_TYPE_ADAPTER = r100;
        ADAPTER = r100;
        DEFAULT_DELETE_FILE = Boolean.FALSE;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.keys = Internal.copyOf("keys", this.keys);
        r100.delete_file = this.delete_file;
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return CancelDownloadRequest.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public CancelDownloadRequest(List<String> r100, Boolean r101) {
        this(r100, r101, ByteString.EMPTY);
    }

    public CancelDownloadRequest(List<String> r100, Boolean r101, ByteString r102) {
        super(ADAPTER, r102);
        this.keys = Internal.immutableCopyOf("keys", r100);
        this.delete_file = r101;
    }
}
