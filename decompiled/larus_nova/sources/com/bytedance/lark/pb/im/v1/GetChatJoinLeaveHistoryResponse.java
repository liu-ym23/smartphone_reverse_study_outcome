package com.bytedance.lark.pb.im.v1;

import com.bytedance.lark.pb.basic.v1.ChatJoinLeaveHistory;
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
public final class GetChatJoinLeaveHistoryResponse extends Message<GetChatJoinLeaveHistoryResponse, Builder> {
    public static final ProtoAdapter<GetChatJoinLeaveHistoryResponse> ADAPTER = null;
    public static final Boolean DEFAULT_HAS_MORE = null;
    public static final String DEFAULT_NEXT_CURSOR = "";
    public static final ProtoAdapter_GetChatJoinLeaveHistoryResponse RAW_TYPE_ADAPTER = null;
    private static final long serialVersionUID = 0;
    public final List<ChatJoinLeaveHistory> chatter_history;
    public final Boolean has_more;
    public final String next_cursor;

    public static final class Builder extends Message.Builder<GetChatJoinLeaveHistoryResponse, Builder> implements d<GetChatJoinLeaveHistoryResponse> {
        public List<ChatJoinLeaveHistory> chatter_history;
        public Boolean has_more;
        public String next_cursor;

        @Override // com.squareup.wire.Message.Builder
        public GetChatJoinLeaveHistoryResponse build() {
            return new GetChatJoinLeaveHistoryResponse(this.chatter_history, this.has_more, this.next_cursor, super.buildUnknownFields());
        }

        public Builder() {
            this.chatter_history = Internal.newMutableList();
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder chatter_history(List<ChatJoinLeaveHistory> r100) {
            Internal.checkElementsNotNull(r100);
            this.chatter_history = r100;
            return this;
        }

        public Builder has_more(Boolean r100) {
            this.has_more = r100;
            return this;
        }

        public Builder next_cursor(String r100) {
            this.next_cursor = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_GetChatJoinLeaveHistoryResponse extends ProtoAdapter<GetChatJoinLeaveHistoryResponse> implements c<GetChatJoinLeaveHistoryResponse> {
        public ProtoAdapter_GetChatJoinLeaveHistoryResponse() {
            super(FieldEncoding.LENGTH_DELIMITED, GetChatJoinLeaveHistoryResponse.class);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public GetChatJoinLeaveHistoryResponse decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            r101.has_more = Boolean.FALSE;
            r101.next_cursor = "";
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L15;
            if (r103 != 1) goto L8;
            r101.chatter_history.add(ChatJoinLeaveHistory.ADAPTER.decode(r100));
            goto L3
        L8:
            if (r103 != 2) goto L10;
            r101.has_more = ProtoAdapter.BOOL.decode(r100);
            goto L3
        L10:
            if (r103 != 3) goto L11;
            r101.next_cursor = ProtoAdapter.STRING.decode(r100);
            goto L3
        L11:
            FieldEncoding r104 = r100.peekFieldEncoding();
            r101.addUnknownField(r103, r104, r104.rawProtoAdapter().decode(r100));
            goto L3
        L15:
            r100.endMessage(r102);
            return r101.build();
        }

        /* JADX INFO: renamed from: encodedSize, reason: avoid collision after fix types in other method */
        public int encodedSize2(GetChatJoinLeaveHistoryResponse r100) {
            int r101 = ChatJoinLeaveHistory.ADAPTER.asRepeated().encodedSizeWithTag(1, r100.chatter_history);
            Boolean r102 = r100.has_more;
            int r103 = 0;
            if (r102 == null) goto L5;
            int r104 = ProtoAdapter.BOOL.encodedSizeWithTag(2, r102);
        L6:
            int r105 = r101 + r104;
            String r106 = r100.next_cursor;
            if (r106 == null) goto L10;
            r103 = ProtoAdapter.STRING.encodedSizeWithTag(3, r106);
        L10:
            return (r105 + r103) + r100.unknownFields().size();
        L5:
            r104 = 0;
            goto L6
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ GetChatJoinLeaveHistoryResponse decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(GetChatJoinLeaveHistoryResponse r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, GetChatJoinLeaveHistoryResponse r101) throws IOException {
            ChatJoinLeaveHistory.ADAPTER.asRepeated().encodeWithTag(r100, 1, r101.chatter_history);
            Boolean r102 = r101.has_more;
            if (r102 == null) goto L5;
            ProtoAdapter.BOOL.encodeWithTag(r100, 2, r102);
        L5:
            String r103 = r101.next_cursor;
            if (r103 == null) goto L8;
            ProtoAdapter.STRING.encodeWithTag(r100, 3, r103);
        L8:
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, GetChatJoinLeaveHistoryResponse r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ProtoAdapter_GetChatJoinLeaveHistoryResponse r100 = new ProtoAdapter_GetChatJoinLeaveHistoryResponse();
        RAW_TYPE_ADAPTER = r100;
        ADAPTER = r100;
        DEFAULT_HAS_MORE = Boolean.FALSE;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.chatter_history = Internal.copyOf("chatter_history", this.chatter_history);
        r100.has_more = this.has_more;
        r100.next_cursor = this.next_cursor;
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return GetChatJoinLeaveHistoryResponse.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public GetChatJoinLeaveHistoryResponse(List<ChatJoinLeaveHistory> r100, Boolean r101, String r102) {
        this(r100, r101, r102, ByteString.EMPTY);
    }

    public GetChatJoinLeaveHistoryResponse(List<ChatJoinLeaveHistory> r100, Boolean r101, String r102, ByteString r103) {
        super(ADAPTER, r103);
        this.chatter_history = Internal.immutableCopyOf("chatter_history", r100);
        this.has_more = r101;
        this.next_cursor = r102;
    }
}
