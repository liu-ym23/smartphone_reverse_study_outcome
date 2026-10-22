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
public final class CreateLocalMentionBotsNotInChatMessageRequest extends Message<CreateLocalMentionBotsNotInChatMessageRequest, Builder> {
    public static final ProtoAdapter<CreateLocalMentionBotsNotInChatMessageRequest> ADAPTER = null;
    public static final String DEFAULT_SOURCE_MESSAGE_ID = "";
    public static final ProtoAdapter_CreateLocalMentionBotsNotInChatMessageRequest RAW_TYPE_ADAPTER = null;
    private static final long serialVersionUID = 0;
    public final List<String> mention_id;
    public final String source_message_id;

    public static final class Builder extends Message.Builder<CreateLocalMentionBotsNotInChatMessageRequest, Builder> implements d<CreateLocalMentionBotsNotInChatMessageRequest> {
        public List<String> mention_id;
        public String source_message_id;

        @Override // com.squareup.wire.Message.Builder
        public CreateLocalMentionBotsNotInChatMessageRequest build() {
            String r100 = this.source_message_id;
            if (r100 == null) goto L7;
            return new CreateLocalMentionBotsNotInChatMessageRequest(this.source_message_id, this.mention_id, super.buildUnknownFields());
        L7:
            throw Internal.missingRequiredFields(new Object[]{r100, "source_message_id"});
        }

        public Builder() {
            this.mention_id = Internal.newMutableList();
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder mention_id(List<String> r100) {
            Internal.checkElementsNotNull(r100);
            this.mention_id = r100;
            return this;
        }

        public Builder source_message_id(String r100) {
            this.source_message_id = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_CreateLocalMentionBotsNotInChatMessageRequest extends ProtoAdapter<CreateLocalMentionBotsNotInChatMessageRequest> implements c<CreateLocalMentionBotsNotInChatMessageRequest> {
        public ProtoAdapter_CreateLocalMentionBotsNotInChatMessageRequest() {
            super(FieldEncoding.LENGTH_DELIMITED, CreateLocalMentionBotsNotInChatMessageRequest.class);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public CreateLocalMentionBotsNotInChatMessageRequest decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            r101.source_message_id = "";
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L12;
            if (r103 != 1) goto L8;
            r101.source_message_id = ProtoAdapter.STRING.decode(r100);
            goto L3
        L8:
            if (r103 != 2) goto L9;
            r101.mention_id.add(ProtoAdapter.STRING.decode(r100));
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
        public int encodedSize2(CreateLocalMentionBotsNotInChatMessageRequest r100) {
            ProtoAdapter<String> r101 = ProtoAdapter.STRING;
            return (r101.encodedSizeWithTag(1, r100.source_message_id) + r101.asRepeated().encodedSizeWithTag(2, r100.mention_id)) + r100.unknownFields().size();
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ CreateLocalMentionBotsNotInChatMessageRequest decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(CreateLocalMentionBotsNotInChatMessageRequest r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, CreateLocalMentionBotsNotInChatMessageRequest r101) throws IOException {
            ProtoAdapter<String> r102 = ProtoAdapter.STRING;
            r102.encodeWithTag(r100, 1, r101.source_message_id);
            r102.asRepeated().encodeWithTag(r100, 2, r101.mention_id);
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, CreateLocalMentionBotsNotInChatMessageRequest r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ProtoAdapter_CreateLocalMentionBotsNotInChatMessageRequest r100 = new ProtoAdapter_CreateLocalMentionBotsNotInChatMessageRequest();
        RAW_TYPE_ADAPTER = r100;
        ADAPTER = r100;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.source_message_id = this.source_message_id;
        r100.mention_id = Internal.copyOf("mention_id", this.mention_id);
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return CreateLocalMentionBotsNotInChatMessageRequest.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public CreateLocalMentionBotsNotInChatMessageRequest(String r100, List<String> r101) {
        this(r100, r101, ByteString.EMPTY);
    }

    public CreateLocalMentionBotsNotInChatMessageRequest(String r100, List<String> r101, ByteString r102) {
        super(ADAPTER, r102);
        this.source_message_id = r100;
        this.mention_id = Internal.immutableCopyOf("mention_id", r101);
    }
}
