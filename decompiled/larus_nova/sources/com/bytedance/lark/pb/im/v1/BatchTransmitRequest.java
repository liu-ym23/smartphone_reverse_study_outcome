package com.bytedance.lark.pb.im.v1;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import com.squareup.wire.internal.Internal;
import java.io.IOException;
import java.util.List;
import okio.ByteString;
import we6.c;
import we6.d;

/* JADX INFO: loaded from: classes20.dex */
public final class BatchTransmitRequest extends Message<BatchTransmitRequest, Builder> {
    public static final ProtoAdapter<BatchTransmitRequest> ADAPTER = null;
    public static final String DEFAULT_ORIGIN_MERGE_FORWARD_ID = "";
    public static final ProtoAdapter_BatchTransmitRequest RAW_TYPE_ADAPTER = null;
    private static final long serialVersionUID = 0;
    public final List<String> message_ids;
    public final String origin_merge_forward_id;
    public final List<TransmitTarget> targets;

    public static final class Builder extends Message.Builder<BatchTransmitRequest, Builder> implements d<BatchTransmitRequest> {
        public List<String> message_ids;
        public String origin_merge_forward_id;
        public List<TransmitTarget> targets;

        @Override // com.squareup.wire.Message.Builder
        public BatchTransmitRequest build() {
            return new BatchTransmitRequest(this.message_ids, this.targets, this.origin_merge_forward_id, super.buildUnknownFields());
        }

        public Builder() {
            this.message_ids = Internal.newMutableList();
            this.targets = Internal.newMutableList();
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder message_ids(List<String> r100) {
            Internal.checkElementsNotNull(r100);
            this.message_ids = r100;
            return this;
        }

        public Builder origin_merge_forward_id(String r100) {
            this.origin_merge_forward_id = r100;
            return this;
        }

        public Builder targets(List<TransmitTarget> r100) {
            Internal.checkElementsNotNull(r100);
            this.targets = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_BatchTransmitRequest extends ProtoAdapter<BatchTransmitRequest> implements c<BatchTransmitRequest> {
        public ProtoAdapter_BatchTransmitRequest() {
            super(FieldEncoding.LENGTH_DELIMITED, BatchTransmitRequest.class);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public BatchTransmitRequest decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            r101.origin_merge_forward_id = "";
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L15;
            if (r103 != 1) goto L8;
            r101.message_ids.add(ProtoAdapter.STRING.decode(r100));
            goto L3
        L8:
            if (r103 != 2) goto L10;
            r101.targets.add(TransmitTarget.ADAPTER.decode(r100));
            goto L3
        L10:
            if (r103 != 3) goto L11;
            r101.origin_merge_forward_id = ProtoAdapter.STRING.decode(r100);
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
        public int encodedSize2(BatchTransmitRequest r100) {
            ProtoAdapter<String> r101 = ProtoAdapter.STRING;
            int r102 = r101.asRepeated().encodedSizeWithTag(1, r100.message_ids) + TransmitTarget.ADAPTER.asRepeated().encodedSizeWithTag(2, r100.targets);
            String r103 = r100.origin_merge_forward_id;
            if (r103 == null) goto L5;
            int r104 = r101.encodedSizeWithTag(3, r103);
        L7:
            return (r102 + r104) + r100.unknownFields().size();
        L5:
            r104 = 0;
            goto L7
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ BatchTransmitRequest decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(BatchTransmitRequest r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, BatchTransmitRequest r101) throws IOException {
            ProtoAdapter<String> r102 = ProtoAdapter.STRING;
            r102.asRepeated().encodeWithTag(r100, 1, r101.message_ids);
            TransmitTarget.ADAPTER.asRepeated().encodeWithTag(r100, 2, r101.targets);
            String r103 = r101.origin_merge_forward_id;
            if (r103 == null) goto L5;
            r102.encodeWithTag(r100, 3, r103);
        L5:
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, BatchTransmitRequest r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ProtoAdapter_BatchTransmitRequest r100 = new ProtoAdapter_BatchTransmitRequest();
        RAW_TYPE_ADAPTER = r100;
        ADAPTER = r100;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.message_ids = Internal.copyOf("message_ids", this.message_ids);
        r100.targets = Internal.copyOf("targets", this.targets);
        r100.origin_merge_forward_id = this.origin_merge_forward_id;
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return BatchTransmitRequest.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public BatchTransmitRequest(List<String> r100, List<TransmitTarget> r101, String r102) {
        this(r100, r101, r102, ByteString.EMPTY);
    }

    public BatchTransmitRequest(List<String> r100, List<TransmitTarget> r101, String r102, ByteString r103) {
        super(ADAPTER, r103);
        this.message_ids = Internal.immutableCopyOf("message_ids", r100);
        this.targets = Internal.immutableCopyOf("targets", r101);
        this.origin_merge_forward_id = r102;
    }
}
