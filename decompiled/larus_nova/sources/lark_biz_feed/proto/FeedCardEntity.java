package lark_biz_feed.proto;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import com.squareup.wire.internal.Internal;
import java.io.IOException;
import okio.ByteString;

/* JADX INFO: loaded from: classes42.dex */
public final class FeedCardEntity extends Message<FeedCardEntity, Builder> {
    public static final ProtoAdapter<FeedCardEntity> ADAPTER = null;
    public static final String DEFAULT_FEED_ID = "";
    public static final FeedCardType DEFAULT_FEED_TYPE = null;
    private static final long serialVersionUID = 0;
    public final String feed_id;
    public final FeedCardType feed_type;

    public static final class Builder extends Message.Builder<FeedCardEntity, Builder> {
        public String feed_id;
        public FeedCardType feed_type;

        @Override // com.squareup.wire.Message.Builder
        public FeedCardEntity build() {
            String r100 = this.feed_id;
            if (r100 == null) goto L9;
            if (this.feed_type == null) goto L9;
            return new FeedCardEntity(this.feed_id, this.feed_type, super.buildUnknownFields());
        L9:
            throw Internal.missingRequiredFields(new Object[]{r100, "feed_id", this.feed_type, "feed_type"});
        }

        public Builder() {
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder feed_id(String r100) {
            this.feed_id = r100;
            return this;
        }

        public Builder feed_type(FeedCardType r100) {
            this.feed_type = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_FeedCardEntity extends ProtoAdapter<FeedCardEntity> {
        public ProtoAdapter_FeedCardEntity() {
            super(FieldEncoding.LENGTH_DELIMITED, FeedCardEntity.class);
        }

        @Override // com.squareup.wire.ProtoAdapter
        /* JADX INFO: renamed from: decode, reason: avoid collision after fix types in other method */
        public FeedCardEntity decode2(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L15;
            if (r103 != 1) goto L8;
            r101.feed_id = ProtoAdapter.STRING.decode(r100);
            goto L3
        L8:
            if (r103 != 2) goto L9;
            r101.feed_type = FeedCardType.ADAPTER.decode(r100);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L12
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
        public int encodedSize2(FeedCardEntity r100) {
            return (ProtoAdapter.STRING.encodedSizeWithTag(1, r100.feed_id) + FeedCardType.ADAPTER.encodedSizeWithTag(2, r100.feed_type)) + r100.unknownFields().size();
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ FeedCardEntity decode(ProtoReader r100) throws IOException {
            return decode2(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(FeedCardEntity r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, FeedCardEntity r101) throws IOException {
            ProtoAdapter.STRING.encodeWithTag(r100, 1, r101.feed_id);
            FeedCardType.ADAPTER.encodeWithTag(r100, 2, r101.feed_type);
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, FeedCardEntity r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_FeedCardEntity();
        DEFAULT_FEED_TYPE = FeedCardType.VAR_FEED_CARD_TYPE_UNKNOWN_TYPE;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.feed_id = this.feed_id;
        r100.feed_type = this.feed_type;
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return FeedCardEntity.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public FeedCardEntity(String r100, FeedCardType r101) {
        this(r100, r101, ByteString.EMPTY);
    }

    public FeedCardEntity(String r100, FeedCardType r101, ByteString r102) {
        super(ADAPTER, r102);
        this.feed_id = r100;
        this.feed_type = r101;
    }
}
