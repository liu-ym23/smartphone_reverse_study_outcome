package com.bytedance.lark.pb.search.sidecard;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import com.squareup.wire.internal.Internal;
import java.io.IOException;
import okio.ByteString;

/* JADX INFO: loaded from: classes20.dex */
public final class EntityCard extends Message<EntityCard, Builder> {
    public static final ProtoAdapter<EntityCard> ADAPTER = null;
    public static final CardType DEFAULT_CARDTYPE = null;
    public static final String DEFAULT_ID = "";
    public static final SourceType DEFAULT_SOURCETYPE = null;
    private static final long serialVersionUID = 0;
    public final CardType cardType;

    /* JADX INFO: renamed from: id, reason: collision with root package name */
    public final String f253681id;
    public final SourceType sourceType;

    public static final class Builder extends Message.Builder<EntityCard, Builder> {
        public CardType cardType;

        /* JADX INFO: renamed from: id, reason: collision with root package name */
        public String f253682id;
        public SourceType sourceType;

        @Override // com.squareup.wire.Message.Builder
        public EntityCard build() {
            String r100 = this.f253682id;
            if (r100 == null) goto L7;
            return new EntityCard(this.f253682id, this.sourceType, this.cardType, super.buildUnknownFields());
        L7:
            throw Internal.missingRequiredFields(new Object[]{r100, "id"});
        }

        public Builder() {
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder cardType(CardType r100) {
            this.cardType = r100;
            return this;
        }

        public Builder id(String r100) {
            this.f253682id = r100;
            return this;
        }

        public Builder sourceType(SourceType r100) {
            this.sourceType = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_EntityCard extends ProtoAdapter<EntityCard> {
        public ProtoAdapter_EntityCard() {
            super(FieldEncoding.LENGTH_DELIMITED, EntityCard.class);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public EntityCard decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            r101.f253682id = "";
            r101.sourceType = SourceType.Exact;
            r101.cardType = CardType.UNKNOWN;
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L21;
            if (r103 != 1) goto L8;
            r101.f253682id = ProtoAdapter.STRING.decode(r100);
            goto L3
        L8:
            if (r103 != 2) goto L10;
            r101.sourceType = SourceType.ADAPTER.decode(r100);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L18
        L18:
            e = move-exception;
            r101.addUnknownField(r103, FieldEncoding.VARINT, Long.valueOf(e.value));
            goto L3
        L10:
            if (r103 != 3) goto L11;
            r101.cardType = CardType.ADAPTER.decode(r100);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L14
        L14:
            e = move-exception;
            r101.addUnknownField(r103, FieldEncoding.VARINT, Long.valueOf(e.value));
            goto L3
        L11:
            FieldEncoding r104 = r100.peekFieldEncoding();
            r101.addUnknownField(r103, r104, r104.rawProtoAdapter().decode(r100));
            goto L3
        L21:
            r100.endMessage(r102);
            return r101.build();
        }

        /* JADX INFO: renamed from: encodedSize, reason: avoid collision after fix types in other method */
        public int encodedSize2(EntityCard r100) {
            int r101 = ProtoAdapter.STRING.encodedSizeWithTag(1, r100.f253681id);
            SourceType r102 = r100.sourceType;
            int r103 = 0;
            if (r102 == null) goto L5;
            int r104 = SourceType.ADAPTER.encodedSizeWithTag(2, r102);
        L6:
            int r105 = r101 + r104;
            CardType r106 = r100.cardType;
            if (r106 == null) goto L10;
            r103 = CardType.ADAPTER.encodedSizeWithTag(3, r106);
        L10:
            return (r105 + r103) + r100.unknownFields().size();
        L5:
            r104 = 0;
            goto L6
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ EntityCard decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(EntityCard r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, EntityCard r101) throws IOException {
            ProtoAdapter.STRING.encodeWithTag(r100, 1, r101.f253681id);
            SourceType r102 = r101.sourceType;
            if (r102 == null) goto L5;
            SourceType.ADAPTER.encodeWithTag(r100, 2, r102);
        L5:
            CardType r103 = r101.cardType;
            if (r103 == null) goto L8;
            CardType.ADAPTER.encodeWithTag(r100, 3, r103);
        L8:
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, EntityCard r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_EntityCard();
        DEFAULT_SOURCETYPE = SourceType.Exact;
        DEFAULT_CARDTYPE = CardType.UNKNOWN;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.f253682id = this.f253681id;
        r100.sourceType = this.sourceType;
        r100.cardType = this.cardType;
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return EntityCard.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public EntityCard(String r100, SourceType r101, CardType r102) {
        this(r100, r101, r102, ByteString.EMPTY);
    }

    public EntityCard(String r100, SourceType r101, CardType r102, ByteString r103) {
        super(ADAPTER, r103);
        this.f253681id = r100;
        this.sourceType = r101;
        this.cardType = r102;
    }
}
