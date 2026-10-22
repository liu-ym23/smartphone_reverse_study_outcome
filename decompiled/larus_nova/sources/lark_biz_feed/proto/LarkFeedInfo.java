package lark_biz_feed.proto;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import com.squareup.wire.internal.Internal;
import java.io.IOException;
import okio.ByteString;

/* JADX INFO: loaded from: classes42.dex */
public final class LarkFeedInfo extends Message<LarkFeedInfo, Builder> {
    public static final ProtoAdapter<LarkFeedInfo> ADAPTER = null;
    public static final Integer DEFAULT_BADGE_COUNT = null;
    public static final Integer DEFAULT_BADGE_COUNT_WITHOUT_DOUBAO = null;
    public static final ByteString DEFAULT_LATEST_PREVIEW = null;
    public static final Integer DEFAULT_MESSAGE_ON_TOP_BADGE_COUNT = null;
    public static final Integer DEFAULT_MESSAGE_WITHOUT_DOUBAO_ON_TOP_BADGE_COUNT = null;
    public static final Long DEFAULT_RANK_TIME_MS = null;
    public static final Long DEFAULT_VERSION = null;
    private static final long serialVersionUID = 0;
    public final Integer badge_count;
    public final Integer badge_count_without_doubao;
    public final ByteString latest_preview;
    public final Integer message_on_top_badge_count;
    public final Integer message_without_doubao_on_top_badge_count;
    public final Long rank_time_ms;
    public final Long version;

    public static final class Builder extends Message.Builder<LarkFeedInfo, Builder> {
        public Integer badge_count;
        public Integer badge_count_without_doubao;
        public ByteString latest_preview;
        public Integer message_on_top_badge_count;
        public Integer message_without_doubao_on_top_badge_count;
        public Long rank_time_ms;
        public Long version;

