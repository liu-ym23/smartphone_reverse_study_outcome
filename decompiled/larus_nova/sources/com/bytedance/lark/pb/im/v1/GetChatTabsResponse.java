package com.bytedance.lark.pb.im.v1;

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
public final class GetChatTabsResponse extends Message<GetChatTabsResponse, Builder> {
    public static final ProtoAdapter<GetChatTabsResponse> ADAPTER = null;
    public static final Long DEFAULT_VERSION = null;
    public static final ProtoAdapter_GetChatTabsResponse RAW_TYPE_ADAPTER = null;
    private static final long serialVersionUID = 0;
    public final List<ChatTab> tabs;
    public final Long version;

    public static final class Builder extends Message.Builder<GetChatTabsResponse, Builder> implements d<GetChatTabsResponse> {
        public List<ChatTab> tabs;
        public Long version;

        @Override // com.squareup.wire.Message.Builder
        public GetChatTabsResponse build() {
            return new GetChatTabsResponse(this.tabs, this.version, super.buildUnknownFields());
        }

        public Builder() {
            this.tabs = Internal.newMutableList();
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder tabs(List<ChatTab> r100) {
            Internal.checkElementsNotNull(r100);
            this.tabs = r100;
            return this;
        }

        public Builder version(Long r100) {
            this.version = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_GetChatTabsResponse extends ProtoAdapter<GetChatTabsResponse> implements c<GetChatTabsResponse> {
        public ProtoAdapter_GetChatTabsResponse() {
            super(FieldEncoding.LENGTH_DELIMITED, GetChatTabsResponse.class);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public GetChatTabsResponse decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            r101.version = 0L;
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L12;
            if (r103 != 1) goto L8;
            r101.tabs.add(ChatTab.ADAPTER.decode(r100));
            goto L3
        L8:
            if (r103 != 2) goto L9;
            r101.version = ProtoAdapter.INT64.decode(r100);
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
        public int encodedSize2(GetChatTabsResponse r100) {
            int r101 = ChatTab.ADAPTER.asRepeated().encodedSizeWithTag(1, r100.tabs);
            Long r102 = r100.version;
            if (r102 == null) goto L5;
            int r103 = ProtoAdapter.INT64.encodedSizeWithTag(2, r102);
        L7:
            return (r101 + r103) + r100.unknownFields().size();
        L5:
            r103 = 0;
            goto L7
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ GetChatTabsResponse decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(GetChatTabsResponse r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, GetChatTabsResponse r101) throws IOException {
            ChatTab.ADAPTER.asRepeated().encodeWithTag(r100, 1, r101.tabs);
            Long r102 = r101.version;
            if (r102 == null) goto L5;
            ProtoAdapter.INT64.encodeWithTag(r100, 2, r102);
        L5:
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, GetChatTabsResponse r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ProtoAdapter_GetChatTabsResponse r100 = new ProtoAdapter_GetChatTabsResponse();
        RAW_TYPE_ADAPTER = r100;
        ADAPTER = r100;
        DEFAULT_VERSION = 0L;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.tabs = Internal.copyOf("tabs", this.tabs);
        r100.version = this.version;
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return GetChatTabsResponse.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public GetChatTabsResponse(List<ChatTab> r100, Long r101) {
        this(r100, r101, ByteString.EMPTY);
    }

    public GetChatTabsResponse(List<ChatTab> r100, Long r101, ByteString r102) {
        super(ADAPTER, r102);
        this.tabs = Internal.immutableCopyOf("tabs", r100);
        this.version = r101;
    }
}
