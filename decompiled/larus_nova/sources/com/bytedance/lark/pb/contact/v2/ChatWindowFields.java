package com.bytedance.lark.pb.contact.v2;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import com.squareup.wire.internal.Internal;
import java.io.IOException;
import java.util.List;
import okio.ByteString;

/* JADX INFO: loaded from: classes20.dex */
public final class ChatWindowFields extends Message<ChatWindowFields, Builder> {
    public static final ProtoAdapter<ChatWindowFields> ADAPTER = null;
    private static final long serialVersionUID = 0;
    public final List<GetUserProfileResponse.Field> field_orders;

    public static final class Builder extends Message.Builder<ChatWindowFields, Builder> {
        public List<GetUserProfileResponse.Field> field_orders;

        @Override // com.squareup.wire.Message.Builder
        public ChatWindowFields build() {
            return new ChatWindowFields(this.field_orders, super.buildUnknownFields());
        }

        public Builder() {
            this.field_orders = Internal.newMutableList();
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder field_orders(List<GetUserProfileResponse.Field> r100) {
            Internal.checkElementsNotNull(r100);
            this.field_orders = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_ChatWindowFields extends ProtoAdapter<ChatWindowFields> {
        public ProtoAdapter_ChatWindowFields() {
            super(FieldEncoding.LENGTH_DELIMITED, ChatWindowFields.class);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public ChatWindowFields decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L9;
            if (r103 != 1) goto L7;
            r101.field_orders.add(GetUserProfileResponse.Field.ADAPTER.decode(r100));
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
        public int encodedSize2(ChatWindowFields r100) {
            return GetUserProfileResponse.Field.ADAPTER.asRepeated().encodedSizeWithTag(1, r100.field_orders) + r100.unknownFields().size();
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ ChatWindowFields decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(ChatWindowFields r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, ChatWindowFields r101) throws IOException {
            GetUserProfileResponse.Field.ADAPTER.asRepeated().encodeWithTag(r100, 1, r101.field_orders);
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, ChatWindowFields r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_ChatWindowFields();
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.field_orders = Internal.copyOf("field_orders", this.field_orders);
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return ChatWindowFields.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public ChatWindowFields(List<GetUserProfileResponse.Field> r100) {
        this(r100, ByteString.EMPTY);
    }

    public ChatWindowFields(List<GetUserProfileResponse.Field> r100, ByteString r101) {
        super(ADAPTER, r101);
        this.field_orders = Internal.immutableCopyOf("field_orders", r100);
    }
}
