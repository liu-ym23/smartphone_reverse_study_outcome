package com.ss.android.lark.pb.usearch;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import java.io.IOException;
import okio.ByteString;

/* JADX INFO: loaded from: classes37.dex */
public final class PullDoubaoSearchQueryHistoryRequest extends Message<PullDoubaoSearchQueryHistoryRequest, Builder> {
    public static final ProtoAdapter<PullDoubaoSearchQueryHistoryRequest> ADAPTER = null;
    private static final long serialVersionUID = 0;
    public final ClientType mclient_type;
    public final DoubaoSearchSceneMeta mscene_meta;

    public static final class Builder extends Message.Builder<PullDoubaoSearchQueryHistoryRequest, Builder> {
        public ClientType mclient_type;
        public DoubaoSearchSceneMeta mscene_meta;

        @Override // com.squareup.wire.Message.Builder
        public PullDoubaoSearchQueryHistoryRequest build() {
            return new PullDoubaoSearchQueryHistoryRequest(this.mscene_meta, this.mclient_type, super.buildUnknownFields());
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

        public Builder scene_meta(DoubaoSearchSceneMeta r100) {
            this.mscene_meta = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_PullDoubaoSearchQueryHistoryRequest extends ProtoAdapter<PullDoubaoSearchQueryHistoryRequest> {
        public ProtoAdapter_PullDoubaoSearchQueryHistoryRequest() {
            super(FieldEncoding.LENGTH_DELIMITED, PullDoubaoSearchQueryHistoryRequest.class);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public PullDoubaoSearchQueryHistoryRequest decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L15;
            if (r103 != 1) goto L8;
            r101.mscene_meta = DoubaoSearchSceneMeta.ADAPTER.decode(r100);
            goto L3
        L8:
            if (r103 != 2) goto L9;
            r101.mclient_type = ClientType.ADAPTER.decode(r100);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L12
        L12:
            e = move-exception;
            r101.addUnknownField(r103, FieldEncoding.VARINT, Long.valueOf(e.value));
            goto L3
        L9:
            FieldEncoding r104 = r100.peekFieldEncoding();
            r101.addUnknownField(r103, r104, r104.rawProtoAdapter().decode(r100));
            goto L3
        L15:
            r100.endMessage(r102);
            return r101.build();
        }

        /* JADX INFO: renamed from: encodedSize, reason: avoid collision after fix types in other method */
        public int encodedSize2(PullDoubaoSearchQueryHistoryRequest r100) {
            DoubaoSearchSceneMeta r101 = r100.mscene_meta;
            int r102 = 0;
            if (r101 == null) goto L5;
            int r103 = DoubaoSearchSceneMeta.ADAPTER.encodedSizeWithTag(1, r101);
        L6:
            ClientType r104 = r100.mclient_type;
            if (r104 == null) goto L10;
            r102 = ClientType.ADAPTER.encodedSizeWithTag(2, r104);
        L10:
            return (r103 + r102) + r100.unknownFields().size();
        L5:
            r103 = 0;
            goto L6
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ PullDoubaoSearchQueryHistoryRequest decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(PullDoubaoSearchQueryHistoryRequest r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, PullDoubaoSearchQueryHistoryRequest r101) throws IOException {
            DoubaoSearchSceneMeta r102 = r101.mscene_meta;
            if (r102 == null) goto L5;
            DoubaoSearchSceneMeta.ADAPTER.encodeWithTag(r100, 1, r102);
        L5:
            ClientType r103 = r101.mclient_type;
            if (r103 == null) goto L8;
            ClientType.ADAPTER.encodeWithTag(r100, 2, r103);
        L8:
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, PullDoubaoSearchQueryHistoryRequest r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_PullDoubaoSearchQueryHistoryRequest();
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.mscene_meta = this.mscene_meta;
        r100.mclient_type = this.mclient_type;
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return PullDoubaoSearchQueryHistoryRequest.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public PullDoubaoSearchQueryHistoryRequest(DoubaoSearchSceneMeta r100, ClientType r101) {
        this(r100, r101, ByteString.EMPTY);
    }

    public PullDoubaoSearchQueryHistoryRequest(DoubaoSearchSceneMeta r100, ClientType r101, ByteString r102) {
        super(ADAPTER, r102);
        this.mscene_meta = r100;
        this.mclient_type = r101;
    }
}
