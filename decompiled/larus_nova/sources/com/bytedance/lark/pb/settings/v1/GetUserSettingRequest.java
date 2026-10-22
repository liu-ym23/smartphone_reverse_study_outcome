package com.bytedance.lark.pb.settings.v1;

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
public final class GetUserSettingRequest extends Message<GetUserSettingRequest, Builder> {
    public static final ProtoAdapter<GetUserSettingRequest> ADAPTER = null;
    public static final Boolean DEFAULT_IS_FROM_SERVER = null;
    public static final SyncDataStrategy DEFAULT_SYNC_DATA_STRATEGY = null;
    public static final ProtoAdapter_GetUserSettingRequest RAW_TYPE_ADAPTER = null;
    private static final long serialVersionUID = 0;
    public final Boolean is_from_server;
    public final SyncDataStrategy sync_data_strategy;

    public static final class Builder extends Message.Builder<GetUserSettingRequest, Builder> implements d<GetUserSettingRequest> {
        public Boolean is_from_server;
        public SyncDataStrategy sync_data_strategy;

        @Override // com.squareup.wire.Message.Builder
        public GetUserSettingRequest build() {
            return new GetUserSettingRequest(this.is_from_server, this.sync_data_strategy, super.buildUnknownFields());
        }

        public Builder() {
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder is_from_server(Boolean r100) {
            this.is_from_server = r100;
            return this;
        }

        public Builder sync_data_strategy(SyncDataStrategy r100) {
            this.sync_data_strategy = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_GetUserSettingRequest extends ProtoAdapter<GetUserSettingRequest> implements c<GetUserSettingRequest> {
        public ProtoAdapter_GetUserSettingRequest() {
            super(FieldEncoding.LENGTH_DELIMITED, GetUserSettingRequest.class);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public GetUserSettingRequest decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            r101.is_from_server = Boolean.TRUE;
            r101.sync_data_strategy = SyncDataStrategy.FORCE_SERVER;
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L15;
            if (r103 != 1) goto L8;
            r101.is_from_server = ProtoAdapter.BOOL.decode(r100);
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
        public int encodedSize2(GetUserSettingRequest r100) {
            Boolean r101 = r100.is_from_server;
            int r102 = 0;
            if (r101 == null) goto L5;
            int r103 = ProtoAdapter.BOOL.encodedSizeWithTag(1, r101);
        L6:
            SyncDataStrategy r104 = r100.sync_data_strategy;
            if (r104 == null) goto L10;
            r102 = SyncDataStrategy.ADAPTER.encodedSizeWithTag(2, r104);
        L10:
            return (r103 + r102) + r100.unknownFields().size();
        L5:
            r103 = 0;
            goto L6
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ GetUserSettingRequest decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(GetUserSettingRequest r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, GetUserSettingRequest r101) throws IOException {
            Boolean r102 = r101.is_from_server;
            if (r102 == null) goto L5;
            ProtoAdapter.BOOL.encodeWithTag(r100, 1, r102);
        L5:
            SyncDataStrategy r103 = r101.sync_data_strategy;
            if (r103 == null) goto L8;
            SyncDataStrategy.ADAPTER.encodeWithTag(r100, 2, r103);
        L8:
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, GetUserSettingRequest r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ProtoAdapter_GetUserSettingRequest r100 = new ProtoAdapter_GetUserSettingRequest();
        RAW_TYPE_ADAPTER = r100;
        ADAPTER = r100;
        DEFAULT_IS_FROM_SERVER = Boolean.TRUE;
        DEFAULT_SYNC_DATA_STRATEGY = SyncDataStrategy.FORCE_SERVER;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.is_from_server = this.is_from_server;
        r100.sync_data_strategy = this.sync_data_strategy;
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return GetUserSettingRequest.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public GetUserSettingRequest(Boolean r100, SyncDataStrategy r101) {
        this(r100, r101, ByteString.EMPTY);
    }

    public GetUserSettingRequest(Boolean r100, SyncDataStrategy r101, ByteString r102) {
        super(ADAPTER, r102);
        this.is_from_server = r100;
        this.sync_data_strategy = r101;
    }
}
