package com.bytedance.lark.pb.im.v1;

import com.bytedance.lark.pb.basic.v1.Content;
import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import com.squareup.wire.internal.Internal;
import java.io.IOException;
import java.util.List;
import okio.ByteString;
import we6.c;
import we6.d;

/* JADX INFO: loaded from: classes20.dex */
public final class GetMessageActionPayloadResponse extends Message<GetMessageActionPayloadResponse, Builder> {
    public static final ProtoAdapter<GetMessageActionPayloadResponse> ADAPTER = null;
    public static final Content.SystemMessageAction.ActType DEFAULT_ACTION_TYPE = null;
    public static final String DEFAULT_URL = "";
    public static final ProtoAdapter_GetMessageActionPayloadResponse RAW_TYPE_ADAPTER = null;
    private static final long serialVersionUID = 0;
    public final Content.SystemMessageAction.ActType action_type;
    public final List<String> at_chatter_ids;
    public final String url;

    public static final class Builder extends Message.Builder<GetMessageActionPayloadResponse, Builder> implements d<GetMessageActionPayloadResponse> {
        public Content.SystemMessageAction.ActType action_type;
        public List<String> at_chatter_ids;
        public String url;

        @Override // com.squareup.wire.Message.Builder
        public GetMessageActionPayloadResponse build() {
            Content.SystemMessageAction.ActType r100 = this.action_type;
            if (r100 == null) goto L7;
            return new GetMessageActionPayloadResponse(this.action_type, this.at_chatter_ids, this.url, super.buildUnknownFields());
        L7:
            throw Internal.missingRequiredFields(new Object[]{r100, "action_type"});
        }

        public Builder() {
            this.at_chatter_ids = Internal.newMutableList();
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder action_type(Content.SystemMessageAction.ActType r100) {
            this.action_type = r100;
            return this;
        }

        public Builder at_chatter_ids(List<String> r100) {
            Internal.checkElementsNotNull(r100);
            this.at_chatter_ids = r100;
            return this;
        }

        public Builder url(String r100) {
            this.url = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_GetMessageActionPayloadResponse extends ProtoAdapter<GetMessageActionPayloadResponse> implements c<GetMessageActionPayloadResponse> {
        public ProtoAdapter_GetMessageActionPayloadResponse() {
            super(FieldEncoding.LENGTH_DELIMITED, GetMessageActionPayloadResponse.class);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public GetMessageActionPayloadResponse decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            r101.action_type = Content.SystemMessageAction.ActType.UNKNOWN_ACT_TYPE;
            r101.url = "";
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L18;
            if (r103 != 1) goto L8;
            r101.action_type = Content.SystemMessageAction.ActType.ADAPTER.decode(r100);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L16
        L16:
            e = move-exception;
            r101.addUnknownField(r103, FieldEncoding.VARINT, Long.valueOf(e.value));
            goto L3
        L8:
            if (r103 != 2) goto L10;
            r101.at_chatter_ids.add(ProtoAdapter.STRING.decode(r100));
            goto L3
        L10:
            if (r103 != 3) goto L11;
            r101.url = ProtoAdapter.STRING.decode(r100);
            goto L3
        L11:
            FieldEncoding r104 = r100.peekFieldEncoding();
            r101.addUnknownField(r103, r104, r104.rawProtoAdapter().decode(r100));
            goto L3
        L18:
            r100.endMessage(r102);
            return r101.build();
        }

        /* JADX INFO: renamed from: encodedSize, reason: avoid collision after fix types in other method */
        public int encodedSize2(GetMessageActionPayloadResponse r100) {
            int r101 = Content.SystemMessageAction.ActType.ADAPTER.encodedSizeWithTag(1, r100.action_type);
            ProtoAdapter<String> r102 = ProtoAdapter.STRING;
            int r103 = r101 + r102.asRepeated().encodedSizeWithTag(2, r100.at_chatter_ids);
            String r104 = r100.url;
            if (r104 == null) goto L5;
            int r105 = r102.encodedSizeWithTag(3, r104);
        L7:
            return (r103 + r105) + r100.unknownFields().size();
        L5:
            r105 = 0;
            goto L7
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ GetMessageActionPayloadResponse decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(GetMessageActionPayloadResponse r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, GetMessageActionPayloadResponse r101) throws IOException {
            Content.SystemMessageAction.ActType.ADAPTER.encodeWithTag(r100, 1, r101.action_type);
            ProtoAdapter<String> r102 = ProtoAdapter.STRING;
            r102.asRepeated().encodeWithTag(r100, 2, r101.at_chatter_ids);
            String r103 = r101.url;
            if (r103 == null) goto L5;
            r102.encodeWithTag(r100, 3, r103);
        L5:
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, GetMessageActionPayloadResponse r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ProtoAdapter_GetMessageActionPayloadResponse r100 = new ProtoAdapter_GetMessageActionPayloadResponse();
        RAW_TYPE_ADAPTER = r100;
        ADAPTER = r100;
        DEFAULT_ACTION_TYPE = Content.SystemMessageAction.ActType.UNKNOWN_ACT_TYPE;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.action_type = this.action_type;
        r100.at_chatter_ids = Internal.copyOf("at_chatter_ids", this.at_chatter_ids);
        r100.url = this.url;
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return GetMessageActionPayloadResponse.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public GetMessageActionPayloadResponse(Content.SystemMessageAction.ActType r100, List<String> r101, String r102) {
        this(r100, r101, r102, ByteString.EMPTY);
    }

    public GetMessageActionPayloadResponse(Content.SystemMessageAction.ActType r100, List<String> r101, String r102, ByteString r103) {
        super(ADAPTER, r103);
        this.action_type = r100;
        this.at_chatter_ids = Internal.immutableCopyOf("at_chatter_ids", r101);
        this.url = r102;
    }
}
