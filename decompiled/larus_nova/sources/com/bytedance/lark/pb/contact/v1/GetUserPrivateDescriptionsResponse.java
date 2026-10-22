package com.bytedance.lark.pb.contact.v1;

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
public final class GetUserPrivateDescriptionsResponse extends Message<GetUserPrivateDescriptionsResponse, Builder> {
    public static final ProtoAdapter<GetUserPrivateDescriptionsResponse> ADAPTER = null;
    public static final ProtoAdapter_GetUserPrivateDescriptionsResponse RAW_TYPE_ADAPTER = null;
    private static final long serialVersionUID = 0;
    public final Map<Long, PrivateDescriptionItem> user_private_descriptions;

    public static final class Builder extends Message.Builder<GetUserPrivateDescriptionsResponse, Builder> implements d<GetUserPrivateDescriptionsResponse> {
        public Map<Long, PrivateDescriptionItem> user_private_descriptions;

        @Override // com.squareup.wire.Message.Builder
        public GetUserPrivateDescriptionsResponse build() {
            return new GetUserPrivateDescriptionsResponse(this.user_private_descriptions, super.buildUnknownFields());
        }

        public Builder() {
            this.user_private_descriptions = Internal.newMutableMap();
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder user_private_descriptions(Map<Long, PrivateDescriptionItem> r100) {
            Internal.checkElementsNotNull(r100);
            this.user_private_descriptions = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_GetUserPrivateDescriptionsResponse extends ProtoAdapter<GetUserPrivateDescriptionsResponse> implements c<GetUserPrivateDescriptionsResponse> {
        private final ProtoAdapter<Map<Long, PrivateDescriptionItem>> user_private_descriptions;

        public ProtoAdapter_GetUserPrivateDescriptionsResponse() {
            super(FieldEncoding.LENGTH_DELIMITED, GetUserPrivateDescriptionsResponse.class);
            this.user_private_descriptions = ProtoAdapter.newMapAdapter(ProtoAdapter.INT64, PrivateDescriptionItem.ADAPTER);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public GetUserPrivateDescriptionsResponse decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L9;
            if (r103 != 1) goto L7;
            r101.user_private_descriptions.putAll(this.user_private_descriptions.decode(r100));
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
        public int encodedSize2(GetUserPrivateDescriptionsResponse r100) {
            return this.user_private_descriptions.encodedSizeWithTag(1, r100.user_private_descriptions) + r100.unknownFields().size();
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ GetUserPrivateDescriptionsResponse decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(GetUserPrivateDescriptionsResponse r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, GetUserPrivateDescriptionsResponse r101) throws IOException {
            this.user_private_descriptions.encodeWithTag(r100, 1, r101.user_private_descriptions);
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, GetUserPrivateDescriptionsResponse r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ProtoAdapter_GetUserPrivateDescriptionsResponse r100 = new ProtoAdapter_GetUserPrivateDescriptionsResponse();
        RAW_TYPE_ADAPTER = r100;
        ADAPTER = r100;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.user_private_descriptions = Internal.copyOf("user_private_descriptions", this.user_private_descriptions);
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return GetUserPrivateDescriptionsResponse.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public GetUserPrivateDescriptionsResponse(Map<Long, PrivateDescriptionItem> r100) {
        this(r100, ByteString.EMPTY);
    }

    public GetUserPrivateDescriptionsResponse(Map<Long, PrivateDescriptionItem> r100, ByteString r101) {
        super(ADAPTER, r101);
        this.user_private_descriptions = Internal.immutableCopyOf("user_private_descriptions", r100);
    }
}
