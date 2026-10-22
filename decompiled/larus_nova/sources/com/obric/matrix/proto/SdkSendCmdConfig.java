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
import java.util.List;
import java.util.Map;
import okio.ByteString;

/* JADX INFO: loaded from: classes33.dex */
public final class SdkSendCmdConfig extends Message<SdkSendCmdConfig, Builder> {
    public static final ProtoAdapter<SdkSendCmdConfig> ADAPTER = null;
    public static final Boolean DEFAULT_ISALLUSEBIND = null;
    public static final Integer DEFAULT_MINSUPPORTINTENTSERVICEVERSION = null;
    public static final Integer DEFAULT_POLLINGINTERVAL = null;
    public static final Integer DEFAULT_SENDCMDTIMEOUT = null;
    private static final long serialVersionUID = 0;

    @SerializedName("extraConfigs")
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", keyAdapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 6)
    public final Map<String, String> extraConfigs;

    @SerializedName("forceUseOldBindCmd")
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#INT32", label = WireField.Label.REPEATED, tag = 7)
    public final List<Integer> forceUseOldBindCmd;

    @SerializedName("isAllUseBind")
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#BOOL", tag = 1)
    public final Boolean isAllUseBind;

    @SerializedName("minSupportIntentServiceVersion")
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#INT32", tag = 2)
    public final Integer minSupportIntentServiceVersion;

    @SerializedName("pollingInterval")
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#INT32", tag = 5)
    public final Integer pollingInterval;

    @SerializedName("sendCmdTimeout")
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#INT32", tag = 4)
    public final Integer sendCmdTimeout;

    @SerializedName("useBindCmd")
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#INT32", label = WireField.Label.REPEATED, tag = 3)
    public final List<Integer> useBindCmd;

    public static final class Builder extends Message.Builder<SdkSendCmdConfig, Builder> {
        public Map<String, String> extraConfigs;
        public List<Integer> forceUseOldBindCmd;
        public Boolean isAllUseBind;
        public Integer minSupportIntentServiceVersion;
        public Integer pollingInterval;
        public Integer sendCmdTimeout;
        public List<Integer> useBindCmd;

        @Override // com.squareup.wire.Message.Builder
        public SdkSendCmdConfig build() {
            return new SdkSendCmdConfig(this.isAllUseBind, this.minSupportIntentServiceVersion, this.useBindCmd, this.sendCmdTimeout, this.pollingInterval, this.extraConfigs, this.forceUseOldBindCmd, super.buildUnknownFields());
        }

