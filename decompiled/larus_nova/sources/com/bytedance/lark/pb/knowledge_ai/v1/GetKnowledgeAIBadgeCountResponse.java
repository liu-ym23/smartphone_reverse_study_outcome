package com.bytedance.lark.pb.knowledge_ai.v1;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import com.squareup.wire.internal.Internal;
import java.io.IOException;
import okio.ByteString;
import we6.c;
import we6.d;

/* JADX INFO: loaded from: classes20.dex */
public final class GetKnowledgeAIBadgeCountResponse extends Message<GetKnowledgeAIBadgeCountResponse, Builder> {
    public static final ProtoAdapter<GetKnowledgeAIBadgeCountResponse> ADAPTER = null;
    public static final Long DEFAULT_BADGE_COUNT = null;
    public static final Long DEFAULT_VERSION = null;
    public static final ProtoAdapter_GetKnowledgeAIBadgeCountResponse RAW_TYPE_ADAPTER = null;
    private static final long serialVersionUID = 0;
    public final Long badge_count;
    public final TopicListIndex latest_streaming_topic;
    public final TopicListIndex latest_unread_topic;
    public final Long version;

    public static final class Builder extends Message.Builder<GetKnowledgeAIBadgeCountResponse, Builder> implements d<GetKnowledgeAIBadgeCountResponse> {
        public Long badge_count;
        public TopicListIndex latest_streaming_topic;
        public TopicListIndex latest_unread_topic;
        public Long version;

        @Override // com.squareup.wire.Message.Builder
        public GetKnowledgeAIBadgeCountResponse build() {
            Long r100 = this.badge_count;
            if (r100 == null) goto L9;
            if (this.version == null) goto L9;
            return new GetKnowledgeAIBadgeCountResponse(this.badge_count, this.latest_unread_topic, this.latest_streaming_topic, this.version, super.buildUnknownFields());
        L9:
            throw Internal.missingRequiredFields(new Object[]{r100, "badge_count", this.version, "version"});
        }

        public Builder() {
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder badge_count(Long r100) {
            this.badge_count = r100;
            return this;
        }

        public Builder latest_streaming_topic(TopicListIndex r100) {
            this.latest_streaming_topic = r100;
            return this;
        }

        public Builder latest_unread_topic(TopicListIndex r100) {
            this.latest_unread_topic = r100;
            return this;
        }

        public Builder version(Long r100) {
            this.version = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_GetKnowledgeAIBadgeCountResponse extends ProtoAdapter<GetKnowledgeAIBadgeCountResponse> implements c<GetKnowledgeAIBadgeCountResponse> {
        public ProtoAdapter_GetKnowledgeAIBadgeCountResponse() {
            super(FieldEncoding.LENGTH_DELIMITED, GetKnowledgeAIBadgeCountResponse.class);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public GetKnowledgeAIBadgeCountResponse decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            r101.badge_count = 0L;
            r101.version = 0L;
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L18;
            if (r103 != 1) goto L8;
            r101.badge_count = ProtoAdapter.INT64.decode(r100);
            goto L3
        L8:
            if (r103 != 2) goto L10;
            r101.latest_unread_topic = TopicListIndex.ADAPTER.decode(r100);
            goto L3
        L10:
            if (r103 != 3) goto L12;
            r101.latest_streaming_topic = TopicListIndex.ADAPTER.decode(r100);
            goto L3
        L12:
            if (r103 != 4) goto L13;
            r101.version = ProtoAdapter.INT64.decode(r100);
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
        public int encodedSize2(GetKnowledgeAIBadgeCountResponse r100) {
            ProtoAdapter<Long> r101 = ProtoAdapter.INT64;
            int r102 = r101.encodedSizeWithTag(1, r100.badge_count);
            TopicListIndex r103 = r100.latest_unread_topic;
            int r104 = 0;
            if (r103 == null) goto L5;
            int r105 = TopicListIndex.ADAPTER.encodedSizeWithTag(2, r103);
        L6:
            int r106 = r102 + r105;
            TopicListIndex r107 = r100.latest_streaming_topic;
            if (r107 == null) goto L10;
            r104 = TopicListIndex.ADAPTER.encodedSizeWithTag(3, r107);
        L10:
            return ((r106 + r104) + r101.encodedSizeWithTag(4, r100.version)) + r100.unknownFields().size();
        L5:
            r105 = 0;
            goto L6
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ GetKnowledgeAIBadgeCountResponse decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(GetKnowledgeAIBadgeCountResponse r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, GetKnowledgeAIBadgeCountResponse r101) throws IOException {
            ProtoAdapter<Long> r102 = ProtoAdapter.INT64;
            r102.encodeWithTag(r100, 1, r101.badge_count);
            TopicListIndex r103 = r101.latest_unread_topic;
            if (r103 == null) goto L5;
            TopicListIndex.ADAPTER.encodeWithTag(r100, 2, r103);
        L5:
            TopicListIndex r104 = r101.latest_streaming_topic;
            if (r104 == null) goto L8;
            TopicListIndex.ADAPTER.encodeWithTag(r100, 3, r104);
        L8:
            r102.encodeWithTag(r100, 4, r101.version);
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, GetKnowledgeAIBadgeCountResponse r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ProtoAdapter_GetKnowledgeAIBadgeCountResponse r100 = new ProtoAdapter_GetKnowledgeAIBadgeCountResponse();
        RAW_TYPE_ADAPTER = r100;
        ADAPTER = r100;
        DEFAULT_BADGE_COUNT = 0L;
        DEFAULT_VERSION = 0L;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.badge_count = this.badge_count;
        r100.latest_unread_topic = this.latest_unread_topic;
        r100.latest_streaming_topic = this.latest_streaming_topic;
        r100.version = this.version;
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return GetKnowledgeAIBadgeCountResponse.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public GetKnowledgeAIBadgeCountResponse(Long r100, TopicListIndex r101, TopicListIndex r102, Long r110) {
        this(r100, r101, r102, r110, ByteString.EMPTY);
    }

    public GetKnowledgeAIBadgeCountResponse(Long r100, TopicListIndex r101, TopicListIndex r102, Long r103, ByteString r104) {
        super(ADAPTER, r104);
        this.badge_count = r100;
        this.latest_unread_topic = r101;
        this.latest_streaming_topic = r102;
        this.version = r103;
    }
}
