package com.bytedance.lark.pb.url.v1;

import com.bytedance.lark.pb.basic.v1.SyncDataStrategy;
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
public final class MGetUrlPreviewRequest extends Message<MGetUrlPreviewRequest, Builder> {
    public static final ProtoAdapter<MGetUrlPreviewRequest> ADAPTER = null;
    public static final SyncDataStrategy DEFAULT_SYNC_DATA_STRATEGY = null;
    public static final ProtoAdapter_MGetUrlPreviewRequest RAW_TYPE_ADAPTER = null;
    private static final long serialVersionUID = 0;
    public final List<GetUrlPreviewRequest> reqs;
    public final SyncDataStrategy sync_data_strategy;

    public static final class Builder extends Message.Builder<MGetUrlPreviewRequest, Builder> implements d<MGetUrlPreviewRequest> {
        public List<GetUrlPreviewRequest> reqs;
        public SyncDataStrategy sync_data_strategy;

        @Override // com.squareup.wire.Message.Builder
        public MGetUrlPreviewRequest build() {
            return new MGetUrlPreviewRequest(this.reqs, this.sync_data_strategy, super.buildUnknownFields());
        }

        public Builder() {
            this.reqs = Internal.newMutableList();
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder reqs(List<GetUrlPreviewRequest> r100) {
            Internal.checkElementsNotNull(r100);
            this.reqs = r100;
            return this;
        }

        public Builder sync_data_strategy(SyncDataStrategy r100) {
            this.sync_data_strategy = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_MGetUrlPreviewRequest extends ProtoAdapter<MGetUrlPreviewRequest> implements c<MGetUrlPreviewRequest> {
        public ProtoAdapter_MGetUrlPreviewRequest() {
            super(FieldEncoding.LENGTH_DELIMITED, MGetUrlPreviewRequest.class);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public MGetUrlPreviewRequest decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            r101.sync_data_strategy = SyncDataStrategy.TRY_LOCAL;
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L15;
            if (r103 != 1) goto L8;
            r101.reqs.add(GetUrlPreviewRequest.ADAPTER.decode(r100));
            goto L3
        L8:
            if (r103 != 2) goto L9;
            r101.sync_data_strategy = SyncDataStrategy.ADAPTER.decode(r100);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L12
        L12:
            e = move-exception;
            r101.addUnknownField(r103, FieldEncoding.VARINT, Long.valueOf(e.value));
            goto L3
        L9:
            FieldEncoding r104 = r100.peekFieldEncoding();
            r101.addUnknownField(r103, r104, r104.rawProtoAdapter().decode(r100));
            goto L3
        L15:
            r100.endMessage(r102);
            return r101.build();
        }

        /* JADX INFO: renamed from: encodedSize, reason: avoid collision after fix types in other method */
        public int encodedSize2(MGetUrlPreviewRequest r100) {
            int r101 = GetUrlPreviewRequest.ADAPTER.asRepeated().encodedSizeWithTag(1, r100.reqs);
            SyncDataStrategy r102 = r100.sync_data_strategy;
            if (r102 == null) goto L5;
            int r103 = SyncDataStrategy.ADAPTER.encodedSizeWithTag(2, r102);
        L7:
            return (r101 + r103) + r100.unknownFields().size();
        L5:
            r103 = 0;
            goto L7
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ MGetUrlPreviewRequest decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(MGetUrlPreviewRequest r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, MGetUrlPreviewRequest r101) throws IOException {
            GetUrlPreviewRequest.ADAPTER.asRepeated().encodeWithTag(r100, 1, r101.reqs);
            SyncDataStrategy r102 = r101.sync_data_strategy;
            if (r102 == null) goto L5;
            SyncDataStrategy.ADAPTER.encodeWithTag(r100, 2, r102);
        L5:
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, MGetUrlPreviewRequest r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ProtoAdapter_MGetUrlPreviewRequest r100 = new ProtoAdapter_MGetUrlPreviewRequest();
        RAW_TYPE_ADAPTER = r100;
        ADAPTER = r100;
        DEFAULT_SYNC_DATA_STRATEGY = SyncDataStrategy.TRY_LOCAL;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.reqs = Internal.copyOf("reqs", this.reqs);
        r100.sync_data_strategy = this.sync_data_strategy;
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return MGetUrlPreviewRequest.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public MGetUrlPreviewRequest(List<GetUrlPreviewRequest> r100, SyncDataStrategy r101) {
        this(r100, r101, ByteString.EMPTY);
    }

    public MGetUrlPreviewRequest(List<GetUrlPreviewRequest> r100, SyncDataStrategy r101, ByteString r102) {
        super(ADAPTER, r102);
        this.reqs = Internal.immutableCopyOf("reqs", r100);
        this.sync_data_strategy = r101;
    }
}
