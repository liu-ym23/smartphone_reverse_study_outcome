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
public final class UpdateChatPostUsersRequest extends Message<UpdateChatPostUsersRequest, Builder> {
    public static final ProtoAdapter<UpdateChatPostUsersRequest> ADAPTER = null;
    public static final String DEFAULT_CHAT_ID = "";
    public static final Chat.PostType DEFAULT_POST_TYPE = null;
    public static final ProtoAdapter_UpdateChatPostUsersRequest RAW_TYPE_ADAPTER = null;
    private static final long serialVersionUID = 0;
    public final String chat_id;
    public final Chat.PostType post_type;
    public final List<String> to_add_user_ids;
    public final List<String> to_del_user_ids;

    public static final class Builder extends Message.Builder<UpdateChatPostUsersRequest, Builder> implements d<UpdateChatPostUsersRequest> {
        public String chat_id;
        public Chat.PostType post_type;
        public List<String> to_add_user_ids;
        public List<String> to_del_user_ids;

        @Override // com.squareup.wire.Message.Builder
        public UpdateChatPostUsersRequest build() {
            String r100 = this.chat_id;
            if (r100 == null) goto L9;
            if (this.post_type == null) goto L9;
            return new UpdateChatPostUsersRequest(this.chat_id, this.post_type, this.to_add_user_ids, this.to_del_user_ids, super.buildUnknownFields());
        L9:
            throw Internal.missingRequiredFields(new Object[]{r100, "chat_id", this.post_type, "post_type"});
        }

        public Builder() {
            this.to_add_user_ids = Internal.newMutableList();
            this.to_del_user_ids = Internal.newMutableList();
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder chat_id(String r100) {
            this.chat_id = r100;
            return this;
        }

        public Builder post_type(Chat.PostType r100) {
            this.post_type = r100;
            return this;
        }

        public Builder to_add_user_ids(List<String> r100) {
            Internal.checkElementsNotNull(r100);
            this.to_add_user_ids = r100;
            return this;
        }

        public Builder to_del_user_ids(List<String> r100) {
            Internal.checkElementsNotNull(r100);
            this.to_del_user_ids = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_UpdateChatPostUsersRequest extends ProtoAdapter<UpdateChatPostUsersRequest> implements c<UpdateChatPostUsersRequest> {
        public ProtoAdapter_UpdateChatPostUsersRequest() {
            super(FieldEncoding.LENGTH_DELIMITED, UpdateChatPostUsersRequest.class);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public UpdateChatPostUsersRequest decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            r101.chat_id = "";
            r101.post_type = Chat.PostType.UNKNOWN_POST_TYPE;
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L21;
            if (r103 != 1) goto L8;
            r101.chat_id = ProtoAdapter.STRING.decode(r100);
            goto L3
        L8:
            if (r103 != 2) goto L10;
            r101.post_type = Chat.PostType.ADAPTER.decode(r100);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L18
        L18:
            e = move-exception;
            r101.addUnknownField(r103, FieldEncoding.VARINT, Long.valueOf(e.value));
            goto L3
        L10:
            if (r103 != 3) goto L12;
            r101.to_add_user_ids.add(ProtoAdapter.STRING.decode(r100));
            goto L3
        L12:
            if (r103 != 4) goto L13;
            r101.to_del_user_ids.add(ProtoAdapter.STRING.decode(r100));
            goto L3
        L13:
            FieldEncoding r104 = r100.peekFieldEncoding();
            r101.addUnknownField(r103, r104, r104.rawProtoAdapter().decode(r100));
            goto L3
        L21:
            r100.endMessage(r102);
            return r101.build();
        }

        /* JADX INFO: renamed from: encodedSize, reason: avoid collision after fix types in other method */
        public int encodedSize2(UpdateChatPostUsersRequest r100) {
            ProtoAdapter<String> r101 = ProtoAdapter.STRING;
            return (((r101.encodedSizeWithTag(1, r100.chat_id) + Chat.PostType.ADAPTER.encodedSizeWithTag(2, r100.post_type)) + r101.asRepeated().encodedSizeWithTag(3, r100.to_add_user_ids)) + r101.asRepeated().encodedSizeWithTag(4, r100.to_del_user_ids)) + r100.unknownFields().size();
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ UpdateChatPostUsersRequest decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(UpdateChatPostUsersRequest r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, UpdateChatPostUsersRequest r101) throws IOException {
            ProtoAdapter<String> r102 = ProtoAdapter.STRING;
            r102.encodeWithTag(r100, 1, r101.chat_id);
            Chat.PostType.ADAPTER.encodeWithTag(r100, 2, r101.post_type);
            r102.asRepeated().encodeWithTag(r100, 3, r101.to_add_user_ids);
            r102.asRepeated().encodeWithTag(r100, 4, r101.to_del_user_ids);
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, UpdateChatPostUsersRequest r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ProtoAdapter_UpdateChatPostUsersRequest r100 = new ProtoAdapter_UpdateChatPostUsersRequest();
        RAW_TYPE_ADAPTER = r100;
        ADAPTER = r100;
        DEFAULT_POST_TYPE = Chat.PostType.UNKNOWN_POST_TYPE;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.chat_id = this.chat_id;
        r100.post_type = this.post_type;
        r100.to_add_user_ids = Internal.copyOf("to_add_user_ids", this.to_add_user_ids);
        r100.to_del_user_ids = Internal.copyOf("to_del_user_ids", this.to_del_user_ids);
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return UpdateChatPostUsersRequest.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public UpdateChatPostUsersRequest(String r100, Chat.PostType r101, List<String> r102, List<String> r110) {
        this(r100, r101, r102, r110, ByteString.EMPTY);
    }

    public UpdateChatPostUsersRequest(String r100, Chat.PostType r101, List<String> r102, List<String> r103, ByteString r104) {
        super(ADAPTER, r104);
        this.chat_id = r100;
        this.post_type = r101;
        this.to_add_user_ids = Internal.immutableCopyOf("to_add_user_ids", r102);
        this.to_del_user_ids = Internal.immutableCopyOf("to_del_user_ids", r103);
    }
}
