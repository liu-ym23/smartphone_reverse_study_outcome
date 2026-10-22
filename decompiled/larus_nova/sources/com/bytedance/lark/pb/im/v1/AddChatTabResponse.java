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
public final class AddChatTabResponse extends Message<AddChatTabResponse, Builder> {
    public static final ProtoAdapter<AddChatTabResponse> ADAPTER = null;
    public static final Long DEFAULT_CHAT_ID = null;
    public static final Long DEFAULT_NEW_TAB_ID = null;
    public static final Long DEFAULT_VERSION = null;
    public static final ProtoAdapter_AddChatTabResponse RAW_TYPE_ADAPTER = null;
    private static final long serialVersionUID = 0;
    public final Long chat_id;
    public final Long new_tab_id;
    public final List<ChatTab> tabs;
    public final Long version;

    public static final class Builder extends Message.Builder<AddChatTabResponse, Builder> implements d<AddChatTabResponse> {
        public Long chat_id;
        public Long new_tab_id;
        public List<ChatTab> tabs;
        public Long version;

        @Override // com.squareup.wire.Message.Builder
        public AddChatTabResponse build() {
            return new AddChatTabResponse(this.chat_id, this.tabs, this.version, this.new_tab_id, super.buildUnknownFields());
        }

        public Builder() {
            this.tabs = Internal.newMutableList();
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder chat_id(Long r100) {
            this.chat_id = r100;
            return this;
        }

        public Builder new_tab_id(Long r100) {
            this.new_tab_id = r100;
            return this;
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

    public static final class ProtoAdapter_AddChatTabResponse extends ProtoAdapter<AddChatTabResponse> implements c<AddChatTabResponse> {
        public ProtoAdapter_AddChatTabResponse() {
            super(FieldEncoding.LENGTH_DELIMITED, AddChatTabResponse.class);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public AddChatTabResponse decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            r101.chat_id = 0L;
            r101.version = 0L;
            r101.new_tab_id = 0L;
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L18;
            if (r103 != 1) goto L8;
            r101.chat_id = ProtoAdapter.INT64.decode(r100);
            goto L3
        L8:
            if (r103 != 2) goto L10;
            r101.tabs.add(ChatTab.ADAPTER.decode(r100));
            goto L3
        L10:
            if (r103 != 3) goto L12;
            r101.version = ProtoAdapter.INT64.decode(r100);
            goto L3
        L12:
            if (r103 != 4) goto L13;
            r101.new_tab_id = ProtoAdapter.INT64.decode(r100);
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
        public int encodedSize2(AddChatTabResponse r100) {
            Long r101 = r100.chat_id;
            int r102 = 0;
            if (r101 == null) goto L5;
            int r103 = ProtoAdapter.INT64.encodedSizeWithTag(1, r101);
        L6:
            int r104 = r103 + ChatTab.ADAPTER.asRepeated().encodedSizeWithTag(2, r100.tabs);
            Long r105 = r100.version;
            if (r105 == null) goto L9;
            int r106 = ProtoAdapter.INT64.encodedSizeWithTag(3, r105);
        L10:
            int r107 = r104 + r106;
            Long r108 = r100.new_tab_id;
            if (r108 == null) goto L14;
            r102 = ProtoAdapter.INT64.encodedSizeWithTag(4, r108);
        L14:
            return (r107 + r102) + r100.unknownFields().size();
        L9:
            r106 = 0;
            goto L10
        L5:
            r103 = 0;
            goto L6
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ AddChatTabResponse decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(AddChatTabResponse r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, AddChatTabResponse r101) throws IOException {
            Long r102 = r101.chat_id;
            if (r102 == null) goto L5;
            ProtoAdapter.INT64.encodeWithTag(r100, 1, r102);
        L5:
            ChatTab.ADAPTER.asRepeated().encodeWithTag(r100, 2, r101.tabs);
            Long r103 = r101.version;
            if (r103 == null) goto L8;
            ProtoAdapter.INT64.encodeWithTag(r100, 3, r103);
        L8:
            Long r104 = r101.new_tab_id;
            if (r104 == null) goto L11;
            ProtoAdapter.INT64.encodeWithTag(r100, 4, r104);
        L11:
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, AddChatTabResponse r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ProtoAdapter_AddChatTabResponse r100 = new ProtoAdapter_AddChatTabResponse();
        RAW_TYPE_ADAPTER = r100;
        ADAPTER = r100;
        DEFAULT_CHAT_ID = 0L;
        DEFAULT_VERSION = 0L;
        DEFAULT_NEW_TAB_ID = 0L;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.chat_id = this.chat_id;
        r100.tabs = Internal.copyOf("tabs", this.tabs);
        r100.version = this.version;
        r100.new_tab_id = this.new_tab_id;
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return AddChatTabResponse.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public AddChatTabResponse(Long r100, List<ChatTab> r101, Long r102, Long r110) {
        this(r100, r101, r102, r110, ByteString.EMPTY);
    }

    public AddChatTabResponse(Long r100, List<ChatTab> r101, Long r102, Long r103, ByteString r104) {
        super(ADAPTER, r104);
        this.chat_id = r100;
        this.tabs = Internal.immutableCopyOf("tabs", r101);
        this.version = r102;
        this.new_tab_id = r103;
    }
}
