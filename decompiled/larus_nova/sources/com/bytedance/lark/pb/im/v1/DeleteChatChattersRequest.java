package com.bytedance.lark.pb.im.v1;

import com.bytedance.lark.pb.basic.v1.PickEntities;
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
public final class DeleteChatChattersRequest extends Message<DeleteChatChattersRequest, Builder> {
    public static final ProtoAdapter<DeleteChatChattersRequest> ADAPTER = null;
    public static final String DEFAULT_CHAT_ID = "";
    public static final String DEFAULT_NEW_OWNER_ID = "";
    public static final ProtoAdapter_DeleteChatChattersRequest RAW_TYPE_ADAPTER = null;
    private static final long serialVersionUID = 0;
    public final String chat_id;
    public final List<String> chatter_ids;
    public final String new_owner_id;
    public final DeleteChatChatterOption option;
    public final List<PickEntities> pick_entities;

    public static final class Builder extends Message.Builder<DeleteChatChattersRequest, Builder> implements d<DeleteChatChattersRequest> {
        public String chat_id;
        public List<String> chatter_ids;
        public String new_owner_id;
        public DeleteChatChatterOption option;
        public List<PickEntities> pick_entities;

        @Override // com.squareup.wire.Message.Builder
        public DeleteChatChattersRequest build() {
            String r100 = this.chat_id;
            if (r100 == null) goto L7;
            return new DeleteChatChattersRequest(this.chat_id, this.chatter_ids, this.new_owner_id, this.option, this.pick_entities, super.buildUnknownFields());
        L7:
            throw Internal.missingRequiredFields(new Object[]{r100, "chat_id"});
        }

        public Builder() {
            this.chatter_ids = Internal.newMutableList();
            this.pick_entities = Internal.newMutableList();
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

        public Builder new_owner_id(String r100) {
            this.new_owner_id = r100;
            return this;
        }

        public Builder option(DeleteChatChatterOption r100) {
            this.option = r100;
            return this;
        }

        public Builder pick_entities(List<PickEntities> r100) {
            Internal.checkElementsNotNull(r100);
            this.pick_entities = r100;
            return this;
        }
    }

    public static final class DeleteChatChatterOption extends Message<DeleteChatChatterOption, Builder> {
        public static final ProtoAdapter<DeleteChatChatterOption> ADAPTER = null;
        public static final Boolean DEFAULT_WITHDRAW = null;
        private static final long serialVersionUID = 0;
        public final Boolean withdraw;

        public static final class Builder extends Message.Builder<DeleteChatChatterOption, Builder> {
            public Boolean withdraw;

            @Override // com.squareup.wire.Message.Builder
            public DeleteChatChatterOption build() {
                return new DeleteChatChatterOption(this.withdraw, super.buildUnknownFields());
            }

            public Builder() {
            }

            @Override // com.squareup.wire.Message.Builder
            public /* bridge */ /* synthetic */ Message build() {
                return build();
            }

            public Builder withdraw(Boolean r100) {
                this.withdraw = r100;
                return this;
            }
        }

        public static final class ProtoAdapter_DeleteChatChatterOption extends ProtoAdapter<DeleteChatChatterOption> {
            public ProtoAdapter_DeleteChatChatterOption() {
                super(FieldEncoding.LENGTH_DELIMITED, DeleteChatChatterOption.class);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.squareup.wire.ProtoAdapter
            public DeleteChatChatterOption decode(ProtoReader r100) throws IOException {
                Builder r101 = new Builder();
                r101.withdraw = Boolean.FALSE;
                long r102 = r100.beginMessage();
            L3:
                int r103 = r100.nextTag();
                if (r103 == (-1)) goto L9;
                if (r103 != 1) goto L7;
                r101.withdraw = ProtoAdapter.BOOL.decode(r100);
                goto L3
            L7:
                FieldEncoding r104 = r100.peekFieldEncoding();
                r101.addUnknownField(r103, r104, r104.rawProtoAdapter().decode(r100));
                goto L3
            L9:
                r100.endMessage(r102);
                return r101.build();
            }

            /* JADX INFO: renamed from: encodedSize, reason: avoid collision after fix types in other method */
            public int encodedSize2(DeleteChatChatterOption r100) {
                Boolean r101 = r100.withdraw;
                if (r101 == null) goto L5;
                int r102 = ProtoAdapter.BOOL.encodedSizeWithTag(1, r101);
            L7:
                return r102 + r100.unknownFields().size();
            L5:
                r102 = 0;
                goto L7
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ DeleteChatChatterOption decode(ProtoReader r100) throws IOException {
                return decode(r100);
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ int encodedSize(DeleteChatChatterOption r100) {
                return encodedSize2(r100);
            }

            /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
            public void encode2(ProtoWriter r100, DeleteChatChatterOption r101) throws IOException {
                Boolean r102 = r101.withdraw;
                if (r102 == null) goto L5;
                ProtoAdapter.BOOL.encodeWithTag(r100, 1, r102);
            L5:
                r100.writeBytes(r101.unknownFields());
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, DeleteChatChatterOption r101) throws IOException {
                encode2(r100, r101);
            }
        }

        static {
            ADAPTER = new ProtoAdapter_DeleteChatChatterOption();
            DEFAULT_WITHDRAW = Boolean.FALSE;
        }

        @Override // com.squareup.wire.Message
        public Builder newBuilder() {
            Builder r100 = new Builder();
            r100.withdraw = this.withdraw;
            r100.addUnknownFields(unknownFields());
            return r100;
        }

        @Override // com.squareup.wire.Message
        public String toString() {
            return DeleteChatChatterOption.class.getName() + "@" + Integer.toHexString(hashCode());
        }

        @Override // com.squareup.wire.Message
        public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
            return newBuilder();
        }

        public DeleteChatChatterOption(Boolean r100) {
            this(r100, ByteString.EMPTY);
        }

        public DeleteChatChatterOption(Boolean r100, ByteString r101) {
            super(ADAPTER, r101);
            this.withdraw = r100;
        }
    }

