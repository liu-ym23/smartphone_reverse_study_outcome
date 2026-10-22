package com.bytedance.lark.pb.settings.v1;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import com.squareup.wire.internal.Internal;
import java.io.IOException;
import java.util.Map;
import okio.ByteString;
import we6.a;
import we6.b;

/* JADX INFO: loaded from: classes20.dex */
public final class GetSettingsResponse extends Message<GetSettingsResponse, Builder> {
    public static final ProtoAdapter<GetSettingsResponse> ADAPTER = null;
    public static final String DEFAULT_USER_ID = "";
    public static final ProtoAdapter_GetSettingsResponse RAW_TYPE_ADAPTER = null;
    private static final long serialVersionUID = 0;
    public final Map<String, String> field_groups;
    public final String user_id;

    public static final class Builder extends Message.Builder<GetSettingsResponse, Builder> implements b<GetSettingsResponse> {
        public Map<String, String> field_groups;
        public String user_id;

        @Override // com.squareup.wire.Message.Builder
        public GetSettingsResponse build() {
            return new GetSettingsResponse(this.field_groups, this.user_id, super.buildUnknownFields());
        }

        public Builder() {
            this.field_groups = Internal.newMutableMap();
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder field_groups(Map<String, String> r100) {
            Internal.checkElementsNotNull(r100);
            this.field_groups = r100;
            return this;
        }

        public Builder user_id(String r100) {
            this.user_id = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_GetSettingsResponse extends ProtoAdapter<GetSettingsResponse> implements a<GetSettingsResponse> {
        private final ProtoAdapter<Map<String, String>> field_groups;

        public ProtoAdapter_GetSettingsResponse() {
            super(FieldEncoding.LENGTH_DELIMITED, GetSettingsResponse.class);
            ProtoAdapter<String> r100 = ProtoAdapter.STRING;
            this.field_groups = ProtoAdapter.newMapAdapter(r100, r100);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public GetSettingsResponse decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            r101.user_id = "";
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L12;
            if (r103 != 1) goto L8;
            r101.field_groups.putAll(this.field_groups.decode(r100));
            goto L3
        L8:
            if (r103 != 2) goto L9;
            r101.user_id = ProtoAdapter.STRING.decode(r100);
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
        public int encodedSize2(GetSettingsResponse r100) {
            int r101 = this.field_groups.encodedSizeWithTag(1, r100.field_groups);
            String r102 = r100.user_id;
            if (r102 == null) goto L5;
            int r103 = ProtoAdapter.STRING.encodedSizeWithTag(2, r102);
        L7:
            return (r101 + r103) + r100.unknownFields().size();
        L5:
            r103 = 0;
            goto L7
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ GetSettingsResponse decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(GetSettingsResponse r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, GetSettingsResponse r101) throws IOException {
            this.field_groups.encodeWithTag(r100, 1, r101.field_groups);
            String r102 = r101.user_id;
            if (r102 == null) goto L5;
            ProtoAdapter.STRING.encodeWithTag(r100, 2, r102);
        L5:
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, GetSettingsResponse r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ProtoAdapter_GetSettingsResponse r100 = new ProtoAdapter_GetSettingsResponse();
        RAW_TYPE_ADAPTER = r100;
        ADAPTER = r100;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.field_groups = Internal.copyOf("field_groups", this.field_groups);
        r100.user_id = this.user_id;
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return GetSettingsResponse.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public GetSettingsResponse(Map<String, String> r100, String r101) {
        this(r100, r101, ByteString.EMPTY);
    }

    public GetSettingsResponse(Map<String, String> r100, String r101, ByteString r102) {
        super(ADAPTER, r102);
        this.field_groups = Internal.immutableCopyOf("field_groups", r100);
        this.user_id = r101;
    }
}
