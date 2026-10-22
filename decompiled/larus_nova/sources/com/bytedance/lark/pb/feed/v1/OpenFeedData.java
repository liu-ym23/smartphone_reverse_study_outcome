package com.bytedance.lark.pb.feed.v1;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import com.squareup.wire.internal.Internal;
import java.io.IOException;
import okio.ByteString;

/* JADX INFO: loaded from: classes20.dex */
public final class OpenFeedData extends Message<OpenFeedData, Builder> {
    public static final ProtoAdapter<OpenFeedData> ADAPTER = null;
    public static final Integer DEFAULT_BADGE_COUNT = null;
    public static final ByteString DEFAULT_PREVIEW_DATA = null;
    public static final Integer DEFAULT_RANK_LEVEL = null;
    public static final Long DEFAULT_RANK_TIME = null;
    private static final long serialVersionUID = 0;
    public final Integer badge_count;
    public final OpenFeedExtraInfo extra_info;
    public final ByteString preview_data;
    public final Integer rank_level;
    public final Long rank_time;

    public static final class Builder extends Message.Builder<OpenFeedData, Builder> {
        public Integer badge_count;
        public OpenFeedExtraInfo extra_info;
        public ByteString preview_data;
        public Integer rank_level;
        public Long rank_time;

        @Override // com.squareup.wire.Message.Builder
        public OpenFeedData build() {
            Long r100 = this.rank_time;
            if (r100 == null) goto L13;
            if (this.badge_count == null) goto L13;
            if (this.rank_level == null) goto L13;
            if (this.preview_data == null) goto L13;
            return new OpenFeedData(this.rank_time, this.badge_count, this.rank_level, this.extra_info, this.preview_data, super.buildUnknownFields());
        L13:
            throw Internal.missingRequiredFields(new Object[]{r100, "rank_time", this.badge_count, "badge_count", this.rank_level, "rank_level", this.preview_data, "preview_data"});
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

        public Builder preview_data(ByteString r100) {
            this.preview_data = r100;
            return this;
        }

        public Builder rank_level(Integer r100) {
            this.rank_level = r100;
            return this;
        }

        public Builder rank_time(Long r100) {
            this.rank_time = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_OpenFeedData extends ProtoAdapter<OpenFeedData> {
        public ProtoAdapter_OpenFeedData() {
            super(FieldEncoding.LENGTH_DELIMITED, OpenFeedData.class);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public OpenFeedData decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            r101.rank_time = 0L;
            r101.badge_count = 0;
            r101.rank_level = 0;
            r101.preview_data = ByteString.EMPTY;
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L21;
            if (r103 != 1) goto L8;
            r101.rank_time = ProtoAdapter.INT64.decode(r100);
            goto L3
        L8:
            if (r103 != 2) goto L10;
            r101.badge_count = ProtoAdapter.INT32.decode(r100);
            goto L3
        L10:
            if (r103 != 3) goto L12;
            r101.rank_level = ProtoAdapter.INT32.decode(r100);
            goto L3
        L12:
            if (r103 != 4) goto L14;
            r101.extra_info = OpenFeedExtraInfo.ADAPTER.decode(r100);
            goto L3
        L14:
            if (r103 != 999) goto L15;
            r101.preview_data = ProtoAdapter.BYTES.decode(r100);
            goto L3
        L15:
            FieldEncoding r104 = r100.peekFieldEncoding();
            r101.addUnknownField(r103, r104, r104.rawProtoAdapter().decode(r100));
            goto L3
        L21:
            r100.endMessage(r102);
            return r101.build();
        }

        /* JADX INFO: renamed from: encodedSize, reason: avoid collision after fix types in other method */
        public int encodedSize2(OpenFeedData r100) {
            int r101 = ProtoAdapter.INT64.encodedSizeWithTag(1, r100.rank_time);
            ProtoAdapter<Integer> r102 = ProtoAdapter.INT32;
            int r103 = (r101 + r102.encodedSizeWithTag(2, r100.badge_count)) + r102.encodedSizeWithTag(3, r100.rank_level);
            OpenFeedExtraInfo r104 = r100.extra_info;
            if (r104 == null) goto L5;
            int r105 = OpenFeedExtraInfo.ADAPTER.encodedSizeWithTag(4, r104);
        L7:
            return ((r103 + r105) + ProtoAdapter.BYTES.encodedSizeWithTag(999, r100.preview_data)) + r100.unknownFields().size();
        L5:
            r105 = 0;
            goto L7
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ OpenFeedData decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(OpenFeedData r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, OpenFeedData r101) throws IOException {
            ProtoAdapter.INT64.encodeWithTag(r100, 1, r101.rank_time);
            ProtoAdapter<Integer> r102 = ProtoAdapter.INT32;
            r102.encodeWithTag(r100, 2, r101.badge_count);
            r102.encodeWithTag(r100, 3, r101.rank_level);
            OpenFeedExtraInfo r103 = r101.extra_info;
            if (r103 == null) goto L5;
            OpenFeedExtraInfo.ADAPTER.encodeWithTag(r100, 4, r103);
        L5:
            ProtoAdapter.BYTES.encodeWithTag(r100, 999, r101.preview_data);
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, OpenFeedData r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_OpenFeedData();
        DEFAULT_RANK_TIME = 0L;
        DEFAULT_BADGE_COUNT = 0;
        DEFAULT_RANK_LEVEL = 0;
        DEFAULT_PREVIEW_DATA = ByteString.EMPTY;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.rank_time = this.rank_time;
        r100.badge_count = this.badge_count;
        r100.rank_level = this.rank_level;
        r100.extra_info = this.extra_info;
        r100.preview_data = this.preview_data;
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return OpenFeedData.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public OpenFeedData(Long r100, Integer r101, Integer r110, OpenFeedExtraInfo r111, ByteString r112) {
        this(r100, r101, r110, r111, r112, ByteString.EMPTY);
    }

    public OpenFeedData(Long r100, Integer r101, Integer r102, OpenFeedExtraInfo r103, ByteString r104, ByteString r105) {
        super(ADAPTER, r105);
        this.rank_time = r100;
        this.badge_count = r101;
        this.rank_level = r102;
        this.extra_info = r103;
        this.preview_data = r104;
    }
}
