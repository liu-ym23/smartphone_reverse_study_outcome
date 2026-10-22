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
public final class GetExternalContactListRequest extends Message<GetExternalContactListRequest, Builder> {
    public static final ProtoAdapter<GetExternalContactListRequest> ADAPTER = null;
    public static final Long DEFAULT_LIMIT = null;
    public static final Long DEFAULT_OFFSET = null;
    public static final SyncDataStrategy DEFAULT_STRATEGY = null;
    public static final ProtoAdapter_GetExternalContactListRequest RAW_TYPE_ADAPTER = null;
    private static final long serialVersionUID = 0;
    public final Long limit;
    public final Long offset;
    public final SyncDataStrategy strategy;

    public static final class Builder extends Message.Builder<GetExternalContactListRequest, Builder> implements d<GetExternalContactListRequest> {
        public Long limit;
        public Long offset;
        public SyncDataStrategy strategy;

        @Override // com.squareup.wire.Message.Builder
        public GetExternalContactListRequest build() {
            return new GetExternalContactListRequest(this.strategy, this.offset, this.limit, super.buildUnknownFields());
        }

        public Builder() {
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder limit(Long r100) {
            this.limit = r100;
            return this;
        }

        public Builder offset(Long r100) {
            this.offset = r100;
            return this;
        }

        public Builder strategy(SyncDataStrategy r100) {
            this.strategy = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_GetExternalContactListRequest extends ProtoAdapter<GetExternalContactListRequest> implements c<GetExternalContactListRequest> {
        public ProtoAdapter_GetExternalContactListRequest() {
            super(FieldEncoding.LENGTH_DELIMITED, GetExternalContactListRequest.class);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public GetExternalContactListRequest decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            r101.strategy = SyncDataStrategy.FORCE_SERVER;
            r101.offset = 0L;
            r101.limit = 0L;
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L18;
            if (r103 != 1) goto L8;
            r101.strategy = SyncDataStrategy.ADAPTER.decode(r100);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L16
        L16:
            e = move-exception;
            r101.addUnknownField(r103, FieldEncoding.VARINT, Long.valueOf(e.value));
            goto L3
        L8:
            if (r103 != 2) goto L10;
            r101.offset = ProtoAdapter.INT64.decode(r100);
            goto L3
        L10:
            if (r103 != 3) goto L11;
            r101.limit = ProtoAdapter.INT64.decode(r100);
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
        public int encodedSize2(GetExternalContactListRequest r100) {
            SyncDataStrategy r101 = r100.strategy;
            int r102 = 0;
            if (r101 == null) goto L5;
            int r103 = SyncDataStrategy.ADAPTER.encodedSizeWithTag(1, r101);
        L6:
            Long r104 = r100.offset;
            if (r104 == null) goto L9;
            int r105 = ProtoAdapter.INT64.encodedSizeWithTag(2, r104);
        L10:
            int r106 = r103 + r105;
            Long r107 = r100.limit;
            if (r107 == null) goto L14;
            r102 = ProtoAdapter.INT64.encodedSizeWithTag(3, r107);
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
        public /* bridge */ /* synthetic */ GetExternalContactListRequest decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(GetExternalContactListRequest r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, GetExternalContactListRequest r101) throws IOException {
            SyncDataStrategy r102 = r101.strategy;
            if (r102 == null) goto L5;
            SyncDataStrategy.ADAPTER.encodeWithTag(r100, 1, r102);
        L5:
            Long r103 = r101.offset;
            if (r103 == null) goto L8;
            ProtoAdapter.INT64.encodeWithTag(r100, 2, r103);
        L8:
            Long r104 = r101.limit;
            if (r104 == null) goto L11;
            ProtoAdapter.INT64.encodeWithTag(r100, 3, r104);
        L11:
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, GetExternalContactListRequest r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ProtoAdapter_GetExternalContactListRequest r100 = new ProtoAdapter_GetExternalContactListRequest();
        RAW_TYPE_ADAPTER = r100;
        ADAPTER = r100;
        DEFAULT_STRATEGY = SyncDataStrategy.FORCE_SERVER;
        DEFAULT_OFFSET = 0L;
        DEFAULT_LIMIT = 0L;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.strategy = this.strategy;
        r100.offset = this.offset;
        r100.limit = this.limit;
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return GetExternalContactListRequest.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public GetExternalContactListRequest(SyncDataStrategy r100, Long r101, Long r102) {
        this(r100, r101, r102, ByteString.EMPTY);
    }

    public GetExternalContactListRequest(SyncDataStrategy r100, Long r101, Long r102, ByteString r103) {
        super(ADAPTER, r103);
        this.strategy = r100;
        this.offset = r101;
        this.limit = r102;
    }
}
