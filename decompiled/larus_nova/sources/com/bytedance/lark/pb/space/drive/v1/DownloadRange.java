package com.bytedance.lark.pb.space.drive.v1;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import com.squareup.wire.internal.Internal;
import java.io.IOException;
import okio.ByteString;

/* JADX INFO: loaded from: classes20.dex */
public final class DownloadRange extends Message<DownloadRange, Builder> {
    public static final ProtoAdapter<DownloadRange> ADAPTER = null;
    public static final Long DEFAULT_END = null;
    public static final Long DEFAULT_START = null;
    private static final long serialVersionUID = 0;
    public final Long end;
    public final Long start;

    public static final class Builder extends Message.Builder<DownloadRange, Builder> {
        public Long end;
        public Long start;

        @Override // com.squareup.wire.Message.Builder
        public DownloadRange build() {
            Long r100 = this.start;
            if (r100 == null) goto L9;
            if (this.end == null) goto L9;
            return new DownloadRange(this.start, this.end, super.buildUnknownFields());
        L9:
            throw Internal.missingRequiredFields(new Object[]{r100, "start", this.end, "end"});
        }

        public Builder() {
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder end(Long r100) {
            this.end = r100;
            return this;
        }

        public Builder start(Long r100) {
            this.start = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_DownloadRange extends ProtoAdapter<DownloadRange> {
        public ProtoAdapter_DownloadRange() {
            super(FieldEncoding.LENGTH_DELIMITED, DownloadRange.class);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public DownloadRange decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            r101.start = 0L;
            r101.end = 0L;
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L12;
            if (r103 != 1) goto L8;
            r101.start = ProtoAdapter.UINT64.decode(r100);
            goto L3
        L8:
            if (r103 != 2) goto L9;
            r101.end = ProtoAdapter.UINT64.decode(r100);
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
        public int encodedSize2(DownloadRange r100) {
            ProtoAdapter<Long> r101 = ProtoAdapter.UINT64;
            return (r101.encodedSizeWithTag(1, r100.start) + r101.encodedSizeWithTag(2, r100.end)) + r100.unknownFields().size();
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ DownloadRange decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(DownloadRange r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, DownloadRange r101) throws IOException {
            ProtoAdapter<Long> r102 = ProtoAdapter.UINT64;
            r102.encodeWithTag(r100, 1, r101.start);
            r102.encodeWithTag(r100, 2, r101.end);
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, DownloadRange r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_DownloadRange();
        DEFAULT_START = 0L;
        DEFAULT_END = 0L;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.start = this.start;
        r100.end = this.end;
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return DownloadRange.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public DownloadRange(Long r100, Long r101) {
        this(r100, r101, ByteString.EMPTY);
    }

    public DownloadRange(Long r100, Long r101, ByteString r102) {
        super(ADAPTER, r102);
        this.start = r100;
        this.end = r101;
    }
}
