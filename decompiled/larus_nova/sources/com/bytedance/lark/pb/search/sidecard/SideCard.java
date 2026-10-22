package com.bytedance.lark.pb.search.sidecard;

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
public final class SideCard extends Message<SideCard, Builder> {
    public static final ProtoAdapter<SideCard> ADAPTER = null;
    private static final long serialVersionUID = 0;
    public final List<EntityCard> entity_cards;

    public static final class Builder extends Message.Builder<SideCard, Builder> {
        public List<EntityCard> entity_cards;

        @Override // com.squareup.wire.Message.Builder
        public SideCard build() {
            return new SideCard(this.entity_cards, super.buildUnknownFields());
        }

        public Builder() {
            this.entity_cards = Internal.newMutableList();
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder entity_cards(List<EntityCard> r100) {
            Internal.checkElementsNotNull(r100);
            this.entity_cards = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_SideCard extends ProtoAdapter<SideCard> {
        public ProtoAdapter_SideCard() {
            super(FieldEncoding.LENGTH_DELIMITED, SideCard.class);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public SideCard decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L9;
            if (r103 != 1) goto L7;
            r101.entity_cards.add(EntityCard.ADAPTER.decode(r100));
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
        public int encodedSize2(SideCard r100) {
            return EntityCard.ADAPTER.asRepeated().encodedSizeWithTag(1, r100.entity_cards) + r100.unknownFields().size();
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ SideCard decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(SideCard r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, SideCard r101) throws IOException {
            EntityCard.ADAPTER.asRepeated().encodeWithTag(r100, 1, r101.entity_cards);
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, SideCard r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_SideCard();
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.entity_cards = Internal.copyOf("entity_cards", this.entity_cards);
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return SideCard.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public SideCard(List<EntityCard> r100) {
        this(r100, ByteString.EMPTY);
    }

    public SideCard(List<EntityCard> r100, ByteString r101) {
        super(ADAPTER, r101);
        this.entity_cards = Internal.immutableCopyOf("entity_cards", r100);
    }
}
