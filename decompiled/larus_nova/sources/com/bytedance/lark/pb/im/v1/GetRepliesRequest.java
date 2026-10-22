package com.bytedance.lark.pb.im.v1;

import com.bytedance.lark.pb.basic.v1.SyncDataStrategy;
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
public final class GetRepliesRequest extends Message<GetRepliesRequest, Builder> {
    public static final ProtoAdapter<GetRepliesRequest> ADAPTER = null;
    public static final String DEFAULT_ROOT_ID = "";
    public static final SyncDataStrategy DEFAULT_SYNC_DATA_STRATEGY = null;
    public static final ProtoAdapter_GetRepliesRequest RAW_TYPE_ADAPTER = null;
    private static final long serialVersionUID = 0;
    public final String root_id;
    public final SyncDataStrategy sync_data_strategy;

    public static final class Builder extends Message.Builder<GetRepliesRequest, Builder> implements d<GetRepliesRequest> {
        public String root_id;
        public SyncDataStrategy sync_data_strategy;

        @Override // com.squareup.wire.Message.Builder
        public GetRepliesRequest build() {
            String r100 = this.root_id;
            if (r100 == null) goto L7;
            return new GetRepliesRequest(this.root_id, this.sync_data_strategy, super.buildUnknownFields());
        L7:
            throw Internal.missingRequiredFields(new Object[]{r100, "root_id"});
        }

        public Builder() {
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder root_id(String r100) {
            this.root_id = r100;
            return this;
        }

        public Builder sync_data_strategy(SyncDataStrategy r100) {
            this.sync_data_strategy = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_GetRepliesRequest extends ProtoAdapter<GetRepliesRequest> implements c<GetRepliesRequest> {
        public ProtoAdapter_GetRepliesRequest() {
            super(FieldEncoding.LENGTH_DELIMITED, GetRepliesRequest.class);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public GetRepliesRequest decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            r101.root_id = "";
            r101.sync_data_strategy = SyncDataStrategy.FORCE_SERVER;
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L15;
            if (r103 != 1) goto L8;
            r101.root_id = ProtoAdapter.STRING.decode(r100);
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
        public int encodedSize2(GetRepliesRequest r100) {
            int r101 = ProtoAdapter.STRING.encodedSizeWithTag(1, r100.root_id);
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
        public /* bridge */ /* synthetic */ GetRepliesRequest decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(GetRepliesRequest r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, GetRepliesRequest r101) throws IOException {
            ProtoAdapter.STRING.encodeWithTag(r100, 1, r101.root_id);
            SyncDataStrategy r102 = r101.sync_data_strategy;
            if (r102 == null) goto L5;
            SyncDataStrategy.ADAPTER.encodeWithTag(r100, 2, r102);
        L5:
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, GetRepliesRequest r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ProtoAdapter_GetRepliesRequest r100 = new ProtoAdapter_GetRepliesRequest();
        RAW_TYPE_ADAPTER = r100;
        ADAPTER = r100;
        DEFAULT_SYNC_DATA_STRATEGY = SyncDataStrategy.FORCE_SERVER;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.root_id = this.root_id;
        r100.sync_data_strategy = this.sync_data_strategy;
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return GetRepliesRequest.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public GetRepliesRequest(String r100, SyncDataStrategy r101) {
        this(r100, r101, ByteString.EMPTY);
    }

    public GetRepliesRequest(String r100, SyncDataStrategy r101, ByteString r102) {
        super(ADAPTER, r102);
        this.root_id = r100;
        this.sync_data_strategy = r101;
    }
}
