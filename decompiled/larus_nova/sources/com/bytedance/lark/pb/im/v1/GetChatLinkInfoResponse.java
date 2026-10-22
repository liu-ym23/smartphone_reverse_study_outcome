package com.bytedance.lark.pb.im.v1;

import com.bytedance.lark.pb.basic.v1.Entity;
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
public final class GetChatLinkInfoResponse extends Message<GetChatLinkInfoResponse, Builder> {
    public static final ProtoAdapter<GetChatLinkInfoResponse> ADAPTER = null;
    public static final Boolean DEFAULT_ALREADY_IN_CHAT = null;
    public static final String DEFAULT_CHAT_ID = "";
    public static final String DEFAULT_EXPIRE_TIME = "";
    public static final String DEFAULT_INVITER_CHATTER_ID = "";
    public static final Boolean DEFAULT_IS_INVITER_CAN_INVITE_MEMBER = null;
    public static final String DEFAULT_OWNER_CHATTER_ID = "";
    public static final ProtoAdapter_GetChatLinkInfoResponse RAW_TYPE_ADAPTER = null;
    private static final long serialVersionUID = 0;
    public final Boolean already_in_chat;
    public final String chat_id;
    public final Entity entity;
    public final String expire_time;
    public final String inviter_chatter_id;
    public final Boolean is_inviter_can_invite_member;
    public final String owner_chatter_id;

    public static final class Builder extends Message.Builder<GetChatLinkInfoResponse, Builder> implements d<GetChatLinkInfoResponse> {
        public Boolean already_in_chat;
        public String chat_id;
        public Entity entity;
        public String expire_time;
        public String inviter_chatter_id;
        public Boolean is_inviter_can_invite_member;
        public String owner_chatter_id;

        @Override // com.squareup.wire.Message.Builder
        public GetChatLinkInfoResponse build() {
            Entity r100 = this.entity;
            if (r100 == null) goto L7;
            return new GetChatLinkInfoResponse(this.already_in_chat, this.chat_id, this.owner_chatter_id, this.inviter_chatter_id, this.is_inviter_can_invite_member, this.entity, this.expire_time, super.buildUnknownFields());
        L7:
            throw Internal.missingRequiredFields(new Object[]{r100, "entity"});
        }

