package com.bytedance.lark.pb.contact.v1;

import com.bytedance.lark.pb.basic.v1.ChatterSensitiveInfo;
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
public final class GetMentionChatterSensitiveInfoResponse extends Message<GetMentionChatterSensitiveInfoResponse, Builder> {
    public static final ProtoAdapter<GetMentionChatterSensitiveInfoResponse> ADAPTER = null;
    public static final ProtoAdapter_GetMentionChatterSensitiveInfoResponse RAW_TYPE_ADAPTER = null;
    private static final long serialVersionUID = 0;
    public final Map<Long, ChatterSensitiveInfo> chatter_id_to_sensitive_info;

    public static final class Builder extends Message.Builder<GetMentionChatterSensitiveInfoResponse, Builder> implements d<GetMentionChatterSensitiveInfoResponse> {
        public Map<Long, ChatterSensitiveInfo> chatter_id_to_sensitive_info;

        @Override // com.squareup.wire.Message.Builder
        public GetMentionChatterSensitiveInfoResponse build() {
            return new GetMentionChatterSensitiveInfoResponse(this.chatter_id_to_sensitive_info, super.buildUnknownFields());
        }

        public Builder() {
            this.chatter_id_to_sensitive_info = Internal.newMutableMap();
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder chatter_id_to_sensitive_info(Map<Long, ChatterSensitiveInfo> r100) {
            Internal.checkElementsNotNull(r100);
            this.chatter_id_to_sensitive_info = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_GetMentionChatterSensitiveInfoResponse extends ProtoAdapter<GetMentionChatterSensitiveInfoResponse> implements c<GetMentionChatterSensitiveInfoResponse> {
        private final ProtoAdapter<Map<Long, ChatterSensitiveInfo>> chatter_id_to_sensitive_info;

        public ProtoAdapter_GetMentionChatterSensitiveInfoResponse() {
            super(FieldEncoding.LENGTH_DELIMITED, GetMentionChatterSensitiveInfoResponse.class);
            this.chatter_id_to_sensitive_info = ProtoAdapter.newMapAdapter(ProtoAdapter.INT64, ChatterSensitiveInfo.ADAPTER);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public GetMentionChatterSensitiveInfoResponse decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L9;
            if (r103 != 1) goto L7;
            r101.chatter_id_to_sensitive_info.putAll(this.chatter_id_to_sensitive_info.decode(r100));
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
        public int encodedSize2(GetMentionChatterSensitiveInfoResponse r100) {
            return this.chatter_id_to_sensitive_info.encodedSizeWithTag(1, r100.chatter_id_to_sensitive_info) + r100.unknownFields().size();
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ GetMentionChatterSensitiveInfoResponse decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(GetMentionChatterSensitiveInfoResponse r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, GetMentionChatterSensitiveInfoResponse r101) throws IOException {
            this.chatter_id_to_sensitive_info.encodeWithTag(r100, 1, r101.chatter_id_to_sensitive_info);
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, GetMentionChatterSensitiveInfoResponse r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ProtoAdapter_GetMentionChatterSensitiveInfoResponse r100 = new ProtoAdapter_GetMentionChatterSensitiveInfoResponse();
        RAW_TYPE_ADAPTER = r100;
        ADAPTER = r100;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.chatter_id_to_sensitive_info = Internal.copyOf("chatter_id_to_sensitive_info", this.chatter_id_to_sensitive_info);
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return GetMentionChatterSensitiveInfoResponse.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public GetMentionChatterSensitiveInfoResponse(Map<Long, ChatterSensitiveInfo> r100) {
        this(r100, ByteString.EMPTY);
    }

    public GetMentionChatterSensitiveInfoResponse(Map<Long, ChatterSensitiveInfo> r100, ByteString r101) {
        super(ADAPTER, r101);
        this.chatter_id_to_sensitive_info = Internal.immutableCopyOf("chatter_id_to_sensitive_info", r100);
    }
}
