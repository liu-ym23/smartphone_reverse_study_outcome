package com.bytedance.lark.pb.feed.v1;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import java.io.IOException;
import okio.ByteString;

/* JADX INFO: loaded from: classes20.dex */
public final class FilterPushInfo extends Message<FilterPushInfo, Builder> {
    public static final ProtoAdapter<FilterPushInfo> ADAPTER = null;
    public static final Integer DEFAULT_MUTE_UNREAD = null;
    public static final Integer DEFAULT_ON_TOP_BADGE_COUNT = null;
    public static final Integer DEFAULT_UNREAD = null;
    private static final long serialVersionUID = 0;
    public final Integer mute_unread;
    public final Integer on_top_badge_count;
    public final Integer unread;

    public static final class Builder extends Message.Builder<FilterPushInfo, Builder> {
        public Integer mute_unread;
        public Integer on_top_badge_count;
        public Integer unread;

        @Override // com.squareup.wire.Message.Builder
        public FilterPushInfo build() {
            return new FilterPushInfo(this.unread, this.mute_unread, this.on_top_badge_count, super.buildUnknownFields());
        }

        public Builder() {
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder mute_unread(Integer r100) {
            this.mute_unread = r100;
            return this;
        }

        public Builder on_top_badge_count(Integer r100) {
            this.on_top_badge_count = r100;
            return this;
        }

        public Builder unread(Integer r100) {
            this.unread = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_FilterPushInfo extends ProtoAdapter<FilterPushInfo> {
        public ProtoAdapter_FilterPushInfo() {
            super(FieldEncoding.LENGTH_DELIMITED, FilterPushInfo.class);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public FilterPushInfo decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            r101.unread = 0;
            r101.mute_unread = 0;
            r101.on_top_badge_count = 0;
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L15;
            if (r103 != 1) goto L8;
            r101.unread = ProtoAdapter.INT32.decode(r100);
            goto L3
        L8:
            if (r103 != 2) goto L10;
            r101.mute_unread = ProtoAdapter.INT32.decode(r100);
            goto L3
        L10:
            if (r103 != 3) goto L11;
            r101.on_top_badge_count = ProtoAdapter.INT32.decode(r100);
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
        public int encodedSize2(FilterPushInfo r100) {
            Integer r101 = r100.unread;
            int r102 = 0;
            if (r101 == null) goto L5;
            int r103 = ProtoAdapter.INT32.encodedSizeWithTag(1, r101);
        L6:
            Integer r104 = r100.mute_unread;
            if (r104 == null) goto L9;
            int r105 = ProtoAdapter.INT32.encodedSizeWithTag(2, r104);
        L10:
            int r106 = r103 + r105;
            Integer r107 = r100.on_top_badge_count;
            if (r107 == null) goto L14;
            r102 = ProtoAdapter.INT32.encodedSizeWithTag(3, r107);
        L14:
            return (r106 + r102) + r100.unknownFields().size();
        L9:
            r105 = 0;
            goto L10
        L5:
            r103 = 0;
            goto L6
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ FilterPushInfo decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(FilterPushInfo r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, FilterPushInfo r101) throws IOException {
            Integer r102 = r101.unread;
            if (r102 == null) goto L5;
            ProtoAdapter.INT32.encodeWithTag(r100, 1, r102);
        L5:
            Integer r103 = r101.mute_unread;
            if (r103 == null) goto L8;
            ProtoAdapter.INT32.encodeWithTag(r100, 2, r103);
        L8:
            Integer r104 = r101.on_top_badge_count;
            if (r104 == null) goto L11;
            ProtoAdapter.INT32.encodeWithTag(r100, 3, r104);
        L11:
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, FilterPushInfo r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_FilterPushInfo();
        DEFAULT_UNREAD = 0;
        DEFAULT_MUTE_UNREAD = 0;
        DEFAULT_ON_TOP_BADGE_COUNT = 0;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.unread = this.unread;
        r100.mute_unread = this.mute_unread;
        r100.on_top_badge_count = this.on_top_badge_count;
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return FilterPushInfo.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public FilterPushInfo(Integer r100, Integer r101, Integer r102) {
        this(r100, r101, r102, ByteString.EMPTY);
    }

    public FilterPushInfo(Integer r100, Integer r101, Integer r102, ByteString r103) {
        super(ADAPTER, r103);
        this.unread = r100;
        this.mute_unread = r101;
        this.on_top_badge_count = r102;
    }
}
