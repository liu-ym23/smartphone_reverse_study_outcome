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
public final class DeleteDraftRequest extends Message<DeleteDraftRequest, Builder> {
    public static final ProtoAdapter<DeleteDraftRequest> ADAPTER = null;
    public static final String DEFAULT_DRAFT_ID = "";
    public static final ProtoAdapter_DeleteDraftRequest RAW_TYPE_ADAPTER = null;
    private static final long serialVersionUID = 0;
    public final String draft_id;

    public static final class Builder extends Message.Builder<DeleteDraftRequest, Builder> implements d<DeleteDraftRequest> {
        public String draft_id;

        @Override // com.squareup.wire.Message.Builder
        public DeleteDraftRequest build() {
            String r100 = this.draft_id;
            if (r100 == null) goto L7;
            return new DeleteDraftRequest(this.draft_id, super.buildUnknownFields());
        L7:
            throw Internal.missingRequiredFields(new Object[]{r100, "draft_id"});
        }

        public Builder() {
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder draft_id(String r100) {
            this.draft_id = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_DeleteDraftRequest extends ProtoAdapter<DeleteDraftRequest> implements c<DeleteDraftRequest> {
        public ProtoAdapter_DeleteDraftRequest() {
            super(FieldEncoding.LENGTH_DELIMITED, DeleteDraftRequest.class);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public DeleteDraftRequest decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            r101.draft_id = "";
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L9;
            if (r103 != 1) goto L7;
            r101.draft_id = ProtoAdapter.STRING.decode(r100);
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
        public int encodedSize2(DeleteDraftRequest r100) {
            return ProtoAdapter.STRING.encodedSizeWithTag(1, r100.draft_id) + r100.unknownFields().size();
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ DeleteDraftRequest decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(DeleteDraftRequest r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, DeleteDraftRequest r101) throws IOException {
            ProtoAdapter.STRING.encodeWithTag(r100, 1, r101.draft_id);
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, DeleteDraftRequest r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ProtoAdapter_DeleteDraftRequest r100 = new ProtoAdapter_DeleteDraftRequest();
        RAW_TYPE_ADAPTER = r100;
        ADAPTER = r100;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.draft_id = this.draft_id;
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return DeleteDraftRequest.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public DeleteDraftRequest(String r100) {
        this(r100, ByteString.EMPTY);
    }

    public DeleteDraftRequest(String r100, ByteString r101) {
        super(ADAPTER, r101);
        this.draft_id = r100;
    }
}
