package com.bytedance.lark.pb.feed.v1;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import com.squareup.wire.internal.Internal;
import com.ss.android.downloadlib.constants.DownloadConstants;
import java.io.IOException;
import okio.ByteString;

/* JADX INFO: loaded from: classes20.dex */
public final class LarkFeedListKeyChange extends Message<LarkFeedListKeyChange, Builder> {
    public static final ProtoAdapter<LarkFeedListKeyChange> ADAPTER = null;
    public static final Integer DEFAULT_BADGE_COUNT = null;
    public static final FeedFilter.Type DEFAULT_FEED_FILTER = null;
    public static final Boolean DEFAULT_FORCE_UPDATE = null;
    public static final FeedFilter.Type DEFAULT_LAST_FEED_FILTER = null;
    public static final Integer DEFAULT_MUTE_UNREAD_COUNT = null;
    public static final Long DEFAULT_VERSION = null;
    private static final long serialVersionUID = 0;
    public final Integer badge_count;
    public final FeedFilter.Type feed_filter;
    public final Boolean force_update;
    public final FeedFilter.Type last_feed_filter;
    public final Integer mute_unread_count;
    public final Long version;

    public static final class Builder extends Message.Builder<LarkFeedListKeyChange, Builder> {
        public Integer badge_count;
        public FeedFilter.Type feed_filter;
        public Boolean force_update;
        public FeedFilter.Type last_feed_filter;
        public Integer mute_unread_count;
        public Long version;