        @Override // com.squareup.wire.Message.Builder
        public LarkFeedInfo build() {
            Integer r100 = this.badge_count;
            if (r100 == null) goto L17;
            if (this.rank_time_ms == null) goto L17;
            if (this.version == null) goto L17;
            if (this.badge_count_without_doubao == null) goto L17;
            if (this.message_on_top_badge_count == null) goto L17;
            if (this.message_without_doubao_on_top_badge_count == null) goto L17;
            return new LarkFeedInfo(this.badge_count, this.latest_preview, this.rank_time_ms, this.version, this.badge_count_without_doubao, this.message_on_top_badge_count, this.message_without_doubao_on_top_badge_count, super.buildUnknownFields());
        L17:
            throw Internal.missingRequiredFields(new Object[]{r100, "badge_count", this.rank_time_ms, "rank_time_ms", this.version, "version", this.badge_count_without_doubao, "badge_count_without_doubao", this.message_on_top_badge_count, "message_on_top_badge_count", this.message_without_doubao_on_top_badge_count, "message_without_doubao_on_top_badge_count"});
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

        public Builder badge_count_without_doubao(Integer r100) {
            this.badge_count_without_doubao = r100;
            return this;
        }

        public Builder latest_preview(ByteString r100) {
            this.latest_preview = r100;
            return this;
        }

        public Builder message_on_top_badge_count(Integer r100) {
            this.message_on_top_badge_count = r100;
            return this;
        }

        public Builder message_without_doubao_on_top_badge_count(Integer r100) {
            this.message_without_doubao_on_top_badge_count = r100;
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

    public static final class ProtoAdapter_LarkFeedInfo extends ProtoAdapter<LarkFeedInfo> {
        public ProtoAdapter_LarkFeedInfo() {
            super(FieldEncoding.LENGTH_DELIMITED, LarkFeedInfo.class);
        }

        @Override // com.squareup.wire.ProtoAdapter
        /* JADX INFO: renamed from: decode, reason: avoid collision after fix types in other method */
        public LarkFeedInfo decode2(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L14;
            switch(r103) {
                case 1: goto L13;
                case 2: goto L12;
                case 3: goto L11;
                case 4: goto L10;
                case 5: goto L9;
                case 6: goto L8;
                case 7: goto L7;
                default: goto L6;
            };
        L7:
            r101.message_without_doubao_on_top_badge_count = ProtoAdapter.INT32.decode(r100);
            goto L3
        L8:
            r101.message_on_top_badge_count = ProtoAdapter.INT32.decode(r100);
            goto L3
        L9:
            r101.badge_count_without_doubao = ProtoAdapter.INT32.decode(r100);
            goto L3
        L10:
            r101.version = ProtoAdapter.INT64.decode(r100);
            goto L3
        L11:
            r101.rank_time_ms = ProtoAdapter.INT64.decode(r100);
            goto L3
        L12:
            r101.latest_preview = ProtoAdapter.BYTES.decode(r100);
            goto L3
        L13:
            r101.badge_count = ProtoAdapter.INT32.decode(r100);
            goto L3
        L6:
            FieldEncoding r104 = r100.peekFieldEncoding();
            r101.addUnknownField(r103, r104, r104.rawProtoAdapter().decode(r100));
            goto L3
        L14:
            r100.endMessage(r102);
            return r101.build();
        }

        /* JADX INFO: renamed from: encodedSize, reason: avoid collision after fix types in other method */
        public int encodedSize2(LarkFeedInfo r100) {
            ProtoAdapter<Integer> r101 = ProtoAdapter.INT32;
            int r102 = r101.encodedSizeWithTag(1, r100.badge_count);
            ByteString r103 = r100.latest_preview;
            if (r103 == null) goto L5;
            int r104 = ProtoAdapter.BYTES.encodedSizeWithTag(2, r103);
        L6:
            int r105 = r102 + r104;
            ProtoAdapter<Long> r106 = ProtoAdapter.INT64;
            return (((((r105 + r106.encodedSizeWithTag(3, r100.rank_time_ms)) + r106.encodedSizeWithTag(4, r100.version)) + r101.encodedSizeWithTag(5, r100.badge_count_without_doubao)) + r101.encodedSizeWithTag(6, r100.message_on_top_badge_count)) + r101.encodedSizeWithTag(7, r100.message_without_doubao_on_top_badge_count)) + r100.unknownFields().size();
        L5:
            r104 = 0;
            goto L6
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ LarkFeedInfo decode(ProtoReader r100) throws IOException {
            return decode2(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(LarkFeedInfo r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, LarkFeedInfo r101) throws IOException {
            ProtoAdapter<Integer> r102 = ProtoAdapter.INT32;
            r102.encodeWithTag(r100, 1, r101.badge_count);
            ByteString r103 = r101.latest_preview;
            if (r103 == null) goto L5;
            ProtoAdapter.BYTES.encodeWithTag(r100, 2, r103);
        L5:
            ProtoAdapter<Long> r104 = ProtoAdapter.INT64;
            r104.encodeWithTag(r100, 3, r101.rank_time_ms);
            r104.encodeWithTag(r100, 4, r101.version);
            r102.encodeWithTag(r100, 5, r101.badge_count_without_doubao);
            r102.encodeWithTag(r100, 6, r101.message_on_top_badge_count);
            r102.encodeWithTag(r100, 7, r101.message_without_doubao_on_top_badge_count);
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, LarkFeedInfo r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_LarkFeedInfo();
        DEFAULT_BADGE_COUNT = 0;
        DEFAULT_LATEST_PREVIEW = ByteString.EMPTY;
        DEFAULT_RANK_TIME_MS = 0L;
        DEFAULT_VERSION = 0L;
        DEFAULT_BADGE_COUNT_WITHOUT_DOUBAO = 0;
        DEFAULT_MESSAGE_ON_TOP_BADGE_COUNT = 0;
        DEFAULT_MESSAGE_WITHOUT_DOUBAO_ON_TOP_BADGE_COUNT = 0;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.badge_count = this.badge_count;
        r100.latest_preview = this.latest_preview;
        r100.rank_time_ms = this.rank_time_ms;
        r100.version = this.version;
        r100.badge_count_without_doubao = this.badge_count_without_doubao;
        r100.message_on_top_badge_count = this.message_on_top_badge_count;
        r100.message_without_doubao_on_top_badge_count = this.message_without_doubao_on_top_badge_count;
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return LarkFeedInfo.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public LarkFeedInfo(Integer r110, ByteString r111, Long r112, Long r113, Integer r114, Integer r115, Integer r116) {
        this(r110, r111, r112, r113, r114, r115, r116, ByteString.EMPTY);
    }

    public LarkFeedInfo(Integer r100, ByteString r101, Long r102, Long r103, Integer r104, Integer r105, Integer r106, ByteString r107) {
        super(ADAPTER, r107);
        this.badge_count = r100;
        this.latest_preview = r101;
        this.rank_time_ms = r102;
        this.version = r103;
        this.badge_count_without_doubao = r104;
        this.message_on_top_badge_count = r105;
        this.message_without_doubao_on_top_badge_count = r106;
    }
}
