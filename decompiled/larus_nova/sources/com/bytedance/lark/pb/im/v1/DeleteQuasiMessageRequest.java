package com.bytedance.lark.pb.im.v1;

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
public final class DeleteQuasiMessageRequest extends Message<DeleteQuasiMessageRequest, Builder> {
    public static final ProtoAdapter<DeleteQuasiMessageRequest> ADAPTER = null;
    public static final String DEFAULT_CID = "";
    public static final ProtoAdapter_DeleteQuasiMessageRequest RAW_TYPE_ADAPTER = null;
    private static final long serialVersionUID = 0;
    public final String cid;

    public static final class Builder extends Message.Builder<DeleteQuasiMessageRequest, Builder> implements d<DeleteQuasiMessageRequest> {
        public String cid;

        @Override // com.squareup.wire.Message.Builder
        public DeleteQuasiMessageRequest build() {
            String r100 = this.cid;
            if (r100 == null) goto L7;
            return new DeleteQuasiMessageRequest(this.cid, super.buildUnknownFields());
        L7:
            throw Internal.missingRequiredFields(new Object[]{r100, "cid"});
        }

        public Builder() {
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder cid(String r100) {
            this.cid = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_DeleteQuasiMessageRequest extends ProtoAdapter<DeleteQuasiMessageRequest> implements c<DeleteQuasiMessageRequest> {
        public ProtoAdapter_DeleteQuasiMessageRequest() {
            super(FieldEncoding.LENGTH_DELIMITED, DeleteQuasiMessageRequest.class);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public DeleteQuasiMessageRequest decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            r101.cid = "";
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L9;
            if (r103 != 1) goto L7;
            r101.cid = ProtoAdapter.STRING.decode(r100);
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
        public int encodedSize2(DeleteQuasiMessageRequest r100) {
            return ProtoAdapter.STRING.encodedSizeWithTag(1, r100.cid) + r100.unknownFields().size();
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ DeleteQuasiMessageRequest decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(DeleteQuasiMessageRequest r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, DeleteQuasiMessageRequest r101) throws IOException {
            ProtoAdapter.STRING.encodeWithTag(r100, 1, r101.cid);
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, DeleteQuasiMessageRequest r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ProtoAdapter_DeleteQuasiMessageRequest r100 = new ProtoAdapter_DeleteQuasiMessageRequest();
        RAW_TYPE_ADAPTER = r100;
        ADAPTER = r100;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.cid = this.cid;
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return DeleteQuasiMessageRequest.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public DeleteQuasiMessageRequest(String r100) {
        this(r100, ByteString.EMPTY);
    }

    public DeleteQuasiMessageRequest(String r100, ByteString r101) {
        super(ADAPTER, r101);
        this.cid = r100;
    }
}
