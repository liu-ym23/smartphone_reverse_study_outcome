package com.ss.android.lark.pb.chats;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import com.squareup.wire.internal.Internal;
import com.ss.android.lark.pb.entities.Chat;
import java.io.IOException;
import java.util.List;
import okio.ByteString;

/* JADX INFO: loaded from: classes37.dex */
public final class PullChangeGroupMemberAuthorizationRequest extends Message<PullChangeGroupMemberAuthorizationRequest, Builder> {
    public static final ProtoAdapter<PullChangeGroupMemberAuthorizationRequest> ADAPTER = null;
    public static final Long DEFAULT_FROM_CHAT_ID = null;
    private static final long serialVersionUID = 0;
    public final Chat.ChatMode mchat_mode;
    public final Long mfrom_chat_id;
    public final List<PickEntities> mpick_entities;

    public static final class Builder extends Message.Builder<PullChangeGroupMemberAuthorizationRequest, Builder> {
        public Chat.ChatMode mchat_mode;
        public Long mfrom_chat_id;
        public List<PickEntities> mpick_entities;

        @Override // com.squareup.wire.Message.Builder
        public PullChangeGroupMemberAuthorizationRequest build() {
            return new PullChangeGroupMemberAuthorizationRequest(this.mpick_entities, this.mchat_mode, this.mfrom_chat_id, super.buildUnknownFields());
        }

        public Builder() {
            this.mpick_entities = Internal.newMutableList();
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder chat_mode(Chat.ChatMode r100) {
            this.mchat_mode = r100;
            return this;
        }

        public Builder from_chat_id(Long r100) {
            this.mfrom_chat_id = r100;
            return this;
        }

        public Builder pick_entities(List<PickEntities> r100) {
            Internal.checkElementsNotNull(r100);
            this.mpick_entities = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_PullChangeGroupMemberAuthorizationRequest extends ProtoAdapter<PullChangeGroupMemberAuthorizationRequest> {
        public ProtoAdapter_PullChangeGroupMemberAuthorizationRequest() {
            super(FieldEncoding.LENGTH_DELIMITED, PullChangeGroupMemberAuthorizationRequest.class);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public PullChangeGroupMemberAuthorizationRequest decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            r101.mfrom_chat_id = 0L;
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L18;
            if (r103 != 1) goto L8;
            r101.mpick_entities.add(PickEntities.ADAPTER.decode(r100));
            goto L3
        L8:
            if (r103 != 2) goto L10;
            r101.mchat_mode = Chat.ChatMode.ADAPTER.decode(r100);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L15
        L15:
            e = move-exception;
            r101.addUnknownField(r103, FieldEncoding.VARINT, Long.valueOf(e.value));
            goto L3
        L10:
            if (r103 != 3) goto L11;
            r101.mfrom_chat_id = ProtoAdapter.INT64.decode(r100);
            goto L3
        L11:
            FieldEncoding r104 = r100.peekFieldEncoding();
            r101.addUnknownField(r103, r104, r104.rawProtoAdapter().decode(r100));
            goto L3
        L18:
            r100.endMessage(r102);
            return r101.build();
        }

        /* JADX INFO: renamed from: encodedSize, reason: avoid collision after fix types in other method */
        public int encodedSize2(PullChangeGroupMemberAuthorizationRequest r100) {
            int r101 = PickEntities.ADAPTER.asRepeated().encodedSizeWithTag(1, r100.mpick_entities);
            Chat.ChatMode r102 = r100.mchat_mode;
            int r103 = 0;
            if (r102 == null) goto L5;
            int r104 = Chat.ChatMode.ADAPTER.encodedSizeWithTag(2, r102);
        L6:
            int r105 = r101 + r104;
            Long r106 = r100.mfrom_chat_id;
            if (r106 == null) goto L10;
            r103 = ProtoAdapter.INT64.encodedSizeWithTag(3, r106);
        L10:
            return (r105 + r103) + r100.unknownFields().size();
        L5:
            r104 = 0;
            goto L6
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ PullChangeGroupMemberAuthorizationRequest decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(PullChangeGroupMemberAuthorizationRequest r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, PullChangeGroupMemberAuthorizationRequest r101) throws IOException {
            PickEntities.ADAPTER.asRepeated().encodeWithTag(r100, 1, r101.mpick_entities);
            Chat.ChatMode r102 = r101.mchat_mode;
            if (r102 == null) goto L5;
            Chat.ChatMode.ADAPTER.encodeWithTag(r100, 2, r102);
        L5:
            Long r103 = r101.mfrom_chat_id;
            if (r103 == null) goto L8;
            ProtoAdapter.INT64.encodeWithTag(r100, 3, r103);
        L8:
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, PullChangeGroupMemberAuthorizationRequest r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_PullChangeGroupMemberAuthorizationRequest();
        DEFAULT_FROM_CHAT_ID = 0L;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.mpick_entities = Internal.copyOf("mpick_entities", this.mpick_entities);
        r100.mchat_mode = this.mchat_mode;
        r100.mfrom_chat_id = this.mfrom_chat_id;
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return PullChangeGroupMemberAuthorizationRequest.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public PullChangeGroupMemberAuthorizationRequest(List<PickEntities> r100, Chat.ChatMode r101, Long r102) {
        this(r100, r101, r102, ByteString.EMPTY);
    }

    public PullChangeGroupMemberAuthorizationRequest(List<PickEntities> r100, Chat.ChatMode r101, Long r102, ByteString r103) {
        super(ADAPTER, r103);
        this.mpick_entities = Internal.immutableCopyOf("mpick_entities", r100);
        this.mchat_mode = r101;
        this.mfrom_chat_id = r102;
    }
}
