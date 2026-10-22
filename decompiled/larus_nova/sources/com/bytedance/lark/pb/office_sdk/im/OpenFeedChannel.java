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
public final class OpenFeedChannel extends Message<OpenFeedChannel, Builder> {
    public static final ProtoAdapter<OpenFeedChannel> ADAPTER = null;
    public static final Integer DEFAULT_BADGE_COUNT = null;
    public static final Long DEFAULT_FEED_ID = null;
    public static final FeedRankLevel DEFAULT_RANK_LEVEL = null;
    public static final Long DEFAULT_RANK_TIME_MS = null;
    private static final long serialVersionUID = 0;
    public final Integer badge_count;
    public final Long feed_id;
    public final FeedRankLevel rank_level;
    public final Long rank_time_ms;

    public static final class Builder extends Message.Builder<OpenFeedChannel, Builder> {
        public Integer badge_count;
        public Long feed_id;
        public FeedRankLevel rank_level;
        public Long rank_time_ms;

        @Override // com.squareup.wire.Message.Builder
        public OpenFeedChannel build() {
            Long r100 = this.feed_id;
            if (r100 == null) goto L13;
            if (this.rank_level == null) goto L13;
            if (this.rank_time_ms == null) goto L13;
            if (this.badge_count == null) goto L13;
            return new OpenFeedChannel(this.feed_id, this.rank_level, this.rank_time_ms, this.badge_count, super.buildUnknownFields());
        L13:
            throw Internal.missingRequiredFields(new Object[]{r100, "feed_id", this.rank_level, "rank_level", this.rank_time_ms, "rank_time_ms", this.badge_count, "badge_count"});
        }

        public Builder() {
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder badge_count(Integer r100) {
            this.badge_count = r100;
            return this;
        }

        public Builder feed_id(Long r100) {
            this.feed_id = r100;
            return this;
        }

        public Builder rank_level(FeedRankLevel r100) {
            this.rank_level = r100;
            return this;
        }

        public Builder rank_time_ms(Long r100) {
            this.rank_time_ms = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_OpenFeedChannel extends ProtoAdapter<OpenFeedChannel> {
        public ProtoAdapter_OpenFeedChannel() {
            super(FieldEncoding.LENGTH_DELIMITED, OpenFeedChannel.class);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public OpenFeedChannel decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            r101.feed_id = 0L;
            r101.rank_level = FeedRankLevel.LOWEST_RANK;
            r101.rank_time_ms = 0L;
            r101.badge_count = 0;
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L21;
            if (r103 != 1) goto L8;
            r101.feed_id = ProtoAdapter.INT64.decode(r100);
            goto L3
        L8:
            if (r103 != 2) goto L10;
            r101.rank_level = FeedRankLevel.ADAPTER.decode(r100);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L18
        L18:
            e = move-exception;
            r101.addUnknownField(r103, FieldEncoding.VARINT, Long.valueOf(e.value));
            goto L3
        L10:
            if (r103 != 3) goto L12;
            r101.rank_time_ms = ProtoAdapter.INT64.decode(r100);
            goto L3
        L12:
            if (r103 != 4) goto L13;
            r101.badge_count = ProtoAdapter.INT32.decode(r100);
            goto L3
        L13:
            FieldEncoding r104 = r100.peekFieldEncoding();
            r101.addUnknownField(r103, r104, r104.rawProtoAdapter().decode(r100));
            goto L3
        L21:
            r100.endMessage(r102);
            return r101.build();
        }

        /* JADX INFO: renamed from: encodedSize, reason: avoid collision after fix types in other method */
        public int encodedSize2(OpenFeedChannel r100) {
            ProtoAdapter<Long> r101 = ProtoAdapter.INT64;
            return (((r101.encodedSizeWithTag(1, r100.feed_id) + FeedRankLevel.ADAPTER.encodedSizeWithTag(2, r100.rank_level)) + r101.encodedSizeWithTag(3, r100.rank_time_ms)) + ProtoAdapter.INT32.encodedSizeWithTag(4, r100.badge_count)) + r100.unknownFields().size();
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ OpenFeedChannel decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(OpenFeedChannel r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, OpenFeedChannel r101) throws IOException {
            ProtoAdapter<Long> r102 = ProtoAdapter.INT64;
            r102.encodeWithTag(r100, 1, r101.feed_id);
            FeedRankLevel.ADAPTER.encodeWithTag(r100, 2, r101.rank_level);
            r102.encodeWithTag(r100, 3, r101.rank_time_ms);
            ProtoAdapter.INT32.encodeWithTag(r100, 4, r101.badge_count);
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, OpenFeedChannel r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_OpenFeedChannel();
        DEFAULT_FEED_ID = 0L;
        DEFAULT_RANK_LEVEL = FeedRankLevel.LOWEST_RANK;
        DEFAULT_RANK_TIME_MS = 0L;
        DEFAULT_BADGE_COUNT = 0;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.feed_id = this.feed_id;
        r100.rank_level = this.rank_level;
        r100.rank_time_ms = this.rank_time_ms;
        r100.badge_count = this.badge_count;
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return OpenFeedChannel.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public OpenFeedChannel(Long r100, FeedRankLevel r101, Long r102, Integer r110) {
        this(r100, r101, r102, r110, ByteString.EMPTY);
    }

    public OpenFeedChannel(Long r100, FeedRankLevel r101, Long r102, Integer r103, ByteString r104) {
        super(ADAPTER, r104);
        this.feed_id = r100;
        this.rank_level = r101;
        this.rank_time_ms = r102;
        this.badge_count = r103;
    }
}
