package com.bytedance.lark.pb.basic.v1;

import annotation.Debug;
import com.google.protobuf.FieldOptions;
import com.squareup.wire.FieldEncoding;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import com.squareup.wire.internal.Internal;
import java.io.IOException;
import okio.ByteString;
import we6.a;
import we6.b;

/* JADX INFO: loaded from: classes20.dex */
public final class SetEnvRequest extends com.squareup.wire.Message<SetEnvRequest, Builder> {
    public static final ProtoAdapter<SetEnvRequest> ADAPTER = null;
    public static final InitSDKRequest.EnvType DEFAULT_ENV_TYPE = null;
    public static final Boolean DEFAULT_SHOULD_FETCH_DOMAINS_IF_ABSENT = null;
    public static final SyncDataStrategy DEFAULT_SYNC_DATA_STRATEGY = null;
    public static final FieldOptions FIELD_OPTIONS_ENV_TYPE = null;
    public static final FieldOptions FIELD_OPTIONS_ENV_V2 = null;
    public static final FieldOptions FIELD_OPTIONS_SHOULD_FETCH_DOMAINS_IF_ABSENT = null;
    public static final FieldOptions FIELD_OPTIONS_SYNC_DATA_STRATEGY = null;
    public static final ProtoAdapter_SetEnvRequest RAW_TYPE_ADAPTER = null;
    private static final long serialVersionUID = 0;
    public final InitSDKRequest.EnvType env_type;
    public final InitSDKRequest.EnvV2 env_v2;
    public final Boolean should_fetch_domains_if_absent;
    public final SyncDataStrategy sync_data_strategy;

    public static final class Builder extends com.squareup.wire.Message.Builder<SetEnvRequest, Builder> implements b<SetEnvRequest> {
        public InitSDKRequest.EnvType env_type;
        public InitSDKRequest.EnvV2 env_v2;
        public Boolean should_fetch_domains_if_absent;
        public SyncDataStrategy sync_data_strategy;

        @Override // com.squareup.wire.Message.Builder
        public SetEnvRequest build() {
            InitSDKRequest.EnvType r100 = this.env_type;
            if (r100 == null) goto L7;
            return new SetEnvRequest(this.env_type, this.env_v2, this.should_fetch_domains_if_absent, this.sync_data_strategy, super.buildUnknownFields());
        L7:
            throw Internal.missingRequiredFields(new Object[]{r100, "env_type"});
        }

