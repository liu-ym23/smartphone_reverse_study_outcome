package com.bytedance.lark.pb.im.v1;

import com.bytedance.lark.pb.basic.v1.AddChatChatterApply;
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
public final class CreateAddChatChatterApplyRequest extends Message<CreateAddChatChatterApplyRequest, Builder> {
    public static final ProtoAdapter<CreateAddChatChatterApplyRequest> ADAPTER = null;
    public static final String DEFAULT_CHAT_ID = "";
    public static final String DEFAULT_EVENT_ID = "";
    public static final String DEFAULT_INVITER_ID = "";
    public static final String DEFAULT_JOIN_TOKEN = "";
    public static final String DEFAULT_REASON = "";
    public static final Long DEFAULT_TEAM_ID = null;
    public static final AddChatChatterApply.Ways DEFAULT_WAY = null;
    public static final ProtoAdapter_CreateAddChatChatterApplyRequest RAW_TYPE_ADAPTER = null;
    private static final long serialVersionUID = 0;
    public final String chat_id;
    public final List<String> chatter_ids;
    public final String event_id;
    public final ChatPageContext from_page;
    public final String inviter_id;
    public final String join_token;
    public final String reason;
    public final Long team_id;
    public final AddChatChatterApply.Ways way;

    public static final class Builder extends Message.Builder<CreateAddChatChatterApplyRequest, Builder> implements d<CreateAddChatChatterApplyRequest> {
        public String chat_id;
        public List<String> chatter_ids;
        public String event_id;
        public ChatPageContext from_page;
        public String inviter_id;
        public String join_token;
        public String reason;
        public Long team_id;
        public AddChatChatterApply.Ways way;

        @Override // com.squareup.wire.Message.Builder
        public CreateAddChatChatterApplyRequest build() {
            String r100 = this.chat_id;
            if (r100 == null) goto L9;
            if (this.way == null) goto L9;
            return new CreateAddChatChatterApplyRequest(this.chat_id, this.way, this.reason, this.chatter_ids, this.inviter_id, this.join_token, this.team_id, this.event_id, this.from_page, super.buildUnknownFields());
        L9:
            throw Internal.missingRequiredFields(new Object[]{r100, "chat_id", this.way, "way"});
        }