        public Builder() {
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder already_in_chat(Boolean r100) {
            this.already_in_chat = r100;
            return this;
        }

        public Builder chat_id(String r100) {
            this.chat_id = r100;
            return this;
        }

        public Builder entity(Entity r100) {
            this.entity = r100;
            return this;
        }

        public Builder expire_time(String r100) {
            this.expire_time = r100;
            return this;
        }

        public Builder inviter_chatter_id(String r100) {
            this.inviter_chatter_id = r100;
            return this;
        }

        public Builder is_inviter_can_invite_member(Boolean r100) {
            this.is_inviter_can_invite_member = r100;
            return this;
        }

        public Builder owner_chatter_id(String r100) {
            this.owner_chatter_id = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_GetChatLinkInfoResponse extends ProtoAdapter<GetChatLinkInfoResponse> implements c<GetChatLinkInfoResponse> {
        public ProtoAdapter_GetChatLinkInfoResponse() {
            super(FieldEncoding.LENGTH_DELIMITED, GetChatLinkInfoResponse.class);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public GetChatLinkInfoResponse decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            Boolean r102 = Boolean.FALSE;
            r101.already_in_chat = r102;
            r101.chat_id = "";
            r101.owner_chatter_id = "";
            r101.inviter_chatter_id = "";
            r101.is_inviter_can_invite_member = r102;
            r101.expire_time = "";
            long r103 = r100.beginMessage();
        L3:
            int r104 = r100.nextTag();
            if (r104 == (-1)) goto L14;
            switch(r104) {
                case 1: goto L13;
                case 2: goto L12;
                case 3: goto L11;
                case 4: goto L10;
                case 5: goto L9;
                case 6: goto L8;
                case 7: goto L7;
                default: goto L6;
            };
        L7:
            r101.expire_time = ProtoAdapter.STRING.decode(r100);
            goto L3
        L8:
            r101.entity = Entity.ADAPTER.decode(r100);
            goto L3
        L9:
            r101.is_inviter_can_invite_member = ProtoAdapter.BOOL.decode(r100);
            goto L3
        L10:
            r101.inviter_chatter_id = ProtoAdapter.STRING.decode(r100);
            goto L3
        L11:
            r101.owner_chatter_id = ProtoAdapter.STRING.decode(r100);
            goto L3
        L12:
            r101.chat_id = ProtoAdapter.STRING.decode(r100);
            goto L3
        L13:
            r101.already_in_chat = ProtoAdapter.BOOL.decode(r100);
            goto L3
        L6:
            FieldEncoding r105 = r100.peekFieldEncoding();
            r101.addUnknownField(r104, r105, r105.rawProtoAdapter().decode(r100));
            goto L3
        L14:
            r100.endMessage(r103);
            return r101.build();
        }

        /* JADX INFO: renamed from: encodedSize, reason: avoid collision after fix types in other method */
        public int encodedSize2(GetChatLinkInfoResponse r100) {
            Boolean r101 = r100.already_in_chat;
            int r102 = 0;
            if (r101 == null) goto L5;
            int r103 = ProtoAdapter.BOOL.encodedSizeWithTag(1, r101);
        L6:
            String r104 = r100.chat_id;
            if (r104 == null) goto L9;
            int r105 = ProtoAdapter.STRING.encodedSizeWithTag(2, r104);
        L10:
            int r106 = r103 + r105;
            String r107 = r100.owner_chatter_id;
            if (r107 == null) goto L13;
            int r108 = ProtoAdapter.STRING.encodedSizeWithTag(3, r107);
        L14:
            int r109 = r106 + r108;
            String r110 = r100.inviter_chatter_id;
            if (r110 == null) goto L17;
            int r111 = ProtoAdapter.STRING.encodedSizeWithTag(4, r110);
        L18:
            int r112 = r109 + r111;
            Boolean r113 = r100.is_inviter_can_invite_member;
            if (r113 == null) goto L21;
            int r114 = ProtoAdapter.BOOL.encodedSizeWithTag(5, r113);
        L22:
            int r115 = (r112 + r114) + Entity.ADAPTER.encodedSizeWithTag(6, r100.entity);
            String r116 = r100.expire_time;
            if (r116 == null) goto L26;
            r102 = ProtoAdapter.STRING.encodedSizeWithTag(7, r116);
        L26:
            return (r115 + r102) + r100.unknownFields().size();
        L21:
            r114 = 0;
            goto L22
        L17:
            r111 = 0;
            goto L18
        L13:
            r108 = 0;
            goto L14
        L9:
            r105 = 0;
            goto L10
        L5:
            r103 = 0;
            goto L6
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ GetChatLinkInfoResponse decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(GetChatLinkInfoResponse r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, GetChatLinkInfoResponse r101) throws IOException {
            Boolean r102 = r101.already_in_chat;
            if (r102 == null) goto L5;
            ProtoAdapter.BOOL.encodeWithTag(r100, 1, r102);
        L5:
            String r103 = r101.chat_id;
            if (r103 == null) goto L8;
            ProtoAdapter.STRING.encodeWithTag(r100, 2, r103);
        L8:
            String r104 = r101.owner_chatter_id;
            if (r104 == null) goto L11;
            ProtoAdapter.STRING.encodeWithTag(r100, 3, r104);
        L11:
            String r105 = r101.inviter_chatter_id;
            if (r105 == null) goto L14;
            ProtoAdapter.STRING.encodeWithTag(r100, 4, r105);
        L14:
            Boolean r106 = r101.is_inviter_can_invite_member;
            if (r106 == null) goto L17;
            ProtoAdapter.BOOL.encodeWithTag(r100, 5, r106);
        L17:
            Entity.ADAPTER.encodeWithTag(r100, 6, r101.entity);
            String r107 = r101.expire_time;
            if (r107 == null) goto L20;
            ProtoAdapter.STRING.encodeWithTag(r100, 7, r107);
        L20:
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, GetChatLinkInfoResponse r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ProtoAdapter_GetChatLinkInfoResponse r100 = new ProtoAdapter_GetChatLinkInfoResponse();
        RAW_TYPE_ADAPTER = r100;
        ADAPTER = r100;
        Boolean r101 = Boolean.FALSE;
        DEFAULT_ALREADY_IN_CHAT = r101;
        DEFAULT_IS_INVITER_CAN_INVITE_MEMBER = r101;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.already_in_chat = this.already_in_chat;
        r100.chat_id = this.chat_id;
        r100.owner_chatter_id = this.owner_chatter_id;
        r100.inviter_chatter_id = this.inviter_chatter_id;
        r100.is_inviter_can_invite_member = this.is_inviter_can_invite_member;
        r100.entity = this.entity;
        r100.expire_time = this.expire_time;
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return GetChatLinkInfoResponse.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public GetChatLinkInfoResponse(Boolean r110, String r111, String r112, String r113, Boolean r114, Entity r115, String r116) {
        this(r110, r111, r112, r113, r114, r115, r116, ByteString.EMPTY);
    }

    public GetChatLinkInfoResponse(Boolean r100, String r101, String r102, String r103, Boolean r104, Entity r105, String r106, ByteString r107) {
        super(ADAPTER, r107);
        this.already_in_chat = r100;
        this.chat_id = r101;
        this.owner_chatter_id = r102;
        this.inviter_chatter_id = r103;
        this.is_inviter_can_invite_member = r104;
        this.entity = r105;
        this.expire_time = r106;
    }
}
