package com.bytedance.lark.pb.basic.v1;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import java.io.IOException;
import okio.ByteString;
import we6.c;
import we6.d;

/* JADX INFO: loaded from: classes20.dex */
public final class GetAppConfigRequest extends com.squareup.wire.Message<GetAppConfigRequest, Builder> {
    public static final ProtoAdapter<GetAppConfigRequest> ADAPTER = null;
    public static final Boolean DEFAULT_FORCE_REMOTE = null;
    public static final Boolean DEFAULT_NEED_LOGIN = null;
    public static final SyncDataStrategy DEFAULT_SYNC_DATA_STRATEGY = null;
    public static final ProtoAdapter_GetAppConfigRequest RAW_TYPE_ADAPTER = null;
    private static final long serialVersionUID = 0;
    public final Boolean force_remote;
    public final Boolean need_login;
    public final SyncDataStrategy sync_data_strategy;

    public static final class Builder extends com.squareup.wire.Message.Builder<GetAppConfigRequest, Builder> implements d<GetAppConfigRequest> {
        public Boolean force_remote;
        public Boolean need_login;
        public SyncDataStrategy sync_data_strategy;

        @Override // com.squareup.wire.Message.Builder
        public GetAppConfigRequest build() {
            return new GetAppConfigRequest(this.need_login, this.force_remote, this.sync_data_strategy, super.buildUnknownFields());
        }

        public Builder() {
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ com.squareup.wire.Message build() {
            return build();
        }

        public Builder force_remote(Boolean r100) {
            this.force_remote = r100;
            return this;
        }

        public Builder need_login(Boolean r100) {
            this.need_login = r100;
            return this;
        }

        public Builder sync_data_strategy(SyncDataStrategy r100) {
            this.sync_data_strategy = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_GetAppConfigRequest extends ProtoAdapter<GetAppConfigRequest> implements c<GetAppConfigRequest> {
        public ProtoAdapter_GetAppConfigRequest() {
            super(FieldEncoding.LENGTH_DELIMITED, GetAppConfigRequest.class);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public GetAppConfigRequest decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            r101.need_login = Boolean.TRUE;
            r101.force_remote = Boolean.FALSE;
            r101.sync_data_strategy = SyncDataStrategy.FORCE_SERVER;
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L18;
            if (r103 != 1) goto L8;
            r101.need_login = ProtoAdapter.BOOL.decode(r100);
            goto L3
        L8:
            if (r103 != 2) goto L10;
            r101.force_remote = ProtoAdapter.BOOL.decode(r100);
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
        public int encodedSize2(GetAppConfigRequest r100) {
            Boolean r101 = r100.need_login;
            int r102 = 0;
            if (r101 == null) goto L5;
            int r103 = ProtoAdapter.BOOL.encodedSizeWithTag(1, r101);
        L6:
            Boolean r104 = r100.force_remote;
            if (r104 == null) goto L9;
            int r105 = ProtoAdapter.BOOL.encodedSizeWithTag(2, r104);
        L10:
            int r106 = r103 + r105;
            SyncDataStrategy r107 = r100.sync_data_strategy;
            if (r107 == null) goto L14;
            r102 = SyncDataStrategy.ADAPTER.encodedSizeWithTag(3, r107);
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
        public /* bridge */ /* synthetic */ GetAppConfigRequest decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(GetAppConfigRequest r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, GetAppConfigRequest r101) throws IOException {
            Boolean r102 = r101.need_login;
            if (r102 == null) goto L5;
            ProtoAdapter.BOOL.encodeWithTag(r100, 1, r102);
        L5:
            Boolean r103 = r101.force_remote;
            if (r103 == null) goto L8;
            ProtoAdapter.BOOL.encodeWithTag(r100, 2, r103);
        L8:
            SyncDataStrategy r104 = r101.sync_data_strategy;
            if (r104 == null) goto L11;
            SyncDataStrategy.ADAPTER.encodeWithTag(r100, 3, r104);
        L11:
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, GetAppConfigRequest r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ProtoAdapter_GetAppConfigRequest r100 = new ProtoAdapter_GetAppConfigRequest();
        RAW_TYPE_ADAPTER = r100;
        ADAPTER = r100;
        DEFAULT_NEED_LOGIN = Boolean.TRUE;
        DEFAULT_FORCE_REMOTE = Boolean.FALSE;
        DEFAULT_SYNC_DATA_STRATEGY = SyncDataStrategy.FORCE_SERVER;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.need_login = this.need_login;
        r100.force_remote = this.force_remote;
        r100.sync_data_strategy = this.sync_data_strategy;
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return GetAppConfigRequest.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ com.squareup.wire.Message.Builder newBuilder() {
        return newBuilder();
    }

    public GetAppConfigRequest(Boolean r100, Boolean r101, SyncDataStrategy r102) {
        this(r100, r101, r102, ByteString.EMPTY);
    }

    public GetAppConfigRequest(Boolean r100, Boolean r101, SyncDataStrategy r102, ByteString r103) {
        super(ADAPTER, r103);
        this.need_login = r100;
        this.force_remote = r101;
        this.sync_data_strategy = r102;
    }
}
