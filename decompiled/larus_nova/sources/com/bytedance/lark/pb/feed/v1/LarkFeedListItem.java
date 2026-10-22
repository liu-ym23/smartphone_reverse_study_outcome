package com.bytedance.lark.pb.feed.v1;

import com.bytedance.lark.pb.basic.v1.FeedCard;
import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import com.squareup.wire.internal.Internal;
import java.io.IOException;
import okio.ByteString;

/* JADX INFO: loaded from: classes20.dex */
public final class LarkFeedListItem extends Message<LarkFeedListItem, Builder> {
    public static final ProtoAdapter<LarkFeedListItem> ADAPTER = null;
    public static final Integer DEFAULT_BADGE_COUNT = null;
    public static final Long DEFAULT_FEED_ID = null;
    public static final FeedCard.FeedType DEFAULT_FEED_TYPE = null;
    public static final String DEFAULT_ID = "";
    public static final Boolean DEFAULT_IS_FLAG = null;
    public static final Boolean DEFAULT_IS_REMIND = null;
    public static final Boolean DEFAULT_IS_SHORTCUT = null;
    public static final Boolean DEFAULT_IS_TOPPING = null;
    public static final Long DEFAULT_ON_TOP_RANK_TIME = null;
    public static final Long DEFAULT_REAL_RANK_TIME = null;
    public static final Long DEFAULT_SORT_KEY = null;
    public static final Long DEFAULT_UPDATE_TIME = null;
    public static final Long DEFAULT_UPDATE_TIME_MS = null;
    private static final long serialVersionUID = 0;
    public final Integer badge_count;
    public final Long feed_id;
    public final FeedCard.FeedType feed_type;

    /* JADX INFO: renamed from: id, reason: collision with root package name */
    public final String f253627id;
    public final Boolean is_flag;
    public final Boolean is_remind;
    public final Boolean is_shortcut;
    public final Boolean is_topping;
    public final Long on_top_rank_time;
    public final FeedEntityPreview preview;
    public final Long real_rank_time;
    public final Long sort_key;
    public final Long update_time;
    public final Long update_time_ms;

    public static final class Builder extends Message.Builder<LarkFeedListItem, Builder> {
        public Integer badge_count;
        public Long feed_id;
        public FeedCard.FeedType feed_type;

        /* JADX INFO: renamed from: id, reason: collision with root package name */
        public String f253628id;
        public Boolean is_flag;
        public Boolean is_remind;
        public Boolean is_shortcut;
        public Boolean is_topping;
        public Long on_top_rank_time;
        public FeedEntityPreview preview;
        public Long real_rank_time;
        public Long sort_key;
        public Long update_time;
        public Long update_time_ms;

