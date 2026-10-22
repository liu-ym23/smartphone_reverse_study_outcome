package com.bytedance.lark.pb.feed.v1;

import com.bytedance.lark.pb.basic.v1.FeedCard;
import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import com.squareup.wire.internal.Internal;
import java.io.IOException;
import okio.ByteString;

/* JADX INFO: loaded from: classes20.dex */
public final class CardPair extends Message<CardPair, Builder> {
    public static final ProtoAdapter<CardPair> ADAPTER = null;
    public static final String DEFAULT_ID = "";
    public static final FeedCard.EntityType DEFAULT_TYPE = null;
    private static final long serialVersionUID = 0;

    /* JADX INFO: renamed from: id, reason: collision with root package name */
    public final String f253621id;
    public final FeedCard.EntityType type;

    public static final class Builder extends Message.Builder<CardPair, Builder> {

        /* JADX INFO: renamed from: id, reason: collision with root package name */
        public String f253622id;
        public FeedCard.EntityType type;

        @Override // com.squareup.wire.Message.Builder
        public CardPair build() {
            String r100 = this.f253622id;
            if (r100 == null) goto L9;
            if (this.type == null) goto L9;
            return new CardPair(this.f253622id, this.type, super.buildUnknownFields());
        L9:
            throw Internal.missingRequiredFields(new Object[]{r100, "id", this.type, "type"});
        }

        public Builder() {
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder id(String r100) {
            this.f253622id = r100;
            return this;
        }

        public Builder type(FeedCard.EntityType r100) {
            this.type = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_CardPair extends ProtoAdapter<CardPair> {
        public ProtoAdapter_CardPair() {
            super(FieldEncoding.LENGTH_DELIMITED, CardPair.class);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public CardPair decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            r101.f253622id = "";
            r101.type = FeedCard.EntityType.UNKNOWN_ENTITY;
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L15;
            if (r103 != 1) goto L8;
            r101.f253622id = ProtoAdapter.STRING.decode(r100);
            goto L3
        L8:
            if (r103 != 2) goto L9;
            r101.type = FeedCard.EntityType.ADAPTER.decode(r100);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L12
        L12:
            e = move-exception;
            r101.addUnknownField(r103, FieldEncoding.VARINT, Long.valueOf(e.value));
            goto L3
        L9:
            FieldEncoding r104 = r100.peekFieldEncoding();
            r101.addUnknownField(r103, r104, r104.rawProtoAdapter().decode(r100));
            goto L3
        L15:
            r100.endMessage(r102);
            return r101.build();
        }

        /* JADX INFO: renamed from: encodedSize, reason: avoid collision after fix types in other method */
        public int encodedSize2(CardPair r100) {
            return (ProtoAdapter.STRING.encodedSizeWithTag(1, r100.f253621id) + FeedCard.EntityType.ADAPTER.encodedSizeWithTag(2, r100.type)) + r100.unknownFields().size();
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ CardPair decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(CardPair r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, CardPair r101) throws IOException {
            ProtoAdapter.STRING.encodeWithTag(r100, 1, r101.f253621id);
            FeedCard.EntityType.ADAPTER.encodeWithTag(r100, 2, r101.type);
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, CardPair r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_CardPair();
        DEFAULT_TYPE = FeedCard.EntityType.UNKNOWN_ENTITY;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.f253622id = this.f253621id;
        r100.type = this.type;
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return CardPair.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public CardPair(String r100, FeedCard.EntityType r101) {
        this(r100, r101, ByteString.EMPTY);
    }

    public CardPair(String r100, FeedCard.EntityType r101, ByteString r102) {
        super(ADAPTER, r102);
        this.f253621id = r100;
        this.type = r101;
    }
}