        @Override // com.squareup.wire.Message.Builder
        public LarkFeedListKeyChange build() {
            Long r100 = this.version;
            if (r100 == null) goto L17;
            if (this.force_update == null) goto L17;
            if (this.badge_count == null) goto L17;
            if (this.mute_unread_count == null) goto L17;
            if (this.feed_filter == null) goto L17;
            if (this.last_feed_filter == null) goto L17;
            return new LarkFeedListKeyChange(this.version, this.force_update, this.badge_count, this.mute_unread_count, this.feed_filter, this.last_feed_filter, super.buildUnknownFields());
        L17:
            throw Internal.missingRequiredFields(new Object[]{r100, "version", this.force_update, DownloadConstants.KEY_FORCE_UPDATE, this.badge_count, "badge_count", this.mute_unread_count, "mute_unread_count", this.feed_filter, "feed_filter", this.last_feed_filter, "last_feed_filter"});
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

        public Builder feed_filter(FeedFilter.Type r100) {
            this.feed_filter = r100;
            return this;
        }

        public Builder force_update(Boolean r100) {
            this.force_update = r100;
            return this;
        }

        public Builder last_feed_filter(FeedFilter.Type r100) {
            this.last_feed_filter = r100;
            return this;
        }

        public Builder mute_unread_count(Integer r100) {
            this.mute_unread_count = r100;
            return this;
        }

        public Builder version(Long r100) {
            this.version = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_LarkFeedListKeyChange extends ProtoAdapter<LarkFeedListKeyChange> {
        public ProtoAdapter_LarkFeedListKeyChange() {
            super(FieldEncoding.LENGTH_DELIMITED, LarkFeedListKeyChange.class);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public LarkFeedListKeyChange decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            r101.version = 0L;
            r101.force_update = Boolean.FALSE;
            r101.badge_count = 0;
            r101.mute_unread_count = 0;
            FeedFilter.Type r102 = FeedFilter.Type.UNKNOWN;
            r101.feed_filter = r102;
            r101.last_feed_filter = r102;
            long r103 = r100.beginMessage();
        L3:
            int r104 = r100.nextTag();
            if (r104 == (-1)) goto L19;
            switch(r104) {
                case 1: goto L18;
                case 2: goto L17;
                case 3: goto L16;
                case 4: goto L15;
                case 5: goto L21;
                case 6: goto L23;
                default: goto L6;
            };
        L21:
            r101.feed_filter = FeedFilter.Type.ADAPTER.decode(r100);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L13
        L13:
            e = move-exception;
            r101.addUnknownField(r104, FieldEncoding.VARINT, Long.valueOf(e.value));
            goto L3
        L23:
            r101.last_feed_filter = FeedFilter.Type.ADAPTER.decode(r100);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L9
        L9:
            e = move-exception;
            r101.addUnknownField(r104, FieldEncoding.VARINT, Long.valueOf(e.value));
            goto L3
        L15:
            r101.mute_unread_count = ProtoAdapter.INT32.decode(r100);
            goto L3
        L16:
            r101.badge_count = ProtoAdapter.INT32.decode(r100);
            goto L3
        L17:
            r101.force_update = ProtoAdapter.BOOL.decode(r100);
            goto L3
        L18:
            r101.version = ProtoAdapter.INT64.decode(r100);
            goto L3
        L6:
            FieldEncoding r105 = r100.peekFieldEncoding();
            r101.addUnknownField(r104, r105, r105.rawProtoAdapter().decode(r100));
            goto L3
        L19:
            r100.endMessage(r103);
            return r101.build();
        }

        /* JADX INFO: renamed from: encodedSize, reason: avoid collision after fix types in other method */
        public int encodedSize2(LarkFeedListKeyChange r100) {
            int r101 = ProtoAdapter.INT64.encodedSizeWithTag(1, r100.version) + ProtoAdapter.BOOL.encodedSizeWithTag(2, r100.force_update);
            ProtoAdapter<Integer> r102 = ProtoAdapter.INT32;
            int r103 = (r101 + r102.encodedSizeWithTag(3, r100.badge_count)) + r102.encodedSizeWithTag(4, r100.mute_unread_count);
            ProtoAdapter<FeedFilter.Type> r104 = FeedFilter.Type.ADAPTER;
            return ((r103 + r104.encodedSizeWithTag(5, r100.feed_filter)) + r104.encodedSizeWithTag(6, r100.last_feed_filter)) + r100.unknownFields().size();
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ LarkFeedListKeyChange decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(LarkFeedListKeyChange r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, LarkFeedListKeyChange r101) throws IOException {
            ProtoAdapter.INT64.encodeWithTag(r100, 1, r101.version);
            ProtoAdapter.BOOL.encodeWithTag(r100, 2, r101.force_update);
            ProtoAdapter<Integer> r102 = ProtoAdapter.INT32;
            r102.encodeWithTag(r100, 3, r101.badge_count);
            r102.encodeWithTag(r100, 4, r101.mute_unread_count);
            ProtoAdapter<FeedFilter.Type> r103 = FeedFilter.Type.ADAPTER;
            r103.encodeWithTag(r100, 5, r101.feed_filter);
            r103.encodeWithTag(r100, 6, r101.last_feed_filter);
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, LarkFeedListKeyChange r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_LarkFeedListKeyChange();
        DEFAULT_VERSION = 0L;
        DEFAULT_FORCE_UPDATE = Boolean.FALSE;
        DEFAULT_BADGE_COUNT = 0;
        DEFAULT_MUTE_UNREAD_COUNT = 0;
        FeedFilter.Type r100 = FeedFilter.Type.UNKNOWN;
        DEFAULT_FEED_FILTER = r100;
        DEFAULT_LAST_FEED_FILTER = r100;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.version = this.version;
        r100.force_update = this.force_update;
        r100.badge_count = this.badge_count;
        r100.mute_unread_count = this.mute_unread_count;
        r100.feed_filter = this.feed_filter;
        r100.last_feed_filter = this.last_feed_filter;
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return LarkFeedListKeyChange.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public LarkFeedListKeyChange(Long r100, Boolean r110, Integer r111, Integer r112, FeedFilter.Type r113, FeedFilter.Type r114) {
        this(r100, r110, r111, r112, r113, r114, ByteString.EMPTY);
    }

    public LarkFeedListKeyChange(Long r100, Boolean r101, Integer r102, Integer r103, FeedFilter.Type r104, FeedFilter.Type r105, ByteString r106) {
        super(ADAPTER, r106);
        this.version = r100;
        this.force_update = r101;
        this.badge_count = r102;
        this.mute_unread_count = r103;
        this.feed_filter = r104;
        this.last_feed_filter = r105;
    }
}
