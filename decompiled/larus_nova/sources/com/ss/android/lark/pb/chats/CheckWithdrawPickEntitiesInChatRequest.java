package com.ss.android.lark.pb.chats;

import com.google.protobuf.server.FieldOptions;
import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import com.squareup.wire.internal.Internal;
import java.io.IOException;
import java.util.List;
import okio.ByteString;

/* JADX INFO: loaded from: classes37.dex */
public final class CheckWithdrawPickEntitiesInChatRequest extends Message<CheckWithdrawPickEntitiesInChatRequest, Builder> {
    public static final ProtoAdapter<CheckWithdrawPickEntitiesInChatRequest> ADAPTER = null;
    public static final String DEFAULT_CHAT_ID = "";
    public static final FieldOptions FIELD_OPTIONS_MCHAT_ID = null;
    private static final long serialVersionUID = 0;
    public final String mchat_id;
    public final List<PickEntities> mpick_entities;

    public static final class Builder extends Message.Builder<CheckWithdrawPickEntitiesInChatRequest, Builder> {
        public String mchat_id;
        public List<PickEntities> mpick_entities;

        @Override // com.squareup.wire.Message.Builder
        public CheckWithdrawPickEntitiesInChatRequest build() {
            String r100 = this.mchat_id;
            if (r100 == null) goto L7;
            return new CheckWithdrawPickEntitiesInChatRequest(this.mchat_id, this.mpick_entities, super.buildUnknownFields());
        L7:
            throw Internal.missingRequiredFields(new Object[]{r100, "mchat_id"});
        }

        public Builder() {
            this.mpick_entities = Internal.newMutableList();
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder chat_id(String r100) {
            this.mchat_id = r100;
            return this;
        }

        public Builder pick_entities(List<PickEntities> r100) {
            Internal.checkElementsNotNull(r100);
            this.mpick_entities = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_CheckWithdrawPickEntitiesInChatRequest extends ProtoAdapter<CheckWithdrawPickEntitiesInChatRequest> {
        public ProtoAdapter_CheckWithdrawPickEntitiesInChatRequest() {
            super(FieldEncoding.LENGTH_DELIMITED, CheckWithdrawPickEntitiesInChatRequest.class);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public CheckWithdrawPickEntitiesInChatRequest decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            r101.mchat_id = "";
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L12;
            if (r103 != 1) goto L8;
            r101.mchat_id = ProtoAdapter.STRING.decode(r100);
            goto L3
        L8:
            if (r103 != 2) goto L9;
            r101.mpick_entities.add(PickEntities.ADAPTER.decode(r100));
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
        public int encodedSize2(CheckWithdrawPickEntitiesInChatRequest r100) {
            return (ProtoAdapter.STRING.encodedSizeWithTag(1, r100.mchat_id) + PickEntities.ADAPTER.asRepeated().encodedSizeWithTag(2, r100.mpick_entities)) + r100.unknownFields().size();
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ CheckWithdrawPickEntitiesInChatRequest decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(CheckWithdrawPickEntitiesInChatRequest r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, CheckWithdrawPickEntitiesInChatRequest r101) throws IOException {
            ProtoAdapter.STRING.encodeWithTag(r100, 1, r101.mchat_id);
            PickEntities.ADAPTER.asRepeated().encodeWithTag(r100, 2, r101.mpick_entities);
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, CheckWithdrawPickEntitiesInChatRequest r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_CheckWithdrawPickEntitiesInChatRequest();
        FIELD_OPTIONS_MCHAT_ID = new FieldOptions.Builder().FieldInfo("split,type=channel").build();
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.mchat_id = this.mchat_id;
        r100.mpick_entities = Internal.copyOf("mpick_entities", this.mpick_entities);
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return CheckWithdrawPickEntitiesInChatRequest.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public CheckWithdrawPickEntitiesInChatRequest(String r100, List<PickEntities> r101) {
        this(r100, r101, ByteString.EMPTY);
    }

    public CheckWithdrawPickEntitiesInChatRequest(String r100, List<PickEntities> r101, ByteString r102) {
        super(ADAPTER, r102);
        this.mchat_id = r100;
        this.mpick_entities = Internal.immutableCopyOf("mpick_entities", r101);
    }
}
