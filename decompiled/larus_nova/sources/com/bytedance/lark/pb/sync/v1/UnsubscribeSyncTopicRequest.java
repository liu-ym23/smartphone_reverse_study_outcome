package com.bytedance.lark.pb.sync.v1;

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
public final class UnsubscribeSyncTopicRequest extends Message<UnsubscribeSyncTopicRequest, Builder> {
    public static final ProtoAdapter<UnsubscribeSyncTopicRequest> ADAPTER = null;
    public static final String DEFAULT_TOPIC_ID = "";
    public static final ProtoAdapter_UnsubscribeSyncTopicRequest RAW_TYPE_ADAPTER = null;
    private static final long serialVersionUID = 0;
    public final SyncHeader header;
    public final String topic_id;

    public static final class Builder extends Message.Builder<UnsubscribeSyncTopicRequest, Builder> implements d<UnsubscribeSyncTopicRequest> {
        public SyncHeader header;
        public String topic_id;

        @Override // com.squareup.wire.Message.Builder
        public UnsubscribeSyncTopicRequest build() {
            SyncHeader r100 = this.header;
            if (r100 == null) goto L9;
            if (this.topic_id == null) goto L9;
            return new UnsubscribeSyncTopicRequest(this.header, this.topic_id, super.buildUnknownFields());
        L9:
            throw Internal.missingRequiredFields(new Object[]{r100, "header", this.topic_id, "topic_id"});
        }

        public Builder() {
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder header(SyncHeader r100) {
            this.header = r100;
            return this;
        }

        public Builder topic_id(String r100) {
            this.topic_id = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_UnsubscribeSyncTopicRequest extends ProtoAdapter<UnsubscribeSyncTopicRequest> implements c<UnsubscribeSyncTopicRequest> {
        public ProtoAdapter_UnsubscribeSyncTopicRequest() {
            super(FieldEncoding.LENGTH_DELIMITED, UnsubscribeSyncTopicRequest.class);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public UnsubscribeSyncTopicRequest decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            r101.topic_id = "";
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L12;
            if (r103 != 1) goto L8;
            r101.header = SyncHeader.ADAPTER.decode(r100);
            goto L3
        L8:
            if (r103 != 2) goto L9;
            r101.topic_id = ProtoAdapter.STRING.decode(r100);
            goto L3
        L9:
            FieldEncoding r104 = r100.peekFieldEncoding();
            r101.addUnknownField(r103, r104, r104.rawProtoAdapter().decode(r100));
            goto L3
        L12:
            r100.endMessage(r102);
            return r101.build();
        }

        /* JADX INFO: renamed from: encodedSize, reason: avoid collision after fix types in other method */
        public int encodedSize2(UnsubscribeSyncTopicRequest r100) {
            return (SyncHeader.ADAPTER.encodedSizeWithTag(1, r100.header) + ProtoAdapter.STRING.encodedSizeWithTag(2, r100.topic_id)) + r100.unknownFields().size();
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ UnsubscribeSyncTopicRequest decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(UnsubscribeSyncTopicRequest r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, UnsubscribeSyncTopicRequest r101) throws IOException {
            SyncHeader.ADAPTER.encodeWithTag(r100, 1, r101.header);
            ProtoAdapter.STRING.encodeWithTag(r100, 2, r101.topic_id);
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, UnsubscribeSyncTopicRequest r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ProtoAdapter_UnsubscribeSyncTopicRequest r100 = new ProtoAdapter_UnsubscribeSyncTopicRequest();
        RAW_TYPE_ADAPTER = r100;
        ADAPTER = r100;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.header = this.header;
        r100.topic_id = this.topic_id;
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return UnsubscribeSyncTopicRequest.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public UnsubscribeSyncTopicRequest(SyncHeader r100, String r101) {
        this(r100, r101, ByteString.EMPTY);
    }

    public UnsubscribeSyncTopicRequest(SyncHeader r100, String r101, ByteString r102) {
        super(ADAPTER, r102);
        this.header = r100;
        this.topic_id = r101;
    }
}
