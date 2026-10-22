package com.bytedance.lark.pb.knowledge_ai.v1;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import com.squareup.wire.internal.Internal;
import java.io.IOException;
import okio.ByteString;

/* JADX INFO: loaded from: classes20.dex */
public final class TopicListIndex extends Message<TopicListIndex, Builder> {
    public static final ProtoAdapter<TopicListIndex> ADAPTER = null;
    public static final Long DEFAULT_RANK_VALUE = null;
    public static final Long DEFAULT_TOPIC_ID = null;
    public static final Long DEFAULT_UPDATE_TIME_MS = null;
    private static final long serialVersionUID = 0;
    public final Long rank_value;
    public final Long topic_id;
    public final Long update_time_ms;

    public static final class Builder extends Message.Builder<TopicListIndex, Builder> {
        public Long rank_value;
        public Long topic_id;
        public Long update_time_ms;

        @Override // com.squareup.wire.Message.Builder
        public TopicListIndex build() {
            Long r100 = this.topic_id;
            if (r100 == null) goto L11;
            if (this.update_time_ms == null) goto L11;
            if (this.rank_value == null) goto L11;
            return new TopicListIndex(this.topic_id, this.update_time_ms, this.rank_value, super.buildUnknownFields());
        L11:
            throw Internal.missingRequiredFields(new Object[]{r100, "topic_id", this.update_time_ms, "update_time_ms", this.rank_value, "rank_value"});
        }

        public Builder() {
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder rank_value(Long r100) {
            this.rank_value = r100;
            return this;
        }

        public Builder topic_id(Long r100) {
            this.topic_id = r100;
            return this;
        }

        public Builder update_time_ms(Long r100) {
            this.update_time_ms = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_TopicListIndex extends ProtoAdapter<TopicListIndex> {
        public ProtoAdapter_TopicListIndex() {
            super(FieldEncoding.LENGTH_DELIMITED, TopicListIndex.class);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public TopicListIndex decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            r101.topic_id = 0L;
            r101.update_time_ms = 0L;
            r101.rank_value = 0L;
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L15;
            if (r103 != 1) goto L8;
            r101.topic_id = ProtoAdapter.INT64.decode(r100);
            goto L3
        L8:
            if (r103 != 2) goto L10;
            r101.update_time_ms = ProtoAdapter.INT64.decode(r100);
            goto L3
        L10:
            if (r103 != 3) goto L11;
            r101.rank_value = ProtoAdapter.INT64.decode(r100);
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
        public int encodedSize2(TopicListIndex r100) {
            ProtoAdapter<Long> r101 = ProtoAdapter.INT64;
            return ((r101.encodedSizeWithTag(1, r100.topic_id) + r101.encodedSizeWithTag(2, r100.update_time_ms)) + r101.encodedSizeWithTag(3, r100.rank_value)) + r100.unknownFields().size();
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ TopicListIndex decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(TopicListIndex r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, TopicListIndex r101) throws IOException {
            ProtoAdapter<Long> r102 = ProtoAdapter.INT64;
            r102.encodeWithTag(r100, 1, r101.topic_id);
            r102.encodeWithTag(r100, 2, r101.update_time_ms);
            r102.encodeWithTag(r100, 3, r101.rank_value);
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, TopicListIndex r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_TopicListIndex();
        DEFAULT_TOPIC_ID = 0L;
        DEFAULT_UPDATE_TIME_MS = 0L;
        DEFAULT_RANK_VALUE = 0L;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.topic_id = this.topic_id;
        r100.update_time_ms = this.update_time_ms;
        r100.rank_value = this.rank_value;
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return TopicListIndex.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public TopicListIndex(Long r100, Long r101, Long r102) {
        this(r100, r101, r102, ByteString.EMPTY);
    }

    public TopicListIndex(Long r100, Long r101, Long r102, ByteString r103) {
        super(ADAPTER, r103);
        this.topic_id = r100;
        this.update_time_ms = r101;
        this.rank_value = r102;
    }
}
