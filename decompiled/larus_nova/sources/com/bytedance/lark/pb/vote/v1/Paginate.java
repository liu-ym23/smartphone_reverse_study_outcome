package com.bytedance.lark.pb.vote.v1;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import java.io.IOException;
import okio.ByteString;

/* JADX INFO: loaded from: classes20.dex */
public final class Paginate extends Message<Paginate, Builder> {
    public static final ProtoAdapter<Paginate> ADAPTER = null;
    public static final Integer DEFAULT_SIZE = null;
    public static final Long DEFAULT_START_CURSOR = null;
    private static final long serialVersionUID = 0;
    public final Integer size;
    public final Long start_cursor;

    public static final class Builder extends Message.Builder<Paginate, Builder> {
        public Integer size;
        public Long start_cursor;

        @Override // com.squareup.wire.Message.Builder
        public Paginate build() {
            return new Paginate(this.start_cursor, this.size, super.buildUnknownFields());
        }

        public Builder() {
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder size(Integer r100) {
            this.size = r100;
            return this;
        }

        public Builder start_cursor(Long r100) {
            this.start_cursor = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_Paginate extends ProtoAdapter<Paginate> {
        public ProtoAdapter_Paginate() {
            super(FieldEncoding.LENGTH_DELIMITED, Paginate.class);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public Paginate decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            r101.start_cursor = 0L;
            r101.size = 0;
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L12;
            if (r103 != 1) goto L8;
            r101.start_cursor = ProtoAdapter.INT64.decode(r100);
            goto L3
        L8:
            if (r103 != 2) goto L9;
            r101.size = ProtoAdapter.INT32.decode(r100);
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
        public int encodedSize2(Paginate r100) {
            Long r101 = r100.start_cursor;
            int r102 = 0;
            if (r101 == null) goto L5;
            int r103 = ProtoAdapter.INT64.encodedSizeWithTag(1, r101);
        L6:
            Integer r104 = r100.size;
            if (r104 == null) goto L10;
            r102 = ProtoAdapter.INT32.encodedSizeWithTag(2, r104);
        L10:
            return (r103 + r102) + r100.unknownFields().size();
        L5:
            r103 = 0;
            goto L6
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ Paginate decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(Paginate r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, Paginate r101) throws IOException {
            Long r102 = r101.start_cursor;
            if (r102 == null) goto L5;
            ProtoAdapter.INT64.encodeWithTag(r100, 1, r102);
        L5:
            Integer r103 = r101.size;
            if (r103 == null) goto L8;
            ProtoAdapter.INT32.encodeWithTag(r100, 2, r103);
        L8:
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, Paginate r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_Paginate();
        DEFAULT_START_CURSOR = 0L;
        DEFAULT_SIZE = 0;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.start_cursor = this.start_cursor;
        r100.size = this.size;
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return Paginate.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public Paginate(Long r100, Integer r101) {
        this(r100, r101, ByteString.EMPTY);
    }

    public Paginate(Long r100, Integer r101, ByteString r102) {
        super(ADAPTER, r102);
        this.start_cursor = r100;
        this.size = r101;
    }
}
