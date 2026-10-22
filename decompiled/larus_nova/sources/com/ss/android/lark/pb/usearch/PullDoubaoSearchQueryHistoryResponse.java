package com.ss.android.lark.pb.usearch;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import com.squareup.wire.internal.Internal;
import java.io.IOException;
import java.util.List;
import okio.ByteString;

/* JADX INFO: loaded from: classes37.dex */
public final class PullDoubaoSearchQueryHistoryResponse extends Message<PullDoubaoSearchQueryHistoryResponse, Builder> {
    public static final ProtoAdapter<PullDoubaoSearchQueryHistoryResponse> ADAPTER = null;
    private static final long serialVersionUID = 0;
    public final List<DoubaoSearchQueryMeta> mquery_metas;

    public static final class Builder extends Message.Builder<PullDoubaoSearchQueryHistoryResponse, Builder> {
        public List<DoubaoSearchQueryMeta> mquery_metas;

        @Override // com.squareup.wire.Message.Builder
        public PullDoubaoSearchQueryHistoryResponse build() {
            return new PullDoubaoSearchQueryHistoryResponse(this.mquery_metas, super.buildUnknownFields());
        }

        public Builder() {
            this.mquery_metas = Internal.newMutableList();
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder query_metas(List<DoubaoSearchQueryMeta> r100) {
            Internal.checkElementsNotNull(r100);
            this.mquery_metas = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_PullDoubaoSearchQueryHistoryResponse extends ProtoAdapter<PullDoubaoSearchQueryHistoryResponse> {
        public ProtoAdapter_PullDoubaoSearchQueryHistoryResponse() {
            super(FieldEncoding.LENGTH_DELIMITED, PullDoubaoSearchQueryHistoryResponse.class);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public PullDoubaoSearchQueryHistoryResponse decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L9;
            if (r103 != 1) goto L7;
            r101.mquery_metas.add(DoubaoSearchQueryMeta.ADAPTER.decode(r100));
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
        public int encodedSize2(PullDoubaoSearchQueryHistoryResponse r100) {
            return DoubaoSearchQueryMeta.ADAPTER.asRepeated().encodedSizeWithTag(1, r100.mquery_metas) + r100.unknownFields().size();
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ PullDoubaoSearchQueryHistoryResponse decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(PullDoubaoSearchQueryHistoryResponse r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, PullDoubaoSearchQueryHistoryResponse r101) throws IOException {
            DoubaoSearchQueryMeta.ADAPTER.asRepeated().encodeWithTag(r100, 1, r101.mquery_metas);
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, PullDoubaoSearchQueryHistoryResponse r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_PullDoubaoSearchQueryHistoryResponse();
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.mquery_metas = Internal.copyOf("mquery_metas", this.mquery_metas);
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return PullDoubaoSearchQueryHistoryResponse.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public PullDoubaoSearchQueryHistoryResponse(List<DoubaoSearchQueryMeta> r100) {
        this(r100, ByteString.EMPTY);
    }

    public PullDoubaoSearchQueryHistoryResponse(List<DoubaoSearchQueryMeta> r100, ByteString r101) {
        super(ADAPTER, r101);
        this.mquery_metas = Internal.immutableCopyOf("mquery_metas", r100);
    }
}
