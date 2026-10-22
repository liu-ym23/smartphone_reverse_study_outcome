package com.bytedance.lark.pb.im.v1;

import com.bytedance.lark.pb.basic.v1.Entity;
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
public final class AddChatChattersResponse extends Message<AddChatChattersResponse, Builder> {
    public static final ProtoAdapter<AddChatChattersResponse> ADAPTER = null;
    public static final String DEFAULT_CHAT_ID = "";
    public static final String DEFAULT_JOIN_GROUP_APPLICATION_ID = "";
    public static final ProtoAdapter_AddChatChattersResponse RAW_TYPE_ADAPTER = null;
    private static final long serialVersionUID = 0;
    public final String chat_id;
    public final Entity entity;
    public final String join_group_application_id;

    public static final class Builder extends Message.Builder<AddChatChattersResponse, Builder> implements d<AddChatChattersResponse> {
        public String chat_id;
        public Entity entity;
        public String join_group_application_id;

        @Override // com.squareup.wire.Message.Builder
        public AddChatChattersResponse build() {
            return new AddChatChattersResponse(this.chat_id, this.entity, this.join_group_application_id, super.buildUnknownFields());
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

        public Builder entity(Entity r100) {
            this.entity = r100;
            return this;
        }

        public Builder join_group_application_id(String r100) {
            this.join_group_application_id = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_AddChatChattersResponse extends ProtoAdapter<AddChatChattersResponse> implements c<AddChatChattersResponse> {
        public ProtoAdapter_AddChatChattersResponse() {
            super(FieldEncoding.LENGTH_DELIMITED, AddChatChattersResponse.class);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public AddChatChattersResponse decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            r101.chat_id = "";
            r101.join_group_application_id = "";
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L15;
            if (r103 != 1) goto L8;
            r101.chat_id = ProtoAdapter.STRING.decode(r100);
            goto L3
        L8:
            if (r103 != 2) goto L10;
            r101.entity = Entity.ADAPTER.decode(r100);
            goto L3
        L10:
            if (r103 != 3) goto L11;
            r101.join_group_application_id = ProtoAdapter.STRING.decode(r100);
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
        public int encodedSize2(AddChatChattersResponse r100) {
            String r101 = r100.chat_id;
            int r102 = 0;
            if (r101 == null) goto L5;
            int r103 = ProtoAdapter.STRING.encodedSizeWithTag(1, r101);
        L6:
            Entity r104 = r100.entity;
            if (r104 == null) goto L9;
            int r105 = Entity.ADAPTER.encodedSizeWithTag(2, r104);
        L10:
            int r106 = r103 + r105;
            String r107 = r100.join_group_application_id;
            if (r107 == null) goto L14;
            r102 = ProtoAdapter.STRING.encodedSizeWithTag(3, r107);
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
        public /* bridge */ /* synthetic */ AddChatChattersResponse decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(AddChatChattersResponse r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, AddChatChattersResponse r101) throws IOException {
            String r102 = r101.chat_id;
            if (r102 == null) goto L5;
            ProtoAdapter.STRING.encodeWithTag(r100, 1, r102);
        L5:
            Entity r103 = r101.entity;
            if (r103 == null) goto L8;
            Entity.ADAPTER.encodeWithTag(r100, 2, r103);
        L8:
            String r104 = r101.join_group_application_id;
            if (r104 == null) goto L11;
            ProtoAdapter.STRING.encodeWithTag(r100, 3, r104);
        L11:
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, AddChatChattersResponse r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ProtoAdapter_AddChatChattersResponse r100 = new ProtoAdapter_AddChatChattersResponse();
        RAW_TYPE_ADAPTER = r100;
        ADAPTER = r100;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.chat_id = this.chat_id;
        r100.entity = this.entity;
        r100.join_group_application_id = this.join_group_application_id;
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return AddChatChattersResponse.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public AddChatChattersResponse(String r100, Entity r101, String r102) {
        this(r100, r101, r102, ByteString.EMPTY);
    }

    public AddChatChattersResponse(String r100, Entity r101, String r102, ByteString r103) {
        super(ADAPTER, r103);
        this.chat_id = r100;
        this.entity = r101;
        this.join_group_application_id = r102;
    }
}