        public Builder() {
            this.chatter_ids = Internal.newMutableList();
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder chat_id(String r100) {
            this.chat_id = r100;
            return this;
        }

        public Builder chatter_ids(List<String> r100) {
            Internal.checkElementsNotNull(r100);
            this.chatter_ids = r100;
            return this;
        }

        public Builder event_id(String r100) {
            this.event_id = r100;
            return this;
        }

        public Builder from_page(ChatPageContext r100) {
            this.from_page = r100;
            return this;
        }

        public Builder inviter_id(String r100) {
            this.inviter_id = r100;
            return this;
        }

        public Builder join_token(String r100) {
            this.join_token = r100;
            return this;
        }

        public Builder reason(String r100) {
            this.reason = r100;
            return this;
        }

        public Builder team_id(Long r100) {
            this.team_id = r100;
            return this;
        }

        public Builder way(AddChatChatterApply.Ways r100) {
            this.way = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_CreateAddChatChatterApplyRequest extends ProtoAdapter<CreateAddChatChatterApplyRequest> implements c<CreateAddChatChatterApplyRequest> {
        public ProtoAdapter_CreateAddChatChatterApplyRequest() {
            super(FieldEncoding.LENGTH_DELIMITED, CreateAddChatChatterApplyRequest.class);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public CreateAddChatChatterApplyRequest decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            r101.chat_id = "";
            r101.way = AddChatChatterApply.Ways.UNKNOWN_WAY;
            r101.reason = "";
            r101.inviter_id = "";
            r101.join_token = "";
            r101.team_id = 0L;
            r101.event_id = "";
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L19;
            switch(r103) {
                case 1: goto L18;
                case 2: goto L21;
                case 3: goto L13;
                case 4: goto L12;
                case 5: goto L11;
                case 6: goto L10;
                case 7: goto L9;
                case 8: goto L8;
                case 9: goto L7;
                default: goto L6;
            };
        L21:
            r101.way = AddChatChatterApply.Ways.ADAPTER.decode(r100);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L16
        L16:
            e = move-exception;
            r101.addUnknownField(r103, FieldEncoding.VARINT, Long.valueOf(e.value));
            goto L3
        L7:
            r101.from_page = ChatPageContext.ADAPTER.decode(r100);
            goto L3
        L8:
            r101.event_id = ProtoAdapter.STRING.decode(r100);
            goto L3
        L9:
            r101.team_id = ProtoAdapter.INT64.decode(r100);
            goto L3
        L10:
            r101.join_token = ProtoAdapter.STRING.decode(r100);
            goto L3
        L11:
            r101.inviter_id = ProtoAdapter.STRING.decode(r100);
            goto L3
        L12:
            r101.chatter_ids.add(ProtoAdapter.STRING.decode(r100));
            goto L3
        L13:
            r101.reason = ProtoAdapter.STRING.decode(r100);
            goto L3
        L18:
            r101.chat_id = ProtoAdapter.STRING.decode(r100);
            goto L3
        L6:
            FieldEncoding r104 = r100.peekFieldEncoding();
            r101.addUnknownField(r103, r104, r104.rawProtoAdapter().decode(r100));
            goto L3
        L19:
            r100.endMessage(r102);
            return r101.build();
        }

        /* JADX INFO: renamed from: encodedSize, reason: avoid collision after fix types in other method */
        public int encodedSize2(CreateAddChatChatterApplyRequest r100) {
            ProtoAdapter<String> r101 = ProtoAdapter.STRING;
            int r102 = r101.encodedSizeWithTag(1, r100.chat_id) + AddChatChatterApply.Ways.ADAPTER.encodedSizeWithTag(2, r100.way);
            String r103 = r100.reason;
            int r104 = 0;
            if (r103 == null) goto L5;
            int r105 = r101.encodedSizeWithTag(3, r103);
        L6:
            int r106 = (r102 + r105) + r101.asRepeated().encodedSizeWithTag(4, r100.chatter_ids);
            String r107 = r100.inviter_id;
            if (r107 == null) goto L9;
            int r108 = r101.encodedSizeWithTag(5, r107);
        L10:
            int r109 = r106 + r108;
            String r110 = r100.join_token;
            if (r110 == null) goto L13;
            int r111 = r101.encodedSizeWithTag(6, r110);
        L14:
            int r112 = r109 + r111;
            Long r113 = r100.team_id;
            if (r113 == null) goto L17;
            int r114 = ProtoAdapter.INT64.encodedSizeWithTag(7, r113);
        L18:
            int r115 = r112 + r114;
            String r116 = r100.event_id;
            if (r116 == null) goto L21;
            int r117 = r101.encodedSizeWithTag(8, r116);
        L22:
            int r118 = r115 + r117;
            ChatPageContext r119 = r100.from_page;
            if (r119 == null) goto L26;
            r104 = ChatPageContext.ADAPTER.encodedSizeWithTag(9, r119);
        L26:
            return (r118 + r104) + r100.unknownFields().size();
        L21:
            r117 = 0;
            goto L22
        L17:
            r114 = 0;
            goto L18
        L13:
            r111 = 0;
            goto L14
        L9:
            r108 = 0;
            goto L10
        L5:
            r105 = 0;
            goto L6
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ CreateAddChatChatterApplyRequest decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(CreateAddChatChatterApplyRequest r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, CreateAddChatChatterApplyRequest r101) throws IOException {
            ProtoAdapter<String> r102 = ProtoAdapter.STRING;
            r102.encodeWithTag(r100, 1, r101.chat_id);
            AddChatChatterApply.Ways.ADAPTER.encodeWithTag(r100, 2, r101.way);
            String r103 = r101.reason;
            if (r103 == null) goto L5;
            r102.encodeWithTag(r100, 3, r103);
        L5:
            r102.asRepeated().encodeWithTag(r100, 4, r101.chatter_ids);
            String r104 = r101.inviter_id;
            if (r104 == null) goto L8;
            r102.encodeWithTag(r100, 5, r104);
        L8:
            String r105 = r101.join_token;
            if (r105 == null) goto L11;
            r102.encodeWithTag(r100, 6, r105);
        L11:
            Long r106 = r101.team_id;
            if (r106 == null) goto L14;
            ProtoAdapter.INT64.encodeWithTag(r100, 7, r106);
        L14:
            String r107 = r101.event_id;
            if (r107 == null) goto L17;
            r102.encodeWithTag(r100, 8, r107);
        L17:
            ChatPageContext r108 = r101.from_page;
            if (r108 == null) goto L20;
            ChatPageContext.ADAPTER.encodeWithTag(r100, 9, r108);
        L20:
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, CreateAddChatChatterApplyRequest r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ProtoAdapter_CreateAddChatChatterApplyRequest r100 = new ProtoAdapter_CreateAddChatChatterApplyRequest();
        RAW_TYPE_ADAPTER = r100;
        ADAPTER = r100;
        DEFAULT_WAY = AddChatChatterApply.Ways.UNKNOWN_WAY;
        DEFAULT_TEAM_ID = 0L;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.chat_id = this.chat_id;
        r100.way = this.way;
        r100.reason = this.reason;
        r100.chatter_ids = Internal.copyOf("chatter_ids", this.chatter_ids);
        r100.inviter_id = this.inviter_id;
        r100.join_token = this.join_token;
        r100.team_id = this.team_id;
        r100.event_id = this.event_id;
        r100.from_page = this.from_page;
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return CreateAddChatChatterApplyRequest.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public CreateAddChatChatterApplyRequest(String r110, AddChatChatterApply.Ways r111, String r112, List<String> r113, String r114, String r115, Long r116, String r117, ChatPageContext r210) {
        this(r110, r111, r112, r113, r114, r115, r116, r117, r210, ByteString.EMPTY);
    }

    public CreateAddChatChatterApplyRequest(String r100, AddChatChatterApply.Ways r101, String r102, List<String> r103, String r104, String r105, Long r106, String r107, ChatPageContext r110, ByteString r111) {
        super(ADAPTER, r111);
        this.chat_id = r100;
        this.way = r101;
        this.reason = r102;
        this.chatter_ids = Internal.immutableCopyOf("chatter_ids", r103);
        this.inviter_id = r104;
        this.join_token = r105;
        this.team_id = r106;
        this.event_id = r107;
        this.from_page = r110;
    }
}