        public Builder() {
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ com.squareup.wire.Message build() {
            return build();
        }

        public Builder env_type(InitSDKRequest.EnvType r100) {
            this.env_type = r100;
            return this;
        }

        public Builder env_v2(InitSDKRequest.EnvV2 r100) {
            this.env_v2 = r100;
            return this;
        }

        public Builder should_fetch_domains_if_absent(Boolean r100) {
            this.should_fetch_domains_if_absent = r100;
            return this;
        }

        public Builder sync_data_strategy(SyncDataStrategy r100) {
            this.sync_data_strategy = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_SetEnvRequest extends ProtoAdapter<SetEnvRequest> implements a<SetEnvRequest> {
        public ProtoAdapter_SetEnvRequest() {
            super(FieldEncoding.LENGTH_DELIMITED, SetEnvRequest.class);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public SetEnvRequest decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            r101.env_type = InitSDKRequest.EnvType.ONLINE;
            r101.should_fetch_domains_if_absent = Boolean.TRUE;
            r101.sync_data_strategy = SyncDataStrategy.FORCE_SERVER;
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L24;
            if (r103 != 1) goto L8;
            r101.env_type = InitSDKRequest.EnvType.ADAPTER.decode(r100);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L22
        L22:
            e = move-exception;
            r101.addUnknownField(r103, FieldEncoding.VARINT, Long.valueOf(e.value));
            goto L3
        L8:
            if (r103 != 2) goto L10;
            r101.env_v2 = InitSDKRequest.EnvV2.ADAPTER.decode(r100);
            goto L3
        L10:
            if (r103 != 3) goto L12;
            r101.should_fetch_domains_if_absent = ProtoAdapter.BOOL.decode(r100);
            goto L3
        L12:
            if (r103 != 4) goto L13;
            r101.sync_data_strategy = SyncDataStrategy.ADAPTER.decode(r100);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L16
        L16:
            e = move-exception;
            r101.addUnknownField(r103, FieldEncoding.VARINT, Long.valueOf(e.value));
            goto L3
        L13:
            FieldEncoding r104 = r100.peekFieldEncoding();
            r101.addUnknownField(r103, r104, r104.rawProtoAdapter().decode(r100));
            goto L3
        L24:
            r100.endMessage(r102);
            return r101.build();
        }

        /* JADX INFO: renamed from: encodedSize, reason: avoid collision after fix types in other method */
        public int encodedSize2(SetEnvRequest r100) {
            int r101 = InitSDKRequest.EnvType.ADAPTER.encodedSizeWithTag(1, r100.env_type);
            InitSDKRequest.EnvV2 r102 = r100.env_v2;
            int r103 = 0;
            if (r102 == null) goto L5;
            int r104 = InitSDKRequest.EnvV2.ADAPTER.encodedSizeWithTag(2, r102);
        L6:
            int r105 = r101 + r104;
            Boolean r106 = r100.should_fetch_domains_if_absent;
            if (r106 == null) goto L9;
            int r107 = ProtoAdapter.BOOL.encodedSizeWithTag(3, r106);
        L10:
            int r108 = r105 + r107;
            SyncDataStrategy r109 = r100.sync_data_strategy;
            if (r109 == null) goto L14;
            r103 = SyncDataStrategy.ADAPTER.encodedSizeWithTag(4, r109);
        L14:
            return (r108 + r103) + r100.unknownFields().size();
        L9:
            r107 = 0;
            goto L10
        L5:
            r104 = 0;
            goto L6
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ SetEnvRequest decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(SetEnvRequest r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, SetEnvRequest r101) throws IOException {
            InitSDKRequest.EnvType.ADAPTER.encodeWithTag(r100, 1, r101.env_type);
            InitSDKRequest.EnvV2 r102 = r101.env_v2;
            if (r102 == null) goto L5;
            InitSDKRequest.EnvV2.ADAPTER.encodeWithTag(r100, 2, r102);
        L5:
            Boolean r103 = r101.should_fetch_domains_if_absent;
            if (r103 == null) goto L8;
            ProtoAdapter.BOOL.encodeWithTag(r100, 3, r103);
        L8:
            SyncDataStrategy r104 = r101.sync_data_strategy;
            if (r104 == null) goto L11;
            SyncDataStrategy.ADAPTER.encodeWithTag(r100, 4, r104);
        L11:
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, SetEnvRequest r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ProtoAdapter_SetEnvRequest r100 = new ProtoAdapter_SetEnvRequest();
        RAW_TYPE_ADAPTER = r100;
        ADAPTER = r100;
        FIELD_OPTIONS_ENV_TYPE = new FieldOptions.Builder().debug(new Debug.Builder().build()).build();
        FIELD_OPTIONS_ENV_V2 = new FieldOptions.Builder().debug(new Debug.Builder().build()).build();
        FIELD_OPTIONS_SHOULD_FETCH_DOMAINS_IF_ABSENT = new FieldOptions.Builder().debug(new Debug.Builder().build()).build();
        FIELD_OPTIONS_SYNC_DATA_STRATEGY = new FieldOptions.Builder().debug(new Debug.Builder().build()).build();
        DEFAULT_ENV_TYPE = InitSDKRequest.EnvType.ONLINE;
        DEFAULT_SHOULD_FETCH_DOMAINS_IF_ABSENT = Boolean.TRUE;
        DEFAULT_SYNC_DATA_STRATEGY = SyncDataStrategy.FORCE_SERVER;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.env_type = this.env_type;
        r100.env_v2 = this.env_v2;
        r100.should_fetch_domains_if_absent = this.should_fetch_domains_if_absent;
        r100.sync_data_strategy = this.sync_data_strategy;
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return SetEnvRequest.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ com.squareup.wire.Message.Builder newBuilder() {
        return newBuilder();
    }

    public SetEnvRequest(InitSDKRequest.EnvType r100, InitSDKRequest.EnvV2 r101, Boolean r102, SyncDataStrategy r110) {
        this(r100, r101, r102, r110, ByteString.EMPTY);
    }

    public SetEnvRequest(InitSDKRequest.EnvType r100, InitSDKRequest.EnvV2 r101, Boolean r102, SyncDataStrategy r103, ByteString r104) {
        super(ADAPTER, r104);
        this.env_type = r100;
        this.env_v2 = r101;
        this.should_fetch_domains_if_absent = r102;
        this.sync_data_strategy = r103;
    }
}
