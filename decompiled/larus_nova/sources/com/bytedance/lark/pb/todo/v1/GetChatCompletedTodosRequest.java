package com.bytedance.lark.pb.todo.v1;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import java.io.IOException;
import okio.ByteString;
import we6.c;
import we6.d;

/* JADX INFO: loaded from: classes20.dex */
public final class GetChatCompletedTodosRequest extends Message<GetChatCompletedTodosRequest, Builder> {
    public static final ProtoAdapter<GetChatCompletedTodosRequest> ADAPTER = null;
    public static final String DEFAULT_CHAT_ID = "";
    public static final Long DEFAULT_LAST_OFFSET = null;
    public static final Integer DEFAULT_PAGE_COUNT = null;
    public static final ProtoAdapter_GetChatCompletedTodosRequest RAW_TYPE_ADAPTER = null;
    private static final long serialVersionUID = 0;
    public final String chat_id;
    public final Long last_offset;
    public final Integer page_count;

    public static final class Builder extends Message.Builder<GetChatCompletedTodosRequest, Builder> implements d<GetChatCompletedTodosRequest> {
        public String chat_id;
        public Long last_offset;
        public Integer page_count;

        @Override // com.squareup.wire.Message.Builder
        public GetChatCompletedTodosRequest build() {
            return new GetChatCompletedTodosRequest(this.chat_id, this.page_count, this.last_offset, super.buildUnknownFields());
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

        public Builder last_offset(Long r100) {
            this.last_offset = r100;
            return this;
        }

        public Builder page_count(Integer r100) {
            this.page_count = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_GetChatCompletedTodosRequest extends ProtoAdapter<GetChatCompletedTodosRequest> implements c<GetChatCompletedTodosRequest> {
        public ProtoAdapter_GetChatCompletedTodosRequest() {
            super(FieldEncoding.LENGTH_DELIMITED, GetChatCompletedTodosRequest.class);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public GetChatCompletedTodosRequest decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            r101.chat_id = "";
            r101.page_count = 20;
            r101.last_offset = 0L;
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L15;
            if (r103 != 1) goto L8;
            r101.chat_id = ProtoAdapter.STRING.decode(r100);
            goto L3
        L8:
            if (r103 != 2) goto L10;
            r101.page_count = ProtoAdapter.INT32.decode(r100);
            goto L3
        L10:
            if (r103 != 3) goto L11;
            r101.last_offset = ProtoAdapter.INT64.decode(r100);
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
        public int encodedSize2(GetChatCompletedTodosRequest r100) {
            String r101 = r100.chat_id;
            int r102 = 0;
            if (r101 == null) goto L5;
            int r103 = ProtoAdapter.STRING.encodedSizeWithTag(1, r101);
        L6:
            Integer r104 = r100.page_count;
            if (r104 == null) goto L9;
            int r105 = ProtoAdapter.INT32.encodedSizeWithTag(2, r104);
        L10:
            int r106 = r103 + r105;
            Long r107 = r100.last_offset;
            if (r107 == null) goto L14;
            r102 = ProtoAdapter.INT64.encodedSizeWithTag(3, r107);
        L14:
            return (r106 + r102) + r100.unknownFields().size();
        L9:
            r105 = 0;
            goto L10
        L5:
            r103 = 0;
            goto L6
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ GetChatCompletedTodosRequest decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(GetChatCompletedTodosRequest r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, GetChatCompletedTodosRequest r101) throws IOException {
            String r102 = r101.chat_id;
            if (r102 == null) goto L5;
            ProtoAdapter.STRING.encodeWithTag(r100, 1, r102);
        L5:
            Integer r103 = r101.page_count;
            if (r103 == null) goto L8;
            ProtoAdapter.INT32.encodeWithTag(r100, 2, r103);
        L8:
            Long r104 = r101.last_offset;
            if (r104 == null) goto L11;
            ProtoAdapter.INT64.encodeWithTag(r100, 3, r104);
        L11:
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, GetChatCompletedTodosRequest r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ProtoAdapter_GetChatCompletedTodosRequest r100 = new ProtoAdapter_GetChatCompletedTodosRequest();
        RAW_TYPE_ADAPTER = r100;
        ADAPTER = r100;
        DEFAULT_PAGE_COUNT = 20;
        DEFAULT_LAST_OFFSET = 0L;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.chat_id = this.chat_id;
        r100.page_count = this.page_count;
        r100.last_offset = this.last_offset;
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return GetChatCompletedTodosRequest.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public GetChatCompletedTodosRequest(String r100, Integer r101, Long r102) {
        this(r100, r101, r102, ByteString.EMPTY);
    }

    public GetChatCompletedTodosRequest(String r100, Integer r101, Long r102, ByteString r103) {
        super(ADAPTER, r103);
        this.chat_id = r100;
        this.page_count = r101;
        this.last_offset = r102;
    }
}
