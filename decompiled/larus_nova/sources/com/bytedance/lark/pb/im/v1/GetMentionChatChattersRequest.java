package com.bytedance.lark.pb.im.v1;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import com.squareup.wire.internal.Internal;
import java.io.IOException;
import okio.ByteString;
import we6.c;
import we6.d;

/* JADX INFO: loaded from: classes20.dex */
public final class GetMentionChatChattersRequest extends Message<GetMentionChatChattersRequest, Builder> {
    public static final ProtoAdapter<GetMentionChatChattersRequest> ADAPTER = null;
    public static final String DEFAULT_CHAT_ID = "";
    public static final Boolean DEFAULT_ENABLEAIKNOWLEDGE = null;
    public static final Boolean DEFAULT_IS_FROM_SERVER = null;
    public static final String DEFAULT_QUERY = "";
    public static final ProtoAdapter_GetMentionChatChattersRequest RAW_TYPE_ADAPTER = null;
    private static final long serialVersionUID = 0;
    public final String chat_id;
    public final Boolean enableAiKnowledge;
    public final Boolean is_from_server;
    public final String query;

    public static final class Builder extends Message.Builder<GetMentionChatChattersRequest, Builder> implements d<GetMentionChatChattersRequest> {
        public String chat_id;
        public Boolean enableAiKnowledge;
        public Boolean is_from_server;
        public String query;

        @Override // com.squareup.wire.Message.Builder
        public GetMentionChatChattersRequest build() {
            String r100 = this.chat_id;
            if (r100 == null) goto L7;
            return new GetMentionChatChattersRequest(this.chat_id, this.is_from_server, this.query, this.enableAiKnowledge, super.buildUnknownFields());
        L7:
            throw Internal.missingRequiredFields(new Object[]{r100, "chat_id"});
        }

        public Builder() {
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder chat_id(String r100) {
            this.chat_id = r100;
            return this;
        }

        public Builder enableAiKnowledge(Boolean r100) {
            this.enableAiKnowledge = r100;
            return this;
        }

        public Builder is_from_server(Boolean r100) {
            this.is_from_server = r100;
            return this;
        }

        public Builder query(String r100) {
            this.query = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_GetMentionChatChattersRequest extends ProtoAdapter<GetMentionChatChattersRequest> implements c<GetMentionChatChattersRequest> {
        public ProtoAdapter_GetMentionChatChattersRequest() {
            super(FieldEncoding.LENGTH_DELIMITED, GetMentionChatChattersRequest.class);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public GetMentionChatChattersRequest decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            r101.chat_id = "";
            r101.is_from_server = Boolean.TRUE;
            r101.query = "";
            r101.enableAiKnowledge = Boolean.FALSE;
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L18;
            if (r103 != 1) goto L8;
            r101.chat_id = ProtoAdapter.STRING.decode(r100);
            goto L3
        L8:
            if (r103 != 2) goto L10;
            r101.is_from_server = ProtoAdapter.BOOL.decode(r100);
            goto L3
        L10:
            if (r103 != 3) goto L12;
            r101.query = ProtoAdapter.STRING.decode(r100);
            goto L3
        L12:
            if (r103 != 4) goto L13;
            r101.enableAiKnowledge = ProtoAdapter.BOOL.decode(r100);
            goto L3
        L13:
            FieldEncoding r104 = r100.peekFieldEncoding();
            r101.addUnknownField(r103, r104, r104.rawProtoAdapter().decode(r100));
            goto L3
        L18:
            r100.endMessage(r102);
            return r101.build();
        }

        /* JADX INFO: renamed from: encodedSize, reason: avoid collision after fix types in other method */
        public int encodedSize2(GetMentionChatChattersRequest r100) {
            ProtoAdapter<String> r101 = ProtoAdapter.STRING;
            int r102 = r101.encodedSizeWithTag(1, r100.chat_id);
            Boolean r103 = r100.is_from_server;
            int r104 = 0;
            if (r103 == null) goto L5;
            int r105 = ProtoAdapter.BOOL.encodedSizeWithTag(2, r103);
        L6:
            int r106 = r102 + r105;
            String r107 = r100.query;
            if (r107 == null) goto L9;
            int r108 = r101.encodedSizeWithTag(3, r107);
        L10:
            int r109 = r106 + r108;
            Boolean r110 = r100.enableAiKnowledge;
            if (r110 == null) goto L14;
            r104 = ProtoAdapter.BOOL.encodedSizeWithTag(4, r110);
        L14:
            return (r109 + r104) + r100.unknownFields().size();
        L9:
            r108 = 0;
            goto L10
        L5:
            r105 = 0;
            goto L6
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ GetMentionChatChattersRequest decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(GetMentionChatChattersRequest r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, GetMentionChatChattersRequest r101) throws IOException {
            ProtoAdapter<String> r102 = ProtoAdapter.STRING;
            r102.encodeWithTag(r100, 1, r101.chat_id);
            Boolean r103 = r101.is_from_server;
            if (r103 == null) goto L5;
            ProtoAdapter.BOOL.encodeWithTag(r100, 2, r103);
        L5:
            String r104 = r101.query;
            if (r104 == null) goto L8;
            r102.encodeWithTag(r100, 3, r104);
        L8:
            Boolean r105 = r101.enableAiKnowledge;
            if (r105 == null) goto L11;
            ProtoAdapter.BOOL.encodeWithTag(r100, 4, r105);
        L11:
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, GetMentionChatChattersRequest r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ProtoAdapter_GetMentionChatChattersRequest r100 = new ProtoAdapter_GetMentionChatChattersRequest();
        RAW_TYPE_ADAPTER = r100;
        ADAPTER = r100;
        DEFAULT_IS_FROM_SERVER = Boolean.TRUE;
        DEFAULT_ENABLEAIKNOWLEDGE = Boolean.FALSE;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.chat_id = this.chat_id;
        r100.is_from_server = this.is_from_server;
        r100.query = this.query;
        r100.enableAiKnowledge = this.enableAiKnowledge;
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return GetMentionChatChattersRequest.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public GetMentionChatChattersRequest(String r100, Boolean r101, String r102, Boolean r110) {
        this(r100, r101, r102, r110, ByteString.EMPTY);
    }

    public GetMentionChatChattersRequest(String r100, Boolean r101, String r102, Boolean r103, ByteString r104) {
        super(ADAPTER, r104);
        this.chat_id = r100;
        this.is_from_server = r101;
        this.query = r102;
        this.enableAiKnowledge = r103;
    }
}
