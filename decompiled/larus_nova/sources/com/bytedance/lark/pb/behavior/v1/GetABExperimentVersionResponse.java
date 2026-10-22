package com.bytedance.lark.pb.behavior.v1;

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
public final class GetABExperimentVersionResponse extends Message<GetABExperimentVersionResponse, Builder> {
    public static final ProtoAdapter<GetABExperimentVersionResponse> ADAPTER = null;
    public static final ProtoAdapter_GetABExperimentVersionResponse RAW_TYPE_ADAPTER = null;
    private static final long serialVersionUID = 0;
    public final Map<String, String> feature_with_ab_map;
    public final Map<String, String> tea_event_key_map;

    public static final class Builder extends Message.Builder<GetABExperimentVersionResponse, Builder> implements d<GetABExperimentVersionResponse> {
        public Map<String, String> feature_with_ab_map;
        public Map<String, String> tea_event_key_map;

        @Override // com.squareup.wire.Message.Builder
        public GetABExperimentVersionResponse build() {
            return new GetABExperimentVersionResponse(this.tea_event_key_map, this.feature_with_ab_map, super.buildUnknownFields());
        }

        public Builder() {
            this.tea_event_key_map = Internal.newMutableMap();
            this.feature_with_ab_map = Internal.newMutableMap();
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder feature_with_ab_map(Map<String, String> r100) {
            Internal.checkElementsNotNull(r100);
            this.feature_with_ab_map = r100;
            return this;
        }

        public Builder tea_event_key_map(Map<String, String> r100) {
            Internal.checkElementsNotNull(r100);
            this.tea_event_key_map = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_GetABExperimentVersionResponse extends ProtoAdapter<GetABExperimentVersionResponse> implements c<GetABExperimentVersionResponse> {
        private final ProtoAdapter<Map<String, String>> feature_with_ab_map;
        private final ProtoAdapter<Map<String, String>> tea_event_key_map;

        public ProtoAdapter_GetABExperimentVersionResponse() {
            super(FieldEncoding.LENGTH_DELIMITED, GetABExperimentVersionResponse.class);
            ProtoAdapter<String> r100 = ProtoAdapter.STRING;
            this.tea_event_key_map = ProtoAdapter.newMapAdapter(r100, r100);
            this.feature_with_ab_map = ProtoAdapter.newMapAdapter(r100, r100);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public GetABExperimentVersionResponse decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L12;
            if (r103 != 16) goto L8;
            r101.tea_event_key_map.putAll(this.tea_event_key_map.decode(r100));
            goto L3
        L8:
            if (r103 != 17) goto L9;
            r101.feature_with_ab_map.putAll(this.feature_with_ab_map.decode(r100));
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
        public int encodedSize2(GetABExperimentVersionResponse r100) {
            return (this.tea_event_key_map.encodedSizeWithTag(16, r100.tea_event_key_map) + this.feature_with_ab_map.encodedSizeWithTag(17, r100.feature_with_ab_map)) + r100.unknownFields().size();
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ GetABExperimentVersionResponse decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(GetABExperimentVersionResponse r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, GetABExperimentVersionResponse r101) throws IOException {
            this.tea_event_key_map.encodeWithTag(r100, 16, r101.tea_event_key_map);
            this.feature_with_ab_map.encodeWithTag(r100, 17, r101.feature_with_ab_map);
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, GetABExperimentVersionResponse r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ProtoAdapter_GetABExperimentVersionResponse r100 = new ProtoAdapter_GetABExperimentVersionResponse();
        RAW_TYPE_ADAPTER = r100;
        ADAPTER = r100;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.tea_event_key_map = Internal.copyOf("tea_event_key_map", this.tea_event_key_map);
        r100.feature_with_ab_map = Internal.copyOf("feature_with_ab_map", this.feature_with_ab_map);
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return GetABExperimentVersionResponse.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public GetABExperimentVersionResponse(Map<String, String> r100, Map<String, String> r101) {
        this(r100, r101, ByteString.EMPTY);
    }

    public GetABExperimentVersionResponse(Map<String, String> r100, Map<String, String> r101, ByteString r102) {
        super(ADAPTER, r102);
        this.tea_event_key_map = Internal.immutableCopyOf("tea_event_key_map", r100);
        this.feature_with_ab_map = Internal.immutableCopyOf("feature_with_ab_map", r101);
    }
}
