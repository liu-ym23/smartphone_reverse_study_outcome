package com.bytedance.lark.pb.office_sdk.im;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import com.squareup.wire.internal.Internal;
import java.io.IOException;
import okio.ByteString;

/* JADX INFO: loaded from: classes20.dex */
public final class MetaFeed extends Message<MetaFeed, Builder> {
    public static final ProtoAdapter<MetaFeed> ADAPTER = null;
    public static final String DEFAULT_BIZ_ID = "";
    public static final Long DEFAULT_FEED_ID = null;
    public static final Long DEFAULT_RANK_TIME_MS = null;
    private static final long serialVersionUID = 0;
    public final String biz_id;
    public final Long feed_id;
    public final Long rank_time_ms;

    public static final class Builder extends Message.Builder<MetaFeed, Builder> {
        public String biz_id;
        public Long feed_id;
        public Long rank_time_ms;

        @Override // com.squareup.wire.Message.Builder
        public MetaFeed build() {
            Long r100 = this.feed_id;
            if (r100 == null) goto L7;
            return new MetaFeed(this.feed_id, this.biz_id, this.rank_time_ms, super.buildUnknownFields());
        L7:
            throw Internal.missingRequiredFields(new Object[]{r100, "feed_id"});
        }

        public Builder() {
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder biz_id(String r100) {
            this.biz_id = r100;
            return this;
        }

        public Builder feed_id(Long r100) {
            this.feed_id = r100;
            return this;
        }

        public Builder rank_time_ms(Long r100) {
            this.rank_time_ms = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_MetaFeed extends ProtoAdapter<MetaFeed> {
        public ProtoAdapter_MetaFeed() {
            super(FieldEncoding.LENGTH_DELIMITED, MetaFeed.class);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public MetaFeed decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            r101.feed_id = 0L;
            r101.biz_id = "";
            r101.rank_time_ms = 0L;
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L15;
            if (r103 != 1) goto L8;
            r101.feed_id = ProtoAdapter.INT64.decode(r100);
            goto L3
        L8:
            if (r103 != 2) goto L10;
            r101.biz_id = ProtoAdapter.STRING.decode(r100);
            goto L3
        L10:
            if (r103 != 3) goto L11;
            r101.rank_time_ms = ProtoAdapter.INT64.decode(r100);
            goto L3
        L11:
            FieldEncoding r104 = r100.peekFieldEncoding();
            r101.addUnknownField(r103, r104, r104.rawProtoAdapter().decode(r100));
            goto L3
        L15:
            r100.endMessage(r102);
            return r101.build();
        }

        /* JADX INFO: renamed from: encodedSize, reason: avoid collision after fix types in other method */
        public int encodedSize2(MetaFeed r100) {
            ProtoAdapter<Long> r101 = ProtoAdapter.INT64;
            int r102 = r101.encodedSizeWithTag(1, r100.feed_id);
            String r103 = r100.biz_id;
            int r104 = 0;
            if (r103 == null) goto L5;
            int r105 = ProtoAdapter.STRING.encodedSizeWithTag(2, r103);
        L6:
            int r106 = r102 + r105;
            Long r107 = r100.rank_time_ms;
            if (r107 == null) goto L10;
            r104 = r101.encodedSizeWithTag(3, r107);
        L10:
            return (r106 + r104) + r100.unknownFields().size();
        L5:
            r105 = 0;
            goto L6
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ MetaFeed decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(MetaFeed r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, MetaFeed r101) throws IOException {
            ProtoAdapter<Long> r102 = ProtoAdapter.INT64;
            r102.encodeWithTag(r100, 1, r101.feed_id);
            String r103 = r101.biz_id;
            if (r103 == null) goto L5;
            ProtoAdapter.STRING.encodeWithTag(r100, 2, r103);
        L5:
            Long r104 = r101.rank_time_ms;
            if (r104 == null) goto L8;
            r102.encodeWithTag(r100, 3, r104);
        L8:
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, MetaFeed r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_MetaFeed();
        DEFAULT_FEED_ID = 0L;
        DEFAULT_RANK_TIME_MS = 0L;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.feed_id = this.feed_id;
        r100.biz_id = this.biz_id;
        r100.rank_time_ms = this.rank_time_ms;
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return MetaFeed.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public MetaFeed(Long r100, String r101, Long r102) {
        this(r100, r101, r102, ByteString.EMPTY);
    }

    public MetaFeed(Long r100, String r101, Long r102, ByteString r103) {
        super(ADAPTER, r103);
        this.feed_id = r100;
        this.biz_id = r101;
        this.rank_time_ms = r102;
    }
}