        public Builder() {
            this.isAllUseBind = Boolean.FALSE;
            this.minSupportIntentServiceVersion = 0;
            this.sendCmdTimeout = 0;
            this.pollingInterval = 0;
            this.useBindCmd = Internal.newMutableList();
            this.extraConfigs = Internal.newMutableMap();
            this.forceUseOldBindCmd = Internal.newMutableList();
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder extraConfigs(Map<String, String> r100) {
            Internal.checkElementsNotNull(r100);
            this.extraConfigs = r100;
            return this;
        }

        public Builder forceUseOldBindCmd(List<Integer> r100) {
            Internal.checkElementsNotNull(r100);
            this.forceUseOldBindCmd = r100;
            return this;
        }

        public Builder isAllUseBind(Boolean r100) {
            this.isAllUseBind = r100;
            return this;
        }

        public Builder minSupportIntentServiceVersion(Integer r100) {
            this.minSupportIntentServiceVersion = r100;
            return this;
        }

        public Builder pollingInterval(Integer r100) {
            this.pollingInterval = r100;
            return this;
        }

        public Builder sendCmdTimeout(Integer r100) {
            this.sendCmdTimeout = r100;
            return this;
        }

        public Builder useBindCmd(List<Integer> r100) {
            Internal.checkElementsNotNull(r100);
            this.useBindCmd = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_SdkSendCmdConfig extends ProtoAdapter<SdkSendCmdConfig> {
        private final ProtoAdapter<Map<String, String>> extraConfigs;

        public ProtoAdapter_SdkSendCmdConfig() {
            super(FieldEncoding.LENGTH_DELIMITED, SdkSendCmdConfig.class);
            ProtoAdapter<String> r100 = ProtoAdapter.STRING;
            this.extraConfigs = ProtoAdapter.newMapAdapter(r100, r100);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public SdkSendCmdConfig decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L14;
            switch(r103) {
                case 1: goto L13;
                case 2: goto L12;
                case 3: goto L11;
                case 4: goto L10;
                case 5: goto L9;
                case 6: goto L8;
                case 7: goto L7;
                default: goto L6;
            };
        L7:
            r101.forceUseOldBindCmd.add(ProtoAdapter.INT32.decode(r100));
            goto L3
        L8:
            r101.extraConfigs.putAll(this.extraConfigs.decode(r100));
            goto L3
        L9:
            r101.pollingInterval(ProtoAdapter.INT32.decode(r100));
            goto L3
        L10:
            r101.sendCmdTimeout(ProtoAdapter.INT32.decode(r100));
            goto L3
        L11:
            r101.useBindCmd.add(ProtoAdapter.INT32.decode(r100));
            goto L3
        L12:
            r101.minSupportIntentServiceVersion(ProtoAdapter.INT32.decode(r100));
            goto L3
        L13:
            r101.isAllUseBind(ProtoAdapter.BOOL.decode(r100));
            goto L3
        L6:
            FieldEncoding r104 = r100.peekFieldEncoding();
            r101.addUnknownField(r103, r104, r104.rawProtoAdapter().decode(r100));
            goto L3
        L14:
            r100.endMessage(r102);
            return r101.build();
        }

        /* JADX INFO: renamed from: encodedSize, reason: avoid collision after fix types in other method */
        public int encodedSize2(SdkSendCmdConfig r100) {
            int r101 = ProtoAdapter.BOOL.encodedSizeWithTag(1, r100.isAllUseBind);
            ProtoAdapter<Integer> r102 = ProtoAdapter.INT32;
            return ((((((r101 + r102.encodedSizeWithTag(2, r100.minSupportIntentServiceVersion)) + r102.asRepeated().encodedSizeWithTag(3, r100.useBindCmd)) + r102.encodedSizeWithTag(4, r100.sendCmdTimeout)) + r102.encodedSizeWithTag(5, r100.pollingInterval)) + this.extraConfigs.encodedSizeWithTag(6, r100.extraConfigs)) + r102.asRepeated().encodedSizeWithTag(7, r100.forceUseOldBindCmd)) + r100.unknownFields().size();
        }

        /* JADX INFO: renamed from: redact, reason: avoid collision after fix types in other method */
        public SdkSendCmdConfig redact2(SdkSendCmdConfig r100) {
            Builder r101 = r100.newBuilder();
            r101.clearUnknownFields();
            return r101.build();
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ SdkSendCmdConfig decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(SdkSendCmdConfig r100) {
            return encodedSize2(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ SdkSendCmdConfig redact(SdkSendCmdConfig r100) {
            return redact2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, SdkSendCmdConfig r101) throws IOException {
            ProtoAdapter.BOOL.encodeWithTag(r100, 1, r101.isAllUseBind);
            ProtoAdapter<Integer> r102 = ProtoAdapter.INT32;
            r102.encodeWithTag(r100, 2, r101.minSupportIntentServiceVersion);
            r102.asRepeated().encodeWithTag(r100, 3, r101.useBindCmd);
            r102.encodeWithTag(r100, 4, r101.sendCmdTimeout);
            r102.encodeWithTag(r100, 5, r101.pollingInterval);
            this.extraConfigs.encodeWithTag(r100, 6, r101.extraConfigs);
            r102.asRepeated().encodeWithTag(r100, 7, r101.forceUseOldBindCmd);
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, SdkSendCmdConfig r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_SdkSendCmdConfig();
        DEFAULT_ISALLUSEBIND = Boolean.FALSE;
        DEFAULT_MINSUPPORTINTENTSERVICEVERSION = 0;
        DEFAULT_SENDCMDTIMEOUT = 0;
        DEFAULT_POLLINGINTERVAL = 0;
    }

    public int hashCode() {
        int r100 = this.hashCode;
        if (r100 != 0) goto L21;
        int r101 = unknownFields().hashCode() * 37;
        Boolean r102 = this.isAllUseBind;
        int r103 = 0;
        if (r102 == null) goto L7;
        int r104 = r102.hashCode();
    L8:
        int r105 = (r101 + r104) * 37;
        Integer r106 = this.minSupportIntentServiceVersion;
        if (r106 == null) goto L11;
        int r107 = r106.hashCode();
    L12:
        int r108 = (((r105 + r107) * 37) + this.useBindCmd.hashCode()) * 37;
        Integer r109 = this.sendCmdTimeout;
        if (r109 == null) goto L15;
        int r110 = r109.hashCode();
    L16:
        int r111 = (r108 + r110) * 37;
        Integer r112 = this.pollingInterval;
        if (r112 == null) goto L19;
        r103 = r112.hashCode();
    L19:
        int r113 = ((((r111 + r103) * 37) + this.extraConfigs.hashCode()) * 37) + this.forceUseOldBindCmd.hashCode();
        this.hashCode = r113;
        return r113;
    L15:
        r110 = 0;
        goto L16
    L11:
        r107 = 0;
        goto L12
    L7:
        r104 = 0;
        goto L8
    L21:
        return r100;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.isAllUseBind = this.isAllUseBind;
        r100.minSupportIntentServiceVersion = this.minSupportIntentServiceVersion;
        r100.useBindCmd = Internal.copyOf("useBindCmd", this.useBindCmd);
        r100.sendCmdTimeout = this.sendCmdTimeout;
        r100.pollingInterval = this.pollingInterval;
        r100.extraConfigs = Internal.copyOf("extraConfigs", this.extraConfigs);
        r100.forceUseOldBindCmd = Internal.copyOf("forceUseOldBindCmd", this.forceUseOldBindCmd);
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        StringBuilder r100 = new StringBuilder();
        if (this.isAllUseBind == null) goto L6;
        r100.append(", isAllUseBind=");
        r100.append(this.isAllUseBind);
    L6:
        if (this.minSupportIntentServiceVersion == null) goto L8;
        r100.append(", minSupportIntentServiceVersion=");
        r100.append(this.minSupportIntentServiceVersion);
    L8:
        List<Integer> r101 = this.useBindCmd;
        if (r101 == null) goto L14;
        if (r101.isEmpty() == true) goto L14;
        r100.append(", useBindCmd=");
        r100.append(this.useBindCmd);
    L14:
        if (this.sendCmdTimeout == null) goto L17;
        r100.append(", sendCmdTimeout=");
        r100.append(this.sendCmdTimeout);
    L17:
        if (this.pollingInterval == null) goto L19;
        r100.append(", pollingInterval=");
        r100.append(this.pollingInterval);
    L19:
        Map<String, String> r102 = this.extraConfigs;
        if (r102 != null) goto L22;
    L24:
        List<Integer> r103 = this.forceUseOldBindCmd;
        if (r103 != null) goto L27;
    L29:
        StringBuilder r104 = r100.replace(0, 2, "SdkSendCmdConfig{");
        r104.append('}');
        return r104.toString();
    L27:
        if (r103.isEmpty() == true) goto L29;
        r100.append(", forceUseOldBindCmd=");
        r100.append(this.forceUseOldBindCmd);
        goto L29
    L22:
        if (r102.isEmpty() == true) goto L24;
        r100.append(", extraConfigs=");
        r100.append(this.extraConfigs);
        goto L24
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public boolean equals(Object r100) {
        if (r100 != this) goto L6;
        return true;
    L6:
        if ((r100 instanceof SdkSendCmdConfig) == true) goto L8;
        return false;
    L8:
        SdkSendCmdConfig r101 = (SdkSendCmdConfig) r100;
        if (unknownFields().equals(r101.unknownFields()) == true) goto L11;
    L25:
        return false;
    L11:
        if (Internal.equals(this.isAllUseBind, r101.isAllUseBind) == false) goto L25;
        if (Internal.equals(this.minSupportIntentServiceVersion, r101.minSupportIntentServiceVersion) == false) goto L25;
        if (this.useBindCmd.equals(r101.useBindCmd) == false) goto L25;
        if (Internal.equals(this.sendCmdTimeout, r101.sendCmdTimeout) == false) goto L25;
        if (Internal.equals(this.pollingInterval, r101.pollingInterval) == false) goto L25;
        if (this.extraConfigs.equals(r101.extraConfigs) == false) goto L25;
        if (this.forceUseOldBindCmd.equals(r101.forceUseOldBindCmd) == false) goto L25;
        return true;
    }

    public SdkSendCmdConfig(Boolean r110, Integer r111, List<Integer> r112, Integer r113, Integer r114, Map<String, String> r115, List<Integer> r116) {
        this(r110, r111, r112, r113, r114, r115, r116, ByteString.EMPTY);
    }

    public SdkSendCmdConfig(Boolean r100, Integer r101, List<Integer> r102, Integer r103, Integer r104, Map<String, String> r105, List<Integer> r106, ByteString r107) {
        super(ADAPTER, r107);
        this.isAllUseBind = r100;
        this.minSupportIntentServiceVersion = r101;
        this.useBindCmd = Internal.immutableCopyOf("useBindCmd", r102);
        this.sendCmdTimeout = r103;
        this.pollingInterval = r104;
        this.extraConfigs = Internal.immutableCopyOf("extraConfigs", r105);
        this.forceUseOldBindCmd = Internal.immutableCopyOf("forceUseOldBindCmd", r106);
    }
}
