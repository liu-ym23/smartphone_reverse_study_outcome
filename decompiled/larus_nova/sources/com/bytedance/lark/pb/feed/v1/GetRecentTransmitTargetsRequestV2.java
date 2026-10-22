package com.bytedance.lark.pb.feed.v1;

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
public final class GetRecentTransmitTargetsRequestV2 extends Message<GetRecentTransmitTargetsRequestV2, Builder> {
    public static final ProtoAdapter<GetRecentTransmitTargetsRequestV2> ADAPTER = null;
    public static final Integer DEFAULT_LIMIT = null;
    public static final SyncDataStrategy DEFAULT_SYNC_DATA_STRATEGY = null;
    public static final ProtoAdapter_GetRecentTransmitTargetsRequestV2 RAW_TYPE_ADAPTER = null;
    private static final long serialVersionUID = 0;
    public final List<ForwardIncludeItem.IncludeItem> include_items;
    public final Integer limit;
    public final SyncDataStrategy sync_data_strategy;

    public static final class Builder extends Message.Builder<GetRecentTransmitTargetsRequestV2, Builder> implements d<GetRecentTransmitTargetsRequestV2> {
        public List<ForwardIncludeItem.IncludeItem> include_items;
        public Integer limit;
        public SyncDataStrategy sync_data_strategy;

        @Override // com.squareup.wire.Message.Builder
        public GetRecentTransmitTargetsRequestV2 build() {
            return new GetRecentTransmitTargetsRequestV2(this.limit, this.include_items, this.sync_data_strategy, super.buildUnknownFields());
        }

        public Builder() {
            this.include_items = Internal.newMutableList();
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder include_items(List<ForwardIncludeItem.IncludeItem> r100) {
            Internal.checkElementsNotNull(r100);
            this.include_items = r100;
            return this;
        }

        public Builder limit(Integer r100) {
            this.limit = r100;
            return this;
        }

        public Builder sync_data_strategy(SyncDataStrategy r100) {
            this.sync_data_strategy = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_GetRecentTransmitTargetsRequestV2 extends ProtoAdapter<GetRecentTransmitTargetsRequestV2> implements c<GetRecentTransmitTargetsRequestV2> {
        public ProtoAdapter_GetRecentTransmitTargetsRequestV2() {
            super(FieldEncoding.LENGTH_DELIMITED, GetRecentTransmitTargetsRequestV2.class);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public GetRecentTransmitTargetsRequestV2 decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            r101.limit = 0;
            r101.sync_data_strategy = SyncDataStrategy.LOCAL;
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L18;
            if (r103 != 1) goto L8;
            r101.limit = ProtoAdapter.INT32.decode(r100);
            goto L3
        L8:
            if (r103 != 2) goto L10;
            r101.include_items.add(ForwardIncludeItem.IncludeItem.ADAPTER.decode(r100));
            goto L3
        L10:
            if (r103 != 3) goto L11;
            r101.sync_data_strategy = SyncDataStrategy.ADAPTER.decode(r100);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L14
        L14:
            e = move-exception;
            r101.addUnknownField(r103, FieldEncoding.VARINT, Long.valueOf(e.value));
            goto L3
        L11:
            FieldEncoding r104 = r100.peekFieldEncoding();
            r101.addUnknownField(r103, r104, r104.rawProtoAdapter().decode(r100));
            goto L3
        L18:
            r100.endMessage(r102);
            return r101.build();
        }

        /* JADX INFO: renamed from: encodedSize, reason: avoid collision after fix types in other method */
        public int encodedSize2(GetRecentTransmitTargetsRequestV2 r100) {
            Integer r101 = r100.limit;
            int r102 = 0;
            if (r101 == null) goto L5;
            int r103 = ProtoAdapter.INT32.encodedSizeWithTag(1, r101);
        L6:
            int r104 = r103 + ForwardIncludeItem.IncludeItem.ADAPTER.asRepeated().encodedSizeWithTag(2, r100.include_items);
            SyncDataStrategy r105 = r100.sync_data_strategy;
            if (r105 == null) goto L10;
            r102 = SyncDataStrategy.ADAPTER.encodedSizeWithTag(3, r105);
        L10:
            return (r104 + r102) + r100.unknownFields().size();
        L5:
            r103 = 0;
            goto L6
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ GetRecentTransmitTargetsRequestV2 decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(GetRecentTransmitTargetsRequestV2 r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, GetRecentTransmitTargetsRequestV2 r101) throws IOException {
            Integer r102 = r101.limit;
            if (r102 == null) goto L5;
            ProtoAdapter.INT32.encodeWithTag(r100, 1, r102);
        L5:
            ForwardIncludeItem.IncludeItem.ADAPTER.asRepeated().encodeWithTag(r100, 2, r101.include_items);
            SyncDataStrategy r103 = r101.sync_data_strategy;
            if (r103 == null) goto L8;
            SyncDataStrategy.ADAPTER.encodeWithTag(r100, 3, r103);
        L8:
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, GetRecentTransmitTargetsRequestV2 r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ProtoAdapter_GetRecentTransmitTargetsRequestV2 r100 = new ProtoAdapter_GetRecentTransmitTargetsRequestV2();
        RAW_TYPE_ADAPTER = r100;
        ADAPTER = r100;
        DEFAULT_LIMIT = 0;
        DEFAULT_SYNC_DATA_STRATEGY = SyncDataStrategy.LOCAL;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.limit = this.limit;
        r100.include_items = Internal.copyOf("include_items", this.include_items);
        r100.sync_data_strategy = this.sync_data_strategy;
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return GetRecentTransmitTargetsRequestV2.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public GetRecentTransmitTargetsRequestV2(Integer r100, List<ForwardIncludeItem.IncludeItem> r101, SyncDataStrategy r102) {
        this(r100, r101, r102, ByteString.EMPTY);
    }

    public GetRecentTransmitTargetsRequestV2(Integer r100, List<ForwardIncludeItem.IncludeItem> r101, SyncDataStrategy r102, ByteString r103) {
        super(ADAPTER, r103);
        this.limit = r100;
        this.include_items = Internal.immutableCopyOf("include_items", r101);
        this.sync_data_strategy = r102;
    }
}
