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
public final class SubscribeTopicRequest extends Message<SubscribeTopicRequest, Builder> {
    public static final ProtoAdapter<SubscribeTopicRequest> ADAPTER = null;
    public static final String DEFAULT_TOPIC_ID = "";
    public static final ProtoAdapter_SubscribeTopicRequest RAW_TYPE_ADAPTER = null;
    private static final long serialVersionUID = 0;
    public final SyncHeader header;
    public final SubOptions options;
    public final String topic_id;

    public static final class Builder extends Message.Builder<SubscribeTopicRequest, Builder> implements d<SubscribeTopicRequest> {
        public SyncHeader header;
        public SubOptions options;
        public String topic_id;

        @Override // com.squareup.wire.Message.Builder
        public SubscribeTopicRequest build() {
            SyncHeader r100 = this.header;
            if (r100 == null) goto L9;
            if (this.topic_id == null) goto L9;
            return new SubscribeTopicRequest(this.header, this.topic_id, this.options, super.buildUnknownFields());
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

        public Builder options(SubOptions r100) {
            this.options = r100;
            return this;
        }

        public Builder topic_id(String r100) {
            this.topic_id = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_SubscribeTopicRequest extends ProtoAdapter<SubscribeTopicRequest> implements c<SubscribeTopicRequest> {
        public ProtoAdapter_SubscribeTopicRequest() {
            super(FieldEncoding.LENGTH_DELIMITED, SubscribeTopicRequest.class);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public SubscribeTopicRequest decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            r101.topic_id = "";
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L15;
            if (r103 != 1) goto L8;
            r101.header = SyncHeader.ADAPTER.decode(r100);
            goto L3
        L8:
            if (r103 != 2) goto L10;
            r101.topic_id = ProtoAdapter.STRING.decode(r100);
            goto L3
        L10:
            if (r103 != 3) goto L11;
            r101.options = SubOptions.ADAPTER.decode(r100);
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
        public int encodedSize2(SubscribeTopicRequest r100) {
            int r101 = SyncHeader.ADAPTER.encodedSizeWithTag(1, r100.header) + ProtoAdapter.STRING.encodedSizeWithTag(2, r100.topic_id);
            SubOptions r102 = r100.options;
            if (r102 == null) goto L5;
            int r103 = SubOptions.ADAPTER.encodedSizeWithTag(3, r102);
        L7:
            return (r101 + r103) + r100.unknownFields().size();
        L5:
            r103 = 0;
            goto L7
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ SubscribeTopicRequest decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(SubscribeTopicRequest r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, SubscribeTopicRequest r101) throws IOException {
            SyncHeader.ADAPTER.encodeWithTag(r100, 1, r101.header);
            ProtoAdapter.STRING.encodeWithTag(r100, 2, r101.topic_id);
            SubOptions r102 = r101.options;
            if (r102 == null) goto L5;
            SubOptions.ADAPTER.encodeWithTag(r100, 3, r102);
        L5:
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, SubscribeTopicRequest r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ProtoAdapter_SubscribeTopicRequest r100 = new ProtoAdapter_SubscribeTopicRequest();
        RAW_TYPE_ADAPTER = r100;
        ADAPTER = r100;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.header = this.header;
        r100.topic_id = this.topic_id;
        r100.options = this.options;
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return SubscribeTopicRequest.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public SubscribeTopicRequest(SyncHeader r100, String r101, SubOptions r102) {
        this(r100, r101, r102, ByteString.EMPTY);
    }

    public SubscribeTopicRequest(SyncHeader r100, String r101, SubOptions r102, ByteString r103) {
        super(ADAPTER, r103);
        this.header = r100;
        this.topic_id = r101;
        this.options = r102;
    }
}
