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
public final class PatchChatAdminUsersRequest extends Message<PatchChatAdminUsersRequest, Builder> {
    public static final ProtoAdapter<PatchChatAdminUsersRequest> ADAPTER = null;
    public static final String DEFAULT_CHAT_ID = "";
    public static final ProtoAdapter_PatchChatAdminUsersRequest RAW_TYPE_ADAPTER = null;
    private static final long serialVersionUID = 0;
    public final String chat_id;
    public final List<String> to_add_user_ids;
    public final List<String> to_del_user_ids;

    public static final class Builder extends Message.Builder<PatchChatAdminUsersRequest, Builder> implements d<PatchChatAdminUsersRequest> {
        public String chat_id;
        public List<String> to_add_user_ids;
        public List<String> to_del_user_ids;

        @Override // com.squareup.wire.Message.Builder
        public PatchChatAdminUsersRequest build() {
            String r100 = this.chat_id;
            if (r100 == null) goto L7;
            return new PatchChatAdminUsersRequest(this.chat_id, this.to_add_user_ids, this.to_del_user_ids, super.buildUnknownFields());
        L7:
            throw Internal.missingRequiredFields(new Object[]{r100, "chat_id"});
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

    public static final class ProtoAdapter_PatchChatAdminUsersRequest extends ProtoAdapter<PatchChatAdminUsersRequest> implements c<PatchChatAdminUsersRequest> {
        public ProtoAdapter_PatchChatAdminUsersRequest() {
            super(FieldEncoding.LENGTH_DELIMITED, PatchChatAdminUsersRequest.class);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public PatchChatAdminUsersRequest decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            r101.chat_id = "";
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L15;
            if (r103 != 1) goto L8;
            r101.chat_id = ProtoAdapter.STRING.decode(r100);
            goto L3
        L8:
            if (r103 != 2) goto L10;
            r101.to_add_user_ids.add(ProtoAdapter.STRING.decode(r100));
            goto L3
        L10:
            if (r103 != 3) goto L11;
            r101.to_del_user_ids.add(ProtoAdapter.STRING.decode(r100));
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
        public int encodedSize2(PatchChatAdminUsersRequest r100) {
            ProtoAdapter<String> r101 = ProtoAdapter.STRING;
            return ((r101.encodedSizeWithTag(1, r100.chat_id) + r101.asRepeated().encodedSizeWithTag(2, r100.to_add_user_ids)) + r101.asRepeated().encodedSizeWithTag(3, r100.to_del_user_ids)) + r100.unknownFields().size();
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ PatchChatAdminUsersRequest decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(PatchChatAdminUsersRequest r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, PatchChatAdminUsersRequest r101) throws IOException {
            ProtoAdapter<String> r102 = ProtoAdapter.STRING;
            r102.encodeWithTag(r100, 1, r101.chat_id);
            r102.asRepeated().encodeWithTag(r100, 2, r101.to_add_user_ids);
            r102.asRepeated().encodeWithTag(r100, 3, r101.to_del_user_ids);
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, PatchChatAdminUsersRequest r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ProtoAdapter_PatchChatAdminUsersRequest r100 = new ProtoAdapter_PatchChatAdminUsersRequest();
        RAW_TYPE_ADAPTER = r100;
        ADAPTER = r100;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.chat_id = this.chat_id;
        r100.to_add_user_ids = Internal.copyOf("to_add_user_ids", this.to_add_user_ids);
        r100.to_del_user_ids = Internal.copyOf("to_del_user_ids", this.to_del_user_ids);
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return PatchChatAdminUsersRequest.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public PatchChatAdminUsersRequest(String r100, List<String> r101, List<String> r102) {
        this(r100, r101, r102, ByteString.EMPTY);
    }

    public PatchChatAdminUsersRequest(String r100, List<String> r101, List<String> r102, ByteString r103) {
        super(ADAPTER, r103);
        this.chat_id = r100;
        this.to_add_user_ids = Internal.immutableCopyOf("to_add_user_ids", r101);
        this.to_del_user_ids = Internal.immutableCopyOf("to_del_user_ids", r102);
    }
}
