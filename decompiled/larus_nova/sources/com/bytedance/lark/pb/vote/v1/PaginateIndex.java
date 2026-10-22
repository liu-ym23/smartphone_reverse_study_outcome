package com.bytedance.lark.pb.vote.v1;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import java.io.IOException;
import okio.ByteString;

/* JADX INFO: loaded from: classes20.dex */
public final class PaginateIndex extends Message<PaginateIndex, Builder> {
    public static final ProtoAdapter<PaginateIndex> ADAPTER = null;
    public static final Long DEFAULT_INDEX = null;
    private static final long serialVersionUID = 0;
    public final Long index;
    public final Paginate paginate;

    public static final class Builder extends Message.Builder<PaginateIndex, Builder> {
        public Long index;
        public Paginate paginate;

        @Override // com.squareup.wire.Message.Builder
        public PaginateIndex build() {
            return new PaginateIndex(this.index, this.paginate, super.buildUnknownFields());
        }

        public Builder() {
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder index(Long r100) {
            this.index = r100;
            return this;
        }

        public Builder paginate(Paginate r100) {
            this.paginate = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_PaginateIndex extends ProtoAdapter<PaginateIndex> {
        public ProtoAdapter_PaginateIndex() {
            super(FieldEncoding.LENGTH_DELIMITED, PaginateIndex.class);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public PaginateIndex decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            r101.index = 0L;
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L12;
            if (r103 != 1) goto L8;
            r101.index = ProtoAdapter.INT64.decode(r100);
            goto L3
        L8:
            if (r103 != 2) goto L9;
            r101.paginate = Paginate.ADAPTER.decode(r100);
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
        public int encodedSize2(PaginateIndex r100) {
            Long r101 = r100.index;
            int r102 = 0;
            if (r101 == null) goto L5;
            int r103 = ProtoAdapter.INT64.encodedSizeWithTag(1, r101);
        L6:
            Paginate r104 = r100.paginate;
            if (r104 == null) goto L10;
            r102 = Paginate.ADAPTER.encodedSizeWithTag(2, r104);
        L10:
            return (r103 + r102) + r100.unknownFields().size();
        L5:
            r103 = 0;
            goto L6
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ PaginateIndex decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(PaginateIndex r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, PaginateIndex r101) throws IOException {
            Long r102 = r101.index;
            if (r102 == null) goto L5;
            ProtoAdapter.INT64.encodeWithTag(r100, 1, r102);
        L5:
            Paginate r103 = r101.paginate;
            if (r103 == null) goto L8;
            Paginate.ADAPTER.encodeWithTag(r100, 2, r103);
        L8:
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, PaginateIndex r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_PaginateIndex();
        DEFAULT_INDEX = 0L;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.index = this.index;
        r100.paginate = this.paginate;
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return PaginateIndex.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public PaginateIndex(Long r100, Paginate r101) {
        this(r100, r101, ByteString.EMPTY);
    }

    public PaginateIndex(Long r100, Paginate r101, ByteString r102) {
        super(ADAPTER, r102);
        this.index = r100;
        this.paginate = r101;
    }
}
