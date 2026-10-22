package com.bytedance.lark.pb.feed.v1;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import com.squareup.wire.internal.Internal;
import java.io.IOException;
import java.util.Map;
import okio.ByteString;
import we6.c;
import we6.d;

/* JADX INFO: loaded from: classes20.dex */
public final class PushFeedEntity extends Message<PushFeedEntity, Builder> {
    public static final ProtoAdapter<PushFeedEntity> ADAPTER = null;
    public static final ProtoAdapter_PushFeedEntity RAW_TYPE_ADAPTER = null;
    private static final long serialVersionUID = 0;
    public final Map<Long, FilterPushInfo> badges;
    public final FeedEntity entity;
    public final FilterPushInfo inbox_badge;
    public final Map<Long, Long> subscription_versions;

    public static final class Builder extends Message.Builder<PushFeedEntity, Builder> implements d<PushFeedEntity> {
        public Map<Long, FilterPushInfo> badges;
        public FeedEntity entity;
        public FilterPushInfo inbox_badge;
        public Map<Long, Long> subscription_versions;

        @Override // com.squareup.wire.Message.Builder
        public PushFeedEntity build() {
            return new PushFeedEntity(this.entity, this.subscription_versions, this.badges, this.inbox_badge, super.buildUnknownFields());
        }

        public Builder() {
            this.subscription_versions = Internal.newMutableMap();
            this.badges = Internal.newMutableMap();
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder badges(Map<Long, FilterPushInfo> r100) {
            Internal.checkElementsNotNull(r100);
            this.badges = r100;
            return this;
        }

        public Builder entity(FeedEntity r100) {
            this.entity = r100;
            return this;
        }

        public Builder inbox_badge(FilterPushInfo r100) {
            this.inbox_badge = r100;
            return this;
        }

        public Builder subscription_versions(Map<Long, Long> r100) {
            Internal.checkElementsNotNull(r100);
            this.subscription_versions = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_PushFeedEntity extends ProtoAdapter<PushFeedEntity> implements c<PushFeedEntity> {
        private final ProtoAdapter<Map<Long, FilterPushInfo>> badges;
        private final ProtoAdapter<Map<Long, Long>> subscription_versions;

        public ProtoAdapter_PushFeedEntity() {
            super(FieldEncoding.LENGTH_DELIMITED, PushFeedEntity.class);
            ProtoAdapter<Long> r100 = ProtoAdapter.INT64;
            this.subscription_versions = ProtoAdapter.newMapAdapter(r100, r100);
            this.badges = ProtoAdapter.newMapAdapter(r100, FilterPushInfo.ADAPTER);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public PushFeedEntity decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L18;
            if (r103 != 1) goto L8;
            r101.entity = FeedEntity.ADAPTER.decode(r100);
            goto L3
        L8:
            if (r103 != 2) goto L10;
            r101.subscription_versions.putAll(this.subscription_versions.decode(r100));
            goto L3
        L10:
            if (r103 != 3) goto L12;
            r101.badges.putAll(this.badges.decode(r100));
            goto L3
        L12:
            if (r103 != 4) goto L13;
            r101.inbox_badge = FilterPushInfo.ADAPTER.decode(r100);
            goto L3
        L13:
            FieldEncoding r104 = r100.peekFieldEncoding();
            r101.addUnknownField(r103, r104, r104.rawProtoAdapter().decode(r100));
            goto L3
        L18:
            r100.endMessage(r102);
            return r101.build();
        }

        /* JADX INFO: renamed from: encodedSize, reason: avoid collision after fix types in other method */
        public int encodedSize2(PushFeedEntity r100) {
            FeedEntity r101 = r100.entity;
            int r102 = 0;
            if (r101 == null) goto L5;
            int r103 = FeedEntity.ADAPTER.encodedSizeWithTag(1, r101);
        L6:
            int r104 = (r103 + this.subscription_versions.encodedSizeWithTag(2, r100.subscription_versions)) + this.badges.encodedSizeWithTag(3, r100.badges);
            FilterPushInfo r105 = r100.inbox_badge;
            if (r105 == null) goto L10;
            r102 = FilterPushInfo.ADAPTER.encodedSizeWithTag(4, r105);
        L10:
            return (r104 + r102) + r100.unknownFields().size();
        L5:
            r103 = 0;
            goto L6
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ PushFeedEntity decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(PushFeedEntity r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, PushFeedEntity r101) throws IOException {
            FeedEntity r102 = r101.entity;
            if (r102 == null) goto L5;
            FeedEntity.ADAPTER.encodeWithTag(r100, 1, r102);
        L5:
            this.subscription_versions.encodeWithTag(r100, 2, r101.subscription_versions);
            this.badges.encodeWithTag(r100, 3, r101.badges);
            FilterPushInfo r103 = r101.inbox_badge;
            if (r103 == null) goto L8;
            FilterPushInfo.ADAPTER.encodeWithTag(r100, 4, r103);
        L8:
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, PushFeedEntity r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ProtoAdapter_PushFeedEntity r100 = new ProtoAdapter_PushFeedEntity();
        RAW_TYPE_ADAPTER = r100;
        ADAPTER = r100;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.entity = this.entity;
        r100.subscription_versions = Internal.copyOf("subscription_versions", this.subscription_versions);
        r100.badges = Internal.copyOf("badges", this.badges);
        r100.inbox_badge = this.inbox_badge;
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return PushFeedEntity.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public PushFeedEntity(FeedEntity r100, Map<Long, Long> r101, Map<Long, FilterPushInfo> r102, FilterPushInfo r110) {
        this(r100, r101, r102, r110, ByteString.EMPTY);
    }

    public PushFeedEntity(FeedEntity r100, Map<Long, Long> r101, Map<Long, FilterPushInfo> r102, FilterPushInfo r103, ByteString r104) {
        super(ADAPTER, r104);
        this.entity = r100;
        this.subscription_versions = Internal.immutableCopyOf("subscription_versions", r101);
        this.badges = Internal.immutableCopyOf("badges", r102);
        this.inbox_badge = r103;
    }
}
