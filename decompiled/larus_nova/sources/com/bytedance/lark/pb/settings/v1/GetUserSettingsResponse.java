package com.bytedance.lark.pb.settings.v1;

import com.bytedance.lark.pb.basic.v1.DomainSettings;
import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import com.squareup.wire.internal.Internal;
import java.io.IOException;
import java.util.Map;
import okio.ByteString;
import we6.c;
import we6.d;

/* JADX INFO: loaded from: classes20.dex */
public final class GetUserSettingsResponse extends Message<GetUserSettingsResponse, Builder> {
    public static final ProtoAdapter<GetUserSettingsResponse> ADAPTER = null;
    public static final ProtoAdapter_GetUserSettingsResponse RAW_TYPE_ADAPTER = null;
    private static final long serialVersionUID = 0;
    public final DomainSettings domains;
    public final Map<String, String> settings;

    public static final class Builder extends Message.Builder<GetUserSettingsResponse, Builder> implements d<GetUserSettingsResponse> {
        public DomainSettings domains;
        public Map<String, String> settings;

        @Override // com.squareup.wire.Message.Builder
        public GetUserSettingsResponse build() {
            return new GetUserSettingsResponse(this.settings, this.domains, super.buildUnknownFields());
        }

        public Builder() {
            this.settings = Internal.newMutableMap();
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder domains(DomainSettings r100) {
            this.domains = r100;
            return this;
        }

        public Builder settings(Map<String, String> r100) {
            Internal.checkElementsNotNull(r100);
            this.settings = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_GetUserSettingsResponse extends ProtoAdapter<GetUserSettingsResponse> implements c<GetUserSettingsResponse> {
        private final ProtoAdapter<Map<String, String>> settings;

        public ProtoAdapter_GetUserSettingsResponse() {
            super(FieldEncoding.LENGTH_DELIMITED, GetUserSettingsResponse.class);
            ProtoAdapter<String> r100 = ProtoAdapter.STRING;
            this.settings = ProtoAdapter.newMapAdapter(r100, r100);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public GetUserSettingsResponse decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L12;
            if (r103 != 1) goto L8;
            r101.settings.putAll(this.settings.decode(r100));
            goto L3
        L8:
            if (r103 != 2) goto L9;
            r101.domains = DomainSettings.ADAPTER.decode(r100);
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
        public int encodedSize2(GetUserSettingsResponse r100) {
            int r101 = this.settings.encodedSizeWithTag(1, r100.settings);
            DomainSettings r102 = r100.domains;
            if (r102 == null) goto L5;
            int r103 = DomainSettings.ADAPTER.encodedSizeWithTag(2, r102);
        L7:
            return (r101 + r103) + r100.unknownFields().size();
        L5:
            r103 = 0;
            goto L7
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ GetUserSettingsResponse decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(GetUserSettingsResponse r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, GetUserSettingsResponse r101) throws IOException {
            this.settings.encodeWithTag(r100, 1, r101.settings);
            DomainSettings r102 = r101.domains;
            if (r102 == null) goto L5;
            DomainSettings.ADAPTER.encodeWithTag(r100, 2, r102);
        L5:
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, GetUserSettingsResponse r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ProtoAdapter_GetUserSettingsResponse r100 = new ProtoAdapter_GetUserSettingsResponse();
        RAW_TYPE_ADAPTER = r100;
        ADAPTER = r100;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.settings = Internal.copyOf("settings", this.settings);
        r100.domains = this.domains;
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return GetUserSettingsResponse.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public GetUserSettingsResponse(Map<String, String> r100, DomainSettings r101) {
        this(r100, r101, ByteString.EMPTY);
    }

    public GetUserSettingsResponse(Map<String, String> r100, DomainSettings r101, ByteString r102) {
        super(ADAPTER, r102);
        this.settings = Internal.immutableCopyOf("settings", r100);
        this.domains = r101;
    }
}