        @Override // com.squareup.wire.Message.Builder
        public LarkFeedListItem build() {
            String r100 = this.f253628id;
            if (r100 == null) goto L25;
            if (this.preview == null) goto L25;
            if (this.feed_type == null) goto L25;
            if (this.sort_key == null) goto L25;
            if (this.badge_count == null) goto L25;
            if (this.update_time == null) goto L25;
            if (this.is_topping == null) goto L25;
            if (this.is_flag == null) goto L25;
            if (this.is_remind == null) goto L25;
            if (this.is_shortcut == null) goto L25;
            return new LarkFeedListItem(this.f253628id, this.preview, this.feed_type, this.sort_key, this.badge_count, this.update_time, this.is_topping, this.is_flag, this.is_remind, this.is_shortcut, this.on_top_rank_time, this.real_rank_time, this.update_time_ms, this.feed_id, super.buildUnknownFields());
        L25:
            throw Internal.missingRequiredFields(new Object[]{r100, "id", this.preview, "preview", this.feed_type, "feed_type", this.sort_key, "sort_key", this.badge_count, "badge_count", this.update_time, "update_time", this.is_topping, "is_topping", this.is_flag, "is_flag", this.is_remind, "is_remind", this.is_shortcut, "is_shortcut"});
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

        public Builder feed_type(FeedCard.FeedType r100) {
            this.feed_type = r100;
            return this;
        }

        public Builder id(String r100) {
            this.f253628id = r100;
            return this;
        }

        public Builder is_flag(Boolean r100) {
            this.is_flag = r100;
            return this;
        }

        public Builder is_remind(Boolean r100) {
            this.is_remind = r100;
            return this;
        }

        public Builder is_shortcut(Boolean r100) {
            this.is_shortcut = r100;
            return this;
        }

        public Builder is_topping(Boolean r100) {
            this.is_topping = r100;
            return this;
        }

        public Builder on_top_rank_time(Long r100) {
            this.on_top_rank_time = r100;
            return this;
        }

        public Builder preview(FeedEntityPreview r100) {
            this.preview = r100;
            return this;
        }

        public Builder real_rank_time(Long r100) {
            this.real_rank_time = r100;
            return this;
        }

        public Builder sort_key(Long r100) {
            this.sort_key = r100;
            return this;
        }

        public Builder update_time(Long r100) {
            this.update_time = r100;
            return this;
        }

        public Builder update_time_ms(Long r100) {
            this.update_time_ms = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_LarkFeedListItem extends ProtoAdapter<LarkFeedListItem> {
        public ProtoAdapter_LarkFeedListItem() {
            super(FieldEncoding.LENGTH_DELIMITED, LarkFeedListItem.class);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public LarkFeedListItem decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            r101.f253628id = "";
            r101.feed_type = FeedCard.FeedType.UNKNOWN;
            r101.sort_key = 0L;
            r101.badge_count = 0;
            r101.update_time = 0L;
            Boolean r102 = Boolean.FALSE;
            r101.is_topping = r102;
            r101.is_flag = r102;
            r101.is_remind = r102;
            r101.is_shortcut = r102;
            r101.on_top_rank_time = 0L;
            r101.real_rank_time = 0L;
            r101.update_time_ms = 0L;
            r101.feed_id = 0L;
            long r103 = r100.beginMessage();
        L3:
            int r104 = r100.nextTag();
            if (r104 == (-1)) goto L24;
            switch(r104) {
                case 1: goto L23;
                case 2: goto L22;
                case 3: goto L26;
                case 4: goto L17;
                case 5: goto L16;
                case 6: goto L15;
                case 7: goto L14;
                case 8: goto L13;
                case 9: goto L12;
                case 10: goto L11;
                case 11: goto L10;
                case 12: goto L9;
                case 13: goto L8;
                case 14: goto L7;
                default: goto L6;
            };
        L26:
            r101.feed_type = FeedCard.FeedType.ADAPTER.decode(r100);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L20
        L20:
            e = move-exception;
            r101.addUnknownField(r104, FieldEncoding.VARINT, Long.valueOf(e.value));
            goto L3
        L7:
            r101.feed_id = ProtoAdapter.INT64.decode(r100);
            goto L3
        L8:
            r101.update_time_ms = ProtoAdapter.INT64.decode(r100);
            goto L3
        L9:
            r101.real_rank_time = ProtoAdapter.INT64.decode(r100);
            goto L3
        L10:
            r101.on_top_rank_time = ProtoAdapter.INT64.decode(r100);
            goto L3
        L11:
            r101.is_shortcut = ProtoAdapter.BOOL.decode(r100);
            goto L3
        L12:
            r101.is_remind = ProtoAdapter.BOOL.decode(r100);
            goto L3
        L13:
            r101.is_flag = ProtoAdapter.BOOL.decode(r100);
            goto L3
        L14:
            r101.is_topping = ProtoAdapter.BOOL.decode(r100);
            goto L3
        L15:
            r101.update_time = ProtoAdapter.INT64.decode(r100);
            goto L3
        L16:
            r101.badge_count = ProtoAdapter.INT32.decode(r100);
            goto L3
        L17:
            r101.sort_key = ProtoAdapter.INT64.decode(r100);
            goto L3
        L22:
            r101.preview = FeedEntityPreview.ADAPTER.decode(r100);
            goto L3
        L23:
            r101.f253628id = ProtoAdapter.STRING.decode(r100);
            goto L3
        L6:
            FieldEncoding r105 = r100.peekFieldEncoding();
            r101.addUnknownField(r104, r105, r105.rawProtoAdapter().decode(r100));
            goto L3
        L24:
            r100.endMessage(r103);
            return r101.build();
        }

        /* JADX INFO: renamed from: encodedSize, reason: avoid collision after fix types in other method */
        public int encodedSize2(LarkFeedListItem r100) {
            int r101 = (ProtoAdapter.STRING.encodedSizeWithTag(1, r100.f253627id) + FeedEntityPreview.ADAPTER.encodedSizeWithTag(2, r100.preview)) + FeedCard.FeedType.ADAPTER.encodedSizeWithTag(3, r100.feed_type);
            ProtoAdapter<Long> r102 = ProtoAdapter.INT64;
            int r103 = ((r101 + r102.encodedSizeWithTag(4, r100.sort_key)) + ProtoAdapter.INT32.encodedSizeWithTag(5, r100.badge_count)) + r102.encodedSizeWithTag(6, r100.update_time);
            ProtoAdapter<Boolean> r104 = ProtoAdapter.BOOL;
            int r105 = (((r103 + r104.encodedSizeWithTag(7, r100.is_topping)) + r104.encodedSizeWithTag(8, r100.is_flag)) + r104.encodedSizeWithTag(9, r100.is_remind)) + r104.encodedSizeWithTag(10, r100.is_shortcut);
            Long r106 = r100.on_top_rank_time;
            int r107 = 0;
            if (r106 == null) goto L5;
            int r108 = r102.encodedSizeWithTag(11, r106);
        L6:
            int r109 = r105 + r108;
            Long r110 = r100.real_rank_time;
            if (r110 == null) goto L9;
            int r111 = r102.encodedSizeWithTag(12, r110);
        L10:
            int r112 = r109 + r111;
            Long r113 = r100.update_time_ms;
            if (r113 == null) goto L13;
            int r114 = r102.encodedSizeWithTag(13, r113);
        L14:
            int r115 = r112 + r114;
            Long r116 = r100.feed_id;
            if (r116 == null) goto L18;
            r107 = r102.encodedSizeWithTag(14, r116);
        L18:
            return (r115 + r107) + r100.unknownFields().size();
        L13:
            r114 = 0;
            goto L14
        L9:
            r111 = 0;
            goto L10
        L5:
            r108 = 0;
            goto L6
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ LarkFeedListItem decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(LarkFeedListItem r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, LarkFeedListItem r101) throws IOException {
            ProtoAdapter.STRING.encodeWithTag(r100, 1, r101.f253627id);
            FeedEntityPreview.ADAPTER.encodeWithTag(r100, 2, r101.preview);
            FeedCard.FeedType.ADAPTER.encodeWithTag(r100, 3, r101.feed_type);
            ProtoAdapter<Long> r102 = ProtoAdapter.INT64;
            r102.encodeWithTag(r100, 4, r101.sort_key);
            ProtoAdapter.INT32.encodeWithTag(r100, 5, r101.badge_count);
            r102.encodeWithTag(r100, 6, r101.update_time);
            ProtoAdapter<Boolean> r103 = ProtoAdapter.BOOL;
            r103.encodeWithTag(r100, 7, r101.is_topping);
            r103.encodeWithTag(r100, 8, r101.is_flag);
            r103.encodeWithTag(r100, 9, r101.is_remind);
            r103.encodeWithTag(r100, 10, r101.is_shortcut);
            Long r104 = r101.on_top_rank_time;
            if (r104 == null) goto L5;
            r102.encodeWithTag(r100, 11, r104);
        L5:
            Long r105 = r101.real_rank_time;
            if (r105 == null) goto L8;
            r102.encodeWithTag(r100, 12, r105);
        L8:
            Long r106 = r101.update_time_ms;
            if (r106 == null) goto L11;
            r102.encodeWithTag(r100, 13, r106);
        L11:
            Long r107 = r101.feed_id;
            if (r107 == null) goto L14;
            r102.encodeWithTag(r100, 14, r107);
        L14:
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, LarkFeedListItem r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_LarkFeedListItem();
        DEFAULT_FEED_TYPE = FeedCard.FeedType.UNKNOWN;
        DEFAULT_SORT_KEY = 0L;
        DEFAULT_BADGE_COUNT = 0;
        DEFAULT_UPDATE_TIME = 0L;
        Boolean r100 = Boolean.FALSE;
        DEFAULT_IS_TOPPING = r100;
        DEFAULT_IS_FLAG = r100;
        DEFAULT_IS_REMIND = r100;
        DEFAULT_IS_SHORTCUT = r100;
        DEFAULT_ON_TOP_RANK_TIME = 0L;
        DEFAULT_REAL_RANK_TIME = 0L;
        DEFAULT_UPDATE_TIME_MS = 0L;
        DEFAULT_FEED_ID = 0L;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.f253628id = this.f253627id;
        r100.preview = this.preview;
        r100.feed_type = this.feed_type;
        r100.sort_key = this.sort_key;
        r100.badge_count = this.badge_count;
        r100.update_time = this.update_time;
        r100.is_topping = this.is_topping;
        r100.is_flag = this.is_flag;
        r100.is_remind = this.is_remind;
        r100.is_shortcut = this.is_shortcut;
        r100.on_top_rank_time = this.on_top_rank_time;
        r100.real_rank_time = this.real_rank_time;
        r100.update_time_ms = this.update_time_ms;
        r100.feed_id = this.feed_id;
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return LarkFeedListItem.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public LarkFeedListItem(String r110, FeedEntityPreview r111, FeedCard.FeedType r112, Long r210, Integer r211, Long r212, Boolean r213, Boolean r214, Boolean r215, Boolean r216, Long r217, Long r218, Long r219, Long r310) {
        this(r110, r111, r112, r210, r211, r212, r213, r214, r215, r216, r217, r218, r219, r310, ByteString.EMPTY);
    }

    public LarkFeedListItem(String r100, FeedEntityPreview r101, FeedCard.FeedType r102, Long r103, Integer r104, Long r105, Boolean r110, Boolean r111, Boolean r112, Boolean r113, Long r114, Long r115, Long r116, Long r117, ByteString r118) {
        super(ADAPTER, r118);
        this.f253627id = r100;
        this.preview = r101;
        this.feed_type = r102;
        this.sort_key = r103;
        this.badge_count = r104;
        this.update_time = r105;
        this.is_topping = r110;
        this.is_flag = r111;
        this.is_remind = r112;
        this.is_shortcut = r113;
        this.on_top_rank_time = r114;
        this.real_rank_time = r115;
        this.update_time_ms = r116;
        this.feed_id = r117;
    }
}
