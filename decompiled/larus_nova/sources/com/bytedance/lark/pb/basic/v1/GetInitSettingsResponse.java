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
public final class GetInitSettingsResponse extends com.squareup.wire.Message<GetInitSettingsResponse, Builder> {
    public static final ProtoAdapter<GetInitSettingsResponse> ADAPTER = null;
    public static final ProtoAdapter_GetInitSettingsResponse RAW_TYPE_ADAPTER = null;
    private static final long serialVersionUID = 0;
    public final DomainSettings domain_settings;
    public final FeatureSwitches feature_switches;

    public static final class Builder extends com.squareup.wire.Message.Builder<GetInitSettingsResponse, Builder> implements d<GetInitSettingsResponse> {
        public DomainSettings domain_settings;
        public FeatureSwitches feature_switches;

        @Override // com.squareup.wire.Message.Builder
        public GetInitSettingsResponse build() {
            return new GetInitSettingsResponse(this.domain_settings, this.feature_switches, super.buildUnknownFields());
        }

        public Builder() {
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ com.squareup.wire.Message build() {
            return build();
        }

        public Builder domain_settings(DomainSettings r100) {
            this.domain_settings = r100;
            return this;
        }

        public Builder feature_switches(FeatureSwitches r100) {
            this.feature_switches = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_GetInitSettingsResponse extends ProtoAdapter<GetInitSettingsResponse> implements c<GetInitSettingsResponse> {
        public ProtoAdapter_GetInitSettingsResponse() {
            super(FieldEncoding.LENGTH_DELIMITED, GetInitSettingsResponse.class);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public GetInitSettingsResponse decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L12;
            if (r103 != 1) goto L8;
            r101.domain_settings = DomainSettings.ADAPTER.decode(r100);
            goto L3
        L8:
            if (r103 != 2) goto L9;
            r101.feature_switches = FeatureSwitches.ADAPTER.decode(r100);
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
        public int encodedSize2(GetInitSettingsResponse r100) {
            DomainSettings r101 = r100.domain_settings;
            int r102 = 0;
            if (r101 == null) goto L5;
            int r103 = DomainSettings.ADAPTER.encodedSizeWithTag(1, r101);
        L6:
            FeatureSwitches r104 = r100.feature_switches;
            if (r104 == null) goto L10;
            r102 = FeatureSwitches.ADAPTER.encodedSizeWithTag(2, r104);
        L10:
            return (r103 + r102) + r100.unknownFields().size();
        L5:
            r103 = 0;
            goto L6
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ GetInitSettingsResponse decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(GetInitSettingsResponse r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, GetInitSettingsResponse r101) throws IOException {
            DomainSettings r102 = r101.domain_settings;
            if (r102 == null) goto L5;
            DomainSettings.ADAPTER.encodeWithTag(r100, 1, r102);
        L5:
            FeatureSwitches r103 = r101.feature_switches;
            if (r103 == null) goto L8;
            FeatureSwitches.ADAPTER.encodeWithTag(r100, 2, r103);
        L8:
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, GetInitSettingsResponse r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ProtoAdapter_GetInitSettingsResponse r100 = new ProtoAdapter_GetInitSettingsResponse();
        RAW_TYPE_ADAPTER = r100;
        ADAPTER = r100;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.domain_settings = this.domain_settings;
        r100.feature_switches = this.feature_switches;
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return GetInitSettingsResponse.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ com.squareup.wire.Message.Builder newBuilder() {
        return newBuilder();
    }

    public GetInitSettingsResponse(DomainSettings r100, FeatureSwitches r101) {
        this(r100, r101, ByteString.EMPTY);
    }

    public GetInitSettingsResponse(DomainSettings r100, FeatureSwitches r101, ByteString r102) {
        super(ADAPTER, r102);
        this.domain_settings = r100;
        this.feature_switches = r101;
    }
}
