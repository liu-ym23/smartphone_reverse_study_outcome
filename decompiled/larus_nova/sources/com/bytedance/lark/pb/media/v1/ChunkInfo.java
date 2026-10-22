package com.bytedance.lark.pb.media.v1;

import com.bytedance.android.ec.core.event.a;
import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import com.squareup.wire.internal.Internal;
import com.ss.android.socialbase.downloader.constants.MonitorConstants;
import java.io.IOException;
import okio.ByteString;

/* JADX INFO: loaded from: classes20.dex */
public final class ChunkInfo extends Message<ChunkInfo, Builder> {
    public static final ProtoAdapter<ChunkInfo> ADAPTER = null;
    public static final ByteString DEFAULT_CHUNK = null;
    public static final Boolean DEFAULT_IS_FIRST = null;
    public static final Boolean DEFAULT_IS_LAST = null;
    public static final Long DEFAULT_OFFSET = null;
    private static final long serialVersionUID = 0;
    public final ByteString chunk;
    public final Boolean is_first;
    public final Boolean is_last;
    public final Long offset;

    public static final class Builder extends Message.Builder<ChunkInfo, Builder> {
        public ByteString chunk;
        public Boolean is_first;
        public Boolean is_last;
        public Long offset;

        @Override // com.squareup.wire.Message.Builder
        public ChunkInfo build() {
            Long r100 = this.offset;
            if (r100 == null) goto L13;
            if (this.is_first == null) goto L13;
            if (this.is_last == null) goto L13;
            if (this.chunk == null) goto L13;
            return new ChunkInfo(this.offset, this.is_first, this.is_last, this.chunk, super.buildUnknownFields());
        L13:
            throw Internal.missingRequiredFields(new Object[]{r100, "offset", this.is_first, a.KEY_IS_FIRST, this.is_last, "is_last", this.chunk, MonitorConstants.CHUNK});
        }

        public Builder() {
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder chunk(ByteString r100) {
            this.chunk = r100;
            return this;
        }

        public Builder is_first(Boolean r100) {
            this.is_first = r100;
            return this;
        }

        public Builder is_last(Boolean r100) {
            this.is_last = r100;
            return this;
        }

        public Builder offset(Long r100) {
            this.offset = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_ChunkInfo extends ProtoAdapter<ChunkInfo> {
        public ProtoAdapter_ChunkInfo() {
            super(FieldEncoding.LENGTH_DELIMITED, ChunkInfo.class);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public ChunkInfo decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            r101.offset = 0L;
            Boolean r102 = Boolean.FALSE;
            r101.is_first = r102;
            r101.is_last = r102;
            r101.chunk = ByteString.EMPTY;
            long r103 = r100.beginMessage();
        L3:
            int r104 = r100.nextTag();
            if (r104 == (-1)) goto L18;
            if (r104 != 1) goto L8;
            r101.offset = ProtoAdapter.UINT64.decode(r100);
            goto L3
        L8:
            if (r104 != 2) goto L10;
            r101.is_first = ProtoAdapter.BOOL.decode(r100);
            goto L3
        L10:
            if (r104 != 3) goto L12;
            r101.is_last = ProtoAdapter.BOOL.decode(r100);
            goto L3
        L12:
            if (r104 != 4) goto L13;
            r101.chunk = ProtoAdapter.BYTES.decode(r100);
            goto L3
        L13:
            FieldEncoding r105 = r100.peekFieldEncoding();
            r101.addUnknownField(r104, r105, r105.rawProtoAdapter().decode(r100));
            goto L3
        L18:
            r100.endMessage(r103);
            return r101.build();
        }

        /* JADX INFO: renamed from: encodedSize, reason: avoid collision after fix types in other method */
        public int encodedSize2(ChunkInfo r100) {
            int r101 = ProtoAdapter.UINT64.encodedSizeWithTag(1, r100.offset);
            ProtoAdapter<Boolean> r102 = ProtoAdapter.BOOL;
            return (((r101 + r102.encodedSizeWithTag(2, r100.is_first)) + r102.encodedSizeWithTag(3, r100.is_last)) + ProtoAdapter.BYTES.encodedSizeWithTag(4, r100.chunk)) + r100.unknownFields().size();
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ ChunkInfo decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(ChunkInfo r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, ChunkInfo r101) throws IOException {
            ProtoAdapter.UINT64.encodeWithTag(r100, 1, r101.offset);
            ProtoAdapter<Boolean> r102 = ProtoAdapter.BOOL;
            r102.encodeWithTag(r100, 2, r101.is_first);
            r102.encodeWithTag(r100, 3, r101.is_last);
            ProtoAdapter.BYTES.encodeWithTag(r100, 4, r101.chunk);
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, ChunkInfo r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_ChunkInfo();
        DEFAULT_OFFSET = 0L;
        Boolean r100 = Boolean.FALSE;
        DEFAULT_IS_FIRST = r100;
        DEFAULT_IS_LAST = r100;
        DEFAULT_CHUNK = ByteString.EMPTY;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.offset = this.offset;
        r100.is_first = this.is_first;
        r100.is_last = this.is_last;
        r100.chunk = this.chunk;
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return ChunkInfo.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public ChunkInfo(Long r100, Boolean r101, Boolean r102, ByteString r110) {
        this(r100, r101, r102, r110, ByteString.EMPTY);
    }

    public ChunkInfo(Long r100, Boolean r101, Boolean r102, ByteString r103, ByteString r104) {
        super(ADAPTER, r104);
        this.offset = r100;
        this.is_first = r101;
        this.is_last = r102;
        this.chunk = r103;
    }
}
