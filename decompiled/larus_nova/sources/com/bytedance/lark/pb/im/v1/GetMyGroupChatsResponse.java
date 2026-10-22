package com.bytedance.lark.pb.im.v1;

import com.bytedance.lark.pb.basic.v1.Chat;
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
public final class GetMyGroupChatsResponse extends Message<GetMyGroupChatsResponse, Builder> {
    public static final ProtoAdapter<GetMyGroupChatsResponse> ADAPTER = null;
    public static final Boolean DEFAULT_HAS_MORE = null;
    public static final Long DEFAULT_MIN_TIME = null;
    public static final Integer DEFAULT_TOTAL_COUNT = null;
    public static final ProtoAdapter_GetMyGroupChatsResponse RAW_TYPE_ADAPTER = null;
    private static final long serialVersionUID = 0;
    public final List<Chat> chats;
    public final Boolean has_more;
    public final Long min_time;
    public final Integer total_count;

    public static final class Builder extends Message.Builder<GetMyGroupChatsResponse, Builder> implements d<GetMyGroupChatsResponse> {
        public List<Chat> chats;
        public Boolean has_more;
        public Long min_time;
        public Integer total_count;

        @Override // com.squareup.wire.Message.Builder
        public GetMyGroupChatsResponse build() {
            return new GetMyGroupChatsResponse(this.chats, this.min_time, this.has_more, this.total_count, super.buildUnknownFields());
        }

        public Builder() {
            this.chats = Internal.newMutableList();
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder chats(List<Chat> r100) {
            Internal.checkElementsNotNull(r100);
            this.chats = r100;
            return this;
        }

        public Builder has_more(Boolean r100) {
            this.has_more = r100;
            return this;
        }

        public Builder min_time(Long r100) {
            this.min_time = r100;
            return this;
        }

        public Builder total_count(Integer r100) {
            this.total_count = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_GetMyGroupChatsResponse extends ProtoAdapter<GetMyGroupChatsResponse> implements c<GetMyGroupChatsResponse> {
        public ProtoAdapter_GetMyGroupChatsResponse() {
            super(FieldEncoding.LENGTH_DELIMITED, GetMyGroupChatsResponse.class);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public GetMyGroupChatsResponse decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            r101.min_time = 0L;
            r101.has_more = Boolean.FALSE;
            r101.total_count = 0;
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L18;
            if (r103 != 1) goto L8;
            r101.chats.add(Chat.ADAPTER.decode(r100));
            goto L3
        L8:
            if (r103 != 2) goto L10;
            r101.min_time = ProtoAdapter.INT64.decode(r100);
            goto L3
        L10:
            if (r103 != 3) goto L12;
            r101.has_more = ProtoAdapter.BOOL.decode(r100);
            goto L3
        L12:
            if (r103 != 4) goto L13;
            r101.total_count = ProtoAdapter.INT32.decode(r100);
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
        public int encodedSize2(GetMyGroupChatsResponse r100) {
            int r101 = Chat.ADAPTER.asRepeated().encodedSizeWithTag(1, r100.chats);
            Long r102 = r100.min_time;
            int r103 = 0;
            if (r102 == null) goto L5;
            int r104 = ProtoAdapter.INT64.encodedSizeWithTag(2, r102);
        L6:
            int r105 = r101 + r104;
            Boolean r106 = r100.has_more;
            if (r106 == null) goto L9;
            int r107 = ProtoAdapter.BOOL.encodedSizeWithTag(3, r106);
        L10:
            int r108 = r105 + r107;
            Integer r109 = r100.total_count;
            if (r109 == null) goto L14;
            r103 = ProtoAdapter.INT32.encodedSizeWithTag(4, r109);
        L14:
            return (r108 + r103) + r100.unknownFields().size();
        L9:
            r107 = 0;
            goto L10
        L5:
            r104 = 0;
            goto L6
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ GetMyGroupChatsResponse decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(GetMyGroupChatsResponse r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, GetMyGroupChatsResponse r101) throws IOException {
            Chat.ADAPTER.asRepeated().encodeWithTag(r100, 1, r101.chats);
            Long r102 = r101.min_time;
            if (r102 == null) goto L5;
            ProtoAdapter.INT64.encodeWithTag(r100, 2, r102);
        L5:
            Boolean r103 = r101.has_more;
            if (r103 == null) goto L8;
            ProtoAdapter.BOOL.encodeWithTag(r100, 3, r103);
        L8:
            Integer r104 = r101.total_count;
            if (r104 == null) goto L11;
            ProtoAdapter.INT32.encodeWithTag(r100, 4, r104);
        L11:
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, GetMyGroupChatsResponse r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ProtoAdapter_GetMyGroupChatsResponse r100 = new ProtoAdapter_GetMyGroupChatsResponse();
        RAW_TYPE_ADAPTER = r100;
        ADAPTER = r100;
        DEFAULT_MIN_TIME = 0L;
        DEFAULT_HAS_MORE = Boolean.FALSE;
        DEFAULT_TOTAL_COUNT = 0;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.chats = Internal.copyOf("chats", this.chats);
        r100.min_time = this.min_time;
        r100.has_more = this.has_more;
        r100.total_count = this.total_count;
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return GetMyGroupChatsResponse.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public GetMyGroupChatsResponse(List<Chat> r100, Long r101, Boolean r102, Integer r110) {
        this(r100, r101, r102, r110, ByteString.EMPTY);
    }

    public GetMyGroupChatsResponse(List<Chat> r100, Long r101, Boolean r102, Integer r103, ByteString r104) {
        super(ADAPTER, r104);
        this.chats = Internal.immutableCopyOf("chats", r100);
        this.min_time = r101;
        this.has_more = r102;
        this.total_count = r103;
    }
}
