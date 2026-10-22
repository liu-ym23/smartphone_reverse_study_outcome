package com.obric.matrix.proto;

import com.google.gson.annotations.SerializedName;
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
public final class SdkAllConfig extends Message<SdkAllConfig, Builder> {
    public static final ProtoAdapter<SdkAllConfig> ADAPTER = null;
    private static final long serialVersionUID = 0;

    @SerializedName("otherConfig")
    @WireField(adapter = "com.obric.matrix.proto.SdkCommonConfig#ADAPTER", keyAdapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 2)
    public final Map<String, SdkCommonConfig> otherConfig;

    @SerializedName("sdkSendCmdConfig")
    @WireField(adapter = "com.obric.matrix.proto.SdkSendCmdConfig#ADAPTER", tag = 1)
    public final SdkSendCmdConfig sdkSendCmdConfig;

    public static final class Builder extends Message.Builder<SdkAllConfig, Builder> {
        public Map<String, SdkCommonConfig> otherConfig;
        public SdkSendCmdConfig sdkSendCmdConfig;

        @Override // com.squareup.wire.Message.Builder
        public SdkAllConfig build() {
            return new SdkAllConfig(this.sdkSendCmdConfig, this.otherConfig, super.buildUnknownFields());
        }

        public Builder() {
            this.otherConfig = Internal.newMutableMap();
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder otherConfig(Map<String, SdkCommonConfig> r100) {
            Internal.checkElementsNotNull(r100);
            this.otherConfig = r100;
            return this;
        }

        public Builder sdkSendCmdConfig(SdkSendCmdConfig r100) {
            this.sdkSendCmdConfig = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_SdkAllConfig extends ProtoAdapter<SdkAllConfig> {
        private final ProtoAdapter<Map<String, SdkCommonConfig>> otherConfig;

        public ProtoAdapter_SdkAllConfig() {
            super(FieldEncoding.LENGTH_DELIMITED, SdkAllConfig.class);
            this.otherConfig = ProtoAdapter.newMapAdapter(ProtoAdapter.STRING, SdkCommonConfig.ADAPTER);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public SdkAllConfig decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L12;
            if (r103 != 1) goto L8;
            r101.sdkSendCmdConfig(SdkSendCmdConfig.ADAPTER.decode(r100));
            goto L3
        L8:
            if (r103 != 2) goto L9;
            r101.otherConfig.putAll(this.otherConfig.decode(r100));
            goto L3
        L9:
            FieldEncoding r104 = r100.peekFieldEncoding();
            r101.addUnknownField(r103, r104, r104.rawProtoAdapter().decode(r100));
            goto L3
        L12:
            r100.endMessage(r102);
            return r101.build();
        }

        /* JADX INFO: renamed from: encodedSize, reason: avoid collision after fix types in other method */
        public int encodedSize2(SdkAllConfig r100) {
            return (SdkSendCmdConfig.ADAPTER.encodedSizeWithTag(1, r100.sdkSendCmdConfig) + this.otherConfig.encodedSizeWithTag(2, r100.otherConfig)) + r100.unknownFields().size();
        }

        /* JADX INFO: renamed from: redact, reason: avoid collision after fix types in other method */
        public SdkAllConfig redact2(SdkAllConfig r100) {
            Builder r101 = r100.newBuilder();
            SdkSendCmdConfig r102 = r101.sdkSendCmdConfig;
            if (r102 == null) goto L5;
            r101.sdkSendCmdConfig = SdkSendCmdConfig.ADAPTER.redact(r102);
        L5:
            Internal.redactElements(r101.otherConfig, SdkCommonConfig.ADAPTER);
            r101.clearUnknownFields();
            return r101.build();
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ SdkAllConfig decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(SdkAllConfig r100) {
            return encodedSize2(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ SdkAllConfig redact(SdkAllConfig r100) {
            return redact2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, SdkAllConfig r101) throws IOException {
            SdkSendCmdConfig.ADAPTER.encodeWithTag(r100, 1, r101.sdkSendCmdConfig);
            this.otherConfig.encodeWithTag(r100, 2, r101.otherConfig);
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, SdkAllConfig r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_SdkAllConfig();
    }

    public int hashCode() {
        int r100 = this.hashCode;
        if (r100 != 0) goto L10;
        int r101 = unknownFields().hashCode() * 37;
        SdkSendCmdConfig r102 = this.sdkSendCmdConfig;
        if (r102 == null) goto L7;
        int r103 = r102.hashCode();
    L8:
        int r104 = ((r101 + r103) * 37) + this.otherConfig.hashCode();
        this.hashCode = r104;
        return r104;
    L7:
        r103 = 0;
        goto L8
    L10:
        return r100;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.sdkSendCmdConfig = this.sdkSendCmdConfig;
        r100.otherConfig = Internal.copyOf("otherConfig", this.otherConfig);
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        StringBuilder r100 = new StringBuilder();
        if (this.sdkSendCmdConfig == null) goto L5;
        r100.append(", sdkSendCmdConfig=");
        r100.append(this.sdkSendCmdConfig);
    L5:
        Map<String, SdkCommonConfig> r101 = this.otherConfig;
        if (r101 != null) goto L8;
    L10:
        StringBuilder r102 = r100.replace(0, 2, "SdkAllConfig{");
        r102.append('}');
        return r102.toString();
    L8:
        if (r101.isEmpty() == true) goto L10;
        r100.append(", otherConfig=");
        r100.append(this.otherConfig);
        goto L10
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public boolean equals(Object r100) {
        if (r100 != this) goto L6;
        return true;
    L6:
        if ((r100 instanceof SdkAllConfig) == true) goto L8;
        return false;
    L8:
        SdkAllConfig r101 = (SdkAllConfig) r100;
        if (unknownFields().equals(r101.unknownFields()) == true) goto L11;
    L15:
        return false;
    L11:
        if (Internal.equals(this.sdkSendCmdConfig, r101.sdkSendCmdConfig) == false) goto L15;
        if (this.otherConfig.equals(r101.otherConfig) == false) goto L15;
        return true;
    }

    public SdkAllConfig(SdkSendCmdConfig r100, Map<String, SdkCommonConfig> r101) {
        this(r100, r101, ByteString.EMPTY);
    }

    public SdkAllConfig(SdkSendCmdConfig r100, Map<String, SdkCommonConfig> r101, ByteString r102) {
        super(ADAPTER, r102);
        this.sdkSendCmdConfig = r100;
        this.otherConfig = Internal.immutableCopyOf("otherConfig", r101);
    }
}
