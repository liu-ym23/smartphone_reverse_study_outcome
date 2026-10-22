package com.ss.android.lark.pb.usearch;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import java.io.IOException;
import okio.ByteString;

/* JADX INFO: loaded from: classes37.dex */
public final class DeleteDoubaoSearchQueryHistoryRequest extends Message<DeleteDoubaoSearchQueryHistoryRequest, Builder> {
    public static final ProtoAdapter<DeleteDoubaoSearchQueryHistoryRequest> ADAPTER = null;
    private static final long serialVersionUID = 0;
    public final ClientType mclient_type;
    public final DoubaoSearchQueryMeta mquery_meta;
    public final DoubaoSearchSceneMeta mscene_meta;

    public static final class Builder extends Message.Builder<DeleteDoubaoSearchQueryHistoryRequest, Builder> {
        public ClientType mclient_type;
        public DoubaoSearchQueryMeta mquery_meta;
        public DoubaoSearchSceneMeta mscene_meta;

        @Override // com.squareup.wire.Message.Builder
        public DeleteDoubaoSearchQueryHistoryRequest build() {
            return new DeleteDoubaoSearchQueryHistoryRequest(this.mscene_meta, this.mclient_type, this.mquery_meta, super.buildUnknownFields());
        }

        public Builder() {
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder client_type(ClientType r100) {
            this.mclient_type = r100;
            return this;
        }

        public Builder query_meta(DoubaoSearchQueryMeta r100) {
            this.mquery_meta = r100;
            return this;
        }

        public Builder scene_meta(DoubaoSearchSceneMeta r100) {
            this.mscene_meta = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_DeleteDoubaoSearchQueryHistoryRequest extends ProtoAdapter<DeleteDoubaoSearchQueryHistoryRequest> {
        public ProtoAdapter_DeleteDoubaoSearchQueryHistoryRequest() {
            super(FieldEncoding.LENGTH_DELIMITED, DeleteDoubaoSearchQueryHistoryRequest.class);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public DeleteDoubaoSearchQueryHistoryRequest decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L18;
            if (r103 != 1) goto L8;
            r101.mscene_meta = DoubaoSearchSceneMeta.ADAPTER.decode(r100);
            goto L3
        L8:
            if (r103 != 2) goto L10;
            r101.mclient_type = ClientType.ADAPTER.decode(r100);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L15
        L15:
            e = move-exception;
            r101.addUnknownField(r103, FieldEncoding.VARINT, Long.valueOf(e.value));
            goto L3
        L10:
            if (r103 != 3) goto L11;
            r101.mquery_meta = DoubaoSearchQueryMeta.ADAPTER.decode(r100);
            goto L3
        L11:
            FieldEncoding r104 = r100.peekFieldEncoding();
            r101.addUnknownField(r103, r104, r104.rawProtoAdapter().decode(r100));
            goto L3
        L18:
            r100.endMessage(r102);
            return r101.build();
        }

        /* JADX INFO: renamed from: encodedSize, reason: avoid collision after fix types in other method */
        public int encodedSize2(DeleteDoubaoSearchQueryHistoryRequest r100) {
            DoubaoSearchSceneMeta r101 = r100.mscene_meta;
            int r102 = 0;
            if (r101 == null) goto L5;
            int r103 = DoubaoSearchSceneMeta.ADAPTER.encodedSizeWithTag(1, r101);
        L6:
            ClientType r104 = r100.mclient_type;
            if (r104 == null) goto L9;
            int r105 = ClientType.ADAPTER.encodedSizeWithTag(2, r104);
        L10:
            int r106 = r103 + r105;
            DoubaoSearchQueryMeta r107 = r100.mquery_meta;
            if (r107 == null) goto L14;
            r102 = DoubaoSearchQueryMeta.ADAPTER.encodedSizeWithTag(3, r107);
        L14:
            return (r106 + r102) + r100.unknownFields().size();
        L9:
            r105 = 0;
            goto L10
        L5:
            r103 = 0;
            goto L6
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ DeleteDoubaoSearchQueryHistoryRequest decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(DeleteDoubaoSearchQueryHistoryRequest r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, DeleteDoubaoSearchQueryHistoryRequest r101) throws IOException {
            DoubaoSearchSceneMeta r102 = r101.mscene_meta;
            if (r102 == null) goto L5;
            DoubaoSearchSceneMeta.ADAPTER.encodeWithTag(r100, 1, r102);
        L5:
            ClientType r103 = r101.mclient_type;
            if (r103 == null) goto L8;
            ClientType.ADAPTER.encodeWithTag(r100, 2, r103);
        L8:
            DoubaoSearchQueryMeta r104 = r101.mquery_meta;
            if (r104 == null) goto L11;
            DoubaoSearchQueryMeta.ADAPTER.encodeWithTag(r100, 3, r104);
        L11:
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, DeleteDoubaoSearchQueryHistoryRequest r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_DeleteDoubaoSearchQueryHistoryRequest();
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.mscene_meta = this.mscene_meta;
        r100.mclient_type = this.mclient_type;
        r100.mquery_meta = this.mquery_meta;
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return DeleteDoubaoSearchQueryHistoryRequest.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public DeleteDoubaoSearchQueryHistoryRequest(DoubaoSearchSceneMeta r100, ClientType r101, DoubaoSearchQueryMeta r102) {
        this(r100, r101, r102, ByteString.EMPTY);
    }

    public DeleteDoubaoSearchQueryHistoryRequest(DoubaoSearchSceneMeta r100, ClientType r101, DoubaoSearchQueryMeta r102, ByteString r103) {
        super(ADAPTER, r103);
        this.mscene_meta = r100;
        this.mclient_type = r101;
        this.mquery_meta = r102;
    }
}
