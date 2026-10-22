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
public final class OpenFeedPreview extends Message<OpenFeedPreview, Builder> {
    public static final ProtoAdapter<OpenFeedPreview> ADAPTER = null;
    public static final Integer DEFAULT_BADGE_COUNT = null;
    public static final Long DEFAULT_FEED_ID = null;
    public static final ByteString DEFAULT_PREVIEW_DATA = null;
    public static final FeedRankLevel DEFAULT_RANK_LEVEL = null;
    public static final Long DEFAULT_RANK_TIME_MS = null;
    public static final Long DEFAULT_VERSION = null;
    private static final long serialVersionUID = 0;
    public final Integer badge_count;
    public final OpenFeedExtraInfo extra_info;
    public final Long feed_id;
    public final ByteString preview_data;
    public final FeedRankLevel rank_level;
    public final Long rank_time_ms;
    public final Long version;

    public static final class Builder extends Message.Builder<OpenFeedPreview, Builder> {
        public Integer badge_count;
        public OpenFeedExtraInfo extra_info;
        public Long feed_id;
        public ByteString preview_data;
        public FeedRankLevel rank_level;
        public Long rank_time_ms;
        public Long version;

        @Override // com.squareup.wire.Message.Builder
        public OpenFeedPreview build() {
            Long r100 = this.feed_id;
            if (r100 == null) goto L17;
            if (this.rank_level == null) goto L17;
            if (this.rank_time_ms == null) goto L17;
            if (this.badge_count == null) goto L17;
            if (this.version == null) goto L17;
            if (this.preview_data == null) goto L17;
            return new OpenFeedPreview(this.feed_id, this.rank_level, this.rank_time_ms, this.badge_count, this.version, this.extra_info, this.preview_data, super.buildUnknownFields());
        L17:
            throw Internal.missingRequiredFields(new Object[]{r100, "feed_id", this.rank_level, "rank_level", this.rank_time_ms, "rank_time_ms", this.badge_count, "badge_count", this.version, "version", this.preview_data, "preview_data"});
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

        public Builder extra_info(OpenFeedExtraInfo r100) {
            this.extra_info = r100;
            return this;
        }

        public Builder feed_id(Long r100) {
            this.feed_id = r100;
            return this;
        }

        public Builder preview_data(ByteString r100) {
            this.preview_data = r100;
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

        public Builder version(Long r100) {
            this.version = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_OpenFeedPreview extends ProtoAdapter<OpenFeedPreview> {
        public ProtoAdapter_OpenFeedPreview() {
            super(FieldEncoding.LENGTH_DELIMITED, OpenFeedPreview.class);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public OpenFeedPreview decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            r101.feed_id = 0L;
            r101.rank_level = FeedRankLevel.LOWEST_RANK;
            r101.rank_time_ms = 0L;
            r101.badge_count = 0;
            r101.version = 0L;
            r101.preview_data = ByteString.EMPTY;
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L19;
            if (r103 != 999) goto L7;
            r101.preview_data = ProtoAdapter.BYTES.decode(r100);
            goto L3
        L7:
            switch(r103) {
                case 1: goto L17;
                case 2: goto L21;
                case 3: goto L12;
                case 4: goto L11;
                case 5: goto L10;
                case 6: goto L9;
                default: goto L8;
            };
        L21:
            r101.rank_level = FeedRankLevel.ADAPTER.decode(r100);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L15
        L15:
            e = move-exception;
            r101.addUnknownField(r103, FieldEncoding.VARINT, Long.valueOf(e.value));
            goto L3
        L9:
            r101.extra_info = OpenFeedExtraInfo.ADAPTER.decode(r100);
            goto L3
        L10:
            r101.version = ProtoAdapter.INT64.decode(r100);
            goto L3
        L11:
            r101.badge_count = ProtoAdapter.INT32.decode(r100);
            goto L3
        L12:
            r101.rank_time_ms = ProtoAdapter.INT64.decode(r100);
            goto L3
        L17:
            r101.feed_id = ProtoAdapter.INT64.decode(r100);
            goto L3
        L8:
            FieldEncoding r104 = r100.peekFieldEncoding();
            r101.addUnknownField(r103, r104, r104.rawProtoAdapter().decode(r100));
            goto L3
        L19:
            r100.endMessage(r102);
            return r101.build();
        }

        /* JADX INFO: renamed from: encodedSize, reason: avoid collision after fix types in other method */
        public int encodedSize2(OpenFeedPreview r100) {
            ProtoAdapter<Long> r101 = ProtoAdapter.INT64;
            int r102 = (((r101.encodedSizeWithTag(1, r100.feed_id) + FeedRankLevel.ADAPTER.encodedSizeWithTag(2, r100.rank_level)) + r101.encodedSizeWithTag(3, r100.rank_time_ms)) + ProtoAdapter.INT32.encodedSizeWithTag(4, r100.badge_count)) + r101.encodedSizeWithTag(5, r100.version);
            OpenFeedExtraInfo r103 = r100.extra_info;
            if (r103 == null) goto L5;
            int r104 = OpenFeedExtraInfo.ADAPTER.encodedSizeWithTag(6, r103);
        L7:
            return ((r102 + r104) + ProtoAdapter.BYTES.encodedSizeWithTag(999, r100.preview_data)) + r100.unknownFields().size();
        L5:
            r104 = 0;
            goto L7
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ OpenFeedPreview decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(OpenFeedPreview r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, OpenFeedPreview r101) throws IOException {
            ProtoAdapter<Long> r102 = ProtoAdapter.INT64;
            r102.encodeWithTag(r100, 1, r101.feed_id);
            FeedRankLevel.ADAPTER.encodeWithTag(r100, 2, r101.rank_level);
            r102.encodeWithTag(r100, 3, r101.rank_time_ms);
            ProtoAdapter.INT32.encodeWithTag(r100, 4, r101.badge_count);
            r102.encodeWithTag(r100, 5, r101.version);
            OpenFeedExtraInfo r103 = r101.extra_info;
            if (r103 == null) goto L5;
            OpenFeedExtraInfo.ADAPTER.encodeWithTag(r100, 6, r103);
        L5:
            ProtoAdapter.BYTES.encodeWithTag(r100, 999, r101.preview_data);
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, OpenFeedPreview r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_OpenFeedPreview();
        DEFAULT_FEED_ID = 0L;
        DEFAULT_RANK_LEVEL = FeedRankLevel.LOWEST_RANK;
        DEFAULT_RANK_TIME_MS = 0L;
        DEFAULT_BADGE_COUNT = 0;
        DEFAULT_VERSION = 0L;
        DEFAULT_PREVIEW_DATA = ByteString.EMPTY;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.feed_id = this.feed_id;
        r100.rank_level = this.rank_level;
        r100.rank_time_ms = this.rank_time_ms;
        r100.badge_count = this.badge_count;
        r100.version = this.version;
        r100.extra_info = this.extra_info;
        r100.preview_data = this.preview_data;
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return OpenFeedPreview.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public OpenFeedPreview(Long r110, FeedRankLevel r111, Long r112, Integer r113, Long r114, OpenFeedExtraInfo r115, ByteString r116) {
        this(r110, r111, r112, r113, r114, r115, r116, ByteString.EMPTY);
    }

    public OpenFeedPreview(Long r100, FeedRankLevel r101, Long r102, Integer r103, Long r104, OpenFeedExtraInfo r105, ByteString r106, ByteString r107) {
        super(ADAPTER, r107);
        this.feed_id = r100;
        this.rank_level = r101;
        this.rank_time_ms = r102;
        this.badge_count = r103;
        this.version = r104;
        this.extra_info = r105;
        this.preview_data = r106;
    }
}