    public static final class ProtoAdapter_DeleteChatChattersRequest extends ProtoAdapter<DeleteChatChattersRequest> implements c<DeleteChatChattersRequest> {
        public ProtoAdapter_DeleteChatChattersRequest() {
            super(FieldEncoding.LENGTH_DELIMITED, DeleteChatChattersRequest.class);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public DeleteChatChattersRequest decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            r101.chat_id = "";
            r101.new_owner_id = "";
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L21;
            if (r103 != 1) goto L8;
            r101.chat_id = ProtoAdapter.STRING.decode(r100);
            goto L3
        L8:
            if (r103 != 2) goto L10;
            r101.chatter_ids.add(ProtoAdapter.STRING.decode(r100));
            goto L3
        L10:
            if (r103 != 3) goto L12;
            r101.new_owner_id = ProtoAdapter.STRING.decode(r100);
            goto L3
        L12:
            if (r103 != 4) goto L14;
            r101.option = DeleteChatChatterOption.ADAPTER.decode(r100);
            goto L3
        L14:
            if (r103 != 5) goto L15;
            r101.pick_entities.add(PickEntities.ADAPTER.decode(r100));
            goto L3
        L15:
            FieldEncoding r104 = r100.peekFieldEncoding();
            r101.addUnknownField(r103, r104, r104.rawProtoAdapter().decode(r100));
            goto L3
        L21:
            r100.endMessage(r102);
            return r101.build();
        }

        /* JADX INFO: renamed from: encodedSize, reason: avoid collision after fix types in other method */
        public int encodedSize2(DeleteChatChattersRequest r100) {
            ProtoAdapter<String> r101 = ProtoAdapter.STRING;
            int r102 = r101.encodedSizeWithTag(1, r100.chat_id) + r101.asRepeated().encodedSizeWithTag(2, r100.chatter_ids);
            String r103 = r100.new_owner_id;
            int r104 = 0;
            if (r103 == null) goto L5;
            int r105 = r101.encodedSizeWithTag(3, r103);
        L6:
            int r106 = r102 + r105;
            DeleteChatChatterOption r107 = r100.option;
            if (r107 == null) goto L10;
            r104 = DeleteChatChatterOption.ADAPTER.encodedSizeWithTag(4, r107);
        L10:
            return ((r106 + r104) + PickEntities.ADAPTER.asRepeated().encodedSizeWithTag(5, r100.pick_entities)) + r100.unknownFields().size();
        L5:
            r105 = 0;
            goto L6
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ DeleteChatChattersRequest decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(DeleteChatChattersRequest r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, DeleteChatChattersRequest r101) throws IOException {
            ProtoAdapter<String> r102 = ProtoAdapter.STRING;
            r102.encodeWithTag(r100, 1, r101.chat_id);
            r102.asRepeated().encodeWithTag(r100, 2, r101.chatter_ids);
            String r103 = r101.new_owner_id;
            if (r103 == null) goto L5;
            r102.encodeWithTag(r100, 3, r103);
        L5:
            DeleteChatChatterOption r104 = r101.option;
            if (r104 == null) goto L8;
            DeleteChatChatterOption.ADAPTER.encodeWithTag(r100, 4, r104);
        L8:
            PickEntities.ADAPTER.asRepeated().encodeWithTag(r100, 5, r101.pick_entities);
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, DeleteChatChattersRequest r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ProtoAdapter_DeleteChatChattersRequest r100 = new ProtoAdapter_DeleteChatChattersRequest();
        RAW_TYPE_ADAPTER = r100;
        ADAPTER = r100;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.chat_id = this.chat_id;
        r100.chatter_ids = Internal.copyOf("chatter_ids", this.chatter_ids);
        r100.new_owner_id = this.new_owner_id;
        r100.option = this.option;
        r100.pick_entities = Internal.copyOf("pick_entities", this.pick_entities);
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return DeleteChatChattersRequest.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public DeleteChatChattersRequest(String r100, List<String> r101, String r110, DeleteChatChatterOption r111, List<PickEntities> r112) {
        this(r100, r101, r110, r111, r112, ByteString.EMPTY);
    }

    public DeleteChatChattersRequest(String r100, List<String> r101, String r102, DeleteChatChatterOption r103, List<PickEntities> r104, ByteString r105) {
        super(ADAPTER, r105);
        this.chat_id = r100;
        this.chatter_ids = Internal.immutableCopyOf("chatter_ids", r101);
        this.new_owner_id = r102;
        this.option = r103;
        this.pick_entities = Internal.immutableCopyOf("pick_entities", r104);
    }
}
