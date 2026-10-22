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
public final class ChannelEntity extends Message<ChannelEntity, Builder> {
    public static final ProtoAdapter<ChannelEntity> ADAPTER = null;
    public static final String DEFAULT_CHANNEL_ID = "";
    public static final FeedCardType DEFAULT_FEED_TYPE = null;
    private static final long serialVersionUID = 0;
    public final String channel_id;
    public final FeedCardType feed_type;

    public static final class Builder extends Message.Builder<ChannelEntity, Builder> {
        public String channel_id;
        public FeedCardType feed_type;

        @Override // com.squareup.wire.Message.Builder
        public ChannelEntity build() {
            String r100 = this.channel_id;
            if (r100 == null) goto L7;
            return new ChannelEntity(this.channel_id, this.feed_type, super.buildUnknownFields());
        L7:
            throw Internal.missingRequiredFields(new Object[]{r100, "channel_id"});
        }

        public Builder() {
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder channel_id(String r100) {
            this.channel_id = r100;
            return this;
        }

        public Builder feed_type(FeedCardType r100) {
            this.feed_type = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_ChannelEntity extends ProtoAdapter<ChannelEntity> {
        public ProtoAdapter_ChannelEntity() {
            super(FieldEncoding.LENGTH_DELIMITED, ChannelEntity.class);
        }

        @Override // com.squareup.wire.ProtoAdapter
        /* JADX INFO: renamed from: decode, reason: avoid collision after fix types in other method */
        public ChannelEntity decode2(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L15;
            if (r103 != 1) goto L8;
            r101.channel_id = ProtoAdapter.STRING.decode(r100);
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
        public int encodedSize2(ChannelEntity r100) {
            int r101 = ProtoAdapter.STRING.encodedSizeWithTag(1, r100.channel_id);
            FeedCardType r102 = r100.feed_type;
            if (r102 == null) goto L5;
            int r103 = FeedCardType.ADAPTER.encodedSizeWithTag(2, r102);
        L7:
            return (r101 + r103) + r100.unknownFields().size();
        L5:
            r103 = 0;
            goto L7
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ ChannelEntity decode(ProtoReader r100) throws IOException {
            return decode2(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(ChannelEntity r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, ChannelEntity r101) throws IOException {
            ProtoAdapter.STRING.encodeWithTag(r100, 1, r101.channel_id);
            FeedCardType r102 = r101.feed_type;
            if (r102 == null) goto L5;
            FeedCardType.ADAPTER.encodeWithTag(r100, 2, r102);
        L5:
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, ChannelEntity r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_ChannelEntity();
        DEFAULT_FEED_TYPE = FeedCardType.VAR_FEED_CARD_TYPE_UNKNOWN_TYPE;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.channel_id = this.channel_id;
        r100.feed_type = this.feed_type;
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return ChannelEntity.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public ChannelEntity(String r100, FeedCardType r101) {
        this(r100, r101, ByteString.EMPTY);
    }

    public ChannelEntity(String r100, FeedCardType r101, ByteString r102) {
        super(ADAPTER, r102);
        this.channel_id = r100;
        this.feed_type = r101;
    }
}
