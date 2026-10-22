package com.bytedance.lark.pb.settings.v1;

import annotation.Debug;
import com.bytedance.lark.pb.basic.v1.InitSDKRequest;
import com.google.protobuf.FieldOptions;
import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import com.squareup.wire.internal.Internal;
import java.io.IOException;
import okio.ByteString;
import we6.a;
import we6.b;

/* JADX INFO: loaded from: classes20.dex */
public final class PushCommonSettingsUpdated extends Message<PushCommonSettingsUpdated, Builder> {
    public static final ProtoAdapter<PushCommonSettingsUpdated> ADAPTER = null;
    public static final FieldOptions FIELD_OPTIONS_ENV_V2 = null;
    public static final ProtoAdapter_PushCommonSettingsUpdated RAW_TYPE_ADAPTER = null;
    private static final long serialVersionUID = 0;
    public final InitSDKRequest.EnvV2 env_v2;

    public static final class Builder extends Message.Builder<PushCommonSettingsUpdated, Builder> implements b<PushCommonSettingsUpdated> {
        public InitSDKRequest.EnvV2 env_v2;

        @Override // com.squareup.wire.Message.Builder
        public PushCommonSettingsUpdated build() {
            InitSDKRequest.EnvV2 r100 = this.env_v2;
            if (r100 == null) goto L7;
            return new PushCommonSettingsUpdated(this.env_v2, super.buildUnknownFields());
        L7:
            throw Internal.missingRequiredFields(new Object[]{r100, "env_v2"});
        }

        public Builder() {
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder env_v2(InitSDKRequest.EnvV2 r100) {
            this.env_v2 = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_PushCommonSettingsUpdated extends ProtoAdapter<PushCommonSettingsUpdated> implements a<PushCommonSettingsUpdated> {
        public ProtoAdapter_PushCommonSettingsUpdated() {
            super(FieldEncoding.LENGTH_DELIMITED, PushCommonSettingsUpdated.class);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public PushCommonSettingsUpdated decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L9;
            if (r103 != 1) goto L7;
            r101.env_v2 = InitSDKRequest.EnvV2.ADAPTER.decode(r100);
            goto L3
        L7:
            FieldEncoding r104 = r100.peekFieldEncoding();
            r101.addUnknownField(r103, r104, r104.rawProtoAdapter().decode(r100));
            goto L3
        L9:
            r100.endMessage(r102);
            return r101.build();
        }

        /* JADX INFO: renamed from: encodedSize, reason: avoid collision after fix types in other method */
        public int encodedSize2(PushCommonSettingsUpdated r100) {
            return InitSDKRequest.EnvV2.ADAPTER.encodedSizeWithTag(1, r100.env_v2) + r100.unknownFields().size();
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ PushCommonSettingsUpdated decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(PushCommonSettingsUpdated r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, PushCommonSettingsUpdated r101) throws IOException {
            InitSDKRequest.EnvV2.ADAPTER.encodeWithTag(r100, 1, r101.env_v2);
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, PushCommonSettingsUpdated r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ProtoAdapter_PushCommonSettingsUpdated r100 = new ProtoAdapter_PushCommonSettingsUpdated();
        RAW_TYPE_ADAPTER = r100;
        ADAPTER = r100;
        FIELD_OPTIONS_ENV_V2 = new FieldOptions.Builder().debug(new Debug.Builder().build()).build();
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.env_v2 = this.env_v2;
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return PushCommonSettingsUpdated.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public PushCommonSettingsUpdated(InitSDKRequest.EnvV2 r100) {
        this(r100, ByteString.EMPTY);
    }

    public PushCommonSettingsUpdated(InitSDKRequest.EnvV2 r100, ByteString r101) {
        super(ADAPTER, r101);
        this.env_v2 = r100;
    }
}
