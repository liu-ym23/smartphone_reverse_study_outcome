package com.obric.matrix.proto;

import com.google.gson.annotations.SerializedName;
import com.obric.aiagent.messenger.stub.FlowNetworkIDLStub;
import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import com.squareup.wire.WireField;
import com.squareup.wire.internal.Internal;
import java.io.IOException;
import java.util.Map;
import okio.ByteString;

/* JADX INFO: loaded from: classes33.dex */
public final class SdkCommonConfig extends Message<SdkCommonConfig, Builder> {
    public static final ProtoAdapter<SdkCommonConfig> ADAPTER = null;
    private static final long serialVersionUID = 0;

    @SerializedName(FlowNetworkIDLStub.O_AUTO_CONFIGS_KEY)
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", keyAdapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 1)
    public final Map<String, String> configs;

    public static final class Builder extends Message.Builder<SdkCommonConfig, Builder> {
        public Map<String, String> configs;

        @Override // com.squareup.wire.Message.Builder
        public SdkCommonConfig build() {
            return new SdkCommonConfig(this.configs, super.buildUnknownFields());
        }

        public Builder() {
            this.configs = Internal.newMutableMap();
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder configs(Map<String, String> r100) {
            Internal.checkElementsNotNull(r100);
            this.configs = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_SdkCommonConfig extends ProtoAdapter<SdkCommonConfig> {
        private final ProtoAdapter<Map<String, String>> configs;

        public ProtoAdapter_SdkCommonConfig() {
            super(FieldEncoding.LENGTH_DELIMITED, SdkCommonConfig.class);
            ProtoAdapter<String> r100 = ProtoAdapter.STRING;
            this.configs = ProtoAdapter.newMapAdapter(r100, r100);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public SdkCommonConfig decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L9;
            if (r103 != 1) goto L7;
            r101.configs.putAll(this.configs.decode(r100));
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
        public int encodedSize2(SdkCommonConfig r100) {
            return this.configs.encodedSizeWithTag(1, r100.configs) + r100.unknownFields().size();
        }

        /* JADX INFO: renamed from: redact, reason: avoid collision after fix types in other method */
        public SdkCommonConfig redact2(SdkCommonConfig r100) {
            Builder r101 = r100.newBuilder();
            r101.clearUnknownFields();
            return r101.build();
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ SdkCommonConfig decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(SdkCommonConfig r100) {
            return encodedSize2(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ SdkCommonConfig redact(SdkCommonConfig r100) {
            return redact2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, SdkCommonConfig r101) throws IOException {
            this.configs.encodeWithTag(r100, 1, r101.configs);
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, SdkCommonConfig r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_SdkCommonConfig();
    }

    public int hashCode() {
        int r100 = this.hashCode;
        if (r100 != 0) goto L6;
        int r101 = (unknownFields().hashCode() * 37) + this.configs.hashCode();
        this.hashCode = r101;
        return r101;
    L6:
        return r100;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.configs = Internal.copyOf(FlowNetworkIDLStub.O_AUTO_CONFIGS_KEY, this.configs);
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        StringBuilder r100 = new StringBuilder();
        Map<String, String> r101 = this.configs;
        if (r101 != null) goto L5;
    L7:
        StringBuilder r102 = r100.replace(0, 2, "SdkCommonConfig{");
        r102.append('}');
        return r102.toString();
    L5:
        if (r101.isEmpty() == true) goto L7;
        r100.append(", configs=");
        r100.append(this.configs);
        goto L7
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public SdkCommonConfig(Map<String, String> r100) {
        this(r100, ByteString.EMPTY);
    }

    public boolean equals(Object r100) {
        if (r100 != this) goto L6;
        return true;
    L6:
        if ((r100 instanceof SdkCommonConfig) == true) goto L8;
        return false;
    L8:
        SdkCommonConfig r101 = (SdkCommonConfig) r100;
        if (unknownFields().equals(r101.unknownFields()) == true) goto L11;
    L13:
        return false;
    L11:
        if (this.configs.equals(r101.configs) == false) goto L13;
        return true;
    }

    public SdkCommonConfig(Map<String, String> r100, ByteString r101) {
        super(ADAPTER, r101);
        this.configs = Internal.immutableCopyOf(FlowNetworkIDLStub.O_AUTO_CONFIGS_KEY, r100);
    }
}
