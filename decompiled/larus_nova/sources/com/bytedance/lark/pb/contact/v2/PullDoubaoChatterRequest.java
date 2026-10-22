package com.bytedance.lark.pb.contact.v2;

import com.bytedance.lark.pb.basic.v1.SyncDataStrategy;
import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import java.io.IOException;
import okio.ByteString;
import we6.c;
import we6.d;

/* JADX INFO: loaded from: classes20.dex */
public final class PullDoubaoChatterRequest extends Message<PullDoubaoChatterRequest, Builder> {
    public static final ProtoAdapter<PullDoubaoChatterRequest> ADAPTER = null;
    public static final SyncDataStrategy DEFAULT_SYNC_DATA_STRATEGY = null;
    public static final ProtoAdapter_PullDoubaoChatterRequest RAW_TYPE_ADAPTER = null;
    private static final long serialVersionUID = 0;
    public final SyncDataStrategy sync_data_strategy;

    public static final class Builder extends Message.Builder<PullDoubaoChatterRequest, Builder> implements d<PullDoubaoChatterRequest> {
        public SyncDataStrategy sync_data_strategy;

        @Override // com.squareup.wire.Message.Builder
        public PullDoubaoChatterRequest build() {
            return new PullDoubaoChatterRequest(this.sync_data_strategy, super.buildUnknownFields());
        }

        public Builder() {
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder sync_data_strategy(SyncDataStrategy r100) {
            this.sync_data_strategy = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_PullDoubaoChatterRequest extends ProtoAdapter<PullDoubaoChatterRequest> implements c<PullDoubaoChatterRequest> {
        public ProtoAdapter_PullDoubaoChatterRequest() {
            super(FieldEncoding.LENGTH_DELIMITED, PullDoubaoChatterRequest.class);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public PullDoubaoChatterRequest decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            r101.sync_data_strategy = SyncDataStrategy.LOCAL;
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L12;
            if (r103 != 2) goto L7;
            r101.sync_data_strategy = SyncDataStrategy.ADAPTER.decode(r100);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L10
        L10:
            e = move-exception;
            r101.addUnknownField(r103, FieldEncoding.VARINT, Long.valueOf(e.value));
            goto L3
        L7:
            FieldEncoding r104 = r100.peekFieldEncoding();
            r101.addUnknownField(r103, r104, r104.rawProtoAdapter().decode(r100));
            goto L3
        L12:
            r100.endMessage(r102);
            return r101.build();
        }

        /* JADX INFO: renamed from: encodedSize, reason: avoid collision after fix types in other method */
        public int encodedSize2(PullDoubaoChatterRequest r100) {
            SyncDataStrategy r101 = r100.sync_data_strategy;
            if (r101 == null) goto L5;
            int r102 = SyncDataStrategy.ADAPTER.encodedSizeWithTag(2, r101);
        L7:
            return r102 + r100.unknownFields().size();
        L5:
            r102 = 0;
            goto L7
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ PullDoubaoChatterRequest decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(PullDoubaoChatterRequest r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, PullDoubaoChatterRequest r101) throws IOException {
            SyncDataStrategy r102 = r101.sync_data_strategy;
            if (r102 == null) goto L5;
            SyncDataStrategy.ADAPTER.encodeWithTag(r100, 2, r102);
        L5:
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, PullDoubaoChatterRequest r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ProtoAdapter_PullDoubaoChatterRequest r100 = new ProtoAdapter_PullDoubaoChatterRequest();
        RAW_TYPE_ADAPTER = r100;
        ADAPTER = r100;
        DEFAULT_SYNC_DATA_STRATEGY = SyncDataStrategy.LOCAL;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.sync_data_strategy = this.sync_data_strategy;
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return PullDoubaoChatterRequest.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public PullDoubaoChatterRequest(SyncDataStrategy r100) {
        this(r100, ByteString.EMPTY);
    }

    public PullDoubaoChatterRequest(SyncDataStrategy r100, ByteString r101) {
        super(ADAPTER, r101);
        this.sync_data_strategy = r100;
    }
}
