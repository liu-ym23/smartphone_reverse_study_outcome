package com.bytedance.lark.pb.contact.v2;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import com.squareup.wire.internal.Internal;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import okio.ByteString;
import we6.c;
import we6.d;

/* JADX INFO: loaded from: classes20.dex */
public final class GetUserChatWindowFieldsResponse extends Message<GetUserChatWindowFieldsResponse, Builder> {
    public static final ProtoAdapter<GetUserChatWindowFieldsResponse> ADAPTER = null;
    public static final ProtoAdapter_GetUserChatWindowFieldsResponse RAW_TYPE_ADAPTER = null;
    private static final long serialVersionUID = 0;
    public final Map<String, ChatWindowFields> chat_window_fields;
    public final List<String> old_data_user_ids;

    public static final class Builder extends Message.Builder<GetUserChatWindowFieldsResponse, Builder> implements d<GetUserChatWindowFieldsResponse> {
        public Map<String, ChatWindowFields> chat_window_fields;
        public List<String> old_data_user_ids;

        @Override // com.squareup.wire.Message.Builder
        public GetUserChatWindowFieldsResponse build() {
            return new GetUserChatWindowFieldsResponse(this.chat_window_fields, this.old_data_user_ids, super.buildUnknownFields());
        }

        public Builder() {
            this.chat_window_fields = Internal.newMutableMap();
            this.old_data_user_ids = Internal.newMutableList();
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder chat_window_fields(Map<String, ChatWindowFields> r100) {
            Internal.checkElementsNotNull(r100);
            this.chat_window_fields = r100;
            return this;
        }

        public Builder old_data_user_ids(List<String> r100) {
            Internal.checkElementsNotNull(r100);
            this.old_data_user_ids = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_GetUserChatWindowFieldsResponse extends ProtoAdapter<GetUserChatWindowFieldsResponse> implements c<GetUserChatWindowFieldsResponse> {
        private final ProtoAdapter<Map<String, ChatWindowFields>> chat_window_fields;

        public ProtoAdapter_GetUserChatWindowFieldsResponse() {
            super(FieldEncoding.LENGTH_DELIMITED, GetUserChatWindowFieldsResponse.class);
            this.chat_window_fields = ProtoAdapter.newMapAdapter(ProtoAdapter.STRING, ChatWindowFields.ADAPTER);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public GetUserChatWindowFieldsResponse decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L12;
            if (r103 != 1) goto L8;
            r101.chat_window_fields.putAll(this.chat_window_fields.decode(r100));
            goto L3
        L8:
            if (r103 != 2) goto L9;
            r101.old_data_user_ids.add(ProtoAdapter.STRING.decode(r100));
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
        public int encodedSize2(GetUserChatWindowFieldsResponse r100) {
            return (this.chat_window_fields.encodedSizeWithTag(1, r100.chat_window_fields) + ProtoAdapter.STRING.asRepeated().encodedSizeWithTag(2, r100.old_data_user_ids)) + r100.unknownFields().size();
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ GetUserChatWindowFieldsResponse decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(GetUserChatWindowFieldsResponse r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, GetUserChatWindowFieldsResponse r101) throws IOException {
            this.chat_window_fields.encodeWithTag(r100, 1, r101.chat_window_fields);
            ProtoAdapter.STRING.asRepeated().encodeWithTag(r100, 2, r101.old_data_user_ids);
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, GetUserChatWindowFieldsResponse r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ProtoAdapter_GetUserChatWindowFieldsResponse r100 = new ProtoAdapter_GetUserChatWindowFieldsResponse();
        RAW_TYPE_ADAPTER = r100;
        ADAPTER = r100;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.chat_window_fields = Internal.copyOf("chat_window_fields", this.chat_window_fields);
        r100.old_data_user_ids = Internal.copyOf("old_data_user_ids", this.old_data_user_ids);
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return GetUserChatWindowFieldsResponse.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public GetUserChatWindowFieldsResponse(Map<String, ChatWindowFields> r100, List<String> r101) {
        this(r100, r101, ByteString.EMPTY);
    }

    public GetUserChatWindowFieldsResponse(Map<String, ChatWindowFields> r100, List<String> r101, ByteString r102) {
        super(ADAPTER, r102);
        this.chat_window_fields = Internal.immutableCopyOf("chat_window_fields", r100);
        this.old_data_user_ids = Internal.immutableCopyOf("old_data_user_ids", r101);
    }
}
